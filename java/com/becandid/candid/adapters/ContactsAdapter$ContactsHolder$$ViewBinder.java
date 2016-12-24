/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.Button
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
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.adapters.ContactsAdapter;

public class ContactsAdapter$ContactsHolder$$ViewBinder<T extends ContactsAdapter.ContactsHolder>
implements ViewBinder<T> {
    public Unbinder a(Finder finder, T t2, Object object) {
        a<T> a2 = this.a(t2);
        t2.contactName = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624363, "field 'contactName'"), 2131624363, "field 'contactName'");
        t2.contactPhoto = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624361, "field 'contactPhoto'"), 2131624361, "field 'contactPhoto'");
        t2.animalBgView = (View)finder.findRequiredView(object, 2131624360, "field 'animalBgView'");
        t2.invite = (Button)finder.castView((View)finder.findRequiredView(object, 2131624362, "field 'invite'"), 2131624362, "field 'invite'");
        return a2;
    }

    protected a<T> a(T t2) {
        return new a<T>(t2);
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object object, Object object2) {
        return this.a(finder, (T)((Object)((ContactsAdapter.ContactsHolder)((Object)object))), object2);
    }

    public static class a<T extends ContactsAdapter.ContactsHolder>
    implements Unbinder {
        private T a;

        protected a(T t2) {
            this.a = t2;
        }

        protected void a(T t2) {
            t2.contactName = null;
            t2.contactPhoto = null;
            t2.animalBgView = null;
            t2.invite = null;
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

