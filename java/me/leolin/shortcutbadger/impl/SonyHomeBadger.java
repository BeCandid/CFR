/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.AsyncQueryHandler
 *  android.content.ComponentName
 *  android.content.ContentResolver
 *  android.content.ContentValues
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.content.pm.ProviderInfo
 *  android.net.Uri
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Arrays
 *  java.util.List
 */
package me.leolin.shortcutbadger.impl;

import android.content.AsyncQueryHandler;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import java.util.Arrays;
import java.util.List;
import me.leolin.shortcutbadger.ShortcutBadgeException;

public class SonyHomeBadger
implements aot {
    private final Uri a = Uri.parse((String)"content://com.sonymobile.home.resourceprovider/badge");
    private AsyncQueryHandler b;

    private void a(int n2, String string2, String string3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("badge_count", Integer.valueOf((int)n2));
        contentValues.put("package_name", string2);
        contentValues.put("activity_name", string3);
        this.b.startInsert(0, (Object)null, this.a, contentValues);
    }

    private static boolean a(Context context) {
        ProviderInfo providerInfo = context.getPackageManager().resolveContentProvider("com.sonymobile.home.resourceprovider", 0);
        boolean bl2 = false;
        if (providerInfo != null) {
            bl2 = true;
        }
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static void b(Context context, ComponentName componentName, int n2) {
        Intent intent = new Intent("com.sonyericsson.home.action.UPDATE_BADGE");
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME", componentName.getPackageName());
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME", componentName.getClassName());
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.MESSAGE", String.valueOf((int)n2));
        boolean bl2 = n2 > 0;
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", bl2);
        context.sendBroadcast(intent);
    }

    private void c(Context context, ComponentName componentName, int n2) {
        if (n2 < 0) {
            return;
        }
        if (this.b == null) {
            this.b = new AsyncQueryHandler(context.getApplicationContext().getContentResolver()){};
        }
        super.a(n2, componentName.getPackageName(), componentName.getClassName());
    }

    @Override
    public List<String> a() {
        return Arrays.asList((Object[])new String[]{"com.sonyericsson.home"});
    }

    @Override
    public void a(Context context, ComponentName componentName, int n2) throws ShortcutBadgeException {
        if (SonyHomeBadger.a(context)) {
            super.c(context, componentName, n2);
            return;
        }
        SonyHomeBadger.b(context, componentName, n2);
    }

}

