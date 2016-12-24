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
 */
package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareMedia;

public final class ShareVideo
extends ShareMedia {
    public static final Parcelable.Creator<ShareVideo> CREATOR = new Parcelable.Creator<ShareVideo>(){

        public ShareVideo a(Parcel parcel) {
            return new ShareVideo(parcel);
        }

        public ShareVideo[] a(int n2) {
            return new ShareVideo[n2];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return this.a(parcel);
        }

        public /* synthetic */ Object[] newArray(int n2) {
            return this.a(n2);
        }
    };
    private final Uri a;

    ShareVideo(Parcel parcel) {
        super(parcel);
        this.a = (Uri)parcel.readParcelable(Uri.class.getClassLoader());
    }

    private ShareVideo(a a2) {
        super(a2);
        this.a = a2.a;
    }

    /* synthetic */ ShareVideo(a a2,  var2_2) {
        super(a2);
    }

    @Override
    public ShareMedia.Type b() {
        return ShareMedia.Type.b;
    }

    public Uri c() {
        return this.a;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int n2) {
        super.writeToParcel(parcel, n2);
        parcel.writeParcelable((Parcelable)this.a, 0);
    }

    public static final class a
    extends ShareMedia.a<ShareVideo, a> {
        private Uri a;

        @Override
        public a a(Uri uri) {
            this.a = uri;
            return this;
        }

        @Override
        public a a(ShareVideo shareVideo) {
            if (shareVideo == null) {
                return this;
            }
            return ((a)super.a(shareVideo)).a(shareVideo.c());
        }

        public ShareVideo a() {
            return new ShareVideo(this, null);
        }

        a b(Parcel parcel) {
            return this.a((ShareVideo)parcel.readParcelable(ShareVideo.class.getClassLoader()));
        }
    }

}

