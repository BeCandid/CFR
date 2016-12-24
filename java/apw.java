/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.util.concurrent.TimeUnit
 *  rx.internal.schedulers.ScheduledAction
 */
import android.os.Handler;
import java.util.concurrent.TimeUnit;
import rx.internal.schedulers.ScheduledAction;

public final class apw
extends apo {
    private final Handler b;

    apw(Handler handler) {
        this.b = handler;
    }

    @Override
    public apo.a createWorker() {
        return new a(this.b);
    }

    static class a
    extends apo.a {
        private final Handler a;
        private final asv b = new asv();

        a(Handler handler) {
            this.a = handler;
        }

        @Override
        public aps a(apy apy2) {
            return this.a(apy2, 0, TimeUnit.MILLISECONDS);
        }

        @Override
        public aps a(apy apy2, long l2, TimeUnit timeUnit) {
            if (this.b.isUnsubscribed()) {
                return asy.b();
            }
            final ScheduledAction scheduledAction = new ScheduledAction(apt.a().b().a(apy2));
            scheduledAction.a(this.b);
            this.b.a((aps)scheduledAction);
            this.a.postDelayed((Runnable)scheduledAction, timeUnit.toMillis(l2));
            scheduledAction.a(asy.a(new apy(){

                @Override
                public void call() {
                    a.this.a.removeCallbacks((Runnable)scheduledAction);
                }
            }));
            return scheduledAction;
        }

        @Override
        public boolean isUnsubscribed() {
            return this.b.isUnsubscribed();
        }

        @Override
        public void unsubscribe() {
            this.b.unsubscribe();
        }

    }

}

