/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.graphics.Color
 *  android.os.Bundle
 *  android.support.design.widget.TabLayout
 *  android.support.design.widget.TabLayout$a
 *  android.support.design.widget.TabLayout$d
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.FragmentActivity
 *  android.support.v4.app.FragmentManager
 *  android.support.v4.view.ViewPager
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  butterknife.Unbinder
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.List
 */
package com.becandid.candid.fragments.main_tabs;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Post;
import com.becandid.candid.views.TabViewPager;
import java.util.ArrayList;
import java.util.List;

public class FeedTabFragment
extends ht
implements TabLayout.a {
    BaseActivity d;
    private hq e;
    private List<String> f;
    @BindView(value=2131624421)
    View mFeedTab;
    @BindView(value=2131624422)
    TabLayout mFeedTabs;
    @BindView(value=2131624424)
    View mNewPostsText;
    @BindView(value=2131624423)
    TabViewPager viewPager;

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private String a(String var1_1) {
        var2_2 = -1;
        switch (var1_1.hashCode()) {
            case 3208415: {
                if (var1_1.equals((Object)"home")) {
                    var2_2 = 0;
                }
            }
            default: {
                ** GOTO lbl11
            }
            case 1394955557: 
        }
        if (var1_1.equals((Object)"trending")) {
            var2_2 = 1;
        }
lbl11: // 4 sources:
        switch (var2_2) {
            default: {
                return "Friends";
            }
            case 0: {
                return "New";
            }
            case 1: 
        }
        return "Hot";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void a() {
        super.a();
        if (this.viewPager == null) {
            return;
        }
        int n2 = 0;
        while (n2 < this.viewPager.getChildCount()) {
            ((hs)this.e.getItem(n2)).a(0);
            ++n2;
        }
    }

    public void a(int n2) {
        ((hs)this.e.getItem(this.viewPager.getCurrentItem())).b(n2);
    }

    @Override
    public void b() {
        if (this.mFeedTab != null) {
            this.mFeedTab.setVisibility(0);
        }
    }

    @Override
    public void c() {
        if (this.mFeedTab != null) {
            this.mFeedTab.setVisibility(8);
        }
    }

    public void onActivityResult(int n2, int n3, Intent intent) {
        super.onActivityResult(n2, n3, intent);
        if (this.d == null || this.d.callbackManager == null) {
            return;
        }
        this.d.callbackManager.a(n2, n3, intent);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = layoutInflater.inflate(2130968668, viewGroup, false);
        this.b = ButterKnife.bind((Object)this, (View)view);
        this.d = (BaseActivity)this.getActivity();
        this.a = this.getContext();
        this.mFeedTabs.setSelectedTabIndicatorColor(this.getResources().getColor(2131558476));
        this.mFeedTabs.setTabTextColors(Color.parseColor((String)"#888888"), this.getResources().getColor(2131558476));
        this.f = AppState.tabsOrder;
        if (this.f == null || this.f.isEmpty()) {
            this.f = new ArrayList();
            this.f.add((Object)"home");
            this.f.add((Object)"trending");
            this.f.add((Object)"friends");
        }
        this.e = new hq(this.d.getSupportFragmentManager());
        for (String string2 : this.f) {
            hs hs2 = new hs();
            Bundle bundle2 = new Bundle();
            bundle2.putString("feed_type", string2);
            hs2.setArguments(bundle2);
            this.e.a(hs2, super.a(string2));
        }
        this.viewPager.setAdapter((ev)((Object)this.e));
        this.viewPager.setOffscreenPageLimit(2);
        this.viewPager.setCurrTab("feed");
        this.mFeedTabs.setupWithViewPager((ViewPager)this.viewPager);
        this.mFeedTabs.setOnTabSelectedListener((TabLayout.a)this);
        aps aps2 = ix.a().a(in.ah.class, new apr<in.ah>(){

            public void a(in.ah ah2) {
                if (AppState.relatedPosts != null && !AppState.relatedPosts.isEmpty() && FeedTabFragment.this.viewPager != null && !ah2.b) {
                    FeedTabFragment.this.viewPager.setCurrentItem(0);
                }
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((in.ah)object);
            }
        });
        ((BaseActivity)this.a).addToSubscriptionList(aps2);
        return view;
    }

    public void onResume() {
        super.onResume();
    }

    public void onTabReselected(TabLayout.d d2) {
        ((hs)this.e.getItem(d2.c())).a(0);
    }

    public void onTabSelected(TabLayout.d d2) {
        this.viewPager.setCurrentItem(d2.c(), true);
    }

    public void onTabUnselected(TabLayout.d d2) {
    }

}

