/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.lang.CloneNotSupportedException
 *  java.lang.Cloneable
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.Throwable
 */
import java.io.File;

public class px<A, T, Z, R>
implements Cloneable,
qc<A, T, Z, R> {
    private final qc<A, T, Z, R> a;
    private kp<File, Z> b;
    private kp<T, Z> c;
    private kq<Z> d;
    private pf<Z, R> e;
    private km<T> f;

    public px(qc<A, T, Z, R> qc2) {
        this.a = qc2;
    }

    @Override
    public kp<File, Z> a() {
        if (this.b != null) {
            return this.b;
        }
        return this.a.a();
    }

    public void a(km<T> km2) {
        this.f = km2;
    }

    public void a(kp<T, Z> kp2) {
        this.c = kp2;
    }

    @Override
    public kp<T, Z> b() {
        if (this.c != null) {
            return this.c;
        }
        return this.a.b();
    }

    @Override
    public km<T> c() {
        if (this.f != null) {
            return this.f;
        }
        return this.a.c();
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return this.g();
    }

    @Override
    public kq<Z> d() {
        if (this.d != null) {
            return this.d;
        }
        return this.a.d();
    }

    @Override
    public mr<A, T> e() {
        return this.a.e();
    }

    @Override
    public pf<Z, R> f() {
        if (this.e != null) {
            return this.e;
        }
        return this.a.f();
    }

    public px<A, T, Z, R> g() {
        try {
            px px2 = (px)super.clone();
            return px2;
        }
        catch (CloneNotSupportedException var1_2) {
            throw new RuntimeException((Throwable)var1_2);
        }
    }
}

