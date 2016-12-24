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

public final class MessageDialogFeature
extends Enum<MessageDialogFeature>
implements vj {
    public static final /* enum */ MessageDialogFeature a = new MessageDialogFeature(20140204);
    public static final /* enum */ MessageDialogFeature b = new MessageDialogFeature(20140324);
    public static final /* enum */ MessageDialogFeature c = new MessageDialogFeature(20141218);
    private static final /* synthetic */ MessageDialogFeature[] e;
    private int d;

    static {
        MessageDialogFeature[] arrmessageDialogFeature = new MessageDialogFeature[]{a, b, c};
        e = arrmessageDialogFeature;
    }

    private MessageDialogFeature(int n3) {
        super(string2, n2);
        this.d = n3;
    }

    public static MessageDialogFeature valueOf(String string2) {
        return (MessageDialogFeature)Enum.valueOf((Class)MessageDialogFeature.class, (String)string2);
    }

    public static MessageDialogFeature[] values() {
        return (MessageDialogFeature[])e.clone();
    }

    @Override
    public String a() {
        return "com.facebook.platform.action.request.MESSAGE_DIALOG";
    }

    @Override
    public int b() {
        return this.d;
    }
}

