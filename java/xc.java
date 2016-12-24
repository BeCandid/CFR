/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.auth.api.signin.GoogleSignInAccount
 *  com.google.android.gms.common.api.Scope
 *  com.google.android.gms.common.internal.safeparcel.zza
 *  com.google.android.gms.common.internal.safeparcel.zza$zza
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.List
 */
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;
import java.util.List;

public class xc
implements Parcelable.Creator<GoogleSignInAccount> {
    public static void a(GoogleSignInAccount googleSignInAccount, Parcel parcel, int n2) {
        int n3 = xw.a(parcel);
        xw.a(parcel, 1, googleSignInAccount.b);
        xw.a(parcel, 2, googleSignInAccount.a(), false);
        xw.a(parcel, 3, googleSignInAccount.b(), false);
        xw.a(parcel, 4, googleSignInAccount.c(), false);
        xw.a(parcel, 5, googleSignInAccount.d(), false);
        xw.a(parcel, 6, (Parcelable)googleSignInAccount.g(), n2, false);
        xw.a(parcel, 7, googleSignInAccount.h(), false);
        xw.a(parcel, 8, googleSignInAccount.i());
        xw.a(parcel, 9, googleSignInAccount.j(), false);
        xw.c(parcel, 10, googleSignInAccount.c, false);
        xw.a(parcel, 11, googleSignInAccount.e(), false);
        xw.a(parcel, 12, googleSignInAccount.f(), false);
        xw.a(parcel, n3);
    }

    public GoogleSignInAccount a(Parcel parcel) {
        int n2 = zza.b((Parcel)parcel);
        int n3 = 0;
        String string2 = null;
        String string3 = null;
        String string4 = null;
        String string5 = null;
        Uri uri = null;
        String string6 = null;
        long l2 = 0;
        String string7 = null;
        ArrayList arrayList = null;
        String string8 = null;
        String string9 = null;
        block14 : while (parcel.dataPosition() < n2) {
            int n4 = zza.a((Parcel)parcel);
            switch (zza.a((int)n4)) {
                default: {
                    zza.b((Parcel)parcel, (int)n4);
                    continue block14;
                }
                case 1: {
                    n3 = zza.f((Parcel)parcel, (int)n4);
                    continue block14;
                }
                case 2: {
                    string2 = zza.n((Parcel)parcel, (int)n4);
                    continue block14;
                }
                case 3: {
                    string3 = zza.n((Parcel)parcel, (int)n4);
                    continue block14;
                }
                case 4: {
                    string4 = zza.n((Parcel)parcel, (int)n4);
                    continue block14;
                }
                case 5: {
                    string5 = zza.n((Parcel)parcel, (int)n4);
                    continue block14;
                }
                case 6: {
                    uri = (Uri)zza.a((Parcel)parcel, (int)n4, (Parcelable.Creator)Uri.CREATOR);
                    continue block14;
                }
                case 7: {
                    string6 = zza.n((Parcel)parcel, (int)n4);
                    continue block14;
                }
                case 8: {
                    l2 = zza.h((Parcel)parcel, (int)n4);
                    continue block14;
                }
                case 9: {
                    string7 = zza.n((Parcel)parcel, (int)n4);
                    continue block14;
                }
                case 10: {
                    arrayList = zza.c((Parcel)parcel, (int)n4, (Parcelable.Creator)Scope.CREATOR);
                    continue block14;
                }
                case 11: {
                    string8 = zza.n((Parcel)parcel, (int)n4);
                    continue block14;
                }
                case 12: 
            }
            string9 = zza.n((Parcel)parcel, (int)n4);
        }
        if (parcel.dataPosition() != n2) {
            throw new zza.zza(new StringBuilder(37).append("Overread allowed size end=").append(n2).toString(), parcel);
        }
        return new GoogleSignInAccount(n3, string2, string3, string4, string5, uri, string6, l2, string7, (List)arrayList, string8, string9);
    }

    public GoogleSignInAccount[] a(int n2) {
        return new GoogleSignInAccount[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

