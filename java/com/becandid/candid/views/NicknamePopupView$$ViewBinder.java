/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.Button
 *  android.widget.EditText
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.becandid.candid.views.BlurLayout;
import com.becandid.candid.views.BlurLayout$$ViewBinder;
import com.becandid.candid.views.NicknamePopupView;

public class NicknamePopupView$$ViewBinder<T extends NicknamePopupView>
extends BlurLayout$$ViewBinder<T> {
    @Override
    public Unbinder a(Finder finder, T t2, Object object) {
        a a2 = (a)super.a(finder, t2, object);
        t2.mMessageContainerAddNickname = (View)finder.findRequiredView(object, 2131624590, "field 'mMessageContainerAddNickname'");
        t2.mMessageContainerSecondNickname = (View)finder.findRequiredView(object, 2131624584, "field 'mMessageContainerSecondNickname'");
        t2.mBadgeIcon = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624079, "field 'mBadgeIcon'"), 2131624079, "field 'mBadgeIcon'");
        t2.mFinishBtn = (Button)finder.castView((View)finder.findRequiredView(object, 2131624579, "field 'mFinishBtn'"), 2131624579, "field 'mFinishBtn'");
        t2.mNicknameCloseButton = (View)finder.findRequiredView(object, 2131624595, "field 'mNicknameCloseButton'");
        t2.secondNicknameDesc = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624586, "field 'secondNicknameDesc'"), 2131624586, "field 'secondNicknameDesc'");
        t2.addNicknameDesc = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624592, "field 'addNicknameDesc'"), 2131624592, "field 'addNicknameDesc'");
        t2.mNoButton = (Button)finder.castView((View)finder.findRequiredView(object, 2131624587, "field 'mNoButton'"), 2131624587, "field 'mNoButton'");
        t2.mYesButton = (Button)finder.castView((View)finder.findRequiredView(object, 2131624588, "field 'mYesButton'"), 2131624588, "field 'mYesButton'");
        t2.mOkButton = (Button)finder.castView((View)finder.findRequiredView(object, 2131624589, "field 'mOkButton'"), 2131624589, "field 'mOkButton'");
        t2.mCancelButton = (Button)finder.castView((View)finder.findRequiredView(object, 2131624594, "field 'mCancelButton'"), 2131624594, "field 'mCancelButton'");
        t2.editNickname = (EditText)finder.castView((View)finder.findRequiredView(object, 2131624593, "field 'editNickname'"), 2131624593, "field 'editNickname'");
        return a2;
    }

    @Override
    protected a<T> a(T t2) {
        return new a<T>(t2);
    }

    @Override
    public /* synthetic */ Unbinder bind(Finder finder, Object object, Object object2) {
        return this.a(finder, (T)((Object)((NicknamePopupView)((Object)object))), object2);
    }

    public static class a<T extends NicknamePopupView>
    extends BlurLayout$$ViewBinder.a<T> {
        protected a(T t2) {
            super(t2);
        }

        @Override
        protected void a(T t2) {
            super.a(t2);
            t2.mMessageContainerAddNickname = null;
            t2.mMessageContainerSecondNickname = null;
            t2.mBadgeIcon = null;
            t2.mFinishBtn = null;
            t2.mNicknameCloseButton = null;
            t2.secondNicknameDesc = null;
            t2.addNicknameDesc = null;
            t2.mNoButton = null;
            t2.mYesButton = null;
            t2.mOkButton = null;
            t2.mCancelButton = null;
            t2.editNickname = null;
        }
    }

}

