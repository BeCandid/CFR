/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.zzamc
 *  java.io.IOException
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
import com.google.android.gms.internal.zzamc;
import java.io.IOException;

public interface aby {

    public static final class a
    extends aau {
        private static volatile a[] e;
        public Integer b;
        public e[] c;
        public b[] d;

        public a() {
            this.f();
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public static a[] e() {
            if (e == null) {
                Object object;
                Object object2 = object = aat.c;
                synchronized (object2) {
                    if (e == null) {
                        e = new a[0];
                    }
                }
            }
            return e;
        }

        @Override
        public /* synthetic */ aau a(aas aas2) throws IOException {
            return this.b(aas2);
        }

        @Override
        public void a(zzamc zzamc2) throws IOException {
            if (this.b != null) {
                zzamc2.a(1, this.b.intValue());
            }
            if (this.c != null && this.c.length > 0) {
                for (int i2 = 0; i2 < this.c.length; ++i2) {
                    e e2 = this.c[i2];
                    if (e2 == null) continue;
                    zzamc2.a(2, (aau)e2);
                }
            }
            if (this.d != null) {
                int n2 = this.d.length;
                if (n2 > 0) {
                    for (int i3 = 0; i3 < this.d.length; ++i3) {
                        b b2 = this.d[i3];
                        if (b2 == null) continue;
                        zzamc2.a(3, (aau)b2);
                    }
                }
            }
            super.a(zzamc2);
        }

        /*
         * Enabled aggressive block sorting
         */
        public a b(aas aas2) throws IOException {
            block6 : do {
                int n2 = aas2.a();
                switch (n2) {
                    default: {
                        if (aaw.a(aas2, n2)) continue block6;
                    }
                    case 0: {
                        return this;
                    }
                    case 8: {
                        this.b = aas2.g();
                        continue block6;
                    }
                    case 18: {
                        int n3 = aaw.b(aas2, 18);
                        int n4 = this.c == null ? 0 : this.c.length;
                        e[] arre = new e[n3 + n4];
                        if (n4 != 0) {
                            System.arraycopy((Object)this.c, (int)0, (Object)arre, (int)0, (int)n4);
                        }
                        while (n4 < -1 + arre.length) {
                            arre[n4] = new e();
                            aas2.a(arre[n4]);
                            aas2.a();
                            ++n4;
                        }
                        arre[n4] = new e();
                        aas2.a(arre[n4]);
                        this.c = arre;
                        continue block6;
                    }
                    case 26: 
                }
                int n5 = aaw.b(aas2, 26);
                int n6 = this.d == null ? 0 : this.d.length;
                b[] arrb = new b[n5 + n6];
                if (n6 != 0) {
                    System.arraycopy((Object)this.d, (int)0, (Object)arrb, (int)0, (int)n6);
                }
                while (n6 < -1 + arrb.length) {
                    arrb[n6] = new b();
                    aas2.a(arrb[n6]);
                    aas2.a();
                    ++n6;
                }
                arrb[n6] = new b();
                aas2.a(arrb[n6]);
                this.d = arrb;
            } while (true);
        }

        @Override
        protected int c() {
            int n2 = super.c();
            if (this.b != null) {
                n2 += zzamc.b((int)1, (int)this.b);
            }
            if (this.c != null && this.c.length > 0) {
                int n3 = n2;
                for (int i2 = 0; i2 < this.c.length; ++i2) {
                    e e2 = this.c[i2];
                    if (e2 == null) continue;
                    n3 += zzamc.b((int)2, (aau)e2);
                }
                n2 = n3;
            }
            if (this.d != null) {
                int n4 = this.d.length;
                if (n4 > 0) {
                    for (int i3 = 0; i3 < this.d.length; ++i3) {
                        b b2 = this.d[i3];
                        if (b2 == null) continue;
                        n2 += zzamc.b((int)3, (aau)b2);
                    }
                }
            }
            return n2;
        }

        /*
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof a)) {
                return false;
            }
            a a2 = (a)object;
            if (this.b == null ? a2.b != null : !this.b.equals((Object)a2.b)) {
                return false;
            }
            if (!aat.a(this.c, a2.c)) {
                return false;
            }
            if (aat.a(this.d, a2.d)) return true;
            return false;
        }

        public a f() {
            this.b = null;
            this.c = e.e();
            this.d = b.e();
            this.a = -1;
            return this;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public int hashCode() {
            int n2;
            int n3 = 31 * (527 + this.getClass().getName().hashCode());
            if (this.b == null) {
                n2 = 0;
                do {
                    return 31 * (31 * (n2 + n3) + aat.a(this.c)) + aat.a(this.d);
                    break;
                } while (true);
            }
            n2 = this.b.hashCode();
            return 31 * (31 * (n2 + n3) + aat.a(this.c)) + aat.a(this.d);
        }
    }

    public static final class b
    extends aau {
        private static volatile b[] g;
        public Integer b;
        public String c;
        public c[] d;
        public Boolean e;
        public d f;

        public b() {
            this.f();
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public static b[] e() {
            if (g == null) {
                Object object;
                Object object2 = object = aat.c;
                synchronized (object2) {
                    if (g == null) {
                        g = new b[0];
                    }
                }
            }
            return g;
        }

        @Override
        public /* synthetic */ aau a(aas aas2) throws IOException {
            return this.b(aas2);
        }

        @Override
        public void a(zzamc zzamc2) throws IOException {
            if (this.b != null) {
                zzamc2.a(1, this.b.intValue());
            }
            if (this.c != null) {
                zzamc2.a(2, this.c);
            }
            if (this.d != null && this.d.length > 0) {
                for (int i2 = 0; i2 < this.d.length; ++i2) {
                    c c2 = this.d[i2];
                    if (c2 == null) continue;
                    zzamc2.a(3, (aau)c2);
                }
            }
            if (this.e != null) {
                zzamc2.a(4, this.e.booleanValue());
            }
            if (this.f != null) {
                zzamc2.a(5, (aau)this.f);
            }
            super.a(zzamc2);
        }

        /*
         * Enabled aggressive block sorting
         */
        public b b(aas aas2) throws IOException {
            block8 : do {
                int n2 = aas2.a();
                switch (n2) {
                    default: {
                        if (aaw.a(aas2, n2)) continue block8;
                    }
                    case 0: {
                        return this;
                    }
                    case 8: {
                        this.b = aas2.g();
                        continue block8;
                    }
                    case 18: {
                        this.c = aas2.i();
                        continue block8;
                    }
                    case 26: {
                        int n3 = aaw.b(aas2, 26);
                        int n4 = this.d == null ? 0 : this.d.length;
                        c[] arrc = new c[n3 + n4];
                        if (n4 != 0) {
                            System.arraycopy((Object)this.d, (int)0, (Object)arrc, (int)0, (int)n4);
                        }
                        while (n4 < -1 + arrc.length) {
                            arrc[n4] = new c();
                            aas2.a(arrc[n4]);
                            aas2.a();
                            ++n4;
                        }
                        arrc[n4] = new c();
                        aas2.a(arrc[n4]);
                        this.d = arrc;
                        continue block8;
                    }
                    case 32: {
                        this.e = aas2.h();
                        continue block8;
                    }
                    case 42: 
                }
                if (this.f == null) {
                    this.f = new d();
                }
                aas2.a(this.f);
            } while (true);
        }

        @Override
        protected int c() {
            int n2 = super.c();
            if (this.b != null) {
                n2 += zzamc.b((int)1, (int)this.b);
            }
            if (this.c != null) {
                n2 += zzamc.b((int)2, (String)this.c);
            }
            if (this.d != null && this.d.length > 0) {
                int n3 = n2;
                for (int i2 = 0; i2 < this.d.length; ++i2) {
                    c c2 = this.d[i2];
                    if (c2 == null) continue;
                    n3 += zzamc.b((int)3, (aau)c2);
                }
                n2 = n3;
            }
            if (this.e != null) {
                n2 += zzamc.b((int)4, (boolean)this.e);
            }
            if (this.f != null) {
                n2 += zzamc.b((int)5, (aau)this.f);
            }
            return n2;
        }

        /*
         * Enabled aggressive block sorting
         */
        public boolean equals(Object object) {
            if (object == this) return true;
            if (!(object instanceof b)) {
                return false;
            }
            b b2 = (b)object;
            if (this.b == null ? b2.b != null : !this.b.equals((Object)b2.b)) {
                return false;
            }
            if (this.c == null ? b2.c != null : !this.c.equals((Object)b2.c)) {
                return false;
            }
            if (!aat.a(this.d, b2.d)) {
                return false;
            }
            if (this.e == null ? b2.e != null : !this.e.equals((Object)b2.e)) {
                return false;
            }
            if (this.f == null) {
                if (b2.f == null) return true;
                return false;
            }
            if (!this.f.equals(b2.f)) return false;
            return true;
        }

        public b f() {
            this.b = null;
            this.c = null;
            this.d = c.e();
            this.e = null;
            this.f = null;
            this.a = -1;
            return this;
        }

        /*
         * Enabled aggressive block sorting
         */
        public int hashCode() {
            int n2 = 31 * (527 + this.getClass().getName().hashCode());
            int n3 = this.b == null ? 0 : this.b.hashCode();
            int n4 = 31 * (n3 + n2);
            int n5 = this.c == null ? 0 : this.c.hashCode();
            int n6 = 31 * (31 * (n5 + n4) + aat.a(this.d));
            int n7 = this.e == null ? 0 : this.e.hashCode();
            int n8 = 31 * (n7 + n6);
            d d2 = this.f;
            int n9 = 0;
            if (d2 == null) {
                return n8 + n9;
            }
            n9 = this.f.hashCode();
            return n8 + n9;
        }
    }

    public static final class c
    extends aau {
        private static volatile c[] f;
        public f b;
        public d c;
        public Boolean d;
        public String e;

        public c() {
            this.f();
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public static c[] e() {
            if (f == null) {
                Object object;
                Object object2 = object = aat.c;
                synchronized (object2) {
                    if (f == null) {
                        f = new c[0];
                    }
                }
            }
            return f;
        }

        @Override
        public /* synthetic */ aau a(aas aas2) throws IOException {
            return this.b(aas2);
        }

        @Override
        public void a(zzamc zzamc2) throws IOException {
            if (this.b != null) {
                zzamc2.a(1, (aau)this.b);
            }
            if (this.c != null) {
                zzamc2.a(2, (aau)this.c);
            }
            if (this.d != null) {
                zzamc2.a(3, this.d.booleanValue());
            }
            if (this.e != null) {
                zzamc2.a(4, this.e);
            }
            super.a(zzamc2);
        }

        public c b(aas aas2) throws IOException {
            block7 : do {
                int n2 = aas2.a();
                switch (n2) {
                    default: {
                        if (aaw.a(aas2, n2)) continue block7;
                    }
                    case 0: {
                        return this;
                    }
                    case 10: {
                        if (this.b == null) {
                            this.b = new f();
                        }
                        aas2.a(this.b);
                        continue block7;
                    }
                    case 18: {
                        if (this.c == null) {
                            this.c = new d();
                        }
                        aas2.a(this.c);
                        continue block7;
                    }
                    case 24: {
                        this.d = aas2.h();
                        continue block7;
                    }
                    case 34: 
                }
                this.e = aas2.i();
            } while (true);
        }

        @Override
        protected int c() {
            int n2 = super.c();
            if (this.b != null) {
                n2 += zzamc.b((int)1, (aau)this.b);
            }
            if (this.c != null) {
                n2 += zzamc.b((int)2, (aau)this.c);
            }
            if (this.d != null) {
                n2 += zzamc.b((int)3, (boolean)this.d);
            }
            if (this.e != null) {
                n2 += zzamc.b((int)4, (String)this.e);
            }
            return n2;
        }

        /*
         * Enabled aggressive block sorting
         */
        public boolean equals(Object object) {
            if (object == this) return true;
            if (!(object instanceof c)) {
                return false;
            }
            c c2 = (c)object;
            if (this.b == null ? c2.b != null : !this.b.equals(c2.b)) {
                return false;
            }
            if (this.c == null ? c2.c != null : !this.c.equals(c2.c)) {
                return false;
            }
            if (this.d == null ? c2.d != null : !this.d.equals((Object)c2.d)) {
                return false;
            }
            if (this.e == null) {
                if (c2.e == null) return true;
                return false;
            }
            if (!this.e.equals((Object)c2.e)) return false;
            return true;
        }

        public c f() {
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.a = -1;
            return this;
        }

        /*
         * Enabled aggressive block sorting
         */
        public int hashCode() {
            int n2 = 31 * (527 + this.getClass().getName().hashCode());
            int n3 = this.b == null ? 0 : this.b.hashCode();
            int n4 = 31 * (n3 + n2);
            int n5 = this.c == null ? 0 : this.c.hashCode();
            int n6 = 31 * (n5 + n4);
            int n7 = this.d == null ? 0 : this.d.hashCode();
            int n8 = 31 * (n7 + n6);
            String string2 = this.e;
            int n9 = 0;
            if (string2 == null) {
                return n8 + n9;
            }
            n9 = this.e.hashCode();
            return n8 + n9;
        }
    }

    public static final class d
    extends aau {
        public Integer b;
        public Boolean c;
        public String d;
        public String e;
        public String f;

        public d() {
            this.e();
        }

        @Override
        public /* synthetic */ aau a(aas aas2) throws IOException {
            return this.b(aas2);
        }

        @Override
        public void a(zzamc zzamc2) throws IOException {
            if (this.b != null) {
                zzamc2.a(1, this.b.intValue());
            }
            if (this.c != null) {
                zzamc2.a(2, this.c.booleanValue());
            }
            if (this.d != null) {
                zzamc2.a(3, this.d);
            }
            if (this.e != null) {
                zzamc2.a(4, this.e);
            }
            if (this.f != null) {
                zzamc2.a(5, this.f);
            }
            super.a(zzamc2);
        }

        public d b(aas aas2) throws IOException {
            block11 : do {
                int n2 = aas2.a();
                switch (n2) {
                    default: {
                        if (aaw.a(aas2, n2)) continue block11;
                    }
                    case 0: {
                        return this;
                    }
                    case 8: {
                        int n3 = aas2.g();
                        switch (n3) {
                            default: {
                                continue block11;
                            }
                            case 0: 
                            case 1: 
                            case 2: 
                            case 3: 
                            case 4: 
                        }
                        this.b = n3;
                        continue block11;
                    }
                    case 16: {
                        this.c = aas2.h();
                        continue block11;
                    }
                    case 26: {
                        this.d = aas2.i();
                        continue block11;
                    }
                    case 34: {
                        this.e = aas2.i();
                        continue block11;
                    }
                    case 42: 
                }
                this.f = aas2.i();
            } while (true);
        }

        @Override
        protected int c() {
            int n2 = super.c();
            if (this.b != null) {
                n2 += zzamc.b((int)1, (int)this.b);
            }
            if (this.c != null) {
                n2 += zzamc.b((int)2, (boolean)this.c);
            }
            if (this.d != null) {
                n2 += zzamc.b((int)3, (String)this.d);
            }
            if (this.e != null) {
                n2 += zzamc.b((int)4, (String)this.e);
            }
            if (this.f != null) {
                n2 += zzamc.b((int)5, (String)this.f);
            }
            return n2;
        }

        public d e() {
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            this.a = -1;
            return this;
        }

        /*
         * Enabled aggressive block sorting
         */
        public boolean equals(Object object) {
            if (object == this) return true;
            if (!(object instanceof d)) {
                return false;
            }
            d d2 = (d)object;
            if (this.b == null ? d2.b != null : !this.b.equals((Object)d2.b)) {
                return false;
            }
            if (this.c == null ? d2.c != null : !this.c.equals((Object)d2.c)) {
                return false;
            }
            if (this.d == null ? d2.d != null : !this.d.equals((Object)d2.d)) {
                return false;
            }
            if (this.e == null ? d2.e != null : !this.e.equals((Object)d2.e)) {
                return false;
            }
            if (this.f == null) {
                if (d2.f == null) return true;
                return false;
            }
            if (!this.f.equals((Object)d2.f)) return false;
            return true;
        }

        /*
         * Enabled aggressive block sorting
         */
        public int hashCode() {
            int n2 = 31 * (527 + this.getClass().getName().hashCode());
            int n3 = this.b == null ? 0 : this.b;
            int n4 = 31 * (n3 + n2);
            int n5 = this.c == null ? 0 : this.c.hashCode();
            int n6 = 31 * (n5 + n4);
            int n7 = this.d == null ? 0 : this.d.hashCode();
            int n8 = 31 * (n7 + n6);
            int n9 = this.e == null ? 0 : this.e.hashCode();
            int n10 = 31 * (n9 + n8);
            String string2 = this.f;
            int n11 = 0;
            if (string2 == null) {
                return n10 + n11;
            }
            n11 = this.f.hashCode();
            return n10 + n11;
        }
    }

    public static final class e
    extends aau {
        private static volatile e[] e;
        public Integer b;
        public String c;
        public c d;

        public e() {
            this.f();
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public static e[] e() {
            if (e == null) {
                Object object;
                Object object2 = object = aat.c;
                synchronized (object2) {
                    if (e == null) {
                        e = new e[0];
                    }
                }
            }
            return e;
        }

        @Override
        public /* synthetic */ aau a(aas aas2) throws IOException {
            return this.b(aas2);
        }

        @Override
        public void a(zzamc zzamc2) throws IOException {
            if (this.b != null) {
                zzamc2.a(1, this.b.intValue());
            }
            if (this.c != null) {
                zzamc2.a(2, this.c);
            }
            if (this.d != null) {
                zzamc2.a(3, (aau)this.d);
            }
            super.a(zzamc2);
        }

        public e b(aas aas2) throws IOException {
            block6 : do {
                int n2 = aas2.a();
                switch (n2) {
                    default: {
                        if (aaw.a(aas2, n2)) continue block6;
                    }
                    case 0: {
                        return this;
                    }
                    case 8: {
                        this.b = aas2.g();
                        continue block6;
                    }
                    case 18: {
                        this.c = aas2.i();
                        continue block6;
                    }
                    case 26: 
                }
                if (this.d == null) {
                    this.d = new c();
                }
                aas2.a(this.d);
            } while (true);
        }

        @Override
        protected int c() {
            int n2 = super.c();
            if (this.b != null) {
                n2 += zzamc.b((int)1, (int)this.b);
            }
            if (this.c != null) {
                n2 += zzamc.b((int)2, (String)this.c);
            }
            if (this.d != null) {
                n2 += zzamc.b((int)3, (aau)this.d);
            }
            return n2;
        }

        /*
         * Enabled aggressive block sorting
         */
        public boolean equals(Object object) {
            if (object == this) return true;
            if (!(object instanceof e)) {
                return false;
            }
            e e2 = (e)object;
            if (this.b == null ? e2.b != null : !this.b.equals((Object)e2.b)) {
                return false;
            }
            if (this.c == null ? e2.c != null : !this.c.equals((Object)e2.c)) {
                return false;
            }
            if (this.d == null) {
                if (e2.d == null) return true;
                return false;
            }
            if (!this.d.equals(e2.d)) return false;
            return true;
        }

        public e f() {
            this.b = null;
            this.c = null;
            this.d = null;
            this.a = -1;
            return this;
        }

        /*
         * Enabled aggressive block sorting
         */
        public int hashCode() {
            int n2 = 31 * (527 + this.getClass().getName().hashCode());
            int n3 = this.b == null ? 0 : this.b.hashCode();
            int n4 = 31 * (n3 + n2);
            int n5 = this.c == null ? 0 : this.c.hashCode();
            int n6 = 31 * (n5 + n4);
            c c2 = this.d;
            int n7 = 0;
            if (c2 == null) {
                return n6 + n7;
            }
            n7 = this.d.hashCode();
            return n6 + n7;
        }
    }

    public static final class f
    extends aau {
        public Integer b;
        public String c;
        public Boolean d;
        public String[] e;

        public f() {
            this.e();
        }

        @Override
        public /* synthetic */ aau a(aas aas2) throws IOException {
            return this.b(aas2);
        }

        @Override
        public void a(zzamc zzamc2) throws IOException {
            if (this.b != null) {
                zzamc2.a(1, this.b.intValue());
            }
            if (this.c != null) {
                zzamc2.a(2, this.c);
            }
            if (this.d != null) {
                zzamc2.a(3, this.d.booleanValue());
            }
            if (this.e != null && this.e.length > 0) {
                for (int i2 = 0; i2 < this.e.length; ++i2) {
                    String string2 = this.e[i2];
                    if (string2 == null) continue;
                    zzamc2.a(4, string2);
                }
            }
            super.a(zzamc2);
        }

        /*
         * Enabled aggressive block sorting
         */
        public f b(aas aas2) throws IOException {
            block10 : do {
                int n2 = aas2.a();
                switch (n2) {
                    default: {
                        if (aaw.a(aas2, n2)) continue block10;
                    }
                    case 0: {
                        return this;
                    }
                    case 8: {
                        int n3 = aas2.g();
                        switch (n3) {
                            default: {
                                continue block10;
                            }
                            case 0: 
                            case 1: 
                            case 2: 
                            case 3: 
                            case 4: 
                            case 5: 
                            case 6: 
                        }
                        this.b = n3;
                        continue block10;
                    }
                    case 18: {
                        this.c = aas2.i();
                        continue block10;
                    }
                    case 24: {
                        this.d = aas2.h();
                        continue block10;
                    }
                    case 34: 
                }
                int n4 = aaw.b(aas2, 34);
                int n5 = this.e == null ? 0 : this.e.length;
                String[] arrstring = new String[n4 + n5];
                if (n5 != 0) {
                    System.arraycopy((Object)this.e, (int)0, (Object)arrstring, (int)0, (int)n5);
                }
                while (n5 < -1 + arrstring.length) {
                    arrstring[n5] = aas2.i();
                    aas2.a();
                    ++n5;
                }
                arrstring[n5] = aas2.i();
                this.e = arrstring;
            } while (true);
        }

        @Override
        protected int c() {
            int n2 = 0;
            int n3 = super.c();
            if (this.b != null) {
                n3 += zzamc.b((int)1, (int)this.b);
            }
            if (this.c != null) {
                n3 += zzamc.b((int)2, (String)this.c);
            }
            if (this.d != null) {
                n3 += zzamc.b((int)3, (boolean)this.d);
            }
            if (this.e != null && this.e.length > 0) {
                int n4 = 0;
                int n5 = 0;
                while (n2 < this.e.length) {
                    String string2 = this.e[n2];
                    if (string2 != null) {
                        ++n5;
                        n4 += zzamc.b((String)string2);
                    }
                    ++n2;
                }
                n3 = n3 + n4 + n5 * 1;
            }
            return n3;
        }

        public f e() {
            this.c = null;
            this.d = null;
            this.e = aaw.f;
            this.a = -1;
            return this;
        }

        /*
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof f)) {
                return false;
            }
            f f2 = (f)object;
            if (this.b == null ? f2.b != null : !this.b.equals((Object)f2.b)) {
                return false;
            }
            if (this.c == null ? f2.c != null : !this.c.equals((Object)f2.c)) {
                return false;
            }
            if (this.d == null ? f2.d != null : !this.d.equals((Object)f2.d)) {
                return false;
            }
            if (aat.a(this.e, f2.e)) return true;
            return false;
        }

        /*
         * Enabled aggressive block sorting
         */
        public int hashCode() {
            int n2 = 31 * (527 + this.getClass().getName().hashCode());
            int n3 = this.b == null ? 0 : this.b;
            int n4 = 31 * (n3 + n2);
            int n5 = this.c == null ? 0 : this.c.hashCode();
            int n6 = 31 * (n5 + n4);
            Boolean bl2 = this.d;
            int n7 = 0;
            if (bl2 == null) {
                return 31 * (n6 + n7) + aat.a(this.e);
            }
            n7 = this.d.hashCode();
            return 31 * (n6 + n7) + aat.a(this.e);
        }
    }

}

