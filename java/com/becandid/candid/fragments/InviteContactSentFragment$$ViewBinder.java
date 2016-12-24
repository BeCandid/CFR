/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
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
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.fragments.InviteContactSentFragment;

public class InviteContactSentFragment$$ViewBinder<T extends InviteContactSentFragment>
implements ViewBinder<T> {
    public Unbinder a(Finder finder, T t2, Object object) {
        View view;
        View view2;
        a<T> a2 = this.a(t2);
        a2.a = view2 = (View)finder.findRequiredView(object, 2131624445, "method 'onContactClose'");
        view2.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener((InviteContactSentFragment)((Object)t2)){
            final /* synthetic */ InviteContactSentFragment a;

            public void doClick(View view) {
                this.a.onContactClose();
            }
        });
        a2.b = view = (View)finder.findRequiredView(object, 2131624470, "method 'onClose'");
        view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener((InviteContactSentFragment)((Object)t2)){
            final /* synthetic */ InviteContactSentFragment a;

            public void doClick(View view) {
                this.a.onClose();
            }
        });
        return a2;
    }

    protected a<T> a(T t2) {
        return new a<T>(t2);
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object object, Object object2) {
        return this.a(finder, (T)((Object)((InviteContactSentFragment)((Object)object))), object2);
    }

    public static class a<T extends InviteContactSentFragment>
    implements Unbinder {
        View a;
        View b;
        private T c;

        protected a(T t2) {
            this.c = t2;
        }

        protected void a(T t2) {
            this.a.setOnClickListener(null);
            this.b.setOnClickListener(null);
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

