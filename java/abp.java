/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Message
 *  android.util.Log
 *  com.google.android.gms.common.api.Status
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ThreadLocal
 *  java.lang.Throwable
 *  java.lang.ref.WeakReference
 *  java.util.concurrent.Future
 */
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;
import java.util.concurrent.Future;

public class abp<R extends xk>
extends xo<R>
implements xl<R> {
    private xn<? super R, ? extends xk> a;
    private abp<? extends xk> b;
    private volatile xm<? super R> c;
    private xi<R> d;
    private final Object e;
    private Status f;
    private final WeakReference<xh> g;
    private final a h;
    private boolean i;

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void a() {
        if (this.a == null && this.c == null) {
            return;
        }
        xh xh2 = (xh)this.g.get();
        if (!this.i && this.a != null && xh2 != null) {
            xh2.a(this);
            this.i = true;
        }
        if (this.f != null) {
            this.b(this.f);
            return;
        }
        if (this.d == null) return;
        this.d.a(this);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    private void a(Status status) {
        Object object;
        Object object2 = object = this.e;
        synchronized (object2) {
            this.f = status;
            super.b(this.f);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void b(Status status) {
        Object object;
        Object object2 = object = this.e;
        synchronized (object2) {
            if (this.a != null) {
                Status status2 = this.a.a(status);
                xz.a(status2, (Object)"onFailure must not return null");
                super.a(status2);
            } else if (super.b()) {
                this.c.a(status);
            }
            return;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void b(xk xk2) {
        if (!(xk2 instanceof xj)) return;
        try {
            ((xj)((Object)xk2)).a();
            return;
        }
        catch (RuntimeException var2_2) {
            String string2 = String.valueOf((Object)xk2);
            Log.w((String)"TransformedResultImpl", (String)new StringBuilder(18 + String.valueOf((Object)string2).length()).append("Unable to release ").append(string2).toString(), (Throwable)var2_2);
            return;
        }
    }

    private boolean b() {
        xh xh2 = (xh)this.g.get();
        if (this.c != null && xh2 != null) {
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(xi<?> xi2) {
        Object object;
        Object object2 = object = this.e;
        synchronized (object2) {
            this.d = xi2;
            super.a();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(R r2) {
        Object object;
        Object object2 = object = this.e;
        synchronized (object2) {
            if (r2.a().f()) {
                if (this.a != null) {
                    abn.a().submit(new Runnable((xk)r2){
                        final /* synthetic */ xk a;

                        /*
                         * Enabled aggressive block sorting
                         * Enabled unnecessary exception pruning
                         * Enabled aggressive exception aggregation
                         * Lifted jumps to return sites
                         */
                        public void run() {
                            try {
                                abe.a.set((Object)true);
                                xi xi2 = abp.this.a.a(this.a);
                                abp.this.h.sendMessage(abp.this.h.obtainMessage(0, xi2));
                                return;
                            }
                            catch (RuntimeException var3_3) {
                                abp.this.h.sendMessage(abp.this.h.obtainMessage(1, (Object)var3_3));
                                return;
                            }
                            finally {
                                abe.a.set((Object)false);
                                abp.this.b(this.a);
                                xh xh2 = (xh)abp.this.g.get();
                                if (xh2 == null) return;
                                xh2.b(abp.this);
                            }
                        }
                    });
                } else if (super.b()) {
                    this.c.b(r2);
                }
            } else {
                super.a(r2.a());
                super.b((xk)r2);
            }
            return;
        }
    }

    final class a
    extends Handler {
        final /* synthetic */ abp a;

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public void handleMessage(Message message) {
            switch (message.what) {
                default: {
                    int n2 = message.what;
                    Log.e((String)"TransformedResultImpl", (String)new StringBuilder(70).append("TransformationResultHandler received unknown message type: ").append(n2).toString());
                    return;
                }
                case 0: {
                    Object object;
                    xi xi2 = (xi)message.obj;
                    Object object2 = object = this.a.e;
                    synchronized (object2) {
                        if (xi2 == null) {
                            this.a.b.a(new Status(13, "Transform returned null"));
                        } else if (xi2 instanceof abo) {
                            this.a.b.a(((abo)xi2).b());
                        } else {
                            this.a.b.a(xi2);
                        }
                        return;
                    }
                }
                case 1: 
            }
            RuntimeException runtimeException = (RuntimeException)message.obj;
            String string2 = String.valueOf((Object)runtimeException.getMessage());
            String string3 = string2.length() != 0 ? "Runtime exception on the transformation worker thread: ".concat(string2) : new String("Runtime exception on the transformation worker thread: ");
            Log.e((String)"TransformedResultImpl", (String)string3);
            throw runtimeException;
        }
    }

}

