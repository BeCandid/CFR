/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package com.venmo.view;

public final class ArrowAlignment
extends Enum<ArrowAlignment> {
    public static final /* enum */ ArrowAlignment a = new ArrowAlignment(0);
    public static final /* enum */ ArrowAlignment b = new ArrowAlignment(1);
    public static final /* enum */ ArrowAlignment c = new ArrowAlignment(2);
    public static final /* enum */ ArrowAlignment d = new ArrowAlignment(3);
    private static final /* synthetic */ ArrowAlignment[] f;
    private final int e;

    static {
        ArrowAlignment[] arrarrowAlignment = new ArrowAlignment[]{a, b, c, d};
        f = arrarrowAlignment;
    }

    private ArrowAlignment(int n3) {
        super(string2, n2);
        this.e = n3;
    }

    public static ArrowAlignment a(int n2) {
        for (ArrowAlignment arrowAlignment : ArrowAlignment.values()) {
            if (n2 != arrowAlignment.a()) continue;
            return arrowAlignment;
        }
        throw new IllegalArgumentException("No matching ArrowAlignment with value: " + n2);
    }

    public static ArrowAlignment valueOf(String string2) {
        return (ArrowAlignment)Enum.valueOf((Class)ArrowAlignment.class, (String)string2);
    }

    public static ArrowAlignment[] values() {
        return (ArrowAlignment[])f.clone();
    }

    public int a() {
        return this.e;
    }
}

