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

public final class HttpMethod
extends Enum<HttpMethod> {
    public static final /* enum */ HttpMethod a = new HttpMethod();
    public static final /* enum */ HttpMethod b = new HttpMethod();
    public static final /* enum */ HttpMethod c = new HttpMethod();
    private static final /* synthetic */ HttpMethod[] d;

    static {
        HttpMethod[] arrhttpMethod = new HttpMethod[]{a, b, c};
        d = arrhttpMethod;
    }

    private HttpMethod() {
        super(string2, n2);
    }

    public static HttpMethod valueOf(String string2) {
        return (HttpMethod)Enum.valueOf((Class)HttpMethod.class, (String)string2);
    }

    public static HttpMethod[] values() {
        return (HttpMethod[])d.clone();
    }
}

