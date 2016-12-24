/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.Object
 */
import android.os.Build;

public final class zt {
    public static boolean a() {
        return zt.a(11);
    }

    private static boolean a(int n2) {
        if (Build.VERSION.SDK_INT >= n2) {
            return true;
        }
        return false;
    }

    public static boolean b() {
        return zt.a(13);
    }

    public static boolean c() {
        return zt.a(14);
    }

    public static boolean d() {
        return zt.a(16);
    }

    public static boolean e() {
        return zt.a(18);
    }

    public static boolean f() {
        return zt.a(19);
    }

    public static boolean g() {
        return zt.a(20);
    }

    public static boolean h() {
        return zt.a(21);
    }
}

