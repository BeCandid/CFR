/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Bundle
 *  android.support.v7.widget.LinearLayoutManager
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$Adapter
 *  android.support.v7.widget.RecyclerView$LayoutManager
 *  android.support.v7.widget.RecyclerView$OnItemTouchListener
 *  android.text.Editable
 *  android.text.TextWatcher
 *  android.util.Log
 *  android.view.KeyEvent
 *  android.view.View
 *  android.widget.EditText
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  android.widget.TextView$OnEditorActionListener
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.List
 *  rx.schedulers.Schedulers
 */
package com.becandid.candid.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.data.MessageThread;
import com.becandid.candid.models.NetworkData;
import java.util.List;
import rx.schedulers.Schedulers;

public class MessageSearchActivity
extends BaseActivity {
    private hl b;
    @BindView(value=2131624249)
    RecyclerView resultRecycler;
    @BindView(value=2131624247)
    EditText searchEdit;
    @BindView(value=2131624248)
    LinearLayout searchProgressBar;

    private void a() {
        this.b.c();
        this.resultRecycler.getAdapter().notifyDataSetChanged();
    }

    private void a(final String string2) {
        this.searchProgressBar.setVisibility(0);
        this.resultRecycler.setVisibility(8);
        super.a();
        ik.a().l(string2).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                Log.d((String)"GroupSearch", (String)throwable.toString());
                MessageSearchActivity.this.searchProgressBar.setVisibility(8);
                MessageSearchActivity.this.resultRecycler.setVisibility(0);
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void onNext(NetworkData networkData) {
                if (MessageSearchActivity.this.isStopped) {
                    return;
                }
                if (!networkData.success) {
                    MessageSearchActivity.this.a();
                    MessageSearchActivity.this.searchProgressBar.setVisibility(8);
                    MessageSearchActivity.this.resultRecycler.setVisibility(0);
                    return;
                }
                if (!MessageSearchActivity.this.searchEdit.getText().toString().equals((Object)string2)) {
                    MessageSearchActivity.this.a();
                    MessageSearchActivity.this.searchProgressBar.setVisibility(8);
                    MessageSearchActivity.this.resultRecycler.setVisibility(0);
                    return;
                }
                if (networkData.results != null) {
                    MessageSearchActivity.this.b.a(networkData.results);
                    MessageSearchActivity.this.b.notifyDataSetChanged();
                } else {
                    MessageSearchActivity.this.a();
                }
                MessageSearchActivity.this.searchProgressBar.setVisibility(8);
                MessageSearchActivity.this.resultRecycler.setVisibility(0);
            }
        });
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130968622);
        ButterKnife.bind((Activity)this);
        this.b = new hl((Context)this);
        this.resultRecycler.setAdapter((RecyclerView.Adapter)this.b);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager((Context)this);
        this.resultRecycler.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
        this.resultRecycler.setHasFixedSize(true);
        this.resultRecycler.addOnItemTouchListener((RecyclerView.OnItemTouchListener)new iv((Context)this){

            @Override
            public void onItemClick(View view, int n2) {
                MessageSearchActivity.this.b.b(n2);
            }
        });
        this.searchEdit.addTextChangedListener(new TextWatcher(){

            public void afterTextChanged(Editable editable) {
                if (editable.length() >= 3) {
                    MessageSearchActivity.this.a(editable.toString());
                    return;
                }
                MessageSearchActivity.this.a();
                MessageSearchActivity.this.searchProgressBar.setVisibility(8);
                MessageSearchActivity.this.resultRecycler.setVisibility(0);
            }

            public void beforeTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
            }

            public void onTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
            }
        });
        this.searchEdit.setOnEditorActionListener(new TextView.OnEditorActionListener(){

            public boolean onEditorAction(TextView textView, int n2, KeyEvent keyEvent) {
                if (n2 == 3 || keyEvent != null && keyEvent.getAction() == 1 && keyEvent.getKeyCode() == 66) {
                    MessageSearchActivity.this.a(MessageSearchActivity.this.searchEdit.getText().toString());
                    return true;
                }
                return false;
            }
        });
    }

}

