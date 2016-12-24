/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Date
 *  java.util.concurrent.TimeUnit
 */
package okhttp3.internal.http;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import okhttp3.CacheControl;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.http.HeaderParser;
import okhttp3.internal.http.HttpDate;
import okhttp3.internal.http.OkHeaders;

public final class CacheStrategy {
    public final Response cacheResponse;
    public final Request networkRequest;

    private CacheStrategy(Request request, Response response) {
        this.networkRequest = request;
        this.cacheResponse = response;
    }

    /* synthetic */ CacheStrategy(Request request, Response response,  var3_2) {
        super(request, response);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static boolean isCacheable(Response response, Request request) {
        switch (response.code()) {
            case 302: 
            case 307: {
                if (response.header("Expires") != null || response.cacheControl().maxAgeSeconds() != -1 || response.cacheControl().isPublic() || response.cacheControl().isPrivate()) break;
            }
            default: {
                return false;
            }
            case 200: 
            case 203: 
            case 204: 
            case 300: 
            case 301: 
            case 308: 
            case 404: 
            case 405: 
            case 410: 
            case 414: 
            case 501: 
        }
        if (response.cacheControl().noStore() || request.cacheControl().noStore()) return false;
        return true;
    }

    public static class Factory {
        private int ageSeconds = -1;
        final Response cacheResponse;
        private String etag;
        private Date expires;
        private Date lastModified;
        private String lastModifiedString;
        final long nowMillis;
        private long receivedResponseMillis;
        final Request request;
        private long sentRequestMillis;
        private Date servedDate;
        private String servedDateString;

        /*
         * Enabled aggressive block sorting
         */
        public Factory(long l2, Request request, Response response) {
            this.nowMillis = l2;
            this.request = request;
            this.cacheResponse = response;
            if (response != null) {
                Headers headers = response.headers();
                int n2 = headers.size();
                for (int i2 = 0; i2 < n2; ++i2) {
                    String string2 = headers.name(i2);
                    String string3 = headers.value(i2);
                    if ("Date".equalsIgnoreCase(string2)) {
                        this.servedDate = HttpDate.parse(string3);
                        this.servedDateString = string3;
                        continue;
                    }
                    if ("Expires".equalsIgnoreCase(string2)) {
                        this.expires = HttpDate.parse(string3);
                        continue;
                    }
                    if ("Last-Modified".equalsIgnoreCase(string2)) {
                        this.lastModified = HttpDate.parse(string3);
                        this.lastModifiedString = string3;
                        continue;
                    }
                    if ("ETag".equalsIgnoreCase(string2)) {
                        this.etag = string3;
                        continue;
                    }
                    if ("Age".equalsIgnoreCase(string2)) {
                        this.ageSeconds = HeaderParser.parseSeconds(string3, -1);
                        continue;
                    }
                    if (OkHeaders.SENT_MILLIS.equalsIgnoreCase(string2)) {
                        this.sentRequestMillis = Long.parseLong((String)string3);
                        continue;
                    }
                    if (!OkHeaders.RECEIVED_MILLIS.equalsIgnoreCase(string2)) continue;
                    this.receivedResponseMillis = Long.parseLong((String)string3);
                }
            }
        }

        /*
         * Enabled aggressive block sorting
         */
        private long cacheResponseAge() {
            long l2 = 0;
            if (this.servedDate != null) {
                l2 = Math.max((long)l2, (long)(this.receivedResponseMillis - this.servedDate.getTime()));
            }
            long l3 = this.ageSeconds != -1 ? Math.max((long)l2, (long)TimeUnit.SECONDS.toMillis((long)this.ageSeconds)) : l2;
            long l4 = this.receivedResponseMillis - this.sentRequestMillis;
            return this.nowMillis - this.receivedResponseMillis + (l3 + l4);
        }

        /*
         * Enabled aggressive block sorting
         */
        private long computeFreshnessLifetime() {
            long l2 = 0;
            CacheControl cacheControl = this.cacheResponse.cacheControl();
            if (cacheControl.maxAgeSeconds() != -1) {
                return TimeUnit.SECONDS.toMillis((long)cacheControl.maxAgeSeconds());
            }
            if (this.expires != null) {
                long l3 = this.servedDate != null ? this.servedDate.getTime() : this.receivedResponseMillis;
                long l4 = this.expires.getTime() - l3;
                if (l4 <= l2) return l2;
                return l4;
            }
            if (this.lastModified == null) return l2;
            if (this.cacheResponse.request().url().query() != null) return l2;
            long l5 = this.servedDate != null ? this.servedDate.getTime() : this.sentRequestMillis;
            long l6 = l5 - this.lastModified.getTime();
            if (l6 <= l2) return l2;
            return l6 / 10;
        }

        /*
         * Enabled aggressive block sorting
         */
        private CacheStrategy getCandidate() {
            Request request;
            if (this.cacheResponse == null) {
                return new CacheStrategy(this.request, null, null);
            }
            if (this.request.isHttps() && this.cacheResponse.handshake() == null) {
                return new CacheStrategy(this.request, null, null);
            }
            if (!CacheStrategy.isCacheable(this.cacheResponse, this.request)) {
                return new CacheStrategy(this.request, null, null);
            }
            CacheControl cacheControl = this.request.cacheControl();
            if (cacheControl.noCache()) return new CacheStrategy(this.request, null, null);
            if (Factory.hasConditions(this.request)) {
                return new CacheStrategy(this.request, null, null);
            }
            long l2 = this.cacheResponseAge();
            long l3 = this.computeFreshnessLifetime();
            if (cacheControl.maxAgeSeconds() != -1) {
                l3 = Math.min((long)l3, (long)TimeUnit.SECONDS.toMillis((long)cacheControl.maxAgeSeconds()));
            }
            long l4 = 0;
            if (cacheControl.minFreshSeconds() != -1) {
                l4 = TimeUnit.SECONDS.toMillis((long)cacheControl.minFreshSeconds());
            }
            long l5 = 0;
            CacheControl cacheControl2 = this.cacheResponse.cacheControl();
            if (!cacheControl2.mustRevalidate() && cacheControl.maxStaleSeconds() != -1) {
                l5 = TimeUnit.SECONDS.toMillis((long)cacheControl.maxStaleSeconds());
            }
            if (!cacheControl2.noCache() && l2 + l4 < l3 + l5) {
                Response.Builder builder = this.cacheResponse.newBuilder();
                if (l2 + l4 >= l3) {
                    builder.addHeader("Warning", "110 HttpURLConnection \"Response is stale\"");
                }
                if (l2 <= 86400000) return new CacheStrategy(null, builder.build(), null);
                if (!this.isFreshnessLifetimeHeuristic()) return new CacheStrategy(null, builder.build(), null);
                builder.addHeader("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                return new CacheStrategy(null, builder.build(), null);
            }
            Request.Builder builder = this.request.newBuilder();
            if (this.etag != null) {
                builder.header("If-None-Match", this.etag);
            } else if (this.lastModified != null) {
                builder.header("If-Modified-Since", this.lastModifiedString);
            } else if (this.servedDate != null) {
                builder.header("If-Modified-Since", this.servedDateString);
            }
            if (!Factory.hasConditions(request = builder.build())) return new CacheStrategy(request, null, null);
            return new CacheStrategy(request, this.cacheResponse, null);
        }

        private static boolean hasConditions(Request request) {
            if (request.header("If-Modified-Since") != null || request.header("If-None-Match") != null) {
                return true;
            }
            return false;
        }

        private boolean isFreshnessLifetimeHeuristic() {
            if (this.cacheResponse.cacheControl().maxAgeSeconds() == -1 && this.expires == null) {
                return true;
            }
            return false;
        }

        public CacheStrategy get() {
            CacheStrategy cacheStrategy = this.getCandidate();
            if (cacheStrategy.networkRequest != null && this.request.cacheControl().onlyIfCached()) {
                cacheStrategy = new CacheStrategy(null, null, null);
            }
            return cacheStrategy;
        }
    }

}

