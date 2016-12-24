/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  butterknife.Unbinder
 *  butterknife.internal.DebouncingOnClickListener
 *  butterknife.internal.Finder
 *  butterknife.internal.ViewBinder
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package com.becandid.candid.fragments;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.fragments.InviteContactPeopleFragment;

public class InviteContactPeopleFragment$$ViewBinder<T extends InviteContactPeopleFragment>
implements ViewBinder<T> {
    public Unbinder a(Finder finder, T t2, Object object) {
        View view;
        View view2;
        View view3;
        a<T> a2 = this.a(t2);
        t2.mPostSnippet = (FrameLayout)finder.castView((View)finder.findRequiredView(object, 2131624461, "field 'mPostSnippet'"), 2131624461, "field 'mPostSnippet'");
        t2.mEntirePostSnippet = (FrameLayout)finder.castView((View)finder.findRequiredView(object, 2131624466, "field 'mEntirePostSnippet'"), 2131624466, "field 'mEntirePostSnippet'");
        t2.mPostPlaceholder = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624463, "field 'mPostPlaceholder'"), 2131624463, "field 'mPostPlaceholder'");
        t2.mPostPreview = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624462, "field 'mPostPreview'"), 2131624462, "field 'mPostPreview'");
        a2.a = view3 = (View)finder.findRequiredView(object, 2131624464, "method 'inviteAll'");
        view3.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener((InviteContactPeopleFragment)((Object)t2)){
            final /* synthetic */ InviteContactPeopleFragment a;

            public void doClick(View view) {
                this.a.inviteAll(view);
            }
        });
        a2.b = view2 = (View)finder.findRequiredView(object, 2131624465, "method 'chooseContacts'");
        view2.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener((InviteContactPeopleFragment)((Object)t2)){
            final /* synthetic */ InviteContactPeopleFragment a;

            public void doClick(View view) {
                this.a.chooseContacts(view);
            }
        });
        a2.c = view = (View)finder.findRequiredView(object, 2131624445, "method 'onContactClose'");
        view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener((InviteContactPeopleFragment)((Object)t2)){
            final /* synthetic */ InviteContactPeopleFragment a;

            public void doClick(View view) {
                this.a.onContactClose();
            }
        });
        return a2;
    }

    protected a<T> a(T t2) {
        return new a<T>(t2);
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object object, Object object2) {
        return this.a(finder, (T)((Object)((InviteContactPeopleFragment)((Object)object))), object2);
    }

    public static class a<T extends InviteContactPeopleFragment>
    implements Unbinder {
        View a;
        View b;
        View c;
        private T d;

        protected a(T t2) {
            this.d = t2;
        }

        protected void a(T t2) {
            t2.mPostSnippet = null;
            t2.mEntirePostSnippet = null;
            t2.mPostPlaceholder = null;
            t2.mPostPreview = null;
            this.a.setOnClickListener(null);
            this.b.setOnClickListener(null);
            this.c.setOnClickListener(null);
        }

        public final void unbind() {
            if (this.d == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a(this.d);
            this.d = null;
        }
    }

}

