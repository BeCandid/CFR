/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  java.lang.Object
 *  java.lang.String
 */
import android.graphics.Bitmap;

public class oq
implements kr<on> {
    private final kr<Bitmap> a;
    private final ln b;

    public oq(kr<Bitmap> kr2, ln ln2) {
        this.a = kr2;
        this.b = ln2;
    }

    @Override
    public String a() {
        return this.a.a();
    }

    @Override
    public lj<on> a(lj<on> op2, int n2, int n3) {
        on on2 = op2.b();
        Bitmap bitmap = op2.b().b();
        nr nr2 = new nr(bitmap, this.b);
        Bitmap bitmap2 = this.a.a(nr2, n2, n3).b();
        if (!bitmap2.equals((Object)bitmap)) {
            op2 = new op(new on(on2, bitmap2, this.a));
        }
        return op2;
    }
}

