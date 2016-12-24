/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.support.v4.widget.NestedScrollView
 *  android.util.AttributeSet
 *  java.lang.Object
 */
package com.becandid.candid.views;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;

public class EndlessScrollView
extends NestedScrollView {
    private a a;

    public EndlessScrollView(Context context) {
        super(context);
    }

    public EndlessScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EndlessScrollView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
    }

    protected void onScrollChanged(int n2, int n3, int n4, int n5) {
        super.onScrollChanged(n2, n3, n4, n5);
        if (this.a != null) {
            this.a.a((EndlessScrollView)this, n2, n3, n4, n5);
        }
    }

    public void setScrollViewListener(a a2) {
        this.a = a2;
    }

    public static interface a {
        public void a(EndlessScrollView var1, int var2, int var3, int var4, int var5);
    }

}

