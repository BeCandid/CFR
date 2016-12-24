/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ClipData
 *  android.content.ClipData$Item
 *  android.content.ClipDescription
 *  android.content.ClipboardManager
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Bundle
 *  android.text.Editable
 *  android.util.Log
 *  android.view.KeyEvent
 *  android.view.View
 *  android.widget.EditText
 *  android.widget.TextView
 *  android.widget.TextView$OnEditorActionListener
 *  android.widget.Toast
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  butterknife.OnClick
 *  com.google.gson.internal.LinkedTreeMap
 *  java.io.Serializable
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Map
 *  rx.schedulers.Schedulers
 */
package com.becandid.candid.activities;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.becandid.candid.activities.BaseActivity;
import com.google.gson.internal.LinkedTreeMap;
import java.io.Serializable;
import java.util.Map;
import rx.schedulers.Schedulers;

public class AddLinkActivity
extends BaseActivity {
    private String b;
    private Map<String, String> c;
    @BindView(value=2131624070)
    TextView copiedLink;
    @BindView(value=2131624072)
    View spinny;
    @BindView(value=2131624068)
    EditText typedLink;

    private void a() {
        if (this.c != null) {
            Intent intent = new Intent();
            intent.putExtra("link_info", (Serializable)((LinkedTreeMap)this.c));
            this.setResult(-1, intent);
            this.finish();
        }
    }

    private void a(String string2) {
        if (string2 == null || !iz.a(string2)) {
            Toast.makeText((Context)this, (CharSequence)"That does not appear to be a valid url", (int)1).show();
            return;
        }
        this.spinny.setVisibility(0);
        this.addToSubscriptionList(ik.a().d(string2).b(Schedulers.io()).a(apv.a()).b(new apr<Map<String, String>>(){

            @Override
            public void onCompleted() {
                AddLinkActivity.this.spinny.setVisibility(8);
                AddLinkActivity.this.a();
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
                Toast.makeText((Context)AddLinkActivity.this, (CharSequence)"There was an error fetching this link", (int)1);
            }

            @Override
            public void onNext(Map<String, String> map) {
                if (map != null) {
                    AddLinkActivity.this.c = map;
                    return;
                }
                Toast.makeText((Context)AddLinkActivity.this, (CharSequence)"There was an error fetching this link", (int)1);
            }
        }));
    }

    @OnClick(value={2131624071})
    public void chooseCopiedLink(View view) {
        if (this.b != null) {
            super.a(this.b);
            return;
        }
        Toast.makeText((Context)this, (CharSequence)"The clipboard doesn't seem to have a link.", (int)1).show();
    }

    @OnClick(value={2131624069})
    public void chooseTypedLink(View view) {
        super.a(this.typedLink.getText().toString());
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130968601);
        ButterKnife.bind((Activity)this);
        ClipboardManager clipboardManager = (ClipboardManager)this.getSystemService("clipboard");
        this.b = null;
        if (clipboardManager.hasPrimaryClip() && clipboardManager.getPrimaryClip().getItemCount() > 0) {
            ClipData.Item item = clipboardManager.getPrimaryClip().getItemAt(0);
            if (clipboardManager.getPrimaryClipDescription().hasMimeType("text/plain")) {
                this.b = item.getText().toString();
            } else if (clipboardManager.getPrimaryClipDescription().hasMimeType("text/uri-list")) {
                this.b = item.getUri().toString();
            }
        }
        Log.d((String)"ALA", (String)("Clipboard has: " + this.b));
        if (this.b != null && this.b.startsWith("http")) {
            this.copiedLink.setText((CharSequence)this.b);
            this.copiedLink.setVisibility(0);
        }
        this.typedLink.setOnEditorActionListener(new TextView.OnEditorActionListener(){

            public boolean onEditorAction(TextView textView, int n2, KeyEvent keyEvent) {
                if (n2 == 6 || keyEvent != null && keyEvent.getAction() == 1 && keyEvent.getKeyCode() == 66) {
                    AddLinkActivity.this.chooseTypedLink(null);
                    return true;
                }
                return false;
            }
        });
    }

}

