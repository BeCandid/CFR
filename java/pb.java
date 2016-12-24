/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  java.lang.Object
 *  java.lang.String
 */
import android.graphics.Bitmap;

public class pb
implements kr<ow> {
    private final kr<Bitmap> a;
    private final kr<on> b;

    pb(kr<Bitmap> kr2, kr<on> kr3) {
        this.a = kr2;
        this.b = kr3;
    }

    public pb(ln ln2, kr<Bitmap> kr2) {
        super(kr2, new oq(kr2, ln2));
    }

    @Override
    public String a() {
        return this.a.a();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public lj<ow> a(lj<ow> ox2, int n2, int n3) {
        lj<Bitmap> lj2 = ((ow)ox2.b()).b();
        lj<on> lj3 = ((ow)ox2.b()).c();
        if (lj2 != null && this.a != null) {
            lj<Bitmap> lj4 = this.a.a(lj2, n2, n3);
            if (lj2.equals(lj4)) return ox2;
            return new ox(new ow(lj4, ((ow)ox2.b()).c()));
        }
        if (lj3 == null) return ox2;
        if (this.b == null) return ox2;
        lj<on> lj5 = this.b.a(lj3, n2, n3);
        if (lj3.equals(lj5)) return ox2;
        return new ox(new ow(((ow)ox2.b()).b(), lj5));
    }
}

