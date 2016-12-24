/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.support.v4.app.FragmentActivity
 *  android.util.Base64
 *  android.util.Log
 *  java.io.UnsupportedEncodingException
 *  java.lang.Double
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Date
 *  java.util.HashMap
 *  java.util.Map
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.facebook.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.util.Base64;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginClient;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class LoginMethodHandler
implements Parcelable {
    Map<String, String> a;
    protected LoginClient b;

    LoginMethodHandler(Parcel parcel) {
        this.a = we.a(parcel);
    }

    LoginMethodHandler(LoginClient loginClient) {
        this.b = loginClient;
    }

    static AccessToken a(Bundle bundle, AccessTokenSource accessTokenSource, String string2) {
        Date date = we.a(bundle, "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH", new Date(0));
        ArrayList arrayList = bundle.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
        String string3 = bundle.getString("com.facebook.platform.extra.ACCESS_TOKEN");
        if (we.a(string3)) {
            return null;
        }
        return new AccessToken(string3, string2, bundle.getString("com.facebook.platform.extra.USER_ID"), (Collection<String>)arrayList, null, accessTokenSource, date, new Date());
    }

    public static AccessToken a(Collection<String> arrayList, Bundle bundle, AccessTokenSource accessTokenSource, String string2) throws FacebookException {
        Date date = we.a(bundle, "expires_in", new Date());
        String string3 = bundle.getString("access_token");
        String string4 = bundle.getString("granted_scopes");
        if (!we.a(string4)) {
            arrayList = new ArrayList((Collection)Arrays.asList((Object[])string4.split(",")));
        }
        String string5 = bundle.getString("denied_scopes");
        boolean bl2 = we.a(string5);
        ArrayList arrayList2 = null;
        if (!bl2) {
            arrayList2 = new ArrayList((Collection)Arrays.asList((Object[])string5.split(",")));
        }
        if (we.a(string3)) {
            return null;
        }
        String string6 = LoginMethodHandler.c(bundle.getString("signed_request"));
        Date date2 = new Date();
        return new AccessToken(string3, string2, string6, (Collection<String>)arrayList, (Collection<String>)arrayList2, accessTokenSource, date, date2);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static String c(String string2) throws FacebookException {
        if (string2 == null) throw new FacebookException("Authorization response does not contain the signed_request");
        if (string2.isEmpty()) {
            throw new FacebookException("Authorization response does not contain the signed_request");
        }
        try {
            String[] arrstring = string2.split("\\.");
            if (arrstring.length != 2) throw new FacebookException("Failed to retrieve user_id from signed_request");
            return new JSONObject(new String(Base64.decode((String)arrstring[1], (int)0), "UTF-8")).getString("user_id");
        }
        catch (JSONException var2_3) {
            // empty catch block
        }
        throw new FacebookException("Failed to retrieve user_id from signed_request");
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new FacebookException("Failed to retrieve user_id from signed_request");
        }
    }

    abstract String a();

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected String a(String string2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("0_auth_logger_id", (Object)string2);
            jSONObject.put("3_method", (Object)this.a());
            this.a(jSONObject);
        }
        catch (JSONException var3_3) {
            Log.w((String)"LoginMethodHandler", (String)("Error creating client state json: " + var3_3.getMessage()));
            return jSONObject.toString();
        }
        do {
            return jSONObject.toString();
            break;
        } while (true);
    }

    void a(LoginClient loginClient) {
        if (this.b != null) {
            throw new FacebookException("Can't set LoginClient if it is already set.");
        }
        this.b = loginClient;
    }

    /*
     * Enabled aggressive block sorting
     */
    protected void a(String string2, Object object) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        Map<String, String> map = this.a;
        String string3 = object == null ? null : object.toString();
        map.put((Object)string2, (Object)string3);
    }

    void a(JSONObject jSONObject) throws JSONException {
    }

    boolean a(int n2, int n3, Intent intent) {
        return false;
    }

    abstract boolean a(LoginClient.Request var1);

    void b() {
    }

    protected void b(String string2) {
        String string3 = this.b.c().d();
        AppEventsLogger appEventsLogger = AppEventsLogger.a((Context)this.b.b(), string3);
        Bundle bundle = new Bundle();
        bundle.putString("fb_web_login_e2e", string2);
        bundle.putLong("fb_web_login_switchback_time", System.currentTimeMillis());
        bundle.putString("app_id", string3);
        appEventsLogger.a("fb_dialogs_web_login_dialog_complete", null, bundle);
    }

    boolean d() {
        return false;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        we.a(parcel, this.a);
    }
}

