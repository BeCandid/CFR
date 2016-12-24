/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.StateListDrawable
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.becandid.candid.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class TagBox
extends LinearLayout {
    public static a b;
    Context a;
    @BindView(value=2131624828)
    ImageView mTagIcon;
    @BindView(value=2131624829)
    TextView mTagName;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public TagBox(Context context, final String string2) {
        super(context);
        this.a = context;
        LayoutInflater.from((Context)context).inflate(2130968753, (ViewGroup)this, true);
        ButterKnife.bind((View)this);
        try {
            StateListDrawable stateListDrawable = new StateListDrawable();
            String string3 = "onboarding_tags_" + string2.toLowerCase().replace((CharSequence)" ", (CharSequence)"_").replace((CharSequence)"'", (CharSequence)"");
            stateListDrawable.addState(new int[]{16842913}, this.getResources().getDrawable(this.getResources().getIdentifier(string3 + "_selected", "drawable", context.getPackageName())));
            stateListDrawable.addState(new int[0], this.getResources().getDrawable(this.getResources().getIdentifier(string3, "drawable", context.getPackageName())));
            this.mTagIcon.setImageDrawable((Drawable)stateListDrawable);
        }
        catch (Resources.NotFoundException var6_5) {
            Log.d((String)"Onboarding", (String)"Resource not found for tag icon");
        }
        this.mTagName.setText((CharSequence)string2);
        this.setTag((Object)string2);
        this.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                TagBox.b.a(view, string2);
            }
        });
    }

    public static void setTagClickListener(a a2) {
        b = a2;
    }

    public String getTagName() {
        return this.mTagName.getText().toString();
    }

    public String getTagNameLowerCase() {
        return this.mTagName.getText().toString().toLowerCase();
    }

    public static interface a {
        public void a(View var1, String var2);
    }

}

