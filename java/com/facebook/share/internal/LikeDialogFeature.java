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

public final class LikeDialogFeature
extends Enum<LikeDialogFeature>
implements vj {
    public static final /* enum */ LikeDialogFeature a = new LikeDialogFeature(20140701);
    private static final /* synthetic */ LikeDialogFeature[] c;
    private int b;

    static {
        LikeDialogFeature[] arrlikeDialogFeature = new LikeDialogFeature[]{a};
        c = arrlikeDialogFeature;
    }

    private LikeDialogFeature(int n3) {
        super(string2, n2);
        this.b = n3;
    }

    public static LikeDialogFeature valueOf(String string2) {
        return (LikeDialogFeature)Enum.valueOf((Class)LikeDialogFeature.class, (String)string2);
    }

    public static LikeDialogFeature[] values() {
        return (LikeDialogFeature[])c.clone();
    }

    @Override
    public String a() {
        return "com.facebook.platform.action.request.LIKE_DIALOG";
    }

    @Override
    public int b() {
        return this.b;
    }
}

