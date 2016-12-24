/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$ViewHolder
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.TextView
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  java.lang.Object
 */
package com.becandid.candid.views.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class LinkSearchViewholder
extends RecyclerView.ViewHolder {
    @BindView(value=2131624518)
    public TextView linkDesc;
    @BindView(value=2131624519)
    public TextView linkHost;
    @BindView(value=2131624515)
    public ImageView linkImage;
    @BindView(value=2131624516)
    public ImageView linkSearchResultIcon;
    @BindView(value=2131624517)
    public TextView linkTitle;

    public LinkSearchViewholder(View view) {
        super(view);
        ButterKnife.bind((Object)this, (View)view);
    }
}

