/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Queue
 */
import java.util.Queue;

public class mq<A, B> {
    private final rf<a<A>, B> a;

    public mq() {
        this(250);
    }

    public mq(int n2) {
        this.a = new rf<a<A>, B>(n2){

            @Override
            protected void a(a<A> a2, B b2) {
                a2.a();
            }
        };
    }

    public B a(A a2, int n2, int n3) {
        a<A> a3 = a.a(a2, n2, n3);
        B b2 = this.a.b(a3);
        a3.a();
        return b2;
    }

    public void a(A a2, int n2, int n3, B b2) {
        a<A> a3 = a.a(a2, n2, n3);
        this.a.b(a3, b2);
    }

    static final class a<A> {
        private static final Queue<a<?>> a = ri.a(0);
        private int b;
        private int c;
        private A d;

        private a() {
        }

        static <A> a<A> a(A a2, int n2, int n3) {
            a<A> a3 = (a<A>)a.poll();
            if (a3 == null) {
                a3 = new a<A>();
            }
            a3.b(a2, n2, n3);
            return a3;
        }

        private void b(A a2, int n2, int n3) {
            this.d = a2;
            this.c = n2;
            this.b = n3;
        }

        public void a() {
            a.offer((Object)this);
        }

        public boolean equals(Object object) {
            boolean bl2 = object instanceof a;
            boolean bl3 = false;
            if (bl2) {
                a a2 = (a)object;
                int n2 = this.c;
                int n3 = a2.c;
                bl3 = false;
                if (n2 == n3) {
                    int n4 = this.b;
                    int n5 = a2.b;
                    bl3 = false;
                    if (n4 == n5) {
                        boolean bl4 = this.d.equals(a2.d);
                        bl3 = false;
                        if (bl4) {
                            bl3 = true;
                        }
                    }
                }
            }
            return bl3;
        }

        public int hashCode() {
            return 31 * (31 * this.b + this.c) + this.d.hashCode();
        }
    }

}

