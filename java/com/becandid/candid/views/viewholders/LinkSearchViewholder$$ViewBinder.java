/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.ImageView
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
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.views.viewholders.LinkSearchViewholder;

public class LinkSearchViewholder$$ViewBinder<T extends LinkSearchViewholder>
implements ViewBinder<T> {
    public Unbinder a(Finder finder, T t2, Object object) {
        a<T> a2 = this.a(t2);
        t2.linkImage = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624515, "field 'linkImage'"), 2131624515, "field 'linkImage'");
        t2.linkDesc = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624518, "field 'linkDesc'"), 2131624518, "field 'linkDesc'");
        t2.linkTitle = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624517, "field 'linkTitle'"), 2131624517, "field 'linkTitle'");
        t2.linkHost = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624519, "field 'linkHost'"), 2131624519, "field 'linkHost'");
        t2.linkSearchResultIcon = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624516, "field 'linkSearchResultIcon'"), 2131624516, "field 'linkSearchResultIcon'");
        return a2;
    }

    protected a<T> a(T t2) {
        return new a<T>(t2);
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object object, Object object2) {
        return this.a(finder, (T)((Object)((LinkSearchViewholder)((Object)object))), object2);
    }

    public static class a<T extends LinkSearchViewholder>
    implements Unbinder {
        private T a;

        protected a(T t2) {
            this.a = t2;
        }

        protected void a(T t2) {
            t2.linkImage = null;
            t2.linkDesc = null;
            t2.linkTitle = null;
            t2.linkHost = null;
            t2.linkSearchResultIcon = null;
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

