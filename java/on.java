/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.Gravity
 *  java.lang.IllegalArgumentException
 *  java.lang.NullPointerException
 *  java.lang.String
 */
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.Gravity;

public class on
extends oh
implements or.b {
    private final Paint a;
    private final Rect b;
    private final a c;
    private final kd d;
    private final or e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private int j;
    private int k;
    private boolean l;

    public on(Context context, kd.a a2, ln ln2, kr<Bitmap> kr2, int n2, int n3, kf kf2, byte[] arrby, Bitmap bitmap) {
        super(new a(kf2, arrby, context, kr2, n2, n3, a2, ln2, bitmap));
    }

    on(a a2) {
        this.b = new Rect();
        this.i = true;
        this.k = -1;
        if (a2 == null) {
            throw new NullPointerException("GifState must not be null");
        }
        this.c = a2;
        this.d = new kd(a2.g);
        this.a = new Paint();
        this.d.a(a2.a, a2.b);
        this.e = new or(a2.c, (or.b)this, this.d, a2.e, a2.f);
        this.e.a(a2.d);
    }

    public on(on on2, Bitmap bitmap, kr<Bitmap> kr2) {
        super(new a(on2.c.a, on2.c.b, on2.c.c, kr2, on2.c.e, on2.c.f, on2.c.g, on2.c.h, bitmap));
    }

    private void g() {
        this.j = 0;
    }

    private void h() {
        this.e.c();
        this.invalidateSelf();
    }

    /*
     * Enabled aggressive block sorting
     */
    private void i() {
        if (this.d.c() == 1) {
            this.invalidateSelf();
            return;
        } else {
            if (this.f) return;
            {
                this.f = true;
                this.e.a();
                this.invalidateSelf();
                return;
            }
        }
    }

    private void j() {
        this.f = false;
        this.e.b();
    }

    @Override
    public void a(int n2) {
        if (n2 <= 0 && n2 != -1 && n2 != 0) {
            throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
        }
        if (n2 == 0) {
            this.k = this.d.e();
            return;
        }
        this.k = n2;
    }

    @Override
    public boolean a() {
        return true;
    }

    public Bitmap b() {
        return this.c.i;
    }

    /*
     * Enabled aggressive block sorting
     */
    @TargetApi(value=11)
    @Override
    public void b(int n2) {
        if (Build.VERSION.SDK_INT >= 11 && this.getCallback() == null) {
            this.stop();
            super.h();
            return;
        } else {
            this.invalidateSelf();
            if (n2 == -1 + this.d.c()) {
                this.j = 1 + this.j;
            }
            if (this.k == -1 || this.j < this.k) return;
            {
                this.stop();
                return;
            }
        }
    }

    public kr<Bitmap> c() {
        return this.c.d;
    }

    public byte[] d() {
        return this.c.b;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void draw(Canvas canvas) {
        Bitmap bitmap;
        if (this.h) {
            return;
        }
        if (this.l) {
            Gravity.apply((int)119, (int)this.getIntrinsicWidth(), (int)this.getIntrinsicHeight(), (Rect)this.getBounds(), (Rect)this.b);
            this.l = false;
        }
        Bitmap bitmap2 = (bitmap = this.e.d()) != null ? bitmap : this.c.i;
        canvas.drawBitmap(bitmap2, null, this.b, this.a);
    }

    public int e() {
        return this.d.c();
    }

    public void f() {
        this.h = true;
        this.c.h.a(this.c.i);
        this.e.c();
        this.e.b();
    }

    public Drawable.ConstantState getConstantState() {
        return this.c;
    }

    public int getIntrinsicHeight() {
        return this.c.i.getHeight();
    }

    public int getIntrinsicWidth() {
        return this.c.i.getWidth();
    }

    public int getOpacity() {
        return -2;
    }

    public boolean isRunning() {
        return this.f;
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.l = true;
    }

    public void setAlpha(int n2) {
        this.a.setAlpha(n2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean setVisible(boolean bl2, boolean bl3) {
        this.i = bl2;
        if (!bl2) {
            super.j();
            return super.setVisible(bl2, bl3);
        }
        if (!this.g) return super.setVisible(bl2, bl3);
        super.i();
        return super.setVisible(bl2, bl3);
    }

    public void start() {
        this.g = true;
        this.g();
        if (this.i) {
            this.i();
        }
    }

    public void stop() {
        this.g = false;
        this.j();
        if (Build.VERSION.SDK_INT < 11) {
            this.h();
        }
    }

    static class a
    extends Drawable.ConstantState {
        kf a;
        byte[] b;
        Context c;
        kr<Bitmap> d;
        int e;
        int f;
        kd.a g;
        ln h;
        Bitmap i;

        public a(kf kf2, byte[] arrby, Context context, kr<Bitmap> kr2, int n2, int n3, kd.a a2, ln ln2, Bitmap bitmap) {
            if (bitmap == null) {
                throw new NullPointerException("The first frame of the GIF must not be null");
            }
            this.a = kf2;
            this.b = arrby;
            this.h = ln2;
            this.i = bitmap;
            this.c = context.getApplicationContext();
            this.d = kr2;
            this.e = n2;
            this.f = n3;
            this.g = a2;
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            return new on(this);
        }

        public Drawable newDrawable(Resources resources) {
            return this.newDrawable();
        }
    }

}

