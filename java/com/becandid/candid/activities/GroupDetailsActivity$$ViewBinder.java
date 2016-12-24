/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.support.v4.widget.SwipeRefreshLayout
 *  android.support.v7.widget.RecyclerView
 *  android.view.View
 *  android.widget.LinearLayout
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
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.activities.GroupDetailsActivity;

public class GroupDetailsActivity$$ViewBinder<T extends GroupDetailsActivity>
implements ViewBinder<T> {
    public Unbinder bind(Finder finder, T t2, Object object) {
        InnerUnbinder<T> innerUnbinder = this.createUnbinder(t2);
        t2.groupPosts = (RecyclerView)finder.castView((View)finder.findRequiredView(object, 2131624171, "field 'groupPosts'"), 2131624171, "field 'groupPosts'");
        t2.loadingSpinny = (LinearLayout)finder.castView((View)finder.findRequiredView(object, 2131624177, "field 'loadingSpinny'"), 2131624177, "field 'loadingSpinny'");
        t2.gdHeaderName = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624173, "field 'gdHeaderName'"), 2131624173, "field 'gdHeaderName'");
        t2.gdJoin = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624176, "field 'gdJoin'"), 2131624176, "field 'gdJoin'");
        t2.gdCompose = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624175, "field 'gdCompose'"), 2131624175, "field 'gdCompose'");
        t2.groupEmpty = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624172, "field 'groupEmpty'"), 2131624172, "field 'groupEmpty'");
        t2.mSwipeContainer = (SwipeRefreshLayout)finder.castView((View)finder.findRequiredView(object, 2131624169, "field 'mSwipeContainer'"), 2131624169, "field 'mSwipeContainer'");
        return innerUnbinder;
    }

    protected InnerUnbinder<T> createUnbinder(T t2) {
        return new InnerUnbinder<T>(t2);
    }

    public static class InnerUnbinder<T extends GroupDetailsActivity>
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
            t2.groupPosts = null;
            t2.loadingSpinny = null;
            t2.gdHeaderName = null;
            t2.gdJoin = null;
            t2.gdCompose = null;
            t2.groupEmpty = null;
            t2.mSwipeContainer = null;
        }
    }

}

