/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  butterknife.Unbinder
 *  butterknife.internal.Finder
 *  butterknife.internal.ViewBinder
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package com.becandid.candid.views.viewholders;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.views.viewholders.MessagePostViewHolder;

public class MessagePostViewHolder$$ViewBinder<T extends MessagePostViewHolder>
implements ViewBinder<T> {
    public Unbinder a(Finder finder, T t2, Object object) {
        a<T> a2 = this.a(t2);
        t2.messagePostDeleted = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624399, "field 'messagePostDeleted'"), 2131624399, "field 'messagePostDeleted'");
        t2.messagePostWrapper = (FrameLayout)finder.castView((View)finder.findRequiredView(object, 2131624390, "field 'messagePostWrapper'"), 2131624390, "field 'messagePostWrapper'");
        t2.mPostCaption = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624392, "field 'mPostCaption'"), 2131624392, "field 'mPostCaption'");
        t2.mPostImage = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624393, "field 'mPostImage'"), 2131624393, "field 'mPostImage'");
        t2.mPostRow = (LinearLayout)finder.castView((View)finder.findRequiredView(object, 2131624391, "field 'mPostRow'"), 2131624391, "field 'mPostRow'");
        t2.mHeader = (View)finder.findRequiredView(object, 2131624264, "field 'mHeader'");
        t2.mPostPopupAction = (View)finder.findRequiredView(object, 2131624768, "field 'mPostPopupAction'");
        t2.mPostHeaderBadge = (View)finder.findRequiredView(object, 2131624770, "field 'mPostHeaderBadge'");
        t2.mPostHeaderBadgeText = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624771, "field 'mPostHeaderBadgeText'"), 2131624771, "field 'mPostHeaderBadgeText'");
        t2.mPostHeaderBadgeScore = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624773, "field 'mPostHeaderBadgeScore'"), 2131624773, "field 'mPostHeaderBadgeScore'");
        t2.mPostHeaderBadgeDot = (FrameLayout)finder.castView((View)finder.findRequiredView(object, 2131624772, "field 'mPostHeaderBadgeDot'"), 2131624772, "field 'mPostHeaderBadgeDot'");
        t2.mPostAuthor = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624769, "field 'mPostAuthor'"), 2131624769, "field 'mPostAuthor'");
        t2.mPostIcon = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624766, "field 'mPostIcon'"), 2131624766, "field 'mPostIcon'");
        t2.mPostModIcon = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624767, "field 'mPostModIcon'"), 2131624767, "field 'mPostModIcon'");
        t2.mPostGroup = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624779, "field 'mPostGroup'"), 2131624779, "field 'mPostGroup'");
        t2.mPostGroupContainer = (FrameLayout)finder.castView((View)finder.findRequiredView(object, 2131624776, "field 'mPostGroupContainer'"), 2131624776, "field 'mPostGroupContainer'");
        t2.mPostGroupMenu = (View)finder.findRequiredView(object, 2131624778, "field 'mPostGroupMenu'");
        t2.mPostGroupMenuContainer = (RelativeLayout)finder.castView((View)finder.findRequiredView(object, 2131624777, "field 'mPostGroupMenuContainer'"), 2131624777, "field 'mPostGroupMenuContainer'");
        t2.mPostTimestamp = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624774, "field 'mPostTimestamp'"), 2131624774, "field 'mPostTimestamp'");
        t2.mPostLinkPlacehoder = (LinearLayout)finder.castView((View)finder.findRequiredView(object, 2131624394, "field 'mPostLinkPlacehoder'"), 2131624394, "field 'mPostLinkPlacehoder'");
        t2.mPostLinkTitle = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624396, "field 'mPostLinkTitle'"), 2131624396, "field 'mPostLinkTitle'");
        t2.mPostLinkImage = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624395, "field 'mPostLinkImage'"), 2131624395, "field 'mPostLinkImage'");
        t2.mPostLinkDesc = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624397, "field 'mPostLinkDesc'"), 2131624397, "field 'mPostLinkDesc'");
        t2.mPostLinkDomain = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624398, "field 'mPostLinkDomain'"), 2131624398, "field 'mPostLinkDomain'");
        return a2;
    }

    protected a<T> a(T t2) {
        return new a<T>(t2);
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object object, Object object2) {
        return this.a(finder, (T)((Object)((MessagePostViewHolder)((Object)object))), object2);
    }

    public static class a<T extends MessagePostViewHolder>
    implements Unbinder {
        private T a;

        protected a(T t2) {
            this.a = t2;
        }

        protected void a(T t2) {
            t2.messagePostDeleted = null;
            t2.messagePostWrapper = null;
            t2.mPostCaption = null;
            t2.mPostImage = null;
            t2.mPostRow = null;
            t2.mHeader = null;
            t2.mPostPopupAction = null;
            t2.mPostHeaderBadge = null;
            t2.mPostHeaderBadgeText = null;
            t2.mPostHeaderBadgeScore = null;
            t2.mPostHeaderBadgeDot = null;
            t2.mPostAuthor = null;
            t2.mPostIcon = null;
            t2.mPostModIcon = null;
            t2.mPostGroup = null;
            t2.mPostGroupContainer = null;
            t2.mPostGroupMenu = null;
            t2.mPostGroupMenuContainer = null;
            t2.mPostTimestamp = null;
            t2.mPostLinkPlacehoder = null;
            t2.mPostLinkTitle = null;
            t2.mPostLinkImage = null;
            t2.mPostLinkDesc = null;
            t2.mPostLinkDomain = null;
        }

        public final void unbind() {
            if (this.a == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a(this.a);
            this.a = null;
        }
    }

}

