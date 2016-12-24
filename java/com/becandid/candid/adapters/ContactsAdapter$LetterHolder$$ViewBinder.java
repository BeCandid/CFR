/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.TextView
 *  butterknife.Unbinder
 *  butterknife.internal.Finder
 *  butterknife.internal.ViewBinder
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package com.becandid.candid.adapters;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.adapters.ContactsAdapter;

public class ContactsAdapter$LetterHolder$$ViewBinder<T extends ContactsAdapter.LetterHolder>
implements ViewBinder<T> {
    public Unbinder a(Finder finder, T t2, Object object) {
        a<T> a2 = this.a(t2);
        t2.letter = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624364, "field 'letter'"), 2131624364, "field 'letter'");
        return a2;
    }

    protected a<T> a(T t2) {
        return new a<T>(t2);
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object object, Object object2) {
        return this.a(finder, (T)((Object)((ContactsAdapter.LetterHolder)((Object)object))), object2);
    }

    public static class a<T extends ContactsAdapter.LetterHolder>
    implements Unbinder {
        private T a;

        protected a(T t2) {
            this.a = t2;
        }

        protected void a(T t2) {
            t2.letter = null;
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

