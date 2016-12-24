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
package com.becandid.candid.views;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.becandid.candid.views.BadgeInfoView;
import com.becandid.candid.views.BlurLayout;
import com.becandid.candid.views.BlurLayout$$ViewBinder;

public class BadgeInfoView$$ViewBinder<T extends BadgeInfoView>
extends BlurLayout$$ViewBinder<T> {
    @Override
    public Unbinder a(Finder finder, T t2, Object object) {
        a a2 = (a)super.a(finder, t2, object);
        t2.mBadgeIcon = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624079, "field 'mBadgeIcon'"), 2131624079, "field 'mBadgeIcon'");
        t2.mBadgeTitle = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624076, "field 'mBadgeTitle'"), 2131624076, "field 'mBadgeTitle'");
        t2.mBadgeDesc = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624077, "field 'mBadgeDesc'"), 2131624077, "field 'mBadgeDesc'");
        t2.mBadgeContainer = (View)finder.findRequiredView(object, 2131624075, "field 'mBadgeContainer'");
        t2.seeAllBadges = (View)finder.findRequiredView(object, 2131624078, "field 'seeAllBadges'");
        return a2;
    }

    @Override
    protected a<T> a(T t2) {
        return new a<T>(t2);
    }

    @Override
    public /* synthetic */ Unbinder bind(Finder finder, Object object, Object object2) {
        return this.a(finder, (T)((Object)((BadgeInfoView)((Object)object))), object2);
    }

    public static class a<T extends BadgeInfoView>
    extends BlurLayout$$ViewBinder.a<T> {
        protected a(T t2) {
            super(t2);
        }

        @Override
        protected void a(T t2) {
            super.a(t2);
            t2.mBadgeIcon = null;
            t2.mBadgeTitle = null;
            t2.mBadgeDesc = null;
            t2.mBadgeContainer = null;
            t2.seeAllBadges = null;
        }
    }

}

