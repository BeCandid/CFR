/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.animation.Animation
 *  android.view.animation.AnimationUtils
 *  android.widget.FrameLayout
 *  java.lang.Class
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.becandid.candid.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.User;
import com.becandid.candid.views.BadgeInfoView;
import com.becandid.candid.views.MessagingPopupView;
import com.becandid.candid.views.ModeratorInfoView;
import com.becandid.candid.views.NicknamePopupView;
import com.becandid.candid.views.QualityScoreInfoView;
import com.becandid.thirdparty.BlurTask;

public abstract class PopupWithBlurBackgroundActivity
extends BaseActivity {
    private boolean b = true;
    private int c = 500;
    protected boolean mIsShowingMessagingPopup;

    static /* synthetic */ int a(PopupWithBlurBackgroundActivity popupWithBlurBackgroundActivity) {
        return popupWithBlurBackgroundActivity.c;
    }

    static /* synthetic */ boolean a(PopupWithBlurBackgroundActivity popupWithBlurBackgroundActivity, boolean bl2) {
        popupWithBlurBackgroundActivity.b = bl2;
        return bl2;
    }

    public abstract void hideCurrentScreen();

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.addToSubscriptionList(ix.a().a(in.b.class, new apr<in.b>((Activity)this){
            final /* synthetic */ Activity a;

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
            }

            /*
             * Unable to fully structure code
             * Enabled aggressive block sorting
             * Lifted jumps to return sites
             */
            @Override
            public void onNext(in.b var1) {
                var2_2 = var1.a;
                var3_3 = var1.b;
                var4_4 = .a[var3_3.ordinal()];
                var5_5 = null;
                switch (var4_4) {
                    case 1: {
                        var5_7 = new BadgeInfoView((Context)this.a, AppState.account.badge_status, true, var2_2);
                        ** break;
                    }
                    case 2: {
                        var5_8 = new ModeratorInfoView((Context)this.a, var2_2, var1.d, var1.e);
                        ** break;
                    }
                    case 3: {
                        var5_9 = new QualityScoreInfoView(this.a, var2_2, var1.c, var1.d, var1.e);
                        ** break;
                    }
                    case 4: {
                        var5_10 = new QualityScoreInfoView(this.a, var2_2, var1.c);
                        ** break;
                    }
                    case 5: {
                        var5_11 = new MessagingPopupView((Context)this.a, var2_2, true);
                        PopupWithBlurBackgroundActivity.a(PopupWithBlurBackgroundActivity.this, false);
                        ** break;
                    }
                    case 6: {
                        var5_12 = new MessagingPopupView((Context)this.a, var2_2, false);
                        PopupWithBlurBackgroundActivity.a(PopupWithBlurBackgroundActivity.this, false);
                        ** break;
                    }
                    case 7: {
                        var5_13 = new NicknamePopupView((Context)this.a, var2_2, false);
                        PopupWithBlurBackgroundActivity.a(PopupWithBlurBackgroundActivity.this, false);
                    }
lbl29: // 8 sources:
                    default: {
                        ** GOTO lbl34
                    }
                    case 8: 
                }
                var5_14 = new NicknamePopupView((Context)this.a, var2_2, true);
                PopupWithBlurBackgroundActivity.a(PopupWithBlurBackgroundActivity.this, false);
lbl34: // 2 sources:
                var7_15 = (FrameLayout)PopupWithBlurBackgroundActivity.this.findViewById(2131624178);
                var7_15.setVisibility(0);
                var7_15.addView((View)var5_6);
                var8_16 = AnimationUtils.loadAnimation((Context)PopupWithBlurBackgroundActivity.this.getApplicationContext(), (int)2131034137);
                var8_16.setDuration((long)PopupWithBlurBackgroundActivity.a(PopupWithBlurBackgroundActivity.this));
                var7_15.findViewById(2131624074).startAnimation(var8_16);
                var7_15.setOnClickListener(new View.OnClickListener(){

                    public void onClick(View view) {
                        if (PopupWithBlurBackgroundActivity.this.b) {
                            view.setOnClickListener(null);
                            PopupWithBlurBackgroundActivity.this.slideOutAnimation(view);
                        }
                    }
                });
                PopupWithBlurBackgroundActivity.this.hideCurrentScreen();
            }

        }));
    }

    protected void onPause() {
        super.onPause();
        if (!this.b) {
            ix.a().a(new in.f());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        View view = this.findViewById(2131624178);
        if (view != null) {
            view.setVisibility(8);
        }
        this.showCurrentScreen();
        if (!this.b) {
            ix.a().a(new in.f());
        }
    }

    public abstract void showCurrentScreen();

    public void slideOutAnimation(final View view) {
        Animation animation = AnimationUtils.loadAnimation((Context)this, (int)2131034132);
        animation.setDuration((long)this.c);
        View view2 = ((FrameLayout)this.findViewById(2131624178)).findViewById(2131624074);
        if (view2 != null) {
            view2.startAnimation(animation);
        }
        view.postDelayed(new Runnable(){

            public void run() {
                ((FrameLayout)PopupWithBlurBackgroundActivity.this.findViewById(2131624178)).removeAllViews();
                view.setVisibility(8);
                PopupWithBlurBackgroundActivity.this.showCurrentScreen();
                AppState.blurTaskCalledOnFlight = false;
            }
        }, (long)this.c);
        this.mIsShowingMessagingPopup = false;
        if (!this.b) {
            ix.a().a(new in.f());
        }
    }

}

