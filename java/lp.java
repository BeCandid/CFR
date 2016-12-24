/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class lp<K extends ls, V> {
    private final a<K, V> a = new a();
    private final Map<K, a<K, V>> b = new HashMap();

    lp() {
    }

    private void a(a<K, V> a2) {
        lp.d(a2);
        a2.b = this.a;
        a2.a = this.a.a;
        lp.c(a2);
    }

    private void b(a<K, V> a2) {
        lp.d(a2);
        a2.b = this.a.b;
        a2.a = this.a;
        lp.c(a2);
    }

    private static <K, V> void c(a<K, V> a2) {
        a2.a.b = a2;
        a2.b.a = a2;
    }

    private static <K, V> void d(a<K, V> a2) {
        a2.b.a = a2.a;
        a2.a.b = a2.b;
    }

    public V a() {
        a a2 = this.a.b;
        while (!a2.equals(this.a)) {
            Object v2 = a2.a();
            if (v2 != null) {
                return v2;
            }
            lp.d(a2);
            this.b.remove(a2.c);
            ((ls)a2.c).a();
            a2 = a2.b;
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     */
    public V a(K k2) {
        a a2 = (a)this.b.get(k2);
        if (a2 == null) {
            a2 = new a(k2);
            this.b.put(k2, a2);
        } else {
            k2.a();
        }
        super.a((K)a2);
        return a2.a();
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(K k2, V v2) {
        a<K, V> a2 = (a<K, V>)this.b.get(k2);
        if (a2 == null) {
            a2 = new a<K, V>(k2);
            super.b(a2);
            this.b.put(k2, a2);
        } else {
            k2.a();
        }
        a2.a(v2);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("GroupedLinkedMap( ");
        a a2 = this.a.a;
        boolean bl2 = false;
        while (!a2.equals(this.a)) {
            bl2 = true;
            stringBuilder.append('{').append(a2.c).append(':').append(a2.b()).append("}, ");
            a2 = a2.a;
        }
        if (bl2) {
            stringBuilder.delete(-2 + stringBuilder.length(), stringBuilder.length());
        }
        return stringBuilder.append(" )").toString();
    }

    static class a<K, V> {
        a<K, V> a;
        a<K, V> b;
        private final K c;
        private List<V> d;

        public a() {
            this(null);
        }

        public a(K k2) {
            this.b = this;
            this.a = this;
            this.c = k2;
        }

        public V a() {
            int n2 = this.b();
            if (n2 > 0) {
                return (V)this.d.remove(n2 - 1);
            }
            return null;
        }

        public void a(V v2) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            this.d.add(v2);
        }

        public int b() {
            if (this.d != null) {
                return this.d.size();
            }
            return 0;
        }
    }

}

