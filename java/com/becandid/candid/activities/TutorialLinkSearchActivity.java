/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ContextWrapper
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  java.lang.Object
 */
package com.becandid.candid.activities;

import android.app.Activity;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.data.AppState;

public class TutorialLinkSearchActivity
extends BaseActivity {
    @BindView(value=2131624301)
    Button mContinue;

    public void onBackPressed() {
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130968632);
        ButterKnife.bind((Activity)this);
        this.mContinue.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                AppState.hasLinkSearched = true;
                AppState.saveState((ContextWrapper)GossipApplication.a());
                TutorialLinkSearchActivity.this.finish();
            }
        });
    }

}

