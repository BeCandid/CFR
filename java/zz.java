/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.internal.safeparcel.zza
 *  com.google.android.gms.common.internal.safeparcel.zza$zza
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zz
implements Parcelable.Creator<ConnectionResult> {
    public static void a(ConnectionResult connectionResult, Parcel parcel, int n2) {
        int n3 = xw.a(parcel);
        xw.a(parcel, 1, connectionResult.b);
        xw.a(parcel, 2, connectionResult.c());
        xw.a(parcel, 3, (Parcelable)connectionResult.d(), n2, false);
        xw.a(parcel, 4, connectionResult.e(), false);
        xw.a(parcel, n3);
    }

    /*
     * Enabled aggressive block sorting
     */
    public ConnectionResult a(Parcel parcel) {
        String string2 = null;
        int n2 = 0;
        int n3 = zza.b((Parcel)parcel);
        PendingIntent pendingIntent = null;
        int n4 = 0;
        while (parcel.dataPosition() < n3) {
            PendingIntent pendingIntent2;
            int n5;
            String string3;
            int n6;
            int n7 = zza.a((Parcel)parcel);
            switch (zza.a((int)n7)) {
                default: {
                    zza.b((Parcel)parcel, (int)n7);
                    string3 = string2;
                    pendingIntent2 = pendingIntent;
                    n6 = n2;
                    n5 = n4;
                    break;
                }
                case 1: {
                    int n8 = zza.f((Parcel)parcel, (int)n7);
                    String string4 = string2;
                    pendingIntent2 = pendingIntent;
                    n6 = n2;
                    n5 = n8;
                    string3 = string4;
                    break;
                }
                case 2: {
                    int n9 = zza.f((Parcel)parcel, (int)n7);
                    n5 = n4;
                    PendingIntent pendingIntent3 = pendingIntent;
                    n6 = n9;
                    string3 = string2;
                    pendingIntent2 = pendingIntent3;
                    break;
                }
                case 3: {
                    PendingIntent pendingIntent4 = (PendingIntent)zza.a((Parcel)parcel, (int)n7, (Parcelable.Creator)PendingIntent.CREATOR);
                    n6 = n2;
                    n5 = n4;
                    String string5 = string2;
                    pendingIntent2 = pendingIntent4;
                    string3 = string5;
                    break;
                }
                case 4: {
                    string3 = zza.n((Parcel)parcel, (int)n7);
                    pendingIntent2 = pendingIntent;
                    n6 = n2;
                    n5 = n4;
                }
            }
            n4 = n5;
            n2 = n6;
            pendingIntent = pendingIntent2;
            string2 = string3;
        }
        if (parcel.dataPosition() != n3) {
            throw new zza.zza(new StringBuilder(37).append("Overread allowed size end=").append(n3).toString(), parcel);
        }
        return new ConnectionResult(n4, n2, pendingIntent, string2);
    }

    public ConnectionResult[] a(int n2) {
        return new ConnectionResult[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

