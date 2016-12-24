/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  com.google.android.gms.iid.InstanceIDListenerService
 *  java.lang.Class
 */
package com.becandid.candid.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.becandid.candid.services.RegistrationIntentService;
import com.google.android.gms.iid.InstanceIDListenerService;

public class CustomInstanceIDListenerService
extends InstanceIDListenerService {
    public void a() {
        this.startService(new Intent((Context)this, (Class)RegistrationIntentService.class));
    }
}

