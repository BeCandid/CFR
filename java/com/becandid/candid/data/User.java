/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.PrintStream
 *  java.lang.Class
 *  java.lang.IllegalAccessException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.reflect.Field
 *  java.util.List
 */
package com.becandid.candid.data;

import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.List;

public class User {
    public String age;
    public String badge_status;
    public boolean have_fb;
    public boolean have_phone_number;
    public String icon_color;
    public String icon_name;
    public boolean is_blocked;
    public int message_auto_deletion;
    public int messaging_disabled;
    public int need_age;
    public int need_onboarding;
    public String nickname;
    public int num_fb_friends;
    public int num_groups;
    public int num_phone_friends;
    public int num_posts;
    public int online;
    public String post_name;
    public float quality_score;
    public List<String> tags;
    public int unread_activity_count = -1;
    public int unread_feed_count = -1;
    public int unread_groups_count = -1;
    public int unread_message_count = -1;
    public int user_id;
    public String user_name;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = System.getProperty((String)"line.separator");
        stringBuilder.append(this.getClass().getName());
        stringBuilder.append(" Object {");
        stringBuilder.append(string2);
        Field[] arrfield = this.getClass().getDeclaredFields();
        int n2 = arrfield.length;
        int n3 = 0;
        do {
            if (n3 >= n2) {
                stringBuilder.append("}");
                return stringBuilder.toString();
            }
            Field field = arrfield[n3];
            stringBuilder.append("  ");
            try {
                stringBuilder.append(field.getName());
                stringBuilder.append(": ");
                stringBuilder.append(field.get((Object)this));
            }
            catch (IllegalAccessException var12_6) {
                System.out.println((Object)var12_6);
            }
            stringBuilder.append(string2);
            ++n3;
        } while (true);
    }
}

