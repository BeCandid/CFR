/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.graphics.Point
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.PersistableBundle
 *  android.support.v7.app.AlertDialog
 *  android.support.v7.app.AlertDialog$Builder
 *  android.support.v7.app.AppCompatActivity
 *  android.util.Log
 *  android.view.Display
 *  android.view.View
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.view.WindowManager
 *  android.view.inputmethod.InputMethodManager
 *  android.widget.Toast
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  rx.schedulers.Schedulers
 */
package com.becandid.candid.activities;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PersistableBundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.InviteContactsActivity;
import com.becandid.candid.activities.OnboardingActivity;
import com.becandid.candid.activities.WebViewActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.DataUtil;
import com.becandid.candid.data.EmptyClass;
import com.becandid.candid.data.FacebookInfo;
import com.becandid.candid.data.Group;
import com.becandid.candid.data.User;
import com.becandid.candid.models.EmptySubscriber;
import com.becandid.candid.models.JoinedFacebookData;
import com.becandid.candid.models.NetworkData;
import com.becandid.candid.services.ConnectivityReceiver;
import com.facebook.AccessToken;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rx.schedulers.Schedulers;

public class BaseActivity
extends AppCompatActivity
implements ConnectivityReceiver.a {
    public static final int PERMISSION_WRITE_EXTERNAL_STORAGE = 1104;
    public static final int UPSELL_FEED = 1104;
    public static final int UPSELL_GROUP = 929;
    View a;
    public uj callbackManager;
    protected ArrayList<aps> eventSubscriptions = new ArrayList();
    public boolean isStopped;
    public boolean keyboardOpen;
    protected aps mSubscription;
    protected it photoHelper;

    private void a() {
        this.showSnack(ConnectivityReceiver.a());
    }

    public void addToSubscriptionList(aps aps2) {
        this.eventSubscriptions.add((Object)aps2);
    }

    public void backNavClick(View view) {
        this.onBackPressed();
    }

    protected void busSubscribe(aps aps2) {
        this.eventSubscriptions.add((Object)aps2);
    }

    protected <T> void busSubscribe(Class<T> class_, apr<T> apr2) {
        this.eventSubscriptions.add((Object)ix.a().a(class_, apr2));
    }

    protected void clearPhoto() {
        if (this.photoHelper != null) {
            this.photoHelper.clearPhoto();
        }
    }

    public void closeKeyboard() {
        this.closeKeyboard(this.a);
    }

    public void closeKeyboard(View view) {
        ((InputMethodManager)this.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void connectFacebook(int n2) {
        if (this.callbackManager == null) {
            this.callbackManager = uj.a.a();
            wm.c().a(this.callbackManager, new uk<wn>(){

                @Override
                public void onCancel() {
                    Log.d((String)"FBConnect", (String)"cancel");
                }

                @Override
                public void onError(FacebookException facebookException) {
                    Log.e((String)"FBConnect", (String)facebookException.toString());
                    if (facebookException instanceof FacebookAuthorizationException && AccessToken.a() != null) {
                        wm.c().d();
                        wm.c().a(BaseActivity.this.getParent(), (Collection<String>)Arrays.asList((Object[])"public_profile,user_friends,user_work_history,user_education_history".split(",")));
                        return;
                    }
                    Toast.makeText((Context)GossipApplication.a(), (CharSequence)"Unable to connect to Facebook", (int)1).show();
                }

                @Override
                public void onSuccess(wn wn2) {
                    Log.d((String)"FBConnect", (String)"success");
                    AppState.setFBInfo(wn2.a());
                    ix.a().a(in.v.class, new apr<in.v>(){

                        @Override
                        public void onCompleted() {
                        }

                        @Override
                        public void onError(Throwable throwable) {
                            rj.a(throwable);
                        }

                        @Override
                        public void onNext(in.v v2) {
                            BaseActivity.this.sendFbDataToServer();
                        }
                    });
                }

            });
        }
        wm.c().a((Activity)this, (Collection<String>)Arrays.asList((Object[])"public_profile,user_friends,user_work_history,user_education_history".split(",")));
    }

    public void enableKeyboardEvents(final View view) {
        this.a = view;
        Display display = this.getWindowManager().getDefaultDisplay();
        final Point point = new Point();
        display.getSize(point);
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(){

            /*
             * Enabled aggressive block sorting
             */
            public void onGlobalLayout() {
                int n2 = view.getHeight();
                if (n2 < -100 + point.y && !BaseActivity.this.keyboardOpen) {
                    BaseActivity.this.keyboardOpen = true;
                    BaseActivity.this.keyboardOpened();
                    return;
                } else {
                    if (n2 < -100 + point.y || !BaseActivity.this.keyboardOpen) return;
                    {
                        BaseActivity.this.keyboardOpen = false;
                        BaseActivity.this.keyboardClosed();
                        return;
                    }
                }
            }
        });
    }

    public it getPhotoHelper() {
        if (this.photoHelper == null) {
            this.photoHelper = new it(this);
        }
        return this.photoHelper;
    }

    protected void getRxSubscription() {
        this.mSubscription = null;
    }

    public void inviteFriends(final int n2, final int n3) {
        new AlertDialog.Builder((Context)this).setTitle((CharSequence)"Invite Candid Friends").setMessage((CharSequence)"Do you want to anonymously recommend this group to your friends on Candid?").setCancelable(true).setNegativeButton((CharSequence)this.getResources().getString(2131230890), new DialogInterface.OnClickListener(){

            public void onClick(DialogInterface dialogInterface, int n2) {
            }
        }).setPositiveButton((CharSequence)this.getResources().getString(2131230953), new DialogInterface.OnClickListener(){

            public void onClick(DialogInterface dialogInterface, int n22) {
                ik.a().e(n3).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
                BaseActivity.this.upsellChange(n2);
                Toast.makeText((Context)BaseActivity.this.getBaseContext(), (CharSequence)"Your friends have been notified. Thanks!", (int)1).show();
            }
        }).create().show();
    }

    protected void keyboardClosed() {
    }

    protected void keyboardOpened() {
    }

    protected void onActivityResult(int n2, int n3, Intent intent) {
        super.onActivityResult(n2, n3, intent);
        if (this.photoHelper != null) {
            this.photoHelper.a(n2, n3, intent);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        (GossipApplication)this.getApplication();
        Bundle bundle2 = this.getIntent().getExtras();
        if (bundle2 != null && bundle2.containsKey("click_notification")) {
            ik.a().j(bundle2.getString("click_notification")).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
        }
        this.busSubscribe(in.ao.class, new apr<in.ao>(){

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
            }

            @Override
            public void onNext(in.ao ao2) {
                iy.a().b();
            }
        });
        this.busSubscribe(in.ac.class, new apr<in.ac>(){

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
            }

            @Override
            public void onNext(in.ac ac2) {
                Toast.makeText((Context)GossipApplication.a().getApplicationContext(), (int)2131230887, (int)0).show();
            }
        });
        this.busSubscribe(in.ap.class, new apr<in.ap>(){

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
            }

            @Override
            public void onNext(in.ap ap2) {
                Toast.makeText((Context)GossipApplication.a().getApplicationContext(), (int)2131230941, (int)0).show();
            }
        });
        super.a();
    }

    public void onCreate(Bundle bundle, PersistableBundle persistableBundle) {
        super.onCreate(bundle, persistableBundle);
        this.isStopped = false;
        super.a();
    }

    protected void onDestroy() {
        super.onDestroy();
        Iterator iterator = this.eventSubscriptions.iterator();
        while (iterator.hasNext()) {
            ((aps)iterator.next()).unsubscribe();
        }
    }

    @Override
    public void onNetworkConnectionChanged(boolean bl2) {
        this.showSnack(bl2);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Bundle bundle = intent.getExtras();
        if (bundle != null && bundle.containsKey("click_notification")) {
            ik.a().j(bundle.getString("click_notification")).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
        }
    }

    public void onPhotoChosen(String string2, int n2, int n3) {
    }

    public void onRequestPermissionsResult(int n2, String[] arrstring, int[] arrn) {
        super.onRequestPermissionsResult(n2, arrstring, arrn);
        if (this.photoHelper != null) {
            this.photoHelper.a(n2, arrstring, arrn);
        }
        if (n2 == 1989 && arrn.length > 0 && arrn[0] == 0) {
            ix.a().a(new in.ao());
        }
    }

    protected void onResume() {
        super.onResume();
        GossipApplication.a().a(this);
    }

    protected void onStart() {
        super.onStart();
        this.isStopped = false;
    }

    protected void onStop() {
        super.onStop();
        this.isStopped = true;
    }

    public void openKeyboard() {
        ((InputMethodManager)this.getSystemService("input_method")).toggleSoftInput(1, 1);
    }

    public void sendFbDataToServer() {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"fb_token", (Object)AppState.fbInfo.fbToken.b());
        hashMap.put((Object)"fb_uid", (Object)AppState.fbInfo.fbToken.i());
        HashMap hashMap2 = new HashMap();
        hashMap2.put((Object)"type", (Object)"fb");
        hashMap2.put((Object)"fb_uid", (Object)AppState.fbInfo.fbToken.i());
        hashMap2.put((Object)"id_list", (Object)DataUtil.join(AppState.fbInfo.friendIds));
        apl.a(ik.a().b((Map<String, String>)hashMap).b(Schedulers.io()).a(apv.a()), ik.a().a(AppState.fbInfo).b(Schedulers.io()).a(apv.a()), new aqd<ain, NetworkData, JoinedFacebookData>(){

            @Override
            public JoinedFacebookData call(ain ain2, NetworkData networkData) {
                return new JoinedFacebookData(ain2, networkData);
            }
        }).b(new apr<JoinedFacebookData>(){

            @Override
            public void onCompleted() {
                ix.a().a(new in.au());
            }

            @Override
            public void onError(Throwable throwable) {
            }

            @Override
            public void onNext(JoinedFacebookData joinedFacebookData) {
                NetworkData networkData = joinedFacebookData.autoJoin;
                if (networkData != null && networkData.groups != null) {
                    for (Group group : networkData.groups) {
                        ix.a().a(new in.m(group));
                    }
                }
                if (networkData != null && networkData.my_info != null) {
                    AppState.account.num_groups = networkData.my_info.num_groups;
                }
            }
        });
    }

    public void setPhotoHelper(it it2) {
        this.photoHelper = it2;
    }

    public void showConnectAccount(int n2) {
        Intent intent = new Intent((Context)this, (Class)OnboardingActivity.class);
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_facebook_last_fragment", true);
        bundle.putString("first_fragment", "phone");
        bundle.putString("second_fragment", "fb");
        intent.putExtras(bundle);
        this.startActivityForResult(intent, 1104);
    }

    public void showContactsDialog(int n2) {
        Intent intent = new Intent((Context)this, (Class)InviteContactsActivity.class);
        intent.putExtra("invite_type", InviteContactsActivity.InviteFlowTypes.DOWNLOAD.toString());
        intent.putExtra("upsellId", n2);
        this.startActivityForResult(intent, 929);
    }

    public void showContactsDialog(int n2, int n3) {
        Intent intent = new Intent((Context)this, (Class)InviteContactsActivity.class);
        intent.putExtra("invite_type", InviteContactsActivity.InviteFlowTypes.GROUP.toString());
        intent.putExtra("groupId", n3);
        intent.putExtra("upsellId", n2);
        this.startActivityForResult(intent, 929);
    }

    public void showPhoneConnect(int n2) {
        Intent intent = new Intent((Context)this, (Class)OnboardingActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("first_fragment", "phone");
        bundle.putString("second_fragment", "phone");
        intent.putExtras(bundle);
        this.startActivityForResult(intent, 1104);
    }

    protected void showSnack(boolean bl2) {
    }

    public void showWebView(String string2) {
        Intent intent = new Intent((Context)this, (Class)WebViewActivity.class);
        intent.putExtra("url", GossipApplication.d + string2);
        this.startActivity(intent);
    }

    public void skipUpsell(int n2) {
        ik.a().g(Integer.toString((int)n2)).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
        this.upsellChange(n2);
    }

    public void skipUpsell(int n2, int n3) {
        ik.a().g(Integer.toString((int)n2) + "," + Integer.toString((int)n3)).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
        this.upsellChange(n2);
    }

    public void upsellChange(int n2) {
    }

}

