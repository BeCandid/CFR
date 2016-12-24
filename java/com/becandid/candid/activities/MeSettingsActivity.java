/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.ProgressDialog
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Bundle
 *  android.support.v7.widget.LinearLayoutManager
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$Adapter
 *  android.support.v7.widget.RecyclerView$LayoutManager
 *  android.widget.TextView
 *  android.widget.Toast
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.List
 *  rx.schedulers.Schedulers
 */
package com.becandid.candid.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.activities.ChangeEndpointActivity;
import com.becandid.candid.activities.NotificationSettingsActivity;
import com.becandid.candid.activities.OnboardingActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.models.NetworkData;
import java.util.ArrayList;
import java.util.List;
import rx.schedulers.Schedulers;

public class MeSettingsActivity
extends BaseActivity {
    public static final int HEADER = 0;
    public static final int ITEM = 1;
    public static String TAG_SETTINGS_KEY = "tag_settings";
    private ArrayList<Setting> b;
    private hk c;
    @BindView(value=2131624213)
    RecyclerView recyclerView;
    @BindView(value=2131624214)
    TextView versionNumber;

    public void disownAccount() {
        final ProgressDialog progressDialog = ProgressDialog.show((Context)this, (CharSequence)"", (CharSequence)"Disowning account...", (boolean)true, (boolean)false);
        ik.a().a(true).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                progressDialog.dismiss();
                Toast.makeText((Context)MeSettingsActivity.this, (CharSequence)"Unable to disown account, please try again.", (int)1).show();
            }

            @Override
            public void onNext(NetworkData networkData) {
                if (networkData.success) {
                    AppState.disownAccount();
                    Intent intent = GossipApplication.a().getBaseContext().getPackageManager().getLaunchIntentForPackage(GossipApplication.a().getPackageName());
                    intent.addFlags(32768);
                    intent.addFlags(268435456);
                    MeSettingsActivity.this.startActivity(intent);
                }
            }
        });
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130968620);
        ButterKnife.bind((Activity)this);
        this.b = new ArrayList();
        Setting setting = (MeSettingsActivity)this.new Setting(0, "ACCOUNT");
        this.b.add((Object)setting);
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean(TAG_SETTINGS_KEY, true);
        ActivitySetting activitySetting = (MeSettingsActivity)this.new ActivitySetting(1, "Edit Interests", OnboardingActivity.class, bundle2);
        this.b.add((Object)activitySetting);
        ActivitySetting activitySetting2 = (MeSettingsActivity)this.new ActivitySetting(1, "Notification Settings", NotificationSettingsActivity.class, null);
        this.b.add((Object)activitySetting2);
        Setting setting2 = (MeSettingsActivity)this.new Setting(0, "ABOUT");
        this.b.add((Object)setting2);
        WebViewSetting webViewSetting = (MeSettingsActivity)this.new WebViewSetting(1, "About Candid", "content/about");
        this.b.add((Object)webViewSetting);
        WebViewSetting webViewSetting2 = (MeSettingsActivity)this.new WebViewSetting(1, "Terms of Service", "content/terms");
        this.b.add((Object)webViewSetting2);
        WebViewSetting webViewSetting3 = (MeSettingsActivity)this.new WebViewSetting(1, "Privacy Policy", "content/privacy");
        this.b.add((Object)webViewSetting3);
        WebViewSetting webViewSetting4 = (MeSettingsActivity)this.new WebViewSetting(1, "Community Guidelines", "content/community");
        this.b.add((Object)webViewSetting4);
        WebViewSetting webViewSetting5 = (MeSettingsActivity)this.new WebViewSetting(1, "Get Help", "content/help");
        this.b.add((Object)webViewSetting5);
        Setting setting3 = (MeSettingsActivity)this.new Setting(0, "");
        this.b.add((Object)setting3);
        Setting setting4 = (MeSettingsActivity)this.new Setting(1, "Disown Permanently");
        this.b.add((Object)setting4);
        if (AppState.internal) {
            Setting setting5 = (MeSettingsActivity)this.new Setting(0, "Internal");
            this.b.add((Object)setting5);
            ActivitySetting activitySetting3 = (MeSettingsActivity)this.new ActivitySetting(1, "Change Endpoint", ChangeEndpointActivity.class, null);
            this.b.add((Object)activitySetting3);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager((Context)this);
        this.recyclerView.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
        this.c = new hk((List<Setting>)this.b, (Context)this);
        this.recyclerView.setAdapter((RecyclerView.Adapter)this.c);
        String string2 = "\u00a9 Candid 2016";
        try {
            String string3;
            string2 = string3 = string2 + " \u2022 Version " + this.getPackageManager().getPackageInfo((String)this.getPackageName(), (int)0).versionName;
        }
        catch (PackageManager.NameNotFoundException var32_19) {
            var32_19.printStackTrace();
        }
        this.versionNumber.setText((CharSequence)string2);
    }

    public class ActivitySetting
    extends Setting {
        public Bundle bundle;
        public Class toStart;

        public ActivitySetting(int n2, String string2, Class class_, Bundle bundle) {
            super(n2, string2);
            this.toStart = class_;
            this.bundle = bundle;
        }
    }

    public class Setting {
        public String name;
        public int type;

        public Setting(int n2, String string2) {
            this.type = n2;
            this.name = string2;
        }
    }

    public class WebViewSetting
    extends Setting {
        public String url;

        public WebViewSetting(int n2, String string2, String string3) {
            super(n2, string2);
            this.url = string3;
        }
    }

}

