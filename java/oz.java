/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  java.io.OutputStream
 *  java.lang.Object
 *  java.lang.String
 */
import android.graphics.Bitmap;
import java.io.OutputStream;

public class oz
implements kq<ow> {
    private final kq<Bitmap> a;
    private final kq<on> b;
    private String c;

    public oz(kq<Bitmap> kq2, kq<on> kq3) {
        this.a = kq2;
        this.b = kq3;
    }

    @Override
    public String a() {
        if (this.c == null) {
            this.c = this.a.a() + this.b.a();
        }
        return this.c;
    }

    @Override
    public boolean a(lj<ow> lj2, OutputStream outputStream) {
        ow ow2 = lj2.b();
        lj<Bitmap> lj3 = ow2.b();
        if (lj3 != null) {
            return this.a.a(lj3, outputStream);
        }
        return this.b.a(ow2.c(), outputStream);
    }
}

