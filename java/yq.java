/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.ServiceConnection
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.Context;
import android.content.ServiceConnection;

public abstract class yq {
    private static final Object a = new Object();
    private static yq b;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static yq a(Context context) {
        Object object;
        Object object2 = object = a;
        synchronized (object2) {
            if (b == null) {
                b = new yr(context.getApplicationContext());
            }
            return b;
        }
    }

    public abstract boolean a(String var1, String var2, ServiceConnection var3, String var4);

    public abstract void b(String var1, String var2, ServiceConnection var3, String var4);
}

