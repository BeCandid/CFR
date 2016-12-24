/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.util.Arrays
 *  java.util.Iterator
 *  java.util.List
 */
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class kd {
    private static final String a = kd.class.getSimpleName();
    private static final Bitmap.Config b = Bitmap.Config.ARGB_8888;
    private int[] c;
    private ByteBuffer d;
    private final byte[] e = new byte[256];
    private short[] f;
    private byte[] g;
    private byte[] h;
    private byte[] i;
    private int[] j;
    private int k;
    private byte[] l;
    private kf m;
    private a n;
    private Bitmap o;
    private boolean p;
    private int q;

    public kd(a a2) {
        this.n = a2;
        this.m = new kf();
    }

    /*
     * Enabled aggressive block sorting
     */
    private Bitmap a(ke ke2, ke ke3) {
        int n2 = this.m.f;
        int n3 = this.m.g;
        int[] arrn = this.j;
        if (ke3 != null && ke3.g > 0) {
            if (ke3.g == 2) {
                boolean bl2 = ke2.f;
                int n4 = 0;
                if (!bl2) {
                    n4 = this.m.l;
                }
                Arrays.fill((int[])arrn, (int)n4);
            } else if (ke3.g == 3 && this.o != null) {
                this.o.getPixels(arrn, 0, n2, 0, 0, n2, n3);
            }
        }
        super.a(ke2);
        int n5 = 1;
        int n6 = 8;
        int n7 = 0;
        for (int i2 = 0; i2 < ke2.d; ++i2) {
            int n8;
            int n9 = i2;
            if (ke2.e) {
                if (n7 >= ke2.d) {
                    switch (++n5) {
                        case 2: {
                            n7 = 4;
                            break;
                        }
                        case 3: {
                            n7 = 2;
                            n6 = 4;
                            break;
                        }
                        case 4: {
                            n7 = 1;
                            n6 = 2;
                        }
                    }
                }
                n9 = n7;
                n7 += n6;
            }
            if ((n8 = n9 + ke2.b) >= this.m.g) continue;
            int n10 = n8 * this.m.f;
            int n11 = n10 + ke2.a;
            int n12 = n11 + ke2.c;
            if (n10 + this.m.f < n12) {
                n12 = n10 + this.m.f;
            }
            int n13 = i2 * ke2.c;
            while (n11 < n12) {
                byte[] arrby = this.i;
                int n14 = n13 + 1;
                int n15 = 255 & arrby[n13];
                int n16 = this.c[n15];
                if (n16 != 0) {
                    arrn[n11] = n16;
                }
                ++n11;
                n13 = n14;
            }
        }
        if (this.p && (ke2.g == 0 || ke2.g == 1)) {
            if (this.o == null) {
                this.o = super.j();
            }
            this.o.setPixels(arrn, 0, n2, 0, 0, n2, n3);
        }
        Bitmap bitmap = super.j();
        bitmap.setPixels(arrn, 0, n2, 0, 0, n2, n3);
        return bitmap;
    }

    @TargetApi(value=12)
    private static void a(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 12) {
            bitmap.setHasAlpha(true);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void a(ke var1) {
        if (var1 != null) {
            this.d.position(var1.j);
        }
        var2_2 = var1 == null ? this.m.f * this.m.g : var1.c * var1.d;
        if (this.i == null || this.i.length < var2_2) {
            this.i = new byte[var2_2];
        }
        if (this.f == null) {
            this.f = new short[4096];
        }
        if (this.g == null) {
            this.g = new byte[4096];
        }
        if (this.h == null) {
            this.h = new byte[4097];
        }
        var3_3 = super.h();
        var4_4 = 1 << var3_3;
        var5_5 = var4_4 + 1;
        var6_6 = var4_4 + 2;
        var7_7 = -1;
        var8_8 = var3_3 + 1;
        var9_9 = -1 + (1 << var8_8);
        for (var10_10 = 0; var10_10 < var4_4; ++var10_10) {
            this.f[var10_10] = 0;
            this.g[var10_10] = (byte)var10_10;
        }
        var11_11 = 0;
        var12_12 = 0;
        var13_13 = 0;
        var14_14 = 0;
        var15_15 = 0;
        var16_16 = 0;
        var17_17 = 0;
        var18_18 = 0;
        block1 : do {
            if (var18_18 >= var2_2) ** GOTO lbl37
            if (var15_15 == 0) {
                var15_15 = super.i();
                if (var15_15 <= 0) {
                    this.q = 3;
lbl37: // 2 sources:
                    var19_33 = var12_12;
                    while (var19_33 < var2_2) {
                        this.i[var19_33] = 0;
                        ++var19_33;
                    }
                    return;
                }
                var11_11 = 0;
            }
            var17_17 += (255 & this.e[var11_11]) << var16_16;
            var16_16 += 8;
            ++var11_11;
            --var15_15;
            var20_25 = var13_13;
            while (var16_16 >= var8_8) {
                var21_24 = var17_17 & var9_9;
                var17_17 >>= var8_8;
                var16_16 -= var8_8;
                if (var21_24 == var4_4) {
                    var8_8 = var3_3 + 1;
                    var9_9 = -1 + (1 << var8_8);
                    var6_6 = var4_4 + 2;
                    var7_7 = -1;
                    continue;
                }
                if (var21_24 > var6_6) {
                    this.q = 3;
                    var13_13 = var20_25;
                    continue block1;
                }
                if (var21_24 == var5_5) {
                    var13_13 = var20_25;
                    continue block1;
                }
                if (var7_7 == -1) {
                    var32_30 = this.h;
                    var33_19 = var20_25 + 1;
                    var32_30[var20_25] = this.g[var21_24];
                    var7_7 = var21_24;
                    var14_14 = var21_24;
                    var20_25 = var33_19;
                    continue;
                }
                var22_28 = var21_24;
                if (var21_24 >= var6_6) {
                    var30_27 = this.h;
                    var31_32 = var20_25 + 1;
                    var30_27[var20_25] = (byte)var14_14;
                    var21_24 = var7_7;
                    var20_25 = var31_32;
                }
                while (var21_24 >= var4_4) {
                    var28_20 = this.h;
                    var29_26 = var20_25 + 1;
                    var28_20[var20_25] = this.g[var21_24];
                    var21_24 = this.f[var21_24];
                    var20_25 = var29_26;
                }
                var14_14 = 255 & this.g[var21_24];
                var23_22 = this.h;
                var24_31 = var20_25 + 1;
                var23_22[var20_25] = (byte)var14_14;
                if (var6_6 < 4096) {
                    this.f[var6_6] = (short)var7_7;
                    this.g[var6_6] = (byte)var14_14;
                    if ((++var6_6 & var9_9) == 0 && var6_6 < 4096) {
                        ++var8_8;
                        var9_9 += var6_6;
                    }
                }
                var7_7 = var22_28;
                var25_23 = var12_12;
                while (var24_31 > 0) {
                    var26_21 = this.i;
                    var27_29 = var25_23 + 1;
                    var26_21[var25_23] = this.h[--var24_31];
                    ++var18_18;
                    var25_23 = var27_29;
                }
                var12_12 = var25_23;
                var20_25 = var24_31;
            }
            var13_13 = var20_25;
        } while (true);
    }

    private int h() {
        byte by2;
        try {
            by2 = this.d.get();
        }
        catch (Exception var1_2) {
            this.q = 1;
            return 0;
        }
        return by2 & 255;
    }

    private int i() {
        int n2;
        int n3 = this.h();
        if (n3 > 0) {
            int n4;
            for (n2 = 0; n2 < n3; n2 += n4) {
                n4 = n3 - n2;
                try {
                    this.d.get(this.e, n2, n4);
                }
                catch (Exception var4_4) {
                    Log.w((String)a, (String)"Error Reading Block", (Throwable)var4_4);
                    this.q = 1;
                    break;
                }
                continue;
            }
        }
        return n2;
    }

    private Bitmap j() {
        Bitmap bitmap = this.n.a(this.m.f, this.m.g, b);
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap((int)this.m.f, (int)this.m.g, (Bitmap.Config)b);
        }
        kd.a(bitmap);
        return bitmap;
    }

    public int a(int n2) {
        int n3 = -1;
        if (n2 >= 0 && n2 < this.m.c) {
            n3 = ((ke)this.m.e.get((int)n2)).i;
        }
        return n3;
    }

    public void a() {
        this.k = (1 + this.k) % this.m.c;
    }

    public void a(kf kf2, byte[] arrby) {
        this.m = kf2;
        this.l = arrby;
        this.q = 0;
        this.k = -1;
        this.d = ByteBuffer.wrap((byte[])arrby);
        this.d.rewind();
        this.d.order(ByteOrder.LITTLE_ENDIAN);
        this.p = false;
        Iterator iterator = kf2.e.iterator();
        while (iterator.hasNext()) {
            if (((ke)iterator.next()).g != 3) continue;
            this.p = true;
            break;
        }
        this.i = new byte[kf2.f * kf2.g];
        this.j = new int[kf2.f * kf2.g];
    }

    public int b() {
        if (this.m.c <= 0 || this.k < 0) {
            return -1;
        }
        return this.a(this.k);
    }

    public int c() {
        return this.m.c;
    }

    public int d() {
        return this.k;
    }

    public int e() {
        return this.m.m;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Bitmap f() {
        kd kd2 = this;
        synchronized (kd2) {
            Bitmap bitmap;
            if (this.m.c <= 0 || this.k < 0) {
                if (Log.isLoggable((String)a, (int)3)) {
                    Log.d((String)a, (String)("unable to decode frame, frameCount=" + this.m.c + " framePointer=" + this.k));
                }
                this.q = 1;
            }
            if (this.q == 1 || this.q == 2) {
                boolean bl2 = Log.isLoggable((String)a, (int)3);
                bitmap = null;
                if (!bl2) return bitmap;
                Log.d((String)a, (String)("Unable to decode frame, status=" + this.q));
            } else {
                this.q = 0;
                ke ke2 = (ke)this.m.e.get(this.k);
                int n2 = -1 + this.k;
                ke ke3 = null;
                if (n2 >= 0) {
                    ke3 = (ke)this.m.e.get(n2);
                }
                if (ke2.k == null) {
                    this.c = this.m.a;
                } else {
                    this.c = ke2.k;
                    if (this.m.j == ke2.h) {
                        this.m.l = 0;
                    }
                }
                boolean bl3 = ke2.f;
                int n3 = 0;
                if (bl3) {
                    n3 = this.c[ke2.h];
                    this.c[ke2.h] = 0;
                }
                if (this.c == null) {
                    if (Log.isLoggable((String)a, (int)3)) {
                        Log.d((String)a, (String)"No Valid Color Table");
                    }
                    this.q = 1;
                    return null;
                }
                bitmap = this.a(ke2, ke3);
                if (!ke2.f) return bitmap;
                this.c[ke2.h] = n3;
            }
            return bitmap;
        }
    }

    public void g() {
        this.m = null;
        this.l = null;
        this.i = null;
        this.j = null;
        if (this.o != null) {
            this.n.a(this.o);
        }
        this.o = null;
        this.d = null;
    }

    public static interface a {
        public Bitmap a(int var1, int var2, Bitmap.Config var3);

        public void a(Bitmap var1);
    }

}

