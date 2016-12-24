/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.widget.ImageView
 *  java.lang.Math
 */
package com.becandid.candid.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

public class ResizableImageView
extends ImageView {
    public ResizableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onMeasure(int n2, int n3) {
        Drawable drawable = this.getDrawable();
        if (drawable != null) {
            int n4 = View.MeasureSpec.getSize((int)n2);
            this.setMeasuredDimension(n4, (int)Math.ceil((double)((float)n4 * (float)drawable.getIntrinsicHeight() / (float)drawable.getIntrinsicWidth())));
            return;
        }
        super.onMeasure(n2, n3);
    }
}

