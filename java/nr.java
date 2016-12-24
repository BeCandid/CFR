/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 */
import android.graphics.Bitmap;

public class nr
implements lj<Bitmap> {
    private final Bitmap a;
    private final ln b;

    public nr(Bitmap bitmap, ln ln2) {
        if (bitmap == null) {
            throw new NullPointerException("Bitmap must not be null");
        }
        if (ln2 == null) {
            throw new NullPointerException("BitmapPool must not be null");
        }
        this.a = bitmap;
        this.b = ln2;
    }

    public static nr a(Bitmap bitmap, ln ln2) {
        if (bitmap == null) {
            return null;
        }
        return new nr(bitmap, ln2);
    }

    public Bitmap a() {
        return this.a;
    }

    @Override
    public /* synthetic */ Object b() {
        return this.a();
    }

    @Override
    public int c() {
        return ri.a(this.a);
    }

    @Override
    public void d() {
        if (!this.b.a(this.a)) {
            this.a.recycle();
        }
    }
}

