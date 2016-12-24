/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.concurrent.Callable
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Future
 *  java.util.concurrent.RejectedExecutionException
 *  java.util.concurrent.TimeUnit
 */
import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

class ta {
    private final ExecutorService a;

    public ta(ExecutorService executorService) {
        this.a = executorService;
    }

    <T> T a(Callable<T> callable) {
        Object object;
        try {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                return (T)this.a.submit(callable).get(4, TimeUnit.SECONDS);
            }
            object = this.a.submit(callable).get();
        }
        catch (RejectedExecutionException var3_3) {
            akx.h().a("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
        catch (Exception var2_4) {
            akx.h().e("CrashlyticsCore", "Failed to execute task.", (Throwable)var2_4);
            return null;
        }
        return (T)object;
    }

    Future<?> a(final Runnable runnable) {
        try {
            Future future = this.a.submit(new Runnable(){

                public void run() {
                    try {
                        runnable.run();
                        return;
                    }
                    catch (Exception var1_1) {
                        akx.h().e("CrashlyticsCore", "Failed to execute task.", (Throwable)var1_1);
                        return;
                    }
                }
            });
            return future;
        }
        catch (RejectedExecutionException var2_3) {
            akx.h().a("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }

    <T> Future<T> b(final Callable<T> callable) {
        try {
            Future future = this.a.submit(new Callable<T>(){

                public T call() throws Exception {
                    Object object;
                    try {
                        object = callable.call();
                    }
                    catch (Exception var1_2) {
                        akx.h().e("CrashlyticsCore", "Failed to execute task.", (Throwable)var1_2);
                        return null;
                    }
                    return (T)object;
                }
            });
            return future;
        }
        catch (RejectedExecutionException var2_3) {
            akx.h().a("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }

}

