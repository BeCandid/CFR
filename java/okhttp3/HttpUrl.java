/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.NoSuchFieldError
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.net.InetAddress
 *  java.net.MalformedURLException
 *  java.net.URI
 *  java.net.URISyntaxException
 *  java.net.URL
 *  java.net.UnknownHostException
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.LinkedHashSet
 *  java.util.List
 *  java.util.Set
 */
package okhttp3;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import okhttp3.internal.Util;
import okio.Buffer;

public final class HttpUrl {
    static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
    static final String FRAGMENT_ENCODE_SET = "";
    static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
    private static final char[] HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
    static final String QUERY_COMPONENT_ENCODE_SET = " \"'<>#&=";
    static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
    static final String QUERY_ENCODE_SET = " \"'<>#";
    static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    private final String fragment;
    private final String host;
    private final String password;
    private final List<String> pathSegments;
    private final int port;
    private final List<String> queryNamesAndValues;
    private final String scheme;
    private final String url;
    private final String username;

    /*
     * Enabled aggressive block sorting
     */
    private HttpUrl(Builder builder) {
        this.scheme = builder.scheme;
        this.username = HttpUrl.percentDecode(builder.encodedUsername, false);
        this.password = HttpUrl.percentDecode(builder.encodedPassword, false);
        this.host = builder.host;
        this.port = builder.effectivePort();
        this.pathSegments = super.percentDecode(builder.encodedPathSegments, false);
        List<String> list = builder.encodedQueryNamesAndValues != null ? super.percentDecode(builder.encodedQueryNamesAndValues, true) : null;
        this.queryNamesAndValues = list;
        String string2 = builder.encodedFragment;
        String string3 = null;
        if (string2 != null) {
            string3 = HttpUrl.percentDecode(builder.encodedFragment, false);
        }
        this.fragment = string3;
        this.url = builder.toString();
    }

    /* synthetic */ HttpUrl(Builder builder,  var2_2) {
        super(builder);
    }

    static /* synthetic */ String access$100(HttpUrl httpUrl) {
        return httpUrl.scheme;
    }

    static /* synthetic */ String access$200(HttpUrl httpUrl) {
        return httpUrl.host;
    }

    static /* synthetic */ int access$300(HttpUrl httpUrl) {
        return httpUrl.port;
    }

    static String canonicalize(String string2, int n2, int n3, String string3, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        int n4;
        for (int i2 = n2; i2 < n3; i2 += Character.charCount((int)n4)) {
            n4 = string2.codePointAt(i2);
            if (!(n4 < 32 || n4 == 127 || n4 >= 128 && bl5 || string3.indexOf(n4) != -1 || n4 == 37 && (!bl2 || bl3 && !HttpUrl.percentEncoded(string2, i2, n3))) && (n4 != 43 || !bl4)) continue;
            Buffer buffer = new Buffer();
            buffer.writeUtf8(string2, n2, i2);
            HttpUrl.canonicalize(buffer, string2, i2, n3, string3, bl2, bl3, bl4, bl5);
            return buffer.readUtf8();
        }
        return string2.substring(n2, n3);
    }

    static String canonicalize(String string2, String string3, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        return HttpUrl.canonicalize(string2, 0, string2.length(), string3, bl2, bl3, bl4, bl5);
    }

    /*
     * Enabled aggressive block sorting
     */
    static void canonicalize(Buffer buffer, String string2, int n2, int n3, String string3, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        Buffer buffer2 = null;
        int n4 = n2;
        while (n4 < n3) {
            int n5 = string2.codePointAt(n4);
            if (!bl2 || n5 != 9 && n5 != 10 && n5 != 12 && n5 != 13) {
                if (n5 == 43 && bl4) {
                    String string4 = bl2 ? "+" : "%2B";
                    buffer.writeUtf8(string4);
                } else if (n5 < 32 || n5 == 127 || n5 >= 128 && bl5 || string3.indexOf(n5) != -1 || n5 == 37 && (!bl2 || bl3 && !HttpUrl.percentEncoded(string2, n4, n3))) {
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    buffer2.writeUtf8CodePoint(n5);
                    while (!buffer2.exhausted()) {
                        int n6 = 255 & buffer2.readByte();
                        buffer.writeByte(37);
                        buffer.writeByte(HEX_DIGITS[15 & n6 >> 4]);
                        buffer.writeByte(HEX_DIGITS[n6 & 15]);
                    }
                } else {
                    buffer.writeUtf8CodePoint(n5);
                }
            }
            n4 += Character.charCount((int)n5);
        }
        return;
    }

    static int decodeHexDigit(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - 48;
        }
        if (c2 >= 'a' && c2 <= 'f') {
            return 10 + (c2 - 97);
        }
        if (c2 >= 'A' && c2 <= 'F') {
            return 10 + (c2 - 65);
        }
        return -1;
    }

    public static int defaultPort(String string2) {
        if (string2.equals((Object)"http")) {
            return 80;
        }
        if (string2.equals((Object)"https")) {
            return 443;
        }
        return -1;
    }

    public static HttpUrl get(URI uRI) {
        return HttpUrl.parse(uRI.toString());
    }

    public static HttpUrl get(URL uRL) {
        return HttpUrl.parse(uRL.toString());
    }

    static HttpUrl getChecked(String string2) throws MalformedURLException, UnknownHostException {
        Builder builder = new Builder();
        Builder.ParseResult parseResult = builder.parse(null, string2);
        switch (.$SwitchMap$okhttp3$HttpUrl$Builder$ParseResult[parseResult.ordinal()]) {
            default: {
                throw new MalformedURLException("Invalid URL: " + (Object)((Object)parseResult) + " for " + string2);
            }
            case 1: {
                return builder.build();
            }
            case 2: 
        }
        throw new UnknownHostException("Invalid host: " + string2);
    }

    static void namesAndValuesToQueryString(StringBuilder stringBuilder, List<String> list) {
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; i2 += 2) {
            String string2 = (String)list.get(i2);
            String string3 = (String)list.get(i2 + 1);
            if (i2 > 0) {
                stringBuilder.append('&');
            }
            stringBuilder.append(string2);
            if (string3 == null) continue;
            stringBuilder.append('=');
            stringBuilder.append(string3);
        }
    }

    public static HttpUrl parse(String string2) {
        Builder builder = new Builder();
        Builder.ParseResult parseResult = builder.parse(null, string2);
        Builder.ParseResult parseResult2 = Builder.ParseResult.SUCCESS;
        HttpUrl httpUrl = null;
        if (parseResult == parseResult2) {
            httpUrl = builder.build();
        }
        return httpUrl;
    }

    static void pathSegmentsToString(StringBuilder stringBuilder, List<String> list) {
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            stringBuilder.append('/');
            stringBuilder.append((String)list.get(i2));
        }
    }

    static String percentDecode(String string2, int n2, int n3, boolean bl2) {
        for (int i2 = n2; i2 < n3; ++i2) {
            char c2 = string2.charAt(i2);
            if (c2 != '%' && (c2 != '+' || !bl2)) continue;
            Buffer buffer = new Buffer();
            buffer.writeUtf8(string2, n2, i2);
            HttpUrl.percentDecode(buffer, string2, i2, n3, bl2);
            return buffer.readUtf8();
        }
        return string2.substring(n2, n3);
    }

    static String percentDecode(String string2, boolean bl2) {
        return HttpUrl.percentDecode(string2, 0, string2.length(), bl2);
    }

    /*
     * Enabled aggressive block sorting
     */
    private List<String> percentDecode(List<String> list, boolean bl2) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            String string2 = (String)iterator.next();
            String string3 = string2 != null ? HttpUrl.percentDecode(string2, bl2) : null;
            arrayList.add((Object)string3);
        }
        return Collections.unmodifiableList((List)arrayList);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    static void percentDecode(Buffer var0_2, String var1_1, int var2_4, int var3_3, boolean var4) {
        var5_5 = var2_4;
        while (var5_5 < var3_3) {
            var6_8 = var1_1.codePointAt(var5_5);
            if (var6_8 != 37 || var5_5 + 2 >= var3_3) ** GOTO lbl11
            var9_6 = HttpUrl.decodeHexDigit(var1_1.charAt(var5_5 + 1));
            var10_7 = HttpUrl.decodeHexDigit(var1_1.charAt(var5_5 + 2));
            if (var9_6 == -1 || var10_7 == -1) ** GOTO lbl-1000
            var0_2.writeByte(var10_7 + (var9_6 << 4));
            var5_5 += 2;
            ** GOTO lbl15
lbl11: // 1 sources:
            if (var6_8 == 43 && var4) {
                var0_2.writeByte(32);
            } else lbl-1000: // 2 sources:
            {
                var0_2.writeUtf8CodePoint(var6_8);
            }
lbl15: // 3 sources:
            var5_5 += Character.charCount((int)var6_8);
        }
    }

    static boolean percentEncoded(String string2, int n2, int n3) {
        if (n2 + 2 < n3 && string2.charAt(n2) == '%' && HttpUrl.decodeHexDigit(string2.charAt(n2 + 1)) != -1 && HttpUrl.decodeHexDigit(string2.charAt(n2 + 2)) != -1) {
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    static List<String> queryStringToNamesAndValues(String string2) {
        ArrayList arrayList = new ArrayList();
        int n2 = 0;
        while (n2 <= string2.length()) {
            int n3;
            int n4 = string2.indexOf(38, n2);
            if (n4 == -1) {
                n4 = string2.length();
            }
            if ((n3 = string2.indexOf(61, n2)) == -1 || n3 > n4) {
                arrayList.add((Object)string2.substring(n2, n4));
                arrayList.add((Object)null);
            } else {
                arrayList.add((Object)string2.substring(n2, n3));
                arrayList.add((Object)string2.substring(n3 + 1, n4));
            }
            n2 = n4 + 1;
        }
        return arrayList;
    }

    public String encodedFragment() {
        if (this.fragment == null) {
            return null;
        }
        int n2 = 1 + this.url.indexOf(35);
        return this.url.substring(n2);
    }

    public String encodedPassword() {
        if (this.password.isEmpty()) {
            return "";
        }
        int n2 = 1 + this.url.indexOf(58, 3 + this.scheme.length());
        int n3 = this.url.indexOf(64);
        return this.url.substring(n2, n3);
    }

    public String encodedPath() {
        int n2 = this.url.indexOf(47, 3 + this.scheme.length());
        int n3 = Util.delimiterOffset(this.url, n2, this.url.length(), "?#");
        return this.url.substring(n2, n3);
    }

    public List<String> encodedPathSegments() {
        int n2 = this.url.indexOf(47, 3 + this.scheme.length());
        int n3 = Util.delimiterOffset(this.url, n2, this.url.length(), "?#");
        ArrayList arrayList = new ArrayList();
        int n4 = n2;
        while (n4 < n3) {
            int n5 = n4 + 1;
            int n6 = Util.delimiterOffset(this.url, n5, n3, '/');
            arrayList.add((Object)this.url.substring(n5, n6));
            n4 = n6;
        }
        return arrayList;
    }

    public String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int n2 = 1 + this.url.indexOf(63);
        int n3 = Util.delimiterOffset(this.url, n2 + 1, this.url.length(), '#');
        return this.url.substring(n2, n3);
    }

    public String encodedUsername() {
        if (this.username.isEmpty()) {
            return "";
        }
        int n2 = 3 + this.scheme.length();
        int n3 = Util.delimiterOffset(this.url, n2, this.url.length(), ":@");
        return this.url.substring(n2, n3);
    }

    public boolean equals(Object object) {
        if (object instanceof HttpUrl && ((HttpUrl)object).url.equals((Object)this.url)) {
            return true;
        }
        return false;
    }

    public String fragment() {
        return this.fragment;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public String host() {
        return this.host;
    }

    public boolean isHttps() {
        return this.scheme.equals((Object)"https");
    }

    /*
     * Enabled aggressive block sorting
     */
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.scheme = this.scheme;
        builder.encodedUsername = this.encodedUsername();
        builder.encodedPassword = this.encodedPassword();
        builder.host = this.host;
        int n2 = this.port != HttpUrl.defaultPort(this.scheme) ? this.port : -1;
        builder.port = n2;
        builder.encodedPathSegments.clear();
        builder.encodedPathSegments.addAll(this.encodedPathSegments());
        builder.encodedQuery(this.encodedQuery());
        builder.encodedFragment = this.encodedFragment();
        return builder;
    }

    public Builder newBuilder(String string2) {
        Builder builder = new Builder();
        if (builder.parse((HttpUrl)this, string2) == Builder.ParseResult.SUCCESS) {
            return builder;
        }
        return null;
    }

    public String password() {
        return this.password;
    }

    public List<String> pathSegments() {
        return this.pathSegments;
    }

    public int pathSize() {
        return this.pathSegments.size();
    }

    public int port() {
        return this.port;
    }

    public String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        HttpUrl.namesAndValuesToQueryString(stringBuilder, this.queryNamesAndValues);
        return stringBuilder.toString();
    }

    /*
     * Enabled aggressive block sorting
     */
    public String queryParameter(String string2) {
        if (this.queryNamesAndValues != null) {
            int n2 = this.queryNamesAndValues.size();
            for (int i2 = 0; i2 < n2; i2 += 2) {
                if (!string2.equals(this.queryNamesAndValues.get(i2))) continue;
                return (String)this.queryNamesAndValues.get(i2 + 1);
            }
        }
        return null;
    }

    public String queryParameterName(int n2) {
        return (String)this.queryNamesAndValues.get(n2 * 2);
    }

    public Set<String> queryParameterNames() {
        if (this.queryNamesAndValues == null) {
            return Collections.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int n2 = this.queryNamesAndValues.size();
        for (int i2 = 0; i2 < n2; i2 += 2) {
            linkedHashSet.add(this.queryNamesAndValues.get(i2));
        }
        return Collections.unmodifiableSet((Set)linkedHashSet);
    }

    public String queryParameterValue(int n2) {
        return (String)this.queryNamesAndValues.get(1 + n2 * 2);
    }

    public List<String> queryParameterValues(String string2) {
        if (this.queryNamesAndValues == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int n2 = this.queryNamesAndValues.size();
        for (int i2 = 0; i2 < n2; i2 += 2) {
            if (!string2.equals(this.queryNamesAndValues.get(i2))) continue;
            arrayList.add(this.queryNamesAndValues.get(i2 + 1));
        }
        return Collections.unmodifiableList((List)arrayList);
    }

    public int querySize() {
        if (this.queryNamesAndValues != null) {
            return this.queryNamesAndValues.size() / 2;
        }
        return 0;
    }

    public HttpUrl resolve(String string2) {
        Builder builder = this.newBuilder(string2);
        if (builder != null) {
            return builder.build();
        }
        return null;
    }

    public String scheme() {
        return this.scheme;
    }

    public String toString() {
        return this.url;
    }

    public URI uri() {
        String string2 = this.newBuilder().reencodeForUri().toString();
        try {
            URI uRI = new URI(string2);
            return uRI;
        }
        catch (URISyntaxException var3_3) {
            try {
                URI uRI = URI.create((String)string2.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
                return uRI;
            }
            catch (Exception var4_5) {
                throw new RuntimeException((Throwable)var3_3);
            }
        }
    }

    public URL url() {
        try {
            URL uRL = new URL(this.url);
            return uRL;
        }
        catch (MalformedURLException var2_2) {
            throw new RuntimeException((Throwable)var2_2);
        }
    }

    public String username() {
        return this.username;
    }

    public static final class Builder {
        String encodedFragment;
        String encodedPassword = "";
        final List<String> encodedPathSegments = new ArrayList();
        List<String> encodedQueryNamesAndValues;
        String encodedUsername = "";
        String host;
        int port = -1;
        String scheme;

        public Builder() {
            this.encodedPathSegments.add((Object)"");
        }

        /*
         * Enabled aggressive block sorting
         */
        private Builder addPathSegments(String string2, boolean bl2) {
            int n2;
            int n3 = 0;
            do {
                boolean bl3 = (n2 = Util.delimiterOffset(string2, n3, string2.length(), "/\\")) < string2.length();
                super.push(string2, n3, n2, bl3, bl2);
            } while ((n3 = n2 + 1) <= string2.length());
            return this;
        }

        /*
         * Enabled aggressive block sorting
         */
        private static String canonicalizeHost(String string2, int n2, int n3) {
            String string3 = HttpUrl.percentDecode(string2, n2, n3, false);
            if (!string3.contains((CharSequence)":")) {
                return Util.domainToAscii(string3);
            }
            InetAddress inetAddress = string3.startsWith("[") && string3.endsWith("]") ? Builder.decodeIpv6(string3, 1, -1 + string3.length()) : Builder.decodeIpv6(string3, 0, string3.length());
            if (inetAddress == null) {
                return null;
            }
            byte[] arrby = inetAddress.getAddress();
            if (arrby.length == 16) {
                return Builder.inet6AddressToAscii(arrby);
            }
            throw new AssertionError();
        }

        /*
         * Enabled aggressive block sorting
         */
        private static boolean decodeIpv4Suffix(String string2, int n2, int n3, byte[] arrby, int n4) {
            int n5 = n2;
            int n6 = n4;
            block0 : do {
                if (n5 < n3) {
                    if (n6 == arrby.length) break;
                    if (n6 != n4) {
                        if (string2.charAt(n5) != '.') break;
                        ++n5;
                    }
                } else {
                    if (n6 != n4 + 4) break;
                    return true;
                }
                int n7 = 0;
                int n8 = n5;
                do {
                    char c2;
                    if (n5 >= n3 || (c2 = string2.charAt(n5)) < '0' || c2 > '9') {
                        if (n5 - n8 == 0) break block0;
                        int n9 = n6 + 1;
                        arrby[n6] = n7;
                        n6 = n9;
                        continue block0;
                    }
                    if (n7 == 0 && n8 != n5 || (n7 = -48 + (c2 + n7 * 10)) > 255) break block0;
                    ++n5;
                } while (true);
                break;
            } while (true);
            return false;
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Lifted jumps to return sites
         */
        private static InetAddress decodeIpv6(String var0_1, int var1, int var2_2) {
            var3_3 = new byte[16];
            var4_4 = 0;
            var5_5 = -1;
            var6_6 = -1;
            var7_7 = var1;
            do {
                if (var7_7 >= var2_2) ** GOTO lbl24
                if (var4_4 == var3_3.length) {
                    return null;
                }
                if (var7_7 + 2 > var2_2 || !var0_1.regionMatches(var7_7, "::", 0, 2)) ** GOTO lbl16
                if (var5_5 != -1) {
                    return null;
                }
                var5_5 = var4_4 += 2;
                if ((var7_7 += 2) != var2_2) ** GOTO lbl33
                ** GOTO lbl24
lbl16: // 1 sources:
                if (var4_4 != 0) {
                    if (var0_1.regionMatches(var7_7, ":", 0, 1)) {
                        ++var7_7;
                    } else {
                        if (var0_1.regionMatches(var7_7, ".", 0, 1) == false) return null;
                        if (!Builder.decodeIpv4Suffix(var0_1, var6_6, var2_2, var3_3, var4_4 - 2)) {
                            return null;
                        }
                        var4_4 += 2;
lbl24: // 3 sources:
                        if (var4_4 != var3_3.length) {
                            if (var5_5 == -1) {
                                return null;
                            }
                            System.arraycopy((Object)var3_3, (int)var5_5, (Object)var3_3, (int)(var3_3.length - (var4_4 - var5_5)), (int)(var4_4 - var5_5));
                            Arrays.fill((byte[])var3_3, (int)var5_5, (int)(var5_5 + (var3_3.length - var4_4)), (byte)0);
                        }
                        try {
                            return InetAddress.getByAddress((byte[])var3_3);
                        }
                        catch (UnknownHostException var8_13) {
                            throw new AssertionError();
                        }
                    }
                }
lbl33: // 4 sources:
                var10_11 = 0;
                var6_6 = var7_7;
                do {
                    if (var7_7 >= var2_2 || (var13_9 = HttpUrl.decodeHexDigit(var0_1.charAt(var7_7))) == -1) {
                        var11_8 = var7_7 - var6_6;
                        if (var11_8 == 0) return null;
                        if (var11_8 <= 4) break;
                        return null;
                    }
                    var10_11 = var13_9 + (var10_11 << 4);
                    ++var7_7;
                } while (true);
                var12_10 = var4_4 + 1;
                var3_3[var4_4] = (byte)(255 & var10_11 >>> 8);
                var4_4 = var12_10 + 1;
                var3_3[var12_10] = (byte)(var10_11 & 255);
            } while (true);
        }

        private static String inet6AddressToAscii(byte[] arrby) {
            int n2 = -1;
            int n3 = 0;
            for (int i2 = 0; i2 < arrby.length; i2 += 2) {
                int n4 = i2;
                while (i2 < 16 && arrby[i2] == 0 && arrby[i2 + 1] == 0) {
                    i2 += 2;
                }
                int n5 = i2 - n4;
                if (n5 <= n3) continue;
                n2 = n4;
                n3 = n5;
            }
            Buffer buffer = new Buffer();
            int n6 = 0;
            while (n6 < arrby.length) {
                if (n6 == n2) {
                    buffer.writeByte(58);
                    if ((n6 += n3) != 16) continue;
                    buffer.writeByte(58);
                    continue;
                }
                if (n6 > 0) {
                    buffer.writeByte(58);
                }
                buffer.writeHexadecimalUnsignedLong((255 & arrby[n6]) << 8 | 255 & arrby[n6 + 1]);
                n6 += 2;
            }
            return buffer.readUtf8();
        }

        private boolean isDot(String string2) {
            if (string2.equals((Object)".") || string2.equalsIgnoreCase("%2e")) {
                return true;
            }
            return false;
        }

        private boolean isDotDot(String string2) {
            if (string2.equals((Object)"..") || string2.equalsIgnoreCase("%2e.") || string2.equalsIgnoreCase(".%2e") || string2.equalsIgnoreCase("%2e%2e")) {
                return true;
            }
            return false;
        }

        private static int parsePort(String string2, int n2, int n3) {
            try {
                int n4 = Integer.parseInt((String)HttpUrl.canonicalize(string2, n2, n3, "", false, false, false, true));
                if (n4 > 0 && n4 <= 65535) {
                    return n4;
                }
                return -1;
            }
            catch (NumberFormatException var3_4) {
                return -1;
            }
        }

        private void pop() {
            if (((String)this.encodedPathSegments.remove(-1 + this.encodedPathSegments.size())).isEmpty() && !this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.set(-1 + this.encodedPathSegments.size(), (Object)"");
                return;
            }
            this.encodedPathSegments.add((Object)"");
        }

        /*
         * Exception decompiling
         */
        private static int portColonOffset(String var0_1, int var1, int var2_2) {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Extractable last case doesn't follow previous
            // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.examineSwitchContiguity(SwitchReplacer.java:486)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.replaceRawSwitches(SwitchReplacer.java:65)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:422)
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

        /*
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        private void push(String string2, int n2, int n3, boolean bl2, boolean bl3) {
            String string3 = HttpUrl.canonicalize(string2, n2, n3, " \"<>^`{}|/\\?#", bl3, false, false, true);
            if (this.isDot(string3)) {
                return;
            }
            if (this.isDotDot(string3)) {
                this.pop();
                return;
            }
            if (((String)this.encodedPathSegments.get(-1 + this.encodedPathSegments.size())).isEmpty()) {
                this.encodedPathSegments.set(-1 + this.encodedPathSegments.size(), (Object)string3);
            } else {
                this.encodedPathSegments.add((Object)string3);
            }
            if (!bl2) return;
            this.encodedPathSegments.add((Object)"");
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        private void removeAllCanonicalQueryParameters(String string2) {
            int n2 = -2 + this.encodedQueryNamesAndValues.size();
            while (n2 >= 0) {
                if (string2.equals(this.encodedQueryNamesAndValues.get(n2))) {
                    this.encodedQueryNamesAndValues.remove(n2 + 1);
                    this.encodedQueryNamesAndValues.remove(n2);
                    if (this.encodedQueryNamesAndValues.isEmpty()) {
                        this.encodedQueryNamesAndValues = null;
                        return;
                    }
                }
                n2 -= 2;
            }
        }

        /*
         * Enabled aggressive block sorting
         */
        private void resolvePath(String string2, int n2, int n3) {
            if (n2 != n3) {
                char c2 = string2.charAt(n2);
                if (c2 == '/' || c2 == '\\') {
                    this.encodedPathSegments.clear();
                    this.encodedPathSegments.add((Object)"");
                    ++n2;
                } else {
                    this.encodedPathSegments.set(-1 + this.encodedPathSegments.size(), (Object)"");
                }
                int n4 = n2;
                while (n4 < n3) {
                    int n5 = Util.delimiterOffset(string2, n4, n3, "/\\");
                    boolean bl2 = n5 < n3;
                    super.push(string2, n4, n5, bl2, true);
                    n4 = n5;
                    if (!bl2) continue;
                    ++n4;
                }
            }
        }

        /*
         * Enabled aggressive block sorting
         */
        private static int schemeDelimiterOffset(String string2, int n2, int n3) {
            char c2;
            if (n3 - n2 < 2) {
                return -1;
            }
            char c3 = string2.charAt(n2);
            if (c3 < 'a' || c3 > 'z') {
                if (c3 < 'A') return -1;
                if (c3 > 'Z') {
                    return -1;
                }
            }
            int n4 = n2 + 1;
            do {
                if (n4 >= n3) {
                    return -1;
                }
                c2 = string2.charAt(n4);
                if (!(c2 >= 'a' && c2 <= 'z' || c2 >= 'A' && c2 <= 'Z' || c2 >= '0' && c2 <= '9' || c2 == '+' || c2 == '-') && c2 != '.') break;
                ++n4;
            } while (true);
            if (c2 == ':') return n4;
            return -1;
        }

        private static int slashCount(String string2, int n2, int n3) {
            char c2;
            int n4 = 0;
            while (n2 < n3 && ((c2 = string2.charAt(n2)) == '\\' || c2 == '/')) {
                ++n4;
                ++n2;
            }
            return n4;
        }

        public Builder addEncodedPathSegment(String string2) {
            if (string2 == null) {
                throw new IllegalArgumentException("encodedPathSegment == null");
            }
            super.push(string2, 0, string2.length(), false, true);
            return this;
        }

        public Builder addEncodedPathSegments(String string2) {
            if (string2 == null) {
                throw new IllegalArgumentException("encodedPathSegments == null");
            }
            return super.addPathSegments(string2, true);
        }

        /*
         * Enabled aggressive block sorting
         */
        public Builder addEncodedQueryParameter(String string2, String string3) {
            if (string2 == null) {
                throw new IllegalArgumentException("encodedName == null");
            }
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            this.encodedQueryNamesAndValues.add((Object)HttpUrl.canonicalize(string2, " \"'<>#&=", true, false, true, true));
            List<String> list = this.encodedQueryNamesAndValues;
            String string4 = string3 != null ? HttpUrl.canonicalize(string3, " \"'<>#&=", true, false, true, true) : null;
            list.add((Object)string4);
            return this;
        }

        public Builder addPathSegment(String string2) {
            if (string2 == null) {
                throw new IllegalArgumentException("pathSegment == null");
            }
            super.push(string2, 0, string2.length(), false, false);
            return this;
        }

        public Builder addPathSegments(String string2) {
            if (string2 == null) {
                throw new IllegalArgumentException("pathSegments == null");
            }
            return super.addPathSegments(string2, false);
        }

        /*
         * Enabled aggressive block sorting
         */
        public Builder addQueryParameter(String string2, String string3) {
            if (string2 == null) {
                throw new IllegalArgumentException("name == null");
            }
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            this.encodedQueryNamesAndValues.add((Object)HttpUrl.canonicalize(string2, " \"'<>#&=", false, false, true, true));
            List<String> list = this.encodedQueryNamesAndValues;
            String string4 = string3 != null ? HttpUrl.canonicalize(string3, " \"'<>#&=", false, false, true, true) : null;
            list.add((Object)string4);
            return this;
        }

        public HttpUrl build() {
            if (this.scheme == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.host == null) {
                throw new IllegalStateException("host == null");
            }
            return new HttpUrl(this, null);
        }

        int effectivePort() {
            if (this.port != -1) {
                return this.port;
            }
            return HttpUrl.defaultPort(this.scheme);
        }

        /*
         * Enabled aggressive block sorting
         */
        public Builder encodedFragment(String string2) {
            String string3 = string2 != null ? HttpUrl.canonicalize(string2, "", true, false, false, false) : null;
            this.encodedFragment = string3;
            return this;
        }

        public Builder encodedPassword(String string2) {
            if (string2 == null) {
                throw new IllegalArgumentException("encodedPassword == null");
            }
            this.encodedPassword = HttpUrl.canonicalize(string2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
            return this;
        }

        public Builder encodedPath(String string2) {
            if (string2 == null) {
                throw new IllegalArgumentException("encodedPath == null");
            }
            if (!string2.startsWith("/")) {
                throw new IllegalArgumentException("unexpected encodedPath: " + string2);
            }
            super.resolvePath(string2, 0, string2.length());
            return this;
        }

        /*
         * Enabled aggressive block sorting
         */
        public Builder encodedQuery(String string2) {
            List<String> list = string2 != null ? HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(string2, " \"'<>#", true, false, true, true)) : null;
            this.encodedQueryNamesAndValues = list;
            return this;
        }

        public Builder encodedUsername(String string2) {
            if (string2 == null) {
                throw new IllegalArgumentException("encodedUsername == null");
            }
            this.encodedUsername = HttpUrl.canonicalize(string2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
            return this;
        }

        /*
         * Enabled aggressive block sorting
         */
        public Builder fragment(String string2) {
            String string3 = string2 != null ? HttpUrl.canonicalize(string2, "", false, false, false, false) : null;
            this.encodedFragment = string3;
            return this;
        }

        public Builder host(String string2) {
            if (string2 == null) {
                throw new IllegalArgumentException("host == null");
            }
            String string3 = Builder.canonicalizeHost(string2, 0, string2.length());
            if (string3 == null) {
                throw new IllegalArgumentException("unexpected host: " + string2);
            }
            this.host = string3;
            return this;
        }

        /*
         * Exception decompiling
         */
        ParseResult parse(HttpUrl var1, String var2_2) {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // java.util.ConcurrentModificationException
            // java.util.LinkedList$ReverseLinkIterator.next(LinkedList.java:217)
            // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.extractLabelledBlocks(Block.java:212)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:485)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
            // org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredIf.transformStructuredChildren(StructuredIf.java:83)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:487)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
            // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.transformStructuredChildren(Block.java:378)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:487)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.insertLabelledBlocks(Op04StructuredStatement.java:649)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:816)
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

        public Builder password(String string2) {
            if (string2 == null) {
                throw new IllegalArgumentException("password == null");
            }
            this.encodedPassword = HttpUrl.canonicalize(string2, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public Builder port(int n2) {
            if (n2 <= 0 || n2 > 65535) {
                throw new IllegalArgumentException("unexpected port: " + n2);
            }
            this.port = n2;
            return this;
        }

        /*
         * Enabled aggressive block sorting
         */
        public Builder query(String string2) {
            List<String> list = string2 != null ? HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(string2, " \"'<>#", false, false, true, true)) : null;
            this.encodedQueryNamesAndValues = list;
            return this;
        }

        Builder reencodeForUri() {
            int n2 = this.encodedPathSegments.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                String string2 = (String)this.encodedPathSegments.get(i2);
                this.encodedPathSegments.set(i2, (Object)HttpUrl.canonicalize(string2, "[]", true, true, false, true));
            }
            if (this.encodedQueryNamesAndValues != null) {
                int n3 = this.encodedQueryNamesAndValues.size();
                for (int i3 = 0; i3 < n3; ++i3) {
                    String string3 = (String)this.encodedQueryNamesAndValues.get(i3);
                    if (string3 == null) continue;
                    this.encodedQueryNamesAndValues.set(i3, (Object)HttpUrl.canonicalize(string3, "\\^`{|}", true, true, true, true));
                }
            }
            if (this.encodedFragment != null) {
                this.encodedFragment = HttpUrl.canonicalize(this.encodedFragment, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public Builder removeAllEncodedQueryParameters(String string2) {
            if (string2 == null) {
                throw new IllegalArgumentException("encodedName == null");
            }
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            super.removeAllCanonicalQueryParameters(HttpUrl.canonicalize(string2, " \"'<>#&=", true, false, true, true));
            return this;
        }

        public Builder removeAllQueryParameters(String string2) {
            if (string2 == null) {
                throw new IllegalArgumentException("name == null");
            }
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            super.removeAllCanonicalQueryParameters(HttpUrl.canonicalize(string2, " \"'<>#&=", false, false, true, true));
            return this;
        }

        public Builder removePathSegment(int n2) {
            this.encodedPathSegments.remove(n2);
            if (this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add((Object)"");
            }
            return this;
        }

        public Builder scheme(String string2) {
            if (string2 == null) {
                throw new IllegalArgumentException("scheme == null");
            }
            if (string2.equalsIgnoreCase("http")) {
                this.scheme = "http";
                return this;
            }
            if (string2.equalsIgnoreCase("https")) {
                this.scheme = "https";
                return this;
            }
            throw new IllegalArgumentException("unexpected scheme: " + string2);
        }

        public Builder setEncodedPathSegment(int n2, String string2) {
            if (string2 == null) {
                throw new IllegalArgumentException("encodedPathSegment == null");
            }
            String string3 = HttpUrl.canonicalize(string2, 0, string2.length(), " \"<>^`{}|/\\?#", true, false, false, true);
            this.encodedPathSegments.set(n2, (Object)string3);
            if (super.isDot(string3) || super.isDotDot(string3)) {
                throw new IllegalArgumentException("unexpected path segment: " + string2);
            }
            return this;
        }

        public Builder setEncodedQueryParameter(String string2, String string3) {
            this.removeAllEncodedQueryParameters(string2);
            this.addEncodedQueryParameter(string2, string3);
            return this;
        }

        public Builder setPathSegment(int n2, String string2) {
            if (string2 == null) {
                throw new IllegalArgumentException("pathSegment == null");
            }
            String string3 = HttpUrl.canonicalize(string2, 0, string2.length(), " \"<>^`{}|/\\?#", false, false, false, true);
            if (super.isDot(string3) || super.isDotDot(string3)) {
                throw new IllegalArgumentException("unexpected path segment: " + string2);
            }
            this.encodedPathSegments.set(n2, (Object)string3);
            return this;
        }

        public Builder setQueryParameter(String string2, String string3) {
            this.removeAllQueryParameters(string2);
            this.addQueryParameter(string2, string3);
            return this;
        }

        /*
         * Enabled aggressive block sorting
         */
        public String toString() {
            int n2;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.scheme);
            stringBuilder.append("://");
            if (!this.encodedUsername.isEmpty() || !this.encodedPassword.isEmpty()) {
                stringBuilder.append(this.encodedUsername);
                if (!this.encodedPassword.isEmpty()) {
                    stringBuilder.append(':');
                    stringBuilder.append(this.encodedPassword);
                }
                stringBuilder.append('@');
            }
            if (this.host.indexOf(58) != -1) {
                stringBuilder.append('[');
                stringBuilder.append(this.host);
                stringBuilder.append(']');
            } else {
                stringBuilder.append(this.host);
            }
            if ((n2 = this.effectivePort()) != HttpUrl.defaultPort(this.scheme)) {
                stringBuilder.append(':');
                stringBuilder.append(n2);
            }
            HttpUrl.pathSegmentsToString(stringBuilder, this.encodedPathSegments);
            if (this.encodedQueryNamesAndValues != null) {
                stringBuilder.append('?');
                HttpUrl.namesAndValuesToQueryString(stringBuilder, this.encodedQueryNamesAndValues);
            }
            if (this.encodedFragment != null) {
                stringBuilder.append('#');
                stringBuilder.append(this.encodedFragment);
            }
            return stringBuilder.toString();
        }

        public Builder username(String string2) {
            if (string2 == null) {
                throw new IllegalArgumentException("username == null");
            }
            this.encodedUsername = HttpUrl.canonicalize(string2, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        static final class ParseResult
        extends Enum<ParseResult> {
            private static final /* synthetic */ ParseResult[] $VALUES;
            public static final /* enum */ ParseResult INVALID_HOST;
            public static final /* enum */ ParseResult INVALID_PORT;
            public static final /* enum */ ParseResult MISSING_SCHEME;
            public static final /* enum */ ParseResult SUCCESS;
            public static final /* enum */ ParseResult UNSUPPORTED_SCHEME;

            static {
                SUCCESS = new ParseResult();
                MISSING_SCHEME = new ParseResult();
                UNSUPPORTED_SCHEME = new ParseResult();
                INVALID_PORT = new ParseResult();
                INVALID_HOST = new ParseResult();
                ParseResult[] arrparseResult = new ParseResult[]{SUCCESS, MISSING_SCHEME, UNSUPPORTED_SCHEME, INVALID_PORT, INVALID_HOST};
                $VALUES = arrparseResult;
            }

            private ParseResult() {
                super(string2, n2);
            }

            public static ParseResult valueOf(String string2) {
                return (ParseResult)Enum.valueOf((Class)ParseResult.class, (String)string2);
            }

            public static ParseResult[] values() {
                return (ParseResult[])$VALUES.clone();
            }
        }

    }

}

