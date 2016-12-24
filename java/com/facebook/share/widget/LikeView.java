/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Fragment
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.os.Bundle
 *  android.support.v4.app.Fragment
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.IllegalArgumentException
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 */
package com.facebook.share.widget;

import android.app.Activity;
import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.FacebookException;
import com.facebook.share.internal.LikeBoxCountView;
import com.facebook.share.internal.LikeButton;

public class LikeView
extends FrameLayout {
    private String a;
    private ObjectType b;
    private LinearLayout c;
    private LikeButton d;
    private LikeBoxCountView e;
    private TextView f;
    private ws g;
    private c h;
    private BroadcastReceiver i;
    private a j;
    private Style k = Style.d;
    private HorizontalAlignment l = HorizontalAlignment.d;
    private AuxiliaryViewPosition m = AuxiliaryViewPosition.d;
    private int n = -1;
    private int o;
    private int p;
    private vq q;
    private boolean r;

    public LikeView(Context context) {
        super(context);
        super.a(context);
    }

    public LikeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.a(attributeSet);
        super.a(context);
    }

    private void a() {
        if (this.g != null) {
            vq vq2 = this.q;
            Activity activity = null;
            if (vq2 == null) {
                activity = this.getActivity();
            }
            this.g.a(activity, this.q, this.getAnalyticsParameters());
        }
    }

    private void a(Context context) {
        this.o = this.getResources().getDimensionPixelSize(uu.b.com_facebook_likeview_edge_padding);
        this.p = this.getResources().getDimensionPixelSize(uu.b.com_facebook_likeview_internal_padding);
        if (this.n == -1) {
            this.n = this.getResources().getColor(uu.a.com_facebook_likeview_text_color);
        }
        this.setBackgroundColor(0);
        this.c = new LinearLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        this.c.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        super.b(context);
        super.c(context);
        super.d(context);
        this.c.addView((View)this.d);
        this.c.addView((View)this.f);
        this.c.addView((View)this.e);
        this.addView((View)this.c);
        super.a(this.a, this.b);
        super.c();
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(AttributeSet attributeSet) {
        TypedArray typedArray;
        if (attributeSet == null || this.getContext() == null || (typedArray = this.getContext().obtainStyledAttributes(attributeSet, uu.h.com_facebook_like_view)) == null) {
            return;
        }
        this.a = we.a(typedArray.getString(uu.h.com_facebook_like_view_com_facebook_object_id), null);
        this.b = ObjectType.a(typedArray.getInt(uu.h.com_facebook_like_view_com_facebook_object_type, ObjectType.d.a()));
        this.k = Style.a(typedArray.getInt(uu.h.com_facebook_like_view_com_facebook_style, Style.d.a()));
        if (this.k == null) {
            throw new IllegalArgumentException("Unsupported value for LikeView 'style'");
        }
        this.m = AuxiliaryViewPosition.a(typedArray.getInt(uu.h.com_facebook_like_view_com_facebook_auxiliary_view_position, AuxiliaryViewPosition.d.a()));
        if (this.m == null) {
            throw new IllegalArgumentException("Unsupported value for LikeView 'auxiliary_view_position'");
        }
        this.l = HorizontalAlignment.a(typedArray.getInt(uu.h.com_facebook_like_view_com_facebook_horizontal_alignment, HorizontalAlignment.d.a()));
        if (this.l == null) {
            throw new IllegalArgumentException("Unsupported value for LikeView 'horizontal_alignment'");
        }
        this.n = typedArray.getColor(uu.h.com_facebook_like_view_com_facebook_foreground_color, -1);
        typedArray.recycle();
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void a(String string2, ObjectType objectType) {
        super.b();
        this.a = string2;
        this.b = objectType;
        if (we.a(string2)) {
            return;
        }
        this.j = new a((LikeView)this, null);
        if (this.isInEditMode()) return;
        ws.a(string2, objectType, (ws.c)this.j);
    }

    private void a(ws ws2) {
        this.g = ws2;
        this.i = new b((LikeView)this, null);
        bn bn2 = bn.a(this.getContext());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.facebook.sdk.LikeActionController.UPDATED");
        intentFilter.addAction("com.facebook.sdk.LikeActionController.DID_ERROR");
        intentFilter.addAction("com.facebook.sdk.LikeActionController.DID_RESET");
        bn2.a(this.i, intentFilter);
    }

    private void b() {
        if (this.i != null) {
            bn.a(this.getContext()).a(this.i);
            this.i = null;
        }
        if (this.j != null) {
            this.j.a();
            this.j = null;
        }
        this.g = null;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void b(Context context) {
        boolean bl2 = this.g != null && this.g.d();
        this.d = new LikeButton(context, bl2);
        this.d.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                LikeView.this.a();
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.d.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void c() {
        boolean bl2 = !this.r;
        if (this.g == null) {
            this.d.setSelected(false);
            this.f.setText(null);
            this.e.setText(null);
        } else {
            this.d.setSelected(this.g.d());
            this.f.setText((CharSequence)this.g.c());
            this.e.setText(this.g.b());
            bl2 &= this.g.e();
        }
        super.setEnabled(bl2);
        this.d.setEnabled(bl2);
        this.d();
    }

    private void c(Context context) {
        this.f = new TextView(context);
        this.f.setTextSize(0, this.getResources().getDimension(uu.b.com_facebook_likeview_text_size));
        this.f.setMaxLines(2);
        this.f.setTextColor(this.n);
        this.f.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        this.f.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void d() {
        Object object;
        int n2 = 1;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.c.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams)this.d.getLayoutParams();
        int n3 = this.l == HorizontalAlignment.b ? 3 : (this.l == HorizontalAlignment.a ? n2 : 5);
        layoutParams.gravity = n3 | 48;
        layoutParams2.gravity = n3;
        this.f.setVisibility(8);
        this.e.setVisibility(8);
        if (this.k == Style.a && this.g != null && !we.a(this.g.c())) {
            object = this.f;
        } else {
            if (this.k != Style.c) return;
            if (this.g == null) return;
            if (we.a(this.g.b())) return;
            this.e();
            object = this.e;
        }
        object.setVisibility(0);
        ((LinearLayout.LayoutParams)object.getLayoutParams()).gravity = n3;
        LinearLayout linearLayout = this.c;
        if (this.m == AuxiliaryViewPosition.b) {
            n2 = 0;
        }
        linearLayout.setOrientation(n2);
        if (this.m == AuxiliaryViewPosition.c || this.m == AuxiliaryViewPosition.b && this.l == HorizontalAlignment.c) {
            this.c.removeView((View)this.d);
            this.c.addView((View)this.d);
        } else {
            this.c.removeView((View)object);
            this.c.addView((View)object);
        }
        switch (.a[this.m.ordinal()]) {
            default: {
                return;
            }
            case 1: {
                object.setPadding(this.o, this.o, this.o, this.p);
                return;
            }
            case 2: {
                object.setPadding(this.o, this.p, this.o, this.o);
                return;
            }
            case 3: 
        }
        if (this.l == HorizontalAlignment.c) {
            object.setPadding(this.o, this.o, this.p, this.o);
            return;
        }
        object.setPadding(this.p, this.o, this.o, this.o);
    }

    private void d(Context context) {
        this.e = new LikeBoxCountView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.e.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void e() {
        switch (.a[this.m.ordinal()]) {
            default: {
                return;
            }
            case 1: {
                this.e.setCaretPosition(LikeBoxCountView.LikeBoxCountViewCaretPosition.d);
                return;
            }
            case 2: {
                this.e.setCaretPosition(LikeBoxCountView.LikeBoxCountViewCaretPosition.b);
                return;
            }
            case 3: 
        }
        LikeBoxCountView likeBoxCountView = this.e;
        LikeBoxCountView.LikeBoxCountViewCaretPosition likeBoxCountViewCaretPosition = this.l == HorizontalAlignment.c ? LikeBoxCountView.LikeBoxCountViewCaretPosition.c : LikeBoxCountView.LikeBoxCountViewCaretPosition.a;
        likeBoxCountView.setCaretPosition(likeBoxCountViewCaretPosition);
    }

    private Activity getActivity() {
        Context context = this.getContext();
        while (!(context instanceof Activity) && context instanceof ContextWrapper) {
            context = ((ContextWrapper)context).getBaseContext();
        }
        if (context instanceof Activity) {
            return (Activity)context;
        }
        throw new FacebookException("Unable to get Activity.");
    }

    private Bundle getAnalyticsParameters() {
        Bundle bundle = new Bundle();
        bundle.putString("style", this.k.toString());
        bundle.putString("auxiliary_position", this.m.toString());
        bundle.putString("horizontal_alignment", this.l.toString());
        bundle.putString("object_id", we.a(this.a, ""));
        bundle.putString("object_type", this.b.toString());
        return bundle;
    }

    public c getOnErrorListener() {
        return this.h;
    }

    protected void onDetachedFromWindow() {
        this.setObjectIdAndType(null, ObjectType.a);
        super.onDetachedFromWindow();
    }

    /*
     * Enabled aggressive block sorting
     */
    public void setAuxiliaryViewPosition(AuxiliaryViewPosition auxiliaryViewPosition) {
        if (auxiliaryViewPosition == null) {
            auxiliaryViewPosition = AuxiliaryViewPosition.d;
        }
        if (this.m != auxiliaryViewPosition) {
            this.m = auxiliaryViewPosition;
            super.d();
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void setEnabled(boolean bl2) {
        boolean bl3 = !bl2;
        this.r = bl3;
        super.c();
    }

    public void setForegroundColor(int n2) {
        if (this.n != n2) {
            this.f.setTextColor(n2);
        }
    }

    public void setFragment(Fragment fragment) {
        this.q = new vq(fragment);
    }

    public void setFragment(android.support.v4.app.Fragment fragment) {
        this.q = new vq(fragment);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void setHorizontalAlignment(HorizontalAlignment horizontalAlignment) {
        if (horizontalAlignment == null) {
            horizontalAlignment = HorizontalAlignment.d;
        }
        if (this.l != horizontalAlignment) {
            this.l = horizontalAlignment;
            super.d();
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void setLikeViewStyle(Style style) {
        if (style == null) {
            style = Style.d;
        }
        if (this.k != style) {
            this.k = style;
            super.d();
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void setObjectIdAndType(String string2, ObjectType objectType) {
        String string3 = we.a(string2, null);
        if (objectType == null) {
            objectType = ObjectType.d;
        }
        if (!we.a(string3, this.a) || objectType != this.b) {
            super.a(string3, objectType);
            super.c();
        }
    }

    public void setOnErrorListener(c c2) {
        this.h = c2;
    }

    public static final class AuxiliaryViewPosition
    extends Enum<AuxiliaryViewPosition> {
        public static final /* enum */ AuxiliaryViewPosition a = new AuxiliaryViewPosition("bottom", 0);
        public static final /* enum */ AuxiliaryViewPosition b = new AuxiliaryViewPosition("inline", 1);
        public static final /* enum */ AuxiliaryViewPosition c = new AuxiliaryViewPosition("top", 2);
        static AuxiliaryViewPosition d;
        private static final /* synthetic */ AuxiliaryViewPosition[] g;
        private String e;
        private int f;

        static {
            AuxiliaryViewPosition[] arrauxiliaryViewPosition = new AuxiliaryViewPosition[]{a, b, c};
            g = arrauxiliaryViewPosition;
            d = a;
        }

        private AuxiliaryViewPosition(String string3, int n3) {
            super(string2, n2);
            this.e = string3;
            this.f = n3;
        }

        private int a() {
            return this.f;
        }

        static AuxiliaryViewPosition a(int n2) {
            for (AuxiliaryViewPosition auxiliaryViewPosition : AuxiliaryViewPosition.values()) {
                if (auxiliaryViewPosition.a() != n2) continue;
                return auxiliaryViewPosition;
            }
            return null;
        }

        public static AuxiliaryViewPosition valueOf(String string2) {
            return (AuxiliaryViewPosition)Enum.valueOf((Class)AuxiliaryViewPosition.class, (String)string2);
        }

        public static AuxiliaryViewPosition[] values() {
            return (AuxiliaryViewPosition[])g.clone();
        }

        public String toString() {
            return this.e;
        }
    }

    public static final class HorizontalAlignment
    extends Enum<HorizontalAlignment> {
        public static final /* enum */ HorizontalAlignment a = new HorizontalAlignment("center", 0);
        public static final /* enum */ HorizontalAlignment b = new HorizontalAlignment("left", 1);
        public static final /* enum */ HorizontalAlignment c = new HorizontalAlignment("right", 2);
        static HorizontalAlignment d;
        private static final /* synthetic */ HorizontalAlignment[] g;
        private String e;
        private int f;

        static {
            HorizontalAlignment[] arrhorizontalAlignment = new HorizontalAlignment[]{a, b, c};
            g = arrhorizontalAlignment;
            d = a;
        }

        private HorizontalAlignment(String string3, int n3) {
            super(string2, n2);
            this.e = string3;
            this.f = n3;
        }

        private int a() {
            return this.f;
        }

        static HorizontalAlignment a(int n2) {
            for (HorizontalAlignment horizontalAlignment : HorizontalAlignment.values()) {
                if (horizontalAlignment.a() != n2) continue;
                return horizontalAlignment;
            }
            return null;
        }

        public static HorizontalAlignment valueOf(String string2) {
            return (HorizontalAlignment)Enum.valueOf((Class)HorizontalAlignment.class, (String)string2);
        }

        public static HorizontalAlignment[] values() {
            return (HorizontalAlignment[])g.clone();
        }

        public String toString() {
            return this.e;
        }
    }

    public static final class ObjectType
    extends Enum<ObjectType> {
        public static final /* enum */ ObjectType a = new ObjectType("unknown", 0);
        public static final /* enum */ ObjectType b = new ObjectType("open_graph", 1);
        public static final /* enum */ ObjectType c = new ObjectType("page", 2);
        public static ObjectType d;
        private static final /* synthetic */ ObjectType[] g;
        private String e;
        private int f;

        static {
            ObjectType[] arrobjectType = new ObjectType[]{a, b, c};
            g = arrobjectType;
            d = a;
        }

        private ObjectType(String string3, int n3) {
            super(string2, n2);
            this.e = string3;
            this.f = n3;
        }

        public static ObjectType a(int n2) {
            for (ObjectType objectType : ObjectType.values()) {
                if (objectType.a() != n2) continue;
                return objectType;
            }
            return null;
        }

        public static ObjectType valueOf(String string2) {
            return (ObjectType)Enum.valueOf((Class)ObjectType.class, (String)string2);
        }

        public static ObjectType[] values() {
            return (ObjectType[])g.clone();
        }

        public int a() {
            return this.f;
        }

        public String toString() {
            return this.e;
        }
    }

    public static final class Style
    extends Enum<Style> {
        public static final /* enum */ Style a = new Style("standard", 0);
        public static final /* enum */ Style b = new Style("button", 1);
        public static final /* enum */ Style c = new Style("box_count", 2);
        static Style d;
        private static final /* synthetic */ Style[] g;
        private String e;
        private int f;

        static {
            Style[] arrstyle = new Style[]{a, b, c};
            g = arrstyle;
            d = a;
        }

        private Style(String string3, int n3) {
            super(string2, n2);
            this.e = string3;
            this.f = n3;
        }

        private int a() {
            return this.f;
        }

        static Style a(int n2) {
            for (Style style : Style.values()) {
                if (style.a() != n2) continue;
                return style;
            }
            return null;
        }

        public static Style valueOf(String string2) {
            return (Style)Enum.valueOf((Class)Style.class, (String)string2);
        }

        public static Style[] values() {
            return (Style[])g.clone();
        }

        public String toString() {
            return this.e;
        }
    }

    class a
    implements ws.c {
        final /* synthetic */ LikeView a;
        private boolean b;

        private a(LikeView likeView) {
            this.a = likeView;
        }

        /* synthetic */ a(LikeView likeView,  var2_2) {
            super(likeView);
        }

        public void a() {
            this.b = true;
        }

        @Override
        public void a(ws ws2, FacebookException facebookException) {
            if (this.b) {
                return;
            }
            if (ws2 != null) {
                if (!ws2.e()) {
                    facebookException = new FacebookException("Cannot use LikeView. The device may not be supported.");
                }
                this.a.a(ws2);
                this.a.c();
            }
            if (facebookException != null && this.a.h != null) {
                this.a.h.a(facebookException);
            }
            this.a.j = null;
        }
    }

    class b
    extends BroadcastReceiver {
        final /* synthetic */ LikeView a;

        private b(LikeView likeView) {
            this.a = likeView;
        }

        /* synthetic */ b(LikeView likeView,  var2_2) {
            super(likeView);
        }

        /*
         * Enabled aggressive block sorting
         */
        public void onReceive(Context context, Intent intent) {
            String string2 = intent.getAction();
            Bundle bundle = intent.getExtras();
            boolean bl2 = true;
            if (bundle != null) {
                String string3 = bundle.getString("com.facebook.sdk.LikeActionController.OBJECT_ID");
                if (!we.a(string3) && !we.a(this.a.a, string3)) {
                    return;
                }
                bl2 = true;
                if (!bl2) return;
            }
            if ("com.facebook.sdk.LikeActionController.UPDATED".equals((Object)string2)) {
                this.a.c();
                return;
            }
            if ("com.facebook.sdk.LikeActionController.DID_ERROR".equals((Object)string2)) {
                if (this.a.h == null) return;
                {
                    this.a.h.a(vz.a(bundle));
                    return;
                }
            }
            if (!"com.facebook.sdk.LikeActionController.DID_RESET".equals((Object)string2)) {
                return;
            }
            this.a.a(this.a.a, this.a.b);
            this.a.c();
        }
    }

    public static interface c {
        public void a(FacebookException var1);
    }

}

