/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.TextView
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.becandid.candid.views;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.activities.PopupWithBlurBackgroundActivity;
import com.becandid.candid.views.BlurLayout;

public class QualityScoreInfoView
extends BlurLayout {
    @BindView(value=2131624075)
    View mBadgeContainer;
    @BindView(value=2131624796)
    Button mClosePopup;
    @BindView(value=2131624077)
    TextView mScoreDesc;
    @BindView(value=2131624528)
    TextView mScoreText;
    @BindView(value=2131624076)
    TextView mScoreTitle;

    public QualityScoreInfoView(Activity activity, String string2, String string3) {
        super((Context)activity);
        this.a = string2;
        LayoutInflater.from((Context)activity).inflate(2130968695, (ViewGroup)this, true);
        ButterKnife.bind((View)this);
        this.a();
        jb.a(this.mBadgeContainer, "#ffffff");
        this.mScoreText.setText((CharSequence)string3);
    }

    public QualityScoreInfoView(final Activity activity, String string2, String string3, String string4, String string5) {
        super((Context)activity);
        this.a = string2;
        LayoutInflater.from((Context)activity).inflate(2130968737, (ViewGroup)this, true);
        ButterKnife.bind((View)this);
        this.a();
        jb.a(this.mBadgeContainer, "#ffffff");
        this.mScoreText.setText((CharSequence)string3);
        this.mScoreTitle.setText((CharSequence)string4);
        this.mScoreDesc.setText((CharSequence)string5);
        this.mClosePopup.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                ((PopupWithBlurBackgroundActivity)activity).slideOutAnimation(view);
            }
        });
    }

}

