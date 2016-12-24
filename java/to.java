/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.crashlytics.android.core.CodedOutputStream
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.TreeMap
 */
import com.crashlytics.android.core.CodedOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class to {
    private static final ue a = new ue("", "", 0);
    private static final j[] b = new j[0];
    private static final m[] c = new m[0];
    private static final g[] d = new g[0];
    private static final b[] e = new b[0];
    private static final c[] f = new c[0];

    private static d a(uc uc2) {
        return new d((float)uc2.f / 100.0f, uc2.g, uc2.h, uc2.a, uc2.b - uc2.d, uc2.c - uc2.e);
    }

    /*
     * Enabled aggressive block sorting
     */
    private static e a(ud ud2, tl tl2, Map<String, String> map) throws IOException {
        void var7_8;
        ue ue2 = ud2.b != null ? ud2.b : a;
        a a2 = new a(new f(new l(ue2), to.a(ud2.c), to.a(ud2.d)), to.a(to.a(ud2.e, map)));
        d d2 = to.a(ud2.f);
        sw sw2 = tl2.a();
        if (sw2 == null) {
            akx.h().a("CrashlyticsCore", "No log data to include with this event.");
        }
        tl2.b();
        if (sw2 != null) {
            h h2 = new h(sw2);
            return new e(ud2.a, "ndk-crash", new j[]{a2, d2, var7_8});
        } else {
            i i2 = new i();
        }
        return new e(ud2.a, "ndk-crash", new j[]{a2, d2, var7_8});
    }

    /*
     * Enabled aggressive block sorting
     */
    private static k a(ua[] arrua) {
        j[] arrj = arrua != null ? new b[arrua.length] : e;
        int n2 = 0;
        while (n2 < arrj.length) {
            arrj[n2] = new b(arrua[n2]);
            ++n2;
        }
        return new k(arrj);
    }

    /*
     * Enabled aggressive block sorting
     */
    private static k a(ub[] arrub) {
        j[] arrj = arrub != null ? new c[arrub.length] : f;
        int n2 = 0;
        while (n2 < arrj.length) {
            arrj[n2] = new c(arrub[n2]);
            ++n2;
        }
        return new k(arrj);
    }

    /*
     * Enabled aggressive block sorting
     */
    private static k a(uf.a[] arra) {
        j[] arrj = arra != null ? new g[arra.length] : d;
        int n2 = 0;
        while (n2 < arrj.length) {
            arrj[n2] = new g(arra[n2]);
            ++n2;
        }
        return new k(arrj);
    }

    /*
     * Enabled aggressive block sorting
     */
    private static k a(uf[] arruf) {
        j[] arrj = arruf != null ? new m[arruf.length] : c;
        int n2 = 0;
        while (n2 < arrj.length) {
            uf uf2 = arruf[n2];
            arrj[n2] = new m(uf2, to.a(uf2.c));
            ++n2;
        }
        return new k(arrj);
    }

    public static void a(ud ud2, tl tl2, Map<String, String> map, CodedOutputStream codedOutputStream) throws IOException {
        to.a(ud2, tl2, map).b(codedOutputStream);
    }

    private static ub[] a(ub[] arrub, Map<String, String> map) {
        TreeMap treeMap = new TreeMap(map);
        if (arrub != null) {
            for (ub ub2 : arrub) {
                treeMap.put((Object)ub2.a, (Object)ub2.b);
            }
        }
        Map.Entry[] arrentry = (Map.Entry[])treeMap.entrySet().toArray((Object[])new Map.Entry[treeMap.size()]);
        ub[] arrub2 = new ub[arrentry.length];
        for (int i2 = 0; i2 < arrub2.length; ++i2) {
            arrub2[i2] = new ub((String)arrentry[i2].getKey(), (String)arrentry[i2].getValue());
        }
        return arrub2;
    }

    static final class a
    extends j {
        public a(f f2, k k2) {
            super(3, f2, k2);
        }
    }

    static final class b
    extends j {
        private final long a;
        private final long b;
        private final String c;
        private final String d;

        public b(ua ua2) {
            super(4, new j[0]);
            this.a = ua2.a;
            this.b = ua2.b;
            this.c = ua2.c;
            this.d = ua2.d;
        }

        @Override
        public int a() {
            int n2 = CodedOutputStream.b((int)1, (long)this.a);
            int n3 = CodedOutputStream.b((int)2, (long)this.b);
            int n4 = CodedOutputStream.b((int)3, (sw)sw.a(this.c));
            return CodedOutputStream.b((int)4, (sw)sw.a(this.d)) + (n3 + (n4 + n2));
        }

        @Override
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            codedOutputStream.a(1, this.a);
            codedOutputStream.a(2, this.b);
            codedOutputStream.a(3, sw.a(this.c));
            codedOutputStream.a(4, sw.a(this.d));
        }
    }

    static final class c
    extends j {
        private final String a;
        private final String b;

        public c(ub ub2) {
            super(2, new j[0]);
            this.a = ub2.a;
            this.b = ub2.b;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public int a() {
            String string2;
            int n2 = CodedOutputStream.b((int)1, (sw)sw.a(this.a));
            if (this.b == null) {
                string2 = "";
                do {
                    return n2 + CodedOutputStream.b((int)2, (sw)sw.a(string2));
                    break;
                } while (true);
            }
            string2 = this.b;
            return n2 + CodedOutputStream.b((int)2, (sw)sw.a(string2));
        }

        /*
         * Enabled aggressive block sorting
         */
        @Override
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            codedOutputStream.a(1, sw.a(this.a));
            String string2 = this.b == null ? "" : this.b;
            codedOutputStream.a(2, sw.a(string2));
        }
    }

    static final class d
    extends j {
        private final float a;
        private final int b;
        private final boolean c;
        private final int d;
        private final long e;
        private final long f;

        public d(float f2, int n2, boolean bl2, int n3, long l2, long l3) {
            super(5, new j[0]);
            this.a = f2;
            this.b = n2;
            this.c = bl2;
            this.d = n3;
            this.e = l2;
            this.f = l3;
        }

        @Override
        public int a() {
            return 0 + CodedOutputStream.b((int)1, (float)this.a) + CodedOutputStream.f((int)2, (int)this.b) + CodedOutputStream.b((int)3, (boolean)this.c) + CodedOutputStream.d((int)4, (int)this.d) + CodedOutputStream.b((int)5, (long)this.e) + CodedOutputStream.b((int)6, (long)this.f);
        }

        @Override
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            codedOutputStream.a(1, this.a);
            codedOutputStream.c(2, this.b);
            codedOutputStream.a(3, this.c);
            codedOutputStream.a(4, this.d);
            codedOutputStream.a(5, this.e);
            codedOutputStream.a(6, this.f);
        }
    }

    static final class e
    extends j {
        private final long a;
        private final String b;

        public /* varargs */ e(long l2, String string2, j ... arrj) {
            super(10, arrj);
            this.a = l2;
            this.b = string2;
        }

        @Override
        public int a() {
            return CodedOutputStream.b((int)1, (long)this.a) + CodedOutputStream.b((int)2, (sw)sw.a(this.b));
        }

        @Override
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            codedOutputStream.a(1, this.a);
            codedOutputStream.a(2, sw.a(this.b));
        }
    }

    static final class f
    extends j {
        public f(l l2, k k2, k k3) {
            super(1, k2, l2, k3);
        }
    }

    static final class g
    extends j {
        private final long a;
        private final String b;
        private final String c;
        private final long d;
        private final int e;

        public g(uf.a a2) {
            super(3, new j[0]);
            this.a = a2.a;
            this.b = a2.b;
            this.c = a2.c;
            this.d = a2.d;
            this.e = a2.e;
        }

        @Override
        public int a() {
            return CodedOutputStream.b((int)1, (long)this.a) + CodedOutputStream.b((int)2, (sw)sw.a(this.b)) + CodedOutputStream.b((int)3, (sw)sw.a(this.c)) + CodedOutputStream.b((int)4, (long)this.d) + CodedOutputStream.d((int)5, (int)this.e);
        }

        @Override
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            codedOutputStream.a(1, this.a);
            codedOutputStream.a(2, sw.a(this.b));
            codedOutputStream.a(3, sw.a(this.c));
            codedOutputStream.a(4, this.d);
            codedOutputStream.a(5, this.e);
        }
    }

    static final class h
    extends j {
        sw a;

        public h(sw sw2) {
            super(6, new j[0]);
            this.a = sw2;
        }

        @Override
        public int a() {
            return CodedOutputStream.b((int)1, (sw)this.a);
        }

        @Override
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            codedOutputStream.a(1, this.a);
        }
    }

    static final class i
    extends j {
        public i() {
            super(0, new j[0]);
        }

        @Override
        public void b(CodedOutputStream codedOutputStream) throws IOException {
        }
    }

    static abstract class j {
        private final int a;
        private final j[] b;

        /*
         * Enabled aggressive block sorting
         */
        public /* varargs */ j(int n2, j ... arrj) {
            this.a = n2;
            if (arrj == null) {
                arrj = b;
            }
            this.b = arrj;
        }

        public int a() {
            return 0;
        }

        public void a(CodedOutputStream codedOutputStream) throws IOException {
        }

        public int b() {
            int n2 = this.c();
            return n2 + CodedOutputStream.l((int)n2) + CodedOutputStream.j((int)this.a);
        }

        public void b(CodedOutputStream codedOutputStream) throws IOException {
            codedOutputStream.g(this.a, 2);
            codedOutputStream.k(this.c());
            this.a(codedOutputStream);
            j[] arrj = this.b;
            int n2 = arrj.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                arrj[i2].b(codedOutputStream);
            }
        }

        public int c() {
            int n2 = this.a();
            j[] arrj = this.b;
            int n3 = arrj.length;
            for (int i2 = 0; i2 < n3; ++i2) {
                n2 += arrj[i2].b();
            }
            return n2;
        }
    }

    static final class k
    extends j {
        private final j[] a;

        public /* varargs */ k(j ... arrj) {
            super(0, new j[0]);
            this.a = arrj;
        }

        @Override
        public int b() {
            int n2 = 0;
            j[] arrj = this.a;
            int n3 = arrj.length;
            for (int i2 = 0; i2 < n3; ++i2) {
                n2 += arrj[i2].b();
            }
            return n2;
        }

        @Override
        public void b(CodedOutputStream codedOutputStream) throws IOException {
            j[] arrj = this.a;
            int n2 = arrj.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                arrj[i2].b(codedOutputStream);
            }
        }
    }

    static final class l
    extends j {
        private final String a;
        private final String b;
        private final long c;

        public l(ue ue2) {
            super(3, new j[0]);
            this.a = ue2.a;
            this.b = ue2.b;
            this.c = ue2.c;
        }

        @Override
        public int a() {
            return CodedOutputStream.b((int)1, (sw)sw.a(this.a)) + CodedOutputStream.b((int)2, (sw)sw.a(this.b)) + CodedOutputStream.b((int)3, (long)this.c);
        }

        @Override
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            codedOutputStream.a(1, sw.a(this.a));
            codedOutputStream.a(2, sw.a(this.b));
            codedOutputStream.a(3, this.c);
        }
    }

    static final class m
    extends j {
        private final String a;
        private final int b;

        public m(uf uf2, k k2) {
            super(1, k2);
            this.a = uf2.a;
            this.b = uf2.b;
        }

        private boolean d() {
            if (this.a != null && this.a.length() > 0) {
                return true;
            }
            return false;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public int a() {
            int n2;
            if (this.d()) {
                n2 = CodedOutputStream.b((int)1, (sw)sw.a(this.a));
                do {
                    return n2 + CodedOutputStream.d((int)2, (int)this.b);
                    break;
                } while (true);
            }
            n2 = 0;
            return n2 + CodedOutputStream.d((int)2, (int)this.b);
        }

        @Override
        public void a(CodedOutputStream codedOutputStream) throws IOException {
            if (super.d()) {
                codedOutputStream.a(1, sw.a(this.a));
            }
            codedOutputStream.a(2, this.b);
        }
    }

}

