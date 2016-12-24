/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.auth.api.signin.GoogleSignInAccount
 *  com.google.android.gms.common.internal.ResolveAccountRequest
 *  com.google.android.gms.common.internal.safeparcel.zza
 *  com.google.android.gms.common.internal.safeparcel.zza$zza
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.zza;

public class ya
implements Parcelable.Creator<ResolveAccountRequest> {
    public static void a(ResolveAccountRequest resolveAccountRequest, Parcel parcel, int n2) {
        int n3 = xw.a(parcel);
        xw.a(parcel, 1, resolveAccountRequest.a);
        xw.a(parcel, 2, (Parcelable)resolveAccountRequest.a(), n2, false);
        xw.a(parcel, 3, resolveAccountRequest.b());
        xw.a(parcel, 4, (Parcelable)resolveAccountRequest.c(), n2, false);
        xw.a(parcel, n3);
    }

    /*
     * Enabled aggressive block sorting
     */
    public ResolveAccountRequest a(Parcel parcel) {
        GoogleSignInAccount googleSignInAccount = null;
        int n2 = 0;
        int n3 = zza.b((Parcel)parcel);
        Account account = null;
        int n4 = 0;
        while (parcel.dataPosition() < n3) {
            int n5;
            Account account2;
            int n6;
            GoogleSignInAccount googleSignInAccount2;
            int n7 = zza.a((Parcel)parcel);
            switch (zza.a((int)n7)) {
                default: {
                    zza.b((Parcel)parcel, (int)n7);
                    googleSignInAccount2 = googleSignInAccount;
                    n5 = n2;
                    account2 = account;
                    n6 = n4;
                    break;
                }
                case 1: {
                    int n8 = zza.f((Parcel)parcel, (int)n7);
                    GoogleSignInAccount googleSignInAccount3 = googleSignInAccount;
                    n5 = n2;
                    account2 = account;
                    n6 = n8;
                    googleSignInAccount2 = googleSignInAccount3;
                    break;
                }
                case 2: {
                    Account account3 = (Account)zza.a((Parcel)parcel, (int)n7, (Parcelable.Creator)Account.CREATOR);
                    n6 = n4;
                    int n9 = n2;
                    account2 = account3;
                    googleSignInAccount2 = googleSignInAccount;
                    n5 = n9;
                    break;
                }
                case 3: {
                    int n10 = zza.f((Parcel)parcel, (int)n7);
                    account2 = account;
                    n6 = n4;
                    GoogleSignInAccount googleSignInAccount4 = googleSignInAccount;
                    n5 = n10;
                    googleSignInAccount2 = googleSignInAccount4;
                    break;
                }
                case 4: {
                    googleSignInAccount2 = (GoogleSignInAccount)zza.a((Parcel)parcel, (int)n7, (Parcelable.Creator)GoogleSignInAccount.CREATOR);
                    n5 = n2;
                    account2 = account;
                    n6 = n4;
                }
            }
            n4 = n6;
            account = account2;
            n2 = n5;
            googleSignInAccount = googleSignInAccount2;
        }
        if (parcel.dataPosition() != n3) {
            throw new zza.zza(new StringBuilder(37).append("Overread allowed size end=").append(n3).toString(), parcel);
        }
        return new ResolveAccountRequest(n4, account, n2, googleSignInAccount);
    }

    public ResolveAccountRequest[] a(int n2) {
        return new ResolveAccountRequest[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

