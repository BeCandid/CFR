/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.IntentService
 *  android.content.Context
 *  android.content.Intent
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.content.res.Resources
 *  android.preference.PreferenceManager
 *  android.util.Log
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  rx.schedulers.Schedulers
 */
package com.becandid.candid.services;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.util.Log;
import com.becandid.candid.data.EmptyClass;
import java.io.IOException;
import rx.schedulers.Schedulers;

public class RegistrationIntentService
extends IntentService {
    public RegistrationIntentService() {
        super("RegIntentService");
    }

    private void a(String string2) {
        ik.a().c(string2).a(apv.a()).b(Schedulers.io()).b(new apr<EmptyClass>(){

            public void a(EmptyClass emptyClass) {
            }

            @Override
            public void onCompleted() {
                PreferenceManager.getDefaultSharedPreferences((Context)RegistrationIntentService.this.getApplicationContext()).edit().putBoolean("sentTokenToServer", true).apply();
            }

            @Override
            public void onError(Throwable throwable) {
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((EmptyClass)object);
            }
        });
    }

    protected void onHandleIntent(Intent intent) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences((Context)this.getApplicationContext());
        aal aal2 = aal.c((Context)this);
        String string2 = this.getResources().getString(2131230847);
        try {
            String string3 = aal2.a(string2, "GCM");
            Log.d((String)"RegIntentService", (String)("GCM Registration Token: " + string3));
            super.a(string3);
            sharedPreferences.edit().putString("gcmToken", string3).apply();
            return;
        }
        catch (IOException var5_6) {
            var5_6.printStackTrace();
            return;
        }
    }

}

