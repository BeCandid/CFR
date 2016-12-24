/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Path
 *  android.util.AttributeSet
 *  android.widget.TextView
 */
package com.venmo.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.TextView;
import com.venmo.view.ArrowAlignment;

public class TooltipView
extends TextView {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private akr f;
    private ArrowAlignment g;
    private int h;
    private int i;
    private Paint j;
    private Path k;

    public TooltipView(Context context) {
        super(context);
        super.a(null, 0);
    }

    public TooltipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.a(attributeSet, 0);
    }

    public TooltipView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        super.a(attributeSet, n2);
    }

    private int a(TypedArray typedArray, int n2, int n3) {
        int n4 = typedArray.getDimensionPixelSize(n2, Integer.MIN_VALUE);
        if (n4 == Integer.MIN_VALUE) {
            n4 = this.getResources().getDimensionPixelSize(n3);
        }
        return n4;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(AttributeSet attributeSet, int n2) {
        Resources resources = this.getResources();
        TypedArray typedArray = this.getContext().obtainStyledAttributes(attributeSet, akt.c.TooltipView, n2, 0);
        try {
            void var6_6;
            this.d = typedArray.getResourceId(akt.c.TooltipView_anchoredView, -1);
            this.e = typedArray.getColor(akt.c.TooltipView_tooltipColor, 0);
            this.c = super.a(typedArray, akt.c.TooltipView_cornerRadius, akt.a.tooltip_default_corner_radius);
            this.a = super.a(typedArray, akt.c.TooltipView_arrowHeight, akt.a.tooltip_default_arrow_height);
            this.b = super.a(typedArray, akt.c.TooltipView_arrowWidth, akt.a.tooltip_default_arrow_width);
            this.i = typedArray.getInteger(akt.c.TooltipView_arrowLocation, resources.getInteger(akt.b.tooltip_default_arrow_location));
            if (this.i == 0) {
                aku aku2 = new aku();
            } else {
                aks aks2 = new aks();
            }
            this.f = var6_6;
            this.g = ArrowAlignment.a(typedArray.getInteger(akt.c.TooltipView_arrowAlignment, resources.getInteger(akt.b.tooltip_default_arrow_alignment)));
            this.h = super.a(typedArray, akt.c.TooltipView_arrowAlignmentOffset, akt.a.tooltip_default_offset);
            return;
        }
        finally {
            typedArray.recycle();
        }
    }

    public int getAlignmentOffset() {
        return this.h;
    }

    public int getAnchoredViewId() {
        return this.d;
    }

    public ArrowAlignment getArrowAlignment() {
        return this.g;
    }

    public int getArrowHeight() {
        return this.a;
    }

    public int getArrowWidth() {
        return this.b;
    }

    public int getCornerRadius() {
        return this.c;
    }

    public int getTooltipColor() {
        return this.e;
    }

    public Paint getTooltipPaint() {
        return this.j;
    }

    public Path getTooltipPath() {
        return this.k;
    }

    public void invalidate() {
        super.invalidate();
        this.k = null;
        this.j = null;
    }

    protected void onDraw(Canvas canvas) {
        if (this.k == null || this.j == null) {
            this.f.a((TooltipView)this, canvas);
        }
        canvas.drawPath(this.k, this.j);
        super.onDraw(canvas);
    }

    protected void onMeasure(int n2, int n3) {
        super.onMeasure(n2, n3);
        this.setMeasuredDimension(this.getMeasuredWidth(), this.getMeasuredHeight() + this.a);
    }

    public void setAlignmentOffset(int n2) {
        this.h = n2;
        this.invalidate();
    }

    public void setAlignmentOffsetResource(int n2) {
        this.h = this.getResources().getDimensionPixelSize(n2);
        this.invalidate();
    }

    public void setAnchoredViewId(int n2) {
        this.d = n2;
        this.invalidate();
    }

    public void setArrowAlignment(ArrowAlignment arrowAlignment) {
        this.g = arrowAlignment;
        this.invalidate();
    }

    public void setArrowHeight(int n2) {
        this.a = n2;
        this.invalidate();
    }

    public void setArrowHeightResource(int n2) {
        this.a = this.getResources().getDimensionPixelSize(n2);
        this.invalidate();
    }

    public void setArrowPositioning(int n2) {
        this.i = n2;
        this.invalidate();
    }

    public void setArrowWidth(int n2) {
        this.b = n2;
        this.invalidate();
    }

    public void setArrowWidthResource(int n2) {
        this.b = this.getResources().getDimensionPixelSize(n2);
        this.invalidate();
    }

    public void setCornerRadius(int n2) {
        this.c = n2;
        this.invalidate();
    }

    public void setCornerRadiusResource(int n2) {
        this.c = this.getResources().getDimensionPixelSize(n2);
        this.invalidate();
    }

    public void setPaint(Paint paint) {
        this.j = paint;
    }

    public void setTooltipColor(int n2) {
        this.e = n2;
        this.invalidate();
    }

    public void setTooltipPath(Path path) {
        this.k = path;
    }
}

