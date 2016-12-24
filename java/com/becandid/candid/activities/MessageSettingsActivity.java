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
import com.becandid.candid.data.Config;
import com.becandid.candid.data.User;
import com.becandid.candid.models.EmptySubscriber;
import com.becandid.candid.models.NetworkData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.schedulers.Schedulers;

public class MessageSettingsActivity
extends BaseActivity {
    private ArrayList<String> b;
    private ArrayList<String> c;
    private ToggleSettingsAdapter d;
    private ToggleSettingsAdapter e;
    private boolean f;

    public void cancelClick(View view) {
        this.finish();
    }

    public void onBackPressed() {
        if (this.f) {
            new AlertDialog.Builder((Context)this).setTitle((CharSequence)"Unsaved changes").setMessage((CharSequence)"Save the settings or reset them?").setNegativeButton((CharSequence)"Reset", new DialogInterface.OnClickListener(){

                public void onClick(DialogInterface dialogInterface, int n2) {
                    MessageSettingsActivity.this.cancelClick(null);
                }
            }).setPositiveButton((CharSequence)"Save", new DialogInterface.OnClickListener(){

                public void onClick(DialogInterface dialogInterface, int n2) {
                    MessageSettingsActivity.this.saveClick(null);
                }
            }).create().show();
            return;
        }
        super.onBackPressed();
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130968623);
        ListView listView = (ListView)this.findViewById(2131624251);
        ListView listView2 = (ListView)this.findViewById(2131624253);
        this.b = new ArrayList(2);
        this.b.add((Object)AppState.config.getString("enable_messaging_prompt", "Messaging enabled"));
        this.b.add((Object)AppState.config.getString("disable_messaging_prompt", "Messaging disabled"));
        this.c = new ArrayList(2);
        this.c.add((Object)AppState.config.getString("self_delete_messages_prompt", "Messages manually deleted"));
        this.c.add((Object)AppState.config.getString("auto_delete_messages_prompt", "Messages deleted automatically after 2 days"));
        this.d = (MessageSettingsActivity)this.new ToggleSettingsAdapter((Context)this, (List<String>)this.b, AppState.account.messaging_disabled);
        listView.setAdapter((ListAdapter)this.d);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            public void onItemClick(AdapterView<?> adapterView, View view, int n2, long l2) {
                MessageSettingsActivity.this.f = MessageSettingsActivity.this.d.selectOption(n2);
            }
        });
        this.e = (MessageSettingsActivity)this.new ToggleSettingsAdapter((Context)this, (List<String>)this.c, AppState.account.message_auto_deletion);
        listView2.setAdapter((ListAdapter)this.e);
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            public void onItemClick(AdapterView<?> adapterView, View view, int n2, long l2) {
                MessageSettingsActivity.this.f = MessageSettingsActivity.this.e.selectOption(n2);
            }
        });
    }

    public void saveClick(View view) {
        if (this.f) {
            HashMap hashMap = new HashMap();
            hashMap.put((Object)"messaging_disabled", (Object)Integer.toString((int)this.d.getSetting()));
            hashMap.put((Object)"message_auto_deletion", (Object)Integer.toString((int)this.e.getSetting()));
            AppState.account.messaging_disabled = this.d.getSetting();
            AppState.account.message_auto_deletion = this.e.getSetting();
            ik.a().r((Map<String, String>)hashMap).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
            ix.a().a(new in.aa(AppState.account.messaging_disabled));
        }
        this.finish();
    }

    class ToggleSettingsAdapter
    extends ArrayAdapter<String> {
        private int b;

        public ToggleSettingsAdapter(Context context, List<String> list, int n2) {
            super(context, -1, list);
            this.b = n2;
        }

        public int getSetting() {
            return this.b;
        }

        /*
         * Enabled aggressive block sorting
         */
        public View getView(int n2, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = ((LayoutInflater)this.getContext().getSystemService("layout_inflater")).inflate(2130968715, viewGroup, false);
            }
            ImageView imageView = (ImageView)view.findViewById(2131624611);
            int n3 = n2 == this.b ? 2130837982 : 2130837709;
            imageView.setImageResource(n3);
            ((TextView)view.findViewById(2131624612)).setText((CharSequence)this.getItem(n2));
            return view;
        }

        public boolean selectOption(int n2) {
            if (this.b == n2) {
                return false;
            }
            this.b = n2;
            this.notifyDataSetChanged();
            return true;
        }
    }

}

