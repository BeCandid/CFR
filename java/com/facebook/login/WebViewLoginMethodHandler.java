/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.support.v4.app.FragmentActivity
 *  android.support.v4.app.FragmentManager
 *  java.lang.Object
 *  java.lang.String
 */
package com.facebook.login;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.login.LoginClient;
import com.facebook.login.WebLoginMethodHandler;

class WebViewLoginMethodHandler
extends WebLoginMethodHandler {
    public static final Parcelable.Creator<WebViewLoginMethodHandler> CREATOR = new Parcelable.Creator(){

        public WebViewLoginMethodHandler a(Parcel parcel) {
            return new WebViewLoginMethodHandler(parcel);
        }

        public WebViewLoginMethodHandler[] a(int n2) {
            return new WebViewLoginMethodHandler[n2];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return this.a(parcel);
        }

        public /* synthetic */ Object[] newArray(int n2) {
            return this.a(n2);
        }
    };
    private wg c;
    private String d;

    WebViewLoginMethodHandler(Parcel parcel) {
        super(parcel);
        this.d = parcel.readString();
    }

    WebViewLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    @Override
    String a() {
        return "web_view";
    }

    @Override
    boolean a(final LoginClient.Request request) {
        Bundle bundle = this.b(request);
        wg.c c2 = new wg.c(){

            @Override
            public void a(Bundle bundle, FacebookException facebookException) {
                WebViewLoginMethodHandler.this.b(request, bundle, facebookException);
            }
        };
        this.d = LoginClient.m();
        this.a("e2e", this.d);
        FragmentActivity fragmentActivity = this.b.b();
        this.c = new a((Context)fragmentActivity, request.d(), bundle).a(this.d).a(request.f()).a(c2).a();
        vm vm2 = new vm();
        vm2.setRetainInstance(true);
        vm2.a(this.c);
        vm2.show(fragmentActivity.getSupportFragmentManager(), "FacebookDialogFragment");
        return true;
    }

    @Override
    void b() {
        if (this.c != null) {
            this.c.cancel();
            this.c = null;
        }
    }

    void b(LoginClient.Request request, Bundle bundle, FacebookException facebookException) {
        super.a(request, bundle, facebookException);
    }

    @Override
    AccessTokenSource b_() {
        return AccessTokenSource.e;
    }

    @Override
    boolean d() {
        return true;
    }

    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int n2) {
        super.writeToParcel(parcel, n2);
        parcel.writeString(this.d);
    }

    static class a
    extends wg.a {
        private String a;
        private boolean b;

        public a(Context context, String string2, Bundle bundle) {
            super(context, string2, "oauth", bundle);
        }

        public a a(String string2) {
            this.a = string2;
            return this;
        }

        public a a(boolean bl2) {
            this.b = bl2;
            return this;
        }

        @Override
        public wg a() {
            Bundle bundle = this.e();
            bundle.putString("redirect_uri", "fbconnect://success");
            bundle.putString("client_id", this.b());
            bundle.putString("e2e", this.a);
            bundle.putString("response_type", "token,signed_request");
            bundle.putString("return_scopes", "true");
            bundle.putString("auth_type", "rerequest");
            return new wg(this.c(), "oauth", bundle, this.d(), this.f());
        }
    }

}

