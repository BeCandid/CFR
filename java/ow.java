/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
import android.graphics.Bitmap;

public class ow {
    private final lj<on> a;
    private final lj<Bitmap> b;

    public ow(lj<Bitmap> lj2, lj<on> lj3) {
        if (lj2 != null && lj3 != null) {
            throw new IllegalArgumentException("Can only contain either a bitmap resource or a gif resource, not both");
        }
        if (lj2 == null && lj3 == null) {
            throw new IllegalArgumentException("Must contain either a bitmap resource or a gif resource");
        }
        this.b = lj2;
        this.a = lj3;
    }

    public int a() {
        if (this.b != null) {
            return this.b.c();
        }
        return this.a.c();
    }

    public lj<Bitmap> b() {
        return this.b;
    }

    public lj<on> c() {
        return this.a;
    }
}

