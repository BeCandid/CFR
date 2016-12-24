/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.TextView
 *  butterknife.Unbinder
 *  butterknife.internal.Finder
 *  java.lang.Object
 *  java.lang.String
 */
package com.becandid.candid.views;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.becandid.candid.views.BlurLayout;
import com.becandid.candid.views.BlurLayout$$ViewBinder;
import com.becandid.candid.views.ModeratorInfoView;

public class ModeratorInfoView$$ViewBinder<T extends ModeratorInfoView>
extends BlurLayout$$ViewBinder<T> {
    @Override
    public Unbinder a(Finder finder, T t2, Object object) {
        a a2 = (a)super.a(finder, t2, object);
        t2.mBadgeContainer = (View)finder.findRequiredView(object, 2131624075, "field 'mBadgeContainer'");
        t2.mModTitle = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624076, "field 'mModTitle'"), 2131624076, "field 'mModTitle'");
        t2.mModDesc = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624077, "field 'mModDesc'"), 2131624077, "field 'mModDesc'");
        return a2;
    }

    @Override
    protected a<T> a(T t2) {
        return new a<T>(t2);
    }

    @Override
    public /* synthetic */ Unbinder bind(Finder finder, Object object, Object object2) {
        return this.a(finder, (T)((Object)((ModeratorInfoView)((Object)object))), object2);
    }

    public static class a<T extends ModeratorInfoView>
    extends BlurLayout$$ViewBinder.a<T> {
        protected a(T t2) {
            super(t2);
        }

        @Override
        protected void a(T t2) {
            super.a(t2);
            t2.mBadgeContainer = null;
            t2.mModTitle = null;
            t2.mModDesc = null;
        }
    }

}

