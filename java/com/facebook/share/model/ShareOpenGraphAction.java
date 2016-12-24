/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.ClassLoader
 *  java.lang.Object
 *  java.lang.String
 */
package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareOpenGraphValueContainer;

public final class ShareOpenGraphAction
extends ShareOpenGraphValueContainer<ShareOpenGraphAction, a> {
    public static final Parcelable.Creator<ShareOpenGraphAction> CREATOR = new Parcelable.Creator<ShareOpenGraphAction>(){

        public ShareOpenGraphAction a(Parcel parcel) {
            return new ShareOpenGraphAction(parcel);
        }

        public ShareOpenGraphAction[] a(int n2) {
            return new ShareOpenGraphAction[n2];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return this.a(parcel);
        }

        public /* synthetic */ Object[] newArray(int n2) {
            return this.a(n2);
        }
    };

    ShareOpenGraphAction(Parcel parcel) {
        super(parcel);
    }

    private ShareOpenGraphAction(a a2) {
        super(a2);
    }

    /* synthetic */ ShareOpenGraphAction(a a2,  var2_2) {
        super(a2);
    }

    public String a() {
        return this.b("og:type");
    }

    public static final class a
    extends ShareOpenGraphValueContainer.a<ShareOpenGraphAction, a> {
        @Override
        a a(Parcel parcel) {
            return this.a((ShareOpenGraphAction)parcel.readParcelable(ShareOpenGraphAction.class.getClassLoader()));
        }

        @Override
        public a a(ShareOpenGraphAction shareOpenGraphAction) {
            if (shareOpenGraphAction == null) {
                return this;
            }
            return ((a)super.a(shareOpenGraphAction)).a(shareOpenGraphAction.a());
        }

        @Override
        public a a(String string2) {
            this.a("og:type", string2);
            return this;
        }

        public ShareOpenGraphAction a() {
            return new ShareOpenGraphAction(this, null);
        }
    }

}

