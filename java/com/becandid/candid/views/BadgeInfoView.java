/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Color
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.becandid.candid.views;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.views.BlurLayout;

public class BadgeInfoView
extends BlurLayout {
    private String b;
    private a c;
    @BindView(value=2131624075)
    View mBadgeContainer;
    @BindView(value=2131624077)
    TextView mBadgeDesc;
    @BindView(value=2131624079)
    ImageView mBadgeIcon;
    @BindView(value=2131624076)
    TextView mBadgeTitle;
    @BindView(value=2131624078)
    View seeAllBadges;

    public BadgeInfoView(Context context, String string2, boolean bl2, String string3) {
        super(context);
        this.b = string2;
        this.a = string3;
        LayoutInflater.from((Context)context).inflate(2130968602, (ViewGroup)this, true);
        ButterKnife.bind((View)this);
        this.a();
        ig.a a2 = ig.a().a(this.b);
        if (a2 != null) {
            this.mBadgeIcon.setImageResource(a2.c);
            this.mBadgeTitle.setText((CharSequence)a2.b);
            this.mBadgeDesc.setText((CharSequence)a2.d);
            this.mBadgeTitle.setTextColor(Color.parseColor((String)a2.e));
        }
        jb.a(this.mBadgeContainer, "#ffffff");
        if (bl2) {
            this.seeAllBadges.setVisibility(0);
            this.seeAllBadges.setOnClickListener(new View.OnClickListener(){

                public void onClick(View view) {
                    BadgeInfoView.this.c.k();
                }
            });
            return;
        }
        this.seeAllBadges.setVisibility(8);
    }

    public void setSeeAllBadgesListener(a a2) {
        this.c = a2;
    }

    public static interface a {
        public void k();
    }

}

