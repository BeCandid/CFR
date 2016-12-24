/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
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
import android.widget.Button;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.fragments.InviteContactMethodFragment;

public class InviteContactMethodFragment$$ViewBinder<T extends InviteContactMethodFragment>
implements ViewBinder<T> {
    public Unbinder a(Finder finder, T t2, Object object) {
        View view;
        a<T> a2 = this.a(t2);
        t2.mAnonPlaceHolder = (View)finder.findRequiredView(object, 2131624449, "field 'mAnonPlaceHolder'");
        t2.mKnownPlaceHolder = (View)finder.findRequiredView(object, 2131624452, "field 'mKnownPlaceHolder'");
        t2.mContinueBtn = (Button)finder.castView((View)finder.findRequiredView(object, 2131624455, "field 'mContinueBtn'"), 2131624455, "field 'mContinueBtn'");
        t2.mAnonCheckmark = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624450, "field 'mAnonCheckmark'"), 2131624450, "field 'mAnonCheckmark'");
        t2.mKnownCheckmark = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624453, "field 'mKnownCheckmark'"), 2131624453, "field 'mKnownCheckmark'");
        a2.a = view = (View)finder.findRequiredView(object, 2131624445, "method 'onContactClose'");
        view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener((InviteContactMethodFragment)((Object)t2)){
            final /* synthetic */ InviteContactMethodFragment a;

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
        return this.a(finder, (T)((Object)((InviteContactMethodFragment)((Object)object))), object2);
    }

    public static class a<T extends InviteContactMethodFragment>
    implements Unbinder {
        View a;
        private T b;

        protected a(T t2) {
            this.b = t2;
        }

        protected void a(T t2) {
            t2.mAnonPlaceHolder = null;
            t2.mKnownPlaceHolder = null;
            t2.mContinueBtn = null;
            t2.mAnonCheckmark = null;
            t2.mKnownCheckmark = null;
            this.a.setOnClickListener(null);
        }

        public final void unbind() {
            if (this.b == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a(this.b);
            this.b = null;
        }
    }

}

