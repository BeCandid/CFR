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

public final class LoggingBehavior
extends Enum<LoggingBehavior> {
    public static final /* enum */ LoggingBehavior a = new LoggingBehavior();
    public static final /* enum */ LoggingBehavior b = new LoggingBehavior();
    public static final /* enum */ LoggingBehavior c = new LoggingBehavior();
    public static final /* enum */ LoggingBehavior d = new LoggingBehavior();
    public static final /* enum */ LoggingBehavior e = new LoggingBehavior();
    public static final /* enum */ LoggingBehavior f = new LoggingBehavior();
    public static final /* enum */ LoggingBehavior g = new LoggingBehavior();
    public static final /* enum */ LoggingBehavior h = new LoggingBehavior();
    private static final /* synthetic */ LoggingBehavior[] i;

    static {
        LoggingBehavior[] arrloggingBehavior = new LoggingBehavior[]{a, b, c, d, e, f, g, h};
        i = arrloggingBehavior;
    }

    private LoggingBehavior() {
        super(string2, n2);
    }

    public static LoggingBehavior valueOf(String string2) {
        return (LoggingBehavior)Enum.valueOf((Class)LoggingBehavior.class, (String)string2);
    }

    public static LoggingBehavior[] values() {
        return (LoggingBehavior[])i.clone();
    }
}

