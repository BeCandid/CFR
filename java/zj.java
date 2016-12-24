/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.zza
 *  com.google.android.gms.common.internal.safeparcel.zza$zza
 *  com.google.android.gms.common.stats.WakeLockEvent
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.List
 */
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.stats.WakeLockEvent;
import java.util.ArrayList;
import java.util.List;

public class zj
implements Parcelable.Creator<WakeLockEvent> {
    public static void a(WakeLockEvent wakeLockEvent, Parcel parcel, int n2) {
        int n3 = xw.a(parcel);
        xw.a(parcel, 1, wakeLockEvent.a);
        xw.a(parcel, 2, wakeLockEvent.a());
        xw.a(parcel, 4, wakeLockEvent.c(), false);
        xw.a(parcel, 5, wakeLockEvent.f());
        xw.b(parcel, 6, wakeLockEvent.g(), false);
        xw.a(parcel, 8, wakeLockEvent.j());
        xw.a(parcel, 10, wakeLockEvent.d(), false);
        xw.a(parcel, 11, wakeLockEvent.b());
        xw.a(parcel, 12, wakeLockEvent.h(), false);
        xw.a(parcel, 13, wakeLockEvent.m(), false);
        xw.a(parcel, 14, wakeLockEvent.k());
        xw.a(parcel, 15, wakeLockEvent.n());
        xw.a(parcel, 16, wakeLockEvent.o());
        xw.a(parcel, 17, wakeLockEvent.e(), false);
        xw.a(parcel, n3);
    }

    public WakeLockEvent a(Parcel parcel) {
        int n2 = zza.b((Parcel)parcel);
        int n3 = 0;
        long l2 = 0;
        int n4 = 0;
        String string2 = null;
        int n5 = 0;
        ArrayList arrayList = null;
        String string3 = null;
        long l3 = 0;
        int n6 = 0;
        String string4 = null;
        String string5 = null;
        float f2 = 0.0f;
        long l4 = 0;
        String string6 = null;
        block16 : while (parcel.dataPosition() < n2) {
            int n7 = zza.a((Parcel)parcel);
            switch (zza.a((int)n7)) {
                default: {
                    zza.b((Parcel)parcel, (int)n7);
                    continue block16;
                }
                case 1: {
                    n3 = zza.f((Parcel)parcel, (int)n7);
                    continue block16;
                }
                case 2: {
                    l2 = zza.h((Parcel)parcel, (int)n7);
                    continue block16;
                }
                case 4: {
                    string2 = zza.n((Parcel)parcel, (int)n7);
                    continue block16;
                }
                case 5: {
                    n5 = zza.f((Parcel)parcel, (int)n7);
                    continue block16;
                }
                case 6: {
                    arrayList = zza.s((Parcel)parcel, (int)n7);
                    continue block16;
                }
                case 8: {
                    l3 = zza.h((Parcel)parcel, (int)n7);
                    continue block16;
                }
                case 10: {
                    string4 = zza.n((Parcel)parcel, (int)n7);
                    continue block16;
                }
                case 11: {
                    n4 = zza.f((Parcel)parcel, (int)n7);
                    continue block16;
                }
                case 12: {
                    string3 = zza.n((Parcel)parcel, (int)n7);
                    continue block16;
                }
                case 13: {
                    string5 = zza.n((Parcel)parcel, (int)n7);
                    continue block16;
                }
                case 14: {
                    n6 = zza.f((Parcel)parcel, (int)n7);
                    continue block16;
                }
                case 15: {
                    f2 = zza.j((Parcel)parcel, (int)n7);
                    continue block16;
                }
                case 16: {
                    l4 = zza.h((Parcel)parcel, (int)n7);
                    continue block16;
                }
                case 17: 
            }
            string6 = zza.n((Parcel)parcel, (int)n7);
        }
        if (parcel.dataPosition() != n2) {
            throw new zza.zza(new StringBuilder(37).append("Overread allowed size end=").append(n2).toString(), parcel);
        }
        return new WakeLockEvent(n3, l2, n4, string2, n5, (List)arrayList, string3, l3, n6, string4, string5, f2, l4, string6);
    }

    public WakeLockEvent[] a(int n2) {
        return new WakeLockEvent[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

