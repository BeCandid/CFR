/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.util.DisplayMetrics
 *  android.view.Gravity
 *  java.lang.NullPointerException
 *  java.lang.String
 */
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.Gravity;

public class ny
extends oh {
    private final Rect a;
    private int b;
    private int c;
    private boolean d;
    private boolean e;
    private a f;

    public ny(Resources resources, Bitmap bitmap) {
        super(resources, new a(bitmap));
    }

    /*
     * Enabled aggressive block sorting
     */
    ny(Resources resources, a a2) {
        int n2;
        this.a = new Rect();
        if (a2 == null) {
            throw new NullPointerException("BitmapState must not be null");
        }
        this.f = a2;
        if (resources != null) {
            int n3 = resources.getDisplayMetrics().densityDpi;
            n2 = n3 == 0 ? 160 : n3;
            a2.b = n2;
        } else {
            n2 = a2.b;
        }
        this.b = a2.a.getScaledWidth(n2);
        this.c = a2.a.getScaledHeight(n2);
    }

    @Override
    public void a(int n2) {
    }

    @Override
    public boolean a() {
        return false;
    }

    public Bitmap b() {
        return this.f.a;
    }

    public void draw(Canvas canvas) {
        if (this.d) {
            Gravity.apply((int)119, (int)this.b, (int)this.c, (Rect)this.getBounds(), (Rect)this.a);
            this.d = false;
        }
        canvas.drawBitmap(this.f.a, null, this.a, this.f.c);
    }

    public Drawable.ConstantState getConstantState() {
        return this.f;
    }

    public int getIntrinsicHeight() {
        return this.c;
    }

    public int getIntrinsicWidth() {
        return this.b;
    }

    public int getOpacity() {
        Bitmap bitmap = this.f.a;
        if (bitmap == null || bitmap.hasAlpha() || this.f.c.getAlpha() < 255) {
            return -3;
        }
        return -1;
    }

    public boolean isRunning() {
        return false;
    }

    public Drawable mutate() {
        if (!this.e && super.mutate() == this) {
            this.f = new a(this.f);
            this.e = true;
        }
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.d = true;
    }

    public void setAlpha(int n2) {
        if (this.f.c.getAlpha() != n2) {
            this.f.a(n2);
            this.invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f.a(colorFilter);
        this.invalidateSelf();
    }

    public void start() {
    }

    public void stop() {
    }

    static class a
    extends Drawable.ConstantState {
        private static final Paint d = new Paint(6);
        final Bitmap a;
        int b;
        Paint c;

        public a(Bitmap bitmap) {
            this.c = d;
            this.a = bitmap;
        }

        a(a a2) {
            super(a2.a);
            this.b = a2.b;
        }

        void a() {
            if (d == this.c) {
                this.c = new Paint(6);
            }
        }

        void a(int n2) {
            this.a();
            this.c.setAlpha(n2);
        }

        void a(ColorFilter colorFilter) {
            this.a();
            this.c.setColorFilter(colorFilter);
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            return new ny(null, this);
        }

        public Drawable newDrawable(Resources resources) {
            return new ny(resources, (a)this);
        }
    }

}

