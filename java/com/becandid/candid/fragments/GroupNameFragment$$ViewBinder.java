/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.Button
 *  android.widget.EditText
 *  android.widget.TextView
 *  butterknife.Unbinder
 *  butterknife.internal.Finder
 *  butterknife.internal.ViewBinder
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package com.becandid.candid.fragments;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.fragments.GroupNameFragment;

public class GroupNameFragment$$ViewBinder<T extends GroupNameFragment>
implements ViewBinder<T> {
    public Unbinder a(Finder finder, T t2, Object object) {
        a<T> a2 = this.a(t2);
        t2.groupNameHeader = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624435, "field 'groupNameHeader'"), 2131624435, "field 'groupNameHeader'");
        t2.groupNameInfo = (EditText)finder.castView((View)finder.findRequiredView(object, 2131624110, "field 'groupNameInfo'"), 2131624110, "field 'groupNameInfo'");
        t2.nextBtn = (Button)finder.castView((View)finder.findRequiredView(object, 2131624436, "field 'nextBtn'"), 2131624436, "field 'nextBtn'");
        t2.mNamePlaceholder = (View)finder.findRequiredView(object, 2131624434, "field 'mNamePlaceholder'");
        t2.mProgressBar = (View)finder.findRequiredView(object, 2131624191, "field 'mProgressBar'");
        return a2;
    }

    protected a<T> a(T t2) {
        return new a<T>(t2);
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object object, Object object2) {
        return this.a(finder, (T)((Object)((GroupNameFragment)((Object)object))), object2);
    }

    public static class a<T extends GroupNameFragment>
    implements Unbinder {
        private T a;

        protected a(T t2) {
            this.a = t2;
        }

        protected void a(T t2) {
            t2.groupNameHeader = null;
            t2.groupNameInfo = null;
            t2.nextBtn = null;
            t2.mNamePlaceholder = null;
            t2.mProgressBar = null;
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

