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

public final class FlushResult
extends Enum<FlushResult> {
    public static final /* enum */ FlushResult a = new FlushResult();
    public static final /* enum */ FlushResult b = new FlushResult();
    public static final /* enum */ FlushResult c = new FlushResult();
    public static final /* enum */ FlushResult d = new FlushResult();
    private static final /* synthetic */ FlushResult[] e;

    static {
        FlushResult[] arrflushResult = new FlushResult[]{a, b, c, d};
        e = arrflushResult;
    }

    private FlushResult() {
        super(string2, n2);
    }

    public static FlushResult valueOf(String string2) {
        return (FlushResult)Enum.valueOf((Class)FlushResult.class, (String)string2);
    }

    public static FlushResult[] values() {
        return (FlushResult[])e.clone();
    }
}

