/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.Deprecated
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareModel;
import java.util.ArrayList;
import java.util.List;

public abstract class ShareMedia
implements ShareModel {
    private final Bundle a;

    ShareMedia(Parcel parcel) {
        this.a = parcel.readBundle();
    }

    protected ShareMedia(a a2) {
        this.a = new Bundle(a2.a);
    }

    @Deprecated
    public Bundle a() {
        return new Bundle(this.a);
    }

    public abstract Type b();

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeBundle(this.a);
    }

    public static final class Type
    extends Enum<Type> {
        public static final /* enum */ Type a = new Type();
        public static final /* enum */ Type b = new Type();
        private static final /* synthetic */ Type[] c;

        static {
            Type[] arrtype = new Type[]{a, b};
            c = arrtype;
        }

        private Type() {
            super(string2, n2);
        }

        public static Type valueOf(String string2) {
            return (Type)Enum.valueOf((Class)Type.class, (String)string2);
        }

        public static Type[] values() {
            return (Type[])c.clone();
        }
    }

    public static abstract class a<M extends ShareMedia, B extends a> {
        private Bundle a = new Bundle();

        static List<ShareMedia> a(Parcel parcel) {
            Parcelable[] arrparcelable = parcel.readParcelableArray(ShareMedia.class.getClassLoader());
            ArrayList arrayList = new ArrayList(arrparcelable.length);
            int n2 = arrparcelable.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                arrayList.add((Object)((ShareMedia)arrparcelable[i2]));
            }
            return arrayList;
        }

        @Deprecated
        public B a(Bundle bundle) {
            this.a.putAll(bundle);
            return this;
        }

        public B a(M m2) {
            if (m2 == null) {
                return this;
            }
            return this.a((M)m2.a());
        }
    }

}

