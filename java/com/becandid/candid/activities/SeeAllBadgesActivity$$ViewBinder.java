/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.support.v7.widget.RecyclerView
 *  android.view.View
 *  android.widget.FrameLayout
 *  butterknife.Unbinder
 *  butterknife.internal.Finder
 *  butterknife.internal.ViewBinder
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package com.becandid.candid.activities;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.activities.SeeAllBadgesActivity;

public class SeeAllBadgesActivity$$ViewBinder<T extends SeeAllBadgesActivity>
implements ViewBinder<T> {
    public Unbinder bind(Finder finder, T t2, Object object) {
        InnerUnbinder<T> innerUnbinder = this.createUnbinder(t2);
        t2.mRecyclerView = (RecyclerView)finder.castView((View)finder.findRequiredView(object, 2131624286, "field 'mRecyclerView'"), 2131624286, "field 'mRecyclerView'");
        t2.mBadgeInfoContainer = (FrameLayout)finder.castView((View)finder.findRequiredView(object, 2131624287, "field 'mBadgeInfoContainer'"), 2131624287, "field 'mBadgeInfoContainer'");
        return innerUnbinder;
    }

    protected InnerUnbinder<T> createUnbinder(T t2) {
        return new InnerUnbinder<T>(t2);
    }

    public static class InnerUnbinder<T extends SeeAllBadgesActivity>
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
            t2.mRecyclerView = null;
            t2.mBadgeInfoContainer = null;
        }
    }

}

