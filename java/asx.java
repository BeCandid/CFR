/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.concurrent.atomic.AtomicReference
 */
import java.util.concurrent.atomic.AtomicReference;

public final class asx
implements aps {
    final AtomicReference<a> a = new AtomicReference((Object)new a(false, asy.a()));

    public void a(aps aps2) {
        a a2;
        if (aps2 == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        AtomicReference<a> atomicReference = this.a;
        do {
            a2 = (a)atomicReference.get();
            if (!a2.a) continue;
            aps2.unsubscribe();
            return;
        } while (!atomicReference.compareAndSet((Object)a2, (Object)a2.a(aps2)));
        a2.b.unsubscribe();
    }

    @Override
    public boolean isUnsubscribed() {
        return ((a)this.a.get()).a;
    }

    @Override
    public void unsubscribe() {
        a a2;
        AtomicReference<a> atomicReference = this.a;
        do {
            a2 = (a)atomicReference.get();
            if (!a2.a) continue;
            return;
        } while (!atomicReference.compareAndSet((Object)a2, (Object)a2.a()));
        a2.b.unsubscribe();
    }

    static final class a {
        final boolean a;
        final aps b;

        a(boolean bl2, aps aps2) {
            this.a = bl2;
            this.b = aps2;
        }

        a a() {
            return new a(true, this.b);
        }

        a a(aps aps2) {
            return new a(this.a, aps2);
        }
    }

}

