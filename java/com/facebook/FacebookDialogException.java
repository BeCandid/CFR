/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.String
 */
package com.facebook;

import com.facebook.FacebookException;

public class FacebookDialogException
extends FacebookException {
    private int a;
    private String b;

    public FacebookDialogException(String string2, int n2, String string3) {
        super(string2);
        this.a = n2;
        this.b = string3;
    }

    public int a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    @Override
    public final String toString() {
        return "{FacebookDialogException: " + "errorCode: " + this.a() + ", message: " + this.getMessage() + ", url: " + this.b() + "}";
    }
}

