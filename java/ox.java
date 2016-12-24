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

public class ox
implements lj<ow> {
    private final ow a;

    public ox(ow ow2) {
        if (ow2 == null) {
            throw new NullPointerException("Data must not be null");
        }
        this.a = ow2;
    }

    public ow a() {
        return this.a;
    }

    @Override
    public /* synthetic */ Object b() {
        return this.a();
    }

    @Override
    public int c() {
        return this.a.a();
    }

    @Override
    public void d() {
        lj<on> lj2;
        lj<Bitmap> lj3 = this.a.b();
        if (lj3 != null) {
            lj3.d();
        }
        if ((lj2 = this.a.c()) != null) {
            lj2.d();
        }
    }
}

