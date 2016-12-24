/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.TimeInterpolator
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Color
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.view.ViewPropertyAnimator
 *  android.view.animation.AccelerateDecelerateInterpolator
 *  android.view.animation.LinearInterpolator
 *  android.widget.Button
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  java.util.concurrent.ConcurrentLinkedQueue
 *  rx.schedulers.Schedulers
 */
package com.becandid.candid.views;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.data.EmptyClass;
import com.becandid.candid.data.Group;
import com.becandid.candid.models.NetworkData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import rx.schedulers.Schedulers;

public class GroupStackView
extends RelativeLayout
implements View.OnClickListener,
View.OnTouchListener {
    RelativeLayout a;
    RelativeLayout b;
    ImageView c;
    private int d;
    private int e;
    private long f;
    private float g;
    private float h;
    private ConcurrentLinkedQueue<View> i;
    private ConcurrentLinkedQueue<View> j;
    private View k;
    private ArrayList<Group> l;
    private int m;
    private int n;
    private boolean o;
    private float p;
    private float q;
    private b[] r;
    private Button s;
    private Button t;
    private c u;
    private boolean v;
    private boolean w;

    public GroupStackView(Context context) {
        super(context);
        this.h = 0.0f;
        this.m = 0;
        this.n = 0;
        b[] arrb = new b[]{(GroupStackView)this.new b(-13.0f, 5.0f, -0.12f), (GroupStackView)this.new b(15.0f, -10.0f, 0.11f), (GroupStackView)this.new b(12.0f, 9.0f, -0.16f), (GroupStackView)this.new b(-12.0f, -8.0f, 0.17f), (GroupStackView)this.new b(-4.0f, -1.0f, -0.19f), (GroupStackView)this.new b(9.0f, 3.0f, 0.14f)};
        this.r = arrb;
        this.v = true;
        super.d();
    }

    public GroupStackView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = 0.0f;
        this.m = 0;
        this.n = 0;
        b[] arrb = new b[]{(GroupStackView)this.new b(-13.0f, 5.0f, -0.12f), (GroupStackView)this.new b(15.0f, -10.0f, 0.11f), (GroupStackView)this.new b(12.0f, 9.0f, -0.16f), (GroupStackView)this.new b(-12.0f, -8.0f, 0.17f), (GroupStackView)this.new b(-4.0f, -1.0f, -0.19f), (GroupStackView)this.new b(9.0f, 3.0f, 0.14f)};
        this.r = arrb;
        this.v = true;
        super.d();
    }

    public GroupStackView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.h = 0.0f;
        this.m = 0;
        this.n = 0;
        b[] arrb = new b[]{(GroupStackView)this.new b(-13.0f, 5.0f, -0.12f), (GroupStackView)this.new b(15.0f, -10.0f, 0.11f), (GroupStackView)this.new b(12.0f, 9.0f, -0.16f), (GroupStackView)this.new b(-12.0f, -8.0f, 0.17f), (GroupStackView)this.new b(-4.0f, -1.0f, -0.19f), (GroupStackView)this.new b(9.0f, 3.0f, 0.14f)};
        this.r = arrb;
        this.v = true;
        super.d();
    }

    @TargetApi(value=21)
    public GroupStackView(Context context, AttributeSet attributeSet, int n2, int n3) {
        super(context, attributeSet, n2, n3);
        this.h = 0.0f;
        this.m = 0;
        this.n = 0;
        b[] arrb = new b[]{(GroupStackView)this.new b(-13.0f, 5.0f, -0.12f), (GroupStackView)this.new b(15.0f, -10.0f, 0.11f), (GroupStackView)this.new b(12.0f, 9.0f, -0.16f), (GroupStackView)this.new b(-12.0f, -8.0f, 0.17f), (GroupStackView)this.new b(-4.0f, -1.0f, -0.19f), (GroupStackView)this.new b(9.0f, 3.0f, 0.14f)};
        this.r = arrb;
        this.v = true;
        super.d();
    }

    private void a(View view, float f2, int n2) {
        float f3 = Math.max((float)0.0f, (float)Math.min((float)1.0f, (float)(3.0f * f2 / (float)this.d - 0.2f)));
        float f4 = Math.max((float)0.0f, (float)Math.min((float)1.0f, (float)(3.0f * (- f2) / (float)this.d - 0.2f)));
        a a2 = (a)view.getTag(2131624110);
        if (n2 == 0) {
            a2.g.setAlpha(f3);
            a2.h.setAlpha(f4);
            return;
        }
        a2.g.animate().alpha(f3).setDuration((long)n2).start();
        a2.h.animate().alpha(f4).setDuration((long)n2).start();
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(final View view, int n2, int n3) {
        if (n2 > 0) {
            this.a((Group)view.getTag(2131624387));
        } else {
            this.b((Group)view.getTag(2131624387));
        }
        super.a(view, (float)n2, n3 / 4);
        int n4 = n2 + n2 / 5;
        ViewPropertyAnimator viewPropertyAnimator = view.animate().x((float)n4);
        float f2 = n4 > 0 ? 25.0f : -25.0f;
        final ViewPropertyAnimator viewPropertyAnimator2 = viewPropertyAnimator.rotation(f2);
        if (n3 >= 250 || n3 < 0) {
            viewPropertyAnimator2.setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
        } else {
            viewPropertyAnimator2.setInterpolator((TimeInterpolator)new LinearInterpolator());
        }
        viewPropertyAnimator2.setDuration((long)n3);
        viewPropertyAnimator2.setListener(new Animator.AnimatorListener(){

            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                Log.d((String)"GSV", (String)"animation end");
                view.setX(0.0f);
                GroupStackView.this.b.removeView(view);
                GroupStackView.this.a(view);
                GroupStackView.this.b();
                viewPropertyAnimator2.setListener(null);
                if (GroupStackView.this.a.getChildCount() <= 0 && GroupStackView.this.k == null) {
                    GroupStackView.this.u.onEmptyGroups();
                }
                GroupStackView.this.v = true;
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                Log.d((String)"GSV", (String)"animation start");
                GroupStackView.this.c();
                GroupStackView.this.v = false;
            }
        });
        viewPropertyAnimator2.start();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void d() {
        if (this.getChildCount() > 0) {
            return;
        }
        this.w = true;
        this.q = this.getResources().getDisplayMetrics().density;
        this.j = new ConcurrentLinkedQueue();
        this.i = new ConcurrentLinkedQueue();
        this.l = new ArrayList();
        this.a = new RelativeLayout(this.getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(0, 0, 0, (int)(50.0f * this.q));
        this.a.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        this.addView((View)this.a);
        this.c = new ImageView(this.getContext());
        this.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        this.addView((View)this.c);
        this.b = new RelativeLayout(this.getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.setMargins(0, 0, 0, (int)(50.0f * this.q));
        this.b.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
        this.addView((View)this.b);
        RelativeLayout relativeLayout = new RelativeLayout(this.getContext());
        relativeLayout.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
        this.addView((View)relativeLayout);
        relativeLayout.setOnTouchListener((View.OnTouchListener)this);
        LinearLayout linearLayout = new LinearLayout(this.getContext());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int)(40.0f * this.q));
        layoutParams3.addRule(12);
        layoutParams3.setMargins((int)(15.0f * this.q), 0, (int)(15.0f * this.q), (int)(15.0f * this.q));
        linearLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams3);
        this.addView((View)linearLayout);
        this.t = new Button(this.getContext());
        this.t.setText((CharSequence)"Skip");
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -1);
        layoutParams4.weight = 1.0f;
        this.t.setLayoutParams((ViewGroup.LayoutParams)layoutParams4);
        this.t.setBackground(this.getResources().getDrawable(2130837987));
        linearLayout.addView((View)this.t);
        this.t.setOnClickListener((View.OnClickListener)this);
        this.s = new Button(this.getContext());
        this.s.setText((CharSequence)"Join");
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(0, -1);
        layoutParams5.weight = 1.0f;
        layoutParams5.setMargins((int)(20.0f * this.q), 0, 0, 0);
        this.s.setLayoutParams((ViewGroup.LayoutParams)layoutParams5);
        this.s.setBackground(this.getResources().getDrawable(2130838157));
        this.s.setTextColor(Color.parseColor((String)"#ffffff"));
        linearLayout.addView((View)this.s);
        this.s.setOnClickListener((View.OnClickListener)this);
        int n2 = 0;
        while (n2 < 6) {
            View view = this.e();
            view.setAlpha(0.0f);
            this.a.addView(view, 0);
            ++n2;
        }
    }

    private View e() {
        View view = LayoutInflater.from((Context)this.getContext()).inflate(2130968688, (ViewGroup)this.a, false);
        view.setTag(2131624110, (Object)new a(view));
        return view;
    }

    public int a() {
        return this.l.size() - this.n;
    }

    /*
     * Enabled aggressive block sorting
     */
    public View a(Group group, int n2) {
        View view = this.j.isEmpty() ? super.e() : (View)this.j.poll();
        if (view.getAlpha() == 0.0f) {
            view.setAlpha(1.0f);
        }
        view.setTag((Object)n2);
        view.setTag(2131624387, (Object)group);
        a a2 = (a)view.getTag(2131624110);
        a2.g.setAlpha(0.0f);
        a2.h.setAlpha(0.0f);
        a2.g.setVisibility(8);
        a2.h.setVisibility(8);
        iw iw2 = new iw(this.getContext());
        if (this.w) {
            GossipApplication.c.a(group.imageUrl()).d().a((String)((int)17301613)).a(new ns[]{iw2}).a(a2.e);
        }
        a2.a.setText((CharSequence)group.group_name);
        a2.b.setText((CharSequence)group.about);
        a2.a(group.tags);
        a2.a(group);
        if (group.isFriendCreated()) {
            a2.f.setVisibility(0);
            a2.f.setTypeface(Typeface.defaultFromStyle((int)1));
        } else {
            a2.f.setVisibility(8);
        }
        this.a.addView(view, 0);
        return view;
    }

    public void a(View view) {
        if (view.getParent() != null) {
            ((ViewGroup)view.getParent()).removeView(view);
        }
        this.j.add((Object)view);
    }

    public void a(Group group) {
        ik.a().b(group.group_id).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

            public void a(NetworkData networkData) {
                if (networkData.success && GroupStackView.this.u != null) {
                    GroupStackView.this.u.onJoinGroup(networkData.group);
                }
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
                Log.d((String)"GroupStackView", (String)throwable.toString());
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((NetworkData)object);
            }
        });
    }

    public void a(List<Group> list) {
        this.l.addAll(list);
        this.b();
        this.a.requestLayout();
        for (int i2 = 0; i2 < this.a.getChildCount(); ++i2) {
            this.a.getChildAt(i2).requestLayout();
        }
        this.b.requestLayout();
    }

    public void b() {
        while (this.a.getChildCount() < 3 && this.m < this.l.size()) {
            View view = this.a((Group)this.l.get(this.m), this.m);
            b b2 = this.r[this.m % this.r.length];
            view.setTranslationX(b2.a);
            view.setTranslationY(b2.b);
            view.setRotation(b2.c);
            this.m = 1 + this.m;
        }
        this.c();
    }

    public void b(final Group group) {
        ik.a().a(group).b(Schedulers.io()).a(apv.a()).b(new apr<EmptyClass>(){

            public void a(EmptyClass emptyClass) {
                if (GroupStackView.this.u != null) {
                    GroupStackView.this.u.onSkipGroup(group);
                }
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
                Log.d((String)"GroupStackView", (String)throwable.toString());
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((EmptyClass)object);
            }
        });
    }

    public void c() {
        int n2 = this.a.getChildCount();
        if (n2 > 0 && this.k == null) {
            View view = this.a.getChildAt(n2 - 1);
            Log.d((String)"GSV", (String)("promoteNextCard: " + (Object)((TextView)view.findViewById(2131624110)).getText()));
            this.a.removeView(view);
            this.b.addView(view, 0);
            view.animate().rotation(0.0f).translationX(0.0f).translationY(0.0f).setDuration(100).start();
            this.k = view;
            this.n = this.m - n2;
            a a2 = (a)view.getTag(2131624110);
            a2.g.setVisibility(0);
            a2.h.setVisibility(0);
        }
    }

    public boolean isAttachedToWindow() {
        this.w = true;
        return super.isAttachedToWindow();
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void onClick(View view) {
        if (this.k == null) return;
        if (!this.v) {
            return;
        }
        if (view == this.s) {
            View view2 = this.k;
            this.k = null;
            super.a(view2, (float)this.d, 0);
            super.a(view2, this.d, 750);
            return;
        }
        if (view != this.t) return;
        View view3 = this.k;
        this.k = null;
        super.a(view3, (float)(- this.d), 0);
        super.a(view3, - this.d, 750);
    }

    protected void onDetachedFromWindow() {
        this.w = false;
        super.onDetachedFromWindow();
    }

    protected void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
        super.onLayout(bl2, n2, n3, n4, n5);
        this.d = this.getMeasuredWidth();
        this.e = this.getMeasuredHeight();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean onTouch(View var1, MotionEvent var2_2) {
        if (this.k == null) {
            return false;
        }
        var3_3 = var2_2.getX();
        if (var2_2.getAction() == 0) {
            if (this.u != null) {
                this.u.onTouchEvent((Group)this.k.getTag(2131624387));
            }
            this.o = true;
            this.p = var3_3;
            this.f = System.currentTimeMillis();
            this.g = this.p;
            this.h = 0.0f;
            this.k.findViewById(2131624495).setVisibility(0);
            this.k.findViewById(2131624496).setVisibility(0);
            return true;
        }
        var4_4 = var3_3 - this.p;
        if (var2_2.getAction() == 2 && this.o) {
            this.k.setX(var4_4);
            this.k.setRotation(25.0f * var4_4 / (float)this.d);
            super.a(this.k, var4_4, 0);
            var13_5 = System.currentTimeMillis();
            if (this.f > 0) {
                this.h = 0.5f * this.h + 0.5f * (var3_3 - this.g) / (float)(var13_5 - this.f);
                this.h = this.h > 0.0f ? Math.max((float)this.h, (float)1.0f) : Math.min((float)this.h, (float)-1.0f);
            }
            this.g = var3_3;
            this.f = var13_5;
            return true;
        }
        if (var2_2.getAction() != 1) return false;
        Log.d((String)"GSV", (String)("drag end at " + var4_4 + " vel: " + this.h + " (sw: " + this.d));
        var6_6 = (int)var4_4 + (int)(200.0f * this.h);
        if (var6_6 <= this.d / 2) ** GOTO lbl35
        Log.d((String)"GSV", (String)"fling right");
        var8_7 = Math.abs((int)((int)(((float)this.d - var3_3 + this.p) / Math.abs((float)this.h))));
        var9_8 = this.d;
        ** GOTO lbl42
lbl35: // 1 sources:
        var7_10 = (- this.d) / 2;
        var8_7 = 0;
        var9_8 = 0;
        if (var6_6 < var7_10) {
            Log.d((String)"GSV", (String)"fling left");
            var8_7 = Math.abs((int)((int)((var4_4 + (float)this.d) / Math.abs((float)this.h))));
            var9_8 = - this.d;
lbl42: // 2 sources:
            if (var9_8 != 0) {
                var11_9 = this.k;
                this.k = null;
                super.a(var11_9, var9_8, var8_7);
                return true;
            }
        }
        this.k.animate().x(0.0f).rotation(0.0f).setDuration(250).start();
        super.a(this.k, 0.0f, 150);
        return true;
    }

    public void setGroups(List<Group> list) {
        this.l.clear();
        this.m = 0;
        this.n = 0;
        for (int i2 = 0; i2 < this.a.getChildCount(); ++i2) {
            View view = this.a.getChildAt(i2);
            this.j.add((Object)view);
        }
        this.a.removeAllViews();
        if (this.k != null) {
            this.b.removeView(this.k);
        }
        this.k = null;
        this.a(list);
    }

    public void setListener(c c2) {
        this.u = c2;
    }

    public class a {
        TextView a;
        TextView b;
        TextView c;
        TextView[] d;
        ImageView e;
        TextView f;
        ImageView g;
        ImageView h;

        public a(View view) {
            this.a = (TextView)view.findViewById(2131624110);
            this.b = (TextView)view.findViewById(2131624494);
            this.c = (TextView)view.findViewById(2131624387);
            TextView[] arrtextView = new TextView[]{(TextView)view.findViewById(2131624383), (TextView)view.findViewById(2131624384), (TextView)view.findViewById(2131624385)};
            this.d = arrtextView;
            this.e = (ImageView)view.findViewById(2131624379);
            this.f = (TextView)view.findViewById(2131624493);
            this.g = (ImageView)view.findViewById(2131624495);
            this.h = (ImageView)view.findViewById(2131624496);
        }

        public void a(Group group) {
            StringBuilder stringBuilder = new StringBuilder(50);
            if (group.num_friends > 1) {
                stringBuilder.append("" + group.num_friends + " friends   ");
            }
            stringBuilder.append("" + group.num_members + " member");
            if (group.num_members != 1) {
                stringBuilder.append("s");
            }
            stringBuilder.append("   " + group.num_posts + " post");
            if (group.num_posts != 1) {
                stringBuilder.append("s");
            }
            this.c.setText((CharSequence)stringBuilder.toString());
        }

        /*
         * Enabled aggressive block sorting
         */
        public void a(List<String> list) {
            int n2 = 0;
            while (n2 < this.d.length) {
                if (n2 < list.size()) {
                    this.d[n2].setText((CharSequence)list.get(n2));
                    this.d[n2].setVisibility(0);
                } else {
                    this.d[n2].setVisibility(8);
                }
                ++n2;
            }
        }
    }

    class b {
        float a;
        float b;
        float c;

        public b(float f2, float f3, float f4) {
            this.a = f2;
            this.b = f3;
            this.c = 60.0f * f4 / 3.1415927f;
        }
    }

    public static interface c {
        public void onEmptyGroups();

        public void onJoinGroup(Group var1);

        public void onSkipGroup(Group var1);

        public void onTouchEvent(Group var1);
    }

}

