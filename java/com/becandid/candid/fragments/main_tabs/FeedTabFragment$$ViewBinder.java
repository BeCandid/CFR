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
package com.becandid.candid.fragments.main_tabs;

import android.support.design.widget.TabLayout;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.fragments.main_tabs.FeedTabFragment;
import com.becandid.candid.views.TabViewPager;

public class FeedTabFragment$$ViewBinder<T extends FeedTabFragment>
implements ViewBinder<T> {
    public Unbinder a(Finder finder, T t2, Object object) {
        a<T> a2 = this.a(t2);
        t2.mFeedTabs = (TabLayout)finder.castView((View)finder.findRequiredView(object, 2131624422, "field 'mFeedTabs'"), 2131624422, "field 'mFeedTabs'");
        t2.mNewPostsText = (View)finder.findRequiredView(object, 2131624424, "field 'mNewPostsText'");
        t2.viewPager = (TabViewPager)((Object)finder.castView((View)finder.findRequiredView(object, 2131624423, "field 'viewPager'"), 2131624423, "field 'viewPager'"));
        t2.mFeedTab = (View)finder.findRequiredView(object, 2131624421, "field 'mFeedTab'");
        return a2;
    }

    protected a<T> a(T t2) {
        return new a<T>(t2);
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object object, Object object2) {
        return this.a(finder, (T)((Object)((FeedTabFragment)((Object)object))), object2);
    }

    public static class a<T extends FeedTabFragment>
    implements Unbinder {
        private T a;

        protected a(T t2) {
            this.a = t2;
        }

        protected void a(T t2) {
            t2.mFeedTabs = null;
            t2.mNewPostsText = null;
            t2.viewPager = null;
            t2.mFeedTab = null;
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

