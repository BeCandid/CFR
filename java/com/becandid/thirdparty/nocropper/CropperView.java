/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  java.lang.Object
 */
package com.becandid.thirdparty.nocropper;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.becandid.thirdparty.nocropper.CropperGridView;
import com.becandid.thirdparty.nocropper.CropperImageView;

public class CropperView
extends FrameLayout {
    public static double a = 1.1;
    private CropperImageView b;
    private CropperGridView c;

    public CropperView(Context context) {
        super(context);
        super.a(context, null);
    }

    public CropperView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.a(context, attributeSet);
    }

    public CropperView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        super.a(context, attributeSet);
    }

    @TargetApi(value=21)
    public CropperView(Context context, AttributeSet attributeSet, int n2, int n3) {
        super(context, attributeSet, n2, n3);
        super.a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.b = new CropperImageView(context, attributeSet);
        this.c = new CropperGridView(context, attributeSet);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, 0);
        if (context.getResources().getConfiguration().orientation == 2) {
            layoutParams.width = 0;
            layoutParams.height = -1;
        }
        this.addView((View)this.b, 0, (ViewGroup.LayoutParams)layoutParams);
        this.addView((View)this.c, 1, (ViewGroup.LayoutParams)layoutParams);
        this.b.setGestureCallback(new a((CropperView)this, null));
    }

    public Bitmap getCroppedBitmap() {
        return this.b.getCroppedBitmap();
    }

    public int getCropperWidth() {
        if (this.b != null) {
            return this.b.getWidth();
        }
        return 0;
    }

    public float getMaxZoom() {
        return this.b.getMaxZoom();
    }

    public float getMinZoom() {
        return this.b.getMinZoom();
    }

    public int getPaddingColor() {
        return this.b.getPaddingColor();
    }

    protected void onMeasure(int n2, int n3) {
        super.onMeasure(n2, n3);
        int n4 = this.getContext().getResources().getConfiguration().orientation;
        if (n4 == 1 || n4 == 0) {
            int n5 = View.MeasureSpec.getSize((int)n2);
            this.setMeasuredDimension(n5, View.MeasureSpec.makeMeasureSpec((int)((int)(0.5 + (double)n5 * a)), (int)1073741824));
            return;
        }
        int n6 = View.MeasureSpec.getSize((int)n3);
        this.setMeasuredDimension(View.MeasureSpec.makeMeasureSpec((int)n6, (int)1073741824), n6);
    }

    public void setDebug(boolean bl2) {
        this.b.setDEBUG(bl2);
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.b.setImageBitmap(bitmap);
    }

    public void setMakeSquare(boolean bl2) {
        this.b.setMakeSquare(bl2);
    }

    public void setMaxZoom(float f2) {
        this.b.setMaxZoom(f2);
    }

    public void setMinZoom(float f2) {
        this.b.setMinZoom(f2);
    }

    public void setPaddingColor(int n2) {
        this.b.setPaddingColor(n2);
    }

    public void setPreScaling(boolean bl2) {
        this.b.setDoPreScaling(bl2);
    }

    class a
    implements CropperImageView.a {
        final /* synthetic */ CropperView a;

        private a(CropperView cropperView) {
            this.a = cropperView;
        }

        /* synthetic */ a(CropperView cropperView,  var2_2) {
            super(cropperView);
        }

        @Override
        public void a() {
            this.a.c.setShowGrid(true);
        }

        @Override
        public void b() {
            this.a.c.setShowGrid(false);
        }
    }

}

