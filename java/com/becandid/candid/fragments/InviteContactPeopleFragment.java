/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.FragmentActivity
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  butterknife.OnClick
 *  butterknife.Unbinder
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.becandid.candid.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.becandid.candid.activities.InviteContactsActivity;
import com.becandid.candid.data.Post;
import com.becandid.candid.views.viewholders.ImagePostViewHolder;
import com.becandid.candid.views.viewholders.LinkPostViewHolder;
import com.becandid.candid.views.viewholders.TextPostViewHolder;

public class InviteContactPeopleFragment
extends Fragment {
    int a = -1;
    int b = -1;
    int c = -1;
    int d = -1;
    Runnable e;
    private Unbinder f;
    private Bundle g;
    private Handler h;
    @BindView(value=2131624466)
    FrameLayout mEntirePostSnippet;
    @BindView(value=2131624463)
    ImageView mPostPlaceholder;
    @BindView(value=2131624462)
    ImageView mPostPreview;
    @BindView(value=2131624461)
    FrameLayout mPostSnippet;

    public InviteContactPeopleFragment() {
        this.e = new Runnable(){

            public void run() {
                InviteContactPeopleFragment.this.a();
            }
        };
    }

    private void a() {
        this.mEntirePostSnippet.setDrawingCacheEnabled(true);
        this.mEntirePostSnippet.buildDrawingCache();
        Bitmap bitmap = this.mEntirePostSnippet.getDrawingCache();
        if (bitmap == null) {
            return;
        }
        if (this.a == -1 && this.b == -1) {
            int n2 = this.mEntirePostSnippet.getHeight();
            int n3 = this.mEntirePostSnippet.getWidth();
            this.a = this.mPostSnippet.getHeight();
            this.b = n3 * this.a / n2;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(this.getResources(), Bitmap.createScaledBitmap((Bitmap)bitmap, (int)this.b, (int)this.a, (boolean)true));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, this.a);
        layoutParams.addRule(3, 2131624444);
        layoutParams.addRule(2, 2131624448);
        layoutParams.addRule(14);
        this.mPostSnippet.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        this.mPostPreview.setImageDrawable((Drawable)bitmapDrawable);
        this.mEntirePostSnippet.setVisibility(8);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void a(String var1, String var2_2) {
        var3_3 = (Post)new aih().a(var1, Post.class);
        if (var3_3 == null) {
            rj.a(new Throwable("post object is null in setup post preview"));
            this.getActivity().finish();
            return;
        }
        this.c = var3_3.group_id;
        if (this.getActivity() instanceof InviteContactsActivity) {
            ((InviteContactsActivity)this.getActivity()).setGroupId(this.c);
        }
        var4_4 = var3_3.type;
        var5_5 = this.getContext();
        var6_6 = -1;
        switch (var4_4.hashCode()) {
            case 100313435: {
                if (var4_4.equals((Object)"image")) {
                    var6_6 = 0;
                }
            }
            default: {
                ** GOTO lbl21
            }
            case 3321850: 
        }
        if (var4_4.equals((Object)"link")) {
            var6_6 = 1;
        }
lbl21: // 4 sources:
        switch (var6_6) {
            default: {
                var9_7 = new TextPostViewHolder(LayoutInflater.from((Context)var5_5).inflate(2130968667, null, false), (Activity)this.getActivity());
                TextPostViewHolder.a(var9_7, var3_3);
                this.mEntirePostSnippet.addView(var9_7.itemView);
                break;
            }
            case 0: {
                var8_8 = new ImagePostViewHolder(LayoutInflater.from((Context)var5_5).inflate(2130968665, null, false), (Activity)this.getActivity(), true);
                if (var3_3.localBitmapPath == null) {
                    var3_3.localBitmapPath = var2_2;
                }
                ImagePostViewHolder.a(var8_8, var3_3);
                this.mEntirePostSnippet.addView(var8_8.itemView);
                break;
            }
            case 1: {
                var7_9 = new LinkPostViewHolder(LayoutInflater.from((Context)var5_5).inflate(2130968666, null, false), (Activity)this.getActivity());
                LinkPostViewHolder.a(var7_9, var3_3);
                this.mEntirePostSnippet.addView(var7_9.itemView);
            }
        }
        this.mEntirePostSnippet.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(){

            public void onGlobalLayout() {
                InviteContactPeopleFragment.this.mEntirePostSnippet.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
                InviteContactPeopleFragment.this.mEntirePostSnippet.requestLayout();
                InviteContactPeopleFragment.this.h.post(InviteContactPeopleFragment.this.e);
            }
        });
    }

    @OnClick(value={2131624465})
    public void chooseContacts(View view) {
        ((InviteContactsActivity)this.getActivity()).chooseContacts(view);
    }

    @OnClick(value={2131624464})
    public void inviteAll(View view) {
        ((InviteContactsActivity)this.getActivity()).inviteAll(view);
    }

    @OnClick(value={2131624445})
    public void onContactClose() {
        this.getActivity().finish();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public View onCreateView(LayoutInflater var1, ViewGroup var2_3, Bundle var3_2) {
        var4_4 = var1.inflate(2130968675, var2_3, false);
        this.f = ButterKnife.bind((Object)this, (View)var4_4);
        this.g = this.getArguments();
        this.h = new Handler(this.getActivity().getMainLooper());
        var5_5 = this.g.getString("post");
        var6_6 = this.g.getString("link_image_path");
        if (var5_5 == null) ** GOTO lbl10
        super.a(var5_5, var6_6);
        ** GOTO lbl40
lbl10: // 1 sources:
        this.mPostPlaceholder.setVisibility(0);
        var7_7 = this.g.getString("invite_type");
        if (var7_7 == null) ** GOTO lbl34
        switch (var7_7.hashCode()) {
            case 2493632: {
                if (!var7_7.equals((Object)"Post")) ** GOTO lbl18
                var8_8 = 0;
                ** GOTO lbl25
            }
lbl18: // 2 sources:
            default: {
                ** GOTO lbl-1000
            }
            case 69076575: 
        }
        if (var7_7.equals((Object)"Group")) {
            var8_8 = 1;
        } else lbl-1000: // 2 sources:
        {
            var8_8 = -1;
        }
lbl25: // 3 sources:
        switch (var8_8) {
            default: {
                this.mPostPlaceholder.setImageResource(2130838034);
                break;
            }
            case 0: {
                this.mPostPlaceholder.setImageResource(2130838033);
                break;
            }
            case 1: {
                this.mPostPlaceholder.setImageResource(2130838035);
            }
        }
lbl34: // 4 sources:
        this.c = this.g.getInt("groupId", -1);
        if (this.getActivity() instanceof InviteContactsActivity) {
            ((InviteContactsActivity)this.getActivity()).setGroupId(this.c);
        }
        this.d = this.g.getInt("upsellId", -1);
        if (this.getActivity() instanceof InviteContactsActivity) {
            ((InviteContactsActivity)this.getActivity()).setUpsellId(this.d);
        }
lbl40: // 4 sources:
        var4_4.findViewById(2131624464).setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                ((InviteContactsActivity)InviteContactPeopleFragment.this.getActivity()).inviteAllWithCheck(view);
            }
        });
        var4_4.findViewById(2131624465).setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                ((InviteContactsActivity)InviteContactPeopleFragment.this.getActivity()).chooseContactsWithCheck(view);
            }
        });
        return var4_4;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f.unbind();
    }

    public void onPause() {
        super.onPause();
        this.h.removeCallbacks(this.e);
    }

    public void onResume() {
        ViewTreeObserver viewTreeObserver;
        super.onResume();
        if (this.mPostPlaceholder.getVisibility() != 0 && (viewTreeObserver = this.mEntirePostSnippet.getViewTreeObserver()).isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(){

                public void onGlobalLayout() {
                    if (InviteContactPeopleFragment.this.mEntirePostSnippet != null) {
                        InviteContactPeopleFragment.this.mEntirePostSnippet.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
                        InviteContactPeopleFragment.this.h.postDelayed(InviteContactPeopleFragment.this.e, 3000);
                    }
                }
            });
        }
    }

}

