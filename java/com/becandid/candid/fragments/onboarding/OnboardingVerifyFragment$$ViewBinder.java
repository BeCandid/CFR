/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.Button
 *  android.widget.EditText
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
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.fragments.onboarding.OnboardingVerifyFragment;

public class OnboardingVerifyFragment$$ViewBinder<T extends OnboardingVerifyFragment>
implements ViewBinder<T> {
    public Unbinder a(Finder finder, T t2, Object object) {
        a<T> a2 = this.a(t2);
        t2.resend = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624726, "field 'resend'"), 2131624726, "field 'resend'");
        t2.verify = (EditText)finder.castView((View)finder.findRequiredView(object, 2131624724, "field 'verify'"), 2131624724, "field 'verify'");
        t2.submit = (Button)finder.castView((View)finder.findRequiredView(object, 2131624725, "field 'submit'"), 2131624725, "field 'submit'");
        t2.verifySubheader = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624722, "field 'verifySubheader'"), 2131624722, "field 'verifySubheader'");
        t2.verifyHeader = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624721, "field 'verifyHeader'"), 2131624721, "field 'verifyHeader'");
        t2.spinny = (FrameLayout)finder.castView((View)finder.findRequiredView(object, 2131624727, "field 'spinny'"), 2131624727, "field 'spinny'");
        return a2;
    }

    protected a<T> a(T t2) {
        return new a<T>(t2);
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object object, Object object2) {
        return this.a(finder, (T)((Object)((OnboardingVerifyFragment)((Object)object))), object2);
    }

    public static class a<T extends OnboardingVerifyFragment>
    implements Unbinder {
        private T a;

        protected a(T t2) {
            this.a = t2;
        }

        protected void a(T t2) {
            t2.resend = null;
            t2.verify = null;
            t2.submit = null;
            t2.verifySubheader = null;
            t2.verifyHeader = null;
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

