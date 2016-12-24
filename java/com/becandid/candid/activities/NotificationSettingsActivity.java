/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.os.Bundle
 *  android.support.v7.app.AlertDialog
 *  android.support.v7.app.AlertDialog$Builder
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.ArrayAdapter
 *  android.widget.ImageView
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 *  rx.schedulers.Schedulers
 */
package com.becandid.candid.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.DataUtil;
import com.becandid.candid.data.EmptyClass;
import com.becandid.candid.models.EmptySubscriber;
import com.becandid.candid.models.NetworkData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.schedulers.Schedulers;

public class NotificationSettingsActivity
extends BaseActivity {
    private ArrayList<NetworkData.NotificationSetting> b;
    private boolean c;

    public void cancelClick(View view) {
        this.finish();
    }

    public void onBackPressed() {
        if (this.c) {
            new AlertDialog.Builder((Context)this).setTitle((CharSequence)"Unsaved changes").setMessage((CharSequence)"Save the settings or reset them?").setNegativeButton((CharSequence)"Reset", new DialogInterface.OnClickListener(){

                public void onClick(DialogInterface dialogInterface, int n2) {
                    NotificationSettingsActivity.this.cancelClick(null);
                }
            }).setPositiveButton((CharSequence)"Save", new DialogInterface.OnClickListener(){

                public void onClick(DialogInterface dialogInterface, int n2) {
                    NotificationSettingsActivity.this.saveClick(null);
                }
            }).create().show();
            return;
        }
        super.onBackPressed();
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130968624);
        ListView listView = (ListView)this.findViewById(2131624256);
        this.b = new ArrayList(10);
        if (AppState.notificationSettings == null) {
            rj.a(new Throwable("AppState notificationSettings is NULL"));
            this.finish();
            return;
        }
        for (NetworkData.NotificationSetting notificationSetting : AppState.notificationSettings) {
            this.b.add((Object)notificationSetting.copy());
        }
        final NotificationSettingsAdapter notificationSettingsAdapter = (NotificationSettingsActivity)this.new NotificationSettingsAdapter((Context)this, (List<NetworkData.NotificationSetting>)this.b);
        listView.setAdapter((ListAdapter)notificationSettingsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            /*
             * Enabled aggressive block sorting
             */
            public void onItemClick(AdapterView<?> adapterView, View view, int n2, long l2) {
                NetworkData.NotificationSetting notificationSetting = (NetworkData.NotificationSetting)notificationSettingsAdapter.getItem(n2);
                int n3 = notificationSetting.disabled == 1 ? 0 : 1;
                notificationSetting.disabled = n3;
                NotificationSettingsActivity.this.c = true;
                notificationSettingsAdapter.notifyDataSetChanged();
            }
        });
    }

    public void saveClick(View view) {
        AppState.notificationSettings = this.b;
        ArrayList arrayList = new ArrayList();
        for (NetworkData.NotificationSetting notificationSetting : this.b) {
            if (notificationSetting.disabled != 1) continue;
            arrayList.add((Object)notificationSetting.type);
        }
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"disabled", (Object)DataUtil.join(arrayList));
        ik.a().e((Map<String, String>)hashMap).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
        this.finish();
    }

    class NotificationSettingsAdapter
    extends ArrayAdapter<NetworkData.NotificationSetting> {
        public NotificationSettingsAdapter(Context context, List<NetworkData.NotificationSetting> list) {
            super(context, -1, list);
        }

        /*
         * Enabled aggressive block sorting
         */
        public View getView(int n2, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = ((LayoutInflater)this.getContext().getSystemService("layout_inflater")).inflate(2130968715, viewGroup, false);
            }
            NetworkData.NotificationSetting notificationSetting = (NetworkData.NotificationSetting)this.getItem(n2);
            ImageView imageView = (ImageView)view.findViewById(2131624611);
            int n3 = notificationSetting.disabled == 0 ? 2130837982 : 2130837709;
            imageView.setImageResource(n3);
            ((TextView)view.findViewById(2131624612)).setText((CharSequence)notificationSetting.display_name);
            return view;
        }
    }

}

