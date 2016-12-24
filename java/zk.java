/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Parcelable
 *  android.os.SystemClock
 *  android.text.TextUtils
 *  android.util.Log
 *  com.google.android.gms.common.stats.WakeLockEvent
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.SecurityException
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.List
 */
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.stats.WakeLockEvent;
import java.util.List;

public class zk {
    private static String a = "WakeLockTracker";
    private static zk b = new zk();
    private static Boolean c;

    public static zk a() {
        return b;
    }

    private static boolean a(Context context) {
        if (c == null) {
            c = zk.b(context);
        }
        return c;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean b(Context context) {
        try {
            boolean bl2 = zm.a();
            boolean bl3 = false;
            if (!bl2) return bl3;
        }
        catch (SecurityException var1_6) {
            return false;
        }
        int n2 = zf.b.a.a();
        int n3 = zg.b;
        if (n2 == n3) return false;
        return true;
    }

    public void a(Context context, String string2, int n2, String string3, String string4, String string5, int n3, List<String> list) {
        this.a(context, string2, n2, string3, string4, string5, n3, list, 0);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void a(Context context, String string2, int n2, String string3, String string4, String string5, int n3, List<String> list, long l2) {
        if (!zk.a(context)) {
            return;
        }
        if (TextUtils.isEmpty((CharSequence)string2)) {
            String string6 = a;
            String string7 = String.valueOf((Object)string2);
            String string8 = string7.length() != 0 ? "missing wakeLock key. ".concat(string7) : new String("missing wakeLock key. ");
            Log.e((String)string6, (String)string8);
            return;
        }
        long l3 = System.currentTimeMillis();
        if (7 != n2 && 8 != n2 && 10 != n2) {
            if (11 != n2) return;
        }
        WakeLockEvent wakeLockEvent = new WakeLockEvent(l3, n2, string3, n3, zi.a(list), string2, SystemClock.elapsedRealtime(), zr.a(context), string4, zi.a(context.getPackageName()), zr.b(context), l2, string5);
        try {
            context.startService(new Intent().setComponent(zg.a).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", (Parcelable)wakeLockEvent));
            return;
        }
        catch (Exception var14_15) {
            Log.wtf((String)a, (Throwable)var14_15);
            return;
        }
    }
}

