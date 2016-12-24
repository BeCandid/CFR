/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.concurrent.TimeUnit
 */
package okhttp3;

import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.internal.http.HeaderParser;

public final class CacheControl {
    public static final CacheControl FORCE_CACHE;
    public static final CacheControl FORCE_NETWORK;
    String headerValue;
    private final boolean isPrivate;
    private final boolean isPublic;
    private final int maxAgeSeconds;
    private final int maxStaleSeconds;
    private final int minFreshSeconds;
    private final boolean mustRevalidate;
    private final boolean noCache;
    private final boolean noStore;
    private final boolean noTransform;
    private final boolean onlyIfCached;
    private final int sMaxAgeSeconds;

    static {
        FORCE_NETWORK = new Builder().noCache().build();
        FORCE_CACHE = new Builder().onlyIfCached().maxStale(Integer.MAX_VALUE, TimeUnit.SECONDS).build();
    }

    private CacheControl(Builder builder) {
        this.noCache = builder.noCache;
        this.noStore = builder.noStore;
        this.maxAgeSeconds = builder.maxAgeSeconds;
        this.sMaxAgeSeconds = -1;
        this.isPrivate = false;
        this.isPublic = false;
        this.mustRevalidate = false;
        this.maxStaleSeconds = builder.maxStaleSeconds;
        this.minFreshSeconds = builder.minFreshSeconds;
        this.onlyIfCached = builder.onlyIfCached;
        this.noTransform = builder.noTransform;
    }

    /* synthetic */ CacheControl(Builder builder,  var2_2) {
        super(builder);
    }

    private CacheControl(boolean bl2, boolean bl3, int n2, int n3, boolean bl4, boolean bl5, boolean bl6, int n4, int n5, boolean bl7, boolean bl8, String string2) {
        this.noCache = bl2;
        this.noStore = bl3;
        this.maxAgeSeconds = n2;
        this.sMaxAgeSeconds = n3;
        this.isPrivate = bl4;
        this.isPublic = bl5;
        this.mustRevalidate = bl6;
        this.maxStaleSeconds = n4;
        this.minFreshSeconds = n5;
        this.onlyIfCached = bl7;
        this.noTransform = bl8;
        this.headerValue = string2;
    }

    private String headerValue() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.noCache) {
            stringBuilder.append("no-cache, ");
        }
        if (this.noStore) {
            stringBuilder.append("no-store, ");
        }
        if (this.maxAgeSeconds != -1) {
            stringBuilder.append("max-age=").append(this.maxAgeSeconds).append(", ");
        }
        if (this.sMaxAgeSeconds != -1) {
            stringBuilder.append("s-maxage=").append(this.sMaxAgeSeconds).append(", ");
        }
        if (this.isPrivate) {
            stringBuilder.append("private, ");
        }
        if (this.isPublic) {
            stringBuilder.append("public, ");
        }
        if (this.mustRevalidate) {
            stringBuilder.append("must-revalidate, ");
        }
        if (this.maxStaleSeconds != -1) {
            stringBuilder.append("max-stale=").append(this.maxStaleSeconds).append(", ");
        }
        if (this.minFreshSeconds != -1) {
            stringBuilder.append("min-fresh=").append(this.minFreshSeconds).append(", ");
        }
        if (this.onlyIfCached) {
            stringBuilder.append("only-if-cached, ");
        }
        if (this.noTransform) {
            stringBuilder.append("no-transform, ");
        }
        if (stringBuilder.length() == 0) {
            return "";
        }
        stringBuilder.delete(-2 + stringBuilder.length(), stringBuilder.length());
        return stringBuilder.toString();
    }

    /*
     * Enabled aggressive block sorting
     */
    public static CacheControl parse(Headers headers) {
        boolean bl2 = false;
        boolean bl3 = false;
        int n2 = -1;
        int n3 = -1;
        boolean bl4 = false;
        boolean bl5 = false;
        boolean bl6 = false;
        int n4 = -1;
        int n5 = -1;
        boolean bl7 = false;
        boolean bl8 = false;
        boolean bl9 = true;
        String string2 = null;
        int n6 = headers.size();
        for (int i2 = 0; i2 < n6; ++i2) {
            int n7;
            String string3 = headers.name(i2);
            String string4 = headers.value(i2);
            if (string3.equalsIgnoreCase("Cache-Control")) {
                if (string2 != null) {
                    bl9 = false;
                } else {
                    string2 = string4;
                }
            } else {
                if (!string3.equalsIgnoreCase("Pragma")) continue;
                bl9 = false;
            }
            int n8 = 0;
            while (n8 < (n7 = string4.length())) {
                String string5;
                int n9 = n8;
                int n10 = HeaderParser.skipUntil(string4, n8, "=,;");
                String string6 = string4.substring(n9, n10).trim();
                if (n10 == string4.length() || string4.charAt(n10) == ',' || string4.charAt(n10) == ';') {
                    n8 = n10 + 1;
                    string5 = null;
                } else {
                    int n11 = HeaderParser.skipWhitespace(string4, n10 + 1);
                    if (n11 < string4.length() && string4.charAt(n11) == '\"') {
                        int n12 = n11 + 1;
                        int n13 = HeaderParser.skipUntil(string4, n12, "\"");
                        string5 = string4.substring(n12, n13);
                        n8 = n13 + 1;
                    } else {
                        n8 = HeaderParser.skipUntil(string4, n11, ",;");
                        string5 = string4.substring(n11, n8).trim();
                    }
                }
                if ("no-cache".equalsIgnoreCase(string6)) {
                    bl2 = true;
                    continue;
                }
                if ("no-store".equalsIgnoreCase(string6)) {
                    bl3 = true;
                    continue;
                }
                if ("max-age".equalsIgnoreCase(string6)) {
                    n2 = HeaderParser.parseSeconds(string5, -1);
                    continue;
                }
                if ("s-maxage".equalsIgnoreCase(string6)) {
                    n3 = HeaderParser.parseSeconds(string5, -1);
                    continue;
                }
                if ("private".equalsIgnoreCase(string6)) {
                    bl4 = true;
                    continue;
                }
                if ("public".equalsIgnoreCase(string6)) {
                    bl5 = true;
                    continue;
                }
                if ("must-revalidate".equalsIgnoreCase(string6)) {
                    bl6 = true;
                    continue;
                }
                if ("max-stale".equalsIgnoreCase(string6)) {
                    n4 = HeaderParser.parseSeconds(string5, Integer.MAX_VALUE);
                    continue;
                }
                if ("min-fresh".equalsIgnoreCase(string6)) {
                    n5 = HeaderParser.parseSeconds(string5, -1);
                    continue;
                }
                if ("only-if-cached".equalsIgnoreCase(string6)) {
                    bl7 = true;
                    continue;
                }
                if (!"no-transform".equalsIgnoreCase(string6)) continue;
                bl8 = true;
            }
        }
        if (!bl9) {
            string2 = null;
        }
        return new CacheControl(bl2, bl3, n2, n3, bl4, bl5, bl6, n4, n5, bl7, bl8, string2);
    }

    public boolean isPrivate() {
        return this.isPrivate;
    }

    public boolean isPublic() {
        return this.isPublic;
    }

    public int maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    public int maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    public int minFreshSeconds() {
        return this.minFreshSeconds;
    }

    public boolean mustRevalidate() {
        return this.mustRevalidate;
    }

    public boolean noCache() {
        return this.noCache;
    }

    public boolean noStore() {
        return this.noStore;
    }

    public boolean noTransform() {
        return this.noTransform;
    }

    public boolean onlyIfCached() {
        return this.onlyIfCached;
    }

    public int sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public String toString() {
        String string2;
        String string3 = this.headerValue;
        if (string3 != null) {
            return string3;
        }
        this.headerValue = string2 = this.headerValue();
        return string2;
    }

    public static final class Builder {
        int maxAgeSeconds = -1;
        int maxStaleSeconds = -1;
        int minFreshSeconds = -1;
        boolean noCache;
        boolean noStore;
        boolean noTransform;
        boolean onlyIfCached;

        public CacheControl build() {
            return new CacheControl(this, null);
        }

        /*
         * Enabled aggressive block sorting
         */
        public Builder maxAge(int n2, TimeUnit timeUnit) {
            if (n2 < 0) {
                throw new IllegalArgumentException("maxAge < 0: " + n2);
            }
            long l2 = timeUnit.toSeconds((long)n2);
            int n3 = l2 > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)l2;
            this.maxAgeSeconds = n3;
            return this;
        }

        /*
         * Enabled aggressive block sorting
         */
        public Builder maxStale(int n2, TimeUnit timeUnit) {
            if (n2 < 0) {
                throw new IllegalArgumentException("maxStale < 0: " + n2);
            }
            long l2 = timeUnit.toSeconds((long)n2);
            int n3 = l2 > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)l2;
            this.maxStaleSeconds = n3;
            return this;
        }

        /*
         * Enabled aggressive block sorting
         */
        public Builder minFresh(int n2, TimeUnit timeUnit) {
            if (n2 < 0) {
                throw new IllegalArgumentException("minFresh < 0: " + n2);
            }
            long l2 = timeUnit.toSeconds((long)n2);
            int n3 = l2 > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)l2;
            this.minFreshSeconds = n3;
            return this;
        }

        public Builder noCache() {
            this.noCache = true;
            return this;
        }

        public Builder noStore() {
            this.noStore = true;
            return this;
        }

        public Builder noTransform() {
            this.noTransform = true;
            return this;
        }

        public Builder onlyIfCached() {
            this.onlyIfCached = true;
            return this;
        }
    }

}

