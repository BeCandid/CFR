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
package com.becandid.candid.activities;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.activities.FullScreenImageActivity;

public class FullScreenImageActivity$$ViewBinder<T extends FullScreenImageActivity>
implements ViewBinder<T> {
    public Unbinder bind(Finder finder, T t2, Object object) {
        InnerUnbinder<T> innerUnbinder = this.createUnbinder(t2);
        t2.container = (RelativeLayout)finder.castView((View)finder.findRequiredView(object, 2131624132, "field 'container'"), 2131624132, "field 'container'");
        t2.fullscreenImage = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624133, "field 'fullscreenImage'"), 2131624133, "field 'fullscreenImage'");
        t2.fullscreenSpinny = (LinearLayout)finder.castView((View)finder.findRequiredView(object, 2131624161, "field 'fullscreenSpinny'"), 2131624161, "field 'fullscreenSpinny'");
        t2.fullscreenFooter = (RelativeLayout)finder.castView((View)finder.findRequiredView(object, 2131624138, "field 'fullscreenFooter'"), 2131624138, "field 'fullscreenFooter'");
        t2.userIcon = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624140, "field 'userIcon'"), 2131624140, "field 'userIcon'");
        t2.userName = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624142, "field 'userName'"), 2131624142, "field 'userName'");
        t2.likeContainer = (RelativeLayout)finder.castView((View)finder.findRequiredView(object, 2131624144, "field 'likeContainer'"), 2131624144, "field 'likeContainer'");
        t2.likeIcon = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624145, "field 'likeIcon'"), 2131624145, "field 'likeIcon'");
        t2.trueIcon = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624146, "field 'trueIcon'"), 2131624146, "field 'trueIcon'");
        t2.likeCount = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624148, "field 'likeCount'"), 2131624148, "field 'likeCount'");
        t2.trueCount = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624149, "field 'trueCount'"), 2131624149, "field 'trueCount'");
        t2.falseCount = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624155, "field 'falseCount'"), 2131624155, "field 'falseCount'");
        t2.dislikeContainer = (RelativeLayout)finder.castView((View)finder.findRequiredView(object, 2131624150, "field 'dislikeContainer'"), 2131624150, "field 'dislikeContainer'");
        t2.dislikeIcon = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624151, "field 'dislikeIcon'"), 2131624151, "field 'dislikeIcon'");
        t2.falseIcon = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624152, "field 'falseIcon'"), 2131624152, "field 'falseIcon'");
        t2.dislikeCount = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624154, "field 'dislikeCount'"), 2131624154, "field 'dislikeCount'");
        t2.commentContainer = (RelativeLayout)finder.castView((View)finder.findRequiredView(object, 2131624156, "field 'commentContainer'"), 2131624156, "field 'commentContainer'");
        t2.commentCount = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624158, "field 'commentCount'"), 2131624158, "field 'commentCount'");
        t2.shareContainer = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624159, "field 'shareContainer'"), 2131624159, "field 'shareContainer'");
        t2.replyContainer = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624160, "field 'replyContainer'"), 2131624160, "field 'replyContainer'");
        t2.fullscreenGradient = (FrameLayout)finder.castView((View)finder.findRequiredView(object, 2131624137, "field 'fullscreenGradient'"), 2131624137, "field 'fullscreenGradient'");
        t2.fullscreenHeader = (RelativeLayout)finder.castView((View)finder.findRequiredView(object, 2131624134, "field 'fullscreenHeader'"), 2131624134, "field 'fullscreenHeader'");
        t2.fullscreenDownload = (View)finder.findRequiredView(object, 2131624136, "field 'fullscreenDownload'");
        t2.fullscreenExit = (View)finder.findRequiredView(object, 2131624135, "field 'fullscreenExit'");
        return innerUnbinder;
    }

    protected InnerUnbinder<T> createUnbinder(T t2) {
        return new InnerUnbinder<T>(t2);
    }

    public static class InnerUnbinder<T extends FullScreenImageActivity>
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
            t2.container = null;
            t2.fullscreenImage = null;
            t2.fullscreenSpinny = null;
            t2.fullscreenFooter = null;
            t2.userIcon = null;
            t2.userName = null;
            t2.likeContainer = null;
            t2.likeIcon = null;
            t2.trueIcon = null;
            t2.likeCount = null;
            t2.trueCount = null;
            t2.falseCount = null;
            t2.dislikeContainer = null;
            t2.dislikeIcon = null;
            t2.falseIcon = null;
            t2.dislikeCount = null;
            t2.commentContainer = null;
            t2.commentCount = null;
            t2.shareContainer = null;
            t2.replyContainer = null;
            t2.fullscreenGradient = null;
            t2.fullscreenHeader = null;
            t2.fullscreenDownload = null;
            t2.fullscreenExit = null;
        }
    }

}

