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
 */
package com.becandid.candid.data;

import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Comment;
import com.becandid.candid.data.ShareInfo;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.List;

public class Post {
    public String about;
    public int actual_height = -1;
    public int actual_width = -1;
    public int can_mute;
    public String caption;
    public String comment_icon_name;
    public int comment_image_height = -1;
    public int comment_image_width = -1;
    public int comment_is_candid_mod;
    public String comment_source_url;
    public String comment_sticker_name;
    public String comment_text;
    public String comment_time_ago;
    public List<Comment> comments;
    public int first_related_post;
    public Integer friend_created = 0;
    public int friends_disabled;
    public int group_id;
    public String group_name;
    public int height;
    public String icon_color;
    public String icon_name;
    public String image_hash;
    public int is_candid_mod;
    public int is_friend;
    public int last_related_post;
    public String layout_xml;
    public int like_value;
    public String link_domain;
    public String link_url;
    public String localBitmapPath;
    public String mentioned_groups_info;
    public String messaging_blocked;
    public String messaging_disabled;
    public Integer moderator;
    public int muted_post;
    public int num_comments;
    public int num_dislikes;
    public int num_false;
    public Integer num_friends = 0;
    public int num_likes;
    public Integer num_members = 0;
    public Integer num_posts = 0;
    public int num_true;
    public String og_desc;
    public String og_title;
    public int opinion_value;
    public Integer owner_user_id;
    public int post_id;
    public String post_time_ago;
    public float quality_score;
    public int related_to_post;
    public int rumor;
    public ShareInfo share_info;
    public String source_url;
    public Integer t_joined;
    public Integer t_last_post;
    public List<String> tags;
    public int thats_me;
    public String thumb_url;
    public int trending;
    public String type;
    public String user_name;
    public int wait_for_play;
    public int width;

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        if (!(object instanceof Post)) {
            return false;
        }
        Post post = (Post)object;
        if (this.post_id != post.post_id) return false;
        return true;
    }

    public String imageUrl() {
        if (this.thumb_url != null && this.thumb_url.length() > 0) {
            return this.thumb_url;
        }
        return this.source_url;
    }

    public boolean isMember() {
        return AppState.isGroupMember(this.group_id);
    }

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

