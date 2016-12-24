/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.ProgressBar
 *  android.widget.RelativeLayout
 *  butterknife.Unbinder
 *  butterknife.internal.Finder
 *  butterknife.internal.ViewBinder
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package com.becandid.candid.activities;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.activities.ImageCropActivity;
import com.becandid.thirdparty.nocropper.CropperView;

public class ImageCropActivity$$ViewBinder<T extends ImageCropActivity>
implements ViewBinder<T> {
    public Unbinder bind(Finder finder, T t2, Object object) {
        InnerUnbinder<T> innerUnbinder = this.createUnbinder(t2);
        t2.mImageView = (CropperView)((Object)finder.castView((View)finder.findRequiredView(object, 2131624189, "field 'mImageView'"), 2131624189, "field 'mImageView'"));
        t2.mCropButton = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624190, "field 'mCropButton'"), 2131624190, "field 'mCropButton'");
        t2.mProgressBar = (ProgressBar)finder.castView((View)finder.findRequiredView(object, 2131624191, "field 'mProgressBar'"), 2131624191, "field 'mProgressBar'");
        t2.mCropContainer = (RelativeLayout)finder.castView((View)finder.findRequiredView(object, 2131624187, "field 'mCropContainer'"), 2131624187, "field 'mCropContainer'");
        t2.mCropperFrameLayout = (FrameLayout)finder.castView((View)finder.findRequiredView(object, 2131624188, "field 'mCropperFrameLayout'"), 2131624188, "field 'mCropperFrameLayout'");
        return innerUnbinder;
    }

    protected InnerUnbinder<T> createUnbinder(T t2) {
        return new InnerUnbinder<T>(t2);
    }

    public static class InnerUnbinder<T extends ImageCropActivity>
    implements Unbinder {
        private T a;

        protected InnerUnbinder(T t2) {
            this.a = t2;
        }

        public final void unbind() {
            if (this.a == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.unbind(this.a);
            this.a = null;
        }

        protected void unbind(T t2) {
            t2.mImageView = null;
            t2.mCropButton = null;
            t2.mProgressBar = null;
            t2.mCropContainer = null;
            t2.mCropperFrameLayout = null;
        }
    }

}

