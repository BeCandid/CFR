/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 */
import android.content.Context;

public class abv {
    private static abv b = new abv();
    private abu a = null;

    public static abu b(Context context) {
        return b.a(context);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public abu a(Context context) {
        void var5_2 = this;
        synchronized (var5_2) {
            if (this.a != null) return this.a;
            if (context.getApplicationContext() != null) {
                Context context2;
                context = context2 = context.getApplicationContext();
            }
            this.a = new abu(context);
            return this.a;
        }
    }
}

