/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.os.Bundle
 *  android.text.TextUtils
 *  com.google.android.gms.measurement.internal.zzw
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.zzw;

public class agr
extends ahm {
    static final String a = String.valueOf((int)(aaa.b / 1000)).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
    private Boolean b;

    agr(ahk ahk2) {
        super(ahk2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Boolean g(String string2) {
        xz.a(string2);
        try {
            PackageManager packageManager = this.q().getPackageManager();
            if (packageManager == null) {
                this.w().f().a("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(this.q().getPackageName(), 128);
            if (applicationInfo == null) {
                this.w().f().a("Failed to load metadata: ApplicationInfo is null");
                return null;
            }
            if (applicationInfo.metaData == null) {
                this.w().f().a("Failed to load metadata: Metadata bundle is null");
                return null;
            }
        }
        catch (PackageManager.NameNotFoundException var3_4) {
            this.w().f().a("Failed to load metadata: Package name not found", (Object)var3_4);
            return null;
        }
        boolean bl2 = applicationInfo.metaData.containsKey(string2);
        Boolean bl3 = null;
        if (!bl2) return bl3;
        Boolean bl4 = applicationInfo.metaData.getBoolean(string2);
        return bl4;
    }

    public int A() {
        return 2048;
    }

    int B() {
        return 500;
    }

    public long C() {
        return agz.m.b().intValue();
    }

    public long D() {
        return agz.n.b().intValue();
    }

    public long E() {
        return 1000;
    }

    int F() {
        return 25;
    }

    int G() {
        return 50;
    }

    long H() {
        return 3600000;
    }

    long I() {
        return 60000;
    }

    long J() {
        return 61000;
    }

    long K() {
        return agz.A.b();
    }

    public String L() {
        return "google_app_measurement.db";
    }

    public String M() {
        return "google_app_measurement2.db";
    }

    public long N() {
        return 9080;
    }

    public boolean O() {
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean P() {
        if (this.b == null) {
            agr agr2 = this;
            synchronized (agr2) {
                if (this.b == null) {
                    ApplicationInfo applicationInfo = this.q().getApplicationInfo();
                    String string2 = zu.b();
                    if (applicationInfo != null) {
                        String string3 = applicationInfo.processName;
                        boolean bl2 = string3 != null && string3.equals((Object)string2);
                        this.b = bl2;
                    }
                    if (this.b == null) {
                        this.b = Boolean.TRUE;
                        this.w().f().a("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.b;
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean Q() {
        Boolean bl2;
        if (this.O() || (bl2 = this.g("firebase_analytics_collection_deactivated")) == null || bl2.booleanValue()) {
            return false;
        }
        return true;
    }

    public Boolean R() {
        if (this.O()) {
            return null;
        }
        return this.g("firebase_analytics_collection_enabled");
    }

    public boolean S() {
        return abh.b();
    }

    public long T() {
        return agz.y.b();
    }

    public long U() {
        return agz.u.b();
    }

    public long V() {
        return 1000;
    }

    public long W() {
        return Math.max((long)0, (long)agz.e.b());
    }

    public int X() {
        return Math.max((int)0, (int)agz.k.b());
    }

    public int Y() {
        return Math.max((int)1, (int)agz.l.b());
    }

    public String Z() {
        return agz.q.b();
    }

    public int a(String string2) {
        return this.b(string2, agz.o);
    }

    public long a(String string2, agz.a<Long> a2) {
        if (string2 == null) {
            return a2.b();
        }
        String string3 = this.t().a(string2, a2.a());
        if (TextUtils.isEmpty((CharSequence)string3)) {
            return a2.b();
        }
        try {
            long l2 = a2.a((long)Long.valueOf((String)string3));
            return l2;
        }
        catch (NumberFormatException var4_5) {
            return a2.b();
        }
    }

    String a() {
        return agz.c.b();
    }

    /*
     * Enabled aggressive block sorting
     */
    public String a(String string2, String string3) {
        Uri.Builder builder = new Uri.Builder();
        Uri.Builder builder2 = builder.scheme(agz.g.b()).encodedAuthority(agz.h.b());
        String string4 = String.valueOf((Object)string2);
        String string5 = string4.length() != 0 ? "config/app/".concat(string4) : new String("config/app/");
        builder2.path(string5).appendQueryParameter("app_instance_id", string3).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", String.valueOf((long)this.N()));
        return builder.build().toString();
    }

    public long aa() {
        return agz.f.b();
    }

    public long ab() {
        return Math.max((long)0, (long)agz.r.b());
    }

    public long ac() {
        return Math.max((long)0, (long)agz.t.b());
    }

    public long ad() {
        return agz.s.b();
    }

    public long ae() {
        return Math.max((long)0, (long)agz.v.b());
    }

    public long af() {
        return Math.max((long)0, (long)agz.w.b());
    }

    public int ag() {
        return Math.min((int)20, (int)Math.max((int)0, (int)agz.x.b()));
    }

    public int b() {
        return 25;
    }

    public int b(String string2, agz.a<Integer> a2) {
        if (string2 == null) {
            return a2.b();
        }
        String string3 = this.t().a(string2, a2.a());
        if (TextUtils.isEmpty((CharSequence)string3)) {
            return a2.b();
        }
        try {
            int n2 = a2.a((int)Integer.valueOf((String)string3));
            return n2;
        }
        catch (NumberFormatException var4_5) {
            return a2.b();
        }
    }

    long b(String string2) {
        return this.a(string2, agz.d);
    }

    public int c() {
        return 32;
    }

    int c(String string2) {
        return this.b(string2, agz.z);
    }

    public int d() {
        return 24;
    }

    public int d(String string2) {
        return this.b(string2, agz.i);
    }

    int e() {
        return 24;
    }

    public int e(String string2) {
        return Math.max((int)0, (int)this.b(string2, agz.j));
    }

    int f() {
        return 36;
    }

    public int f(String string2) {
        return Math.max((int)0, (int)Math.min((int)1000000, (int)this.b(string2, agz.p)));
    }

    int g() {
        return 256;
    }

    public int z() {
        return 36;
    }
}

