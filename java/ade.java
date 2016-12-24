/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.RemoteException
 *  com.google.android.gms.common.GooglePlayServicesNotAvailableException
 *  com.google.android.gms.maps.model.RuntimeRemoteException
 *  java.lang.Object
 */
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class ade {
    private static boolean a = false;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static int a(Context context) {
        reference var7_1 = ade.class;
        synchronized (ade.class) {
            aea aea2;
            za.zzb((Object)context, (Object)"Context is null");
            boolean bl2 = a;
            int n2 = 0;
            if (bl2) return n2;
            try {
                aea2 = ady.a(context);
            }
            catch (GooglePlayServicesNotAvailableException var5_5) {
                return var5_5.a;
            }
            ade.a(aea2);
            a = true;
            return 0;
        }
    }

    public static void a(aea aea2) {
        try {
            adc.a(aea2.a());
            aez.a(aea2.b());
            return;
        }
        catch (RemoteException var1_1) {
            throw new RuntimeRemoteException(var1_1);
        }
    }
}

