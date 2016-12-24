/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.FragmentActivity
 *  android.support.v4.app.FragmentManager
 *  android.support.v4.app.FragmentTransaction
 *  android.support.v7.widget.AppCompatEditText
 *  android.text.Editable
 *  android.text.TextWatcher
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.Window
 *  android.view.inputmethod.InputMethodManager
 *  android.widget.Button
 *  android.widget.ImageView
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  butterknife.Unbinder
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.becandid.candid.fragments;

import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.becandid.candid.activities.InviteContactsActivity;
import com.becandid.candid.fragments.InviteContactSentFragment;

public class InviteContactNameFragment
extends Fragment {
    private Unbinder a;
    @BindView(value=2131624067)
    ImageView mBackNav;
    @BindView(value=2131624459)
    AppCompatEditText mInviteName;
    @BindView(value=2131624460)
    Button mSendText;

    public void backNavClick(View view) {
        this.getActivity().onBackPressed();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = layoutInflater.inflate(2130968674, viewGroup, false);
        this.a = ButterKnife.bind((Object)this, (View)view);
        this.mInviteName.addTextChangedListener(new TextWatcher(){

            public void afterTextChanged(Editable editable) {
                if (editable.toString().isEmpty()) {
                    InviteContactNameFragment.this.mSendText.setEnabled(false);
                    return;
                }
                InviteContactNameFragment.this.mSendText.setEnabled(true);
            }

            public void beforeTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
            }

            public void onTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
            }
        });
        this.mSendText.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                if (InviteContactNameFragment.this.getActivity() instanceof InviteContactsActivity) {
                    ((InviteContactsActivity)InviteContactNameFragment.this.getActivity()).setSendInviteName(InviteContactNameFragment.this.mInviteName.getText().toString());
                    InviteContactSentFragment inviteContactSentFragment = new InviteContactSentFragment();
                    FragmentTransaction fragmentTransaction = InviteContactNameFragment.this.getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.setCustomAnimations(2131034128, 2131034129, 2131034130, 2131034131);
                    fragmentTransaction.replace(2131624107, (Fragment)inviteContactSentFragment, "SENT_FRAGMENT");
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            }
        });
        return view;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.getActivity().getWindow().setSoftInputMode(3);
    }

    public void onPause() {
        super.onPause();
        ((InputMethodManager)this.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.getView().getWindowToken(), 0);
    }

}

