/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 *  android.util.Log
 *  java.lang.Object
 *  java.lang.String
 */
import android.os.SystemClock;
import android.util.Log;

public class amb {
    private final String a;
    private final String b;
    private final boolean c;
    private long d;
    private long e;

    /*
     * Enabled aggressive block sorting
     */
    public amb(String string2, String string3) {
        this.a = string2;
        this.b = string3;
        boolean bl2 = !Log.isLoggable((String)string3, (int)2);
        this.c = bl2;
    }

    private void c() {
        Log.v((String)this.b, (String)(this.a + ": " + this.e + "ms"));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a() {
        amb amb2 = this;
        synchronized (amb2) {
            boolean bl2 = this.c;
            if (!bl2) {
                this.d = SystemClock.elapsedRealtime();
                this.e = 0;
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b() {
        amb amb2 = this;
        synchronized (amb2) {
            boolean bl2 = this.c;
            if (!bl2 && this.e == 0) {
                this.e = SystemClock.elapsedRealtime() - this.d;
                this.c();
            }
            return;
        }
    }
}

