/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.FragmentActivity
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.ImageView
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  butterknife.OnClick
 *  butterknife.Unbinder
 *  java.lang.Object
 */
package com.becandid.candid.fragments;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.becandid.candid.activities.InviteContactsActivity;
import com.becandid.candid.fragments.InviteContactNameFragment;
import com.becandid.candid.fragments.InviteContactSentFragment;

public class InviteContactMethodFragment
extends Fragment {
    private Unbinder a;
    private Bundle b;
    private boolean c = false;
    private boolean d = false;
    @BindView(value=2131624450)
    ImageView mAnonCheckmark;
    @BindView(value=2131624449)
    View mAnonPlaceHolder;
    @BindView(value=2131624455)
    Button mContinueBtn;
    @BindView(value=2131624453)
    ImageView mKnownCheckmark;
    @BindView(value=2131624452)
    View mKnownPlaceHolder;

    private void a() {
        if (this.d || this.c) {
            this.mContinueBtn.setEnabled(true);
            return;
        }
        this.mContinueBtn.setEnabled(false);
    }

    private void a(boolean bl2) {
        if (bl2) {
            this.mAnonPlaceHolder.setBackground(this.getResources().getDrawable(2130837981));
            this.mAnonCheckmark.setImageDrawable(this.getResources().getDrawable(2130837982));
            return;
        }
        this.mAnonPlaceHolder.setBackground(this.getResources().getDrawable(2130837710));
        this.mAnonCheckmark.setImageDrawable(this.getResources().getDrawable(2130837709));
    }

    private void b(boolean bl2) {
        if (bl2) {
            this.mKnownPlaceHolder.setBackground(this.getResources().getDrawable(2130837981));
            this.mKnownCheckmark.setImageDrawable(this.getResources().getDrawable(2130837982));
            return;
        }
        this.mKnownPlaceHolder.setBackground(this.getResources().getDrawable(2130837710));
        this.mKnownCheckmark.setImageDrawable(this.getResources().getDrawable(2130837709));
    }

    @OnClick(value={2131624445})
    public void onContactClose() {
        this.getActivity().finish();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = layoutInflater.inflate(2130968673, viewGroup, false);
        this.a = ButterKnife.bind((Object)this, (View)view);
        this.b = this.getArguments();
        this.mAnonPlaceHolder.setOnClickListener(new View.OnClickListener(){

            /*
             * Enabled aggressive block sorting
             */
            public void onClick(View view) {
                boolean bl2 = true;
                if (!InviteContactMethodFragment.this.c) {
                    InviteContactMethodFragment.this.a(bl2);
                    InviteContactMethodFragment.this.b(false);
                    InviteContactMethodFragment.this.d = false;
                } else {
                    InviteContactMethodFragment.this.a(false);
                }
                InviteContactMethodFragment inviteContactMethodFragment = InviteContactMethodFragment.this;
                if (InviteContactMethodFragment.this.c) {
                    bl2 = false;
                }
                inviteContactMethodFragment.c = bl2;
                InviteContactMethodFragment.this.a();
            }
        });
        this.mKnownPlaceHolder.setOnClickListener(new View.OnClickListener(){

            /*
             * Enabled aggressive block sorting
             */
            public void onClick(View view) {
                boolean bl2 = true;
                if (!InviteContactMethodFragment.this.d) {
                    InviteContactMethodFragment.this.a(false);
                    InviteContactMethodFragment.this.b(bl2);
                    InviteContactMethodFragment.this.c = false;
                } else {
                    InviteContactMethodFragment.this.b(false);
                }
                InviteContactMethodFragment inviteContactMethodFragment = InviteContactMethodFragment.this;
                if (InviteContactMethodFragment.this.d) {
                    bl2 = false;
                }
                inviteContactMethodFragment.d = bl2;
                InviteContactMethodFragment.this.a();
            }
        });
        this.mContinueBtn.setOnClickListener(new View.OnClickListener(){

            /*
             * Enabled aggressive block sorting
             */
            public void onClick(View view) {
                if (InviteContactMethodFragment.this.c) {
                    InviteContactSentFragment inviteContactSentFragment = new InviteContactSentFragment();
                    if (!(InviteContactMethodFragment.this.getActivity() instanceof InviteContactsActivity)) return;
                    {
                        ((InviteContactsActivity)InviteContactMethodFragment.this.getActivity()).switchFragment(inviteContactSentFragment);
                        return;
                    }
                } else {
                    if (!InviteContactMethodFragment.this.d) return;
                    {
                        InviteContactNameFragment inviteContactNameFragment = new InviteContactNameFragment();
                        if (!(InviteContactMethodFragment.this.getActivity() instanceof InviteContactsActivity)) return;
                        {
                            ((InviteContactsActivity)InviteContactMethodFragment.this.getActivity()).switchFragment(inviteContactNameFragment);
                            return;
                        }
                    }
                }
            }
        });
        return view;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.a.unbind();
    }

}

