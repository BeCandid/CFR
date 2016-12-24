/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.URI
 *  java.net.URL
 *  java.util.List
 */
package okhttp3;

import java.net.URI;
import java.net.URL;
import java.util.List;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.RequestBody;
import okhttp3.internal.http.HttpMethod;

public final class Request {
    private final RequestBody body;
    private volatile CacheControl cacheControl;
    private final Headers headers;
    private volatile URI javaNetUri;
    private final String method;
    private final Object tag;
    private final HttpUrl url;

    /*
     * Enabled aggressive block sorting
     */
    private Request(Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.headers = builder.headers.build();
        this.body = builder.body;
        Object object = builder.tag != null ? builder.tag : this;
        this.tag = object;
    }

    /* synthetic */ Request(Builder builder,  var2_2) {
        super(builder);
    }

    public RequestBody body() {
        return this.body;
    }

    public CacheControl cacheControl() {
        CacheControl cacheControl;
        CacheControl cacheControl2 = this.cacheControl;
        if (cacheControl2 != null) {
            return cacheControl2;
        }
        this.cacheControl = cacheControl = CacheControl.parse(this.headers);
        return cacheControl;
    }

    public String header(String string2) {
        return this.headers.get(string2);
    }

    public List<String> headers(String string2) {
        return this.headers.values(string2);
    }

    public Headers headers() {
        return this.headers;
    }

    public boolean isHttps() {
        return this.url.isHttps();
    }

    public String method() {
        return this.method;
    }

    public Builder newBuilder() {
        return new Builder(this, null);
    }

    public Object tag() {
        return this.tag;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String toString() {
        Object object;
        StringBuilder stringBuilder = new StringBuilder().append("Request{method=").append(this.method).append(", url=").append((Object)this.url).append(", tag=");
        if (this.tag != this) {
            object = this.tag;
            do {
                return stringBuilder.append(object).append('}').toString();
                break;
            } while (true);
        }
        object = null;
        return stringBuilder.append(object).append('}').toString();
    }

    public HttpUrl url() {
        return this.url;
    }

    public static class Builder {
        private RequestBody body;
        private Headers.Builder headers;
        private String method;
        private Object tag;
        private HttpUrl url;

        public Builder() {
            this.method = "GET";
            this.headers = new Headers.Builder();
        }

        private Builder(Request request) {
            this.url = request.url;
            this.method = request.method;
            this.body = request.body;
            this.tag = request.tag;
            this.headers = request.headers.newBuilder();
        }

        /* synthetic */ Builder(Request request,  var2_2) {
            super(request);
        }

        public Builder addHeader(String string2, String string3) {
            this.headers.add(string2, string3);
            return this;
        }

        public Request build() {
            if (this.url == null) {
                throw new IllegalStateException("url == null");
            }
            return new Request(this, null);
        }

        public Builder cacheControl(CacheControl cacheControl) {
            String string2 = cacheControl.toString();
            if (string2.isEmpty()) {
                return this.removeHeader("Cache-Control");
            }
            return this.header("Cache-Control", string2);
        }

        public Builder delete() {
            return this.delete(RequestBody.create(null, new byte[0]));
        }

        public Builder delete(RequestBody requestBody) {
            return this.method("DELETE", requestBody);
        }

        public Builder get() {
            return this.method("GET", null);
        }

        public Builder head() {
            return this.method("HEAD", null);
        }

        public Builder header(String string2, String string3) {
            this.headers.set(string2, string3);
            return this;
        }

        public Builder headers(Headers headers) {
            this.headers = headers.newBuilder();
            return this;
        }

        public Builder method(String string2, RequestBody requestBody) {
            if (string2 == null || string2.length() == 0) {
                throw new IllegalArgumentException("method == null || method.length() == 0");
            }
            if (requestBody != null && !HttpMethod.permitsRequestBody(string2)) {
                throw new IllegalArgumentException("method " + string2 + " must not have a request body.");
            }
            if (requestBody == null && HttpMethod.requiresRequestBody(string2)) {
                throw new IllegalArgumentException("method " + string2 + " must have a request body.");
            }
            this.method = string2;
            this.body = requestBody;
            return this;
        }

        public Builder patch(RequestBody requestBody) {
            return this.method("PATCH", requestBody);
        }

        public Builder post(RequestBody requestBody) {
            return this.method("POST", requestBody);
        }

        public Builder put(RequestBody requestBody) {
            return this.method("PUT", requestBody);
        }

        public Builder removeHeader(String string2) {
            this.headers.removeAll(string2);
            return this;
        }

        public Builder tag(Object object) {
            this.tag = object;
            return this;
        }

        /*
         * Enabled aggressive block sorting
         */
        public Builder url(String string2) {
            HttpUrl httpUrl;
            if (string2 == null) {
                throw new IllegalArgumentException("url == null");
            }
            if (string2.regionMatches(true, 0, "ws:", 0, 3)) {
                string2 = "http:" + string2.substring(3);
            } else if (string2.regionMatches(true, 0, "wss:", 0, 4)) {
                string2 = "https:" + string2.substring(4);
            }
            if ((httpUrl = HttpUrl.parse(string2)) == null) {
                throw new IllegalArgumentException("unexpected url: " + string2);
            }
            return this.url(httpUrl);
        }

        public Builder url(URL uRL) {
            if (uRL == null) {
                throw new IllegalArgumentException("url == null");
            }
            HttpUrl httpUrl = HttpUrl.get(uRL);
            if (httpUrl == null) {
                throw new IllegalArgumentException("unexpected url: " + (Object)uRL);
            }
            return this.url(httpUrl);
        }

        public Builder url(HttpUrl httpUrl) {
            if (httpUrl == null) {
                throw new IllegalArgumentException("url == null");
            }
            this.url = httpUrl;
            return this;
        }
    }

}

