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
 *  android.os.Looper
 *  android.util.Base64
 *  android.util.Log
 *  java.io.IOException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.security.KeyPair
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 *  java.security.PublicKey
 *  java.util.HashMap
 *  java.util.Map
 */
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import java.io.IOException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

public class aal {
    static Map<String, aal> a = new HashMap();
    static String f;
    private static aap g;
    private static aao h;
    Context b;
    KeyPair c;
    String d = "";
    long e;

    protected aal(Context context, String string2, Bundle bundle) {
        this.b = context.getApplicationContext();
        this.d = string2;
    }

    static int a(Context context) {
        try {
            int n2 = context.getPackageManager().getPackageInfo((String)context.getPackageName(), (int)0).versionCode;
            return n2;
        }
        catch (PackageManager.NameNotFoundException var1_2) {
            String string2 = String.valueOf((Object)var1_2);
            Log.w((String)"InstanceID", (String)new StringBuilder(38 + String.valueOf((Object)string2).length()).append("Never happens: can't find own package ").append(string2).toString());
            return 0;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static aal a(Context context, Bundle bundle) {
        reference var9_2 = aal.class;
        synchronized (aal.class) {
            String string2;
            String string3 = bundle == null ? "" : (string2 = bundle.getString("subtype"));
            String string4 = string3 == null ? "" : string3;
            Context context2 = context.getApplicationContext();
            if (g == null) {
                g = new aap(context2);
                h = new aao(context2);
            }
            f = Integer.toString((int)aal.a(context2));
            aal aal2 = (aal)a.get((Object)string4);
            if (aal2 == null) {
                aal2 = new aal(context2, string4, bundle);
                a.put((Object)string4, (Object)aal2);
            }
            // ** MonitorExit[var9_2] (shouldn't be in output)
            return aal2;
        }
    }

    static String a(KeyPair keyPair) {
        byte[] arrby = keyPair.getPublic().getEncoded();
        try {
            byte[] arrby2 = MessageDigest.getInstance((String)"SHA1").digest(arrby);
            arrby2[0] = (byte)(255 & 112 + (15 & arrby2[0]));
            String string2 = Base64.encodeToString((byte[])arrby2, (int)0, (int)8, (int)11);
            return string2;
        }
        catch (NoSuchAlgorithmException var2_4) {
            Log.w((String)"InstanceID", (String)"Unexpected error, device missing required alghorithms");
            return null;
        }
    }

    static String a(byte[] arrby) {
        return Base64.encodeToString((byte[])arrby, (int)11);
    }

    static String b(Context context) {
        try {
            String string2 = context.getPackageManager().getPackageInfo((String)context.getPackageName(), (int)0).versionName;
            return string2;
        }
        catch (PackageManager.NameNotFoundException var1_2) {
            String string3 = String.valueOf((Object)var1_2);
            Log.w((String)"InstanceID", (String)new StringBuilder(38 + String.valueOf((Object)string3).length()).append("Never happens: can't find own package ").append(string3).toString());
            return null;
        }
    }

    public static aal c(Context context) {
        return aal.a(context, null);
    }

    public String a(String string2, String string3) throws IOException {
        return this.a(string2, string3, null);
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public String a(String string2, String string3, Bundle bundle) throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        boolean bl2 = true;
        String string4 = this.e() ? null : g.a(this.d, string2, string3);
        if (string4 != null) {
            return string4;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (bundle.getString("ttl") != null) {
            bl2 = false;
        }
        boolean bl3 = "jwt".equals((Object)bundle.getString("type"));
        boolean bl4 = false;
        if (!bl3) {
            bl4 = bl2;
        }
        if ((string4 = this.b(string2, string3, bundle)) == null) return string4;
        if (!bl4) return string4;
        g.a(this.d, string2, string3, string4, f);
        return string4;
    }

    KeyPair a() {
        if (this.c == null) {
            this.c = g.c(this.d);
        }
        if (this.c == null) {
            this.e = System.currentTimeMillis();
            this.c = g.a(this.d, this.e);
        }
        return this.c;
    }

    /*
     * Enabled aggressive block sorting
     */
    public String b(String string2, String string3, Bundle bundle) throws IOException {
        if (string3 != null) {
            bundle.putString("scope", string3);
        }
        bundle.putString("sender", string2);
        String string4 = "".equals((Object)this.d) ? string2 : this.d;
        if (!bundle.containsKey("legacy.register")) {
            bundle.putString("subscription", string2);
            bundle.putString("subtype", string4);
            bundle.putString("X-subscription", string2);
            bundle.putString("X-subtype", string4);
        }
        Intent intent = h.a(bundle, this.a());
        return h.b(intent);
    }

    public void b() {
        this.e = 0;
        g.d(this.d);
        this.c = null;
    }

    public aap c() {
        return g;
    }

    public aao d() {
        return h;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    boolean e() {
        String string2 = g.a("appVersion");
        if (string2 == null) return true;
        if (!string2.equals((Object)f)) {
            return true;
        }
        String string3 = g.a("lastToken");
        if (string3 == null) return true;
        Long l2 = Long.parseLong((String)string3);
        if (System.currentTimeMillis() / 1000 - l2 > 604800) return true;
        return false;
    }
}

