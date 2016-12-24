/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  java.lang.Object
 *  java.lang.String
 */
import android.graphics.Bitmap;

class ll
implements lr {
    private final b a = new b();
    private final lp<a, Bitmap> b = new lp();

    ll() {
    }

    private static String d(int n2, int n3, Bitmap.Config config) {
        return "[" + n2 + "x" + n3 + "], " + (Object)config;
    }

    private static String d(Bitmap bitmap) {
        return ll.d(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    @Override
    public Bitmap a() {
        return this.b.a();
    }

    @Override
    public Bitmap a(int n2, int n3, Bitmap.Config config) {
        a a2 = this.a.a(n2, n3, config);
        return this.b.a(a2);
    }

    @Override
    public void a(Bitmap bitmap) {
        a a2 = this.a.a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        this.b.a(a2, bitmap);
    }

    @Override
    public String b(int n2, int n3, Bitmap.Config config) {
        return ll.d(n2, n3, config);
    }

    @Override
    public String b(Bitmap bitmap) {
        return ll.d(bitmap);
    }

    @Override
    public int c(Bitmap bitmap) {
        return ri.a(bitmap);
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.b;
    }

    static class a
    implements ls {
        private final b a;
        private int b;
        private int c;
        private Bitmap.Config d;

        public a(b b2) {
            this.a = b2;
        }

        @Override
        public void a() {
            this.a.a(this);
        }

        public void a(int n2, int n3, Bitmap.Config config) {
            this.b = n2;
            this.c = n3;
            this.d = config;
        }

        public boolean equals(Object object) {
            boolean bl2 = object instanceof a;
            boolean bl3 = false;
            if (bl2) {
                a a2 = (a)object;
                int n2 = this.b;
                int n3 = a2.b;
                bl3 = false;
                if (n2 == n3) {
                    int n4 = this.c;
                    int n5 = a2.c;
                    bl3 = false;
                    if (n4 == n5) {
                        Bitmap.Config config = this.d;
                        Bitmap.Config config2 = a2.d;
                        bl3 = false;
                        if (config == config2) {
                            bl3 = true;
                        }
                    }
                }
            }
            return bl3;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public int hashCode() {
            int n2;
            int n3 = 31 * (31 * this.b + this.c);
            if (this.d != null) {
                n2 = this.d.hashCode();
                do {
                    return n3 + n2;
                    break;
                } while (true);
            }
            n2 = 0;
            return n3 + n2;
        }

        public String toString() {
            return ll.d(this.b, this.c, this.d);
        }
    }

    static class b
    extends lm<a> {
        b() {
        }

        protected a a() {
            return new a(this);
        }

        public a a(int n2, int n3, Bitmap.Config config) {
            a a2 = (a)this.c();
            a2.a(n2, n3, config);
            return a2;
        }

        @Override
        protected /* synthetic */ ls b() {
            return this.a();
        }
    }

}

