/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Cap
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.os.Handler
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  java.lang.Object
 *  java.lang.Runnable
 */
package com.becandid.thirdparty.nocropper;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import com.becandid.thirdparty.nocropper.CropperView;

public class CropperGridView
extends View {
    private long a = 1500;
    private Paint b;
    private int c = 268435455;
    private int d = 200;
    private int e = 3;
    private boolean f = false;
    private Handler g;
    private Path h;
    private Runnable i;

    public CropperGridView(Context context) {
        super(context);
        this.i = new Runnable(){

            public void run() {
                CropperGridView.this.f = false;
                CropperGridView.this.invalidate();
            }
        };
        super.a(context, null);
    }

    public CropperGridView(Context context, AttributeSet attributeSet) {
        super(context);
        this.i = new ;
        super.a(context, attributeSet);
    }

    public CropperGridView(Context context, AttributeSet attributeSet, int n2) {
        super(context);
        this.i = new ;
        super.a(context, attributeSet);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attributeSet, ha.a.CropperView);
            this.c = typedArray.getColor(0, this.c);
            float f2 = 255.0f * typedArray.getFloat(2, 1.0f);
            if (f2 < 0.0f) {
                f2 = 0.0f;
            } else if (f2 > 255.0f) {
                f2 = 255.0f;
            }
            this.d = (int)f2;
            this.e = typedArray.getDimensionPixelOffset(1, this.e);
            typedArray.recycle();
        }
        this.b = new Paint();
        this.b.setColor(this.c);
        this.b.setAntiAlias(true);
        this.b.setStyle(Paint.Style.STROKE);
        this.b.setStrokeCap(Paint.Cap.ROUND);
        this.b.setStrokeWidth((float)this.e);
        this.b.setAlpha(this.d);
        this.h = new Path();
        this.g = new Handler();
        if (this.isInEditMode()) {
            this.f = true;
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f) {
            return;
        }
        int n2 = canvas.getWidth();
        int n3 = canvas.getHeight();
        this.h.reset();
        this.h.moveTo((float)(n2 / 3), 0.0f);
        this.h.lineTo((float)(n2 / 3), (float)n3);
        this.h.moveTo((float)(n2 * 2 / 3), 0.0f);
        this.h.lineTo((float)(n2 * 2 / 3), (float)n3);
        this.h.moveTo(0.0f, (float)(n3 / 3));
        this.h.lineTo((float)n2, (float)(n3 / 3));
        this.h.moveTo(0.0f, (float)(n3 * 2 / 3));
        this.h.lineTo((float)n2, (float)(n3 * 2 / 3));
        canvas.drawPath(this.h, this.b);
    }

    protected void onMeasure(int n2, int n3) {
        super.onMeasure(n2, n3);
        int n4 = this.getContext().getResources().getConfiguration().orientation;
        if (n4 == 1 || n4 == 0) {
            int n5 = View.MeasureSpec.getSize((int)n2);
            this.setMeasuredDimension(n5, View.MeasureSpec.makeMeasureSpec((int)((int)(0.5 + (double)n5 * CropperView.a)), (int)1073741824));
            return;
        }
        int n6 = View.MeasureSpec.getSize((int)n3);
        this.setMeasuredDimension(View.MeasureSpec.makeMeasureSpec((int)n6, (int)1073741824), n6);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void setShowGrid(boolean bl2) {
        if (this.f == bl2) return;
        this.f = bl2;
        if (this.f) {
            this.g.removeCallbacks(this.i);
            this.invalidate();
            return;
        }
        this.g.postDelayed(this.i, this.a);
    }

}

