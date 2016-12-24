/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.Typeface
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.TextPaint
 *  android.text.TextUtils
 *  android.text.TextUtils$TruncateAt
 *  android.view.View
 *  android.view.animation.Interpolator
 *  java.lang.CharSequence
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Interpolator;

public final class n {
    private static final boolean a;
    private static final Paint b;
    private boolean A;
    private Bitmap B;
    private Paint C;
    private float D;
    private float E;
    private float F;
    private float G;
    private boolean H;
    private final TextPaint I;
    private Interpolator J;
    private Interpolator K;
    private float L;
    private float M;
    private float N;
    private int O;
    private float P;
    private float Q;
    private float R;
    private int S;
    private final View c;
    private boolean d;
    private float e;
    private final Rect f;
    private final Rect g;
    private final RectF h;
    private int i = 16;
    private int j = 16;
    private float k = 15.0f;
    private float l = 15.0f;
    private int m;
    private int n;
    private float o;
    private float p;
    private float q;
    private float r;
    private float s;
    private float t;
    private Typeface u;
    private Typeface v;
    private Typeface w;
    private CharSequence x;
    private CharSequence y;
    private boolean z;

    /*
     * Enabled aggressive block sorting
     */
    static {
        boolean bl2 = Build.VERSION.SDK_INT < 18;
        a = bl2;
        b = null;
        if (b != null) {
            b.setAntiAlias(true);
            b.setColor(-65281);
        }
    }

    public n(View view) {
        this.c = view;
        this.I = new TextPaint(129);
        this.g = new Rect();
        this.f = new Rect();
        this.h = new RectF();
    }

    private static float a(float f2, float f3, float f4, Interpolator interpolator) {
        if (interpolator != null) {
            f4 = interpolator.getInterpolation(f4);
        }
        return k.a(f2, f3, f4);
    }

    private static int a(int n2, int n3, float f2) {
        float f3 = 1.0f - f2;
        float f4 = f3 * (float)Color.alpha((int)n2) + f2 * (float)Color.alpha((int)n3);
        float f5 = f3 * (float)Color.red((int)n2) + f2 * (float)Color.red((int)n3);
        float f6 = f3 * (float)Color.green((int)n2) + f2 * (float)Color.green((int)n3);
        float f7 = f3 * (float)Color.blue((int)n2) + f2 * (float)Color.blue((int)n3);
        return Color.argb((int)((int)f4), (int)((int)f5), (int)((int)f6), (int)((int)f7));
    }

    private static boolean a(float f2, float f3) {
        if (Math.abs((float)(f2 - f3)) < 0.001f) {
            return true;
        }
        return false;
    }

    private static boolean a(Rect rect, int n2, int n3, int n4, int n5) {
        if (rect.left == n2 && rect.top == n3 && rect.right == n4 && rect.bottom == n5) {
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    private boolean b(CharSequence charSequence) {
        dd dd2;
        int n2 = 1;
        if (fb.h(this.c) != n2) {
            n2 = 0;
        }
        if (n2 != 0) {
            dd2 = de.d;
            return dd2.a(charSequence, 0, charSequence.length());
        }
        dd2 = de.c;
        return dd2.a(charSequence, 0, charSequence.length());
    }

    /*
     * Enabled aggressive block sorting
     */
    private void c(float f2) {
        super.d(f2);
        this.s = n.a(this.q, this.r, f2, this.J);
        this.t = n.a(this.o, this.p, f2, this.J);
        super.e(n.a(this.k, this.l, f2, this.K));
        if (this.n != this.m) {
            this.I.setColor(n.a(this.m, this.n, f2));
        } else {
            this.I.setColor(this.n);
        }
        this.I.setShadowLayer(n.a(this.P, this.L, f2, null), n.a(this.Q, this.M, f2, null), n.a(this.R, this.N, f2, null), n.a(this.S, this.O, f2));
        fb.d(this.c);
    }

    private void d(float f2) {
        this.h.left = n.a(this.f.left, this.g.left, f2, this.J);
        this.h.top = n.a(this.o, this.p, f2, this.J);
        this.h.right = n.a(this.f.right, this.g.right, f2, this.J);
        this.h.bottom = n.a(this.f.bottom, this.g.bottom, f2, this.J);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void e(float f2) {
        super.f(f2);
        boolean bl2 = a && this.F != 1.0f;
        this.A = bl2;
        if (this.A) {
            super.m();
        }
        fb.d(this.c);
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void f(float f2) {
        boolean bl2;
        float f3;
        float f4;
        boolean bl3 = true;
        if (this.x == null) {
            return;
        }
        if (n.a(f2, this.l)) {
            f3 = this.g.width();
            f4 = this.l;
            this.F = 1.0f;
            Typeface typeface = this.w;
            Typeface typeface2 = this.u;
            bl2 = false;
            if (typeface != typeface2) {
                this.w = this.u;
                bl2 = true;
            }
        } else {
            f3 = this.f.width();
            f4 = this.k;
            Typeface typeface = this.w;
            Typeface typeface3 = this.v;
            bl2 = false;
            if (typeface != typeface3) {
                this.w = this.v;
                bl2 = true;
            }
            this.F = n.a(f2, this.k) ? 1.0f : f2 / this.k;
        }
        if (f3 > 0.0f) {
            bl2 = this.G != f4 || this.H || bl2 ? bl3 : false;
            this.G = f4;
            this.H = false;
        }
        if (this.y != null) {
            if (!bl2) return;
        }
        this.I.setTextSize(this.G);
        this.I.setTypeface(this.w);
        TextPaint textPaint = this.I;
        if (this.F == 1.0f) {
            bl3 = false;
        }
        textPaint.setLinearText(bl3);
        CharSequence charSequence = TextUtils.ellipsize((CharSequence)this.x, (TextPaint)this.I, (float)f3, (TextUtils.TruncateAt)TextUtils.TruncateAt.END);
        if (TextUtils.equals((CharSequence)charSequence, (CharSequence)this.y)) return;
        this.y = charSequence;
        this.z = super.b(this.y);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Typeface g(int n2) {
        TypedArray typedArray = this.c.getContext().obtainStyledAttributes(n2, new int[]{16843692});
        try {
            String string2 = typedArray.getString(0);
            if (string2 != null) {
                Typeface typeface = Typeface.create((String)string2, (int)0);
                return typeface;
            }
            return null;
        }
        finally {
            typedArray.recycle();
        }
    }

    private void k() {
        this.c(this.e);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void l() {
        int n2 = 1;
        float f2 = this.G;
        this.f(this.l);
        float f3 = this.y != null ? this.I.measureText(this.y, 0, this.y.length()) : 0.0f;
        int n3 = this.j;
        int n4 = this.z ? n2 : 0;
        int n5 = dx.a(n3, n4);
        switch (n5 & 112) {
            default: {
                this.p = (this.I.descent() - this.I.ascent()) / 2.0f - this.I.descent() + (float)this.g.centerY();
                break;
            }
            case 80: {
                this.p = this.g.bottom;
                break;
            }
            case 48: {
                this.p = (float)this.g.top - this.I.ascent();
                break;
            }
        }
        switch (n5 & 8388615) {
            default: {
                this.r = this.g.left;
                break;
            }
            case 1: {
                this.r = (float)this.g.centerX() - f3 / 2.0f;
                break;
            }
            case 5: {
                this.r = (float)this.g.right - f3;
            }
        }
        this.f(this.k);
        float f4 = this.y != null ? this.I.measureText(this.y, 0, this.y.length()) : 0.0f;
        int n6 = this.i;
        if (!this.z) {
            n2 = 0;
        }
        int n7 = dx.a(n6, n2);
        switch (n7 & 112) {
            default: {
                this.o = (this.I.descent() - this.I.ascent()) / 2.0f - this.I.descent() + (float)this.f.centerY();
                break;
            }
            case 80: {
                this.o = this.f.bottom;
                break;
            }
            case 48: {
                this.o = (float)this.f.top - this.I.ascent();
            }
        }
        switch (n7 & 8388615) {
            default: {
                this.q = this.f.left;
                break;
            }
            case 1: {
                this.q = (float)this.f.centerX() - f4 / 2.0f;
                break;
            }
            case 5: {
                this.q = (float)this.f.right - f4;
            }
        }
        this.n();
        this.e(f2);
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void m() {
        if (this.B != null) return;
        if (this.f.isEmpty()) return;
        if (TextUtils.isEmpty((CharSequence)this.y)) {
            return;
        }
        this.c(0.0f);
        this.D = this.I.ascent();
        this.E = this.I.descent();
        int n2 = Math.round((float)this.I.measureText(this.y, 0, this.y.length()));
        int n3 = Math.round((float)(this.E - this.D));
        if (n2 <= 0) return;
        if (n3 <= 0) return;
        this.B = Bitmap.createBitmap((int)n2, (int)n3, (Bitmap.Config)Bitmap.Config.ARGB_8888);
        new Canvas(this.B).drawText(this.y, 0, this.y.length(), 0.0f, (float)n3 - this.I.descent(), (Paint)this.I);
        if (this.C != null) return;
        this.C = new Paint(3);
    }

    private void n() {
        if (this.B != null) {
            this.B.recycle();
            this.B = null;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    void a() {
        boolean bl2 = this.g.width() > 0 && this.g.height() > 0 && this.f.width() > 0 && this.f.height() > 0;
        this.d = bl2;
    }

    public void a(float f2) {
        if (this.k != f2) {
            this.k = f2;
            this.h();
        }
    }

    public void a(int n2) {
        if (this.n != n2) {
            this.n = n2;
            this.h();
        }
    }

    public void a(int n2, int n3, int n4, int n5) {
        if (!n.a(this.f, n2, n3, n4, n5)) {
            this.f.set(n2, n3, n4, n5);
            this.H = true;
            this.a();
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(Canvas canvas) {
        int n2 = canvas.save();
        if (this.y != null && this.d) {
            float f2;
            float f3 = this.s;
            float f4 = this.t;
            boolean bl2 = this.A && this.B != null;
            if (bl2) {
                f2 = this.D * this.F;
                this.E * this.F;
            } else {
                f2 = this.I.ascent() * this.F;
                this.I.descent() * this.F;
            }
            if (bl2) {
                f4 += f2;
            }
            if (this.F != 1.0f) {
                canvas.scale(this.F, this.F, f3, f4);
            }
            if (bl2) {
                canvas.drawBitmap(this.B, f3, f4, this.C);
            } else {
                canvas.drawText(this.y, 0, this.y.length(), f3, f4, (Paint)this.I);
            }
        }
        canvas.restoreToCount(n2);
    }

    public void a(Typeface typeface) {
        if (this.u != typeface) {
            this.u = typeface;
            this.h();
        }
    }

    public void a(Interpolator interpolator) {
        this.K = interpolator;
        this.h();
    }

    public void a(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals((Object)this.x)) {
            this.x = charSequence;
            this.y = null;
            super.n();
            this.h();
        }
    }

    public int b() {
        return this.i;
    }

    public void b(float f2) {
        float f3 = v.a(f2, 0.0f, 1.0f);
        if (f3 != this.e) {
            this.e = f3;
            super.k();
        }
    }

    public void b(int n2) {
        if (this.m != n2) {
            this.m = n2;
            this.h();
        }
    }

    public void b(int n2, int n3, int n4, int n5) {
        if (!n.a(this.g, n2, n3, n4, n5)) {
            this.g.set(n2, n3, n4, n5);
            this.H = true;
            this.a();
        }
    }

    public void b(Typeface typeface) {
        if (this.v != typeface) {
            this.v = typeface;
            this.h();
        }
    }

    public void b(Interpolator interpolator) {
        this.J = interpolator;
        this.h();
    }

    public int c() {
        return this.j;
    }

    public void c(int n2) {
        if (this.i != n2) {
            this.i = n2;
            this.h();
        }
    }

    public void c(Typeface typeface) {
        this.v = typeface;
        this.u = typeface;
        this.h();
    }

    public Typeface d() {
        if (this.u != null) {
            return this.u;
        }
        return Typeface.DEFAULT;
    }

    public void d(int n2) {
        if (this.j != n2) {
            this.j = n2;
            this.h();
        }
    }

    public Typeface e() {
        if (this.v != null) {
            return this.v;
        }
        return Typeface.DEFAULT;
    }

    public void e(int n2) {
        TypedArray typedArray = this.c.getContext().obtainStyledAttributes(n2, g.i.TextAppearance);
        if (typedArray.hasValue(g.i.TextAppearance_android_textColor)) {
            this.n = typedArray.getColor(g.i.TextAppearance_android_textColor, this.n);
        }
        if (typedArray.hasValue(g.i.TextAppearance_android_textSize)) {
            this.l = typedArray.getDimensionPixelSize(g.i.TextAppearance_android_textSize, (int)this.l);
        }
        this.O = typedArray.getInt(g.i.TextAppearance_android_shadowColor, 0);
        this.M = typedArray.getFloat(g.i.TextAppearance_android_shadowDx, 0.0f);
        this.N = typedArray.getFloat(g.i.TextAppearance_android_shadowDy, 0.0f);
        this.L = typedArray.getFloat(g.i.TextAppearance_android_shadowRadius, 0.0f);
        typedArray.recycle();
        if (Build.VERSION.SDK_INT >= 16) {
            this.u = super.g(n2);
        }
        this.h();
    }

    public float f() {
        return this.e;
    }

    public void f(int n2) {
        TypedArray typedArray = this.c.getContext().obtainStyledAttributes(n2, g.i.TextAppearance);
        if (typedArray.hasValue(g.i.TextAppearance_android_textColor)) {
            this.m = typedArray.getColor(g.i.TextAppearance_android_textColor, this.m);
        }
        if (typedArray.hasValue(g.i.TextAppearance_android_textSize)) {
            this.k = typedArray.getDimensionPixelSize(g.i.TextAppearance_android_textSize, (int)this.k);
        }
        this.S = typedArray.getInt(g.i.TextAppearance_android_shadowColor, 0);
        this.Q = typedArray.getFloat(g.i.TextAppearance_android_shadowDx, 0.0f);
        this.R = typedArray.getFloat(g.i.TextAppearance_android_shadowDy, 0.0f);
        this.P = typedArray.getFloat(g.i.TextAppearance_android_shadowRadius, 0.0f);
        typedArray.recycle();
        if (Build.VERSION.SDK_INT >= 16) {
            this.v = super.g(n2);
        }
        this.h();
    }

    public float g() {
        return this.l;
    }

    public void h() {
        if (this.c.getHeight() > 0 && this.c.getWidth() > 0) {
            this.l();
            this.k();
        }
    }

    public CharSequence i() {
        return this.x;
    }

    public int j() {
        return this.n;
    }
}

