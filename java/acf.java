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

public class acf {
    public static final xf<Object> a;
    public static final acg b;
    private static final xf.d<Object> c;
    private static final xf.b<Object, Object> d;

    static {
        c = new xf.d();
        d = new xf.b<Object, Object>(){};
        a = new xf("ActivityRecognition.API", d, c);
        b = new acp();
    }

    public static abstract class a<R extends xk>
    extends zza.zza<R, Object> {
        public a(xh xh2) {
            super((Api.zzc)c, (GoogleApiClient)xh2);
        }
    }

}

