/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.support.v4.content.WakefulBroadcastReceiver
 *  android.util.Base64
 *  android.util.Log
 *  java.lang.Object
 *  java.lang.String
 */
package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Base64;
import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceIdInternalReceiver;

public final class FirebaseInstanceIdReceiver
extends WakefulBroadcastReceiver {
    /*
     * Enabled aggressive block sorting
     */
    public void onReceive(Context context, Intent intent) {
        String string2;
        String string3;
        if (this.isOrderedBroadcast()) {
            this.setResultCode(500);
        }
        intent.setComponent(null);
        intent.setPackage(context.getPackageName());
        if (Build.VERSION.SDK_INT <= 18) {
            intent.removeCategory(context.getPackageName());
        }
        if ((string3 = intent.getStringExtra("gcm.rawData64")) != null) {
            intent.putExtra("rawData", Base64.decode((String)string3, (int)0));
            intent.removeExtra("gcm.rawData64");
        }
        String string4 = intent.getStringExtra("from");
        if ("com.google.android.c2dm.intent.REGISTRATION".equals((Object)intent.getAction()) || "google.com/iid".equals((Object)string4) || "gcm.googleapis.com/refresh".equals((Object)string4)) {
            string2 = "com.google.firebase.INSTANCE_ID_EVENT";
        } else if ("com.google.android.c2dm.intent.RECEIVE".equals((Object)intent.getAction())) {
            string2 = "com.google.firebase.MESSAGING_EVENT";
        } else {
            Log.d((String)"FirebaseInstanceId", (String)"Unexpected intent");
            string2 = null;
        }
        int n2 = -1;
        if (string2 != null) {
            n2 = FirebaseInstanceIdInternalReceiver.a(context, string2, intent);
        }
        if (!this.isOrderedBroadcast()) return;
        this.setResultCode(n2);
    }
}

