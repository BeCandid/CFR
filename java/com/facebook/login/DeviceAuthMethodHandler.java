/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.support.v4.app.FragmentActivity
 *  android.support.v4.app.FragmentManager
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.Date
 *  java.util.concurrent.ScheduledThreadPoolExecutor
 */
package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.login.DeviceAuthDialog;
import com.facebook.login.LoginClient;
import com.facebook.login.LoginMethodHandler;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;

class DeviceAuthMethodHandler
extends LoginMethodHandler {
    public static final Parcelable.Creator<DeviceAuthMethodHandler> CREATOR = new Parcelable.Creator(){

        public DeviceAuthMethodHandler a(Parcel parcel) {
            return new DeviceAuthMethodHandler(parcel);
        }

        public DeviceAuthMethodHandler[] a(int n2) {
            return new DeviceAuthMethodHandler[n2];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return this.a(parcel);
        }

        public /* synthetic */ Object[] newArray(int n2) {
            return this.a(n2);
        }
    };
    private static ScheduledThreadPoolExecutor c;

    protected DeviceAuthMethodHandler(Parcel parcel) {
        super(parcel);
    }

    DeviceAuthMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    private void b(LoginClient.Request request) {
        DeviceAuthDialog deviceAuthDialog = new DeviceAuthDialog();
        deviceAuthDialog.show(this.b.b().getSupportFragmentManager(), "login_with_facebook");
        deviceAuthDialog.a(request);
    }

    public static ScheduledThreadPoolExecutor c() {
        reference var2 = DeviceAuthMethodHandler.class;
        synchronized (DeviceAuthMethodHandler.class) {
            if (c == null) {
                c = new ScheduledThreadPoolExecutor(1);
            }
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = c;
            // ** MonitorExit[var2] (shouldn't be in output)
            return scheduledThreadPoolExecutor;
        }
    }

    @Override
    String a() {
        return "device_auth";
    }

    public void a(Exception exception) {
        LoginClient.Result result = LoginClient.Result.a(this.b.c(), null, exception.getMessage());
        this.b.a(result);
    }

    public void a(String string2, String string3, String string4, Collection<String> collection, Collection<String> collection2, AccessTokenSource accessTokenSource, Date date, Date date2) {
        AccessToken accessToken = new AccessToken(string2, string3, string4, collection, collection2, accessTokenSource, date, date2);
        LoginClient.Result result = LoginClient.Result.a(this.b.c(), accessToken);
        this.b.a(result);
    }

    @Override
    boolean a(LoginClient.Request request) {
        super.b(request);
        return true;
    }

    public void c_() {
        LoginClient.Result result = LoginClient.Result.a(this.b.c(), "User canceled log in.");
        this.b.a(result);
    }

    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int n2) {
        super.writeToParcel(parcel, n2);
    }

}

