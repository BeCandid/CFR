/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.facebook.appevents;

public final class FlushReason
extends Enum<FlushReason> {
    public static final /* enum */ FlushReason a = new FlushReason();
    public static final /* enum */ FlushReason b = new FlushReason();
    public static final /* enum */ FlushReason c = new FlushReason();
    public static final /* enum */ FlushReason d = new FlushReason();
    public static final /* enum */ FlushReason e = new FlushReason();
    public static final /* enum */ FlushReason f = new FlushReason();
    private static final /* synthetic */ FlushReason[] g;

    static {
        FlushReason[] arrflushReason = new FlushReason[]{a, b, c, d, e, f};
        g = arrflushReason;
    }

    private FlushReason() {
        super(string2, n2);
    }

    public static FlushReason valueOf(String string2) {
        return (FlushReason)Enum.valueOf((Class)FlushReason.class, (String)string2);
    }

    public static FlushReason[] values() {
        return (FlushReason[])g.clone();
    }
}

