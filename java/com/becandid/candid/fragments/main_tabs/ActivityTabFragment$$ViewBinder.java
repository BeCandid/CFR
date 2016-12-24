/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.support.v4.widget.SwipeRefreshLayout
 *  android.support.v7.widget.RecyclerView
 *  android.view.View
 *  butterknife.Unbinder
 *  butterknife.internal.Finder
 *  butterknife.internal.ViewBinder
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package com.becandid.candid.fragments.main_tabs;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.fragments.main_tabs.ActivityTabFragment;

public class ActivityTabFragment$$ViewBinder<T extends ActivityTabFragment>
implements ViewBinder<T> {
    public Unbinder a(Finder finder, T t2, Object object) {
        a<T> a2 = this.a(t2);
        t2.mSwipeRefresh = (SwipeRefreshLayout)finder.castView((View)finder.findRequiredView(object, 2131624296, "field 'mSwipeRefresh'"), 2131624296, "field 'mSwipeRefresh'");
        t2.mRecyclerView = (RecyclerView)finder.castView((View)finder.findRequiredView(object, 2131624297, "field 'mRecyclerView'"), 2131624297, "field 'mRecyclerView'");
        t2.mEmptyView = (View)finder.findRequiredView(object, 2131624298, "field 'mEmptyView'");
        t2.mSettingView = (View)finder.findRequiredView(object, 2131624295, "field 'mSettingView'");
        return a2;
    }

    protected a<T> a(T t2) {
        return new a<T>(t2);
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object object, Object object2) {
        return this.a(finder, (T)((Object)((ActivityTabFragment)((Object)object))), object2);
    }

    public static class a<T extends ActivityTabFragment>
    implements Unbinder {
        private T a;

        protected a(T t2) {
            this.a = t2;
        }

        protected void a(T t2) {
            t2.mSwipeRefresh = null;
            t2.mRecyclerView = null;
            t2.mEmptyView = null;
            t2.mSettingView = null;
        }

        public final void unbind() {
            if (this.a == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a(this.a);
            this.a = null;
        }
    }

}

