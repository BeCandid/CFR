/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Fragment
 *  android.content.Context
 *  android.support.v4.app.Fragment
 *  android.util.AttributeSet
 *  java.lang.String
 */
package com.facebook.share.widget;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.util.AttributeSet;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.share.model.ShareContent;
import com.facebook.share.widget.ShareButtonBase;
import com.facebook.share.widget.ShareDialog;

public final class ShareButton
extends ShareButtonBase {
    public ShareButton(Context context) {
        super(context, null, 0, "fb_share_button_create", "fb_share_button_did_tap");
    }

    public ShareButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, "fb_share_button_create", "fb_share_button_did_tap");
    }

    public ShareButton(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2, "fb_share_button_create", "fb_share_button_did_tap");
    }

    @Override
    protected int getDefaultRequestCode() {
        return CallbackManagerImpl.RequestCodeOffset.b.a();
    }

    @Override
    protected int getDefaultStyleResource() {
        return uu.g.com_facebook_button_share;
    }

    @Override
    protected vl<ShareContent, wq.a> getDialog() {
        if (this.getFragment() != null) {
            return new ShareDialog(this.getFragment(), this.getRequestCode());
        }
        if (this.getNativeFragment() != null) {
            return new ShareDialog(this.getNativeFragment(), this.getRequestCode());
        }
        return new ShareDialog(this.getActivity(), this.getRequestCode());
    }
}

