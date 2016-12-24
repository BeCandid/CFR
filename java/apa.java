/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class apa {
    public static MessageDigest a() {
        return apa.a("MD5");
    }

    public static MessageDigest a(String string2) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance((String)string2);
            return messageDigest;
        }
        catch (NoSuchAlgorithmException var1_2) {
            throw new IllegalArgumentException((Throwable)var1_2);
        }
    }

    public static byte[] a(byte[] arrby) {
        return apa.a().digest(arrby);
    }

    public static byte[] b(String string2) {
        return apa.a(aoz.a(string2));
    }
}

