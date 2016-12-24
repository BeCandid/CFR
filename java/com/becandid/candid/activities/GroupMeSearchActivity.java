/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$Adapter
 *  android.support.v7.widget.RecyclerView$LayoutManager
 *  android.support.v7.widget.RecyclerView$OnItemTouchListener
 *  android.support.v7.widget.StaggeredGridLayoutManager
 *  android.view.View
 *  android.widget.Toast
 *  java.io.Serializable
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package com.becandid.candid.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;
import com.becandid.candid.activities.GroupBaseSearchActivity;
import com.becandid.candid.activities.GroupDetailsActivity;
import com.becandid.candid.data.DataUtil;
import com.becandid.candid.data.Group;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GroupMeSearchActivity
extends GroupBaseSearchActivity {
    private ho d;
    private List<Group> e = new ArrayList();

    private void a(String string2) {
        ArrayList<Group> arrayList = this.groupSearch(string2);
        this.d.a(arrayList);
        if (arrayList.size() == 0) {
            this.mSearchResultRecyclerView.setVisibility(8);
            this.mSearchEmpty.setVisibility(0);
            return;
        }
        this.mSearchResultRecyclerView.setVisibility(0);
        this.mSearchEmpty.setVisibility(8);
    }

    /*
     * Enabled aggressive block sorting
     */
    public ArrayList<Group> groupSearch(String string2) {
        ArrayList arrayList = new ArrayList();
        if (this.e == null) {
            Toast.makeText((Context)this, (CharSequence)"Unable to find your groups", (int)1).show();
            this.finish();
            return arrayList;
        }
        Iterator iterator = this.e.iterator();
        while (iterator.hasNext()) {
            Group group = (Group)iterator.next();
            String string3 = group.group_name.toLowerCase();
            if (string3.startsWith(string2.toLowerCase())) {
                arrayList.add(0, (Object)group);
                continue;
            }
            if (!string3.contains((CharSequence)string2.toLowerCase())) continue;
            arrayList.add((Object)group);
        }
        return arrayList;
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.e = (List)this.getIntent().getExtras().getSerializable("groups");
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
        this.mSearchResultRecyclerView.setLayoutManager((RecyclerView.LayoutManager)staggeredGridLayoutManager);
        this.d = new ho((Context)this);
        this.mSearchResultRecyclerView.setAdapter((RecyclerView.Adapter)this.d);
        this.mSearchResultRecyclerView.addOnItemTouchListener((RecyclerView.OnItemTouchListener)new iv(this.getBaseContext()){

            @Override
            public void onItemClick(View view, int n2) {
                Intent intent = new Intent(view.getContext(), (Class)GroupDetailsActivity.class);
                Group group = GroupMeSearchActivity.this.d.b(n2);
                if (group == null) {
                    return;
                }
                intent.putExtra("group_id", group.group_id);
                intent.putExtra("group_name", group.group_name);
                intent.putExtra("group_image", group.imageUrl());
                intent.putExtra("group_json", DataUtil.toJson(group));
                view.getContext().startActivity(intent);
            }
        });
        this.mQueryTextInterface = new GroupBaseSearchActivity.QueryTextInterface(){

            @Override
            public void onQueryTextChange(String string2) {
                GroupMeSearchActivity.this.a(string2);
            }

            @Override
            public void onQueryTextSubmit(String string2) {
                GroupMeSearchActivity.this.a(string2);
            }
        };
    }

}

