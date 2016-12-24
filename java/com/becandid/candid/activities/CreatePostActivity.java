/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.Typeface
 *  android.media.ExifInterface
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Environment
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Parcelable
 *  android.support.v7.app.AlertDialog
 *  android.support.v7.app.AlertDialog$Builder
 *  android.support.v7.widget.ListPopupWindow
 *  android.support.v7.widget.SwitchCompat
 *  android.text.Editable
 *  android.text.SpannableStringBuilder
 *  android.text.TextWatcher
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.view.Display
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnFocusChangeListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.WindowManager
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.ArrayAdapter
 *  android.widget.Button
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 *  android.widget.EditText
 *  android.widget.ImageView
 *  android.widget.ListAdapter
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.ScrollView
 *  android.widget.TextView
 *  android.widget.TextView$OnEditorActionListener
 *  android.widget.Toast
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  butterknife.OnClick
 *  java.io.File
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.io.Serializable
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.ClassCastException
 *  java.lang.Exception
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  rx.exceptions.CompositeException
 *  rx.schedulers.Schedulers
 */
package com.becandid.candid.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.SwitchCompat;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.AddLinkActivity;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.activities.CreateGroupActivity;
import com.becandid.candid.activities.InviteContactsActivity;
import com.becandid.candid.activities.LinkSearchActivity;
import com.becandid.candid.activities.PostDetailsActivity;
import com.becandid.candid.activities.TutorialLinkSearchActivity;
import com.becandid.candid.activities.TutorialPostActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Config;
import com.becandid.candid.data.DataUtil;
import com.becandid.candid.data.EmptyClass;
import com.becandid.candid.data.Group;
import com.becandid.candid.data.Post;
import com.becandid.candid.data.TextTag;
import com.becandid.candid.data.User;
import com.becandid.candid.models.EmptySubscriber;
import com.becandid.candid.models.NetworkData;
import com.becandid.candid.models.ServerMessage;
import com.becandid.candid.views.AlwaysOnAutoCompleteView;
import com.venmo.view.TooltipView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rx.exceptions.CompositeException;
import rx.schedulers.Schedulers;

public class CreatePostActivity
extends BaseActivity
implements View.OnClickListener {
    public static final int ADD_LINK_REQUEST = 1002;
    public static final int CREATE_GROUP_FOR_POST = 1001;
    public static final int TUTORIAL_LINK_SEARCH = 1004;
    public static final int TUTORIAL_POST = 1003;
    final Runnable b;
    private String c;
    @BindView(value=2131624125)
    View camBtn;
    @BindView(value=2131624113)
    View createGroupButton;
    private boolean d;
    private int e;
    private boolean f = true;
    @BindView(value=2131624129)
    TextView friendMarker;
    @BindView(value=2131624128)
    SwitchCompat friendSwitch;
    private Handler g;
    @BindView(value=2131624110)
    AlwaysOnAutoCompleteView groupNameSelector;
    private String h;
    private hg i;
    private int j;
    private ArrayList<TextTag> k;
    private ListPopupWindow l;
    @BindView(value=2131624118)
    RelativeLayout linkContainer;
    private hg m;
    @BindView(value=2131624109)
    View mRootView;
    private CharSequence n = "";
    private int o;
    private int p;
    @BindView(value=2131624130)
    Button postButton;
    @BindView(value=2131624115)
    EditText postCaption;
    @BindView(value=2131624114)
    ScrollView postContent;
    @BindView(value=2131624117)
    ImageView postPhoto;
    @BindView(value=2131624131)
    View postSpinny;
    private boolean q;
    private Map<String, String> r;
    private boolean s;
    private aps t;
    @BindView(value=2131624124)
    TooltipView tooltipView;
    private String u;
    @BindView(value=2131624127)
    View webSearchBtn;

    public CreatePostActivity() {
        this.b = new Runnable(){

            public void run() {
                CreatePostActivity.this.tooltipView.setVisibility(8);
            }
        };
    }

    private Group a(String string2) {
        if (this.i != null) {
            return this.i.b(string2);
        }
        return null;
    }

    private void a() {
        if (AppState.account == null || AppState.account.num_fb_friends + AppState.account.num_phone_friends < 1) {
            this.friendSwitch.setVisibility(8);
            this.friendMarker.setVisibility(8);
            return;
        }
        this.friendSwitch.setVisibility(0);
        this.friendMarker.setVisibility(0);
    }

    private void a(Bitmap bitmap, File file, int n2) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        bitmap.compress(Bitmap.CompressFormat.PNG, n2, (OutputStream)fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(Group group) {
        if (group != null) {
            Log.d((String)"CPA", (String)("Choose group: " + group.group_name));
            this.e = group.group_id;
            this.groupNameSelector.setVisibility(8);
            this.createGroupButton.setVisibility(8);
            this.findViewById(2131624111).setVisibility(0);
            ((TextView)this.findViewById(2131624112)).setText((CharSequence)group.group_name);
            this.postCaption.requestFocus();
        } else {
            this.e = 0;
            this.findViewById(2131624111).setVisibility(8);
            this.groupNameSelector.setVisibility(0);
            this.createGroupButton.setVisibility(0);
            this.groupNameSelector.setText((CharSequence)"");
            this.groupNameSelector.requestFocus();
        }
        this.updatePostButton();
    }

    private void a(Post post, Map<String, String> map) {
        if (this.t != null) {
            this.t.unsubscribe();
        }
        this.t = ik.a().createPost(post, map).b(Schedulers.io()).a(apv.a()).b(super.d());
        this.addToSubscriptionList(this.t);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(Map<String, String> map) {
        if (map.containsKey((Object)"type") && ((String)map.get((Object)"type")).equals((Object)"video")) {
            map.put((Object)"type", (Object)"link");
        }
        if (map.containsKey((Object)"type") && ((String)map.get((Object)"type")).equals((Object)"image")) {
            this.c = (String)map.get((Object)"source_url");
            GossipApplication.c.a(this.c).j().a(new qq(this.postPhoto){

                /*
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 */
                @Override
                public void onResourceReady(Bitmap bitmap, qk<? super Bitmap> qk2) {
                    super.onResourceReady(bitmap, qk2);
                    if (bitmap != null && bitmap.getWidth() > 0) {
                        CreatePostActivity.this.photoHelper = CreatePostActivity.this.getPhotoHelper();
                        CreatePostActivity.this.photoHelper.d = bitmap.getWidth();
                        CreatePostActivity.this.photoHelper.e = bitmap.getHeight();
                        CreatePostActivity.this.photoHelper.c = CreatePostActivity.this.photoHelper.a(bitmap);
                        try {
                            CreatePostActivity.this.u = (Object)Environment.getExternalStorageDirectory() + "/temp_link_img.png";
                            CreatePostActivity.this.a(bitmap, new File(CreatePostActivity.this.u), 100);
                            int n2 = new ExifInterface(CreatePostActivity.this.u).getAttributeInt("Orientation", 1);
                            jb.b(CreatePostActivity.this.u, n2);
                        }
                        catch (Exception var3_4) {
                            rj.a((Throwable)var3_4);
                        }
                        CreatePostActivity.this.e();
                    }
                }
            });
            this.findViewById(2131624116).setVisibility(0);
            this.updatePostButton();
            return;
        }
        this.r = map;
        this.linkContainer.setVisibility(0);
        ((TextView)this.linkContainer.findViewById(2131624120)).setText((CharSequence)this.r.get((Object)"title"));
        String string2 = this.r.containsKey((Object)"description") ? (String)this.r.get((Object)"description") : "";
        TextView textView = (TextView)this.linkContainer.findViewById(2131624121);
        if (string2.length() > 0) {
            textView.setText((CharSequence)string2);
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        ((TextView)this.linkContainer.findViewById(2131624122)).setText((CharSequence)this.r.get((Object)"attribution_host"));
        String string3 = this.r.containsKey((Object)"source_url") ? (String)this.r.get((Object)"source_url") : null;
        ImageView imageView = (ImageView)this.linkContainer.findViewById(2131624119);
        if (string3 != null && string3.length() > 0) {
            GossipApplication.c.a(string3).a().a(imageView);
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        this.updatePostButton();
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(boolean bl2) {
        this.g.removeCallbacks(this.b);
        this.tooltipView.setVisibility(0);
        if (bl2) {
            this.tooltipView.setText((CharSequence)this.getString(2131230961));
        } else {
            this.tooltipView.setText((CharSequence)this.getString(2131230962));
        }
        this.g.postDelayed(this.b, 5000);
    }

    private Group b(String string2) {
        for (Group group : AppState.groups) {
            if (!group.group_name.equals((Object)string2)) continue;
            return group;
        }
        return null;
    }

    private void b() {
        if (AppState.groups == null) {
            ik.a().b().b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

                @Override
                public void onCompleted() {
                }

                @Override
                public void onError(Throwable throwable) {
                    if (CreatePostActivity.this.isStopped) {
                        return;
                    }
                    Toast.makeText((Context)CreatePostActivity.this, (CharSequence)throwable.toString(), (int)1).show();
                }

                @Override
                public void onNext(NetworkData networkData) {
                    if (CreatePostActivity.this.isStopped) {
                        return;
                    }
                    CreatePostActivity.this.b();
                }
            });
            return;
        }
        this.i = new hg((Context)this, 2130968690, (List<Group>)new ArrayList(AppState.groups));
        this.groupNameSelector.setThreshold(0);
        this.groupNameSelector.setAdapter((ListAdapter)this.i);
    }

    private void c() {
        String string2;
        String[] arrstring;
        String string3;
        String[] arrstring2 = this.postCaption.getText().toString().trim().split("\n");
        this.updatePostButton();
        if (arrstring2.length > 0 && (string3 = arrstring2[-1 + arrstring2.length]) != null && (arrstring = string3.split(" ")).length > 0 && (string2 = arrstring[-1 + arrstring.length]) != null && iz.a(string2) && !string2.equals((Object)this.h)) {
            this.h = string2;
            this.addToSubscriptionList(ik.a().d(string2).b(Schedulers.io()).a(apv.a()).b(new apr<Map<String, String>>(){

                @Override
                public void onCompleted() {
                }

                @Override
                public void onError(Throwable throwable) {
                    throwable.printStackTrace();
                }

                @Override
                public void onNext(Map<String, String> map) {
                    if (map != null) {
                        CreatePostActivity.this.s = true;
                        CreatePostActivity.this.r = map;
                        CreatePostActivity.this.a(CreatePostActivity.this.r);
                        CreatePostActivity.this.postCaption.setText((CharSequence)"");
                    }
                }
            }));
        }
    }

    private apr<NetworkData> d() {
        return new apr<NetworkData>(){

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                if (throwable instanceof CompositeException) {
                    Iterator iterator = ((CompositeException)throwable).a().iterator();
                    while (iterator.hasNext()) {
                        Log.d((String)"CPA", (String)((Throwable)iterator.next()).toString());
                    }
                }
                rj.a(throwable);
                new Handler().postDelayed(new Runnable(){

                    public void run() {
                        CreatePostActivity.this.postSpinny.setVisibility(8);
                        CreatePostActivity.this.mRootView.setAlpha(1.0f);
                    }
                }, 500);
            }

            @Override
            public void onNext(final NetworkData networkData) {
                if (!networkData.success) {
                    if (networkData.same_link_found == 1) {
                        Object[] arrobject = new String[]{"Join The Conversation", "Create A New Post"};
                        AlertDialog.Builder builder = new AlertDialog.Builder((Context)CreatePostActivity.this);
                        TextView textView = new TextView(CreatePostActivity.this.getApplicationContext());
                        textView.setText((CharSequence)networkData.error);
                        textView.setTextSize(1, 16.0f);
                        textView.setTypeface(Typeface.defaultFromStyle((int)1));
                        textView.setTextColor(CreatePostActivity.this.getResources().getColor(17170444));
                        textView.setGravity(17);
                        int n2 = jb.a(5, CreatePostActivity.this.getApplicationContext());
                        ArrayAdapter arrayAdapter = new ArrayAdapter(CreatePostActivity.this.getApplicationContext(), 2130968749, arrobject);
                        textView.setPadding(n2, n2, n2, 0);
                        builder.setCustomTitle((View)textView).setAdapter((ListAdapter)arrayAdapter, new DialogInterface.OnClickListener(){

                            public void onClick(DialogInterface dialogInterface, int n2) {
                                switch (n2) {
                                    default: {
                                        return;
                                    }
                                    case 0: {
                                        dialogInterface.dismiss();
                                        Intent intent = new Intent((Context)CreatePostActivity.this, (Class)PostDetailsActivity.class);
                                        intent.putExtra("post_id", networkData.post.post_id);
                                        CreatePostActivity.this.startActivity(intent);
                                        CreatePostActivity.this.finish();
                                        return;
                                    }
                                    case 1: 
                                }
                                dialogInterface.dismiss();
                                HashMap hashMap = new HashMap();
                                hashMap.putAll(CreatePostActivity.this.r);
                                hashMap.put((Object)"insist_posting", (Object)"1");
                                CreatePostActivity.this.a(networkData.post, (Map)hashMap);
                            }
                        });
                        android.support.v7.app.AlertDialog alertDialog = builder.create();
                        alertDialog.setCanceledOnTouchOutside(false);
                        alertDialog.setCancelable(false);
                        alertDialog.show();
                        return;
                    }
                    Toast.makeText((Context)CreatePostActivity.this, (CharSequence)networkData.error, (int)1).show();
                    new Handler().postDelayed(new Runnable(){

                        public void run() {
                            CreatePostActivity.this.postSpinny.setVisibility(8);
                            CreatePostActivity.this.mRootView.setAlpha(1.0f);
                        }
                    }, 500);
                    return;
                }
                final Post post = networkData.post;
                if (networkData.server_message != null) {
                    new AlertDialog.Builder((Context)CreatePostActivity.this).setTitle((CharSequence)networkData.server_message.title).setMessage((CharSequence)networkData.server_message.message).setPositiveButton(2131230895, new DialogInterface.OnClickListener(){

                        public void onClick(DialogInterface dialogInterface, int n2) {
                            ik.a().k(networkData.server_message.message_type).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
                            ix.a().a(new in.k(post));
                            new Handler().postDelayed(new Runnable(){

                                public void run() {
                                    CreatePostActivity.this.postSpinny.setVisibility(8);
                                    CreatePostActivity.this.mRootView.setAlpha(1.0f);
                                }
                            }, 500);
                            Intent intent = new Intent();
                            intent.putExtra("json", DataUtil.toJson(post));
                            CreatePostActivity.this.setResult(-1, intent);
                            Intent intent2 = new Intent(CreatePostActivity.this.getBaseContext(), (Class)InviteContactsActivity.class);
                            intent2.putExtra("post", DataUtil.toJson(post));
                            CreatePostActivity.this.startActivity(intent2);
                            CreatePostActivity.this.finish();
                        }

                    }).create().show();
                    return;
                }
                if (AppState.groups != null) {
                    for (Group group : AppState.groups) {
                        if (group.group_id != post.group_id) continue;
                        AppState.groups.remove((Object)group);
                        AppState.groups.add(0, (Object)group);
                        break;
                    }
                }
                if (AppState.config.getInt("enable_related_posts", 1) == 1 && networkData.related_posts != null && !networkData.related_posts.isEmpty()) {
                    ix.a().a(new in.ah(networkData.post.post_id, false, null));
                }
                if (CreatePostActivity.this.photoHelper != null) {
                    post.localBitmapPath = CreatePostActivity.this.photoHelper.a;
                }
                ix.a().a(new in.k(post));
                new Handler().postDelayed(new Runnable(){

                    public void run() {
                        CreatePostActivity.this.postSpinny.setVisibility(8);
                        CreatePostActivity.this.mRootView.setAlpha(1.0f);
                    }
                }, 500);
                Intent intent = new Intent();
                intent.putExtra("json", DataUtil.toJson(post));
                CreatePostActivity.this.setResult(-1, intent);
                Intent intent2 = new Intent(CreatePostActivity.this.getBaseContext(), (Class)InviteContactsActivity.class);
                intent2.putExtra("post", DataUtil.toJson(post));
                intent2.putExtra("link_image_path", CreatePostActivity.this.u);
                CreatePostActivity.this.startActivity(intent2);
                CreatePostActivity.this.finish();
            }

        };
    }

    private void e() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)this.postPhoto.getLayoutParams();
        layoutParams.width = (int)((float)this.photoHelper.d / (float)this.photoHelper.e * (float)layoutParams.height);
        this.postPhoto.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    }

    private double f() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int n2 = displayMetrics.widthPixels;
        int n3 = displayMetrics.heightPixels;
        double d2 = (double)n2 / (double)displayMetrics.xdpi;
        double d3 = (double)n3 / (double)displayMetrics.ydpi;
        return Math.sqrt((double)(Math.pow((double)d2, (double)2.0) + Math.pow((double)d3, (double)2.0)));
    }

    void a(Intent intent) {
        String string2 = intent.getStringExtra("android.intent.extra.TEXT");
        if (string2 != null) {
            this.s = false;
            this.postCaption.setText((CharSequence)string2);
        }
    }

    void b(Intent intent) {
        Uri uri = (Uri)intent.getParcelableExtra("android.intent.extra.STREAM");
        try {
            if (this.photoHelper == null) {
                this.photoHelper = this.getPhotoHelper();
            }
            File file = this.photoHelper.a(uri);
            String string2 = file.getAbsolutePath();
            Uri uri2 = Uri.fromFile((File)file);
            this.photoHelper.a(string2, uri2, 902);
            return;
        }
        catch (Exception var3_6) {
            var3_6.printStackTrace();
            return;
        }
    }

    @Override
    public void backNavClick(View view) {
        this.onBackPressed();
    }

    @OnClick(value={2131624126})
    public void chooseLink(ImageView imageView) {
        Log.d((String)"CPA", (String)"add a link");
        this.startActivityForResult(new Intent((Context)this, (Class)AddLinkActivity.class), 1002);
    }

    public void choosePhoto() {
        this.getPhotoHelper().choosePhoto();
    }

    @OnClick(value={2131624111})
    public void clearChosenGroup(View view) {
        super.a((Group)null);
    }

    @OnClick(value={2131624123})
    public void clearLink(ImageView imageView) {
        this.linkContainer.setVisibility(8);
        this.r = null;
    }

    public void clearPhoto(View view) {
        this.c = null;
        this.d = false;
        this.postPhoto.setImageBitmap(null);
        this.findViewById(2131624116).setVisibility(8);
        this.updatePostButton();
    }

    public void createGroupClick(View view) {
        Log.d((String)"CPA", (String)"Create group?");
        Intent intent = new Intent((Context)this, (Class)CreateGroupActivity.class);
        intent.putExtra("for_post", true);
        this.startActivityForResult(intent, 1001);
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

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void onNext(in.ak ak2) {
                if (ak2.b) {
                    if (!CreatePostActivity.this.d) {
                        return;
                    }
                    CreatePostActivity.this.d = false;
                    CreatePostActivity.this.c = ak2.a.full_url;
                    CreatePostActivity.this.postPhoto.setAlpha(1.0f);
                } else {
                    CreatePostActivity.this.clearPhoto(null);
                    Toast.makeText((Context)CreatePostActivity.this, (CharSequence)CreatePostActivity.this.getString(2131230940), (int)0).show();
                }
                CreatePostActivity.this.updatePostButton();
            }
        }));
    }

    @Override
    protected void keyboardOpened() {
        super.keyboardOpened();
        this.groupNameSelector.setDropDownHeight(this.postContent.getHeight());
        if (this.groupNameSelector.isFocused()) {
            this.groupNameSelector.showDropDown();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    protected void onActivityResult(int n2, int n3, Intent intent) {
        super.onActivityResult(n2, n3, intent);
        if (n2 == 1001) {
            if (n3 != -1) return;
            {
                super.a((Group)intent.getSerializableExtra("group"));
                return;
            }
        } else if (n2 == 1002) {
            if (intent == null || !intent.hasExtra("link_info")) return;
            {
                Map map;
                try {
                    map = (Map)intent.getSerializableExtra("link_info");
                }
                catch (ClassCastException var5_5) {
                    var5_5.printStackTrace();
                    return;
                }
                super.a(map);
                return;
            }
        } else {
            if (n2 != 1003 && n2 != 1004) return;
            {
                super.a();
                this.groupNameSelector.requestFocus();
                this.openKeyboard();
                return;
            }
        }
    }

    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("json", "{\"cancelled\": 1}");
        this.setResult(0, intent);
        super.onBackPressed();
    }

    /*
     * Enabled aggressive block sorting
     */
    public void onClick(View view) {
        if (view.getId() == 2131624125) {
            this.choosePhoto();
            return;
        } else {
            if (view.getId() != 2131624127) return;
            {
                this.startActivity(new Intent((Context)this, (Class)LinkSearchActivity.class));
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.e = 0;
        if (super.f() > 4.5) {
            this.setContentView(2130968607);
        } else {
            this.setContentView(2130968608);
        }
        ButterKnife.bind((Activity)this);
        this.enableKeyboardEvents(this.mRootView);
        this.camBtn.setOnClickListener((View.OnClickListener)this);
        this.webSearchBtn.setOnClickListener((View.OnClickListener)this);
        super.b();
        this.groupNameSelector.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            public void onItemClick(AdapterView<?> adapterView, View view, int n2, long l2) {
                if (adapterView != null) {
                    Group group = (Group)adapterView.getItemAtPosition(n2);
                    CreatePostActivity.this.a(CreatePostActivity.this.b(group.group_name));
                }
            }
        });
        this.groupNameSelector.setOnFocusChangeListener(new View.OnFocusChangeListener(){

            public void onFocusChange(View view, boolean bl2) {
                if (view.getWindowVisibility() != 0) {
                    return;
                }
                if (bl2) {
                    CreatePostActivity.this.groupNameSelector.showDropDown();
                    return;
                }
                CreatePostActivity.this.groupNameSelector.dismissDropDown();
            }
        });
        this.groupNameSelector.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                CreatePostActivity.this.groupNameSelector.showDropDown();
            }
        });
        this.groupNameSelector.setOnEditorActionListener(new TextView.OnEditorActionListener(){

            public boolean onEditorAction(TextView textView, int n2, KeyEvent keyEvent) {
                Log.d((String)"CPA", (String)("group action: " + n2));
                if (n2 == 5 || keyEvent != null && keyEvent.getAction() == 1 && keyEvent.getKeyCode() == 66) {
                    Group group = CreatePostActivity.this.a(CreatePostActivity.this.groupNameSelector.getText().toString());
                    if (group != null) {
                        CreatePostActivity.this.a(group);
                    }
                    return true;
                }
                return false;
            }
        });
        this.groupNameSelector.addTextChangedListener(new TextWatcher(){

            public void afterTextChanged(Editable editable) {
                ArrayList<Group> arrayList;
                Group group;
                String string2 = editable.toString();
                if (CreatePostActivity.this.i != null && (arrayList = CreatePostActivity.this.i.a(string2)).size() == 1 && (group = (Group)arrayList.get(0)) != null) {
                    CreatePostActivity.this.a(group);
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
            }

            public void onTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
            }
        });
        float f2 = this.getResources().getDisplayMetrics().density;
        this.groupNameSelector.setDropDownHeight((int)(140.0f * f2));
        this.groupNameSelector.setDropDownVerticalOffset((int)(-11.0f * f2));
        if (this.getIntent().hasExtra("group_name") && this.getIntent().hasExtra("group_id")) {
            int n2 = this.getIntent().getIntExtra("group_id", 0);
            try {
                for (Group group : AppState.groups) {
                    if (group.group_id != n2) continue;
                    super.a(group);
                }
            }
            catch (NullPointerException var8_6) {
                rj.a((Throwable)new Exception("groups ARE NULL: " + AppState.groups));
            }
        }
        this.j = AppState.config.getInt("disable_group_tagging", 0);
        this.k = new ArrayList();
        if (AppState.groups == null) {
            AppState.groups = new ArrayList();
        }
        this.m = new hg((Context)this, 2130968690, (List<Group>)new ArrayList(AppState.groups));
        this.l = new ListPopupWindow((Context)this);
        this.l.setAdapter((ListAdapter)this.m);
        this.l.setAnchorView((View)this.postCaption);
        this.l.setAnimationStyle(0);
        this.l.setHeight(-2);
        this.l.setWidth(jb.a(150, (Context)this));
        this.l.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            /*
             * Enabled aggressive block sorting
             */
            public void onItemClick(AdapterView<?> adapterView, View view, int n2, long l2) {
                Group group = (Group)adapterView.getItemAtPosition(n2);
                String[] arrstring = CreatePostActivity.this.postCaption.getText().toString().split("(?=#)");
                int n3 = CreatePostActivity.this.postCaption.getSelectionStart();
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
                for (TextTag textTag : CreatePostActivity.this.k) {
                    if (n3 > textTag.startIndex && n3 <= textTag.endIndex) continue;
                    if (textTag.startIndex > n3) {
                        textTag.startIndex = n6 + textTag.startIndex;
                        textTag.endIndex = n6 + textTag.endIndex;
                    }
                    arrayList.add((Object)textTag);
                }
                CreatePostActivity.this.k = arrayList;
                Iterator iterator = CreatePostActivity.this.k.iterator();
                do {
                    if (!iterator.hasNext()) {
                        CreatePostActivity.this.n = (CharSequence)spannableStringBuilder;
                        CreatePostActivity.this.postCaption.setText((CharSequence)spannableStringBuilder);
                        CreatePostActivity.this.postCaption.setSelection(n5 + 1);
                        CreatePostActivity.this.l.dismiss();
                        return;
                    }
                    TextTag textTag2 = (TextTag)iterator.next();
                    if (textTag2.startIndex <= -1 || textTag2.endIndex <= -1) continue;
                    spannableStringBuilder.setSpan((Object)jb.a(), textTag2.startIndex, textTag2.endIndex, 33);
                } while (true);
            }
        });
        this.postCaption.setOnFocusChangeListener(new View.OnFocusChangeListener(){

            public void onFocusChange(View view, boolean bl2) {
                if (bl2 && CreatePostActivity.this.j == 0) {
                    jb.a((CharSequence)CreatePostActivity.this.postCaption.getText(), CreatePostActivity.this.postCaption, CreatePostActivity.this.l, CreatePostActivity.this.m);
                }
            }
        });
        this.postCaption.addTextChangedListener(new TextWatcher(){

            public void afterTextChanged(Editable editable) {
                if (CreatePostActivity.this.j == 0 && !editable.toString().equals((Object)CreatePostActivity.this.n.toString())) {
                    CreatePostActivity.this.n = (CharSequence)editable.toString();
                    jb.a((CharSequence)editable, CreatePostActivity.this.postCaption, CreatePostActivity.this.l, CreatePostActivity.this.m);
                    if (CreatePostActivity.this.q) {
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder((CharSequence)editable.toString());
                        for (TextTag textTag : CreatePostActivity.this.k) {
                            if (textTag.startIndex <= -1 || textTag.endIndex <= -1) continue;
                            spannableStringBuilder.setSpan((Object)jb.a(), textTag.startIndex, textTag.endIndex, 33);
                        }
                        CreatePostActivity.this.q = false;
                        CreatePostActivity.this.n = (CharSequence)spannableStringBuilder.toString();
                        int n2 = CreatePostActivity.this.postCaption.getSelectionStart();
                        CreatePostActivity.this.postCaption.setText((CharSequence)spannableStringBuilder);
                        CreatePostActivity.this.postCaption.setSelection(n2);
                    }
                }
                if (!CreatePostActivity.this.s) {
                    CreatePostActivity.this.c();
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
                CreatePostActivity.this.o = CreatePostActivity.this.postCaption.getSelectionStart();
                CreatePostActivity.this.p = CreatePostActivity.this.postCaption.getSelectionEnd();
            }

            public void onTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
                if (CreatePostActivity.this.j == 0 && !charSequence.toString().equals((Object)CreatePostActivity.this.n.toString())) {
                    int n5 = CreatePostActivity.this.postCaption.getSelectionStart();
                    ArrayList arrayList = new ArrayList();
                    for (TextTag textTag : CreatePostActivity.this.k) {
                        if (CreatePostActivity.this.o <= textTag.startIndex && CreatePostActivity.this.p <= textTag.startIndex) {
                            textTag.startIndex += n4 - n3;
                            textTag.endIndex += n4 - n3;
                            arrayList.add((Object)textTag);
                            CreatePostActivity.this.q = true;
                            continue;
                        }
                        if (CreatePostActivity.this.o <= textTag.startIndex && CreatePostActivity.this.p > textTag.startIndex) {
                            CreatePostActivity.this.q = true;
                            continue;
                        }
                        if (CreatePostActivity.this.o > textTag.startIndex && CreatePostActivity.this.o <= textTag.endIndex) {
                            CreatePostActivity.this.q = true;
                            continue;
                        }
                        if (n5 > textTag.endIndex) {
                            arrayList.add((Object)textTag);
                            continue;
                        }
                        CreatePostActivity.this.q = true;
                    }
                    CreatePostActivity.this.k = arrayList;
                }
            }
        });
        super.a();
        this.friendMarker.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                CreatePostActivity.this.friendSwitch.toggle();
            }
        });
        this.friendSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

            public void onCheckedChanged(CompoundButton compoundButton, boolean bl2) {
                CreatePostActivity.this.f = bl2;
                CreatePostActivity.this.a(CreatePostActivity.this.f);
            }
        });
        this.g = new Handler(this.getMainLooper());
        this.mRootView.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                CreatePostActivity.this.enableKeyboardEvents(CreatePostActivity.this.mRootView);
            }
        });
        if (!AppState.hasPosted) {
            this.friendSwitch.setVisibility(0);
            this.friendMarker.setVisibility(0);
            this.startActivityForResult(new Intent((Context)this, (Class)TutorialPostActivity.class), 1003);
        } else if (!AppState.hasLinkSearched) {
            this.startActivityForResult(new Intent((Context)this, (Class)TutorialLinkSearchActivity.class), 1004);
        }
        Intent intent = this.getIntent();
        String string2 = intent.getAction();
        String string3 = intent.getType();
        this.addToSubscriptionList(ix.a().a(in.y.class, new apr<in.y>(){

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
            }

            @Override
            public void onNext(in.y y2) {
                if (CreatePostActivity.this.photoHelper != null && CreatePostActivity.this.photoHelper.f != null && CreatePostActivity.this.photoHelper.b != null && CreatePostActivity.this.photoHelper.a != null) {
                    CreatePostActivity.this.postPhoto.setImageBitmap(CreatePostActivity.this.photoHelper.f);
                    if (CreatePostActivity.this.photoHelper.d > 0 && CreatePostActivity.this.photoHelper.e > 0) {
                        CreatePostActivity.this.e();
                    }
                    CreatePostActivity.this.findViewById(2131624116).setVisibility(0);
                    CreatePostActivity.this.postPhoto.setAlpha(0.3f);
                    CreatePostActivity.this.imageCaptured();
                }
            }
        }));
        this.busSubscribe(in.z.class, new apr<in.z>(){

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
            }

            @Override
            public void onNext(in.z z2) {
                String string2 = z2.a;
                CreatePostActivity.this.s = false;
                CreatePostActivity.this.postCaption.setText((CharSequence)string2);
            }
        });
        if (!"android.intent.action.SEND".equals((Object)string2) || string3 == null) return;
        {
            if ("text/plain".equals((Object)string3)) {
                this.a(intent);
                return;
            } else {
                if (!string3.startsWith("image/")) return;
                {
                    this.b(intent);
                    return;
                }
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    /*
     * Enabled aggressive block sorting
     */
    public void savePost(View view) {
        String string2;
        if (this.e == 0) {
            new AlertDialog.Builder((Context)this).setTitle((CharSequence)"Please select a group").setPositiveButton(2131230895, null).create().show();
            return;
        }
        if (this.d) return;
        {
            string2 = this.postCaption.getText().toString().trim();
            if (string2.length() <= 0 && this.c == null && this.r == null) {
                new AlertDialog.Builder((Context)this).setTitle((CharSequence)"Blank posts are not allowed").setPositiveButton(2131230895, null).create().show();
                return;
            }
        }
        this.mRootView.setAlpha(0.3f);
        this.postSpinny.setVisibility(0);
        Post post = new Post();
        post.group_id = this.e;
        if (!this.f) {
            post.friends_disabled = 1;
        }
        if (string2.length() > 0) {
            int n2 = this.postCaption.getText().toString().length();
            DataUtil.StringTrimResult stringTrimResult = DataUtil.trimWithCount(this.postCaption.getText().toString());
            if (stringTrimResult.string.length() > 0) {
                post.caption = stringTrimResult.string;
            }
            if (!this.k.isEmpty()) {
                String string3 = "";
                for (TextTag textTag : this.k) {
                    int n3 = n2 - 1 - textTag.endIndex;
                    textTag.startIndex -= stringTrimResult.trimmedStart;
                    textTag.endIndex -= stringTrimResult.trimmedStart;
                    if (stringTrimResult.trimmedEnd >= n3) {
                        textTag.endIndex = stringTrimResult.string.length();
                    }
                    string3 = string3 + textTag.toString() + ";";
                }
                post.mentioned_groups_info = string3.substring(0, -1 + string3.length());
            }
        }
        if (this.c != null) {
            post.source_url = this.c;
            if (this.photoHelper != null) {
                post.width = this.photoHelper.d;
                post.height = this.photoHelper.e;
                post.image_hash = this.photoHelper.c;
            }
        }
        super.a(post, this.r);
    }

    public void updatePostButton() {
        String string2 = this.postCaption.getText().toString().trim();
        if (this.e != 0 && (string2.length() > 0 || this.c != null || this.r != null)) {
            this.postButton.setSelected(true);
            if (this.d) {
                this.postButton.setSelected(false);
            }
            return;
        }
        this.postButton.setSelected(false);
    }

}

