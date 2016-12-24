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

import com.becandid.candid.data.User;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.List;

public class Comment {
    public int clipped = 1;
    public int comment_id;
    public String comment_text;
    public String comment_time_ago;
    public String icon_color;
    public String icon_name;
    public int image_height;
    public int image_width;
    public int is_candid_mod;
    public int is_friend;
    public boolean is_master_comment;
    public int is_op;
    public int like_value;
    public String mentioned_groups_info;
    public String messaging_blocked;
    public String messaging_disabled;
    public int num_dislikes;
    public int num_likes;
    public int post_id;
    public List<Comment> reply_comments;
    public int small_image_height;
    public int small_image_width;
    public String source_url;
    public String sticker_name;
    public int thats_me;
    public User user;
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

