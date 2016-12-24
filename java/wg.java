/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.app.Dialog
 *  android.app.ProgressDialog
 *  android.content.ActivityNotFoundException
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.net.http.SslError
 *  android.os.Bundle
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.KeyEvent
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window
 *  android.view.WindowManager
 *  android.webkit.SslErrorHandler
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Locale
 */
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.AccessToken;
import com.facebook.FacebookDialogException;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookServiceException;
import java.util.Locale;

public class wg
extends Dialog {
    private String a;
    private String b;
    private c c;
    private WebView d;
    private ProgressDialog e;
    private ImageView f;
    private FrameLayout g;
    private boolean h;
    private boolean i;
    private boolean j;

    public wg(Context context, String string2) {
        super(context, string2, ul.l());
    }

    public wg(Context context, String string2, int n2) {
        if (n2 == 0) {
            n2 = ul.l();
        }
        super(context, n2);
        this.b = "fbconnect://success";
        this.h = false;
        this.i = false;
        this.j = false;
        this.a = string2;
    }

    public wg(Context context, String string2, Bundle bundle, int n2, c c2) {
        if (n2 == 0) {
            n2 = ul.l();
        }
        super(context, n2);
        this.b = "fbconnect://success";
        this.h = false;
        this.i = false;
        this.j = false;
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("redirect_uri", "fbconnect://success");
        bundle.putString("display", "touch");
        Locale locale = Locale.ROOT;
        Object[] arrobject = new Object[]{ul.g()};
        bundle.putString("sdk", String.format((Locale)locale, (String)"android-%s", (Object[])arrobject));
        this.a = we.a(wc.a(), wc.d() + "/" + "dialog/" + string2, bundle).toString();
        this.c = c2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private int a(int n2, float f2, int n3, int n4) {
        double d2;
        int n5 = (int)((float)n2 / f2);
        if (n5 <= n3) {
            d2 = 1.0;
            do {
                return (int)(d2 * (double)n2);
                break;
            } while (true);
        }
        if (n5 >= n4) {
            d2 = 0.5;
            return (int)(d2 * (double)n2);
        }
        d2 = 0.5 + 0.5 * ((double)(n4 - n5) / (double)(n4 - n3));
        return (int)(d2 * (double)n2);
    }

    @SuppressLint(value={"SetJavaScriptEnabled"})
    private void a(int n2) {
        LinearLayout linearLayout = new LinearLayout(this.getContext());
        this.d = new WebView(this.getContext().getApplicationContext()){

            public void onWindowFocusChanged(boolean bl2) {
                try {
                    super.onWindowFocusChanged(bl2);
                    return;
                }
                catch (NullPointerException var2_2) {
                    return;
                }
            }
        };
        this.d.setVerticalScrollBarEnabled(false);
        this.d.setHorizontalScrollBarEnabled(false);
        this.d.setWebViewClient((WebViewClient)new b((wg)this, null));
        this.d.getSettings().setJavaScriptEnabled(true);
        this.d.loadUrl(this.a);
        this.d.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        this.d.setVisibility(4);
        this.d.getSettings().setSavePassword(false);
        this.d.getSettings().setSaveFormData(false);
        this.d.setFocusable(true);
        this.d.setFocusableInTouchMode(true);
        this.d.setOnTouchListener(new View.OnTouchListener(){

            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (!view.hasFocus()) {
                    view.requestFocus();
                }
                return false;
            }
        });
        linearLayout.setPadding(n2, n2, n2, n2);
        linearLayout.addView((View)this.d);
        linearLayout.setBackgroundColor(-872415232);
        this.g.addView((View)linearLayout);
    }

    private void e() {
        this.f = new ImageView(this.getContext());
        this.f.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                wg.this.cancel();
            }
        });
        Drawable drawable = this.getContext().getResources().getDrawable(uu.c.com_facebook_close);
        this.f.setImageDrawable(drawable);
        this.f.setVisibility(4);
    }

    protected Bundle a(String string2) {
        Uri uri = Uri.parse((String)string2);
        Bundle bundle = we.c(uri.getQuery());
        bundle.putAll(we.c(uri.getFragment()));
        return bundle;
    }

    protected void a(Bundle bundle) {
        if (this.c != null && !this.h) {
            this.h = true;
            this.c.a(bundle, null);
            this.dismiss();
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    protected void a(Throwable throwable) {
        if (this.c != null && !this.h) {
            this.h = true;
            FacebookException facebookException = throwable instanceof FacebookException ? (FacebookException)throwable : new FacebookException(throwable);
            this.c.a(null, facebookException);
            this.dismiss();
        }
    }

    public void a(c c2) {
        this.c = c2;
    }

    protected boolean a() {
        return this.h;
    }

    protected void b(String string2) {
        this.b = string2;
    }

    protected boolean b() {
        return this.j;
    }

    protected WebView c() {
        return this.d;
    }

    public void cancel() {
        if (this.c != null && !this.h) {
            this.a((Throwable)new FacebookOperationCanceledException());
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void d() {
        Display display = ((WindowManager)this.getContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getMetrics(displayMetrics);
        int n2 = displayMetrics.widthPixels < displayMetrics.heightPixels ? displayMetrics.widthPixels : displayMetrics.heightPixels;
        int n3 = displayMetrics.widthPixels < displayMetrics.heightPixels ? displayMetrics.heightPixels : displayMetrics.widthPixels;
        int n4 = Math.min((int)this.a(n2, displayMetrics.density, 480, 800), (int)displayMetrics.widthPixels);
        int n5 = Math.min((int)this.a(n3, displayMetrics.density, 800, 1280), (int)displayMetrics.heightPixels);
        this.getWindow().setLayout(n4, n5);
    }

    public void dismiss() {
        if (this.d != null) {
            this.d.stopLoading();
        }
        if (!this.i && this.e != null && this.e.isShowing()) {
            this.e.dismiss();
        }
        super.dismiss();
    }

    public void onAttachedToWindow() {
        this.i = false;
        super.onAttachedToWindow();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.e = new ProgressDialog(this.getContext());
        this.e.requestWindowFeature(1);
        this.e.setMessage((CharSequence)this.getContext().getString(uu.f.com_facebook_loading));
        this.e.setCanceledOnTouchOutside(false);
        this.e.setOnCancelListener(new DialogInterface.OnCancelListener(){

            public void onCancel(DialogInterface dialogInterface) {
                wg.this.cancel();
            }
        });
        this.requestWindowFeature(1);
        this.g = new FrameLayout(this.getContext());
        this.d();
        this.getWindow().setGravity(17);
        this.getWindow().setSoftInputMode(16);
        super.e();
        super.a(1 + this.f.getDrawable().getIntrinsicWidth() / 2);
        this.g.addView((View)this.f, new ViewGroup.LayoutParams(-2, -2));
        this.setContentView((View)this.g);
    }

    public void onDetachedFromWindow() {
        this.i = true;
        super.onDetachedFromWindow();
    }

    public boolean onKeyDown(int n2, KeyEvent keyEvent) {
        if (n2 == 4) {
            this.cancel();
        }
        return super.onKeyDown(n2, keyEvent);
    }

    protected void onStart() {
        super.onStart();
        this.d();
    }

    public static class a {
        private Context a;
        private String b;
        private String c;
        private int d;
        private c e;
        private Bundle f;
        private AccessToken g;

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public a(Context context, String string2, Bundle bundle) {
            this.g = AccessToken.a();
            if (this.g == null) {
                String string3 = we.a(context);
                if (string3 == null) throw new FacebookException("Attempted to create a builder without a valid access token or a valid default Application ID.");
                this.b = string3;
            }
            super.a(context, string2, bundle);
        }

        public a(Context context, String string2, String string3, Bundle bundle) {
            if (string2 == null) {
                string2 = we.a(context);
            }
            wf.a(string2, "applicationId");
            this.b = string2;
            super.a(context, string3, bundle);
        }

        private void a(Context context, String string2, Bundle bundle) {
            this.a = context;
            this.c = string2;
            if (bundle != null) {
                this.f = bundle;
                return;
            }
            this.f = new Bundle();
        }

        public a a(c c2) {
            this.e = c2;
            return this;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public wg a() {
            if (this.g != null) {
                this.f.putString("app_id", this.g.h());
                this.f.putString("access_token", this.g.b());
                do {
                    return new wg(this.a, this.c, this.f, this.d, this.e);
                    break;
                } while (true);
            }
            this.f.putString("app_id", this.b);
            return new wg(this.a, this.c, this.f, this.d, this.e);
        }

        public String b() {
            return this.b;
        }

        public Context c() {
            return this.a;
        }

        public int d() {
            return this.d;
        }

        public Bundle e() {
            return this.f;
        }

        public c f() {
            return this.e;
        }
    }

    class b
    extends WebViewClient {
        final /* synthetic */ wg a;

        private b(wg wg2) {
            this.a = wg2;
        }

        /* synthetic */ b(wg wg2,  var2_2) {
            super(wg2);
        }

        public void onPageFinished(WebView webView, String string2) {
            super.onPageFinished(webView, string2);
            if (!this.a.i) {
                this.a.e.dismiss();
            }
            this.a.g.setBackgroundColor(0);
            this.a.d.setVisibility(0);
            this.a.f.setVisibility(0);
            this.a.j = true;
        }

        public void onPageStarted(WebView webView, String string2, Bitmap bitmap) {
            we.b("FacebookSDK.WebDialog", "Webview loading URL: " + string2);
            super.onPageStarted(webView, string2, bitmap);
            if (!this.a.i) {
                this.a.e.show();
            }
        }

        public void onReceivedError(WebView webView, int n2, String string2, String string3) {
            super.onReceivedError(webView, n2, string2, string3);
            this.a.a((Throwable)new FacebookDialogException(string2, n2, string3));
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            sslErrorHandler.cancel();
            this.a.a((Throwable)new FacebookDialogException(null, -11, null));
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public boolean shouldOverrideUrlLoading(WebView webView, String string2) {
            we.b("FacebookSDK.WebDialog", "Redirect URL: " + string2);
            if (string2.startsWith(this.a.b)) {
                String string3;
                Bundle bundle = this.a.a(string2);
                String string4 = bundle.getString("error");
                if (string4 == null) {
                    string4 = bundle.getString("error_type");
                }
                if ((string3 = bundle.getString("error_msg")) == null) {
                    string3 = bundle.getString("error_message");
                }
                if (string3 == null) {
                    string3 = bundle.getString("error_description");
                }
                String string5 = bundle.getString("error_code");
                int n2 = -1;
                if (!we.a(string5)) {
                    try {
                        int n3;
                        n2 = n3 = Integer.parseInt((String)string5);
                    }
                    catch (NumberFormatException var10_9) {
                        n2 = -1;
                    }
                }
                if (we.a(string4) && we.a(string3) && n2 == -1) {
                    this.a.a(bundle);
                    return true;
                }
                if (string4 != null && (string4.equals((Object)"access_denied") || string4.equals((Object)"OAuthAccessDeniedException"))) {
                    this.a.cancel();
                    return true;
                }
                if (n2 == 4201) {
                    this.a.cancel();
                    return true;
                }
                FacebookRequestError facebookRequestError = new FacebookRequestError(n2, string4, string3);
                this.a.a((Throwable)new FacebookServiceException(facebookRequestError, string3));
                return true;
            }
            if (string2.startsWith("fbconnect://cancel")) {
                this.a.cancel();
                return true;
            }
            if (string2.contains((CharSequence)"touch")) {
                return false;
            }
            try {
                this.a.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse((String)string2)));
                return true;
            }
            catch (ActivityNotFoundException var3_11) {
                return false;
            }
        }
    }

    public static interface c {
        public void a(Bundle var1, FacebookException var2);
    }

}

