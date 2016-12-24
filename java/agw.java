/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
class agw {
    final String a;
    final String b;
    final long c;
    final long d;
    final long e;

    /*
     * Enabled aggressive block sorting
     */
    agw(String string2, String string3, long l2, long l3, long l4) {
        boolean bl2 = true;
        xz.a(string2);
        xz.a(string3);
        boolean bl3 = l2 >= 0 ? bl2 : false;
        xz.b(bl3);
        if (l3 < 0) {
            bl2 = false;
        }
        xz.b(bl2);
        this.a = string2;
        this.b = string3;
        this.c = l2;
        this.d = l3;
        this.e = l4;
    }

    agw a() {
        return new agw(this.a, this.b, 1 + this.c, 1 + this.d, this.e);
    }

    agw a(long l2) {
        return new agw(this.a, this.b, this.c, this.d, l2);
    }
}

