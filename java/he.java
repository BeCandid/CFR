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
 *  android.graphics.Color
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.support.v7.app.AlertDialog
 *  android.support.v7.app.AlertDialog$Builder
 *  android.support.v7.widget.PopupMenu
 *  android.support.v7.widget.PopupMenu$OnMenuItemClickListener
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$ViewHolder
 *  android.text.SpannableString
 *  android.util.DisplayMetrics
 *  android.view.LayoutInflater
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnFocusChangeListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.Button
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageView
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.TextView
 *  android.widget.Toast
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Integer
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.List
 *  rx.schedulers.Schedulers
 */
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.activities.ContentEditActivity;
import com.becandid.candid.activities.FullScreenImageActivity;
import com.becandid.candid.activities.MessageActivity;
import com.becandid.candid.activities.PostDetailsActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Comment;
import com.becandid.candid.data.Config;
import com.becandid.candid.data.EmptyClass;
import com.becandid.candid.data.Post;
import com.becandid.candid.data.User;
import com.becandid.candid.views.viewholders.ImagePostViewHolder;
import com.becandid.candid.views.viewholders.LinkPostViewHolder;
import com.becandid.candid.views.viewholders.TextPostViewHolder;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import rx.schedulers.Schedulers;

public class he
extends hd<Comment> {
    private io d;
    private Post e;
    private Context f;
    private Handler g;
    private int h = 10;
    private int i = 16;
    private int j = 30;
    private int k;

    public he(List<Comment> list, Post post, Context context) {
        this.a = list;
        this.e = post;
        this.d = io.a();
        this.f = context;
        this.g = new Handler(context.getMainLooper());
        aps aps2 = ix.a().a(in.aq.class, new apr<in.aq>(){

            public void a(in.aq aq2) {
                he.this.a(aq2.a, aq2);
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((in.aq)object);
            }
        });
        ((BaseActivity)context).addToSubscriptionList(aps2);
        aps aps3 = ix.a().a(in.l.class, new apr<in.l>(){

            public void a(in.l l2) {
                he.this.c(l2.a);
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((in.l)object);
            }
        });
        ((BaseActivity)context).addToSubscriptionList(aps3);
        aps aps4 = ix.a().a(in.s.class, new apr<in.s>(){

            public void a(in.s s2) {
                he.this.c(s2.a);
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((in.s)object);
            }
        });
        ((BaseActivity)context).addToSubscriptionList(aps4);
        aps aps5 = ix.a().a(in.g.class, new apr<in.g>(){

            public void a(in.g g2) {
                he.this.a(g2.a, g2.b, g2.c);
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((in.g)object);
            }
        });
        ((BaseActivity)context).addToSubscriptionList(aps5);
        aps aps6 = ix.a().a(in.ai.class, new apr<in.ai>(){

            public void a(in.ai ai2) {
                jb.a(ai2.a, ai2.d, ai2.b);
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((in.ai)object);
            }
        });
        ((BaseActivity)context).addToSubscriptionList(aps6);
        aps aps7 = ix.a().a(in.h.class, new apr<in.h>(){

            public void a(in.h h2) {
                jb.b(h2.a, h2.b, h2.c);
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((in.h)object);
            }
        });
        ((BaseActivity)context).addToSubscriptionList(aps7);
        aps aps8 = ix.a().a(in.i.class, new apr<in.i>(){

            public void a(in.i i2) {
                jb.a(i2.a, i2.d, i2.b, i2.c);
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((in.i)object);
            }
        });
        ((BaseActivity)context).addToSubscriptionList(aps8);
    }

    private View.OnClickListener a(final Comment comment) {
        return new View.OnClickListener(){

            /*
             * Enabled aggressive block sorting
             */
            public void onClick(View view) {
                if (comment.messaging_blocked != null) {
                    new AlertDialog.Builder(he.this.f).setMessage((CharSequence)comment.messaging_blocked).setPositiveButton(2131230895, null).show();
                    return;
                }
                if (comment.messaging_disabled != null) {
                    new AlertDialog.Builder(he.this.f).setMessage((CharSequence)comment.messaging_disabled).setPositiveButton(2131230895, null).show();
                    return;
                }
                if (!AppState.hasMessagedFromAlert) {
                    new AlertDialog.Builder(he.this.f).setTitle((CharSequence)"Message User?").setMessage((CharSequence)"Would you like to send this user a message?").setNegativeButton((CharSequence)he.this.f.getResources().getString(2131230890), null).setPositiveButton((CharSequence)he.this.f.getResources().getString(2131230953), new DialogInterface.OnClickListener(){

                        /*
                         * Enabled aggressive block sorting
                         */
                        public void onClick(DialogInterface dialogInterface, int n2) {
                            Intent intent = new Intent(he.this.f, (Class)MessageActivity.class);
                            intent.putExtra("post_id", Integer.toString((int)he.b((he)he.this).post_id));
                            if (comment.user != null) {
                                intent.putExtra("user_name", comment.user.user_name);
                            } else {
                                intent.putExtra("user_name", comment.user_name);
                            }
                            intent.putExtra("comment_id", Integer.toString((int)comment.comment_id));
                            he.this.f.startActivity(intent);
                        }
                    }).create().show();
                    AppState.hasMessagedFromAlert = true;
                    AppState.saveState((ContextWrapper)GossipApplication.a());
                    return;
                }
                Intent intent = new Intent(he.this.f, (Class)MessageActivity.class);
                intent.putExtra("post_id", Integer.toString((int)he.b((he)he.this).post_id));
                if (comment.user != null) {
                    intent.putExtra("user_name", comment.user.user_name);
                } else {
                    intent.putExtra("user_name", comment.user_name);
                }
                intent.putExtra("comment_id", Integer.toString((int)comment.comment_id));
                he.this.f.startActivity(intent);
            }

        };
    }

    private void a(int n2, in.aq aq2) {
        int n3 = this.b(n2);
        if (n3 != -1) {
            Comment comment = (Comment)this.a.get(n3);
            comment.like_value = aq2.b;
            comment.num_likes = aq2.c;
            comment.num_dislikes = aq2.d;
            this.notifyItemChanged(n3 + 1);
        }
    }

    private void a(int n2, String string2, String string3) {
        int n3 = this.b(n2);
        if (n3 != -1) {
            Comment comment = (Comment)this.a.get(n3);
            comment.comment_text = string2;
            comment.mentioned_groups_info = string3;
            this.notifyItemChanged(n3 + 1);
        }
    }

    static /* synthetic */ Post b(he he2) {
        return he2.e;
    }

    private void c(int n2) {
        int n3 = this.b(n2);
        if (n3 != -1) {
            this.a.remove(n3);
            this.notifyItemRemoved(n3 + 1);
        }
    }

    public void a(List<Comment> list, Post post) {
        this.e = post;
        this.a.clear();
        this.a.addAll(list);
        this.notifyDataSetChanged();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public void a(jc var1, final int var2_2) {
        if (var1 == null) {
            return;
        }
        if (var2_2 == 0) {
            if (var1 instanceof TextPostViewHolder) {
                TextPostViewHolder.a((TextPostViewHolder)var1, this.e);
                return;
            }
            if (var1 instanceof ImagePostViewHolder) {
                ImagePostViewHolder.a((ImagePostViewHolder)var1, this.e);
                return;
            }
            if (var1 instanceof LinkPostViewHolder == false) return;
            LinkPostViewHolder.a((LinkPostViewHolder)var1, this.e);
            return;
        }
        var3_3 = (jd)var1;
        var4_4 = (Comment)this.a.get(var2_2 - 1);
        if (var4_4 == null) return;
        if (var4_4.is_master_comment) {
            var36_5 = (RelativeLayout.LayoutParams)var3_3.w.getLayoutParams();
            var36_5.setMargins(0, jb.a(this.h, this.f), 0, 0);
            var3_3.w.setLayoutParams((ViewGroup.LayoutParams)var36_5);
            this.i = 16;
            this.j = 30;
            this.k = 28;
        } else {
            var5_6 = (RelativeLayout.LayoutParams)var3_3.w.getLayoutParams();
            var5_6.setMargins(jb.a(35, this.f), 0, 0, 0);
            var3_3.w.setLayoutParams((ViewGroup.LayoutParams)var5_6);
            this.i = 15;
            this.j = 24;
            this.k = 25;
        }
        var6_7 = var4_4.user != null ? var4_4.user.user_name : (var4_4.user_name != null ? var4_4.user_name : "");
        var3_3.s = var4_4.comment_id;
        var3_3.t = var4_4.like_value;
        var3_3.a.setText((CharSequence)var6_7);
        var7_8 = Color.parseColor((String)var4_4.icon_color);
        var3_3.a.setTextColor(var7_8);
        var3_3.a.setTextSize((float)this.i);
        var8_9 = new jp();
        var9_10 = jb.a(10, this.f);
        var10_11 = jb.a(6, this.f);
        var8_9.setBounds(0, jb.a(1, this.f), var9_10, var10_11);
        var8_9.a(var7_8);
        var3_3.a.setCompoundDrawables(null, null, (Drawable)var8_9, null);
        if (var4_4.thats_me == 1) {
            var3_3.A.setVisibility(8);
        } else if (AppState.config.getBoolean("messaging_turned_on", true) && var4_4.thats_me != 1) {
            var3_3.A.setOnClickListener(super.a(var4_4));
        } else {
            var3_3.A.setOnClickListener(null);
        }
        var3_3.a.setOnClickListener(new View.OnClickListener(){

            /*
             * Enabled aggressive block sorting
             */
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){

                    /*
                     * Unable to fully structure code
                     * Enabled aggressive block sorting
                     * Lifted jumps to return sites
                     */
                    public boolean onMenuItemClick(MenuItem var1) {
                        switch (var1.getItemId()) {
                            case 2131624830: {
                                var12_2 = new Intent(he.a(15.this.he.this), (Class)ContentEditActivity.class);
                                var12_2.putExtra("comment_text", 15.this.var4_4.comment_text);
                                var12_2.putExtra("comment_id", 15.this.var4_4.comment_id);
                                if (15.this.var4_4.mentioned_groups_info != null) {
                                    var12_2.putExtra("group_tags", 15.this.var4_4.mentioned_groups_info);
                                }
                                ((PostDetailsActivity)he.a(15.this.he.this)).startActivityForResult(var12_2, 203);
                                ** break;
                            }
                            case 2131624831: {
                                jb.a(he.a(15.this.he.this), "Delete this comment?", "Once you delete this comment you can never see it again.", "Yes", "No", 16843605, false, new in.h(he.a(15.this.he.this), 15.this.var4_4.comment_id, 15.this.var4_4.post_id)).show();
                                ** break;
                            }
                            case 2131624833: {
                                var10_3 = jb.a(he.a(15.this.he.this), "Report This Comment?", null, "Report Comment", "Cancel", -1, true, new in.ai(he.a(15.this.he.this), 15.this.var4_4.comment_id)).create();
                                var10_3.setOnShowListener(new DialogInterface.OnShowListener(){

                                    public void onShow(DialogInterface dialogInterface) {
                                        ((AlertDialog)dialogInterface).getButton(-1).setEnabled(false);
                                    }
                                });
                                var10_3.show();
                                ** break;
                            }
                            case 2131624834: {
                                var9_4 = jb.a(he.a(15.this.he.this), "Delete this comment?", null, "Delete Comment", "Cancel", 16843605, true, new in.i(he.a(15.this.he.this), 15.this.var4_4.comment_id, 15.this.var4_4.post_id)).create();
                                var9_4.setOnShowListener(new DialogInterface.OnShowListener(){

                                    public void onShow(DialogInterface dialogInterface) {
                                        ((AlertDialog)dialogInterface).getButton(-1).setEnabled(false);
                                    }
                                });
                                var9_4.show();
                            }
lbl22: // 5 sources:
                            default: {
                                return true;
                            }
                            case 2131624832: 
                        }
                        if (15.this.var4_4.messaging_blocked != null) {
                            new AlertDialog.Builder(he.a(15.this.he.this)).setMessage((CharSequence)15.this.var4_4.messaging_blocked).setPositiveButton(2131230895, null).show();
                            return true;
                        }
                        if (15.this.var4_4.messaging_disabled != null) {
                            new AlertDialog.Builder(he.a(15.this.he.this)).setMessage((CharSequence)15.this.var4_4.messaging_disabled).setPositiveButton(2131230895, null).show();
                            return true;
                        }
                        var2_5 = new Intent(he.a(15.this.he.this), (Class)MessageActivity.class);
                        var2_5.putExtra("post_id", Integer.toString((int)he.b((he)15.this.he.this).post_id));
                        if (15.this.var4_4.user != null) {
                            var2_5.putExtra("user_name", 15.this.var4_4.user.user_name);
                        } else {
                            var2_5.putExtra("user_name", 15.this.var4_4.user_name);
                        }
                        var2_5.putExtra("comment_id", Integer.toString((int)15.this.var4_4.comment_id));
                        he.a(15.this.he.this).startActivity(var2_5);
                        return true;
                    }

                });
                if (var4_4.thats_me == 1) {
                    if (!var4_4.comment_text.equals((Object)"")) {
                        popupMenu.getMenu().add(1, 2131624830, 0, 2131230833);
                    }
                    popupMenu.getMenu().add(1, 2131624831, 0, 2131230826);
                } else if (he.b((he)he.this).group_id != 0 && AppState.isGroupModerator(he.b((he)he.this).group_id)) {
                    popupMenu.getMenu().add(1, 2131624834, 0, 2131230826);
                } else {
                    if (AppState.config.getBoolean("messaging_turned_on", true) && var4_4.thats_me != 1) {
                        popupMenu.getMenu().add(1, 2131624832, 0, 2131230877);
                    }
                    if (he.b((he)he.this).group_id != 0 && AppState.isGroupModerator(he.b((he)he.this).group_id)) {
                        popupMenu.getMenu().add(1, 2131624834, 0, 2131230826);
                    } else {
                        popupMenu.getMenu().add(1, 2131624833, 0, 2131230912);
                    }
                }
                popupMenu.show();
            }

        });
        if (var4_4.is_candid_mod == 1) {
            var3_3.c.setVisibility(0);
            var35_12 = (RelativeLayout.LayoutParams)var3_3.c.getLayoutParams();
            var35_12.width = jb.a(this.j, this.f);
            var35_12.height = jb.a(this.j, this.f);
            var3_3.c.setLayoutParams((ViewGroup.LayoutParams)var35_12);
            var3_3.c.setOnClickListener(new View.OnClickListener(){

                /*
                 * Enabled aggressive block sorting
                 */
                public void onClick(View view) {
                    if (var4_4.messaging_blocked != null) {
                        new AlertDialog.Builder(he.this.f).setMessage((CharSequence)var4_4.messaging_blocked).setPositiveButton(2131230895, null).show();
                        return;
                    }
                    if (var4_4.messaging_disabled != null) {
                        new AlertDialog.Builder(he.this.f).setMessage((CharSequence)var4_4.messaging_disabled).setPositiveButton(2131230895, null).show();
                        return;
                    }
                    if (!AppState.hasMessagedFromAlert) {
                        new AlertDialog.Builder(he.this.f).setTitle((CharSequence)"Message User?").setMessage((CharSequence)"Would you like to send this user a message?").setNegativeButton((CharSequence)he.this.f.getResources().getString(2131230890), null).setPositiveButton((CharSequence)he.this.f.getResources().getString(2131230953), new DialogInterface.OnClickListener(){

                            /*
                             * Enabled aggressive block sorting
                             */
                            public void onClick(DialogInterface dialogInterface, int n2) {
                                Intent intent = new Intent(he.this.f, (Class)MessageActivity.class);
                                intent.putExtra("post_id", Integer.toString((int)he.b((he)he.this).post_id));
                                if (var4_4.user != null) {
                                    intent.putExtra("user_name", var4_4.user.user_name);
                                } else {
                                    intent.putExtra("user_name", var4_4.user_name);
                                }
                                intent.putExtra("comment_id", Integer.toString((int)var4_4.comment_id));
                                he.this.f.startActivity(intent);
                            }
                        }).create().show();
                        AppState.hasMessagedFromAlert = true;
                        AppState.saveState((ContextWrapper)GossipApplication.a());
                        return;
                    }
                    Intent intent = new Intent(he.this.f, (Class)MessageActivity.class);
                    intent.putExtra("post_id", Integer.toString((int)he.b((he)he.this).post_id));
                    if (var4_4.user != null) {
                        intent.putExtra("user_name", var4_4.user.user_name);
                    } else {
                        intent.putExtra("user_name", var4_4.user_name);
                    }
                    intent.putExtra("comment_id", Integer.toString((int)var4_4.comment_id));
                    he.this.f.startActivity(intent);
                }

            });
            var3_3.b.setVisibility(8);
        } else {
            var3_3.b.setVisibility(0);
            var3_3.b.setTextColor(var7_8);
            var11_13 = var3_3.b;
            var11_13.setTypeface(io.b());
            var3_3.b.setText((CharSequence)io.a(var4_4.icon_name));
            var13_14 = (RelativeLayout.LayoutParams)var3_3.b.getLayoutParams();
            var13_14.width = jb.a(this.j, this.f);
            var13_14.height = jb.a(this.j, this.f);
            var3_3.b.setLayoutParams((ViewGroup.LayoutParams)var13_14);
            var3_3.b.setTextSize((float)this.j);
            var14_16 = var3_3.b.getWidth();
            if (var14_16 == 0) {
                var14_16 = (int)(var3_3.b.getResources().getDisplayMetrics().density * (float)this.j);
            }
            var15_15 = 1073741824 | 16777215 & var7_8;
            var3_3.d.setColor(var15_15);
            var3_3.d.setCornerRadius((float)(var14_16 / 2));
            var3_3.b.setBackground((Drawable)var3_3.d);
            if (AppState.config.getBoolean("messaging_turned_on", true) && var4_4.thats_me != 1) {
                var3_3.b.setOnClickListener(super.a(var4_4));
            } else {
                var3_3.b.setOnClickListener(null);
            }
            var3_3.c.setVisibility(8);
        }
        if (var4_4.is_op == 1 || var4_4.is_friend == 1 || var4_4.thats_me == 1 || var4_4.is_candid_mod == 1) {
            var3_3.g.setVisibility(0);
            var3_3.g.setTextColor(Color.parseColor((String)var4_4.icon_color));
            var3_3.g.setBackground(null);
            if (var4_4.is_candid_mod == 1) {
                var3_3.g.setText((CharSequence)"MOD");
                var3_3.g.setTextColor(this.f.getResources().getColor(2131558476));
            } else if (var4_4.thats_me == 1) {
                var3_3.g.setText((CharSequence)"YOU");
                var3_3.g.setTextColor(this.f.getResources().getColor(17170443));
                var3_3.g.setBackground(this.f.getResources().getDrawable(2130838158));
            } else if (var4_4.is_op == 1) {
                var3_3.g.setText((CharSequence)"OP");
            } else if (var4_4.is_friend == 1) {
                var3_3.g.setText((CharSequence)"FRIEND");
            }
        } else {
            var3_3.g.setVisibility(8);
        }
        var3_3.h.setOnFocusChangeListener(null);
        if (PostDetailsActivity.clipped != null && !PostDetailsActivity.clipped.contains((Object)var4_4.comment_id)) {
            var16_17 = jb.a(var4_4.comment_text, 2131558478);
            if (var16_17.toString().endsWith("See More")) {
                var3_3.h.setOnFocusChangeListener(new View.OnFocusChangeListener(){

                    public void onFocusChange(View view, boolean bl2) {
                        if (bl2) {
                            new Handler().post(new Runnable(){

                                public void run() {
                                    var3_3.h.setOnFocusChangeListener(null);
                                    PostDetailsActivity.clipped.add((Object)var4_4.comment_id);
                                    he.this.notifyItemChanged(var2_2);
                                }
                            });
                        }
                    }

                });
            } else {
                PostDetailsActivity.clipped.add((Object)var4_4.comment_id);
            }
        } else {
            var16_17 = new SpannableString((CharSequence)var4_4.comment_text);
        }
        if (var4_4.sticker_name != null) {
            var33_18 = GossipApplication.a.getResources().getIdentifier(var4_4.sticker_name.toLowerCase(), "drawable", GossipApplication.a.getPackageName());
            var3_3.i.setImageDrawable(GossipApplication.a.getResources().getDrawable(var33_18));
            var3_3.i.setVisibility(0);
        } else {
            var3_3.i.setVisibility(8);
        }
        if (!var4_4.comment_text.equals((Object)"")) ** GOTO lbl120
        var3_3.h.setVisibility(8);
        ** GOTO lbl124
lbl120: // 1 sources:
        if (AppState.config.getInt("disable_group_tagging", 0) != 0 || var4_4.mentioned_groups_info == null) ** GOTO lbl188
        var25_24 = var4_4.mentioned_groups_info.split(";");
        var26_25 = var25_24.length;
        ** GOTO lbl178
lbl124: // 2 sources:
        do {
            if (var4_4.source_url != null) {
                var3_3.j.setVisibility(0);
                var17_19 = this.f.getResources().getDisplayMetrics().density;
                if (var4_4.image_width > 250 || var4_4.image_height > 250) {
                    var18_20 = (int)(0.05f + 250.0f * var17_19);
                    var19_21 = (int)(0.05f + 250.0f * var17_19);
                    var20_22 = new FrameLayout.LayoutParams(var18_20, var19_21);
                } else {
                    var23_32 = (int)(0.05f + var17_19 * (float)var4_4.image_width);
                    var24_33 = (int)(0.05f + var17_19 * (float)var4_4.image_height);
                    var20_22 = new FrameLayout.LayoutParams(var23_32, var24_33);
                }
                var21_23 = var20_22.width;
                var3_3.j.setLayoutParams((ViewGroup.LayoutParams)var20_22);
                if (AppState.config.getInt("android_enable_image_progress") == 1) {
                    is.a(var3_3.z, var3_3.y, this.f, var21_23, 80, var4_4.source_url, var3_3.j, null, 0, false);
                } else {
                    var3_3.j.setBackgroundResource(17301613);
                    GossipApplication.c.a(var4_4.source_url).a(new qf<String, oh>(){

                        public boolean a(Exception exception, String string2, qy<oh> qy2, boolean bl2) {
                            return false;
                        }

                        public boolean a(oh oh2, String string2, qy<oh> qy2, boolean bl2, boolean bl3) {
                            var3_3.j.setBackground(null);
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
                    }).a(var3_3.j);
                }
                var3_3.j.setOnClickListener(new View.OnClickListener(){

                    /*
                     * Enabled aggressive block sorting
                     * Enabled unnecessary exception pruning
                     * Enabled aggressive exception aggregation
                     */
                    public void onClick(View view) {
                        try {
                            Intent intent = new Intent(he.this.f, (Class)FullScreenImageActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putInt("comment_id", var4_4.comment_id);
                            bundle.putString("source_url", var4_4.source_url);
                            bundle.putInt("num_likes", var4_4.num_likes);
                            bundle.putInt("num_dislikes", var4_4.num_dislikes);
                            bundle.putString("icon_name", var4_4.icon_name);
                            bundle.putString("icon_color", var4_4.icon_color);
                            if (var4_4.user != null) {
                                bundle.putString("user_name", var4_4.user.user_name);
                            } else {
                                bundle.putString("user_name", var4_4.user_name);
                            }
                            bundle.putInt("like_value", var4_4.like_value);
                            bundle.putBoolean("fromDetails", true);
                            bundle.putInt("thats_me", var4_4.thats_me);
                            intent.putExtras(bundle);
                            ((Activity)he.this.f).startActivityForResult(intent, 198);
                            return;
                        }
                        catch (NullPointerException var4_42) {
                            Toast.makeText((Context)he.this.f, (CharSequence)"This image is currently unavailable, please try again later", (int)1).show();
                            rj.a((Throwable)var4_42);
                            return;
                        }
                    }
                });
            } else {
                var3_3.j.setVisibility(8);
                var3_3.y.setVisibility(8);
            }
            var3_3.k.setText((CharSequence)var4_4.comment_time_ago);
            if (var4_4.like_value == -1) {
                var3_3.o.setSelected(true);
                var3_3.l.setSelected(false);
            } else if (var4_4.like_value == 1) {
                var3_3.l.setSelected(true);
                var3_3.o.setSelected(false);
            } else {
                var3_3.l.setSelected(false);
                var3_3.o.setSelected(false);
            }
            var3_3.n.setText((CharSequence)Integer.toString((int)var4_4.num_likes));
            var3_3.q.setText((CharSequence)Integer.toString((int)var4_4.num_dislikes));
            var3_3.m.setOnClickListener(new View.OnClickListener(){

                /*
                 * Enabled aggressive block sorting
                 */
                public void onClick(View view) {
                    int n2;
                    in.aq aq2;
                    if (var3_3.l.isSelected()) {
                        n2 = 0;
                        aq2 = new in.aq(var4_4.comment_id, 0, -1 + var4_4.num_likes, var4_4.num_dislikes);
                    } else {
                        n2 = 1;
                        aq2 = var3_3.o.isSelected() ? new in.aq(var4_4.comment_id, n2, 1 + var4_4.num_likes, -1 + var4_4.num_dislikes) : new in.aq(var4_4.comment_id, n2, 1 + var4_4.num_likes, var4_4.num_dislikes);
                    }
                    ix.a().a(aq2);
                    ik.a().a(var4_4.comment_id, n2).b(Schedulers.io()).a(apv.a()).b(new apr<EmptyClass>(){

                        public void a(EmptyClass emptyClass) {
                        }

                        @Override
                        public void onCompleted() {
                        }

                        @Override
                        public void onError(Throwable throwable) {
                            rj.a(throwable);
                        }

                        @Override
                        public /* synthetic */ void onNext(Object object) {
                            this.a((EmptyClass)object);
                        }
                    });
                }

            });
            var3_3.p.setOnClickListener(new View.OnClickListener(){

                /*
                 * Enabled aggressive block sorting
                 */
                public void onClick(View view) {
                    int n2;
                    in.aq aq2;
                    if (var3_3.o.isSelected()) {
                        n2 = 0;
                        aq2 = new in.aq(var4_4.comment_id, 0, var4_4.num_likes, -1 + var4_4.num_dislikes);
                    } else {
                        n2 = -1;
                        aq2 = var3_3.l.isSelected() ? new in.aq(var4_4.comment_id, n2, -1 + var4_4.num_likes, 1 + var4_4.num_dislikes) : new in.aq(var4_4.comment_id, n2, var4_4.num_likes, 1 + var4_4.num_dislikes);
                    }
                    ix.a().a(aq2);
                    ik.a().a(var4_4.comment_id, n2).b(Schedulers.io()).a(apv.a()).b(new apr<EmptyClass>(){

                        public void a(EmptyClass emptyClass) {
                        }

                        @Override
                        public void onCompleted() {
                        }

                        @Override
                        public void onError(Throwable throwable) {
                            rj.a(throwable);
                        }

                        @Override
                        public /* synthetic */ void onNext(Object object) {
                            this.a((EmptyClass)object);
                        }
                    });
                }

            });
            if (var4_4.like_value == 1) {
                var3_3.l.setSelected(true);
                var3_3.o.setSelected(false);
            } else if (var4_4.like_value == -1) {
                var3_3.l.setSelected(false);
                var3_3.o.setSelected(true);
            } else {
                var3_3.l.setSelected(false);
                var3_3.o.setSelected(false);
            }
            if (var4_4.thats_me == 1) {
                var3_3.r.setVisibility(8);
            } else {
                var3_3.r.setVisibility(0);
            }
            var3_3.r.setOnClickListener(new View.OnClickListener(){

                public void onClick(View view) {
                    ((PostDetailsActivity)he.this.f).replyTo(var6_7, Integer.toString((int)var4_4.comment_id), var2_2);
                    new Handler().postDelayed(new Runnable(){

                        public void run() {
                            ((PostDetailsActivity)he.this.f).scrollToComment(var4_4.comment_id);
                        }
                    }, 500);
                }

            });
            return;
            break;
        } while (true);
lbl178: // 2 sources:
        for (var27_26 = 0; var27_26 < var26_25 && (var28_27 = var25_24[var27_26].split(",")).length == 3; ++var27_26) {
            var29_28 = Integer.parseInt((String)var28_27[0]);
            var30_29 = Integer.parseInt((String)var28_27[1]);
            var31_30 = Integer.parseInt((String)var28_27[2]);
            if (var16_17.toString().endsWith("See More") && var31_30 >= var16_17.length() || var30_29 >= var16_17.length() || var31_30 > var16_17.length() || var30_29 < 0 || var31_30 <= 0) break;
            try {
                var16_17.setSpan((Object)jb.b("#000000", var29_28, this.f), var30_29, var31_30, 33);
                continue;
            }
            catch (IndexOutOfBoundsException var32_31) {}
            break;
        }
lbl188: // 4 sources:
        var3_3.h.setText((CharSequence)var16_17);
        var3_3.h.setVisibility(0);
        var3_3.h.setTextSize((float)this.i);
        ** while (true)
    }

    public int b(int n2) {
        for (int i2 = 0; i2 < this.a.size(); ++i2) {
            if (((Comment)this.a.get((int)i2)).comment_id != n2) continue;
            return i2;
        }
        return -1;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public jc b(ViewGroup viewGroup, int n2) {
        if (n2 == 2) {
            return new ImagePostViewHolder(LayoutInflater.from((Context)viewGroup.getContext()).inflate(2130968665, viewGroup, false), (Activity)this.f);
        }
        if (n2 == 3) {
            return new LinkPostViewHolder(LayoutInflater.from((Context)viewGroup.getContext()).inflate(2130968666, viewGroup, false), (Activity)this.f);
        }
        if (n2 == 1) {
            return new TextPostViewHolder(LayoutInflater.from((Context)viewGroup.getContext()).inflate(2130968667, viewGroup, false), (Activity)this.f);
        }
        ImagePostViewHolder imagePostViewHolder = null;
        if (n2 != 6) return imagePostViewHolder;
        return new jd(LayoutInflater.from((Context)viewGroup.getContext()).inflate(2130968644, viewGroup, false));
    }

    public void c(List<Comment> list) {
        int n2 = this.a.size();
        this.a.addAll(list);
        this.notifyItemRangeChanged(n2 + 1, 20);
    }

    @Override
    public int getItemCount() {
        return 1 + this.a.size();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public int getItemViewType(int var1) {
        if (var1 != 0) return 6;
        if (this.e == null) {
            return 6;
        }
        var2_2 = this.e.type;
        var3_3 = -1;
        switch (var2_2.hashCode()) {
            case 100313435: {
                if (var2_2.equals((Object)"image")) {
                    var3_3 = 0;
                    ** break;
                }
                ** GOTO lbl15
            }
            case 3321850: {
                if (var2_2.equals((Object)"link")) {
                    var3_3 = 1;
                }
            }
lbl15: // 6 sources:
            default: {
                ** GOTO lbl20
            }
            case 112202875: 
        }
        if (var2_2.equals((Object)"video")) {
            var3_3 = 2;
        }
lbl20: // 4 sources:
        switch (var3_3) {
            default: {
                return 1;
            }
            case 0: {
                return 2;
            }
            case 1: 
            case 2: 
        }
        return 3;
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

