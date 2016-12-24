/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Integer
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.ProtocolException
 */
package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.Protocol;
import okhttp3.Response;

public final class StatusLine {
    public static final int HTTP_CONTINUE = 100;
    public static final int HTTP_PERM_REDIRECT = 308;
    public static final int HTTP_TEMP_REDIRECT = 307;
    public final int code;
    public final String message;
    public final Protocol protocol;

    public StatusLine(Protocol protocol, int n2, String string2) {
        this.protocol = protocol;
        this.code = n2;
        this.message = string2;
    }

    public static StatusLine get(Response response) {
        return new StatusLine(response.protocol(), response.code(), response.message());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static StatusLine parse(String string2) throws IOException {
        Protocol protocol;
        int n2;
        String string3;
        int n3;
        if (string2.startsWith("HTTP/1.")) {
            if (string2.length() < 9) throw new ProtocolException("Unexpected status line: " + string2);
            if (string2.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + string2);
            }
            int n4 = -48 + string2.charAt(7);
            n3 = 9;
            if (n4 == 0) {
                protocol = Protocol.HTTP_1_0;
            } else {
                if (n4 != 1) throw new ProtocolException("Unexpected status line: " + string2);
                protocol = Protocol.HTTP_1_1;
            }
        } else {
            if (!string2.startsWith("ICY ")) throw new ProtocolException("Unexpected status line: " + string2);
            protocol = Protocol.HTTP_1_0;
            n3 = 4;
        }
        if (string2.length() < n3 + 3) {
            throw new ProtocolException("Unexpected status line: " + string2);
        }
        int n5 = n3 + 3;
        try {
            n2 = Integer.parseInt((String)string2.substring(n3, n5));
            string3 = "";
        }
        catch (NumberFormatException var4_7) {
            throw new ProtocolException("Unexpected status line: " + string2);
        }
        if (string2.length() <= n3 + 3) return new StatusLine(protocol, n2, string3);
        if (string2.charAt(n3 + 3) != ' ') {
            throw new ProtocolException("Unexpected status line: " + string2);
        }
        string3 = string2.substring(n3 + 4);
        return new StatusLine(protocol, n2, string3);
    }

    /*
     * Enabled aggressive block sorting
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.protocol == Protocol.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1";
        stringBuilder.append(string2);
        stringBuilder.append(' ').append(this.code);
        if (this.message != null) {
            stringBuilder.append(' ').append(this.message);
        }
        return stringBuilder.toString();
    }
}

