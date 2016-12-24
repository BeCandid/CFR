/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.nio.charset.Charset
 *  java.nio.charset.UnsupportedCharsetException
 *  java.util.concurrent.TimeUnit
 */
package okhttp3.logging;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.concurrent.TimeUnit;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Platform;
import okhttp3.internal.http.HttpEngine;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;

public final class HttpLoggingInterceptor
implements Interceptor {
    private static final Charset UTF8 = Charset.forName((String)"UTF-8");
    private volatile Level level = Level.NONE;
    private final Logger logger;

    public HttpLoggingInterceptor() {
        this(Logger.DEFAULT);
    }

    public HttpLoggingInterceptor(Logger logger) {
        this.logger = logger;
    }

    private boolean bodyEncoded(Headers headers) {
        String string2 = headers.get("Content-Encoding");
        if (string2 != null && !string2.equalsIgnoreCase("identity")) {
            return true;
        }
        return false;
    }

    public Level getLevel() {
        return this.level;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Level level = this.level;
        Request request = chain.request();
        if (level == Level.NONE) {
            return chain.proceed(request);
        }
        boolean bl2 = level == Level.BODY;
        boolean bl3 = bl2 || level == Level.HEADERS;
        RequestBody requestBody = request.body();
        boolean bl4 = requestBody != null;
        Connection connection = chain.connection();
        Protocol protocol = connection != null ? connection.protocol() : Protocol.HTTP_1_1;
        String string2 = "--> " + request.method() + ' ' + request.url() + ' ' + (Object)((Object)protocol);
        if (!bl3 && bl4) {
            string2 = string2 + " (" + requestBody.contentLength() + "-byte body)";
        }
        this.logger.log(string2);
        if (bl3) {
            if (bl4) {
                if (requestBody.contentType() != null) {
                    this.logger.log("Content-Type: " + requestBody.contentType());
                }
                if (requestBody.contentLength() != -1) {
                    this.logger.log("Content-Length: " + requestBody.contentLength());
                }
            }
            Headers headers = request.headers();
            int n2 = headers.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                String string3 = headers.name(i2);
                if ("Content-Type".equalsIgnoreCase(string3) || "Content-Length".equalsIgnoreCase(string3)) continue;
                this.logger.log(string3 + ": " + headers.value(i2));
            }
            if (!bl2 || !bl4) {
                this.logger.log("--> END " + request.method());
            } else if (super.bodyEncoded(request.headers())) {
                this.logger.log("--> END " + request.method() + " (encoded body omitted)");
            } else {
                Buffer buffer = new Buffer();
                requestBody.writeTo(buffer);
                Charset charset = UTF8;
                MediaType mediaType = requestBody.contentType();
                if (mediaType != null) {
                    charset = mediaType.charset(UTF8);
                }
                this.logger.log("");
                this.logger.log(buffer.readString(charset));
                this.logger.log("--> END " + request.method() + " (" + requestBody.contentLength() + "-byte body)");
            }
        }
        long l2 = System.nanoTime();
        Response response = chain.proceed(request);
        long l3 = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - l2);
        ResponseBody responseBody = response.body();
        long l4 = responseBody.contentLength();
        String string4 = l4 != -1 ? "" + l4 + "-byte" : "unknown-length";
        Logger logger = this.logger;
        StringBuilder stringBuilder = new StringBuilder().append("<-- ").append(response.code()).append(' ').append(response.message()).append(' ').append((Object)response.request().url()).append(" (").append(l3).append("ms");
        String string5 = !bl3 ? ", " + string4 + " body" : "";
        logger.log(stringBuilder.append(string5).append(')').toString());
        if (!bl3) return response;
        Headers headers = response.headers();
        int n3 = headers.size();
        for (int i3 = 0; i3 < n3; ++i3) {
            this.logger.log(headers.name(i3) + ": " + headers.value(i3));
        }
        if (!bl2 || !HttpEngine.hasBody(response)) {
            this.logger.log("<-- END HTTP");
            return response;
        }
        if (super.bodyEncoded(response.headers())) {
            this.logger.log("<-- END HTTP (encoded body omitted)");
            return response;
        }
        BufferedSource bufferedSource = responseBody.source();
        bufferedSource.request(Long.MAX_VALUE);
        Buffer buffer = bufferedSource.buffer();
        Charset charset = UTF8;
        MediaType mediaType = responseBody.contentType();
        if (mediaType != null) {
            Charset charset2;
            charset = charset2 = mediaType.charset(UTF8);
        }
        if (l4 != 0) {
            this.logger.log("");
            this.logger.log(buffer.clone().readString(charset));
        }
        this.logger.log("<-- END HTTP (" + buffer.size() + "-byte body)");
        return response;
        catch (UnsupportedCharsetException unsupportedCharsetException) {
            this.logger.log("");
            this.logger.log("Couldn't decode the response body; charset is likely malformed.");
            this.logger.log("<-- END HTTP");
            return response;
        }
    }

    public HttpLoggingInterceptor setLevel(Level level) {
        if (level == null) {
            throw new NullPointerException("level == null. Use Level.NONE instead.");
        }
        this.level = level;
        return this;
    }

    public static final class Level
    extends Enum<Level> {
        private static final /* synthetic */ Level[] $VALUES;
        public static final /* enum */ Level BASIC;
        public static final /* enum */ Level BODY;
        public static final /* enum */ Level HEADERS;
        public static final /* enum */ Level NONE;

        static {
            NONE = new Level();
            BASIC = new Level();
            HEADERS = new Level();
            BODY = new Level();
            Level[] arrlevel = new Level[]{NONE, BASIC, HEADERS, BODY};
            $VALUES = arrlevel;
        }

        private Level() {
            super(string2, n2);
        }

        public static Level valueOf(String string2) {
            return (Level)Enum.valueOf((Class)Level.class, (String)string2);
        }

        public static Level[] values() {
            return (Level[])$VALUES.clone();
        }
    }

    public static interface Logger {
        public static final Logger DEFAULT = new Logger(){

            @Override
            public void log(String string2) {
                Platform.get().log(string2);
            }
        };

        public void log(String var1);

    }

}

