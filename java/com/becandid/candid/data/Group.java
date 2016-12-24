/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.becandid.candid.data;

import com.becandid.candid.data.Post;
import java.io.Serializable;
import java.util.List;

public class Group
implements Serializable {
    public String about;
    public int friend_created = 0;
    public int group_id;
    public String group_name;
    public int moderator;
    public int num_friends = 0;
    public int num_members = 0;
    public int num_posts = 0;
    public int owner_user_id;
    public String source_url;
    public int t_joined;
    public int t_last_post;
    public List<String> tags;
    public String thumb_url;

    public Post convertToPost() {
        Post post = new Post();
        post.group_id = this.group_id;
        post.group_name = this.group_name;
        post.source_url = this.source_url;
        post.thumb_url = this.thumb_url;
        post.num_posts = this.num_posts;
        post.num_members = this.num_members;
        post.num_friends = this.num_friends;
        post.owner_user_id = this.owner_user_id;
        post.moderator = this.moderator;
        post.about = this.about;
        post.friend_created = this.friend_created;
        post.t_joined = this.t_joined;
        post.t_last_post = this.t_last_post;
        post.tags = this.tags;
        return post;
    }

    public String imageUrl() {
        if (this.thumb_url != null && this.thumb_url.length() > 0) {
            return this.thumb_url;
        }
        return this.source_url;
    }

    public boolean isFriendCreated() {
        if (this.friend_created != 0) {
            return true;
        }
        return false;
    }
}

