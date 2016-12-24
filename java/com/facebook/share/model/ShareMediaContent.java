/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.ClassLoader
 *  java.lang.Object
 *  java.util.Arrays
 *  java.util.List
 */
package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareMedia;
import java.util.Arrays;
import java.util.List;

public final class ShareMediaContent
extends ShareContent<ShareMediaContent, Object> {
    public static final Parcelable.Creator<ShareMediaContent> CREATOR = new Parcelable.Creator<ShareMediaContent>(){

        public ShareMediaContent a(Parcel parcel) {
            return new ShareMediaContent(parcel);
        }

        public ShareMediaContent[] a(int n2) {
            return new ShareMediaContent[n2];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return this.a(parcel);
        }

        public /* synthetic */ Object[] newArray(int n2) {
            return this.a(n2);
        }
    };
    private final List<ShareMedia> a;

    ShareMediaContent(Parcel parcel) {
        super(parcel);
        this.a = Arrays.asList((Object[])((ShareMedia[])parcel.readParcelableArray(ShareMedia.class.getClassLoader())));
    }

    public List<ShareMedia> a() {
        return this.a;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int n2) {
        super.writeToParcel(parcel, n2);
        parcel.writeParcelableArray((Parcelable[])((ShareMedia[])this.a.toArray()), n2);
    }

}

