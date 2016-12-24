/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.app.Fragment
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$FontMetrics
 *  android.os.Bundle
 *  android.support.v4.app.Fragment
 *  android.text.TextPaint
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$OnClickListener
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Enum
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.List
 */
package com.facebook.login.widget;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.AccessToken;
import com.facebook.FacebookButtonBase;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.LoginAuthorizationType;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginBehavior;
import com.facebook.login.widget.ToolTipPopup;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LoginButton
extends FacebookButtonBase {
    private static final String a = LoginButton.class.getName();
    private boolean b;
    private String c;
    private String d;
    private a e = new a();
    private String f = "fb_login_view_usage";
    private boolean g;
    private ToolTipPopup.Style h = ToolTipPopup.Style.a;
    private ToolTipMode i;
    private long j = 6000;
    private ToolTipPopup k;
    private ui l;
    private wm m;

    public LoginButton(Context context) {
        super(context, null, 0, 0, "fb_login_button_create", "fb_login_button_did_tap");
    }

    public LoginButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 0, "fb_login_button_create", "fb_login_button_did_tap");
    }

    public LoginButton(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2, 0, "fb_login_button_create", "fb_login_button_did_tap");
    }

    private void a(we.b b2) {
        if (b2 != null && b2.c() && this.getVisibility() == 0) {
            super.b(b2.b());
        }
    }

    private void b() {
        switch (.a[this.i.ordinal()]) {
            default: {
                return;
            }
            case 1: {
                final String string2 = we.a(this.getContext());
                ul.d().execute(new Runnable(){

                    public void run() {
                        final we.b b2 = we.a(string2, false);
                        LoginButton.this.getActivity().runOnUiThread(new Runnable(){

                            public void run() {
                                LoginButton.this.a(b2);
                            }
                        });
                    }

                });
                return;
            }
            case 2: 
        }
        this.b(this.getResources().getString(uu.f.com_facebook_tooltip_default));
    }

    private void b(Context context, AttributeSet attributeSet, int n2, int n3) {
        this.i = ToolTipMode.d;
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attributeSet, uu.h.com_facebook_login_view, n2, n3);
        try {
            this.b = typedArray.getBoolean(uu.h.com_facebook_login_view_com_facebook_confirm_logout, true);
            this.c = typedArray.getString(uu.h.com_facebook_login_view_com_facebook_login_text);
            this.d = typedArray.getString(uu.h.com_facebook_login_view_com_facebook_logout_text);
            this.i = ToolTipMode.a(typedArray.getInt(uu.h.com_facebook_login_view_com_facebook_tooltip_mode, ToolTipMode.d.a()));
            return;
        }
        finally {
            typedArray.recycle();
        }
    }

    private void b(String string2) {
        this.k = new ToolTipPopup(string2, (View)this);
        this.k.a(this.h);
        this.k.a(this.j);
        this.k.a();
    }

    private int c(String string2) {
        return this.a(string2) + (this.getCompoundPaddingLeft() + this.getCompoundDrawablePadding()) + this.getCompoundPaddingRight();
    }

    /*
     * Enabled aggressive block sorting
     */
    private void c() {
        Resources resources = this.getResources();
        if (!this.isInEditMode() && AccessToken.a() != null) {
            String string2 = this.d != null ? this.d : resources.getString(uu.f.com_facebook_loginview_log_out_button);
            this.setText((CharSequence)string2);
            return;
        }
        if (this.c != null) {
            this.setText((CharSequence)this.c);
            return;
        }
        String string3 = resources.getString(uu.f.com_facebook_loginview_log_in_button_long);
        int n2 = this.getWidth();
        if (n2 != 0 && this.c(string3) > n2) {
            string3 = resources.getString(uu.f.com_facebook_loginview_log_in_button);
        }
        this.setText((CharSequence)string3);
    }

    public void a() {
        if (this.k != null) {
            this.k.b();
            this.k = null;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    protected void a(Context context, AttributeSet attributeSet, int n2, int n3) {
        super.a(context, attributeSet, n2, n3);
        this.setInternalOnClickListener(this.getNewLoginClickListener());
        super.b(context, attributeSet, n2, n3);
        if (this.isInEditMode()) {
            this.setBackgroundColor(this.getResources().getColor(uu.a.com_facebook_blue));
            this.c = "Log in with Facebook";
        } else {
            this.l = new ui(){

                @Override
                protected void a(AccessToken accessToken, AccessToken accessToken2) {
                    LoginButton.this.c();
                }
            };
        }
        super.c();
    }

    public DefaultAudience getDefaultAudience() {
        return this.e.a();
    }

    @Override
    protected int getDefaultRequestCode() {
        return CallbackManagerImpl.RequestCodeOffset.a.a();
    }

    @Override
    protected int getDefaultStyleResource() {
        return uu.g.com_facebook_loginview_default_style;
    }

    public LoginBehavior getLoginBehavior() {
        return this.e.c();
    }

    wm getLoginManager() {
        if (this.m == null) {
            this.m = wm.c();
        }
        return this.m;
    }

    protected b getNewLoginClickListener() {
        return new b();
    }

    List<String> getPermissions() {
        return this.e.b();
    }

    public long getToolTipDisplayTime() {
        return this.j;
    }

    public ToolTipMode getToolTipMode() {
        return this.i;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.l != null && !this.l.c()) {
            this.l.a();
            this.c();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.l != null) {
            this.l.b();
        }
        this.a();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.g && !this.isInEditMode()) {
            this.g = true;
            super.b();
        }
    }

    protected void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
        super.onLayout(bl2, n2, n3, n4, n5);
        this.c();
    }

    protected void onMeasure(int n2, int n3) {
        int n4;
        Paint.FontMetrics fontMetrics = this.getPaint().getFontMetrics();
        int n5 = this.getCompoundPaddingTop() + (int)Math.ceil((double)(Math.abs((float)fontMetrics.top) + Math.abs((float)fontMetrics.bottom))) + this.getCompoundPaddingBottom();
        Resources resources = this.getResources();
        String string2 = this.c;
        if (string2 == null && LoginButton.resolveSize((int)(n4 = super.c(string2 = resources.getString(uu.f.com_facebook_loginview_log_in_button_long))), (int)n2) < n4) {
            string2 = resources.getString(uu.f.com_facebook_loginview_log_in_button);
        }
        int n6 = super.c(string2);
        String string3 = this.d;
        if (string3 == null) {
            string3 = resources.getString(uu.f.com_facebook_loginview_log_out_button);
        }
        this.setMeasuredDimension(LoginButton.resolveSize((int)Math.max((int)n6, (int)super.c(string3)), (int)n2), n5);
    }

    protected void onVisibilityChanged(View view, int n2) {
        super.onVisibilityChanged(view, n2);
        if (n2 != 0) {
            this.a();
        }
    }

    public void setDefaultAudience(DefaultAudience defaultAudience) {
        this.e.a(defaultAudience);
    }

    public void setLoginBehavior(LoginBehavior loginBehavior) {
        this.e.a(loginBehavior);
    }

    void setLoginManager(wm wm2) {
        this.m = wm2;
    }

    void setProperties(a a2) {
        this.e = a2;
    }

    public void setPublishPermissions(List<String> list) {
        this.e.b(list);
    }

    public /* varargs */ void setPublishPermissions(String ... arrstring) {
        this.e.b(Arrays.asList((Object[])arrstring));
    }

    public void setReadPermissions(List<String> list) {
        this.e.a(list);
    }

    public /* varargs */ void setReadPermissions(String ... arrstring) {
        this.e.a(Arrays.asList((Object[])arrstring));
    }

    public void setToolTipDisplayTime(long l2) {
        this.j = l2;
    }

    public void setToolTipMode(ToolTipMode toolTipMode) {
        this.i = toolTipMode;
    }

    public void setToolTipStyle(ToolTipPopup.Style style) {
        this.h = style;
    }

    public static final class ToolTipMode
    extends Enum<ToolTipMode> {
        public static final /* enum */ ToolTipMode a = new ToolTipMode("automatic", 0);
        public static final /* enum */ ToolTipMode b = new ToolTipMode("display_always", 1);
        public static final /* enum */ ToolTipMode c = new ToolTipMode("never_display", 2);
        public static ToolTipMode d;
        private static final /* synthetic */ ToolTipMode[] g;
        private String e;
        private int f;

        static {
            ToolTipMode[] arrtoolTipMode = new ToolTipMode[]{a, b, c};
            g = arrtoolTipMode;
            d = a;
        }

        private ToolTipMode(String string3, int n3) {
            super(string2, n2);
            this.e = string3;
            this.f = n3;
        }

        public static ToolTipMode a(int n2) {
            for (ToolTipMode toolTipMode : ToolTipMode.values()) {
                if (toolTipMode.a() != n2) continue;
                return toolTipMode;
            }
            return null;
        }

        public static ToolTipMode valueOf(String string2) {
            return (ToolTipMode)Enum.valueOf((Class)ToolTipMode.class, (String)string2);
        }

        public static ToolTipMode[] values() {
            return (ToolTipMode[])g.clone();
        }

        public int a() {
            return this.f;
        }

        public String toString() {
            return this.e;
        }
    }

    static class a {
        private DefaultAudience a = DefaultAudience.c;
        private List<String> b = Collections.emptyList();
        private LoginAuthorizationType c = null;
        private LoginBehavior d = LoginBehavior.a;

        a() {
        }

        public DefaultAudience a() {
            return this.a;
        }

        public void a(DefaultAudience defaultAudience) {
            this.a = defaultAudience;
        }

        public void a(LoginBehavior loginBehavior) {
            this.d = loginBehavior;
        }

        public void a(List<String> list) {
            if (LoginAuthorizationType.b.equals((Object)this.c)) {
                throw new UnsupportedOperationException("Cannot call setReadPermissions after setPublishPermissions has been called.");
            }
            this.b = list;
            this.c = LoginAuthorizationType.a;
        }

        List<String> b() {
            return this.b;
        }

        public void b(List<String> list) {
            if (LoginAuthorizationType.a.equals((Object)this.c)) {
                throw new UnsupportedOperationException("Cannot call setPublishPermissions after setReadPermissions has been called.");
            }
            if (we.a(list)) {
                throw new IllegalArgumentException("Permissions for publish actions cannot be null or empty.");
            }
            this.b = list;
            this.c = LoginAuthorizationType.b;
        }

        public LoginBehavior c() {
            return this.d;
        }
    }

    public class b
    implements View.OnClickListener {
        protected b() {
        }

        protected wm a() {
            wm wm2 = wm.c();
            wm2.a(LoginButton.this.getDefaultAudience());
            wm2.a(LoginButton.this.getLoginBehavior());
            return wm2;
        }

        /*
         * Enabled aggressive block sorting
         */
        protected void a(Context context) {
            String string2;
            final wm wm2 = this.a();
            if (!LoginButton.this.b) {
                wm2.d();
                return;
            }
            String string3 = LoginButton.this.getResources().getString(uu.f.com_facebook_loginview_log_out_action);
            String string4 = LoginButton.this.getResources().getString(uu.f.com_facebook_loginview_cancel_action);
            Profile profile = Profile.a();
            if (profile != null && profile.c() != null) {
                String string5 = LoginButton.this.getResources().getString(uu.f.com_facebook_loginview_logged_in_as);
                Object[] arrobject = new Object[]{profile.c()};
                string2 = String.format((String)string5, (Object[])arrobject);
            } else {
                string2 = LoginButton.this.getResources().getString(uu.f.com_facebook_loginview_logged_in_using_facebook);
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage((CharSequence)string2).setCancelable(true).setPositiveButton((CharSequence)string3, new DialogInterface.OnClickListener(){

                public void onClick(DialogInterface dialogInterface, int n2) {
                    wm2.d();
                }
            }).setNegativeButton((CharSequence)string4, null);
            builder.create().show();
        }

        protected void b() {
            wm wm2 = this.a();
            if (LoginAuthorizationType.b.equals((Object)LoginButton.this.e.c)) {
                if (LoginButton.this.getFragment() != null) {
                    wm2.b(LoginButton.this.getFragment(), (Collection<String>)LoginButton.this.e.b);
                    return;
                }
                if (LoginButton.this.getNativeFragment() != null) {
                    wm2.b(LoginButton.this.getNativeFragment(), (Collection<String>)LoginButton.this.e.b);
                    return;
                }
                wm2.b(LoginButton.this.getActivity(), (Collection<String>)LoginButton.this.e.b);
                return;
            }
            if (LoginButton.this.getFragment() != null) {
                wm2.a(LoginButton.this.getFragment(), (Collection<String>)LoginButton.this.e.b);
                return;
            }
            if (LoginButton.this.getNativeFragment() != null) {
                wm2.a(LoginButton.this.getNativeFragment(), (Collection<String>)LoginButton.this.e.b);
                return;
            }
            wm2.a(LoginButton.this.getActivity(), (Collection<String>)LoginButton.this.e.b);
        }

        /*
         * Enabled aggressive block sorting
         */
        public void onClick(View view) {
            LoginButton.this.a(view);
            AccessToken accessToken = AccessToken.a();
            if (accessToken != null) {
                this.a(LoginButton.this.getContext());
            } else {
                this.b();
            }
            AppEventsLogger appEventsLogger = AppEventsLogger.a(LoginButton.this.getContext());
            Bundle bundle = new Bundle();
            int n2 = accessToken != null ? 0 : 1;
            bundle.putInt("logging_in", n2);
            appEventsLogger.a(LoginButton.this.f, null, bundle);
        }

    }

}

