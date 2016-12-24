/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 */
package com.becandid.candid.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class TabView
extends RelativeLayout {
    protected ViewGroup a;

    public TabView(Context context) {
        super(context);
    }

    protected void setContentView(int n2) {
        this.setContentView(LayoutInflater.from((Context)this.getContext()).inflate(n2, (ViewGroup)this, false));
    }

    protected void setContentView(View view) {
        this.a = (ViewGroup)view;
        this.addView(view);
        view.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    }
}

