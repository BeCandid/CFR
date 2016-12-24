/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.os.Handler
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.FragmentActivity
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.animation.AccelerateDecelerateInterpolator
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 *  android.view.animation.AnimationSet
 *  android.view.animation.Interpolator
 *  android.view.animation.RotateAnimation
 *  android.view.animation.ScaleAnimation
 *  android.view.animation.TranslateAnimation
 *  android.widget.FrameLayout
 *  android.widget.RelativeLayout
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
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.List
 *  java.util.Map
 *  rx.schedulers.Schedulers
 */
package com.becandid.candid.fragments.onboarding;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
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
import com.becandid.candid.data.User;
import com.becandid.candid.models.NetworkData;
import com.facebook.AccessToken;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import rx.schedulers.Schedulers;

public class OnboardingFacebookFragment
extends Fragment {
    String a;
    private Unbinder b;
    private uj c;
    @BindView(value=2131624662)
    RelativeLayout fbButton;
    @BindView(value=2131624643)
    TextView fbHeader;
    @BindView(value=2131624665)
    TextView fbInfo;
    @BindView(value=2131624666)
    TextView fbInfo2;
    @BindView(value=2131624667)
    TextView fbPrivacy;
    @BindView(value=2131624644)
    TextView fbSubheader;
    @BindView(value=2131624642)
    TextView skip;
    @BindView(value=2131624668)
    FrameLayout spinny;

    private void c() {
        if (AppState.config != null) {
            this.fbHeader.setText((CharSequence)AppState.config.getString("fb_header", this.getString(2131230840)));
            this.fbSubheader.setText((CharSequence)AppState.config.getString("fb_subheader", this.getString(2131230843)));
            this.fbPrivacy.setText((CharSequence)AppState.config.getString("more_info", this.getString(2131230904)));
            this.fbInfo.setText((CharSequence)AppState.config.getString("fb_info", this.getString(2131230841)));
            this.fbInfo2.setText((CharSequence)AppState.config.getString("fb_info_2", ""));
            return;
        }
        this.fbHeader.setText((CharSequence)this.getString(2131230840));
        this.fbSubheader.setText((CharSequence)this.getString(2131230843));
        this.fbPrivacy.setText((CharSequence)this.getString(2131230904));
        this.fbInfo.setText((CharSequence)this.getString(2131230841));
        this.fbInfo2.setText((CharSequence)"");
    }

    public AnimationSet a(int n2, int n3, final int n4, final int n5, final View view) {
        AnimationSet animationSet = new AnimationSet(false);
        float f2 = this.getResources().getDisplayMetrics().density;
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0.0f, 0, f2 * (float)n2, 0, 0.0f, 0, f2 * (float)n3);
        translateAnimation.setInterpolator((Interpolator)new AccelerateDecelerateInterpolator());
        translateAnimation.setDuration(200);
        translateAnimation.setStartOffset((long)(n4 + 1400));
        translateAnimation.setFillAfter(true);
        translateAnimation.setFillEnabled(true);
        animationSet.addAnimation((Animation)translateAnimation);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(0, 0.0f, 0, 0.0f, 0, 0.0f, 2, 1.0f);
        translateAnimation2.setInterpolator((Interpolator)new AccelerateDecelerateInterpolator());
        translateAnimation2.setDuration(400);
        translateAnimation2.setStartOffset((long)(n4 + 2200));
        translateAnimation2.setFillAfter(true);
        translateAnimation2.setFillEnabled(true);
        translateAnimation2.setAnimationListener(new Animation.AnimationListener(){

            public void onAnimationEnd(Animation animation) {
                view.findViewById(n5).setVisibility(8);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                new Handler().postDelayed(new Runnable(){

                    public void run() {
                        view.findViewById(n5).bringToFront();
                        view.findViewById(2131624661).bringToFront();
                    }
                }, (long)(2200 + n4));
            }

        });
        animationSet.addAnimation((Animation)translateAnimation2);
        return animationSet;
    }

    public void a() {
        if (this.c == null) {
            this.c = uj.a.a();
            wm.c().a(this.c, new uk<wn>(){

                /*
                 * Enabled aggressive block sorting
                 */
                public void a(wn wn2) {
                    if (AppState.account != null) {
                        rk.c().a((ru)new ru("Connect To Facebook Successful").a("logged_in", "true"));
                    } else {
                        rk.c().a((ru)new ru("Connect To Facebook Successful").a("logged_in", "false"));
                    }
                    Log.d((String)"FBConnect", (String)"success");
                    OnboardingFacebookFragment.this.spinny.setVisibility(8);
                    AppState.setFBInfo(wn2.a());
                    if (OnboardingFacebookFragment.this.a != null) {
                        OnboardingFacebookFragment.this.spinny.setVisibility(0);
                        aps aps2 = ix.a().a(in.v.class, new apr<in.v>(){

                            public void a(in.v v2) {
                                OnboardingFacebookFragment.this.spinny.setVisibility(8);
                                ((BaseActivity)OnboardingFacebookFragment.this.getActivity()).sendFbDataToServer();
                                OnboardingFacebookFragment.this.getActivity().setResult(-1);
                                ((OnboardingActivity)OnboardingFacebookFragment.this.getActivity()).finish();
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
                                this.a((in.v)object);
                            }
                        });
                        ((BaseActivity)OnboardingFacebookFragment.this.getActivity()).addToSubscriptionList(aps2);
                        return;
                    }
                    OnboardingFacebookFragment.this.b();
                }

                /*
                 * Enabled aggressive block sorting
                 */
                @Override
                public void onCancel() {
                    if (AppState.account != null) {
                        rk.c().a((ru)new ru("Connect To Facebook Cancelled").a("logged_in", "true"));
                    } else {
                        rk.c().a((ru)new ru("Connect To Facebook Cancelled").a("logged_in", "false"));
                    }
                    Log.d((String)"FBConnect", (String)"cancel");
                    OnboardingFacebookFragment.this.spinny.setVisibility(8);
                    OnboardingFacebookFragment.this.fbButton.setEnabled(true);
                }

                /*
                 * Enabled aggressive block sorting
                 */
                @Override
                public void onError(FacebookException facebookException) {
                    if (AppState.account != null) {
                        rk.c().a((ru)new ru("Connect To Facebook Error").a("logged_in", "true"));
                    } else {
                        rk.c().a((ru)new ru("Connect To Facebook Error").a("logged_in", "false"));
                    }
                    rj.a((Throwable)facebookException);
                    if (facebookException instanceof FacebookAuthorizationException && AccessToken.a() != null) {
                        wm.c().d();
                        wm.c().a((Activity)OnboardingFacebookFragment.this.getActivity(), (Collection<String>)Arrays.asList((Object[])"public_profile,user_friends,user_work_history,user_education_history".split(",")));
                        return;
                    }
                    Toast.makeText((Context)GossipApplication.a(), (CharSequence)"Unable to connect to Facebook", (int)1).show();
                    OnboardingFacebookFragment.this.spinny.setVisibility(8);
                    OnboardingFacebookFragment.this.fbButton.setEnabled(true);
                }

                @Override
                public /* synthetic */ void onSuccess(Object object) {
                    this.a((wn)object);
                }

            });
        }
        wm.c().a(this, (Collection<String>)Arrays.asList((Object[])"public_profile,user_friends,user_work_history,user_education_history".split(",")));
    }

    public void a(View view) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.75f, 1.0f, 0.75f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(500);
        scaleAnimation.setStartOffset(500);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -10.0f, 1, 0.5f, 1, 1.0f);
        rotateAnimation.setDuration(200);
        rotateAnimation.setStartOffset(1000);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setFillEnabled(true);
        RotateAnimation rotateAnimation2 = new RotateAnimation(0.0f, 10.0f, 1, 0.5f, 1, 1.0f);
        rotateAnimation2.setDuration(200);
        rotateAnimation2.setStartOffset(1200);
        rotateAnimation2.setFillAfter(true);
        rotateAnimation2.setFillEnabled(true);
        AnimationSet animationSet = this.a(-110, 20, 30, 2131624647, view);
        AnimationSet animationSet2 = this.a(-125, -10, 50, 2131624648, view);
        AnimationSet animationSet3 = this.a(-115, -40, 30, 2131624649, view);
        AnimationSet animationSet4 = this.a(-90, -80, 40, 2131624650, view);
        AnimationSet animationSet5 = this.a(-30, -105, 50, 2131624651, view);
        AnimationSet animationSet6 = this.a(-15, -80, 10, 2131624652, view);
        AnimationSet animationSet7 = this.a(68, -90, 20, 2131624653, view);
        AnimationSet animationSet8 = this.a(115, -50, 30, 2131624654, view);
        AnimationSet animationSet9 = this.a(100, -25, 10, 2131624655, view);
        AnimationSet animationSet10 = this.a(110, 8, 20, 2131624656, view);
        AnimationSet animationSet11 = this.a(100, 30, 40, 2131624657, view);
        view.findViewById(2131624646).startAnimation((Animation)scaleAnimation);
        view.findViewById(2131624659).startAnimation((Animation)rotateAnimation);
        view.findViewById(2131624658).startAnimation((Animation)rotateAnimation2);
        view.findViewById(2131624647).startAnimation((Animation)animationSet);
        view.findViewById(2131624648).startAnimation((Animation)animationSet2);
        view.findViewById(2131624649).startAnimation((Animation)animationSet3);
        view.findViewById(2131624650).startAnimation((Animation)animationSet4);
        view.findViewById(2131624651).startAnimation((Animation)animationSet5);
        view.findViewById(2131624652).startAnimation((Animation)animationSet6);
        view.findViewById(2131624653).startAnimation((Animation)animationSet7);
        view.findViewById(2131624654).startAnimation((Animation)animationSet8);
        view.findViewById(2131624655).startAnimation((Animation)animationSet9);
        view.findViewById(2131624656).startAnimation((Animation)animationSet10);
        view.findViewById(2131624657).startAnimation((Animation)animationSet11);
    }

    public void a(String string2, String string3) {
        FragmentActivity fragmentActivity = this.getActivity();
        if (fragmentActivity instanceof OnboardingActivity) {
            ((OnboardingActivity)fragmentActivity).switchFragment(string2, string3);
        }
    }

    public void b() {
        if (AppState.config.getInt("disable_mobile_fb_phone_login", 0) == 0) {
            ik.a().d().b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

                /*
                 * Enabled aggressive block sorting
                 */
                public void a(NetworkData networkData) {
                    if (!networkData.success) {
                        ix.a().a(new in.an("fb", "phone"));
                        return;
                    } else {
                        if (networkData.my_info != null) {
                            AppState.account = networkData.my_info;
                            ((OnboardingActivity)OnboardingFacebookFragment.this.getActivity()).finishSyncAccount();
                        }
                        if (networkData.config != null) {
                            AppState.setConfig(networkData.config);
                        }
                        if (networkData.activity_settings == null) return;
                        {
                            AppState.notificationSettings = new ArrayList(networkData.activity_settings);
                            return;
                        }
                    }
                }

                @Override
                public void onCompleted() {
                }

                @Override
                public void onError(Throwable throwable) {
                    rj.a(throwable);
                    Log.d((String)"FacebookLogin", (String)throwable.toString());
                    ix.a().a(new in.an("fb", "phone"));
                }

                @Override
                public /* synthetic */ void onNext(Object object) {
                    this.a((NetworkData)object);
                }
            });
            return;
        }
        this.a("fb", "phone");
    }

    public void onActivityResult(int n2, int n3, Intent intent) {
        if (this.c != null) {
            this.c.a(n2, n3, intent);
        }
        super.onActivityResult(n2, n3, intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle bundle2 = this.getArguments();
        if (bundle2 != null) {
            this.a = bundle2.getString("second_fragment");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = layoutInflater.inflate(2130968724, viewGroup, false);
        this.b = ButterKnife.bind((Object)this, (View)view);
        super.c();
        this.skip.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                if (OnboardingFacebookFragment.this.a != null) {
                    OnboardingFacebookFragment.this.getActivity().setResult(-1);
                    OnboardingFacebookFragment.this.getActivity().finish();
                    return;
                }
                OnboardingFacebookFragment.this.a("fb", "phone");
            }
        });
        this.fbButton.setOnClickListener(new View.OnClickListener(){

            /*
             * Enabled aggressive block sorting
             */
            public void onClick(View view) {
                if (AppState.account != null) {
                    rk.c().a((ru)new ru("Connect To Facebook").a("logged_in", "true"));
                } else {
                    rk.c().a((ru)new ru("Connect To Facebook").a("logged_in", "false"));
                }
                OnboardingFacebookFragment.this.a();
            }
        });
        this.fbPrivacy.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                Intent intent = new Intent(OnboardingFacebookFragment.this.getContext(), (Class)WebViewActivity.class);
                intent.putExtra("title", "Why Can I Trust Candid?");
                intent.putExtra("url", GossipApplication.d + "content/whysafe");
                OnboardingFacebookFragment.this.getContext().startActivity(intent);
            }
        });
        this.a(view);
        return view;
    }

}

