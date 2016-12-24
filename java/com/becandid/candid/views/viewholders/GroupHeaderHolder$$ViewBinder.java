/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  butterknife.Unbinder
 *  butterknife.internal.Finder
 *  butterknife.internal.ViewBinder
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package com.becandid.candid.views.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.views.viewholders.GroupHeaderHolder;

public class GroupHeaderHolder$$ViewBinder<T extends GroupHeaderHolder>
implements ViewBinder<T> {
    public Unbinder a(Finder finder, T t2, Object object) {
        a<T> a2 = this.a(t2);
        t2.groupHeader = (RelativeLayout)finder.castView((View)finder.findRequiredView(object, 2131624376, "field 'groupHeader'"), 2131624376, "field 'groupHeader'");
        t2.groupAbout = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624386, "field 'groupAbout'"), 2131624386, "field 'groupAbout'");
        t2.groupStats = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624387, "field 'groupStats'"), 2131624387, "field 'groupStats'");
        t2.groupImage = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624379, "field 'groupImage'"), 2131624379, "field 'groupImage'");
        t2.groupMenu = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624377, "field 'groupMenu'"), 2131624377, "field 'groupMenu'");
        t2.groupJoin = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624380, "field 'groupJoin'"), 2131624380, "field 'groupJoin'");
        t2.groupLeave = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624381, "field 'groupLeave'"), 2131624381, "field 'groupLeave'");
        return a2;
    }

    protected a<T> a(T t2) {
        return new a<T>(t2);
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object object, Object object2) {
        return this.a(finder, (T)((Object)((GroupHeaderHolder)((Object)object))), object2);
    }

    public static class a<T extends GroupHeaderHolder>
    implements Unbinder {
        private T a;

        protected a(T t2) {
            this.a = t2;
        }

        protected void a(T t2) {
            t2.groupHeader = null;
            t2.groupAbout = null;
            t2.groupStats = null;
            t2.groupImage = null;
            t2.groupMenu = null;
            t2.groupJoin = null;
            t2.groupLeave = null;
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

