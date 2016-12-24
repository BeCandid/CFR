/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.NullPointerException
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.Date
 *  java.util.GregorianCalendar
 *  java.util.List
 *  java.util.Locale
 *  java.util.TimeZone
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package okhttp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpDate;

public final class Cookie {
    private static final Pattern DAY_OF_MONTH_PATTERN;
    private static final Pattern MONTH_PATTERN;
    private static final Pattern TIME_PATTERN;
    private static final Pattern YEAR_PATTERN;
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;
    private final String name;
    private final String path;
    private final boolean persistent;
    private final boolean secure;
    private final String value;

    static {
        YEAR_PATTERN = Pattern.compile((String)"(\\d{2,4})[^\\d]*");
        MONTH_PATTERN = Pattern.compile((String)"(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
        DAY_OF_MONTH_PATTERN = Pattern.compile((String)"(\\d{1,2})[^\\d]*");
        TIME_PATTERN = Pattern.compile((String)"(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    }

    private Cookie(String string2, String string3, long l2, String string4, String string5, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        this.name = string2;
        this.value = string3;
        this.expiresAt = l2;
        this.domain = string4;
        this.path = string5;
        this.secure = bl2;
        this.httpOnly = bl3;
        this.hostOnly = bl4;
        this.persistent = bl5;
    }

    private Cookie(Builder builder) {
        if (builder.name == null) {
            throw new IllegalArgumentException("builder.name == null");
        }
        if (builder.value == null) {
            throw new IllegalArgumentException("builder.value == null");
        }
        if (builder.domain == null) {
            throw new IllegalArgumentException("builder.domain == null");
        }
        this.name = builder.name;
        this.value = builder.value;
        this.expiresAt = builder.expiresAt;
        this.domain = builder.domain;
        this.path = builder.path;
        this.secure = builder.secure;
        this.httpOnly = builder.httpOnly;
        this.persistent = builder.persistent;
        this.hostOnly = builder.hostOnly;
    }

    /* synthetic */ Cookie(Builder builder,  var2_2) {
        super(builder);
    }

    /*
     * Enabled aggressive block sorting
     */
    private static int dateCharacterOffset(String string2, int n2, int n3, boolean bl2) {
        int n4 = n2;
        while (n4 < n3) {
            char c2 = string2.charAt(n4);
            boolean bl3 = c2 < ' ' && c2 != '\t' || c2 >= '' || c2 >= '0' && c2 <= '9' || c2 >= 'a' && c2 <= 'z' || c2 >= 'A' && c2 <= 'Z' || c2 == ':';
            if (bl2) return n4;
            boolean bl4 = true;
            if (bl3 == bl4) {
                return n4;
            }
            ++n4;
        }
        return n3;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static boolean domainMatch(HttpUrl httpUrl, String string2) {
        String string3 = httpUrl.host();
        if (string3.equals((Object)string2) || string3.endsWith(string2) && string3.charAt(-1 + (string3.length() - string2.length())) == '.' && !Util.verifyAsIpAddress(string3)) {
            return true;
        }
        return false;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    static Cookie parse(long var0, HttpUrl var2_2, String var3_1) {
        var4_3 = var3_1.length();
        var5_4 = Util.delimiterOffset(var3_1, 0, var4_3, ';');
        var6_5 = Util.delimiterOffset(var3_1, 0, var5_4, '=');
        if (var6_5 == var5_4) {
            return null;
        }
        var7_6 = Util.trimSubstring(var3_1, 0, var6_5);
        if (var7_6.isEmpty()) {
            return null;
        }
        var8_7 = Util.trimSubstring(var3_1, var6_5 + 1, var5_4);
        var9_8 = 253402300799999L;
        var11_9 = -1;
        var13_10 = null;
        var14_11 = null;
        var15_12 = false;
        var16_13 = false;
        var17_14 = true;
        var18_15 = false;
        var19_16 = var5_4 + 1;
        do {
            if (var19_16 < var4_3) {
                var24_25 = Util.delimiterOffset(var3_1, var19_16, var4_3, ';');
                var25_20 = Util.delimiterOffset(var3_1, var19_16, var24_25, '=');
                var26_19 = Util.trimSubstring(var3_1, var19_16, var25_20);
                var27_23 = var25_20 < var24_25 ? Util.trimSubstring(var3_1, var25_20 + 1, var24_25) : "";
                if (var26_19.equalsIgnoreCase("expires")) {
                    var34_24 = var27_23.length();
                    var9_8 = var35_26 = Cookie.parseExpires(var27_23, 0, var34_24);
                    var18_15 = true;
                    ** GOTO lbl75
                } else {
                    if (var26_19.equalsIgnoreCase("max-age")) {
                        var11_9 = var31_27 = Cookie.parseMaxAge(var27_23);
                        var18_15 = true;
                    }
                    if (var26_19.equalsIgnoreCase("domain")) {
                        var13_10 = var29_21 = Cookie.parseDomain(var27_23);
                        var17_14 = false;
                    }
                    if (var26_19.equalsIgnoreCase("path")) {
                        var14_11 = var27_23;
                    } else if (var26_19.equalsIgnoreCase("secure")) {
                        var15_12 = true;
                    } else if (var26_19.equalsIgnoreCase("httponly")) {
                        var16_13 = true;
                    }
                }
            } else {
                if (var11_9 == Long.MIN_VALUE) {
                    var9_8 = Long.MIN_VALUE;
                } else if (var11_9 != -1) {
                    var20_30 = var11_9 <= 9223372036854775L ? var11_9 * 1000 : Long.MAX_VALUE;
                    var9_8 = var0 + var20_30;
                    if (var9_8 < var0 || var9_8 > 253402300799999L) {
                        var9_8 = 253402300799999L;
                    }
                }
                if (var13_10 == null) {
                    var13_10 = var2_2.host();
                } else if (!Cookie.domainMatch(var2_2, var13_10)) {
                    return null;
                }
                if (var14_11 != null) {
                    if (var14_11.startsWith("/") != false) return new Cookie(var7_6, var8_7, var9_8, var13_10, var14_11, var15_12, var16_13, var17_14, var18_15);
                }
                if ((var23_29 = (var22_28 = var2_2.encodedPath()).lastIndexOf(47)) != 0) {
                    var14_11 = var22_28.substring(0, var23_29);
                    return new Cookie(var7_6, var8_7, var9_8, var13_10, var14_11, var15_12, var16_13, var17_14, var18_15);
                }
                var14_11 = "/";
                return new Cookie(var7_6, var8_7, var9_8, var13_10, var14_11, var15_12, var16_13, var17_14, var18_15);
                catch (NumberFormatException var30_22) {}
            }
            ** GOTO lbl75
            catch (IllegalArgumentException var28_18) {}
            ** GOTO lbl75
            catch (IllegalArgumentException var33_17) {}
lbl75: // 9 sources:
            var19_16 = var24_25 + 1;
        } while (true);
    }

    public static Cookie parse(HttpUrl httpUrl, String string2) {
        return Cookie.parse(System.currentTimeMillis(), httpUrl, string2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
        List<String> list = headers.values("Set-Cookie");
        ArrayList arrayList = null;
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            Cookie cookie = Cookie.parse(httpUrl, (String)list.get(i2));
            if (cookie == null) continue;
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add((Object)cookie);
        }
        if (arrayList != null) {
            return Collections.unmodifiableList((List)arrayList);
        }
        return Collections.emptyList();
    }

    private static String parseDomain(String string2) {
        String string3;
        if (string2.endsWith(".")) {
            throw new IllegalArgumentException();
        }
        if (string2.startsWith(".")) {
            string2 = string2.substring(1);
        }
        if ((string3 = Util.domainToAscii(string2)) == null) {
            throw new IllegalArgumentException();
        }
        return string3;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static long parseExpires(String string2, int n2, int n3) {
        int n4 = Cookie.dateCharacterOffset(string2, n2, n3, false);
        int n5 = -1;
        int n6 = -1;
        int n7 = -1;
        int n8 = -1;
        int n9 = -1;
        int n10 = -1;
        Matcher matcher = TIME_PATTERN.matcher((CharSequence)string2);
        while (n4 < n3) {
            int n11 = Cookie.dateCharacterOffset(string2, n4 + 1, n3, true);
            matcher.region(n4, n11);
            if (n5 == -1 && matcher.usePattern(TIME_PATTERN).matches()) {
                n5 = Integer.parseInt((String)matcher.group(1));
                n6 = Integer.parseInt((String)matcher.group(2));
                n7 = Integer.parseInt((String)matcher.group(3));
            } else if (n8 == -1 && matcher.usePattern(DAY_OF_MONTH_PATTERN).matches()) {
                n8 = Integer.parseInt((String)matcher.group(1));
            } else if (n9 == -1 && matcher.usePattern(MONTH_PATTERN).matches()) {
                String string3 = matcher.group(1).toLowerCase(Locale.US);
                n9 = MONTH_PATTERN.pattern().indexOf(string3) / 4;
            } else if (n10 == -1 && matcher.usePattern(YEAR_PATTERN).matches()) {
                n10 = Integer.parseInt((String)matcher.group(1));
            }
            n4 = Cookie.dateCharacterOffset(string2, n11 + 1, n3, false);
        }
        if (n10 >= 70 && n10 <= 99) {
            n10 += 1900;
        }
        if (n10 >= 0 && n10 <= 69) {
            n10 += 2000;
        }
        if (n10 < 1601) {
            throw new IllegalArgumentException();
        }
        if (n9 == -1) {
            throw new IllegalArgumentException();
        }
        if (n8 < 1 || n8 > 31) {
            throw new IllegalArgumentException();
        }
        if (n5 < 0 || n5 > 23) {
            throw new IllegalArgumentException();
        }
        if (n6 < 0 || n6 > 59) {
            throw new IllegalArgumentException();
        }
        if (n7 >= 0 && n7 <= 59) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.UTC);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, n10);
            gregorianCalendar.set(2, n9 - 1);
            gregorianCalendar.set(5, n8);
            gregorianCalendar.set(11, n5);
            gregorianCalendar.set(12, n6);
            gregorianCalendar.set(13, n7);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }
        throw new IllegalArgumentException();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static long parseMaxAge(String string2) {
        long l2 = Long.MIN_VALUE;
        try {
            long l3;
            long l4 = l3 = Long.parseLong((String)string2);
            if (l4 > 0) return l4;
            return l2;
        }
        catch (NumberFormatException var3_4) {
            if (!string2.matches("-?\\d+")) throw var3_4;
            if (!string2.startsWith("-")) return Long.MAX_VALUE;
            return l2;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private static boolean pathMatch(HttpUrl httpUrl, String string2) {
        String string3 = httpUrl.encodedPath();
        if (string3.equals((Object)string2) || string3.startsWith(string2) && (string2.endsWith("/") || string3.charAt(string2.length()) == '/')) {
            return true;
        }
        return false;
    }

    public String domain() {
        return this.domain;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        if (!(object instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie)object;
        if (!cookie.name.equals((Object)this.name)) return false;
        if (!cookie.value.equals((Object)this.value)) return false;
        if (!cookie.domain.equals((Object)this.domain)) return false;
        if (!cookie.path.equals((Object)this.path)) return false;
        if (cookie.expiresAt != this.expiresAt) return false;
        if (cookie.secure != this.secure) return false;
        if (cookie.httpOnly != this.httpOnly) return false;
        if (cookie.persistent != this.persistent) return false;
        if (cookie.hostOnly != this.hostOnly) return false;
        return true;
    }

    public long expiresAt() {
        return this.expiresAt;
    }

    /*
     * Enabled aggressive block sorting
     */
    public int hashCode() {
        int n2 = 31 * (31 * (31 * (31 * (31 * (527 + this.name.hashCode()) + this.value.hashCode()) + this.domain.hashCode()) + this.path.hashCode()) + (int)(this.expiresAt ^ this.expiresAt >>> 32));
        int n3 = this.secure ? 0 : 1;
        int n4 = 31 * (n2 + n3);
        int n5 = this.httpOnly ? 0 : 1;
        int n6 = 31 * (n4 + n5);
        int n7 = this.persistent ? 0 : 1;
        int n8 = 31 * (n6 + n7);
        boolean bl2 = this.hostOnly;
        int n9 = 0;
        if (bl2) {
            return n8 + n9;
        }
        n9 = 1;
        return n8 + n9;
    }

    public boolean hostOnly() {
        return this.hostOnly;
    }

    public boolean httpOnly() {
        return this.httpOnly;
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean matches(HttpUrl httpUrl) {
        boolean bl2 = this.hostOnly ? httpUrl.host().equals((Object)this.domain) : Cookie.domainMatch(httpUrl, this.domain);
        if (!bl2 || !Cookie.pathMatch(httpUrl, this.path) || this.secure && !httpUrl.isHttps()) {
            return false;
        }
        return true;
    }

    public String name() {
        return this.name;
    }

    public String path() {
        return this.path;
    }

    public boolean persistent() {
        return this.persistent;
    }

    public boolean secure() {
        return this.secure;
    }

    /*
     * Enabled aggressive block sorting
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name);
        stringBuilder.append('=');
        stringBuilder.append(this.value);
        if (this.persistent) {
            if (this.expiresAt == Long.MIN_VALUE) {
                stringBuilder.append("; max-age=0");
            } else {
                stringBuilder.append("; expires=").append(HttpDate.format(new Date(this.expiresAt)));
            }
        }
        if (!this.hostOnly) {
            stringBuilder.append("; domain=").append(this.domain);
        }
        stringBuilder.append("; path=").append(this.path);
        if (this.secure) {
            stringBuilder.append("; secure");
        }
        if (this.httpOnly) {
            stringBuilder.append("; httponly");
        }
        return stringBuilder.toString();
    }

    public String value() {
        return this.value;
    }

    public static final class Builder {
        String domain;
        long expiresAt = 253402300799999L;
        boolean hostOnly;
        boolean httpOnly;
        String name;
        String path = "/";
        boolean persistent;
        boolean secure;
        String value;

        private Builder domain(String string2, boolean bl2) {
            if (string2 == null) {
                throw new IllegalArgumentException("domain == null");
            }
            String string3 = Util.domainToAscii(string2);
            if (string3 == null) {
                throw new IllegalArgumentException("unexpected domain: " + string2);
            }
            this.domain = string3;
            this.hostOnly = bl2;
            return this;
        }

        public Cookie build() {
            return new Cookie(this, null);
        }

        public Builder domain(String string2) {
            return super.domain(string2, false);
        }

        public Builder expiresAt(long l2) {
            if (l2 <= 0) {
                l2 = Long.MIN_VALUE;
            }
            if (l2 > 253402300799999L) {
                l2 = 253402300799999L;
            }
            this.expiresAt = l2;
            this.persistent = true;
            return this;
        }

        public Builder hostOnlyDomain(String string2) {
            return super.domain(string2, true);
        }

        public Builder httpOnly() {
            this.httpOnly = true;
            return this;
        }

        public Builder name(String string2) {
            if (string2 == null) {
                throw new NullPointerException("name == null");
            }
            if (!string2.trim().equals((Object)string2)) {
                throw new IllegalArgumentException("name is not trimmed");
            }
            this.name = string2;
            return this;
        }

        public Builder path(String string2) {
            if (!string2.startsWith("/")) {
                throw new IllegalArgumentException("path must start with '/'");
            }
            this.path = string2;
            return this;
        }

        public Builder secure() {
            this.secure = true;
            return this;
        }

        public Builder value(String string2) {
            if (string2 == null) {
                throw new NullPointerException("value == null");
            }
            if (!string2.trim().equals((Object)string2)) {
                throw new IllegalArgumentException("value is not trimmed");
            }
            this.value = string2;
            return this;
        }
    }

}

