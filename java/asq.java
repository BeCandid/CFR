/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Comparable
 *  java.lang.Long
 *  java.lang.Object
 *  java.util.concurrent.PriorityBlockingQueue
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicInteger
 */
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class asq
extends apo {
    private static final asq b = new asq();

    asq() {
    }

    static int a(int n2, int n3) {
        if (n2 < n3) {
            return -1;
        }
        if (n2 == n3) {
            return 0;
        }
        return 1;
    }

    public static asq a() {
        return b;
    }

    @Override
    public apo.a createWorker() {
        return new a();
    }

    static class a
    extends apo.a
    implements aps {
        final AtomicInteger a = new AtomicInteger();
        final PriorityBlockingQueue<b> b = new PriorityBlockingQueue();
        private final asu c = new asu();
        private final AtomicInteger d = new AtomicInteger();

        a() {
        }

        private aps a(apy apy2, long l2) {
            if (this.c.isUnsubscribed()) {
                return asy.b();
            }
            final b b2 = new b(apy2, l2, this.a.incrementAndGet());
            this.b.add((Object)b2);
            if (this.d.getAndIncrement() == 0) {
                do {
                    b b3;
                    if ((b3 = (b)this.b.poll()) == null) continue;
                    b3.a.call();
                } while (this.d.decrementAndGet() > 0);
                return asy.b();
            }
            return asy.a(new apy(){

                @Override
                public void call() {
                    a.this.b.remove((Object)b2);
                }
            });
        }

        @Override
        public aps a(apy apy2) {
            return super.a(apy2, this.a());
        }

        @Override
        public aps a(apy apy2, long l2, TimeUnit timeUnit) {
            long l3 = this.a() + timeUnit.toMillis(l2);
            return super.a(new asp(apy2, (apo.a)this, l3), l3);
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

    static final class b
    implements Comparable<b> {
        final apy a;
        final Long b;
        final int c;

        b(apy apy2, Long l2, int n2) {
            this.a = apy2;
            this.b = l2;
            this.c = n2;
        }

        public int a(b b2) {
            int n2 = this.b.compareTo(b2.b);
            if (n2 == 0) {
                n2 = asq.a(this.c, b2.c);
            }
            return n2;
        }

        public /* synthetic */ int compareTo(Object object) {
            return this.a((b)object);
        }
    }

}

