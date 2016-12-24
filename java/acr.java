/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.api.internal.zza
 *  com.google.android.gms.common.api.internal.zza$zza
 *  com.google.android.gms.location.GeofencingRequest
 *  com.google.android.gms.location.GeofencingRequest$a
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.location.GeofencingRequest;
import java.util.List;

public class acr
implements acl {
    public xi<Status> a(xh xh2, final GeofencingRequest geofencingRequest, final PendingIntent pendingIntent) {
        return xh2.zzb((zza.zza)new a(xh2){});
    }

    @Override
    public xi<Status> a(xh xh2, final List<String> list) {
        return xh2.zzb((zza.zza)new a(xh2){});
    }

    @Deprecated
    @Override
    public xi<Status> a(xh xh2, List<ack> list, PendingIntent pendingIntent) {
        GeofencingRequest.a a2 = new GeofencingRequest.a();
        a2.a(list);
        a2.a(5);
        return this.a(xh2, a2.a(), pendingIntent);
    }

    static abstract class a
    extends acn.a<Status> {
        public a(xh xh2) {
            super(xh2);
        }
    }

}

