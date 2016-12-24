/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.ClassLoader
 *  java.lang.Object
 *  java.lang.String
 */
package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareModel;

public class ShareHashtag
implements ShareModel {
    public static final Parcelable.Creator<ShareHashtag> CREATOR = new Parcelable.Creator<ShareHashtag>(){

        public ShareHashtag a(Parcel parcel) {
            return new ShareHashtag(parcel);
        }

        public ShareHashtag[] a(int n2) {
            return new ShareHashtag[n2];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return this.a(parcel);
        }

        public /* synthetic */ Object[] newArray(int n2) {
            return this.a(n2);
        }
    };
    private final String a;

    ShareHashtag(Parcel parcel) {
        this.a = parcel.readString();
    }

    private ShareHashtag(a a2) {
        this.a = a2.a;
    }

    /* synthetic */ ShareHashtag(a a2,  var2_2) {
        super(a2);
    }

    public String a() {
        return this.a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeString(this.a);
    }

    public static class a {
        private String a;

        a a(Parcel parcel) {
            return this.a((ShareHashtag)parcel.readParcelable(ShareHashtag.class.getClassLoader()));
        }

        public a a(ShareHashtag shareHashtag) {
            if (shareHashtag == null) {
                return this;
            }
            return this.a(shareHashtag.a());
        }

        public a a(String string2) {
            this.a = string2;
            return this;
        }

        public ShareHashtag a() {
            return new ShareHashtag(this, null);
        }
    }

}

