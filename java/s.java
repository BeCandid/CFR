/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.TimeInterpolator
 *  android.support.design.widget.VisibilityAwareImageButton
 *  android.view.View
 *  android.view.ViewPropertyAnimator
 *  android.view.animation.Interpolator
 */
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.support.design.widget.VisibilityAwareImageButton;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;

public class s
extends r {
    private boolean m;

    public s(VisibilityAwareImageButton visibilityAwareImageButton, x x2) {
        super(visibilityAwareImageButton, x2);
    }

    private void e(float f2) {
        if (this.a != null) {
            this.a.a(- f2);
        }
        if (this.d != null) {
            this.d.b(- f2);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    void a(final t.a a2, final boolean bl2) {
        if (this.m || this.k.getVisibility() != 0) {
            if (a2 == null) return;
            {
                a2.b();
                return;
            }
        } else {
            if (fb.G((View)this.k) && !this.k.isInEditMode()) {
                this.k.animate().cancel();
                this.k.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setDuration(200).setInterpolator((TimeInterpolator)k.c).setListener((Animator.AnimatorListener)new AnimatorListenerAdapter(){
                    private boolean d;

                    public void onAnimationCancel(Animator animator) {
                        s.this.m = false;
                        this.d = true;
                    }

                    public void onAnimationEnd(Animator animator) {
                        s.this.m = false;
                        if (!this.d) {
                            s.this.k.a(8, bl2);
                            if (a2 != null) {
                                a2.b();
                            }
                        }
                    }

                    public void onAnimationStart(Animator animator) {
                        s.this.m = true;
                        this.d = false;
                        s.this.k.a(0, bl2);
                    }
                });
                return;
            }
            this.k.a(8, bl2);
            if (a2 == null) return;
            {
                a2.b();
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    void b(final t.a a2, final boolean bl2) {
        if (!this.m && this.k.getVisibility() == 0) return;
        {
            if (fb.G((View)this.k) && !this.k.isInEditMode()) {
                this.k.animate().cancel();
                if (this.k.getVisibility() != 0) {
                    this.k.setAlpha(0.0f);
                    this.k.setScaleY(0.0f);
                    this.k.setScaleX(0.0f);
                }
                this.k.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(200).setInterpolator((TimeInterpolator)k.d).setListener((Animator.AnimatorListener)new AnimatorListenerAdapter(){

                    public void onAnimationEnd(Animator animator) {
                        if (a2 != null) {
                            a2.a();
                        }
                    }

                    public void onAnimationStart(Animator animator) {
                        s.this.k.a(0, bl2);
                    }
                });
                return;
            } else {
                this.k.a(0, bl2);
                this.k.setAlpha(1.0f);
                this.k.setScaleY(1.0f);
                this.k.setScaleX(1.0f);
                if (a2 == null) return;
                {
                    a2.a();
                    return;
                }
            }
        }
    }

    @Override
    boolean d() {
        return true;
    }

    @Override
    void e() {
        this.e(this.k.getRotation());
    }

}

