/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.support.v4.widget.SwipeRefreshLayout
 *  android.support.v4.widget.SwipeRefreshLayout$OnRefreshListener
 *  android.support.v7.widget.LinearLayoutManager
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$Adapter
 *  android.support.v7.widget.RecyclerView$LayoutManager
 *  android.support.v7.widget.RecyclerView$OnItemTouchListener
 *  android.support.v7.widget.RecyclerView$OnScrollListener
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.Toast
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  butterknife.Unbinder
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Integer
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
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.becandid.candid.activities.GroupDetailsActivity;
import com.becandid.candid.activities.NotificationSettingsActivity;
import com.becandid.candid.activities.PostDetailsActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.EmptyClass;
import com.becandid.candid.data.Notification;
import com.becandid.candid.data.User;
import com.becandid.candid.models.EmptySubscriber;
import com.becandid.candid.models.NetworkData;
import java.util.List;
import rx.schedulers.Schedulers;

public class ActivityTabFragment
extends ht
implements View.OnClickListener {
    private hb d;
    private aps e;
    private long f;
    @BindView(value=2131624298)
    View mEmptyView;
    @BindView(value=2131624297)
    RecyclerView mRecyclerView;
    @BindView(value=2131624295)
    View mSettingView;
    @BindView(value=2131624296)
    SwipeRefreshLayout mSwipeRefresh;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private aps a(boolean bl2) {
        int n2 = 1;
        this.mSwipeRefresh.setRefreshing((boolean)n2);
        this.f = System.currentTimeMillis();
        if (bl2) {
            do {
                return ik.a().b(Integer.toString((int)n2), null).b(Schedulers.io()).a(apv.a()).b(super.d());
                break;
            } while (true);
        }
        n2 = 0;
        return ik.a().b(Integer.toString((int)n2), null).b(Schedulers.io()).a(apv.a()).b(super.d());
    }

    private apr d() {
        return new apr<NetworkData>(){

            public void a(NetworkData networkData) {
                ActivityTabFragment.this.d.a(networkData.activity);
                ActivityTabFragment.this.d.a(String.valueOf((int)networkData.last_activity_id));
                ix.a().a(new in.as(3, networkData.unread_count, true));
                ix.a().a(new in.as(1, networkData.unread_groups_count, true));
            }

            @Override
            public void onCompleted() {
                ActivityTabFragment.this.mSwipeRefresh.setRefreshing(false);
                ActivityTabFragment.this.e();
            }

            @Override
            public void onError(Throwable throwable) {
                ActivityTabFragment.this.mSwipeRefresh.setRefreshing(false);
                ActivityTabFragment.this.e();
                rj.a(throwable);
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((NetworkData)object);
            }
        };
    }

    private void e() {
        if (!this.d.d()) {
            Log.d((String)"Toggle", (String)"empty");
            this.mRecyclerView.setVisibility(8);
            this.mEmptyView.setVisibility(0);
            return;
        }
        Log.d((String)"Toggle", (String)"not empty");
        this.mRecyclerView.setVisibility(0);
        this.mEmptyView.setVisibility(8);
    }

    @Override
    public void a() {
        super.a();
        this.mRecyclerView.scrollToPosition(0);
        if (this.e != null) {
            this.e.unsubscribe();
        }
        this.e = this.a(false);
        this.d.c();
        this.c = false;
    }

    @Override
    public void b() {
    }

    @Override
    public void c() {
    }

    public void onClick(View view) {
        if (view.getId() == 2131624295) {
            Intent intent = new Intent(this.getContext(), (Class)NotificationSettingsActivity.class);
            this.getContext().startActivity(intent);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = layoutInflater.inflate(2130968631, viewGroup, false);
        this.b = ButterKnife.bind((Object)this, (View)view);
        this.a = this.getContext();
        aou.a(this.a);
        this.mSettingView.setOnClickListener((View.OnClickListener)this);
        this.mSwipeRefresh.setColorSchemeColors(new int[]{2131558476});
        this.mSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){

            public void onRefresh() {
                if (ActivityTabFragment.this.e != null) {
                    ActivityTabFragment.this.e.unsubscribe();
                }
                ActivityTabFragment.this.e = ActivityTabFragment.this.a(true);
                ActivityTabFragment.this.d.c();
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.a);
        this.mRecyclerView.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
        this.mRecyclerView.addOnItemTouchListener((RecyclerView.OnItemTouchListener)new iv(this.a){

            /*
             * Unable to fully structure code
             * Enabled aggressive block sorting
             * Lifted jumps to return sites
             */
            @Override
            public void onItemClick(View var1, int var2_2) {
                if (var2_2 < 0 || var2_2 >= ActivityTabFragment.b(ActivityTabFragment.this).e().size()) {
                    Toast.makeText((Context)ActivityTabFragment.this.a, (CharSequence)"Unable to find that notification", (int)0).show();
                    return;
                }
                var3_3 = (Notification)ActivityTabFragment.b(ActivityTabFragment.this).e().get(var2_2);
                var3_3.unread = 0;
                ActivityTabFragment.b(ActivityTabFragment.this).notifyItemChanged(var2_2);
                ik.a().a(var3_3.activity_id).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
                var5_4 = var3_3.onclick.split(":");
                var6_5 = Integer.valueOf((String)var5_4[1]);
                var7_6 = var5_4[0];
                switch (var7_6.hashCode()) {
                    case -338943683: {
                        if (!var7_6.equals((Object)"showPost")) ** GOTO lbl24
                        var8_7 = 0;
                        ** GOTO lbl31
                    }
                    case -1572993592: {
                        if (!var7_6.equals((Object)"showPostBottom")) ** GOTO lbl24
                        var8_7 = 1;
                        ** GOTO lbl31
                    }
                    case -1925545598: {
                        if (!var7_6.equals((Object)"showGroup")) ** GOTO lbl24
                        var8_7 = 2;
                        ** GOTO lbl31
                    }
lbl24: // 4 sources:
                    default: {
                        ** GOTO lbl-1000
                    }
                    case 2067279704: 
                }
                if (var7_6.equals((Object)"showTab")) {
                    var8_7 = 3;
                } else lbl-1000: // 2 sources:
                {
                    var8_7 = -1;
                }
lbl31: // 5 sources:
                switch (var8_7) {
                    default: {
                        return;
                    }
                    case 0: {
                        var15_8 = new Intent(ActivityTabFragment.this.a, (Class)PostDetailsActivity.class);
                        var15_8.putExtra("post_id", var6_5);
                        if (var3_3.comment_id > 0) {
                            var15_8.putExtra("comment_id", var3_3.comment_id);
                            var15_8.putExtra("scrollToBottom", true);
                        }
                        ActivityTabFragment.this.a.startActivity(var15_8);
                        return;
                    }
                    case 1: {
                        var11_9 = new Intent(ActivityTabFragment.this.a, (Class)PostDetailsActivity.class);
                        var11_9.putExtra("post_id", var6_5);
                        var11_9.putExtra("comment_id", var3_3.comment_id);
                        var11_9.putExtra("scrollToBottom", true);
                        ActivityTabFragment.this.a.startActivity(var11_9);
                        return;
                    }
                    case 2: {
                        var9_10 = new Intent(ActivityTabFragment.this.a, (Class)GroupDetailsActivity.class);
                        var9_10.putExtra("group_id", var6_5);
                        ActivityTabFragment.this.a.startActivity(var9_10);
                        return;
                    }
                    case 3: 
                }
                ix.a().a(new in.e(var6_5));
            }
        });
        this.d = new hb(this.a);
        this.mRecyclerView.setAdapter((RecyclerView.Adapter)this.d);
        this.mRecyclerView.addOnScrollListener((RecyclerView.OnScrollListener)new hn(linearLayoutManager, this.d){

            @Override
            public void onLoadMore(String string2) {
                if (string2 != null) {
                    ik.a().b(Boolean.toString((boolean)true), string2).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

                        public void a(NetworkData networkData) {
                            if (networkData == null || networkData.activity == null || networkData.activity.isEmpty()) {
                                ActivityTabFragment.this.d.a((String)null);
                                return;
                            }
                            ActivityTabFragment.this.d.b(networkData.activity);
                            ActivityTabFragment.this.d.a(String.valueOf((int)networkData.last_activity_id));
                        }

                        @Override
                        public void onCompleted() {
                        }

                        @Override
                        public void onError(Throwable throwable) {
                        }

                        @Override
                        public /* synthetic */ void onNext(Object object) {
                            this.a((NetworkData)object);
                        }
                    });
                }
            }

        });
        this.e = super.a(false);
        return view;
    }

    public void onResume() {
        super.onResume();
        if (AppState.account != null) {
            this.e = this.a(true);
        }
        aou.a(this.a);
    }

}

