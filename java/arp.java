/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  sun.misc.Unsafe
 */
import sun.misc.Unsafe;

abstract class arp<E>
extends arr<E> {
    protected static final long d = asd.a(arp.class, "consumerIndex");
    private volatile long consumerIndex;

    public arp(int n2) {
        super(n2);
    }

    protected final long a() {
        return this.consumerIndex;
    }

    protected final boolean b(long l2, long l3) {
        return asd.a.compareAndSwapLong((Object)this, d, l2, l3);
    }
}

