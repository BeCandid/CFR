/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.TextView
 *  butterknife.Unbinder
 *  butterknife.internal.Finder
 *  java.lang.Object
 *  java.lang.String
 */
package com.becandid.candid.views.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.becandid.candid.views.viewholders.BasePostViewHolder;
import com.becandid.candid.views.viewholders.BasePostViewHolder$$ViewBinder;
import com.becandid.candid.views.viewholders.ImagePostViewHolder;

public class ImagePostViewHolder$$ViewBinder<T extends ImagePostViewHolder>
extends BasePostViewHolder$$ViewBinder<T> {
    @Override
    public Unbinder a(Finder finder, T t2, Object object) {
        a a2 = (a)super.a(finder, t2, object);
        t2.mPostCaption = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624115, "field 'mPostCaption'"), 2131624115, "field 'mPostCaption'");
        t2.mPostImage = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624404, "field 'mPostImage'"), 2131624404, "field 'mPostImage'");
        t2.mPostImageRow = (View)finder.findRequiredView(object, 2131624402, "field 'mPostImageRow'");
        t2.mPostLoadingImageProgress = (View)finder.findRequiredView(object, 2131624406, "field 'mPostLoadingImageProgress'");
        t2.mPostImageContainer = (View)finder.findRequiredView(object, 2131624403, "field 'mPostImageContainer'");
        t2.mPostLoadingImageProgressContainer = (View)finder.findRequiredView(object, 2131624405, "field 'mPostLoadingImageProgressContainer'");
        t2.mPostGifPlay = (View)finder.findRequiredView(object, 2131624407, "field 'mPostGifPlay'");
        t2.mPostImageImage = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624412, "field 'mPostImageImage'"), 2131624412, "field 'mPostImageImage'");
        return a2;
    }

    @Override
    protected a<T> a(T t2) {
        return new a<T>(t2);
    }

    @Override
    public /* synthetic */ Unbinder bind(Finder finder, Object object, Object object2) {
        return this.a(finder, (T)((Object)((ImagePostViewHolder)((Object)object))), object2);
    }

    public static class a<T extends ImagePostViewHolder>
    extends BasePostViewHolder$$ViewBinder.a<T> {
        protected a(T t2) {
            super(t2);
        }

        @Override
        protected void a(T t2) {
            super.a(t2);
            t2.mPostCaption = null;
            t2.mPostImage = null;
            t2.mPostImageRow = null;
            t2.mPostLoadingImageProgress = null;
            t2.mPostImageContainer = null;
            t2.mPostLoadingImageProgressContainer = null;
            t2.mPostGifPlay = null;
            t2.mPostImageImage = null;
        }
    }

}

