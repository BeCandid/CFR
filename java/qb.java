/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 */
import java.io.File;

public class qb<A, T, Z, R>
implements qc<A, T, Z, R> {
    private final mr<A, T> a;
    private final pf<Z, R> b;
    private final py<T, Z> c;

    public qb(mr<A, T> mr2, pf<Z, R> pf2, py<T, Z> py2) {
        if (mr2 == null) {
            throw new NullPointerException("ModelLoader must not be null");
        }
        this.a = mr2;
        if (pf2 == null) {
            throw new NullPointerException("Transcoder must not be null");
        }
        this.b = pf2;
        if (py2 == null) {
            throw new NullPointerException("DataLoadProvider must not be null");
        }
        this.c = py2;
    }

    @Override
    public kp<File, Z> a() {
        return this.c.a();
    }

    @Override
    public kp<T, Z> b() {
        return this.c.b();
    }

    @Override
    public km<T> c() {
        return this.c.c();
    }

    @Override
    public kq<Z> d() {
        return this.c.d();
    }

    @Override
    public mr<A, T> e() {
        return this.a;
    }

    @Override
    public pf<Z, R> f() {
        return this.b;
    }
}

