/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.support.v4.widget.SwipeRefreshLayout
 *  android.support.v4.widget.SwipeRefreshLayout$OnRefreshListener
 *  android.support.v7.app.AlertDialog
 *  android.support.v7.app.AlertDialog$Builder
 *  android.support.v7.widget.LinearLayoutManager
 *  android.support.v7.widget.ListPopupWindow
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$Adapter
 *  android.support.v7.widget.RecyclerView$ItemAnimator
 *  android.support.v7.widget.RecyclerView$LayoutManager
 *  android.support.v7.widget.RecyclerView$OnScrollListener
 *  android.text.Editable
 *  android.text.SpannableStringBuilder
 *  android.text.TextWatcher
 *  android.util.DisplayMetrics
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnFocusChangeListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.EditText
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.ListAdapter
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.TextView
 *  android.widget.Toast
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.NullPointerException
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  rx.schedulers.Schedulers
 */
package com.becandid.candid.activities;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.MainTabsActivity;
import com.becandid.candid.activities.PopupWithBlurBackgroundActivity;
import com.becandid.candid.activities.RelatedPostsFeedActivity;
import com.becandid.candid.activities.TutorialMuteActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Comment;
import com.becandid.candid.data.Config;
import com.becandid.candid.data.DataUtil;
import com.becandid.candid.data.EmptyClass;
import com.becandid.candid.data.Group;
import com.becandid.candid.data.Post;
import com.becandid.candid.data.TextTag;
import com.becandid.candid.data.UpdatePost;
import com.becandid.candid.models.NetworkData;
import com.becandid.candid.views.StickerKeyboard;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rx.schedulers.Schedulers;

public class PostDetailsActivity
extends PopupWithBlurBackgroundActivity
implements StickerKeyboard.a {
    public static final int COMMENT_EDIT = 203;
    public static final int COMMENT_INPUT_TYPE_FLAGS = 212992;
    public static final int FULLSCREEN_VIEW_REPLY = 198;
    public static final int MUTE_THREAD = 199;
    public static final int NUMBER_OF_COMMENTS_PER_PAGE = 20;
    public static HashSet<Integer> clipped;
    private Runnable A;
    int b;
    private String c;
    @BindView(value=2131624130)
    ImageView commentButton;
    @BindView(value=2131624276)
    EditText commentInput;
    @BindView(value=2131624272)
    RelativeLayout commentInputContainer;
    @BindView(value=2131624275)
    ImageView commentPhotoClear;
    @BindView(value=2131624268)
    RecyclerView commentRecyclerView;
    @BindView(value=2131624281)
    FrameLayout commentSpinnyContainer;
    @BindView(value=2131624279)
    TextView commentTextPlaceholder;
    private boolean d;
    private boolean e;
    private String f;
    private String g;
    private boolean h = false;
    private String i;
    private String j;
    private String k;
    private String l;
    private ArrayList<TextTag> m;
    @BindView(value=2131624269)
    View mReplyToBox;
    @BindView(value=2131624271)
    View mReplyToClose;
    @BindView(value=2131624270)
    TextView mReplyToTextHint;
    @BindView(value=2131624169)
    SwipeRefreshLayout mSwipeContainer;
    @BindView(value=2131624266)
    ImageView mutePostIcon;
    private ListPopupWindow n;
    private hg o;
    private CharSequence p = "";
    @BindView(value=2131624265)
    TextView postHeaderText;
    @BindView(value=2131624274)
    ImageView postPhoto;
    @BindView(value=2131624282)
    RelativeLayout postSpinnyContainer;
    private boolean q;
    private int r;
    @BindView(value=2131624280)
    LinearLayout relatedPostsButton;
    @BindView(value=2131624263)
    View root;
    private int s;
    @BindView(value=2131624278)
    ImageView stickerButton;
    @BindView(value=2131624232)
    StickerKeyboard stickerKeyboard;
    private Post t;
    private List<Comment> u;
    private he v;
    private Handler w;
    private Intent x;
    private String y;
    private final int z = 60000;

    public PostDetailsActivity() {
        this.A = new Runnable(){

            public void run() {
                PostDetailsActivity.this.getRxSubscription();
                PostDetailsActivity.this.w.postDelayed(PostDetailsActivity.this.A, 60000);
            }
        };
    }

    private aps a(final String string2, final boolean bl2, final int n2, String string3) {
        this.relatedPostsButton.setVisibility(8);
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"post_id", (Object)string2);
        if (string3 != null) {
            hashMap.put((Object)"op_color", (Object)string3);
        }
        return ik.a().d((Map<String, String>)hashMap).b(Schedulers.io()).a(apv.a()).b(new apr<Post>(){

            @Override
            public void onCompleted() {
                PostDetailsActivity.this.postSpinnyContainer.setVisibility(8);
                new Handler().postDelayed(new Runnable(){

                    /*
                     * Enabled aggressive block sorting
                     */
                    public void run() {
                        if (n2 != -1) {
                            PostDetailsActivity.this.scrollToComment(n2);
                            return;
                        } else {
                            if (!bl2) return;
                            {
                                PostDetailsActivity.this.scrollToBottom();
                                return;
                            }
                        }
                    }
                }, 200);
                PostDetailsActivity.this.mSwipeContainer.setRefreshing(false);
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
                PostDetailsActivity.this.postSpinnyContainer.setVisibility(8);
                PostDetailsActivity.this.mSwipeContainer.setRefreshing(false);
                ix.a().a(new in.ac());
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void onNext(Post post) {
                if (post == null) {
                    ix.a().a(new in.r(Integer.parseInt((String)string2)));
                    return;
                }
                PostDetailsActivity.this.t = post;
                new ArrayList().add((Object)PostDetailsActivity.this.t);
                PostDetailsActivity postDetailsActivity = PostDetailsActivity.this;
                List<Comment> list = post.comments != null ? post.comments : null;
                postDetailsActivity.u = list;
                ArrayList arrayList = new ArrayList();
                for (Comment comment : PostDetailsActivity.this.u) {
                    comment.is_master_comment = true;
                    arrayList.add((Object)comment);
                    for (Comment comment2 : comment.reply_comments) {
                        comment2.is_master_comment = false;
                        arrayList.add((Object)comment2);
                    }
                }
                PostDetailsActivity.this.u.clear();
                PostDetailsActivity.this.u.addAll((Collection)arrayList);
                ArrayList arrayList2 = new ArrayList();
                if (PostDetailsActivity.this.u.size() > 20 && PostDetailsActivity.this.v.e().size() == 0 && !bl2 && n2 == -1) {
                    arrayList2.addAll((Collection)PostDetailsActivity.this.u.subList(0, 20));
                    PostDetailsActivity.this.v.a("1");
                } else {
                    arrayList2.addAll((Collection)PostDetailsActivity.this.u);
                    PostDetailsActivity.this.v.a((String)null);
                }
                PostDetailsActivity.this.v.a((List<Comment>)arrayList2, PostDetailsActivity.this.t);
                if (!AppState.hasMuted && post.can_mute == 1 && PostDetailsActivity.this.j.equals((Object)"comment")) {
                    Intent intent = new Intent((Context)PostDetailsActivity.this, (Class)TutorialMuteActivity.class);
                    PostDetailsActivity.this.startActivityForResult(intent, 199);
                } else {
                    PostDetailsActivity.this.toggleMuteIcon();
                }
                PostDetailsActivity.this.toggleMuteIcon();
            }

        });
    }

    private void a(int n2) {
        this.mSubscription = super.a(this.f, false, n2, this.g);
        this.addToSubscriptionList(this.mSubscription);
    }

    private void a(final HashMap<String, String> hashMap) {
        String[] arrstring;
        if (!(hashMap.containsKey((Object)"comment_text") || hashMap.containsKey((Object)"sticker_name") || hashMap.containsKey((Object)"source_url"))) {
            Toast.makeText((Context)this, (CharSequence)"Empty comments are not allowed.", (int)0).show();
            return;
        }
        String string2 = (String)hashMap.get((Object)"comment_text");
        if (string2 != null && (arrstring = string2.split(" "))[0].startsWith("@") && arrstring.length == 1 && !hashMap.containsKey((Object)"sticker_name") && !hashMap.containsKey((Object)"source_url")) {
            Toast.makeText((Context)this, (CharSequence)"Empty comments are not allowed", (int)0).show();
            return;
        }
        this.commentSpinnyContainer.setVisibility(0);
        this.m.clear();
        this.commentInput.setText((CharSequence)"");
        this.chooseSticker(null);
        hashMap.put((Object)"post_id", (Object)this.f);
        this.k = null;
        ik.a().h((Map<String, String>)hashMap).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

            @Override
            public void onCompleted() {
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
                PostDetailsActivity.this.mReplyToBox.setVisibility(8);
                if (PostDetailsActivity.this.isStopped || !hashMap.containsKey((Object)"comment_text")) {
                    return;
                }
                PostDetailsActivity.this.commentInput.setText((CharSequence)hashMap.get((Object)"comment_text"));
            }

            /*
             * Enabled aggressive block sorting
             * Lifted jumps to return sites
             */
            @Override
            public void onNext(final NetworkData networkData) {
                PostDetailsActivity.this.mReplyToBox.setVisibility(8);
                if (PostDetailsActivity.this.isStopped) return;
                if (networkData == null) {
                    return;
                }
                if (!networkData.success) {
                    Toast.makeText((Context)PostDetailsActivity.this, (CharSequence)networkData.error, (int)0).show();
                    if (hashMap.containsKey((Object)"comment_text")) {
                        PostDetailsActivity.this.commentInput.setText((CharSequence)hashMap.get((Object)"comment_text"));
                    }
                    PostDetailsActivity.this.commentSpinnyContainer.setVisibility(8);
                    return;
                }
                if (networkData.comment != null) {
                    in.ad ad2 = new in.ad();
                    ad2.a = Integer.valueOf((String)PostDetailsActivity.this.f);
                    ad2.b = networkData.comment.comment_id;
                    ad2.c = networkData.comment.comment_text;
                    ad2.d = networkData.comment;
                    ad2.e = (String)hashMap.get((Object)"reply_to_comment_id");
                    ad2.d.is_master_comment = ad2.e == null;
                    ix.a().a(ad2);
                    if (networkData.update_post != null) {
                        ix.a().a(new in.ar(networkData.update_post));
                    }
                    if (PostDetailsActivity.this.c != null || PostDetailsActivity.this.i != null) {
                        PostDetailsActivity.this.clearPhoto(null);
                    }
                    PostDetailsActivity.this.closeKeyboard();
                    PostDetailsActivity.this.commentSpinnyContainer.setVisibility(8);
                }
                if (AppState.config.getInt("enable_related_posts", 1) == 1 && networkData.related_posts != null && !networkData.related_posts.isEmpty()) {
                    if (AppState.config.getInt("enable_related_posts_pop_up", 0) == 1) {
                        PostDetailsActivity.this.relatedPostsButton.setVisibility(0);
                        PostDetailsActivity.this.relatedPostsButton.setOnClickListener(new View.OnClickListener(){

                            public void onClick(View view) {
                                Intent intent = new Intent(view.getContext(), (Class)RelatedPostsFeedActivity.class);
                                intent.putExtra("related_posts", DataUtil.toJson(networkData.related_posts));
                                PostDetailsActivity.this.startActivity(intent);
                                PostDetailsActivity.this.relatedPostsButton.setVisibility(8);
                            }
                        });
                        return;
                    }
                    if (PostDetailsActivity.this.l == null) return;
                    PostDetailsActivity.this.relatedPostsButton.setVisibility(0);
                    PostDetailsActivity.this.relatedPostsButton.setOnClickListener(new View.OnClickListener(){

                        public void onClick(View view) {
                            AppState.relatedPosts = networkData.related_posts;
                            ix.a().a(new in.ah(networkData.update_post.post_id, true, PostDetailsActivity.this.l));
                            PostDetailsActivity.this.finish();
                        }
                    });
                    return;
                }
                PostDetailsActivity.this.relatedPostsButton.setVisibility(8);
            }

        });
    }

    private void b(int n2) {
        this.getRxSubscription();
    }

    public static void startPostDetailsActivity(int n2, Context context, String string2) {
        Intent intent = new Intent(context, (Class)PostDetailsActivity.class);
        intent.putExtra("post_id", n2);
        intent.putExtra("op_color", string2);
        context.startActivity(intent);
    }

    public void choosePhoto(View view) {
        if (this.d || this.c != null || this.i != null) {
            this.clearPhoto(null);
            return;
        }
        this.getPhotoHelper().choosePhoto();
    }

    public void chooseSticker(View view) {
        if (this.stickerKeyboard.getVisibility() == 0 || view == null) {
            this.stickerKeyboard.setVisibility(8);
            this.stickerButton.setImageResource(2130838235);
            this.stickerButton.setAlpha(0.5f);
            return;
        }
        if (this.keyboardOpen) {
            this.closeKeyboard();
        }
        this.stickerKeyboard.setVisibility(0);
        this.stickerButton.setImageResource(2130838236);
        this.stickerButton.setAlpha(1.0f);
    }

    public void clearPhoto(View view) {
        this.postPhoto.setImageBitmap(null);
        this.d = false;
        this.c = null;
        this.postPhoto.setVisibility(8);
        this.i = null;
        this.commentPhotoClear.setVisibility(8);
        if (!this.keyboardOpen) {
            this.keyboardClosed();
        }
        this.updatePostButton();
    }

    @Override
    public void clickSticker(String string2) {
        this.i = string2;
        this.postPhoto.setVisibility(0);
        this.commentPhotoClear.setVisibility(0);
        int n2 = GossipApplication.a.getResources().getIdentifier(string2.toLowerCase(), "drawable", GossipApplication.a.getPackageName());
        this.postPhoto.setImageDrawable(GossipApplication.a.getResources().getDrawable(n2));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)this.postPhoto.getLayoutParams();
        layoutParams.height = layoutParams.width = (int)(120.0f * this.getResources().getDisplayMetrics().density);
        this.postPhoto.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        this.showCommentInput();
        this.updatePostButton();
    }

    @Override
    protected void getRxSubscription() {
        this.mSubscription = this.a(this.f, false, -1, this.g);
        this.addToSubscriptionList(this.mSubscription);
    }

    public void hideCommentInput() {
        this.commentButton.setVisibility(8);
        this.commentInputContainer.setVisibility(8);
        this.commentTextPlaceholder.setVisibility(0);
    }

    @Override
    public void hideCurrentScreen() {
        this.root.setVisibility(8);
    }

    protected void imageCaptured() {
        this.d = true;
        this.photoHelper.a();
        this.addToSubscriptionList(ix.a().a(in.ak.class, new apr<in.ak>(){

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
            }

            @Override
            public void onNext(in.ak ak2) {
                if (ak2.b) {
                    if (!PostDetailsActivity.this.d) {
                        return;
                    }
                    PostDetailsActivity.this.d = false;
                    PostDetailsActivity.this.c = ak2.a.full_url;
                    if (PostDetailsActivity.this.e) {
                        PostDetailsActivity.this.e = false;
                        PostDetailsActivity.this.saveComment(null);
                    }
                    PostDetailsActivity.this.updatePostButton();
                    PostDetailsActivity.this.postPhoto.setAlpha(1.0f);
                    return;
                }
                PostDetailsActivity.this.clearPhoto(null);
                PostDetailsActivity.this.updatePostButton();
                if (PostDetailsActivity.this.e) {
                    PostDetailsActivity.this.e = false;
                }
                Toast.makeText((Context)PostDetailsActivity.this, (CharSequence)PostDetailsActivity.this.getString(2131230940), (int)0).show();
            }
        }));
    }

    @Override
    protected void keyboardClosed() {
        super.keyboardClosed();
        String string2 = this.commentInput.getText().toString().trim();
        if (!this.d && this.c == null && string2.length() == 0) {
            this.hideCommentInput();
        }
    }

    @Override
    protected void keyboardOpened() {
        super.keyboardOpened();
        this.chooseSticker(null);
        this.scrollToBottom();
    }

    public void mutePost() {
        ik.a().e(Integer.toString((int)this.t.post_id)).b(Schedulers.io()).a(apv.a()).b(new apr<EmptyClass>(){

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
            }

            @Override
            public void onNext(EmptyClass emptyClass) {
                PostDetailsActivity.a((PostDetailsActivity)PostDetailsActivity.this).muted_post = 1;
                AlertDialog.Builder builder = new AlertDialog.Builder((Context)PostDetailsActivity.this);
                if (!AppState.hasShownMutePopup) {
                    builder.setTitle((CharSequence)"Muted").setMessage((CharSequence)"You will no longer receive notifications about this post.").setPositiveButton(2131230895, null);
                    builder.create().show();
                    AppState.hasShownMutePopup = true;
                    AppState.saveState((ContextWrapper)GossipApplication.a());
                }
                PostDetailsActivity.this.toggleMuteIcon();
            }
        });
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void onActivityResult(int n2, int n3, Intent intent) {
        super.onActivityResult(n2, n3, intent);
        this.x = intent;
        if (n3 == 199) {
            this.t.can_mute = 1;
            this.mutePost();
            return;
        } else {
            if ((n2 == 901 || n2 == 902) && this.photoHelper != null && this.photoHelper.f != null && this.photoHelper.b != null && this.photoHelper.a != null) {
                this.postPhoto.setImageBitmap(this.photoHelper.f);
                if (this.photoHelper.d > 0 && this.photoHelper.e > 0) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)this.postPhoto.getLayoutParams();
                    layoutParams.width = (int)((float)this.photoHelper.d / (float)this.photoHelper.e * (float)layoutParams.height);
                    this.postPhoto.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
                }
                this.postPhoto.setVisibility(0);
                this.postPhoto.setAlpha(0.3f);
                this.commentPhotoClear.setVisibility(0);
                this.showCommentInput();
                this.imageCaptured();
                return;
            }
            if (n3 != 203) return;
            {
                this.k = "";
                return;
            }
        }
    }

    public void onBackPressed() {
        if (AppState.mainTabsActivity == null) {
            Intent intent = new Intent((Context)this, (Class)MainTabsActivity.class);
            if (!AppState.config.getBoolean("messaging_turned_on", true)) {
                intent.putExtra("selected_tab", "feed");
            }
            this.startActivity(intent);
            this.finish();
            return;
        }
        try {
            super.onBackPressed();
            return;
        }
        catch (IllegalStateException var3_2) {
            rj.a((Throwable)var3_2);
            this.finish();
            return;
        }
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130968627);
        ButterKnife.bind((Activity)this);
        clipped = new HashSet();
        this.j = AppState.config.getString("show_mute_tutorial", "none");
        this.u = new ArrayList();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager((Context)this);
        this.commentRecyclerView.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
        this.v = new he(this.u, this.t, (Context)this);
        this.commentRecyclerView.setAdapter((RecyclerView.Adapter)this.v);
        this.commentRecyclerView.setItemAnimator(null);
        this.commentRecyclerView.addOnScrollListener((RecyclerView.OnScrollListener)new hn(linearLayoutManager, this.v){

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void onLoadMore(String string2) {
                if (string2 != null) {
                    ArrayList arrayList = new ArrayList();
                    int n2 = PostDetailsActivity.this.v.e().size();
                    if (PostDetailsActivity.this.u.size() > n2 + 20) {
                        arrayList.addAll((Collection)PostDetailsActivity.this.u.subList(n2, n2 + 20));
                        PostDetailsActivity.this.v.a("1");
                    } else {
                        if (n2 < PostDetailsActivity.this.u.size()) {
                            arrayList.addAll((Collection)PostDetailsActivity.this.u.subList(n2, PostDetailsActivity.this.u.size()));
                        }
                        PostDetailsActivity.this.v.a((String)null);
                    }
                    PostDetailsActivity.this.v.c((List<Comment>)arrayList);
                }
            }
        });
        this.b = AppState.config.getInt("disable_group_tagging", 0);
        this.m = new ArrayList();
        if (AppState.groups == null) {
            AppState.groups = new ArrayList();
        }
        this.o = new hg((Context)this, 2130968690, (List<Group>)new ArrayList(AppState.groups));
        this.n = new ListPopupWindow((Context)this);
        this.n.setAdapter((ListAdapter)this.o);
        this.n.setAnchorView((View)this.commentInput);
        this.n.setAnimationStyle(0);
        this.n.setHeight(-2);
        this.n.setWidth(jb.a(150, (Context)this));
        this.n.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            /*
             * Enabled aggressive block sorting
             */
            public void onItemClick(AdapterView<?> adapterView, View view, int n2, long l2) {
                Group group = (Group)adapterView.getItemAtPosition(n2);
                String[] arrstring = PostDetailsActivity.this.commentInput.getText().toString().split("(?=#)");
                int n3 = PostDetailsActivity.this.commentInput.getSelectionStart();
                int n4 = 0;
                int n5 = 0;
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder((CharSequence)"");
                ArrayList arrayList = new ArrayList();
                int n6 = 0;
                for (String string2 : arrstring) {
                    int n7 = n4;
                    if (n7 < n3 && n3 <= (n4 += string2.length())) {
                        int n8 = spannableStringBuilder.length();
                        spannableStringBuilder.append((CharSequence)("#" + group.group_name));
                        n6 = 1 + group.group_name.length() - (n3 - n8);
                        n5 = spannableStringBuilder.length();
                        spannableStringBuilder.append((CharSequence)" ");
                        spannableStringBuilder.append((CharSequence)string2.substring(n3 - n7));
                        TextTag textTag = new TextTag(n8, n5, group.group_id);
                        arrayList.add((Object)textTag);
                        continue;
                    }
                    spannableStringBuilder.append((CharSequence)string2);
                }
                for (TextTag textTag : PostDetailsActivity.this.m) {
                    if (n3 >= textTag.startIndex && n3 <= textTag.endIndex) continue;
                    if (textTag.startIndex > n3) {
                        textTag.startIndex = n6 + textTag.startIndex;
                        textTag.endIndex = n6 + textTag.endIndex;
                    }
                    arrayList.add((Object)textTag);
                }
                PostDetailsActivity.this.m = arrayList;
                Iterator iterator = PostDetailsActivity.this.m.iterator();
                do {
                    if (!iterator.hasNext()) {
                        PostDetailsActivity.this.p = (CharSequence)spannableStringBuilder;
                        PostDetailsActivity.this.commentInput.setText((CharSequence)spannableStringBuilder);
                        PostDetailsActivity.this.commentInput.setSelection(n5);
                        PostDetailsActivity.this.commentInput.setSelection(n5 + 1);
                        PostDetailsActivity.this.n.dismiss();
                        return;
                    }
                    TextTag textTag2 = (TextTag)iterator.next();
                    if (textTag2.startIndex <= -1 || textTag2.endIndex <= -1) continue;
                    spannableStringBuilder.setSpan((Object)jb.a(), textTag2.startIndex, textTag2.endIndex, 33);
                } while (true);
            }
        });
        this.commentInput.setOnFocusChangeListener(new View.OnFocusChangeListener(){

            public void onFocusChange(View view, boolean bl2) {
                if (bl2 && PostDetailsActivity.this.b == 0) {
                    jb.a((CharSequence)PostDetailsActivity.this.commentInput.getText(), PostDetailsActivity.this.commentInput, PostDetailsActivity.this.n, PostDetailsActivity.this.o);
                }
            }
        });
        this.commentInput.addTextChangedListener(new TextWatcher(){

            public void afterTextChanged(Editable editable) {
                if (PostDetailsActivity.this.b == 0 && !editable.toString().equals((Object)PostDetailsActivity.this.p.toString())) {
                    PostDetailsActivity.this.p = (CharSequence)editable.toString();
                    jb.a((CharSequence)editable, PostDetailsActivity.this.commentInput, PostDetailsActivity.this.n, PostDetailsActivity.this.o);
                    if (PostDetailsActivity.this.q) {
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder((CharSequence)editable.toString());
                        for (TextTag textTag : PostDetailsActivity.this.m) {
                            if (textTag.startIndex <= -1 || textTag.endIndex <= -1) continue;
                            spannableStringBuilder.setSpan((Object)jb.a(), textTag.startIndex, textTag.endIndex, 33);
                        }
                        PostDetailsActivity.this.q = false;
                        PostDetailsActivity.this.p = (CharSequence)spannableStringBuilder.toString();
                        int n2 = PostDetailsActivity.this.commentInput.getSelectionStart();
                        PostDetailsActivity.this.commentInput.setText((CharSequence)spannableStringBuilder);
                        PostDetailsActivity.this.commentInput.setSelection(n2);
                    }
                }
                if (PostDetailsActivity.this.h) {
                    PostDetailsActivity.this.h = false;
                    PostDetailsActivity.this.commentInput.setInputType(16384 | -8193 & PostDetailsActivity.this.commentInput.getInputType());
                }
                PostDetailsActivity.this.updatePostButton();
            }

            public void beforeTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
                PostDetailsActivity.this.r = PostDetailsActivity.this.commentInput.getSelectionStart();
                PostDetailsActivity.this.s = PostDetailsActivity.this.commentInput.getSelectionEnd();
            }

            public void onTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
                if (PostDetailsActivity.this.b == 0 && !charSequence.toString().equals((Object)PostDetailsActivity.this.p.toString())) {
                    int n5 = PostDetailsActivity.this.commentInput.getSelectionStart();
                    ArrayList arrayList = new ArrayList();
                    for (TextTag textTag : PostDetailsActivity.this.m) {
                        if (PostDetailsActivity.this.r <= textTag.startIndex && PostDetailsActivity.this.s <= textTag.startIndex) {
                            textTag.startIndex += n4 - n3;
                            textTag.endIndex += n4 - n3;
                            arrayList.add((Object)textTag);
                            PostDetailsActivity.this.q = true;
                            continue;
                        }
                        if (PostDetailsActivity.this.r <= textTag.startIndex && PostDetailsActivity.this.s > textTag.startIndex) {
                            PostDetailsActivity.this.q = true;
                            continue;
                        }
                        if (PostDetailsActivity.this.r > textTag.startIndex && PostDetailsActivity.this.r <= textTag.endIndex) {
                            PostDetailsActivity.this.q = true;
                            continue;
                        }
                        if (n5 > textTag.endIndex) {
                            arrayList.add((Object)textTag);
                            continue;
                        }
                        PostDetailsActivity.this.q = true;
                    }
                    PostDetailsActivity.this.m = arrayList;
                }
            }
        });
        this.stickerKeyboard.a = this;
        this.root.requestLayout();
        this.enableKeyboardEvents(this.root);
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
                if (PostDetailsActivity.this.f != null && r2.a == Integer.valueOf((String)PostDetailsActivity.this.f)) {
                    Toast.makeText((Context)PostDetailsActivity.this, (CharSequence)"That post has been deleted", (int)0).show();
                    PostDetailsActivity.this.finish();
                }
            }
        });
        this.busSubscribe(in.ad.class, new apr<in.ad>(){

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void onNext(in.ad ad2) {
                if (ad2.a == Integer.valueOf((String)PostDetailsActivity.this.f)) {
                    if (ad2.e != null) {
                        try {
                            PostDetailsActivity.this.a(ad2.b);
                        }
                        catch (NumberFormatException var3_2) {
                            rj.a((Throwable)var3_2);
                        }
                    } else {
                        if (PostDetailsActivity.this.v == null) {
                            rj.a((Throwable)new NullPointerException("commentsAdapter is NULL"));
                            return;
                        }
                        PostDetailsActivity.this.a(ad2.b);
                    }
                }
                if (PostDetailsActivity.this.t == null) {
                    rj.a((Throwable)new Exception("mPost is NULL"));
                    return;
                } else {
                    PostDetailsActivity.a((PostDetailsActivity)PostDetailsActivity.this).can_mute = 1;
                    PostDetailsActivity.this.toggleMuteIcon();
                    if (AppState.hasMuted || !PostDetailsActivity.this.j.equals((Object)"comment")) return;
                    {
                        Intent intent = new Intent((Context)PostDetailsActivity.this, (Class)TutorialMuteActivity.class);
                        PostDetailsActivity.this.startActivityForResult(intent, 199);
                        return;
                    }
                }
            }
        });
        this.busSubscribe(in.l.class, new apr<in.l>(){

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
            }

            @Override
            public void onNext(in.l l2) {
                PostDetailsActivity.this.b(l2.a);
            }
        });
        this.busSubscribe(in.s.class, new apr<in.s>(){

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
            }

            @Override
            public void onNext(in.s s2) {
                PostDetailsActivity.this.b(s2.a);
            }
        });
        this.mSwipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){

            public void onRefresh() {
                PostDetailsActivity.this.getRxSubscription();
            }
        });
        this.mutePostIcon.setOnClickListener(new View.OnClickListener(){

            /*
             * Enabled aggressive block sorting
             */
            public void onClick(View view) {
                if (!AppState.hasMuted && PostDetailsActivity.this.j.equals((Object)"click")) {
                    Intent intent = new Intent((Context)PostDetailsActivity.this, (Class)TutorialMuteActivity.class);
                    PostDetailsActivity.this.startActivityForResult(intent, 199);
                    return;
                } else {
                    PostDetailsActivity.this.mutePostIcon.setEnabled(false);
                    if (PostDetailsActivity.a((PostDetailsActivity)PostDetailsActivity.this).muted_post == 0) {
                        PostDetailsActivity.this.mutePost();
                        return;
                    }
                    if (PostDetailsActivity.a((PostDetailsActivity)PostDetailsActivity.this).muted_post != 1) return;
                    {
                        PostDetailsActivity.this.unmutePost();
                        return;
                    }
                }
            }
        });
        this.postHeaderText.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                PostDetailsActivity.this.scrollToTop();
            }
        });
        this.mReplyToClose.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                PostDetailsActivity.this.mReplyToBox.setVisibility(8);
                PostDetailsActivity.this.k = null;
                PostDetailsActivity.this.y = null;
            }
        });
        this.w = new Handler(this.getMainLooper());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.setIntent(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.w.removeCallbacks(this.A);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    protected void onResume() {
        super.onResume();
        if (this.x != null) {
            if (this.x.getIntExtra("comment_id", -1) != -1) {
                // empty if block
            }
            this.x = null;
        } else {
            this.f = Integer.toString((int)this.getIntent().getIntExtra("post_id", 0));
            if (this.getIntent().hasExtra("op_color")) {
                this.g = this.getIntent().getStringExtra("op_color");
            }
            boolean bl2 = this.getIntent().getBooleanExtra("scrollToBottom", false);
            int n2 = this.getIntent().getIntExtra("comment_id", -1);
            this.l = this.getIntent().getStringExtra("feed_type");
            String string2 = DataUtil.getEncodedId(this.getIntent().getData());
            if (string2 != null) {
                this.f = String.valueOf((long)DataUtil.decodeId(string2));
            }
            this.mSubscription = this.a(this.f, bl2, n2, this.g);
        }
        this.w.postDelayed(this.A, 60000);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public void replyTo(String string2, String string3, int n2) {
        this.mReplyToBox.setVisibility(0);
        this.mReplyToTextHint.setHint((CharSequence)jb.a("Replying to " + string2));
        if (!string2.startsWith("@")) {
            this.y = "@" + string2;
        }
        if (!string2.endsWith(" ")) {
            this.y = this.y + " ";
        }
        if (((Comment)this.u.get((int)(n2 - 1))).is_master_comment && AppState.config != null && AppState.config.getInt("android_disable_at_mention_for_main_comment", 1) == 1) {
            this.y = "";
        }
        this.k = string3;
        this.startComment(null);
        this.h = true;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void saveComment(View view) {
        HashMap hashMap = new HashMap();
        StringBuilder stringBuilder = new StringBuilder();
        if (this.y != null) {
            stringBuilder.append(this.y);
        }
        stringBuilder.append(this.commentInput.getText().toString());
        String string2 = stringBuilder.toString();
        int n2 = string2.length();
        DataUtil.StringTrimResult stringTrimResult = DataUtil.trimWithCount(string2);
        if (stringTrimResult.string.length() > 0) {
            hashMap.put((Object)"comment_text", (Object)string2);
            this.y = null;
        }
        if (!this.m.isEmpty()) {
            String string3 = "";
            for (TextTag textTag : this.m) {
                int n3 = n2 - 1 - textTag.endIndex;
                textTag.startIndex -= stringTrimResult.trimmedStart;
                textTag.endIndex -= stringTrimResult.trimmedStart;
                if (stringTrimResult.trimmedEnd >= n3) {
                    textTag.endIndex = stringTrimResult.string.length();
                }
                string3 = string3 + textTag.toString() + ";";
            }
            hashMap.put((Object)"mentioned_group_ids", (Object)string3.substring(0, -1 + string3.length()));
        }
        if (this.c != null) {
            hashMap.put((Object)"source_url", (Object)this.c);
            float f2 = this.photoHelper.d;
            float f3 = this.photoHelper.e;
            if (f2 > 0.0f && f3 > 0.0f) {
                if ((double)f2 < 240.0 * (double)f3 / 160.0) {
                    hashMap.put((Object)"image_width", (Object)String.valueOf((int)((int)(160.0 * (double)f2 / (double)f3))));
                    hashMap.put((Object)"image_height", (Object)"160");
                } else {
                    hashMap.put((Object)"image_width", (Object)"240");
                    hashMap.put((Object)"image_height", (Object)String.valueOf((int)((int)(240.0 * (double)f3 / (double)f2))));
                }
            } else {
                hashMap.put((Object)"image_width", (Object)"240");
                hashMap.put((Object)"image_height", (Object)"160");
            }
        }
        if (this.i != null) {
            hashMap.put((Object)"sticker_name", (Object)this.i);
            hashMap.put((Object)"image_width", (Object)"120");
            hashMap.put((Object)"image_height", (Object)"120");
        }
        if (this.k != null) {
            hashMap.put((Object)"reply_to_comment_id", (Object)this.k);
        }
        super.a(hashMap);
    }

    public void scrollToBottom() {
        if (this.k == null) {
            if (this.v.e().size() != this.u.size()) {
                this.v.a(this.u, this.t);
                this.v.a((String)null);
            }
            this.commentRecyclerView.scrollToPosition(this.v.e().size());
        }
    }

    public void scrollToBottomAndNotUpdateData() {
        if (this.k == null) {
            this.commentRecyclerView.scrollToPosition(this.v.e().size());
        }
    }

    public void scrollToComment(int n2) {
        int n3;
        if (this.v.e().size() != this.u.size()) {
            this.v.a(this.u, this.t);
            this.v.a((String)null);
        }
        if ((n3 = this.v.b(n2)) != -1) {
            this.commentRecyclerView.scrollToPosition(n3 + 1);
            return;
        }
        Toast.makeText((Context)this, (int)2131230814, (int)0).show();
    }

    public void scrollToTop() {
        if (this.commentRecyclerView != null) {
            this.commentRecyclerView.scrollToPosition(0);
        }
    }

    public void showCommentInput() {
        this.commentInputContainer.setVisibility(0);
        this.commentTextPlaceholder.setVisibility(8);
        this.commentButton.setVisibility(0);
    }

    @Override
    public void showCurrentScreen() {
        this.root.setVisibility(0);
    }

    public void startComment(View view) {
        this.showCommentInput();
        this.commentInput.requestFocus();
        this.commentInput.post(new Runnable(){

            public void run() {
                PostDetailsActivity.this.openKeyboard();
            }
        });
    }

    /*
     * Enabled aggressive block sorting
     */
    public void toggleMuteIcon() {
        this.mutePostIcon.setEnabled(false);
        if (this.t.can_mute != 1) {
            this.mutePostIcon.setVisibility(8);
            return;
        }
        this.mutePostIcon.setVisibility(0);
        if (this.t.muted_post == 0) {
            this.mutePostIcon.setImageDrawable(this.getResources().getDrawable(2130838077));
        } else {
            this.mutePostIcon.setImageDrawable(this.getResources().getDrawable(2130838078));
        }
        this.mutePostIcon.setEnabled(true);
    }

    public void unmutePost() {
        ik.a().f(Integer.toString((int)this.t.post_id)).b(Schedulers.io()).a(apv.a()).b(new apr<EmptyClass>(){

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
            }

            @Override
            public void onNext(EmptyClass emptyClass) {
                PostDetailsActivity.a((PostDetailsActivity)PostDetailsActivity.this).muted_post = 0;
                AlertDialog.Builder builder = new AlertDialog.Builder((Context)PostDetailsActivity.this);
                if (!AppState.hasShownUnmutePopup) {
                    builder.setTitle((CharSequence)"Unmuted Post").setMessage((CharSequence)"You will receive notifications about this post again.").setPositiveButton(2131230895, null);
                    builder.create().show();
                    AppState.hasShownUnmutePopup = true;
                    AppState.saveState((ContextWrapper)GossipApplication.a());
                }
                PostDetailsActivity.this.toggleMuteIcon();
            }
        });
    }

    public void updatePostButton() {
        if (this.commentInput.getText().toString().trim().length() > 0 || this.c != null || this.i != null) {
            this.commentButton.setImageResource(2130837649);
            if (this.d) {
                this.commentButton.setImageResource(2130837648);
            }
            return;
        }
        this.commentButton.setImageResource(2130837648);
    }

}

