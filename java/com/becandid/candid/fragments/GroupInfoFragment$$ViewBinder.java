/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.Button
 *  android.widget.EditText
 *  android.widget.ImageView
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
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.fragments.GroupInfoFragment;

public class GroupInfoFragment$$ViewBinder<T extends GroupInfoFragment>
implements ViewBinder<T> {
    public Unbinder a(Finder finder, T t2, Object object) {
        a<T> a2 = this.a(t2);
        t2.mGroupPhoto = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624430, "field 'mGroupPhoto'"), 2131624430, "field 'mGroupPhoto'");
        t2.mChoosePhotoPlaceholder = (View)finder.findRequiredView(object, 2131624429, "field 'mChoosePhotoPlaceholder'");
        t2.mSkipBtn = (Button)finder.castView((View)finder.findRequiredView(object, 2131624433, "field 'mSkipBtn'"), 2131624433, "field 'mSkipBtn'");
        t2.mGroupInfo = (EditText)finder.castView((View)finder.findRequiredView(object, 2131624428, "field 'mGroupInfo'"), 2131624428, "field 'mGroupInfo'");
        t2.mNextBtn = (Button)finder.castView((View)finder.findRequiredView(object, 2131624432, "field 'mNextBtn'"), 2131624432, "field 'mNextBtn'");
        return a2;
    }

    protected a<T> a(T t2) {
        return new a<T>(t2);
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object object, Object object2) {
        return this.a(finder, (T)((Object)((GroupInfoFragment)((Object)object))), object2);
    }

    public static class a<T extends GroupInfoFragment>
    implements Unbinder {
        private T a;

        protected a(T t2) {
            this.a = t2;
        }

        protected void a(T t2) {
            t2.mGroupPhoto = null;
            t2.mChoosePhotoPlaceholder = null;
            t2.mSkipBtn = null;
            t2.mGroupInfo = null;
            t2.mNextBtn = null;
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

