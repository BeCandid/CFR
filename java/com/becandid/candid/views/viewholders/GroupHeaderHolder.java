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
 *  android.support.v7.widget.PopupMenu
 *  android.support.v7.widget.PopupMenu$OnMenuItemClickListener
 *  android.util.DisplayMetrics
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnClickListener
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.widget.ImageView
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  butterknife.BindView
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 */
package com.becandid.candid.views.viewholders;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.PopupMenu;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.GroupDetailsActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Config;
import com.becandid.candid.data.Post;
import com.becandid.candid.util.RoundedCornersTransformation;
import java.util.List;

public class GroupHeaderHolder
extends jc {
    @BindView(value=2131624386)
    TextView groupAbout;
    @BindView(value=2131624376)
    RelativeLayout groupHeader;
    @BindView(value=2131624379)
    ImageView groupImage;
    @BindView(value=2131624380)
    TextView groupJoin;
    @BindView(value=2131624381)
    TextView groupLeave;
    @BindView(value=2131624377)
    ImageView groupMenu;
    @BindView(value=2131624387)
    TextView groupStats;

    public GroupHeaderHolder(View view, Activity activity) {
        super(view, activity);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(final GroupHeaderHolder groupHeaderHolder, final Post post) {
        int[] arrn = new int[]{2131624383, 2131624384, 2131624385};
        for (int i2 = 0; i2 < arrn.length; ++i2) {
            TextView textView = (TextView)this.groupHeader.findViewById(arrn[i2]);
            if (i2 < post.tags.size()) {
                textView.setText((CharSequence)apf.a((String)post.tags.get(i2)));
                textView.setVisibility(0);
                continue;
            }
            textView.setVisibility(8);
        }
        this.groupAbout.setText((CharSequence)post.about);
        int n2 = AppState.config.getInt("max_group_desc_lines", 7);
        this.groupAbout.setMaxLines(n2);
        StringBuilder stringBuilder = new StringBuilder(50);
        stringBuilder.append((Object)post.num_posts + " POST");
        if (post.num_posts != 1) {
            stringBuilder.append("S");
        }
        stringBuilder.append("  |  ");
        stringBuilder.append((Object)post.num_members + " MEMBER");
        if (post.num_members != 1) {
            stringBuilder.append("S");
        }
        if (post.num_friends > 1) {
            stringBuilder.append("  |  " + (Object)post.num_friends + " FRIENDS");
        }
        this.groupStats.setText((CharSequence)stringBuilder.toString());
        this.groupImage.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(){

            public void onGlobalLayout() {
                GossipApplication.c.a(post.imageUrl()).j().a().a(17301613).a(new qv<Bitmap>(GroupHeaderHolder.this.groupImage.getWidth(), GroupHeaderHolder.this.groupImage.getHeight()){

                    public void a(Bitmap bitmap, qk<? super Bitmap> qk2) {
                        float f2 = GroupHeaderHolder.this.f.getResources().getDisplayMetrics().density;
                        Bitmap bitmap2 = new RoundedCornersTransformation(GroupHeaderHolder.this.f, (int)(60.0f * f2), 0, RoundedCornersTransformation.CornerType.a).a(bitmap, GroupHeaderHolder.this.groupImage.getWidth(), GroupHeaderHolder.this.groupImage.getHeight()).b();
                        GroupHeaderHolder.this.groupImage.setImageBitmap(bitmap2);
                        Bitmap bitmap3 = im.a(bitmap, GroupHeaderHolder.this.groupHeader.getWidth(), GroupHeaderHolder.this.groupHeader.getHeight());
                        if (bitmap3 != null) {
                            GroupHeaderHolder.this.groupHeader.setBackground((Drawable)new BitmapDrawable(bitmap3));
                        }
                    }

                    @Override
                    public /* synthetic */ void onResourceReady(Object object, qk qk2) {
                        this.a((Bitmap)object, qk2);
                    }
                });
            }

        });
        if (post.isMember() && post.moderator != 1) {
            this.groupLeave.setVisibility(0);
            this.groupJoin.setVisibility(8);
        } else if (!post.isMember()) {
            this.groupJoin.setVisibility(0);
            this.groupLeave.setVisibility(8);
        } else {
            this.groupJoin.setVisibility(8);
            this.groupLeave.setVisibility(8);
        }
        this.groupJoin.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                GroupHeaderHolder.this.groupJoin.setVisibility(8);
                GroupHeaderHolder.this.groupLeave.setVisibility(0);
                if (GroupHeaderHolder.this.f instanceof GroupDetailsActivity) {
                    ((GroupDetailsActivity)GroupHeaderHolder.this.f).joinGroupClick(view);
                }
            }
        });
        this.groupLeave.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                GroupHeaderHolder.this.groupLeave.setVisibility(8);
                GroupHeaderHolder.this.groupJoin.setVisibility(0);
                if (GroupHeaderHolder.this.f instanceof GroupDetailsActivity) {
                    ((GroupDetailsActivity)GroupHeaderHolder.this.f).leaveGroupClick(view);
                }
            }
        });
        this.groupMenu.setOnClickListener(new View.OnClickListener(){

            /*
             * Enabled aggressive block sorting
             */
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
                popupMenu.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener)groupHeaderHolder.f);
                if (post.moderator == 1 && post.num_posts == 0) {
                    popupMenu.getMenu().add(1, 2131624840, 0, 2131230827);
                    popupMenu.getMenu().add(1, 2131624842, 0, 2131230835);
                } else if (post.moderator == 1) {
                    popupMenu.getMenu().add(1, 2131624842, 0, 2131230835);
                } else {
                    popupMenu.getMenu().add(1, 2131624841, 0, 2131230913);
                }
                popupMenu.show();
            }
        });
        this.groupHeader.measure(View.MeasureSpec.makeMeasureSpec((int)this.f.getResources().getDisplayMetrics().widthPixels, (int)1073741824), 0);
    }

}

