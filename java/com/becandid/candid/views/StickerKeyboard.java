/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.support.v7.widget.GridLayoutManager
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$Adapter
 *  android.support.v7.widget.RecyclerView$LayoutManager
 *  android.support.v7.widget.RecyclerView$ViewHolder
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 */
package com.becandid.candid.views;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.HashMap;

public class StickerKeyboard
extends RecyclerView {
    static HashMap<String, Integer> b = new HashMap();
    static String[] c = new String[]{"happy", "sad", "shock", "angelic", "angry", "cool", "laugh", "love", "crying", "dead", "devilish", "dizzy", "tears", "uhhh", "upset", "wink", "shy", "worried", "kissright", "kissleft", "photoop", "ghost", "ambition", "grinning", "gross", "hmph", "sneaky", "studious", "hot", "cold", "sick", "ninja", "zombie", "alien", "robot", "luchador", "policeofficer", "fire", "balloons", "heart", "heartbreak", "baseball", "basketball", "soccer", "tennis", "bowling", "iceskate", "burger", "icecream", "pizza", "ramen", "sushi", "cake", "popcorn", "cappuccino", "beer", "wine", "champagne", "hotdrink", "apple", "orange", "redcup", "retrohandheld", "gamecontroller", "laptop", "smartphone", "clock", "tablet", "notebook", "camera_sticker", "present", "books", "teddybear", "backpack", "locker", "schoolbus", "luggage", "lifepreserver", "airplane", "taxi", "tickets", "palmtree", "paintset", "envelope", "shuriken", "trophy", "jersey", "lipstick", "compactmirror", "necklace", "purse", "stiletto", "crown", "diamond", "weddingring", "rose", "mask", "lipprint", "eighthnote", "sun", "moon", "male", "female", "rainbow"};
    public a a;

    static {
        b.put((Object)"airplane", (Object)2130837582);
        b.put((Object)"alien", (Object)2130837583);
        b.put((Object)"ambition", (Object)2130837585);
        b.put((Object)"angelic", (Object)2130837586);
        b.put((Object)"angry", (Object)2130837587);
        b.put((Object)"apple", (Object)2130837588);
        b.put((Object)"backpack", (Object)2130837591);
        b.put((Object)"balloons", (Object)2130837592);
        b.put((Object)"baseball", (Object)2130837593);
        b.put((Object)"basketball", (Object)2130837594);
        b.put((Object)"beer", (Object)2130837595);
        b.put((Object)"books", (Object)2130837598);
        b.put((Object)"bowling", (Object)2130837600);
        b.put((Object)"burger", (Object)2130837601);
        b.put((Object)"cake", (Object)2130837602);
        b.put((Object)"camera_sticker", (Object)2130837604);
        b.put((Object)"cappuccino", (Object)2130837609);
        b.put((Object)"champagne", (Object)2130837610);
        b.put((Object)"clock", (Object)2130837613);
        b.put((Object)"cold", (Object)2130837617);
        b.put((Object)"compactmirror", (Object)2130837692);
        b.put((Object)"cool", (Object)2130837695);
        b.put((Object)"crown", (Object)2130837699);
        b.put((Object)"crying", (Object)2130837700);
        b.put((Object)"dead", (Object)2130837701);
        b.put((Object)"devilish", (Object)2130837704);
        b.put((Object)"diamond", (Object)2130837705);
        b.put((Object)"dizzy", (Object)2130837706);
        b.put((Object)"eighthnote", (Object)2130837708);
        b.put((Object)"envelope", (Object)2130837711);
        b.put((Object)"female", (Object)2130837717);
        b.put((Object)"fire", (Object)2130837718);
        b.put((Object)"gamecontroller", (Object)2130837973);
        b.put((Object)"ghost", (Object)2130837974);
        b.put((Object)"grinning", (Object)2130837992);
        b.put((Object)"gross", (Object)2130837993);
        b.put((Object)"happy", (Object)2130838003);
        b.put((Object)"heart", (Object)2130838005);
        b.put((Object)"heartbreak", (Object)2130838013);
        b.put((Object)"hmph", (Object)2130838017);
        b.put((Object)"hot", (Object)2130838018);
        b.put((Object)"hotdrink", (Object)2130838019);
        b.put((Object)"icecream", (Object)2130838024);
        b.put((Object)"iceskate", (Object)2130838025);
        b.put((Object)"jersey", (Object)2130838038);
        b.put((Object)"kissleft", (Object)2130838040);
        b.put((Object)"kissright", (Object)2130838041);
        b.put((Object)"laptop", (Object)2130838042);
        b.put((Object)"laugh", (Object)2130838043);
        b.put((Object)"lifepreserver", (Object)2130838044);
        b.put((Object)"lipprint", (Object)2130838047);
        b.put((Object)"lipstick", (Object)2130838048);
        b.put((Object)"locker", (Object)2130838051);
        b.put((Object)"love", (Object)2130838052);
        b.put((Object)"luchador", (Object)2130838053);
        b.put((Object)"luggage", (Object)2130838054);
        b.put((Object)"male", (Object)2130838055);
        b.put((Object)"mask", (Object)2130838056);
        b.put((Object)"moon", (Object)2130838076);
        b.put((Object)"necklace", (Object)2130838079);
        b.put((Object)"ninja", (Object)2130838082);
        b.put((Object)"notebook", (Object)2130838083);
        b.put((Object)"orange", (Object)2130838156);
        b.put((Object)"paintset", (Object)2130838162);
        b.put((Object)"palmtree", (Object)2130838163);
        b.put((Object)"photoop", (Object)2130838164);
        b.put((Object)"pizza", (Object)2130838165);
        b.put((Object)"policeofficer", (Object)2130838169);
        b.put((Object)"popcorn", (Object)2130838170);
        b.put((Object)"present", (Object)2130838175);
        b.put((Object)"purse", (Object)2130838176);
        b.put((Object)"rainbow", (Object)2130838180);
        b.put((Object)"ramen", (Object)2130838181);
        b.put((Object)"redcup", (Object)2130838184);
        b.put((Object)"retrohandheld", (Object)2130838191);
        b.put((Object)"robot", (Object)2130838192);
        b.put((Object)"rose", (Object)2130838193);
        b.put((Object)"sad", (Object)2130838197);
        b.put((Object)"schoolbus", (Object)2130838198);
        b.put((Object)"shock", (Object)2130838206);
        b.put((Object)"shuriken", (Object)2130838207);
        b.put((Object)"shy", (Object)2130838208);
        b.put((Object)"sick", (Object)2130838209);
        b.put((Object)"smartphone", (Object)2130838211);
        b.put((Object)"sneaky", (Object)2130838212);
        b.put((Object)"soccer", (Object)2130838213);
        b.put((Object)"stiletto", (Object)2130838237);
        b.put((Object)"studious", (Object)2130838238);
        b.put((Object)"sun", (Object)2130838239);
        b.put((Object)"sushi", (Object)2130838240);
        b.put((Object)"tablet", (Object)2130838242);
        b.put((Object)"taxi", (Object)2130838247);
        b.put((Object)"tears", (Object)2130838248);
        b.put((Object)"teddybear", (Object)2130838249);
        b.put((Object)"tennis", (Object)2130838250);
        b.put((Object)"tickets", (Object)2130838251);
        b.put((Object)"trophy", (Object)2130838255);
        b.put((Object)"uhhh", (Object)2130838256);
        b.put((Object)"upset", (Object)2130838260);
        b.put((Object)"weddingring", (Object)2130838263);
        b.put((Object)"wine", (Object)2130838269);
        b.put((Object)"wink", (Object)2130838270);
        b.put((Object)"worried", (Object)2130838271);
        b.put((Object)"zombie", (Object)2130838272);
    }

    public StickerKeyboard(Context context) {
        super(context);
        super.a();
    }

    public StickerKeyboard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.a();
    }

    public StickerKeyboard(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        super.a();
    }

    private void a() {
        this.setLayoutManager((RecyclerView.LayoutManager)new GridLayoutManager(this.getContext(), 2, 0, false));
        this.setAdapter((RecyclerView.Adapter)new RecyclerView.Adapter<b>(c.length){
            final /* synthetic */ int a;

            public b a(ViewGroup viewGroup, int n2) {
                View view = LayoutInflater.from((Context)viewGroup.getContext()).inflate(2130968751, viewGroup, false);
                return new b(view);
            }

            public void a(b b2, int n2) {
                String string2 = StickerKeyboard.c[n2];
                if (string2.equals((Object)b2.b)) {
                    return;
                }
                b2.b = string2;
                b2.a.setImageResource(((Integer)StickerKeyboard.b.get((Object)string2)).intValue());
            }

            public int getItemCount() {
                return this.a;
            }

            public /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int n2) {
                this.a((b)viewHolder, n2);
            }

            public /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int n2) {
                return this.a(viewGroup, n2);
            }
        });
    }

    public boolean fling(int n2, int n3) {
        return super.fling((int)(0.8 * (double)n2), n3);
    }

    public static interface a {
        public void clickSticker(String var1);
    }

    public class b
    extends RecyclerView.ViewHolder
    implements View.OnClickListener {
        ImageView a;
        String b;

        public b(View view) {
            super(view);
            this.a = (ImageView)view;
            this.a.setOnClickListener((View.OnClickListener)this);
        }

        public void onClick(View view) {
            if (this.b != null) {
                StickerKeyboard.this.a.clickSticker(this.b);
            }
        }
    }

}

