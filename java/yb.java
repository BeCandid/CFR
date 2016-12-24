/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.internal.ResolveAccountResponse
 *  com.google.android.gms.common.internal.safeparcel.zza
 *  com.google.android.gms.common.internal.safeparcel.zza$zza
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.zza;

public class yb
implements Parcelable.Creator<ResolveAccountResponse> {
    public static void a(ResolveAccountResponse resolveAccountResponse, Parcel parcel, int n2) {
        int n3 = xw.a(parcel);
        xw.a(parcel, 1, resolveAccountResponse.a);
        xw.a(parcel, 2, resolveAccountResponse.b, false);
        xw.a(parcel, 3, (Parcelable)resolveAccountResponse.b(), n2, false);
        xw.a(parcel, 4, resolveAccountResponse.c());
        xw.a(parcel, 5, resolveAccountResponse.d());
        xw.a(parcel, n3);
    }

    public ResolveAccountResponse a(Parcel parcel) {
        ConnectionResult connectionResult = null;
        boolean bl2 = false;
        int n2 = zza.b((Parcel)parcel);
        boolean bl3 = false;
        IBinder iBinder = null;
        int n3 = 0;
        block7 : while (parcel.dataPosition() < n2) {
            int n4 = zza.a((Parcel)parcel);
            switch (zza.a((int)n4)) {
                default: {
                    zza.b((Parcel)parcel, (int)n4);
                    continue block7;
                }
                case 1: {
                    n3 = zza.f((Parcel)parcel, (int)n4);
                    continue block7;
                }
                case 2: {
                    iBinder = zza.o((Parcel)parcel, (int)n4);
                    continue block7;
                }
                case 3: {
                    connectionResult = (ConnectionResult)zza.a((Parcel)parcel, (int)n4, (Parcelable.Creator)ConnectionResult.CREATOR);
                    continue block7;
                }
                case 4: {
                    bl3 = zza.c((Parcel)parcel, (int)n4);
                    continue block7;
                }
                case 5: 
            }
            bl2 = zza.c((Parcel)parcel, (int)n4);
        }
        if (parcel.dataPosition() != n2) {
            throw new zza.zza(new StringBuilder(37).append("Overread allowed size end=").append(n2).toString(), parcel);
        }
        return new ResolveAccountResponse(n3, iBinder, connectionResult, bl3, bl2);
    }

    public ResolveAccountResponse[] a(int n2) {
        return new ResolveAccountResponse[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

