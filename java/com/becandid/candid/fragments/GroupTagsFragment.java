/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.FragmentActivity
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.LinearLayout
 *  android.widget.RelativeLayout
 *  android.widget.Toast
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  butterknife.Unbinder
 *  java.io.Serializable
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  rx.schedulers.Schedulers
 */
package com.becandid.candid.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.becandid.candid.activities.CreateGroupActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Group;
import com.becandid.candid.views.TagBox;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import rx.schedulers.Schedulers;

public class GroupTagsFragment
extends Fragment
implements TagBox.a {
    private Unbinder a;
    private Bundle b;
    private List<String> c;
    private boolean d = false;
    @BindView(value=2131624442)
    Button mCreateGroupBtn;
    @BindView(value=2131624191)
    View mProgressBar;
    @BindView(value=2131624437)
    View mTagsPlaceholder;
    @BindView(value=2131624440)
    RelativeLayout mTagsView;

    public void a() {
        final CreateGroupActivity createGroupActivity = (CreateGroupActivity)this.getActivity();
        ik.a().a((Integer)this.b.get("group_id"), createGroupActivity.getmGroupName(), createGroupActivity.getmGroupAbout(), createGroupActivity.getGroupTags(), createGroupActivity.getmGroupSourceUrl()).b(Schedulers.io()).a(apv.a()).b(new apr<Group>(){

            public void a(Group group) {
                for (int i2 = 0; i2 < AppState.groups.size(); ++i2) {
                    if (((Group)AppState.groups.get((int)i2)).group_id != group.group_id) continue;
                    AppState.groups.remove(i2);
                }
                AppState.groups.add((Object)group);
                ix.a().a(new in.t(group));
                Intent intent = new Intent();
                intent.putExtra("group", (Serializable)group);
                createGroupActivity.setResult(-1, intent);
                createGroupActivity.finish();
            }

            @Override
            public void onCompleted() {
                Toast.makeText((Context)GroupTagsFragment.this.getContext(), (CharSequence)"Successfully updated your group", (int)0).show();
            }

            @Override
            public void onError(Throwable throwable) {
                GroupTagsFragment.this.mProgressBar.setVisibility(8);
                Toast.makeText((Context)GroupTagsFragment.this.getContext(), (CharSequence)"Failed to update your group", (int)0).show();
                createGroupActivity.setResult(0);
                GroupTagsFragment.this.getActivity().finish();
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((Group)object);
            }
        });
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void a(View view, String string2) {
        boolean bl2 = true;
        FragmentActivity fragmentActivity = this.getActivity();
        boolean bl3 = fragmentActivity instanceof CreateGroupActivity;
        boolean bl4 = false;
        if (bl3 && (bl4 = ((CreateGroupActivity)fragmentActivity).addTag(string2.toLowerCase()))) {
            boolean bl5 = !view.isSelected() ? bl2 : false;
            view.setSelected(bl5);
        } else {
            Toast.makeText((Context)view.getContext(), (CharSequence)"You can only add three tags", (int)0).show();
        }
        Button button = this.mCreateGroupBtn;
        if (((CreateGroupActivity)fragmentActivity).isTagsEmpty()) {
            bl2 = false;
        }
        button.setEnabled(bl2);
    }

    public void b() {
        final CreateGroupActivity createGroupActivity = (CreateGroupActivity)this.getActivity();
        ik.a().a(createGroupActivity.getmGroupName(), createGroupActivity.getmGroupAbout(), createGroupActivity.getGroupTags(), createGroupActivity.getmGroupSourceUrl()).b(Schedulers.io()).a(apv.a()).b(new apr<Group>(){

            public void a(Group group) {
                AppState.groups.add((Object)group);
                ix.a().a(new in.m(group));
                Intent intent = new Intent();
                intent.putExtra("group", (Serializable)group);
                createGroupActivity.setResult(-1, intent);
                createGroupActivity.finish();
            }

            @Override
            public void onCompleted() {
                Toast.makeText((Context)GroupTagsFragment.this.getContext(), (CharSequence)"Successfully created your group", (int)0).show();
            }

            @Override
            public void onError(Throwable throwable) {
                GroupTagsFragment.this.mProgressBar.setVisibility(8);
                Toast.makeText((Context)GroupTagsFragment.this.getContext(), (CharSequence)"Failed to create a group", (int)0).show();
                createGroupActivity.setResult(0);
                GroupTagsFragment.this.getActivity().finish();
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((Group)object);
            }
        });
    }

    public boolean c() {
        if (this.mProgressBar.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public void d() {
        if (this.c()) {
            this.mProgressBar.setVisibility(8);
            Toast.makeText((Context)this.getContext(), (CharSequence)"Failed to create a group", (int)0).show();
            this.getActivity().setResult(0);
            this.getActivity().finish();
            return;
        }
        this.d = true;
    }

    /*
     * Enabled aggressive block sorting
     */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = layoutInflater.inflate(2130968672, viewGroup, false);
        this.a = ButterKnife.bind((Object)this, (View)view);
        this.b = this.getArguments();
        final CreateGroupActivity createGroupActivity = (CreateGroupActivity)this.getActivity();
        if (createGroupActivity instanceof CreateGroupActivity) {
            createGroupActivity.resetTags();
        }
        this.c = new ArrayList();
        if (this.b.containsKey("tags")) {
            ArrayList arrayList = this.b.getStringArrayList("tags");
            this.c.addAll((Collection)arrayList);
            jb.a((Activity)this.getActivity(), this.mTagsView, AppState.groupTags);
            for (int i2 = 0; i2 < arrayList.size(); ++i2) {
                createGroupActivity.addTag((String)arrayList.get(i2));
            }
            this.mCreateGroupBtn.setText((CharSequence)"Update Group");
            Button button = this.mCreateGroupBtn;
            boolean bl2 = !createGroupActivity.isTagsEmpty();
            button.setEnabled(bl2);
        } else {
            jb.a((Activity)this.getActivity(), this.mTagsView, AppState.groupTags);
        }
        TagBox.setTagClickListener((TagBox.a)this);
        this.mCreateGroupBtn.setOnClickListener(new View.OnClickListener(){

            /*
             * Enabled aggressive block sorting
             */
            public void onClick(View view) {
                GroupTagsFragment.this.mProgressBar.setVisibility(0);
                GroupTagsFragment.this.mTagsPlaceholder.setAlpha(0.3f);
                if (GroupTagsFragment.this.d || createGroupActivity.ismGroupPhotoFailedToUpload()) {
                    GroupTagsFragment.this.d();
                    return;
                }
                if (!createGroupActivity.isGroupPhotoSkipped() && createGroupActivity.getmGroupSourceUrl() == null) return;
                {
                    if (GroupTagsFragment.this.b.containsKey("edit_group")) {
                        GroupTagsFragment.this.a();
                        return;
                    }
                }
                GroupTagsFragment.this.b();
            }
        });
        return view;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.a.unbind();
    }

    public void onResume() {
        super.onResume();
        int n2 = this.mTagsView.getChildCount();
        for (int i2 = 0; i2 < n2; ++i2) {
            LinearLayout linearLayout = (LinearLayout)this.mTagsView.getChildAt(i2);
            for (int i3 = 0; i3 < linearLayout.getChildCount(); ++i3) {
                TagBox tagBox = (TagBox)linearLayout.getChildAt(i3);
                if (!this.c.contains((Object)tagBox.getTagNameLowerCase())) continue;
                tagBox.setSelected(true);
            }
        }
    }

}

