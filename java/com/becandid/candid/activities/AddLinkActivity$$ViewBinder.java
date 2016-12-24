/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.EditText
 *  android.widget.TextView
 *  butterknife.Unbinder
 *  butterknife.internal.DebouncingOnClickListener
 *  butterknife.internal.Finder
 *  butterknife.internal.ViewBinder
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package com.becandid.candid.activities;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.activities.AddLinkActivity;

public class AddLinkActivity$$ViewBinder<T extends AddLinkActivity>
implements ViewBinder<T> {
    public Unbinder bind(Finder finder, T t2, Object object) {
        View view;
        View view2;
        InnerUnbinder<T> innerUnbinder = this.createUnbinder(t2);
        t2.copiedLink = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624070, "field 'copiedLink'"), 2131624070, "field 'copiedLink'");
        t2.typedLink = (EditText)finder.castView((View)finder.findRequiredView(object, 2131624068, "field 'typedLink'"), 2131624068, "field 'typedLink'");
        t2.spinny = (View)finder.findRequiredView(object, 2131624072, "field 'spinny'");
        innerUnbinder.a = view2 = (View)finder.findRequiredView(object, 2131624069, "method 'chooseTypedLink'");
        view2.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener((AddLinkActivity)t2){
            final /* synthetic */ AddLinkActivity a;

            public void doClick(View view) {
                this.a.chooseTypedLink(view);
            }
        });
        innerUnbinder.b = view = (View)finder.findRequiredView(object, 2131624071, "method 'chooseCopiedLink'");
        view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener((AddLinkActivity)t2){
            final /* synthetic */ AddLinkActivity a;

            public void doClick(View view) {
                this.a.chooseCopiedLink(view);
            }
        });
        return innerUnbinder;
    }

    protected InnerUnbinder<T> createUnbinder(T t2) {
        return new InnerUnbinder<T>(t2);
    }

    public static class InnerUnbinder<T extends AddLinkActivity>
    implements Unbinder {
        View a;
        View b;
        private T c;

        protected InnerUnbinder(T t2) {
            this.c = t2;
        }

        public final void unbind() {
            if (this.c == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.unbind(this.c);
            this.c = null;
        }

        protected void unbind(T t2) {
            t2.copiedLink = null;
            t2.typedLink = null;
            t2.spinny = null;
            this.a.setOnClickListener(null);
            this.b.setOnClickListener(null);
        }
    }

}

