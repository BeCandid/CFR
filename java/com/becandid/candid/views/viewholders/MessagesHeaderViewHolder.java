/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.graphics.Color
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.util.DisplayMetrics
 *  android.view.View
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  butterknife.BindView
 *  java.lang.CharSequence
 *  java.lang.String
 */
package com.becandid.candid.views.viewholders;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.becandid.candid.data.User;

public class MessagesHeaderViewHolder
extends jc {
    public static io a;
    @BindView(value=2131624236)
    RelativeLayout messagesHeaderIconContainer;
    @BindView(value=2131624556)
    TextView messagesHeaderName;
    @BindView(value=2131624238)
    TextView messagesHeaderUserIcon;

    public MessagesHeaderViewHolder(View view) {
        super(view);
        a = io.a();
    }

    public static void a(MessagesHeaderViewHolder messagesHeaderViewHolder, User user) {
        int n2 = Color.parseColor((String)user.icon_color);
        messagesHeaderViewHolder.messagesHeaderUserIcon.setTextColor(n2);
        TextView textView = messagesHeaderViewHolder.messagesHeaderUserIcon;
        textView.setTypeface(io.b());
        TextView textView2 = messagesHeaderViewHolder.messagesHeaderUserIcon;
        textView2.setText((CharSequence)io.a(user.icon_name));
        int n3 = messagesHeaderViewHolder.messagesHeaderIconContainer.getWidth();
        if (n3 == 0) {
            n3 = (int)(30.0f * messagesHeaderViewHolder.messagesHeaderIconContainer.getResources().getDisplayMetrics().density);
        }
        int n4 = 1073741824 | 16777215 & n2;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(n4);
        gradientDrawable.setCornerRadius((float)(n3 / 2));
        messagesHeaderViewHolder.messagesHeaderIconContainer.setBackground((Drawable)gradientDrawable);
        messagesHeaderViewHolder.messagesHeaderName.setText((CharSequence)user.post_name);
        messagesHeaderViewHolder.messagesHeaderName.setTextColor(n2);
    }
}

