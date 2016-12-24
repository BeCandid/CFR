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
import com.becandid.candid.views.viewholders.LinkPostViewHolder;

public class LinkPostViewHolder$$ViewBinder<T extends LinkPostViewHolder>
extends BasePostViewHolder$$ViewBinder<T> {
    @Override
    public Unbinder a(Finder finder, T t2, Object object) {
        a a2 = (a)super.a(finder, t2, object);
        t2.mPostLinkTitle = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624396, "field 'mPostLinkTitle'"), 2131624396, "field 'mPostLinkTitle'");
        t2.mPostLinkImage = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624395, "field 'mPostLinkImage'"), 2131624395, "field 'mPostLinkImage'");
        t2.mPostLinkDesc = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624397, "field 'mPostLinkDesc'"), 2131624397, "field 'mPostLinkDesc'");
        t2.mPostLinkDomain = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624398, "field 'mPostLinkDomain'"), 2131624398, "field 'mPostLinkDomain'");
        t2.mPostImageRow = (View)finder.findRequiredView(object, 2131624402, "field 'mPostImageRow'");
        t2.mPostCaption = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624115, "field 'mPostCaption'"), 2131624115, "field 'mPostCaption'");
        t2.mPostLinkPlacehoder = (View)finder.findRequiredView(object, 2131624394, "field 'mPostLinkPlacehoder'");
        t2.mPostLinkRow = (View)finder.findRequiredView(object, 2131624414, "field 'mPostLinkRow'");
        t2.mPostImageImage = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624412, "field 'mPostImageImage'"), 2131624412, "field 'mPostImageImage'");
        t2.mPostLinkTitleImage = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624416, "field 'mPostLinkTitleImage'"), 2131624416, "field 'mPostLinkTitleImage'");
        t2.mPostLinkDescImage = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624417, "field 'mPostLinkDescImage'"), 2131624417, "field 'mPostLinkDescImage'");
        t2.mPostLinkDomainImage = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624418, "field 'mPostLinkDomainImage'"), 2131624418, "field 'mPostLinkDomainImage'");
        t2.mPostInfoImage = (View)finder.findRequiredView(object, 2131624415, "field 'mPostInfoImage'");
        return a2;
    }

    @Override
    protected a<T> a(T t2) {
        return new a<T>(t2);
    }

    @Override
    public /* synthetic */ Unbinder bind(Finder finder, Object object, Object object2) {
        return this.a(finder, (T)((Object)((LinkPostViewHolder)((Object)object))), object2);
    }

    public static class a<T extends LinkPostViewHolder>
    extends BasePostViewHolder$$ViewBinder.a<T> {
        protected a(T t2) {
            super(t2);
        }

        @Override
        protected void a(T t2) {
            super.a(t2);
            t2.mPostLinkTitle = null;
            t2.mPostLinkImage = null;
            t2.mPostLinkDesc = null;
            t2.mPostLinkDomain = null;
            t2.mPostImageRow = null;
            t2.mPostCaption = null;
            t2.mPostLinkPlacehoder = null;
            t2.mPostLinkRow = null;
            t2.mPostImageImage = null;
            t2.mPostLinkTitleImage = null;
            t2.mPostLinkDescImage = null;
            t2.mPostLinkDomainImage = null;
            t2.mPostInfoImage = null;
        }
    }

}

