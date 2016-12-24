/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  android.os.Message
 *  java.lang.Object
 *  java.lang.ref.WeakReference
 */
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

public class y {
    private static y a;
    private final Object b = new Object();
    private final Handler c;
    private b d;
    private b e;

    private y() {
        this.c = new Handler(Looper.getMainLooper(), new Handler.Callback(){

            public boolean handleMessage(Message message) {
                switch (message.what) {
                    default: {
                        return false;
                    }
                    case 0: 
                }
                y.this.b((b)message.obj);
                return true;
            }
        });
    }

    public static y a() {
        if (a == null) {
            a = new y();
        }
        return a;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(b b2) {
        if (b2.b == -2) {
            return;
        }
        int n2 = 2750;
        if (b2.b > 0) {
            n2 = b2.b;
        } else if (b2.b == -1) {
            n2 = 1500;
        }
        this.c.removeCallbacksAndMessages((Object)b2);
        this.c.sendMessageDelayed(Message.obtain((Handler)this.c, (int)0, (Object)b2), (long)n2);
    }

    private boolean a(b b2, int n2) {
        a a2 = (a)b2.a.get();
        if (a2 != null) {
            this.c.removeCallbacksAndMessages((Object)b2);
            a2.a(n2);
            return true;
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void b() {
        if (this.e == null) return;
        this.d = this.e;
        this.e = null;
        a a2 = (a)this.d.a.get();
        if (a2 != null) {
            a2.a();
            return;
        }
        this.d = null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void b(b b2) {
        Object object;
        Object object2 = object = this.b;
        synchronized (object2) {
            if (this.d == b2 || this.e == b2) {
                super.a(b2, 2);
            }
            return;
        }
    }

    private boolean f(a a2) {
        if (this.d != null && this.d.a(a2)) {
            return true;
        }
        return false;
    }

    private boolean g(a a2) {
        if (this.e != null && this.e.a(a2)) {
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(int n2, a a2) {
        Object object;
        Object object2 = object = this.b;
        synchronized (object2) {
            if (super.f(a2)) {
                this.d.b = n2;
                this.c.removeCallbacksAndMessages((Object)this.d);
                super.a(this.d);
                return;
            }
            if (super.g(a2)) {
                this.e.b = n2;
            } else {
                this.e = new b(n2, a2);
            }
            if (this.d != null && super.a(this.d, 4)) {
                return;
            }
            this.d = null;
            super.b();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(a a2) {
        Object object;
        Object object2 = object = this.b;
        synchronized (object2) {
            if (super.f(a2)) {
                this.d = null;
                if (this.e != null) {
                    super.b();
                }
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(a a2, int n2) {
        Object object;
        Object object2 = object = this.b;
        synchronized (object2) {
            if (super.f(a2)) {
                super.a(this.d, n2);
            } else if (super.g(a2)) {
                super.a(this.e, n2);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b(a a2) {
        Object object;
        Object object2 = object = this.b;
        synchronized (object2) {
            if (super.f(a2)) {
                super.a(this.d);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c(a a2) {
        Object object;
        Object object2 = object = this.b;
        synchronized (object2) {
            if (super.f(a2)) {
                this.c.removeCallbacksAndMessages((Object)this.d);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void d(a a2) {
        Object object;
        Object object2 = object = this.b;
        synchronized (object2) {
            if (super.f(a2)) {
                super.a(this.d);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean e(a a2) {
        Object object;
        Object object2 = object = this.b;
        synchronized (object2) {
            if (super.f(a2)) return true;
            if (!super.g(a2)) return false;
            return true;
        }
    }

    public static interface a {
        public void a();

        public void a(int var1);
    }

    static class b {
        private final WeakReference<a> a;
        private int b;

        b(int n2, a a2) {
            this.a = new WeakReference((Object)a2);
            this.b = n2;
        }

        boolean a(a a2) {
            if (a2 != null && this.a.get() == a2) {
                return true;
            }
            return false;
        }
    }

}

