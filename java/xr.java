/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.util.concurrent.atomic.AtomicBoolean
 *  java.util.concurrent.atomic.AtomicInteger
 */
import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class xr<O extends xf.a> {
    private final Context a;
    private final abm b;
    private final xf<O> c;
    private final O d;
    private final aba<O> e;
    private final int f;
    private final abg g;
    private final AtomicBoolean h;
    private final AtomicInteger i;

    /*
     * Enabled aggressive block sorting
     */
    public void a() {
        boolean bl2 = true;
        if (this.h.getAndSet(bl2)) {
            return;
        }
        this.b.a();
        abg abg2 = this.g;
        int n2 = this.f;
        if (this.i.get() <= 0) {
            bl2 = false;
        }
        abg2.a(n2, bl2);
    }

    public xf<O> b() {
        return this.c;
    }

    public O c() {
        return this.d;
    }

    public aba<O> d() {
        return this.e;
    }

    public Context e() {
        return this.a;
    }
}

