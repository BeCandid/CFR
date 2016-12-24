/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Bundle
 *  android.support.annotation.Keep
 *  android.util.Base64
 *  android.util.Log
 *  java.io.IOException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.security.KeyPair
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 *  java.security.PublicKey
 *  java.util.Map
 */
package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.util.Base64;
import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceIdInternalReceiver;
import com.google.firebase.iid.FirebaseInstanceIdService;
import java.io.IOException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.Map;

public class FirebaseInstanceId {
    private static Map<String, FirebaseInstanceId> a = new dh<String, FirebaseInstanceId>();
    private static aib b;
    private final ahv c;
    private final aia d;
    private final String e;

    private FirebaseInstanceId(ahv ahv2, aia aia2) {
        this.c = ahv2;
        this.d = aia2;
        this.e = this.b();
        if (this.e == null) {
            throw new IllegalStateException("IID failing to initialize, FirebaseApp is missing project ID");
        }
        FirebaseInstanceIdService.a(this.c.a(), (FirebaseInstanceId)this);
    }

    public static FirebaseInstanceId a() {
        return FirebaseInstanceId.getInstance(ahv.d());
    }

    public static String a(Context context) {
        return FirebaseInstanceId.a().c.c().a();
    }

    public static String a(KeyPair keyPair) {
        byte[] arrby = keyPair.getPublic().getEncoded();
        try {
            byte[] arrby2 = MessageDigest.getInstance((String)"SHA1").digest(arrby);
            arrby2[0] = (byte)(255 & 112 + (15 & arrby2[0]));
            String string2 = Base64.encodeToString((byte[])arrby2, (int)0, (int)8, (int)11);
            return string2;
        }
        catch (NoSuchAlgorithmException var2_4) {
            Log.w((String)"FirebaseInstanceId", (String)"Unexpected error, device missing required alghorithms");
            return null;
        }
    }

    public static String a(byte[] arrby) {
        return Base64.encodeToString((byte[])arrby, (int)11);
    }

    public static void a(Context context, aid aid2) {
        aid2.c();
        Intent intent = new Intent();
        intent.putExtra("CMD", "RST");
        context.sendBroadcast(FirebaseInstanceIdInternalReceiver.b(context, intent));
    }

    public static int b(Context context) {
        try {
            int n2 = context.getPackageManager().getPackageInfo((String)context.getPackageName(), (int)0).versionCode;
            return n2;
        }
        catch (PackageManager.NameNotFoundException var1_2) {
            String string2 = String.valueOf((Object)var1_2);
            Log.w((String)"FirebaseInstanceId", (String)new StringBuilder(38 + String.valueOf((Object)string2).length()).append("Never happens: can't find own package ").append(string2).toString());
            return 0;
        }
    }

    public static String c(Context context) {
        try {
            String string2 = context.getPackageManager().getPackageInfo((String)context.getPackageName(), (int)0).versionName;
            return string2;
        }
        catch (PackageManager.NameNotFoundException var1_2) {
            String string3 = String.valueOf((Object)var1_2);
            Log.w((String)"FirebaseInstanceId", (String)new StringBuilder(38 + String.valueOf((Object)string3).length()).append("Never happens: can't find own package ").append(string3).toString());
            return null;
        }
    }

    public static void d(Context context) {
        Intent intent = new Intent();
        intent.setPackage(context.getPackageName());
        intent.putExtra("CMD", "SYNC");
        context.sendBroadcast(FirebaseInstanceIdInternalReceiver.b(context, intent));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Keep
    public static FirebaseInstanceId getInstance(ahv ahv2) {
        reference var5_1 = FirebaseInstanceId.class;
        synchronized (FirebaseInstanceId.class) {
            FirebaseInstanceId firebaseInstanceId = (FirebaseInstanceId)a.get((Object)ahv2.c().a());
            if (firebaseInstanceId == null) {
                aia aia2 = aia.a(ahv2.a(), null);
                if (b == null) {
                    b = new aib(aia2.c());
                }
                firebaseInstanceId = new FirebaseInstanceId(ahv2, aia2);
                a.put((Object)ahv2.c().a(), (Object)firebaseInstanceId);
            }
            // ** MonitorExit[var5_1] (shouldn't be in output)
            return firebaseInstanceId;
        }
    }

    public String a(String string2, String string3) throws IOException {
        return this.d.b(string2, string3, null);
    }

    /*
     * Enabled aggressive block sorting
     */
    void a(String string2) throws IOException {
        if (this.d() == null) {
            throw new IOException("token not available");
        }
        Bundle bundle = new Bundle();
        String string3 = String.valueOf((Object)"/topics/");
        String string4 = String.valueOf((Object)string2);
        String string5 = string4.length() != 0 ? string3.concat(string4) : new String(string3);
        bundle.putString("gcm.topic", string5);
        aia aia2 = this.d;
        String string6 = this.d();
        String string7 = String.valueOf((Object)"/topics/");
        String string8 = String.valueOf((Object)string2);
        String string9 = string8.length() != 0 ? string7.concat(string8) : new String(string7);
        aia2.b(string6, string9, bundle);
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    String b() {
        String string2 = this.c.c().b();
        if (string2 != null) {
            return string2;
        }
        string2 = this.c.c().a();
        if (!string2.startsWith("1:")) return string2;
        String[] arrstring = string2.split(":");
        if (arrstring.length < 2) {
            return null;
        }
        string2 = arrstring[1];
        if (!string2.isEmpty()) return string2;
        return null;
    }

    /*
     * Enabled aggressive block sorting
     */
    void b(String string2) throws IOException {
        if (this.d() == null) {
            throw new IOException("token not available");
        }
        Bundle bundle = new Bundle();
        String string3 = String.valueOf((Object)"/topics/");
        String string4 = String.valueOf((Object)string2);
        String string5 = string4.length() != 0 ? string3.concat(string4) : new String(string3);
        bundle.putString("gcm.topic", string5);
        aia aia2 = this.d;
        String string6 = this.d();
        String string7 = String.valueOf((Object)"/topics/");
        String string8 = String.valueOf((Object)string2);
        String string9 = string8.length() != 0 ? string7.concat(string8) : new String(string7);
        aia2.a(string6, string9, bundle);
    }

    public String c() {
        return FirebaseInstanceId.a(this.d.a());
    }

    public String d() {
        String string2 = this.e();
        if (string2 == null) {
            FirebaseInstanceIdService.a(this.c.a());
        }
        return string2;
    }

    String e() {
        return this.d.c().a("", this.e, "*");
    }

    String f() throws IOException {
        return this.a(this.e, "*");
    }

    aib g() {
        return b;
    }
}

