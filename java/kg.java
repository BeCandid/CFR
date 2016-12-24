/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.nio.Buffer
 *  java.nio.BufferUnderflowException
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.util.Arrays
 *  java.util.List
 */
import android.util.Log;
import java.nio.Buffer;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;

public class kg {
    private final byte[] a = new byte[256];
    private ByteBuffer b;
    private kf c;
    private int d = 0;

    private int[] a(int n2) {
        int n3 = n2 * 3;
        Object object = null;
        byte[] arrby = new byte[n3];
        this.b.get(arrby);
        object = new int[256];
        int n4 = 0;
        int n5 = 0;
        while (n5 < n2) {
            int n6 = n4 + 1;
            int n7 = 255 & arrby[n4];
            int n8 = n6 + 1;
            int n9 = 255 & arrby[n6];
            int n10 = n8 + 1;
            int n11 = 255 & arrby[n8];
            int n12 = n5 + 1;
            try {
                object[n5] = n11 | (-16777216 | n7 << 16 | n9 << 8);
                n4 = n10;
                n5 = n12;
                continue;
            }
            catch (BufferUnderflowException var5_14) {
                if (Log.isLoggable((String)"GifHeaderParser", (int)3)) {
                    Log.d((String)"GifHeaderParser", (String)"Format Error Reading Color Table", (Throwable)var5_14);
                }
                this.c.b = 1;
                break;
            }
        }
        return object;
    }

    private void c() {
        this.b = null;
        Arrays.fill((byte[])this.a, (byte)0);
        this.c = new kf();
        this.d = 0;
    }

    private void d() {
        boolean bl2 = false;
        block11 : while (!bl2 && !this.o()) {
            switch (this.m()) {
                default: {
                    this.c.b = 1;
                    continue block11;
                }
                case 44: {
                    if (this.c.d == null) {
                        this.c.d = new ke();
                    }
                    this.f();
                    continue block11;
                }
                case 33: {
                    switch (this.m()) {
                        default: {
                            this.k();
                            continue block11;
                        }
                        case 249: {
                            this.c.d = new ke();
                            this.e();
                            continue block11;
                        }
                        case 255: {
                            this.l();
                            String string2 = "";
                            for (int i2 = 0; i2 < 11; ++i2) {
                                string2 = string2 + this.a[i2];
                            }
                            if (string2.equals((Object)"NETSCAPE2.0")) {
                                this.g();
                                continue block11;
                            }
                            this.k();
                            continue block11;
                        }
                        case 254: {
                            this.k();
                            continue block11;
                        }
                        case 1: 
                    }
                    this.k();
                    continue block11;
                }
                case 59: 
            }
            bl2 = true;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void e() {
        int n2 = 1;
        this.m();
        int n3 = this.m();
        this.c.d.g = (n3 & 28) >> 2;
        if (this.c.d.g == 0) {
            this.c.d.g = n2;
        }
        ke ke2 = this.c.d;
        if ((n3 & 1) == 0) {
            n2 = 0;
        }
        ke2.f = n2;
        int n4 = this.n();
        if (n4 < 3) {
            n4 = 10;
        }
        this.c.d.i = n4 * 10;
        this.c.d.h = this.m();
        this.m();
    }

    /*
     * Enabled aggressive block sorting
     */
    private void f() {
        boolean bl2 = true;
        this.c.d.a = this.n();
        this.c.d.b = this.n();
        this.c.d.c = this.n();
        this.c.d.d = this.n();
        int n2 = this.m();
        boolean bl3 = (n2 & 128) != 0 ? bl2 : false;
        int n3 = (int)Math.pow((double)2.0, (double)(1 + (n2 & 7)));
        ke ke2 = this.c.d;
        if ((n2 & 64) == 0) {
            bl2 = false;
        }
        ke2.e = bl2;
        this.c.d.k = bl3 ? this.a(n3) : (Object)null;
        this.c.d.j = this.b.position();
        this.j();
        if (this.o()) {
            return;
        }
        kf kf2 = this.c;
        kf2.c = 1 + kf2.c;
        this.c.e.add((Object)this.c.d);
    }

    private void g() {
        do {
            this.l();
            if (this.a[0] != 1) continue;
            int n2 = 255 & this.a[1];
            int n3 = 255 & this.a[2];
            this.c.m = n2 | n3 << 8;
        } while (this.d > 0 && !this.o());
    }

    /*
     * Enabled aggressive block sorting
     */
    private void h() {
        String string2 = "";
        for (int i2 = 0; i2 < 6; ++i2) {
            string2 = string2 + (char)this.m();
        }
        if (!string2.startsWith("GIF")) {
            this.c.b = 1;
            return;
        } else {
            this.i();
            if (!this.c.h || this.o()) return;
            {
                this.c.a = this.a(this.c.i);
                this.c.l = this.c.a[this.c.j];
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void i() {
        this.c.f = this.n();
        this.c.g = this.n();
        int n2 = this.m();
        kf kf2 = this.c;
        boolean bl2 = (n2 & 128) != 0;
        kf2.h = bl2;
        this.c.i = 2 << (n2 & 7);
        this.c.j = this.m();
        this.c.k = this.m();
    }

    private void j() {
        this.m();
        this.k();
    }

    private void k() {
        int n2;
        do {
            n2 = this.m();
            this.b.position(n2 + this.b.position());
        } while (n2 > 0);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private int l() {
        int n3;
        int n2 = this.d = this.m();
        if (n2 <= 0) return n3;
        {
            int n4 = 0;
            try {
                for (n3 = 0; n3 < this.d; n3 += n4) {
                    n4 = this.d - n3;
                    this.b.get(this.a, n3, n4);
                }
                return n3;
            }
            catch (Exception exception) {
                if (Log.isLoggable((String)"GifHeaderParser", (int)3)) {
                    Log.d((String)"GifHeaderParser", (String)("Error Reading Block n: " + n3 + " count: " + n4 + " blockSize: " + this.d), (Throwable)exception);
                }
                this.c.b = 1;
            }
        }
        return n3;
    }

    private int m() {
        byte by2;
        try {
            by2 = this.b.get();
        }
        catch (Exception var1_2) {
            this.c.b = 1;
            return 0;
        }
        return by2 & 255;
    }

    private int n() {
        return this.b.getShort();
    }

    private boolean o() {
        if (this.c.b != 0) {
            return true;
        }
        return false;
    }

    public kg a(byte[] arrby) {
        super.c();
        if (arrby != null) {
            this.b = ByteBuffer.wrap((byte[])arrby);
            this.b.rewind();
            this.b.order(ByteOrder.LITTLE_ENDIAN);
            return this;
        }
        this.b = null;
        this.c.b = 2;
        return this;
    }

    public void a() {
        this.b = null;
        this.c = null;
    }

    public kf b() {
        if (this.b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (this.o()) {
            return this.c;
        }
        this.h();
        if (!this.o()) {
            this.d();
            if (this.c.c < 0) {
                this.c.b = 1;
            }
        }
        return this.c;
    }
}

