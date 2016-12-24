/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Color
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.os.AsyncTask
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
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
 *  android.support.v7.widget.RecyclerView$OnScrollListener
 *  android.support.v7.widget.SimpleItemAnimator
 *  android.text.Editable
 *  android.text.TextWatcher
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.EditText
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.TextView
 *  android.widget.Toast
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.lang.Void
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 *  org.json.JSONException
 *  org.json.JSONObject
 *  rx.schedulers.Schedulers
 */
package com.becandid.candid.activities;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.MainTabsActivity;
import com.becandid.candid.activities.PopupWithBlurBackgroundActivity;
import com.becandid.candid.activities.PostDetailsActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Config;
import com.becandid.candid.data.Message;
import com.becandid.candid.data.MessageThread;
import com.becandid.candid.data.Post;
import com.becandid.candid.data.User;
import com.becandid.candid.models.EmptySubscriber;
import com.becandid.candid.models.NetworkData;
import com.becandid.candid.views.StickerKeyboard;
import com.becandid.thirdparty.BlurTask;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import rx.schedulers.Schedulers;

public class MessageActivity
extends PopupWithBlurBackgroundActivity
implements StickerKeyboard.a {
    final BroadcastReceiver b;
    @BindView(value=2131624234)
    FrameLayout blockedFrameLayout;
    private io c;
    @BindView(value=2131624216)
    RelativeLayout contentRootView;
    private String d;
    private String e;
    private String f;
    private User g;
    private User h;
    @BindView(value=2131624237)
    TextView headerName;
    @BindView(value=2131624239)
    ImageView headerOnline;
    private boolean i;
    private boolean j;
    private String k;
    private int l;
    private String m;
    @BindView(value=2131624243)
    TextView mNickname;
    @BindView(value=2131624240)
    LinearLayout messageHeaderPostContainer;
    @BindView(value=2131624241)
    TextView messageHeaderPostText;
    @BindView(value=2131624242)
    ImageView messageHeaderRightArrow;
    @BindView(value=2131624238)
    TextView messageHeaderUserIcon;
    @BindView(value=2131624236)
    RelativeLayout messageHeaderUserIconContainer;
    @BindView(value=2131624225)
    EditText messageInput;
    @BindView(value=2131624221)
    RelativeLayout messageInputContainer;
    @BindView(value=2131624223)
    ImageView messagePhoto;
    @BindView(value=2131624226)
    ImageView messagePhotoButton;
    @BindView(value=2131624224)
    ImageView messagePhotoClear;
    @BindView(value=2131624220)
    RecyclerView messageRecycler;
    @BindView(value=2131624233)
    FrameLayout messageSpinnyContainer;
    @BindView(value=2131624217)
    SwipeRefreshLayout messageSwipeContainer;
    @BindView(value=2131624228)
    TextView messageTextPlaceholder;
    private boolean n = false;
    private hm o;
    private RelativeLayout.LayoutParams p;
    @BindView(value=2131624130)
    ImageView postButton;
    private Handler q;
    private final int r = 60000;
    @BindView(value=2131624231)
    TextView requestAccept;
    @BindView(value=2131624229)
    LinearLayout requestButtons;
    @BindView(value=2131624230)
    TextView requestIgnore;
    @BindView(value=2131624215)
    View root;
    private aps s;
    @BindView(value=2131624227)
    ImageView stickerButton;
    @BindView(value=2131624232)
    StickerKeyboard stickerKeyboard;
    private aps t;
    private Runnable u;

    public MessageActivity() {
        this.b = new BroadcastReceiver(){

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public void onReceive(Context context, Intent intent) {
                Bundle bundle = intent.getExtras();
                String string2 = bundle.getString("user_info");
                if (bundle.getString("message_id") != null && bundle.getString("post_id") != null && string2 != null) {
                    try {
                        int n2 = Integer.parseInt((String)bundle.getString("message_id"));
                        int n3 = Integer.parseInt((String)bundle.getString("post_id"));
                        String string3 = new JSONObject(string2).getString("post_name");
                        if (n2 != 0 && n3 != 0 && Integer.toString((int)n3).equals((Object)MessageActivity.this.d) && string3.equals((Object)MessageActivity.this.e)) {
                            Message message = new Message();
                            message.message_id = n2;
                            message.post_id = n3;
                            message.message = bundle.getString("message");
                            message.subject = bundle.getString("subject");
                            if (bundle.containsKey("image_width") && bundle.containsKey("image_height") && bundle.containsKey("source_url")) {
                                message.image_width = Integer.parseInt((String)bundle.getString("image_width"));
                                message.image_height = Integer.parseInt((String)bundle.getString("image_height"));
                                message.source_url = bundle.getString("source_url");
                                message.uploaded = Integer.parseInt((String)bundle.getString("uploaded"));
                            } else if (bundle.containsKey("sticker_name")) {
                                message.sticker_name = bundle.getString("sticker_name");
                            }
                            MessageActivity.this.a(message);
                        }
                    }
                    catch (JSONException var6_9) {
                        rj.a((Throwable)var6_9);
                    }
                    catch (Exception var5_10) {
                        rj.a((Throwable)var5_10);
                    }
                }
                this.abortBroadcast();
            }
        };
        this.u = new Runnable(){

            public void run() {
                HashMap hashMap = new HashMap();
                if (MessageActivity.this.d != null) {
                    hashMap.put((Object)"post_id", (Object)MessageActivity.this.d);
                }
                if (MessageActivity.this.e != null) {
                    hashMap.put((Object)"post_name", (Object)MessageActivity.this.e);
                }
                ik.a().n((Map<String, String>)hashMap).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        rj.a(throwable);
                    }

                    @Override
                    public void onNext(NetworkData networkData) {
                        if (!networkData.success) {
                            Toast.makeText((Context)MessageActivity.this, (CharSequence)networkData.error, (int)0).show();
                        }
                        MessageThread messageThread = networkData.thread;
                        if (messageThread.user_info != null) {
                            MessageActivity.this.g = messageThread.user_info;
                        }
                        if (messageThread.target_user_info != null) {
                            MessageActivity.this.h = messageThread.target_user_info;
                        }
                        ArrayList arrayList = new ArrayList();
                        if (messageThread.messages != null && !messageThread.messages.isEmpty()) {
                            for (Message message : messageThread.messages) {
                                if (MessageActivity.this.o.b(message.message_id)) continue;
                                arrayList.add((Object)message);
                            }
                            MessageActivity.this.o.a(0, (List<Message>)arrayList);
                        }
                        if (AppState.config.getInt("enable_nickname", 1) == 1 && messageThread.show_nickname_alert == 1 && networkData.thread.target_user_info.nickname != null && !networkData.thread.target_user_info.nickname.equals((Object)"")) {
                            MessageActivity.this.setupNicknameAlert(networkData.thread.target_user_info.nickname);
                        }
                    }
                });
                MessageActivity.this.q.postDelayed(MessageActivity.this.u, 60000);
            }

        };
    }

    private void a(Message message) {
        message.sender = "other";
        this.o.a(message);
        this.messageRecycler.smoothScrollToPosition(-1 + this.o.getItemCount());
        this.markThreadRead();
    }

    private void a(BlurTask.BadgeType badgeType) {
        if (this.n) {
            return;
        }
        this.n = true;
        new BlurTask((Activity)this, (View)this.contentRootView, badgeType).execute((Object[])new Void[0]);
    }

    private void a(HashMap<String, String> hashMap, final Message message) {
        long l2;
        if (!(hashMap.containsKey((Object)"message") || hashMap.containsKey((Object)"sticker_name") || hashMap.containsKey((Object)"source_url"))) {
            Toast.makeText((Context)this, (CharSequence)"Empty messages are not allowed.", (int)0).show();
            return;
        }
        this.messageInput.setText((CharSequence)"");
        this.chooseSticker(null);
        hashMap.put((Object)"post_id", (Object)this.d);
        message.post_id = Integer.parseInt((String)this.d);
        if (this.e != null) {
            hashMap.put((Object)"post_name", (Object)this.e);
            message.user_info = new User();
            message.user_info.post_name = this.e;
        }
        if (this.f != null) {
            hashMap.put((Object)"thread_comment_id", (Object)this.f);
        }
        hashMap.put((Object)"send", (Object)Boolean.toString((boolean)true));
        message.messageTempId = l2 = System.currentTimeMillis();
        ik.a().o((Map<String, String>)hashMap).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                if (MessageActivity.this.s != null) {
                    MessageActivity.this.s.unsubscribe();
                }
                if (MessageActivity.this.isStopped) {
                    return;
                }
                Toast.makeText((Context)MessageActivity.this, (CharSequence)throwable.toString(), (int)1).show();
                MessageActivity.this.o.a(message.messageTempId, false, false, null);
            }

            /*
             * Enabled aggressive block sorting
             * Lifted jumps to return sites
             */
            @Override
            public void onNext(NetworkData networkData) {
                if (MessageActivity.this.s != null) {
                    MessageActivity.this.s.unsubscribe();
                }
                if (MessageActivity.this.isStopped) {
                    return;
                }
                if (MessageActivity.this.k != null || MessageActivity.this.m != null) {
                    MessageActivity.this.clearPhoto(null);
                }
                if (networkData != null && !networkData.success) {
                    Toast.makeText((Context)MessageActivity.this, (CharSequence)networkData.error, (int)1).show();
                    if (networkData.error.contains((CharSequence)"blocked") || networkData.error.contains((CharSequence)"disabled")) {
                        MessageActivity.this.o.a(l2, false, true, null);
                    }
                    MessageActivity.this.o.a(l2, false, false, null);
                    return;
                }
                if (networkData != null && networkData.message != null) {
                    MessageActivity.this.o.a(l2, true, false, networkData.message);
                }
                if (AppState.config.getInt("enable_nickname", 1) != 1) return;
                if (networkData == null) return;
                if (networkData.show_nickname_prompt != 1) return;
                MessageActivity.this.a(BlurTask.BadgeType.g);
            }
        });
        message.params = hashMap;
        this.o.a(message);
        new Handler().postDelayed(new Runnable(){

            public void run() {
                MessageActivity.this.scrollToBottom();
            }
        }, 200);
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
        super.clearPhoto();
        this.messagePhoto.setImageBitmap(null);
        this.i = false;
        this.k = null;
        this.l = 0;
        this.messagePhoto.setVisibility(8);
        if (this.p != null) {
            this.messagePhoto.setLayoutParams((ViewGroup.LayoutParams)this.p);
        }
        this.m = null;
        this.messagePhotoClear.setVisibility(8);
        if (!this.keyboardOpen) {
            this.keyboardClosed();
        }
        this.updatePostButton();
        if (this.s != null) {
            this.s.unsubscribe();
        }
    }

    @Override
    public void clickSticker(String string2) {
        this.m = string2;
        this.messagePhoto.setVisibility(0);
        this.messagePhotoClear.setVisibility(0);
        int n2 = GossipApplication.a.getResources().getIdentifier(string2.toLowerCase(), "drawable", GossipApplication.a.getPackageName());
        this.messagePhoto.setImageDrawable(GossipApplication.a.getResources().getDrawable(n2));
        this.p = (RelativeLayout.LayoutParams)this.messagePhoto.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)this.messagePhoto.getLayoutParams();
        layoutParams.height = layoutParams.width = (int)(50.0f * this.getResources().getDisplayMetrics().density);
        this.messagePhoto.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        this.showMessageInput();
        this.updatePostButton();
    }

    public void closingPopup() {
        this.n = false;
        this.messageInput.requestFocus();
    }

    public aps getDataSubscription() {
        HashMap hashMap = new HashMap();
        if (this.d != null) {
            hashMap.put((Object)"post_id", (Object)this.d);
        }
        if (this.e != null) {
            hashMap.put((Object)"post_name", (Object)this.e);
        }
        this.markThreadRead();
        return ik.a().n((Map<String, String>)hashMap).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
                Log.d((String)"ReadMessage", (String)throwable.toString());
                MessageActivity.this.messageSpinnyContainer.setVisibility(8);
                MessageActivity.this.messageSwipeContainer.setRefreshing(false);
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void onNext(NetworkData networkData) {
                if (!networkData.success) {
                    Toast.makeText((Context)MessageActivity.this, (CharSequence)networkData.error, (int)0).show();
                    MessageActivity.this.finish();
                }
                MessageThread messageThread = networkData.thread;
                MessageActivity.this.g = messageThread.user_info;
                MessageActivity.this.h = messageThread.target_user_info;
                MessageActivity.this.o.b(messageThread.user_info);
                MessageActivity.this.o.a(messageThread.target_user_info);
                ArrayList arrayList = new ArrayList();
                if (messageThread.messages != null && !messageThread.messages.isEmpty()) {
                    arrayList.addAll(messageThread.messages);
                    MessageActivity.this.o.a(((Message)messageThread.messages.get((int)0)).message_id);
                } else {
                    MessageActivity.this.o.a((String)null);
                }
                if (messageThread.thread_comment_id != null) {
                    MessageActivity.this.f = messageThread.thread_comment_id;
                }
                MessageActivity.this.o.a(arrayList);
                MessageActivity.this.postButton.setEnabled(true);
                MessageActivity.this.setupActivityHeader(messageThread.target_user_info, messageThread.post, messageThread.user_info, messageThread);
                if (messageThread.target_user_info.is_blocked) {
                    MessageActivity.this.setupBlockedUser();
                }
                if (messageThread.is_request == 1) {
                    MessageActivity.this.setupRequest();
                }
                MessageActivity.this.messagePhotoButton.setOnClickListener(new View.OnClickListener(){

                    public void onClick(View view) {
                        MessageActivity.this.takePhoto();
                    }
                });
                MessageActivity.this.messageSpinnyContainer.setVisibility(8);
                MessageActivity.this.messageSwipeContainer.setRefreshing(false);
                if (AppState.config.getInt("enable_nickname", 1) == 1 && messageThread.show_nickname_alert == 1 && messageThread.target_user_info.nickname != null && !messageThread.target_user_info.nickname.equals((Object)"")) {
                    MessageActivity.this.setupNicknameAlert(messageThread.target_user_info.nickname);
                }
            }

        });
    }

    public void getPage(String string2) {
        HashMap hashMap = new HashMap();
        if (this.d != null) {
            hashMap.put((Object)"post_id", (Object)this.d);
        }
        if (this.e != null) {
            hashMap.put((Object)"post_name", (Object)this.e);
        }
        hashMap.put((Object)"prev_message_id", (Object)string2);
        ik.a().n((Map<String, String>)hashMap).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
                Log.d((String)"ReadMessage", (String)throwable.toString());
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void onNext(NetworkData networkData) {
                if (!networkData.success) {
                    Toast.makeText((Context)MessageActivity.this, (CharSequence)networkData.error, (int)0).show();
                    return;
                } else {
                    MessageThread messageThread = networkData.thread;
                    if (messageThread.user_info != null) {
                        MessageActivity.this.g = messageThread.user_info;
                    }
                    if (messageThread.target_user_info != null) {
                        MessageActivity.this.h = messageThread.target_user_info;
                    }
                    if (messageThread.messages != null && !messageThread.messages.isEmpty()) {
                        MessageActivity.this.o.c(messageThread.messages);
                        MessageActivity.this.o.a(((Message)messageThread.messages.get((int)0)).message_id);
                    } else {
                        MessageActivity.this.o.a((String)null);
                    }
                    if (AppState.config.getInt("enable_nickname", 1) != 1 || messageThread.show_nickname_alert != 1 || networkData.thread.target_user_info.nickname == null || networkData.thread.target_user_info.nickname.equals((Object)"")) return;
                    {
                        MessageActivity.this.setupNicknameAlert(networkData.thread.target_user_info.nickname);
                        return;
                    }
                }
            }
        });
    }

    public User getTargetUserData() {
        if (this.h != null) {
            return this.h;
        }
        return null;
    }

    public User getUserData() {
        if (this.g != null) {
            return this.g;
        }
        return null;
    }

    @Override
    public void hideCurrentScreen() {
        this.contentRootView.setVisibility(8);
    }

    public void hideMessageInput() {
        this.messageInputContainer.setVisibility(8);
        this.messageTextPlaceholder.setVisibility(0);
    }

    public void ignoreNickname() {
        ik.a().c(null, this.d, this.e).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
            }

            @Override
            public void onNext(NetworkData networkData) {
                MessageActivity.this.mNickname.setVisibility(0);
                MessageActivity.this.mNickname.setText((CharSequence)"Add a Nickname");
                MessageActivity.this.mNickname.setOnClickListener(new View.OnClickListener(){

                    public void onClick(View view) {
                        new BlurTask((Activity)MessageActivity.this, (View)MessageActivity.this.contentRootView, BlurTask.BadgeType.g).execute((Object[])new Void[0]);
                    }
                });
            }

        });
    }

    protected void imageCaptured() {
        this.i = true;
        if (this.photoHelper == null) {
            rj.a((Throwable)new Exception("photoHelper is NULL"));
            return;
        }
        this.photoHelper.a();
        if (this.s != null && !this.s.isUnsubscribed()) {
            this.s.unsubscribe();
        }
        this.s = ix.a().a(in.ak.class, new apr<in.ak>(){

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
                    if (!MessageActivity.this.i) {
                        return;
                    }
                    MessageActivity.this.i = false;
                    MessageActivity.this.k = ak2.a.full_url;
                    if (MessageActivity.this.j) {
                        MessageActivity.this.j = false;
                        MessageActivity.this.saveMessage(null);
                    }
                    MessageActivity.this.updatePostButton();
                    MessageActivity.this.messagePhoto.setAlpha(1.0f);
                    return;
                }
                MessageActivity.this.clearPhoto(null);
                MessageActivity.this.updatePostButton();
                if (MessageActivity.this.j) {
                    MessageActivity.this.j = false;
                }
                Toast.makeText((Context)MessageActivity.this, (CharSequence)MessageActivity.this.getString(2131230940), (int)0).show();
            }
        });
        this.addToSubscriptionList(this.s);
    }

    @Override
    protected void keyboardClosed() {
        super.keyboardClosed();
        String string2 = this.messageInput.getText().toString().trim();
        if (!this.i && this.k == null && string2.length() == 0) {
            this.hideMessageInput();
        }
    }

    @Override
    protected void keyboardOpened() {
        super.keyboardOpened();
        this.chooseSticker(null);
        this.scrollToBottom();
    }

    public void markNicknameAlertShown() {
        ik.a().d(this.d, this.e).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
    }

    public void markThreadRead() {
        HashMap hashMap = new HashMap();
        if (this.d != null) {
            hashMap.put((Object)"post_id", (Object)this.d);
        }
        if (this.e != null) {
            hashMap.put((Object)"post_name", (Object)this.e);
        }
        ik.a().w((Map<String, String>)hashMap).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void onActivityResult(int n2, int n3, Intent intent) {
        super.onActivityResult(n2, n3, intent);
        if (n3 != -1) {
            this.messagePhoto.setImageBitmap(null);
            this.clearPhoto();
            return;
        } else {
            if (this.photoHelper == null || this.photoHelper.f == null || this.photoHelper.b == null || this.photoHelper.a == null) return;
            {
                this.messagePhoto.setImageBitmap(this.photoHelper.f);
                if (this.photoHelper.d > 0 && this.photoHelper.e > 0) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)this.messagePhoto.getLayoutParams();
                    layoutParams.width = (int)((float)this.photoHelper.d / (float)this.photoHelper.e * (float)layoutParams.height);
                    this.messagePhoto.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
                }
                if (n2 == 905 || n2 == 902) {
                    this.l = 1;
                }
                this.messagePhoto.setVisibility(0);
                this.messagePhoto.setAlpha(0.3f);
                this.messagePhotoClear.setVisibility(0);
                this.showMessageInput();
                return;
            }
        }
    }

    public void onBackPressed() {
        if (AppState.mainTabsActivity == null) {
            Intent intent = new Intent((Context)this, (Class)MainTabsActivity.class);
            if (AppState.config.getBoolean("messaging_turned_on", true)) {
                intent.putExtra("selected_tab", "messages");
            }
            this.startActivity(intent);
            this.finish();
            return;
        }
        super.onBackPressed();
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle bundle2 = this.getIntent().getExtras();
        if (bundle2 == null) {
            this.finish();
            return;
        }
        if (bundle2.containsKey("post_id")) {
            this.d = bundle2.getString("post_id");
        }
        if (bundle2.containsKey("user_name")) {
            this.e = bundle2.getString("user_name");
        }
        if (bundle2.containsKey("comment_id")) {
            this.f = bundle2.getString("comment_id");
        }
        this.c = io.a();
        this.q = new Handler(this.getMainLooper());
        this.setContentView(2130968621);
        ButterKnife.bind((Activity)this);
        this.enableKeyboardEvents(this.root);
        if (AppState.account.messaging_disabled == 1) {
            this.blockedFrameLayout.setVisibility(0);
            new AlertDialog.Builder((Context)this).setTitle((CharSequence)"Enable Messaging?").setMessage((CharSequence)"You've previously disabled messaging. Do you want to enable it?").setNegativeButton((CharSequence)this.getResources().getString(2131230890), new DialogInterface.OnClickListener(){

                public void onClick(DialogInterface dialogInterface, int n2) {
                    MessageActivity.this.finish();
                }
            }).setPositiveButton((CharSequence)this.getResources().getString(2131230953), new DialogInterface.OnClickListener(){

                public void onClick(DialogInterface dialogInterface, int n2) {
                    HashMap hashMap = new HashMap();
                    hashMap.put((Object)"messaging_disabled", (Object)"0");
                    ik.a().r((Map<String, String>)hashMap).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
                    AppState.account.messaging_disabled = 0;
                    ix.a().a(new in.aa(0));
                    MessageActivity.this.blockedFrameLayout.setVisibility(8);
                }
            }).setCancelable(false).create().show();
        }
        this.stickerKeyboard.a = this;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager((Context)this);
        this.messageRecycler.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
        linearLayoutManager.setStackFromEnd(true);
        this.o = new hm((Context)this);
        this.messageRecycler.setAdapter((RecyclerView.Adapter)this.o);
        this.messageRecycler.addOnScrollListener((RecyclerView.OnScrollListener)new hn(linearLayoutManager, this.o, 1, 25){

            @Override
            public void onLoadMore(String string2) {
                if (string2 != null) {
                    MessageActivity.this.getPage(string2);
                }
            }
        });
        RecyclerView.ItemAnimator itemAnimator = this.messageRecycler.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator)itemAnimator).setSupportsChangeAnimations(false);
        }
        this.messageSwipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){

            public void onRefresh() {
                MessageActivity.this.o.c();
                MessageActivity.this.getDataSubscription();
            }
        });
        this.messageInput.addTextChangedListener((TextWatcher)new il(){

            public void afterTextChanged(Editable editable) {
                MessageActivity.this.updatePostButton();
            }
        });
        this.messageSpinnyContainer.setVisibility(0);
        this.addToSubscriptionList(this.getDataSubscription());
        this.t = ix.a().a(in.y.class, new apr<in.y>(){

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
            }

            @Override
            public void onNext(in.y y2) {
                MessageActivity.this.imageCaptured();
            }
        });
        this.addToSubscriptionList(this.t);
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.unregisterReceiver(this.b);
        this.q.removeCallbacks(this.u);
    }

    @Override
    protected void onResume() {
        IntentFilter intentFilter = new IntentFilter("com.becandid.candid.MESSAGING");
        intentFilter.setPriority(2);
        this.registerReceiver(this.b, intentFilter);
        this.q.postDelayed(this.u, 60000);
        ix.a().a(new in.as(2, 0, true));
        super.onResume();
    }

    /*
     * Enabled aggressive block sorting
     */
    public void saveMessage(View view) {
        if (this.i) {
            return;
        }
        Message message = new Message();
        HashMap hashMap = new HashMap();
        String string2 = this.messageInput.getText().toString().trim();
        if (string2.length() > 0) {
            hashMap.put((Object)"message", (Object)string2);
            message.message = string2;
        }
        if (this.k != null) {
            hashMap.put((Object)"source_url", (Object)this.k);
            message.source_url = this.k;
            hashMap.put((Object)"uploaded", (Object)Integer.toString((int)this.l));
            message.uploaded = this.l;
            float f2 = this.photoHelper.d;
            float f3 = this.photoHelper.e;
            if (f2 > 0.0f && f3 > 0.0f) {
                if ((double)f2 < 240.0 * (double)f3 / 160.0) {
                    hashMap.put((Object)"image_width", (Object)String.valueOf((int)((int)(160.0 * (double)f2 / (double)f3))));
                    message.image_width = (int)(160.0 * (double)f2 / (double)f3);
                    hashMap.put((Object)"image_height", (Object)"160");
                    message.image_height = 160;
                } else {
                    hashMap.put((Object)"image_width", (Object)"240");
                    message.image_width = 240;
                    hashMap.put((Object)"image_height", (Object)String.valueOf((int)((int)(240.0 * (double)f3 / (double)f2))));
                    message.image_height = (int)(240.0 * (double)f3 / (double)f2);
                }
            } else {
                hashMap.put((Object)"image_width", (Object)"240");
                message.image_width = 240;
                hashMap.put((Object)"image_height", (Object)"160");
                message.image_height = 160;
            }
        }
        if (this.m != null) {
            hashMap.put((Object)"sticker_name", (Object)this.m);
            message.sticker_name = this.m;
            hashMap.put((Object)"image_width", (Object)"120");
            message.image_width = 120;
            hashMap.put((Object)"image_height", (Object)"120");
            message.image_height = 120;
        }
        super.a(hashMap, message);
    }

    public void scrollToBottom() {
        this.messageRecycler.smoothScrollToPosition(this.messageRecycler.getBottom());
    }

    /*
     * Enabled aggressive block sorting
     */
    public void setupActivityHeader(User user, Post post, User user2, MessageThread messageThread) {
        int n2 = Color.parseColor((String)user.icon_color);
        this.messageHeaderUserIcon.setTextColor(n2);
        TextView textView = this.messageHeaderUserIcon;
        textView.setTypeface(io.b());
        TextView textView2 = this.messageHeaderUserIcon;
        textView2.setText((CharSequence)io.a(user.icon_name));
        int n3 = this.messageHeaderUserIconContainer.getWidth();
        if (n3 == 0) {
            n3 = (int)(28.0f * this.messageHeaderUserIconContainer.getResources().getDisplayMetrics().density);
        }
        int n4 = 1073741824 | 16777215 & n2;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(n4);
        gradientDrawable.setCornerRadius((float)(n3 / 2));
        this.messageHeaderUserIconContainer.setBackground((Drawable)gradientDrawable);
        if (user.online == 1) {
            this.headerOnline.setVisibility(0);
        } else {
            this.headerOnline.setVisibility(8);
        }
        jp jp2 = new jp();
        int n5 = jb.a(10, (Context)this);
        int n6 = jb.a(6, (Context)this);
        jp2.setBounds(0, jb.a(1, (Context)this), n5, n6);
        jp2.a(n2);
        this.headerName.setCompoundDrawables(null, null, (Drawable)jp2, null);
        if (AppState.config.getInt("enable_nickname", 1) == 1 && user.nickname != null && !user.nickname.equals((Object)"")) {
            this.headerName.setText((CharSequence)user.nickname);
        } else {
            this.headerName.setText((CharSequence)user.post_name);
        }
        this.headerName.setTextColor(n2);
        this.headerName.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu((Context)MessageActivity.this, view);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){

                    /*
                     * Enabled aggressive block sorting
                     */
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        HashMap hashMap = new HashMap();
                        hashMap.put((Object)"post_id", (Object)MessageActivity.this.d);
                        hashMap.put((Object)"post_name", (Object)MessageActivity.this.e);
                        switch (menuItem.getItemId()) {
                            case 2131624855: {
                                ix.a().a(new in.j(Integer.parseInt((String)MessageActivity.this.d), MessageActivity.this.e));
                                ik.a().s((Map<String, String>)hashMap).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
                                MessageActivity.this.finish();
                            }
                            default: {
                                return false;
                            }
                            case 2131624857: 
                        }
                        ix.a().a(new in.j(Integer.parseInt((String)MessageActivity.this.d), MessageActivity.this.e));
                        ik.a().u((Map<String, String>)hashMap).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
                        MessageActivity.this.finish();
                        return false;
                    }
                });
                popupMenu.getMenu().add(1, 2131624855, 0, 2131230878);
                popupMenu.getMenu().add(1, 2131624857, 0, 2131230879);
                popupMenu.show();
            }

        });
        if (post != null) {
            this.messageHeaderPostContainer.setVisibility(0);
            if (this.f != null) {
                this.messageHeaderPostText.setText((CharSequence)"See Comment");
            } else {
                this.messageHeaderPostText.setText((CharSequence)"See Post");
            }
            jk jk2 = new jk();
            jk2.setBounds(0, jb.a(2, (Context)this), jb.a(8, (Context)this), jb.a(10, (Context)this));
            jk2.a(this.getResources().getColor(2131558478));
            this.messageHeaderRightArrow.setImageDrawable((Drawable)jk2);
            this.messageHeaderPostContainer.setOnClickListener(new View.OnClickListener(){

                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), (Class)PostDetailsActivity.class);
                    intent.putExtra("post_id", Integer.parseInt((String)MessageActivity.this.d));
                    if (MessageActivity.this.f != null) {
                        intent.putExtra("comment_id", Integer.parseInt((String)MessageActivity.this.f));
                        intent.putExtra("scrollToBottom", true);
                    }
                    MessageActivity.this.startActivity(intent);
                }
            });
        } else {
            this.messageHeaderPostContainer.setVisibility(8);
        }
        if (AppState.config.getInt("enable_nickname", 1) == 1 && user2.nickname != null && !user2.nickname.equals((Object)"")) {
            this.mNickname.setText((CharSequence)("Chatting as " + user2.nickname));
            this.mNickname.setVisibility(0);
            return;
        }
        if (AppState.config.getInt("enable_nickname", 1) == 1 && messageThread.can_add_nickname == 1) {
            this.mNickname.setText((CharSequence)"Add Nickname");
            this.mNickname.setOnClickListener(new View.OnClickListener(){

                public void onClick(View view) {
                    MessageActivity messageActivity = MessageActivity.this;
                    messageActivity.a(BlurTask.BadgeType.g);
                }
            });
            this.mNickname.setVisibility(0);
            return;
        }
        this.mNickname.setVisibility(8);
    }

    public void setupBlockedUser() {
        this.blockedFrameLayout.setVisibility(0);
        new AlertDialog.Builder((Context)this).setTitle((CharSequence)"Unblock This Thread?").setMessage((CharSequence)"You've previously blocked this thread. Do you want to unblock it?").setNegativeButton((CharSequence)this.getResources().getString(2131230890), new DialogInterface.OnClickListener(){

            public void onClick(DialogInterface dialogInterface, int n2) {
                MessageActivity.this.finish();
            }
        }).setPositiveButton((CharSequence)this.getResources().getString(2131230953), new DialogInterface.OnClickListener(){

            public void onClick(DialogInterface dialogInterface, int n2) {
                HashMap hashMap = new HashMap();
                hashMap.put((Object)"post_id", (Object)MessageActivity.this.d);
                hashMap.put((Object)"post_name", (Object)MessageActivity.this.e);
                ik.a().t((Map<String, String>)hashMap).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
                MessageActivity.this.blockedFrameLayout.setVisibility(8);
            }
        }).setCancelable(false).create().show();
    }

    public void setupNicknameAlert(String string2) {
        this.headerName.setText((CharSequence)string2);
        super.a(BlurTask.BadgeType.h);
    }

    public void setupRequest() {
        this.requestButtons.setVisibility(0);
        this.requestIgnore.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                MessageActivity.this.requestIgnore.setEnabled(false);
                MessageActivity.this.requestAccept.setEnabled(true);
                HashMap hashMap = new HashMap();
                hashMap.put((Object)"post_id", (Object)MessageActivity.this.d);
                hashMap.put((Object)"post_name", (Object)MessageActivity.this.e);
                hashMap.put((Object)"ignore", (Object)"1");
                ik.a().v((Map<String, String>)hashMap).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        rj.a(throwable);
                        Log.d((String)"HandleRequest", (String)throwable.toString());
                        MessageActivity.this.requestIgnore.setEnabled(true);
                    }

                    @Override
                    public void onNext(NetworkData networkData) {
                        if (networkData.success) {
                            ix.a().a(new in.x(MessageActivity.this.d, MessageActivity.this.e, 1));
                            MessageActivity.this.finish();
                            return;
                        }
                        MessageActivity.this.requestIgnore.setEnabled(true);
                    }
                });
            }

        });
        this.requestAccept.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                MessageActivity.this.requestIgnore.setEnabled(false);
                MessageActivity.this.requestAccept.setEnabled(true);
                HashMap hashMap = new HashMap();
                hashMap.put((Object)"post_id", (Object)MessageActivity.this.d);
                hashMap.put((Object)"post_name", (Object)MessageActivity.this.e);
                hashMap.put((Object)"ignore", (Object)"0");
                ik.a().v((Map<String, String>)hashMap).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        rj.a(throwable);
                        Log.d((String)"HandleRequest", (String)throwable.toString());
                        MessageActivity.this.requestIgnore.setEnabled(true);
                        MessageActivity.this.requestAccept.setEnabled(true);
                    }

                    @Override
                    public void onNext(NetworkData networkData) {
                        if (networkData.success) {
                            MessageActivity.this.requestButtons.setVisibility(8);
                            ix.a().a(new in.x(MessageActivity.this.d, MessageActivity.this.e, 0));
                            return;
                        }
                        MessageActivity.this.requestIgnore.setEnabled(true);
                        MessageActivity.this.requestAccept.setEnabled(true);
                    }
                });
            }

        });
    }

    @Override
    public void showCurrentScreen() {
        this.contentRootView.setVisibility(0);
    }

    public void showMessageInput() {
        this.messageInputContainer.setVisibility(0);
        this.messageTextPlaceholder.setVisibility(8);
    }

    public void startMessage(View view) {
        this.showMessageInput();
        this.messageInput.requestFocus();
        this.messageInput.post(new Runnable(){

            public void run() {
                MessageActivity.this.openKeyboard();
            }
        });
    }

    public void takePhoto() {
        if (this.i || this.k != null || this.m != null) {
            this.clearPhoto(null);
        }
        if (AppState.config.getInt("android_msg_image_upload", 1) == 1) {
            this.getPhotoHelper().choosePhoto(false);
            return;
        }
        this.getPhotoHelper().choosePhoto(true);
    }

    public void updateNickname(final String string2) {
        AppState.nickname = string2;
        AppState.saveState((ContextWrapper)this);
        ik.a().c(string2, this.d, this.e).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
            }

            @Override
            public void onNext(NetworkData networkData) {
                if (networkData.success) {
                    MessageActivity.this.mNickname.setVisibility(0);
                    MessageActivity.this.mNickname.setText((CharSequence)("Chatting as " + string2));
                    MessageActivity.this.mNickname.setOnClickListener(null);
                }
            }
        });
    }

    public void updatePostButton() {
        if (this.messageInput.getText().toString().trim().length() > 0 || this.k != null || this.m != null) {
            this.postButton.setImageResource(2130837649);
            if (this.i) {
                this.postButton.setImageResource(2130837648);
            }
            return;
        }
        this.postButton.setImageResource(2130837648);
    }

}

