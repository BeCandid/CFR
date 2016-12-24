/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Handler
 *  android.os.IBinder
 *  com.google.android.gms.measurement.internal.zzw
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.SecurityException
 *  java.lang.String
 */
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.google.android.gms.measurement.internal.zzw;

public final class agh {
    private static Boolean d;
    private final Handler a;
    private final Context b;
    private final a c;

    public agh(a a2) {
        this.b = a2.a();
        xz.a(this.b);
        this.c = a2;
        this.a = new Handler();
    }

    public static boolean a(Context context) {
        xz.a(context);
        if (d != null) {
            return d;
        }
        boolean bl2 = ago.a(context, "com.google.android.gms.measurement.AppMeasurementService");
        d = bl2;
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void c() {
        ace ace2;
        try {
            Object object;
            Object object2 = object = ahi.a;
            synchronized (object2) {
                ace2 = ahi.b;
            }
        }
        catch (SecurityException var1_4) {
            return;
        }
        {
            if (ace2 != null && ace2.b()) {
                ace2.a();
            }
            return;
        }
    }

    private ahd d() {
        return ahk.a(this.b).f();
    }

    /*
     * Enabled aggressive block sorting
     */
    public int a(Intent intent, int n2, final int n3) {
        super.c();
        final ahk ahk2 = ahk.a(this.b);
        final ahd ahd2 = ahk2.f();
        if (intent == null) {
            ahd2.z().a("AppMeasurementService started with null intent");
            return 2;
        } else {
            String string2 = intent.getAction();
            if (ahk2.d().O()) {
                ahd2.E().a("Device AppMeasurementService called. startId, action", n3, string2);
            } else {
                ahd2.E().a("Local AppMeasurementService called. startId, action", n3, string2);
            }
            if (!"com.google.android.gms.measurement.UPLOAD".equals((Object)string2)) return 2;
            {
                ahk2.h().a(new Runnable(){

                    public void run() {
                        ahk2.J();
                        ahk2.H();
                        agh.this.a.post(new Runnable(){

                            /*
                             * Enabled force condition propagation
                             * Lifted jumps to return sites
                             */
                            public void run() {
                                if (!agh.this.c.a(n3)) return;
                                if (ahk2.d().O()) {
                                    ahd2.E().a("Device AppMeasurementService processed last upload request");
                                    return;
                                }
                                ahd2.E().a("Local AppMeasurementService processed last upload request");
                            }
                        });
                    }

                });
                return 2;
            }
        }
    }

    public IBinder a(Intent intent) {
        if (intent == null) {
            super.d().f().a("onBind called with null intent");
            return null;
        }
        String string2 = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals((Object)string2)) {
            return new ahl(ahk.a(this.b));
        }
        super.d().z().a("onBind received unknown action", string2);
        return null;
    }

    public void a() {
        ahk ahk2 = ahk.a(this.b);
        ahd ahd2 = ahk2.f();
        if (ahk2.d().O()) {
            ahd2.E().a("Device AppMeasurementService is starting up");
            return;
        }
        ahd2.E().a("Local AppMeasurementService is starting up");
    }

    public void b() {
        ahk ahk2 = ahk.a(this.b);
        ahd ahd2 = ahk2.f();
        if (ahk2.d().O()) {
            ahd2.E().a("Device AppMeasurementService is shutting down");
            return;
        }
        ahd2.E().a("Local AppMeasurementService is shutting down");
    }

    public boolean b(Intent intent) {
        if (intent == null) {
            super.d().f().a("onUnbind called with null intent");
            return true;
        }
        String string2 = intent.getAction();
        super.d().E().a("onUnbind called for intent. action", string2);
        return true;
    }

    public void c(Intent intent) {
        if (intent == null) {
            super.d().f().a("onRebind called with null intent");
            return;
        }
        String string2 = intent.getAction();
        super.d().E().a("onRebind called. action", string2);
    }

    public static interface a {
        public Context a();

        public boolean a(int var1);
    }

}

