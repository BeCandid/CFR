/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  io.fabric.sdk.android.services.concurrency.AsyncTask
 *  io.fabric.sdk.android.services.concurrency.AsyncTask$Status
 *  io.fabric.sdk.android.services.concurrency.Priority
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Collection
 *  java.util.concurrent.Executor
 *  java.util.concurrent.ExecutorService
 */
import io.fabric.sdk.android.services.concurrency.AsyncTask;
import io.fabric.sdk.android.services.concurrency.Priority;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public abstract class ame<Params, Progress, Result>
extends AsyncTask<Params, Progress, Result>
implements amc<amk>,
amh,
amk {
    private final ami a = new ami();

    public void a(amk amk2) {
        if (this.d_() != AsyncTask.Status.a) {
            throw new IllegalStateException("Must not add Dependency after task is running");
        }
        ((amc)((Object)((amh)this.g()))).c(amk2);
    }

    @Override
    public void a(Throwable throwable) {
        ((amk)((Object)((amh)this.g()))).a(throwable);
    }

    public final /* varargs */ void a(ExecutorService executorService, Params ... arrParams) {
        super.a(new a((Executor)executorService, (ame)this), (Object[])arrParams);
    }

    @Override
    public Priority b() {
        return ((amh)this.g()).b();
    }

    @Override
    public void b(boolean bl2) {
        ((amk)((Object)((amh)this.g()))).b(bl2);
    }

    @Override
    public Collection<amk> c() {
        return ((amc)((Object)((amh)this.g()))).c();
    }

    @Override
    public /* synthetic */ void c(Object object) {
        this.a((amk)object);
    }

    public int compareTo(Object object) {
        return Priority.a((amh)this, (Object)object);
    }

    @Override
    public boolean d() {
        return ((amc)((Object)((amh)this.g()))).d();
    }

    @Override
    public boolean f() {
        return ((amk)((Object)((amh)this.g()))).f();
    }

    public <T extends amc<amk>,  extends amh> T g() {
        return (T)this.a;
    }

    static class a<Result>
    implements Executor {
        private final Executor a;
        private final ame b;

        public a(Executor executor, ame ame2) {
            this.a = executor;
            this.b = ame2;
        }

        public void execute(Runnable runnable) {
            this.a.execute((Runnable)new amg<Result>(runnable, null){

                @Override
                public <T extends amc<amk>,  extends amh> T a() {
                    return (T)a.this.b;
                }
            });
        }

    }

}

