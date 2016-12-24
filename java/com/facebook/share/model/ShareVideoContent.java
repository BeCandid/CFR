/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.net.Uri
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.Object
 *  java.lang.String
 */
package com.facebook.share.model;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareModel;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.ShareVideo;

public final class ShareVideoContent
extends ShareContent<ShareVideoContent, Object>
implements ShareModel {
    public static final Parcelable.Creator<ShareVideoContent> CREATOR = new Parcelable.Creator<ShareVideoContent>(){

        public ShareVideoContent a(Parcel parcel) {
            return new ShareVideoContent(parcel);
        }

        public ShareVideoContent[] a(int n2) {
            return new ShareVideoContent[n2];
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
    private final SharePhoto c;
    private final ShareVideo d;

    /*
     * Enabled aggressive block sorting
     */
    ShareVideoContent(Parcel parcel) {
        super(parcel);
        this.a = parcel.readString();
        this.b = parcel.readString();
        SharePhoto.a a2 = new SharePhoto.a().b(parcel);
        this.c = a2.a() != null || a2.b() != null ? a2.c() : null;
        this.d = new ShareVideo.a().b(parcel).a();
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public SharePhoto c() {
        return this.c;
    }

    public ShareVideo d() {
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
        parcel.writeParcelable((Parcelable)this.d, 0);
    }

}

