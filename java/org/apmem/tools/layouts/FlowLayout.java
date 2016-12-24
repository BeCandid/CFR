/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.util.AttributeSet
 *  android.view.Gravity
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewDebug
 *  android.view.ViewDebug$ExportedProperty
 *  android.view.ViewDebug$IntToString
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Method
 *  java.util.ArrayList
 *  java.util.List
 */
package org.apmem.tools.layouts;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.apmem.tools.layouts.LayoutConfiguration;

public class FlowLayout
extends ViewGroup {
    List<apg> a = new ArrayList();
    private final LayoutConfiguration b;

    public FlowLayout(Context context) {
        super(context);
        this.b = new LayoutConfiguration(context, null);
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new LayoutConfiguration(context, attributeSet);
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.b = new LayoutConfiguration(context, attributeSet);
    }

    /*
     * Enabled aggressive block sorting
     */
    private int a(int n2) {
        int n3 = 3;
        if (this.b.a() == 1 && (n2 & 8388608) == 0) {
            int n4 = n2;
            n2 = 0 | (n4 & 7) >> 0 << 4 | (n4 & 112) >> 4 << 0;
        }
        if (this.b.e() != 1) return n2;
        if ((n2 & 8388608) == 0) return n2;
        int n5 = n2;
        int n6 = (n5 & 3) == n3 ? 5 : 0;
        int n7 = 0 | n6;
        if ((n5 & 5) == 5) return n7 | n3;
        n3 = 0;
        return n7 | n3;
    }

    private int a(int n2, int n3, int n4) {
        switch (n2) {
            default: {
                return n4;
            }
            case 0: {
                return n4;
            }
            case Integer.MIN_VALUE: {
                return Math.min((int)n4, (int)n3);
            }
            case 1073741824: 
        }
        return n3;
    }

    /*
     * Enabled aggressive block sorting
     */
    private int a(LayoutParams layoutParams) {
        int n2 = this.b.d();
        int n3 = layoutParams != null && layoutParams.a() ? layoutParams.i() : n2;
        int n4 = super.a(n3);
        int n5 = super.a(n2);
        if ((n4 & 7) == 0) {
            n4 |= n5 & 7;
        }
        if ((n4 & 112) == 0) {
            n4 |= n5 & 112;
        }
        if ((n4 & 7) == 0) {
            n4 |= 3;
        }
        if ((n4 & 112) == 0) {
            n4 |= 48;
        }
        return n4;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void a(Canvas canvas, View view) {
        if (!this.b()) {
            return;
        }
        Paint paint = super.b(-256);
        Paint paint2 = super.b(-65536);
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (layoutParams.rightMargin > 0) {
            float f2 = view.getRight();
            float f3 = (float)view.getTop() + (float)view.getHeight() / 2.0f;
            canvas.drawLine(f2, f3, f2 + (float)layoutParams.rightMargin, f3, paint);
            canvas.drawLine(f2 + (float)layoutParams.rightMargin - 4.0f, f3 - 4.0f, f2 + (float)layoutParams.rightMargin, f3, paint);
            canvas.drawLine(f2 + (float)layoutParams.rightMargin - 4.0f, f3 + 4.0f, f2 + (float)layoutParams.rightMargin, f3, paint);
        }
        if (layoutParams.leftMargin > 0) {
            float f4 = view.getLeft();
            float f5 = (float)view.getTop() + (float)view.getHeight() / 2.0f;
            canvas.drawLine(f4, f5, f4 - (float)layoutParams.leftMargin, f5, paint);
            canvas.drawLine(4.0f + (f4 - (float)layoutParams.leftMargin), f5 - 4.0f, f4 - (float)layoutParams.leftMargin, f5, paint);
            canvas.drawLine(4.0f + (f4 - (float)layoutParams.leftMargin), f5 + 4.0f, f4 - (float)layoutParams.leftMargin, f5, paint);
        }
        if (layoutParams.bottomMargin > 0) {
            float f6 = (float)view.getLeft() + (float)view.getWidth() / 2.0f;
            float f7 = view.getBottom();
            canvas.drawLine(f6, f7, f6, f7 + (float)layoutParams.bottomMargin, paint);
            canvas.drawLine(f6 - 4.0f, f7 + (float)layoutParams.bottomMargin - 4.0f, f6, f7 + (float)layoutParams.bottomMargin, paint);
            canvas.drawLine(f6 + 4.0f, f7 + (float)layoutParams.bottomMargin - 4.0f, f6, f7 + (float)layoutParams.bottomMargin, paint);
        }
        if (layoutParams.topMargin > 0) {
            float f8 = (float)view.getLeft() + (float)view.getWidth() / 2.0f;
            float f9 = view.getTop();
            canvas.drawLine(f8, f9, f8, f9 - (float)layoutParams.topMargin, paint);
            canvas.drawLine(f8 - 4.0f, 4.0f + (f9 - (float)layoutParams.topMargin), f8, f9 - (float)layoutParams.topMargin, paint);
            canvas.drawLine(f8 + 4.0f, 4.0f + (f9 - (float)layoutParams.topMargin), f8, f9 - (float)layoutParams.topMargin, paint);
        }
        if (!layoutParams.k()) return;
        if (this.b.a() == 0) {
            float f10 = view.getLeft();
            float f11 = (float)view.getTop() + (float)view.getHeight() / 2.0f;
            canvas.drawLine(f10, f11 - 6.0f, f10, f11 + 6.0f, paint2);
            return;
        }
        float f12 = (float)view.getLeft() + (float)view.getWidth() / 2.0f;
        float f13 = view.getTop();
        canvas.drawLine(f12 - 6.0f, f13, f12 + 6.0f, f13, paint2);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(apg apg2) {
        List<View> list = apg2.e();
        int n2 = list.size();
        int n3 = 0;
        while (n3 < n2) {
            View view = (View)list.get(n3);
            LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
            if (this.b.a() == 0) {
                layoutParams.a(this.getPaddingLeft() + apg2.d() + layoutParams.c(), this.getPaddingTop() + apg2.a() + layoutParams.f());
                view.measure(View.MeasureSpec.makeMeasureSpec((int)layoutParams.d(), (int)1073741824), View.MeasureSpec.makeMeasureSpec((int)layoutParams.e(), (int)1073741824));
            } else {
                layoutParams.a(this.getPaddingLeft() + apg2.a() + layoutParams.f(), this.getPaddingTop() + apg2.d() + layoutParams.c());
                view.measure(View.MeasureSpec.makeMeasureSpec((int)layoutParams.e(), (int)1073741824), View.MeasureSpec.makeMeasureSpec((int)layoutParams.d(), (int)1073741824));
            }
            ++n3;
        }
    }

    private void a(List<apg> list) {
        int n2 = 0;
        int n3 = list.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            apg apg2 = (apg)list.get(i2);
            apg2.a(n2);
            n2 += apg2.b();
            int n4 = 0;
            List<View> list2 = apg2.e();
            int n5 = list2.size();
            for (int i3 = 0; i3 < n5; ++i3) {
                LayoutParams layoutParams = (LayoutParams)((View)list2.get(i3)).getLayoutParams();
                layoutParams.a(n4);
                n4 += layoutParams.d() + layoutParams.g();
            }
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void a(List<apg> list, int n2, int n3) {
        int n4 = list.size();
        if (n4 <= 0) {
            return;
        }
        apg apg2 = (apg)list.get(n4 - 1);
        int n5 = n3 - (apg2.b() + apg2.a());
        if (n5 < 0) {
            n5 = 0;
        }
        int n6 = 0;
        int n7 = 0;
        while (n7 < n4) {
            apg apg3 = (apg)list.get(n7);
            int n8 = super.a((LayoutParams)null);
            int n9 = Math.round((float)(n5 * 1 / n4));
            int n10 = apg3.c();
            int n11 = apg3.b();
            Rect rect = new Rect();
            rect.top = n6;
            rect.left = 0;
            rect.right = n2;
            rect.bottom = n6 + (n11 + n9);
            Rect rect2 = new Rect();
            Gravity.apply((int)n8, (int)n10, (int)n11, (Rect)rect, (Rect)rect2);
            n6 += n9;
            apg3.b(apg3.d() + rect2.left);
            apg3.a(apg3.a() + rect2.top);
            apg3.d(rect2.width());
            apg3.c(rect2.height());
            ++n7;
        }
    }

    private float b(LayoutParams layoutParams) {
        if (layoutParams.b()) {
            return layoutParams.j();
        }
        return this.b.c();
    }

    private Paint b(int n2) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(n2);
        paint.setStrokeWidth(2.0f);
        return paint;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void b(apg apg2) {
        List<View> list = apg2.e();
        int n2 = list.size();
        if (n2 <= 0) {
            return;
        }
        float f2 = 0.0f;
        for (int i2 = 0; i2 < n2; f2 += super.b((LayoutParams)((LayoutParams)((View)list.get((int)i2)).getLayoutParams())), ++i2) {
        }
        LayoutParams layoutParams = (LayoutParams)((View)list.get(n2 - 1)).getLayoutParams();
        int n3 = apg2.c() - (layoutParams.d() + layoutParams.g() + layoutParams.c());
        int n4 = 0;
        int n5 = 0;
        while (n5 < n2) {
            LayoutParams layoutParams2 = (LayoutParams)((View)list.get(n5)).getLayoutParams();
            float f3 = super.b(layoutParams2);
            int n6 = super.a(layoutParams2);
            int n7 = f2 == 0.0f ? n3 / n2 : Math.round((float)(f3 * (float)n3 / f2));
            int n8 = layoutParams2.d() + layoutParams2.g();
            int n9 = layoutParams2.e() + layoutParams2.h();
            Rect rect = new Rect();
            rect.top = 0;
            rect.left = n4;
            rect.right = n4 + (n8 + n7);
            rect.bottom = apg2.b();
            Rect rect2 = new Rect();
            Gravity.apply((int)n6, (int)n8, (int)n9, (Rect)rect, (Rect)rect2);
            n4 += n7;
            layoutParams2.a(rect2.left + layoutParams2.c());
            layoutParams2.d(rect2.top);
            layoutParams2.b(rect2.width() - layoutParams2.g());
            layoutParams2.c(rect2.height() - layoutParams2.h());
            ++n5;
        }
    }

    private boolean c() {
        try {
            Method method = ViewGroup.class.getDeclaredMethod("debugDraw", (Class[])null);
            method.setAccessible(true);
            boolean bl2 = (Boolean)method.invoke((Object)this, new Object[]{null});
            return bl2;
        }
        catch (Exception var1_3) {
            return false;
        }
    }

    protected LayoutParams a() {
        return new LayoutParams(-2, -2);
    }

    public LayoutParams a(AttributeSet attributeSet) {
        return new LayoutParams(this.getContext(), attributeSet);
    }

    protected LayoutParams a(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public boolean b() {
        if (this.b.b() || this.c()) {
            return true;
        }
        return false;
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    protected boolean drawChild(Canvas canvas, View view, long l2) {
        boolean bl2 = super.drawChild(canvas, view, l2);
        super.a(canvas, view);
        return bl2;
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return this.a();
    }

    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return this.a(attributeSet);
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return this.a(layoutParams);
    }

    public int getGravity() {
        return this.b.d();
    }

    public int getLayoutDirection() {
        if (this.b == null) {
            return 0;
        }
        return this.b.e();
    }

    public int getOrientation() {
        return this.b.a();
    }

    public float getWeightDefault() {
        return this.b.c();
    }

    protected void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
        int n6 = this.getChildCount();
        for (int i2 = 0; i2 < n6; ++i2) {
            View view = this.getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
            view.layout(layoutParams.h + layoutParams.leftMargin, layoutParams.i + layoutParams.topMargin, layoutParams.h + layoutParams.leftMargin + view.getMeasuredWidth(), layoutParams.i + layoutParams.topMargin + view.getMeasuredHeight());
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    protected void onMeasure(int n2, int n3) {
        int n4;
        int n5;
        int n6 = View.MeasureSpec.getSize((int)n2) - this.getPaddingRight() - this.getPaddingLeft();
        int n7 = View.MeasureSpec.getSize((int)n3) - this.getPaddingTop() - this.getPaddingBottom();
        int n8 = View.MeasureSpec.getMode((int)n2);
        int n9 = View.MeasureSpec.getMode((int)n3);
        int n10 = this.b.a() == 0 ? n6 : n7;
        int n11 = this.b.a() == 0 ? n7 : n6;
        int n12 = this.b.a() == 0 ? n8 : n9;
        if (this.b.a() == 0) {
            // empty if block
        }
        this.a.clear();
        apg apg2 = new apg(n10);
        this.a.add((Object)apg2);
        int n13 = this.getChildCount();
        for (int i2 = 0; i2 < n13; ++i2) {
            View view = this.getChildAt(i2);
            if (view.getVisibility() == 8) continue;
            LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
            view.measure(FlowLayout.getChildMeasureSpec((int)n2, (int)(this.getPaddingLeft() + this.getPaddingRight()), (int)layoutParams.width), FlowLayout.getChildMeasureSpec((int)n3, (int)(this.getPaddingTop() + this.getPaddingBottom()), (int)layoutParams.height));
            layoutParams.j = this.b.a();
            if (this.b.a() == 0) {
                layoutParams.b(view.getMeasuredWidth());
                layoutParams.c(view.getMeasuredHeight());
            } else {
                layoutParams.b(view.getMeasuredHeight());
                layoutParams.c(view.getMeasuredWidth());
            }
            boolean bl2 = layoutParams.k() || n12 != 0 && !apg2.b(view);
            if (bl2) {
                apg2 = new apg(n10);
                if (this.b.a() == 1 && this.b.e() == 1) {
                    this.a.add(0, (Object)apg2);
                } else {
                    this.a.add((Object)apg2);
                }
            }
            if (this.b.a() == 0 && this.b.e() == 1) {
                apg2.a(0, view);
                continue;
            }
            apg2.a(view);
        }
        super.a(this.a);
        int n14 = 0;
        int n15 = this.a.size();
        for (int i3 = 0; i3 < n15; ++i3) {
            n14 = Math.max((int)n14, (int)((apg)this.a.get(i3)).c());
        }
        int n16 = apg2.a() + apg2.b();
        int n17 = super.a(n12, n10, n14);
        int n18 = super.a(n9, n11, n16);
        super.a(this.a, n17, n18);
        for (int i4 = 0; i4 < n15; ++i4) {
            apg apg3 = (apg)this.a.get(i4);
            super.b(apg3);
            super.a(apg3);
        }
        int n19 = this.getPaddingLeft() + this.getPaddingRight();
        int n20 = this.getPaddingBottom() + this.getPaddingTop();
        if (this.b.a() == 0) {
            n5 = n19 + n14;
            n4 = n20 + n16;
        } else {
            n5 = n19 + n16;
            n4 = n20 + n14;
        }
        this.setMeasuredDimension(FlowLayout.resolveSize((int)n5, (int)n2), FlowLayout.resolveSize((int)n4, (int)n3));
    }

    public void setDebugDraw(boolean bl2) {
        this.b.a(bl2);
        this.invalidate();
    }

    public void setGravity(int n2) {
        this.b.b(n2);
        this.requestLayout();
    }

    public void setLayoutDirection(int n2) {
        this.b.c(n2);
        this.requestLayout();
    }

    public void setOrientation(int n2) {
        this.b.a(n2);
        this.requestLayout();
    }

    public void setWeightDefault(float f2) {
        this.b.a(f2);
        this.requestLayout();
    }

    public static class LayoutParams
    extends ViewGroup.MarginLayoutParams {
        @ViewDebug.ExportedProperty(mapping={@ViewDebug.IntToString(from=0, to="NONE"), @ViewDebug.IntToString(from=48, to="TOP"), @ViewDebug.IntToString(from=80, to="BOTTOM"), @ViewDebug.IntToString(from=3, to="LEFT"), @ViewDebug.IntToString(from=5, to="RIGHT"), @ViewDebug.IntToString(from=16, to="CENTER_VERTICAL"), @ViewDebug.IntToString(from=112, to="FILL_VERTICAL"), @ViewDebug.IntToString(from=1, to="CENTER_HORIZONTAL"), @ViewDebug.IntToString(from=7, to="FILL_HORIZONTAL"), @ViewDebug.IntToString(from=17, to="CENTER"), @ViewDebug.IntToString(from=119, to="FILL")})
        private boolean a = false;
        private int b = 0;
        private float c = -1.0f;
        private int d;
        private int e;
        private int f;
        private int g;
        private int h;
        private int i;
        private int j;

        public LayoutParams(int n2, int n3) {
            super(n2, n3);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            super.a(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        private void a(Context context, AttributeSet attributeSet) {
            TypedArray typedArray = context.obtainStyledAttributes(attributeSet, aph.a.FlowLayout_LayoutParams);
            try {
                this.a = typedArray.getBoolean(aph.a.FlowLayout_LayoutParams_layout_newLine, false);
                this.b = typedArray.getInt(aph.a.FlowLayout_LayoutParams_android_layout_gravity, 0);
                this.c = typedArray.getFloat(aph.a.FlowLayout_LayoutParams_layout_weight, -1.0f);
                return;
            }
            finally {
                typedArray.recycle();
            }
        }

        void a(int n2) {
            this.d = n2;
        }

        void a(int n2, int n3) {
            this.h = n2;
            this.i = n3;
        }

        public boolean a() {
            if (this.b != 0) {
                return true;
            }
            return false;
        }

        void b(int n2) {
            this.e = n2;
        }

        public boolean b() {
            if (this.c >= 0.0f) {
                return true;
            }
            return false;
        }

        int c() {
            return this.d;
        }

        void c(int n2) {
            this.f = n2;
        }

        public int d() {
            return this.e;
        }

        void d(int n2) {
            this.g = n2;
        }

        public int e() {
            return this.f;
        }

        int f() {
            return this.g;
        }

        public int g() {
            if (this.j == 0) {
                return this.leftMargin + this.rightMargin;
            }
            return this.topMargin + this.bottomMargin;
        }

        public int h() {
            if (this.j == 0) {
                return this.topMargin + this.bottomMargin;
            }
            return this.leftMargin + this.rightMargin;
        }

        public int i() {
            return this.b;
        }

        public float j() {
            return this.c;
        }

        public boolean k() {
            return this.a;
        }
    }

}

