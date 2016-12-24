/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.graphics.drawable.LayerDrawable
 *  android.support.design.widget.VisibilityAwareImageButton
 *  android.view.View
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 *  android.view.animation.AnimationUtils
 *  android.view.animation.Interpolator
 *  android.view.animation.Transformation
 */
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.support.design.widget.VisibilityAwareImageButton;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;

public class r
extends t {
    w a;
    private int m;
    private z n;
    private boolean o;

    public r(VisibilityAwareImageButton visibilityAwareImageButton, x x2) {
        super(visibilityAwareImageButton, x2);
        this.m = visibilityAwareImageButton.getResources().getInteger(17694720);
        this.n = new z();
        this.n.a((View)visibilityAwareImageButton);
        this.n.a(h, super.a(new b((r)this, null)));
        this.n.a(i, super.a(new b((r)this, null)));
        this.n.a(j, super.a(new c((r)this, null)));
    }

    private Animation a(Animation animation) {
        animation.setInterpolator(k.b);
        animation.setDuration((long)this.m);
        return animation;
    }

    private static ColorStateList b(int n2) {
        int[][] arrarrn = new int[3][];
        int[] arrn = new int[3];
        arrarrn[0] = i;
        arrn[0] = n2;
        int n3 = 0 + 1;
        arrarrn[n3] = h;
        arrn[n3] = n2;
        int n4 = n3 + 1;
        arrarrn[n4] = new int[0];
        arrn[n4] = 0;
        n4 + 1;
        return new ColorStateList((int[][])arrarrn, arrn);
    }

    @Override
    float a() {
        return this.f;
    }

    @Override
    void a(float f2) {
        if (this.a != null) {
            this.a.a(f2, f2 + this.g);
            this.g();
        }
    }

    @Override
    void a(int n2) {
        if (this.c != null) {
            bv.a(this.c, r.b(n2));
        }
    }

    @Override
    void a(ColorStateList colorStateList) {
        if (this.b != null) {
            bv.a(this.b, colorStateList);
        }
        if (this.d != null) {
            this.d.a(colorStateList);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    void a(ColorStateList colorStateList, PorterDuff.Mode mode, int n2, int n3) {
        Drawable[] arrdrawable;
        this.b = bv.f((Drawable)this.k());
        bv.a(this.b, colorStateList);
        if (mode != null) {
            bv.a(this.b, mode);
        }
        this.c = bv.f((Drawable)this.k());
        bv.a(this.c, r.b(n2));
        if (n3 > 0) {
            this.d = this.a(n3, colorStateList);
            arrdrawable = new Drawable[]{this.d, this.b, this.c};
        } else {
            this.d = null;
            arrdrawable = new Drawable[]{this.b, this.c};
        }
        this.e = new LayerDrawable(arrdrawable);
        this.a = new w(this.k.getResources(), this.e, this.l.a(), this.f, this.f + this.g);
        this.a.a(false);
        this.l.a((Drawable)this.a);
    }

    @Override
    void a(PorterDuff.Mode mode) {
        if (this.b != null) {
            bv.a(this.b, mode);
        }
    }

    @Override
    void a(Rect rect) {
        this.a.getPadding(rect);
    }

    @Override
    void a(final t.a a2, final boolean bl2) {
        if (this.o || this.k.getVisibility() != 0) {
            if (a2 != null) {
                a2.b();
            }
            return;
        }
        Animation animation = AnimationUtils.loadAnimation((Context)this.k.getContext(), (int)g.a.design_fab_out);
        animation.setInterpolator(k.c);
        animation.setDuration(200);
        animation.setAnimationListener((Animation.AnimationListener)new k.a(){

            @Override
            public void onAnimationEnd(Animation animation) {
                r.this.o = false;
                r.this.k.a(8, bl2);
                if (a2 != null) {
                    a2.b();
                }
            }

            @Override
            public void onAnimationStart(Animation animation) {
                r.this.o = true;
            }
        });
        this.k.startAnimation(animation);
    }

    @Override
    void a(int[] arrn) {
        this.n.a(arrn);
    }

    @Override
    void b() {
        this.n.b();
    }

    @Override
    void b(float f2) {
        if (this.a != null) {
            this.a.c(f2 + this.f);
            this.g();
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    void b(final t.a a2, boolean bl2) {
        if (this.k.getVisibility() != 0 || this.o) {
            this.k.clearAnimation();
            this.k.a(0, bl2);
            Animation animation = AnimationUtils.loadAnimation((Context)this.k.getContext(), (int)g.a.design_fab_in);
            animation.setDuration(200);
            animation.setInterpolator(k.d);
            animation.setAnimationListener((Animation.AnimationListener)new k.a(){

                @Override
                public void onAnimationEnd(Animation animation) {
                    if (a2 != null) {
                        a2.a();
                    }
                }
            });
            this.k.startAnimation(animation);
            return;
        } else {
            if (a2 == null) return;
            {
                a2.a();
                return;
            }
        }
    }

    @Override
    void c() {
    }

    abstract class a
    extends Animation {
        final /* synthetic */ r a;
        private float b;
        private float c;

        private a(r r2) {
            this.a = r2;
        }

        /* synthetic */ a(r r2,  var2_2) {
            super(r2);
        }

        protected abstract float a();

        protected void applyTransformation(float f2, Transformation transformation) {
            this.a.a.b(this.b + f2 * this.c);
        }

        public void reset() {
            super.reset();
            this.b = this.a.a.a();
            this.c = this.a() - this.b;
        }
    }

    class b
    extends a {
        final /* synthetic */ r b;

        private b(r r2) {
            this.b = r2;
            super(r2, null);
        }

        /* synthetic */ b(r r2,  var2_2) {
            super(r2);
        }

        @Override
        protected float a() {
            return this.b.f + this.b.g;
        }
    }

    class c
    extends a {
        final /* synthetic */ r b;

        private c(r r2) {
            this.b = r2;
            super(r2, null);
        }

        /* synthetic */ c(r r2,  var2_2) {
            super(r2);
        }

        @Override
        protected float a() {
            return this.b.f;
        }
    }

}

