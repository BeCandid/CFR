/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  java.lang.Object
 */
import android.graphics.Bitmap;

class om
implements kd.a {
    private final ln a;

    public om(ln ln2) {
        this.a = ln2;
    }

    @Override
    public Bitmap a(int n2, int n3, Bitmap.Config config) {
        return this.a.b(n2, n3, config);
    }

    @Override
    public void a(Bitmap bitmap) {
        if (!this.a.a(bitmap)) {
            bitmap.recycle();
        }
    }
}

