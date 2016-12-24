/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  butterknife.Unbinder
 *  butterknife.internal.DebouncingOnClickListener
 *  butterknife.internal.Finder
 *  butterknife.internal.ViewBinder
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package com.becandid.candid.fragments.main_tabs;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.fragments.main_tabs.MeTabFragment;
import com.becandid.candid.views.TabViewPager;

public class MeTabFragment$$ViewBinder<T extends MeTabFragment>
implements ViewBinder<T> {
    public Unbinder a(Finder finder, T t2, Object object) {
        View view;
        View view2;
        a<T> a2 = this.a(t2);
        t2.mPostsCount = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624817, "field 'mPostsCount'"), 2131624817, "field 'mPostsCount'");
        t2.mGroupsCount = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624818, "field 'mGroupsCount'"), 2131624818, "field 'mGroupsCount'");
        t2.mNumContacts = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624816, "field 'mNumContacts'"), 2131624816, "field 'mNumContacts'");
        t2.mNumFriends = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624815, "field 'mNumFriends'"), 2131624815, "field 'mNumFriends'");
        t2.connectFb = view2 = (View)finder.findRequiredView(object, 2131624821, "field 'connectFb' and method 'connectFB'");
        a2.a = view2;
        view2.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener((MeTabFragment)t2){
            final /* synthetic */ MeTabFragment a;

            public void doClick(View view) {
                this.a.connectFB(view);
            }
        });
        t2.connectContact = view = (View)finder.findRequiredView(object, 2131624820, "field 'connectContact' and method 'connectContacts'");
        a2.b = view;
        view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener((MeTabFragment)t2){
            final /* synthetic */ MeTabFragment a;

            public void doClick(View view) {
                this.a.connectContacts(view);
            }
        });
        t2.mBadgeIcon = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624079, "field 'mBadgeIcon'"), 2131624079, "field 'mBadgeIcon'");
        t2.mBadgeTitle = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624076, "field 'mBadgeTitle'"), 2131624076, "field 'mBadgeTitle'");
        t2.buttonPanel = (LinearLayout)finder.castView((View)finder.findRequiredView(object, 2131624819, "field 'buttonPanel'"), 2131624819, "field 'buttonPanel'");
        t2.mBadgeInfoContainer = (FrameLayout)finder.castView((View)finder.findRequiredView(object, 2131624287, "field 'mBadgeInfoContainer'"), 2131624287, "field 'mBadgeInfoContainer'");
        t2.mProfileContainer = (View)finder.findRequiredView(object, 2131624809, "field 'mProfileContainer'");
        t2.viewPager = (TabViewPager)((Object)finder.castView((View)finder.findRequiredView(object, 2131624823, "field 'viewPager'"), 2131624823, "field 'viewPager'"));
        t2.mQualityScore = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624813, "field 'mQualityScore'"), 2131624813, "field 'mQualityScore'");
        t2.mProfileSpinny = (View)finder.findRequiredView(object, 2131624824, "field 'mProfileSpinny'");
        return a2;
    }

    protected a<T> a(T t2) {
        return new a<T>(t2);
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object object, Object object2) {
        return this.a(finder, (MeTabFragment)object, object2);
    }

    public static class a<T extends MeTabFragment>
    implements Unbinder {
        View a;
        View b;
        private T c;

        protected a(T t2) {
            this.c = t2;
        }

        protected void a(T t2) {
            t2.mPostsCount = null;
            t2.mGroupsCount = null;
            t2.mNumContacts = null;
            t2.mNumFriends = null;
            this.a.setOnClickListener(null);
            t2.connectFb = null;
            this.b.setOnClickListener(null);
            t2.connectContact = null;
            t2.mBadgeIcon = null;
            t2.mBadgeTitle = null;
            t2.buttonPanel = null;
            t2.mBadgeInfoContainer = null;
            t2.mProfileContainer = null;
            t2.viewPager = null;
            t2.mQualityScore = null;
            t2.mProfileSpinny = null;
        }

        public final void unbind() {
            if (this.c == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a(this.c);
            this.c = null;
        }
    }

}

