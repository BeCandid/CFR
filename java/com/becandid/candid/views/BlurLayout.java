/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.os.AsyncTask
 *  android.text.TextUtils
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.RelativeLayout
 *  butterknife.BindView
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Void
 */
package com.becandid.candid.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import butterknife.BindView;

public abstract class BlurLayout
extends RelativeLayout {
    protected String a;
    @BindView(value=2131624073)
    View mBackgroundContainer;
    @BindView(value=2131624080)
    ImageView mBlurImage;

    public BlurLayout(Context context) {
        super(context);
    }

    private void b() {
        if (!TextUtils.isEmpty((CharSequence)this.a)) {
            new AsyncTask<Void, Void, Void>(){

                protected /* varargs */ Void a(Void ... arrvoid) {
                    jm.b(BlurLayout.this.a);
                    return null;
                }

                protected /* synthetic */ Object doInBackground(Object[] arrobject) {
                    return this.a((Void[])arrobject);
                }
            }.execute((Object[])new Void[0]);
        }
    }

    protected void a() {
        if (!TextUtils.isEmpty((CharSequence)this.a)) {
            this.mBackgroundContainer.setVisibility(0);
            Bitmap bitmap = jm.a(this.a);
            if (bitmap != null) {
                this.mBlurImage.setImageBitmap(bitmap);
                this.mBlurImage.setAlpha(0.075f);
            }
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.b();
    }

}

