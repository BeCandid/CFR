/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Field
 *  java.util.Arrays
 *  java.util.List
 */
package me.leolin.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import me.leolin.shortcutbadger.ShortcutBadgeException;

public class XiaomiHomeBadger
implements aot {
    @Override
    public List<String> a() {
        return Arrays.asList((Object[])new String[]{"com.miui.miuilite", "com.miui.home", "com.miui.miuihome", "com.miui.miuihome2", "com.miui.mihome", "com.miui.mihome2"});
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(Context context, ComponentName componentName, int n2) throws ShortcutBadgeException {
        try {
            Object object;
            Object object2 = Class.forName((String)"android.app.MiuiNotification").newInstance();
            Field field = object2.getClass().getDeclaredField("messageCount");
            field.setAccessible(true);
            String string2 = n2 == 0 ? "" : (object = Integer.valueOf((int)n2));
            field.set(object2, (Object)String.valueOf((Object)string2));
            return;
        }
        catch (Exception var4_8) {
            Intent intent = new Intent("android.intent.action.APPLICATION_MESSAGE_UPDATE");
            intent.putExtra("android.intent.extra.update_application_component_name", componentName.getPackageName() + "/" + componentName.getClassName());
            String string3 = n2 == 0 ? "" : Integer.valueOf((int)n2);
            intent.putExtra("android.intent.extra.update_application_message_text", String.valueOf((Object)string3));
            if (aov.a(context, intent)) {
                context.sendBroadcast(intent);
                return;
            }
            throw new ShortcutBadgeException("unable to resolve intent: " + intent.toString());
        }
    }
}

