/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Handler
 *  android.util.Log
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  android.widget.Toast
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.List
 *  rx.schedulers.Schedulers
 */
package com.becandid.candid.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.activities.MainTabsActivity;
import com.becandid.candid.activities.PostDetailsActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Config;
import com.becandid.candid.data.Group;
import com.becandid.candid.models.NetworkData;
import com.becandid.candid.views.GroupStackView;
import java.util.ArrayList;
import java.util.List;
import rx.schedulers.Schedulers;

public class OnboardingGroupsActivity
extends BaseActivity
implements GroupStackView.c {
    private int b;
    private int c;
    @BindView(value=2131624260)
    Button ogButton;
    @BindView(value=2131624262)
    TextView ogEmpty;
    @BindView(value=2131624258)
    TextView ogHeader;
    @BindView(value=2131624261)
    LinearLayout ogSpinny;
    @BindView(value=2131624259)
    GroupStackView ogStack;

    private void a() {
        this.ogButton.setEnabled(false);
        this.ogSpinny.setVisibility(0);
        ik.a().f().b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
                Toast.makeText((Context)OnboardingGroupsActivity.this, (CharSequence)"Unable to get get your recommended groups. Please try again", (int)0).show();
                rj.a(throwable);
                Log.d((String)"OnboardingGroups", (String)throwable.toString());
                OnboardingGroupsActivity.this.ogSpinny.setVisibility(8);
                OnboardingGroupsActivity.this.b();
            }

            @Override
            public void onNext(NetworkData networkData) {
                OnboardingGroupsActivity.this.ogStack.setGroups(networkData.groups);
                new Handler().postDelayed(new Runnable(){

                    public void run() {
                        OnboardingGroupsActivity.this.ogSpinny.setVisibility(8);
                        OnboardingGroupsActivity.this.ogStack.setVisibility(0);
                    }
                }, 500);
            }

        });
    }

    private void b() {
        this.ogButton.setText((CharSequence)"Retry");
        this.ogButton.setEnabled(true);
        this.ogButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                OnboardingGroupsActivity.this.c();
                OnboardingGroupsActivity.this.ogButton.setOnClickListener(new View.OnClickListener(){

                    public void onClick(View view) {
                        OnboardingGroupsActivity.this.launchMainActivity((View)OnboardingGroupsActivity.this.ogButton);
                    }
                });
                OnboardingGroupsActivity.this.a();
            }

        });
    }

    private void c() {
        this.ogHeader.setText((CharSequence)AppState.config.getString("onboarding_groups_header", this.getString(2131230863)));
        this.ogButton.setText((CharSequence)AppState.config.getString("onboarding_groups_done", this.getString(2131230854)));
    }

    /*
     * Enabled aggressive block sorting
     */
    public void launchMainActivity(View view) {
        Intent intent;
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

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130968626);
        ButterKnife.bind((Activity)this);
        super.c();
        this.ogStack.setListener((GroupStackView.c)this);
        AppState.groups = new ArrayList();
        this.b = 0;
        this.c = AppState.config.getInt("onboarding_num_groups", 10);
        super.a();
    }

    @Override
    public void onEmptyGroups() {
        this.ogStack.setVisibility(8);
        this.ogEmpty.setVisibility(0);
    }

    @Override
    public void onJoinGroup(Group group) {
        this.b = 1 + this.b;
        if (this.b >= this.c || this.ogStack.a() <= 1) {
            this.ogButton.setEnabled(true);
        }
    }

    @Override
    public void onSkipGroup(Group group) {
        if (this.ogStack.a() <= 1) {
            this.ogButton.setEnabled(true);
        }
    }

    @Override
    public void onTouchEvent(Group group) {
    }

}

