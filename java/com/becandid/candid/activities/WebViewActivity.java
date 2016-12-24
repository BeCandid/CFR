/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Intent
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.webkit.WebChromeClient
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  android.widget.ProgressBar
 *  android.widget.TextView
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.IllegalAccessException
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 */
package com.becandid.candid.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.activities.BaseActivity;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class WebViewActivity
extends BaseActivity {
    String b;
    @BindView(value=2131624315)
    TextView mCopyLink;
    @BindView(value=2131624191)
    ProgressBar mProgressBar;
    @BindView(value=2131624314)
    TextView mTitle;
    @BindView(value=2131624316)
    WebView mWebView;

    /*
     * Enabled aggressive block sorting
     */
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130968637);
        ButterKnife.bind((Activity)this);
        if (this.getIntent().hasExtra("url")) {
            this.b = this.getIntent().getStringExtra("url");
            this.mWebView.loadUrl(this.b);
        }
        if (this.getIntent().hasExtra("title")) {
            this.mTitle.setText((CharSequence)this.getIntent().getStringExtra("title"));
        }
        if (this.getIntent().hasExtra("show_copy_link") && this.getIntent().getBooleanExtra("show_copy_link", false)) {
            this.mCopyLink.setVisibility(0);
            this.mCopyLink.setOnClickListener(new View.OnClickListener(){

                public void onClick(View view) {
                    in.z z2 = new in.z(WebViewActivity.this.b);
                    ix.a().a(z2);
                    WebViewActivity.this.finish();
                }
            });
        } else {
            this.mCopyLink.setVisibility(8);
        }
        this.mProgressBar.setMax(100);
        this.mProgressBar.getProgressDrawable().setColorFilter(-16776961, PorterDuff.Mode.SRC_IN);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.getSettings().setSupportMultipleWindows(true);
        this.mWebView.setWebChromeClient(new WebChromeClient(){

            public void onProgressChanged(WebView webView, int n2) {
                super.onProgressChanged(webView, n2);
                WebViewActivity.this.setValue(n2);
            }

            public void onReceivedTitle(WebView webView, String string2) {
                super.onReceivedTitle(webView, string2);
            }
        });
        this.mWebView.setWebViewClient(new WebViewClient(){

            public void onPageFinished(WebView webView, String string2) {
                super.onPageFinished(webView, string2);
                WebViewActivity.this.b = string2;
                WebViewActivity.this.mProgressBar.setVisibility(8);
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String string2) {
                webView.loadUrl(string2);
                WebViewActivity.this.b = string2;
                return true;
            }
        });
    }

    public boolean onKeyDown(int n2, KeyEvent keyEvent) {
        if (n2 == 4 && this.mWebView.canGoBack()) {
            this.mWebView.goBack();
            return true;
        }
        return super.onKeyDown(n2, keyEvent);
    }

    public void onPause() {
        super.onPause();
        try {
            Class.forName((String)"android.webkit.WebView").getMethod("onPause", (Class[])null).invoke((Object)this.mWebView, (Object[])null);
            return;
        }
        catch (IllegalAccessException var4_1) {
            return;
        }
        catch (InvocationTargetException var3_2) {
            return;
        }
        catch (NoSuchMethodException var2_3) {
            return;
        }
        catch (ClassNotFoundException var1_4) {
            return;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        this.mWebView.onResume();
    }

    public void setValue(int n2) {
        this.mProgressBar.setProgress(n2);
    }

}

