/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Color
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.support.v7.widget.PopupMenu
 *  android.support.v7.widget.PopupMenu$OnMenuItemClickListener
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$ViewHolder
 *  android.view.LayoutInflater
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnLongClickListener
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 *  rx.schedulers.Schedulers
 */
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.MessageActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Config;
import com.becandid.candid.data.Message;
import com.becandid.candid.data.MessageThread;
import com.becandid.candid.data.Post;
import com.becandid.candid.data.User;
import com.becandid.candid.models.EmptySubscriber;
import com.becandid.candid.models.NetworkData;
import com.becandid.candid.util.RoundedCornersTransformation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.schedulers.Schedulers;

public class hl
extends hd<MessageThread> {
    private Context d;
    private io e;

    public hl(Context context) {
        this.d = context;
        this.e = io.a();
    }

    @Override
    public void a(MessageThread messageThread) {
        if (this.a != null) {
            this.a.add(0, (Object)messageThread);
            this.notifyItemInserted(0);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(final jc jc2, int n2) {
        jg jg2 = (jg)jc2;
        final MessageThread messageThread = (MessageThread)this.a.get(n2);
        jg2.a.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                Intent intent = new Intent(hl.this.d, (Class)MessageActivity.class);
                intent.putExtra("post_id", Integer.toString((int)messageThread.post_id));
                if (messageThread.target_user_info.post_name != null) {
                    intent.putExtra("user_name", messageThread.target_user_info.post_name);
                }
                hl.this.d.startActivity(intent);
                HashMap hashMap = new HashMap();
                hashMap.put((Object)"post_id", (Object)Integer.toString((int)messageThread.post_id));
                if (messageThread.target_user_info.post_name != null) {
                    hashMap.put((Object)"post_name", (Object)messageThread.target_user_info.post_name);
                }
                ik.a().w((Map<String, String>)hashMap).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
                int n2 = jc2.getAdapterPosition();
                if (n2 != -1) {
                    ((MessageThread)hl.this.a.get((int)n2)).unread_messages = 0;
                    hl.this.notifyItemChanged(n2);
                }
            }
        });
        jg2.a.setOnLongClickListener(new View.OnLongClickListener(){

            public boolean onLongClick(View view) {
                PopupMenu popupMenu = new PopupMenu(hl.this.d, view);
                popupMenu.getMenuInflater().inflate(2131689479, popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){

                    /*
                     * Enabled aggressive block sorting
                     */
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        HashMap hashMap = new HashMap();
                        int n2 = messageThread.post_id;
                        String string2 = messageThread.target_user_info.post_name;
                        hashMap.put((Object)"post_id", (Object)Integer.toString((int)n2));
                        hashMap.put((Object)"post_name", (Object)string2);
                        switch (menuItem.getItemId()) {
                            default: {
                                return false;
                            }
                            case 2131624854: 
                        }
                        if (messageThread.is_request == 1) {
                            ik.a().s((Map<String, String>)hashMap).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
                        } else {
                            ik.a().u((Map<String, String>)hashMap).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
                        }
                        ix.a().a(new in.j(n2, string2));
                        return true;
                    }
                });
                return true;
            }

        });
        int n3 = this.d.getResources().getColor(2131558476);
        try {
            int n4;
            n3 = n4 = Color.parseColor((String)messageThread.target_user_info.icon_color);
        }
        catch (NullPointerException var6_12) {
            rk.c().a((ru)new ru("Display Messaging Thread").a("Thread", messageThread.toString()));
        }
        if (AppState.config.getInt("enable_nickname", 1) == 1 && messageThread.target_user_info.nickname != null && !messageThread.target_user_info.nickname.equals((Object)"")) {
            jg2.g.setText((CharSequence)messageThread.target_user_info.nickname);
            jg2.b.setTypeface(Typeface.DEFAULT_BOLD);
            jg2.b.setTextSize(28.0f);
            jg2.b.setText((CharSequence)messageThread.target_user_info.nickname.substring(0, 1));
        } else {
            jg2.g.setText((CharSequence)messageThread.target_user_info.post_name);
            TextView textView = jg2.b;
            textView.setTypeface(io.b());
            jg2.b.setTextSize(40.0f);
            TextView textView2 = jg2.b;
            textView2.setText((CharSequence)io.a(messageThread.target_user_info.icon_name));
        }
        jg2.g.setTextColor(n3);
        jg2.b.setTextColor(n3);
        int n5 = jg2.c.getWidth();
        if (n5 == 0) {
            n5 = jb.a(60, this.d);
        }
        int n6 = 1073741824 | 16777215 & n3;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(n6);
        gradientDrawable.setCornerRadius((float)(n5 / 2));
        jg2.c.setBackground((Drawable)gradientDrawable);
        if (messageThread.online == 1) {
            jg2.d.setVisibility(0);
        } else {
            jg2.d.setVisibility(8);
        }
        jg2.h.setText((CharSequence)((Message)messageThread.messages.get((int)0)).subject);
        jg2.i.setText((CharSequence)ip.a(messageThread.sent_time));
        if (messageThread.post != null) {
            if (messageThread.post.thumb_url != null) {
                jg2.j.setBackground(null);
                jg2.k.setVisibility(8);
                jg2.m.setVisibility(8);
                jg2.l.setVisibility(0);
                jt<String> jt2 = GossipApplication.c.a(messageThread.post.thumb_url).d();
                kr[] arrkr = new kr[]{new RoundedCornersTransformation(this.d, jb.a(4, this.d), 0)};
                jt2.a(arrkr).a(jg2.l);
            } else {
                jg2.l.setVisibility(8);
                jg2.m.setVisibility(8);
                jg2.k.setVisibility(0);
                jg2.k.setTypeface(ih.a(this.d).a("JosefinSans-SemiBold.ttf"));
                jg2.j.setBackground(this.d.getResources().getDrawable(2130838061));
                ((GradientDrawable)jg2.j.getBackground()).setColor(Color.parseColor((String)messageThread.post.icon_color));
                if (messageThread.post.caption != null) {
                    jg2.k.setText((CharSequence)messageThread.post.caption);
                } else if (messageThread.post.og_title != null) {
                    jg2.k.setText((CharSequence)messageThread.post.og_title);
                }
            }
        } else {
            jg2.l.setVisibility(8);
            jg2.k.setVisibility(8);
            jg2.m.setVisibility(0);
            jg2.j.setBackground(this.d.getResources().getDrawable(2130838061));
            ((GradientDrawable)jg2.j.getBackground()).setColor(Color.parseColor((String)"#DDDDDD"));
        }
        if (messageThread.unread_messages > 0) {
            jg2.a.setBackgroundColor(268435456 | 16777215 & this.d.getResources().getColor(2131558476));
            return;
        }
        jg2.a.setBackground(this.d.getResources().getDrawable(2130838062));
    }

    public boolean a(in.ae ae2) {
        if (this.a != null) {
            for (int i2 = 0; i2 < this.a.size(); ++i2) {
                MessageThread messageThread = (MessageThread)this.a.get(i2);
                if (messageThread.post_id != ae2.b || !messageThread.target_user_info.post_name.equals((Object)ae2.d)) continue;
                ((Message)messageThread.messages.get((int)0)).message = ae2.c;
                ((Message)messageThread.messages.get((int)0)).subject = ae2.c;
                ((Message)messageThread.messages.get((int)0)).sent_time = System.currentTimeMillis();
                messageThread.unread_messages = 1 + messageThread.unread_messages;
                this.notifyItemChanged(i2);
                return true;
            }
        }
        return false;
    }

    public MessageThread b(int n2) {
        return (MessageThread)this.a.get(n2);
    }

    @Override
    public jc b(ViewGroup viewGroup, int n2) {
        return new jg(LayoutInflater.from((Context)viewGroup.getContext()).inflate(2130968700, viewGroup, false));
    }

    public void c(int n2) {
        this.a.remove(n2);
        this.notifyItemRemoved(n2);
    }

    public boolean f() {
        return this.a.isEmpty();
    }

    @Override
    public /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int n2) {
        this.a((jc)viewHolder, n2);
    }

    @Override
    public /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int n2) {
        return this.b(viewGroup, n2);
    }

}

