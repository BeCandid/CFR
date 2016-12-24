/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Color
 *  android.os.AsyncTask
 *  android.view.View
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Void
 */
package com.becandid.thirdparty;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.AsyncTask;
import android.view.View;

public class BlurTask
extends AsyncTask<Void, Void, Void> {
    private Activity a;
    private int b;
    private Bitmap c;
    private String d;
    private String e;
    private BadgeType f;
    private View g;
    private String h;
    private String i;
    private String j;

    public BlurTask(Activity activity, int n2) {
        this.a = activity;
        this.b = n2;
    }

    public BlurTask(Activity activity, int n2, String string2) {
        this.a = activity;
        this.b = n2;
        this.e = string2;
    }

    public BlurTask(Activity activity, View view, BadgeType badgeType) {
        this.a = activity;
        this.g = view;
        this.f = badgeType;
    }

    public BlurTask(Activity activity, View view, BadgeType badgeType, String string2, String string3) {
        this.a = activity;
        this.g = view;
        this.f = badgeType;
        this.i = string2;
        this.j = string3;
    }

    public BlurTask(Activity activity, View view, String string2, BadgeType badgeType, String string3, String string4) {
        this.a = activity;
        this.g = view;
        this.f = badgeType;
        this.h = string2;
        this.i = string3;
        this.j = string4;
    }

    private View a() {
        return this.a.findViewById(this.b);
    }

    private String b() {
        Bitmap bitmap = jl.a((Context)this.a, this.c, 24);
        String string2 = jm.a(this.a, bitmap);
        this.c.recycle();
        bitmap.recycle();
        return string2;
    }

    protected /* varargs */ Void a(Void ... arrvoid) {
        this.d = super.b();
        return null;
    }

    protected void a(Void void_) {
        if (this.e != null) {
            ix.a().a(new in.c(this.d, this.e));
            return;
        }
        if (this.f != null) {
            ix.a().a(new in.b(this.d, this.f, this.h, this.i, this.j));
            return;
        }
        ix.a().a(new in.d(this.d));
    }

    protected /* synthetic */ Object doInBackground(Object[] arrobject) {
        return this.a((Void[])arrobject);
    }

    protected /* synthetic */ void onPostExecute(Object object) {
        this.a((Void)object);
    }

    protected void onPreExecute() {
        if (this.g == null) {
            this.g = this.a();
        }
        this.c = jm.a(this.g, Color.parseColor((String)"#FF000000"));
    }

    public static final class BadgeType
    extends Enum<BadgeType> {
        public static final /* enum */ BadgeType a = new BadgeType();
        public static final /* enum */ BadgeType b = new BadgeType();
        public static final /* enum */ BadgeType c = new BadgeType();
        public static final /* enum */ BadgeType d = new BadgeType();
        public static final /* enum */ BadgeType e = new BadgeType();
        public static final /* enum */ BadgeType f = new BadgeType();
        public static final /* enum */ BadgeType g = new BadgeType();
        public static final /* enum */ BadgeType h = new BadgeType();
        private static final /* synthetic */ BadgeType[] i;

        static {
            BadgeType[] arrbadgeType = new BadgeType[]{a, b, c, d, e, f, g, h};
            i = arrbadgeType;
        }

        private BadgeType() {
            super(string2, n2);
        }

        public static BadgeType valueOf(String string2) {
            return (BadgeType)Enum.valueOf((Class)BadgeType.class, (String)string2);
        }

        public static BadgeType[] values() {
            return (BadgeType[])i.clone();
        }
    }

}

