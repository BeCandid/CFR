/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.Paint
 *  android.util.Log
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 */
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import java.io.IOException;
import java.io.OutputStream;

public class kh {
    private int a;
    private int b;
    private Integer c = null;
    private int d;
    private int e = -1;
    private int f = 0;
    private boolean g = false;
    private OutputStream h;
    private Bitmap i;
    private byte[] j;
    private byte[] k;
    private int l;
    private byte[] m;
    private boolean[] n = new boolean[256];
    private int o = 7;
    private int p = -1;
    private boolean q = false;
    private boolean r = true;
    private boolean s = false;
    private int t = 10;
    private boolean u;

    private void a(String string2) throws IOException {
        for (int i2 = 0; i2 < string2.length(); ++i2) {
            this.h.write((int)((byte)string2.charAt(i2)));
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private int b(int n2) {
        if (this.m == null) {
            return -1;
        }
        int n3 = Color.red((int)n2);
        int n4 = Color.green((int)n2);
        int n5 = Color.blue((int)n2);
        int n6 = 0;
        int n7 = 16777216;
        int n8 = this.m.length;
        int n9 = 0;
        while (n9 < n8) {
            byte[] arrby = this.m;
            int n10 = n9 + 1;
            int n11 = n3 - (255 & arrby[n9]);
            byte[] arrby2 = this.m;
            int n12 = n10 + 1;
            int n13 = n4 - (255 & arrby2[n10]);
            int n14 = n5 - (255 & this.m[n12]);
            int n15 = n11 * n11 + n13 * n13 + n14 * n14;
            int n16 = n12 / 3;
            if (this.n[n16] && n15 < n7) {
                n7 = n15;
                n6 = n16;
            }
            n9 = n12 + 1;
        }
        return n6;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void b() {
        int n2 = this.j.length;
        int n3 = n2 / 3;
        this.k = new byte[n3];
        kj kj2 = new kj(this.j, n2, this.t);
        this.m = kj2.d();
        for (int i2 = 0; i2 < this.m.length; i2 += 3) {
            byte by2 = this.m[i2];
            this.m[i2] = this.m[i2 + 2];
            this.m[i2 + 2] = by2;
            this.n[i2 / 3] = false;
        }
        int n4 = 0;
        for (int i3 = 0; i3 < n3; ++i3) {
            byte[] arrby = this.j;
            int n5 = n4 + 1;
            int n6 = 255 & arrby[n4];
            byte[] arrby2 = this.j;
            int n7 = n5 + 1;
            int n8 = 255 & arrby2[n5];
            byte[] arrby3 = this.j;
            int n9 = n7 + 1;
            int n10 = kj2.a(n6, n8, 255 & arrby3[n7]);
            this.n[n10] = true;
            this.k[i3] = (byte)n10;
            n4 = n9;
        }
        this.j = null;
        this.l = 8;
        this.o = 7;
        if (this.c != null) {
            this.d = this.b(this.c);
            return;
        } else {
            if (!this.u) return;
            {
                this.d = this.b(0);
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void c() {
        int n2 = this.i.getWidth();
        int n3 = this.i.getHeight();
        if (n2 != this.a || n3 != this.b) {
            Bitmap bitmap = Bitmap.createBitmap((int)this.a, (int)this.b, (Bitmap.Config)Bitmap.Config.ARGB_8888);
            new Canvas(bitmap).drawBitmap(bitmap, 0.0f, 0.0f, null);
            this.i = bitmap;
        }
        int[] arrn = new int[n2 * n3];
        this.i.getPixels(arrn, 0, n2, 0, 0, n2, n3);
        this.j = new byte[3 * arrn.length];
        this.u = false;
        int n4 = 0;
        int n5 = arrn.length;
        int n6 = 0;
        for (int i2 = 0; i2 < n5; ++i2) {
            int n7 = arrn[i2];
            if (n7 == 0) {
                ++n4;
            }
            byte[] arrby = this.j;
            int n8 = n6 + 1;
            arrby[n6] = (byte)(n7 & 255);
            byte[] arrby2 = this.j;
            int n9 = n8 + 1;
            arrby2[n8] = (byte)(255 & n7 >> 8);
            byte[] arrby3 = this.j;
            int n10 = n9 + 1;
            arrby3[n9] = (byte)(255 & n7 >> 16);
            n6 = n10;
        }
        double d2 = (double)(n4 * 100) / (double)arrn.length;
        boolean bl2 = d2 > 4.0;
        this.u = bl2;
        if (Log.isLoggable((String)"AnimatedGifEncoder", (int)3)) {
            Log.d((String)"AnimatedGifEncoder", (String)("got pixels for frame with " + d2 + "% transparent pixels"));
        }
    }

    private void c(int n2) throws IOException {
        this.h.write(n2 & 255);
        this.h.write(255 & n2 >> 8);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void d() throws IOException {
        int n2;
        int n3;
        this.h.write(33);
        this.h.write(249);
        this.h.write(4);
        if (this.c == null && !this.u) {
            n2 = 0;
            n3 = 0;
        } else {
            n2 = 1;
            n3 = 2;
        }
        if (this.p >= 0) {
            n3 = 7 & this.p;
        }
        int n4 = n3 << 2;
        this.h.write(n2 | (0 | (n4 | 0)));
        this.c(this.f);
        this.h.write(this.d);
        this.h.write(0);
    }

    private void e() throws IOException {
        this.h.write(44);
        this.c(0);
        this.c(0);
        this.c(this.a);
        this.c(this.b);
        if (this.r) {
            this.h.write(0);
            return;
        }
        this.h.write(128 | this.o);
    }

    private void f() throws IOException {
        this.c(this.a);
        this.c(this.b);
        this.h.write(240 | this.o);
        this.h.write(0);
        this.h.write(0);
    }

    private void g() throws IOException {
        this.h.write(33);
        this.h.write(255);
        this.h.write(11);
        this.a("NETSCAPE2.0");
        this.h.write(3);
        this.h.write(1);
        this.c(this.e);
        this.h.write(0);
    }

    private void h() throws IOException {
        this.h.write(this.m, 0, this.m.length);
        int n2 = 768 - this.m.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.h.write(0);
        }
    }

    private void i() throws IOException {
        new ki(this.a, this.b, this.k, this.l).b(this.h);
    }

    public void a(int n2) {
        this.f = Math.round((float)((float)n2 / 10.0f));
    }

    public void a(int n2, int n3) {
        if (this.g && !this.r) {
            return;
        }
        this.a = n2;
        this.b = n3;
        if (this.a < 1) {
            this.a = 320;
        }
        if (this.b < 1) {
            this.b = 240;
        }
        this.s = true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean a() {
        if (!this.g) {
            return false;
        }
        boolean bl2 = true;
        this.g = false;
        try {
            this.h.write(59);
            this.h.flush();
            if (this.q) {
                this.h.close();
            }
        }
        catch (IOException var2_2) {
            bl2 = false;
        }
        this.d = 0;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.m = null;
        this.q = false;
        this.r = true;
        return bl2;
    }

    public boolean a(Bitmap bitmap) {
        if (bitmap == null || !this.g) {
            return false;
        }
        try {
            if (!this.s) {
                this.a(bitmap.getWidth(), bitmap.getHeight());
            }
            this.i = bitmap;
            super.c();
            super.b();
            if (this.r) {
                super.f();
                super.h();
                if (this.e >= 0) {
                    super.g();
                }
            }
            super.d();
            super.e();
            if (!this.r) {
                super.h();
            }
            super.i();
            this.r = false;
            return true;
        }
        catch (IOException var2_2) {
            return false;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean a(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean bl2 = true;
        this.q = false;
        this.h = outputStream;
        try {
            super.a("GIF89a");
        }
        catch (IOException var3_3) {
            bl2 = false;
        }
        this.g = bl2;
        return bl2;
    }
}

