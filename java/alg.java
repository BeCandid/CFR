/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  io.fabric.sdk.android.services.common.CommonUtils
 *  io.fabric.sdk.android.services.common.DeliveryMechanism
 *  io.fabric.sdk.android.services.common.IdManager
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.concurrent.Future
 */
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.DeliveryMechanism;
import io.fabric.sdk.android.services.common.IdManager;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

class alg
extends alc<Boolean> {
    private final anb a = new ana();
    private PackageManager b;
    private String c;
    private PackageInfo d;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private final Future<Map<String, ale>> p;
    private final Collection<alc> q;

    public alg(Future<Map<String, ale>> future, Collection<alc> collection) {
        this.p = future;
        this.q = collection;
    }

    private ann a(anx anx2, Collection<ale> collection) {
        Context context = this.E();
        String string2 = new alr().a(context);
        String string3 = CommonUtils.a((String[])new String[]{CommonUtils.m((Context)context)});
        int n2 = DeliveryMechanism.a((String)this.m).a();
        return new ann(string2, this.D().c(), this.l, this.k, string3, this.n, n2, this.o, "0", anx2, collection);
    }

    private boolean a(ano ano2, anx anx2, Collection<ale> collection) {
        ann ann2 = super.a(anx2, collection);
        return new aoh((alc)this, this.e(), ano2.c, this.a).a(ann2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean a(String string2, ano ano2, Collection<ale> collection) {
        boolean bl2 = true;
        if ("new".equals((Object)ano2.b)) {
            if (super.b(string2, ano2, collection)) {
                return aoa.a().d();
            }
            akx.h().e("Fabric", "Failed to create app with Crashlytics service.", null);
            return false;
        }
        if ("configured".equals((Object)ano2.b)) {
            return aoa.a().d();
        }
        if (!ano2.e) return bl2;
        akx.h().a("Fabric", "Server says an update is required - forcing a full App update.");
        super.c(string2, ano2, collection);
        return bl2;
    }

    private boolean b(String string2, ano ano2, Collection<ale> collection) {
        ann ann2 = super.a(anx.a(this.E(), string2), collection);
        return new anr((alc)this, this.e(), ano2.c, this.a).a(ann2);
    }

    private boolean c(String string2, ano ano2, Collection<ale> collection) {
        return super.a(ano2, anx.a(this.E(), string2), collection);
    }

    private aoc g() {
        try {
            aoa.a().a(this, this.i, this.a, this.k, this.l, this.e()).c();
            aoc aoc2 = aoa.a().b();
            return aoc2;
        }
        catch (Exception var1_2) {
            akx.h().e("Fabric", "Error dealing with settings", (Throwable)var1_2);
            return null;
        }
    }

    @Override
    public String a() {
        return "1.3.12.127";
    }

    Map<String, ale> a(Map<String, ale> map, Collection<alc> collection) {
        for (alc alc2 : collection) {
            if (map.containsKey((Object)alc2.b())) continue;
            map.put((Object)alc2.b(), (Object)new ale(alc2.b(), alc2.a(), "binary"));
        }
        return map;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    protected boolean a_() {
        try {
            this.m = this.D().j();
            this.b = this.E().getPackageManager();
            this.c = this.E().getPackageName();
            this.d = this.b.getPackageInfo(this.c, 0);
            this.k = Integer.toString((int)this.d.versionCode);
            String string2 = this.d.versionName == null ? "0.0" : this.d.versionName;
            this.l = string2;
            this.n = this.b.getApplicationLabel(this.E().getApplicationInfo()).toString();
            this.o = Integer.toString((int)this.E().getApplicationInfo().targetSdkVersion);
            return true;
        }
        catch (PackageManager.NameNotFoundException var1_2) {
            akx.h().e("Fabric", "Failed init", (Throwable)var1_2);
            return false;
        }
    }

    @Override
    public String b() {
        return "io.fabric.sdk.android:fabric";
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected Boolean c() {
        String string2 = CommonUtils.k((Context)this.E());
        aoc aoc2 = this.g();
        boolean bl2 = false;
        if (aoc2 == null) return bl2;
        try {
            boolean bl3;
            Map map = this.p != null ? (Map)this.p.get() : new HashMap();
            Map<String, ale> map2 = this.a(map, this.q);
            bl2 = bl3 = this.a(string2, aoc2.a, map2.values());
        }
        catch (Exception var4_7) {
            akx.h().e("Fabric", "Error performing auto configuration.", (Throwable)var4_7);
            bl2 = false;
            return bl2;
        }
        return bl2;
    }

    String e() {
        return CommonUtils.b((Context)this.E(), (String)"com.crashlytics.ApiEndpoint");
    }

    @Override
    protected /* synthetic */ Object f() {
        return this.c();
    }
}

