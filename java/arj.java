/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  sun.misc.Unsafe
 */
import sun.misc.Unsafe;

abstract class arj<E>
extends arl<E> {
    private static final long e = asd.a(arj.class, "consumerIndex");
    private volatile long consumerIndex;

    public arj(int n2) {
        super(n2);
    }

    protected final long a() {
        return this.consumerIndex;
    }

    protected final boolean b(long l2, long l3) {
        return asd.a.compareAndSwapLong((Object)this, e, l2, l3);
    }
}

