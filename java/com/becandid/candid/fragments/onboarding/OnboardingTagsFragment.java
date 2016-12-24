/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
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
 *  android.widget.TextView
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  butterknife.Unbinder
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.List
 *  java.util.Map
 *  rx.schedulers.Schedulers
 */
package com.becandid.candid.fragments.onboarding;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.becandid.candid.activities.MeSettingsActivity;
import com.becandid.candid.activities.OnboardingActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Config;
import com.becandid.candid.data.DataUtil;
import com.becandid.candid.data.User;
import com.becandid.candid.models.NetworkData;
import com.becandid.candid.views.TagBox;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import rx.schedulers.Schedulers;

public class OnboardingTagsFragment
extends Fragment
implements TagBox.a {
    private Unbinder a;
    private HashSet<String> b;
    private Bundle c;
    @BindView(value=2131624718)
    Button tagCancel;
    @BindView(value=2131624717)
    RelativeLayout tagContainer;
    @BindView(value=2131624719)
    Button tagSubmit;
    @BindView(value=2131624714)
    TextView tagsHeader;

    private void b() {
        this.tagsHeader.setText((CharSequence)AppState.config.getString("tags_header", this.getString(2131230929)));
    }

    private void c() {
        if (AppState.activeTags == null && AppState.account.tags != null) {
            this.b = new HashSet(AppState.account.tags);
        }
        int n2 = this.tagContainer.getChildCount();
        for (int i2 = 0; i2 < n2; ++i2) {
            LinearLayout linearLayout = (LinearLayout)this.tagContainer.getChildAt(i2);
            for (int i3 = 0; i3 < linearLayout.getChildCount(); ++i3) {
                TagBox tagBox = (TagBox)linearLayout.getChildAt(i3);
                if (AppState.account == null || AppState.account.tags == null || !AppState.account.tags.contains((Object)tagBox.getTagName())) continue;
                tagBox.setSelected(true);
                this.tagSubmit.setEnabled(true);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a() {
        this.tagSubmit.setEnabled(false);
        AppState.account.tags = this.b != null && !this.b.isEmpty() ? (AppState.activeTags = new ArrayList(this.b)) : (AppState.activeTags = new ArrayList());
        if (this.c != null && this.c.containsKey(MeSettingsActivity.TAG_SETTINGS_KEY)) {
            HashMap hashMap = new HashMap();
            hashMap.put((Object)"tags", (Object)DataUtil.join(AppState.activeTags));
            ik.a().i((Map<String, String>)hashMap).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

                public void a(NetworkData networkData) {
                    ix.a().a(new in.as(1, networkData.unread_groups_count, true));
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
                    this.a((NetworkData)object);
                }
            });
            this.getActivity().finish();
            return;
        }
        ((OnboardingActivity)this.getActivity()).finishGetGroups();
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void a(View view, String string2) {
        boolean bl2 = !view.isSelected();
        view.setSelected(bl2);
        if (this.b == null) {
            this.b = new HashSet();
        }
        if (!this.b.contains((Object)string2)) {
            this.b.add((Object)string2);
            this.tagSubmit.setEnabled(true);
            return;
        }
        this.b.remove((Object)string2);
        if (this.b.isEmpty()) {
            this.tagSubmit.setEnabled(false);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    /*
     * Enabled aggressive block sorting
     */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = layoutInflater.inflate(2130968727, viewGroup, false);
        this.a = ButterKnife.bind((Object)this, (View)view);
        super.b();
        if (AppState.tags == null) {
            AppState.tags = Arrays.asList((Object[])new String[]{"Politics", "Celebrities", "Music", "Technology", "Fashion", "Business", "School", "Art", "Photography", "LGBT", "Relationships", "Sports", "Funny", "Teens", "Confessions", "Personal", "Sex", "Family", "Work", "Faith", "Food", "Entertainment", "Womens Issues"});
        }
        List<String> list = AppState.tags;
        this.c = this.getArguments();
        if (this.c != null && this.c.containsKey(MeSettingsActivity.TAG_SETTINGS_KEY)) {
            jb.a((Activity)this.getActivity(), this.tagContainer, list);
            this.b = new HashSet(AppState.account.tags);
            if (!this.b.isEmpty()) {
                this.tagSubmit.setEnabled(true);
            }
            this.tagCancel.setVisibility(0);
            this.tagCancel.setOnClickListener(new View.OnClickListener(){

                public void onClick(View view) {
                    OnboardingTagsFragment.this.getActivity().finish();
                }
            });
        } else {
            jb.a((Activity)this.getActivity(), this.tagContainer, list);
        }
        TagBox.setTagClickListener((TagBox.a)this);
        this.tagSubmit.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                OnboardingTagsFragment.this.a();
            }
        });
        return view;
    }

    public void onResume() {
        super.onResume();
        this.c();
    }

}

