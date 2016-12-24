/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Matrix
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.util.AttributeSet
 *  android.view.GestureDetector
 *  android.view.GestureDetector$OnDoubleTapListener
 *  android.view.View
 *  android.view.View$OnLongClickListener
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 *  java.lang.Deprecated
 */
package uk.co.senab.photoview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;

public class PhotoView
extends ImageView
implements atb {
    private atc a;
    private ImageView.ScaleType b;

    public PhotoView(Context context) {
        super(context, null);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        this.a();
    }

    protected void a() {
        if (this.a == null || this.a.c() == null) {
            this.a = new atc(this);
        }
        if (this.b != null) {
            this.setScaleType(this.b);
            this.b = null;
        }
    }

    public Matrix getDisplayMatrix() {
        return this.a.l();
    }

    public RectF getDisplayRect() {
        return this.a.b();
    }

    public atb getIPhotoViewImplementation() {
        return this.a;
    }

    @Deprecated
    public float getMaxScale() {
        return this.getMaximumScale();
    }

    public float getMaximumScale() {
        return this.a.f();
    }

    public float getMediumScale() {
        return this.a.e();
    }

    @Deprecated
    public float getMidScale() {
        return this.getMediumScale();
    }

    @Deprecated
    public float getMinScale() {
        return this.getMinimumScale();
    }

    public float getMinimumScale() {
        return this.a.d();
    }

    @Deprecated
    public atc.d getOnPhotoTapListener() {
        return this.a.i();
    }

    @Deprecated
    public atc.g getOnViewTapListener() {
        return this.a.j();
    }

    public float getScale() {
        return this.a.g();
    }

    public ImageView.ScaleType getScaleType() {
        return this.a.h();
    }

    public Bitmap getVisibleRectangleBitmap() {
        return this.a.n();
    }

    protected void onAttachedToWindow() {
        this.a();
        super.onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        this.a.a();
        super.onDetachedFromWindow();
    }

    public void setAllowParentInterceptOnEdge(boolean bl2) {
        this.a.a(bl2);
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.a != null) {
            this.a.k();
        }
    }

    public void setImageResource(int n2) {
        super.setImageResource(n2);
        if (this.a != null) {
            this.a.k();
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        if (this.a != null) {
            this.a.k();
        }
    }

    @Deprecated
    public void setMaxScale(float f2) {
        this.setMaximumScale(f2);
    }

    public void setMaximumScale(float f2) {
        this.a.e(f2);
    }

    public void setMediumScale(float f2) {
        this.a.d(f2);
    }

    @Deprecated
    public void setMidScale(float f2) {
        this.setMediumScale(f2);
    }

    @Deprecated
    public void setMinScale(float f2) {
        this.setMinimumScale(f2);
    }

    public void setMinimumScale(float f2) {
        this.a.c(f2);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.a.a(onDoubleTapListener);
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.a.a(onLongClickListener);
    }

    public void setOnMatrixChangeListener(atc.c c2) {
        this.a.a(c2);
    }

    public void setOnPhotoTapListener(atc.d d2) {
        this.a.a(d2);
    }

    public void setOnScaleChangeListener(atc.e e2) {
        this.a.a(e2);
    }

    public void setOnSingleFlingListener(atc.f f2) {
        this.a.a(f2);
    }

    public void setOnViewTapListener(atc.g g2) {
        this.a.a(g2);
    }

    public void setPhotoViewRotation(float f2) {
        this.a.a(f2);
    }

    public void setRotationBy(float f2) {
        this.a.b(f2);
    }

    public void setRotationTo(float f2) {
        this.a.a(f2);
    }

    public void setScale(float f2) {
        this.a.f(f2);
    }

    public void setScale(float f2, float f3, float f4, boolean bl2) {
        this.a.a(f2, f3, f4, bl2);
    }

    public void setScale(float f2, boolean bl2) {
        this.a.a(f2, bl2);
    }

    public void setScaleLevels(float f2, float f3, float f4) {
        this.a.b(f2, f3, f4);
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (this.a != null) {
            this.a.a(scaleType);
            return;
        }
        this.b = scaleType;
    }

    public void setZoomTransitionDuration(int n2) {
        this.a.a(n2);
    }

    public void setZoomable(boolean bl2) {
        this.a.b(bl2);
    }
}

