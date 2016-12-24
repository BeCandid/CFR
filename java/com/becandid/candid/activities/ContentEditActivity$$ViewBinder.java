/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.support.v7.widget.AppCompatEditText
 *  android.view.View
 *  android.widget.Button
 *  android.widget.FrameLayout
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  butterknife.Unbinder
 *  butterknife.internal.Finder
 *  butterknife.internal.ViewBinder
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package com.becandid.candid.activities;

import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.activities.ContentEditActivity;

public class ContentEditActivity$$ViewBinder<T extends ContentEditActivity>
implements ViewBinder<T> {
    public Unbinder bind(Finder finder, T t2, Object object) {
        InnerUnbinder<T> innerUnbinder = this.createUnbinder(t2);
        t2.root = (RelativeLayout)finder.castView((View)finder.findRequiredView(object, 2131624094, "field 'root'"), 2131624094, "field 'root'");
        t2.editContainer = (FrameLayout)finder.castView((View)finder.findRequiredView(object, 2131624100, "field 'editContainer'"), 2131624100, "field 'editContainer'");
        t2.editText = (AppCompatEditText)finder.castView((View)finder.findRequiredView(object, 2131624101, "field 'editText'"), 2131624101, "field 'editText'");
        t2.editSave = (Button)finder.castView((View)finder.findRequiredView(object, 2131624105, "field 'editSave'"), 2131624105, "field 'editSave'");
        t2.editCancel = (Button)finder.castView((View)finder.findRequiredView(object, 2131624104, "field 'editCancel'"), 2131624104, "field 'editCancel'");
        t2.editSpinny = (FrameLayout)finder.castView((View)finder.findRequiredView(object, 2131624106, "field 'editSpinny'"), 2131624106, "field 'editSpinny'");
        t2.editDetails = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624102, "field 'editDetails'"), 2131624102, "field 'editDetails'");
        t2.editHeaderTitle = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624097, "field 'editHeaderTitle'"), 2131624097, "field 'editHeaderTitle'");
        t2.editTitle = (RelativeLayout)finder.castView((View)finder.findRequiredView(object, 2131624095, "field 'editTitle'"), 2131624095, "field 'editTitle'");
        return innerUnbinder;
    }

    protected InnerUnbinder<T> createUnbinder(T t2) {
        return new InnerUnbinder<T>(t2);
    }

    public static class InnerUnbinder<T extends ContentEditActivity>
    implements Unbinder {
        private T a;

        protected InnerUnbinder(T t2) {
            this.a = t2;
        }

        public final void unbind() {
            if (this.a == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.unbind(this.a);
            this.a = null;
        }

        protected void unbind(T t2) {
            t2.root = null;
            t2.editContainer = null;
            t2.editText = null;
            t2.editSave = null;
            t2.editCancel = null;
            t2.editSpinny = null;
            t2.editDetails = null;
            t2.editHeaderTitle = null;
            t2.editTitle = null;
        }
    }

}

