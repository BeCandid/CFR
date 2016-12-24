/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.FragmentActivity
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  butterknife.ButterKnife
 *  butterknife.OnClick
 *  butterknife.Unbinder
 *  java.lang.Object
 */
package com.becandid.candid.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.becandid.candid.activities.InviteContactsActivity;

public class InviteContactSentFragment
extends Fragment {
    private Unbinder a;
    private Bundle b;

    @OnClick(value={2131624470})
    public void onClose() {
        this.getActivity().finish();
    }

    @OnClick(value={2131624445})
    public void onContactClose() {
        this.getActivity().finish();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = layoutInflater.inflate(2130968676, viewGroup, false);
        this.a = ButterKnife.bind((Object)this, (View)view);
        this.b = this.getArguments();
        if (this.getActivity() instanceof InviteContactsActivity) {
            ((InviteContactsActivity)this.getActivity()).sendContactsToServer();
        }
        return view;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.a.unbind();
    }
}

