/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Void
 *  java.util.concurrent.Callable
 *  java.util.concurrent.CountDownLatch
 *  java.util.concurrent.FutureTask
 */
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;

public class vw<T> {
    private T a;
    private CountDownLatch b = new CountDownLatch(1);

    public vw(final Callable<T> callable) {
        ul.d().execute((Runnable)new FutureTask((Callable)new Callable<Void>(){

            public Void a() throws Exception {
                try {
                    vw.this.a = callable.call();
                    return null;
                }
                finally {
                    vw.this.b.countDown();
                }
            }

            public /* synthetic */ Object call() throws Exception {
                return this.a();
            }
        }));
    }

    private void b() {
        if (this.b == null) {
            return;
        }
        try {
            this.b.await();
            return;
        }
        catch (InterruptedException var1_1) {
            return;
        }
    }

    public T a() {
        this.b();
        return this.a;
    }

}

