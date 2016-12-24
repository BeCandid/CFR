/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.support.v7.widget.LinearLayoutManager
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$Adapter
 *  android.support.v7.widget.RecyclerView$LayoutManager
 *  android.support.v7.widget.RecyclerView$OnItemTouchListener
 *  android.support.v7.widget.RecyclerView$ViewHolder
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.ProgressBar
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.Toast
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  butterknife.OnClick
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  rx.schedulers.Schedulers
 */
package com.becandid.candid.views;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.becandid.candid.GossipApplication;
import rx.schedulers.Schedulers;

public class ChoosePhotoDialogView
extends LinearLayout {
    private a a;
    private aij b;
    private b c;
    @BindView(value=2131624318)
    ProgressBar spinny;
    @BindView(value=2131624317)
    RecyclerView suggestedPhotoView;

    public ChoosePhotoDialogView(Context context) {
        super(context);
        this.setOrientation(1);
        ((Activity)context).getLayoutInflater().inflate(2130968638, (ViewGroup)this);
        ButterKnife.bind((View)this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(0);
        this.suggestedPhotoView.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
        this.c = (ChoosePhotoDialogView)this.new b();
        this.suggestedPhotoView.setAdapter((RecyclerView.Adapter)this.c);
        this.suggestedPhotoView.addOnItemTouchListener((RecyclerView.OnItemTouchListener)new iv(context){

            @Override
            public void onItemClick(View view, int n2) {
                if (ChoosePhotoDialogView.this.a != null && ChoosePhotoDialogView.this.b != null && n2 < ChoosePhotoDialogView.this.b.a()) {
                    ain ain2 = ChoosePhotoDialogView.this.b.a(n2).m();
                    ChoosePhotoDialogView.this.a.choosePhoto(ain2.b("source_url").c(), ain2.b("width").g(), ain2.b("height").g());
                    ChoosePhotoDialogView.this.a.d();
                }
            }
        });
    }

    @OnClick(value={2131624321})
    public void cancel(View view) {
        if (this.a != null) {
            this.a.d();
        }
    }

    @OnClick(value={2131624320})
    public void library(View view) {
        if (this.a != null) {
            this.a.c();
            this.a.d();
        }
    }

    public void setDelegate(a a2) {
        this.a = a2;
    }

    public void setQuery(String string2) {
        if (string2 == null || string2.trim().length() == 0) {
            this.suggestedPhotoView.setVisibility(8);
            this.spinny.setVisibility(8);
            return;
        }
        this.suggestedPhotoView.setVisibility(8);
        this.spinny.setVisibility(0);
        ik.a().i(string2).b(Schedulers.io()).a(apv.a()).b(new apr<ain>(){

            /*
             * Enabled aggressive block sorting
             */
            public void a(ain ain2) {
                ChoosePhotoDialogView.this.spinny.setVisibility(8);
                if (ain2.b("success").h() && ain2.a("images") && ain2.c("images").a() > 0) {
                    ChoosePhotoDialogView.this.suggestedPhotoView.setVisibility(0);
                    ChoosePhotoDialogView.this.b = ain2.c("images");
                    ChoosePhotoDialogView.this.c.notifyDataSetChanged();
                    return;
                } else {
                    String string2 = "Unable to suggest images based on your group's name";
                    if (ain2.a("error")) {
                        string2 = ain2.b("error").c();
                    }
                    if (string2.length() <= 0) return;
                    {
                        Toast.makeText((Context)ChoosePhotoDialogView.this.getContext(), (CharSequence)string2, (int)1).show();
                        return;
                    }
                }
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                ChoosePhotoDialogView.this.spinny.setVisibility(8);
                Toast.makeText((Context)ChoosePhotoDialogView.this.getContext(), (CharSequence)"Unable to suggest images based on your group's name", (int)1).show();
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((ain)object);
            }
        });
    }

    @OnClick(value={2131624319})
    public void takePhoto(View view) {
        if (this.a != null) {
            this.a.b();
            this.a.d();
        }
    }

    public class PhotoSuggestionHolder
    extends RecyclerView.ViewHolder {
        @BindView(value=2131624322)
        ImageView imageView;

        public PhotoSuggestionHolder(View view) {
            super(view);
            ButterKnife.bind((Object)this, (View)view);
        }

        public void a(ain ain2) {
            if (this.imageView != null) {
                if (ain2.a("thumb_width") && ain2.a("thumb_height")) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)this.imageView.getLayoutParams();
                    layoutParams.width = (int)(ain2.b("thumb_width").e() / ain2.b("thumb_height").e() * (float)layoutParams.height);
                    this.imageView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
                }
                jt<String> jt2 = GossipApplication.c.a(ain2.b("thumb_url").c()).b();
                if (ain2.a("already_loaded")) {
                    jt2 = jt2.d();
                }
                ain2.a("already_loaded", true);
                jt2.a(this.imageView);
            }
        }
    }

    public static interface a {
        public void b();

        public void c();

        public void choosePhoto(String var1, int var2, int var3);

        public void d();
    }

    public class b
    extends RecyclerView.Adapter<PhotoSuggestionHolder> {
        public PhotoSuggestionHolder a(ViewGroup viewGroup, int n2) {
            View view = ((Activity)ChoosePhotoDialogView.this.getContext()).getLayoutInflater().inflate(2130968639, viewGroup, false);
            return new PhotoSuggestionHolder(view);
        }

        public void a(PhotoSuggestionHolder photoSuggestionHolder, int n2) {
            photoSuggestionHolder.a(ChoosePhotoDialogView.this.b.a(n2).m());
        }

        public int getItemCount() {
            if (ChoosePhotoDialogView.this.b != null) {
                return ChoosePhotoDialogView.this.b.a();
            }
            return 0;
        }

        public /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int n2) {
            this.a((PhotoSuggestionHolder)viewHolder, n2);
        }

        public /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int n2) {
            return this.a(viewGroup, n2);
        }
    }

}

