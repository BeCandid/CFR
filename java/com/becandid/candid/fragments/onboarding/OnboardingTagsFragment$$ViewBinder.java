/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.Button
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.fragments.onboarding.OnboardingTagsFragment;

public class OnboardingTagsFragment$$ViewBinder<T extends OnboardingTagsFragment>
implements ViewBinder<T> {
    public Unbinder a(Finder finder, T t2, Object object) {
        a<T> a2 = this.a(t2);
        t2.tagContainer = (RelativeLayout)finder.castView((View)finder.findRequiredView(object, 2131624717, "field 'tagContainer'"), 2131624717, "field 'tagContainer'");
        t2.tagSubmit = (Button)finder.castView((View)finder.findRequiredView(object, 2131624719, "field 'tagSubmit'"), 2131624719, "field 'tagSubmit'");
        t2.tagCancel = (Button)finder.castView((View)finder.findRequiredView(object, 2131624718, "field 'tagCancel'"), 2131624718, "field 'tagCancel'");
        t2.tagsHeader = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624714, "field 'tagsHeader'"), 2131624714, "field 'tagsHeader'");
        return a2;
    }

    protected a<T> a(T t2) {
        return new a<T>(t2);
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object object, Object object2) {
        return this.a(finder, (OnboardingTagsFragment)object, object2);
    }

    public static class a<T extends OnboardingTagsFragment>
    implements Unbinder {
        private T a;

        protected a(T t2) {
            this.a = t2;
        }

        protected void a(T t2) {
            t2.tagContainer = null;
            t2.tagSubmit = null;
            t2.tagCancel = null;
            t2.tagsHeader = null;
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

