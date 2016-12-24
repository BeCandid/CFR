/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.support.v7.widget.RecyclerView
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ProgressBar
 *  butterknife.Unbinder
 *  butterknife.internal.DebouncingOnClickListener
 *  butterknife.internal.Finder
 *  butterknife.internal.ViewBinder
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package com.becandid.candid.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.views.ChoosePhotoDialogView;

public class ChoosePhotoDialogView$$ViewBinder<T extends ChoosePhotoDialogView>
implements ViewBinder<T> {
    public Unbinder a(Finder finder, T t2, Object object) {
        View view;
        View view2;
        View view3;
        a<T> a2 = this.a(t2);
        t2.spinny = (ProgressBar)finder.castView((View)finder.findRequiredView(object, 2131624318, "field 'spinny'"), 2131624318, "field 'spinny'");
        t2.suggestedPhotoView = (RecyclerView)finder.castView((View)finder.findRequiredView(object, 2131624317, "field 'suggestedPhotoView'"), 2131624317, "field 'suggestedPhotoView'");
        a2.a = view3 = (View)finder.findRequiredView(object, 2131624319, "method 'takePhoto'");
        view3.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener((ChoosePhotoDialogView)((Object)t2)){
            final /* synthetic */ ChoosePhotoDialogView a;

            public void doClick(View view) {
                this.a.takePhoto(view);
            }
        });
        a2.b = view2 = (View)finder.findRequiredView(object, 2131624320, "method 'library'");
        view2.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener((ChoosePhotoDialogView)((Object)t2)){
            final /* synthetic */ ChoosePhotoDialogView a;

            public void doClick(View view) {
                this.a.library(view);
            }
        });
        a2.c = view = (View)finder.findRequiredView(object, 2131624321, "method 'cancel'");
        view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener((ChoosePhotoDialogView)((Object)t2)){
            final /* synthetic */ ChoosePhotoDialogView a;

            public void doClick(View view) {
                this.a.cancel(view);
            }
        });
        return a2;
    }

    protected a<T> a(T t2) {
        return new a<T>(t2);
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object object, Object object2) {
        return this.a(finder, (T)((Object)((ChoosePhotoDialogView)((Object)object))), object2);
    }

    public static class a<T extends ChoosePhotoDialogView>
    implements Unbinder {
        View a;
        View b;
        View c;
        private T d;

        protected a(T t2) {
            this.d = t2;
        }

        protected void a(T t2) {
            t2.spinny = null;
            t2.suggestedPhotoView = null;
            this.a.setOnClickListener(null);
            this.b.setOnClickListener(null);
            this.c.setOnClickListener(null);
        }

        public final void unbind() {
            if (this.d == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a(this.d);
            this.d = null;
        }
    }

}

