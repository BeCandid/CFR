/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelable
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class xx {
    public static <T extends SafeParcelable> T a(Intent intent, String string2, Parcelable.Creator<T> creator) {
        byte[] arrby = intent.getByteArrayExtra(string2);
        if (arrby == null) {
            return null;
        }
        return xx.a(arrby, creator);
    }

    public static <T extends SafeParcelable> T a(byte[] arrby, Parcelable.Creator<T> creator) {
        xz.a(creator);
        Parcel parcel = Parcel.obtain();
        parcel.unmarshall(arrby, 0, arrby.length);
        parcel.setDataPosition(0);
        SafeParcelable safeParcelable = (SafeParcelable)creator.createFromParcel(parcel);
        parcel.recycle();
        return (T)safeParcelable;
    }
}

