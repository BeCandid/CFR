/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.webkit.WebView
 *  android.widget.ProgressBar
 *  android.widget.TextView
 *  butterknife.Unbinder
 *  butterknife.internal.Finder
 *  butterknife.internal.ViewBinder
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package com.becandid.candid.activities;

import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.activities.WebViewActivity;

public class WebViewActivity$$ViewBinder<T extends WebViewActivity>
implements ViewBinder<T> {
    public Unbinder bind(Finder finder, T t2, Object object) {
        InnerUnbinder<T> innerUnbinder = this.createUnbinder(t2);
        t2.mWebView = (WebView)finder.castView((View)finder.findRequiredView(object, 2131624316, "field 'mWebView'"), 2131624316, "field 'mWebView'");
        t2.mTitle = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624314, "field 'mTitle'"), 2131624314, "field 'mTitle'");
        t2.mProgressBar = (ProgressBar)finder.castView((View)finder.findRequiredView(object, 2131624191, "field 'mProgressBar'"), 2131624191, "field 'mProgressBar'");
        t2.mCopyLink = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624315, "field 'mCopyLink'"), 2131624315, "field 'mCopyLink'");
        return innerUnbinder;
    }

    protected InnerUnbinder<T> createUnbinder(T t2) {
        return new InnerUnbinder<T>(t2);
    }

    public static class InnerUnbinder<T extends WebViewActivity>
    implements Unbinder {
        private T a;

        protected InnerUnbinder(T t2) {
            this.a = t2;
        }

        public final void unbind() {
            if (this.a == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.unbind(this.a);
            this.a = null;
        }

        protected void unbind(T t2) {
            t2.mWebView = null;
            t2.mTitle = null;
            t2.mProgressBar = null;
            t2.mCopyLink = null;
        }
    }

}

