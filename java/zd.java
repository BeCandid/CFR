/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.zza
 *  com.google.android.gms.common.internal.safeparcel.zza$zza
 *  com.google.android.gms.common.stats.ConnectionEvent
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.stats.ConnectionEvent;

public class zd
implements Parcelable.Creator<ConnectionEvent> {
    public static void a(ConnectionEvent connectionEvent, Parcel parcel, int n2) {
        int n3 = xw.a(parcel);
        xw.a(parcel, 1, connectionEvent.a);
        xw.a(parcel, 2, connectionEvent.a());
        xw.a(parcel, 4, connectionEvent.c(), false);
        xw.a(parcel, 5, connectionEvent.d(), false);
        xw.a(parcel, 6, connectionEvent.e(), false);
        xw.a(parcel, 7, connectionEvent.f(), false);
        xw.a(parcel, 8, connectionEvent.g(), false);
        xw.a(parcel, 10, connectionEvent.k());
        xw.a(parcel, 11, connectionEvent.j());
        xw.a(parcel, 12, connectionEvent.b());
        xw.a(parcel, 13, connectionEvent.h(), false);
        xw.a(parcel, n3);
    }

    public ConnectionEvent a(Parcel parcel) {
        int n2 = zza.b((Parcel)parcel);
        int n3 = 0;
        long l2 = 0;
        int n4 = 0;
        String string2 = null;
        String string3 = null;
        String string4 = null;
        String string5 = null;
        String string6 = null;
        String string7 = null;
        long l3 = 0;
        long l4 = 0;
        block13 : while (parcel.dataPosition() < n2) {
            int n5 = zza.a((Parcel)parcel);
            switch (zza.a((int)n5)) {
                default: {
                    zza.b((Parcel)parcel, (int)n5);
                    continue block13;
                }
                case 1: {
                    n3 = zza.f((Parcel)parcel, (int)n5);
                    continue block13;
                }
                case 2: {
                    l2 = zza.h((Parcel)parcel, (int)n5);
                    continue block13;
                }
                case 4: {
                    string2 = zza.n((Parcel)parcel, (int)n5);
                    continue block13;
                }
                case 5: {
                    string3 = zza.n((Parcel)parcel, (int)n5);
                    continue block13;
                }
                case 6: {
                    string4 = zza.n((Parcel)parcel, (int)n5);
                    continue block13;
                }
                case 7: {
                    string5 = zza.n((Parcel)parcel, (int)n5);
                    continue block13;
                }
                case 8: {
                    string6 = zza.n((Parcel)parcel, (int)n5);
                    continue block13;
                }
                case 10: {
                    l3 = zza.h((Parcel)parcel, (int)n5);
                    continue block13;
                }
                case 11: {
                    l4 = zza.h((Parcel)parcel, (int)n5);
                    continue block13;
                }
                case 12: {
                    n4 = zza.f((Parcel)parcel, (int)n5);
                    continue block13;
                }
                case 13: 
            }
            string7 = zza.n((Parcel)parcel, (int)n5);
        }
        if (parcel.dataPosition() != n2) {
            throw new zza.zza(new StringBuilder(37).append("Overread allowed size end=").append(n2).toString(), parcel);
        }
        return new ConnectionEvent(n3, l2, n4, string2, string3, string4, string5, string6, string7, l3, l4);
    }

    public ConnectionEvent[] a(int n2) {
        return new ConnectionEvent[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

