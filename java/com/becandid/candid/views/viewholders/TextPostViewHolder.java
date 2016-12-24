/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.graphics.Color
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.view.View
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  butterknife.BindView
 *  java.lang.String
 */
package com.becandid.candid.views.viewholders;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.becandid.candid.data.Post;
import com.becandid.candid.views.viewholders.BasePostViewHolder;

public class TextPostViewHolder
extends BasePostViewHolder {
    @BindView(value=2131624115)
    TextView mPostCaption;
    @BindView(value=2131624420)
    LinearLayout mPostCaptionPlaceholder;
    @BindView(value=2131624411)
    TextView mPostImageCaption;
    @BindView(value=2131624795)
    TextView mPostImageGroup;
    @BindView(value=2131624408)
    View mPostShareImage;
    @BindView(value=2131624419)
    View mPostTextRow;

    public TextPostViewHolder(View view, Activity activity) {
        super(view, activity);
    }

    public TextPostViewHolder(View view, Activity activity, String string2) {
        super(view, activity, string2);
    }

    public static void a(TextPostViewHolder textPostViewHolder, Post post) {
        BasePostViewHolder.a(textPostViewHolder, post);
        jb.a(textPostViewHolder.mPostTextRow, post.icon_color);
        textPostViewHolder.mPostCaption.setTypeface(ih.a(textPostViewHolder.f).a("JosefinSans-SemiBold.ttf"));
    }

    @Override
    public void a(BasePostViewHolder basePostViewHolder, Post post, int n2) {
        super.a(basePostViewHolder, post, n2);
        this.mPostShareImage.setVisibility(4);
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (post.icon_color != null) {
            gradientDrawable.setColor(Color.parseColor((String)post.icon_color));
        }
        this.mPostShareImage.setBackground((Drawable)gradientDrawable);
        this.mPostImageCaption.setTypeface(ih.a(basePostViewHolder.f).a("JosefinSans-SemiBold.ttf"));
    }
}

