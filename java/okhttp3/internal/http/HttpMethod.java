/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package okhttp3.internal.http;

public final class HttpMethod {
    private HttpMethod() {
    }

    public static boolean invalidatesCache(String string2) {
        if (string2.equals((Object)"POST") || string2.equals((Object)"PATCH") || string2.equals((Object)"PUT") || string2.equals((Object)"DELETE") || string2.equals((Object)"MOVE")) {
            return true;
        }
        return false;
    }

    public static boolean permitsRequestBody(String string2) {
        if (HttpMethod.requiresRequestBody(string2) || string2.equals((Object)"OPTIONS") || string2.equals((Object)"DELETE") || string2.equals((Object)"PROPFIND") || string2.equals((Object)"MKCOL") || string2.equals((Object)"LOCK")) {
            return true;
        }
        return false;
    }

    public static boolean redirectsToGet(String string2) {
        if (!string2.equals((Object)"PROPFIND")) {
            return true;
        }
        return false;
    }

    public static boolean requiresRequestBody(String string2) {
        if (string2.equals((Object)"POST") || string2.equals((Object)"PUT") || string2.equals((Object)"PATCH") || string2.equals((Object)"PROPPATCH") || string2.equals((Object)"REPORT")) {
            return true;
        }
        return false;
    }
}

