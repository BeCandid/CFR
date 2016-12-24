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
import com.becandid.candid.fragments.main_tabs.GroupTabFragment;
import com.becandid.candid.views.GroupStackView;

public class GroupTabFragment$$ViewBinder<T extends GroupTabFragment>
implements ViewBinder<T> {
    public Unbinder a(Finder finder, T t2, Object object) {
        a<T> a2 = this.a(t2);
        t2.groupStackView = (GroupStackView)((Object)finder.castView((View)finder.findRequiredView(object, 2131624514, "field 'groupStackView'"), 2131624514, "field 'groupStackView'"));
        t2.tabBar = (TabLayout)finder.castView((View)finder.findRequiredView(object, 2131624507, "field 'tabBar'"), 2131624507, "field 'tabBar'");
        t2.loading = (View)finder.findOptionalView(object, 2131624513, null);
        t2.forYouEmpty = (View)finder.findOptionalView(object, 2131624508, null);
        t2.discoverEmpty = (View)finder.findOptionalView(object, 2131624512, null);
        return a2;
    }

    protected a<T> a(T t2) {
        return new a<T>(t2);
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object object, Object object2) {
        return this.a(finder, (GroupTabFragment)object, object2);
    }

    public static class a<T extends GroupTabFragment>
    implements Unbinder {
        private T a;

        protected a(T t2) {
            this.a = t2;
        }

        protected void a(T t2) {
            t2.groupStackView = null;
            t2.tabBar = null;
            t2.loading = null;
            t2.forYouEmpty = null;
            t2.discoverEmpty = null;
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

