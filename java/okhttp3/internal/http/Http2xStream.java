/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.net.ProtocolException
 *  java.util.ArrayList
 *  java.util.LinkedHashSet
 *  java.util.List
 *  java.util.Locale
 *  java.util.concurrent.TimeUnit
 */
package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.framed.ErrorCode;
import okhttp3.internal.framed.FramedConnection;
import okhttp3.internal.framed.FramedStream;
import okhttp3.internal.framed.Header;
import okhttp3.internal.http.HttpEngine;
import okhttp3.internal.http.HttpStream;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.RetryableSink;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.http.StreamAllocation;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class Http2xStream
implements HttpStream {
    private static final ByteString CONNECTION = ByteString.encodeUtf8("connection");
    private static final ByteString ENCODING;
    private static final ByteString HOST;
    private static final List<ByteString> HTTP_2_SKIPPED_REQUEST_HEADERS;
    private static final List<ByteString> HTTP_2_SKIPPED_RESPONSE_HEADERS;
    private static final ByteString KEEP_ALIVE;
    private static final ByteString PROXY_CONNECTION;
    private static final List<ByteString> SPDY_3_SKIPPED_REQUEST_HEADERS;
    private static final List<ByteString> SPDY_3_SKIPPED_RESPONSE_HEADERS;
    private static final ByteString TE;
    private static final ByteString TRANSFER_ENCODING;
    private static final ByteString UPGRADE;
    private final FramedConnection framedConnection;
    private HttpEngine httpEngine;
    private FramedStream stream;
    private final StreamAllocation streamAllocation;

    static {
        HOST = ByteString.encodeUtf8("host");
        KEEP_ALIVE = ByteString.encodeUtf8("keep-alive");
        PROXY_CONNECTION = ByteString.encodeUtf8("proxy-connection");
        TRANSFER_ENCODING = ByteString.encodeUtf8("transfer-encoding");
        TE = ByteString.encodeUtf8("te");
        ENCODING = ByteString.encodeUtf8("encoding");
        UPGRADE = ByteString.encodeUtf8("upgrade");
        ByteString[] arrbyteString = new ByteString[]{CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TRANSFER_ENCODING, Header.TARGET_METHOD, Header.TARGET_PATH, Header.TARGET_SCHEME, Header.TARGET_AUTHORITY, Header.TARGET_HOST, Header.VERSION};
        SPDY_3_SKIPPED_REQUEST_HEADERS = Util.immutableList(arrbyteString);
        ByteString[] arrbyteString2 = new ByteString[]{CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TRANSFER_ENCODING};
        SPDY_3_SKIPPED_RESPONSE_HEADERS = Util.immutableList(arrbyteString2);
        ByteString[] arrbyteString3 = new ByteString[]{CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE, Header.TARGET_METHOD, Header.TARGET_PATH, Header.TARGET_SCHEME, Header.TARGET_AUTHORITY, Header.TARGET_HOST, Header.VERSION};
        HTTP_2_SKIPPED_REQUEST_HEADERS = Util.immutableList(arrbyteString3);
        ByteString[] arrbyteString4 = new ByteString[]{CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE};
        HTTP_2_SKIPPED_RESPONSE_HEADERS = Util.immutableList(arrbyteString4);
    }

    public Http2xStream(StreamAllocation streamAllocation, FramedConnection framedConnection) {
        this.streamAllocation = streamAllocation;
        this.framedConnection = framedConnection;
    }

    public static List<Header> http2HeadersList(Request request) {
        Headers headers = request.headers();
        ArrayList arrayList = new ArrayList(4 + headers.size());
        arrayList.add((Object)new Header(Header.TARGET_METHOD, request.method()));
        arrayList.add((Object)new Header(Header.TARGET_PATH, RequestLine.requestPath(request.url())));
        arrayList.add((Object)new Header(Header.TARGET_AUTHORITY, Util.hostHeader(request.url(), false)));
        arrayList.add((Object)new Header(Header.TARGET_SCHEME, request.url().scheme()));
        int n2 = headers.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            ByteString byteString = ByteString.encodeUtf8(headers.name(i2).toLowerCase(Locale.US));
            if (HTTP_2_SKIPPED_REQUEST_HEADERS.contains((Object)byteString)) continue;
            arrayList.add((Object)new Header(byteString, headers.value(i2)));
        }
        return arrayList;
    }

    private static String joinOnNull(String string2, String string3) {
        return string2 + '\u0000' + string3;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static Response.Builder readHttp2HeadersList(List<Header> list) throws IOException {
        String string2 = null;
        Headers.Builder builder = new Headers.Builder();
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            ByteString byteString = ((Header)list.get((int)i2)).name;
            String string3 = ((Header)list.get((int)i2)).value.utf8();
            if (byteString.equals(Header.RESPONSE_STATUS)) {
                string2 = string3;
                continue;
            }
            if (HTTP_2_SKIPPED_RESPONSE_HEADERS.contains((Object)byteString)) continue;
            builder.add(byteString.utf8(), string3);
        }
        if (string2 == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        StatusLine statusLine = StatusLine.parse("HTTP/1.1 " + string2);
        return new Response.Builder().protocol(Protocol.HTTP_2).code(statusLine.code).message(statusLine.message).headers(builder.build());
    }

    /*
     * Enabled aggressive block sorting
     */
    public static Response.Builder readSpdy3HeadersList(List<Header> list) throws IOException {
        String string2 = null;
        String string3 = "HTTP/1.1";
        Headers.Builder builder = new Headers.Builder();
        int n2 = 0;
        int n3 = list.size();
        do {
            String string4;
            ByteString byteString;
            int n4;
            if (n2 < n3) {
                byteString = ((Header)list.get((int)n2)).name;
                string4 = ((Header)list.get((int)n2)).value.utf8();
                n4 = 0;
            } else {
                if (string2 == null) {
                    throw new ProtocolException("Expected ':status' header not present");
                }
                StatusLine statusLine = StatusLine.parse(string3 + " " + string2);
                return new Response.Builder().protocol(Protocol.SPDY_3).code(statusLine.code).message(statusLine.message).headers(builder.build());
            }
            while (n4 < string4.length()) {
                int n5 = string4.indexOf(0, n4);
                if (n5 == -1) {
                    n5 = string4.length();
                }
                String string5 = string4.substring(n4, n5);
                if (byteString.equals(Header.RESPONSE_STATUS)) {
                    string2 = string5;
                } else if (byteString.equals(Header.VERSION)) {
                    string3 = string5;
                } else if (!SPDY_3_SKIPPED_RESPONSE_HEADERS.contains((Object)byteString)) {
                    builder.add(byteString.utf8(), string5);
                }
                n4 = n5 + 1;
            }
            ++n2;
        } while (true);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static List<Header> spdy3HeadersList(Request var0) {
        var1_1 = var0.headers();
        var2_2 = new ArrayList(5 + var1_1.size());
        var2_2.add((Object)new Header(Header.TARGET_METHOD, var0.method()));
        var2_2.add((Object)new Header(Header.TARGET_PATH, RequestLine.requestPath(var0.url())));
        var2_2.add((Object)new Header(Header.VERSION, "HTTP/1.1"));
        var2_2.add((Object)new Header(Header.TARGET_HOST, Util.hostHeader(var0.url(), false)));
        var2_2.add((Object)new Header(Header.TARGET_SCHEME, var0.url().scheme()));
        var8_3 = new LinkedHashSet();
        var9_4 = 0;
        var10_5 = var1_1.size();
        block0 : do {
            if (var9_4 >= var10_5) return var2_2;
            var11_6 = ByteString.encodeUtf8(var1_1.name(var9_4).toLowerCase(Locale.US));
            if (Http2xStream.SPDY_3_SKIPPED_REQUEST_HEADERS.contains((Object)var11_6)) ** GOTO lbl-1000
            var12_8 = var1_1.value(var9_4);
            if (!var8_3.add((Object)var11_6)) ** GOTO lbl19
            var2_2.add((Object)new Header(var11_6, var12_8));
            ** GOTO lbl-1000
lbl19: // 1 sources:
            var13_7 = 0;
            do {
                if (var13_7 >= var2_2.size()) lbl-1000: // 4 sources:
                {
                    do {
                        ++var9_4;
                        continue block0;
                        break;
                    } while (true);
                }
                if (((Header)var2_2.get((int)var13_7)).name.equals(var11_6)) {
                    var2_2.set(var13_7, (Object)new Header(var11_6, Http2xStream.joinOnNull(((Header)var2_2.get((int)var13_7)).value.utf8(), var12_8)));
                    ** continue;
                }
                ++var13_7;
            } while (true);
            break;
        } while (true);
    }

    @Override
    public void cancel() {
        if (this.stream != null) {
            this.stream.closeLater(ErrorCode.CANCEL);
        }
    }

    @Override
    public Sink createRequestBody(Request request, long l2) throws IOException {
        return this.stream.getSink();
    }

    @Override
    public void finishRequest() throws IOException {
        this.stream.getSink().close();
    }

    @Override
    public ResponseBody openResponseBody(Response response) throws IOException {
        StreamFinishingSource streamFinishingSource = (Http2xStream)this.new StreamFinishingSource(this.stream.getSource());
        return new RealResponseBody(response.headers(), Okio.buffer(streamFinishingSource));
    }

    @Override
    public Response.Builder readResponseHeaders() throws IOException {
        if (this.framedConnection.getProtocol() == Protocol.HTTP_2) {
            return Http2xStream.readHttp2HeadersList(this.stream.getResponseHeaders());
        }
        return Http2xStream.readSpdy3HeadersList(this.stream.getResponseHeaders());
    }

    @Override
    public void setHttpEngine(HttpEngine httpEngine) {
        this.httpEngine = httpEngine;
    }

    @Override
    public void writeRequestBody(RetryableSink retryableSink) throws IOException {
        retryableSink.writeToSocket(this.stream.getSink());
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void writeRequestHeaders(Request request) throws IOException {
        if (this.stream != null) {
            return;
        }
        this.httpEngine.writingRequestHeaders();
        boolean bl2 = this.httpEngine.permitsRequestBody(request);
        List<Header> list = this.framedConnection.getProtocol() == Protocol.HTTP_2 ? Http2xStream.http2HeadersList(request) : Http2xStream.spdy3HeadersList(request);
        this.stream = this.framedConnection.newStream(list, bl2, true);
        this.stream.readTimeout().timeout(this.httpEngine.client.readTimeoutMillis(), TimeUnit.MILLISECONDS);
        this.stream.writeTimeout().timeout(this.httpEngine.client.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
    }

    class StreamFinishingSource
    extends ForwardingSource {
        public StreamFinishingSource(Source source) {
            super(source);
        }

        @Override
        public void close() throws IOException {
            Http2xStream.this.streamAllocation.streamFinished(false, Http2xStream.this);
            super.close();
        }
    }

}

