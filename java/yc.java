/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.api.Scope
 *  com.google.android.gms.common.internal.SignInButtonConfig
 *  com.google.android.gms.common.internal.safeparcel.zza
 *  com.google.android.gms.common.internal.safeparcel.zza$zza
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.SignInButtonConfig;
import com.google.android.gms.common.internal.safeparcel.zza;

public class yc
implements Parcelable.Creator<SignInButtonConfig> {
    public static void a(SignInButtonConfig signInButtonConfig, Parcel parcel, int n2) {
        int n3 = xw.a(parcel);
        xw.a(parcel, 1, signInButtonConfig.a);
        xw.a(parcel, 2, signInButtonConfig.a());
        xw.a(parcel, 3, signInButtonConfig.b());
        xw.a((Parcel)parcel, (int)4, (Parcelable[])signInButtonConfig.c(), (int)n2, (boolean)false);
        xw.a(parcel, n3);
    }

    public SignInButtonConfig a(Parcel parcel) {
        int n2 = 0;
        int n3 = zza.b((Parcel)parcel);
        Scope[] arrscope = null;
        int n4 = 0;
        int n5 = 0;
        block6 : while (parcel.dataPosition() < n3) {
            int n6 = zza.a((Parcel)parcel);
            switch (zza.a((int)n6)) {
                default: {
                    zza.b((Parcel)parcel, (int)n6);
                    continue block6;
                }
                case 1: {
                    n5 = zza.f((Parcel)parcel, (int)n6);
                    continue block6;
                }
                case 2: {
                    n4 = zza.f((Parcel)parcel, (int)n6);
                    continue block6;
                }
                case 3: {
                    n2 = zza.f((Parcel)parcel, (int)n6);
                    continue block6;
                }
                case 4: 
            }
            arrscope = (Scope[])zza.b((Parcel)parcel, (int)n6, (Parcelable.Creator)Scope.CREATOR);
        }
        if (parcel.dataPosition() != n3) {
            throw new zza.zza(new StringBuilder(37).append("Overread allowed size end=").append(n3).toString(), parcel);
        }
        return new SignInButtonConfig(n5, n4, n2, arrscope);
    }

    public SignInButtonConfig[] a(int n2) {
        return new SignInButtonConfig[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

