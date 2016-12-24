/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  java.lang.Object
 *  java.lang.String
 */
package com.becandid.candid.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.becandid.candid.GossipApplication;

public class ConnectivityReceiver
extends BroadcastReceiver {
    public static a a;

    public static boolean a() {
        NetworkInfo networkInfo = ((ConnectivityManager)GossipApplication.a().getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void onReceive(Context context, Intent intent) {
        NetworkInfo networkInfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        boolean bl2 = networkInfo != null && networkInfo.isConnectedOrConnecting();
        if (a == null) return;
        a.onNetworkConnectionChanged(bl2);
    }

    public static interface a {
        public void onNetworkConnectionChanged(boolean var1);
    }

}

