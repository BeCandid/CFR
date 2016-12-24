/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Throwable
 */
public abstract class apq<T>
implements aps {
    private final aqz a = new aqz();

    public final void a(aps aps2) {
        this.a.a(aps2);
    }

    public abstract void a(T var1);

    public abstract void a(Throwable var1);

    @Override
    public final boolean isUnsubscribed() {
        return this.a.isUnsubscribed();
    }

    @Override
    public final void unsubscribe() {
        this.a.unsubscribe();
    }
}

