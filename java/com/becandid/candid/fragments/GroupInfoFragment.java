/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.os.Bundle
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.FragmentActivity
 *  android.support.v4.app.FragmentManager
 *  android.support.v4.app.FragmentTransaction
 *  android.text.Editable
 *  android.text.TextWatcher
 *  android.util.DisplayMetrics
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.EditText
 *  android.widget.ImageView
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  butterknife.Unbinder
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.becandid.candid.fragments;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.activities.CreateGroupActivity;
import com.becandid.candid.fragments.GroupTagsFragment;
import com.becandid.candid.models.NetworkData;
import com.becandid.candid.util.RoundedCornersTransformation;

public class GroupInfoFragment
extends Fragment
implements View.OnClickListener {
    private RoundedCornersTransformation a;
    private it b;
    private Unbinder c;
    private Bundle d;
    @BindView(value=2131624429)
    View mChoosePhotoPlaceholder;
    @BindView(value=2131624428)
    EditText mGroupInfo;
    @BindView(value=2131624430)
    ImageView mGroupPhoto;
    @BindView(value=2131624432)
    Button mNextBtn;
    @BindView(value=2131624433)
    Button mSkipBtn;

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void a() {
        if (this.b == null) {
            return;
        }
        if (this.b.f != null && this.b.b != null && this.b.a != null) {
            Bitmap bitmap = this.a.a(this.b.f, this.mGroupPhoto.getWidth(), this.mGroupPhoto.getHeight()).b();
            this.mGroupPhoto.setImageBitmap(bitmap);
            this.b.a();
            aps aps2 = ix.a().a(in.ak.class, new apr<in.ak>(){

                public void a(in.ak ak2) {
                    if (ak2.b) {
                        ix.a().a(new in.at(ak2.a.full_url));
                        return;
                    }
                    if (ak2.c != null) {
                        ix.a().a(new in.ab(ak2.c));
                        return;
                    }
                    ix.a().a(new in.ab("S3 upload failure"));
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
                    this.a((in.ak)object);
                }
            });
            ((BaseActivity)this.getActivity()).addToSubscriptionList(aps2);
            return;
        }
        if (this.b.b == null) return;
        js<String> js2 = GossipApplication.c.a(this.b.b).j();
        kr[] arrkr = new kr[]{this.a};
        js2.a(arrkr).a(this.mGroupPhoto);
    }

    public void a(it it2) {
        this.b = it2;
    }

    public void choosePhoto() {
        FragmentActivity fragmentActivity;
        if (this.b == null) {
            this.b = new it((BaseActivity)this.getActivity());
        }
        if ((fragmentActivity = this.getActivity()) instanceof CreateGroupActivity) {
            this.b.choosePhoto(((CreateGroupActivity)fragmentActivity).getmGroupName());
            return;
        }
        this.b.choosePhoto();
    }

    public void onClick(View view) {
        this.choosePhoto();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = layoutInflater.inflate(2130968670, viewGroup, false);
        this.c = ButterKnife.bind((Object)this, (View)view);
        this.d = this.getArguments();
        this.mChoosePhotoPlaceholder.setOnClickListener((View.OnClickListener)this);
        float f2 = this.getResources().getDisplayMetrics().density;
        this.a = new RoundedCornersTransformation(this.getContext(), (int)(100.0f * f2), 0, RoundedCornersTransformation.CornerType.a);
        if (this.d.containsKey("group_info")) {
            this.mGroupInfo.setText((CharSequence)this.d.getString("group_info"));
            this.mGroupInfo.setSelection(this.d.getString("group_info").length());
            this.mNextBtn.setEnabled(true);
        }
        this.mGroupInfo.addTextChangedListener(new TextWatcher(){

            public void afterTextChanged(Editable editable) {
                if (editable.toString().isEmpty()) {
                    GroupInfoFragment.this.mNextBtn.setEnabled(false);
                    return;
                }
                GroupInfoFragment.this.mNextBtn.setEnabled(true);
            }

            public void beforeTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
            }

            public void onTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
            }
        });
        this.a(((BaseActivity)this.getActivity()).getPhotoHelper());
        if (this.d.containsKey("source_url")) {
            this.b.choosePhoto(this.d.getString("source_url"), 0, 0);
            this.mNextBtn.setEnabled(true);
        }
        this.mSkipBtn.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                FragmentActivity fragmentActivity = GroupInfoFragment.this.getActivity();
                jb.a((Context)fragmentActivity);
                if (fragmentActivity instanceof CreateGroupActivity) {
                    ((CreateGroupActivity)fragmentActivity).setGroupPhotoSkipped(true);
                    ((CreateGroupActivity)fragmentActivity).setGroupSourceUrl(null);
                }
                GroupTagsFragment groupTagsFragment = new GroupTagsFragment();
                groupTagsFragment.setArguments(GroupInfoFragment.this.d);
                FragmentTransaction fragmentTransaction = GroupInfoFragment.this.getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(2131034128, 2131034129, 2131034130, 2131034131);
                fragmentTransaction.replace(2131624107, (Fragment)groupTagsFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        this.mNextBtn.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                FragmentActivity fragmentActivity = GroupInfoFragment.this.getActivity();
                jb.a((Context)fragmentActivity);
                if (fragmentActivity instanceof CreateGroupActivity) {
                    ((CreateGroupActivity)fragmentActivity).setGroupAbout(GroupInfoFragment.this.mGroupInfo.getText().toString());
                }
                GroupTagsFragment groupTagsFragment = new GroupTagsFragment();
                groupTagsFragment.setArguments(GroupInfoFragment.this.d);
                FragmentTransaction fragmentTransaction = GroupInfoFragment.this.getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(2131034128, 2131034129, 2131034130, 2131034131);
                fragmentTransaction.replace(2131624107, (Fragment)groupTagsFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return view;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.c.unbind();
    }

}

