/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.util.concurrent.TimeUnit
 */
import java.util.concurrent.TimeUnit;

public final class aqi
implements apl.a<Long> {
    final long a;
    final TimeUnit b;
    final apo c;

    public aqi(long l2, TimeUnit timeUnit, apo apo2) {
        this.a = l2;
        this.b = timeUnit;
        this.c = apo2;
    }

    public void a(final apr<? super Long> apr2) {
        apo.a a2 = this.c.createWorker();
        apr2.add(a2);
        a2.a(new apy(){

            @Override
            public void call() {
                try {
                    apr2.onNext((Object)0);
                }
                catch (Throwable var1_1) {
                    apx.a(var1_1, apr2);
                    return;
                }
                apr2.onCompleted();
            }
        }, this.a, this.b);
    }

    @Override
    public /* synthetic */ void call(Object object) {
        this.a((apr)object);
    }

}

