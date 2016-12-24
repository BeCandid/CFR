/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.ClassLoader
 *  java.lang.Object
 *  java.lang.String
 */
package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;

public final class ShareLinkContent
extends ShareContent<ShareLinkContent, a> {
    public static final Parcelable.Creator<ShareLinkContent> CREATOR = new Parcelable.Creator<ShareLinkContent>(){

        public ShareLinkContent a(Parcel parcel) {
            return new ShareLinkContent(parcel);
        }

        public ShareLinkContent[] a(int n2) {
            return new ShareLinkContent[n2];
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
    private final Uri c;
    private final String d;

    ShareLinkContent(Parcel parcel) {
        super(parcel);
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = (Uri)parcel.readParcelable(Uri.class.getClassLoader());
        this.d = parcel.readString();
    }

    private ShareLinkContent(a a2) {
        super(a2);
        this.a = a2.a;
        this.b = a2.b;
        this.c = a2.c;
        this.d = a2.d;
    }

    /* synthetic */ ShareLinkContent(a a2,  var2_2) {
        super(a2);
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public Uri c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int n2) {
        super.writeToParcel(parcel, n2);
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeParcelable((Parcelable)this.c, 0);
        parcel.writeString(this.d);
    }

    public static final class a
    extends ShareContent.a<ShareLinkContent, a> {
        private String a;
        private String b;
        private Uri c;
        private String d;

        public ShareLinkContent a() {
            return new ShareLinkContent(this, null);
        }
    }

}

