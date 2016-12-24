/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.LinearGradient
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.graphics.drawable.Drawable
 *  java.lang.Math
 */
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

class l
extends Drawable {
    final Paint a = new Paint(1);
    final Rect b = new Rect();
    final RectF c = new RectF();
    float d;
    private int e;
    private int f;
    private int g;
    private int h;
    private ColorStateList i;
    private int j;
    private boolean k = true;
    private float l;

    public l() {
        this.a.setStyle(Paint.Style.STROKE);
    }

    private Shader a() {
        Rect rect = this.b;
        this.copyBounds(rect);
        float f2 = this.d / (float)rect.height();
        int[] arrn = new int[]{bu.a(this.e, this.j), bu.a(this.f, this.j), bu.a(bu.b(this.f, 0), this.j), bu.a(bu.b(this.h, 0), this.j), bu.a(this.h, this.j), bu.a(this.g, this.j)};
        float[] arrf = new float[]{0.0f, f2, 0.5f, 0.5f, 1.0f - f2, 1.0f};
        return new LinearGradient(0.0f, (float)rect.top, 0.0f, (float)rect.bottom, arrn, arrf, Shader.TileMode.CLAMP);
    }

    void a(float f2) {
        if (this.d != f2) {
            this.d = f2;
            this.a.setStrokeWidth(1.3333f * f2);
            this.k = true;
            this.invalidateSelf();
        }
    }

    void a(int n2, int n3, int n4, int n5) {
        this.e = n2;
        this.f = n3;
        this.g = n4;
        this.h = n5;
    }

    void a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.j = colorStateList.getColorForState(this.getState(), this.j);
        }
        this.i = colorStateList;
        this.k = true;
        this.invalidateSelf();
    }

    final void b(float f2) {
        if (f2 != this.l) {
            this.l = f2;
            this.invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        if (this.k) {
            this.a.setShader(super.a());
            this.k = false;
        }
        float f2 = this.a.getStrokeWidth() / 2.0f;
        RectF rectF = this.c;
        this.copyBounds(this.b);
        rectF.set(this.b);
        rectF.left = f2 + rectF.left;
        rectF.top = f2 + rectF.top;
        rectF.right -= f2;
        rectF.bottom -= f2;
        canvas.save();
        canvas.rotate(this.l, rectF.centerX(), rectF.centerY());
        canvas.drawOval(rectF, this.a);
        canvas.restore();
    }

    public int getOpacity() {
        if (this.d > 0.0f) {
            return -3;
        }
        return -2;
    }

    public boolean getPadding(Rect rect) {
        int n2 = Math.round((float)this.d);
        rect.set(n2, n2, n2, n2);
        return true;
    }

    public boolean isStateful() {
        if (this.i != null && this.i.isStateful() || super.isStateful()) {
            return true;
        }
        return false;
    }

    protected void onBoundsChange(Rect rect) {
        this.k = true;
    }

    protected boolean onStateChange(int[] arrn) {
        int n2;
        if (this.i != null && (n2 = this.i.getColorForState(arrn, this.j)) != this.j) {
            this.k = true;
            this.j = n2;
        }
        if (this.k) {
            this.invalidateSelf();
        }
        return this.k;
    }

    public void setAlpha(int n2) {
        this.a.setAlpha(n2);
        this.invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
        this.invalidateSelf();
    }
}

