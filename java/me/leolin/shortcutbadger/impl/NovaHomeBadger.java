/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.ContentResolver
 *  android.content.ContentValues
 *  android.content.Context
 *  android.net.Uri
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Arrays
 *  java.util.List
 */
package me.leolin.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import java.util.Arrays;
import java.util.List;
import me.leolin.shortcutbadger.ShortcutBadgeException;

public class NovaHomeBadger
implements aot {
    @Override
    public List<String> a() {
        return Arrays.asList((Object[])new String[]{"com.teslacoilsw.launcher"});
    }

    @Override
    public void a(Context context, ComponentName componentName, int n2) throws ShortcutBadgeException {
        ContentValues contentValues = new ContentValues();
        contentValues.put("tag", componentName.getPackageName() + "/" + componentName.getClassName());
        contentValues.put("count", Integer.valueOf((int)n2));
        context.getContentResolver().insert(Uri.parse((String)"content://com.teslacoilsw.notifier/unread_count"), contentValues);
    }
}

