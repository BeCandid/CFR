/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runtime
 *  java.lang.String
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicReference
 *  rx.internal.schedulers.ScheduledAction
 *  rx.internal.util.RxThreadFactory
 */
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.schedulers.ScheduledAction;
import rx.internal.util.RxThreadFactory;

public class aqr
extends apo
implements aqu {
    static final RxThreadFactory b = new RxThreadFactory("RxComputationThreadPool-");
    static final int c;
    static final c d;
    static final b e;
    final AtomicReference<b> f = new AtomicReference((Object)e);

    /*
     * Enabled aggressive block sorting
     */
    static {
        int n2 = Integer.getInteger((String)"rx.scheduler.max-computation-threads", (int)0);
        int n3 = Runtime.getRuntime().availableProcessors();
        int n4 = n2 <= 0 || n2 > n3 ? n3 : n2;
        c = n4;
        d = new c((ThreadFactory)new RxThreadFactory("RxComputationShutdown-"));
        d.unsubscribe();
        e = new b(0);
    }

    public aqr() {
        this.a();
    }

    public aps a(apy apy2) {
        return ((b)this.f.get()).a().b(apy2, -1, TimeUnit.NANOSECONDS);
    }

    public void a() {
        b b2 = new b(c);
        if (!this.f.compareAndSet((Object)e, (Object)b2)) {
            b2.b();
        }
    }

    @Override
    public void b() {
        b b2;
        do {
            if ((b2 = (b)this.f.get()) != e) continue;
            return;
        } while (!this.f.compareAndSet((Object)b2, (Object)e));
        b2.b();
    }

    @Override
    public apo.a createWorker() {
        return new a(((b)this.f.get()).a());
    }

    static class a
    extends apo.a {
        private final aqz a = new aqz();
        private final asv b = new asv();
        private final aqz c;
        private final c d;

        a(c c2) {
            aps[] arraps = new aps[]{this.a, this.b};
            this.c = new aqz(arraps);
            this.d = c2;
        }

        @Override
        public aps a(apy apy2) {
            if (this.isUnsubscribed()) {
                return asy.b();
            }
            return this.d.a(apy2, 0, null, this.a);
        }

        @Override
        public aps a(apy apy2, long l2, TimeUnit timeUnit) {
            if (this.isUnsubscribed()) {
                return asy.b();
            }
            return this.d.a(apy2, l2, timeUnit, this.b);
        }

        @Override
        public boolean isUnsubscribed() {
            return this.c.isUnsubscribed();
        }

        @Override
        public void unsubscribe() {
            this.c.unsubscribe();
        }
    }

    static final class b {
        final int a;
        final c[] b;
        long c;

        b(int n2) {
            this.a = n2;
            this.b = new c[n2];
            for (int i2 = 0; i2 < n2; ++i2) {
                this.b[i2] = new c((ThreadFactory)aqr.b);
            }
        }

        public c a() {
            int n2 = this.a;
            if (n2 == 0) {
                return aqr.d;
            }
            c[] arrc = this.b;
            long l2 = this.c;
            this.c = 1 + l2;
            return arrc[(int)(l2 % (long)n2)];
        }

        public void b() {
            c[] arrc = this.b;
            int n2 = arrc.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                arrc[i2].unsubscribe();
            }
        }
    }

    static final class c
    extends aqt {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

}

