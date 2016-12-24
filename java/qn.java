/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.animation.Animation
 *  java.lang.Object
 */
import android.view.View;
import android.view.animation.Animation;

public class qn<R>
implements qk<R> {
    private final a a;

    qn(a a2) {
        this.a = a2;
    }

    @Override
    public boolean a(R r2, qk.a a2) {
        View view = a2.getView();
        if (view != null) {
            view.clearAnimation();
            view.startAnimation(this.a.a());
        }
        return false;
    }

    static interface a {
        public Animation a();
    }

}

