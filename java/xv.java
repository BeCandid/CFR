/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.database.CursorWindow
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.data.DataHolder
 *  com.google.android.gms.common.internal.safeparcel.zza
 *  com.google.android.gms.common.internal.safeparcel.zza$zza
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;

public class xv
implements Parcelable.Creator<DataHolder> {
    public static void a(DataHolder dataHolder, Parcel parcel, int n2) {
        int n3 = xw.a(parcel);
        xw.a(parcel, 1, dataHolder.c(), false);
        xw.a((Parcel)parcel, (int)2, (Parcelable[])dataHolder.d(), (int)n2, (boolean)false);
        xw.a(parcel, 3, dataHolder.e());
        xw.a(parcel, 4, dataHolder.f(), false);
        xw.a(parcel, 1000, dataHolder.b());
        xw.a(parcel, n3);
    }

    public DataHolder a(Parcel parcel) {
        int n2 = 0;
        Bundle bundle = null;
        int n3 = zza.b((Parcel)parcel);
        CursorWindow[] arrcursorWindow = null;
        String[] arrstring = null;
        int n4 = 0;
        block7 : while (parcel.dataPosition() < n3) {
            int n5 = zza.a((Parcel)parcel);
            switch (zza.a((int)n5)) {
                default: {
                    zza.b((Parcel)parcel, (int)n5);
                    continue block7;
                }
                case 1: {
                    arrstring = zza.q((Parcel)parcel, (int)n5);
                    continue block7;
                }
                case 2: {
                    arrcursorWindow = (CursorWindow[])zza.b((Parcel)parcel, (int)n5, (Parcelable.Creator)CursorWindow.CREATOR);
                    continue block7;
                }
                case 3: {
                    n2 = zza.f((Parcel)parcel, (int)n5);
                    continue block7;
                }
                case 4: {
                    bundle = zza.p((Parcel)parcel, (int)n5);
                    continue block7;
                }
                case 1000: 
            }
            n4 = zza.f((Parcel)parcel, (int)n5);
        }
        if (parcel.dataPosition() != n3) {
            throw new zza.zza(new StringBuilder(37).append("Overread allowed size end=").append(n3).toString(), parcel);
        }
        DataHolder dataHolder = new DataHolder(n4, arrstring, arrcursorWindow, n2, bundle);
        dataHolder.a();
        return dataHolder;
    }

    public DataHolder[] a(int n2) {
        return new DataHolder[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

