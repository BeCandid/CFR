/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.api.Scope
 *  com.google.android.gms.common.internal.ValidateAccountRequest
 *  com.google.android.gms.common.internal.safeparcel.zza
 *  com.google.android.gms.common.internal.safeparcel.zza$zza
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ValidateAccountRequest;
import com.google.android.gms.common.internal.safeparcel.zza;

public class yg
implements Parcelable.Creator<ValidateAccountRequest> {
    public static void a(ValidateAccountRequest validateAccountRequest, Parcel parcel, int n2) {
        int n3 = xw.a(parcel);
        xw.a(parcel, 1, validateAccountRequest.a);
        xw.a(parcel, 2, validateAccountRequest.a());
        xw.a(parcel, 3, validateAccountRequest.b, false);
        xw.a((Parcel)parcel, (int)4, (Parcelable[])validateAccountRequest.b(), (int)n2, (boolean)false);
        xw.a(parcel, 5, validateAccountRequest.d(), false);
        xw.a(parcel, 6, validateAccountRequest.c(), false);
        xw.a(parcel, n3);
    }

    public ValidateAccountRequest a(Parcel parcel) {
        int n2 = 0;
        String string2 = null;
        int n3 = zza.b((Parcel)parcel);
        Bundle bundle = null;
        Scope[] arrscope = null;
        IBinder iBinder = null;
        int n4 = 0;
        block8 : while (parcel.dataPosition() < n3) {
            int n5 = zza.a((Parcel)parcel);
            switch (zza.a((int)n5)) {
                default: {
                    zza.b((Parcel)parcel, (int)n5);
                    continue block8;
                }
                case 1: {
                    n4 = zza.f((Parcel)parcel, (int)n5);
                    continue block8;
                }
                case 2: {
                    n2 = zza.f((Parcel)parcel, (int)n5);
                    continue block8;
                }
                case 3: {
                    iBinder = zza.o((Parcel)parcel, (int)n5);
                    continue block8;
                }
                case 4: {
                    arrscope = (Scope[])zza.b((Parcel)parcel, (int)n5, (Parcelable.Creator)Scope.CREATOR);
                    continue block8;
                }
                case 5: {
                    bundle = zza.p((Parcel)parcel, (int)n5);
                    continue block8;
                }
                case 6: 
            }
            string2 = zza.n((Parcel)parcel, (int)n5);
        }
        if (parcel.dataPosition() != n3) {
            throw new zza.zza(new StringBuilder(37).append("Overread allowed size end=").append(n3).toString(), parcel);
        }
        return new ValidateAccountRequest(n4, n2, iBinder, arrscope, bundle, string2);
    }

    public ValidateAccountRequest[] a(int n2) {
        return new ValidateAccountRequest[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

