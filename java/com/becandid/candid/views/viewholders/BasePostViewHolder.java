/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.DialogInterface$OnShowListener
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.os.AsyncTask
 *  android.os.Handler
 *  android.os.Looper
 *  android.support.v4.app.ActivityCompat
 *  android.support.v7.app.AlertDialog
 *  android.support.v7.app.AlertDialog$Builder
 *  android.support.v7.widget.PopupMenu
 *  android.support.v7.widget.PopupMenu$OnMenuItemClickListener
 *  android.text.SpannableString
 *  android.text.method.LinkMovementMethod
 *  android.text.method.MovementMethod
 *  android.text.style.ClickableSpan
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.widget.Button
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.ProgressBar
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  android.widget.Toast
 *  butterknife.BindView
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.Void
 *  java.text.DecimalFormat
 *  java.util.ArrayList
 *  java.util.HashSet
 *  java.util.List
 *  rx.schedulers.Schedulers
 */
package com.becandid.candid.views.viewholders;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.PopupMenu;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.ClickableSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.ContentEditActivity;
import com.becandid.candid.activities.GroupDetailsActivity;
import com.becandid.candid.activities.InviteContactsActivity;
import com.becandid.candid.activities.MessageActivity;
import com.becandid.candid.activities.PostDetailsActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Config;
import com.becandid.candid.data.DataUtil;
import com.becandid.candid.data.EmptyClass;
import com.becandid.candid.data.Group;
import com.becandid.candid.data.Post;
import com.becandid.candid.data.ShareInfo;
import com.becandid.candid.data.TextTag;
import com.becandid.candid.models.NetworkData;
import com.becandid.thirdparty.BlurTask;
import com.facebook.FacebookException;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import rx.schedulers.Schedulers;

public abstract class BasePostViewHolder
extends jc {
    private static String a;
    @BindView(value=2131624751)
    LinearLayout mCommentPostBadge;
    @BindView(value=2131624793)
    public TextView mCommentPostBtnOgImage;
    @BindView(value=2131624749)
    LinearLayout mCommentPostContainer;
    @BindView(value=2131624752)
    TextView mCommentPostText;
    @BindView(value=2131624789)
    View mFalseRumorContainerOgImage;
    @BindView(value=2131624790)
    ImageView mFalseRumorIconOgImage;
    @BindView(value=2131624791)
    public TextView mFalseRumorTextOgImage;
    @BindView(value=2131624267)
    View mFooter;
    @BindView(value=2131624760)
    TextView mFooterCommentIcon;
    @BindView(value=2131624763)
    ImageView mFooterCommentImage;
    @BindView(value=2131624761)
    ImageView mFooterCommentModIcon;
    @BindView(value=2131624757)
    View mFooterCommentSnippet;
    @BindView(value=2131624764)
    TextView mFooterCommentText;
    @BindView(value=2131624762)
    TextView mFooterCommentTimestamp;
    @BindView(value=2131624758)
    TextView mFooterCommentValue;
    @BindView(value=2131624264)
    View mHeader;
    @BindView(value=2131624783)
    public TextView mLikePostBtnOgImage;
    @BindView(value=2131624741)
    LinearLayout mLikeRumorPostBadge;
    @BindView(value=2131624737)
    LinearLayout mLikeRumorPostContainer;
    @BindView(value=2131624739)
    ImageView mLikeRumorPostIcon;
    @BindView(value=2131624742)
    TextView mLikeRumorPostText;
    @BindView(value=2131624755)
    LinearLayout mMessagePostContainer;
    @BindView(value=2131624769)
    public TextView mPostAuthor;
    @BindView(value=2131624115)
    TextView mPostCaption;
    @BindView(value=2131624411)
    TextView mPostCaptionOgImage;
    @BindView(value=2131624401)
    LinearLayout mPostContainer;
    @BindView(value=2131624779)
    public TextView mPostGroup;
    @BindView(value=2131624776)
    public FrameLayout mPostGroupContainer;
    @BindView(value=2131624778)
    public View mPostGroupMenu;
    @BindView(value=2131624777)
    RelativeLayout mPostGroupMenuContainer;
    @BindView(value=2131624795)
    TextView mPostGroupOgImage;
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
    @BindView(value=2131624413)
    View mPostImageFooter;
    @BindView(value=2131624767)
    public ImageView mPostModIcon;
    @BindView(value=2131624768)
    View mPostPopupAction;
    @BindView(value=2131624797)
    LinearLayout mPostRelated;
    @BindView(value=2131624400)
    View mPostRelatedBar;
    @BindView(value=2131624800)
    LinearLayout mPostRelatedBottom;
    @BindView(value=2131624801)
    View mPostRumorAlert;
    @BindView(value=2131624802)
    ImageView mPostRumorAlertDrawable;
    @BindView(value=2131624803)
    TextView mPostRumorAlertText;
    @BindView(value=2131624408)
    View mPostShareOgImage;
    @BindView(value=2131624774)
    public TextView mPostTimestamp;
    @BindView(value=2131624804)
    View mPostTrending;
    @BindView(value=2131624805)
    ImageView mPostTrendingDrawable;
    @BindView(value=2131624806)
    TextView mPostTrendingText;
    @BindView(value=2131624191)
    ProgressBar mProgressBar;
    @BindView(value=2131624746)
    TextView mRumorFalseText;
    @BindView(value=2131624740)
    TextView mRumorTrueText;
    @BindView(value=2131624753)
    FrameLayout mShareButton;
    @BindView(value=2131624754)
    ImageView mShareIcon;
    @BindView(value=2131624784)
    View mTrueRumorContainerOgImage;
    @BindView(value=2131624785)
    ImageView mTrueRumorIconOgImage;
    @BindView(value=2131624786)
    public TextView mTrueRumorTextOgImage;
    @BindView(value=2131624788)
    public TextView mUnlikePostBtnOgImage;
    @BindView(value=2131624747)
    LinearLayout mUnlikeRumorPostBadge;
    @BindView(value=2131624743)
    LinearLayout mUnlikeRumorPostContainer;
    @BindView(value=2131624745)
    ImageView mUnlikeRumorPostIcon;
    @BindView(value=2131624748)
    TextView mUnlikeRumorPostText;
    @BindView(value=2131624775)
    ImageView reportFlag;

    public BasePostViewHolder(View view, Activity activity) {
        super(view, activity);
    }

    public BasePostViewHolder(View view, Activity activity, String string2) {
        super(view, activity);
        a = string2;
    }

    private void a(int n2, int n3, int n4, final Activity activity) {
        ik.a().b(Integer.toString((int)n2), Integer.toString((int)n3), Integer.toString((int)n4)).b(Schedulers.io()).b(new apr<Post>(){

            public void a(Post post) {
                ix.a().a(new in.q(post, activity));
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((Post)object);
            }
        });
    }

    private void a(ImageView imageView, int n2, TextView textView, boolean bl2) {
        if (bl2) {
            imageView.setColorFilter(Color.parseColor((String)"#00FF00"));
            textView.setText((CharSequence)Integer.toString((int)(n2 + 1)));
            return;
        }
        imageView.setColorFilter(Color.parseColor((String)"#FFFFFF"));
        textView.setText((CharSequence)Integer.toString((int)(n2 - 1)));
    }

    private void a(ImageView imageView, TextView textView, Context context, boolean bl2) {
        int n2 = Integer.parseInt((String)textView.getText().toString());
        if (bl2) {
            imageView.setImageDrawable(context.getResources().getDrawable(2130838006));
            textView.setText((CharSequence)Integer.toString((int)(n2 + 1)));
            return;
        }
        imageView.setImageDrawable(context.getResources().getDrawable(2130838010));
        textView.setText((CharSequence)Integer.toString((int)(n2 - 1)));
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static void a(final BasePostViewHolder var0_1, final Post var1) {
        var0_1.d(var1, var0_1);
        var0_1.b(var1, var0_1);
        var0_1.c(var1, var0_1);
        var0_1.a(var1, var0_1);
        var2_2 = new Handler(var0_1.f.getMainLooper());
        var3_3 = jb.b(var0_1.f);
        if (var1.rumor == 1) {
            var0_1.mLikeRumorPostIcon.setImageDrawable(var0_1.f.getResources().getDrawable(2130838196));
            var0_1.mUnlikeRumorPostIcon.setImageDrawable(var0_1.f.getResources().getDrawable(2130838195));
            var0_1.mRumorTrueText.setVisibility(0);
            var0_1.mRumorFalseText.setVisibility(0);
            if (var3_3 > 4.5) {
                var62_4 = new FrameLayout.LayoutParams(-2, -2);
                var62_4.setMargins(jb.a(53, var0_1.f), 0, 0, 0);
                var62_4.gravity = 16;
                var0_1.mLikeRumorPostBadge.setLayoutParams((ViewGroup.LayoutParams)var62_4);
                var63_5 = new FrameLayout.LayoutParams(-2, -2);
                var63_5.setMargins(jb.a(58, var0_1.f), 0, 0, 0);
                var63_5.gravity = 16;
                var0_1.mUnlikeRumorPostBadge.setLayoutParams((ViewGroup.LayoutParams)var63_5);
                var0_1.mLikeRumorPostBadge.setBackground(null);
                var0_1.mUnlikeRumorPostBadge.setBackground(null);
            } else {
                var72_7 = new FrameLayout.LayoutParams(-2, -2);
                var72_7.setMargins(jb.a(48, var0_1.f), jb.a(8, var0_1.f), 0, 0);
                var0_1.mLikeRumorPostBadge.setLayoutParams((ViewGroup.LayoutParams)var72_7);
                var73_6 = new FrameLayout.LayoutParams(-2, -2);
                var73_6.setMargins(jb.a(53, var0_1.f), jb.a(8, var0_1.f), 0, 0);
                var0_1.mUnlikeRumorPostBadge.setLayoutParams((ViewGroup.LayoutParams)var73_6);
                var0_1.mLikeRumorPostBadge.setBackground(var0_1.f.getResources().getDrawable(2130837991));
                var0_1.mUnlikeRumorPostBadge.setBackground(var0_1.f.getResources().getDrawable(2130837991));
            }
            var64_8 = var1.opinion_value;
            var65_9 = Color.parseColor((String)"#FFFFFF");
            var66_10 = Color.parseColor((String)"#FF0000");
            var67_11 = Color.parseColor((String)"#00FF00");
            if (var64_8 == 1) {
                var0_1.mLikeRumorPostIcon.setColorFilter(var67_11);
                var0_1.mUnlikeRumorPostIcon.setColorFilter(var65_9);
            } else if (var64_8 == -1) {
                var0_1.mLikeRumorPostIcon.setColorFilter(var65_9);
                var0_1.mUnlikeRumorPostIcon.setColorFilter(var66_10);
            } else {
                var0_1.mLikeRumorPostIcon.setColorFilter(var65_9);
                var0_1.mUnlikeRumorPostIcon.setColorFilter(var65_9);
            }
            var0_1.mLikeRumorPostText.setText((CharSequence)Integer.toString((int)var1.num_true));
            var0_1.mUnlikeRumorPostText.setText((CharSequence)Integer.toString((int)var1.num_false));
            var68_12 = var0_1.mLikeRumorPostContainer;
            var69_13 = new View.OnClickListener(){

                /*
                 * Enabled aggressive block sorting
                 */
                public void onClick(View view) {
                    int n2 = var1.opinion_value;
                    if (n2 == 1) {
                        var0_1.a(var0_1.mLikeRumorPostIcon, var1.num_true, var0_1.mLikeRumorPostText, false);
                        var1.opinion_value = 0;
                        Post post = var1;
                        post.num_true = -1 + post.num_true;
                    } else {
                        if (n2 == -1) {
                            var0_1.b(var0_1.mUnlikeRumorPostIcon, var1.num_false, var0_1.mUnlikeRumorPostText, false);
                            Post post = var1;
                            post.num_false = -1 + post.num_false;
                        }
                        var0_1.a(var0_1.mLikeRumorPostIcon, var1.num_true, var0_1.mLikeRumorPostText, true);
                        var1.opinion_value = 1;
                        Post post = var1;
                        post.num_true = 1 + post.num_true;
                    }
                    var0_1.a(var1.post_id, var1.opinion_value, 1, (Activity)var0_1.f);
                }
            };
            var68_12.setOnClickListener(var69_13);
            var70_14 = var0_1.mUnlikeRumorPostContainer;
            var71_15 = new View.OnClickListener(){

                /*
                 * Enabled aggressive block sorting
                 */
                public void onClick(View view) {
                    int n2 = var1.opinion_value;
                    if (n2 == -1) {
                        var0_1.b(var0_1.mUnlikeRumorPostIcon, var1.num_false, var0_1.mUnlikeRumorPostText, false);
                        var1.opinion_value = 0;
                        Post post = var1;
                        post.num_false = -1 + post.num_false;
                    } else {
                        if (n2 == 1) {
                            var0_1.a(var0_1.mLikeRumorPostIcon, var1.num_true, var0_1.mLikeRumorPostText, false);
                            Post post = var1;
                            post.num_true = -1 + post.num_true;
                        }
                        var0_1.b(var0_1.mUnlikeRumorPostIcon, var1.num_false, var0_1.mUnlikeRumorPostText, true);
                        var1.opinion_value = -1;
                        Post post = var1;
                        post.num_false = 1 + post.num_false;
                    }
                    var0_1.a(var1.post_id, var1.opinion_value, 1, (Activity)var0_1.f);
                }
            };
            var70_14.setOnClickListener(var71_15);
        } else {
            var0_1.mRumorTrueText.setVisibility(8);
            var0_1.mRumorFalseText.setVisibility(8);
            var5_21 = new LinearLayout.LayoutParams(0, -1, 1.0f);
            var0_1.mLikeRumorPostContainer.setLayoutParams((ViewGroup.LayoutParams)var5_21);
            var0_1.mUnlikeRumorPostContainer.setLayoutParams((ViewGroup.LayoutParams)var5_21);
            var0_1.mCommentPostContainer.setLayoutParams((ViewGroup.LayoutParams)var5_21);
            if (var3_3 > 4.5) {
                var6_17 = new FrameLayout.LayoutParams(-2, -2);
                var6_17.setMargins(jb.a(28, var0_1.f), 0, 0, 0);
                var6_17.gravity = 16;
                var0_1.mLikeRumorPostBadge.setLayoutParams((ViewGroup.LayoutParams)var6_17);
                var7_19 = new FrameLayout.LayoutParams(-2, -2);
                var7_19.setMargins(jb.a(30, var0_1.f), 0, 0, 0);
                var7_19.gravity = 16;
                var0_1.mUnlikeRumorPostBadge.setLayoutParams((ViewGroup.LayoutParams)var7_19);
                var0_1.mLikeRumorPostBadge.setBackground(null);
                var0_1.mUnlikeRumorPostBadge.setBackground(null);
            } else {
                var60_18 = new FrameLayout.LayoutParams(-2, -2);
                var60_18.setMargins(jb.a(22, var0_1.f), jb.a(8, var0_1.f), 0, 0);
                var0_1.mLikeRumorPostBadge.setLayoutParams((ViewGroup.LayoutParams)var60_18);
                var61_22 = new FrameLayout.LayoutParams(-2, -2);
                var61_22.setMargins(jb.a(24, var0_1.f), jb.a(8, var0_1.f), 0, 0);
                var0_1.mUnlikeRumorPostBadge.setLayoutParams((ViewGroup.LayoutParams)var61_22);
                var0_1.mLikeRumorPostBadge.setBackground(var0_1.f.getResources().getDrawable(2130837991));
                var0_1.mUnlikeRumorPostBadge.setBackground(var0_1.f.getResources().getDrawable(2130837991));
            }
            if ((var8_20 = var1.like_value) == 1) {
                var0_1.mLikeRumorPostIcon.setImageDrawable(var0_1.f.getResources().getDrawable(2130838006));
                var0_1.mUnlikeRumorPostIcon.setImageDrawable(var0_1.f.getResources().getDrawable(2130838008));
            } else if (var8_20 == -1) {
                var0_1.mLikeRumorPostIcon.setImageDrawable(var0_1.f.getResources().getDrawable(2130838010));
                var0_1.mUnlikeRumorPostIcon.setImageDrawable(var0_1.f.getResources().getDrawable(2130838007));
            } else {
                var0_1.mLikeRumorPostIcon.setImageDrawable(var0_1.f.getResources().getDrawable(2130838010));
                var0_1.mUnlikeRumorPostIcon.setImageDrawable(var0_1.f.getResources().getDrawable(2130838008));
            }
            var9_23 = var0_1.mLikeRumorPostContainer;
            var10_25 = new View.OnClickListener(){

                /*
                 * Enabled aggressive block sorting
                 */
                public void onClick(View view) {
                    int n2 = var1.like_value;
                    if (n2 == 1) {
                        var0_1.a(var0_1.mLikeRumorPostIcon, var0_1.mLikeRumorPostText, var0_1.f, false);
                        var1.like_value = 0;
                        Post post = var1;
                        post.num_likes = -1 + post.num_likes;
                    } else {
                        if (n2 == -1) {
                            var0_1.b(var0_1.mUnlikeRumorPostIcon, var0_1.mUnlikeRumorPostText, var0_1.f, false);
                            Post post = var1;
                            post.num_dislikes = -1 + post.num_dislikes;
                        }
                        var0_1.a(var0_1.mLikeRumorPostIcon, var0_1.mLikeRumorPostText, var0_1.f, true);
                        Post post = var1;
                        post.num_likes = 1 + post.num_likes;
                        var1.like_value = 1;
                    }
                    var0_1.a(var1.post_id, var1.like_value, 0, (Activity)var0_1.f);
                }
            };
            var9_23.setOnClickListener(var10_25);
            var11_16 = var0_1.mUnlikeRumorPostContainer;
            var12_24 = new View.OnClickListener(){

                /*
                 * Enabled aggressive block sorting
                 */
                public void onClick(View view) {
                    int n2 = var1.like_value;
                    if (n2 == -1) {
                        var0_1.b(var0_1.mUnlikeRumorPostIcon, var0_1.mUnlikeRumorPostText, var0_1.f, false);
                        var1.like_value = 0;
                        Post post = var1;
                        post.num_dislikes = -1 + post.num_dislikes;
                    } else {
                        if (n2 == 1) {
                            var0_1.a(var0_1.mLikeRumorPostIcon, var0_1.mLikeRumorPostText, var0_1.f, false);
                            Post post = var1;
                            post.num_likes = -1 + post.num_likes;
                        }
                        var0_1.b(var0_1.mUnlikeRumorPostIcon, var0_1.mUnlikeRumorPostText, var0_1.f, true);
                        Post post = var1;
                        post.num_dislikes = 1 + post.num_dislikes;
                        var1.like_value = -1;
                    }
                    var0_1.a(var1.post_id, var1.like_value, 0, (Activity)var0_1.f);
                }
            };
            var11_16.setOnClickListener(var12_24);
        }
        if (var3_3 > 4.5) {
            var13_26 = new FrameLayout.LayoutParams(-2, -2);
            var13_26.setMargins(jb.a(28, var0_1.f), 0, 0, 0);
            var13_26.gravity = 16;
            var0_1.mCommentPostBadge.setLayoutParams((ViewGroup.LayoutParams)var13_26);
            var0_1.mCommentPostBadge.setBackground(null);
        } else {
            var59_27 = new FrameLayout.LayoutParams(-2, -2);
            var59_27.setMargins(jb.a(22, var0_1.f), jb.a(8, var0_1.f), 0, 0);
            var0_1.mCommentPostBadge.setLayoutParams((ViewGroup.LayoutParams)var59_27);
            var0_1.mCommentPostBadge.setBackground(var0_1.f.getResources().getDrawable(2130837991));
        }
        if (var1.related_to_post > 0) {
            var0_1.mPostRelatedBar.setVisibility(0);
            if (var1.first_related_post == 1) {
                var0_1.mPostRelated.setVisibility(0);
                var0_1.mPostRelatedBottom.setVisibility(8);
            } else if (var1.last_related_post == 1) {
                var0_1.mPostRelated.setVisibility(8);
                var0_1.mPostRelatedBottom.setVisibility(0);
            } else {
                var0_1.mPostRelated.setVisibility(8);
                var0_1.mPostRelatedBottom.setVisibility(8);
            }
        } else {
            var0_1.mPostRelatedBar.setVisibility(8);
            var0_1.mPostRelated.setVisibility(8);
            var0_1.mPostRelatedBottom.setVisibility(8);
        }
        var14_28 = var0_1.mCommentPostContainer;
        var15_29 = new View.OnClickListener(){

            public void onClick(View view) {
                if (var0_1.f instanceof PostDetailsActivity) {
                    return;
                }
                Intent intent = new Intent(view.getContext(), (Class)PostDetailsActivity.class);
                intent.putExtra("post_id", var1.post_id);
                intent.putExtra("op_color", var1.icon_color);
                if (a != null) {
                    intent.putExtra("feed_type", a);
                }
                view.getContext().startActivity(intent);
            }
        };
        var14_28.setOnClickListener(var15_29);
        var16_30 = var0_1.mShareButton;
        var17_31 = new View.OnClickListener(){

            public void onClick(View view) {
                if (AppState.config.getInt("enable_share_post", 0) == 1) {
                    PopupMenu popupMenu = new PopupMenu(var0_1.f, view);
                    popupMenu.getMenuInflater().inflate(2131689482, popupMenu.getMenu());
                    popupMenu.show();
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){

                        /*
                         * Enabled aggressive block sorting
                         */
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            switch (menuItem.getItemId()) {
                                default: {
                                    return false;
                                }
                                case 2131624865: {
                                    var0_1.a(var0_1, var1, iy.a);
                                    return true;
                                }
                                case 2131624866: {
                                    var0_1.a(var0_1, var1, 1989);
                                    return true;
                                }
                                case 2131624867: {
                                    Intent intent = new Intent(var0_1.f, (Class)InviteContactsActivity.class);
                                    intent.putExtra("invite_type", InviteContactsActivity.InviteFlowTypes.POST.toString());
                                    if (var1.thats_me == 1) {
                                        intent.putExtra("upsell_id", "-7," + String.valueOf((int)var1.post_id));
                                    } else {
                                        intent.putExtra("upsell_id", "-3," + String.valueOf((int)var1.post_id));
                                    }
                                    var0_1.f.startActivity(intent);
                                    return true;
                                }
                                case 2131624868: 
                            }
                            iy.a(var0_1.f, var1.share_info.url, "Share Link");
                            return true;
                        }
                    });
                    return;
                }
                Toast.makeText((Context)var0_1.f, (CharSequence)"Sharing is not available", (int)0).show();
            }

        };
        var16_30.setOnClickListener(var17_31);
        if (var1.thats_me != 1) {
            var0_1.mMessagePostContainer.setVisibility(0);
            var57_32 = var0_1.mMessagePostContainer;
            var58_33 = new View.OnClickListener(){

                public void onClick(View view) {
                    if (var1.messaging_blocked != null) {
                        new AlertDialog.Builder(var0_1.f).setMessage((CharSequence)var1.messaging_blocked).setPositiveButton(2131230895, null).show();
                        return;
                    }
                    if (var1.messaging_disabled != null) {
                        new AlertDialog.Builder(var0_1.f).setMessage((CharSequence)var1.messaging_disabled).setPositiveButton(2131230895, null).show();
                        return;
                    }
                    Intent intent = new Intent(var0_1.f, (Class)MessageActivity.class);
                    intent.putExtra("post_id", Integer.toString((int)var1.post_id));
                    intent.putExtra("user_name", var1.user_name);
                    var0_1.f.startActivity(intent);
                }
            };
            var57_32.setOnClickListener(var58_33);
        } else {
            var0_1.mMessagePostContainer.setVisibility(8);
        }
        var18_34 = var0_1.mPostPopupAction;
        var19_35 = new View.OnClickListener(){

            /*
             * Enabled aggressive block sorting
             */
            public void onClick(View view) {
                final Context context = var0_1.f;
                PopupMenu popupMenu = new PopupMenu(var0_1.f, view);
                popupMenu.getMenuInflater().inflate(2131689481, popupMenu.getMenu());
                if (var1.thats_me == 1) {
                    if (var1.caption == null || var1.caption.equals((Object)"")) {
                        popupMenu.getMenu().getItem(0).setVisible(false);
                    } else {
                        popupMenu.getMenu().getItem(0).setVisible(true);
                    }
                    popupMenu.getMenu().getItem(1).setVisible(true);
                    popupMenu.getMenu().getItem(2).setVisible(false);
                    popupMenu.getMenu().getItem(3).setVisible(false);
                    popupMenu.getMenu().getItem(4).setVisible(false);
                } else {
                    popupMenu.getMenu().getItem(0).setVisible(false);
                    popupMenu.getMenu().getItem(1).setVisible(false);
                    if (AppState.config.getBoolean("messaging_turned_on", true) && var1.thats_me != 1) {
                        popupMenu.getMenu().getItem(2).setVisible(true);
                    } else {
                        popupMenu.getMenu().getItem(2).setVisible(false);
                    }
                    popupMenu.getMenu().getItem(3).setVisible(true);
                    popupMenu.getMenu().getItem(4).setVisible(true);
                }
                if (var1.can_mute == 1 && var1.muted_post == 0) {
                    popupMenu.getMenu().getItem(5).setVisible(true);
                    popupMenu.getMenu().getItem(6).setVisible(false);
                } else if (var1.can_mute == 1 && var1.muted_post == 1) {
                    popupMenu.getMenu().getItem(5).setVisible(false);
                    popupMenu.getMenu().getItem(6).setVisible(true);
                }
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(new AlertDialog.Builder(context)){
                    final /* synthetic */ AlertDialog.Builder b;

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            default: {
                                return false;
                            }
                            case 2131624858: {
                                Intent intent = new Intent(context, (Class)ContentEditActivity.class);
                                intent.putExtra("caption", var1.caption);
                                intent.putExtra("post_id", var1.post_id);
                                if (var1.mentioned_groups_info != null) {
                                    intent.putExtra("group_tags", var1.mentioned_groups_info);
                                }
                                context.startActivity(intent);
                                return true;
                            }
                            case 2131624859: {
                                this.b.setTitle(2131230796).setPositiveButton(2131230953, new DialogInterface.OnClickListener(){

                                    public void onClick(DialogInterface dialogInterface, int n2) {
                                        ik.a().a(var1, null).b(Schedulers.io()).a(apv.a()).b(new apr<EmptyClass>(){

                                            public void a(EmptyClass emptyClass) {
                                                emptyClass.toString();
                                            }

                                            @Override
                                            public void onCompleted() {
                                                ix.a().a(new in.r(var1.post_id));
                                                Context context = GossipApplication.a().getApplicationContext();
                                                Toast.makeText((Context)context, (CharSequence)context.getResources().getString(2131230957), (int)0).show();
                                            }

                                            @Override
                                            public void onError(Throwable throwable) {
                                                throwable.getLocalizedMessage();
                                            }

                                            @Override
                                            public /* synthetic */ void onNext(Object object) {
                                                this.a((EmptyClass)object);
                                            }
                                        });
                                    }

                                }).setNegativeButton(2131230890, new DialogInterface.OnClickListener(){

                                    public void onClick(DialogInterface dialogInterface, int n2) {
                                    }
                                });
                                this.b.create().show();
                                return true;
                            }
                            case 2131624861: {
                                this.b.setTitle(2131230910).setMessage(2131230909).setPositiveButton(2131230953, new DialogInterface.OnClickListener(){

                                    public void onClick(DialogInterface dialogInterface, int n2) {
                                        ik.a().b(var1, context.getString(2131230856)).b(Schedulers.io()).a(apv.a()).b(new apr<EmptyClass>(){

                                            public void a(EmptyClass emptyClass) {
                                            }

                                            @Override
                                            public void onCompleted() {
                                                ix.a().a(new in.r(var1.post_id));
                                                Context context = GossipApplication.a().getApplicationContext();
                                                Toast.makeText((Context)context, (CharSequence)context.getResources().getString(2131230960), (int)0).show();
                                            }

                                            @Override
                                            public void onError(Throwable throwable) {
                                            }

                                            @Override
                                            public /* synthetic */ void onNext(Object object) {
                                                this.a((EmptyClass)object);
                                            }
                                        });
                                    }

                                }).setNegativeButton(2131230890, null);
                                this.b.create().show();
                                return true;
                            }
                            case 2131624862: {
                                final int[] arrn = new int[]{-1};
                                CharSequence[] arrcharSequence = new String[]{context.getString(2131230893), context.getString(2131230928), context.getString(2131230855), context.getString(2131230894)};
                                this.b.setTitle(2131230952).setSingleChoiceItems(arrcharSequence, -1, new DialogInterface.OnClickListener(){

                                    public void onClick(DialogInterface dialogInterface, int n2) {
                                        arrn[0] = n2;
                                        ((AlertDialog)dialogInterface).getButton(-1).setEnabled(true);
                                    }
                                }).setPositiveButton(2131230895, new DialogInterface.OnClickListener((String[])arrcharSequence){
                                    final /* synthetic */ String[] b;

                                    public void onClick(DialogInterface dialogInterface, int n2) {
                                        if (arrn[0] < 0) {
                                            Log.d((String)"BPVH", (String)"No reason selected");
                                            return;
                                        }
                                        ik.a().b(var1, this.b[arrn[0]]).b(Schedulers.io()).a(apv.a()).b(new apr<EmptyClass>(){

                                            public void a(EmptyClass emptyClass) {
                                            }

                                            @Override
                                            public void onCompleted() {
                                                ix.a().a(new in.r(var1.post_id));
                                                Context context = GossipApplication.a().getApplicationContext();
                                                Toast.makeText((Context)context, (CharSequence)context.getResources().getString(2131230960), (int)0).show();
                                            }

                                            @Override
                                            public void onError(Throwable throwable) {
                                            }

                                            @Override
                                            public /* synthetic */ void onNext(Object object) {
                                                this.a((EmptyClass)object);
                                            }
                                        });
                                    }

                                }).setNegativeButton((CharSequence)"Cancel", new DialogInterface.OnClickListener(){

                                    public void onClick(DialogInterface dialogInterface, int n2) {
                                    }
                                });
                                AlertDialog alertDialog = this.b.create();
                                alertDialog.setOnShowListener(new DialogInterface.OnShowListener(){

                                    public void onShow(DialogInterface dialogInterface) {
                                        if (arrn[0] < 0) {
                                            ((AlertDialog)dialogInterface).getButton(-1).setEnabled(false);
                                        }
                                    }
                                });
                                alertDialog.show();
                                return true;
                            }
                            case 2131624860: {
                                if (var1.messaging_blocked != null) {
                                    new AlertDialog.Builder(context).setMessage((CharSequence)var1.messaging_blocked).setPositiveButton(2131230895, null).show();
                                    return true;
                                }
                                if (var1.messaging_disabled != null) {
                                    new AlertDialog.Builder(context).setMessage((CharSequence)var1.messaging_disabled).setPositiveButton(2131230895, null).show();
                                    return true;
                                }
                                Intent intent = new Intent(context, (Class)MessageActivity.class);
                                intent.putExtra("post_id", Integer.toString((int)var1.post_id));
                                intent.putExtra("user_name", var1.user_name);
                                context.startActivity(intent);
                                return true;
                            }
                            case 2131624863: {
                                ik.a().e(Integer.toString((int)var1.post_id)).b(Schedulers.io()).a(apv.a()).b(new apr<EmptyClass>(){

                                    public void a(EmptyClass emptyClass) {
                                        1.this.b.setTitle((CharSequence)"Muted").setMessage((CharSequence)"You will no longer receive notifications about this post.").setPositiveButton(2131230895, null);
                                        1.this.b.create().show();
                                        var1.muted_post = 1;
                                        if (context instanceof PostDetailsActivity) {
                                            ((PostDetailsActivity)context).toggleMuteIcon();
                                        }
                                    }

                                    @Override
                                    public void onCompleted() {
                                    }

                                    @Override
                                    public void onError(Throwable throwable) {
                                    }

                                    @Override
                                    public /* synthetic */ void onNext(Object object) {
                                        this.a((EmptyClass)object);
                                    }
                                });
                                return true;
                            }
                            case 2131624864: 
                        }
                        ik.a().f(Integer.toString((int)var1.post_id)).b(Schedulers.io()).a(apv.a()).b(new apr<EmptyClass>(){

                            public void a(EmptyClass emptyClass) {
                                1.this.b.setTitle((CharSequence)"Unmuted Post").setMessage((CharSequence)"You will receive notifications about this post again.").setPositiveButton(2131230895, null);
                                1.this.b.create().show();
                                var1.muted_post = 0;
                                if (context instanceof PostDetailsActivity) {
                                    ((PostDetailsActivity)context).toggleMuteIcon();
                                }
                            }

                            @Override
                            public void onCompleted() {
                            }

                            @Override
                            public void onError(Throwable throwable) {
                            }

                            @Override
                            public /* synthetic */ void onNext(Object object) {
                                this.a((EmptyClass)object);
                            }
                        });
                        return true;
                    }

                });
            }

        };
        var18_34.setOnClickListener(var19_35);
        var20_36 = AppState.config.getInt("disable_group_tagging", 0);
        var21_37 = var1.caption;
        if (var21_37 == null) {
            var0_1.mPostCaption.setText((CharSequence)var21_37);
            return;
        }
        var22_38 = new SpannableString((CharSequence)var21_37);
        var23_39 = var0_1.f instanceof PostDetailsActivity;
        var24_40 = false;
        if (!var23_39) {
            var52_41 = AppState.expandedPostIds;
            var24_40 = false;
            if (var52_41 != null) {
                var53_42 = AppState.expandedPostIds.contains((Object)var1.post_id);
                var24_40 = false;
                if (!var53_42) {
                    var22_38 = jb.a(var21_37, Color.parseColor((String)"#99FFFFFF"));
                    var54_43 = var22_38.toString().endsWith("See More");
                    var24_40 = false;
                    if (var54_43) {
                        var24_40 = true;
                        var0_1.mPostCaption.setText((CharSequence)var22_38);
                        var55_44 = var0_1.mPostCaption;
                        var56_45 = new View.OnClickListener(){

                            public void onClick(View view) {
                                var2_2.post(new Runnable(){

                                    public void run() {
                                        AppState.expandedPostIds.add((Object)var1.post_id);
                                        ix.a().a(new in.al(var1.post_id));
                                    }
                                });
                            }

                        };
                        var55_44.setOnClickListener(var56_45);
                    }
                }
            }
        }
        var25_46 = new ArrayList();
        if (var20_36 == 0 && var1.mentioned_groups_info != null) {
            var43_47 = var1.mentioned_groups_info.split(";");
            var44_48 = var43_47.length;
            for (var45_49 = 0; var45_49 < var44_48 && (var46_54 = var43_47[var45_49].split(",")).length == 3; ++var45_49) {
                var47_51 = Integer.parseInt((String)var46_54[0]);
                var48_52 = Integer.parseInt((String)var46_54[1]);
                var49_50 = Integer.parseInt((String)var46_54[2]);
                var50_53 = new TextTag(var48_52, var49_50, var47_51);
                var25_46.add((Object)var50_53);
            }
        }
        DataUtil.sortTextTags(var25_46, 0, -1 + var25_46.size());
        var26_55 = 0;
        do {
            if (var25_46.isEmpty()) ** GOTO lbl-1000
            var32_59 = (TextTag)var25_46.remove(0);
            if (!(var32_59.startIndex >= var22_38.length() || var32_59.endIndex > var22_38.length() || var32_59.startIndex < 0 || var32_59.endIndex <= 0 || var22_38.toString().endsWith("See More") && var32_59.endIndex > var22_38.length() || (var33_62 = var26_55) > var22_38.length())) {
                while (var26_55 < var32_59.startIndex) {
                    ++var26_55;
                }
            } else lbl-1000: // 2 sources:
            {
                var27_67 = var26_55;
                while (var26_55 < var22_38.length()) {
                    ++var26_55;
                }
                break;
            }
            if (var26_55 > var22_38.length()) {
                var26_55 = var22_38.length();
            }
            if (var26_55 > -1 && var33_62 > -1 && var26_55 - var33_62 > 0 && !(var0_1.f instanceof PostDetailsActivity) && !var24_40) {
                var39_65 = var1.post_id;
                var40_61 = var0_1.f;
                var41_63 = var1.icon_color;
                var42_58 = jb.a("#ffffff", var39_65, var40_61, var24_40, var41_63);
                var22_38.setSpan((Object)var42_58, var33_62, var26_55, 33);
            }
            try {
                if (var32_59.startIndex <= -1 || var32_59.endIndex <= -1) continue;
                var35_66 = jb.a("#ffffff", var32_59.groupId, var0_1.f);
                var36_57 = var32_59.startIndex;
                var37_56 = var32_59.endIndex;
                var22_38.setSpan((Object)var35_66, var36_57, var37_56, 33);
                var38_60 = var32_59.endIndex;
            }
            catch (IndexOutOfBoundsException var34_64) {
                rj.a((Throwable)var34_64);
                continue;
            }
            var26_55 = var38_60 + 1;
            continue;
            break;
        } while (true);
        if (var26_55 > -1 && var27_67 > -1 && var26_55 - var27_67 > 0 && !(var0_1.f instanceof PostDetailsActivity) && !var24_40) {
            var28_68 = var1.post_id;
            var29_69 = var0_1.f;
            var30_70 = var1.icon_color;
            var31_71 = jb.a("#ffffff", var28_68, var29_69, var24_40, var30_70);
            var22_38.setSpan((Object)var31_71, var27_67, var26_55, 33);
        }
        if (!(var0_1.f instanceof PostDetailsActivity) && !var24_40) {
            var0_1.mPostCaption.setTextIsSelectable(false);
        }
        var0_1.mPostCaption.setMovementMethod(LinkMovementMethod.getInstance());
        var0_1.mPostCaption.setText((CharSequence)var22_38);
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

    private void b(ImageView imageView, int n2, TextView textView, boolean bl2) {
        if (bl2) {
            imageView.setColorFilter(Color.parseColor((String)"#FF0000"));
            textView.setText((CharSequence)Integer.toString((int)(n2 + 1)));
            return;
        }
        imageView.setColorFilter(Color.parseColor((String)"#FFFFFF"));
        textView.setText((CharSequence)Integer.toString((int)(n2 - 1)));
    }

    private void b(ImageView imageView, TextView textView, Context context, boolean bl2) {
        int n2 = Integer.parseInt((String)textView.getText().toString());
        if (bl2) {
            imageView.setImageDrawable(context.getResources().getDrawable(2130838007));
            textView.setText((CharSequence)Integer.toString((int)(n2 + 1)));
            return;
        }
        imageView.setImageDrawable(context.getResources().getDrawable(2130838008));
        textView.setText((CharSequence)Integer.toString((int)(n2 - 1)));
    }

    private void b(Post post, BasePostViewHolder basePostViewHolder) {
        int n2 = Color.parseColor((String)post.icon_color);
        if (post.trending == 1 && post.rumor != 1) {
            basePostViewHolder.mPostTrending.setVisibility(0);
            basePostViewHolder.mPostTrendingDrawable.setColorFilter(n2);
            basePostViewHolder.mPostTrendingText.setTextColor(n2);
            return;
        }
        basePostViewHolder.mPostTrending.setVisibility(8);
    }

    private void c(Post post, BasePostViewHolder basePostViewHolder) {
        int n2 = Color.parseColor((String)post.icon_color);
        if (post.rumor == 1) {
            basePostViewHolder.mPostRumorAlert.setVisibility(0);
            basePostViewHolder.mPostRumorAlertDrawable.setColorFilter(n2);
            basePostViewHolder.mPostRumorAlertText.setTextColor(n2);
            return;
        }
        basePostViewHolder.mPostRumorAlert.setVisibility(8);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void d(final Post post, final BasePostViewHolder basePostViewHolder) {
        String string2 = post.icon_name;
        int n2 = Color.parseColor((String)post.icon_color);
        if (post.is_candid_mod == 1) {
            basePostViewHolder.mPostIcon.setVisibility(8);
            basePostViewHolder.mPostModIcon.setVisibility(0);
            basePostViewHolder.mPostModIcon.setOnClickListener(new View.OnClickListener(){

                public void onClick(View view) {
                    if (!AppState.blurTaskCalledOnFlight) {
                        AppState.blurTaskCalledOnFlight = true;
                        new BlurTask((Activity)basePostViewHolder.f, ((Activity)basePostViewHolder.f).findViewById(16908290), BlurTask.BadgeType.b, basePostViewHolder.f.getString(2131230884), basePostViewHolder.f.getString(2131230933)).execute((Object[])new Void[0]);
                    }
                }
            });
        } else {
            super.a(string2, n2, basePostViewHolder.mPostIcon, basePostViewHolder.f, 40);
            if (AppState.config.getBoolean("messaging_turned_on", true) && post.thats_me != 1) {
                basePostViewHolder.mPostIcon.setOnClickListener(new View.OnClickListener(){

                    public void onClick(View view) {
                        if (post.messaging_blocked != null) {
                            new AlertDialog.Builder(BasePostViewHolder.this.f).setMessage((CharSequence)post.messaging_blocked).setPositiveButton(2131230895, null).show();
                            return;
                        }
                        if (post.messaging_disabled != null) {
                            new AlertDialog.Builder(BasePostViewHolder.this.f).setMessage((CharSequence)post.messaging_disabled).setPositiveButton(2131230895, null).show();
                            return;
                        }
                        if (!AppState.hasMessagedFromAlert) {
                            new AlertDialog.Builder(BasePostViewHolder.this.f).setTitle((CharSequence)"Message User?").setMessage((CharSequence)"Would you like to send this user a message?").setNegativeButton((CharSequence)BasePostViewHolder.this.f.getResources().getString(2131230890), null).setPositiveButton((CharSequence)BasePostViewHolder.this.f.getResources().getString(2131230953), new DialogInterface.OnClickListener(){

                                public void onClick(DialogInterface dialogInterface, int n2) {
                                    Intent intent = new Intent(BasePostViewHolder.this.f, (Class)MessageActivity.class);
                                    intent.putExtra("post_id", Integer.toString((int)post.post_id));
                                    if (post.user_name != null) {
                                        intent.putExtra("user_name", post.user_name);
                                    }
                                    BasePostViewHolder.this.f.startActivity(intent);
                                }
                            }).create().show();
                            AppState.hasMessagedFromAlert = true;
                            AppState.saveState((ContextWrapper)GossipApplication.a());
                            return;
                        }
                        Intent intent = new Intent(BasePostViewHolder.this.f, (Class)MessageActivity.class);
                        intent.putExtra("post_id", Integer.toString((int)post.post_id));
                        if (post.user_name != null) {
                            intent.putExtra("user_name", post.user_name);
                        }
                        BasePostViewHolder.this.f.startActivity(intent);
                    }

                });
                basePostViewHolder.mPostModIcon.setVisibility(8);
            }
        }
        basePostViewHolder.mPostAuthor.setText((CharSequence)post.user_name);
        jp jp2 = new jp();
        jp2.a(Color.parseColor((String)"#ffffff"));
        int n3 = jb.a(10, this.f);
        int n4 = jb.a(6, this.f);
        int n5 = jb.a(1, this.f);
        jp2.setBounds(0, n5, n3, n4);
        basePostViewHolder.mPostAuthor.setCompoundDrawables(null, null, (Drawable)jp2, null);
        basePostViewHolder.mPostTimestamp.setText((CharSequence)post.post_time_ago);
        basePostViewHolder.mPostGroup.setText((CharSequence)post.group_name);
        basePostViewHolder.mPostGroup.setTextColor(n2);
        basePostViewHolder.mPostGroup.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                if (!(BasePostViewHolder.this.f instanceof GroupDetailsActivity)) {
                    Intent intent = new Intent(BasePostViewHolder.this.f, (Class)GroupDetailsActivity.class);
                    intent.putExtra("group_id", post.group_id);
                    BasePostViewHolder.this.f.startActivity(intent);
                }
            }
        });
        basePostViewHolder.mPostGroupContainer.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                if (!(BasePostViewHolder.this.f instanceof GroupDetailsActivity)) {
                    Intent intent = new Intent(BasePostViewHolder.this.f, (Class)GroupDetailsActivity.class);
                    intent.putExtra("group_id", post.group_id);
                    BasePostViewHolder.this.f.startActivity(intent);
                }
            }
        });
        jp jp3 = new jp();
        jp3.a(n2);
        jp3.setBounds(0, n5, n3, n4);
        basePostViewHolder.mPostGroupMenu.setBackground((Drawable)jp3);
        basePostViewHolder.mPostGroupMenuContainer.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
                if (!(basePostViewHolder.f instanceof GroupDetailsActivity)) {
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){

                        /*
                         * Unable to fully structure code
                         * Enabled aggressive block sorting
                         * Lifted jumps to return sites
                         */
                        public boolean onMenuItemClick(MenuItem var1) {
                            switch (var1.getItemId()) {
                                case 2131624838: {
                                    ik.a().c(8.this.post.group_id).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

                                        /*
                                         * Unable to fully structure code
                                         * Enabled aggressive block sorting
                                         * Lifted jumps to return sites
                                         */
                                        public void a(NetworkData var1) {
                                            var2_2 = 0;
                                            do {
                                                if (var2_2 >= AppState.groups.size()) ** GOTO lbl6
                                                if (((Group)AppState.groups.get((int)var2_2)).group_id == 1.this.8.this.post.group_id) {
                                                    AppState.groups.remove(var2_2);
lbl6: // 2 sources:
                                                    ix.a().a(new in.p(1.this.8.this.post.group_id, 1.this.8.this.post.post_id));
                                                    return;
                                                }
                                                ++var2_2;
                                            } while (true);
                                        }

                                        @Override
                                        public void onCompleted() {
                                        }

                                        @Override
                                        public void onError(Throwable throwable) {
                                            rj.a(throwable);
                                            Log.d((String)"GroupPopupLeave", (String)throwable.toString());
                                        }

                                        @Override
                                        public /* synthetic */ void onNext(Object object) {
                                            this.a((NetworkData)object);
                                        }
                                    });
                                    ** break;
                                }
                                case 2131624839: {
                                    ik.a().b(8.this.post.group_id).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

                                        public void a(NetworkData networkData) {
                                            if (networkData.success) {
                                                ix.a().a(new in.n(networkData.group.group_id, post.post_id));
                                            }
                                        }

                                        @Override
                                        public void onCompleted() {
                                        }

                                        @Override
                                        public void onError(Throwable throwable) {
                                            rj.a(throwable);
                                            Log.d((String)"GroupPopupLeave", (String)throwable.toString());
                                        }

                                        @Override
                                        public /* synthetic */ void onNext(Object object) {
                                            this.a((NetworkData)object);
                                        }
                                    });
                                }
lbl7: // 3 sources:
                                default: {
                                    return false;
                                }
                                case 2131624837: 
                            }
                            8.this.basePostViewHolder.f.startActivity(GroupDetailsActivity.startGroupDetailsActivity(8.this.basePostViewHolder.f, 8.this.post.group_id));
                            return false;
                        }

                    });
                    popupMenu.getMenu().add(1, 2131624837, 0, 2131230853);
                    boolean bl2 = true;
                    if (AppState.groups != null) {
                        for (Group group : AppState.groups) {
                            if (group.group_id != post.group_id) continue;
                            if (group.moderator == 1) break;
                            popupMenu.getMenu().add(1, 2131624838, 0, 2131230867);
                            bl2 = false;
                            break;
                        }
                    }
                    if (bl2) {
                        popupMenu.getMenu().add(1, 2131624839, 0, 2131230862);
                    }
                    popupMenu.show();
                    return;
                }
                popupMenu.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener)BasePostViewHolder.this.f);
                boolean bl3 = true;
                if (AppState.groups != null) {
                    for (Group group : AppState.groups) {
                        if (group.group_id != post.group_id) continue;
                        if (group.moderator != 1) {
                            popupMenu.getMenu().add(1, 2131624838, 0, 2131230867);
                            popupMenu.getMenu().add(1, 2131624841, 0, 2131230913);
                            bl3 = false;
                            continue;
                        }
                        popupMenu.getMenu().add(1, 2131624842, 0, 2131230835);
                        if (group.num_posts != 0) continue;
                        popupMenu.getMenu().add(1, 2131624840, 0, 2131230827);
                    }
                }
                if (bl3) {
                    if (bl3) {
                        popupMenu.getMenu().add(1, 2131624839, 0, 2131230862);
                    }
                    popupMenu.getMenu().add(1, 2131624841, 0, 2131230913);
                }
                popupMenu.show();
            }

        });
        if (post.thats_me == 1) {
            basePostViewHolder.reportFlag.setVisibility(8);
        } else {
            basePostViewHolder.reportFlag.setVisibility(0);
            basePostViewHolder.reportFlag.setOnClickListener(new View.OnClickListener(){

                public void onClick(View view) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(BasePostViewHolder.this.f);
                    final int[] arrn = new int[]{-1};
                    CharSequence[] arrcharSequence = new String[]{BasePostViewHolder.this.f.getString(2131230893), BasePostViewHolder.this.f.getString(2131230928), BasePostViewHolder.this.f.getString(2131230855), BasePostViewHolder.this.f.getString(2131230894)};
                    builder.setTitle(2131230952).setSingleChoiceItems(arrcharSequence, -1, new DialogInterface.OnClickListener(){

                        public void onClick(DialogInterface dialogInterface, int n2) {
                            arrn[0] = n2;
                            ((AlertDialog)dialogInterface).getButton(-1).setEnabled(true);
                        }
                    }).setPositiveButton(2131230895, new DialogInterface.OnClickListener((String[])arrcharSequence){
                        final /* synthetic */ String[] b;

                        public void onClick(DialogInterface dialogInterface, int n2) {
                            if (arrn[0] < 0) {
                                Log.d((String)"BPVH", (String)"No reason selected");
                                return;
                            }
                            ik.a().b(post, this.b[arrn[0]]).b(Schedulers.io()).a(apv.a()).b(new apr<EmptyClass>(){

                                public void a(EmptyClass emptyClass) {
                                }

                                @Override
                                public void onCompleted() {
                                    ix.a().a(new in.r(post.post_id));
                                    Context context = GossipApplication.a().getApplicationContext();
                                    Toast.makeText((Context)context, (CharSequence)context.getResources().getString(2131230960), (int)0).show();
                                }

                                @Override
                                public void onError(Throwable throwable) {
                                }

                                @Override
                                public /* synthetic */ void onNext(Object object) {
                                    this.a((EmptyClass)object);
                                }
                            });
                        }

                    }).setNegativeButton((CharSequence)"Cancel", new DialogInterface.OnClickListener(){

                        public void onClick(DialogInterface dialogInterface, int n2) {
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.setOnShowListener(new DialogInterface.OnShowListener(){

                        public void onShow(DialogInterface dialogInterface) {
                            if (arrn[0] < 0) {
                                ((AlertDialog)dialogInterface).getButton(-1).setEnabled(false);
                            }
                        }
                    });
                    alertDialog.show();
                }

            });
        }
        if (post.quality_score == 0.0f && post.is_friend != 1 && post.thats_me != 1 && post.is_candid_mod != 1) {
            basePostViewHolder.mPostHeaderBadge.setVisibility(8);
            return;
        }
        final String string3 = new DecimalFormat("#").format((double)post.quality_score);
        basePostViewHolder.mPostHeaderBadge.setVisibility(0);
        String string4 = "";
        if (post.is_candid_mod == 1) {
            string4 = "MOD";
        } else if (post.thats_me == 1) {
            string4 = "YOU";
        } else if (post.is_friend == 1) {
            string4 = "FRIEND";
        }
        basePostViewHolder.mPostHeaderBadgeText.setText((CharSequence)string4);
        basePostViewHolder.mPostHeaderBadgeText.setTextColor(n2);
        if (post.quality_score != 0.0f) {
            basePostViewHolder.mPostHeaderBadgeScore.setVisibility(0);
            basePostViewHolder.mPostHeaderBadgeScore.setText((CharSequence)string3);
            basePostViewHolder.mPostHeaderBadgeScore.setTextColor(n2);
            if (!string4.isEmpty()) {
                basePostViewHolder.mPostHeaderBadgeDot.setVisibility(0);
                Drawable drawable = basePostViewHolder.f.getResources().getDrawable(2130837707);
                drawable.setColorFilter(n2, PorterDuff.Mode.SRC_IN);
                basePostViewHolder.mPostHeaderBadgeDot.setBackground(drawable);
            } else {
                basePostViewHolder.mPostHeaderBadgeDot.setVisibility(8);
            }
        } else {
            basePostViewHolder.mPostHeaderBadgeScore.setVisibility(8);
            basePostViewHolder.mPostHeaderBadgeDot.setVisibility(8);
        }
        if (post.quality_score != 0.0f) {
            basePostViewHolder.mPostHeaderBadge.setOnClickListener(new View.OnClickListener(){

                public void onClick(View view) {
                    if (!AppState.blurTaskCalledOnFlight) {
                        AppState.blurTaskCalledOnFlight = true;
                        new BlurTask((Activity)basePostViewHolder.f, ((Activity)basePostViewHolder.f).findViewById(16908290), string3, BlurTask.BadgeType.c, basePostViewHolder.f.getString(2131230905), basePostViewHolder.f.getString(2131230931)).execute((Object[])new Void[0]);
                    }
                }
            });
            return;
        }
        basePostViewHolder.mPostHeaderBadge.setOnClickListener(null);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(Post post, BasePostViewHolder basePostViewHolder) {
        int n2 = post.num_likes;
        int n3 = post.num_dislikes;
        int n4 = post.num_comments;
        basePostViewHolder.mCommentPostText.setText((CharSequence)Integer.toString((int)n4));
        basePostViewHolder.mLikeRumorPostText.setText((CharSequence)Integer.toString((int)n2));
        basePostViewHolder.mUnlikeRumorPostText.setText((CharSequence)Integer.toString((int)n3));
        String string2 = post.comment_text;
        String string3 = post.comment_icon_name;
        int n5 = post.comment_image_height;
        int n6 = post.comment_image_width;
        String string4 = post.comment_source_url;
        String string5 = post.comment_time_ago;
        String string6 = post.comment_sticker_name;
        int n7 = post.num_comments;
        int n8 = post.comment_is_candid_mod;
        if (n7 <= 1) {
            basePostViewHolder.mFooterCommentValue.setVisibility(8);
        } else {
            basePostViewHolder.mFooterCommentValue.setVisibility(0);
            String string7 = basePostViewHolder.f.getString(2131230906);
            Object[] arrobject = new Object[]{Integer.toString((int)n7)};
            String string8 = String.format((String)string7, (Object[])arrobject);
            basePostViewHolder.mFooterCommentValue.setText((CharSequence)string8);
        }
        if (string3 == null || string3.isEmpty()) {
            basePostViewHolder.mFooterCommentSnippet.setVisibility(8);
        } else {
            basePostViewHolder.mFooterCommentSnippet.setVisibility(0);
            this.a(post.icon_color, string3, string2, string5, string4, n6, n5, string6, basePostViewHolder, n8, post.post_id);
        }
        jb.a(basePostViewHolder.mFooter);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(final BasePostViewHolder basePostViewHolder, final Post post, final int n2) {
        basePostViewHolder.mPostShareOgImage.setVisibility(4);
        if (post.rumor == 1) {
            basePostViewHolder.mTrueRumorContainerOgImage.setVisibility(0);
            basePostViewHolder.mFalseRumorContainerOgImage.setVisibility(0);
            basePostViewHolder.mLikePostBtnOgImage.setVisibility(8);
            basePostViewHolder.mUnlikePostBtnOgImage.setVisibility(8);
            int n3 = Color.parseColor((String)"#FFFFFF");
            basePostViewHolder.mTrueRumorIconOgImage.setColorFilter(n3);
            basePostViewHolder.mFalseRumorIconOgImage.setColorFilter(n3);
            basePostViewHolder.mTrueRumorTextOgImage.setText((CharSequence)("True " + Integer.toString((int)post.num_true)));
            basePostViewHolder.mFalseRumorTextOgImage.setText((CharSequence)("False " + Integer.toString((int)post.num_false)));
        } else {
            basePostViewHolder.mTrueRumorContainerOgImage.setVisibility(8);
            basePostViewHolder.mFalseRumorContainerOgImage.setVisibility(8);
            basePostViewHolder.mLikePostBtnOgImage.setVisibility(0);
            basePostViewHolder.mUnlikePostBtnOgImage.setVisibility(0);
            basePostViewHolder.mLikePostBtnOgImage.setText((CharSequence)Integer.toString((int)post.num_likes));
            basePostViewHolder.mUnlikePostBtnOgImage.setText((CharSequence)Integer.toString((int)post.num_dislikes));
        }
        basePostViewHolder.mCommentPostBtnOgImage.setText((CharSequence)Integer.toString((int)post.num_comments));
        basePostViewHolder.mPostCaptionOgImage.setText((CharSequence)post.caption);
        basePostViewHolder.mPostGroupOgImage.setText((CharSequence)post.group_name);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(jb.a);
        basePostViewHolder.mPostImageFooter.setBackground((Drawable)gradientDrawable);
        final ShareDialog shareDialog = new ShareDialog((Activity)this.f);
        shareDialog.a(uj.a.a(), new uk<wq.a>(){

            public void a(wq.a a2) {
            }

            @Override
            public void onCancel() {
            }

            @Override
            public void onError(FacebookException facebookException) {
            }

            @Override
            public /* synthetic */ void onSuccess(Object object) {
                this.a((wq.a)object);
            }
        });
        ViewTreeObserver viewTreeObserver = basePostViewHolder.mPostShareOgImage.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(){

                /*
                 * Enabled aggressive block sorting
                 */
                public void onGlobalLayout() {
                    if (BasePostViewHolder.this.mPostShareOgImage != null) {
                        View view = BasePostViewHolder.this.mPostShareOgImage;
                        BasePostViewHolder.this.mPostShareOgImage.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
                        Bitmap bitmap = Bitmap.createBitmap((int)view.getWidth(), (int)view.getHeight(), (Bitmap.Config)Bitmap.Config.ARGB_8888);
                        Canvas canvas = new Canvas(bitmap);
                        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
                        view.draw(canvas);
                        if (bitmap != null) {
                            if (n2 == iy.a) {
                                if (shareDialog != null) {
                                    SharePhoto sharePhoto = new SharePhoto.a().a(bitmap).c();
                                    SharePhotoContent sharePhotoContent = new SharePhotoContent.a().a(sharePhoto).a();
                                    if (ShareDialog.a(SharePhotoContent.class)) {
                                        shareDialog.b(sharePhotoContent);
                                    }
                                }
                            } else if (n2 == 1989) {
                                iy.a().a(bitmap);
                                iy.a().a(basePostViewHolder.f);
                                if (post.share_info != null) {
                                    iy.a().a(post.share_info.url);
                                }
                                if (bb.checkSelfPermission(basePostViewHolder.f, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                                    ActivityCompat.requestPermissions((Activity)((Activity)basePostViewHolder.f), (String[])new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, (int)1989);
                                } else {
                                    iy.a().b();
                                }
                            }
                        }
                        basePostViewHolder.mPostShareOgImage.setVisibility(8);
                    }
                }
            });
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(final String string2, String string3, String string4, String string5, String string6, int n2, int n3, String string7, BasePostViewHolder basePostViewHolder, int n4, final int n5) {
        if (n4 == 1) {
            basePostViewHolder.mFooterCommentModIcon.setVisibility(0);
            basePostViewHolder.mFooterCommentIcon.setVisibility(8);
        } else {
            basePostViewHolder.mFooterCommentIcon.setVisibility(0);
            super.a(string3, Color.parseColor((String)string2), basePostViewHolder.mFooterCommentIcon, basePostViewHolder.f, 25);
            basePostViewHolder.mFooterCommentModIcon.setVisibility(8);
        }
        basePostViewHolder.mFooterCommentTimestamp.setText((CharSequence)string5);
        if (string4 == null || string4.isEmpty()) {
            basePostViewHolder.mFooterCommentText.setVisibility(8);
        } else {
            basePostViewHolder.mFooterCommentText.setVisibility(0);
            basePostViewHolder.mFooterCommentText.setText((CharSequence)string4);
        }
        boolean bl2 = n3 != -1 && n2 != -1 && string6 != null && !string6.isEmpty();
        boolean bl3 = n3 != -1 && n2 != -1 && string7 != null;
        float f2 = basePostViewHolder.f.getResources().getDisplayMetrics().density;
        if (bl2) {
            basePostViewHolder.mFooterCommentImage.setVisibility(0);
            int n6 = (int)(f2 * (float)n2);
            int n7 = (int)(f2 * (float)n3);
            basePostViewHolder.mFooterCommentImage.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(n6, n7));
            GossipApplication.c.a(string6).d().a(basePostViewHolder.mFooterCommentImage);
        } else if (bl3) {
            basePostViewHolder.mFooterCommentImage.setVisibility(0);
            int n8 = (int)(f2 * (float)n2);
            int n9 = (int)(f2 * (float)n3);
            basePostViewHolder.mFooterCommentImage.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(n8, n9));
            int n10 = GossipApplication.a.getResources().getIdentifier(string7.toLowerCase(), "drawable", GossipApplication.a.getPackageName());
            basePostViewHolder.mFooterCommentImage.setImageDrawable(GossipApplication.a.getResources().getDrawable(n10));
        } else {
            basePostViewHolder.mFooterCommentImage.setVisibility(8);
        }
        basePostViewHolder.mFooterCommentSnippet.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), (Class)PostDetailsActivity.class);
                intent.putExtra("post_id", n5);
                intent.putExtra("op_color", string2);
                if (a != null) {
                    intent.putExtra("feed_type", a);
                }
                BasePostViewHolder.this.f.startActivity(intent);
            }
        });
    }

}

