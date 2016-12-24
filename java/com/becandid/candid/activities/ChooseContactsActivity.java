/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.database.Cursor
 *  android.net.Uri
 *  android.os.Bundle
 *  android.provider.ContactsContract
 *  android.provider.ContactsContract$CommonDataKinds
 *  android.provider.ContactsContract$CommonDataKinds$Phone
 *  android.support.v7.app.AlertDialog
 *  android.support.v7.app.AlertDialog$Builder
 *  android.support.v7.widget.LinearLayoutManager
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$Adapter
 *  android.support.v7.widget.RecyclerView$LayoutManager
 *  android.support.v7.widget.RecyclerView$OnScrollListener
 *  android.text.Editable
 *  android.text.TextWatcher
 *  android.view.View
 *  android.widget.Button
 *  android.widget.EditText
 *  android.widget.FrameLayout
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  butterknife.OnClick
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Set
 */
package com.becandid.candid.activities;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.adapters.ContactsAdapter;
import com.becandid.candid.data.AppState;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ChooseContactsActivity
extends BaseActivity
implements ContactsAdapter.b {
    private ContactsAdapter b;
    private List<ContactsAdapter.a> c;
    @BindView(value=2131624090)
    FrameLayout contactsSearchOuter;
    private HashSet<ContactsAdapter.a> d;
    @BindView(value=2131624088)
    RecyclerView recyclerView;
    @BindView(value=2131624091)
    EditText search;
    @BindView(value=2131624092)
    Button sendInvites;

    /*
     * Enabled aggressive block sorting
     */
    public void filterContacts(String string2) {
        String string3 = string2.toLowerCase();
        ArrayList arrayList = new ArrayList();
        String string4 = "";
        Iterator iterator = this.c.iterator();
        do {
            if (!iterator.hasNext()) {
                this.b.a((List<ContactsAdapter.a>)arrayList);
                return;
            }
            ContactsAdapter.a a2 = (ContactsAdapter.a)iterator.next();
            if (!a2.c.toLowerCase().startsWith(string3)) continue;
            String string5 = a2.c.substring(0, 1).toUpperCase();
            if (!string4.equals((Object)string5)) {
                ContactsAdapter.a a3 = new ContactsAdapter.a();
                a3.g = string5.compareTo("A") < 0 ? "0" : string5;
                string4 = string5;
                arrayList.add((Object)a3);
            }
            arrayList.add((Object)a2);
        } while (true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void getContacts() {
        if (io.a == null) {
            io.a();
        }
        ArrayList arrayList = new ArrayList((Collection)io.a.keySet());
        this.c = new ArrayList();
        Cursor cursor = this.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        HashSet hashSet = new HashSet(16);
        do {
            if (!cursor.moveToNext()) {
                Collections.sort(this.c, (Comparator)new Comparator<ContactsAdapter.a>(){

                    public int compare(ContactsAdapter.a a2, ContactsAdapter.a a3) {
                        return a2.c.toLowerCase().compareTo(a3.c.toLowerCase());
                    }
                });
                this.filterContacts("");
                return;
            }
            String string2 = cursor.getString(cursor.getColumnIndex("data1"));
            if (string2 == null) continue;
            try {
                if (string2.length() < 7) continue;
                PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.a();
                Phonenumber.PhoneNumber phoneNumber = phoneNumberUtil.a(string2, "US");
                ContactsAdapter.a a2 = new ContactsAdapter.a();
                String[] arrstring = cursor.getString(cursor.getColumnIndex("display_name")).split(" ", 2);
                a2.c = arrstring[0];
                String string3 = arrstring.length > 1 ? arrstring[1] : "";
                a2.d = string3;
                a2.e = phoneNumberUtil.a(phoneNumber, PhoneNumberUtil.PhoneNumberFormat.a);
                if (hashSet.contains((Object)a2.e)) continue;
                hashSet.add((Object)a2.e);
                a2.a = (String)arrayList.get(this.c.size() % arrayList.size());
                a2.b = (String)AppState.feedColors.get(this.c.size() % AppState.feedColors.size());
                this.c.add((Object)a2);
            }
            catch (NumberParseException var5_6) {
                var5_6.printStackTrace();
                continue;
            }
            break;
        } while (true);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void invite(ContactsAdapter.a a2, int n2) {
        if (!a2.h) {
            this.d.add((Object)a2);
        } else {
            this.d.remove((Object)a2);
        }
        boolean bl2 = !a2.h;
        a2.h = bl2;
        this.b.notifyItemChanged(n2);
        this.sendInvites.setText((CharSequence)("Invite (" + this.d.size() + ")"));
        if (this.d.size() == 1) {
            this.sendInvites.setEnabled(true);
            return;
        } else {
            if (this.d.size() != 0) return;
            {
                this.sendInvites.setEnabled(false);
                return;
            }
        }
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130968604);
        ButterKnife.bind((Activity)this);
        this.b = new ContactsAdapter();
        this.getContacts();
        this.b.a((ContactsAdapter.b)this);
        this.recyclerView.setAdapter((RecyclerView.Adapter)this.b);
        this.recyclerView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager((Context)this));
        this.recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener(){

            public void onScrolled(RecyclerView recyclerView, int n2, int n3) {
                super.onScrolled(recyclerView, n2, n3);
                ChooseContactsActivity.this.contactsSearchOuter.setY(ChooseContactsActivity.this.contactsSearchOuter.getY() - (float)n3);
            }
        });
        this.search.addTextChangedListener((TextWatcher)new il(){

            public void afterTextChanged(Editable editable) {
                ChooseContactsActivity.this.filterContacts(editable.toString());
            }
        });
        this.d = new HashSet();
    }

    @OnClick(value={2131624092})
    public void sendInvites(View view) {
        new AlertDialog.Builder((Context)this).setTitle((CharSequence)"Invite Contacts").setMessage((CharSequence)"Do you want to anonymously invite your selected contacts?").setCancelable(true).setNegativeButton((CharSequence)this.getResources().getString(2131230890), new DialogInterface.OnClickListener(){

            public void onClick(DialogInterface dialogInterface, int n2) {
            }
        }).setPositiveButton((CharSequence)this.getResources().getString(2131230953), new DialogInterface.OnClickListener(){

            public void onClick(DialogInterface dialogInterface, int n2) {
                Intent intent = new Intent();
                aij aij2 = new aij();
                for (ContactsAdapter.a a2 : ChooseContactsActivity.this.d) {
                    ain ain2 = new ain();
                    String string2 = a2.e;
                    boolean bl2 = false;
                    if (string2 != null) {
                        ain2.a("phone", a2.e);
                        bl2 = true;
                    }
                    if (a2.f != null) {
                        ain2.a("email", a2.f);
                        bl2 = true;
                    }
                    if (!bl2) continue;
                    aij2.a(ain2);
                }
                intent.putExtra("contacts", aij2.toString());
                ChooseContactsActivity.this.setResult(-1, intent);
                ChooseContactsActivity.this.finish();
            }
        }).create().show();
    }

}

