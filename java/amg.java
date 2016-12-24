/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  io.fabric.sdk.android.services.concurrency.Priority
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Throwable
 *  java.util.Collection
 *  java.util.concurrent.Callable
 *  java.util.concurrent.FutureTask
 */
import io.fabric.sdk.android.services.concurrency.Priority;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class amg<V>
extends FutureTask<V>
implements amc<amk>,
amh,
amk {
    final Object b;

    public amg(Runnable runnable, V v2) {
        super(runnable, v2);
        this.b = this.a((Object)runnable);
    }

    public amg(Callable<V> callable) {
        super(callable);
        this.b = this.a(callable);
    }

    public <T extends amc<amk>,  extends amh> T a() {
        return (T)((amc)this.b);
    }

    protected <T extends amc<amk>,  extends amh> T a(Object object) {
        if (ami.a(object)) {
            return (T)((amc)object);
        }
        return (T)new ami();
    }

    public void a(amk amk2) {
        ((amc)((Object)((amh)this.a()))).c(amk2);
    }

    @Override
    public void a(Throwable throwable) {
        ((amk)((Object)((amh)this.a()))).a(throwable);
    }

    @Override
    public Priority b() {
        return ((amh)this.a()).b();
    }

    @Override
    public void b(boolean bl2) {
        ((amk)((Object)((amh)this.a()))).b(bl2);
    }

    @Override
    public Collection<amk> c() {
        return ((amc)((Object)((amh)this.a()))).c();
    }

    @Override
    public /* synthetic */ void c(Object object) {
        this.a((amk)object);
    }

    public int compareTo(Object object) {
        return ((amh)this.a()).compareTo(object);
    }

    @Override
    public boolean d() {
        return ((amc)((Object)((amh)this.a()))).d();
    }

    @Override
    public boolean f() {
        return ((amk)((Object)((amh)this.a()))).f();
    }
}

