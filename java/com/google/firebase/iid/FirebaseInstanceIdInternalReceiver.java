/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.content.pm.ResolveInfo
 *  android.content.pm.ServiceInfo
 *  android.os.Parcelable
 *  android.support.v4.content.WakefulBroadcastReceiver
 *  android.util.Log
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.SecurityException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.LinkedList
 *  java.util.Queue
 */
package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Parcelable;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import java.util.LinkedList;
import java.util.Queue;

public final class FirebaseInstanceIdInternalReceiver
extends WakefulBroadcastReceiver {
    private static final Queue<Intent> a = new LinkedList();
    private static final Queue<Intent> b = new LinkedList();

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    static int a(Context var0_1, String var1, Intent var2_2) {
        var3_3 = -1;
        switch (var1.hashCode()) {
            case -842411455: {
                if (var1.equals((Object)"com.google.firebase.INSTANCE_ID_EVENT")) {
                    var3_3 = 0;
                }
            }
            default: {
                ** GOTO lbl11
            }
            case 41532704: 
        }
        if (var1.equals((Object)"com.google.firebase.MESSAGING_EVENT")) {
            var3_3 = 1;
        }
lbl11: // 4 sources:
        switch (var3_3) {
            default: {
                var8_4 = String.valueOf((Object)var1);
                var9_5 = var8_4.length() != 0 ? "Unknown service action: ".concat(var8_4) : new String("Unknown service action: ");
            }
            case 0: {
                FirebaseInstanceIdInternalReceiver.a.offer((Object)var2_2);
                break;
            }
            case 1: {
                FirebaseInstanceIdInternalReceiver.b.offer((Object)var2_2);
            }
        }
        var5_6 = new Intent(var1);
        var5_6.setPackage(var0_1.getPackageName());
        return FirebaseInstanceIdInternalReceiver.c(var0_1, var5_6);
        Log.w((String)"FirebaseInstanceId", (String)var9_5);
        return 500;
    }

    public static Intent a() {
        return (Intent)a.poll();
    }

    public static Intent b(Context context, Intent intent) {
        return FirebaseInstanceIdInternalReceiver.b(context, "com.google.firebase.INSTANCE_ID_EVENT", intent);
    }

    private static Intent b(Context context, String string2, Intent intent) {
        Intent intent2 = new Intent(context, (Class)FirebaseInstanceIdInternalReceiver.class);
        intent2.setAction(string2);
        intent2.putExtra("wrapped_intent", (Parcelable)intent);
        return intent2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static int c(Context context, Intent intent) {
        FirebaseInstanceIdInternalReceiver.d(context, intent);
        try {
            ComponentName componentName;
            if (context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
                componentName = FirebaseInstanceIdInternalReceiver.a((Context)context, (Intent)intent);
            } else {
                componentName = context.startService(intent);
                Log.d((String)"FirebaseInstanceId", (String)"Missing wake lock permission, service start may be delayed");
            }
            if (componentName != null) return -1;
            {
                Log.e((String)"FirebaseInstanceId", (String)"Error while delivering the message: ServiceIntent not found.");
                return 404;
            }
        }
        catch (SecurityException var2_3) {
            Log.e((String)"FirebaseInstanceId", (String)"Error while delivering the message to the serviceIntent", (Throwable)var2_3);
            return 401;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private static void d(Context context, Intent intent) {
        ResolveInfo resolveInfo = context.getPackageManager().resolveService(intent, 0);
        if (resolveInfo == null || resolveInfo.serviceInfo == null) {
            Log.e((String)"FirebaseInstanceId", (String)"Failed to resolve target intent service, skipping classname enforcement");
            return;
        }
        ServiceInfo serviceInfo = resolveInfo.serviceInfo;
        if (!context.getPackageName().equals((Object)serviceInfo.packageName) || serviceInfo.name == null) {
            String string2 = String.valueOf((Object)serviceInfo.packageName);
            String string3 = String.valueOf((Object)serviceInfo.name);
            Log.e((String)"FirebaseInstanceId", (String)new StringBuilder(94 + String.valueOf((Object)string2).length() + String.valueOf((Object)string3).length()).append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ").append(string2).append("/").append(string3).toString());
            return;
        }
        String string4 = serviceInfo.name;
        if (string4.startsWith(".")) {
            String string5 = String.valueOf((Object)context.getPackageName());
            String string6 = String.valueOf((Object)string4);
            string4 = string6.length() != 0 ? string5.concat(string6) : new String(string5);
        }
        if (Log.isLoggable((String)"FirebaseInstanceId", (int)3)) {
            String string7 = String.valueOf((Object)string4);
            String string8 = string7.length() != 0 ? "Restricting intent to a specific service: ".concat(string7) : new String("Restricting intent to a specific service: ");
            Log.d((String)"FirebaseInstanceId", (String)string8);
        }
        intent.setClassName(context.getPackageName(), string4);
    }

    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        Intent intent2 = (Intent)intent.getParcelableExtra("wrapped_intent");
        if (intent2 == null) {
            Log.w((String)"FirebaseInstanceId", (String)"Missing wrapped intent");
            return;
        }
        FirebaseInstanceIdInternalReceiver.a(context, intent.getAction(), intent2);
    }
}

