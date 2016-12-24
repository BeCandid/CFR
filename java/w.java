/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.graphics.Canvas
 *  android.graphics.LinearGradient
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.Path$FillType
 *  android.graphics.RadialGradient
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.graphics.drawable.Drawable
 *  android.support.v7.graphics.drawable.DrawableWrapper
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.String
 */
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.v7.graphics.drawable.DrawableWrapper;

class w
extends DrawableWrapper {
    static final double a = Math.cos((double)Math.toRadians((double)45.0));
    final Paint b;
    final Paint c;
    final RectF d;
    float e;
    Path f;
    float g;
    float h;
    float i;
    float j;
    private boolean k = true;
    private final int l;
    private final int m;
    private final int n;
    private boolean o = true;
    private float p;
    private boolean q = false;

    public w(Resources resources, Drawable drawable, float f2, float f3, float f4) {
        super(drawable);
        this.l = resources.getColor(g.c.design_fab_shadow_start_color);
        this.m = resources.getColor(g.c.design_fab_shadow_mid_color);
        this.n = resources.getColor(g.c.design_fab_shadow_end_color);
        this.b = new Paint(5);
        this.b.setStyle(Paint.Style.FILL);
        this.e = Math.round((float)f2);
        this.d = new RectF();
        this.c = new Paint(this.b);
        this.c.setAntiAlias(false);
        this.a(f3, f4);
    }

    public static float a(float f2, float f3, boolean bl2) {
        if (bl2) {
            return (float)((double)(1.5f * f2) + (1.0 - a) * (double)f3);
        }
        return 1.5f * f2;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(Canvas canvas) {
        int n2 = canvas.save();
        canvas.rotate(this.p, this.d.centerX(), this.d.centerY());
        float f2 = - this.e - this.i;
        float f3 = this.e;
        boolean bl2 = this.d.width() - 2.0f * f3 > 0.0f;
        boolean bl3 = this.d.height() - 2.0f * f3 > 0.0f;
        float f4 = this.j - 0.25f * this.j;
        float f5 = this.j - 0.5f * this.j;
        float f6 = this.j - 1.0f * this.j;
        float f7 = f3 / (f3 + f5);
        float f8 = f3 / (f3 + f4);
        float f9 = f3 / (f3 + f6);
        int n3 = canvas.save();
        canvas.translate(f3 + this.d.left, f3 + this.d.top);
        canvas.scale(f7, f8);
        canvas.drawPath(this.f, this.b);
        if (bl2) {
            canvas.scale(1.0f / f7, 1.0f);
            canvas.drawRect(0.0f, f2, this.d.width() - 2.0f * f3, - this.e, this.c);
        }
        canvas.restoreToCount(n3);
        int n4 = canvas.save();
        canvas.translate(this.d.right - f3, this.d.bottom - f3);
        canvas.scale(f7, f9);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f, this.b);
        if (bl2) {
            canvas.scale(1.0f / f7, 1.0f);
            canvas.drawRect(0.0f, f2, this.d.width() - 2.0f * f3, - this.e + this.i, this.c);
        }
        canvas.restoreToCount(n4);
        int n5 = canvas.save();
        canvas.translate(f3 + this.d.left, this.d.bottom - f3);
        canvas.scale(f7, f9);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f, this.b);
        if (bl3) {
            canvas.scale(1.0f / f9, 1.0f);
            canvas.drawRect(0.0f, f2, this.d.height() - 2.0f * f3, - this.e, this.c);
        }
        canvas.restoreToCount(n5);
        int n6 = canvas.save();
        canvas.translate(this.d.right - f3, f3 + this.d.top);
        canvas.scale(f7, f8);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f, this.b);
        if (bl3) {
            canvas.scale(1.0f / f8, 1.0f);
            canvas.drawRect(0.0f, f2, this.d.height() - 2.0f * f3, - this.e, this.c);
        }
        canvas.restoreToCount(n6);
        canvas.restoreToCount(n2);
    }

    private void a(Rect rect) {
        float f2 = 1.5f * this.h;
        this.d.set((float)rect.left + this.h, f2 + (float)rect.top, (float)rect.right - this.h, (float)rect.bottom - f2);
        this.getWrappedDrawable().setBounds((int)this.d.left, (int)this.d.top, (int)this.d.right, (int)this.d.bottom);
        super.b();
    }

    public static float b(float f2, float f3, boolean bl2) {
        if (bl2) {
            f2 = (float)((double)f2 + (1.0 - a) * (double)f3);
        }
        return f2;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void b() {
        RectF rectF = new RectF(- this.e, - this.e, this.e, this.e);
        RectF rectF2 = new RectF(rectF);
        rectF2.inset(- this.i, - this.i);
        if (this.f == null) {
            this.f = new Path();
        } else {
            this.f.reset();
        }
        this.f.setFillType(Path.FillType.EVEN_ODD);
        this.f.moveTo(- this.e, 0.0f);
        this.f.rLineTo(- this.i, 0.0f);
        this.f.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f.arcTo(rectF, 270.0f, -90.0f, false);
        this.f.close();
        float f2 = - rectF2.top;
        if (f2 > 0.0f) {
            float f3 = this.e / f2;
            float f4 = f3 + (1.0f - f3) / 2.0f;
            Paint paint = this.b;
            int[] arrn = new int[]{0, this.l, this.m, this.n};
            paint.setShader((Shader)new RadialGradient(0.0f, 0.0f, f2, arrn, new float[]{0.0f, f3, f4, 1.0f}, Shader.TileMode.CLAMP));
        }
        Paint paint = this.c;
        float f5 = rectF.top;
        float f6 = rectF2.top;
        int[] arrn = new int[]{this.l, this.m, this.n};
        paint.setShader((Shader)new LinearGradient(0.0f, f5, 0.0f, f6, arrn, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.c.setAntiAlias(false);
    }

    private static int d(float f2) {
        int n2 = Math.round((float)f2);
        if (n2 % 2 == 1) {
            --n2;
        }
        return n2;
    }

    public float a() {
        return this.j;
    }

    final void a(float f2) {
        if (this.p != f2) {
            this.p = f2;
            this.invalidateSelf();
        }
    }

    void a(float f2, float f3) {
        float f4;
        if (f2 < 0.0f || f3 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float f5 = w.d(f2);
        if (f5 > (f4 = (float)w.d(f3))) {
            f5 = f4;
            if (!this.q) {
                this.q = true;
            }
        }
        if (this.j == f5 && this.h == f4) {
            return;
        }
        this.j = f5;
        this.h = f4;
        this.i = Math.round((float)(1.5f * f5));
        this.g = f4;
        this.k = true;
        this.invalidateSelf();
    }

    public void a(boolean bl2) {
        this.o = bl2;
        this.invalidateSelf();
    }

    public void b(float f2) {
        this.a(f2, this.h);
    }

    public void c(float f2) {
        this.a(this.j, f2);
    }

    public void draw(Canvas canvas) {
        if (this.k) {
            super.a(this.getBounds());
            this.k = false;
        }
        super.a(canvas);
        super.draw(canvas);
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(Rect rect) {
        int n2 = (int)Math.ceil((double)w.a(this.h, this.e, this.o));
        int n3 = (int)Math.ceil((double)w.b(this.h, this.e, this.o));
        rect.set(n3, n2, n3, n2);
        return true;
    }

    protected void onBoundsChange(Rect rect) {
        this.k = true;
    }

    public void setAlpha(int n2) {
        super.setAlpha(n2);
        this.b.setAlpha(n2);
        this.c.setAlpha(n2);
    }
}

