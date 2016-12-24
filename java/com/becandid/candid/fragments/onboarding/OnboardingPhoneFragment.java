/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.graphics.Rect
 *  android.os.Bundle
 *  android.os.Handler
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.FragmentActivity
 *  android.support.v4.app.FragmentManager
 *  android.telephony.TelephonyManager
 *  android.text.Editable
 *  android.text.TextWatcher
 *  android.util.DisplayMetrics
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.animation.AccelerateDecelerateInterpolator
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 *  android.view.animation.Interpolator
 *  android.view.animation.TranslateAnimation
 *  android.widget.Button
 *  android.widget.EditText
 *  android.widget.FrameLayout
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  android.widget.Toast
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  butterknife.Unbinder
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  rx.schedulers.Schedulers
 */
package com.becandid.candid.fragments.onboarding;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
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
import com.becandid.candid.data.ContactsInfo;
import com.becandid.candid.data.User;
import com.becandid.candid.models.NetworkData;
import rx.schedulers.Schedulers;

public class OnboardingPhoneFragment
extends Fragment {
    String a;
    private Unbinder b;
    @BindView(value=2131624683)
    TextView countryCode;
    @BindView(value=2131624684)
    EditText phone;
    @BindView(value=2131624680)
    TextView phoneHeader;
    @BindView(value=2131624710)
    TextView phoneInfo;
    @BindView(value=2131624711)
    TextView phonePrivacy;
    @BindView(value=2131624681)
    TextView phoneSubheader;
    @BindView(value=2131624685)
    Button phoneSubmit;
    @BindView(value=2131624679)
    TextView skip;
    @BindView(value=2131624712)
    FrameLayout spinny;
    @BindView(value=2131624686)
    RelativeLayout wrapper;

    /*
     * Enabled aggressive block sorting
     */
    private void a(final String string2) {
        AppState.contactsInfo = null;
        ((BaseActivity)this.getActivity()).closeKeyboard();
        if (AppState.account != null) {
            rk.c().a((ru)new ru("Skip Phone Number").a("logged_in", "true"));
        } else {
            rk.c().a((ru)new ru("Skip Phone Number").a("logged_in", "false"));
        }
        if (this.a == null) {
            this.spinny.setVisibility(0);
            ik.a().e().b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

                /*
                 * Enabled force condition propagation
                 * Lifted jumps to return sites
                 */
                public void a(NetworkData networkData) {
                    AppState.saveState((ContextWrapper)GossipApplication.a());
                    OnboardingPhoneFragment.this.spinny.setVisibility(8);
                    if (!networkData.success) return;
                    if (networkData.is_new_user) {
                        ix.a().a(new in.an("phone", string2));
                        return;
                    }
                    ((OnboardingActivity)OnboardingPhoneFragment.this.getActivity()).finishSyncAccount();
                }

                @Override
                public void onCompleted() {
                }

                @Override
                public void onError(Throwable throwable) {
                    OnboardingPhoneFragment.this.spinny.setVisibility(8);
                    rj.a(throwable);
                    Toast.makeText((Context)OnboardingPhoneFragment.this.getActivity(), (int)2131230926, (int)0).show();
                }

                @Override
                public /* synthetic */ void onNext(Object object) {
                    this.a((NetworkData)object);
                }
            });
            return;
        }
        if (this.a.equals((Object)"fb")) {
            Bundle bundle = new Bundle();
            bundle.putString("second_fragment", this.a);
            ((OnboardingActivity)this.getActivity()).switchFragment("phone", this.a, bundle);
            return;
        }
        this.getActivity().setResult(-1);
        ((OnboardingActivity)this.getActivity()).finish();
    }

    private void c() {
        this.phoneHeader.setText((CharSequence)AppState.config.getString("phone_header", this.getString(2131230896)));
        this.phoneSubheader.setText((CharSequence)AppState.config.getString("phone_subheader", this.getString(2131230899)));
        this.phone.setHint((CharSequence)AppState.config.getString("phone_input", this.getString(2131230898)));
        this.phonePrivacy.setText((CharSequence)AppState.config.getString("more_info", this.getString(2131230904)));
        this.phoneInfo.setText((CharSequence)AppState.config.getString("phone_info", this.getString(2131230897)));
    }

    public Animation a(int n2, int n3, int n4, final int n5, final View view) {
        float f2 = this.getResources().getDisplayMetrics().density;
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0.0f, 0, f2 * (float)n2, 0, 0.0f, 0, f2 * (float)n3);
        translateAnimation.setInterpolator((Interpolator)new AccelerateDecelerateInterpolator());
        translateAnimation.setDuration(200);
        translateAnimation.setStartOffset((long)(n4 + 1000));
        translateAnimation.setFillAfter(true);
        translateAnimation.setFillEnabled(true);
        translateAnimation.setAnimationListener(new Animation.AnimationListener(){

            public void onAnimationEnd(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                new Handler().postDelayed(new Runnable(){

                    public void run() {
                        view.findViewById(n5).setVisibility(0);
                    }
                }, 1000);
            }

        });
        return translateAnimation;
    }

    public void a(View view) {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, -0.5f, 0, 0.0f, 0, 0.0f);
        translateAnimation.setDuration(200);
        translateAnimation.setStartOffset(800);
        translateAnimation.setFillAfter(true);
        translateAnimation.setFillEnabled(true);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 0.5f, 0, 0.0f, 0, 0.0f);
        translateAnimation2.setDuration(200);
        translateAnimation2.setStartOffset(800);
        translateAnimation2.setFillAfter(true);
        translateAnimation2.setFillEnabled(true);
        Animation animation = this.a(-45, -10, 0, 2131624691, view);
        Animation animation2 = this.a(-28, -20, 60, 2131624692, view);
        Animation animation3 = this.a(-23, -35, 30, 2131624693, view);
        Animation animation4 = this.a(-2, -35, 80, 2131624694, view);
        Animation animation5 = this.a(18, -30, 120, 2131624695, view);
        Animation animation6 = this.a(16, 30, 30, 2131624696, view);
        Animation animation7 = this.a(-2, 35, 100, 2131624697, view);
        Animation animation8 = this.a(-30, 23, 40, 2131624698, view);
        Animation animation9 = this.a(-35, 8, 130, 2131624699, view);
        Animation animation10 = this.a(-15, -38, 180, 2131624700, view);
        Animation animation11 = this.a(3, -34, 60, 2131624701, view);
        Animation animation12 = this.a(22, -28, 80, 2131624702, view);
        Animation animation13 = this.a(29, -10, 140, 2131624703, view);
        Animation animation14 = this.a(30, 8, 40, 2131624704, view);
        Animation animation15 = this.a(20, 24, 50, 2131624705, view);
        Animation animation16 = this.a(4, 32, 110, 2131624706, view);
        Animation animation17 = this.a(-16, 32, 30, 2131624707, view);
        view.findViewById(2131624708).startAnimation((Animation)translateAnimation);
        view.findViewById(2131624709).startAnimation((Animation)translateAnimation2);
        view.findViewById(2131624691).startAnimation(animation);
        view.findViewById(2131624692).startAnimation(animation2);
        view.findViewById(2131624693).startAnimation(animation3);
        view.findViewById(2131624694).startAnimation(animation4);
        view.findViewById(2131624695).startAnimation(animation5);
        view.findViewById(2131624696).startAnimation(animation6);
        view.findViewById(2131624697).startAnimation(animation7);
        view.findViewById(2131624698).startAnimation(animation8);
        view.findViewById(2131624699).startAnimation(animation9);
        view.findViewById(2131624700).startAnimation(animation10);
        view.findViewById(2131624701).startAnimation(animation11);
        view.findViewById(2131624702).startAnimation(animation12);
        view.findViewById(2131624703).startAnimation(animation13);
        view.findViewById(2131624704).startAnimation(animation14);
        view.findViewById(2131624705).startAnimation(animation15);
        view.findViewById(2131624706).startAnimation(animation16);
        view.findViewById(2131624707).startAnimation(animation17);
    }

    public boolean a() {
        int n2 = ((TelephonyManager)this.getActivity().getSystemService("phone")).getSimState();
        boolean bl2 = false;
        switch (n2) {
            default: {
                bl2 = true;
            }
            case 0: 
            case 1: 
            case 4: 
        }
        return bl2;
    }

    public void b() {
        this.phoneSubmit.setEnabled(false);
        String string2 = this.phone.getText().toString();
        String string3 = this.countryCode.getText().toString();
        if (AppState.contactsInfo == null) {
            AppState.contactsInfo = new ContactsInfo();
        }
        AppState.contactsInfo.phone_number = string3 + string2;
        this.spinny.setVisibility(0);
        ik.a().h(AppState.contactsInfo.phone_number).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

            /*
             * Enabled aggressive block sorting
             */
            public void a(NetworkData networkData) {
                if (AppState.account != null) {
                    rk.c().a((ru)((ru)new ru("Connect Phone Number").a("success", "true")).a("logged_in", "true"));
                } else {
                    rk.c().a((ru)((ru)new ru("Connect Phone Number").a("success", "true")).a("logged_in", "false"));
                }
                if (networkData != null && networkData.success) {
                    OnboardingPhoneFragment.this.spinny.setVisibility(8);
                    Bundle bundle = new Bundle();
                    if (OnboardingPhoneFragment.this.a != null) {
                        bundle.putString("second_fragment", OnboardingPhoneFragment.this.a);
                    }
                    ((OnboardingActivity)OnboardingPhoneFragment.this.getActivity()).switchFragment("phone", "verify", bundle);
                    ((BaseActivity)OnboardingPhoneFragment.this.getActivity()).closeKeyboard();
                    return;
                } else {
                    OnboardingPhoneFragment.this.spinny.setVisibility(8);
                    OnboardingPhoneFragment.this.phoneSubmit.setEnabled(true);
                    if (networkData == null) return;
                    {
                        Toast.makeText((Context)OnboardingPhoneFragment.this.getActivity(), (CharSequence)networkData.error, (int)0).show();
                        return;
                    }
                }
            }

            @Override
            public void onCompleted() {
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void onError(Throwable throwable) {
                if (AppState.account != null) {
                    rk.c().a((ru)((ru)new ru("Connect Phone Number").a("success", "false")).a("logged_in", "true"));
                } else {
                    rk.c().a((ru)((ru)new ru("Connect Phone Number").a("success", "false")).a("logged_in", "false"));
                }
                OnboardingPhoneFragment.this.spinny.setVisibility(8);
                OnboardingPhoneFragment.this.phoneSubmit.setEnabled(true);
                Toast.makeText((Context)OnboardingPhoneFragment.this.getActivity(), (CharSequence)throwable.toString(), (int)0).show();
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((NetworkData)object);
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle bundle2 = this.getArguments();
        if (bundle2 != null) {
            this.a = bundle2.getString("second_fragment");
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public View onCreateView(LayoutInflater var1, ViewGroup var2_3, Bundle var3_2) {
        var4_4 = var1.inflate(2130968726, var2_3, false);
        this.b = ButterKnife.bind((Object)this, (View)var4_4);
        ((BaseActivity)this.getActivity()).enableKeyboardEvents(var4_4);
        super.c();
        this.phonePrivacy.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                Intent intent = new Intent(OnboardingPhoneFragment.this.getContext(), (Class)WebViewActivity.class);
                intent.putExtra("title", "Why Can I Trust Candid?");
                intent.putExtra("url", GossipApplication.d + "content/whysafe");
                OnboardingPhoneFragment.this.getContext().startActivity(intent);
            }
        });
        this.phone.requestFocus();
        ((BaseActivity)this.getActivity()).openKeyboard();
        var6_5 = new Rect();
        var4_4.getWindowVisibleDisplayFrame(var6_5);
        var7_6 = var6_5.bottom - var6_5.top;
        new Handler().postDelayed(new Runnable(){

            public void run() {
                Fragment fragment;
                Rect rect = new Rect();
                var4_4.getWindowVisibleDisplayFrame(rect);
                if (Float.compare((float)((float)(rect.bottom - rect.top) / (float)var7_6), (float)0.52f) >= 0 && (fragment = OnboardingPhoneFragment.this.getActivity().getSupportFragmentManager().findFragmentByTag("phone")) != null && fragment.isVisible()) {
                    OnboardingPhoneFragment.this.wrapper.setVisibility(0);
                    OnboardingPhoneFragment.this.a(var4_4);
                }
            }
        }, 800);
        var9_7 = akn.a("Select Country");
        var10_8 = AppState.config.getString("show_phone_skip", "sim");
        var11_9 = AppState.config.getString("phone_skip_to", "contacts");
        var12_10 = -1;
        switch (var10_8.hashCode()) {
            case 96673: {
                if (var10_8.equals((Object)"all")) {
                    var12_10 = 0;
                    ** break;
                }
                ** GOTO lbl25
            }
            case 113879: {
                if (var10_8.equals((Object)"sim")) {
                    var12_10 = 1;
                }
            }
lbl25: // 6 sources:
            default: {
                ** GOTO lbl30
            }
            case 3387192: 
        }
        if (var10_8.equals((Object)"none")) {
            var12_10 = 2;
        }
lbl30: // 4 sources:
        switch (var12_10) {
            case 0: {
                this.skip.setVisibility(0);
                this.skip.setOnClickListener(new View.OnClickListener(){

                    public void onClick(View view) {
                        OnboardingPhoneFragment.this.a(var11_9);
                    }
                });
                if (this.a()) {
                    var15_11 = var9_7.a((Context)this.getActivity());
                    this.countryCode.setText((CharSequence)var15_11.a());
                    ** break;
                }
                ** GOTO lbl46
            }
            case 1: {
                if (!this.a()) {
                    this.skip.setVisibility(0);
                    this.skip.setOnClickListener(new View.OnClickListener(){

                        public void onClick(View view) {
                            OnboardingPhoneFragment.this.a(var11_9);
                        }
                    });
                    ** break;
                }
                var14_12 = var9_7.a((Context)this.getActivity());
                this.countryCode.setText((CharSequence)var14_12.a());
            }
lbl46: // 5 sources:
            default: {
                ** GOTO lbl52
            }
            case 2: 
        }
        if (this.a()) {
            var13_13 = var9_7.a((Context)this.getActivity());
            this.countryCode.setText((CharSequence)var13_13.a());
        }
lbl52: // 4 sources:
        this.countryCode.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                OnboardingPhoneFragment.this.countryCode.setEnabled(false);
                var9_7.show(OnboardingPhoneFragment.this.getFragmentManager(), "COUNTRY_PICKER");
                var9_7.a(new ako(){

                    @Override
                    public void a(String string2, String string3, String string4, int n2) {
                        OnboardingPhoneFragment.this.countryCode.setText((CharSequence)string4);
                        OnboardingPhoneFragment.this.countryCode.setEnabled(true);
                        var9_7.dismiss();
                    }
                });
            }

        });
        this.phoneSubmit.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                OnboardingPhoneFragment.this.b();
            }
        });
        this.phone.addTextChangedListener(new TextWatcher(){

            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
            }

            public void onTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
                Button button = (Button)var4_4.findViewById(2131624685);
                if (charSequence.length() >= 5) {
                    button.setEnabled(true);
                    return;
                }
                button.setEnabled(false);
            }
        });
        return var4_4;
    }

}

