/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.facebook.login;

public final class LoginBehavior
extends Enum<LoginBehavior> {
    public static final /* enum */ LoginBehavior a = new LoginBehavior(true, true, false);
    public static final /* enum */ LoginBehavior b = new LoginBehavior(true, false, false);
    public static final /* enum */ LoginBehavior c = new LoginBehavior(false, true, false);
    public static final /* enum */ LoginBehavior d = new LoginBehavior(false, false, true);
    private static final /* synthetic */ LoginBehavior[] h;
    private final boolean e;
    private final boolean f;
    private final boolean g;

    static {
        LoginBehavior[] arrloginBehavior = new LoginBehavior[]{a, b, c, d};
        h = arrloginBehavior;
    }

    private LoginBehavior(boolean bl2, boolean bl3, boolean bl4) {
        super(string2, n2);
        this.e = bl2;
        this.f = bl3;
        this.g = bl4;
    }

    public static LoginBehavior valueOf(String string2) {
        return (LoginBehavior)Enum.valueOf((Class)LoginBehavior.class, (String)string2);
    }

    public static LoginBehavior[] values() {
        return (LoginBehavior[])h.clone();
    }

    boolean a() {
        return this.e;
    }

    boolean b() {
        return this.f;
    }

    boolean c() {
        return this.g;
    }
}

