/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.concurrent.atomic.AtomicReference
 */
import java.util.concurrent.atomic.AtomicReference;

public final class apt {
    private static final apt a = new apt();
    private final AtomicReference<apu> b = new AtomicReference();

    apt() {
    }

    public static apt a() {
        return a;
    }

    public apu b() {
        if (this.b.get() == null) {
            this.b.compareAndSet((Object)null, (Object)apu.a());
        }
        return (apu)this.b.get();
    }
}

