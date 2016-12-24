/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.FragmentActivity
 *  android.text.Editable
 *  android.text.TextWatcher
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.animation.AlphaAnimation
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 *  android.widget.Button
 *  android.widget.EditText
 *  android.widget.FrameLayout
 *  android.widget.TextView
 *  android.widget.Toast
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  butterknife.Unbinder
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.HashMap
 *  java.util.Map
 *  rx.schedulers.Schedulers
 */
package com.becandid.candid.fragments.onboarding;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.activities.OnboardingActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Config;
import com.becandid.candid.data.ContactsInfo;
import com.becandid.candid.data.User;
import com.becandid.candid.models.NetworkData;
import java.util.HashMap;
import java.util.Map;
import rx.schedulers.Schedulers;

public class OnboardingVerifyFragment
extends Fragment {
    String a;
    private Unbinder b;
    @BindView(value=2131624726)
    TextView resend;
    @BindView(value=2131624727)
    FrameLayout spinny;
    @BindView(value=2131624725)
    Button submit;
    @BindView(value=2131624724)
    EditText verify;
    @BindView(value=2131624721)
    TextView verifyHeader;
    @BindView(value=2131624722)
    TextView verifySubheader;

    private void c() {
        this.verifyHeader.setText((CharSequence)AppState.config.getString("code_header", this.getString(2131230945)));
        this.verifySubheader.setText((CharSequence)AppState.config.getString("code_subheader", this.getString(2131230948)));
        this.verify.setHint((CharSequence)AppState.config.getString("code_input", this.getString(2131230946)));
        this.resend.setText((CharSequence)AppState.config.getString("resend_code_button", this.getString(2131230947)));
    }

    public void a() {
        this.submit.setClickable(false);
        this.spinny.setVisibility(0);
        ik.a().a(this.verify.getText().toString(), AppState.contactsInfo.phone_number).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

            /*
             * Enabled aggressive block sorting
             */
            public void a(NetworkData networkData) {
                OnboardingVerifyFragment.this.spinny.setVisibility(8);
                if (networkData != null && networkData.success) {
                    if (AppState.account != null) {
                        AppState.account.have_phone_number = true;
                    }
                    ((BaseActivity)OnboardingVerifyFragment.this.getActivity()).closeKeyboard();
                    AppState.contactsInfo.otpCode = OnboardingVerifyFragment.this.verify.getText().toString();
                    if (OnboardingVerifyFragment.this.a == null) {
                        OnboardingVerifyFragment.this.a("verify", "contacts");
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("second_fragment", OnboardingVerifyFragment.this.a);
                    ((OnboardingActivity)OnboardingVerifyFragment.this.getActivity()).switchFragment("verify", "contacts", bundle);
                    return;
                } else {
                    if (networkData == null || networkData.success) return;
                    {
                        Toast.makeText((Context)OnboardingVerifyFragment.this.getActivity(), (CharSequence)"That does not match the expected code", (int)1).show();
                        OnboardingVerifyFragment.this.submit.setClickable(true);
                        OnboardingVerifyFragment.this.spinny.setVisibility(8);
                        return;
                    }
                }
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                Toast.makeText((Context)OnboardingVerifyFragment.this.getActivity(), (CharSequence)"Unable to verify your code, please try again", (int)1).show();
                rj.a(throwable);
                Log.d((String)"VerifyPhone", (String)throwable.toString());
                OnboardingVerifyFragment.this.spinny.setVisibility(8);
                OnboardingVerifyFragment.this.submit.setClickable(true);
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((NetworkData)object);
            }
        });
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(final View view, final boolean bl2, int n2) {
        AlphaAnimation alphaAnimation = bl2 ? new AlphaAnimation(0.0f, 1.0f) : new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(500);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setFillEnabled(true);
        if (n2 != -1) {
            alphaAnimation.setStartOffset((long)n2);
        }
        alphaAnimation.setAnimationListener(new Animation.AnimationListener(){

            public void onAnimationEnd(Animation animation) {
                if (!bl2) {
                    view.setClickable(false);
                    view.setVisibility(8);
                }
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                if (bl2) {
                    view.setClickable(true);
                    view.setVisibility(0);
                }
            }
        });
        view.startAnimation((Animation)alphaAnimation);
    }

    public void a(String string2, String string3) {
        FragmentActivity fragmentActivity = this.getActivity();
        if (fragmentActivity instanceof OnboardingActivity) {
            ((OnboardingActivity)fragmentActivity).switchFragment(string2, string3);
        }
    }

    public void b() {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"otp_code", (Object)this.verify.getText().toString());
        hashMap.put((Object)"phone_number", (Object)AppState.contactsInfo.phone_number);
        this.submit.setClickable(false);
        this.spinny.setVisibility(0);
        ik.a().b((Map<String, String>)hashMap).b(Schedulers.io()).a(apv.a()).b(new apr<ain>(){

            /*
             * Enabled aggressive block sorting
             */
            public void a(ain ain2) {
                if (ain2 != null && ain2.b("success") != null && ain2.b("success").h()) {
                    AppState.account.have_phone_number = true;
                    if (OnboardingVerifyFragment.this.a != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("second_fragment", OnboardingVerifyFragment.this.a);
                        ((OnboardingActivity)OnboardingVerifyFragment.this.getActivity()).switchFragment("verify", "contacts", bundle);
                    } else {
                        OnboardingVerifyFragment.this.a("verify", "contacts");
                    }
                    if (AppState.account == null) {
                        rk.c().a((ru)((ru)new ru("Verify Phone Number").a("success", "true")).a("logged_in", "false"));
                        return;
                    }
                    rk.c().a((ru)((ru)new ru("Verify Phone Number").a("success", "true")).a("logged_in", "true"));
                    return;
                } else {
                    if (ain2 == null || ain2.b("success") == null || ain2.b("success").h()) return;
                    {
                        Toast.makeText((Context)OnboardingVerifyFragment.this.getActivity(), (CharSequence)"That does not match the expected code", (int)1).show();
                        OnboardingVerifyFragment.this.submit.setClickable(true);
                        OnboardingVerifyFragment.this.spinny.setVisibility(8);
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
                    rk.c().a((ru)((ru)new ru("Verify Phone Number").a("success", "false")).a("logged_in", "true"));
                } else {
                    rk.c().a((ru)((ru)new ru("Verify Phone Number").a("success", "false")).a("logged_in", "false"));
                }
                rj.a(throwable);
                OnboardingVerifyFragment.this.submit.setClickable(true);
                OnboardingVerifyFragment.this.spinny.setVisibility(8);
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
            this.a = bundle2.getString("second_fragment");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = layoutInflater.inflate(2130968728, viewGroup, false);
        this.b = ButterKnife.bind((Object)this, (View)view);
        ((BaseActivity)this.getActivity()).enableKeyboardEvents(view);
        super.c();
        this.getArguments();
        this.a((View)this.resend, true, 5000);
        this.resend.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                if (OnboardingVerifyFragment.this.a != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("second_fragment", OnboardingVerifyFragment.this.a);
                    ((OnboardingActivity)OnboardingVerifyFragment.this.getActivity()).switchFragment("verify", "phone", bundle);
                    return;
                }
                OnboardingVerifyFragment.this.a("verify", "phone");
            }
        });
        this.verify.requestFocus();
        ((BaseActivity)this.getActivity()).openKeyboard();
        this.verify.addTextChangedListener(new TextWatcher(){

            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
            }

            public void onTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
                if (charSequence.length() >= 4) {
                    OnboardingVerifyFragment.this.submit.setEnabled(true);
                    return;
                }
                OnboardingVerifyFragment.this.submit.setEnabled(false);
            }
        });
        this.submit.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                if (AppState.account != null) {
                    OnboardingVerifyFragment.this.b();
                    return;
                }
                OnboardingVerifyFragment.this.a();
            }
        });
        return view;
    }

}

