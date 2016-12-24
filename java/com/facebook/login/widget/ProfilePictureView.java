/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.facebook.login.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;

public class ProfilePictureView
extends FrameLayout {
    public static final String a = ProfilePictureView.class.getSimpleName();
    private String b;
    private int c = 0;
    private int d = 0;
    private boolean e = true;
    private Bitmap f;
    private ImageView g;
    private int h = -1;
    private vs i;
    private a j;
    private Bitmap k = null;

    public ProfilePictureView(Context context) {
        super(context);
        super.a(context);
    }

    public ProfilePictureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.a(context);
        super.a(attributeSet);
    }

    public ProfilePictureView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        super.a(context);
        super.a(attributeSet);
    }

    private void a(Context context) {
        this.removeAllViews();
        this.g = new ImageView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.g.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        this.g.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.addView((View)this.g);
    }

    private void a(AttributeSet attributeSet) {
        TypedArray typedArray = this.getContext().obtainStyledAttributes(attributeSet, uu.h.com_facebook_profile_picture_view);
        this.setPresetSize(typedArray.getInt(uu.h.com_facebook_profile_picture_view_com_facebook_preset_size, -1));
        this.e = typedArray.getBoolean(uu.h.com_facebook_profile_picture_view_com_facebook_is_cropped, true);
        typedArray.recycle();
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(vt vt2) {
        if (vt2.a() != this.i) return;
        {
            this.i = null;
            Bitmap bitmap = vt2.c();
            Exception exception = vt2.b();
            if (exception != null) {
                a a2 = this.j;
                if (a2 == null) {
                    vx.a(LoggingBehavior.a, 6, a, exception.toString());
                    return;
                }
                a2.a(new FacebookException("Error in downloading profile picture for profileId: " + this.getProfileId(), (Throwable)exception));
                return;
            } else {
                if (bitmap == null) return;
                {
                    super.setImageBitmap(bitmap);
                    if (!vt2.d()) return;
                    {
                        super.b(false);
                        return;
                    }
                }
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(boolean bl2) {
        boolean bl3 = super.c();
        if (this.b == null || this.b.length() == 0 || this.d == 0 && this.c == 0) {
            super.b();
            return;
        } else {
            if (!bl3 && !bl2) return;
            {
                super.b(true);
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void b() {
        if (this.i != null) {
            vr.b(this.i);
        }
        if (this.k != null) {
            this.c();
            this.setImageBitmap(Bitmap.createScaledBitmap((Bitmap)this.k, (int)this.d, (int)this.c, (boolean)false));
            return;
        }
        int n2 = this.a() ? uu.c.com_facebook_profile_picture_blank_square : uu.c.com_facebook_profile_picture_blank_portrait;
        this.setImageBitmap(BitmapFactory.decodeResource((Resources)this.getResources(), (int)n2));
    }

    private void b(boolean bl2) {
        vs vs2 = new vs.a(this.getContext(), vs.a(this.b, this.d, this.c)).a(bl2).a(this).a(new vs.b(){

            @Override
            public void a(vt vt2) {
                ProfilePictureView.this.a(vt2);
            }
        }).a();
        if (this.i != null) {
            vr.b(this.i);
        }
        this.i = vs2;
        vr.a(vs2);
    }

    /*
     * Enabled aggressive block sorting
     */
    private int c(boolean bl2) {
        int n2;
        switch (this.h) {
            default: {
                return 0;
            }
            case -2: {
                n2 = uu.b.com_facebook_profilepictureview_preset_size_small;
                return this.getResources().getDimensionPixelSize(n2);
            }
            case -3: {
                n2 = uu.b.com_facebook_profilepictureview_preset_size_normal;
                return this.getResources().getDimensionPixelSize(n2);
            }
            case -4: {
                n2 = uu.b.com_facebook_profilepictureview_preset_size_large;
                return this.getResources().getDimensionPixelSize(n2);
            }
            case -1: 
        }
        if (!bl2) return 0;
        n2 = uu.b.com_facebook_profilepictureview_preset_size_normal;
        return this.getResources().getDimensionPixelSize(n2);
    }

    /*
     * Enabled aggressive block sorting
     */
    private boolean c() {
        int n2 = 1;
        int n3 = this.getHeight();
        int n4 = this.getWidth();
        if (n4 < n2 || n3 < n2) {
            return false;
        }
        int n5 = this.c(false);
        if (n5 != 0) {
            n4 = n5;
            n3 = n5;
        }
        if (n4 <= n3) {
            n3 = this.a() ? n4 : 0;
        } else {
            n4 = this.a() ? n3 : 0;
        }
        if (n4 == this.d && n3 == this.c) {
            n2 = 0;
        }
        this.d = n4;
        this.c = n3;
        return (boolean)n2;
    }

    private void setImageBitmap(Bitmap bitmap) {
        if (this.g != null && bitmap != null) {
            this.f = bitmap;
            this.g.setImageBitmap(bitmap);
        }
    }

    public final boolean a() {
        return this.e;
    }

    public final a getOnErrorListener() {
        return this.j;
    }

    public final int getPresetSize() {
        return this.h;
    }

    public final String getProfileId() {
        return this.b;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.i = null;
    }

    protected void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
        super.onLayout(bl2, n2, n3, n4, n5);
        this.a(false);
    }

    protected void onMeasure(int n2, int n3) {
        ViewGroup.LayoutParams layoutParams = this.getLayoutParams();
        int n4 = View.MeasureSpec.getSize((int)n3);
        int n5 = View.MeasureSpec.getSize((int)n2);
        int n6 = View.MeasureSpec.getMode((int)n3);
        boolean bl2 = false;
        if (n6 != 1073741824) {
            int n7 = layoutParams.height;
            bl2 = false;
            if (n7 == -2) {
                n4 = super.c(true);
                n3 = View.MeasureSpec.makeMeasureSpec((int)n4, (int)1073741824);
                bl2 = true;
            }
        }
        if (View.MeasureSpec.getMode((int)n2) != 1073741824 && layoutParams.width == -2) {
            n5 = super.c(true);
            n2 = View.MeasureSpec.makeMeasureSpec((int)n5, (int)1073741824);
            bl2 = true;
        }
        if (bl2) {
            this.setMeasuredDimension(n5, n4);
            this.measureChildren(n2, n3);
            return;
        }
        super.onMeasure(n2, n3);
    }

    /*
     * Enabled aggressive block sorting
     */
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable.getClass() != Bundle.class) {
            super.onRestoreInstanceState(parcelable);
            return;
        } else {
            Bundle bundle = (Bundle)parcelable;
            super.onRestoreInstanceState(bundle.getParcelable("ProfilePictureView_superState"));
            this.b = bundle.getString("ProfilePictureView_profileId");
            this.h = bundle.getInt("ProfilePictureView_presetSize");
            this.e = bundle.getBoolean("ProfilePictureView_isCropped");
            this.d = bundle.getInt("ProfilePictureView_width");
            this.c = bundle.getInt("ProfilePictureView_height");
            super.setImageBitmap((Bitmap)bundle.getParcelable("ProfilePictureView_bitmap"));
            if (!bundle.getBoolean("ProfilePictureView_refresh")) return;
            {
                super.a(true);
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelable = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable("ProfilePictureView_superState", parcelable);
        bundle.putString("ProfilePictureView_profileId", this.b);
        bundle.putInt("ProfilePictureView_presetSize", this.h);
        bundle.putBoolean("ProfilePictureView_isCropped", this.e);
        bundle.putParcelable("ProfilePictureView_bitmap", (Parcelable)this.f);
        bundle.putInt("ProfilePictureView_width", this.d);
        bundle.putInt("ProfilePictureView_height", this.c);
        boolean bl2 = this.i != null;
        bundle.putBoolean("ProfilePictureView_refresh", bl2);
        return bundle;
    }

    public final void setCropped(boolean bl2) {
        this.e = bl2;
        super.a(false);
    }

    public final void setDefaultProfilePicture(Bitmap bitmap) {
        this.k = bitmap;
    }

    public final void setOnErrorListener(a a2) {
        this.j = a2;
    }

    public final void setPresetSize(int n2) {
        switch (n2) {
            default: {
                throw new IllegalArgumentException("Must use a predefined preset size");
            }
            case -4: 
            case -3: 
            case -2: 
            case -1: 
        }
        this.h = n2;
        this.requestLayout();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final void setProfileId(String var1) {
        if (we.a(this.b)) ** GOTO lbl-1000
        var3_2 = this.b.equalsIgnoreCase(var1);
        var2_3 = false;
        if (!var3_2) lbl-1000: // 2 sources:
        {
            super.b();
            var2_3 = true;
        }
        this.b = var1;
        super.a(var2_3);
    }

    public static interface a {
        public void a(FacebookException var1);
    }

}

