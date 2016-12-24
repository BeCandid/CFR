/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.FragmentManager
 *  android.support.v4.app.FragmentTransaction
 *  java.lang.String
 */
package com.becandid.candid.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.fragments.onboarding.OnboardingAgeFragment;

public class VerifyAgeActivity
extends BaseActivity {
    public void onActivityResult() {
        this.setResult(-1);
        this.finish();
    }

    public void onBackPressed() {
    }

    @Override
    protected void onCreate(Bundle bundle) {
        this.setTheme(2131427522);
        super.onCreate(bundle);
        this.setContentView(2130968636);
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        OnboardingAgeFragment onboardingAgeFragment = new OnboardingAgeFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("existing_user", true);
        onboardingAgeFragment.setArguments(bundle2);
        fragmentManager.beginTransaction().add(2131624312, (Fragment)onboardingAgeFragment, "age").commit();
    }
}

