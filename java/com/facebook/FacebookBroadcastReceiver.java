/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  java.lang.String
 */
package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class FacebookBroadcastReceiver
extends BroadcastReceiver {
    protected void a(String string2, String string3, Bundle bundle) {
    }

    protected void b(String string2, String string3, Bundle bundle) {
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void onReceive(Context context, Intent intent) {
        String string2 = intent.getStringExtra("com.facebook.platform.protocol.CALL_ID");
        String string3 = intent.getStringExtra("com.facebook.platform.protocol.PROTOCOL_ACTION");
        if (string2 == null || string3 == null) return;
        Bundle bundle = intent.getExtras();
        if (vz.f(intent)) {
            this.b(string2, string3, bundle);
            return;
        }
        this.a(string2, string3, bundle);
    }
}

