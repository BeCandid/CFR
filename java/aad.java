/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.Signature
 *  android.util.Base64
 *  android.util.Log
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;

public class aad {
    private static aad a;
    private final Context b;

    private aad(Context context) {
        this.b = context.getApplicationContext();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static aad a(Context context) {
        xz.a(context);
        reference var3_1 = aad.class;
        synchronized (aad.class) {
            if (a == null) {
                aab.a(context);
                a = new aad(context);
            }
            // ** MonitorExit[var3_1] (shouldn't be in output)
            return a;
        }
    }

    /* varargs */ aab.a a(PackageInfo packageInfo, aab.a ... arra) {
        if (packageInfo.signatures == null) {
            return null;
        }
        if (packageInfo.signatures.length != 1) {
            Log.w((String)"GoogleSignatureVerifier", (String)"Package has more than one signature.");
            return null;
        }
        aab.b b2 = new aab.b(packageInfo.signatures[0].toByteArray());
        for (int i2 = 0; i2 < arra.length; ++i2) {
            if (!arra[i2].equals(b2)) continue;
            return arra[i2];
        }
        String string2 = String.valueOf((Object)packageInfo.packageName);
        String string3 = String.valueOf((Object)Base64.encodeToString((byte[])b2.c(), (int)0));
        Log.v((String)"GoogleSignatureVerifier", (String)new StringBuilder(31 + String.valueOf((Object)string2).length() + String.valueOf((Object)string3).length()).append(string2).append(" signature not valid.  Found: \n").append(string3).toString());
        return null;
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean a(PackageInfo packageInfo, boolean bl2) {
        if (packageInfo != null && packageInfo.signatures != null) {
            aab.a a2;
            if (bl2) {
                a2 = this.a(packageInfo, aab.d.a);
            } else {
                aab.a[] arra = new aab.a[]{aab.d.a[0]};
                a2 = this.a(packageInfo, arra);
            }
            if (a2 != null) {
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean a(PackageManager packageManager, PackageInfo packageInfo) {
        boolean bl2 = false;
        if (packageInfo == null) {
            return bl2;
        }
        if (aac.zzal(this.b)) {
            return this.a(packageInfo, true);
        }
        bl2 = this.a(packageInfo, false);
        if (bl2) return bl2;
        if (!this.a(packageInfo, true)) return bl2;
        Log.w((String)"GoogleSignatureVerifier", (String)"Test-keys aren't accepted on this build.");
        return bl2;
    }
}

