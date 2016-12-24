/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.FragmentActivity
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.facebook.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.facebook.AccessTokenSource;
import com.facebook.login.LoginClient;
import com.facebook.login.WebLoginMethodHandler;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomTabLoginMethodHandler
extends WebLoginMethodHandler {
    public static final Parcelable.Creator<CustomTabLoginMethodHandler> CREATOR = new Parcelable.Creator(){

        public CustomTabLoginMethodHandler a(Parcel parcel) {
            return new CustomTabLoginMethodHandler(parcel);
        }

        public CustomTabLoginMethodHandler[] a(int n2) {
            return new CustomTabLoginMethodHandler[n2];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return this.a(parcel);
        }

        public /* synthetic */ Object[] newArray(int n2) {
            return this.a(n2);
        }
    };
    private vi c;

    CustomTabLoginMethodHandler(Parcel parcel) {
        super(parcel);
    }

    CustomTabLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    private boolean a(Context context) {
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        intent.setPackage("com.android.chrome");
        List list = context.getPackageManager().queryIntentServices(intent, 0);
        boolean bl2 = false;
        if (list != null) {
            boolean bl3 = list.isEmpty();
            bl2 = false;
            if (!bl3) {
                bl2 = true;
            }
        }
        return bl2;
    }

    private boolean c() {
        if (this.e() && this.a((Context)this.b.b()) && wf.c(ul.f())) {
            return true;
        }
        return false;
    }

    private boolean e() {
        we.b b2 = we.d(we.a((Context)this.b.b()));
        if (b2 != null && b2.d()) {
            return true;
        }
        return false;
    }

    @Override
    String a() {
        return "custom_tab";
    }

    @Override
    protected void a(JSONObject jSONObject) throws JSONException {
        if (this.b.a() instanceof wk) {
            jSONObject.put("7_challenge", (Object)((wk)this.b.a()).a());
        }
    }

    @Override
    boolean a(LoginClient.Request request) {
        if (!super.c()) {
            return false;
        }
        Bundle bundle = this.a(this.b(request), request);
        FragmentActivity fragmentActivity = this.b.b();
        this.c = new vi("oauth", bundle);
        this.c.a((Activity)fragmentActivity);
        return true;
    }

    @Override
    AccessTokenSource b_() {
        return AccessTokenSource.f;
    }

    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int n2) {
        super.writeToParcel(parcel, n2);
    }

}

