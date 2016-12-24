/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.TextView
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 *  rx.schedulers.Schedulers
 */
package com.becandid.candid.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.activities.PopupWithBlurBackgroundActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.User;
import com.becandid.candid.models.EmptySubscriber;
import com.becandid.candid.models.NetworkData;
import com.becandid.candid.views.BlurLayout;
import java.util.HashMap;
import java.util.Map;
import rx.schedulers.Schedulers;

public class MessagingPopupView
extends BlurLayout {
    PopupWithBlurBackgroundActivity b;
    @BindView(value=2131624567)
    TextView badgeDescEnabled;
    private boolean c;
    private boolean d;
    @BindView(value=2131624577)
    ImageView mAutoCheckmark;
    @BindView(value=2131624576)
    View mAutoDeleteMsgContainer;
    @BindView(value=2131624079)
    ImageView mBadgeIcon;
    @BindView(value=2131624569)
    TextView mDisabledTextView;
    @BindView(value=2131624579)
    Button mFinishBtn;
    @BindView(value=2131624568)
    TextView mKeepEnabledTextView;
    @BindView(value=2131624574)
    ImageView mManualCheckmark;
    @BindView(value=2131624573)
    View mManualDeleteMsgContainer;
    @BindView(value=2131624580)
    View mMessageCloseBtn;
    @BindView(value=2131624570)
    View mMessageContainerDeleteMessage;
    @BindView(value=2131624565)
    View mMessageContainerEnabled;

    /*
     * Enabled aggressive block sorting
     */
    public MessagingPopupView(Context context, String string2, boolean bl2) {
        super(context);
        this.b = (PopupWithBlurBackgroundActivity)context;
        this.a = string2;
        LayoutInflater.from((Context)context).inflate(2130968703, (ViewGroup)this, true);
        ButterKnife.bind((View)this);
        this.a();
        jb.a(this.mMessageContainerEnabled, "#ffffff");
        if (bl2) {
            this.badgeDescEnabled.setText(2131230958);
        } else {
            this.badgeDescEnabled.setText(2131230949);
        }
        this.mKeepEnabledTextView.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                MessagingPopupView.this.mMessageContainerEnabled.setVisibility(8);
                MessagingPopupView.this.mMessageContainerDeleteMessage.setVisibility(0);
                HashMap hashMap = new HashMap();
                hashMap.put((Object)"messaging_disabled", (Object)"0");
                ik.a().r((Map<String, String>)hashMap).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
                AppState.account.messaging_disabled = 0;
                ix.a().a(new in.aa(0));
            }
        });
        this.mDisabledTextView.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put((Object)"messaging_disabled", (Object)"1");
                ik.a().r((Map<String, String>)hashMap).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
                AppState.account.messaging_disabled = 1;
                ix.a().a(new in.aa(1));
                MessagingPopupView.this.b();
            }
        });
        this.mAutoDeleteMsgContainer.setOnClickListener(new View.OnClickListener(){

            /*
             * Enabled aggressive block sorting
             */
            public void onClick(View view) {
                boolean bl2 = true;
                if (!MessagingPopupView.this.d) {
                    MessagingPopupView.this.setAutoState(bl2);
                    MessagingPopupView.this.setManualState(false);
                    MessagingPopupView.this.c = false;
                } else {
                    MessagingPopupView.this.setAutoState(false);
                }
                MessagingPopupView messagingPopupView = MessagingPopupView.this;
                if (MessagingPopupView.this.d) {
                    bl2 = false;
                }
                messagingPopupView.d = bl2;
                MessagingPopupView.this.c();
            }
        });
        this.mManualDeleteMsgContainer.setOnClickListener(new View.OnClickListener(){

            /*
             * Enabled aggressive block sorting
             */
            public void onClick(View view) {
                boolean bl2 = true;
                if (!MessagingPopupView.this.c) {
                    MessagingPopupView.this.setAutoState(false);
                    MessagingPopupView.this.setManualState(bl2);
                    MessagingPopupView.this.d = false;
                } else {
                    MessagingPopupView.this.setManualState(false);
                }
                MessagingPopupView messagingPopupView = MessagingPopupView.this;
                if (MessagingPopupView.this.c) {
                    bl2 = false;
                }
                messagingPopupView.c = bl2;
                MessagingPopupView.this.c();
            }
        });
        this.mFinishBtn.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                boolean bl2 = MessagingPopupView.this.d;
                int n2 = 0;
                if (bl2) {
                    n2 = 1;
                }
                hashMap.put((Object)"message_auto_deletion", (Object)Integer.toString((int)n2));
                AppState.account.message_auto_deletion = n2;
                ik.a().r((Map<String, String>)hashMap).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
                MessagingPopupView.this.b();
            }
        });
        this.mMessageCloseBtn.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                MessagingPopupView.this.b();
            }
        });
        this.mManualDeleteMsgContainer.performClick();
    }

    private void b() {
        FrameLayout frameLayout = (FrameLayout)this.b.findViewById(2131624178);
        if (frameLayout != null) {
            this.b.slideOutAnimation((View)frameLayout);
        }
    }

    private void c() {
        if (this.c || this.d) {
            this.mFinishBtn.setEnabled(true);
            return;
        }
        this.mFinishBtn.setEnabled(false);
    }

    private void setAutoState(boolean bl2) {
        if (bl2) {
            this.mAutoDeleteMsgContainer.setBackground(this.getResources().getDrawable(2130837981));
            this.mAutoCheckmark.setImageDrawable(this.getResources().getDrawable(2130837982));
            return;
        }
        this.mAutoDeleteMsgContainer.setBackground(this.getResources().getDrawable(2130837710));
        this.mAutoCheckmark.setImageDrawable(this.getResources().getDrawable(2130837709));
    }

    private void setManualState(boolean bl2) {
        if (bl2) {
            this.mManualDeleteMsgContainer.setBackground(this.getResources().getDrawable(2130837981));
            this.mManualCheckmark.setImageDrawable(this.getResources().getDrawable(2130837982));
            return;
        }
        this.mManualDeleteMsgContainer.setBackground(this.getResources().getDrawable(2130837710));
        this.mManualCheckmark.setImageDrawable(this.getResources().getDrawable(2130837709));
    }

}

