/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.Button
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  butterknife.Unbinder
 *  butterknife.internal.Finder
 *  butterknife.internal.ViewBinder
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package com.becandid.candid.activities;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.activities.OnboardingGroupsActivity;
import com.becandid.candid.views.GroupStackView;

public class OnboardingGroupsActivity$$ViewBinder<T extends OnboardingGroupsActivity>
implements ViewBinder<T> {
    public Unbinder bind(Finder finder, T t2, Object object) {
        InnerUnbinder<T> innerUnbinder = this.createUnbinder(t2);
        t2.ogStack = (GroupStackView)((Object)finder.castView((View)finder.findRequiredView(object, 2131624259, "field 'ogStack'"), 2131624259, "field 'ogStack'"));
        t2.ogButton = (Button)finder.castView((View)finder.findRequiredView(object, 2131624260, "field 'ogButton'"), 2131624260, "field 'ogButton'");
        t2.ogSpinny = (LinearLayout)finder.castView((View)finder.findRequiredView(object, 2131624261, "field 'ogSpinny'"), 2131624261, "field 'ogSpinny'");
        t2.ogEmpty = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624262, "field 'ogEmpty'"), 2131624262, "field 'ogEmpty'");
        t2.ogHeader = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624258, "field 'ogHeader'"), 2131624258, "field 'ogHeader'");
        return innerUnbinder;
    }

    protected InnerUnbinder<T> createUnbinder(T t2) {
        return new InnerUnbinder<T>(t2);
    }

    public static class InnerUnbinder<T extends OnboardingGroupsActivity>
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
            t2.ogStack = null;
            t2.ogButton = null;
            t2.ogSpinny = null;
            t2.ogEmpty = null;
            t2.ogHeader = null;
        }
    }

}

