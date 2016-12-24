/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.BroadcastReceiver
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.pm.PackageManager
 *  android.content.res.Resources
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.support.design.widget.Snackbar
 *  android.support.design.widget.TabLayout
 *  android.support.design.widget.TabLayout$a
 *  android.support.design.widget.TabLayout$d
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.FragmentManager
 *  android.support.v4.view.ViewPager
 *  android.support.v7.app.AlertDialog
 *  android.support.v7.app.AlertDialog$Builder
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  android.widget.Toast
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  java.io.Serializable
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.lang.Void
 *  java.util.Arrays
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 *  rx.schedulers.Schedulers
 */
package com.becandid.candid.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.CreatePostActivity;
import com.becandid.candid.activities.GroupDetailsActivity;
import com.becandid.candid.activities.PopupWithBlurBackgroundActivity;
import com.becandid.candid.activities.VerifyAgeActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Config;
import com.becandid.candid.data.DataUtil;
import com.becandid.candid.data.EmptyClass;
import com.becandid.candid.data.FacebookInfo;
import com.becandid.candid.data.Group;
import com.becandid.candid.data.User;
import com.becandid.candid.fragments.main_tabs.ActivityTabFragment;
import com.becandid.candid.fragments.main_tabs.FeedTabFragment;
import com.becandid.candid.fragments.main_tabs.MeTabFragment;
import com.becandid.candid.fragments.main_tabs.MessageTabFragment;
import com.becandid.candid.models.EmptySubscriber;
import com.becandid.candid.models.NetworkData;
import com.becandid.candid.services.RegistrationIntentService;
import com.becandid.candid.views.MainTabViewPager;
import com.becandid.thirdparty.BlurTask;
import com.facebook.AccessToken;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.schedulers.Schedulers;

public class MainTabsActivity
extends PopupWithBlurBackgroundActivity
implements TabLayout.a {
    public static final int CREATE_GROUP = 1001;
    public static final int CREATE_POST_REQUEST = 888;
    public static final int PERMISSION_READ_CONTACTS = 1;
    final BroadcastReceiver b;
    private final int c = 999;
    private Handler d;
    private final int e = 60000;
    private List<String> f;
    private MeTabFragment g;
    private FeedTabFragment h;
    private MessageTabFragment i;
    private hj j;
    private Runnable k;
    @BindView(value=2131624194)
    TabLayout mBottomTabs;
    @BindView(value=2131624211)
    View mCreatePostBtn;
    @BindView(value=2131624209)
    MainTabViewPager mViewPager;

    public MainTabsActivity() {
        this.b = new BroadcastReceiver(){

            public void onReceive(Context context, Intent intent) {
                if (intent.getExtras().getString("activity_id") != null) {
                    MainTabsActivity.this.busSubscribe(in.as.class, new apr<in.as>(){

                        @Override
                        public void onCompleted() {
                        }

                        @Override
                        public void onError(Throwable throwable) {
                            rj.a(throwable);
                        }

                        @Override
                        public void onNext(in.as as2) {
                            MainTabsActivity.this.a(as2);
                        }
                    });
                }
                this.abortBroadcast();
            }

        };
        this.k = new Runnable(){

            public void run() {
                MainTabsActivity.this.d.postDelayed(MainTabsActivity.this.k, 60000);
            }
        };
    }

    private FeedTabFragment a() {
        return (FeedTabFragment)this.j.b(0);
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void a(int n2, int n3, int n4) {
        if (this.mViewPager.getCurrentItem() == n4) {
            return;
        }
        String string2 = n2 > 99 ? "99+" : Integer.toString((int)n2);
        View view = this.mBottomTabs.a(n4).a();
        if (view == null) return;
        View view2 = view.findViewById(2131624524);
        TextView textView = (TextView)view.findViewById(2131624525);
        if (n2 < 1) {
            view2.setVisibility(8);
            return;
        }
        view2.setVisibility(0);
        textView.setText((CharSequence)string2);
        if (n3 != 2) return;
        if (AppState.hasMessagingShown) return;
        this.setShowMessagingPopup(true);
        new BlurTask((Activity)this, this.findViewById(16908290), BlurTask.BadgeType.e).execute((Object[])new Void[0]);
        AppState.hasMessagingShown = true;
        AppState.saveState((ContextWrapper)GossipApplication.a());
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(in.as as2) {
        int n2 = as2.a;
        int n3 = as2.b;
        int n4 = this.mViewPager.getCurrentItem();
        if (n2 == 3 && n4 != 4) {
            AppState.account.unread_activity_count = n3;
            super.a(n3, n2, 4);
            return;
        } else {
            if (n2 == 0 && n4 != 0) {
                AppState.account.unread_feed_count = n3;
                super.a(n3, n2, 0);
                return;
            }
            if (n2 == 1 && n4 != 1) {
                AppState.account.unread_groups_count = n3;
                super.a(n3, n2, 1);
                return;
            }
            if (n2 != 2 || n4 == 3) return;
            {
                AppState.account.unread_message_count = n3;
                super.a(n3, n2, 3);
                return;
            }
        }
    }

    private MeTabFragment b() {
        if (AppState.config.experimentConfig.containsKey((Object)"messaging_turned_on") && AppState.config.getBoolean("messaging_turned_on")) {
            return (MeTabFragment)this.j.b(4);
        }
        return (MeTabFragment)this.j.b(3);
    }

    private MessageTabFragment c() {
        if (AppState.config.experimentConfig.containsKey((Object)"messaging_turned_on") && AppState.config.getBoolean("messaging_turned_on")) {
            return (MessageTabFragment)this.j.b(3);
        }
        return null;
    }

    private void d() {
        if (AppState.account == null) {
            return;
        }
        ik.a().b(Boolean.toString((boolean)false), null).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
                MainTabsActivity.this.e();
            }

            @Override
            public void onNext(NetworkData networkData) {
                if (networkData.unread_count > 0) {
                    AppState.account.unread_activity_count = networkData.unread_count;
                }
                if (networkData.unread_groups_count > 0) {
                    AppState.account.unread_groups_count = networkData.unread_groups_count;
                }
                if (AppState.account.unread_activity_count > 0 && networkData.unread_count == 0) {
                    AppState.account.unread_activity_count = 0;
                }
                MainTabsActivity.this.e();
            }
        });
    }

    public static void disownAccount(final Context context) {
        ik.a().a(true).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                Toast.makeText((Context)context, (CharSequence)"Unable to disown account, please try again.", (int)1).show();
            }

            @Override
            public void onNext(NetworkData networkData) {
                if (networkData.success) {
                    AppState.disownAccount();
                    Intent intent = GossipApplication.a().getBaseContext().getPackageManager().getLaunchIntentForPackage(GossipApplication.a().getPackageName());
                    intent.addFlags(32768);
                    intent.addFlags(268435456);
                    context.startActivity(intent);
                }
            }
        });
    }

    private void e() {
        this.a(AppState.account.unread_feed_count, -1, 0);
        this.a(AppState.account.unread_groups_count, -1, 1);
        this.a(AppState.account.unread_activity_count, -1, 4);
        if (AppState.config.getBoolean("messaging_turned_on", true)) {
            this.a(AppState.account.unread_message_count, -1, 3);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean f() {
        xd xd2 = xd.a();
        int n2 = xd2.a((Context)this);
        if (n2 == 0) return true;
        if (xd2.a(n2)) {
            xd2.a((Activity)this, n2, 9000).show();
            do {
                return false;
                break;
            } while (true);
        }
        this.finish();
        return false;
    }

    public void createPost(View view) {
        if (!this.mIsShowingMessagingPopup) {
            this.startActivityForResult(new Intent((Context)this, (Class)CreatePostActivity.class), 888);
        }
    }

    @Override
    public void hideCurrentScreen() {
        int n2 = this.mViewPager.getCurrentItem();
        Fragment fragment = this.j.b(n2);
        if (fragment != null && fragment instanceof ht) {
            ((ht)fragment).c();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    protected void onActivityResult(int n2, int n3, Intent intent) {
        Fragment fragment;
        super.onActivityResult(n2, n3, intent);
        int n4 = this.mViewPager.getCurrentItem();
        if (n4 >= 0 && n4 < this.f.size() && (fragment = this.j.b(n4)) != null && fragment instanceof ht) {
            ((ht)fragment).onActivityResult(n2, n3, intent);
        }
        if (n2 == 888 && n3 == -1 && n4 != 0) {
            this.mViewPager.setCurrentItem(0, true);
        }
        if (n2 == 1001 && n3 == -1 && intent != null) {
            Group group = (Group)intent.getSerializableExtra("group");
            if (group == null) {
                rj.a(new Throwable("Group is NULL after creating a Group"));
                return;
            }
            Intent intent2 = new Intent((Context)this, (Class)GroupDetailsActivity.class);
            intent2.putExtra("group_id", group.group_id);
            intent2.putExtra("group_json", DataUtil.toJson(group));
            this.startActivity(intent2);
        }
        if (n2 == 1104 && n3 == -1) {
            ix.a().a(new in.au());
        }
        if (n2 != 999) return;
        if (n3 != -1) return;
        this.a.setAlpha(1.0f);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (AppState.config.experimentConfig.containsKey((Object)"messaging_turned_on") && AppState.config.getBoolean("messaging_turned_on")) {
            this.setContentView(2130968619);
            this.f = Arrays.asList((Object[])new String[]{"feed", "groups", "post", "messages", "me"});
        } else {
            this.setContentView(2130968618);
            this.f = Arrays.asList((Object[])new String[]{"feed", "groups", "post", "me", "activity"});
        }
        ButterKnife.bind((Activity)this);
        AppState.mainTabsActivity = this;
        this.d = new Handler(this.getMainLooper());
        this.a = (RelativeLayout)this.findViewById(2131624193);
        this.j = new hj(this.getSupportFragmentManager());
        this.j.a(this.f);
        this.mViewPager.setSwipeEnabled(false);
        this.mViewPager.setAdapter((ev)((Object)this.j));
        this.mViewPager.setOffscreenPageLimit(4);
        this.mBottomTabs.setupWithViewPager((ViewPager)this.mViewPager);
        this.mBottomTabs.setOnTabSelectedListener((TabLayout.a)this);
        this.mBottomTabs.setSelectedTabIndicatorHeight(0);
        for (int i2 = 0; i2 < this.mBottomTabs.getTabCount(); ++i2) {
            this.mBottomTabs.a(i2).a(this.j.a(i2));
        }
        if (super.f()) {
            this.startService(new Intent((Context)this, (Class)RegistrationIntentService.class));
        }
        if (AppState.config != null && AppState.config.getBoolean("android_force_upgrade_version_number")) {
            AlertDialog.Builder builder = new AlertDialog.Builder((Context)this);
            builder.setTitle((CharSequence)"A new version is available. Pleage update your app!").setCancelable(false).setPositiveButton((CharSequence)"Update", new DialogInterface.OnClickListener(){

                public void onClick(DialogInterface dialogInterface, int n2) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse((String)"market://details?id=com.becandid.candid"));
                    MainTabsActivity.this.startActivity(intent);
                    MainTabsActivity.this.finish();
                }
            }).setNegativeButton((CharSequence)"Quit app", new DialogInterface.OnClickListener(){

                public void onClick(DialogInterface dialogInterface, int n2) {
                    System.exit((int)0);
                }
            });
            builder.show();
        }
        if (AppState.needAge == 1 && AppState.age == null) {
            if (AppState.fbInfo != null && AppState.fbInfo.fbToken != null && AppState.fbInfo.fbToken.b() != null) {
                HashMap hashMap = new HashMap();
                hashMap.put((Object)"fb_token", (Object)AppState.fbInfo.fbToken.b());
                ik.a().a((Map<String, String>)hashMap);
            } else {
                this.a.setAlpha(0.2f);
                this.startActivityForResult(new Intent((Context)this, (Class)VerifyAgeActivity.class), 999);
            }
        }
        this.busSubscribe(ix.a().a(in.e.class, new apr<in.e>(){

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
            }

            @Override
            public void onNext(in.e e2) {
                if (e2.a >= 0 && e2.a < 5 && e2.a != 2) {
                    MainTabsActivity.this.mViewPager.setCurrentItem(e2.a);
                }
            }
        }));
        this.busSubscribe(ix.a().a(in.as.class, new apr<in.as>(){

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
            }

            @Override
            public void onNext(in.as as2) {
                if (as2.c) {
                    MainTabsActivity.this.a(as2);
                    return;
                }
                MainTabsActivity.this.g = MainTabsActivity.this.b();
                MainTabsActivity.this.g.a();
                MainTabsActivity.this.g.a(as2);
            }
        }));
        this.busSubscribe(ix.a().a(in.au.class, new apr<in.au>(){

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
            }

            @Override
            public void onNext(in.au au2) {
                MainTabsActivity.this.h = MainTabsActivity.this.a();
                MainTabsActivity.this.h.a();
                MainTabsActivity.this.g = MainTabsActivity.this.b();
                MainTabsActivity.this.g.a();
            }
        }));
        this.busSubscribe(ix.a().a(in.f.class, new apr<in.f>(){

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
            }

            @Override
            public void onNext(in.f f2) {
                MainTabsActivity.this.setShowMessagingPopup(false);
            }
        }));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppState.mainTabsActivity = null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    protected void onPause() {
        Fragment fragment;
        super.onPause();
        try {
            this.unregisterReceiver(this.b);
        }
        catch (IllegalArgumentException var1_2) {
            rj.a((Throwable)var1_2);
        }
        if ((fragment = this.j.b(this.mViewPager.getCurrentItem())) != null && (fragment instanceof MeTabFragment || fragment instanceof ActivityTabFragment)) {
            ik.a().b(Boolean.toString((boolean)true), null).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
        } else if (fragment != null && fragment instanceof ht) {
            ((ht)fragment).onPause();
        }
        this.d.removeCallbacks(this.k);
    }

    @Override
    public void onRequestPermissionsResult(int n2, String[] arrstring, int[] arrn) {
        super.onRequestPermissionsResult(n2, arrstring, arrn);
        switch (n2) {
            default: {
                return;
            }
            case 1: 
        }
        this.g = super.b();
        if (arrn.length > 0 && arrn[0] == 0) {
            this.g.g();
            return;
        }
        this.g.h();
    }

    @Override
    protected void onResume() {
        String string2;
        Fragment fragment;
        int n2;
        int n3;
        super.onResume();
        IntentFilter intentFilter = new IntentFilter("com.becandid.candid.GOT_PUSH");
        intentFilter.setPriority(2);
        this.registerReceiver(this.b, intentFilter);
        Uri uri = this.getIntent().getData();
        if (uri != null && uri.getPathSegments() != null && !uri.getPathSegments().isEmpty() && (n3 = this.f.indexOf((Object)(string2 = (String)uri.getPathSegments().get(0)))) != -1 && n3 != 2) {
            this.mViewPager.setCurrentItem(n3);
        }
        if ((fragment = this.j.b(n2 = this.mViewPager.getCurrentItem())) != null && fragment instanceof ht) {
            ((ht)fragment).onResume();
        }
        this.d();
        ik.a().h().b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            @Override
            public void onNext(NetworkData networkData) {
                if (networkData == null) return;
                try {
                    AppState.account.unread_message_count = networkData.new_threads + networkData.new_requests;
                    MainTabsActivity.this.d();
                    return;
                }
                catch (Exception var2_2) {
                    rj.a((Throwable)var2_2);
                    return;
                }
            }
        });
        this.d.postDelayed(this.k, 60000);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void onTabReselected(TabLayout.d d2) {
        int n2 = d2.c();
        Fragment fragment = this.j.b(n2);
        if (fragment != null && fragment instanceof ht) {
            if (fragment instanceof MeTabFragment) {
                ((MeTabFragment)fragment).e();
            } else {
                ((ht)fragment).a();
            }
        }
        d2.a().findViewById(2131624524).setVisibility(8);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void onTabSelected(TabLayout.d d2) {
        this.mViewPager.setCurrentItem(d2.c(), true);
        int n2 = d2.c();
        View view = d2.a();
        ImageView imageView = (ImageView)view.findViewById(2131624522);
        ((TextView)view.findViewById(2131624523)).setTextColor(this.getResources().getColor(2131558476));
        imageView.setImageResource(this.getResources().getIdentifier((String)this.f.get(n2) + "_tab_orange", "drawable", this.getPackageName()));
        view.findViewById(2131624521).setAlpha(1.0f);
        view.findViewById(2131624524).setVisibility(8);
        switch (n2) {
            case 0: {
                AppState.account.unread_feed_count = 0;
                return;
            }
            case 1: {
                AppState.account.unread_groups_count = 0;
                return;
            }
            case 3: {
                if (!AppState.config.getBoolean("messaging_turned_on", true)) return;
                {
                    if (!AppState.hasMessagingShown) {
                        this.i = super.c();
                        this.i.d();
                    }
                    ix.a().a(new in.u());
                    return;
                }
            }
            default: {
                return;
            }
            case 4: 
        }
        AppState.account.unread_activity_count = 0;
        if (!AppState.config.getBoolean("messaging_turned_on", true)) return;
        {
            this.g = super.b();
            if (this.g == null) return;
            {
                this.g.e();
                return;
            }
        }
    }

    public void onTabUnselected(TabLayout.d d2) {
        int n2 = d2.c();
        View view = d2.a();
        ImageView imageView = (ImageView)view.findViewById(2131624522);
        ((TextView)view.findViewById(2131624523)).setTextColor(this.getResources().getColor(17170444));
        imageView.setImageResource(this.getResources().getIdentifier((String)this.f.get(n2) + "_tab", "drawable", this.getPackageName()));
        view.findViewById(2131624521).setAlpha(0.5f);
        view.findViewById(2131624524).setVisibility(8);
        if (n2 == 4) {
            ik.a().b(Boolean.toString((boolean)true), null).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
        }
    }

    public void setShowMessagingPopup(boolean bl2) {
        this.mIsShowingMessagingPopup = bl2;
    }

    @Override
    public void showCurrentScreen() {
        int n2 = this.mViewPager.getCurrentItem();
        Fragment fragment = this.j.b(n2);
        if (fragment != null && fragment instanceof ht) {
            ((ht)fragment).b();
        }
    }

    @Override
    protected void showSnack(boolean bl2) {
        super.showSnack(bl2);
        View view = this.findViewById(2131624194);
        if (!bl2 && view != null) {
            Snackbar.a((View)view, (CharSequence)"No Internet connection!", (int)0).a();
        }
    }

    @Override
    public void upsellChange(int n2) {
        super.upsellChange(n2);
        this.h = super.a();
        this.h.a(n2);
    }

}

