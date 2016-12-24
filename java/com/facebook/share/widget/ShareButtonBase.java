/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$OnClickListener
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.FacebookButtonBase;
import com.facebook.share.model.ShareContent;

public abstract class ShareButtonBase
extends FacebookButtonBase {
    private ShareContent a;
    private int b = 0;
    private boolean c = false;

    /*
     * Enabled aggressive block sorting
     */
    protected ShareButtonBase(Context context, AttributeSet attributeSet, int n2, String string2, String string3) {
        super(context, attributeSet, n2, 0, string2, string3);
        int n3 = this.isInEditMode() ? 0 : this.getDefaultRequestCode();
        this.b = n3;
        this.a(false);
    }

    private void a(boolean bl2) {
        this.setEnabled(bl2);
        this.c = false;
    }

    @Override
    protected void a(Context context, AttributeSet attributeSet, int n2, int n3) {
        super.a(context, attributeSet, n2, n3);
        this.setInternalOnClickListener(this.getShareOnClickListener());
    }

    protected boolean a() {
        return this.getDialog().a(this.getShareContent());
    }

    protected abstract vl<ShareContent, wq.a> getDialog();

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
                ShareButtonBase.this.a(view);
                ShareButtonBase.this.getDialog().b(ShareButtonBase.this.getShareContent());
            }
        };
    }

    public void setEnabled(boolean bl2) {
        super.setEnabled(bl2);
        this.c = true;
    }

    protected void setRequestCode(int n2) {
        if (ul.b(n2)) {
            throw new IllegalArgumentException("Request code " + n2 + " cannot be within the range reserved by the Facebook SDK.");
        }
        this.b = n2;
    }

    public void setShareContent(ShareContent shareContent) {
        this.a = shareContent;
        if (!this.c) {
            super.a(this.a());
        }
    }

}

