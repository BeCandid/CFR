/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

public class zm {
    public static boolean a() {
        return false;
    }

    public static boolean a(Context context, String string2) {
        int n2;
        PackageManager packageManager = context.getPackageManager();
        try {
            n2 = packageManager.getApplicationInfo((String)string2, (int)0).flags;
        }
        catch (PackageManager.NameNotFoundException var3_6) {
            return false;
        }
        int n3 = n2 & 2097152;
        boolean bl2 = false;
        if (n3 != 0) {
            bl2 = true;
        }
        return bl2;
    }
}

