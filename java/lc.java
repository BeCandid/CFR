/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  android.os.MessageQueue
 *  android.os.MessageQueue$IdleHandler
 *  android.util.Log
 *  com.bumptech.glide.Priority
 *  com.bumptech.glide.load.engine.DiskCacheStrategy
 *  com.bumptech.glide.load.engine.EngineRunnable
 *  com.bumptech.glide.load.engine.EngineRunnable$a
 *  java.io.File
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ref.Reference
 *  java.lang.ref.ReferenceQueue
 *  java.lang.ref.WeakReference
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.concurrent.ExecutorService
 */
import android.os.Looper;
import android.os.MessageQueue;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.EngineRunnable;
import java.io.File;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class lc
implements le,
lh.a,
mb.a {
    private final Map<kn, ld> a;
    private final lg b;
    private final mb c;
    private final a d;
    private final Map<kn, WeakReference<lh<?>>> e;
    private final lk f;
    private final b g;
    private ReferenceQueue<lh<?>> h;

    public lc(mb mb2, lu.a a2, ExecutorService executorService, ExecutorService executorService2) {
        super(mb2, a2, executorService, executorService2, null, null, null, null, null);
    }

    lc(mb mb2, lu.a a2, ExecutorService executorService, ExecutorService executorService2, Map<kn, ld> hashMap, lg lg2, Map<kn, WeakReference<lh<?>>> hashMap2, a a3, lk lk2) {
        this.c = mb2;
        this.g = new b(a2);
        if (hashMap2 == null) {
            hashMap2 = new HashMap();
        }
        this.e = hashMap2;
        if (lg2 == null) {
            lg2 = new lg();
        }
        this.b = lg2;
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        this.a = hashMap;
        if (a3 == null) {
            a3 = new a(executorService, executorService2, (le)this);
        }
        this.d = a3;
        if (lk2 == null) {
            lk2 = new lk();
        }
        this.f = lk2;
        mb2.a((mb.a)this);
    }

    private ReferenceQueue<lh<?>> a() {
        if (this.h == null) {
            this.h = new ReferenceQueue();
            Looper.myQueue().addIdleHandler((MessageQueue.IdleHandler)new d(this.e, this.h));
        }
        return this.h;
    }

    private lh<?> a(kn kn2) {
        lj lj2 = this.c.a(kn2);
        if (lj2 == null) {
            return null;
        }
        if (lj2 instanceof lh) {
            return (lh)lj2;
        }
        return new lh(lj2, true);
    }

    /*
     * Enabled aggressive block sorting
     */
    private lh<?> a(kn kn2, boolean bl2) {
        WeakReference weakReference;
        if (!bl2 || (weakReference = (WeakReference)this.e.get((Object)kn2)) == null) {
            return null;
        }
        lh lh2 = (lh)weakReference.get();
        if (lh2 != null) {
            lh2.e();
            return lh2;
        }
        this.e.remove((Object)kn2);
        return lh2;
    }

    private static void a(String string2, long l2, kn kn2) {
        Log.v((String)"Engine", (String)(string2 + " in " + re.a(l2) + "ms, key: " + kn2));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private lh<?> b(kn kn2, boolean bl2) {
        if (!bl2) {
            return null;
        }
        lh lh2 = super.a(kn2);
        if (lh2 == null) return lh2;
        lh2.e();
        this.e.put((Object)kn2, (Object)new e(kn2, lh2, super.a()));
        return lh2;
    }

    public <T, Z, R> c a(kn kn2, int n2, int n3, ku<T> ku2, py<T, Z> py2, kr<Z> kr2, pf<Z, R> pf2, Priority priority, boolean bl2, DiskCacheStrategy diskCacheStrategy, qg qg2) {
        ri.a();
        long l2 = re.a();
        String string2 = ku2.b();
        lf lf2 = this.b.a(string2, kn2, n2, n3, py2.a(), py2.b(), kr2, py2.d(), pf2, py2.c());
        lh lh2 = super.b((kn)lf2, bl2);
        if (lh2 != null) {
            qg2.a(lh2);
            if (Log.isLoggable((String)"Engine", (int)2)) {
                lc.a("Loaded resource from cache", l2, lf2);
            }
            return null;
        }
        lh lh3 = super.a((kn)lf2, bl2);
        if (lh3 != null) {
            qg2.a(lh3);
            if (Log.isLoggable((String)"Engine", (int)2)) {
                lc.a("Loaded resource from active resources", l2, lf2);
            }
            return null;
        }
        ld ld2 = (ld)this.a.get((Object)lf2);
        if (ld2 != null) {
            ld2.a(qg2);
            if (Log.isLoggable((String)"Engine", (int)2)) {
                lc.a("Added to existing load", l2, lf2);
            }
            return new c(qg2, ld2);
        }
        ld ld3 = this.d.a(lf2, bl2);
        lb<T, Z, R> lb2 = new lb<T, Z, R>(lf2, n2, n3, ku2, py2, kr2, pf2, this.g, diskCacheStrategy, priority);
        EngineRunnable engineRunnable = new EngineRunnable((EngineRunnable.a)ld3, lb2, priority);
        this.a.put((Object)lf2, (Object)ld3);
        ld3.a(qg2);
        ld3.a(engineRunnable);
        if (Log.isLoggable((String)"Engine", (int)2)) {
            lc.a("Started new load", l2, lf2);
        }
        return new c(qg2, ld3);
    }

    @Override
    public void a(kn kn2, lh<?> lh2) {
        ri.a();
        if (lh2 != null) {
            lh2.a(kn2, (lh.a)this);
            if (lh2.a()) {
                this.e.put((Object)kn2, (Object)new e(kn2, lh2, super.a()));
            }
        }
        this.a.remove((Object)kn2);
    }

    @Override
    public void a(ld ld2, kn kn2) {
        ri.a();
        if (ld2.equals((Object)((ld)this.a.get((Object)kn2)))) {
            this.a.remove((Object)kn2);
        }
    }

    public void a(lj lj2) {
        ri.a();
        if (lj2 instanceof lh) {
            ((lh)lj2).f();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    public void b(kn kn2, lh lh2) {
        ri.a();
        this.e.remove((Object)kn2);
        if (lh2.a()) {
            this.c.b(kn2, lh2);
            return;
        }
        this.f.a(lh2);
    }

    @Override
    public void b(lj<?> lj2) {
        ri.a();
        this.f.a(lj2);
    }

    static class a {
        private final ExecutorService a;
        private final ExecutorService b;
        private final le c;

        public a(ExecutorService executorService, ExecutorService executorService2, le le2) {
            this.a = executorService;
            this.b = executorService2;
            this.c = le2;
        }

        public ld a(kn kn2, boolean bl2) {
            return new ld(kn2, this.a, this.b, bl2, this.c);
        }
    }

    static class b
    implements lb.a {
        private final lu.a a;
        private volatile lu b;

        public b(lu.a a2) {
            this.a = a2;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public lu a() {
            if (this.b == null) {
                b b2 = this;
                synchronized (b2) {
                    if (this.b == null) {
                        this.b = this.a.a();
                    }
                    if (this.b == null) {
                        this.b = new lv();
                    }
                }
            }
            return this.b;
        }
    }

    public static class c {
        private final ld a;
        private final qg b;

        public c(qg qg2, ld ld2) {
            this.b = qg2;
            this.a = ld2;
        }

        public void a() {
            this.a.b(this.b);
        }
    }

    static class d
    implements MessageQueue.IdleHandler {
        private final Map<kn, WeakReference<lh<?>>> a;
        private final ReferenceQueue<lh<?>> b;

        public d(Map<kn, WeakReference<lh<?>>> map, ReferenceQueue<lh<?>> referenceQueue) {
            this.a = map;
            this.b = referenceQueue;
        }

        public boolean queueIdle() {
            e e2 = (e)this.b.poll();
            if (e2 != null) {
                this.a.remove((Object)e2.a);
            }
            return true;
        }
    }

    static class e
    extends WeakReference<lh<?>> {
        private final kn a;

        public e(kn kn2, lh<?> lh2, ReferenceQueue<? super lh<?>> referenceQueue) {
            super(lh2, referenceQueue);
            this.a = kn2;
        }
    }

}

