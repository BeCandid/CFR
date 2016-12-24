/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.AlarmManager
 *  android.app.PendingIntent
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  android.os.Bundle
 *  android.os.SystemClock
 *  android.util.Log
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.google.firebase.iid;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdInternalReceiver;
import com.google.firebase.iid.zzb;

public class FirebaseInstanceIdService
extends zzb {
    private static BroadcastReceiver c;
    private static final Object d;
    private static boolean e;
    private boolean f = false;

    static {
        d = new Object();
        e = false;
    }

    private aia a(String string2) {
        if (string2 == null) {
            return aia.a((Context)this, null);
        }
        Bundle bundle = new Bundle();
        bundle.putString("subtype", string2);
        return aia.a((Context)this, bundle);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static void a(Context context) {
        Object object;
        Object object2 = object = d;
        synchronized (object2) {
            if (!e) {
                context.sendBroadcast(FirebaseInstanceIdService.c(0));
                e = true;
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    static void a(Context context, FirebaseInstanceId firebaseInstanceId) {
        Object object;
        Object object2 = object = d;
        // MONITORENTER : object2
        if (e) {
            // MONITOREXIT : object2
            return;
        }
        // MONITOREXIT : object2
        if (firebaseInstanceId.e() != null) {
            if (firebaseInstanceId.g().a() == null) return;
        }
        FirebaseInstanceIdService.a(context);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void a(Intent intent, String string2) {
        Object object;
        boolean bl2 = FirebaseInstanceIdService.c((Context)this);
        final int n2 = super.b(intent, bl2);
        Log.d((String)"FirebaseInstanceId", (String)new StringBuilder(47 + String.valueOf((Object)string2).length()).append("background sync failed: ").append(string2).append(", retry in ").append(n2).append("s").toString());
        Object object2 = object = d;
        // MONITORENTER : object2
        super.d(n2);
        e = true;
        // MONITOREXIT : object2
        if (bl2) return;
        if (this.f) {
            Log.d((String)"FirebaseInstanceId", (String)"device not connected. Connectivity change received registered");
        }
        if (c == null) {
            c = new BroadcastReceiver(){

                public void onReceive(Context context, Intent intent) {
                    if (FirebaseInstanceIdService.c(context)) {
                        if (FirebaseInstanceIdService.this.f) {
                            Log.d((String)"FirebaseInstanceId", (String)"connectivity changed. starting background sync.");
                        }
                        FirebaseInstanceIdService.this.getApplicationContext().unregisterReceiver((BroadcastReceiver)this);
                        context.sendBroadcast(FirebaseInstanceIdService.c(n2));
                    }
                }
            };
        }
        this.getApplicationContext().registerReceiver(c, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    /*
     * Exception decompiling
     */
    private void a(Intent var1, boolean var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Extractable last case doesn't follow previous
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.examineSwitchContiguity(SwitchReplacer.java:486)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.replaceRawSwitches(SwitchReplacer.java:65)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:422)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:128)
        // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Enabled aggressive block sorting
     */
    private int b(Intent intent, boolean bl2) {
        int n2 = 10;
        int n3 = intent == null ? n2 : intent.getIntExtra("next_retry_delay_in_seconds", 0);
        if (n3 < n2 && !bl2) {
            return 30;
        }
        if (n3 < n2) return n2;
        if (n3 <= 28800) return n3;
        return 28800;
    }

    private static Intent c(int n2) {
        Context context = ahv.d().a();
        Intent intent = new Intent("ACTION_TOKEN_REFRESH_RETRY");
        intent.putExtra("next_retry_delay_in_seconds", n2);
        return FirebaseInstanceIdInternalReceiver.b(context, intent);
    }

    private static boolean c(Context context) {
        NetworkInfo networkInfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    private void d(int n2) {
        AlarmManager alarmManager = (AlarmManager)this.getSystemService("alarm");
        PendingIntent pendingIntent = PendingIntent.getBroadcast((Context)this, (int)0, (Intent)FirebaseInstanceIdService.c(n2 * 2), (int)268435456);
        alarmManager.set(3, SystemClock.elapsedRealtime() + (long)(n2 * 1000), pendingIntent);
    }

    private String e(Intent intent) {
        String string2 = intent.getStringExtra("subtype");
        if (string2 == null) {
            string2 = "";
        }
        return string2;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    protected int a(Intent intent) {
        this.f = Log.isLoggable((String)"FirebaseInstanceId", (int)3);
        if (intent.getStringExtra("error") == null && intent.getStringExtra("registration_id") == null) {
            return super.a(intent);
        }
        String string2 = super.e(intent);
        if (this.f) {
            String string3 = String.valueOf((Object)string2);
            String string4 = string3.length() != 0 ? "Register result in service ".concat(string3) : new String("Register result in service ");
            Log.d((String)"FirebaseInstanceId", (String)string4);
        }
        super.a(string2).d().d(intent);
        this.b();
        return 2;
    }

    public void a() {
    }

    /*
     * Exception decompiling
     */
    @Override
    public void b(Intent var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Extractable last case doesn't follow previous
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.examineSwitchContiguity(SwitchReplacer.java:486)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.replaceRawSwitches(SwitchReplacer.java:65)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:422)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:128)
        // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    @Override
    protected Intent c(Intent intent) {
        return FirebaseInstanceIdInternalReceiver.a();
    }

    /*
     * Enabled aggressive block sorting
     */
    public void d(Intent intent) {
        String string2 = super.e(intent);
        aia aia2 = super.a(string2);
        String string3 = intent.getStringExtra("CMD");
        if (this.f) {
            String string4 = String.valueOf((Object)intent.getExtras());
            Log.d((String)"FirebaseInstanceId", (String)new StringBuilder(18 + String.valueOf((Object)string2).length() + String.valueOf((Object)string3).length() + String.valueOf((Object)string4).length()).append("Service command ").append(string2).append(" ").append(string3).append(" ").append(string4).toString());
        }
        if (intent.getStringExtra("unregistered") != null) {
            aid aid2 = aia2.c();
            if (string2 == null) {
                string2 = "";
            }
            aid2.e(string2);
            aia2.d().d(intent);
            return;
        } else {
            if ("gcm.googleapis.com/refresh".equals((Object)intent.getStringExtra("from"))) {
                aia2.c().e(string2);
                super.a(intent, false);
                return;
            }
            if ("RST".equals((Object)string3)) {
                aia2.b();
                super.a(intent, true);
                return;
            }
            if ("RST_FULL".equals((Object)string3)) {
                if (aia2.c().b()) return;
                {
                    aia2.c().c();
                    super.a(intent, true);
                    return;
                }
            } else {
                if ("SYNC".equals((Object)string3)) {
                    aia2.c().e(string2);
                    super.a(intent, false);
                    return;
                }
                if (!"PING".equals((Object)string3)) return;
                return;
            }
        }
    }

}

