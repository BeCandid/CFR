/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnScrollChangedListener
 *  android.view.Window
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.PopupWindow
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.ref.WeakReference
 */
package com.facebook.login.widget;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import java.lang.ref.WeakReference;

public class ToolTipPopup {
    private final String a;
    private final WeakReference<View> b;
    private final Context c;
    private a d;
    private PopupWindow e;
    private Style f = Style.a;
    private long g = 6000;
    private final ViewTreeObserver.OnScrollChangedListener h;

    public ToolTipPopup(String string2, View view) {
        this.h = new ViewTreeObserver.OnScrollChangedListener(){

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public void onScrollChanged() {
                if (ToolTipPopup.this.b.get() == null || ToolTipPopup.this.e == null || !ToolTipPopup.this.e.isShowing()) return;
                if (ToolTipPopup.this.e.isAboveAnchor()) {
                    ToolTipPopup.this.d.b();
                    return;
                }
                ToolTipPopup.this.d.a();
            }
        };
        this.a = string2;
        this.b = new WeakReference((Object)view);
        this.c = view.getContext();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void c() {
        if (this.e == null || !this.e.isShowing()) return;
        if (this.e.isAboveAnchor()) {
            this.d.b();
            return;
        }
        this.d.a();
    }

    private void d() {
        this.e();
        if (this.b.get() != null) {
            ((View)this.b.get()).getViewTreeObserver().addOnScrollChangedListener(this.h);
        }
    }

    private void e() {
        if (this.b.get() != null) {
            ((View)this.b.get()).getViewTreeObserver().removeOnScrollChangedListener(this.h);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a() {
        if (this.b.get() != null) {
            this.d = new a(this.c);
            ((TextView)this.d.findViewById(uu.d.com_facebook_tooltip_bubble_view_text_body)).setText((CharSequence)this.a);
            if (this.f == Style.a) {
                this.d.d.setBackgroundResource(uu.c.com_facebook_tooltip_blue_background);
                this.d.c.setImageResource(uu.c.com_facebook_tooltip_blue_bottomnub);
                this.d.b.setImageResource(uu.c.com_facebook_tooltip_blue_topnub);
                this.d.e.setImageResource(uu.c.com_facebook_tooltip_blue_xout);
            } else {
                this.d.d.setBackgroundResource(uu.c.com_facebook_tooltip_black_background);
                this.d.c.setImageResource(uu.c.com_facebook_tooltip_black_bottomnub);
                this.d.b.setImageResource(uu.c.com_facebook_tooltip_black_topnub);
                this.d.e.setImageResource(uu.c.com_facebook_tooltip_black_xout);
            }
            View view = ((Activity)this.c).getWindow().getDecorView();
            int n2 = view.getWidth();
            int n3 = view.getHeight();
            this.d();
            this.d.measure(View.MeasureSpec.makeMeasureSpec((int)n2, (int)Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec((int)n3, (int)Integer.MIN_VALUE));
            this.e = new PopupWindow((View)this.d, this.d.getMeasuredWidth(), this.d.getMeasuredHeight());
            this.e.showAsDropDown((View)this.b.get());
            this.c();
            if (this.g > 0) {
                this.d.postDelayed(new Runnable(){

                    public void run() {
                        ToolTipPopup.this.b();
                    }
                }, this.g);
            }
            this.e.setTouchable(true);
            this.d.setOnClickListener(new View.OnClickListener(){

                public void onClick(View view) {
                    ToolTipPopup.this.b();
                }
            });
        }
    }

    public void a(long l2) {
        this.g = l2;
    }

    public void a(Style style) {
        this.f = style;
    }

    public void b() {
        this.e();
        if (this.e != null) {
            this.e.dismiss();
        }
    }

    public static final class Style
    extends Enum<Style> {
        public static final /* enum */ Style a = new Style();
        public static final /* enum */ Style b = new Style();
        private static final /* synthetic */ Style[] c;

        static {
            Style[] arrstyle = new Style[]{a, b};
            c = arrstyle;
        }

        private Style() {
            super(string2, n2);
        }

        public static Style valueOf(String string2) {
            return (Style)Enum.valueOf((Class)Style.class, (String)string2);
        }

        public static Style[] values() {
            return (Style[])c.clone();
        }
    }

    class a
    extends FrameLayout {
        private ImageView b;
        private ImageView c;
        private View d;
        private ImageView e;

        public a(Context context) {
            super(context);
            super.c();
        }

        private void c() {
            LayoutInflater.from((Context)this.getContext()).inflate(uu.e.com_facebook_tooltip_bubble, (ViewGroup)this);
            this.b = (ImageView)this.findViewById(uu.d.com_facebook_tooltip_bubble_view_top_pointer);
            this.c = (ImageView)this.findViewById(uu.d.com_facebook_tooltip_bubble_view_bottom_pointer);
            this.d = this.findViewById(uu.d.com_facebook_body_frame);
            this.e = (ImageView)this.findViewById(uu.d.com_facebook_button_xout);
        }

        public void a() {
            this.b.setVisibility(0);
            this.c.setVisibility(4);
        }

        public void b() {
            this.b.setVisibility(4);
            this.c.setVisibility(0);
        }
    }

}

