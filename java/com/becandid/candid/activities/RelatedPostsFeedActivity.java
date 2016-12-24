/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.support.v7.widget.LinearLayoutManager
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$Adapter
 *  android.support.v7.widget.RecyclerView$LayoutManager
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Type
 *  java.util.Iterator
 *  java.util.List
 */
package com.becandid.candid.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.data.Post;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

public class RelatedPostsFeedActivity
extends BaseActivity {
    private List<Post> b;
    private hf c;
    @BindView(value=2131624284)
    RecyclerView feedRecycler;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130968628);
        ButterKnife.bind((Activity)this);
        if (!this.getIntent().hasExtra("related_posts")) {
            this.finish();
        }
        Type type = new aju<List<Post>>(){}.getType();
        String string2 = this.getIntent().getStringExtra("related_posts");
        this.b = (List)new aih().a(string2, type);
        Iterator iterator = this.b.iterator();
        while (iterator.hasNext()) {
            ((Post)iterator.next()).related_to_post = 0;
        }
        this.c = new hf((BaseActivity)this, null);
        this.feedRecycler.setAdapter((RecyclerView.Adapter)this.c);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager((Context)this);
        this.feedRecycler.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
        this.c.a(this.b);
    }

}

