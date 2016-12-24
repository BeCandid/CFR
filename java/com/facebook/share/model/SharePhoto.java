/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.net.Uri
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.ClassLoader
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package com.facebook.share.model;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareMedia;
import java.util.ArrayList;
import java.util.List;

public final class SharePhoto
extends ShareMedia {
    public static final Parcelable.Creator<SharePhoto> CREATOR = new Parcelable.Creator<SharePhoto>(){

        public SharePhoto a(Parcel parcel) {
            return new SharePhoto(parcel);
        }

        public SharePhoto[] a(int n2) {
            return new SharePhoto[n2];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return this.a(parcel);
        }

        public /* synthetic */ Object[] newArray(int n2) {
            return this.a(n2);
        }
    };
    private final Bitmap a;
    private final Uri b;
    private final boolean c;
    private final String d;

    /*
     * Enabled aggressive block sorting
     */
    SharePhoto(Parcel parcel) {
        super(parcel);
        this.a = (Bitmap)parcel.readParcelable(Bitmap.class.getClassLoader());
        this.b = (Uri)parcel.readParcelable(Uri.class.getClassLoader());
        boolean bl2 = parcel.readByte() != 0;
        this.c = bl2;
        this.d = parcel.readString();
    }

    private SharePhoto(a a2) {
        super(a2);
        this.a = a2.a;
        this.b = a2.b;
        this.c = a2.c;
        this.d = a2.d;
    }

    /* synthetic */ SharePhoto(a a2,  var2_2) {
        super(a2);
    }

    @Override
    public ShareMedia.Type b() {
        return ShareMedia.Type.a;
    }

    public Bitmap c() {
        return this.a;
    }

    public Uri d() {
        return this.b;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public boolean e() {
        return this.c;
    }

    public String f() {
        return this.d;
    }

    @Override
    public void writeToParcel(Parcel parcel, int n2) {
        super.writeToParcel(parcel, n2);
        parcel.writeParcelable((Parcelable)this.a, 0);
        parcel.writeParcelable((Parcelable)this.b, 0);
        boolean bl2 = this.c;
        byte by2 = 0;
        if (bl2) {
            by2 = 1;
        }
        parcel.writeByte(by2);
        parcel.writeString(this.d);
    }

    public static final class a
    extends ShareMedia.a<SharePhoto, a> {
        private Bitmap a;
        private Uri b;
        private boolean c;
        private String d;

        static void a(Parcel parcel, int n2, List<SharePhoto> list) {
            Parcelable[] arrparcelable = new ShareMedia[list.size()];
            for (int i2 = 0; i2 < list.size(); ++i2) {
                arrparcelable[i2] = (ShareMedia)list.get(i2);
            }
            parcel.writeParcelableArray(arrparcelable, n2);
        }

        static List<SharePhoto> c(Parcel parcel) {
            Object b2 = a.a(parcel);
            ArrayList arrayList = new ArrayList();
            for (ShareMedia shareMedia : b2) {
                if (!(shareMedia instanceof SharePhoto)) continue;
                arrayList.add((Object)((SharePhoto)shareMedia));
            }
            return arrayList;
        }

        Uri a() {
            return this.b;
        }

        @Override
        public a a(Bitmap bitmap) {
            this.a = bitmap;
            return this;
        }

        @Override
        public a a(Uri uri) {
            this.b = uri;
            return this;
        }

        @Override
        public a a(SharePhoto sharePhoto) {
            if (sharePhoto == null) {
                return this;
            }
            return ((a)super.a(sharePhoto)).a(sharePhoto.c()).a(sharePhoto.d()).a(sharePhoto.e()).a(sharePhoto.f());
        }

        @Override
        public a a(String string2) {
            this.d = string2;
            return this;
        }

        @Override
        public a a(boolean bl2) {
            this.c = bl2;
            return this;
        }

        Bitmap b() {
            return this.a;
        }

        a b(Parcel parcel) {
            return this.a((SharePhoto)parcel.readParcelable(SharePhoto.class.getClassLoader()));
        }

        public SharePhoto c() {
            return new SharePhoto(this, null);
        }
    }

}

