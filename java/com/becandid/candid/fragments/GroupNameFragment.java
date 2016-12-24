/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.os.Bundle
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.FragmentActivity
 *  android.support.v4.app.FragmentManager
 *  android.support.v4.app.FragmentTransaction
 *  android.support.v7.app.AlertDialog
 *  android.support.v7.app.AlertDialog$Builder
 *  android.text.Editable
 *  android.text.TextWatcher
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.EditText
 *  android.widget.TextView
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  butterknife.Unbinder
 *  java.io.Serializable
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  rx.schedulers.Schedulers
 */
package com.becandid.candid.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.becandid.candid.activities.CreateGroupActivity;
import com.becandid.candid.activities.GroupDetailsActivity;
import com.becandid.candid.data.Group;
import com.becandid.candid.fragments.GroupInfoFragment;
import com.becandid.candid.models.GroupNameCheck;
import java.io.Serializable;
import rx.schedulers.Schedulers;

public class GroupNameFragment
extends Fragment {
    private Bundle a;
    private Unbinder b;
    @BindView(value=2131624435)
    TextView groupNameHeader;
    @BindView(value=2131624110)
    EditText groupNameInfo;
    @BindView(value=2131624434)
    View mNamePlaceholder;
    @BindView(value=2131624191)
    View mProgressBar;
    @BindView(value=2131624436)
    Button nextBtn;

    private void a() {
        FragmentActivity fragmentActivity = this.getActivity();
        jb.a((Context)fragmentActivity);
        if (fragmentActivity instanceof CreateGroupActivity) {
            ((CreateGroupActivity)fragmentActivity).setGroupName(this.groupNameInfo.getText().toString());
        }
        GroupInfoFragment groupInfoFragment = new GroupInfoFragment();
        groupInfoFragment.setArguments(this.a);
        FragmentTransaction fragmentTransaction = this.getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(2131034128, 2131034129, 2131034130, 2131034131);
        fragmentTransaction.replace(2131624107, (Fragment)groupInfoFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = layoutInflater.inflate(2130968671, viewGroup, false);
        this.b = ButterKnife.bind((Object)this, (View)view);
        this.a = this.getArguments();
        if (this.a.containsKey("group_name")) {
            this.groupNameHeader.setText((CharSequence)"Group Name");
            this.groupNameInfo.setText((CharSequence)this.a.getString("group_name"));
            this.groupNameInfo.setSelection(this.a.getString("group_name").length());
            this.nextBtn.setEnabled(true);
        }
        this.groupNameInfo.addTextChangedListener(new TextWatcher(){

            public void afterTextChanged(Editable editable) {
                if (editable.toString() == null || editable.toString().isEmpty()) {
                    GroupNameFragment.this.nextBtn.setEnabled(false);
                    return;
                }
                GroupNameFragment.this.nextBtn.setEnabled(true);
            }

            public void beforeTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
            }

            public void onTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
            }
        });
        this.nextBtn.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                GroupNameFragment.this.mProgressBar.setVisibility(0);
                GroupNameFragment.this.mNamePlaceholder.setAlpha(0.3f);
                String string2 = GroupNameFragment.this.groupNameInfo.getText().toString();
                final boolean bl2 = GroupNameFragment.this.getActivity().getIntent().getBooleanExtra("for_post", false);
                if (GroupNameFragment.this.a.containsKey("group_name") && string2.equals(GroupNameFragment.this.a.get("group_name"))) {
                    GroupNameFragment.this.a();
                    return;
                }
                ik.a().a(string2, bl2).b(Schedulers.io()).a(apv.a()).b(new apr<GroupNameCheck>(){

                    /*
                     * Enabled aggressive block sorting
                     */
                    public void a(final GroupNameCheck groupNameCheck) {
                        if (groupNameCheck.isSuccess()) {
                            GroupNameFragment.this.a();
                            return;
                        }
                        String string2 = groupNameCheck.getError();
                        final int n2 = groupNameCheck.getGroupId();
                        boolean bl22 = groupNameCheck.getGroupName() != null;
                        AlertDialog.Builder builder = new AlertDialog.Builder((Context)GroupNameFragment.this.getActivity());
                        builder.setMessage((CharSequence)string2);
                        if (bl22) {
                            builder.setPositiveButton(2131230953, new DialogInterface.OnClickListener(){

                                /*
                                 * Enabled aggressive block sorting
                                 */
                                public void onClick(DialogInterface dialogInterface, int n22) {
                                    dialogInterface.dismiss();
                                    if (bl2) {
                                        Intent intent = new Intent();
                                        Group group = new Group();
                                        group.group_id = groupNameCheck.getGroupId();
                                        group.group_name = groupNameCheck.getGroupName();
                                        intent.putExtra("group", (Serializable)group);
                                        GroupNameFragment.this.getActivity().setResult(-1, intent);
                                    } else {
                                        GroupNameFragment.this.getActivity().startActivity(GroupDetailsActivity.startGroupDetailsActivity(GroupNameFragment.this.getContext(), n2));
                                    }
                                    GroupNameFragment.this.getActivity().finish();
                                }
                            }).setNegativeButton(2131230890, new DialogInterface.OnClickListener(){

                                public void onClick(DialogInterface dialogInterface, int n2) {
                                    GroupNameFragment.this.mProgressBar.setVisibility(8);
                                    GroupNameFragment.this.mNamePlaceholder.setAlpha(1.0f);
                                    dialogInterface.dismiss();
                                }
                            });
                        } else {
                            builder.setNeutralButton(2131230895, new DialogInterface.OnClickListener(){

                                public void onClick(DialogInterface dialogInterface, int n2) {
                                    GroupNameFragment.this.mProgressBar.setVisibility(8);
                                    GroupNameFragment.this.mNamePlaceholder.setAlpha(1.0f);
                                    dialogInterface.dismiss();
                                }
                            });
                        }
                        AlertDialog alertDialog = builder.create();
                        alertDialog.setCanceledOnTouchOutside(false);
                        alertDialog.setCancelable(false);
                        alertDialog.show();
                    }

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable throwable) {
                    }

                    @Override
                    public /* synthetic */ void onNext(Object object) {
                        this.a((GroupNameCheck)object);
                    }

                });
            }

        });
        return view;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.b.unbind();
    }

}

