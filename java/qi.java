/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.view.animation.AlphaAnimation
 *  android.view.animation.Animation
 *  java.lang.Object
 */
import android.graphics.drawable.Drawable;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

public class qi<T extends Drawable>
implements ql<T> {
    private final qo<T> a;
    private final int b;
    private qj<T> c;
    private qj<T> d;

    public qi() {
        this(300);
    }

    public qi(int n2) {
        super(new qo(new a(n2)), n2);
    }

    qi(qo<T> qo2, int n2) {
        this.a = qo2;
        this.b = n2;
    }

    private qk<T> a() {
        if (this.c == null) {
            this.c = new qj<T>(this.a.a(false, true), this.b);
        }
        return this.c;
    }

    private qk<T> b() {
        if (this.d == null) {
            this.d = new qj<T>(this.a.a(false, false), this.b);
        }
        return this.d;
    }

    @Override
    public qk<T> a(boolean bl2, boolean bl3) {
        if (bl2) {
            return qm.b();
        }
        if (bl3) {
            return super.a();
        }
        return super.b();
    }

    static class a
    implements qn.a {
        private final int a;

        a(int n2) {
            this.a = n2;
        }

        @Override
        public Animation a() {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration((long)this.a);
            return alphaAnimation;
        }
    }

}

