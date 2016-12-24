/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 *  android.util.Log
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
import android.os.SystemClock;
import android.util.Log;

public class zh {
    private final long a;
    private final int b;
    private final dq<String, Long> c;

    public zh() {
        this.a = 60000;
        this.b = 10;
        this.c = new dq(10);
    }

    public zh(int n2, long l2) {
        this.a = l2;
        this.b = n2;
        this.c = new dq();
    }

    private void a(long l2, long l3) {
        for (int i2 = -1 + this.c.size(); i2 >= 0; --i2) {
            if (l3 - this.c.c(i2) <= l2) continue;
            this.c.d(i2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Long a(String string2) {
        long l2 = SystemClock.elapsedRealtime();
        long l3 = this.a;
        void var10_4 = this;
        synchronized (var10_4) {
            while (this.c.size() >= this.b) {
                super.a(l3, l2);
                int n2 = this.b;
                Log.w((String)"ConnectionTracker", (String)new StringBuilder(94).append("The max capacity ").append(n2).append(" is not enough. Current durationThreshold is: ").append(l3 /= 2).toString());
            }
            return this.c.put(string2, l2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean b(String string2) {
        void var4_2 = this;
        synchronized (var4_2) {
            if (this.c.remove(string2) == null) return false;
            return true;
        }
    }
}

