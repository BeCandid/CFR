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

public final class OpenGraphMessageDialogFeature
extends Enum<OpenGraphMessageDialogFeature>
implements vj {
    public static final /* enum */ OpenGraphMessageDialogFeature a = new OpenGraphMessageDialogFeature(20140204);
    private static final /* synthetic */ OpenGraphMessageDialogFeature[] c;
    private int b;

    static {
        OpenGraphMessageDialogFeature[] arropenGraphMessageDialogFeature = new OpenGraphMessageDialogFeature[]{a};
        c = arropenGraphMessageDialogFeature;
    }

    private OpenGraphMessageDialogFeature(int n3) {
        super(string2, n2);
        this.b = n3;
    }

    public static OpenGraphMessageDialogFeature valueOf(String string2) {
        return (OpenGraphMessageDialogFeature)Enum.valueOf((Class)OpenGraphMessageDialogFeature.class, (String)string2);
    }

    public static OpenGraphMessageDialogFeature[] values() {
        return (OpenGraphMessageDialogFeature[])c.clone();
    }

    @Override
    public String a() {
        return "com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG";
    }

    @Override
    public int b() {
        return this.b;
    }
}

