/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.support.v4.view.ViewPager
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  java.lang.Object
 *  java.lang.String
 */
package com.becandid.candid.views;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Config;

public class TabViewPager
extends ViewPager {
    private Context a;
    private String b;

    public TabViewPager(Context context) {
        super(context);
        this.a = context;
    }

    public TabViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = context;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.b != null && this.b.equals((Object)"feed") && AppState.config.getInt("feed_swipe_enabled", 0) == 1) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        String string2 = this.b;
        boolean bl2 = false;
        if (string2 == null) return bl2;
        boolean bl3 = this.b.equals((Object)"me");
        bl2 = false;
        if (!bl3) return bl2;
        int n2 = AppState.config.getInt("me_swipe_enabled", 0);
        bl2 = false;
        if (n2 != 1) return bl2;
        return super.onInterceptTouchEvent(motionEvent);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (AppState.config.getInt("feed_swipe_enabled", 0) == 0) {
            return super.onTouchEvent(motionEvent);
        }
        String string2 = this.b;
        boolean bl2 = false;
        if (string2 == null) return bl2;
        boolean bl3 = this.b.equals((Object)"me");
        bl2 = false;
        if (!bl3) return bl2;
        int n2 = AppState.config.getInt("me_swipe_enabled", 0);
        bl2 = false;
        if (n2 != 1) return bl2;
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setCurrTab(String string2) {
        this.b = string2;
    }
}

