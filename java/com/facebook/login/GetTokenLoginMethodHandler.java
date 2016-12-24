/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.support.v4.app.FragmentActivity
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.Set
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.login.LoginClient;
import com.facebook.login.LoginMethodHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class GetTokenLoginMethodHandler
extends LoginMethodHandler {
    public static final Parcelable.Creator<GetTokenLoginMethodHandler> CREATOR = new Parcelable.Creator(){

        public GetTokenLoginMethodHandler a(Parcel parcel) {
            return new GetTokenLoginMethodHandler(parcel);
        }

        public GetTokenLoginMethodHandler[] a(int n2) {
            return new GetTokenLoginMethodHandler[n2];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return this.a(parcel);
        }

        public /* synthetic */ Object[] newArray(int n2) {
            return this.a(n2);
        }
    };
    private wj c;

    GetTokenLoginMethodHandler(Parcel parcel) {
        super(parcel);
    }

    GetTokenLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    @Override
    String a() {
        return "get_token";
    }

    void a(LoginClient.Request request, Bundle bundle) {
        if (this.c != null) {
            this.c.a((wa.a)null);
        }
        this.c = null;
        this.b.l();
        if (bundle != null) {
            ArrayList arrayList = bundle.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
            Set<String> set = request.a();
            if (arrayList != null && (set == null || arrayList.containsAll(set))) {
                this.c(request, bundle);
                return;
            }
            HashSet hashSet = new HashSet();
            for (String string2 : set) {
                if (arrayList.contains((Object)string2)) continue;
                hashSet.add((Object)string2);
            }
            if (!hashSet.isEmpty()) {
                this.a("new_permissions", TextUtils.join((CharSequence)",", (Iterable)hashSet));
            }
            request.a((Set<String>)hashSet);
        }
        this.b.i();
    }

    @Override
    boolean a(final LoginClient.Request request) {
        this.c = new wj((Context)this.b.b(), request.d());
        if (!this.c.a()) {
            return false;
        }
        this.b.k();
        wa.a a2 = new wa.a(){

            @Override
            public void a(Bundle bundle) {
                GetTokenLoginMethodHandler.this.a(request, bundle);
            }
        };
        this.c.a(a2);
        return true;
    }

    @Override
    void b() {
        if (this.c != null) {
            this.c.b();
            this.c.a((wa.a)null);
            this.c = null;
        }
    }

    void b(LoginClient.Request request, Bundle bundle) {
        AccessToken accessToken = GetTokenLoginMethodHandler.a(bundle, AccessTokenSource.d, request.d());
        LoginClient.Result result = LoginClient.Result.a(this.b.c(), accessToken);
        this.b.a(result);
    }

    void c(final LoginClient.Request request, final Bundle bundle) {
        String string2 = bundle.getString("com.facebook.platform.extra.USER_ID");
        if (string2 == null || string2.isEmpty()) {
            this.b.k();
            we.a(bundle.getString("com.facebook.platform.extra.ACCESS_TOKEN"), new we.c(){

                @Override
                public void a(FacebookException facebookException) {
                    GetTokenLoginMethodHandler.this.b.b(LoginClient.Result.a(GetTokenLoginMethodHandler.this.b.c(), "Caught exception", facebookException.getMessage()));
                }

                @Override
                public void a(JSONObject jSONObject) {
                    try {
                        String string2 = jSONObject.getString("id");
                        bundle.putString("com.facebook.platform.extra.USER_ID", string2);
                        GetTokenLoginMethodHandler.this.b(request, bundle);
                        return;
                    }
                    catch (JSONException var2_3) {
                        GetTokenLoginMethodHandler.this.b.b(LoginClient.Result.a(GetTokenLoginMethodHandler.this.b.c(), "Caught exception", var2_3.getMessage()));
                        return;
                    }
                }
            });
            return;
        }
        this.b(request, bundle);
    }

    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int n2) {
        super.writeToParcel(parcel, n2);
    }

}

