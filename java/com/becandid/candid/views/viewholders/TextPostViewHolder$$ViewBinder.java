/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  butterknife.Unbinder
 *  butterknife.internal.Finder
 *  java.lang.Object
 *  java.lang.String
 */
package com.becandid.candid.views.viewholders;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.becandid.candid.views.viewholders.BasePostViewHolder;
import com.becandid.candid.views.viewholders.BasePostViewHolder$$ViewBinder;
import com.becandid.candid.views.viewholders.TextPostViewHolder;

public class TextPostViewHolder$$ViewBinder<T extends TextPostViewHolder>
extends BasePostViewHolder$$ViewBinder<T> {
    @Override
    public Unbinder a(Finder finder, T t2, Object object) {
        a a2 = (a)super.a(finder, t2, object);
        t2.mPostCaption = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624115, "field 'mPostCaption'"), 2131624115, "field 'mPostCaption'");
        t2.mPostTextRow = (View)finder.findRequiredView(object, 2131624419, "field 'mPostTextRow'");
        t2.mPostCaptionPlaceholder = (LinearLayout)finder.castView((View)finder.findRequiredView(object, 2131624420, "field 'mPostCaptionPlaceholder'"), 2131624420, "field 'mPostCaptionPlaceholder'");
        t2.mPostShareImage = (View)finder.findRequiredView(object, 2131624408, "field 'mPostShareImage'");
        t2.mPostImageGroup = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624795, "field 'mPostImageGroup'"), 2131624795, "field 'mPostImageGroup'");
        t2.mPostImageCaption = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624411, "field 'mPostImageCaption'"), 2131624411, "field 'mPostImageCaption'");
        return a2;
    }

    @Override
    protected a<T> a(T t2) {
        return new a<T>(t2);
    }

    @Override
    public /* synthetic */ Unbinder bind(Finder finder, Object object, Object object2) {
        return this.a(finder, (T)((Object)((TextPostViewHolder)((Object)object))), object2);
    }

    public static class a<T extends TextPostViewHolder>
    extends BasePostViewHolder$$ViewBinder.a<T> {
        protected a(T t2) {
            super(t2);
        }

        @Override
        protected void a(T t2) {
            super.a(t2);
            t2.mPostCaption = null;
            t2.mPostTextRow = null;
            t2.mPostCaptionPlaceholder = null;
            t2.mPostShareImage = null;
            t2.mPostImageGroup = null;
            t2.mPostImageCaption = null;
        }
    }

}

