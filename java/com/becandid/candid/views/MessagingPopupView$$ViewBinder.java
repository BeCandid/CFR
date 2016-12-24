/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.Button
 *  android.widget.ImageView
 *  android.widget.TextView
 *  butterknife.Unbinder
 *  butterknife.internal.Finder
 *  java.lang.Object
 *  java.lang.String
 */
package com.becandid.candid.views;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.becandid.candid.views.BlurLayout;
import com.becandid.candid.views.BlurLayout$$ViewBinder;
import com.becandid.candid.views.MessagingPopupView;

public class MessagingPopupView$$ViewBinder<T extends MessagingPopupView>
extends BlurLayout$$ViewBinder<T> {
    @Override
    public Unbinder a(Finder finder, T t2, Object object) {
        a a2 = (a)super.a(finder, t2, object);
        t2.mMessageContainerEnabled = (View)finder.findRequiredView(object, 2131624565, "field 'mMessageContainerEnabled'");
        t2.mMessageContainerDeleteMessage = (View)finder.findRequiredView(object, 2131624570, "field 'mMessageContainerDeleteMessage'");
        t2.mKeepEnabledTextView = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624568, "field 'mKeepEnabledTextView'"), 2131624568, "field 'mKeepEnabledTextView'");
        t2.mDisabledTextView = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624569, "field 'mDisabledTextView'"), 2131624569, "field 'mDisabledTextView'");
        t2.mBadgeIcon = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624079, "field 'mBadgeIcon'"), 2131624079, "field 'mBadgeIcon'");
        t2.mManualDeleteMsgContainer = (View)finder.findRequiredView(object, 2131624573, "field 'mManualDeleteMsgContainer'");
        t2.mAutoDeleteMsgContainer = (View)finder.findRequiredView(object, 2131624576, "field 'mAutoDeleteMsgContainer'");
        t2.mManualCheckmark = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624574, "field 'mManualCheckmark'"), 2131624574, "field 'mManualCheckmark'");
        t2.mAutoCheckmark = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624577, "field 'mAutoCheckmark'"), 2131624577, "field 'mAutoCheckmark'");
        t2.mFinishBtn = (Button)finder.castView((View)finder.findRequiredView(object, 2131624579, "field 'mFinishBtn'"), 2131624579, "field 'mFinishBtn'");
        t2.mMessageCloseBtn = (View)finder.findRequiredView(object, 2131624580, "field 'mMessageCloseBtn'");
        t2.badgeDescEnabled = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624567, "field 'badgeDescEnabled'"), 2131624567, "field 'badgeDescEnabled'");
        return a2;
    }

    @Override
    protected a<T> a(T t2) {
        return new a<T>(t2);
    }

    @Override
    public /* synthetic */ Unbinder bind(Finder finder, Object object, Object object2) {
        return this.a(finder, (T)((Object)((MessagingPopupView)((Object)object))), object2);
    }

    public static class a<T extends MessagingPopupView>
    extends BlurLayout$$ViewBinder.a<T> {
        protected a(T t2) {
            super(t2);
        }

        @Override
        protected void a(T t2) {
            super.a(t2);
            t2.mMessageContainerEnabled = null;
            t2.mMessageContainerDeleteMessage = null;
            t2.mKeepEnabledTextView = null;
            t2.mDisabledTextView = null;
            t2.mBadgeIcon = null;
            t2.mManualDeleteMsgContainer = null;
            t2.mAutoDeleteMsgContainer = null;
            t2.mManualCheckmark = null;
            t2.mAutoCheckmark = null;
            t2.mFinishBtn = null;
            t2.mMessageCloseBtn = null;
            t2.badgeDescEnabled = null;
        }
    }

}

