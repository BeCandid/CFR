/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.support.v7.widget.RecyclerView
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  android.widget.EditText
 *  android.widget.FrameLayout
 *  butterknife.Unbinder
 *  butterknife.internal.DebouncingOnClickListener
 *  butterknife.internal.Finder
 *  butterknife.internal.ViewBinder
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package com.becandid.candid.activities;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.activities.ChooseContactsActivity;

public class ChooseContactsActivity$$ViewBinder<T extends ChooseContactsActivity>
implements ViewBinder<T> {
    public Unbinder bind(Finder finder, T t2, Object object) {
        InnerUnbinder<T> innerUnbinder = this.createUnbinder(t2);
        t2.recyclerView = (RecyclerView)finder.castView((View)finder.findRequiredView(object, 2131624088, "field 'recyclerView'"), 2131624088, "field 'recyclerView'");
        t2.contactsSearchOuter = (FrameLayout)finder.castView((View)finder.findRequiredView(object, 2131624090, "field 'contactsSearchOuter'"), 2131624090, "field 'contactsSearchOuter'");
        t2.search = (EditText)finder.castView((View)finder.findRequiredView(object, 2131624091, "field 'search'"), 2131624091, "field 'search'");
        View view = (View)finder.findRequiredView(object, 2131624092, "field 'sendInvites' and method 'sendInvites'");
        t2.sendInvites = (Button)finder.castView(view, 2131624092, "field 'sendInvites'");
        innerUnbinder.a = view;
        view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener((ChooseContactsActivity)t2){
            final /* synthetic */ ChooseContactsActivity a;

            public void doClick(View view) {
                this.a.sendInvites(view);
            }
        });
        return innerUnbinder;
    }

    protected InnerUnbinder<T> createUnbinder(T t2) {
        return new InnerUnbinder<T>(t2);
    }

    public static class InnerUnbinder<T extends ChooseContactsActivity>
    implements Unbinder {
        View a;
        private T b;

        protected InnerUnbinder(T t2) {
            this.b = t2;
        }

        public final void unbind() {
            if (this.b == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.unbind(this.b);
            this.b = null;
        }

        protected void unbind(T t2) {
            t2.recyclerView = null;
            t2.contactsSearchOuter = null;
            t2.search = null;
            this.a.setOnClickListener(null);
            t2.sendInvites = null;
        }
    }

}

