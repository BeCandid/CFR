/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.Button
 *  android.widget.EditText
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
package com.becandid.candid.fragments.onboarding;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.fragments.onboarding.OnboardingPhoneFragment;

public class OnboardingPhoneFragment$$ViewBinder<T extends OnboardingPhoneFragment>
implements ViewBinder<T> {
    public Unbinder a(Finder finder, T t2, Object object) {
        a<T> a2 = this.a(t2);
        t2.phonePrivacy = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624711, "field 'phonePrivacy'"), 2131624711, "field 'phonePrivacy'");
        t2.phone = (EditText)finder.castView((View)finder.findRequiredView(object, 2131624684, "field 'phone'"), 2131624684, "field 'phone'");
        t2.skip = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624679, "field 'skip'"), 2131624679, "field 'skip'");
        t2.countryCode = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624683, "field 'countryCode'"), 2131624683, "field 'countryCode'");
        t2.spinny = (FrameLayout)finder.castView((View)finder.findRequiredView(object, 2131624712, "field 'spinny'"), 2131624712, "field 'spinny'");
        t2.phoneSubmit = (Button)finder.castView((View)finder.findRequiredView(object, 2131624685, "field 'phoneSubmit'"), 2131624685, "field 'phoneSubmit'");
        t2.wrapper = (RelativeLayout)finder.castView((View)finder.findRequiredView(object, 2131624686, "field 'wrapper'"), 2131624686, "field 'wrapper'");
        t2.phoneInfo = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624710, "field 'phoneInfo'"), 2131624710, "field 'phoneInfo'");
        t2.phoneSubheader = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624681, "field 'phoneSubheader'"), 2131624681, "field 'phoneSubheader'");
        t2.phoneHeader = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624680, "field 'phoneHeader'"), 2131624680, "field 'phoneHeader'");
        return a2;
    }

    protected a<T> a(T t2) {
        return new a<T>(t2);
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object object, Object object2) {
        return this.a(finder, (T)((Object)((OnboardingPhoneFragment)((Object)object))), object2);
    }

    public static class a<T extends OnboardingPhoneFragment>
    implements Unbinder {
        private T a;

        protected a(T t2) {
            this.a = t2;
        }

        protected void a(T t2) {
            t2.phonePrivacy = null;
            t2.phone = null;
            t2.skip = null;
            t2.countryCode = null;
            t2.spinny = null;
            t2.phoneSubmit = null;
            t2.wrapper = null;
            t2.phoneInfo = null;
            t2.phoneSubheader = null;
            t2.phoneHeader = null;
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

