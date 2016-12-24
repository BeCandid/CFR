/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  java.lang.Math
 *  java.lang.Object
 */
package org.apmem.tools.layouts;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

class LayoutConfiguration {
    private int a = 0;
    private boolean b = false;
    private float c = 0.0f;
    private int d = 51;
    private int e = 0;

    public LayoutConfiguration(Context context, AttributeSet attributeSet) {
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, aph.a.FlowLayout);
        try {
            this.a(typedArray.getInteger(aph.a.FlowLayout_android_orientation, 0));
            this.a(typedArray.getBoolean(aph.a.FlowLayout_debugDraw, false));
            this.a(typedArray.getFloat(aph.a.FlowLayout_weightDefault, 0.0f));
            this.b(typedArray.getInteger(aph.a.FlowLayout_android_gravity, 0));
            this.c(typedArray.getInteger(aph.a.FlowLayout_layoutDirection, 0));
            return;
        }
        finally {
            typedArray.recycle();
        }
    }

    public int a() {
        return this.a;
    }

    public void a(float f2) {
        this.c = Math.max((float)0.0f, (float)f2);
    }

    public void a(int n2) {
        if (n2 == 1) {
            this.a = n2;
            return;
        }
        this.a = 0;
    }

    public void a(boolean bl2) {
        this.b = bl2;
    }

    public void b(int n2) {
        this.d = n2;
    }

    public boolean b() {
        return this.b;
    }

    public float c() {
        return this.c;
    }

    public void c(int n2) {
        if (n2 == 1) {
            this.e = n2;
            return;
        }
        this.e = 0;
    }

    public int d() {
        return this.d;
    }

    public int e() {
        return this.e;
    }
}

