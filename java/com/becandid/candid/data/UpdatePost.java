/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 */
package com.becandid.candid.data;

public class UpdatePost {
    public int post_id;
    public Updates updates;

    public UpdatePost() {
        this.updates = new Updates();
    }

    public class Updates {
        public Integer like_value;
        public Integer num_comments;
        public Integer num_dislikes;
        public Integer num_likes;
    }

}

