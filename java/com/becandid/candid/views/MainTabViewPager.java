/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 */
package com.becandid.candid.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.becandid.candid.views.TabViewPager;

public class MainTabViewPager
extends TabViewPager {
    private boolean a;

    public MainTabViewPager(Context context) {
        super(context);
    }

    public MainTabViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.a && super.onInterceptTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.a && super.onTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public void setSwipeEnabled(boolean bl2) {
        this.a = bl2;
    }
}

