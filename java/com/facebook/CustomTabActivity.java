/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  java.lang.Class
 *  java.lang.String
 */
package com.facebook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.FacebookActivity;

public class CustomTabActivity
extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = new Intent((Context)this, (Class)FacebookActivity.class);
        intent.putExtra("url", this.getIntent().getDataString());
        intent.addFlags(603979776);
        this.startActivity(intent);
    }
}

