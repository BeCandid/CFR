/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.TransitionDrawable
 *  java.lang.Object
 */
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;

public class qj<T extends Drawable>
implements qk<T> {
    private final qk<T> a;
    private final int b;

    public qj(qk<T> qk2, int n2) {
        this.a = qk2;
        this.b = n2;
    }

    @Override
    public boolean a(T t2, qk.a a2) {
        Drawable drawable = a2.getCurrentDrawable();
        if (drawable != null) {
            TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{drawable, t2});
            transitionDrawable.setCrossFadeEnabled(true);
            transitionDrawable.startTransition(this.b);
            a2.setDrawable((Drawable)transitionDrawable);
            return true;
        }
        this.a.a(t2, a2);
        return false;
    }
}

