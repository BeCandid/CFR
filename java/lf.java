/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.UnsupportedEncodingException
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.ByteBuffer
 *  java.security.MessageDigest
 */
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

class lf
implements kn {
    private final String a;
    private final int b;
    private final int c;
    private final kp d;
    private final kp e;
    private final kr f;
    private final kq g;
    private final pf h;
    private final km i;
    private final kn j;
    private String k;
    private int l;
    private kn m;

    public lf(String string2, kn kn2, int n2, int n3, kp kp2, kp kp3, kr kr2, kq kq2, pf pf2, km km2) {
        this.a = string2;
        this.j = kn2;
        this.b = n2;
        this.c = n3;
        this.d = kp2;
        this.e = kp3;
        this.f = kr2;
        this.g = kq2;
        this.h = pf2;
        this.i = km2;
    }

    public kn a() {
        if (this.m == null) {
            this.m = new li(this.a, this.j);
        }
        return this.m;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void a(MessageDigest messageDigest) throws UnsupportedEncodingException {
        byte[] arrby = ByteBuffer.allocate((int)8).putInt(this.b).putInt(this.c).array();
        this.j.a(messageDigest);
        messageDigest.update(this.a.getBytes("UTF-8"));
        messageDigest.update(arrby);
        String string2 = this.d != null ? this.d.a() : "";
        messageDigest.update(string2.getBytes("UTF-8"));
        String string3 = this.e != null ? this.e.a() : "";
        messageDigest.update(string3.getBytes("UTF-8"));
        String string4 = this.f != null ? this.f.a() : "";
        messageDigest.update(string4.getBytes("UTF-8"));
        String string5 = this.g != null ? this.g.a() : "";
        messageDigest.update(string5.getBytes("UTF-8"));
        String string6 = this.i != null ? this.i.a() : "";
        messageDigest.update(string6.getBytes("UTF-8"));
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        boolean bl2 = false;
        if (object == null) return bl2;
        Class class_ = this.getClass();
        Class class_2 = object.getClass();
        bl2 = false;
        if (class_ != class_2) return bl2;
        lf lf2 = (lf)object;
        boolean bl3 = this.a.equals((Object)lf2.a);
        bl2 = false;
        if (!bl3) return bl2;
        boolean bl4 = this.j.equals((Object)lf2.j);
        bl2 = false;
        if (!bl4) return bl2;
        int n2 = this.c;
        int n3 = lf2.c;
        bl2 = false;
        if (n2 != n3) return bl2;
        int n4 = this.b;
        int n5 = lf2.b;
        bl2 = false;
        if (n4 != n5) return bl2;
        boolean bl5 = this.f == null;
        boolean bl6 = lf2.f == null;
        boolean bl7 = bl5 ^ bl6;
        bl2 = false;
        if (bl7) return bl2;
        if (this.f != null) {
            boolean bl8 = this.f.a().equals((Object)lf2.f.a());
            bl2 = false;
            if (!bl8) return bl2;
        }
        boolean bl9 = this.e == null;
        boolean bl10 = lf2.e == null;
        boolean bl11 = bl9 ^ bl10;
        bl2 = false;
        if (bl11) return bl2;
        if (this.e != null) {
            boolean bl12 = this.e.a().equals((Object)lf2.e.a());
            bl2 = false;
            if (!bl12) return bl2;
        }
        boolean bl13 = this.d == null;
        boolean bl14 = lf2.d == null;
        boolean bl15 = bl13 ^ bl14;
        bl2 = false;
        if (bl15) return bl2;
        if (this.d != null) {
            boolean bl16 = this.d.a().equals((Object)lf2.d.a());
            bl2 = false;
            if (!bl16) return bl2;
        }
        boolean bl17 = this.g == null;
        boolean bl18 = lf2.g == null;
        boolean bl19 = bl17 ^ bl18;
        bl2 = false;
        if (bl19) return bl2;
        if (this.g != null) {
            boolean bl20 = this.g.a().equals((Object)lf2.g.a());
            bl2 = false;
            if (!bl20) return bl2;
        }
        boolean bl21 = this.h == null;
        boolean bl22 = lf2.h == null;
        boolean bl23 = bl21 ^ bl22;
        bl2 = false;
        if (bl23) return bl2;
        if (this.h != null) {
            boolean bl24 = this.h.a().equals((Object)lf2.h.a());
            bl2 = false;
            if (!bl24) return bl2;
        }
        boolean bl25 = this.i == null;
        boolean bl26 = lf2.i == null;
        boolean bl27 = bl25 ^ bl26;
        bl2 = false;
        if (bl27) return bl2;
        if (this.i == null) return true;
        boolean bl28 = this.i.a().equals((Object)lf2.i.a());
        bl2 = false;
        if (!bl28) return bl2;
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    public int hashCode() {
        if (this.l == 0) {
            this.l = this.a.hashCode();
            this.l = 31 * this.l + this.j.hashCode();
            this.l = 31 * this.l + this.b;
            this.l = 31 * this.l + this.c;
            int n2 = 31 * this.l;
            int n3 = this.d != null ? this.d.a().hashCode() : 0;
            this.l = n3 + n2;
            int n4 = 31 * this.l;
            int n5 = this.e != null ? this.e.a().hashCode() : 0;
            this.l = n5 + n4;
            int n6 = 31 * this.l;
            int n7 = this.f != null ? this.f.a().hashCode() : 0;
            this.l = n7 + n6;
            int n8 = 31 * this.l;
            int n9 = this.g != null ? this.g.a().hashCode() : 0;
            this.l = n9 + n8;
            int n10 = 31 * this.l;
            int n11 = this.h != null ? this.h.a().hashCode() : 0;
            this.l = n11 + n10;
            int n12 = 31 * this.l;
            km km2 = this.i;
            int n13 = 0;
            if (km2 != null) {
                n13 = this.i.a().hashCode();
            }
            this.l = n12 + n13;
        }
        return this.l;
    }

    /*
     * Enabled aggressive block sorting
     */
    public String toString() {
        if (this.k == null) {
            StringBuilder stringBuilder = new StringBuilder().append("EngineKey{").append(this.a).append('+').append((Object)this.j).append("+[").append(this.b).append('x').append(this.c).append("]+").append('\'');
            String string2 = this.d != null ? this.d.a() : "";
            StringBuilder stringBuilder2 = stringBuilder.append(string2).append('\'').append('+').append('\'');
            String string3 = this.e != null ? this.e.a() : "";
            StringBuilder stringBuilder3 = stringBuilder2.append(string3).append('\'').append('+').append('\'');
            String string4 = this.f != null ? this.f.a() : "";
            StringBuilder stringBuilder4 = stringBuilder3.append(string4).append('\'').append('+').append('\'');
            String string5 = this.g != null ? this.g.a() : "";
            StringBuilder stringBuilder5 = stringBuilder4.append(string5).append('\'').append('+').append('\'');
            String string6 = this.h != null ? this.h.a() : "";
            StringBuilder stringBuilder6 = stringBuilder5.append(string6).append('\'').append('+').append('\'');
            String string7 = this.i != null ? this.i.a() : "";
            this.k = stringBuilder6.append(string7).append('\'').append('}').toString();
        }
        return this.k;
    }
}

