/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ContextWrapper
 *  android.os.Bundle
 *  android.support.v4.app.FragmentActivity
 *  android.view.View
 *  android.view.View$OnClickListener
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  java.lang.Object
 */
package com.becandid.candid.activities;

import android.app.Activity;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.data.AppState;

public class TutorialMuteActivity
extends FragmentActivity {
    @BindView(value=2131624306)
    View muteNo;
    @BindView(value=2131624305)
    View muteYes;

    public void finishTutorial() {
        AppState.hasMuted = true;
        AppState.saveState((ContextWrapper)GossipApplication.a());
        this.finish();
    }

    public void onBackPressed() {
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130968633);
        ButterKnife.bind((Activity)this);
        this.muteYes.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                TutorialMuteActivity.this.setResult(199);
                TutorialMuteActivity.this.finishTutorial();
            }
        });
        this.muteNo.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                TutorialMuteActivity.this.finishTutorial();
            }
        });
    }

}

