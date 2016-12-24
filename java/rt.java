/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  java.util.concurrent.RejectedExecutionException
 *  java.util.concurrent.ScheduledExecutorService
 *  java.util.concurrent.ScheduledFuture
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicReference
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

class rt {
    final AtomicReference<ScheduledFuture<?>> a = new AtomicReference();
    boolean b = true;
    private final ScheduledExecutorService c;
    private final List<a> d = new ArrayList();
    private volatile boolean e = true;

    public rt(ScheduledExecutorService scheduledExecutorService) {
        this.c = scheduledExecutorService;
    }

    private void c() {
        Iterator iterator = this.d.iterator();
        while (iterator.hasNext()) {
            ((a)iterator.next()).a();
        }
    }

    public void a() {
        this.b = false;
        ScheduledFuture scheduledFuture = (ScheduledFuture)this.a.getAndSet((Object)null);
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }

    public void a(a a2) {
        this.d.add((Object)a2);
    }

    public void a(boolean bl2) {
        this.e = bl2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void b() {
        if (!this.e || this.b) return;
        this.b = true;
        try {
            this.a.compareAndSet((Object)null, (Object)this.c.schedule(new Runnable(){

                public void run() {
                    rt.this.a.set((Object)null);
                    rt.this.c();
                }
            }, 5000, TimeUnit.MILLISECONDS));
            return;
        }
        catch (RejectedExecutionException var1_1) {
            akx.h().a("Answers", "Failed to schedule background detector", (Throwable)var1_1);
            return;
        }
    }

    public static interface a {
        public void a();
    }

}

