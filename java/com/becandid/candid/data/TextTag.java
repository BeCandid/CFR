/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 */
package com.becandid.candid.data;

public class TextTag {
    public int endIndex;
    public int groupId;
    public int startIndex;

    public TextTag(int n2, int n3, int n4) {
        this.startIndex = n2;
        this.endIndex = n3;
        this.groupId = n4;
    }

    public String toString() {
        return Integer.toString((int)this.groupId) + "," + Integer.toString((int)this.startIndex) + "," + Integer.toString((int)this.endIndex);
    }
}

