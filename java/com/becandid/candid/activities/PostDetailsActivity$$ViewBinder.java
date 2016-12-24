/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.support.v4.widget.SwipeRefreshLayout
 *  android.support.v7.widget.RecyclerView
 *  android.view.View
 *  android.widget.EditText
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

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.activities.PostDetailsActivity;
import com.becandid.candid.views.StickerKeyboard;

public class PostDetailsActivity$$ViewBinder<T extends PostDetailsActivity>
implements ViewBinder<T> {
    public Unbinder bind(Finder finder, T t2, Object object) {
        InnerUnbinder<T> innerUnbinder = this.createUnbinder(t2);
        t2.commentRecyclerView = (RecyclerView)finder.castView((View)finder.findRequiredView(object, 2131624268, "field 'commentRecyclerView'"), 2131624268, "field 'commentRecyclerView'");
        t2.mSwipeContainer = (SwipeRefreshLayout)finder.castView((View)finder.findRequiredView(object, 2131624169, "field 'mSwipeContainer'"), 2131624169, "field 'mSwipeContainer'");
        t2.postHeaderText = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624265, "field 'postHeaderText'"), 2131624265, "field 'postHeaderText'");
        t2.commentInput = (EditText)finder.castView((View)finder.findRequiredView(object, 2131624276, "field 'commentInput'"), 2131624276, "field 'commentInput'");
        t2.commentButton = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624130, "field 'commentButton'"), 2131624130, "field 'commentButton'");
        t2.postPhoto = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624274, "field 'postPhoto'"), 2131624274, "field 'postPhoto'");
        t2.stickerKeyboard = (StickerKeyboard)((Object)finder.castView((View)finder.findRequiredView(object, 2131624232, "field 'stickerKeyboard'"), 2131624232, "field 'stickerKeyboard'"));
        t2.root = (View)finder.findRequiredView(object, 2131624263, "field 'root'");
        t2.postSpinnyContainer = (RelativeLayout)finder.castView((View)finder.findRequiredView(object, 2131624282, "field 'postSpinnyContainer'"), 2131624282, "field 'postSpinnyContainer'");
        t2.commentInputContainer = (RelativeLayout)finder.castView((View)finder.findRequiredView(object, 2131624272, "field 'commentInputContainer'"), 2131624272, "field 'commentInputContainer'");
        t2.commentTextPlaceholder = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624279, "field 'commentTextPlaceholder'"), 2131624279, "field 'commentTextPlaceholder'");
        t2.stickerButton = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624278, "field 'stickerButton'"), 2131624278, "field 'stickerButton'");
        t2.commentPhotoClear = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624275, "field 'commentPhotoClear'"), 2131624275, "field 'commentPhotoClear'");
        t2.commentSpinnyContainer = (FrameLayout)finder.castView((View)finder.findRequiredView(object, 2131624281, "field 'commentSpinnyContainer'"), 2131624281, "field 'commentSpinnyContainer'");
        t2.mutePostIcon = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624266, "field 'mutePostIcon'"), 2131624266, "field 'mutePostIcon'");
        t2.relatedPostsButton = (LinearLayout)finder.castView((View)finder.findRequiredView(object, 2131624280, "field 'relatedPostsButton'"), 2131624280, "field 'relatedPostsButton'");
        t2.mReplyToBox = (View)finder.findRequiredView(object, 2131624269, "field 'mReplyToBox'");
        t2.mReplyToTextHint = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624270, "field 'mReplyToTextHint'"), 2131624270, "field 'mReplyToTextHint'");
        t2.mReplyToClose = (View)finder.findRequiredView(object, 2131624271, "field 'mReplyToClose'");
        return innerUnbinder;
    }

    protected InnerUnbinder<T> createUnbinder(T t2) {
        return new InnerUnbinder<T>(t2);
    }

    public static class InnerUnbinder<T extends PostDetailsActivity>
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
            t2.commentRecyclerView = null;
            t2.mSwipeContainer = null;
            t2.postHeaderText = null;
            t2.commentInput = null;
            t2.commentButton = null;
            t2.postPhoto = null;
            t2.stickerKeyboard = null;
            t2.root = null;
            t2.postSpinnyContainer = null;
            t2.commentInputContainer = null;
            t2.commentTextPlaceholder = null;
            t2.stickerButton = null;
            t2.commentPhotoClear = null;
            t2.commentSpinnyContainer = null;
            t2.mutePostIcon = null;
            t2.relatedPostsButton = null;
            t2.mReplyToBox = null;
            t2.mReplyToTextHint = null;
            t2.mReplyToClose = null;
        }
    }

}

