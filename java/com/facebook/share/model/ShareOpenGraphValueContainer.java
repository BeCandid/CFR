/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcel
 *  java.lang.ClassLoader
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Set
 */
package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;
import com.facebook.share.model.ShareModel;
import java.util.Set;

public abstract class ShareOpenGraphValueContainer<P extends ShareOpenGraphValueContainer, E extends a>
implements ShareModel {
    private final Bundle a;

    ShareOpenGraphValueContainer(Parcel parcel) {
        this.a = parcel.readBundle(a.class.getClassLoader());
    }

    protected ShareOpenGraphValueContainer(a<P, E> a2) {
        this.a = (Bundle)a2.a.clone();
    }

    public Object a(String string2) {
        return this.a.get(string2);
    }

    public Bundle b() {
        return (Bundle)this.a.clone();
    }

    public String b(String string2) {
        return this.a.getString(string2);
    }

    public Set<String> c() {
        return this.a.keySet();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeBundle(this.a);
    }

    public static abstract class a<P extends ShareOpenGraphValueContainer, E extends a> {
        private Bundle a = new Bundle();

        public E a(P p2) {
            if (p2 != null) {
                this.a.putAll(p2.b());
            }
            return this;
        }

        public E a(String string2, String string3) {
            this.a.putString(string2, string3);
            return this;
        }
    }

}

