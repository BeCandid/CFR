/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.api.Scope
 *  com.google.android.gms.common.internal.AuthAccountRequest
 *  com.google.android.gms.common.internal.safeparcel.zza
 *  com.google.android.gms.common.internal.safeparcel.zza$zza
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.safeparcel.zza;

public class yh
implements Parcelable.Creator<AuthAccountRequest> {
    public static void a(AuthAccountRequest authAccountRequest, Parcel parcel, int n2) {
        int n3 = xw.a(parcel);
        xw.a(parcel, 1, authAccountRequest.a);
        xw.a(parcel, 2, authAccountRequest.b, false);
        xw.a((Parcel)parcel, (int)3, (Parcelable[])authAccountRequest.c, (int)n2, (boolean)false);
        xw.a(parcel, 4, authAccountRequest.d, false);
        xw.a(parcel, 5, authAccountRequest.e, false);
        xw.a(parcel, n3);
    }

    public AuthAccountRequest a(Parcel parcel) {
        Integer n2 = null;
        int n3 = zza.b((Parcel)parcel);
        int n4 = 0;
        Integer n5 = null;
        Scope[] arrscope = null;
        IBinder iBinder = null;
        block7 : while (parcel.dataPosition() < n3) {
            int n6 = zza.a((Parcel)parcel);
            switch (zza.a((int)n6)) {
                default: {
                    zza.b((Parcel)parcel, (int)n6);
                    continue block7;
                }
                case 1: {
                    n4 = zza.f((Parcel)parcel, (int)n6);
                    continue block7;
                }
                case 2: {
                    iBinder = zza.o((Parcel)parcel, (int)n6);
                    continue block7;
                }
                case 3: {
                    arrscope = (Scope[])zza.b((Parcel)parcel, (int)n6, (Parcelable.Creator)Scope.CREATOR);
                    continue block7;
                }
                case 4: {
                    n5 = zza.g((Parcel)parcel, (int)n6);
                    continue block7;
                }
                case 5: 
            }
            n2 = zza.g((Parcel)parcel, (int)n6);
        }
        if (parcel.dataPosition() != n3) {
            throw new zza.zza(new StringBuilder(37).append("Overread allowed size end=").append(n3).toString(), parcel);
        }
        return new AuthAccountRequest(n4, iBinder, arrscope, n5, n2);
    }

    public AuthAccountRequest[] a(int n2) {
        return new AuthAccountRequest[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

