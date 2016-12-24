/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Bundle
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.SearchView
 *  android.support.v7.widget.SearchView$OnQueryTextListener
 *  android.support.v7.widget.Toolbar
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.becandid.candid.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.activities.BaseActivity;

public class GroupBaseSearchActivity
extends BaseActivity {
    SearchView b;
    MenuItem c;
    public QueryTextInterface mQueryTextInterface;
    @BindView(value=2131624165)
    View mSearchEmpty;
    @BindView(value=2131624167)
    View mSearchProgressBar;
    @BindView(value=2131624164)
    RecyclerView mSearchResultRecyclerView;

    public void onBackPressed() {
        if (this.b != null && this.c != null && !this.c.isActionViewExpanded()) {
            this.finish();
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130968610);
        ButterKnife.bind((Activity)this);
        this.setSupportActionBar((Toolbar)this.findViewById(2131624081));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(2131689476, menu);
        this.c = menu.findItem(2131624844);
        this.b = (SearchView)ej.a(this.c);
        this.c.expandActionView();
        this.b.requestFocus();
        this.b.setQueryHint((CharSequence)"Search ...");
        this.b.setOnQueryTextListener(new SearchView.OnQueryTextListener(){

            public boolean onQueryTextChange(String string2) {
                if (GroupBaseSearchActivity.this.mQueryTextInterface != null) {
                    GroupBaseSearchActivity.this.mQueryTextInterface.onQueryTextChange(string2);
                }
                return false;
            }

            public boolean onQueryTextSubmit(String string2) {
                if (GroupBaseSearchActivity.this.mQueryTextInterface != null) {
                    GroupBaseSearchActivity.this.mQueryTextInterface.onQueryTextSubmit(string2);
                }
                GroupBaseSearchActivity.this.b.clearFocus();
                return true;
            }
        });
        ej.a(this.c, new ej.e(){

            @Override
            public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                GroupBaseSearchActivity.this.finish();
                return false;
            }

            @Override
            public boolean onMenuItemActionExpand(MenuItem menuItem) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    public static interface QueryTextInterface {
        public void onQueryTextChange(String var1);

        public void onQueryTextSubmit(String var1);
    }

}

