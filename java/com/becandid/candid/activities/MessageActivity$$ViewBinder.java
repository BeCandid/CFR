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
import com.becandid.candid.activities.MessageActivity;
import com.becandid.candid.views.StickerKeyboard;

public class MessageActivity$$ViewBinder<T extends MessageActivity>
implements ViewBinder<T> {
    public Unbinder bind(Finder finder, T t2, Object object) {
        InnerUnbinder<T> innerUnbinder = this.createUnbinder(t2);
        t2.root = (View)finder.findRequiredView(object, 2131624215, "field 'root'");
        t2.contentRootView = (RelativeLayout)finder.castView((View)finder.findRequiredView(object, 2131624216, "field 'contentRootView'"), 2131624216, "field 'contentRootView'");
        t2.messageSpinnyContainer = (FrameLayout)finder.castView((View)finder.findRequiredView(object, 2131624233, "field 'messageSpinnyContainer'"), 2131624233, "field 'messageSpinnyContainer'");
        t2.blockedFrameLayout = (FrameLayout)finder.castView((View)finder.findRequiredView(object, 2131624234, "field 'blockedFrameLayout'"), 2131624234, "field 'blockedFrameLayout'");
        t2.headerName = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624237, "field 'headerName'"), 2131624237, "field 'headerName'");
        t2.headerOnline = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624239, "field 'headerOnline'"), 2131624239, "field 'headerOnline'");
        t2.messageHeaderUserIcon = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624238, "field 'messageHeaderUserIcon'"), 2131624238, "field 'messageHeaderUserIcon'");
        t2.messageHeaderUserIconContainer = (RelativeLayout)finder.castView((View)finder.findRequiredView(object, 2131624236, "field 'messageHeaderUserIconContainer'"), 2131624236, "field 'messageHeaderUserIconContainer'");
        t2.messageHeaderPostText = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624241, "field 'messageHeaderPostText'"), 2131624241, "field 'messageHeaderPostText'");
        t2.messageHeaderRightArrow = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624242, "field 'messageHeaderRightArrow'"), 2131624242, "field 'messageHeaderRightArrow'");
        t2.messageHeaderPostContainer = (LinearLayout)finder.castView((View)finder.findRequiredView(object, 2131624240, "field 'messageHeaderPostContainer'"), 2131624240, "field 'messageHeaderPostContainer'");
        t2.mNickname = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624243, "field 'mNickname'"), 2131624243, "field 'mNickname'");
        t2.messageSwipeContainer = (SwipeRefreshLayout)finder.castView((View)finder.findRequiredView(object, 2131624217, "field 'messageSwipeContainer'"), 2131624217, "field 'messageSwipeContainer'");
        t2.messageRecycler = (RecyclerView)finder.castView((View)finder.findRequiredView(object, 2131624220, "field 'messageRecycler'"), 2131624220, "field 'messageRecycler'");
        t2.messageTextPlaceholder = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624228, "field 'messageTextPlaceholder'"), 2131624228, "field 'messageTextPlaceholder'");
        t2.messageInputContainer = (RelativeLayout)finder.castView((View)finder.findRequiredView(object, 2131624221, "field 'messageInputContainer'"), 2131624221, "field 'messageInputContainer'");
        t2.postButton = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624130, "field 'postButton'"), 2131624130, "field 'postButton'");
        t2.messageInput = (EditText)finder.castView((View)finder.findRequiredView(object, 2131624225, "field 'messageInput'"), 2131624225, "field 'messageInput'");
        t2.messagePhoto = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624223, "field 'messagePhoto'"), 2131624223, "field 'messagePhoto'");
        t2.messagePhotoButton = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624226, "field 'messagePhotoButton'"), 2131624226, "field 'messagePhotoButton'");
        t2.messagePhotoClear = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624224, "field 'messagePhotoClear'"), 2131624224, "field 'messagePhotoClear'");
        t2.requestButtons = (LinearLayout)finder.castView((View)finder.findRequiredView(object, 2131624229, "field 'requestButtons'"), 2131624229, "field 'requestButtons'");
        t2.requestIgnore = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624230, "field 'requestIgnore'"), 2131624230, "field 'requestIgnore'");
        t2.requestAccept = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624231, "field 'requestAccept'"), 2131624231, "field 'requestAccept'");
        t2.stickerKeyboard = (StickerKeyboard)((Object)finder.castView((View)finder.findRequiredView(object, 2131624232, "field 'stickerKeyboard'"), 2131624232, "field 'stickerKeyboard'"));
        t2.stickerButton = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624227, "field 'stickerButton'"), 2131624227, "field 'stickerButton'");
        return innerUnbinder;
    }

    protected InnerUnbinder<T> createUnbinder(T t2) {
        return new InnerUnbinder<T>(t2);
    }

    public static class InnerUnbinder<T extends MessageActivity>
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
            t2.root = null;
            t2.contentRootView = null;
            t2.messageSpinnyContainer = null;
            t2.blockedFrameLayout = null;
            t2.headerName = null;
            t2.headerOnline = null;
            t2.messageHeaderUserIcon = null;
            t2.messageHeaderUserIconContainer = null;
            t2.messageHeaderPostText = null;
            t2.messageHeaderRightArrow = null;
            t2.messageHeaderPostContainer = null;
            t2.mNickname = null;
            t2.messageSwipeContainer = null;
            t2.messageRecycler = null;
            t2.messageTextPlaceholder = null;
            t2.messageInputContainer = null;
            t2.postButton = null;
            t2.messageInput = null;
            t2.messagePhoto = null;
            t2.messagePhotoButton = null;
            t2.messagePhotoClear = null;
            t2.requestButtons = null;
            t2.requestIgnore = null;
            t2.requestAccept = null;
            t2.stickerKeyboard = null;
            t2.stickerButton = null;
        }
    }

}

