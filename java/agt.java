/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Looper
 *  com.google.android.gms.measurement.internal.zzw
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.measurement.internal.zzw;

abstract class agt {
    private static volatile Handler b;
    private final ahk a;
    private final Runnable c;
    private volatile long d;
    private boolean e;

    agt(ahk ahk2) {
        xz.a(ahk2);
        this.a = ahk2;
        this.e = true;
        this.c = new Runnable(){

            /*
             * Enabled aggressive block sorting
             */
            public void run() {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    agt.this.a.h().a((Runnable)this);
                    return;
                } else {
                    boolean bl2 = agt.this.b();
                    agt.this.d = 0;
                    if (!bl2 || !agt.this.e) return;
                    {
                        agt.this.a();
                        return;
                    }
                }
            }
        };
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Handler d() {
        if (b != null) {
            return b;
        }
        reference var3_1 = agt.class;
        synchronized (agt.class) {
            if (b != null) return b;
            b = new Handler(this.a.q().getMainLooper());
            return b;
        }
    }

    public abstract void a();

    public void a(long l2) {
        this.c();
        if (l2 >= 0) {
            this.d = this.a.r().a();
            if (!super.d().postDelayed(this.c, l2)) {
                this.a.f().f().a("Failed to schedule delayed post. time", l2);
            }
        }
    }

    public boolean b() {
        if (this.d != 0) {
            return true;
        }
        return false;
    }

    public void c() {
        this.d = 0;
        this.d().removeCallbacks(this.c);
    }

}

