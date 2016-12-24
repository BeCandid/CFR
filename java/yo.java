/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.api.Scope
 *  com.google.android.gms.common.internal.GetServiceRequest
 *  com.google.android.gms.common.internal.safeparcel.zza
 *  com.google.android.gms.common.internal.safeparcel.zza$zza
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.GetServiceRequest;
import com.google.android.gms.common.internal.safeparcel.zza;

public class yo
implements Parcelable.Creator<GetServiceRequest> {
    public static void a(GetServiceRequest getServiceRequest, Parcel parcel, int n2) {
        int n3 = xw.a(parcel);
        xw.a(parcel, 1, getServiceRequest.a);
        xw.a(parcel, 2, getServiceRequest.b);
        xw.a(parcel, 3, getServiceRequest.c);
        xw.a(parcel, 4, getServiceRequest.d, false);
        xw.a(parcel, 5, getServiceRequest.e, false);
        xw.a((Parcel)parcel, (int)6, (Parcelable[])getServiceRequest.f, (int)n2, (boolean)false);
        xw.a(parcel, 7, getServiceRequest.g, false);
        xw.a(parcel, 8, (Parcelable)getServiceRequest.h, n2, false);
        xw.a(parcel, 9, getServiceRequest.i);
        xw.a(parcel, n3);
    }

    public GetServiceRequest a(Parcel parcel) {
        int n2 = 0;
        Account account = null;
        int n3 = zza.b((Parcel)parcel);
        long l2 = 0;
        Bundle bundle = null;
        Scope[] arrscope = null;
        IBinder iBinder = null;
        String string2 = null;
        int n4 = 0;
        int n5 = 0;
        block11 : while (parcel.dataPosition() < n3) {
            int n6 = zza.a((Parcel)parcel);
            switch (zza.a((int)n6)) {
                default: {
                    zza.b((Parcel)parcel, (int)n6);
                    continue block11;
                }
                case 1: {
                    n5 = zza.f((Parcel)parcel, (int)n6);
                    continue block11;
                }
                case 2: {
                    n4 = zza.f((Parcel)parcel, (int)n6);
                    continue block11;
                }
                case 3: {
                    n2 = zza.f((Parcel)parcel, (int)n6);
                    continue block11;
                }
                case 4: {
                    string2 = zza.n((Parcel)parcel, (int)n6);
                    continue block11;
                }
                case 5: {
                    iBinder = zza.o((Parcel)parcel, (int)n6);
                    continue block11;
                }
                case 6: {
                    arrscope = (Scope[])zza.b((Parcel)parcel, (int)n6, (Parcelable.Creator)Scope.CREATOR);
                    continue block11;
                }
                case 7: {
                    bundle = zza.p((Parcel)parcel, (int)n6);
                    continue block11;
                }
                case 8: {
                    account = (Account)zza.a((Parcel)parcel, (int)n6, (Parcelable.Creator)Account.CREATOR);
                    continue block11;
                }
                case 9: 
            }
            l2 = zza.h((Parcel)parcel, (int)n6);
        }
        if (parcel.dataPosition() != n3) {
            throw new zza.zza(new StringBuilder(37).append("Overread allowed size end=").append(n3).toString(), parcel);
        }
        return new GetServiceRequest(n5, n4, n2, string2, iBinder, arrscope, bundle, account, l2);
    }

    public GetServiceRequest[] a(int n2) {
        return new GetServiceRequest[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

