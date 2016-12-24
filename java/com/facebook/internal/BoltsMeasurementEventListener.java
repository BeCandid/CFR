/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.os.Bundle
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Set
 */
package com.facebook.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.facebook.appevents.AppEventsLogger;
import java.util.Set;

public class BoltsMeasurementEventListener
extends BroadcastReceiver {
    private static BoltsMeasurementEventListener a;
    private Context b;

    private BoltsMeasurementEventListener(Context context) {
        this.b = context.getApplicationContext();
    }

    public static BoltsMeasurementEventListener a(Context context) {
        if (a != null) {
            return a;
        }
        a = new BoltsMeasurementEventListener(context);
        a.a();
        return a;
    }

    private void a() {
        bn.a(this.b).a(this, new IntentFilter("com.parse.bolts.measurement_event"));
    }

    private void b() {
        bn.a(this.b).a(this);
    }

    protected void finalize() throws Throwable {
        try {
            this.b();
            return;
        }
        finally {
            super.finalize();
        }
    }

    public void onReceive(Context context, Intent intent) {
        AppEventsLogger appEventsLogger = AppEventsLogger.a(context);
        String string2 = "bf_" + intent.getStringExtra("event_name");
        Bundle bundle = intent.getBundleExtra("event_args");
        Bundle bundle2 = new Bundle();
        for (String string3 : bundle.keySet()) {
            bundle2.putString(string3.replaceAll("[^0-9a-zA-Z _-]", "-").replaceAll("^[ -]*", "").replaceAll("[ -]*$", ""), (String)bundle.get(string3));
        }
        appEventsLogger.a(string2, bundle2);
    }
}

