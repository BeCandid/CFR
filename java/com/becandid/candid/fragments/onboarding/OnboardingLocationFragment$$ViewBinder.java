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
import com.becandid.candid.fragments.onboarding.OnboardingLocationFragment;

public class OnboardingLocationFragment$$ViewBinder<T extends OnboardingLocationFragment>
implements ViewBinder<T> {
    public Unbinder a(Finder finder, T t2, Object object) {
        a<T> a2 = this.a(t2);
        t2.privacy = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624676, "field 'privacy'"), 2131624676, "field 'privacy'");
        t2.skip = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624670, "field 'skip'"), 2131624670, "field 'skip'");
        t2.locationButton = (Button)finder.castView((View)finder.findRequiredView(object, 2131624674, "field 'locationButton'"), 2131624674, "field 'locationButton'");
        t2.spinny = (FrameLayout)finder.castView((View)finder.findRequiredView(object, 2131624677, "field 'spinny'"), 2131624677, "field 'spinny'");
        t2.locationSubheader = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624672, "field 'locationSubheader'"), 2131624672, "field 'locationSubheader'");
        t2.locationInfo = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624675, "field 'locationInfo'"), 2131624675, "field 'locationInfo'");
        t2.locationHeader = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624671, "field 'locationHeader'"), 2131624671, "field 'locationHeader'");
        return a2;
    }

    protected a<T> a(T t2) {
        return new a<T>(t2);
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object object, Object object2) {
        return this.a(finder, (T)((Object)((OnboardingLocationFragment)((Object)object))), object2);
    }

    public static class a<T extends OnboardingLocationFragment>
    implements Unbinder {
        private T a;

        protected a(T t2) {
            this.a = t2;
        }

        protected void a(T t2) {
            t2.privacy = null;
            t2.skip = null;
            t2.locationButton = null;
            t2.spinny = null;
            t2.locationSubheader = null;
            t2.locationInfo = null;
            t2.locationHeader = null;
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

