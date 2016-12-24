/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.PrintStream
 *  java.lang.Class
 *  java.lang.IllegalAccessException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.reflect.Field
 *  java.util.List
 *  java.util.Map
 */
package com.becandid.candid.models;

import com.becandid.candid.data.Comment;
import com.becandid.candid.data.Group;
import com.becandid.candid.data.Message;
import com.becandid.candid.data.MessageThread;
import com.becandid.candid.data.Notification;
import com.becandid.candid.data.Post;
import com.becandid.candid.data.UpdatePost;
import com.becandid.candid.data.User;
import com.becandid.candid.models.ServerMessage;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public class NetworkData {
    public List<Notification> activity;
    public List<NotificationSetting> activity_settings;
    public Comment comment;
    public Map<String, Object> config;
    public boolean debug;
    public String error;
    public List<String> feed_colors;
    public List<String> feed_tab_order;
    public Group group;
    public List<String> group_tags;
    public List<Group> groups;
    public boolean is_new_user;
    public int last_activity_id;
    public Message message;
    public User my_info;
    public int new_requests;
    public int new_threads;
    public int next_page;
    public Post post;
    public List<Post> posts;
    public User profile;
    public int referral_post_id;
    public List<Post> related_posts;
    public int request_next_page;
    public List<MessageThread> requests;
    public List<MessageThread> results;
    public int same_link_found;
    public ServerMessage server_message;
    public int show_nickname_prompt;
    public boolean success;
    public MessageThread thread;
    public int thread_next_page;
    public List<MessageThread> threads;
    public int unread_count = -1;
    public int unread_groups_count = -1;
    public UpdatePost update_post;

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

    public class NotificationSetting {
        public Integer disabled;
        public String display_name;
        public String type;

        public NotificationSetting copy() {
            NotificationSetting notificationSetting = new NotificationSetting();
            notificationSetting.display_name = this.display_name;
            notificationSetting.type = this.type;
            notificationSetting.disabled = this.disabled;
            return notificationSetting;
        }
    }

    public static class UploadResponse {
        public String full_url;
        public Map<String, String> s3_data;
        public boolean success;
    }

}

