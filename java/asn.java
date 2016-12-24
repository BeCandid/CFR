/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Throwable
 *  java.util.concurrent.ConcurrentLinkedQueue
 *  java.util.concurrent.Executor
 *  java.util.concurrent.Future
 *  java.util.concurrent.RejectedExecutionException
 *  java.util.concurrent.ScheduledExecutorService
 *  java.util.concurrent.ScheduledFuture
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicInteger
 *  rx.internal.schedulers.ScheduledAction
 */
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.internal.schedulers.ScheduledAction;

public final class asn
extends apo {
    final Executor b;

    public asn(Executor executor) {
        this.b = executor;
    }

    @Override
    public apo.a createWorker() {
        return new a(this.b);
    }

    static final class a
    extends apo.a
    implements Runnable {
        final Executor a;
        final asv b;
        final ConcurrentLinkedQueue<ScheduledAction> c;
        final AtomicInteger d;

        public a(Executor executor) {
            this.a = executor;
            this.c = new ConcurrentLinkedQueue();
            this.d = new AtomicInteger();
            this.b = new asv();
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public aps a(apy apy2) {
            if (this.isUnsubscribed()) {
                return asy.b();
            }
            aps aps2 = new ScheduledAction(apy2, this.b);
            this.b.a(aps2);
            this.c.offer((Object)aps2);
            if (this.d.getAndIncrement() != 0) return aps2;
            try {
                this.a.execute((Runnable)this);
                return aps2;
            }
            catch (RejectedExecutionException var4_3) {
                this.b.b(aps2);
                this.d.decrementAndGet();
                ask.a().b().a((Throwable)var4_3);
                throw var4_3;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public aps a(final apy apy2, long l2, TimeUnit timeUnit) {
            if (l2 <= 0) {
                return this.a(apy2);
            }
            if (this.isUnsubscribed()) {
                return asy.b();
            }
            ScheduledExecutorService scheduledExecutorService = this.a instanceof ScheduledExecutorService ? (ScheduledExecutorService)this.a : aqs.c();
            asw asw2 = new asw();
            final asw asw3 = new asw();
            asw3.a(asw2);
            this.b.a(asw3);
            final aps aps2 = asy.a(new apy(){

                @Override
                public void call() {
                    a.this.b.b(asw3);
                }
            });
            ScheduledAction scheduledAction = new ScheduledAction(new apy(){

                /*
                 * Enabled aggressive block sorting
                 * Lifted jumps to return sites
                 */
                @Override
                public void call() {
                    if (asw3.isUnsubscribed()) {
                        return;
                    }
                    aps aps22 = a.this.a(apy2);
                    asw3.a(aps22);
                    if (aps22.getClass() != ScheduledAction.class) return;
                    ((ScheduledAction)aps22).a(aps2);
                }
            });
            asw2.a((aps)scheduledAction);
            try {
                scheduledAction.a((Future)scheduledExecutorService.schedule((Runnable)scheduledAction, l2, timeUnit));
                return aps2;
            }
            catch (RejectedExecutionException var10_9) {
                ask.a().b().a((Throwable)var10_9);
                throw var10_9;
            }
        }

        @Override
        public boolean isUnsubscribed() {
            return this.b.isUnsubscribed();
        }

        public void run() {
            do {
                ScheduledAction scheduledAction;
                if ((scheduledAction = (ScheduledAction)this.c.poll()).isUnsubscribed()) continue;
                scheduledAction.run();
            } while (this.d.decrementAndGet() > 0);
        }

        @Override
        public void unsubscribe() {
            this.b.unsubscribe();
        }

    }

}

