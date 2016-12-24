/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.Object
 *  java.lang.String
 */
package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareModel;

public class LikeContent
implements ShareModel {
    public static final Parcelable.Creator<LikeContent> CREATOR = new Parcelable.Creator<LikeContent>(){

        public LikeContent a(Parcel parcel) {
            return new LikeContent(parcel);
        }

        public LikeContent[] a(int n2) {
            return new LikeContent[n2];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return this.a(parcel);
        }

        public /* synthetic */ Object[] newArray(int n2) {
            return this.a(n2);
        }
    };
    private final String a;
    private final String b;

    LikeContent(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
    }

    private LikeContent(a a2) {
        this.a = a2.a;
        this.b = a2.b;
    }

    /* synthetic */ LikeContent(a a2,  var2_2) {
        super(a2);
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
    }

    public static class a {
        private String a;
        private String b;

        public a a(String string2) {
            this.a = string2;
            return this;
        }

        public LikeContent a() {
            return new LikeContent(this, null);
        }

        public a b(String string2) {
            this.b = string2;
            return this;
        }
    }

}

