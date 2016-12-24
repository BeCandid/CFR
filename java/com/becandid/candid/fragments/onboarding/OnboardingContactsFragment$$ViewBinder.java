/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.Button
 *  android.widget.FrameLayout
 *  android.widget.TextView
 *  butterknife.Unbinder
 *  butterknife.internal.Finder
 *  butterknife.internal.ViewBinder
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package com.becandid.candid.fragments.onboarding;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.fragments.onboarding.OnboardingContactsFragment;

public class OnboardingContactsFragment$$ViewBinder<T extends OnboardingContactsFragment>
implements ViewBinder<T> {
    public Unbinder a(Finder finder, T t2, Object object) {
        a<T> a2 = this.a(t2);
        t2.skip = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624637, "field 'skip'"), 2131624637, "field 'skip'");
        t2.contactsButton = (Button)finder.castView((View)finder.findRequiredView(object, 2131624640, "field 'contactsButton'"), 2131624640, "field 'contactsButton'");
        t2.contactsSubheader = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624638, "field 'contactsSubheader'"), 2131624638, "field 'contactsSubheader'");
        t2.contactsSubheader2 = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624639, "field 'contactsSubheader2'"), 2131624639, "field 'contactsSubheader2'");
        t2.contactsHeader = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624089, "field 'contactsHeader'"), 2131624089, "field 'contactsHeader'");
        t2.spinny = (FrameLayout)finder.castView((View)finder.findRequiredView(object, 2131624093, "field 'spinny'"), 2131624093, "field 'spinny'");
        return a2;
    }

    protected a<T> a(T t2) {
        return new a<T>(t2);
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object object, Object object2) {
        return this.a(finder, (T)((Object)((OnboardingContactsFragment)((Object)object))), object2);
    }

    public static class a<T extends OnboardingContactsFragment>
    implements Unbinder {
        private T a;

        protected a(T t2) {
            this.a = t2;
        }

        protected void a(T t2) {
            t2.skip = null;
            t2.contactsButton = null;
            t2.contactsSubheader = null;
            t2.contactsSubheader2 = null;
            t2.contactsHeader = null;
            t2.spinny = null;
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

