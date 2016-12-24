/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.FragmentManager
 *  android.support.v4.app.FragmentTransaction
 *  android.view.View
 *  android.widget.Toast
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  rx.schedulers.Schedulers
 */
package com.becandid.candid.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Toast;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.activities.MainTabsActivity;
import com.becandid.candid.activities.MeSettingsActivity;
import com.becandid.candid.activities.OnboardingGroupsActivity;
import com.becandid.candid.activities.PostDetailsActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Config;
import com.becandid.candid.data.ContactsInfo;
import com.becandid.candid.data.FacebookInfo;
import com.becandid.candid.fragments.onboarding.OnboardingAgeFragment;
import com.becandid.candid.fragments.onboarding.OnboardingContactsFragment;
import com.becandid.candid.fragments.onboarding.OnboardingFacebookFragment;
import com.becandid.candid.fragments.onboarding.OnboardingLocationFragment;
import com.becandid.candid.fragments.onboarding.OnboardingPhoneFragment;
import com.becandid.candid.fragments.onboarding.OnboardingTagsFragment;
import com.becandid.candid.fragments.onboarding.OnboardingVerifyFragment;
import com.becandid.candid.models.EmptySubscriber;
import com.becandid.candid.models.NetworkData;
import rx.schedulers.Schedulers;

public class OnboardingActivity
extends BaseActivity {
    private boolean b = false;
    private boolean c = false;
    private Bundle d;
    private FragmentManager e;
    private OnboardingFacebookFragment f;
    private OnboardingPhoneFragment g;
    private OnboardingLocationFragment h;
    private OnboardingTagsFragment i;
    private Handler j;
    private int k;
    private int l;
    public String otpCode;

    public void finish() {
        super.finish();
        this.setResult(-1);
    }

    public void finishGetGroups() {
        if (AppState.config.has("skip_groups_onboarding")) {
            if (AppState.config.getInt("skip_groups_onboarding", 0) == 1) {
                ik.a().f().b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        rj.a(throwable);
                        Toast.makeText((Context)OnboardingActivity.this, (CharSequence)"Unable to get get your recommended groups. Please try again", (int)0).show();
                    }

                    @Override
                    public void onNext(NetworkData networkData) {
                        OnboardingActivity.this.finishSyncAccount();
                    }
                });
            }
            return;
        }
        this.startActivity(new Intent((Context)this, (Class)OnboardingGroupsActivity.class));
        this.finish();
    }

    /*
     * Enabled aggressive block sorting
     */
    public void finishSyncAccount() {
        Intent intent;
        ik.a().b().b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
        if (AppState.referralPostId != 0) {
            intent = new Intent((Context)this, (Class)PostDetailsActivity.class);
            intent.putExtra("post_id", AppState.referralPostId);
        } else {
            intent = new Intent((Context)this, (Class)MainTabsActivity.class);
        }
        this.startActivity(intent);
        this.finish();
    }

    public void onBackPressed() {
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    protected void onCreate(Bundle bundle) {
        if (AppState.contactsInfo == null) {
            AppState.contactsInfo = new ContactsInfo();
        }
        super.onCreate(bundle);
        if (AppState.config.has("skip_age_onboarding")) {
            this.l = AppState.config.getInt("skip_age_onboarding", 0);
        }
        if (AppState.config.has("skip_tags_onboarding")) {
            this.k = AppState.config.getInt("skip_tags_onboarding", 0);
        }
        this.j = new Handler(this.getMainLooper());
        this.setContentView(2130968625);
        this.e = this.getSupportFragmentManager();
        this.d = this.getIntent().getExtras();
        if (this.d != null && this.d.containsKey("second_fragment")) {
            this.g = new OnboardingPhoneFragment();
            this.g.setArguments(this.d);
            this.e.beginTransaction().add(2131624257, (Fragment)this.g, "phone").commit();
        } else if (this.d != null && this.d.containsKey(MeSettingsActivity.TAG_SETTINGS_KEY)) {
            this.i = new OnboardingTagsFragment();
            this.i.setArguments(this.d);
            this.e.beginTransaction().add(2131624257, (Fragment)this.i, "tags").commit();
        } else if (this.d != null && this.d.containsKey("need_onboarding")) {
            this.h = new OnboardingLocationFragment();
            this.e.beginTransaction().add(2131624257, (Fragment)this.h, "location").commit();
        } else if (bundle != null) {
            this.f = (OnboardingFacebookFragment)this.e.findFragmentByTag("fb");
        } else {
            this.f = new OnboardingFacebookFragment();
            this.e.beginTransaction().add(2131624257, (Fragment)this.f, "fb").commit();
        }
        this.addToSubscriptionList(ix.a().a(in.an.class, new apr<in.an>(){

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void onNext(in.an an2) {
                Fragment fragment = OnboardingActivity.this.e.findFragmentByTag(an2.a);
                if (an2.c != null) {
                    if (fragment == null || !fragment.isVisible()) return;
                    {
                        OnboardingActivity.this.switchFragment(an2.a, an2.b, an2.c);
                        return;
                    }
                } else {
                    if (fragment == null || !fragment.isVisible()) return;
                    {
                        OnboardingActivity.this.switchFragment(an2.a, an2.b);
                        return;
                    }
                }
            }
        }));
    }

    public void switchFragment(String string2, String string3) {
        this.switchFragment(string2, string3, null);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void switchFragment(String var1, String var2_3, Bundle var3_2) {
        var4_4 = this.e.findFragmentByTag(var1);
        jb.a(var4_4.getContext(), var4_4.getView());
        if (var2_3.equals((Object)"age") && (this.l == 1 || AppState.fbInfo != null && AppState.fbInfo.age != null)) {
            var2_3 = "tags";
        }
        if (var2_3.equals((Object)"tags") && this.k == 1) {
            this.finishGetGroups();
            return;
        }
        var5_5 = this.e.findFragmentByTag(var2_3);
        if (var5_5 != null) ** GOTO lbl69
        var10_6 = -1;
        switch (var2_3.hashCode()) {
            case 3260: {
                if (var2_3.equals((Object)"fb")) {
                    var10_6 = 0;
                    ** break;
                }
                ** GOTO lbl40
            }
            case 106642798: {
                if (var2_3.equals((Object)"phone")) {
                    var10_6 = 1;
                    ** break;
                }
                ** GOTO lbl40
            }
            case -819951495: {
                if (var2_3.equals((Object)"verify")) {
                    var10_6 = 2;
                    ** break;
                }
                ** GOTO lbl40
            }
            case -567451565: {
                if (var2_3.equals((Object)"contacts")) {
                    var10_6 = 3;
                    ** break;
                }
                ** GOTO lbl40
            }
            case 1901043637: {
                if (var2_3.equals((Object)"location")) {
                    var10_6 = 4;
                    ** break;
                }
                ** GOTO lbl40
            }
            case 96511: {
                if (var2_3.equals((Object)"age")) {
                    var10_6 = 5;
                }
            }
lbl40: // 14 sources:
            default: {
                ** GOTO lbl45
            }
            case 3552281: 
        }
        if (var2_3.equals((Object)"tags")) {
            var10_6 = 6;
        }
lbl45: // 4 sources:
        switch (var10_6) {
            case 0: {
                var5_5 = new OnboardingFacebookFragment();
                ** break;
            }
            case 1: {
                var5_5 = new OnboardingPhoneFragment();
                ** break;
            }
            case 2: {
                var5_5 = new OnboardingVerifyFragment();
                ** break;
            }
            case 3: {
                var5_5 = new OnboardingContactsFragment();
                ** break;
            }
            case 4: {
                var5_5 = new OnboardingLocationFragment();
                ** break;
            }
            case 5: {
                var5_5 = new OnboardingAgeFragment();
            }
lbl63: // 7 sources:
            default: {
                ** GOTO lbl67
            }
            case 6: 
        }
        var5_5 = new OnboardingTagsFragment();
lbl67: // 2 sources:
        if (var3_2 != null) {
            var5_5.setArguments(var3_2);
        }
lbl69: // 4 sources:
        var6_7 = this.e.beginTransaction();
        var6_7.replace(2131624257, var5_5, var2_3);
        var6_7.addToBackStack(null);
        var6_7.commit();
    }

}

