/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.support.v7.widget.AppCompatEditText
 *  android.view.View
 *  android.widget.Button
 *  android.widget.ImageView
 *  butterknife.Unbinder
 *  butterknife.internal.Finder
 *  butterknife.internal.ViewBinder
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package com.becandid.candid.fragments;

import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.fragments.InviteContactNameFragment;

public class InviteContactNameFragment$$ViewBinder<T extends InviteContactNameFragment>
implements ViewBinder<T> {
    public Unbinder a(Finder finder, T t2, Object object) {
        a<T> a2 = this.a(t2);
        t2.mBackNav = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624067, "field 'mBackNav'"), 2131624067, "field 'mBackNav'");
        t2.mInviteName = (AppCompatEditText)finder.castView((View)finder.findRequiredView(object, 2131624459, "field 'mInviteName'"), 2131624459, "field 'mInviteName'");
        t2.mSendText = (Button)finder.castView((View)finder.findRequiredView(object, 2131624460, "field 'mSendText'"), 2131624460, "field 'mSendText'");
        return a2;
    }

    protected a<T> a(T t2) {
        return new a<T>(t2);
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object object, Object object2) {
        return this.a(finder, (T)((Object)((InviteContactNameFragment)((Object)object))), object2);
    }

    public static class a<T extends InviteContactNameFragment>
    implements Unbinder {
        private T a;

        protected a(T t2) {
            this.a = t2;
        }

        protected void a(T t2) {
            t2.mBackNav = null;
            t2.mInviteName = null;
            t2.mSendText = null;
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

