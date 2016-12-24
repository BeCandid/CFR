/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.SystemClock
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.System
 */
import android.annotation.TargetApi;
import android.os.Build;
import android.os.SystemClock;

public final class re {
    private static final double a;

    static {
        double d2 = 1.0;
        if (17 <= Build.VERSION.SDK_INT) {
            d2 /= Math.pow((double)10.0, (double)6.0);
        }
        a = d2;
    }

    public static double a(long l2) {
        return (double)(re.a() - l2) * a;
    }

    @TargetApi(value=17)
    public static long a() {
        if (17 <= Build.VERSION.SDK_INT) {
            return SystemClock.elapsedRealtimeNanos();
        }
        return System.currentTimeMillis();
    }
}

