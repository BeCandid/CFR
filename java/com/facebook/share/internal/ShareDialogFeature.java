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

public final class ShareDialogFeature
extends Enum<ShareDialogFeature>
implements vj {
    public static final /* enum */ ShareDialogFeature a = new ShareDialogFeature(20130618);
    public static final /* enum */ ShareDialogFeature b = new ShareDialogFeature(20140204);
    public static final /* enum */ ShareDialogFeature c = new ShareDialogFeature(20141028);
    public static final /* enum */ ShareDialogFeature d = new ShareDialogFeature(20160327);
    public static final /* enum */ ShareDialogFeature e = new ShareDialogFeature(20160327);
    public static final /* enum */ ShareDialogFeature f = new ShareDialogFeature(20160327);
    private static final /* synthetic */ ShareDialogFeature[] h;
    private int g;

    static {
        ShareDialogFeature[] arrshareDialogFeature = new ShareDialogFeature[]{a, b, c, d, e, f};
        h = arrshareDialogFeature;
    }

    private ShareDialogFeature(int n3) {
        super(string2, n2);
        this.g = n3;
    }

    public static ShareDialogFeature valueOf(String string2) {
        return (ShareDialogFeature)Enum.valueOf((Class)ShareDialogFeature.class, (String)string2);
    }

    public static ShareDialogFeature[] values() {
        return (ShareDialogFeature[])h.clone();
    }

    @Override
    public String a() {
        return "com.facebook.platform.action.request.FEED_DIALOG";
    }

    @Override
    public int b() {
        return this.g;
    }
}

