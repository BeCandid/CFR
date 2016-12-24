/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.util.AttributeSet
 *  java.lang.Object
 */
package com.facebook.login.widget;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginBehavior;
import com.facebook.login.widget.LoginButton;

public class DeviceLoginButton
extends LoginButton {
    private Uri a;

    public DeviceLoginButton(Context context) {
        super(context);
    }

    public DeviceLoginButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DeviceLoginButton(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
    }

    public Uri getDeviceRedirectUri() {
        return this.a;
    }

    @Override
    protected LoginButton.b getNewLoginClickListener() {
        return new a(this, null);
    }

    public void setDeviceRedirectUri(Uri uri) {
        this.a = uri;
    }

    class a
    extends LoginButton.b {
        final /* synthetic */ DeviceLoginButton a;

        private a(DeviceLoginButton deviceLoginButton) {
            this.a = deviceLoginButton;
        }

        /* synthetic */ a(DeviceLoginButton deviceLoginButton,  var2_2) {
            super(deviceLoginButton);
        }

        @Override
        protected wm a() {
            wi wi2 = wi.a();
            wi2.a(this.a.getDefaultAudience());
            wi2.a(LoginBehavior.d);
            wi2.a(this.a.getDeviceRedirectUri());
            return wi2;
        }
    }

}

