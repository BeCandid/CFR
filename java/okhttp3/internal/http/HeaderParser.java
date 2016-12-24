/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Long
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 */
package okhttp3.internal.http;

public final class HeaderParser {
    private HeaderParser() {
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int parseSeconds(String string2, int n2) {
        try {
            long l2 = Long.parseLong((String)string2);
            if (l2 > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (l2 >= 0) return (int)l2;
            return 0;
        }
        catch (NumberFormatException var2_3) {
            return n2;
        }
    }

    public static int skipUntil(String string2, int n2, String string3) {
        while (n2 < string2.length() && string3.indexOf((int)string2.charAt(n2)) == -1) {
            ++n2;
        }
        return n2;
    }

    public static int skipWhitespace(String string2, int n2) {
        char c2;
        while (n2 < string2.length() && ((c2 = string2.charAt(n2)) == ' ' || c2 == '\t')) {
            ++n2;
        }
        return n2;
    }
}

