/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.graphics.Color
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$ViewHolder
 *  android.text.SpannableString
 *  android.text.style.ForegroundColorSpan
 *  android.text.style.StyleSpan
 *  android.util.DisplayMetrics
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageView
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.FullScreenImageActivity;
import com.becandid.candid.data.Notification;
import java.util.List;

public class hb
extends hd<Notification> {
    private io d = io.a();
    private Context e;

    public hb(Context context) {
        this.e = context;
    }

    public ji a(ViewGroup viewGroup, int n2) {
        return new ji(LayoutInflater.from((Context)viewGroup.getContext()).inflate(2130968714, viewGroup, false));
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void a(jc jc2, int n2) {
        SpannableString spannableString;
        final ji ji2 = (ji)jc2;
        final Notification notification = (Notification)this.a.get(n2);
        int n3 = this.e.getResources().getIdentifier(notification.action_icon.toLowerCase() + "_activity", "drawable", this.e.getPackageName());
        Drawable drawable = this.e.getResources().getDrawable(n3);
        ji2.g.setImageDrawable(drawable);
        if (notification.user_name != null && !notification.title.startsWith("Someone") && notification.icon_color != null) {
            int n4 = Color.parseColor((String)notification.icon_color);
            String string2 = notification.user_name + " " + notification.title;
            spannableString = new SpannableString((CharSequence)string2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(n4);
            spannableString.setSpan((Object)foregroundColorSpan, 0, notification.user_name.length(), 33);
            spannableString.setSpan((Object)new StyleSpan(1), notification.user_name.length(), string2.length(), 33);
            ji2.h.setVisibility(0);
            TextView textView = ji2.h;
            textView.setTypeface(io.b());
            ji2.h.setTextColor(n4);
            ji2.h.setText((CharSequence)io.a(notification.icon_name));
            int n5 = ji2.h.getWidth();
            if (n5 == 0) {
                n5 = (int)(30.0f * ji2.h.getResources().getDisplayMetrics().density);
            }
            int n6 = 1073741824 | 16777215 & n4;
            ji2.j.setColor(n6);
            ji2.j.setCornerRadius((float)(n5 / 2));
            ji2.h.setBackground((Drawable)ji2.j);
        } else {
            ji2.h.setVisibility(8);
            String string3 = notification.title;
            spannableString = new SpannableString((CharSequence)string3);
            spannableString.setSpan((Object)new StyleSpan(1), 0, string3.length(), 33);
        }
        ji2.a.setText((CharSequence)spannableString);
        if (notification.sticker_name != null) {
            ji2.m.setVisibility(0);
            int n7 = this.e.getResources().getIdentifier(notification.sticker_name.toLowerCase(), "drawable", this.e.getPackageName());
            Drawable drawable2 = this.e.getResources().getDrawable(n7);
            ji2.i.setImageDrawable(drawable2);
            ji2.i.setVisibility(0);
            if ("".equals((Object)notification.body)) {
                ji2.b.setVisibility(8);
            } else {
                ji2.b.setText((CharSequence)notification.body);
                ji2.b.setVisibility(0);
            }
        } else {
            ji2.m.setVisibility(8);
            if (notification.body == null || "".equals((Object)notification.body)) {
                ji2.b.setVisibility(8);
            } else {
                ji2.b.setText((CharSequence)notification.body);
                ji2.b.setVisibility(0);
            }
        }
        if (notification.source_url != null) {
            ji2.c.setVisibility(0);
            float f2 = this.e.getResources().getDisplayMetrics().density;
            FrameLayout.LayoutParams layoutParams = notification.image_width > 250 || notification.image_height > 250 ? new FrameLayout.LayoutParams((int)(0.05f + 250.0f * f2), (int)(0.05f + 250.0f * f2)) : new FrameLayout.LayoutParams((int)(0.05f + f2 * (float)notification.image_width), (int)(0.05f + f2 * (float)notification.image_height));
            ji2.c.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            ji2.c.setBackgroundResource(17301613);
            jt<String> jt2 = GossipApplication.c.a(notification.source_url).d();
            qf<String, oh> qf2 = new qf<String, oh>(){

                public boolean a(Exception exception, String string2, qy<oh> qy2, boolean bl2) {
                    return false;
                }

                public boolean a(oh oh2, String string2, qy<oh> qy2, boolean bl2, boolean bl3) {
                    ji2.c.setBackground(null);
                    return false;
                }

                @Override
                public /* synthetic */ boolean onException(Exception exception, Object object, qy qy2, boolean bl2) {
                    return this.a(exception, (String)object, qy2, bl2);
                }

                @Override
                public /* synthetic */ boolean onResourceReady(Object object, Object object2, qy qy2, boolean bl2, boolean bl3) {
                    return this.a((oh)((Object)object), (String)object2, qy2, bl2, bl3);
                }
            };
            jt2.a(qf2).a(ji2.c);
            ImageView imageView = ji2.c;
            View.OnClickListener onClickListener = new View.OnClickListener(){

                public void onClick(View view) {
                    Intent intent = new Intent(hb.this.e, (Class)FullScreenImageActivity.class);
                    intent.putExtra("source_url", notification.source_url);
                    if (notification.onclick.split("/")[0].equals((Object)"post")) {
                        hb.this.e.startActivity(intent);
                    }
                }
            };
            imageView.setOnClickListener(onClickListener);
        } else {
            ji2.c.setVisibility(8);
        }
        ji2.d.setText((CharSequence)ip.a(notification.t_create));
        View view = ((ji)jc2).itemView;
        view.measure(View.MeasureSpec.makeMeasureSpec((int)view.getContext().getResources().getDisplayMetrics().widthPixels, (int)1073741824), View.MeasureSpec.makeMeasureSpec((int)0, (int)0));
        if (notification.unread == 1) {
            ji2.a.setTypeface(Typeface.DEFAULT_BOLD);
            ji2.k.setBackgroundColor(268435456 | 16777215 & this.e.getResources().getColor(2131558476));
            return;
        }
        ji2.k.setBackgroundColor(this.e.getResources().getColor(17170443));
    }

    @Override
    public /* synthetic */ jc b(ViewGroup viewGroup, int n2) {
        return this.a(viewGroup, n2);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int n2) {
        this.a((jc)viewHolder, n2);
    }

    @Override
    public /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int n2) {
        return this.a(viewGroup, n2);
    }

}

