/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  java.lang.IllegalStateException
 *  java.lang.IllegalThreadStateException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 */
import android.os.Looper;

class lh<Z>
implements lj<Z> {
    private final lj<Z> a;
    private final boolean b;
    private a c;
    private kn d;
    private int e;
    private boolean f;

    lh(lj<Z> lj2, boolean bl2) {
        if (lj2 == null) {
            throw new NullPointerException("Wrapped resource must not be null");
        }
        this.a = lj2;
        this.b = bl2;
    }

    void a(kn kn2, a a2) {
        this.d = kn2;
        this.c = a2;
    }

    boolean a() {
        return this.b;
    }

    @Override
    public Z b() {
        return this.a.b();
    }

    @Override
    public int c() {
        return this.a.c();
    }

    @Override
    public void d() {
        if (this.e > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.f) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.f = true;
        this.a.d();
    }

    void e() {
        if (this.f) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        if (!Looper.getMainLooper().equals((Object)Looper.myLooper())) {
            throw new IllegalThreadStateException("Must call acquire on the main thread");
        }
        this.e = 1 + this.e;
    }

    void f() {
        int n2;
        if (this.e <= 0) {
            throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
        }
        if (!Looper.getMainLooper().equals((Object)Looper.myLooper())) {
            throw new IllegalThreadStateException("Must call release on the main thread");
        }
        this.e = n2 = -1 + this.e;
        if (n2 == 0) {
            this.c.b(this.d, this);
        }
    }

    static interface a {
        public void b(kn var1, lh<?> var2);
    }

}

