/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Bundle
 *  android.support.v7.app.ActionBar
 *  android.support.v7.widget.Toolbar
 *  android.text.Editable
 *  android.view.View
 *  android.view.inputmethod.InputMethodManager
 *  android.widget.EditText
 *  android.widget.RadioButton
 *  android.widget.RadioGroup
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.becandid.candid.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.activities.BaseActivity;

public class ChangeEndpointActivity
extends BaseActivity {
    public String PROD_ENDPOINT = "https://becandid.com/";
    public String STAGING_ENDPOINT = "https://dev.becandid.com/";
    private String b = this.PROD_ENDPOINT;
    @BindView(value=2131624083)
    EditText mEndpointText;
    @BindView(value=2131624084)
    RadioGroup mRadioGroup;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130968603);
        ButterKnife.bind((Activity)this);
        this.setSupportActionBar((Toolbar)this.findViewById(2131624081));
        this.getSupportActionBar().setDisplayShowTitleEnabled(false);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setHomeAsUpIndicator(2130837589);
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void onRadioButtonClicked(View view) {
        boolean bl2 = ((RadioButton)view).isChecked();
        switch (view.getId()) {
            default: {
                return;
            }
            case 2131624085: {
                if (bl2) {
                    this.b = this.PROD_ENDPOINT;
                    this.mEndpointText.setText((CharSequence)this.b);
                    this.mEndpointText.setEnabled(false);
                    return;
                }
            }
            case 2131624086: {
                if (!bl2) break;
                this.b = this.STAGING_ENDPOINT;
                this.mEndpointText.setText((CharSequence)this.b);
                this.mEndpointText.setEnabled(false);
                return;
            }
            case 2131624087: 
        }
        if (!bl2) return;
        this.mEndpointText.setEnabled(true);
        this.mEndpointText.requestFocus();
        ((InputMethodManager)this.getSystemService("input_method")).showSoftInput((View)this.mEndpointText, 1);
    }

    public void onSaveEndpoint(View view) {
        ik.a().a(this.mEndpointText.getText().toString());
        this.finish();
    }
}

