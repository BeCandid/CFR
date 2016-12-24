/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.SecurityException
 *  java.lang.String
 */
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

public final class ahi {
    static final Object a = new Object();
    static ace b;
    static Boolean c;

    public static boolean a(Context context) {
        xz.a(context);
        if (c != null) {
            return c;
        }
        boolean bl2 = ago.a(context, "com.google.android.gms.measurement.AppMeasurementReceiver", false);
        c = bl2;
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void a(Context context, Intent intent) {
        Object object;
        ahk ahk2 = ahk.a(context);
        ahd ahd2 = ahk2.f();
        if (intent == null) {
            ahd2.z().a("AppMeasurementReceiver called with null intent");
            return;
        }
        String string2 = intent.getAction();
        if (ahk2.d().O()) {
            ahd2.E().a("Device AppMeasurementReceiver got", string2);
        } else {
            ahd2.E().a("Local AppMeasurementReceiver got", string2);
        }
        if (!"com.google.android.gms.measurement.UPLOAD".equals((Object)string2)) return;
        boolean bl2 = agh.a(context);
        Intent intent2 = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
        intent2.setAction("com.google.android.gms.measurement.UPLOAD");
        Object object2 = object = a;
        // MONITORENTER : object2
        context.startService(intent2);
        if (!bl2) {
            // MONITOREXIT : object2
            return;
        }
        try {
            if (b == null) {
                b = new ace(context, 1, "AppMeasurement WakeLock");
                b.a(false);
            }
            b.a(1000);
            // MONITOREXIT : object2
            return;
        }
        catch (SecurityException var12_10) {
            ahd2.z().a("AppMeasurementService at risk of not starting. For more reliable app measurements, add the WAKE_LOCK permission to your manifest.");
            return;
        }
    }
}

