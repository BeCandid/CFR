/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.UnsupportedEncodingException
 *  java.lang.AssertionError
 *  java.lang.Object
 *  java.lang.String
 */
package okhttp3;

import java.io.UnsupportedEncodingException;
import okio.ByteString;

public final class Credentials {
    private Credentials() {
    }

    public static String basic(String string2, String string3) {
        try {
            String string4 = ByteString.of((string2 + ":" + string3).getBytes("ISO-8859-1")).base64();
            String string5 = "Basic " + string4;
            return string5;
        }
        catch (UnsupportedEncodingException var2_4) {
            throw new AssertionError();
        }
    }
}

