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
import com.becandid.candid.fragments.onboarding.OnboardingAgeFragment;

public class OnboardingAgeFragment$$ViewBinder<T extends OnboardingAgeFragment>
implements ViewBinder<T> {
    public Unbinder a(Finder finder, T t2, Object object) {
        a<T> a2 = this.a(t2);
        t2.privacy = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624634, "field 'privacy'"), 2131624634, "field 'privacy'");
        t2.skip = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624625, "field 'skip'"), 2131624625, "field 'skip'");
        t2.ageOver = (Button)finder.castView((View)finder.findRequiredView(object, 2131624633, "field 'ageOver'"), 2131624633, "field 'ageOver'");
        t2.ageUnder = (Button)finder.castView((View)finder.findRequiredView(object, 2131624631, "field 'ageUnder'"), 2131624631, "field 'ageUnder'");
        t2.spinny = (FrameLayout)finder.castView((View)finder.findRequiredView(object, 2131624635, "field 'spinny'"), 2131624635, "field 'spinny'");
        t2.ageSubheader = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624627, "field 'ageSubheader'"), 2131624627, "field 'ageSubheader'");
        t2.ageHeader = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624626, "field 'ageHeader'"), 2131624626, "field 'ageHeader'");
        return a2;
    }

    protected a<T> a(T t2) {
        return new a<T>(t2);
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object object, Object object2) {
        return this.a(finder, (T)((Object)((OnboardingAgeFragment)((Object)object))), object2);
    }

    public static class a<T extends OnboardingAgeFragment>
    implements Unbinder {
        private T a;

        protected a(T t2) {
            this.a = t2;
        }

        protected void a(T t2) {
            t2.privacy = null;
            t2.skip = null;
            t2.ageOver = null;
            t2.ageUnder = null;
            t2.spinny = null;
            t2.ageSubheader = null;
            t2.ageHeader = null;
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

