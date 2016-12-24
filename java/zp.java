/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 *  java.lang.Object
 *  java.lang.System
 */
import android.os.SystemClock;

public final class zp
implements zn {
    private static zp a;

    public static zn d() {
        reference var2 = zp.class;
        synchronized (zp.class) {
            if (a == null) {
                a = new zp();
            }
            zp zp2 = a;
            // ** MonitorExit[var2] (shouldn't be in output)
            return zp2;
        }
    }

    @Override
    public long a() {
        return System.currentTimeMillis();
    }

    @Override
    public long b() {
        return SystemClock.elapsedRealtime();
    }

    @Override
    public long c() {
        return System.nanoTime();
    }
}

