/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.Intent
 *  android.os.Bundle
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.FragmentActivity
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.FrameLayout
 *  android.widget.TextView
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  butterknife.Unbinder
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 *  rx.schedulers.Schedulers
 */
package com.becandid.candid.fragments.onboarding;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.OnboardingActivity;
import com.becandid.candid.activities.VerifyAgeActivity;
import com.becandid.candid.activities.WebViewActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Config;
import com.becandid.candid.data.EmptyClass;
import com.becandid.candid.models.EmptySubscriber;
import java.util.HashMap;
import java.util.Map;
import rx.schedulers.Schedulers;

public class OnboardingAgeFragment
extends Fragment {
    private Unbinder a;
    @BindView(value=2131624626)
    TextView ageHeader;
    @BindView(value=2131624633)
    Button ageOver;
    @BindView(value=2131624627)
    TextView ageSubheader;
    @BindView(value=2131624631)
    Button ageUnder;
    private boolean b;
    @BindView(value=2131624634)
    TextView privacy;
    @BindView(value=2131624625)
    TextView skip;
    @BindView(value=2131624635)
    FrameLayout spinny;

    private void b() {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"age", (Object)AppState.age);
        ik.a().a((Map<String, String>)hashMap).b(Schedulers.newThread()).a(apv.a()).b(new EmptySubscriber());
    }

    public void a() {
        this.ageHeader.setText((CharSequence)AppState.config.getString("age_prompt_title", "Approximately, How Old Are You?"));
        this.ageSubheader.setText((CharSequence)AppState.config.getString("age_prompt_desc", "This information will help us recommend the right groups for you"));
        this.privacy.setText((CharSequence)AppState.config.getString("more_info", this.getString(2131230904)));
        this.ageOver.setText((CharSequence)AppState.config.getString("age_prompt_over_18", "Over 18"));
        this.ageUnder.setText((CharSequence)AppState.config.getString("age_prompt_under_18", "Under 18"));
    }

    public void a(String string2, String string3) {
        FragmentActivity fragmentActivity = this.getActivity();
        if (fragmentActivity instanceof OnboardingActivity) {
            ((OnboardingActivity)fragmentActivity).switchFragment(string2, string3);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle bundle2 = this.getArguments();
        if (bundle2 != null) {
            this.b = bundle2.getBoolean("existing_user", false);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = layoutInflater.inflate(2130968722, viewGroup, false);
        this.a = ButterKnife.bind((Object)this, (View)view);
        this.a();
        if (AppState.config.getInt("show_age_skip_android", 0) == 1) {
            this.skip.setVisibility(0);
            this.skip.setOnClickListener(new View.OnClickListener(){

                public void onClick(View view) {
                    OnboardingAgeFragment.this.a("age", "tags");
                }
            });
        } else {
            this.skip.setVisibility(8);
        }
        if (this.b) {
            this.privacy.setVisibility(8);
            this.skip.setVisibility(8);
        } else {
            this.privacy.setVisibility(0);
            this.privacy.setOnClickListener(new View.OnClickListener(){

                public void onClick(View view) {
                    Intent intent = new Intent(OnboardingAgeFragment.this.getContext(), (Class)WebViewActivity.class);
                    intent.putExtra("title", "Why Can I Trust Candid?");
                    intent.putExtra("url", GossipApplication.d + "content/whysafe");
                    OnboardingAgeFragment.this.getContext().startActivity(intent);
                }
            });
        }
        this.ageOver.setOnClickListener(new View.OnClickListener(){

            /*
             * Enabled aggressive block sorting
             */
            public void onClick(View view) {
                AppState.age = "18_plus";
                if (OnboardingAgeFragment.this.b) {
                    OnboardingAgeFragment.this.b();
                    ((VerifyAgeActivity)OnboardingAgeFragment.this.getActivity()).onActivityResult();
                } else {
                    OnboardingAgeFragment.this.a("age", "tags");
                }
                AppState.saveState((ContextWrapper)GossipApplication.a());
            }
        });
        this.ageUnder.setOnClickListener(new View.OnClickListener(){

            /*
             * Enabled aggressive block sorting
             */
            public void onClick(View view) {
                AppState.age = "under_18";
                if (OnboardingAgeFragment.this.b) {
                    OnboardingAgeFragment.this.b();
                    ((VerifyAgeActivity)OnboardingAgeFragment.this.getActivity()).onActivityResult();
                } else {
                    OnboardingAgeFragment.this.a("age", "tags");
                }
                AppState.saveState((ContextWrapper)GossipApplication.a());
            }
        });
        return view;
    }

}

