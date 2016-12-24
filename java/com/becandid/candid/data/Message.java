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
 *  java.util.Map
 */
package com.becandid.candid.data;

import com.becandid.candid.data.Post;
import com.becandid.candid.data.User;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.Map;

public class Message {
    public boolean failedSend = false;
    public int image_height;
    public int image_width;
    public String message;
    public boolean messageHeader;
    public boolean messagePost;
    public long messageTempId;
    public int message_id;
    public Map<String, String> params;
    public Post post;
    public int post_id;
    public String sender = "self";
    public long sent_time;
    public String source_url;
    public String sticker_name;
    public String subject;
    public int uploaded;
    public User user_info;

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

