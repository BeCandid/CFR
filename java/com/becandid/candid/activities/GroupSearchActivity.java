/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.location.Location
 *  android.os.Bundle
 *  android.support.v7.widget.LinearLayoutManager
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$Adapter
 *  android.support.v7.widget.RecyclerView$LayoutManager
 *  android.support.v7.widget.RecyclerView$OnItemTouchListener
 *  android.view.View
 *  java.lang.ArrayIndexOutOfBoundsException
 *  java.lang.Exception
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 *  rx.schedulers.Schedulers
 */
package com.becandid.candid.activities;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.becandid.candid.activities.GroupBaseSearchActivity;
import com.becandid.candid.activities.GroupDetailsActivity;
import com.becandid.candid.data.AppState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.schedulers.Schedulers;

public class GroupSearchActivity
extends GroupBaseSearchActivity {
    private List<GroupSearchResult> d;
    private aps e;

    static /* synthetic */ List a(GroupSearchActivity groupSearchActivity) {
        return groupSearchActivity.d;
    }

    private void a() {
        this.d.clear();
        this.mSearchResultRecyclerView.getAdapter().notifyDataSetChanged();
    }

    private void a(ain ain2) {
        GroupSearchResult groupSearchResult = (GroupSearchActivity)this.new GroupSearchResult();
        try {
            groupSearchResult.groupName = ain2.b("group_name").c();
            groupSearchResult.groupId = ain2.b("group_id").g();
            groupSearchResult.firstTag = ain2.b("first_tag").c();
            groupSearchResult.thumbUrl = ain2.b("thumb_url").c();
            this.d.add((Object)groupSearchResult);
            return;
        }
        catch (Exception var3_3) {
            return;
        }
    }

    private void a(String string2) {
        if (string2.length() >= 3) {
            super.b(string2.toString());
            return;
        }
        this.mSearchProgressBar.setVisibility(8);
        this.mSearchResultRecyclerView.setVisibility(0);
    }

    private void a(Map<String, String> map) {
        if (this.e != null) {
            this.e.unsubscribe();
        }
        this.e = ik.a().j(map).b(Schedulers.io()).a(apv.a()).b(new apr<ain>(){

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                GroupSearchActivity.this.mSearchProgressBar.setVisibility(8);
                GroupSearchActivity.this.mSearchResultRecyclerView.setVisibility(0);
            }

            @Override
            public void onNext(ain ain2) {
                if (GroupSearchActivity.this.isStopped) {
                    return;
                }
                aij aij2 = ain2.b("groups").n();
                for (int i2 = 0; i2 < aij2.a(); ++i2) {
                    ain ain3 = aij2.a(i2).m();
                    GroupSearchActivity.this.a(ain3);
                }
                GroupSearchActivity.this.mSearchResultRecyclerView.getAdapter().notifyDataSetChanged();
                GroupSearchActivity.this.mSearchProgressBar.setVisibility(8);
                GroupSearchActivity.this.mSearchResultRecyclerView.setVisibility(0);
            }
        });
    }

    /*
     * Enabled aggressive block sorting
     */
    private void b(String string2) {
        this.mSearchProgressBar.setVisibility(0);
        this.mSearchResultRecyclerView.setVisibility(8);
        super.a();
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"query", (Object)string2);
        if (AppState.location != null) {
            StringBuilder stringBuilder = new StringBuilder().append(AppState.location.getLatitude()).append(",").append(AppState.location.getLongitude()).append("@");
            String string3 = AppState.location.hasAccuracy() ? Float.valueOf((float)AppState.location.getAccuracy()) : "50";
            hashMap.put((Object)"location", (Object)stringBuilder.append((Object)string3).toString());
        }
        super.a((Map<String, String>)hashMap);
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.d = new ArrayList();
        this.mSearchResultRecyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager((Context)this);
        this.mSearchResultRecyclerView.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
        this.mSearchResultRecyclerView.addOnItemTouchListener((RecyclerView.OnItemTouchListener)new iv((Context)this){

            @Override
            public void onItemClick(View view, int n2) {
                try {
                    GroupSearchActivity.this.startActivity(GroupDetailsActivity.startGroupDetailsActivity(GroupSearchActivity.this.getBaseContext(), ((GroupSearchResult)GroupSearchActivity.a((GroupSearchActivity)GroupSearchActivity.this).get((int)n2)).groupId));
                    return;
                }
                catch (ArrayIndexOutOfBoundsException var3_3) {
                    rj.a((Throwable)var3_3);
                    return;
                }
            }
        });
        hh hh2 = new hh(this.d, (Context)this);
        this.mSearchResultRecyclerView.setAdapter((RecyclerView.Adapter)hh2);
        this.mQueryTextInterface = new GroupBaseSearchActivity.QueryTextInterface(){

            @Override
            public void onQueryTextChange(String string2) {
                GroupSearchActivity.this.a(string2);
            }

            @Override
            public void onQueryTextSubmit(String string2) {
                GroupSearchActivity.this.a(string2);
            }
        };
    }

    public class GroupSearchResult {
        public String firstTag;
        public int groupId;
        public String groupName;
        public String thumbUrl;

        GroupSearchResult() {
        }

        public String toString() {
            return "groupName: " + this.groupName + ", groupId: " + Integer.toString((int)this.groupId);
        }
    }

}

