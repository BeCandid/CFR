/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.support.design.widget.VisibilityAwareImageButton
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnPreDrawListener
 *  java.lang.Object
 */
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.design.widget.VisibilityAwareImageButton;
import android.view.ViewTreeObserver;

public abstract class t {
    static final int[] h = new int[]{16842919, 16842910};
    static final int[] i = new int[]{16842908, 16842910};
    static final int[] j = new int[0];
    private final Rect a = new Rect();
    Drawable b;
    Drawable c;
    l d;
    Drawable e;
    float f;
    float g;
    final VisibilityAwareImageButton k;
    final x l;
    private ViewTreeObserver.OnPreDrawListener m;

    t(VisibilityAwareImageButton visibilityAwareImageButton, x x2) {
        this.k = visibilityAwareImageButton;
        this.l = x2;
    }

    private void l() {
        if (this.m == null) {
            this.m = new ViewTreeObserver.OnPreDrawListener(){

                public boolean onPreDraw() {
                    t.this.e();
                    return true;
                }
            };
        }
    }

    public abstract float a();

    l a(int n2, ColorStateList colorStateList) {
        Resources resources = this.k.getResources();
        l l2 = this.j();
        l2.a(resources.getColor(g.c.design_fab_stroke_top_outer_color), resources.getColor(g.c.design_fab_stroke_top_inner_color), resources.getColor(g.c.design_fab_stroke_end_inner_color), resources.getColor(g.c.design_fab_stroke_end_outer_color));
        l2.a(n2);
        l2.a(colorStateList);
        return l2;
    }

    abstract void a(float var1);

    public abstract void a(int var1);

    public abstract void a(ColorStateList var1);

    public abstract void a(ColorStateList var1, PorterDuff.Mode var2, int var3, int var4);

    public abstract void a(PorterDuff.Mode var1);

    abstract void a(Rect var1);

    public abstract void a(a var1, boolean var2);

    public abstract void a(int[] var1);

    public abstract void b();

    abstract void b(float var1);

    void b(Rect rect) {
    }

    public abstract void b(a var1, boolean var2);

    public abstract void c();

    public final void c(float f2) {
        if (this.f != f2) {
            this.f = f2;
            this.a(f2);
        }
    }

    public final void d(float f2) {
        if (this.g != f2) {
            this.g = f2;
            this.b(f2);
        }
    }

    boolean d() {
        return false;
    }

    void e() {
    }

    public final Drawable f() {
        return this.e;
    }

    public final void g() {
        Rect rect = this.a;
        this.a(rect);
        this.b(rect);
        this.l.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void h() {
        if (this.d()) {
            this.l();
            this.k.getViewTreeObserver().addOnPreDrawListener(this.m);
        }
    }

    public void i() {
        if (this.m != null) {
            this.k.getViewTreeObserver().removeOnPreDrawListener(this.m);
            this.m = null;
        }
    }

    l j() {
        return new l();
    }

    GradientDrawable k() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(-1);
        return gradientDrawable;
    }

    public static interface a {
        public void a();

        public void b();
    }

}

