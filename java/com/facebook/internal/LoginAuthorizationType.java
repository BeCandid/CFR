/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.facebook.internal;

public final class LoginAuthorizationType
extends Enum<LoginAuthorizationType> {
    public static final /* enum */ LoginAuthorizationType a = new LoginAuthorizationType();
    public static final /* enum */ LoginAuthorizationType b = new LoginAuthorizationType();
    private static final /* synthetic */ LoginAuthorizationType[] c;

    static {
        LoginAuthorizationType[] arrloginAuthorizationType = new LoginAuthorizationType[]{a, b};
        c = arrloginAuthorizationType;
    }

    private LoginAuthorizationType() {
        super(string2, n2);
    }

    public static LoginAuthorizationType valueOf(String string2) {
        return (LoginAuthorizationType)Enum.valueOf((Class)LoginAuthorizationType.class, (String)string2);
    }

    public static LoginAuthorizationType[] values() {
        return (LoginAuthorizationType[])c.clone();
    }
}

