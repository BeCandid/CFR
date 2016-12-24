/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.support.design.widget.Snackbar
 *  android.text.Html
 *  android.text.TextUtils
 *  android.text.method.LinkMovementMethod
 *  android.text.method.MovementMethod
 *  android.util.Log
 *  android.view.View
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  rx.exceptions.CompositeException
 *  rx.schedulers.Schedulers
 */
package com.becandid.candid.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.activities.ChangeEndpointActivity;
import com.becandid.candid.activities.MainTabsActivity;
import com.becandid.candid.activities.OnboardingActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.DataUtil;
import com.becandid.candid.models.NetworkData;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rx.exceptions.CompositeException;
import rx.schedulers.Schedulers;

public class SplashActivity
extends BaseActivity {
    public static final int CHANGE_ENDPOINT_CODE = 1001;
    private View b;
    private View c;
    private boolean d = false;
    private boolean e = false;

    private void a(final View view) {
        this.d = true;
        ik.a().c().b(Schedulers.io()).a(apv.a()).b(new apr<ain>(){

            @Override
            public void onCompleted() {
                SplashActivity.this.d = false;
            }

            @Override
            public void onError(Throwable throwable) {
                Log.d((String)"Splash", (String)throwable.toString());
                if (throwable instanceof CompositeException) {
                    Iterator iterator = ((CompositeException)throwable).a().iterator();
                    while (iterator.hasNext()) {
                        Log.d((String)"Splash", (String)((Throwable)iterator.next()).toString());
                    }
                }
                SplashActivity.this.b.setVisibility(8);
                view.setEnabled(true);
                rk.c().a(new sk().a("splash_page").a(false));
                SplashActivity.this.d = false;
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void onNext(ain ain2) {
                SplashActivity.this.b.setVisibility(8);
                view.setEnabled(true);
                Map<String, Object> map = DataUtil.toMap(ain2.d("config"));
                Map<String, Object> map2 = DataUtil.toMap(ain2.d("onboarding_data"));
                try {
                    AppState.internal = ain2.b("debug").h();
                    if (AppState.internal) {
                        SplashActivity.this.c.setVisibility(0);
                    }
                    AppState.referralId = ain2.b("referral_id").c();
                }
                catch (Exception var4_7) {
                    rj.a((Throwable)var4_7);
                }
                try {
                    List list = DataUtil.toList(ain2.c("under_18_tags"), String.class);
                    List list2 = DataUtil.toList(ain2.c("18_plus_tags"), String.class);
                    AppState.setOnboardingTeenTags(list);
                    AppState.setOnboardingAdultTags(list2);
                }
                catch (Exception var5_8) {
                    rj.a((Throwable)var5_8);
                }
                AppState.setConfig(map);
                AppState.setOnboardingTags(map2);
                if (SplashActivity.this.e) {
                    Intent intent = new Intent(view.getContext(), (Class)OnboardingActivity.class);
                    SplashActivity.this.startActivity(intent);
                    rk.c().a(new sk().a("splash_page").a(true));
                    SplashActivity.this.finish();
                }
            }
        });
    }

    public void changeEndpoint(View view) {
        this.startActivity(new Intent((Context)this, (Class)ChangeEndpointActivity.class));
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (AppState.loggedin()) {
            ik.a().b().b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

                @Override
                public void onCompleted() {
                    if (AppState.needOnboarding == 1) {
                        Intent intent = new Intent((Context)SplashActivity.this, (Class)OnboardingActivity.class);
                        intent.putExtra("need_onboarding", 1);
                        SplashActivity.this.startActivity(intent);
                        SplashActivity.this.finish();
                        return;
                    }
                    Intent intent = new Intent((Context)SplashActivity.this, (Class)MainTabsActivity.class);
                    SplashActivity.this.startActivity(intent);
                    SplashActivity.this.finish();
                }

                @Override
                public void onError(Throwable throwable) {
                    Intent intent = new Intent((Context)SplashActivity.this, (Class)MainTabsActivity.class);
                    SplashActivity.this.startActivity(intent);
                    SplashActivity.this.finish();
                }

                @Override
                public void onNext(NetworkData networkData) {
                }
            });
            return;
        }
        this.renderSplashPage();
        TextView textView = (TextView)this.findViewById(2131624291);
        textView.setText(TextUtils.concat((CharSequence[])new CharSequence[]{Html.fromHtml((String)"By selecting \"Get Started Anonymously\" you agree to the "), Html.fromHtml((String)("<a href=\"" + GossipApplication.d + "content/terms\">Terms of Service</a>")), " and ", Html.fromHtml((String)("<a href=\"" + GossipApplication.d + "content/community\">Community Guidelines</a>"))}));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void renderSplashPage() {
        this.setContentView(2130968630);
        this.b = this.findViewById(2131624293);
        this.c = this.findViewById(2131624292);
        this.a(this.findViewById(2131624290));
    }

    @Override
    protected void showSnack(boolean bl2) {
        super.showSnack(bl2);
        View view = this.findViewById(2131624291);
        if (!bl2 && view != null) {
            Snackbar.a((View)view, (CharSequence)"No Internet connection!", (int)0).a();
        }
    }

    public void startOnboarding(View view) {
        if (!this.d) {
            super.a(view);
        }
        this.e = true;
        this.b.setVisibility(0);
        view.setEnabled(false);
    }

}

