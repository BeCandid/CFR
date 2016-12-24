/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.Button
 *  android.widget.RelativeLayout
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
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.fragments.GroupTagsFragment;

public class GroupTagsFragment$$ViewBinder<T extends GroupTagsFragment>
implements ViewBinder<T> {
    public Unbinder a(Finder finder, T t2, Object object) {
        a<T> a2 = this.a(t2);
        t2.mTagsView = (RelativeLayout)finder.castView((View)finder.findRequiredView(object, 2131624440, "field 'mTagsView'"), 2131624440, "field 'mTagsView'");
        t2.mCreateGroupBtn = (Button)finder.castView((View)finder.findRequiredView(object, 2131624442, "field 'mCreateGroupBtn'"), 2131624442, "field 'mCreateGroupBtn'");
        t2.mProgressBar = (View)finder.findRequiredView(object, 2131624191, "field 'mProgressBar'");
        t2.mTagsPlaceholder = (View)finder.findRequiredView(object, 2131624437, "field 'mTagsPlaceholder'");
        return a2;
    }

    protected a<T> a(T t2) {
        return new a<T>(t2);
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object object, Object object2) {
        return this.a(finder, (GroupTagsFragment)object, object2);
    }

    public static class a<T extends GroupTagsFragment>
    implements Unbinder {
        private T a;

        protected a(T t2) {
            this.a = t2;
        }

        protected void a(T t2) {
            t2.mTagsView = null;
            t2.mCreateGroupBtn = null;
            t2.mProgressBar = null;
            t2.mTagsPlaceholder = null;
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

