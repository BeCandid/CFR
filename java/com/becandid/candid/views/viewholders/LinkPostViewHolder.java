/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Point
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.WindowManager
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.TextView
 *  butterknife.BindView
 *  com.bumptech.glide.load.engine.DiskCacheStrategy
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
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
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.PostDetailsActivity;
import com.becandid.candid.activities.WebViewActivity;
import com.becandid.candid.data.Post;
import com.becandid.candid.util.RoundedCornersTransformation;
import com.becandid.candid.views.viewholders.BasePostViewHolder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class LinkPostViewHolder
extends BasePostViewHolder {
    static RoundedCornersTransformation a;
    @BindView(value=2131624115)
    TextView mPostCaption;
    @BindView(value=2131624412)
    ImageView mPostImageImage;
    @BindView(value=2131624402)
    View mPostImageRow;
    @BindView(value=2131624415)
    View mPostInfoImage;
    @BindView(value=2131624397)
    TextView mPostLinkDesc;
    @BindView(value=2131624417)
    TextView mPostLinkDescImage;
    @BindView(value=2131624398)
    TextView mPostLinkDomain;
    @BindView(value=2131624418)
    TextView mPostLinkDomainImage;
    @BindView(value=2131624395)
    ImageView mPostLinkImage;
    @BindView(value=2131624394)
    View mPostLinkPlacehoder;
    @BindView(value=2131624414)
    View mPostLinkRow;
    @BindView(value=2131624396)
    TextView mPostLinkTitle;
    @BindView(value=2131624416)
    TextView mPostLinkTitleImage;

    public LinkPostViewHolder(View view, Activity activity) {
        super(view, activity);
        a = new RoundedCornersTransformation((Context)activity, (int)(10.0f * activity.getResources().getDisplayMetrics().density), 3, RoundedCornersTransformation.CornerType.f);
    }

    public LinkPostViewHolder(View view, Activity activity, String string2) {
        super(view, activity, string2);
        a = new RoundedCornersTransformation((Context)activity, (int)(10.0f * activity.getResources().getDisplayMetrics().density), 3, RoundedCornersTransformation.CornerType.f);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void a(final LinkPostViewHolder linkPostViewHolder, final Post post) {
        BasePostViewHolder.a(linkPostViewHolder, post);
        jb.a(linkPostViewHolder.mPostImageRow, post.icon_color);
        if (post.caption == null || post.caption.isEmpty()) {
            linkPostViewHolder.mPostCaption.setVisibility(8);
        } else {
            linkPostViewHolder.mPostCaption.setVisibility(0);
        }
        linkPostViewHolder.mPostLinkTitle.setText((CharSequence)post.og_title);
        linkPostViewHolder.mPostLinkDesc.setText((CharSequence)post.og_desc);
        linkPostViewHolder.mPostLinkDomain.setText((CharSequence)post.link_domain);
        linkPostViewHolder.mPostLinkPlacehoder.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                String string2 = post.link_url;
                if (string2 == null || string2.isEmpty()) {
                    rj.a((Throwable)new Exception("link url is null or empty"));
                    return;
                }
                Intent intent = new Intent(linkPostViewHolder.f, (Class)WebViewActivity.class);
                intent.putExtra("title", post.og_title);
                intent.putExtra("url", string2);
                linkPostViewHolder.f.startActivity(intent);
            }
        });
        linkPostViewHolder.mPostLinkRow.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                if (!(linkPostViewHolder.f instanceof PostDetailsActivity)) {
                    PostDetailsActivity.startPostDetailsActivity(post.post_id, linkPostViewHolder.f, post.icon_color);
                }
            }
        });
        String string2 = post.thumb_url != null ? post.thumb_url : post.source_url;
        if (string2 == null) {
            rj.a((Throwable)new Exception("thumb_url and source_url are both null"));
            linkPostViewHolder.mPostLinkImage.setVisibility(8);
            return;
        }
        if (post.actual_height == -1 && post.actual_width == -1) {
            Display display = ((WindowManager)linkPostViewHolder.f.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            display.getSize(point);
            int n2 = point.x - 2 * (int)(15.0f * ((float)linkPostViewHolder.f.getResources().getDisplayMetrics().densityDpi / 160.0f));
            int n3 = (int)(0.55 * (double)n2);
            post.actual_width = n2;
            post.actual_height = n3;
        }
        linkPostViewHolder.mPostLinkImage.setVisibility(0);
        linkPostViewHolder.mPostLinkImage.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(post.actual_width, post.actual_height));
        jt<String> jt2 = GossipApplication.c.a(string2).a().d();
        kr[] arrkr = new kr[]{a};
        jt2.a(arrkr).a((String)DiskCacheStrategy.c).a(new qz<ImageView, oh>(linkPostViewHolder.mPostLinkImage){

            public void a(oh oh2, qk<? super oh> qk2) {
                ((ImageView)this.view).setImageDrawable((Drawable)oh2);
                linkPostViewHolder.mPostImageImage.setImageDrawable((Drawable)oh2);
                linkPostViewHolder.mPostImageImage.setScaleType(ImageView.ScaleType.FIT_XY);
            }

            @Override
            public /* synthetic */ void onResourceReady(Object object, qk qk2) {
                this.a((oh)((Object)object), qk2);
            }
        });
    }

    @Override
    public void a(BasePostViewHolder basePostViewHolder, Post post, int n2) {
        super.a(basePostViewHolder, post, n2);
        LinkPostViewHolder linkPostViewHolder = (LinkPostViewHolder)basePostViewHolder;
        linkPostViewHolder.mPostLinkTitleImage.setText((CharSequence)post.og_title);
        linkPostViewHolder.mPostLinkDescImage.setText((CharSequence)post.og_desc);
        linkPostViewHolder.mPostLinkDomainImage.setText((CharSequence)post.link_domain);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(jb.a);
        linkPostViewHolder.mPostInfoImage.setBackground((Drawable)gradientDrawable);
    }

}

