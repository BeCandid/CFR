/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Parcel
 *  android.os.Parcelable
 *  java.lang.ClassLoader
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.List
 */
package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class ShareContent<P extends ShareContent, E extends a>
implements ShareModel {
    private final Uri a;
    private final List<String> b;
    private final String c;
    private final String d;
    private final ShareHashtag e;

    public ShareContent(Parcel parcel) {
        this.a = (Uri)parcel.readParcelable(Uri.class.getClassLoader());
        this.b = super.a(parcel);
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = new ShareHashtag.a().a(parcel).a();
    }

    protected ShareContent(a a2) {
        this.a = a2.a;
        this.b = a2.b;
        this.c = a2.c;
        this.d = a2.d;
        this.e = a2.e;
    }

    private List<String> a(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        parcel.readStringList((List)arrayList);
        if (arrayList.size() == 0) {
            return null;
        }
        return Collections.unmodifiableList((List)arrayList);
    }

    public int describeContents() {
        return 0;
    }

    public Uri h() {
        return this.a;
    }

    public List<String> i() {
        return this.b;
    }

    public String j() {
        return this.c;
    }

    public String k() {
        return this.d;
    }

    public ShareHashtag l() {
        return this.e;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeParcelable((Parcelable)this.a, 0);
        parcel.writeStringList(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeParcelable((Parcelable)this.e, 0);
    }

    public static abstract class a<P extends ShareContent, E extends a> {
        private Uri a;
        private List<String> b;
        private String c;
        private String d;
        private ShareHashtag e;

        public E a(Uri uri) {
            this.a = uri;
            return this;
        }
    }

}

