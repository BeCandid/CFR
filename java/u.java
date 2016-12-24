/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.ObjectAnimator
 *  android.animation.StateListAnimator
 *  android.animation.TimeInterpolator
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.graphics.drawable.InsetDrawable
 *  android.graphics.drawable.LayerDrawable
 *  android.graphics.drawable.RippleDrawable
 *  android.support.design.widget.VisibilityAwareImageButton
 *  android.view.animation.AnimationUtils
 *  android.view.animation.Interpolator
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 */
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.support.design.widget.VisibilityAwareImageButton;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

@TargetApi(value=21)
public class u
extends s {
    private final Interpolator m;
    private InsetDrawable n;

    /*
     * Enabled aggressive block sorting
     */
    public u(VisibilityAwareImageButton visibilityAwareImageButton, x x2) {
        super(visibilityAwareImageButton, x2);
        Interpolator interpolator = visibilityAwareImageButton.isInEditMode() ? null : AnimationUtils.loadInterpolator((Context)this.k.getContext(), (int)17563661);
        this.m = interpolator;
    }

    private Animator a(Animator animator) {
        animator.setInterpolator((TimeInterpolator)this.m);
        return animator;
    }

    @Override
    public float a() {
        return this.k.getElevation();
    }

    @Override
    public void a(float f2) {
        this.k.setElevation(f2);
        if (this.l.b()) {
            this.g();
        }
    }

    @Override
    void a(int n2) {
        if (this.c instanceof RippleDrawable) {
            ((RippleDrawable)this.c).setColor(ColorStateList.valueOf((int)n2));
            return;
        }
        super.a(n2);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    void a(ColorStateList colorStateList, PorterDuff.Mode mode, int n2, int n3) {
        Drawable drawable;
        this.b = bv.f((Drawable)this.k());
        bv.a(this.b, colorStateList);
        if (mode != null) {
            bv.a(this.b, mode);
        }
        if (n3 > 0) {
            this.d = this.a(n3, colorStateList);
            Drawable[] arrdrawable = new Drawable[]{this.d, this.b};
            drawable = new LayerDrawable(arrdrawable);
        } else {
            this.d = null;
            drawable = this.b;
        }
        this.e = this.c = new RippleDrawable(ColorStateList.valueOf((int)n2), drawable, null);
        this.l.a(this.c);
    }

    @Override
    void a(Rect rect) {
        if (this.l.b()) {
            float f2 = this.l.a();
            float f3 = this.a() + this.g;
            int n2 = (int)Math.ceil((double)w.b(f3, f2, false));
            int n3 = (int)Math.ceil((double)w.a(f3, f2, false));
            rect.set(n2, n3, n2, n3);
            return;
        }
        rect.set(0, 0, 0, 0);
    }

    @Override
    void a(int[] arrn) {
    }

    @Override
    void b() {
    }

    @Override
    void b(float f2) {
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(h, super.a((Animator)ObjectAnimator.ofFloat((Object)this.k, (String)"translationZ", (float[])new float[]{f2})));
        stateListAnimator.addState(i, super.a((Animator)ObjectAnimator.ofFloat((Object)this.k, (String)"translationZ", (float[])new float[]{f2})));
        stateListAnimator.addState(j, super.a((Animator)ObjectAnimator.ofFloat((Object)this.k, (String)"translationZ", (float[])new float[]{0.0f})));
        this.k.setStateListAnimator(stateListAnimator);
        if (this.l.b()) {
            this.g();
        }
    }

    @Override
    void b(Rect rect) {
        if (this.l.b()) {
            this.n = new InsetDrawable(this.c, rect.left, rect.top, rect.right, rect.bottom);
            this.l.a((Drawable)this.n);
            return;
        }
        this.l.a(this.c);
    }

    @Override
    void c() {
        this.g();
    }

    @Override
    boolean d() {
        return false;
    }

    @Override
    l j() {
        return new m();
    }
}

