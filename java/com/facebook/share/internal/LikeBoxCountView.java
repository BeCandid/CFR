/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.RectF
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 */
package com.facebook.share.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

public class LikeBoxCountView
extends FrameLayout {
    private TextView a;
    private LikeBoxCountViewCaretPosition b = LikeBoxCountViewCaretPosition.a;
    private float c;
    private float d;
    private float e;
    private Paint f;
    private int g;
    private int h;

    public LikeBoxCountView(Context context) {
        super(context);
        super.a(context);
    }

    private void a(int n2, int n3, int n4, int n5) {
        this.a.setPadding(n2 + this.g, n3 + this.g, n4 + this.g, n5 + this.g);
    }

    private void a(Context context) {
        this.setWillNotDraw(false);
        this.c = this.getResources().getDimension(uu.b.com_facebook_likeboxcountview_caret_height);
        this.d = this.getResources().getDimension(uu.b.com_facebook_likeboxcountview_caret_width);
        this.e = this.getResources().getDimension(uu.b.com_facebook_likeboxcountview_border_radius);
        this.f = new Paint();
        this.f.setColor(this.getResources().getColor(uu.a.com_facebook_likeboxcountview_border_color));
        this.f.setStrokeWidth(this.getResources().getDimension(uu.b.com_facebook_likeboxcountview_border_width));
        this.f.setStyle(Paint.Style.STROKE);
        super.b(context);
        this.addView((View)this.a);
        this.setCaretPosition(this.b);
    }

    private void a(Canvas canvas, float f2, float f3, float f4, float f5) {
        Path path = new Path();
        float f6 = 2.0f * this.e;
        path.addArc(new RectF(f2, f3, f2 + f6, f3 + f6), -180.0f, 90.0f);
        if (this.b == LikeBoxCountViewCaretPosition.b) {
            path.lineTo(f2 + (f4 - f2 - this.d) / 2.0f, f3);
            path.lineTo(f2 + (f4 - f2) / 2.0f, f3 - this.c);
            path.lineTo(f2 + (f4 - f2 + this.d) / 2.0f, f3);
        }
        path.lineTo(f4 - this.e, f3);
        path.addArc(new RectF(f4 - f6, f3, f4, f3 + f6), -90.0f, 90.0f);
        if (this.b == LikeBoxCountViewCaretPosition.c) {
            path.lineTo(f4, f3 + (f5 - f3 - this.d) / 2.0f);
            path.lineTo(f4 + this.c, f3 + (f5 - f3) / 2.0f);
            path.lineTo(f4, f3 + (f5 - f3 + this.d) / 2.0f);
        }
        path.lineTo(f4, f5 - this.e);
        path.addArc(new RectF(f4 - f6, f5 - f6, f4, f5), 0.0f, 90.0f);
        if (this.b == LikeBoxCountViewCaretPosition.d) {
            path.lineTo(f2 + (f4 - f2 + this.d) / 2.0f, f5);
            path.lineTo(f2 + (f4 - f2) / 2.0f, f5 + this.c);
            path.lineTo(f2 + (f4 - f2 - this.d) / 2.0f, f5);
        }
        path.lineTo(f2 + this.e, f5);
        path.addArc(new RectF(f2, f5 - f6, f2 + f6, f5), 90.0f, 90.0f);
        if (this.b == LikeBoxCountViewCaretPosition.a) {
            path.lineTo(f2, f3 + (f5 - f3 + this.d) / 2.0f);
            path.lineTo(f2 - this.c, f3 + (f5 - f3) / 2.0f);
            path.lineTo(f2, f3 + (f5 - f3 - this.d) / 2.0f);
        }
        path.lineTo(f2, f3 + this.e);
        canvas.drawPath(path, this.f);
    }

    private void b(Context context) {
        this.a = new TextView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.a.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        this.a.setGravity(17);
        this.a.setTextSize(0, this.getResources().getDimension(uu.b.com_facebook_likeboxcountview_text_size));
        this.a.setTextColor(this.getResources().getColor(uu.a.com_facebook_likeboxcountview_text_color));
        this.g = this.getResources().getDimensionPixelSize(uu.b.com_facebook_likeboxcountview_text_padding);
        this.h = this.getResources().getDimensionPixelSize(uu.b.com_facebook_likeboxcountview_caret_height);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    protected void onDraw(Canvas var1) {
        super.onDraw(var1);
        var2_2 = this.getPaddingTop();
        var3_3 = this.getPaddingLeft();
        var4_4 = this.getWidth() - this.getPaddingRight();
        var5_5 = this.getHeight() - this.getPaddingBottom();
        switch (.a[this.b.ordinal()]) {
            case 4: {
                var5_5 = (int)((float)var5_5 - this.c);
                ** break;
            }
            case 1: {
                var3_3 = (int)((float)var3_3 + this.c);
                ** break;
            }
            case 2: {
                var2_2 = (int)((float)var2_2 + this.c);
            }
lbl15: // 4 sources:
            default: {
                ** GOTO lbl19
            }
            case 3: 
        }
        var4_4 = (int)((float)var4_4 - this.c);
lbl19: // 2 sources:
        super.a(var1, var3_3, var2_2, var4_4, var5_5);
    }

    public void setCaretPosition(LikeBoxCountViewCaretPosition likeBoxCountViewCaretPosition) {
        this.b = likeBoxCountViewCaretPosition;
        switch (.a[likeBoxCountViewCaretPosition.ordinal()]) {
            default: {
                return;
            }
            case 1: {
                super.a(this.h, 0, 0, 0);
                return;
            }
            case 2: {
                super.a(0, this.h, 0, 0);
                return;
            }
            case 3: {
                super.a(0, 0, this.h, 0);
                return;
            }
            case 4: 
        }
        super.a(0, 0, 0, this.h);
    }

    public void setText(String string2) {
        this.a.setText((CharSequence)string2);
    }

    public static final class LikeBoxCountViewCaretPosition
    extends Enum<LikeBoxCountViewCaretPosition> {
        public static final /* enum */ LikeBoxCountViewCaretPosition a = new LikeBoxCountViewCaretPosition();
        public static final /* enum */ LikeBoxCountViewCaretPosition b = new LikeBoxCountViewCaretPosition();
        public static final /* enum */ LikeBoxCountViewCaretPosition c = new LikeBoxCountViewCaretPosition();
        public static final /* enum */ LikeBoxCountViewCaretPosition d = new LikeBoxCountViewCaretPosition();
        private static final /* synthetic */ LikeBoxCountViewCaretPosition[] e;

        static {
            LikeBoxCountViewCaretPosition[] arrlikeBoxCountViewCaretPosition = new LikeBoxCountViewCaretPosition[]{a, b, c, d};
            e = arrlikeBoxCountViewCaretPosition;
        }

        private LikeBoxCountViewCaretPosition() {
            super(string2, n2);
        }

        public static LikeBoxCountViewCaretPosition valueOf(String string2) {
            return (LikeBoxCountViewCaretPosition)Enum.valueOf((Class)LikeBoxCountViewCaretPosition.class, (String)string2);
        }

        public static LikeBoxCountViewCaretPosition[] values() {
            return (LikeBoxCountViewCaretPosition[])e.clone();
        }
    }

}

