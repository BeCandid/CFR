/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.zza
 *  com.google.android.gms.common.internal.safeparcel.zza$zza
 *  com.google.android.gms.maps.model.StreetViewPanoramaCamera
 *  java.lang.Object
 *  java.lang.String
 */
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public class aft
implements Parcelable.Creator<StreetViewPanoramaCamera> {
    public static void a(StreetViewPanoramaCamera streetViewPanoramaCamera, Parcel parcel, int n2) {
        int n3 = xw.zzav((Parcel)parcel);
        xw.a(parcel, 1, streetViewPanoramaCamera.a());
        xw.a(parcel, 2, streetViewPanoramaCamera.a);
        xw.a(parcel, 3, streetViewPanoramaCamera.b);
        xw.a(parcel, 4, streetViewPanoramaCamera.c);
        xw.zzI((Parcel)parcel, (int)n3);
    }

    public StreetViewPanoramaCamera a(Parcel parcel) {
        float f2 = 0.0f;
        int n2 = zza.zzau((Parcel)parcel);
        float f3 = 0.0f;
        int n3 = 0;
        float f4 = 0.0f;
        block6 : while (parcel.dataPosition() < n2) {
            int n4 = zza.zzat((Parcel)parcel);
            switch (zza.zzca((int)n4)) {
                default: {
                    zza.b((Parcel)parcel, (int)n4);
                    continue block6;
                }
                case 1: {
                    n3 = zza.f((Parcel)parcel, (int)n4);
                    continue block6;
                }
                case 2: {
                    f3 = zza.j((Parcel)parcel, (int)n4);
                    continue block6;
                }
                case 3: {
                    f4 = zza.j((Parcel)parcel, (int)n4);
                    continue block6;
                }
                case 4: 
            }
            f2 = zza.j((Parcel)parcel, (int)n4);
        }
        if (parcel.dataPosition() != n2) {
            throw new zza.zza("Overread allowed size end=" + n2, parcel);
        }
        return new StreetViewPanoramaCamera(n3, f3, f4, f2);
    }

    public StreetViewPanoramaCamera[] a(int n2) {
        return new StreetViewPanoramaCamera[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

