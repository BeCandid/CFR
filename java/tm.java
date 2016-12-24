/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.os.Bundle
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

class tm
implements tv {
    private final Context a;
    private final String b;

    public tm(Context context, String string2) {
        this.a = context;
        this.b = string2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public String a() {
        Bundle bundle;
        PackageManager packageManager = this.a.getPackageManager();
        try {
            bundle = packageManager.getApplicationInfo((String)this.b, (int)128).metaData;
            String string2 = null;
            if (bundle == null) return string2;
        }
        catch (Exception var2_5) {
            return null;
        }
        String string3 = bundle.getString("io.fabric.unity.crashlytics.version");
        return string3;
    }
}

