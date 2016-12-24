/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.Button
 *  android.widget.TextView
 *  butterknife.Unbinder
 *  butterknife.internal.Finder
 *  java.lang.Object
 *  java.lang.String
 */
package com.becandid.candid.views;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.becandid.candid.views.BlurLayout;
import com.becandid.candid.views.BlurLayout$$ViewBinder;
import com.becandid.candid.views.QualityScoreInfoView;

public class QualityScoreInfoView$$ViewBinder<T extends QualityScoreInfoView>
extends BlurLayout$$ViewBinder<T> {
    @Override
    public Unbinder a(Finder finder, T t2, Object object) {
        a a2 = (a)super.a(finder, t2, object);
        t2.mScoreText = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624528, "field 'mScoreText'"), 2131624528, "field 'mScoreText'");
        t2.mBadgeContainer = (View)finder.findRequiredView(object, 2131624075, "field 'mBadgeContainer'");
        t2.mScoreTitle = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624076, "field 'mScoreTitle'"), 2131624076, "field 'mScoreTitle'");
        t2.mScoreDesc = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624077, "field 'mScoreDesc'"), 2131624077, "field 'mScoreDesc'");
        t2.mClosePopup = (Button)finder.castView((View)finder.findOptionalView(object, 2131624796, null), 2131624796, "field 'mClosePopup'");
        return a2;
    }

    @Override
    protected a<T> a(T t2) {
        return new a<T>(t2);
    }

    @Override
    public /* synthetic */ Unbinder bind(Finder finder, Object object, Object object2) {
        return this.a(finder, (T)((Object)((QualityScoreInfoView)((Object)object))), object2);
    }

    public static class a<T extends QualityScoreInfoView>
    extends BlurLayout$$ViewBinder.a<T> {
        protected a(T t2) {
            super(t2);
        }

        @Override
        protected void a(T t2) {
            super.a(t2);
            t2.mScoreText = null;
            t2.mBadgeContainer = null;
            t2.mScoreTitle = null;
            t2.mScoreDesc = null;
            t2.mClosePopup = null;
        }
    }

}

