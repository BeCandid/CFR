/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.os.Bundle
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.FragmentActivity
 *  android.support.v7.app.AlertDialog
 *  android.support.v7.app.AlertDialog$Builder
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.FrameLayout
 *  android.widget.TextView
 *  android.widget.Toast
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  butterknife.Unbinder
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.Map
 *  rx.schedulers.Schedulers
 */
package com.becandid.candid.fragments.onboarding;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.activities.OnboardingActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Config;
import com.becandid.candid.data.ContactsInfo;
import com.becandid.candid.data.DataUtil;
import com.becandid.candid.data.User;
import com.becandid.candid.models.NetworkData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import rx.schedulers.Schedulers;

public class OnboardingContactsFragment
extends Fragment {
    final int a = 1;
    String b;
    private Unbinder c;
    @BindView(value=2131624640)
    Button contactsButton;
    @BindView(value=2131624089)
    TextView contactsHeader;
    @BindView(value=2131624638)
    TextView contactsSubheader;
    @BindView(value=2131624639)
    TextView contactsSubheader2;
    @BindView(value=2131624637)
    TextView skip;
    @BindView(value=2131624093)
    FrameLayout spinny;

    private void c() {
        this.contactsHeader.setText((CharSequence)AppState.config.getString("contacts_header", this.getString(2131230820)));
        this.contactsSubheader.setText((CharSequence)AppState.config.getString("contacts_subheader", this.getString(2131230821)));
        this.contactsSubheader2.setText((CharSequence)AppState.config.getString("contacts_subheader_2", ""));
        if (this.contactsSubheader2.getText().equals((Object)"")) {
            this.contactsSubheader2.setVisibility(8);
        }
        this.contactsButton.setText((CharSequence)AppState.config.getString("contacts_button", this.getString(2131230819)));
    }

    private void d() {
        GossipApplication.a().d();
        if (this.b != null) {
            this.b();
            if (this.b.equals((Object)"fb")) {
                Bundle bundle = new Bundle();
                bundle.putString("second_fragment", this.b);
                ((OnboardingActivity)this.getActivity()).switchFragment("contacts", this.b, bundle);
                return;
            }
            this.getActivity().setResult(-1);
            ((OnboardingActivity)this.getActivity()).finish();
            return;
        }
        this.e();
    }

    private void e() {
        this.spinny.setVisibility(0);
        ik.a().e().b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public void a(NetworkData networkData) {
                AppState.saveState((ContextWrapper)GossipApplication.a());
                OnboardingContactsFragment.this.spinny.setVisibility(8);
                if (!networkData.success) return;
                if (networkData.is_new_user) {
                    ix.a().a(new in.an("contacts", "location"));
                    return;
                }
                ((OnboardingActivity)OnboardingContactsFragment.this.getActivity()).finishSyncAccount();
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                OnboardingContactsFragment.this.spinny.setVisibility(8);
                rj.a(throwable);
                Toast.makeText((Context)OnboardingContactsFragment.this.getActivity(), (int)2131230926, (int)0).show();
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((NetworkData)object);
            }
        });
    }

    public void a() {
        Log.d((String)"Onboarding", (String)"asking for contacts permission");
        if (bb.checkSelfPermission((Context)this.getActivity(), "android.permission.READ_CONTACTS") != 0) {
            this.requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 1);
            return;
        }
        this.d();
    }

    public void b() {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"type", (Object)"phone");
        hashMap.put((Object)"id_list", (Object)DataUtil.join(AppState.contactsInfo.contacts));
        ik.a().c((Map<String, String>)hashMap).b(Schedulers.io()).a(apv.a()).b(new apr<ain>(){

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public void a(ain ain2) {
                try {
                    int n2;
                    AppState.account.num_phone_friends = n2 = ain2.b("num_phone_friends").g();
                    if (AppState.account != null) {
                        rk.c().a((ru)((ru)new ru("Connect Phone Contacts").a("success", "true")).a("logged_in", "true"));
                    } else {
                        rk.c().a((ru)((ru)new ru("Connect Phone Contacts").a("success", "true")).a("logged_in", "false"));
                    }
                    AppState.saveState((ContextWrapper)GossipApplication.a());
                    ix.a().a(new in.au());
                    return;
                }
                catch (UnsupportedOperationException var2_3) {
                    AppState.account.num_phone_friends = 0;
                    return;
                }
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                Log.d((String)"ContactsSync", (String)throwable.toString());
                if (AppState.account != null) {
                    rk.c().a((ru)((ru)new ru("Connect Phone Contacts").a("success", "false")).a("logged_in", "true"));
                    return;
                }
                rk.c().a((ru)((ru)new ru("Connect Phone Contacts").a("success", "false")).a("logged_in", "false"));
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((ain)object);
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle bundle2 = this.getArguments();
        if (bundle2 != null) {
            this.b = bundle2.getString("second_fragment");
        }
        aps aps2 = ix.a().a(in.am.class, new apr<in.am>(){

            public void a(in.am am2) {
                OnboardingContactsFragment.this.d();
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
                this.a((in.am)object);
            }
        });
        ((BaseActivity)this.getActivity()).addToSubscriptionList(aps2);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = layoutInflater.inflate(2130968723, viewGroup, false);
        this.c = ButterKnife.bind((Object)this, (View)view);
        super.c();
        if (AppState.config.getInt("show_contacts_skip_android", 0) == 1) {
            this.skip.setVisibility(0);
            this.skip.setOnClickListener(new View.OnClickListener(){

                /*
                 * Enabled aggressive block sorting
                 */
                public void onClick(View view) {
                    if (AppState.account != null) {
                        rk.c().a((ru)new ru("Skip Phone Contacts").a("logged_in", "true"));
                    } else {
                        rk.c().a((ru)new ru("Skip Phone Contacts").a("logged_in", "false"));
                    }
                    if (OnboardingContactsFragment.this.b == null) {
                        OnboardingContactsFragment.this.e();
                        return;
                    }
                    if (OnboardingContactsFragment.this.b.equals((Object)"fb")) {
                        Bundle bundle = new Bundle();
                        bundle.putString("second_fragment", OnboardingContactsFragment.this.b);
                        ((OnboardingActivity)OnboardingContactsFragment.this.getActivity()).switchFragment("contacts", OnboardingContactsFragment.this.b, bundle);
                        return;
                    }
                    OnboardingContactsFragment.this.getActivity().setResult(-1);
                    ((OnboardingActivity)OnboardingContactsFragment.this.getActivity()).finish();
                }
            });
        }
        this.contactsButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                OnboardingContactsFragment.this.a();
            }
        });
        return view;
    }

    public void onRequestPermissionsResult(int n2, String[] arrstring, int[] arrn) {
        switch (n2) {
            default: {
                return;
            }
            case 1: 
        }
        if (arrn.length > 0 && arrn[0] == 0) {
            ix.a().a(new in.am());
            return;
        }
        Log.d((String)"Permissions", (String)"Unable to get contacts permission");
        if (AppState.config == null || AppState.config.getBoolean("android_contacts_required", true)) {
            AlertDialog.Builder builder = new AlertDialog.Builder((Context)this.getActivity());
            String string2 = "Contacts can be added later, but only to let you know which posts are from your friends.";
            if (AppState.config != null && AppState.config.has("android_contacts_required_message")) {
                string2 = AppState.config.getString("android_contacts_required_message");
            }
            builder.setMessage((CharSequence)string2);
            builder.setNeutralButton(2131230895, new DialogInterface.OnClickListener(){

                public void onClick(DialogInterface dialogInterface, int n2) {
                    dialogInterface.dismiss();
                    if (OnboardingContactsFragment.this.b != null) {
                        if (OnboardingContactsFragment.this.b.equals((Object)"fb")) {
                            Bundle bundle = new Bundle();
                            bundle.putString("second_fragment", OnboardingContactsFragment.this.b);
                            ix.a().a(new in.an("contacts", OnboardingContactsFragment.this.b, bundle));
                            return;
                        }
                        OnboardingContactsFragment.this.getActivity().setResult(-1);
                        ((OnboardingActivity)OnboardingContactsFragment.this.getActivity()).finish();
                        return;
                    }
                    OnboardingContactsFragment.this.e();
                }
            });
            builder.create().show();
            return;
        }
        if (this.b != null) {
            if (this.b.equals((Object)"fb")) {
                Bundle bundle = new Bundle();
                bundle.putString("second_fragment", this.b);
                ix.a().a(new in.an("contacts", this.b, bundle));
                return;
            }
            this.getActivity().setResult(-1);
            ((OnboardingActivity)this.getActivity()).finish();
            return;
        }
        super.e();
    }

}

