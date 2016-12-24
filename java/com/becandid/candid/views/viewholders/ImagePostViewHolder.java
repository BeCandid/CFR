/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.graphics.Point
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnLongClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.WindowManager
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.TextView
 *  butterknife.BindView
 *  com.bumptech.glide.load.engine.DiskCacheStrategy
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.becandid.candid.views.viewholders;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.FullScreenImageActivity;
import com.becandid.candid.activities.PostDetailsActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Config;
import com.becandid.candid.data.Post;
import com.becandid.candid.data.ShareInfo;
import com.becandid.candid.views.viewholders.BasePostViewHolder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class ImagePostViewHolder
extends BasePostViewHolder {
    public boolean a;
    @BindView(value=2131624115)
    TextView mPostCaption;
    @BindView(value=2131624407)
    View mPostGifPlay;
    @BindView(value=2131624404)
    ImageView mPostImage;
    @BindView(value=2131624403)
    View mPostImageContainer;
    @BindView(value=2131624412)
    ImageView mPostImageImage;
    @BindView(value=2131624402)
    View mPostImageRow;
    @BindView(value=2131624406)
    View mPostLoadingImageProgress;
    @BindView(value=2131624405)
    View mPostLoadingImageProgressContainer;

    public ImagePostViewHolder(View view, Activity activity) {
        super(view, activity);
    }

    public ImagePostViewHolder(View view, Activity activity, String string2) {
        super(view, activity, string2);
    }

    public ImagePostViewHolder(View view, Activity activity, boolean bl2) {
        super(view, activity);
        this.a = bl2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void a(final ImagePostViewHolder imagePostViewHolder, final Post post) {
        BasePostViewHolder.a(imagePostViewHolder, post);
        jb.a(imagePostViewHolder.mPostImageRow, post.icon_color);
        String string2 = post.thumb_url != null ? post.thumb_url : post.source_url;
        int n2 = post.width;
        int n3 = post.height;
        if (string2 == null || n2 == 0 || n3 == 0) {
            rj.a((Throwable)new Exception("thumb_url and source_url are both null"));
            return;
        }
        if (post.actual_height == -1 && post.actual_width == -1) {
            Display display = ((WindowManager)imagePostViewHolder.f.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            display.getSize(point);
            int n4 = point.x - 2 * (int)(5.0f * ((float)imagePostViewHolder.f.getResources().getDisplayMetrics().densityDpi / 160.0f));
            post.actual_height = (int)((float)n4 * (float)n3 / (float)n2);
            post.actual_width = n4;
        }
        imagePostViewHolder.mPostImage.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(post.actual_width, post.actual_height));
        if (post.localBitmapPath != null && imagePostViewHolder.a) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            Bitmap bitmap = BitmapFactory.decodeFile((String)post.localBitmapPath, (BitmapFactory.Options)options);
            imagePostViewHolder.mPostImage.setImageBitmap(bitmap);
        } else if (AppState.config.getInt("android_enable_image_progress") == 1) {
            is.a(imagePostViewHolder.mPostLoadingImageProgress, imagePostViewHolder.mPostLoadingImageProgressContainer, imagePostViewHolder.f, post.actual_width, Math.min((int)120, (int)post.actual_height), string2, imagePostViewHolder.mPostImage, imagePostViewHolder.mPostGifPlay, post.wait_for_play, false);
        } else {
            imagePostViewHolder.mPostImage.setBackgroundResource(17301613);
            GossipApplication.c.a(string2).d().a((String)DiskCacheStrategy.c).a(imagePostViewHolder.mPostImage);
        }
        imagePostViewHolder.mPostImageRow.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                if (!(imagePostViewHolder.f instanceof PostDetailsActivity)) {
                    PostDetailsActivity.startPostDetailsActivity(post.post_id, imagePostViewHolder.f, post.icon_color);
                    return;
                }
                Intent intent = new Intent(view.getContext(), (Class)FullScreenImageActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("post_id", post.post_id);
                bundle.putString("source_url", post.source_url);
                bundle.putInt("num_likes", post.num_likes);
                bundle.putInt("num_dislikes", post.num_dislikes);
                bundle.putString("icon_name", post.icon_name);
                bundle.putString("icon_color", post.icon_color);
                bundle.putString("user_name", post.user_name);
                bundle.putInt("like_value", post.like_value);
                bundle.putInt("num_comments", post.num_comments);
                bundle.putBoolean("fromDetails", true);
                bundle.putInt("is_rumor", post.rumor);
                bundle.putInt("num_true", post.num_true);
                bundle.putInt("num_false", post.num_false);
                bundle.putInt("opinion_value", post.opinion_value);
                bundle.putString("share_info_url", post.share_info.url);
                bundle.putString("share_info_title", post.share_info.title);
                bundle.putString("share_info_image", post.share_info.image);
                intent.putExtras(bundle);
                view.getContext().startActivity(intent);
            }
        });
        imagePostViewHolder.mPostImageRow.setOnLongClickListener(new View.OnLongClickListener(){

            public boolean onLongClick(View view) {
                if (!(imagePostViewHolder.f instanceof PostDetailsActivity)) {
                    Intent intent = new Intent(view.getContext(), (Class)FullScreenImageActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("post_id", post.post_id);
                    bundle.putString("source_url", post.source_url);
                    bundle.putInt("num_likes", post.num_likes);
                    bundle.putInt("num_dislikes", post.num_dislikes);
                    bundle.putString("icon_name", post.icon_name);
                    bundle.putString("icon_color", post.icon_color);
                    bundle.putString("user_name", post.user_name);
                    bundle.putInt("like_value", post.like_value);
                    bundle.putInt("num_comments", post.num_comments);
                    bundle.putInt("is_rumor", post.rumor);
                    bundle.putInt("num_true", post.num_true);
                    bundle.putInt("num_false", post.num_false);
                    bundle.putInt("opinion_value", post.opinion_value);
                    bundle.putString("share_info_url", post.share_info.url);
                    bundle.putString("share_info_title", post.share_info.title);
                    bundle.putString("share_info_image", post.share_info.image);
                    intent.putExtras(bundle);
                    view.getContext().startActivity(intent);
                }
                return false;
            }
        });
    }

    @Override
    public void a(BasePostViewHolder basePostViewHolder, Post post, int n2) {
        super.a(basePostViewHolder, post, n2);
        Display display = ((WindowManager)basePostViewHolder.f.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        int n3 = point.x;
        ImagePostViewHolder imagePostViewHolder = (ImagePostViewHolder)basePostViewHolder;
        Drawable drawable = imagePostViewHolder.mPostImage.getDrawable();
        imagePostViewHolder.mPostImageImage.setImageDrawable(drawable.getCurrent());
        imagePostViewHolder.mPostImageImage.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(n3, post.actual_height));
        imagePostViewHolder.mPostImageImage.setScaleType(ImageView.ScaleType.FIT_XY);
    }

}

