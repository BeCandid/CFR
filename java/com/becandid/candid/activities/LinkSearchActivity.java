/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Bundle
 *  android.support.v7.widget.LinearLayoutManager
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$Adapter
 *  android.support.v7.widget.RecyclerView$LayoutManager
 *  android.view.View
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 *  rx.schedulers.Schedulers
 */
package com.becandid.candid.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.becandid.candid.activities.GroupBaseSearchActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.schedulers.Schedulers;

public class LinkSearchActivity
extends GroupBaseSearchActivity {
    private List<LinkSearchResult> d;
    private aps e;

    private void a() {
        this.d.clear();
        this.mSearchResultRecyclerView.getAdapter().notifyDataSetChanged();
    }

    private void a(ain ain2) {
        LinkSearchResult linkSearchResult = (LinkSearchActivity)this.new LinkSearchResult();
        try {
            linkSearchResult.host = ain2.b("attribution_host").c();
            linkSearchResult.description = ain2.b("description").c();
            linkSearchResult.title = ain2.b("title").c();
            linkSearchResult.source_url = ain2.b("source_url").c();
            linkSearchResult.final_link_url = ain2.b("final_link_url").c();
            this.d.add((Object)linkSearchResult);
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

    private void b(String string2) {
        this.mSearchProgressBar.setVisibility(0);
        this.mSearchResultRecyclerView.setVisibility(8);
        super.a();
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"query", (Object)string2);
        if (this.e != null) {
            this.e.unsubscribe();
        }
        this.e = ik.a().k((Map<String, String>)hashMap).b(Schedulers.io()).a(apv.a()).b(new apr<ain>(){

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                LinkSearchActivity.this.mSearchProgressBar.setVisibility(8);
                LinkSearchActivity.this.mSearchResultRecyclerView.setVisibility(0);
            }

            @Override
            public void onNext(ain ain2) {
                if (LinkSearchActivity.this.isStopped) {
                    return;
                }
                aij aij2 = ain2.b("links").n();
                for (int i2 = 0; i2 < aij2.a(); ++i2) {
                    ain ain3 = aij2.a(i2).m();
                    LinkSearchActivity.this.a(ain3);
                }
                LinkSearchActivity.this.mSearchResultRecyclerView.getAdapter().notifyDataSetChanged();
                LinkSearchActivity.this.mSearchProgressBar.setVisibility(8);
                LinkSearchActivity.this.mSearchResultRecyclerView.setVisibility(0);
            }
        });
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.d = new ArrayList();
        this.mSearchResultRecyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager((Context)this);
        this.mSearchResultRecyclerView.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
        hi hi2 = new hi(this.d, (Activity)this);
        this.mSearchResultRecyclerView.setAdapter((RecyclerView.Adapter)hi2);
        this.mQueryTextInterface = new GroupBaseSearchActivity.QueryTextInterface(){

            @Override
            public void onQueryTextChange(String string2) {
                LinkSearchActivity.this.a(string2);
            }

            @Override
            public void onQueryTextSubmit(String string2) {
                LinkSearchActivity.this.a(string2);
            }
        };
        this.busSubscribe(in.z.class, new apr<in.z>(){

            @Override
            public void onCompleted() {
                LinkSearchActivity.this.finish();
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
            }

            @Override
            public void onNext(in.z z2) {
                LinkSearchActivity.this.finish();
            }
        });
    }

    public class LinkSearchResult {
        public String description;
        public String final_link_url;
        public String host;
        public String source_url;
        public String title;

        LinkSearchResult() {
        }
    }

}

