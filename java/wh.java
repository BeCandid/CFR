/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.util.concurrent.Executor
 */
import java.util.concurrent.Executor;

public class wh {
    static final /* synthetic */ boolean a;
    private final Object b;
    private b c;
    private final int d;
    private final Executor e;
    private b f;
    private int g;

    /*
     * Enabled aggressive block sorting
     */
    static {
        boolean bl2 = !wh.class.desiredAssertionStatus();
        a = bl2;
    }

    public wh() {
        this(8);
    }

    public wh(int n2) {
        super(n2, ul.d());
    }

    public wh(int n2, Executor executor) {
        this.b = new Object();
        this.f = null;
        this.g = 0;
        this.d = n2;
        this.e = executor;
    }

    private void a() {
        this.a((b)null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void a(b b2) {
        Object object;
        Object object2 = object = this.b;
        // MONITORENTER : object2
        if (b2 != null) {
            this.f = b2.a(this.f);
            this.g = -1 + this.g;
        }
        int n2 = this.g;
        int n3 = this.d;
        b b3 = null;
        if (n2 < n3 && (b3 = this.c) != null) {
            this.c = b3.a(this.c);
            this.f = b3.a(this.f, false);
            this.g = 1 + this.g;
            b3.a(true);
        }
        // MONITOREXIT : object2
        if (b3 == null) return;
        super.b(b3);
    }

    private void b(final b b2) {
        this.e.execute(new Runnable(){

            public void run() {
                try {
                    b2.d().run();
                    return;
                }
                finally {
                    wh.this.a(b2);
                }
            }
        });
    }

    public a a(Runnable runnable) {
        return this.a(runnable, true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public a a(Runnable runnable, boolean bl2) {
        Object object;
        b b2 = (wh)this.new b(runnable);
        Object object2 = object = this.b;
        synchronized (object2) {
            this.c = b2.a(this.c, bl2);
        }
        super.a();
        return b2;
    }

    public static interface a {
        public boolean a();

        public void b();
    }

    class b
    implements a {
        static final /* synthetic */ boolean a;
        private final Runnable c;
        private b d;
        private b e;
        private boolean f;

        /*
         * Enabled aggressive block sorting
         */
        static {
            boolean bl2 = !wh.class.desiredAssertionStatus();
            a = bl2;
        }

        b(Runnable runnable) {
            this.c = runnable;
        }

        /*
         * Enabled aggressive block sorting
         */
        b a(b b2) {
            if (!a && this.d == null) {
                throw new AssertionError();
            }
            if (!a && this.e == null) {
                throw new AssertionError();
            }
            if (b2 == this) {
                b2 = this.d == this ? null : this.d;
            }
            this.d.e = this.e;
            this.e.d = this.d;
            this.e = null;
            this.d = null;
            return b2;
        }

        /*
         * Enabled aggressive block sorting
         */
        b a(b b2, boolean bl2) {
            if (!a && this.d != null) {
                throw new AssertionError();
            }
            if (!a && this.e != null) {
                throw new AssertionError();
            }
            if (b2 == null) {
                this.e = this;
                this.d = this;
                b2 = this;
            } else {
                this.d = b2;
                this.e = b2.e;
                b b3 = this.d;
                this.e.d = this;
                b3.e = this;
            }
            if (bl2) {
                return this;
            }
            return b2;
        }

        void a(boolean bl2) {
            this.f = bl2;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public boolean a() {
            Object object;
            Object object2 = object = wh.this.b;
            synchronized (object2) {
                if (!this.c()) {
                    wh.this.c = this.a(wh.this.c);
                    return true;
                }
                return false;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void b() {
            Object object;
            Object object2 = object = wh.this.b;
            synchronized (object2) {
                if (!this.c()) {
                    wh.this.c = this.a(wh.this.c);
                    wh.this.c = this.a(wh.this.c, true);
                }
                return;
            }
        }

        public boolean c() {
            return this.f;
        }

        Runnable d() {
            return this.c;
        }
    }

}

