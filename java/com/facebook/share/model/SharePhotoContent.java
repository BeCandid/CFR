/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.List
 */
package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.SharePhoto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SharePhotoContent
extends ShareContent<SharePhotoContent, a> {
    public static final Parcelable.Creator<SharePhotoContent> CREATOR = new Parcelable.Creator<SharePhotoContent>(){

        public SharePhotoContent a(Parcel parcel) {
            return new SharePhotoContent(parcel);
        }

        public SharePhotoContent[] a(int n2) {
            return new SharePhotoContent[n2];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return this.a(parcel);
        }

        public /* synthetic */ Object[] newArray(int n2) {
            return this.a(n2);
        }
    };
    private final List<SharePhoto> a;

    SharePhotoContent(Parcel parcel) {
        super(parcel);
        this.a = Collections.unmodifiableList(SharePhoto.a.c(parcel));
    }

    private SharePhotoContent(a a2) {
        super(a2);
        this.a = Collections.unmodifiableList((List)a2.a);
    }

    /* synthetic */ SharePhotoContent(a a2,  var2_2) {
        super(a2);
    }

    public List<SharePhoto> a() {
        return this.a;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int n2) {
        super.writeToParcel(parcel, n2);
        SharePhoto.a.a(parcel, n2, this.a);
    }

    public static class a
    extends ShareContent.a<SharePhotoContent, a> {
        private final List<SharePhoto> a = new ArrayList();

        public a a(SharePhoto sharePhoto) {
            if (sharePhoto != null) {
                this.a.add((Object)new SharePhoto.a().a(sharePhoto).c());
            }
            return this;
        }

        public SharePhotoContent a() {
            return new SharePhotoContent(this, null);
        }
    }

}

