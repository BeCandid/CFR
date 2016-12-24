/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.View
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.views.viewholders.MessagesHeaderViewHolder;

public class MessagesHeaderViewHolder$$ViewBinder<T extends MessagesHeaderViewHolder>
implements ViewBinder<T> {
    public Unbinder a(Finder finder, T t2, Object object) {
        a<T> a2 = this.a(t2);
        t2.messagesHeaderName = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624556, "field 'messagesHeaderName'"), 2131624556, "field 'messagesHeaderName'");
        t2.messagesHeaderUserIcon = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624238, "field 'messagesHeaderUserIcon'"), 2131624238, "field 'messagesHeaderUserIcon'");
        t2.messagesHeaderIconContainer = (RelativeLayout)finder.castView((View)finder.findRequiredView(object, 2131624236, "field 'messagesHeaderIconContainer'"), 2131624236, "field 'messagesHeaderIconContainer'");
        return a2;
    }

    protected a<T> a(T t2) {
        return new a<T>(t2);
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object object, Object object2) {
        return this.a(finder, (T)((Object)((MessagesHeaderViewHolder)((Object)object))), object2);
    }

    public static class a<T extends MessagesHeaderViewHolder>
    implements Unbinder {
        private T a;

        protected a(T t2) {
            this.a = t2;
        }

        protected void a(T t2) {
            t2.messagesHeaderName = null;
            t2.messagesHeaderUserIcon = null;
            t2.messagesHeaderIconContainer = null;
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

