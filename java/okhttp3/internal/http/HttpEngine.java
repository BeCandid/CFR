/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.IllegalStateException
 *  java.lang.Long
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.net.ProtocolException
 *  java.net.Proxy
 *  java.net.Proxy$Type
 *  java.net.ProxySelector
 *  java.util.Date
 *  java.util.List
 *  java.util.concurrent.TimeUnit
 *  javax.net.SocketFactory
 *  javax.net.ssl.HostnameVerifier
 *  javax.net.ssl.SSLSocketFactory
 */
package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Address;
import okhttp3.Authenticator;
import okhttp3.CertificatePinner;
import okhttp3.Connection;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Dns;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.InternalCache;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okhttp3.internal.http.CacheRequest;
import okhttp3.internal.http.CacheStrategy;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.HttpStream;
import okhttp3.internal.http.OkHeaders;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.http.RequestException;
import okhttp3.internal.http.RetryableSink;
import okhttp3.internal.http.RouteException;
import okhttp3.internal.http.StreamAllocation;
import okhttp3.internal.io.RealConnection;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class HttpEngine {
    private static final ResponseBody EMPTY_BODY = new ResponseBody(){

        @Override
        public long contentLength() {
            return 0;
        }

        @Override
        public MediaType contentType() {
            return null;
        }

        @Override
        public BufferedSource source() {
            return new Buffer();
        }
    };
    public static final int MAX_FOLLOW_UPS = 20;
    public final boolean bufferRequestBody;
    private BufferedSink bufferedRequestBody;
    private Response cacheResponse;
    private CacheStrategy cacheStrategy;
    private final boolean callerWritesRequestBody;
    final OkHttpClient client;
    private final boolean forWebSocket;
    private HttpStream httpStream;
    private Request networkRequest;
    private final Response priorResponse;
    private Sink requestBodyOut;
    long sentRequestMillis = -1;
    private CacheRequest storeRequest;
    public final StreamAllocation streamAllocation;
    private boolean transparentGzip;
    private final Request userRequest;
    private Response userResponse;

    /*
     * Enabled aggressive block sorting
     */
    public HttpEngine(OkHttpClient okHttpClient, Request request, boolean bl2, boolean bl3, boolean bl4, StreamAllocation streamAllocation, RetryableSink retryableSink, Response response) {
        this.client = okHttpClient;
        this.userRequest = request;
        this.bufferRequestBody = bl2;
        this.callerWritesRequestBody = bl3;
        this.forWebSocket = bl4;
        if (streamAllocation == null) {
            streamAllocation = new StreamAllocation(okHttpClient.connectionPool(), HttpEngine.createAddress(okHttpClient, request));
        }
        this.streamAllocation = streamAllocation;
        this.requestBodyOut = retryableSink;
        this.priorResponse = response;
    }

    /*
     * Enabled aggressive block sorting
     */
    private Response cacheWritingResponse(CacheRequest cacheRequest, Response response) throws IOException {
        Sink sink;
        if (cacheRequest == null || (sink = cacheRequest.body()) == null) {
            return response;
        }
        Source source = new Source(response.body().source(), cacheRequest, Okio.buffer(sink)){
            boolean cacheRequestClosed;
            final /* synthetic */ BufferedSink val$cacheBody;
            final /* synthetic */ CacheRequest val$cacheRequest;
            final /* synthetic */ BufferedSource val$source;

            @Override
            public void close() throws IOException {
                if (!this.cacheRequestClosed && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    this.cacheRequestClosed = true;
                    this.val$cacheRequest.abort();
                }
                this.val$source.close();
            }

            /*
             * Exception decompiling
             */
            @Override
            public long read(Buffer var1, long var2_2) throws IOException {
                // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 2[SIMPLE_IF_TAKEN]
                // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
                // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
                // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2859)
                // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:805)
                // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
                // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
                // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
                // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
                // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
                // org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:664)
                // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:747)
                // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
                // org.benf.cfr.reader.Main.doJar(Main.java:128)
                // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
                // java.lang.Thread.run(Thread.java:818)
                throw new IllegalStateException("Decompilation failed");
            }

            @Override
            public Timeout timeout() {
                return this.val$source.timeout();
            }
        };
        return response.newBuilder().body(new RealResponseBody(response.headers(), Okio.buffer(source))).build();
    }

    /*
     * Enabled aggressive block sorting
     */
    private static Headers combine(Headers headers, Headers headers2) throws IOException {
        Headers.Builder builder = new Headers.Builder();
        int n2 = headers.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            String string2 = headers.name(i2);
            String string3 = headers.value(i2);
            if ("Warning".equalsIgnoreCase(string2) && string3.startsWith("1") || OkHeaders.isEndToEnd(string2) && headers2.get(string2) != null) continue;
            builder.add(string2, string3);
        }
        int n3 = 0;
        int n4 = headers2.size();
        while (n3 < n4) {
            String string4 = headers2.name(n3);
            if (!"Content-Length".equalsIgnoreCase(string4) && OkHeaders.isEndToEnd(string4)) {
                builder.add(string4, headers2.value(n3));
            }
            ++n3;
        }
        return builder.build();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private HttpStream connect() throws RouteException, RequestException, IOException {
        boolean bl2;
        if (!this.networkRequest.method().equals((Object)"GET")) {
            bl2 = true;
            do {
                return this.streamAllocation.newStream(this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis(), this.client.retryOnConnectionFailure(), bl2);
                break;
            } while (true);
        }
        bl2 = false;
        return this.streamAllocation.newStream(this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis(), this.client.retryOnConnectionFailure(), bl2);
    }

    private String cookieHeader(List<Cookie> list) {
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (i2 > 0) {
                stringBuilder.append("; ");
            }
            Cookie cookie = (Cookie)list.get(i2);
            stringBuilder.append(cookie.name()).append('=').append(cookie.value());
        }
        return stringBuilder.toString();
    }

    private static Address createAddress(OkHttpClient okHttpClient, Request request) {
        boolean bl2 = request.isHttps();
        SSLSocketFactory sSLSocketFactory = null;
        HostnameVerifier hostnameVerifier = null;
        CertificatePinner certificatePinner = null;
        if (bl2) {
            sSLSocketFactory = okHttpClient.sslSocketFactory();
            hostnameVerifier = okHttpClient.hostnameVerifier();
            certificatePinner = okHttpClient.certificatePinner();
        }
        return new Address(request.url().host(), request.url().port(), okHttpClient.dns(), okHttpClient.socketFactory(), sSLSocketFactory, hostnameVerifier, certificatePinner, okHttpClient.proxyAuthenticator(), okHttpClient.proxy(), okHttpClient.protocols(), okHttpClient.connectionSpecs(), okHttpClient.proxySelector());
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static boolean hasBody(Response response) {
        if (response.request().method().equals((Object)"HEAD")) {
            return false;
        }
        int n2 = response.code();
        if ((n2 < 100 || n2 >= 200) && n2 != 204 && n2 != 304) {
            return true;
        }
        if (OkHeaders.contentLength(response) != -1) return true;
        if (!"chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) return false;
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void maybeCache() throws IOException {
        InternalCache internalCache = Internal.instance.internalCache(this.client);
        if (internalCache == null) {
            return;
        }
        if (CacheStrategy.isCacheable(this.userResponse, this.networkRequest)) {
            this.storeRequest = internalCache.put(HttpEngine.stripBody(this.userResponse));
            return;
        }
        if (!HttpMethod.invalidatesCache(this.networkRequest.method())) return;
        try {
            internalCache.remove(this.networkRequest);
            return;
        }
        catch (IOException var2_2) {
            return;
        }
    }

    private Request networkRequest(Request request) throws IOException {
        List<Cookie> list;
        Request.Builder builder = request.newBuilder();
        if (request.header("Host") == null) {
            builder.header("Host", Util.hostHeader(request.url(), false));
        }
        if (request.header("Connection") == null) {
            builder.header("Connection", "Keep-Alive");
        }
        if (request.header("Accept-Encoding") == null) {
            this.transparentGzip = true;
            builder.header("Accept-Encoding", "gzip");
        }
        if (!(list = this.client.cookieJar().loadForRequest(request.url())).isEmpty()) {
            builder.header("Cookie", super.cookieHeader(list));
        }
        if (request.header("User-Agent") == null) {
            builder.header("User-Agent", Version.userAgent());
        }
        return builder.build();
    }

    private Response readNetworkResponse() throws IOException {
        this.httpStream.finishRequest();
        Response response = this.httpStream.readResponseHeaders().request(this.networkRequest).handshake(this.streamAllocation.connection().handshake()).header(OkHeaders.SENT_MILLIS, Long.toString((long)this.sentRequestMillis)).header(OkHeaders.RECEIVED_MILLIS, Long.toString((long)System.currentTimeMillis())).build();
        if (!this.forWebSocket) {
            response = response.newBuilder().body(this.httpStream.openResponseBody(response)).build();
        }
        if ("close".equalsIgnoreCase(response.request().header("Connection")) || "close".equalsIgnoreCase(response.header("Connection"))) {
            this.streamAllocation.noNewStreams();
        }
        return response;
    }

    private static Response stripBody(Response response) {
        if (response != null && response.body() != null) {
            response = response.newBuilder().body(null).build();
        }
        return response;
    }

    /*
     * Enabled aggressive block sorting
     */
    private Response unzip(Response response) throws IOException {
        if (!this.transparentGzip || !"gzip".equalsIgnoreCase(this.userResponse.header("Content-Encoding")) || response.body() == null) {
            return response;
        }
        GzipSource gzipSource = new GzipSource(response.body().source());
        Headers headers = response.headers().newBuilder().removeAll("Content-Encoding").removeAll("Content-Length").build();
        return response.newBuilder().headers(headers).body(new RealResponseBody(headers, Okio.buffer(gzipSource))).build();
    }

    /*
     * Enabled aggressive block sorting
     */
    private static boolean validate(Response response, Response response2) {
        Date date;
        Date date2;
        if (response2.code() == 304 || (date = response.headers().getDate("Last-Modified")) != null && (date2 = response2.headers().getDate("Last-Modified")) != null && date2.getTime() < date.getTime()) {
            return true;
        }
        return false;
    }

    private boolean writeRequestHeadersEagerly() {
        if (this.callerWritesRequestBody && this.permitsRequestBody(this.networkRequest) && this.requestBodyOut == null) {
            return true;
        }
        return false;
    }

    public void cancel() {
        this.streamAllocation.cancel();
    }

    /*
     * Enabled aggressive block sorting
     */
    public StreamAllocation close() {
        if (this.bufferedRequestBody != null) {
            Util.closeQuietly(this.bufferedRequestBody);
        } else if (this.requestBodyOut != null) {
            Util.closeQuietly(this.requestBodyOut);
        }
        if (this.userResponse != null) {
            Util.closeQuietly(this.userResponse.body());
            return this.streamAllocation;
        }
        this.streamAllocation.connectionFailed(null);
        return this.streamAllocation;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public Request followUpRequest() throws IOException {
        if (this.userResponse == null) {
            throw new IllegalStateException();
        }
        RealConnection realConnection = this.streamAllocation.connection();
        Route route = realConnection != null ? realConnection.route() : null;
        int n2 = this.userResponse.code();
        String string2 = this.userRequest.method();
        switch (n2) {
            default: {
                return null;
            }
            case 407: {
                Proxy proxy = route != null ? route.proxy() : this.client.proxy();
                if (proxy.type() == Proxy.Type.HTTP) return this.client.authenticator().authenticate(route, this.userResponse);
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            case 401: {
                return this.client.authenticator().authenticate(route, this.userResponse);
            }
            case 307: 
            case 308: {
                if (!string2.equals((Object)"GET")) {
                    if (!string2.equals((Object)"HEAD")) return null;
                }
            }
            case 300: 
            case 301: 
            case 302: 
            case 303: {
                if (!this.client.followRedirects()) return null;
                String string3 = this.userResponse.header("Location");
                if (string3 == null) return null;
                HttpUrl httpUrl = this.userRequest.url().resolve(string3);
                if (httpUrl == null) return null;
                if (!httpUrl.scheme().equals((Object)this.userRequest.url().scheme())) {
                    if (!this.client.followSslRedirects()) return null;
                }
                Request.Builder builder = this.userRequest.newBuilder();
                if (HttpMethod.permitsRequestBody(string2)) {
                    if (HttpMethod.redirectsToGet(string2)) {
                        builder.method("GET", null);
                    } else {
                        builder.method(string2, null);
                    }
                    builder.removeHeader("Transfer-Encoding");
                    builder.removeHeader("Content-Length");
                    builder.removeHeader("Content-Type");
                }
                if (this.sameConnection(httpUrl)) return builder.url(httpUrl).build();
                builder.removeHeader("Authorization");
                return builder.url(httpUrl).build();
            }
            case 408: 
        }
        boolean bl2 = this.requestBodyOut == null || this.requestBodyOut instanceof RetryableSink;
        if (!this.callerWritesRequestBody) return this.userRequest;
        if (!bl2) return null;
        return this.userRequest;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public BufferedSink getBufferedRequestBody() {
        BufferedSink bufferedSink;
        BufferedSink bufferedSink2 = this.bufferedRequestBody;
        if (bufferedSink2 != null) {
            return bufferedSink2;
        }
        Sink sink = this.getRequestBody();
        if (sink == null) return null;
        this.bufferedRequestBody = bufferedSink = Okio.buffer(sink);
        return bufferedSink;
    }

    public Connection getConnection() {
        return this.streamAllocation.connection();
    }

    public Request getRequest() {
        return this.userRequest;
    }

    public Sink getRequestBody() {
        if (this.cacheStrategy == null) {
            throw new IllegalStateException();
        }
        return this.requestBodyOut;
    }

    public Response getResponse() {
        if (this.userResponse == null) {
            throw new IllegalStateException();
        }
        return this.userResponse;
    }

    public boolean hasResponse() {
        if (this.userResponse != null) {
            return true;
        }
        return false;
    }

    boolean permitsRequestBody(Request request) {
        return HttpMethod.permitsRequestBody(request.method());
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void readResponse() throws IOException {
        Response response;
        if (this.userResponse != null) {
            return;
        }
        if (this.networkRequest == null && this.cacheResponse == null) {
            throw new IllegalStateException("call sendRequest() first!");
        }
        if (this.networkRequest == null) return;
        if (this.forWebSocket) {
            this.httpStream.writeRequestHeaders(this.networkRequest);
            response = this.readNetworkResponse();
        } else if (!this.callerWritesRequestBody) {
            response = new NetworkInterceptorChain(0, this.networkRequest).proceed(this.networkRequest);
        } else {
            if (this.bufferedRequestBody != null && this.bufferedRequestBody.buffer().size() > 0) {
                this.bufferedRequestBody.emit();
            }
            if (this.sentRequestMillis == -1) {
                if (OkHeaders.contentLength(this.networkRequest) == -1 && this.requestBodyOut instanceof RetryableSink) {
                    long l2 = ((RetryableSink)this.requestBodyOut).contentLength();
                    this.networkRequest = this.networkRequest.newBuilder().header("Content-Length", Long.toString((long)l2)).build();
                }
                this.httpStream.writeRequestHeaders(this.networkRequest);
            }
            if (this.requestBodyOut != null) {
                if (this.bufferedRequestBody != null) {
                    this.bufferedRequestBody.close();
                } else {
                    this.requestBodyOut.close();
                }
                if (this.requestBodyOut instanceof RetryableSink) {
                    this.httpStream.writeRequestBody((RetryableSink)this.requestBodyOut);
                }
            }
            response = this.readNetworkResponse();
        }
        this.receiveHeaders(response.headers());
        if (this.cacheResponse != null) {
            if (HttpEngine.validate(this.cacheResponse, response)) {
                this.userResponse = this.cacheResponse.newBuilder().request(this.userRequest).priorResponse(HttpEngine.stripBody(this.priorResponse)).headers(HttpEngine.combine(this.cacheResponse.headers(), response.headers())).cacheResponse(HttpEngine.stripBody(this.cacheResponse)).networkResponse(HttpEngine.stripBody(response)).build();
                response.body().close();
                this.releaseStreamAllocation();
                InternalCache internalCache = Internal.instance.internalCache(this.client);
                internalCache.trackConditionalCacheHit();
                internalCache.update(this.cacheResponse, HttpEngine.stripBody(this.userResponse));
                this.userResponse = this.unzip(this.userResponse);
                return;
            }
            Util.closeQuietly(this.cacheResponse.body());
        }
        this.userResponse = response.newBuilder().request(this.userRequest).priorResponse(HttpEngine.stripBody(this.priorResponse)).cacheResponse(HttpEngine.stripBody(this.cacheResponse)).networkResponse(HttpEngine.stripBody(response)).build();
        if (!HttpEngine.hasBody(this.userResponse)) return;
        this.maybeCache();
        this.userResponse = this.unzip(this.cacheWritingResponse(this.storeRequest, this.userResponse));
    }

    /*
     * Enabled aggressive block sorting
     */
    public void receiveHeaders(Headers headers) throws IOException {
        List<Cookie> list;
        if (this.client.cookieJar() == CookieJar.NO_COOKIES || (list = Cookie.parseAll(this.userRequest.url(), headers)).isEmpty()) {
            return;
        }
        this.client.cookieJar().saveFromResponse(this.userRequest.url(), list);
    }

    public HttpEngine recover(IOException iOException) {
        return this.recover(iOException, this.requestBodyOut);
    }

    /*
     * Enabled aggressive block sorting
     */
    public HttpEngine recover(IOException iOException, Sink sink) {
        if (!this.streamAllocation.recover(iOException, sink) || !this.client.retryOnConnectionFailure()) {
            return null;
        }
        StreamAllocation streamAllocation = this.close();
        return new HttpEngine(this.client, this.userRequest, this.bufferRequestBody, this.callerWritesRequestBody, this.forWebSocket, streamAllocation, (RetryableSink)sink, this.priorResponse);
    }

    public void releaseStreamAllocation() throws IOException {
        this.streamAllocation.release();
    }

    public boolean sameConnection(HttpUrl httpUrl) {
        HttpUrl httpUrl2 = this.userRequest.url();
        if (httpUrl2.host().equals((Object)httpUrl.host()) && httpUrl2.port() == httpUrl.port() && httpUrl2.scheme().equals((Object)httpUrl.scheme())) {
            return true;
        }
        return false;
    }

    /*
     * Exception decompiling
     */
    public void sendRequest() throws RequestException, RouteException, IOException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.util.ConcurrentModificationException
        // java.util.LinkedList$ReverseLinkIterator.next(LinkedList.java:217)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.extractLabelledBlocks(Block.java:212)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:485)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.insertLabelledBlocks(Op04StructuredStatement.java:649)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:816)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:128)
        // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    public void writingRequestHeaders() {
        if (this.sentRequestMillis != -1) {
            throw new IllegalStateException();
        }
        this.sentRequestMillis = System.currentTimeMillis();
    }

    class NetworkInterceptorChain
    implements Interceptor.Chain {
        private int calls;
        private final int index;
        private final Request request;

        NetworkInterceptorChain(int n2, Request request) {
            this.index = n2;
            this.request = request;
        }

        @Override
        public Connection connection() {
            return HttpEngine.this.streamAllocation.connection();
        }

        @Override
        public Response proceed(Request request) throws IOException {
            Response response;
            this.calls = 1 + this.calls;
            if (this.index > 0) {
                Interceptor interceptor = (Interceptor)HttpEngine.this.client.networkInterceptors().get(-1 + this.index);
                Address address = this.connection().route().address();
                if (!request.url().host().equals((Object)address.url().host()) || request.url().port() != address.url().port()) {
                    throw new IllegalStateException("network interceptor " + interceptor + " must retain the same host and port");
                }
                if (this.calls > 1) {
                    throw new IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
                }
            }
            if (this.index < HttpEngine.this.client.networkInterceptors().size()) {
                NetworkInterceptorChain networkInterceptorChain = new NetworkInterceptorChain(1 + this.index, request);
                Interceptor interceptor = (Interceptor)HttpEngine.this.client.networkInterceptors().get(this.index);
                response = interceptor.intercept(networkInterceptorChain);
                if (networkInterceptorChain.calls != 1) {
                    throw new IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
                }
                if (response == null) {
                    throw new NullPointerException("network interceptor " + interceptor + " returned null");
                }
            } else {
                int n2;
                Response response2;
                HttpEngine.this.httpStream.writeRequestHeaders(request);
                HttpEngine.this.networkRequest = request;
                if (HttpEngine.this.permitsRequestBody(request) && request.body() != null) {
                    BufferedSink bufferedSink = Okio.buffer(HttpEngine.this.httpStream.createRequestBody(request, request.body().contentLength()));
                    request.body().writeTo(bufferedSink);
                    bufferedSink.close();
                }
                if (((n2 = (response2 = HttpEngine.this.readNetworkResponse()).code()) == 204 || n2 == 205) && response2.body().contentLength() > 0) {
                    throw new ProtocolException("HTTP " + n2 + " had non-zero Content-Length: " + response2.body().contentLength());
                }
                response = response2;
            }
            return response;
        }

        @Override
        public Request request() {
            return this.request;
        }
    }

}

