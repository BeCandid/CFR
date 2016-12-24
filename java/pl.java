/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.Context;

public class pl {
    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public pk a(Context context, pk.a a2) {
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) return new pq();
        return new pm(context, a2);
    }
}

