/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 */
import android.graphics.drawable.Drawable;

public abstract class og<T extends Drawable>
implements lj<T> {
    protected final T a;

    public og(T t2) {
        if (t2 == null) {
            throw new NullPointerException("Drawable must not be null!");
        }
        this.a = t2;
    }

    public final T a() {
        return (T)this.a.getConstantState().newDrawable();
    }

    @Override
    public /* synthetic */ Object b() {
        return this.a();
    }
}

