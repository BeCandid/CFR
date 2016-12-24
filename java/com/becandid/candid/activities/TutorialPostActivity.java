/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.support.v4.app.FragmentActivity
 *  android.support.v4.app.FragmentManager
 *  android.support.v4.view.ViewPager
 *  android.support.v4.view.ViewPager$e
 *  android.widget.ImageView
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  java.lang.Object
 */
package com.becandid.candid.activities;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class TutorialPostActivity
extends FragmentActivity {
    private ev a;
    @BindView(value=2131624308)
    ImageView ind1;
    @BindView(value=2131624309)
    ImageView ind2;
    @BindView(value=2131624310)
    ImageView ind3;
    @BindView(value=2131624311)
    ImageView ind4;
    @BindView(value=2131624307)
    ViewPager viewPager;

    public void onBackPressed() {
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130968634);
        ButterKnife.bind((Activity)this);
        this.a = new hr(this.getSupportFragmentManager());
        this.viewPager.setAdapter(this.a);
        this.viewPager.a(new ViewPager.e(){

            public void onPageScrollStateChanged(int n2) {
            }

            public void onPageScrolled(int n2, float f2, int n3) {
            }

            public void onPageSelected(int n2) {
                Drawable drawable = TutorialPostActivity.this.getResources().getDrawable(2130838092);
                Drawable drawable2 = TutorialPostActivity.this.getResources().getDrawable(2130838088);
                TutorialPostActivity.this.ind1.setImageDrawable(drawable2);
                TutorialPostActivity.this.ind2.setImageDrawable(drawable2);
                TutorialPostActivity.this.ind3.setImageDrawable(drawable2);
                TutorialPostActivity.this.ind4.setImageDrawable(drawable2);
                switch (n2) {
                    default: {
                        return;
                    }
                    case 0: {
                        TutorialPostActivity.this.ind1.setImageDrawable(drawable);
                        return;
                    }
                    case 1: {
                        TutorialPostActivity.this.ind2.setImageDrawable(drawable);
                        return;
                    }
                    case 2: {
                        TutorialPostActivity.this.ind3.setImageDrawable(drawable);
                        return;
                    }
                    case 3: 
                }
                TutorialPostActivity.this.ind4.setImageDrawable(drawable);
            }
        });
    }

}

