/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.EditText
 *  android.widget.RadioGroup
 *  butterknife.Unbinder
 *  butterknife.internal.Finder
 *  butterknife.internal.ViewBinder
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package com.becandid.candid.activities;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.activities.ChangeEndpointActivity;

public class ChangeEndpointActivity$$ViewBinder<T extends ChangeEndpointActivity>
implements ViewBinder<T> {
    public Unbinder bind(Finder finder, T t2, Object object) {
        InnerUnbinder<T> innerUnbinder = this.createUnbinder(t2);
        t2.mRadioGroup = (RadioGroup)finder.castView((View)finder.findRequiredView(object, 2131624084, "field 'mRadioGroup'"), 2131624084, "field 'mRadioGroup'");
        t2.mEndpointText = (EditText)finder.castView((View)finder.findRequiredView(object, 2131624083, "field 'mEndpointText'"), 2131624083, "field 'mEndpointText'");
        return innerUnbinder;
    }

    protected InnerUnbinder<T> createUnbinder(T t2) {
        return new InnerUnbinder<T>(t2);
    }

    public static class InnerUnbinder<T extends ChangeEndpointActivity>
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
            t2.mRadioGroup = null;
            t2.mEndpointText = null;
        }
    }

}

