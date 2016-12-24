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

public final class DefaultAudience
extends Enum<DefaultAudience> {
    public static final /* enum */ DefaultAudience a = new DefaultAudience(null);
    public static final /* enum */ DefaultAudience b = new DefaultAudience("only_me");
    public static final /* enum */ DefaultAudience c = new DefaultAudience("friends");
    public static final /* enum */ DefaultAudience d = new DefaultAudience("everyone");
    private static final /* synthetic */ DefaultAudience[] f;
    private final String e;

    static {
        DefaultAudience[] arrdefaultAudience = new DefaultAudience[]{a, b, c, d};
        f = arrdefaultAudience;
    }

    private DefaultAudience(String string3) {
        super(string2, n2);
        this.e = string3;
    }

    public static DefaultAudience valueOf(String string2) {
        return (DefaultAudience)Enum.valueOf((Class)DefaultAudience.class, (String)string2);
    }

    public static DefaultAudience[] values() {
        return (DefaultAudience[])f.clone();
    }

    public String a() {
        return this.e;
    }
}

