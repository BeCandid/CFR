/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.UnsupportedEncodingException
 *  java.lang.Object
 *  java.lang.String
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 */
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class md {
    private final rf<kn, String> a = new rf(1000);

    md() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public String a(kn kn2) {
        rf<kn, String> rf2;
        rf<kn, String> rf3;
        rf<kn, String> rf4 = rf3 = this.a;
        // MONITORENTER : rf4
        String string2 = this.a.b(kn2);
        // MONITOREXIT : rf4
        if (string2 != null) return string2;
        try {
            String string3;
            MessageDigest messageDigest = MessageDigest.getInstance((String)"SHA-256");
            kn2.a(messageDigest);
            string2 = string3 = ri.a(messageDigest.digest());
        }
        catch (UnsupportedEncodingException var9_9) {
            var9_9.printStackTrace();
        }
        catch (NoSuchAlgorithmException var5_10) {
            var5_10.printStackTrace();
        }
        rf<kn, String> rf5 = rf2 = this.a;
        // MONITORENTER : rf5
        this.a.b(kn2, string2);
        // MONITOREXIT : rf5
        return string2;
    }
}

