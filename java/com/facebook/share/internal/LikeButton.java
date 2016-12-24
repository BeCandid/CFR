/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.util.AttributeSet
 *  java.lang.CharSequence
 *  java.lang.String
 */
package com.facebook.share.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import com.facebook.FacebookButtonBase;

public class LikeButton
extends FacebookButtonBase {
    public LikeButton(Context context, boolean bl2) {
        super(context, null, 0, 0, "fb_like_button_create", "fb_like_button_did_tap");
        this.setSelected(bl2);
    }

    private void a() {
        if (this.isSelected()) {
            this.setCompoundDrawablesWithIntrinsicBounds(uu.c.com_facebook_button_like_icon_selected, 0, 0, 0);
            this.setText((CharSequence)this.getResources().getString(uu.f.com_facebook_like_button_liked));
            return;
        }
        this.setCompoundDrawablesWithIntrinsicBounds(uu.c.com_facebook_button_icon, 0, 0, 0);
        this.setText((CharSequence)this.getResources().getString(uu.f.com_facebook_like_button_not_liked));
    }

    @Override
    protected void a(Context context, AttributeSet attributeSet, int n2, int n3) {
        super.a(context, attributeSet, n2, n3);
        super.a();
    }

    @Override
    protected int getDefaultRequestCode() {
        return 0;
    }

    @Override
    protected int getDefaultStyleResource() {
        return uu.g.com_facebook_button_like;
    }

    public void setSelected(boolean bl2) {
        super.setSelected(bl2);
        super.a();
    }
}

