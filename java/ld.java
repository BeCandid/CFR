/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  android.os.Message
 *  com.bumptech.glide.load.engine.EngineRunnable
 *  com.bumptech.glide.load.engine.EngineRunnable$a
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.HashSet
 *  java.util.List
 *  java.util.Set
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Future
 */
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bumptech.glide.load.engine.EngineRunnable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

class ld
implements EngineRunnable.a {
    private static final a a = new a();
    private static final Handler b = new Handler(Looper.getMainLooper(), (Handler.Callback)new b(null));
    private final List<qg> c = new ArrayList();
    private final a d;
    private final le e;
    private final kn f;
    private final ExecutorService g;
    private final ExecutorService h;
    private final boolean i;
    private boolean j;
    private lj<?> k;
    private boolean l;
    private Exception m;
    private boolean n;
    private Set<qg> o;
    private EngineRunnable p;
    private lh<?> q;
    private volatile Future<?> r;

    public ld(kn kn2, ExecutorService executorService, ExecutorService executorService2, boolean bl2, le le2) {
        this(kn2, executorService, executorService2, bl2, le2, a);
    }

    public ld(kn kn2, ExecutorService executorService, ExecutorService executorService2, boolean bl2, le le2, a a2) {
        this.f = kn2;
        this.g = executorService;
        this.h = executorService2;
        this.i = bl2;
        this.e = le2;
        this.d = a2;
    }

    private void b() {
        if (this.j) {
            this.k.d();
            return;
        }
        if (this.c.isEmpty()) {
            throw new IllegalStateException("Received a resource without any callbacks to notify");
        }
        this.q = this.d.a(this.k, this.i);
        this.l = true;
        this.q.e();
        this.e.a(this.f, this.q);
        for (qg qg2 : this.c) {
            if (this.d(qg2)) continue;
            this.q.e();
            qg2.a(this.q);
        }
        this.q.f();
    }

    /*
     * Enabled aggressive block sorting
     */
    private void c() {
        if (!this.j) {
            if (this.c.isEmpty()) {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            }
            this.n = true;
            this.e.a(this.f, null);
            for (qg qg2 : this.c) {
                if (this.d(qg2)) continue;
                qg2.a(this.m);
            }
        }
    }

    private void c(qg qg2) {
        if (this.o == null) {
            this.o = new HashSet();
        }
        this.o.add((Object)qg2);
    }

    private boolean d(qg qg2) {
        if (this.o != null && this.o.contains((Object)qg2)) {
            return true;
        }
        return false;
    }

    void a() {
        if (this.n || this.l || this.j) {
            return;
        }
        this.p.a();
        Future future = this.r;
        if (future != null) {
            future.cancel(true);
        }
        this.j = true;
        this.e.a(this, this.f);
    }

    public void a(EngineRunnable engineRunnable) {
        this.p = engineRunnable;
        this.r = this.g.submit((Runnable)engineRunnable);
    }

    public void a(Exception exception) {
        this.m = exception;
        b.obtainMessage(2, (Object)this).sendToTarget();
    }

    public void a(lj<?> lj2) {
        this.k = lj2;
        b.obtainMessage(1, (Object)this).sendToTarget();
    }

    public void a(qg qg2) {
        ri.a();
        if (this.l) {
            qg2.a(this.q);
            return;
        }
        if (this.n) {
            qg2.a(this.m);
            return;
        }
        this.c.add((Object)qg2);
    }

    public void b(EngineRunnable engineRunnable) {
        this.r = this.h.submit((Runnable)engineRunnable);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void b(qg qg2) {
        ri.a();
        if (this.l || this.n) {
            super.c(qg2);
            return;
        } else {
            this.c.remove((Object)qg2);
            if (!this.c.isEmpty()) return;
            {
                this.a();
                return;
            }
        }
    }

    static class a {
        a() {
        }

        public <R> lh<R> a(lj<R> lj2, boolean bl2) {
            return new lh<R>(lj2, bl2);
        }
    }

    static class b
    implements Handler.Callback {
        private b() {
        }

        /* synthetic */ b( var1) {
        }

        public boolean handleMessage(Message message) {
            if (1 == message.what || 2 == message.what) {
                ld ld2 = (ld)message.obj;
                if (1 == message.what) {
                    ld2.b();
                    return true;
                }
                ld2.c();
                return true;
            }
            return false;
        }
    }

}

