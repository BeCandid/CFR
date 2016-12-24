/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Bundle
 *  android.support.v7.app.ActionBar
 *  android.support.v7.widget.GridLayoutManager
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$Adapter
 *  android.support.v7.widget.RecyclerView$LayoutManager
 *  android.support.v7.widget.Toolbar
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.animation.Animation
 *  android.view.animation.AnimationUtils
 *  android.widget.FrameLayout
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.becandid.candid.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.views.BadgeInfoView;

public class SeeAllBadgesActivity
extends BaseActivity {
    private BadgeInfoView b;
    @BindView(value=2131624287)
    FrameLayout mBadgeInfoContainer;
    @BindView(value=2131624286)
    RecyclerView mRecyclerView;

    public void onBackPressed() {
        super.onBackPressed();
        this.mRecyclerView.setVisibility(0);
        this.mBadgeInfoContainer.removeView((View)this.b);
        this.mBadgeInfoContainer.setVisibility(8);
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130968629);
        ButterKnife.bind((Activity)this);
        this.setSupportActionBar((Toolbar)this.findViewById(2131624081));
        this.getSupportActionBar().setDisplayShowTitleEnabled(false);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setHomeAsUpIndicator(2130837589);
        GridLayoutManager gridLayoutManager = new GridLayoutManager((Context)this, 3);
        this.mRecyclerView.setHasFixedSize(true);
        this.mRecyclerView.setLayoutManager((RecyclerView.LayoutManager)gridLayoutManager);
        hc hc2 = new hc((Activity)this);
        this.mRecyclerView.setAdapter((RecyclerView.Adapter)hc2);
        this.addToSubscriptionList(ix.a().a(in.c.class, new apr<in.c>(){

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
            }

            @Override
            public void onNext(in.c c2) {
                String string2 = c2.a;
                String string3 = c2.b;
                SeeAllBadgesActivity.this.b = new BadgeInfoView(SeeAllBadgesActivity.this.getBaseContext(), string3, false, string2);
                SeeAllBadgesActivity.this.mBadgeInfoContainer.setVisibility(0);
                SeeAllBadgesActivity.this.mRecyclerView.setVisibility(8);
                SeeAllBadgesActivity.this.mBadgeInfoContainer.addView((View)SeeAllBadgesActivity.this.b);
                Animation animation = AnimationUtils.loadAnimation((Context)SeeAllBadgesActivity.this.getBaseContext(), (int)2131034137);
                animation.setDuration(500);
                final View view = SeeAllBadgesActivity.this.mBadgeInfoContainer.findViewById(2131624074);
                view.startAnimation(animation);
                SeeAllBadgesActivity.this.mBadgeInfoContainer.setOnClickListener(new View.OnClickListener(){

                    public void onClick(View view2) {
                        Animation animation = AnimationUtils.loadAnimation((Context)SeeAllBadgesActivity.this.getBaseContext(), (int)2131034132);
                        animation.setDuration(500);
                        view.startAnimation(animation);
                        view2.postDelayed(new Runnable(){

                            public void run() {
                                SeeAllBadgesActivity.this.mRecyclerView.setVisibility(0);
                                SeeAllBadgesActivity.this.mBadgeInfoContainer.removeView((View)SeeAllBadgesActivity.this.b);
                                SeeAllBadgesActivity.this.mBadgeInfoContainer.setVisibility(8);
                            }
                        }, 500);
                    }

                });
                AppState.blurTaskCalledOnFlight = false;
            }

        }));
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            this.onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

}

