/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  com.google.android.gms.gcm.GcmListenerService
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 */
package com.becandid.candid.services;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Config;
import com.becandid.candid.data.DataUtil;
import com.becandid.candid.data.User;
import com.google.android.gms.gcm.GcmListenerService;

public class GcmMessageHandler
extends GcmListenerService {
    /*
     * Enabled aggressive block sorting
     */
    public void a(String string2, Bundle bundle) {
        if (AppState.account == null) {
            return;
        }
        Intent intent = new Intent("com.becandid.candid.GOT_PUSH");
        intent.putExtras(bundle);
        if (bundle.containsKey("unread_activity_count")) {
            if ("like_post".equals((Object)bundle.getString("notification_type")) && "0".equals((Object)bundle.getString("unread_activity_count"))) {
                if (AppState.account.unread_activity_count == 0) {
                    AppState.account.unread_activity_count = 1;
                } else {
                    User user = AppState.account;
                    user.unread_activity_count = 1 + user.unread_activity_count;
                }
            } else {
                AppState.account.unread_activity_count = Integer.parseInt((String)bundle.getString("unread_activity_count"));
            }
            ix.a().a(new in.as(3, AppState.account.unread_activity_count));
        }
        if (bundle.containsKey("unread_feed_count")) {
            AppState.account.unread_feed_count = Integer.parseInt((String)bundle.getString("unread_feed_count"));
            ix.a().a(new in.as(0, AppState.account.unread_feed_count));
        }
        if (bundle.containsKey("unread_groups_count")) {
            AppState.account.unread_groups_count = Integer.parseInt((String)bundle.getString("unread_groups_count"));
            ix.a().a(new in.as(1, AppState.account.unread_groups_count));
        }
        aou.a((Context)this, AppState.account.unread_activity_count + AppState.account.unread_feed_count);
        if (bundle.getString("message_id") != null && bundle.getString("post_id") != null && AppState.config.getBoolean("messaging_turned_on", true)) {
            int n2 = Integer.parseInt((String)bundle.getString("message_id"));
            String string3 = (String)DataUtil.toMap(bundle.getString("user_info")).get((Object)"post_name");
            in.ae ae2 = new in.ae(n2, Integer.parseInt((String)bundle.getString("post_id")), bundle.getString("message"), string3, bundle.getString("subject"));
            if (bundle.containsKey("image_width") && bundle.containsKey("image_height") && bundle.containsKey("source_url")) {
                ae2.f = Integer.parseInt((String)bundle.getString("image_width"));
                ae2.g = Integer.parseInt((String)bundle.getString("image_height"));
                ae2.h = bundle.getString("source_url");
            } else if (bundle.containsKey("sticker_name")) {
                ae2.i = bundle.getString("sticker_name");
            }
            ix.a().a(ae2);
            if (bundle.containsKey("unread_message_count")) {
                int n3;
                AppState.account.unread_message_count = n3 = Integer.parseInt((String)bundle.getString("unread_message_count"));
                ix.a().a(new in.as(2, n3, true));
                aou.a((Context)this, n3 + (AppState.account.unread_activity_count + AppState.account.unread_feed_count));
            }
            intent = new Intent("com.becandid.candid.MESSAGING");
            intent.putExtras(bundle);
        }
        this.sendOrderedBroadcast(intent, null);
    }
}

