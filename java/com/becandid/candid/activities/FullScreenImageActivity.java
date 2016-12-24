/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.app.Activity
 *  android.content.ContentResolver
 *  android.content.ContentValues
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.Color
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Environment
 *  android.provider.MediaStore
 *  android.provider.MediaStore$Images
 *  android.provider.MediaStore$Images$Media
 *  android.support.v4.app.ActivityCompat
 *  android.support.v4.app.FragmentActivity
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewPropertyAnimator
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.PopupMenu
 *  android.widget.PopupMenu$OnMenuItemClickListener
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.TextView
 *  android.widget.Toast
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  com.bumptech.glide.load.engine.DiskCacheStrategy
 *  java.io.File
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.text.SimpleDateFormat
 *  java.util.Date
 *  rx.schedulers.Schedulers
 */
package com.becandid.candid.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.activities.InviteContactsActivity;
import com.becandid.candid.activities.PostDetailsActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Config;
import com.becandid.candid.data.EmptyClass;
import com.becandid.candid.data.Post;
import com.becandid.candid.data.UpdatePost;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import rx.schedulers.Schedulers;

public class FullScreenImageActivity
extends BaseActivity {
    private String b;
    private int c;
    @BindView(value=2131624156)
    RelativeLayout commentContainer;
    @BindView(value=2131624158)
    TextView commentCount;
    @BindView(value=2131624132)
    RelativeLayout container;
    private int d;
    @BindView(value=2131624150)
    RelativeLayout dislikeContainer;
    @BindView(value=2131624154)
    TextView dislikeCount;
    @BindView(value=2131624151)
    ImageView dislikeIcon;
    private int e;
    private int f;
    @BindView(value=2131624155)
    TextView falseCount;
    @BindView(value=2131624152)
    ImageView falseIcon;
    @BindView(value=2131624136)
    View fullscreenDownload;
    @BindView(value=2131624135)
    View fullscreenExit;
    @BindView(value=2131624138)
    RelativeLayout fullscreenFooter;
    @BindView(value=2131624137)
    FrameLayout fullscreenGradient;
    @BindView(value=2131624134)
    RelativeLayout fullscreenHeader;
    @BindView(value=2131624133)
    ImageView fullscreenImage;
    @BindView(value=2131624161)
    LinearLayout fullscreenSpinny;
    private int g;
    private int h;
    private boolean i = true;
    private boolean j;
    private String k;
    private String l;
    @BindView(value=2131624144)
    RelativeLayout likeContainer;
    @BindView(value=2131624148)
    TextView likeCount;
    @BindView(value=2131624145)
    ImageView likeIcon;
    private Activity m;
    private boolean n;
    private oh o;
    @BindView(value=2131624160)
    TextView replyContainer;
    @BindView(value=2131624159)
    TextView shareContainer;
    @BindView(value=2131624149)
    TextView trueCount;
    @BindView(value=2131624146)
    ImageView trueIcon;
    @BindView(value=2131624140)
    TextView userIcon;
    @BindView(value=2131624142)
    TextView userName;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a() {
        if (this.o instanceof ny) {
            Bitmap bitmap = ((ny)this.o).b();
            File file = new File((Object)Environment.getExternalStorageDirectory() + File.separator + Environment.DIRECTORY_PICTURES + File.separator + "Candid" + File.separator);
            if (!file.exists()) {
                file.mkdir();
            }
            String string2 = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File file2 = new File(file, string2 + ".png");
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                ContentValues contentValues = new ContentValues();
                contentValues.put("mime_type", "image/png");
                contentValues.put("date_added", Long.valueOf((long)System.currentTimeMillis()));
                contentValues.put("datetaken", Long.valueOf((long)System.currentTimeMillis()));
                contentValues.put("_data", file2.toString());
                this.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                Toast.makeText((Context)this.getApplicationContext(), (CharSequence)"Image saved", (int)0).show();
                return;
            }
            catch (Exception var15_7) {
                Toast.makeText((Context)this.getApplicationContext(), (CharSequence)"An error occured. Please try again later.", (int)0).show();
                return;
            }
        }
        if (!(this.o instanceof on)) return;
        on on2 = (on)this.o;
        File file = new File((Object)Environment.getExternalStorageDirectory() + File.separator + Environment.DIRECTORY_PICTURES + File.separator + "Candid" + File.separator);
        if (!file.exists()) {
            file.mkdir();
        }
        String string3 = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File file3 = new File(file, string3 + ".gif");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file3);
            fileOutputStream.write(on2.d());
            fileOutputStream.flush();
            fileOutputStream.close();
            ContentValues contentValues = new ContentValues();
            contentValues.put("mime_type", "image/gif");
            contentValues.put("date_added", Long.valueOf((long)System.currentTimeMillis()));
            contentValues.put("datetaken", Long.valueOf((long)System.currentTimeMillis()));
            contentValues.put("_data", file3.toString());
            this.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
            Toast.makeText((Context)this.getApplicationContext(), (CharSequence)"Image saved", (int)0).show();
            return;
        }
        catch (IOException var6_14) {
            Toast.makeText((Context)this.getApplicationContext(), (CharSequence)"An error occured. Please try again later.", (int)0).show();
            return;
        }
    }

    private void a(int n2, int n3, int n4) {
        ik.a().b(Integer.toString((int)n2), Integer.toString((int)n3), Integer.toString((int)n4)).b(Schedulers.io()).b(new apr<Post>(){

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
            }

            @Override
            public void onNext(Post post) {
                ix.a().a(new in.q(post));
            }
        });
    }

    private void a(ImageView imageView, int n2, TextView textView, boolean bl2) {
        if (bl2) {
            imageView.setColorFilter(Color.parseColor((String)"#FF0000"));
            textView.setText((CharSequence)("True " + Integer.toString((int)(n2 + 1))));
            return;
        }
        imageView.clearColorFilter();
        textView.setText((CharSequence)("True " + Integer.toString((int)(n2 - 1))));
    }

    private void a(in.q q2) {
        this.f = q2.e;
        this.g = q2.f;
        super.b();
    }

    private void b() {
        this.trueCount.setText((CharSequence)("True " + Integer.toString((int)this.f)));
        this.falseCount.setText((CharSequence)("False " + Integer.toString((int)this.g)));
    }

    private void b(ImageView imageView, int n2, TextView textView, boolean bl2) {
        if (bl2) {
            imageView.setColorFilter(Color.parseColor((String)"#FF0000"));
            textView.setText((CharSequence)("False " + Integer.toString((int)(n2 + 1))));
            return;
        }
        imageView.clearColorFilter();
        textView.setText((CharSequence)("False " + Integer.toString((int)(n2 - 1))));
    }

    public void disableLikes() {
        this.likeContainer.setEnabled(false);
        this.dislikeContainer.setEnabled(false);
    }

    public void enableLikes() {
        this.likeContainer.setEnabled(true);
        this.dislikeContainer.setEnabled(true);
    }

    public void fadeIn() {
        this.fullscreenHeader.animate().setDuration(200).alpha(1.0f).setListener((Animator.AnimatorListener)new AnimatorListenerAdapter(){

            public void onAnimationStart(Animator animator) {
                super.onAnimationEnd(animator);
                FullScreenImageActivity.this.fullscreenHeader.setVisibility(0);
            }
        });
        if (!this.n) {
            this.fullscreenFooter.animate().setDuration(200).alpha(1.0f).setListener((Animator.AnimatorListener)new AnimatorListenerAdapter(){

                public void onAnimationStart(Animator animator) {
                    super.onAnimationEnd(animator);
                    FullScreenImageActivity.this.fullscreenFooter.setVisibility(0);
                }
            });
            this.fullscreenGradient.animate().setDuration(200).alpha(1.0f).setListener((Animator.AnimatorListener)new AnimatorListenerAdapter(){

                public void onAnimationStart(Animator animator) {
                    super.onAnimationEnd(animator);
                    FullScreenImageActivity.this.fullscreenGradient.setVisibility(0);
                }
            });
        }
    }

    public void fadeOut() {
        this.fullscreenHeader.animate().setDuration(200).alpha(0.0f).setListener((Animator.AnimatorListener)new AnimatorListenerAdapter(){

            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                FullScreenImageActivity.this.fullscreenHeader.setVisibility(8);
            }
        });
        if (!this.n) {
            this.fullscreenFooter.animate().setDuration(200).alpha(0.0f).setListener((Animator.AnimatorListener)new AnimatorListenerAdapter(){

                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    FullScreenImageActivity.this.fullscreenFooter.setVisibility(8);
                }
            });
            this.fullscreenGradient.animate().setDuration(200).alpha(0.0f).setListener((Animator.AnimatorListener)new AnimatorListenerAdapter(){

                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    FullScreenImageActivity.this.fullscreenGradient.setVisibility(8);
                }
            });
        }
    }

    public void onBackPressed() {
        this.setResult(198, new Intent());
        super.onBackPressed();
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130968609);
        ButterKnife.bind((Activity)this);
        final Bundle bundle2 = this.getIntent().getExtras();
        if (bundle2.containsKey("source_url")) {
            this.b = bundle2.getString("source_url");
        } else {
            Toast.makeText((Context)this, (CharSequence)"Error finding image url", (int)1).show();
            this.finish();
        }
        if (bundle2.containsKey("post_id")) {
            this.setupPost(bundle2);
            this.subscribeToUpdates("post");
        } else if (bundle2.containsKey("comment_id")) {
            this.setupComment(bundle2);
            this.subscribeToUpdates("comment");
        } else {
            this.fullscreenGradient.setVisibility(8);
            this.fullscreenFooter.setVisibility(8);
            this.n = true;
        }
        final int n2 = this.getResources().getDisplayMetrics().heightPixels;
        jx.a((FragmentActivity)this).a(this.b).b().a((String)DiskCacheStrategy.c).a(new qf<String, oh>(){

            @Override
            public boolean onException(Exception exception, String string2, qy<oh> qy2, boolean bl2) {
                rj.a((Throwable)exception);
                FullScreenImageActivity.this.fullscreenSpinny.setVisibility(8);
                FullScreenImageActivity.this.fullscreenImage.setVisibility(0);
                return false;
            }

            @Override
            public boolean onResourceReady(oh oh2, String string2, qy<oh> qy2, boolean bl2, boolean bl3) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                FullScreenImageActivity.this.fullscreenImage.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, n2 / 5);
                layoutParams2.addRule(12);
                FullScreenImageActivity.this.fullscreenGradient.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
                FullScreenImageActivity.this.fullscreenSpinny.setVisibility(8);
                FullScreenImageActivity.this.fullscreenImage.setVisibility(0);
                if (!FullScreenImageActivity.this.n) {
                    FullScreenImageActivity.this.setupFooterShared(bundle2);
                }
                FullScreenImageActivity.this.o = oh2;
                return false;
            }
        }).a(this.fullscreenImage);
        new atc(this.fullscreenImage).a(new atc.d(){

            @Override
            public void onOutsidePhotoTap() {
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void onPhotoTap(View view, float f2, float f3) {
                if (FullScreenImageActivity.this.j) {
                    FullScreenImageActivity.this.fadeIn();
                } else {
                    FullScreenImageActivity.this.fadeOut();
                }
                FullScreenImageActivity fullScreenImageActivity = FullScreenImageActivity.this;
                boolean bl2 = !FullScreenImageActivity.this.j;
                fullScreenImageActivity.j = bl2;
            }
        });
        this.fullscreenDownload.setOnClickListener(new View.OnClickListener((Activity)this){
            final /* synthetic */ Activity a;

            public void onClick(View view) {
                if (bb.checkSelfPermission((Context)this.a, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                    ActivityCompat.requestPermissions((Activity)this.a, (String[])new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, (int)1104);
                    return;
                }
                FullScreenImageActivity.this.a();
            }
        });
        this.fullscreenExit.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                FullScreenImageActivity.this.onBackPressed();
            }
        });
        this.addToSubscriptionList(ix.a().a(in.q.class, new apr<in.q>(){

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
            }

            @Override
            public void onNext(in.q q2) {
                FullScreenImageActivity.this.a(q2);
            }
        }));
        this.m = this;
    }

    @Override
    public void onRequestPermissionsResult(int n2, String[] arrstring, int[] arrn) {
        super.onRequestPermissionsResult(n2, arrstring, arrn);
        if (n2 == 1104 && arrn.length > 0 && arrn[0] == 0) {
            super.a();
        }
    }

    public void setupComment(Bundle bundle) {
        final int n2 = bundle.getInt("comment_id");
        this.commentContainer.setVisibility(8);
        this.shareContainer.setVisibility(8);
        this.replyContainer.setVisibility(8);
        this.likeContainer.setOnClickListener(new View.OnClickListener(){

            /*
             * Enabled aggressive block sorting
             */
            public void onClick(View view) {
                int n22;
                int n3;
                FullScreenImageActivity.this.disableLikes();
                FullScreenImageActivity.this.c;
                int n4 = FullScreenImageActivity.this.d;
                if (FullScreenImageActivity.this.likeIcon.isSelected()) {
                    n22 = 0;
                    n3 = -1 + FullScreenImageActivity.this.c;
                } else {
                    n22 = 1;
                    n3 = 1 + FullScreenImageActivity.this.c;
                    if (FullScreenImageActivity.this.dislikeIcon.isSelected()) {
                        n4 = -1 + FullScreenImageActivity.this.d;
                    }
                }
                final in.aq aq2 = new in.aq(n2, n22, n3, n4);
                ik.a().a(n2, n22).b(Schedulers.io()).a(apv.a()).b(new apr<EmptyClass>(){

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        rj.a(throwable);
                        Log.d((String)"LikeComment", (String)throwable.toString());
                        FullScreenImageActivity.this.enableLikes();
                    }

                    @Override
                    public void onNext(EmptyClass emptyClass) {
                        ix.a().a(aq2);
                        FullScreenImageActivity.this.enableLikes();
                    }
                });
            }

        });
        this.dislikeContainer.setOnClickListener(new View.OnClickListener(){

            /*
             * Enabled aggressive block sorting
             */
            public void onClick(View view) {
                int n22;
                int n3;
                FullScreenImageActivity.this.disableLikes();
                int n4 = FullScreenImageActivity.this.c;
                FullScreenImageActivity.this.d;
                if (FullScreenImageActivity.this.dislikeIcon.isSelected()) {
                    n22 = 0;
                    n3 = -1 + FullScreenImageActivity.this.d;
                } else {
                    n22 = -1;
                    n3 = 1 + FullScreenImageActivity.this.d;
                    if (FullScreenImageActivity.this.likeIcon.isSelected()) {
                        n4 = -1 + FullScreenImageActivity.this.c;
                    }
                }
                final in.aq aq2 = new in.aq(n2, n22, n4, n3);
                ik.a().a(n2, n22).b(Schedulers.io()).a(apv.a()).b(new apr<EmptyClass>(){

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        rj.a(throwable);
                        Log.d((String)"LikeComment", (String)throwable.toString());
                        FullScreenImageActivity.this.enableLikes();
                    }

                    @Override
                    public void onNext(EmptyClass emptyClass) {
                        ix.a().a(aq2);
                        FullScreenImageActivity.this.enableLikes();
                    }
                });
            }

        });
    }

    /*
     * Enabled aggressive block sorting
     */
    public void setupFooterShared(Bundle bundle) {
        String string2 = bundle.getString("user_name");
        String string3 = bundle.getString("icon_name");
        String string4 = bundle.getString("icon_color");
        String string5 = this.i ? jb.a(string4, 0.3f) : jb.a(string4, 0.7f);
        int n2 = Color.parseColor((String)string5);
        this.userName.setText((CharSequence)string2);
        this.userName.setTextColor(n2);
        TextView textView = this.userIcon;
        io.a();
        textView.setTypeface(io.b());
        this.userIcon.setText((CharSequence)io.a(string3));
        this.userIcon.setTextColor(n2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        int n3 = this.userIcon.getWidth();
        if (n3 == 0) {
            n3 = (int)(30.0f * this.userIcon.getResources().getDisplayMetrics().density);
        }
        gradientDrawable.setColor(1073741824 | 16777215 & n2);
        gradientDrawable.setCornerRadius((float)(n3 / 2));
        this.userIcon.setBackground((Drawable)gradientDrawable);
        this.c = bundle.getInt("num_likes", 0);
        this.d = bundle.getInt("num_dislikes", 0);
        this.e = bundle.getInt("like_value", 0);
        this.f = bundle.getInt("num_true", 0);
        this.g = bundle.getInt("num_false", 0);
        this.h = bundle.getInt("opinion_value", 0);
        if (bundle.getInt("is_rumor", 0) == 1) {
            this.likeIcon.setVisibility(8);
            this.dislikeIcon.setVisibility(8);
            this.trueIcon.setVisibility(0);
            this.falseIcon.setVisibility(0);
            int n4 = Color.parseColor((String)"#FF0000");
            if (this.h == 1) {
                this.trueIcon.setColorFilter(n4);
            } else if (this.h == -1) {
                this.falseIcon.setColorFilter(n4);
            }
            this.trueCount.setText((CharSequence)("True " + Integer.toString((int)this.f)));
            this.falseCount.setText((CharSequence)("False " + Integer.toString((int)this.g)));
            return;
        }
        if (this.e == 1) {
            this.likeIcon.setSelected(true);
        } else if (this.e == -1) {
            this.dislikeIcon.setSelected(true);
        }
        this.likeCount.setText((CharSequence)Integer.toString((int)this.c));
        this.dislikeCount.setText((CharSequence)Integer.toString((int)this.d));
    }

    /*
     * Enabled aggressive block sorting
     */
    public void setupPost(final Bundle bundle) {
        final int n2 = bundle.getInt("post_id");
        int n3 = bundle.getInt("num_comments", 0);
        final int n4 = bundle.getInt("is_rumor", 0);
        if (n4 == 1) {
            this.likeIcon.setVisibility(8);
            this.dislikeIcon.setVisibility(8);
            this.trueIcon.setVisibility(0);
            this.falseIcon.setVisibility(0);
            this.commentContainer.setVisibility(8);
        } else {
            this.commentCount.setText((CharSequence)Integer.toString((int)n3));
            this.commentContainer.setVisibility(0);
        }
        this.k = bundle.getString("share_info_url", null);
        this.l = bundle.getString("share_info_image", null);
        if (this.l != null && this.k != null) {
            this.shareContainer.setOnClickListener(new View.OnClickListener(){

                public void onClick(View view) {
                    Context context = view.getContext();
                    if (AppState.config.getInt("enable_share_post", 0) == 1) {
                        PopupMenu popupMenu = new PopupMenu(context, view);
                        popupMenu.getMenuInflater().inflate(2131689482, popupMenu.getMenu());
                        popupMenu.show();
                        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){

                            public boolean onMenuItemClick(MenuItem menuItem) {
                                switch (menuItem.getItemId()) {
                                    default: {
                                        return false;
                                    }
                                    case 2131624865: {
                                        iy.b((Context)FullScreenImageActivity.this.m, FullScreenImageActivity.this.k, FullScreenImageActivity.this.l);
                                        return true;
                                    }
                                    case 2131624866: {
                                        iy.b((Context)FullScreenImageActivity.this.m, FullScreenImageActivity.this.k, FullScreenImageActivity.this.l);
                                        return true;
                                    }
                                    case 2131624867: {
                                        Intent intent = new Intent((Context)FullScreenImageActivity.this.m, (Class)InviteContactsActivity.class);
                                        intent.putExtra("invite_type", InviteContactsActivity.InviteFlowTypes.POST.toString());
                                        FullScreenImageActivity.this.m.startActivity(intent);
                                        return true;
                                    }
                                    case 2131624868: 
                                }
                                iy.a((Context)FullScreenImageActivity.this.m, FullScreenImageActivity.this.k, "Share Link");
                                return true;
                            }
                        });
                        return;
                    }
                    Toast.makeText((Context)context, (CharSequence)"Sharing is not available", (int)0).show();
                }

            });
        }
        this.replyContainer.setVisibility(8);
        this.likeContainer.setOnClickListener(new View.OnClickListener(){

            /*
             * Enabled aggressive block sorting
             */
            public void onClick(View view) {
                int n22;
                if (n4 == 1) {
                    if (FullScreenImageActivity.this.h == 1) {
                        FullScreenImageActivity.this.a(FullScreenImageActivity.this.trueIcon, FullScreenImageActivity.this.f, FullScreenImageActivity.this.trueCount, false);
                        FullScreenImageActivity.this.h = 0;
                    } else {
                        if (FullScreenImageActivity.this.h == -1) {
                            FullScreenImageActivity.this.b(FullScreenImageActivity.this.falseIcon, FullScreenImageActivity.this.g, FullScreenImageActivity.this.falseCount, false);
                        }
                        FullScreenImageActivity.this.a(FullScreenImageActivity.this.trueIcon, FullScreenImageActivity.this.f, FullScreenImageActivity.this.trueCount, true);
                        FullScreenImageActivity.this.h = 1;
                    }
                    FullScreenImageActivity.this.a(n2, FullScreenImageActivity.this.h, 1);
                    return;
                }
                FullScreenImageActivity.this.disableLikes();
                final UpdatePost updatePost = new UpdatePost();
                updatePost.post_id = n2;
                updatePost.updates.num_likes = FullScreenImageActivity.this.c;
                updatePost.updates.num_dislikes = FullScreenImageActivity.this.d;
                updatePost.updates.like_value = FullScreenImageActivity.this.e;
                UpdatePost updatePost2 = new UpdatePost();
                updatePost2.post_id = n2;
                if (FullScreenImageActivity.this.likeIcon.isSelected()) {
                    n22 = 0;
                    updatePost2.updates.num_likes = -1 + FullScreenImageActivity.this.c;
                } else {
                    n22 = 1;
                    updatePost2.updates.num_likes = 1 + FullScreenImageActivity.this.c;
                    if (FullScreenImageActivity.this.dislikeIcon.isSelected()) {
                        updatePost2.updates.num_dislikes = -1 + FullScreenImageActivity.this.d;
                    }
                }
                updatePost2.updates.like_value = n22;
                ix.a().a(new in.ar(updatePost2));
                ik.a().b(Integer.toString((int)n2), Integer.toString((int)n22), null).b(Schedulers.io()).a(apv.a()).b(new apr<Post>(){

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        rj.a(throwable);
                        Log.d((String)"LikePost", (String)throwable.toString());
                        ix.a().a(new in.ar(updatePost));
                    }

                    @Override
                    public void onNext(Post post) {
                        FullScreenImageActivity.this.enableLikes();
                    }
                });
            }

        });
        this.dislikeContainer.setOnClickListener(new View.OnClickListener(){

            /*
             * Enabled aggressive block sorting
             */
            public void onClick(View view) {
                int n22;
                if (n4 == 1) {
                    if (FullScreenImageActivity.this.h == -1) {
                        FullScreenImageActivity.this.b(FullScreenImageActivity.this.falseIcon, FullScreenImageActivity.this.g, FullScreenImageActivity.this.falseCount, false);
                        FullScreenImageActivity.this.h = 0;
                    } else {
                        if (FullScreenImageActivity.this.h == 1) {
                            FullScreenImageActivity.this.a(FullScreenImageActivity.this.trueIcon, FullScreenImageActivity.this.f, FullScreenImageActivity.this.trueCount, false);
                        }
                        FullScreenImageActivity.this.b(FullScreenImageActivity.this.falseIcon, FullScreenImageActivity.this.g, FullScreenImageActivity.this.falseCount, true);
                        FullScreenImageActivity.this.h = -1;
                    }
                    FullScreenImageActivity.this.a(n2, FullScreenImageActivity.this.h, 1);
                    return;
                }
                FullScreenImageActivity.this.disableLikes();
                final UpdatePost updatePost = new UpdatePost();
                updatePost.post_id = n2;
                updatePost.updates.num_likes = FullScreenImageActivity.this.c;
                updatePost.updates.num_dislikes = FullScreenImageActivity.this.d;
                updatePost.updates.like_value = FullScreenImageActivity.this.e;
                UpdatePost updatePost2 = new UpdatePost();
                updatePost2.post_id = n2;
                if (FullScreenImageActivity.this.dislikeIcon.isSelected()) {
                    n22 = 0;
                    updatePost2.updates.num_dislikes = -1 + FullScreenImageActivity.this.d;
                } else {
                    n22 = -1;
                    updatePost2.updates.num_dislikes = 1 + FullScreenImageActivity.this.d;
                    if (FullScreenImageActivity.this.likeIcon.isSelected()) {
                        updatePost2.updates.num_likes = -1 + FullScreenImageActivity.this.c;
                    }
                }
                updatePost2.updates.like_value = n22;
                ix.a().a(new in.ar(updatePost2));
                ik.a().b(Integer.toString((int)n2), Integer.toString((int)n22), null).b(Schedulers.io()).a(apv.a()).b(new apr<Post>(){

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        rj.a(throwable);
                        Log.d((String)"LikePost", (String)throwable.toString());
                        ix.a().a(new in.ar(updatePost));
                    }

                    @Override
                    public void onNext(Post post) {
                        FullScreenImageActivity.this.enableLikes();
                    }
                });
            }

        });
        this.commentContainer.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                if (FullScreenImageActivity.this.getIntent().hasExtra("fromDetails")) {
                    FullScreenImageActivity.this.finish();
                    return;
                }
                PostDetailsActivity.startPostDetailsActivity(n2, (Context)FullScreenImageActivity.this.m, bundle.getString("icon_color"));
                FullScreenImageActivity.this.finish();
            }
        });
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void subscribeToUpdates(String var1) {
        var2_2 = -1;
        switch (var1.hashCode()) {
            case 3446944: {
                if (var1.equals((Object)"post")) {
                    var2_2 = 0;
                }
            }
            default: {
                ** GOTO lbl11
            }
            case 950398559: 
        }
        if (var1.equals((Object)"comment")) {
            var2_2 = 1;
        }
lbl11: // 4 sources:
        switch (var2_2) {
            default: {
                return;
            }
            case 0: {
                this.addToSubscriptionList(ix.a().a(in.ar.class, new apr<in.ar>(){

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        rj.a(throwable);
                    }

                    @Override
                    public void onNext(in.ar ar2) {
                        FullScreenImageActivity.this.updatePost(ar2);
                    }
                }));
                return;
            }
            case 1: 
        }
        this.addToSubscriptionList(ix.a().a(in.aq.class, new apr<in.aq>(){

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
            }

            @Override
            public void onNext(in.aq aq2) {
                FullScreenImageActivity.this.updateComment(aq2);
            }
        }));
    }

    public void updateComment(in.aq aq2) {
        this.c = aq2.c;
        this.d = aq2.d;
        this.e = aq2.b;
        this.updateFullscreenView();
    }

    public void updateFullscreenView() {
        this.likeCount.setText((CharSequence)Integer.toString((int)this.c));
        this.dislikeCount.setText((CharSequence)Integer.toString((int)this.d));
        if (this.e == 1) {
            this.likeIcon.setSelected(true);
            this.dislikeIcon.setSelected(false);
            return;
        }
        if (this.e == -1) {
            this.likeIcon.setSelected(false);
            this.dislikeIcon.setSelected(true);
            return;
        }
        this.likeIcon.setSelected(false);
        this.dislikeIcon.setSelected(false);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void updatePost(in.ar ar2) {
        UpdatePost.Updates updates = ar2.a.updates;
        int n2 = updates.num_likes != null ? updates.num_likes : this.c;
        this.c = n2;
        int n3 = updates.num_dislikes != null ? updates.num_dislikes : this.d;
        this.d = n3;
        int n4 = updates.like_value != null ? updates.like_value : this.e;
        this.e = n4;
        if (updates.num_comments != null) {
            this.commentCount.setText((CharSequence)Integer.toString((int)updates.num_comments));
        }
        this.updateFullscreenView();
    }

}

