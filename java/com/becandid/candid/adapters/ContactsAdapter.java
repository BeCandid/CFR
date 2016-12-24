/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Color
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$Adapter
 *  android.support.v7.widget.RecyclerView$ViewHolder
 *  android.text.Html
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.TextView
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.becandid.candid.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import java.util.List;

public class ContactsAdapter
extends RecyclerView.Adapter<c> {
    private List<a> a;
    private b b;

    public c a(ViewGroup viewGroup, int n2) {
        if (n2 == 2) {
            return (ContactsAdapter)this.new ContactsHolder(LayoutInflater.from((Context)viewGroup.getContext()).inflate(2130968645, viewGroup, false));
        }
        if (n2 == 1) {
            return (ContactsAdapter)this.new LetterHolder(LayoutInflater.from((Context)viewGroup.getContext()).inflate(2130968646, viewGroup, false));
        }
        return null;
    }

    public void a(b b2) {
        this.b = b2;
    }

    public void a(c c2, int n2) {
        c2.a((a)this.a.get(n2), n2);
    }

    public void a(List<a> list) {
        this.a = list;
        this.notifyDataSetChanged();
    }

    public int getItemCount() {
        if (this.a != null) {
            return this.a.size();
        }
        return 0;
    }

    public int getItemViewType(int n2) {
        if (((a)this.a.get((int)n2)).g == null) {
            return 2;
        }
        return 1;
    }

    public /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int n2) {
        this.a((c)viewHolder, n2);
    }

    public /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int n2) {
        return this.a(viewGroup, n2);
    }

    public class ContactsHolder
    extends c
    implements View.OnClickListener {
        a a;
        @BindView(value=2131624360)
        View animalBgView;
        GradientDrawable b;
        int c;
        @BindView(value=2131624363)
        TextView contactName;
        @BindView(value=2131624361)
        TextView contactPhoto;
        @BindView(value=2131624362)
        Button invite;

        ContactsHolder(View view) {
            super(view);
            ButterKnife.bind((Object)this, (View)view);
            this.invite.setOnClickListener((View.OnClickListener)this);
            this.contactPhoto.setTypeface(io.b());
            this.b = new GradientDrawable();
            this.b.setShape(1);
            this.animalBgView.setBackground((Drawable)this.b);
        }

        @Override
        public void a(a a2, int n2) {
            this.a = a2;
            this.c = n2;
            this.contactName.setText((CharSequence)Html.fromHtml((String)("<b>" + a2.c + "</b> " + a2.d)));
            this.contactPhoto.setText((CharSequence)io.a(a2.a));
            int n3 = Color.parseColor((String)a2.b);
            this.contactPhoto.setTextColor(n3);
            this.b.setColor(1040187392 | 16777215 & n3);
            if (a2.h) {
                this.invite.setBackground(this.invite.getContext().getResources().getDrawable(2130837988));
                this.invite.setText((CharSequence)"Invited");
                return;
            }
            this.invite.setBackground(this.invite.getContext().getResources().getDrawable(2130838158));
            this.invite.setText((CharSequence)"Invite");
        }

        public void onClick(View view) {
            if (ContactsAdapter.this.b != null && this.a != null) {
                ContactsAdapter.this.b.invite(this.a, this.c);
            }
        }
    }

    public class LetterHolder
    extends c {
        @BindView(value=2131624364)
        TextView letter;

        LetterHolder(View view) {
            super(view);
            ButterKnife.bind((Object)this, (View)view);
        }

        @Override
        public void a(a a2, int n2) {
            this.letter.setText((CharSequence)a2.g);
        }
    }

    public static class a {
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public boolean h;
    }

    public static interface b {
        public void invite(a var1, int var2);
    }

    public static class c
    extends RecyclerView.ViewHolder {
        public c(View view) {
            super(view);
        }

        public void a(a a2, int n2) {
        }
    }

}

