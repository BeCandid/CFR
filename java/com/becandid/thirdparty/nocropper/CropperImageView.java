/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Bitmap
 *  android.graphics.Color
 *  android.graphics.Matrix
 *  android.graphics.drawable.Drawable
 *  android.os.Handler
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.GestureDetector
 *  android.view.GestureDetector$OnGestureListener
 *  android.view.GestureDetector$SimpleOnGestureListener
 *  android.view.MotionEvent
 *  android.view.ScaleGestureDetector
 *  android.view.ScaleGestureDetector$OnScaleGestureListener
 *  android.view.ScaleGestureDetector$SimpleOnScaleGestureListener
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 */
package com.becandid.thirdparty.nocropper;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;
import com.becandid.thirdparty.nocropper.CropperView;

public class CropperImageView
extends ImageView {
    protected GestureDetector a;
    protected ScaleGestureDetector b;
    public boolean c = false;
    private float[] d = new float[9];
    private b e;
    private c f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;
    private boolean l = false;
    private boolean m = true;
    private Bitmap n;
    private boolean o = false;
    private float p;
    private boolean q = false;
    private a r;
    private boolean s = true;
    private boolean t = false;
    private int u = Color.rgb((int)246, (int)246, (int)246);

    public CropperImageView(Context context) {
        super(context);
        super.a(context, null);
    }

    public CropperImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.a(context, attributeSet);
    }

    public CropperImageView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        super.a(context, attributeSet);
    }

    private float a(Matrix matrix) {
        return super.a(matrix, 0);
    }

    private float a(Matrix matrix, int n2) {
        matrix.getValues(this.d);
        return this.d[n2];
    }

    private void a(final float f2, final float f3) {
        ValueAnimator valueAnimator = ValueAnimator.ofInt((int[])new int[]{0, 20});
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Matrix matrix = CropperImageView.this.getImageMatrix();
                matrix.postTranslate(f2 / 20.0f, f3 / 20.0f);
                CropperImageView.this.setImageMatrix(matrix);
                CropperImageView.this.invalidate();
            }
        });
        valueAnimator.addListener(new Animator.AnimatorListener(){

            public void onAnimationCancel(Animator animator) {
                CropperImageView.this.t = false;
            }

            public void onAnimationEnd(Animator animator) {
                CropperImageView.this.t = false;
            }

            public void onAnimationRepeat(Animator animator) {
                CropperImageView.this.t = true;
            }

            public void onAnimationStart(Animator animator) {
                CropperImageView.this.t = true;
            }
        });
        valueAnimator.start();
    }

    private void a(final float f2, final float f3, final float f4, final float f5, final float f6, final float f7) {
        ValueAnimator valueAnimator = ValueAnimator.ofInt((int[])new int[]{0, 20});
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Matrix matrix = CropperImageView.this.getImageMatrix();
                matrix.reset();
                Integer n2 = (Integer)valueAnimator.getAnimatedValue();
                matrix.postScale((f7 - f6) * (float)n2.intValue() / 20.0f + f6, (f7 - f6) * (float)n2.intValue() / 20.0f + f6);
                matrix.postTranslate((f3 - f2) * (float)n2.intValue() / 20.0f + f2, (f5 - f4) * (float)n2.intValue() / 20.0f + f4);
                CropperImageView.this.setImageMatrix(matrix);
                CropperImageView.this.invalidate();
            }
        });
        valueAnimator.addListener(new Animator.AnimatorListener(){

            public void onAnimationCancel(Animator animator) {
                CropperImageView.this.t = false;
            }

            public void onAnimationEnd(Animator animator) {
                CropperImageView.this.t = false;
            }

            public void onAnimationRepeat(Animator animator) {
                CropperImageView.this.t = true;
            }

            public void onAnimationStart(Animator animator) {
                CropperImageView.this.t = true;
            }
        });
        valueAnimator.start();
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attributeSet, ha.a.CropperView);
            this.u = typedArray.getColor(3, this.u);
            this.q = typedArray.getBoolean(4, false);
        }
        this.e = new b((CropperImageView)this, null);
        this.a = new GestureDetector(context, (GestureDetector.OnGestureListener)this.e, null, true);
        this.f = new c((CropperImageView)this, null);
        this.b = new ScaleGestureDetector(context, (ScaleGestureDetector.OnScaleGestureListener)this.f);
        this.setScaleType(ImageView.ScaleType.MATRIX);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(Drawable drawable, int n2) {
        if (drawable == null) {
            if (!this.c) return;
            {
                Log.e((String)"CropperImageView", (String)"Drawable is null. I can't fit anything");
            }
            return;
        }
        if (n2 == 0) {
            if (!this.c) return;
            {
                Log.e((String)"CropperImageView", (String)"Frame Dimension is 0. I'm quite boggled by it.");
                return;
            }
        }
        int n3 = drawable.getIntrinsicWidth();
        int n4 = drawable.getIntrinsicHeight();
        if (this.c) {
            Log.i((String)"CropperImageView", (String)("drawable size: (" + n3 + " ," + n4 + ")"));
        }
        float f2 = (float)Math.min((int)n3, (int)n4) / (float)n2;
        Matrix matrix = new Matrix();
        matrix.setScale(1.0f / f2, 1.0f / f2);
        matrix.postTranslate(((float)n2 - (float)n3 / f2) / 2.0f, ((float)n2 - (float)n4 / f2) / 2.0f);
        this.setImageMatrix(matrix);
    }

    /*
     * Enabled aggressive block sorting
     */
    private boolean a(MotionEvent motionEvent) {
        Drawable drawable = this.getDrawable();
        if (drawable == null) {
            return false;
        }
        Matrix matrix = this.getImageMatrix();
        float f2 = super.a(matrix, 2);
        float f3 = super.a(matrix, 5);
        float f4 = super.a(matrix, 0);
        float f5 = super.a(matrix, 4);
        if (this.c) {
            Log.i((String)"CropperImageView", (String)("onUp: " + f2 + " " + f3));
            Log.i((String)"CropperImageView", (String)("scale: " + f4));
            Log.i((String)"CropperImageView", (String)("min, max, base zoom: " + this.g + ", " + this.h + ", " + this.i));
            Log.i((String)"CropperImageView", (String)("imageview size: " + this.getWidth() + " " + this.getHeight()));
            Log.i((String)"CropperImageView", (String)("drawable size: " + drawable.getIntrinsicWidth() + " " + drawable.getIntrinsicHeight()));
            Log.i((String)"CropperImageView", (String)("scaled drawable size: " + f4 * (float)drawable.getIntrinsicWidth() + " " + f5 * (float)drawable.getIntrinsicHeight()));
        }
        if (f4 <= this.g) {
            if (this.c) {
                Log.i((String)"CropperImageView", (String)("set scale: " + this.g));
            }
            float f6 = (float)(this.getWidth() / 2) - this.g * (float)drawable.getIntrinsicWidth() / 2.0f;
            float f7 = (float)(this.getHeight() / 2) - this.g * (float)drawable.getIntrinsicHeight() / 2.0f;
            if (this.a()) {
                super.a(f2, f6, f3, f7, f4, this.g);
                return true;
            }
            matrix.reset();
            matrix.setScale(this.g, this.g);
            matrix.postTranslate(f6, f7);
            this.setImageMatrix(matrix);
            this.invalidate();
            if (!this.c) return true;
            Log.i((String)"CropperImageView", (String)("scale after invalidate: " + super.a(matrix)));
            return true;
        }
        if (f4 < this.i) {
            float f8;
            float f9;
            int n2;
            int n3 = drawable.getIntrinsicHeight();
            if (n3 <= (n2 = drawable.getIntrinsicWidth())) {
                float f10;
                f9 = (float)(this.getHeight() / 2) - f4 * (float)n3 / 2.0f;
                f8 = f2 >= 0.0f ? 0.0f : (f2 < (f10 = (float)this.getWidth() - f4 * (float)drawable.getIntrinsicWidth()) ? f10 : f2);
            } else {
                float f11;
                f8 = (float)(this.getWidth() / 2) - f4 * (float)n2 / 2.0f;
                f9 = f3 >= 0.0f ? 0.0f : (f3 < (f11 = (float)this.getHeight() - f5 * (float)drawable.getIntrinsicHeight()) ? f11 : f3);
            }
            if (this.a()) {
                matrix.reset();
                matrix.postScale(f4, f4);
                matrix.postTranslate(f2, f3);
                this.setImageMatrix(matrix);
                super.a(f8 - f2, f9 - f3);
                return true;
            }
            matrix.reset();
            matrix.postScale(f4, f4);
            matrix.postTranslate(f8, f9);
            this.setImageMatrix(matrix);
            this.invalidate();
            return true;
        }
        if (this.l && f4 > this.h) {
            if (this.c) {
                Log.i((String)"CropperImageView", (String)"set to max zoom");
                Log.i((String)"CropperImageView", (String)("isMaxZoomSet: " + this.l));
            }
            if (this.a()) {
                super.c();
                return true;
            }
            matrix.postScale(this.h / f4, this.h / f4, this.j, this.k);
            this.setImageMatrix(matrix);
            this.invalidate();
            super.b();
            return true;
        }
        if (this.c) {
            Log.i((String)"CropperImageView", (String)"adjust to sides");
        }
        super.b();
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    private boolean b() {
        float f2;
        boolean bl2;
        float f3;
        Drawable drawable = this.getDrawable();
        if (drawable == null) {
            return false;
        }
        Matrix matrix = this.getImageMatrix();
        this.a(matrix, 2);
        this.a(matrix, 5);
        float f4 = this.a(matrix, 2);
        float f5 = this.a(matrix, 5);
        float f6 = this.a(matrix, 0);
        float f7 = this.a(matrix, 4);
        if (f4 > 0.0f) {
            f2 = - f4;
            bl2 = true;
        } else {
            float f8 = (float)this.getWidth() - f6 * (float)drawable.getIntrinsicWidth();
            if (f4 < f8) {
                f2 = f8 - f4;
                bl2 = true;
            } else {
                bl2 = false;
                f2 = 0.0f;
            }
        }
        if (f5 > 0.0f) {
            f3 = - f5;
            bl2 = true;
        } else {
            float f9 = (float)this.getHeight() - f7 * (float)drawable.getIntrinsicHeight();
            if (f5 < f9) {
                f3 = f9 - f5;
                bl2 = true;
            } else {
                f3 = 0.0f;
            }
        }
        if (!bl2) return bl2;
        if (this.a()) {
            this.a(f2, f3);
            return bl2;
        }
        matrix.postTranslate(f2, f3);
        this.setImageMatrix(matrix);
        this.invalidate();
        return bl2;
    }

    private void c() {
        final float f2 = this.a(this.getImageMatrix());
        ValueAnimator valueAnimator = ValueAnimator.ofInt((int[])new int[]{0, 20});
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Matrix matrix = CropperImageView.this.getImageMatrix();
                if (CropperImageView.this.a(matrix) <= CropperImageView.this.h) {
                    return;
                }
                double d2 = Math.pow((double)(CropperImageView.this.h / f2), (double)0.05000000074505806);
                matrix.postScale((float)d2, (float)d2, CropperImageView.this.j, CropperImageView.this.k);
                CropperImageView.this.setImageMatrix(matrix);
                CropperImageView.this.invalidate();
            }
        });
        valueAnimator.addListener(new Animator.AnimatorListener(){

            public void onAnimationCancel(Animator animator) {
                CropperImageView.this.t = false;
            }

            public void onAnimationEnd(Animator animator) {
                CropperImageView.this.t = false;
                CropperImageView.this.b();
            }

            public void onAnimationRepeat(Animator animator) {
                CropperImageView.this.t = true;
            }

            public void onAnimationStart(Animator animator) {
                CropperImageView.this.t = true;
            }
        });
        valueAnimator.start();
    }

    public boolean a() {
        return this.s;
    }

    public boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        Matrix matrix = this.getImageMatrix();
        matrix.postTranslate(- f2, - f3);
        this.setImageMatrix(matrix);
        this.invalidate();
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    public Bitmap getCroppedBitmap() {
        Bitmap bitmap;
        if (this.n == null) {
            Log.e((String)"CropperImageView", (String)"original image is not available");
            return null;
        }
        Matrix matrix = this.getImageMatrix();
        if (this.o) {
            matrix.postScale(1.0f / this.p, 1.0f / this.p);
        }
        float f2 = this.a(matrix, 2);
        float f3 = this.a(matrix, 5);
        float f4 = this.a(matrix, 0);
        if (this.c) {
            Log.i((String)"CropperImageView", (String)("xTrans: " + f2 + ", yTrans: " + f3 + " , scale: " + f4));
        }
        if (this.c) {
            Log.i((String)"CropperImageView", (String)("old bitmap: " + this.n.getWidth() + " " + this.n.getHeight()));
        }
        if (f2 > 0.0f && f3 > 0.0f && f4 <= this.g) {
            if (!this.q) return this.n;
            return jq.a(this.n, this.u);
        }
        float f5 = (- f3) / f4;
        float f6 = (float)this.getHeight() / f4;
        float f7 = (- f2) / f4;
        float f8 = (float)this.getWidth() / f4;
        if (this.c) {
            Log.i((String)"CropperImageView", (String)("cropY: " + f5));
            Log.i((String)"CropperImageView", (String)("Y: " + f6));
            Log.i((String)"CropperImageView", (String)("cropX: " + f7));
            Log.i((String)"CropperImageView", (String)("X: " + f8));
        }
        if (f5 + f6 > (float)this.n.getHeight()) {
            f5 = (float)this.n.getHeight() - f6;
            if (this.c) {
                Log.i((String)"CropperImageView", (String)("readjust cropY to: " + f5));
            }
        } else if (f5 < 0.0f) {
            boolean bl2 = this.c;
            f5 = 0.0f;
            if (bl2) {
                Log.i((String)"CropperImageView", (String)("readjust cropY to: " + 0.0f));
                f5 = 0.0f;
            }
        }
        if (f7 + f8 > (float)this.n.getWidth()) {
            f7 = (float)this.n.getWidth() - f8;
            if (this.c) {
                Log.i((String)"CropperImageView", (String)("readjust cropX to: " + f7));
            }
        } else if (f7 < 0.0f) {
            boolean bl3 = this.c;
            f7 = 0.0f;
            if (bl3) {
                Log.i((String)"CropperImageView", (String)("readjust cropX to: " + 0.0f));
                f7 = 0.0f;
            }
        }
        if (this.n.getHeight() > this.n.getWidth()) {
            if (f2 < 0.0f) {
                return Bitmap.createBitmap((Bitmap)this.n, (int)((int)f7), (int)((int)f5), (int)((int)f8), (int)((int)f6), (Matrix)null, (boolean)true);
            }
            bitmap = Bitmap.createBitmap((Bitmap)this.n, (int)0, (int)((int)f5), (int)this.n.getWidth(), (int)((int)f6), (Matrix)null, (boolean)true);
            if (!this.q) return bitmap;
            return jq.a(bitmap, this.u);
        }
        if (f3 >= 0.0f) {
            bitmap = Bitmap.createBitmap((Bitmap)this.n, (int)((int)f7), (int)0, (int)((int)f8), (int)this.n.getHeight(), (Matrix)null, (boolean)true);
            if (this.q) {
                bitmap = jq.a(bitmap, this.u);
            }
        } else {
            bitmap = Bitmap.createBitmap((Bitmap)this.n, (int)((int)f7), (int)((int)f5), (int)((int)f8), (int)((int)f6), (Matrix)null, (boolean)true);
        }
        if (!this.c) return bitmap;
        Log.i((String)"CropperImageView", (String)("width should be: " + this.n.getWidth()));
        Log.i((String)"CropperImageView", (String)("crop bitmap: " + bitmap.getWidth() + " " + bitmap.getHeight()));
        return bitmap;
    }

    public float getMaxZoom() {
        return this.h;
    }

    public float getMinZoom() {
        return this.g;
    }

    public int getPaddingColor() {
        return this.u;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
        super.onLayout(bl2, n2, n3, n4, n5);
        if (this.c) {
            Log.i((String)"CropperImageView", (String)("onLayout: " + bl2 + " [" + n2 + ", " + n3 + ", " + n4 + ", " + n5 + "]"));
        }
        if (!bl2 && !this.m || !this.m) return;
        Drawable drawable = this.getDrawable();
        if (drawable == null) {
            if (!this.c) return;
            Log.e((String)"CropperImageView", (String)"drawable is null");
            return;
        }
        this.g = (float)(n5 - n3) / (float)Math.max((int)drawable.getIntrinsicHeight(), (int)drawable.getIntrinsicWidth());
        this.i = (float)(n5 - n3) / (float)Math.min((int)drawable.getIntrinsicHeight(), (int)drawable.getIntrinsicWidth());
        this.a(drawable, n5 - n3);
        this.m = false;
    }

    protected void onMeasure(int n2, int n3) {
        super.onMeasure(n2, n3);
        int n4 = this.getContext().getResources().getConfiguration().orientation;
        if (n4 == 1 || n4 == 0) {
            this.setMeasuredDimension(n2, View.MeasureSpec.makeMeasureSpec((int)((int)(0.5 + (double)View.MeasureSpec.getSize((int)n2) * CropperView.a)), (int)1073741824));
            return;
        }
        int n5 = View.MeasureSpec.getSize((int)n3);
        this.setMeasuredDimension(View.MeasureSpec.makeMeasureSpec((int)n5, (int)1073741824), n5);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.t) {
            return true;
        }
        if (motionEvent.getActionMasked() == 0 && this.r != null) {
            this.r.a();
        }
        this.b.onTouchEvent(motionEvent);
        if (!this.b.isInProgress()) {
            this.a.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            default: {
                return true;
            }
            case 1: 
        }
        if (this.r != null) {
            this.r.b();
        }
        return super.a(motionEvent);
    }

    public void setDEBUG(boolean bl2) {
        this.c = bl2;
    }

    public void setDoPreScaling(boolean bl2) {
        this.o = bl2;
    }

    public void setGestureCallback(a a2) {
        this.r = a2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void setImageBitmap(Bitmap bitmap) {
        this.m = true;
        if (bitmap == null) {
            this.n = null;
            super.setImageBitmap(null);
            return;
        }
        if (bitmap.getHeight() > 1280 || bitmap.getWidth() > 1280) {
            Log.w((String)"CropperImageView", (String)"Bitmap size greater than 1280. This might cause memory issues");
        }
        this.n = bitmap;
        if (this.o) {
            this.p = (float)Math.max((int)bitmap.getWidth(), (int)bitmap.getHeight()) / (float)this.getWidth();
            super.setImageBitmap(Bitmap.createScaledBitmap((Bitmap)bitmap, (int)((int)((float)bitmap.getWidth() / this.p)), (int)((int)((float)bitmap.getHeight() / this.p)), (boolean)false));
        } else {
            this.p = 1.0f;
            super.setImageBitmap(bitmap);
        }
        this.requestLayout();
    }

    public void setMakeSquare(boolean bl2) {
        this.q = bl2;
    }

    public void setMaxZoom(float f2) {
        if (f2 <= 0.0f) {
            Log.e((String)"CropperImageView", (String)"Max zoom must be greater than 0");
            return;
        }
        this.h = f2;
        this.l = true;
    }

    public void setMinZoom(float f2) {
        if (f2 <= 0.0f) {
            Log.e((String)"CropperImageView", (String)"Min zoom must be greater than 0");
            return;
        }
        this.g = f2;
    }

    public void setPaddingColor(int n2) {
        this.u = n2;
    }

    public void setShowAnimation(boolean bl2) {
        this.s = bl2;
    }

    public static interface a {
        public void a();

        public void b();
    }

    class b
    extends GestureDetector.SimpleOnGestureListener {
        final /* synthetic */ CropperImageView a;

        private b(CropperImageView cropperImageView) {
            this.a = cropperImageView;
        }

        /* synthetic */ b(CropperImageView cropperImageView,  var2_2) {
            super(cropperImageView);
        }

        /*
         * Enabled aggressive block sorting
         */
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (motionEvent == null || motionEvent2 == null || motionEvent.getPointerCount() > 1 || motionEvent2.getPointerCount() > 1) {
                return false;
            }
            this.a.a(motionEvent, motionEvent2, f2, f3);
            return false;
        }
    }

    class c
    extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        protected boolean a;
        final /* synthetic */ CropperImageView b;

        private c(CropperImageView cropperImageView) {
            this.b = cropperImageView;
            this.a = false;
        }

        /* synthetic */ c(CropperImageView cropperImageView,  var2_2) {
            super(cropperImageView);
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            Matrix matrix = this.b.getImageMatrix();
            this.b.j = scaleGestureDetector.getFocusX();
            this.b.k = scaleGestureDetector.getFocusY();
            matrix.postScale(scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            this.b.setImageMatrix(matrix);
            this.b.invalidate();
            return true;
        }
    }

}

