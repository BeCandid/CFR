/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Long
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.List
 *  java.util.Set
 *  java.util.TreeSet
 */
package okhttp3.internal.http;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import okhttp3.Challenge;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Platform;
import okhttp3.internal.Util;
import okhttp3.internal.http.HeaderParser;

public final class OkHeaders {
    static final String PREFIX = Platform.get().getPrefix();
    public static final String RECEIVED_MILLIS;
    public static final String RESPONSE_SOURCE;
    public static final String SELECTED_PROTOCOL;
    public static final String SENT_MILLIS;

    static {
        SENT_MILLIS = PREFIX + "-Sent-Millis";
        RECEIVED_MILLIS = PREFIX + "-Received-Millis";
        SELECTED_PROTOCOL = PREFIX + "-Selected-Protocol";
        RESPONSE_SOURCE = PREFIX + "-Response-Source";
    }

    private OkHeaders() {
    }

    public static long contentLength(Headers headers) {
        return OkHeaders.stringToLong(headers.get("Content-Length"));
    }

    public static long contentLength(Request request) {
        return OkHeaders.contentLength(request.headers());
    }

    public static long contentLength(Response response) {
        return OkHeaders.contentLength(response.headers());
    }

    public static boolean hasVaryAll(Headers headers) {
        return OkHeaders.varyFields(headers).contains((Object)"*");
    }

    public static boolean hasVaryAll(Response response) {
        return OkHeaders.hasVaryAll(response.headers());
    }

    static boolean isEndToEnd(String string2) {
        if (!("Connection".equalsIgnoreCase(string2) || "Keep-Alive".equalsIgnoreCase(string2) || "Proxy-Authenticate".equalsIgnoreCase(string2) || "Proxy-Authorization".equalsIgnoreCase(string2) || "TE".equalsIgnoreCase(string2) || "Trailers".equalsIgnoreCase(string2) || "Transfer-Encoding".equalsIgnoreCase(string2) || "Upgrade".equalsIgnoreCase(string2))) {
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static List<Challenge> parseChallenges(Headers headers, String string2) {
        ArrayList arrayList = new ArrayList();
        int n2 = 0;
        int n3 = headers.size();
        while (n2 < n3) {
            if (string2.equalsIgnoreCase(headers.name(n2))) {
                String string3 = headers.value(n2);
                int n4 = 0;
                while (n4 < string3.length()) {
                    int n5 = n4;
                    int n6 = HeaderParser.skipUntil(string3, n4, " ");
                    String string4 = string3.substring(n5, n6).trim();
                    int n7 = HeaderParser.skipWhitespace(string3, n6);
                    if (!string3.regionMatches(true, n7, "realm=\"", 0, "realm=\"".length())) break;
                    int n8 = n7 + "realm=\"".length();
                    int n9 = HeaderParser.skipUntil(string3, n8, "\"");
                    String string5 = string3.substring(n8, n9);
                    n4 = HeaderParser.skipWhitespace(string3, 1 + HeaderParser.skipUntil(string3, n9 + 1, ","));
                    arrayList.add((Object)new Challenge(string4, string5));
                }
            }
            ++n2;
        }
        return arrayList;
    }

    private static long stringToLong(String string2) {
        if (string2 == null) {
            return -1;
        }
        try {
            long l2 = Long.parseLong((String)string2);
            return l2;
        }
        catch (NumberFormatException var1_2) {
            return -1;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static Set<String> varyFields(Headers headers) {
        Set set = Collections.emptySet();
        int n2 = 0;
        int n3 = headers.size();
        while (n2 < n3) {
            if ("Vary".equalsIgnoreCase(headers.name(n2))) {
                String string2 = headers.value(n2);
                if (set.isEmpty()) {
                    set = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                }
                String[] arrstring = string2.split(",");
                int n4 = arrstring.length;
                for (int i2 = 0; i2 < n4; ++i2) {
                    set.add((Object)arrstring[i2].trim());
                }
            }
            ++n2;
        }
        return set;
    }

    private static Set<String> varyFields(Response response) {
        return OkHeaders.varyFields(response.headers());
    }

    public static Headers varyHeaders(Headers headers, Headers headers2) {
        Set<String> set = OkHeaders.varyFields(headers2);
        if (set.isEmpty()) {
            return new Headers.Builder().build();
        }
        Headers.Builder builder = new Headers.Builder();
        int n2 = headers.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            String string2 = headers.name(i2);
            if (!set.contains((Object)string2)) continue;
            builder.add(string2, headers.value(i2));
        }
        return builder.build();
    }

    public static Headers varyHeaders(Response response) {
        return OkHeaders.varyHeaders(response.networkResponse().request().headers(), response.headers());
    }

    public static boolean varyMatches(Response response, Headers headers, Request request) {
        for (String string2 : OkHeaders.varyFields(response)) {
            if (Util.equal(headers.values(string2), request.headers(string2))) continue;
            return false;
        }
        return true;
    }
}

