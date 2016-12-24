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
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.List
 *  rx.schedulers.Schedulers
 */
package com.becandid.candid.fragments.main_tabs;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.becandid.candid.activities.GroupDetailsActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.FacebookInfo;
import com.becandid.candid.data.Group;
import com.becandid.candid.models.NetworkData;
import com.becandid.candid.views.GroupStackView;
import java.util.List;
import rx.schedulers.Schedulers;

public class GroupTabFragment
extends ht
implements GroupStackView.c {
    private long d = 0;
    @BindView(value=2131624512)
    View discoverEmpty;
    @BindView(value=2131624508)
    View forYouEmpty;
    @BindView(value=2131624514)
    GroupStackView groupStackView;
    @BindView(value=2131624513)
    View loading;
    @BindView(value=2131624507)
    TabLayout tabBar;

    private void a(final boolean bl2) {
        if (bl2 && this.groupStackView != null) {
            this.groupStackView.setVisibility(8);
            this.forYouEmpty.setVisibility(8);
            this.discoverEmpty.setVisibility(8);
            this.loading.setVisibility(0);
        }
        int n2 = this.tabBar.getSelectedTabPosition();
        final boolean bl3 = false;
        if (n2 == 0) {
            bl3 = true;
        }
        ik.a().a(AppState.fbInfo, bl3).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

            /*
             * Enabled aggressive block sorting
             * Lifted jumps to return sites
             */
            public void a(NetworkData networkData) {
                if (GroupTabFragment.this.tabBar != null) {
                    boolean bl22 = bl3;
                    boolean bl32 = GroupTabFragment.this.tabBar.getSelectedTabPosition() == 0;
                    if (bl22 != bl32) {
                        return;
                    }
                }
                GroupTabFragment.this.loading.setVisibility(8);
                if (networkData == null) return;
                if (networkData.groups == null) return;
                if ((bl2 || GroupTabFragment.this.groupStackView.a() == 0) && networkData.groups.size() == 0) {
                    if (bl3) {
                        GroupTabFragment.this.forYouEmpty.setVisibility(0);
                    } else {
                        GroupTabFragment.this.discoverEmpty.setVisibility(0);
                    }
                } else {
                    GroupTabFragment.this.groupStackView.setVisibility(0);
                }
                GroupTabFragment.this.groupStackView.setGroups(networkData.groups);
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
                if (GroupTabFragment.this.loading != null) {
                    GroupTabFragment.this.loading.setVisibility(8);
                }
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((NetworkData)object);
            }
        });
    }

    @Override
    public void a() {
        super.a();
        this.a(true);
        this.c = false;
    }

    @Override
    public void b() {
    }

    @Override
    public void c() {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = layoutInflater.inflate(2130968691, viewGroup, false);
        this.b = ButterKnife.bind((Object)this, (View)view);
        this.a = this.getContext();
        this.groupStackView.setListener((GroupStackView.c)this);
        this.tabBar.setSelectedTabIndicatorColor(this.getResources().getColor(2131558476));
        this.tabBar.setTabTextColors(Color.parseColor((String)"#888888"), this.getResources().getColor(2131558476));
        this.tabBar.a(this.tabBar.a().a((CharSequence)"For You"));
        this.tabBar.a(this.tabBar.a().a((CharSequence)"Discover"));
        this.tabBar.setOnTabSelectedListener(new TabLayout.a(){

            public void onTabReselected(TabLayout.d d2) {
                GroupTabFragment.this.a();
            }

            public void onTabSelected(TabLayout.d d2) {
                GroupTabFragment.this.a(true);
            }

            public void onTabUnselected(TabLayout.d d2) {
            }
        });
        return view;
    }

    @Override
    public void onEmptyGroups() {
        this.groupStackView.setVisibility(8);
        if (this.tabBar.getSelectedTabPosition() == 0) {
            this.forYouEmpty.setVisibility(0);
            return;
        }
        this.discoverEmpty.setVisibility(0);
    }

    @Override
    public void onJoinGroup(Group group) {
    }

    public void onResume() {
        super.onResume();
        if (this.tabBar != null && this.tabBar.getSelectedTabPosition() == 1) {
            this.tabBar.a(0).e();
        }
        this.a(true);
    }

    @Override
    public void onSkipGroup(Group group) {
    }

    @Override
    public void onTouchEvent(Group group) {
        long l2 = System.currentTimeMillis();
        if (l2 - this.d < 250) {
            Intent intent = new Intent(this.a, (Class)GroupDetailsActivity.class);
            intent.putExtra("group_id", group.group_id);
            this.a.startActivity(intent);
            return;
        }
        this.d = l2;
    }

}

