/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.res.Resources
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.graphics.drawable.Drawable$ConstantState
 *  java.lang.Runnable
 */
import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class qx
extends oh {
    private oh a;
    private a b;
    private boolean c;

    public qx(oh oh2, int n2) {
        super(new a(oh2.getConstantState(), n2), oh2, null);
    }

    qx(a a2, oh oh2, Resources resources) {
        this.b = a2;
        if (oh2 == null) {
            if (resources != null) {
                this.a = (oh)a2.a.newDrawable(resources);
                return;
            }
            this.a = (oh)a2.a.newDrawable();
            return;
        }
        this.a = oh2;
    }

    @Override
    public void a(int n2) {
        this.a.a(n2);
    }

    @Override
    public boolean a() {
        return this.a.a();
    }

    public void clearColorFilter() {
        this.a.clearColorFilter();
    }

    public void draw(Canvas canvas) {
        this.a.draw(canvas);
    }

    @TargetApi(value=19)
    public int getAlpha() {
        return this.a.getAlpha();
    }

    @TargetApi(value=11)
    public Drawable.Callback getCallback() {
        return this.a.getCallback();
    }

    public int getChangingConfigurations() {
        return this.a.getChangingConfigurations();
    }

    public Drawable.ConstantState getConstantState() {
        return this.b;
    }

    public Drawable getCurrent() {
        return this.a.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.b.b;
    }

    public int getIntrinsicWidth() {
        return this.b.b;
    }

    public int getMinimumHeight() {
        return this.a.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.a.getMinimumWidth();
    }

    public int getOpacity() {
        return this.a.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.a.getPadding(rect);
    }

    public void invalidateSelf() {
        super.invalidateSelf();
        this.a.invalidateSelf();
    }

    public boolean isRunning() {
        return this.a.isRunning();
    }

    public Drawable mutate() {
        if (!this.c && super.mutate() == this) {
            this.a = (oh)this.a.mutate();
            this.b = new a(this.b);
            this.c = true;
        }
        return this;
    }

    public void scheduleSelf(Runnable runnable, long l2) {
        super.scheduleSelf(runnable, l2);
        this.a.scheduleSelf(runnable, l2);
    }

    public void setAlpha(int n2) {
        this.a.setAlpha(n2);
    }

    public void setBounds(int n2, int n3, int n4, int n5) {
        super.setBounds(n2, n3, n4, n5);
        this.a.setBounds(n2, n3, n4, n5);
    }

    public void setBounds(Rect rect) {
        super.setBounds(rect);
        this.a.setBounds(rect);
    }

    public void setChangingConfigurations(int n2) {
        this.a.setChangingConfigurations(n2);
    }

    public void setColorFilter(int n2, PorterDuff.Mode mode) {
        this.a.setColorFilter(n2, mode);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
    }

    public void setDither(boolean bl2) {
        this.a.setDither(bl2);
    }

    public void setFilterBitmap(boolean bl2) {
        this.a.setFilterBitmap(bl2);
    }

    public boolean setVisible(boolean bl2, boolean bl3) {
        return this.a.setVisible(bl2, bl3);
    }

    public void start() {
        this.a.start();
    }

    public void stop() {
        this.a.stop();
    }

    public void unscheduleSelf(Runnable runnable) {
        super.unscheduleSelf(runnable);
        this.a.unscheduleSelf(runnable);
    }

    static class a
    extends Drawable.ConstantState {
        private final Drawable.ConstantState a;
        private final int b;

        a(Drawable.ConstantState constantState, int n2) {
            this.a = constantState;
            this.b = n2;
        }

        a(a a2) {
            super(a2.a, a2.b);
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            return this.newDrawable(null);
        }

        public Drawable newDrawable(Resources resources) {
            return new qx((a)this, null, resources);
        }
    }

}

