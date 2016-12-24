/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 */
class kj {
    protected int a;
    protected byte[] b;
    protected int c;
    protected int d;
    protected int[][] e;
    protected int[] f = new int[256];
    protected int[] g = new int[256];
    protected int[] h = new int[256];
    protected int[] i = new int[32];

    public kj(byte[] arrby, int n2, int n3) {
        this.b = arrby;
        this.c = n2;
        this.d = n3;
        this.e = new int[256][];
        for (int i2 = 0; i2 < 256; ++i2) {
            int n4;
            this.e[i2] = new int[4];
            int[] arrn = this.e[i2];
            arrn[2] = n4 = (i2 << 12) / 256;
            arrn[1] = n4;
            arrn[0] = n4;
            this.h[i2] = 256;
            this.g[i2] = 0;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public int a(int n2, int n3, int n4) {
        int n5 = 1000;
        int n6 = -1;
        int n7 = this.f[n3];
        int n8 = n7 - 1;
        while (n7 < 256 || n8 >= 0) {
            int n9;
            int n10;
            int n11;
            if (n7 < 256) {
                int[] arrn = this.e[n7];
                int n12 = arrn[1] - n3;
                if (n12 >= n5) {
                    n7 = 256;
                } else {
                    int n13;
                    int n14;
                    ++n7;
                    if (n12 < 0) {
                        n12 = - n12;
                    }
                    if ((n14 = arrn[0] - n2) < 0) {
                        n14 = - n14;
                    }
                    if ((n13 = n12 + n14) < n5) {
                        int n15;
                        int n16 = arrn[2] - n4;
                        if (n16 < 0) {
                            n16 = - n16;
                        }
                        if ((n15 = n13 + n16) < n5) {
                            n5 = n15;
                            n6 = arrn[3];
                        }
                    }
                }
            }
            if (n8 < 0) continue;
            int[] arrn = this.e[n8];
            int n17 = n3 - arrn[1];
            if (n17 >= n5) {
                n8 = -1;
                continue;
            }
            --n8;
            if (n17 < 0) {
                n17 = - n17;
            }
            if ((n9 = arrn[0] - n2) < 0) {
                n9 = - n9;
            }
            if ((n11 = n17 + n9) >= n5) continue;
            int n18 = arrn[2] - n4;
            if (n18 < 0) {
                n18 = - n18;
            }
            if ((n10 = n11 + n18) >= n5) continue;
            n5 = n10;
            n6 = arrn[3];
        }
        return n6;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void a(int n2, int n3, int n4, int n5, int n6) {
        int n7;
        int n8 = n3 - n2;
        if (n8 < -1) {
            n8 = -1;
        }
        if ((n7 = n3 + n2) > 256) {
            n7 = 256;
        }
        int n9 = n3 + 1;
        int n10 = n3 - 1;
        int n11 = 1;
        int n12 = n10;
        int n13 = n9;
        while (n13 < n7 || n12 > n8) {
            int n14;
            int[] arrn = this.i;
            int n15 = n11 + 1;
            int n16 = arrn[n11];
            if (n13 < n7) {
                int[][] arrn2 = this.e;
                n14 = n13 + 1;
                int[] arrn3 = arrn2[n13];
                try {
                    arrn3[0] = arrn3[0] - n16 * (arrn3[0] - n4) / 262144;
                    arrn3[1] = arrn3[1] - n16 * (arrn3[1] - n5) / 262144;
                    arrn3[2] = arrn3[2] - n16 * (arrn3[2] - n6) / 262144;
                }
                catch (Exception var23_18) {}
            } else {
                n14 = n13;
            }
            if (n12 > n8) {
                int[][] arrn4 = this.e;
                int n17 = n12 - 1;
                int[] arrn5 = arrn4[n12];
                try {
                    arrn5[0] = arrn5[0] - n16 * (arrn5[0] - n4) / 262144;
                    arrn5[1] = arrn5[1] - n16 * (arrn5[1] - n5) / 262144;
                    arrn5[2] = arrn5[2] - n16 * (arrn5[2] - n6) / 262144;
                    n11 = n15;
                    n12 = n17;
                    n13 = n14;
                }
                catch (Exception var20_23) {
                    n11 = n15;
                    n12 = n17;
                    n13 = n14;
                }
                continue;
            }
            n11 = n15;
            n13 = n14;
        }
        return;
    }

    public byte[] a() {
        byte[] arrby = new byte[768];
        int[] arrn = new int[256];
        int n2 = 0;
        while (n2 < 256) {
            arrn[this.e[n2][3]] = n2++;
        }
        int n3 = 0;
        for (int i2 = 0; i2 < 256; ++i2) {
            int n4 = arrn[i2];
            int n5 = n3 + 1;
            arrby[n3] = (byte)this.e[n4][0];
            int n6 = n5 + 1;
            arrby[n5] = (byte)this.e[n4][1];
            int n7 = n6 + 1;
            arrby[n6] = (byte)this.e[n4][2];
            n3 = n7;
        }
        return arrby;
    }

    protected int b(int n2, int n3, int n4) {
        int n5;
        int n6;
        int n7 = n5 = Integer.MAX_VALUE;
        int n8 = n6 = -1;
        for (int i2 = 0; i2 < 256; ++i2) {
            int n9;
            int n10;
            int n11;
            int[] arrn = this.e[i2];
            int n12 = arrn[0] - n2;
            if (n12 < 0) {
                n12 = - n12;
            }
            if ((n9 = arrn[1] - n3) < 0) {
                n9 = - n9;
            }
            int n13 = n12 + n9;
            int n14 = arrn[2] - n4;
            if (n14 < 0) {
                n14 = - n14;
            }
            if ((n11 = n13 + n14) < n5) {
                n5 = n11;
                n6 = i2;
            }
            if ((n10 = n11 - (this.g[i2] >> 12)) < n7) {
                n7 = n10;
                n8 = i2;
            }
            int n15 = this.h[i2] >> 10;
            int[] arrn2 = this.h;
            arrn2[i2] = arrn2[i2] - n15;
            int[] arrn3 = this.g;
            arrn3[i2] = arrn3[i2] + (n15 << 10);
        }
        int[] arrn = this.h;
        arrn[n6] = 64 + arrn[n6];
        int[] arrn4 = this.g;
        arrn4[n6] = arrn4[n6] - 65536;
        return n8;
    }

    public void b() {
        int n2 = 0;
        int n3 = 0;
        for (int i2 = 0; i2 < 256; ++i2) {
            int[] arrn = this.e[i2];
            int n4 = i2;
            int n5 = arrn[1];
            for (int i3 = i2 + 1; i3 < 256; ++i3) {
                int[] arrn2 = this.e[i3];
                if (arrn2[1] >= n5) continue;
                n4 = i3;
                n5 = arrn2[1];
            }
            int[] arrn3 = this.e[n4];
            if (i2 != n4) {
                int n6 = arrn3[0];
                arrn3[0] = arrn[0];
                arrn[0] = n6;
                int n7 = arrn3[1];
                arrn3[1] = arrn[1];
                arrn[1] = n7;
                int n8 = arrn3[2];
                arrn3[2] = arrn[2];
                arrn[2] = n8;
                int n9 = arrn3[3];
                arrn3[3] = arrn[3];
                arrn[3] = n9;
            }
            if (n5 == n2) continue;
            this.f[n2] = n3 + i2 >> 1;
            for (int i4 = n2 + 1; i4 < n5; ++i4) {
                this.f[i4] = i2;
            }
            n2 = n5;
            n3 = i2;
        }
        this.f[n2] = n3 + 255 >> 1;
        for (int i5 = n2 + 1; i5 < 256; ++i5) {
            this.f[i5] = 255;
        }
    }

    protected void b(int n2, int n3, int n4, int n5, int n6) {
        int[] arrn = this.e[n3];
        arrn[0] = arrn[0] - n2 * (arrn[0] - n4) / 1024;
        arrn[1] = arrn[1] - n2 * (arrn[1] - n5) / 1024;
        arrn[2] = arrn[2] - n2 * (arrn[2] - n6) / 1024;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void c() {
        if (this.c < 1509) {
            this.d = 1;
        }
        this.a = 30 + (-1 + this.d) / 3;
        var1_1 = this.b;
        var2_2 = 0;
        var3_3 = this.c;
        var4_4 = this.c / (3 * this.d);
        var5_5 = var4_4 / 100;
        var6_6 = 1024;
        var7_7 = 2048;
        var8_8 = var7_7 >> 6;
        if (var8_8 <= 1) {
            var8_8 = 0;
        }
        for (var9_9 = 0; var9_9 < var8_8; ++var9_9) {
            this.i[var9_9] = var6_6 * (256 * (var8_8 * var8_8 - var9_9 * var9_9) / (var8_8 * var8_8));
        }
        var10_10 = this.c < 1509 ? 3 : (this.c % 499 != 0 ? 1497 : (this.c % 491 != 0 ? 1473 : (this.c % 487 != 0 ? 1461 : 1509)));
        var11_11 = 0;
        block1 : do lbl-1000: // 3 sources:
        {
            if (var11_11 >= var4_4) return;
            var12_14 = (255 & var1_1[var2_2 + 0]) << 4;
            var13_12 = (255 & var1_1[var2_2 + 1]) << 4;
            var14_15 = (255 & var1_1[var2_2 + 2]) << 4;
            var15_13 = this.b(var12_14, var13_12, var14_15);
            this.b(var6_6, var15_13, var12_14, var13_12, var14_15);
            if (var8_8 != 0) {
                this.a(var8_8, var15_13, var12_14, var13_12, var14_15);
            }
            if ((var2_2 += var10_10) >= var3_3) {
                var2_2 -= this.c;
            }
            ++var11_11;
            if (var5_5 == 0) {
                var5_5 = 1;
            }
            if (var11_11 % var5_5 != 0) ** GOTO lbl-1000
            var6_6 -= var6_6 / this.a;
            if ((var8_8 = (var7_7 -= var7_7 / 30) >> 6) <= 1) {
                var8_8 = 0;
            }
            var16_16 = 0;
            do {
                if (var16_16 >= var8_8) continue block1;
                this.i[var16_16] = var6_6 * (256 * (var8_8 * var8_8 - var16_16 * var16_16) / (var8_8 * var8_8));
                ++var16_16;
            } while (true);
            break;
        } while (true);
    }

    public byte[] d() {
        this.c();
        this.e();
        this.b();
        return this.a();
    }

    public void e() {
        int n2 = 0;
        while (n2 < 256) {
            int[] arrn = this.e[n2];
            arrn[0] = arrn[0] >> 4;
            int[] arrn2 = this.e[n2];
            arrn2[1] = arrn2[1] >> 4;
            int[] arrn3 = this.e[n2];
            arrn3[2] = arrn3[2] >> 4;
            this.e[n2][3] = n2++;
        }
    }
}

