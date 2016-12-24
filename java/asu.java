/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.concurrent.atomic.AtomicReference
 */
import java.util.concurrent.atomic.AtomicReference;

public final class asu
implements aps {
    static final apy b = new apy(){

        @Override
        public void call() {
        }
    };
    final AtomicReference<apy> a;

    public asu() {
        this.a = new AtomicReference();
    }

    private asu(apy apy2) {
        this.a = new AtomicReference((Object)apy2);
    }

    public static asu a() {
        return new asu();
    }

    public static asu a(apy apy2) {
        return new asu(apy2);
    }

    @Override
    public boolean isUnsubscribed() {
        if (this.a.get() == b) {
            return true;
        }
        return false;
    }

    @Override
    public final void unsubscribe() {
        apy apy2;
        if ((apy)this.a.get() != b && (apy2 = (apy)this.a.getAndSet((Object)b)) != null && apy2 != b) {
            apy2.call();
        }
    }

}

