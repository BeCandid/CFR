/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Intent
 *  android.os.Bundle
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.FragmentManager
 *  android.support.v4.app.FragmentTransaction
 *  android.support.v7.app.ActionBar
 *  android.support.v7.widget.Toolbar
 *  android.view.MenuItem
 *  android.view.View
 *  android.widget.FrameLayout
 *  android.widget.TextView
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.Set
 */
package com.becandid.candid.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.fragments.GroupInfoFragment;
import com.becandid.candid.fragments.GroupNameFragment;
import com.becandid.candid.fragments.GroupTagsFragment;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CreateGroupActivity
extends BaseActivity {
    private Set<String> b;
    private String c;
    private String d;
    private String e;
    private boolean f = true;
    private boolean g = false;
    private Bundle h;
    @BindView(value=2131624107)
    FrameLayout mPlaceholder;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean addTag(String string2) {
        if (this.b == null) {
            this.b = new HashSet();
        }
        if (this.b.contains((Object)string2.toLowerCase())) {
            this.b.remove((Object)string2.toLowerCase());
            return true;
        }
        int n2 = this.b.size();
        boolean bl2 = false;
        if (n2 >= 3) return bl2;
        this.b.add((Object)string2);
        return true;
    }

    public String getGroupTags() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator iterator = this.b.iterator();
        while (iterator.hasNext()) {
            stringBuilder.append((String)iterator.next());
            stringBuilder.append(',');
        }
        return stringBuilder.toString();
    }

    public String getmGroupAbout() {
        return this.d;
    }

    public String getmGroupName() {
        return this.c;
    }

    public String getmGroupSourceUrl() {
        return this.e;
    }

    public boolean isGroupPhotoSkipped() {
        return this.f;
    }

    public boolean isTagsEmpty() {
        if (this.b.size() == 0) {
            return true;
        }
        return false;
    }

    public boolean ismGroupPhotoFailedToUpload() {
        return this.g;
    }

    @Override
    protected void onActivityResult(int n2, int n3, Intent intent) {
        super.onActivityResult(n2, n3, intent);
        Fragment fragment = this.getSupportFragmentManager().findFragmentById(2131624107);
        if (fragment != null && fragment instanceof GroupInfoFragment) {
            this.setGroupPhotoSkipped(false);
            ((GroupInfoFragment)fragment).a();
        }
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130968606);
        ButterKnife.bind((Activity)this);
        this.h = this.getIntent().getExtras();
        if (this.h == null) {
            this.h = new Bundle();
        }
        this.setSupportActionBar((Toolbar)this.findViewById(2131624081));
        this.getSupportActionBar().setDisplayShowTitleEnabled(false);
        if (this.h.containsKey("edit_group")) {
            ((TextView)this.findViewById(2131624082)).setText((CharSequence)"Edit Group");
        }
        if (this.mPlaceholder != null) {
            if (bundle != null) {
                return;
            }
            GroupNameFragment groupNameFragment = new GroupNameFragment();
            groupNameFragment.setArguments(this.h);
            this.getSupportFragmentManager().beginTransaction().add(2131624107, (Fragment)groupNameFragment).commit();
        }
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setHomeAsUpIndicator(2130837589);
        ix.a().a(in.at.class, new apr<in.at>(){

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
            }

            @Override
            public void onNext(in.at at2) {
                CreateGroupActivity.this.setGroupSourceUrl(at2.a);
                Fragment fragment = CreateGroupActivity.this.getSupportFragmentManager().findFragmentById(2131624107);
                if (fragment != null && fragment instanceof GroupTagsFragment && ((GroupTagsFragment)fragment).c()) {
                    ((GroupTagsFragment)fragment).b();
                }
            }
        });
        ix.a().a(in.ab.class, new apr<in.ab>(){

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
            }

            @Override
            public void onNext(in.ab ab2) {
                Fragment fragment = CreateGroupActivity.this.getSupportFragmentManager().findFragmentById(2131624107);
                if (fragment != null && fragment instanceof GroupTagsFragment) {
                    ((GroupTagsFragment)fragment).d();
                    return;
                }
                CreateGroupActivity.this.setmGroupPhotoFailedToUpload(true);
            }
        });
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            default: {
                return super.onOptionsItemSelected(menuItem);
            }
            case 16908332: 
        }
        int n2 = this.getSupportFragmentManager().getBackStackEntryCount();
        boolean bl2 = false;
        if (n2 != 0) return bl2;
        this.setResult(0);
        this.finish();
        return true;
    }

    @Override
    public void onPhotoChosen(String string2, int n2, int n3) {
        super.onPhotoChosen(string2, n2, n3);
        Fragment fragment = this.getSupportFragmentManager().findFragmentById(2131624107);
        if (fragment != null && fragment instanceof GroupInfoFragment) {
            this.setGroupPhotoSkipped(false);
            ((GroupInfoFragment)fragment).a();
            this.setGroupSourceUrl(string2);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public boolean onSupportNavigateUp() {
        this.getSupportFragmentManager().popBackStack();
        return true;
    }

    public void resetTags() {
        if (this.b != null) {
            this.b.clear();
        }
    }

    public void setGroupAbout(String string2) {
        this.d = string2;
    }

    public void setGroupName(String string2) {
        this.c = string2;
    }

    public void setGroupPhotoSkipped(boolean bl2) {
        this.f = bl2;
    }

    public void setGroupSourceUrl(String string2) {
        this.e = string2;
    }

    public void setmGroupPhotoFailedToUpload(boolean bl2) {
        this.g = bl2;
    }

}

