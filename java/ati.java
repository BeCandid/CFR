/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.Object
 */
import android.content.Context;
import android.os.Build;

public final class ati {
    /*
     * Enabled aggressive block sorting
     */
    public static atg a(Context context, ath ath2) {
        int n2 = Build.VERSION.SDK_INT;
        atd atd2 = n2 < 5 ? new atd(context) : (n2 < 8 ? new ate(context) : new atf(context));
        atd2.a(ath2);
        return atd2;
    }
}

