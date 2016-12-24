/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.internal.safeparcel.zza
 *  com.google.android.gms.common.internal.safeparcel.zza$zza
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;

public class xu
implements Parcelable.Creator<Status> {
    public static void a(Status status, Parcel parcel, int n2) {
        int n3 = xw.a(parcel);
        xw.a(parcel, 1, status.g());
        xw.a(parcel, 2, status.c(), false);
        xw.a(parcel, 3, (Parcelable)status.b(), n2, false);
        xw.a(parcel, 1000, status.d());
        xw.a(parcel, n3);
    }

    public Status a(Parcel parcel) {
        PendingIntent pendingIntent = null;
        int n2 = 0;
        int n3 = zza.b((Parcel)parcel);
        String string2 = null;
        int n4 = 0;
        block6 : while (parcel.dataPosition() < n3) {
            int n5 = zza.a((Parcel)parcel);
            switch (zza.a((int)n5)) {
                default: {
                    zza.b((Parcel)parcel, (int)n5);
                    continue block6;
                }
                case 1: {
                    n2 = zza.f((Parcel)parcel, (int)n5);
                    continue block6;
                }
                case 2: {
                    string2 = zza.n((Parcel)parcel, (int)n5);
                    continue block6;
                }
                case 3: {
                    pendingIntent = (PendingIntent)zza.a((Parcel)parcel, (int)n5, (Parcelable.Creator)PendingIntent.CREATOR);
                    continue block6;
                }
                case 1000: 
            }
            n4 = zza.f((Parcel)parcel, (int)n5);
        }
        if (parcel.dataPosition() != n3) {
            throw new zza.zza(new StringBuilder(37).append("Overread allowed size end=").append(n3).toString(), parcel);
        }
        return new Status(n4, n2, string2, pendingIntent);
    }

    public Status[] a(int n2) {
        return new Status[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

