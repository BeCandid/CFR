/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.Math
 *  java.lang.Object
 */
import java.io.IOException;
import java.io.OutputStream;

class ki {
    int a;
    int b = 12;
    int c;
    int d = 4096;
    int[] e = new int[5003];
    int[] f = new int[5003];
    int g = 5003;
    int h = 0;
    boolean i = false;
    int j;
    int k;
    int l;
    int m = 0;
    int n = 0;
    int[] o = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535};
    int p;
    byte[] q = new byte[256];
    private int r;
    private int s;
    private byte[] t;
    private int u;
    private int v;
    private int w;

    ki(int n2, int n3, byte[] arrby, int n4) {
        this.r = n2;
        this.s = n3;
        this.t = arrby;
        this.u = Math.max((int)2, (int)n4);
    }

    private int a() {
        if (this.v == 0) {
            return -1;
        }
        this.v = -1 + this.v;
        byte[] arrby = this.t;
        int n2 = this.w;
        this.w = n2 + 1;
        return 255 & arrby[n2];
    }

    void a(byte by2, OutputStream outputStream) throws IOException {
        byte[] arrby = this.q;
        int n2 = this.p;
        this.p = n2 + 1;
        arrby[n2] = by2;
        if (this.p >= 254) {
            this.c(outputStream);
        }
    }

    void a(int n2) {
        for (int i2 = 0; i2 < n2; ++i2) {
            this.e[i2] = -1;
        }
    }

    void a(int n2, OutputStream outputStream) throws IOException {
        int n3;
        this.j = n2;
        this.i = false;
        this.a = this.j;
        this.c = this.b(this.a);
        this.k = 1 << n2 - 1;
        this.l = 1 + this.k;
        this.h = 2 + this.k;
        this.p = 0;
        int n4 = super.a();
        int n5 = 0;
        for (int i2 = this.g; i2 < 65536; i2 *= 2) {
            ++n5;
        }
        int n6 = 8 - n5;
        int n7 = this.g;
        this.a(n7);
        this.b(this.k, outputStream);
        block1 : while ((n3 = super.a()) != -1) {
            int n8 = n4 ^ n3 << n6;
            int n9 = n4 + (n3 << this.b);
            if (this.e[n8] == n9) {
                n4 = this.f[n8];
                continue;
            }
            if (this.e[n8] >= 0) {
                int n10 = n7 - n8;
                if (n8 == 0) {
                    n10 = 1;
                }
                do {
                    if ((n8 -= n10) < 0) {
                        n8 += n7;
                    }
                    if (this.e[n8] != n9) continue;
                    n4 = this.f[n8];
                    continue block1;
                } while (this.e[n8] >= 0);
            }
            this.b(n4, outputStream);
            n4 = n3;
            if (this.h < this.d) {
                int[] arrn = this.f;
                int n11 = this.h;
                this.h = n11 + 1;
                arrn[n8] = n11;
                this.e[n8] = n9;
                continue;
            }
            this.a(outputStream);
        }
        this.b(n4, outputStream);
        this.b(this.l, outputStream);
    }

    void a(OutputStream outputStream) throws IOException {
        this.a(this.g);
        this.h = 2 + this.k;
        this.i = true;
        this.b(this.k, outputStream);
    }

    final int b(int n2) {
        return -1 + (1 << n2);
    }

    /*
     * Enabled aggressive block sorting
     */
    void b(int n2, OutputStream outputStream) throws IOException {
        this.m &= this.o[this.n];
        this.m = this.n > 0 ? (this.m |= n2 << this.n) : n2;
        this.n += this.a;
        while (this.n >= 8) {
            this.a((byte)(255 & this.m), outputStream);
            this.m >>= 8;
            this.n = -8 + this.n;
        }
        if (this.h > this.c || this.i) {
            if (this.i) {
                int n3;
                this.a = n3 = this.j;
                this.c = this.b(n3);
                this.i = false;
            } else {
                this.a = 1 + this.a;
                this.c = this.a == this.b ? this.d : this.b(this.a);
            }
        }
        if (n2 == this.l) {
            while (this.n > 0) {
                this.a((byte)(255 & this.m), outputStream);
                this.m >>= 8;
                this.n = -8 + this.n;
            }
            this.c(outputStream);
        }
    }

    void b(OutputStream outputStream) throws IOException {
        outputStream.write(this.u);
        this.v = this.r * this.s;
        this.w = 0;
        this.a(1 + this.u, outputStream);
        outputStream.write(0);
    }

    void c(OutputStream outputStream) throws IOException {
        if (this.p > 0) {
            outputStream.write(this.p);
            outputStream.write(this.q, 0, this.p);
            this.p = 0;
        }
    }
}

