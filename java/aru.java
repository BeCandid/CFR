/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  sun.misc.Unsafe
 */
import sun.misc.Unsafe;

abstract class aru<E>
extends arq<E> {
    protected static final long e = asd.a(aru.class, "producerIndex");
    private volatile long producerIndex;

    public aru(int n2) {
        super(n2);
    }

    protected final long b() {
        return this.producerIndex;
    }

    protected final void d(long l2) {
        asd.a.putOrderedLong((Object)this, e, l2);
    }
}

