/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.app.Activity
 *  android.app.Fragment
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.Typeface
 *  android.os.Bundle
 *  android.support.v4.app.Fragment
 *  android.text.TextPaint
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  java.lang.CharSequence
 *  java.lang.Double
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 */
package com.facebook;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import com.facebook.FacebookException;
import com.facebook.appevents.AppEventsLogger;

public abstract class FacebookButtonBase
extends Button {
    private String a;
    private String b;
    private View.OnClickListener c;
    private View.OnClickListener d;
    private boolean e;
    private int f;
    private int g;
    private vq h;

    public FacebookButtonBase(Context context, AttributeSet attributeSet, int n2, int n3, String string2, String string3) {
        super(context, attributeSet, 0);
        if (n3 == 0) {
            n3 = this.getDefaultStyleResource();
        }
        if (n3 == 0) {
            n3 = uu.g.com_facebook_button;
        }
        this.a(context, attributeSet, n2, n3);
        this.a = string2;
        this.b = string3;
        this.setClickable(true);
        this.setFocusable(true);
    }

    private void a() {
        super.setOnClickListener(new View.OnClickListener(){

            /*
             * Enabled aggressive block sorting
             */
            public void onClick(View view) {
                FacebookButtonBase.this.b(FacebookButtonBase.this.getContext());
                if (FacebookButtonBase.this.d != null) {
                    FacebookButtonBase.this.d.onClick(view);
                    return;
                } else {
                    if (FacebookButtonBase.this.c == null) return;
                    {
                        FacebookButtonBase.this.c.onClick(view);
                        return;
                    }
                }
            }
        });
    }

    private void a(Context context) {
        AppEventsLogger.a(context).a(this.a, null, null);
    }

    private void b(Context context) {
        AppEventsLogger.a(context).a(this.b, null, null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void b(Context context, AttributeSet attributeSet, int n2, int n3) {
        if (this.isInEditMode()) {
            return;
        }
        int[] arrn = new int[]{16842964};
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attributeSet, arrn, n2, n3);
        try {
            if (typedArray.hasValue(0)) {
                int n4 = typedArray.getResourceId(0, 0);
                if (n4 != 0) {
                    this.setBackgroundResource(n4);
                    return;
                }
                this.setBackgroundColor(typedArray.getColor(0, 0));
                return;
            }
            this.setBackgroundColor(bb.getColor(context, uu.a.com_facebook_blue));
            return;
        }
        finally {
            typedArray.recycle();
        }
    }

    @SuppressLint(value={"ResourceType"})
    private void c(Context context, AttributeSet attributeSet, int n2, int n3) {
        int[] arrn = new int[]{16843119, 16843117, 16843120, 16843118, 16843121};
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attributeSet, arrn, n2, n3);
        try {
            this.setCompoundDrawablesWithIntrinsicBounds(typedArray.getResourceId(0, 0), typedArray.getResourceId(1, 0), typedArray.getResourceId(2, 0), typedArray.getResourceId(3, 0));
            this.setCompoundDrawablePadding(typedArray.getDimensionPixelSize(4, 0));
            return;
        }
        finally {
            typedArray.recycle();
        }
    }

    private void d(Context context, AttributeSet attributeSet, int n2, int n3) {
        int[] arrn = new int[]{16842966, 16842967, 16842968, 16842969};
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attributeSet, arrn, n2, n3);
        try {
            this.setPadding(typedArray.getDimensionPixelSize(0, 0), typedArray.getDimensionPixelSize(1, 0), typedArray.getDimensionPixelSize(2, 0), typedArray.getDimensionPixelSize(3, 0));
            return;
        }
        finally {
            typedArray.recycle();
        }
    }

    private void e(Context context, AttributeSet attributeSet, int n2, int n3) {
        int[] arrn = new int[]{16842904};
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attributeSet, arrn, n2, n3);
        this.setTextColor(typedArray.getColorStateList(0));
        int[] arrn2 = new int[]{16842927};
        TypedArray typedArray2 = context.getTheme().obtainStyledAttributes(attributeSet, arrn2, n2, n3);
        this.setGravity(typedArray2.getInt(0, 17));
        int[] arrn3 = new int[]{16842901, 16842903, 16843087};
        TypedArray typedArray3 = context.getTheme().obtainStyledAttributes(attributeSet, arrn3, n2, n3);
        try {
            this.setTextSize(0, (float)typedArray3.getDimensionPixelSize(0, 0));
            this.setTypeface(Typeface.defaultFromStyle((int)typedArray3.getInt(1, 1)));
            this.setText((CharSequence)typedArray3.getString(2));
            return;
        }
        finally {
            typedArray3.recycle();
        }
    }

    public int a(String string2) {
        return (int)Math.ceil((double)this.getPaint().measureText(string2));
    }

    public void a(Context context, AttributeSet attributeSet, int n2, int n3) {
        super.b(context, attributeSet, n2, n3);
        super.c(context, attributeSet, n2, n3);
        super.d(context, attributeSet, n2, n3);
        super.e(context, attributeSet, n2, n3);
        super.a();
    }

    public void a(View view) {
        if (this.c != null) {
            this.c.onClick(view);
        }
    }

    public Activity getActivity() {
        Context context = this.getContext();
        while (!(context instanceof Activity) && context instanceof ContextWrapper) {
            context = ((ContextWrapper)context).getBaseContext();
        }
        if (context instanceof Activity) {
            return (Activity)context;
        }
        throw new FacebookException("Unable to get Activity.");
    }

    public int getCompoundPaddingLeft() {
        if (this.e) {
            return this.f;
        }
        return super.getCompoundPaddingLeft();
    }

    public int getCompoundPaddingRight() {
        if (this.e) {
            return this.g;
        }
        return super.getCompoundPaddingRight();
    }

    public abstract int getDefaultRequestCode();

    public int getDefaultStyleResource() {
        return 0;
    }

    public Fragment getFragment() {
        if (this.h != null) {
            return this.h.b();
        }
        return null;
    }

    public android.app.Fragment getNativeFragment() {
        if (this.h != null) {
            return this.h.a();
        }
        return null;
    }

    public int getRequestCode() {
        return this.getDefaultRequestCode();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.isInEditMode()) {
            this.a(this.getContext());
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void onDraw(Canvas canvas) {
        boolean bl2 = (1 & this.getGravity()) != 0;
        if (bl2) {
            int n2 = this.getCompoundPaddingLeft();
            int n3 = this.getCompoundPaddingRight();
            int n4 = n2 + this.getCompoundDrawablePadding();
            int n5 = Math.min((int)((this.getWidth() - n4 - n3 - this.a(this.getText().toString())) / 2), (int)((n2 - this.getPaddingLeft()) / 2));
            this.f = n2 - n5;
            this.g = n3 + n5;
            this.e = true;
        }
        super.onDraw(canvas);
        this.e = false;
    }

    public void setFragment(android.app.Fragment fragment) {
        this.h = new vq(fragment);
    }

    public void setFragment(Fragment fragment) {
        this.h = new vq(fragment);
    }

    public void setInternalOnClickListener(View.OnClickListener onClickListener) {
        this.d = onClickListener;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.c = onClickListener;
    }

}

