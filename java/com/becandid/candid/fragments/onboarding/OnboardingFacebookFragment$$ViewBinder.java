/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.View
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
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.fragments.onboarding.OnboardingFacebookFragment;

public class OnboardingFacebookFragment$$ViewBinder<T extends OnboardingFacebookFragment>
implements ViewBinder<T> {
    public Unbinder a(Finder finder, T t2, Object object) {
        a<T> a2 = this.a(t2);
        t2.fbPrivacy = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624667, "field 'fbPrivacy'"), 2131624667, "field 'fbPrivacy'");
        t2.skip = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624642, "field 'skip'"), 2131624642, "field 'skip'");
        t2.fbButton = (RelativeLayout)finder.castView((View)finder.findRequiredView(object, 2131624662, "field 'fbButton'"), 2131624662, "field 'fbButton'");
        t2.spinny = (FrameLayout)finder.castView((View)finder.findRequiredView(object, 2131624668, "field 'spinny'"), 2131624668, "field 'spinny'");
        t2.fbInfo = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624665, "field 'fbInfo'"), 2131624665, "field 'fbInfo'");
        t2.fbInfo2 = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624666, "field 'fbInfo2'"), 2131624666, "field 'fbInfo2'");
        t2.fbSubheader = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624644, "field 'fbSubheader'"), 2131624644, "field 'fbSubheader'");
        t2.fbHeader = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624643, "field 'fbHeader'"), 2131624643, "field 'fbHeader'");
        return a2;
    }

    protected a<T> a(T t2) {
        return new a<T>(t2);
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object object, Object object2) {
        return this.a(finder, (T)((Object)((OnboardingFacebookFragment)((Object)object))), object2);
    }

    public static class a<T extends OnboardingFacebookFragment>
    implements Unbinder {
        private T a;

        protected a(T t2) {
            this.a = t2;
        }

        protected void a(T t2) {
            t2.fbPrivacy = null;
            t2.skip = null;
            t2.fbButton = null;
            t2.spinny = null;
            t2.fbInfo = null;
            t2.fbInfo2 = null;
            t2.fbSubheader = null;
            t2.fbHeader = null;
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

