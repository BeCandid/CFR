/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.facebook.share.internal;

public final class OpenGraphActionDialogFeature
extends Enum<OpenGraphActionDialogFeature>
implements vj {
    public static final /* enum */ OpenGraphActionDialogFeature a = new OpenGraphActionDialogFeature(20130618);
    private static final /* synthetic */ OpenGraphActionDialogFeature[] c;
    private int b;

    static {
        OpenGraphActionDialogFeature[] arropenGraphActionDialogFeature = new OpenGraphActionDialogFeature[]{a};
        c = arropenGraphActionDialogFeature;
    }

    private OpenGraphActionDialogFeature(int n3) {
        super(string2, n2);
        this.b = n3;
    }

    public static OpenGraphActionDialogFeature valueOf(String string2) {
        return (OpenGraphActionDialogFeature)Enum.valueOf((Class)OpenGraphActionDialogFeature.class, (String)string2);
    }

    public static OpenGraphActionDialogFeature[] values() {
        return (OpenGraphActionDialogFeature[])c.clone();
    }

    @Override
    public String a() {
        return "com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG";
    }

    @Override
    public int b() {
        return this.b;
    }
}

