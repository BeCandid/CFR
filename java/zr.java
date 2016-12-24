/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.os.PowerManager
 *  android.os.SystemClock
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 */
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;

public final class zr {
    private static IntentFilter a = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private static long b;
    private static float c;

    static {
        c = Float.NaN;
    }

    /*
     * Enabled aggressive block sorting
     */
    @TargetApi(value=20)
    public static int a(Context context) {
        int n2 = 1;
        if (context == null) return -1;
        if (context.getApplicationContext() == null) {
            return -1;
        }
        Intent intent = context.getApplicationContext().registerReceiver(null, a);
        int n3 = intent == null ? 0 : intent.getIntExtra("plugged", 0);
        int n4 = (n3 & 7) != 0 ? n2 : 0;
        PowerManager powerManager = (PowerManager)context.getSystemService("power");
        if (powerManager == null) {
            return -1;
        }
        int n5 = zr.a(powerManager) ? n2 : 0;
        int n6 = n5 << 1;
        if (n4 != 0) {
            return n6 | n2;
        }
        n2 = 0;
        return n6 | n2;
    }

    @TargetApi(value=20)
    public static boolean a(PowerManager powerManager) {
        if (zt.g()) {
            return powerManager.isInteractive();
        }
        return powerManager.isScreenOn();
    }

    public static float b(Context context) {
        reference var6_1 = zr.class;
        synchronized (zr.class) {
            float f2;
            if (SystemClock.elapsedRealtime() - b < 60000 && !Float.isNaN((float)c)) {
                f2 = c;
                return f2;
            }
            Intent intent = context.getApplicationContext().registerReceiver(null, a);
            if (intent != null) {
                int n2 = intent.getIntExtra("level", -1);
                int n3 = intent.getIntExtra("scale", -1);
                c = (float)n2 / (float)n3;
            }
            b = SystemClock.elapsedRealtime();
            f2 = c;
        }
    }
}

