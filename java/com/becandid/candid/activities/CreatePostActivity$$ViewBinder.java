/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.support.v7.widget.SwitchCompat
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  android.widget.EditText
 *  android.widget.ImageView
 *  android.widget.RelativeLayout
 *  android.widget.ScrollView
 *  android.widget.TextView
 *  butterknife.Unbinder
 *  butterknife.internal.DebouncingOnClickListener
 *  butterknife.internal.Finder
 *  butterknife.internal.ViewBinder
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package com.becandid.candid.activities;

import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.activities.CreatePostActivity;
import com.becandid.candid.views.AlwaysOnAutoCompleteView;
import com.venmo.view.TooltipView;

public class CreatePostActivity$$ViewBinder<T extends CreatePostActivity>
implements ViewBinder<T> {
    public Unbinder bind(Finder finder, T t2, Object object) {
        View view;
        View view2;
        View view3;
        InnerUnbinder<T> innerUnbinder = this.createUnbinder(t2);
        t2.postContent = (ScrollView)finder.castView((View)finder.findRequiredView(object, 2131624114, "field 'postContent'"), 2131624114, "field 'postContent'");
        t2.postCaption = (EditText)finder.castView((View)finder.findRequiredView(object, 2131624115, "field 'postCaption'"), 2131624115, "field 'postCaption'");
        t2.postPhoto = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624117, "field 'postPhoto'"), 2131624117, "field 'postPhoto'");
        t2.postButton = (Button)finder.castView((View)finder.findRequiredView(object, 2131624130, "field 'postButton'"), 2131624130, "field 'postButton'");
        t2.createGroupButton = (View)finder.findRequiredView(object, 2131624113, "field 'createGroupButton'");
        t2.groupNameSelector = (AlwaysOnAutoCompleteView)((Object)finder.castView((View)finder.findRequiredView(object, 2131624110, "field 'groupNameSelector'"), 2131624110, "field 'groupNameSelector'"));
        t2.friendMarker = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624129, "field 'friendMarker'"), 2131624129, "field 'friendMarker'");
        t2.friendSwitch = (SwitchCompat)finder.castView((View)finder.findRequiredView(object, 2131624128, "field 'friendSwitch'"), 2131624128, "field 'friendSwitch'");
        t2.tooltipView = (TooltipView)((Object)finder.castView((View)finder.findRequiredView(object, 2131624124, "field 'tooltipView'"), 2131624124, "field 'tooltipView'"));
        t2.camBtn = (View)finder.findRequiredView(object, 2131624125, "field 'camBtn'");
        t2.webSearchBtn = (View)finder.findRequiredView(object, 2131624127, "field 'webSearchBtn'");
        t2.postSpinny = (View)finder.findRequiredView(object, 2131624131, "field 'postSpinny'");
        t2.mRootView = (View)finder.findRequiredView(object, 2131624109, "field 'mRootView'");
        t2.linkContainer = (RelativeLayout)finder.castView((View)finder.findRequiredView(object, 2131624118, "field 'linkContainer'"), 2131624118, "field 'linkContainer'");
        innerUnbinder.a = view3 = (View)finder.findRequiredView(object, 2131624111, "method 'clearChosenGroup'");
        view3.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener((CreatePostActivity)t2){
            final /* synthetic */ CreatePostActivity a;

            public void doClick(View view) {
                this.a.clearChosenGroup(view);
            }
        });
        innerUnbinder.b = view2 = (View)finder.findRequiredView(object, 2131624126, "method 'chooseLink'");
        view2.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener((CreatePostActivity)t2, finder){
            final /* synthetic */ CreatePostActivity a;
            final /* synthetic */ Finder b;

            public void doClick(View view) {
                this.a.chooseLink((ImageView)this.b.castParam((Object)view, "doClick", 0, "chooseLink", 0));
            }
        });
        innerUnbinder.c = view = (View)finder.findRequiredView(object, 2131624123, "method 'clearLink'");
        view.setOnClickListener((View.OnClickListener)new DebouncingOnClickListener((CreatePostActivity)t2, finder){
            final /* synthetic */ CreatePostActivity a;
            final /* synthetic */ Finder b;

            public void doClick(View view) {
                this.a.clearLink((ImageView)this.b.castParam((Object)view, "doClick", 0, "clearLink", 0));
            }
        });
        return innerUnbinder;
    }

    protected InnerUnbinder<T> createUnbinder(T t2) {
        return new InnerUnbinder<T>(t2);
    }

    public static class InnerUnbinder<T extends CreatePostActivity>
    implements Unbinder {
        View a;
        View b;
        View c;
        private T d;

        protected InnerUnbinder(T t2) {
            this.d = t2;
        }

        public final void unbind() {
            if (this.d == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.unbind(this.d);
            this.d = null;
        }

        protected void unbind(T t2) {
            t2.postContent = null;
            t2.postCaption = null;
            t2.postPhoto = null;
            t2.postButton = null;
            t2.createGroupButton = null;
            t2.groupNameSelector = null;
            t2.friendMarker = null;
            t2.friendSwitch = null;
            t2.tooltipView = null;
            t2.camBtn = null;
            t2.webSearchBtn = null;
            t2.postSpinny = null;
            t2.mRootView = null;
            t2.linkContainer = null;
            this.a.setOnClickListener(null);
            this.b.setOnClickListener(null);
            this.c.setOnClickListener(null);
        }
    }

}

