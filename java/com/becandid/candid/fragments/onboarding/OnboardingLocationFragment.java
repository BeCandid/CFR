/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.location.Location
 *  android.location.LocationManager
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.FragmentActivity
 *  android.support.v4.app.FragmentManager
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
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.becandid.candid.fragments.onboarding;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
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
import com.becandid.candid.activities.WebViewActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Config;

public class OnboardingLocationFragment
extends Fragment {
    final int a = 0;
    Handler b;
    Runnable c;
    private Unbinder d;
    private boolean e = false;
    private boolean f = false;
    @BindView(value=2131624674)
    Button locationButton;
    @BindView(value=2131624671)
    TextView locationHeader;
    @BindView(value=2131624675)
    TextView locationInfo;
    @BindView(value=2131624672)
    TextView locationSubheader;
    @BindView(value=2131624676)
    TextView privacy;
    @BindView(value=2131624670)
    TextView skip;
    @BindView(value=2131624677)
    FrameLayout spinny;

    public OnboardingLocationFragment() {
        this.c = new Runnable(){

            public void run() {
                if (AppState.location == null) {
                    Toast.makeText((Context)OnboardingLocationFragment.this.getActivity(), (CharSequence)"Location unavailable; we'll try again later", (int)1).show();
                    OnboardingLocationFragment.this.spinny.setVisibility(8);
                    ix.a().a(new in.an("location", "age"));
                }
            }
        };
    }

    private void c() {
        this.locationHeader.setText((CharSequence)AppState.config.getString("location_header", this.getString(2131230869)));
        this.locationSubheader.setText((CharSequence)AppState.config.getString("location_subheader", this.getString(2131230871)));
        this.locationInfo.setText((CharSequence)AppState.config.getString("location_info", this.getString(2131230870)));
        this.privacy.setText((CharSequence)AppState.config.getString("more_info", this.getString(2131230904)));
        this.locationButton.setText((CharSequence)AppState.config.getString("allow_location_button", this.getString(2131230868)));
    }

    public void a() {
        Log.d((String)"Onboarding", (String)"asking for location permission");
        if (bb.checkSelfPermission((Context)this.getActivity(), "android.permission.ACCESS_COARSE_LOCATION") != 0) {
            this.requestPermissions(new String[]{"android.permission.ACCESS_COARSE_LOCATION"}, 0);
            return;
        }
        this.b();
        GossipApplication.a().c();
    }

    public void a(String string2, String string3) {
        FragmentActivity fragmentActivity = this.getActivity();
        if (fragmentActivity instanceof OnboardingActivity) {
            ((OnboardingActivity)fragmentActivity).switchFragment(string2, string3);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void b() {
        if (!((LocationManager)this.getActivity().getSystemService("location")).isProviderEnabled("network")) {
            new AlertDialog.Builder((Context)this.getActivity()).setTitle((CharSequence)"Location Is Disabled").setMessage((CharSequence)"Do you want to enable it?").setPositiveButton(2131230953, new DialogInterface.OnClickListener(){

                public void onClick(DialogInterface dialogInterface, int n2) {
                    OnboardingLocationFragment.this.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                    OnboardingLocationFragment.this.f = true;
                    OnboardingLocationFragment.this.spinny.setVisibility(0);
                }
            }).setNegativeButton(2131230890, null).create().show();
        } else {
            this.spinny.setVisibility(0);
            this.b.postDelayed(this.c, 5000);
        }
        aps aps2 = ix.a().a(in.w.class, new apr<in.w>(){

            public void a(in.w w2) {
                if (!OnboardingLocationFragment.this.e) {
                    OnboardingLocationFragment.this.e = true;
                    Fragment fragment = OnboardingLocationFragment.this.getActivity().getSupportFragmentManager().findFragmentByTag("location");
                    if (fragment != null && fragment.isVisible()) {
                        OnboardingLocationFragment.this.spinny.setVisibility(8);
                        ix.a().a(new in.an("location", "age"));
                    }
                }
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
                this.a((in.w)object);
            }
        });
        ((BaseActivity)this.getActivity()).addToSubscriptionList(aps2);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = layoutInflater.inflate(2130968725, viewGroup, false);
        this.d = ButterKnife.bind((Object)this, (View)view);
        this.b = new Handler(this.getContext().getMainLooper());
        super.c();
        this.privacy.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                Intent intent = new Intent(OnboardingLocationFragment.this.getContext(), (Class)WebViewActivity.class);
                intent.putExtra("title", "Why Can I Trust Candid?");
                intent.putExtra("url", GossipApplication.d + "content/whysafe");
                OnboardingLocationFragment.this.getContext().startActivity(intent);
            }
        });
        this.skip.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                OnboardingLocationFragment.this.a("location", "age");
            }
        });
        this.locationButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                OnboardingLocationFragment.this.a();
            }
        });
        return view;
    }

    public void onPause() {
        super.onPause();
        this.b.removeCallbacks(this.c);
    }

    public void onRequestPermissionsResult(int n2, String[] arrstring, int[] arrn) {
        switch (n2) {
            default: {
                return;
            }
            case 0: 
        }
        if (arrn.length > 0 && arrn[0] == 0) {
            this.b();
            GossipApplication.a().c();
            return;
        }
        Log.d((String)"Permissions", (String)"Unable to get location permission; skip location");
        ix.a().a(new in.an("location", "age"));
    }

    public void onResume() {
        super.onResume();
        Fragment fragment = this.getActivity().getSupportFragmentManager().findFragmentByTag("location");
        if (AppState.location != null && fragment != null && fragment.isVisible() && this.e) {
            this.spinny.setVisibility(8);
            this.a("location", "age");
            return;
        }
        if (fragment != null && fragment.isVisible() && this.f) {
            this.b.postDelayed(this.c, 5000);
            return;
        }
        this.spinny.setVisibility(8);
    }

}

