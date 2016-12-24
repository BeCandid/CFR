/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.Rect
 *  android.os.Bundle
 *  android.os.Handler
 *  android.support.v7.widget.AppCompatEditText
 *  android.support.v7.widget.ListPopupWindow
 *  android.text.Editable
 *  android.text.SpannableStringBuilder
 *  android.text.TextWatcher
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnFocusChangeListener
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.Button
 *  android.widget.EditText
 *  android.widget.FrameLayout
 *  android.widget.ListAdapter
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  android.widget.Toast
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  java.lang.CharSequence
 *  java.lang.Float
 *  java.lang.Integer
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
 *  rx.schedulers.Schedulers
 */
package com.becandid.candid.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.ListPopupWindow;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Config;
import com.becandid.candid.data.Group;
import com.becandid.candid.data.TextTag;
import com.becandid.candid.models.NetworkData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rx.schedulers.Schedulers;

public class ContentEditActivity
extends BaseActivity {
    private String b;
    private int c;
    private int d;
    private String e;
    @BindView(value=2131624104)
    Button editCancel;
    @BindView(value=2131624100)
    FrameLayout editContainer;
    @BindView(value=2131624102)
    TextView editDetails;
    @BindView(value=2131624097)
    TextView editHeaderTitle;
    @BindView(value=2131624105)
    Button editSave;
    @BindView(value=2131624106)
    FrameLayout editSpinny;
    @BindView(value=2131624101)
    AppCompatEditText editText;
    @BindView(value=2131624095)
    RelativeLayout editTitle;
    private ArrayList<TextTag> f;
    private ListPopupWindow g;
    private hg h;
    private CharSequence i = "";
    private boolean j;
    private int k;
    private int l;
    private int m;
    @BindView(value=2131624094)
    RelativeLayout root;

    @Override
    protected void keyboardClosed() {
        this.editDetails.setVisibility(0);
    }

    @Override
    protected void keyboardOpened() {
        new Handler().post(new Runnable(){

            public void run() {
                Rect rect = new Rect();
                ContentEditActivity.this.root.getWindowVisibleDisplayFrame(rect);
                if (Float.compare((float)((float)(rect.bottom - rect.top) / (float)ContentEditActivity.this.d), (float)0.5f) >= 0) {
                    ContentEditActivity.this.editDetails.setVisibility(8);
                }
            }
        });
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void onCreate(Bundle bundle) {
        ListPopupWindow listPopupWindow;
        hg hg2;
        super.onCreate(bundle);
        this.setContentView(2130968605);
        ButterKnife.bind((Activity)this);
        this.enableKeyboardEvents((View)this.root);
        Rect rect = new Rect();
        this.root.getWindowVisibleDisplayFrame(rect);
        this.d = rect.bottom - rect.top;
        if (this.getIntent().hasExtra("comment_id")) {
            this.e = "comment";
            this.c = this.getIntent().getIntExtra("comment_id", 0);
            this.editHeaderTitle.setText(2131230833);
            this.editText.setText(2131230817);
            this.editDetails.setText(2131230815);
            this.b = this.getIntent().getStringExtra("comment_text");
        } else if (this.getIntent().hasExtra("post_id")) {
            this.e = "post";
            this.c = this.getIntent().getIntExtra("post_id", 0);
            this.editHeaderTitle.setText(2131230836);
            this.editText.setText(2131230903);
            this.editDetails.setText(2131230902);
            this.b = this.getIntent().getStringExtra("caption");
        } else {
            Toast.makeText((Context)this, (CharSequence)"Invalid edit attempt", (int)1).show();
            this.finish();
        }
        this.f = new ArrayList();
        if (this.getIntent().hasExtra("group_tags")) {
            String[] arrstring = this.getIntent().getStringExtra("group_tags").split(";");
            int n2 = arrstring.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                String[] arrstring2 = arrstring[i2].split(",");
                int n3 = Integer.parseInt((String)arrstring2[0]);
                TextTag textTag = new TextTag(Integer.parseInt((String)arrstring2[1]), Integer.parseInt((String)arrstring2[2]), n3);
                this.f.add((Object)textTag);
            }
        }
        this.k = AppState.config.getInt("disable_group_tagging", 0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder((CharSequence)this.b);
        if (this.k == 0 && !this.f.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (TextTag textTag : this.f) {
                if (textTag.endIndex > spannableStringBuilder.length()) {
                    textTag.endIndex = spannableStringBuilder.length();
                }
                if (textTag.startIndex < 0) {
                    textTag.startIndex = 0;
                }
                if (textTag.startIndex >= spannableStringBuilder.length() || textTag.endIndex <= 0) break;
                arrayList.add((Object)textTag);
                if (textTag.startIndex <= -1 || textTag.endIndex <= -1) continue;
                spannableStringBuilder.setSpan((Object)jb.a(), textTag.startIndex, textTag.endIndex, 33);
            }
            this.f = arrayList;
        }
        this.editText.setText((CharSequence)spannableStringBuilder);
        this.editText.setSelection(this.editText.length());
        this.editText.requestFocus();
        this.openKeyboard();
        FrameLayout frameLayout = this.editContainer;
        View.OnClickListener onClickListener = new View.OnClickListener(){

            public void onClick(View view) {
                ContentEditActivity.this.editText.setSelection(ContentEditActivity.this.editText.length());
                ContentEditActivity.this.editText.requestFocus();
                if (!ContentEditActivity.this.keyboardOpen) {
                    ContentEditActivity.this.openKeyboard();
                }
            }
        };
        frameLayout.setOnClickListener(onClickListener);
        if (AppState.groups == null) {
            AppState.groups = new ArrayList();
        }
        this.h = hg2 = new hg((Context)this, 2130968690, (List<Group>)new ArrayList(AppState.groups));
        this.g = listPopupWindow = new ListPopupWindow((Context)this);
        this.g.setAdapter((ListAdapter)this.h);
        this.g.setAnchorView((View)this.editText);
        this.g.setAnimationStyle(0);
        this.g.setHeight(-2);
        this.g.setWidth(jb.a(150, (Context)this));
        ListPopupWindow listPopupWindow2 = this.g;
        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener(){

            /*
             * Enabled aggressive block sorting
             */
            public void onItemClick(AdapterView<?> adapterView, View view, int n2, long l2) {
                Group group = (Group)adapterView.getItemAtPosition(n2);
                String[] arrstring = ContentEditActivity.this.editText.getText().toString().split("(?=#)");
                int n3 = ContentEditActivity.this.editText.getSelectionStart();
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
                for (TextTag textTag : ContentEditActivity.this.f) {
                    if (n3 >= textTag.startIndex && n3 <= textTag.endIndex) continue;
                    if (textTag.startIndex > n3) {
                        textTag.startIndex = n6 + textTag.startIndex;
                        textTag.endIndex = n6 + textTag.endIndex;
                    }
                    arrayList.add((Object)textTag);
                }
                ContentEditActivity.this.f = arrayList;
                Iterator iterator = ContentEditActivity.this.f.iterator();
                do {
                    if (!iterator.hasNext()) {
                        ContentEditActivity.this.i = (CharSequence)spannableStringBuilder;
                        ContentEditActivity.this.editText.setText((CharSequence)spannableStringBuilder);
                        ContentEditActivity.this.editText.setSelection(n5 + 1);
                        ContentEditActivity.this.g.dismiss();
                        return;
                    }
                    TextTag textTag2 = (TextTag)iterator.next();
                    if (textTag2.startIndex <= -1 || textTag2.endIndex <= -1) continue;
                    spannableStringBuilder.setSpan((Object)jb.a(), textTag2.startIndex, textTag2.endIndex, 33);
                } while (true);
            }
        };
        listPopupWindow2.setOnItemClickListener(onItemClickListener);
        AppCompatEditText appCompatEditText = this.editText;
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener(){

            public void onFocusChange(View view, boolean bl2) {
                if (bl2 && ContentEditActivity.this.k == 0) {
                    jb.a((CharSequence)ContentEditActivity.this.editText.getText(), (EditText)ContentEditActivity.this.editText, ContentEditActivity.this.g, ContentEditActivity.this.h);
                }
            }
        };
        appCompatEditText.setOnFocusChangeListener(onFocusChangeListener);
        AppCompatEditText appCompatEditText2 = this.editText;
        TextWatcher textWatcher = new TextWatcher(){

            public void afterTextChanged(Editable editable) {
                if (ContentEditActivity.this.k == 0 && !editable.toString().equals((Object)ContentEditActivity.this.i.toString())) {
                    ContentEditActivity.this.i = editable.toString();
                    jb.a((CharSequence)editable, (EditText)ContentEditActivity.this.editText, ContentEditActivity.this.g, ContentEditActivity.this.h);
                    if (ContentEditActivity.this.j) {
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder((CharSequence)editable.toString());
                        for (TextTag textTag : ContentEditActivity.this.f) {
                            if (textTag.startIndex <= -1 || textTag.endIndex <= -1) continue;
                            spannableStringBuilder.setSpan((Object)jb.a(), textTag.startIndex, textTag.endIndex, 33);
                        }
                        ContentEditActivity.this.j = false;
                        ContentEditActivity.this.i = spannableStringBuilder.toString();
                        int n2 = ContentEditActivity.this.editText.getSelectionStart();
                        ContentEditActivity.this.editText.setText((CharSequence)spannableStringBuilder);
                        ContentEditActivity.this.editText.setSelection(n2);
                    }
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
                ContentEditActivity.this.l = ContentEditActivity.this.editText.getSelectionStart();
                ContentEditActivity.this.m = ContentEditActivity.this.editText.getSelectionEnd();
            }

            public void onTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
                if (ContentEditActivity.this.k == 0 && !charSequence.toString().equals((Object)ContentEditActivity.this.i.toString())) {
                    int n5 = ContentEditActivity.this.editText.getSelectionStart();
                    ArrayList arrayList = new ArrayList();
                    for (TextTag textTag : ContentEditActivity.this.f) {
                        if (ContentEditActivity.this.l <= textTag.startIndex && ContentEditActivity.this.m <= textTag.startIndex) {
                            textTag.startIndex += n4 - n3;
                            textTag.endIndex += n4 - n3;
                            arrayList.add((Object)textTag);
                            ContentEditActivity.this.j = true;
                            continue;
                        }
                        if (ContentEditActivity.this.l <= textTag.startIndex && ContentEditActivity.this.m > textTag.startIndex) {
                            ContentEditActivity.this.j = true;
                            continue;
                        }
                        if (ContentEditActivity.this.l > textTag.startIndex && ContentEditActivity.this.l <= textTag.endIndex) {
                            ContentEditActivity.this.j = true;
                            continue;
                        }
                        if (n5 > textTag.endIndex) {
                            arrayList.add((Object)textTag);
                            continue;
                        }
                        ContentEditActivity.this.j = true;
                    }
                    ContentEditActivity.this.f = arrayList;
                }
            }
        };
        appCompatEditText2.addTextChangedListener(textWatcher);
        Button button = this.editSave;
        View.OnClickListener onClickListener2 = new View.OnClickListener(){

            /*
             * Enabled aggressive block sorting
             */
            public void onClick(View view) {
                if (ContentEditActivity.this.editText.getText().toString().equals((Object)"") || ContentEditActivity.this.editText.getText().toString().trim().equals((Object)"")) {
                    Toast.makeText((Context)ContentEditActivity.this, (int)2131230816, (int)0).show();
                    return;
                } else {
                    ContentEditActivity.this.editSpinny.setVisibility(0);
                    HashMap hashMap = new HashMap();
                    if (!ContentEditActivity.this.f.isEmpty()) {
                        String string2 = "";
                        for (TextTag textTag : ContentEditActivity.this.f) {
                            string2 = string2 + textTag.toString() + ";";
                        }
                        hashMap.put((Object)"mentioned_group_ids", (Object)string2.substring(0, -1 + string2.length()));
                    }
                    if (ContentEditActivity.this.e.equals((Object)"comment")) {
                        hashMap.put((Object)"comment_id", (Object)Integer.toString((int)ContentEditActivity.this.c));
                        hashMap.put((Object)"comment_text", (Object)ContentEditActivity.this.editText.getText().toString());
                        ik.a().m((Map<String, String>)hashMap).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

                            @Override
                            public void onCompleted() {
                            }

                            @Override
                            public void onError(Throwable throwable) {
                                ContentEditActivity.this.editSpinny.setVisibility(8);
                                Toast.makeText((Context)ContentEditActivity.this, (CharSequence)throwable.toString(), (int)1).show();
                            }

                            @Override
                            public void onNext(NetworkData networkData) {
                                if (networkData.success) {
                                    boolean bl2 = ContentEditActivity.this.f.isEmpty();
                                    String string2 = null;
                                    if (!bl2) {
                                        String string3 = "";
                                        for (TextTag textTag : ContentEditActivity.this.f) {
                                            string3 = string3 + textTag.toString() + ";";
                                        }
                                        string2 = string3.substring(0, -1 + string3.length());
                                    }
                                    ix.a().a(new in.g(ContentEditActivity.this.c, ContentEditActivity.this.editText.getText().toString(), string2));
                                    Intent intent = new Intent();
                                    intent.putExtra("comment_id", ContentEditActivity.this.c);
                                    ContentEditActivity.this.setResult(203, intent);
                                    ContentEditActivity.this.finish();
                                    return;
                                }
                                ContentEditActivity.this.editSpinny.setVisibility(8);
                                Toast.makeText((Context)ContentEditActivity.this, (CharSequence)networkData.error, (int)1).show();
                            }
                        });
                        return;
                    }
                    if (!ContentEditActivity.this.e.equals((Object)"post")) return;
                    {
                        hashMap.put((Object)"post_id", (Object)Integer.toString((int)ContentEditActivity.this.c));
                        hashMap.put((Object)"caption", (Object)ContentEditActivity.this.editText.getText().toString());
                        ik.a().l((Map<String, String>)hashMap).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

                            @Override
                            public void onCompleted() {
                            }

                            @Override
                            public void onError(Throwable throwable) {
                                ContentEditActivity.this.editSpinny.setVisibility(8);
                                Toast.makeText((Context)ContentEditActivity.this, (CharSequence)throwable.toString(), (int)1).show();
                            }

                            @Override
                            public void onNext(NetworkData networkData) {
                                if (networkData.success) {
                                    boolean bl2 = ContentEditActivity.this.f.isEmpty();
                                    String string2 = null;
                                    if (!bl2) {
                                        String string3 = "";
                                        for (TextTag textTag : ContentEditActivity.this.f) {
                                            string3 = string3 + textTag.toString() + ";";
                                        }
                                        string2 = string3.substring(0, -1 + string3.length());
                                    }
                                    ix.a().a(new in.af(ContentEditActivity.this.c, ContentEditActivity.this.editText.getText().toString(), string2));
                                    ContentEditActivity.this.finish();
                                    return;
                                }
                                ContentEditActivity.this.editSpinny.setVisibility(8);
                                Toast.makeText((Context)ContentEditActivity.this, (CharSequence)networkData.error, (int)1).show();
                            }
                        });
                        return;
                    }
                }
            }

        };
        button.setOnClickListener(onClickListener2);
        Button button2 = this.editCancel;
        View.OnClickListener onClickListener3 = new View.OnClickListener(){

            public void onClick(View view) {
                ContentEditActivity.this.backNavClick(view);
            }
        };
        button2.setOnClickListener(onClickListener3);
    }

}

