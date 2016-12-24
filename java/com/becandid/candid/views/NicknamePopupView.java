/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.Editable
 *  android.text.SpannableStringBuilder
 *  android.text.TextWatcher
 *  android.text.style.StyleSpan
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.EditText
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.TextView
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.becandid.candid.views;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.activities.MessageActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.User;
import com.becandid.candid.views.BlurLayout;

public class NicknamePopupView
extends BlurLayout {
    @BindView(value=2131624592)
    TextView addNicknameDesc;
    MessageActivity b;
    @BindView(value=2131624593)
    EditText editNickname;
    @BindView(value=2131624079)
    ImageView mBadgeIcon;
    @BindView(value=2131624594)
    Button mCancelButton;
    @BindView(value=2131624579)
    Button mFinishBtn;
    @BindView(value=2131624590)
    View mMessageContainerAddNickname;
    @BindView(value=2131624584)
    View mMessageContainerSecondNickname;
    @BindView(value=2131624595)
    View mNicknameCloseButton;
    @BindView(value=2131624587)
    Button mNoButton;
    @BindView(value=2131624589)
    Button mOkButton;
    @BindView(value=2131624588)
    Button mYesButton;
    @BindView(value=2131624586)
    TextView secondNicknameDesc;

    /*
     * Enabled aggressive block sorting
     */
    public NicknamePopupView(Context context, String string2, boolean bl2) {
        super(context);
        this.b = (MessageActivity)context;
        this.a = string2;
        LayoutInflater.from((Context)context).inflate(2130968711, (ViewGroup)this, true);
        ButterKnife.bind((View)this);
        this.a();
        jb.a(this.mMessageContainerSecondNickname, "#ffffff");
        jb.a(this.mMessageContainerAddNickname, "#ffffff");
        this.mNicknameCloseButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                NicknamePopupView.this.b();
            }
        });
        if (!bl2) {
            this.setupNicknamePrompt();
            return;
        }
        this.b.markNicknameAlertShown();
        User user = this.b.getTargetUserData();
        User user2 = this.b.getUserData();
        if (user != null && user.post_name != null && user.nickname != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder((CharSequence)user.post_name);
            spannableStringBuilder.setSpan((Object)new StyleSpan(1), 0, spannableStringBuilder.length(), 33);
            spannableStringBuilder.append((CharSequence)(" is now " + user.nickname));
            spannableStringBuilder.setSpan((Object)new StyleSpan(1), spannableStringBuilder.length() - user.nickname.length(), spannableStringBuilder.length(), 33);
            spannableStringBuilder.append((CharSequence)".");
            if (user2.nickname == null) {
                spannableStringBuilder.append((CharSequence)" Want to add your own nickname?");
            } else {
                this.mOkButton.setVisibility(0);
                this.mOkButton.setOnClickListener(new View.OnClickListener(){

                    public void onClick(View view) {
                        NicknamePopupView.this.b.markNicknameAlertShown();
                        NicknamePopupView.this.b();
                    }
                });
                this.mYesButton.setVisibility(8);
                this.mNoButton.setVisibility(8);
                this.mNicknameCloseButton.setOnClickListener(new View.OnClickListener(){

                    public void onClick(View view) {
                        NicknamePopupView.this.b();
                    }
                });
            }
            this.secondNicknameDesc.setText((CharSequence)spannableStringBuilder);
        } else {
            super.b();
        }
        this.mMessageContainerSecondNickname.setVisibility(0);
        this.mMessageContainerAddNickname.setVisibility(8);
        this.mYesButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                NicknamePopupView.this.setupNicknamePrompt();
            }
        });
        this.mNoButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                NicknamePopupView.this.b.ignoreNickname();
                NicknamePopupView.this.b();
            }
        });
    }

    private void b() {
        FrameLayout frameLayout = (FrameLayout)this.b.findViewById(2131624178);
        if (frameLayout != null) {
            this.b.slideOutAnimation((View)frameLayout);
        }
        this.b.closingPopup();
    }

    /*
     * Enabled aggressive block sorting
     */
    public void setupNicknamePrompt() {
        this.mMessageContainerAddNickname.setVisibility(0);
        this.mMessageContainerSecondNickname.setVisibility(8);
        this.editNickname.addTextChangedListener(new TextWatcher(){

            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    NicknamePopupView.this.mFinishBtn.setEnabled(true);
                    return;
                }
                NicknamePopupView.this.mFinishBtn.setEnabled(false);
            }

            public void beforeTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
            }

            public void onTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
            }
        });
        if (AppState.nickname != null) {
            this.editNickname.setText((CharSequence)AppState.nickname);
            this.editNickname.setSelection(this.editNickname.length());
        } else if (!this.b.keyboardOpen) {
            this.b.openKeyboard();
        }
        this.mFinishBtn.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                NicknamePopupView.this.b.updateNickname(NicknamePopupView.this.editNickname.getText().toString());
                NicknamePopupView.this.b();
            }
        });
        this.mCancelButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                NicknamePopupView.this.b.ignoreNickname();
                NicknamePopupView.this.b();
            }
        });
    }

}

