/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.TextView
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  java.lang.CharSequence
 *  java.lang.String
 */
package com.becandid.candid.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.views.BlurLayout;

public class ModeratorInfoView
extends BlurLayout {
    @BindView(value=2131624075)
    View mBadgeContainer;
    @BindView(value=2131624077)
    TextView mModDesc;
    @BindView(value=2131624076)
    TextView mModTitle;

    public ModeratorInfoView(Context context, String string2, String string3, String string4) {
        super(context);
        this.a = string2;
        LayoutInflater.from((Context)context).inflate(2130968710, (ViewGroup)this, true);
        ButterKnife.bind((View)this);
        this.a();
        jb.a(this.mBadgeContainer, "#ffffff");
        this.mModTitle.setText((CharSequence)string3);
        this.mModDesc.setText((CharSequence)string4);
    }
}

