/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  io.fabric.sdk.android.services.common.CommonUtils
 *  io.fabric.sdk.android.services.common.DeliveryMechanism
 *  io.fabric.sdk.android.services.common.IdManager
 *  io.fabric.sdk.android.services.settings.SettingsCacheBehavior
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Locale
 *  java.util.concurrent.CountDownLatch
 *  java.util.concurrent.atomic.AtomicReference
 */
import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.DeliveryMechanism;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.settings.SettingsCacheBehavior;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class aoa {
    private final AtomicReference<aoc> a;
    private final CountDownLatch b;
    private aob c;
    private boolean d;

    private aoa() {
        this.a = new AtomicReference();
        this.b = new CountDownLatch(1);
        this.d = false;
    }

    /* synthetic */ aoa( var1) {
    }

    public static aoa a() {
        return a;
    }

    private void a(aoc aoc2) {
        this.a.set((Object)aoc2);
        this.b.countDown();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public aoa a(alc alc2, IdManager idManager, anb anb2, String string2, String string3, String string4) {
        aoa aoa2 = this;
        synchronized (aoa2) {
            boolean bl2 = this.d;
            if (bl2) {
                return this;
            }
            if (this.c == null) {
                Context context = alc2.E();
                String string5 = idManager.c();
                String string6 = new alr().a(context);
                String string7 = idManager.j();
                ama ama2 = new ama();
                anu anu2 = new anu();
                ans ans2 = new ans(alc2);
                String string8 = CommonUtils.k((Context)context);
                String string9 = String.format((Locale)Locale.US, (String)"https://settings.crashlytics.com/spi/v2/platforms/android/apps/%s/settings", (Object[])new Object[]{string5});
                anv anv2 = new anv(alc2, string4, string9, anb2);
                String string10 = idManager.g();
                String string11 = idManager.f();
                String string12 = idManager.e();
                String string13 = idManager.m();
                String string14 = idManager.b();
                String string15 = idManager.n();
                String[] arrstring = new String[]{CommonUtils.m((Context)context)};
                this.c = new ant(alc2, new aof(string6, string10, string11, string12, string13, string14, string15, CommonUtils.a((String[])arrstring), string3, string2, DeliveryMechanism.a((String)string7).a(), string8), ama2, anu2, ans2, anv2);
            }
            this.d = true;
            return this;
        }
    }

    public <T> T a(b<T> b2, T t2) {
        aoc aoc2 = (aoc)this.a.get();
        if (aoc2 == null) {
            return t2;
        }
        return b2.b(aoc2);
    }

    public aoc b() {
        try {
            this.b.await();
            aoc aoc2 = (aoc)this.a.get();
            return aoc2;
        }
        catch (InterruptedException var1_2) {
            akx.h().e("Fabric", "Interrupted while waiting for settings data.");
            return null;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean c() {
        aoa aoa2 = this;
        synchronized (aoa2) {
            aoc aoc2 = this.c.a();
            this.a(aoc2);
            if (aoc2 == null) return false;
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean d() {
        aoa aoa2 = this;
        synchronized (aoa2) {
            aoc aoc2 = this.c.a(SettingsCacheBehavior.b);
            this.a(aoc2);
            if (aoc2 == null) {
                akx.h().e("Fabric", "Failed to force reload of settings from Crashlytics.", null);
            }
            if (aoc2 == null) return false;
            return true;
        }
    }

    static class a {
        private static final aoa a = new aoa(null);
    }

    public static interface b<T> {
        public T b(aoc var1);
    }

}

