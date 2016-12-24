/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package okhttp3;

import java.io.IOException;

public final class Protocol
extends Enum<Protocol> {
    private static final /* synthetic */ Protocol[] $VALUES;
    public static final /* enum */ Protocol HTTP_1_0 = new Protocol("http/1.0");
    public static final /* enum */ Protocol HTTP_1_1 = new Protocol("http/1.1");
    public static final /* enum */ Protocol HTTP_2;
    public static final /* enum */ Protocol SPDY_3;
    private final String protocol;

    static {
        SPDY_3 = new Protocol("spdy/3.1");
        HTTP_2 = new Protocol("h2");
        Protocol[] arrprotocol = new Protocol[]{HTTP_1_0, HTTP_1_1, SPDY_3, HTTP_2};
        $VALUES = arrprotocol;
    }

    private Protocol(String string3) {
        super(string2, n2);
        this.protocol = string3;
    }

    public static Protocol get(String string2) throws IOException {
        if (string2.equals((Object)Protocol.HTTP_1_0.protocol)) {
            return HTTP_1_0;
        }
        if (string2.equals((Object)Protocol.HTTP_1_1.protocol)) {
            return HTTP_1_1;
        }
        if (string2.equals((Object)Protocol.HTTP_2.protocol)) {
            return HTTP_2;
        }
        if (string2.equals((Object)Protocol.SPDY_3.protocol)) {
            return SPDY_3;
        }
        throw new IOException("Unexpected protocol: " + string2);
    }

    public static Protocol valueOf(String string2) {
        return (Protocol)Enum.valueOf((Class)Protocol.class, (String)string2);
    }

    public static Protocol[] values() {
        return (Protocol[])$VALUES.clone();
    }

    public String toString() {
        return this.protocol;
    }
}

