/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.ActivityNotFoundException
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.FragmentActivity
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.Set
 */
package com.facebook.login;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginClient;
import com.facebook.login.LoginMethodHandler;
import java.util.Collection;
import java.util.Set;

class KatanaProxyLoginMethodHandler
extends LoginMethodHandler {
    public static final Parcelable.Creator<KatanaProxyLoginMethodHandler> CREATOR = new Parcelable.Creator(){

        public KatanaProxyLoginMethodHandler a(Parcel parcel) {
            return new KatanaProxyLoginMethodHandler(parcel);
        }

        public KatanaProxyLoginMethodHandler[] a(int n2) {
            return new KatanaProxyLoginMethodHandler[n2];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return this.a(parcel);
        }

        public /* synthetic */ Object[] newArray(int n2) {
            return this.a(n2);
        }
    };

    KatanaProxyLoginMethodHandler(Parcel parcel) {
        super(parcel);
    }

    KatanaProxyLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private LoginClient.Result a(LoginClient.Request request, Intent intent) {
        Bundle bundle = intent.getExtras();
        String string2 = super.a(bundle);
        String string3 = bundle.getString("error_code");
        String string4 = super.b(bundle);
        String string5 = bundle.getString("e2e");
        if (!we.a(string5)) {
            this.b(string5);
        }
        if (string2 == null && string3 == null && string4 == null) {
            try {
                LoginClient.Result result = LoginClient.Result.a(request, KatanaProxyLoginMethodHandler.a(request.a(), bundle, AccessTokenSource.b, request.d()));
                return result;
            }
            catch (FacebookException var10_10) {
                return LoginClient.Result.a(request, null, var10_10.getMessage());
            }
        }
        boolean bl2 = wc.a.contains((Object)string2);
        LoginClient.Result result = null;
        if (bl2) return result;
        if (!wc.b.contains((Object)string2)) return LoginClient.Result.a(request, string2, string4, string3);
        return LoginClient.Result.a(request, null);
    }

    private String a(Bundle bundle) {
        String string2 = bundle.getString("error");
        if (string2 == null) {
            string2 = bundle.getString("error_type");
        }
        return string2;
    }

    private LoginClient.Result b(LoginClient.Request request, Intent intent) {
        Bundle bundle = intent.getExtras();
        String string2 = super.a(bundle);
        String string3 = bundle.getString("error_code");
        if ("CONNECTION_FAILURE".equals((Object)string3)) {
            return LoginClient.Result.a(request, string2, super.b(bundle), string3);
        }
        return LoginClient.Result.a(request, string2);
    }

    private String b(Bundle bundle) {
        String string2 = bundle.getString("error_message");
        if (string2 == null) {
            string2 = bundle.getString("error_description");
        }
        return string2;
    }

    @Override
    String a() {
        return "katana_proxy_auth";
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    boolean a(int n2, int n3, Intent intent) {
        LoginClient.Request request = this.b.c();
        LoginClient.Result result = intent == null ? LoginClient.Result.a(request, "Operation canceled") : (n3 == 0 ? super.b(request, intent) : (n3 != -1 ? LoginClient.Result.a(request, "Unexpected resultCode from authorization.", null) : super.a(request, intent)));
        if (result != null) {
            this.b.a(result);
            return true;
        }
        this.b.i();
        return true;
    }

    protected boolean a(Intent intent, int n2) {
        if (intent == null) {
            return false;
        }
        try {
            this.b.a().startActivityForResult(intent, n2);
            return true;
        }
        catch (ActivityNotFoundException var3_3) {
            return false;
        }
    }

    @Override
    boolean a(LoginClient.Request request) {
        String string2 = LoginClient.m();
        Intent intent = vz.a((Context)this.b.b(), request.d(), request.a(), string2, request.f(), request.h(), request.c(), this.a(request.e()));
        this.a("e2e", string2);
        return this.a(intent, LoginClient.d());
    }

    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int n2) {
        super.writeToParcel(parcel, n2);
    }

}

