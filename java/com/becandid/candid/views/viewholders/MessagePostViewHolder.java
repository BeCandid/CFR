/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.graphics.Color
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.text.Spannable
 *  android.util.DisplayMetrics
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  butterknife.BindView
 *  com.bumptech.glide.load.engine.DiskCacheStrategy
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.text.DecimalFormat
 */
package com.becandid.candid.views.viewholders;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Spannable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.PostDetailsActivity;
import com.becandid.candid.data.Message;
import com.becandid.candid.data.Post;
import com.becandid.candid.util.RoundedCornersTransformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import java.text.DecimalFormat;

public class MessagePostViewHolder
extends jc {
    @BindView(value=2131624264)
    View mHeader;
    @BindView(value=2131624769)
    public TextView mPostAuthor;
    @BindView(value=2131624392)
    TextView mPostCaption;
    @BindView(value=2131624779)
    public TextView mPostGroup;
    @BindView(value=2131624776)
    public FrameLayout mPostGroupContainer;
    @BindView(value=2131624778)
    public View mPostGroupMenu;
    @BindView(value=2131624777)
    RelativeLayout mPostGroupMenuContainer;
    @BindView(value=2131624770)
    View mPostHeaderBadge;
    @BindView(value=2131624772)
    FrameLayout mPostHeaderBadgeDot;
    @BindView(value=2131624773)
    TextView mPostHeaderBadgeScore;
    @BindView(value=2131624771)
    TextView mPostHeaderBadgeText;
    @BindView(value=2131624766)
    public TextView mPostIcon;
    @BindView(value=2131624393)
    ImageView mPostImage;
    @BindView(value=2131624397)
    TextView mPostLinkDesc;
    @BindView(value=2131624398)
    TextView mPostLinkDomain;
    @BindView(value=2131624395)
    ImageView mPostLinkImage;
    @BindView(value=2131624394)
    LinearLayout mPostLinkPlacehoder;
    @BindView(value=2131624396)
    TextView mPostLinkTitle;
    @BindView(value=2131624767)
    public ImageView mPostModIcon;
    @BindView(value=2131624768)
    View mPostPopupAction;
    @BindView(value=2131624391)
    LinearLayout mPostRow;
    @BindView(value=2131624774)
    public TextView mPostTimestamp;
    @BindView(value=2131624399)
    TextView messagePostDeleted;
    @BindView(value=2131624390)
    FrameLayout messagePostWrapper;

    public MessagePostViewHolder(View view, Activity activity) {
        super(view, activity);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(Post post, MessagePostViewHolder messagePostViewHolder) {
        String string2 = post.icon_name;
        int n2 = Color.parseColor((String)post.icon_color);
        if (post.is_candid_mod == 1) {
            messagePostViewHolder.mPostIcon.setVisibility(8);
            messagePostViewHolder.mPostModIcon.setVisibility(0);
        } else {
            super.a(string2, n2, messagePostViewHolder.mPostIcon, messagePostViewHolder.f, 40);
            messagePostViewHolder.mPostModIcon.setVisibility(8);
        }
        messagePostViewHolder.mPostAuthor.setText((CharSequence)post.user_name);
        messagePostViewHolder.mPostTimestamp.setText((CharSequence)post.post_time_ago);
        messagePostViewHolder.mPostGroup.setText((CharSequence)post.group_name);
        messagePostViewHolder.mPostGroup.setTextColor(n2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        messagePostViewHolder.mPostGroup.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        messagePostViewHolder.mPostGroup.setPadding(jb.a(10, this.f), jb.a(4, this.f), jb.a(10, this.f), jb.a(4, this.f));
        if (post.quality_score == 0.0f && post.is_friend != 1 && post.thats_me != 1 && post.is_candid_mod != 1) {
            messagePostViewHolder.mPostHeaderBadge.setVisibility(8);
            return;
        }
        String string3 = new DecimalFormat("#").format((double)post.quality_score);
        messagePostViewHolder.mPostHeaderBadge.setVisibility(0);
        String string4 = "";
        if (post.is_candid_mod == 1) {
            string4 = "MOD";
        } else if (post.thats_me == 1) {
            string4 = "YOU";
        } else if (post.is_friend == 1) {
            string4 = "FRIEND";
        }
        messagePostViewHolder.mPostHeaderBadgeText.setText((CharSequence)string4);
        messagePostViewHolder.mPostHeaderBadgeText.setTextColor(n2);
        if (post.quality_score == 0.0f) {
            messagePostViewHolder.mPostHeaderBadgeScore.setVisibility(8);
            messagePostViewHolder.mPostHeaderBadgeDot.setVisibility(8);
            return;
        }
        messagePostViewHolder.mPostHeaderBadgeScore.setVisibility(0);
        messagePostViewHolder.mPostHeaderBadgeScore.setText((CharSequence)string3);
        messagePostViewHolder.mPostHeaderBadgeScore.setTextColor(n2);
        if (!string4.isEmpty()) {
            messagePostViewHolder.mPostHeaderBadgeDot.setVisibility(0);
            Drawable drawable = messagePostViewHolder.f.getResources().getDrawable(2130837707);
            drawable.setColorFilter(n2, PorterDuff.Mode.SRC_IN);
            messagePostViewHolder.mPostHeaderBadgeDot.setBackground(drawable);
            return;
        }
        messagePostViewHolder.mPostHeaderBadgeDot.setVisibility(8);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static void a(final MessagePostViewHolder var0_1, Message var1) {
        var2_2 = var1.post;
        if (var2_2 == null) {
            var0_1.mPostRow.setVisibility(8);
            var0_1.messagePostDeleted.setVisibility(0);
            return;
        }
        var0_1.mPostRow.setVisibility(0);
        var0_1.messagePostDeleted.setVisibility(8);
        var0_1.messagePostWrapper.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                PostDetailsActivity.startPostDetailsActivity(var2_2.post_id, var0_1.f, var2_2.icon_color);
            }
        });
        var0_1.a(var2_2, var0_1);
        jb.a((View)var0_1.mPostRow, var2_2.icon_color);
        var0_1.mPostCaption.setTypeface(ih.a(var0_1.f).a("JosefinSans-SemiBold.ttf"));
        var3_3 = var2_2.caption;
        if (var3_3 != null) {
            var16_4 = jb.a(var3_3, Color.parseColor((String)"#99FFFFFF"), 100, 3);
            var0_1.mPostCaption.setText((CharSequence)var16_4);
        } else {
            var0_1.mPostCaption.setVisibility(8);
        }
        if (var2_2.link_domain != null) {
            var0_1.mPostLinkPlacehoder.setVisibility(0);
            var0_1.mPostLinkTitle.setText((CharSequence)var2_2.og_title);
            var0_1.mPostLinkDesc.setText((CharSequence)var2_2.og_desc);
            var0_1.mPostLinkDomain.setText((CharSequence)var2_2.link_domain);
            var4_5 = true;
        } else {
            var0_1.mPostLinkPlacehoder.setVisibility(8);
            var4_5 = false;
        }
        var5_6 = new RoundedCornersTransformation(var0_1.f, jb.a(10, var0_1.f), 3, RoundedCornersTransformation.CornerType.f);
        if (var2_2.thumb_url == null) ** GOTO lbl32
        var8_7 = var2_2.thumb_url;
        var7_8 = true;
        ** GOTO lbl38
lbl32: // 1 sources:
        var6_11 = var2_2.source_url;
        var7_8 = false;
        var8_7 = null;
        if (var6_11 != null) {
            var8_7 = var2_2.source_url;
            var7_8 = true;
lbl38: // 2 sources:
            if (var7_8) {
                var9_9 = var2_2.width;
                var10_10 = var2_2.height;
                if (var8_7 == null || var9_9 == 0 || var10_10 == 0) {
                    rj.a((Throwable)new Exception("thumb_url and source_url are both null"));
                    return;
                }
                if (var4_5) {
                    var0_1.mPostLinkImage.setVisibility(0);
                    var0_1.mPostImage.setVisibility(8);
                    GossipApplication.c.a(var8_7).a().d().a(new kr[]{var5_6}).a((String)DiskCacheStrategy.c).a(new qz<ImageView, oh>(var0_1.mPostLinkImage){

                        public void a(oh oh2, qk<? super oh> qk2) {
                            ((ImageView)this.view).setImageDrawable((Drawable)oh2);
                        }

                        @Override
                        public /* synthetic */ void onResourceReady(Object object, qk qk2) {
                            this.a((oh)((Object)object), qk2);
                        }
                    });
                    return;
                }
                var0_1.mPostImage.setVisibility(0);
                var0_1.mPostLinkImage.setVisibility(8);
                if (var2_2.localBitmapPath != null) {
                    var11_12 = new BitmapFactory.Options();
                    var11_12.inPreferredConfig = Bitmap.Config.ARGB_8888;
                    var12_13 = BitmapFactory.decodeFile((String)var2_2.localBitmapPath, (BitmapFactory.Options)var11_12);
                    GossipApplication.c.a(var12_13).a().a((Bitmap)DiskCacheStrategy.c).a(new qz<ImageView, oh>(var0_1.mPostImage){

                        public void a(oh oh2, qk<? super oh> qk2) {
                            ((ImageView)this.view).setImageDrawable((Drawable)oh2);
                        }

                        @Override
                        public /* synthetic */ void onResourceReady(Object object, qk qk2) {
                            this.a((oh)((Object)object), qk2);
                        }
                    });
                    return;
                }
                GossipApplication.c.a(var8_7).a().a((String)DiskCacheStrategy.c).a(new qz<ImageView, oh>(var0_1.mPostImage){

                    public void a(oh oh2, qk<? super oh> qk2) {
                        ((ImageView)this.view).setImageDrawable((Drawable)oh2);
                    }

                    @Override
                    public /* synthetic */ void onResourceReady(Object object, qk qk2) {
                        this.a((oh)((Object)object), qk2);
                    }
                });
                return;
            }
        }
        var0_1.mPostLinkImage.setVisibility(8);
        var0_1.mPostImage.setVisibility(8);
    }

    private void a(String string2, int n2, TextView textView, Context context, int n3) {
        io.a();
        textView.setTypeface(io.b());
        textView.setTextColor(n2);
        textView.setText((CharSequence)io.a(string2));
        textView.setTextSize(1, (float)n3);
        int n4 = textView.getWidth();
        if (n4 == 0) {
            n4 = (int)(40.0f * textView.getResources().getDisplayMetrics().density);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(context.getResources().getColor(17170443));
        gradientDrawable.setCornerRadius((float)(n4 / 2));
        textView.setBackground((Drawable)gradientDrawable);
        textView.getBackground().setAlpha(192);
        textView.setVisibility(0);
    }

}

