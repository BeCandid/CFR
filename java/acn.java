/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.Api
 *  com.google.android.gms.common.api.Api$zza
 *  com.google.android.gms.common.api.Api$zzc
 *  com.google.android.gms.common.api.GoogleApiClient
 *  com.google.android.gms.common.api.internal.zza
 *  com.google.android.gms.common.api.internal.zza$zza
 *  java.lang.Object
 *  java.lang.String
 */
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zza;

public class acn {
    public static final xf<Object> a;
    public static final acj b;
    public static final acl c;
    public static final aco d;
    private static final xf.d<Object> e;
    private static final xf.b<Object, Object> f;

    static {
        e = new xf.d();
        f = new xf.b<Object, Object>(){};
        a = new xf("LocationServices.API", f, e);
        b = new acq();
        c = new acr();
        d = new act();
    }

    public static abstract class a<R extends xk>
    extends zza.zza<R, Object> {
        public a(xh xh2) {
            super((Api.zzc)e, (GoogleApiClient)xh2);
        }
    }

}

