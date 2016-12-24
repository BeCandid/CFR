/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 *  android.view.animation.DecelerateInterpolator
 *  android.view.animation.Interpolator
 *  android.view.animation.LinearInterpolator
 *  java.lang.Math
 *  java.lang.Object
 */
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

public class k {
    public static final Interpolator a = new LinearInterpolator();
    public static final Interpolator b = new gx();
    public static final Interpolator c = new gw();
    public static final Interpolator d = new gy();
    public static final Interpolator e = new DecelerateInterpolator();

    static float a(float f2, float f3, float f4) {
        return f2 + f4 * (f3 - f2);
    }

    public static int a(int n2, int n3, float f2) {
        return n2 + Math.round((float)(f2 * (float)(n3 - n2)));
    }

    static class a
    implements Animation.AnimationListener {
        a() {
        }

        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

}

