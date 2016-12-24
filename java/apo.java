/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.concurrent.TimeUnit
 */
import java.util.concurrent.TimeUnit;

public abstract class apo {
    static final long a = TimeUnit.MINUTES.toNanos(Long.getLong((String)"rx.scheduler.drift-tolerance", (long)15).longValue());

    public abstract a createWorker();

    public long now() {
        return System.currentTimeMillis();
    }

    public static abstract class a
    implements aps {
        public long a() {
            return System.currentTimeMillis();
        }

        public abstract aps a(apy var1);

        public aps a(final apy apy2, long l2, long l3, TimeUnit timeUnit) {
            final long l4 = timeUnit.toNanos(l3);
            final long l5 = TimeUnit.MILLISECONDS.toNanos(this.a());
            final long l6 = l5 + timeUnit.toNanos(l2);
            final asw asw2 = new asw();
            apy apy3 = new apy(){
                long a;
                long b;
                long c;

                /*
                 * Enabled aggressive block sorting
                 */
                @Override
                public void call() {
                    if (!asw2.isUnsubscribed()) {
                        long l2;
                        apy2.call();
                        long l3 = TimeUnit.MILLISECONDS.toNanos(a.this.a());
                        if (l3 + apo.a < this.b || l3 >= this.b + l4 + apo.a) {
                            long l42;
                            l2 = l3 + l4;
                            long l52 = l4;
                            this.a = l42 = 1 + this.a;
                            this.c = l2 - l52 * l42;
                        } else {
                            long l62;
                            long l7 = this.c;
                            this.a = l62 = 1 + this.a;
                            l2 = l7 + l62 * l4;
                        }
                        this.b = l3;
                        long l8 = l2 - l3;
                        asw2.a(a.this.a(this, l8, TimeUnit.NANOSECONDS));
                    }
                }
            };
            asw asw3 = new asw();
            asw2.a(asw3);
            asw3.a(this.a(apy3, l2, timeUnit));
            return asw2;
        }

        public abstract aps a(apy var1, long var2, TimeUnit var4);

    }

}

