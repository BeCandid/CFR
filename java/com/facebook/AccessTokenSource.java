/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.facebook;

public final class AccessTokenSource
extends Enum<AccessTokenSource> {
    public static final /* enum */ AccessTokenSource a = new AccessTokenSource(false);
    public static final /* enum */ AccessTokenSource b = new AccessTokenSource(true);
    public static final /* enum */ AccessTokenSource c = new AccessTokenSource(true);
    public static final /* enum */ AccessTokenSource d = new AccessTokenSource(true);
    public static final /* enum */ AccessTokenSource e = new AccessTokenSource(true);
    public static final /* enum */ AccessTokenSource f = new AccessTokenSource(true);
    public static final /* enum */ AccessTokenSource g = new AccessTokenSource(true);
    public static final /* enum */ AccessTokenSource h = new AccessTokenSource(true);
    public static final /* enum */ AccessTokenSource i = new AccessTokenSource(true);
    private static final /* synthetic */ AccessTokenSource[] k;
    private final boolean j;

    static {
        AccessTokenSource[] arraccessTokenSource = new AccessTokenSource[]{a, b, c, d, e, f, g, h, i};
        k = arraccessTokenSource;
    }

    private AccessTokenSource(boolean bl2) {
        super(string2, n2);
        this.j = bl2;
    }

    public static AccessTokenSource valueOf(String string2) {
        return (AccessTokenSource)Enum.valueOf((Class)AccessTokenSource.class, (String)string2);
    }

    public static AccessTokenSource[] values() {
        return (AccessTokenSource[])k.clone();
    }

    public boolean a() {
        return this.j;
    }
}

