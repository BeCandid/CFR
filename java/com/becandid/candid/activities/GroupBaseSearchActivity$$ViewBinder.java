/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.support.v7.widget.RecyclerView
 *  android.view.View
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
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.activities.GroupBaseSearchActivity;

public class GroupBaseSearchActivity$$ViewBinder<T extends GroupBaseSearchActivity>
implements ViewBinder<T> {
    public Unbinder bind(Finder finder, T t2, Object object) {
        InnerUnbinder<T> innerUnbinder = this.createUnbinder(t2);
        t2.mSearchResultRecyclerView = (RecyclerView)finder.castView((View)finder.findRequiredView(object, 2131624164, "field 'mSearchResultRecyclerView'"), 2131624164, "field 'mSearchResultRecyclerView'");
        t2.mSearchEmpty = (View)finder.findRequiredView(object, 2131624165, "field 'mSearchEmpty'");
        t2.mSearchProgressBar = (View)finder.findRequiredView(object, 2131624167, "field 'mSearchProgressBar'");
        return innerUnbinder;
    }

    protected InnerUnbinder<T> createUnbinder(T t2) {
        return new InnerUnbinder<T>(t2);
    }

    public static class InnerUnbinder<T extends GroupBaseSearchActivity>
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
            t2.mSearchResultRecyclerView = null;
            t2.mSearchEmpty = null;
            t2.mSearchProgressBar = null;
        }
    }

}

