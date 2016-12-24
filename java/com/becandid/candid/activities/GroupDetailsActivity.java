/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.net.Uri
 *  android.os.Bundle
 *  android.support.v4.widget.SwipeRefreshLayout
 *  android.support.v4.widget.SwipeRefreshLayout$OnRefreshListener
 *  android.support.v7.app.AlertDialog
 *  android.support.v7.app.AlertDialog$Builder
 *  android.support.v7.widget.LinearLayoutManager
 *  android.support.v7.widget.PopupMenu
 *  android.support.v7.widget.PopupMenu$OnMenuItemClickListener
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$Adapter
 *  android.support.v7.widget.RecyclerView$ItemAnimator
 *  android.support.v7.widget.RecyclerView$LayoutManager
 *  android.support.v7.widget.SimpleItemAnimator
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.view.MenuItem
 *  android.view.View
 *  android.widget.LinearLayout
 *  android.widget.ListView
 *  android.widget.TextView
 *  android.widget.Toast
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.List
 *  rx.schedulers.Schedulers
 */
package com.becandid.candid.activities;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.activities.CreateGroupActivity;
import com.becandid.candid.activities.CreatePostActivity;
import com.becandid.candid.activities.InviteContactsActivity;
import com.becandid.candid.activities.PopupWithBlurBackgroundActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.DataUtil;
import com.becandid.candid.data.Group;
import com.becandid.candid.data.Post;
import com.becandid.candid.models.NetworkData;
import com.becandid.candid.util.RoundedCornersTransformation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import rx.schedulers.Schedulers;

public class GroupDetailsActivity
extends PopupWithBlurBackgroundActivity
implements PopupMenu.OnMenuItemClickListener,
hf.a {
    public static final int CREATE_POST_REQUEST = 888;
    private int b;
    private Group c;
    private RoundedCornersTransformation d;
    private hf e;
    @BindView(value=2131624175)
    TextView gdCompose;
    @BindView(value=2131624173)
    TextView gdHeaderName;
    @BindView(value=2131624176)
    TextView gdJoin;
    @BindView(value=2131624172)
    TextView groupEmpty;
    @BindView(value=2131624171)
    RecyclerView groupPosts;
    @BindView(value=2131624177)
    LinearLayout loadingSpinny;
    @BindView(value=2131624169)
    SwipeRefreshLayout mSwipeContainer;

    private aps a() {
        return ik.a().a(this.b, null).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

            @Override
            public void onCompleted() {
                GroupDetailsActivity.this.mSwipeContainer.setRefreshing(false);
            }

            @Override
            public void onError(Throwable throwable) {
                GroupDetailsActivity.this.loadingSpinny.setVisibility(8);
                GroupDetailsActivity.this.groupPosts.setVisibility(0);
                rj.a(throwable);
                GroupDetailsActivity.this.mSwipeContainer.setRefreshing(false);
                ix.a().a(new in.ac());
            }

            @Override
            public void onNext(NetworkData networkData) {
                if (GroupDetailsActivity.this.isStopped) {
                    return;
                }
                if (networkData != null) {
                    GroupDetailsActivity.this.c = networkData.group;
                    GroupDetailsActivity.this.gdHeaderName.setText((CharSequence)GroupDetailsActivity.a((GroupDetailsActivity)GroupDetailsActivity.this).group_name);
                    if (networkData.posts != null) {
                        List<Post> list = networkData.posts;
                        GroupDetailsActivity.this.a(list);
                        GroupDetailsActivity.this.e.b(GroupDetailsActivity.this.c.convertToPost());
                        if (!list.isEmpty()) {
                            GroupDetailsActivity.this.e.a(Integer.toString((int)((Post)list.get((int)(-1 + list.size()))).post_id));
                        }
                    }
                }
                GroupDetailsActivity.this.loadingSpinny.setVisibility(8);
                GroupDetailsActivity.this.groupPosts.setVisibility(0);
            }
        });
    }

    private void a(List<Post> list) {
        this.e.a(list);
        if (list.size() > 0) {
            this.groupEmpty.setVisibility(8);
            return;
        }
        this.groupEmpty.setVisibility(0);
    }

    public static Intent startGroupDetailsActivity(Context context, int n2) {
        Intent intent = new Intent(context, (Class)GroupDetailsActivity.class);
        intent.putExtra("group_id", n2);
        return intent;
    }

    public void createPostClick(View view) {
        if (this.c != null) {
            Intent intent = new Intent((Context)this, (Class)CreatePostActivity.class);
            intent.putExtra("group_id", this.c.group_id);
            intent.putExtra("group_name", this.c.group_name);
            this.startActivityForResult(intent, 888);
        }
    }

    @Override
    protected void getRxSubscription() {
        this.mSubscription = this.a();
        this.addToSubscriptionList(this.mSubscription);
    }

    @Override
    public void hideCurrentScreen() {
        this.findViewById(2131624168).setVisibility(8);
    }

    public void joinGroupClick(View view) {
        if (this.c != null) {
            ik.a().b(this.c.group_id).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

                @Override
                public void onCompleted() {
                }

                @Override
                public void onError(Throwable throwable) {
                    rj.a(throwable);
                    Toast.makeText((Context)GroupDetailsActivity.this, (CharSequence)"Unable to join this group", (int)0).show();
                }

                @Override
                public void onNext(NetworkData networkData) {
                    Toast.makeText((Context)GroupDetailsActivity.this, (CharSequence)"You have joined this group", (int)0).show();
                    GroupDetailsActivity.this.gdCompose.setVisibility(0);
                    GroupDetailsActivity.this.e.notifyItemChanged(0);
                }
            });
        }
    }

    public void leaveGroupClick(View view) {
        if (this.c != null) {
            ik.a().c(this.c.group_id).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

                @Override
                public void onCompleted() {
                    GroupDetailsActivity.this.finish();
                }

                @Override
                public void onError(Throwable throwable) {
                    rj.a(throwable);
                    Log.d((String)"GroupDetailsActivity", (String)throwable.toString());
                }

                /*
                 * Unable to fully structure code
                 * Enabled aggressive block sorting
                 * Lifted jumps to return sites
                 */
                @Override
                public void onNext(NetworkData var1) {
                    var2_2 = 0;
                    do {
                        if (var2_2 >= AppState.groups.size()) ** GOTO lbl6
                        if (((Group)AppState.groups.get((int)var2_2)).group_id == GroupDetailsActivity.a((GroupDetailsActivity)GroupDetailsActivity.this).group_id) {
                            AppState.groups.remove(var2_2);
lbl6: // 2 sources:
                            ix.a().a(new in.o(GroupDetailsActivity.a((GroupDetailsActivity)GroupDetailsActivity.this).group_id));
                            GroupDetailsActivity.this.gdCompose.setVisibility(8);
                            Toast.makeText((Context)GroupDetailsActivity.this, (CharSequence)"You have left this group", (int)0).show();
                            return;
                        }
                        ++var2_2;
                    } while (true);
                }
            });
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void onActivityResult(int n2, int n3, Intent intent) {
        if (n2 == 888) {
            if (n3 == -1) return;
            {
                Log.e((String)"GroupDetails", (String)"Error on activity result");
                return;
            }
        }
        if (n2 != 929 || n3 != -1 || intent == null) {
            return;
        }
        this.upsellChange(intent.getIntExtra("upsellId", -1));
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130968611);
        ButterKnife.bind((Activity)this);
        this.groupPosts.setVisibility(8);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager((Context)this);
        this.groupPosts.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
        this.e = new hf((BaseActivity)this, null);
        this.e.a((hf.a)this);
        this.groupPosts.setAdapter((RecyclerView.Adapter)this.e);
        this.loadingSpinny.setVisibility(0);
        this.groupPosts.setNestedScrollingEnabled(false);
        RecyclerView.ItemAnimator itemAnimator = this.groupPosts.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator)itemAnimator).setSupportsChangeAnimations(false);
        }
        this.d = new RoundedCornersTransformation((Context)this, (int)(40.0f * this.getResources().getDisplayMetrics().density), 0, RoundedCornersTransformation.CornerType.a);
        this.b = this.getIntent().getIntExtra("group_id", 0);
        String string2 = DataUtil.getEncodedId(this.getIntent().getData());
        if (string2 != null) {
            this.b = (int)DataUtil.decodeId(string2);
        }
        if (AppState.isGroupMember(this.b)) {
            this.gdCompose.setVisibility(0);
        } else {
            this.gdCompose.setVisibility(8);
        }
        if (this.getIntent().hasExtra("group_name")) {
            this.gdHeaderName.setText((CharSequence)this.getIntent().getStringExtra("group_name"));
        }
        if (this.getIntent().hasExtra("group_image")) {
            // empty if block
        }
        if (this.getIntent().hasExtra("group_json")) {
            this.c = (Group)DataUtil.gson.a(this.getIntent().getStringExtra("group_json"), Group.class);
            if (this.c.group_name != null) {
                this.gdHeaderName.setText((CharSequence)this.c.group_name);
            }
        }
        this.getRxSubscription();
        this.mSwipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){

            public void onRefresh() {
                GroupDetailsActivity.this.getRxSubscription();
            }
        });
        this.busSubscribe(in.k.class, new apr<in.k>(){

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
            }

            @Override
            public void onNext(in.k k2) {
                if (k2.a.group_id == GroupDetailsActivity.this.b) {
                    GroupDetailsActivity.this.e.a(k2.a, 1);
                    GroupDetailsActivity.this.groupPosts.smoothScrollToPosition(1);
                    GroupDetailsActivity.this.groupEmpty.setVisibility(8);
                    Group group = GroupDetailsActivity.this.c;
                    group.num_posts = 1 + group.num_posts;
                    GroupDetailsActivity.this.getRxSubscription();
                }
            }
        });
        this.busSubscribe(in.t.class, new apr<in.t>(){

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
            }

            @Override
            public void onNext(in.t t2) {
                if (t2.a.group_id == GroupDetailsActivity.this.b) {
                    GroupDetailsActivity.this.c = t2.a;
                    Post post = GroupDetailsActivity.this.c.convertToPost();
                    GroupDetailsActivity.this.e.b(post, 0);
                    GroupDetailsActivity.this.getRxSubscription();
                }
            }
        });
        this.busSubscribe(in.r.class, new apr<in.r>(){

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
            }

            @Override
            public void onNext(in.r r2) {
                GroupDetailsActivity.this.e.b(r2.a);
            }
        });
    }

    @Override
    public void onErrorRetry(String string2) {
        this.onLoadMore(string2);
    }

    @Override
    public void onLoadMore(String string2) {
        if (string2 != null && Integer.valueOf((String)string2) > 0) {
            ik.a().a(this.b, string2).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

                @Override
                public void onCompleted() {
                }

                @Override
                public void onError(Throwable throwable) {
                    rj.a(throwable);
                    jb.a(GroupDetailsActivity.this.groupPosts, GroupDetailsActivity.this.e);
                }

                /*
                 * Enabled aggressive block sorting
                 */
                @Override
                public void onNext(NetworkData networkData) {
                    if (networkData.posts == null || networkData.posts.isEmpty()) {
                        GroupDetailsActivity.this.e.a((String)null);
                        return;
                    } else {
                        List<Post> list = networkData.posts;
                        GroupDetailsActivity.this.e.b(list);
                        if (list.isEmpty()) return;
                        {
                            GroupDetailsActivity.this.e.a(Integer.toString((int)((Post)list.get((int)(-1 + list.size()))).post_id));
                            return;
                        }
                    }
                }
            });
        }
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        Log.d((String)"GDA", (String)"groupMenu");
        switch (menuItem.getItemId()) {
            default: {
                return true;
            }
            case 2131624838: {
                this.leaveGroupClick(null);
                return true;
            }
            case 2131624840: {
                new AlertDialog.Builder((Context)this).setIconAttribute(16843605).setTitle((CharSequence)"Delete this group?").setMessage((CharSequence)"Are you sure you want to permanently delete this group?").setPositiveButton((CharSequence)"Yes", new DialogInterface.OnClickListener(){

                    public void onClick(DialogInterface dialogInterface, int n2) {
                        new HashMap().put((Object)"group_id", (Object)Integer.toString((int)GroupDetailsActivity.a((GroupDetailsActivity)GroupDetailsActivity.this).group_id));
                        ik.a().f(GroupDetailsActivity.this.b).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

                            @Override
                            public void onCompleted() {
                            }

                            @Override
                            public void onError(Throwable throwable) {
                                rj.a(throwable);
                                Log.d((String)"DeleteGroup", (String)throwable.toString());
                            }

                            @Override
                            public void onNext(NetworkData networkData) {
                                ix.a().a(new in.o(GroupDetailsActivity.a((GroupDetailsActivity)GroupDetailsActivity.this).group_id));
                                GroupDetailsActivity.this.finish();
                            }
                        });
                    }

                }).setNegativeButton((CharSequence)"No", null).show();
                return true;
            }
            case 2131624842: {
                Intent intent = new Intent((Context)this, (Class)CreateGroupActivity.class);
                Bundle bundle = new Bundle();
                bundle.putBoolean("edit_group", true);
                bundle.putInt("group_id", this.c.group_id);
                bundle.putString("group_name", this.c.group_name);
                bundle.putString("group_info", this.c.about);
                bundle.putString("source_url", this.c.source_url);
                bundle.putStringArrayList("tags", (ArrayList)this.c.tags);
                intent.putExtras(bundle);
                this.startActivity(intent);
                return true;
            }
            case 2131624841: {
                CharSequence[] arrcharSequence = new CharSequence[]{"Pornographic", "Solicitation and Spam", "Hate Speech"};
                new AlertDialog.Builder((Context)this).setTitle((CharSequence)"Why Are You Reporting This Group?").setSingleChoiceItems(arrcharSequence, 0, null).setPositiveButton((CharSequence)"Report Group", new DialogInterface.OnClickListener(){

                    /*
                     * Enabled aggressive block sorting
                     */
                    public void onClick(DialogInterface dialogInterface, int n2) {
                        String string2;
                        switch (((AlertDialog)dialogInterface).getListView().getCheckedItemPosition()) {
                            default: {
                                string2 = "";
                                break;
                            }
                            case 0: {
                                string2 = "nsfw";
                                break;
                            }
                            case 1: {
                                string2 = "spam";
                                break;
                            }
                            case 2: {
                                string2 = "hate";
                            }
                        }
                        ik.a().b(GroupDetailsActivity.this.b, string2).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

                            @Override
                            public void onCompleted() {
                            }

                            @Override
                            public void onError(Throwable throwable) {
                                rj.a(throwable);
                                Log.d((String)"ReportGroup", (String)throwable.toString());
                            }

                            @Override
                            public void onNext(NetworkData networkData) {
                                new AlertDialog.Builder((Context)GroupDetailsActivity.this).setTitle((CharSequence)"Group Reported").setMessage((CharSequence)"This group has been reported.").setPositiveButton((CharSequence)"OK", null).create().show();
                            }
                        });
                    }

                }).setNegativeButton((CharSequence)"Cancel", null).create().show();
                return true;
            }
            case 2131624839: 
        }
        this.joinGroupClick(null);
        return true;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.loadingSpinny.setVisibility(0);
        this.groupPosts.setVisibility(8);
        this.b = intent.getIntExtra("group_id", 0);
        super.a();
    }

    @Override
    public void showContactsDialog(int n2, int n3) {
        Intent intent = new Intent((Context)this, (Class)InviteContactsActivity.class);
        intent.putExtra("invite_type", InviteContactsActivity.InviteFlowTypes.GROUP.toString());
        intent.putExtra("upsell_id", String.valueOf((int)n2) + "," + String.valueOf((int)n3));
        intent.putExtra("groupId", n3);
        intent.putExtra("upsellId", n2);
        this.startActivityForResult(intent, 929);
    }

    @Override
    public void showCurrentScreen() {
        this.findViewById(2131624168).setVisibility(0);
    }

    @Override
    public void upsellChange(int n2) {
        this.e.b(n2);
    }

}

