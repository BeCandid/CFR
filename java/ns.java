/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.Context;
import android.graphics.Bitmap;

public abstract class ns
implements kr<Bitmap> {
    private ln a;

    public ns(Context context) {
        super(jx.a(context).a());
    }

    public ns(ln ln2) {
        this.a = ln2;
    }

    protected abstract Bitmap a(ln var1, Bitmap var2, int var3, int var4);

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public final lj<Bitmap> a(lj<Bitmap> lj2, int n2, int n3) {
        if (!ri.a(n2, n3)) {
            throw new IllegalArgumentException("Cannot apply transformation on width: " + n2 + " or height: " + n3 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
        Bitmap bitmap = lj2.b();
        int n4 = n2 == Integer.MIN_VALUE ? bitmap.getWidth() : n2;
        int n5 = n3 == Integer.MIN_VALUE ? bitmap.getHeight() : n3;
        Bitmap bitmap2 = this.a(this.a, bitmap, n4, n5);
        if (bitmap.equals((Object)bitmap2)) {
            return lj2;
        }
        return nr.a(bitmap2, this.a);
    }
}

