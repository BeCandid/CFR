/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 */
public class nn<T>
implements lj<T> {
    protected final T a;

    public nn(T t2) {
        if (t2 == null) {
            throw new NullPointerException("Data must not be null");
        }
        this.a = t2;
    }

    @Override
    public final T b() {
        return this.a;
    }

    @Override
    public final int c() {
        return 1;
    }

    @Override
    public void d() {
    }
}

