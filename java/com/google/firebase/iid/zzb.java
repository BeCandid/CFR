/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Service
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.Looper
 *  android.os.Message
 *  android.support.v4.content.WakefulBroadcastReceiver
 *  android.util.Log
 *  com.google.android.gms.iid.MessengerCompat
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Executors
 */
package com.google.firebase.iid;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import com.google.android.gms.iid.MessengerCompat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class zzb
extends Service {
    MessengerCompat a;
    final ExecutorService b;
    private final Object c;
    private int d;
    private int e;

    public zzb() {
        this.a = new MessengerCompat(new Handler(Looper.getMainLooper()){

            public void handleMessage(Message message) {
                int n2 = MessengerCompat.a((Message)message);
                aic.a((Context)zzb.this);
                zzb.this.getPackageManager();
                if (n2 != aic.c && n2 != aic.b) {
                    int n3 = aic.b;
                    int n4 = aic.c;
                    Log.w((String)"FirebaseInstanceId", (String)new StringBuilder(77).append("Message from unexpected caller ").append(n2).append(" mine=").append(n3).append(" appid=").append(n4).toString());
                    return;
                }
                zzb.this.b((Intent)message.obj);
            }
        });
        this.b = Executors.newSingleThreadExecutor();
        this.c = new Object();
        this.e = 0;
    }

    protected int a(final Intent intent) {
        this.b.execute(new Runnable(){

            public void run() {
                zzb.this.b(intent);
                zzb.this.b();
            }
        });
        return 3;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void b() {
        Object object;
        Object object2 = object = this.c;
        synchronized (object2) {
            this.e = -1 + this.e;
            if (this.e == 0) {
                this.b(this.d);
            }
            return;
        }
    }

    public abstract void b(Intent var1);

    boolean b(int n2) {
        return this.stopSelfResult(n2);
    }

    protected abstract Intent c(Intent var1);

    public final IBinder onBind(Intent intent) {
        if (intent != null && "com.google.firebase.INSTANCE_ID_EVENT".equals((Object)intent.getAction())) {
            return this.a.a();
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final int onStartCommand(Intent intent, int n2, int n3) {
        Object object;
        int n4;
        Object object2 = object = this.c;
        synchronized (object2) {
            this.d = n3;
            this.e = 1 + this.e;
        }
        Intent intent2 = this.c(intent);
        if (intent2 == null) {
            this.b();
            return 2;
        }
        try {
            int n5;
            n4 = n5 = this.a(intent2);
        }
        catch (Throwable var7_9) {
            if (intent2.getStringExtra("from") == null) throw var7_9;
            WakefulBroadcastReceiver.a((Intent)intent2);
            throw var7_9;
        }
        if (intent2.getStringExtra("from") == null) return n4;
        WakefulBroadcastReceiver.a((Intent)intent2);
        return n4;
    }

}

