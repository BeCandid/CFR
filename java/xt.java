/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.api.Scope
 *  com.google.android.gms.common.internal.safeparcel.zza
 *  com.google.android.gms.common.internal.safeparcel.zza$zza
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;

public class xt
implements Parcelable.Creator<Scope> {
    public static void a(Scope scope, Parcel parcel, int n2) {
        int n3 = xw.a(parcel);
        xw.a(parcel, 1, scope.a);
        xw.a(parcel, 2, scope.a(), false);
        xw.a(parcel, n3);
    }

    public Scope a(Parcel parcel) {
        int n2 = zza.b((Parcel)parcel);
        int n3 = 0;
        String string2 = null;
        block4 : while (parcel.dataPosition() < n2) {
            int n4 = zza.a((Parcel)parcel);
            switch (zza.a((int)n4)) {
                default: {
                    zza.b((Parcel)parcel, (int)n4);
                    continue block4;
                }
                case 1: {
                    n3 = zza.f((Parcel)parcel, (int)n4);
                    continue block4;
                }
                case 2: 
            }
            string2 = zza.n((Parcel)parcel, (int)n4);
        }
        if (parcel.dataPosition() != n2) {
            throw new zza.zza(new StringBuilder(37).append("Overread allowed size end=").append(n2).toString(), parcel);
        }
        return new Scope(n3, string2);
    }

    public Scope[] a(int n2) {
        return new Scope[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

