/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.support.v4.app.FragmentActivity
 *  android.text.TextUtils
 *  android.webkit.CookieSyncManager
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Locale
 *  java.util.Set
 */
package com.facebook.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcel;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookServiceException;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginClient;
import com.facebook.login.LoginMethodHandler;
import java.util.Locale;
import java.util.Set;

abstract class WebLoginMethodHandler
extends LoginMethodHandler {
    private String c;

    WebLoginMethodHandler(Parcel parcel) {
        super(parcel);
    }

    WebLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    private static final String c() {
        return "fb" + ul.i() + "://authorize";
    }

    private void c(String string2) {
        this.b.b().getSharedPreferences("com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).edit().putString("TOKEN", string2).apply();
    }

    private String e() {
        return this.b.b().getSharedPreferences("com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).getString("TOKEN", "");
    }

    protected Bundle a(Bundle bundle, LoginClient.Request request) {
        bundle.putString("redirect_uri", WebLoginMethodHandler.c());
        bundle.putString("client_id", request.d());
        bundle.putString("e2e", LoginClient.m());
        bundle.putString("response_type", "token,signed_request");
        bundle.putString("return_scopes", "true");
        bundle.putString("auth_type", "rerequest");
        return bundle;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void a(LoginClient.Request request, Bundle bundle, FacebookException facebookException) {
        LoginClient.Result result;
        this.c = null;
        if (bundle != null) {
            if (bundle.containsKey("e2e")) {
                this.c = bundle.getString("e2e");
            }
            try {
                AccessToken accessToken = WebLoginMethodHandler.a(request.a(), bundle, this.b_(), request.d());
                result = LoginClient.Result.a(this.b.c(), accessToken);
                CookieSyncManager.createInstance((Context)this.b.b()).sync();
                super.c(accessToken.b());
            }
            catch (FacebookException var11_6) {
                result = LoginClient.Result.a(this.b.c(), null, var11_6.getMessage());
            }
        } else if (facebookException instanceof FacebookOperationCanceledException) {
            result = LoginClient.Result.a(this.b.c(), "User canceled log in.");
        } else {
            this.c = null;
            String string2 = facebookException.getMessage();
            boolean bl2 = facebookException instanceof FacebookServiceException;
            String string3 = null;
            if (bl2) {
                FacebookRequestError facebookRequestError = ((FacebookServiceException)facebookException).a();
                Locale locale = Locale.ROOT;
                Object[] arrobject = new Object[]{facebookRequestError.b()};
                string3 = String.format((Locale)locale, (String)"%d", (Object[])arrobject);
                string2 = facebookRequestError.toString();
            }
            result = LoginClient.Result.a(this.b.c(), null, string2, string3);
        }
        if (!we.a(this.c)) {
            this.b(this.c);
        }
        this.b.a(result);
    }

    /*
     * Enabled aggressive block sorting
     */
    protected Bundle b(LoginClient.Request request) {
        Bundle bundle = new Bundle();
        if (!we.a(request.a())) {
            String string2 = TextUtils.join((CharSequence)",", request.a());
            bundle.putString("scope", string2);
            this.a("scope", string2);
        }
        bundle.putString("default_audience", request.c().a());
        bundle.putString("state", this.a(request.e()));
        AccessToken accessToken = AccessToken.a();
        String string3 = accessToken != null ? accessToken.b() : null;
        if (string3 != null && string3.equals((Object)super.e())) {
            bundle.putString("access_token", string3);
            this.a("access_token", "1");
            return bundle;
        }
        we.b((Context)this.b.b());
        this.a("access_token", "0");
        return bundle;
    }

    abstract AccessTokenSource b_();
}

