/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.util.Log
 *  java.lang.Object
 *  java.lang.String
 */
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

public final class zw {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static boolean a(Context context, int n2) {
        PackageInfo packageInfo;
        if (!zw.a(context, n2, "com.google.android.gms")) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            packageInfo = packageManager.getPackageInfo("com.google.android.gms", 64);
        }
        catch (PackageManager.NameNotFoundException var3_4) {
            if (!Log.isLoggable((String)"UidVerifier", (int)3)) return false;
            Log.d((String)"UidVerifier", (String)"Package manager can't find google play services package, defaulting to false");
            return false;
        }
        return aad.a(context).a(context.getPackageManager(), packageInfo);
    }

    @TargetApi(value=19)
    public static boolean a(Context context, int n2, String string2) {
        return abv.b(context).a(n2, string2);
    }
}

