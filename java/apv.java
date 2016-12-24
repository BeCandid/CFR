/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  java.lang.Object
 */
import android.os.Handler;
import android.os.Looper;

public final class apv {
    private static final apo a = new apw(new Handler(Looper.getMainLooper()));

    public static apo a() {
        apo apo2 = apt.a().b().b();
        if (apo2 != null) {
            return apo2;
        }
        return a;
    }
}

