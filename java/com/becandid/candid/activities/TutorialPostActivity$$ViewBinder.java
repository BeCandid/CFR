/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.support.v4.view.ViewPager
 *  android.view.View
 *  android.widget.ImageView
 *  butterknife.Unbinder
 *  butterknife.internal.Finder
 *  butterknife.internal.ViewBinder
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package com.becandid.candid.activities;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.activities.TutorialPostActivity;

public class TutorialPostActivity$$ViewBinder<T extends TutorialPostActivity>
implements ViewBinder<T> {
    public Unbinder bind(Finder finder, T t2, Object object) {
        InnerUnbinder<T> innerUnbinder = this.createUnbinder(t2);
        t2.viewPager = (ViewPager)finder.castView((View)finder.findRequiredView(object, 2131624307, "field 'viewPager'"), 2131624307, "field 'viewPager'");
        t2.ind1 = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624308, "field 'ind1'"), 2131624308, "field 'ind1'");
        t2.ind2 = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624309, "field 'ind2'"), 2131624309, "field 'ind2'");
        t2.ind3 = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624310, "field 'ind3'"), 2131624310, "field 'ind3'");
        t2.ind4 = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624311, "field 'ind4'"), 2131624311, "field 'ind4'");
        return innerUnbinder;
    }

    protected InnerUnbinder<T> createUnbinder(T t2) {
        return new InnerUnbinder<T>(t2);
    }

    public static class InnerUnbinder<T extends TutorialPostActivity>
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
            t2.viewPager = null;
            t2.ind1 = null;
            t2.ind2 = null;
            t2.ind3 = null;
            t2.ind4 = null;
        }
    }

}

