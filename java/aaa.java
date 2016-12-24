/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

public class aaa {
    private static final aaa a;
    public static final int b;

    static {
        b = aac.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        a = new aaa();
    }

    aaa() {
    }

    public static aaa b() {
        return a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String b(Context context, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("gcore_");
        stringBuilder.append(b);
        stringBuilder.append("-");
        if (!TextUtils.isEmpty((CharSequence)string)) {
            stringBuilder.append(string);
        }
        stringBuilder.append("-");
        if (context != null) {
            stringBuilder.append(context.getPackageName());
        }
        stringBuilder.append("-");
        if (context == null) return stringBuilder.toString();
        try {
            stringBuilder.append(context.getPackageManager().getPackageInfo((String)context.getPackageName(), (int)0).versionCode);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            return stringBuilder.toString();
        }
        return stringBuilder.toString();
    }

    public int a(Context context) {
        int n2 = aac.isGooglePlayServicesAvailable(context);
        if (aac.zzc(context, n2)) {
            n2 = 18;
        }
        return n2;
    }

    public PendingIntent a(Context context, int n2, int n3) {
        return this.a(context, n2, n3, null);
    }

    public PendingIntent a(Context context, int n2, int n3, String string) {
        Intent intent;
        if (zq.a(context) && n2 == 2) {
            n2 = 42;
        }
        if ((intent = this.a(context, n2, string)) == null) {
            return null;
        }
        return PendingIntent.getActivity((Context)context, (int)n3, (Intent)intent, (int)268435456);
    }

    public Intent a(Context context, int n2, String string) {
        switch (n2) {
            default: {
                return null;
            }
            case 1: 
            case 2: {
                return ys.a("com.google.android.gms", super.b(context, string));
            }
            case 42: {
                return ys.a();
            }
            case 3: 
        }
        return ys.a("com.google.android.gms");
    }

    public boolean a(int n2) {
        return aac.isUserRecoverableError(n2);
    }

    public boolean a(Context context, String string) {
        return aac.zzk(context, string);
    }
}

