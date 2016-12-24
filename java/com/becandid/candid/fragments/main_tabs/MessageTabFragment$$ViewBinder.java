/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.support.design.widget.TabLayout
 *  android.view.View
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.TextView
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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.fragments.main_tabs.MessageTabFragment;
import com.becandid.candid.views.TabViewPager;

public class MessageTabFragment$$ViewBinder<T extends MessageTabFragment>
implements ViewBinder<T> {
    public Unbinder a(Finder finder, T t2, Object object) {
        a<T> a2 = this.a(t2);
        t2.messagesSearch = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624558, "field 'messagesSearch'"), 2131624558, "field 'messagesSearch'");
        t2.messagesSettings = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624559, "field 'messagesSettings'"), 2131624559, "field 'messagesSettings'");
        t2.tabBar = (TabLayout)finder.castView((View)finder.findRequiredView(object, 2131624560, "field 'tabBar'"), 2131624560, "field 'tabBar'");
        t2.viewPager = (TabViewPager)((Object)finder.castView((View)finder.findRequiredView(object, 2131624561, "field 'viewPager'"), 2131624561, "field 'viewPager'"));
        t2.messagesSpinny = (FrameLayout)finder.castView((View)finder.findRequiredView(object, 2131624563, "field 'messagesSpinny'"), 2131624563, "field 'messagesSpinny'");
        t2.messagingDisabled = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624562, "field 'messagingDisabled'"), 2131624562, "field 'messagingDisabled'");
        t2.messagesContainer = (View)finder.findRequiredView(object, 2131624557, "field 'messagesContainer'");
        return a2;
    }

    protected a<T> a(T t2) {
        return new a<T>(t2);
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object object, Object object2) {
        return this.a(finder, (T)((Object)((MessageTabFragment)((Object)object))), object2);
    }

    public static class a<T extends MessageTabFragment>
    implements Unbinder {
        private T a;

        protected a(T t2) {
            this.a = t2;
        }

        protected void a(T t2) {
            t2.messagesSearch = null;
            t2.messagesSettings = null;
            t2.tabBar = null;
            t2.viewPager = null;
            t2.messagesSpinny = null;
            t2.messagingDisabled = null;
            t2.messagesContainer = null;
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

