/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.RelativeLayout
 *  butterknife.ButterKnife
 *  butterknife.OnClick
 *  java.lang.Class
 */
package com.becandid.candid.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.becandid.candid.activities.CreateGroupActivity;
import com.becandid.candid.activities.GroupSearchActivity;
import com.becandid.candid.activities.MainTabsActivity;

public class GroupHeaderView
extends RelativeLayout {
    public GroupHeaderView(Context context) {
        super(context);
        this.a(context);
    }

    public GroupHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a(context);
    }

    public GroupHeaderView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.a(context);
    }

    public void a(Context context) {
        LayoutInflater.from((Context)context).inflate(2130968689, (ViewGroup)this, true);
        ButterKnife.bind((View)this);
    }

    @OnClick(value={2131624498})
    public void onCreateGroupClick(View view) {
        Activity activity = (Activity)view.getContext();
        if (activity instanceof MainTabsActivity) {
            activity.startActivityForResult(new Intent((Context)activity, (Class)CreateGroupActivity.class), 1001);
        }
    }

    @OnClick(value={2131624497})
    public void onGroupSearchClick(View view) {
        Intent intent = new Intent(this.getContext(), (Class)GroupSearchActivity.class);
        this.getContext().startActivity(intent);
    }
}

