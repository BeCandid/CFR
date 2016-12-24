/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Fragment
 *  android.content.Context
 *  android.support.v4.app.Fragment
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$OnClickListener
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package com.facebook.share.widget;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.FacebookButtonBase;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.share.model.ShareContent;

public final class DeviceShareButton
extends FacebookButtonBase {
    private ShareContent a;
    private int b;
    private boolean c;
    private wp d;

    public DeviceShareButton(Context context) {
        super(context, null, 0);
    }

    public DeviceShareButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    /*
     * Enabled aggressive block sorting
     */
    private DeviceShareButton(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2, 0, "fb_device_share_button_create", "fb_device_share_button_did_tap");
        this.b = 0;
        this.c = false;
        this.d = null;
        int n3 = this.isInEditMode() ? 0 : this.getDefaultRequestCode();
        this.b = n3;
        super.a(false);
    }

    private void a(boolean bl2) {
        this.setEnabled(bl2);
        this.c = false;
    }

    private boolean a() {
        return new wp(this.getActivity()).a(this.getShareContent());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private wp getDialog() {
        if (this.d != null) {
            return this.d;
        }
        if (this.getFragment() != null) {
            this.d = new wp(this.getFragment());
            do {
                return this.d;
                break;
            } while (true);
        }
        if (this.getNativeFragment() != null) {
            this.d = new wp(this.getNativeFragment());
            return this.d;
        }
        this.d = new wp(this.getActivity());
        return this.d;
    }

    private void setRequestCode(int n2) {
        if (ul.b(n2)) {
            throw new IllegalArgumentException("Request code " + n2 + " cannot be within the range reserved by the Facebook SDK.");
        }
        this.b = n2;
    }

    @Override
    protected void a(Context context, AttributeSet attributeSet, int n2, int n3) {
        super.a(context, attributeSet, n2, n3);
        this.setInternalOnClickListener(this.getShareOnClickListener());
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
    public int getRequestCode() {
        return this.b;
    }

    public ShareContent getShareContent() {
        return this.a;
    }

    protected View.OnClickListener getShareOnClickListener() {
        return new View.OnClickListener(){

            public void onClick(View view) {
                DeviceShareButton.this.a(view);
                DeviceShareButton.this.getDialog().b(DeviceShareButton.this.getShareContent());
            }
        };
    }

    public void setEnabled(boolean bl2) {
        super.setEnabled(bl2);
        this.c = true;
    }

    public void setShareContent(ShareContent shareContent) {
        this.a = shareContent;
        if (!this.c) {
            super.a(super.a());
        }
    }

}

