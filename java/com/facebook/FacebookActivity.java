/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Configuration
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.FragmentActivity
 *  android.support.v4.app.FragmentManager
 *  android.support.v4.app.FragmentTransaction
 *  android.util.Log
 *  java.lang.Integer
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 */
package com.facebook;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookServiceException;
import com.facebook.share.internal.DeviceShareDialogFragment;
import com.facebook.share.model.ShareContent;

public class FacebookActivity
extends FragmentActivity {
    public static String a = "PassThrough";
    private static String b = "SingleFragment";
    private static final String c = FacebookActivity.class.getName();
    private Fragment d;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void a(String string2) {
        String string3;
        String string4;
        if (string2 == null) return;
        if (!string2.startsWith(FacebookActivity.b())) return;
        Uri uri = Uri.parse((String)string2);
        Bundle bundle = we.c(uri.getQuery());
        bundle.putAll(we.c(uri.getFragment()));
        if (!(this.d instanceof wk) || !((wk)this.d).a(bundle)) {
            this.a(null, new FacebookException("Invalid state parameter"));
        }
        if ((string3 = bundle.getString("error")) == null) {
            string3 = bundle.getString("error_type");
        }
        if ((string4 = bundle.getString("error_msg")) == null) {
            string4 = bundle.getString("error_message");
        }
        if (string4 == null) {
            string4 = bundle.getString("error_description");
        }
        String string5 = bundle.getString("error_code");
        int n2 = -1;
        if (!we.a(string5)) {
            try {
                int n3;
                n2 = n3 = Integer.parseInt((String)string5);
            }
            catch (NumberFormatException var8_9) {
                n2 = -1;
            }
        }
        if (we.a(string3) && we.a(string4) && n2 == -1) {
            this.a(bundle, null);
            return;
        }
        if (string3 != null && (string3.equals((Object)"access_denied") || string3.equals((Object)"OAuthAccessDeniedException"))) {
            this.a(null, new FacebookOperationCanceledException());
            return;
        }
        if (n2 == 4201) {
            this.a(null, new FacebookOperationCanceledException());
            return;
        }
        this.a(null, new FacebookServiceException(new FacebookRequestError(n2, string3, string4), string4));
    }

    private static final String b() {
        return "fb" + ul.i() + "://authorize";
    }

    private void c() {
        this.a(null, vz.a(vz.d(this.getIntent())));
    }

    public Fragment a() {
        return this.d;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(Bundle bundle, FacebookException facebookException) {
        int n2;
        Intent intent = this.getIntent();
        if (facebookException == null) {
            n2 = -1;
            wm.a(intent, bundle);
        } else {
            intent = vz.a(intent, bundle, facebookException);
            n2 = 0;
        }
        this.setResult(n2, intent);
        this.finish();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.d != null) {
            this.d.onConfigurationChanged(configuration);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!ul.a()) {
            Log.d((String)c, (String)"Facebook SDK not initialized. Make sure you call sdkInitialize inside your Application's onCreate method.");
            ul.a(this.getApplicationContext());
        }
        this.setContentView(uu.e.com_facebook_activity_layout);
        Intent intent = this.getIntent();
        if (a.equals((Object)intent.getAction())) {
            super.c();
            return;
        }
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        Object object = fragmentManager.findFragmentByTag(b);
        if (object == null) {
            if ("FacebookDialogFragment".equals((Object)intent.getAction())) {
                vm vm2 = new vm();
                vm2.setRetainInstance(true);
                vm2.show(fragmentManager, b);
                object = vm2;
            } else if ("DeviceShareDialogFragment".equals((Object)intent.getAction())) {
                DeviceShareDialogFragment deviceShareDialogFragment = new DeviceShareDialogFragment();
                deviceShareDialogFragment.setRetainInstance(true);
                deviceShareDialogFragment.a((ShareContent)intent.getParcelableExtra("content"));
                deviceShareDialogFragment.show(fragmentManager, b);
                object = deviceShareDialogFragment;
            } else {
                object = new wk();
                object.setRetainInstance(true);
                fragmentManager.beginTransaction().add(uu.d.com_facebook_fragment_container, (Fragment)object, b).commit();
            }
        }
        this.d = object;
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        super.a(intent.getStringExtra("url"));
    }
}

