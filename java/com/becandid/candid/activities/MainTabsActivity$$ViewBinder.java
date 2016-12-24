/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.support.design.widget.TabLayout
 *  android.view.View
 *  butterknife.Unbinder
 *  butterknife.internal.Finder
 *  butterknife.internal.ViewBinder
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package com.becandid.candid.activities;

import android.support.design.widget.TabLayout;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.activities.MainTabsActivity;
import com.becandid.candid.views.MainTabViewPager;

public class MainTabsActivity$$ViewBinder<T extends MainTabsActivity>
implements ViewBinder<T> {
    public Unbinder bind(Finder finder, T t2, Object object) {
        InnerUnbinder<T> innerUnbinder = this.createUnbinder(t2);
        t2.mViewPager = (MainTabViewPager)((Object)finder.castView((View)finder.findRequiredView(object, 2131624209, "field 'mViewPager'"), 2131624209, "field 'mViewPager'"));
        t2.mBottomTabs = (TabLayout)finder.castView((View)finder.findRequiredView(object, 2131624194, "field 'mBottomTabs'"), 2131624194, "field 'mBottomTabs'");
        t2.mCreatePostBtn = (View)finder.findRequiredView(object, 2131624211, "field 'mCreatePostBtn'");
        return innerUnbinder;
    }

    protected InnerUnbinder<T> createUnbinder(T t2) {
        return new InnerUnbinder<T>(t2);
    }

    public static class InnerUnbinder<T extends MainTabsActivity>
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
            t2.mViewPager = null;
            t2.mBottomTabs = null;
            t2.mCreatePostBtn = null;
        }
    }

}

