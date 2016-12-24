/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  sun.misc.Unsafe
 */
import sun.misc.Unsafe;

abstract class arm<E>
extends ark<E> {
    private static final long e = asd.a(arm.class, "producerIndex");
    private volatile long producerIndex;

    public arm(int n2) {
        super(n2);
    }

    protected final long b() {
        return this.producerIndex;
    }

    protected final boolean c(long l2, long l3) {
        return asd.a.compareAndSwapLong((Object)this, e, l2, l3);
    }
}

