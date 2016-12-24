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
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.FragmentManager
 *  android.support.v4.app.FragmentTransaction
 *  android.support.v7.app.AlertDialog
 *  android.support.v7.app.AlertDialog$Builder
 *  android.view.KeyEvent
 *  android.view.View
 *  android.widget.FrameLayout
 *  android.widget.Toast
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Set
 *  rx.schedulers.Schedulers
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
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.activities.ChooseContactsActivity;
import com.becandid.candid.activities.InviteContactsActivityPermissionsDispatcher;
import com.becandid.candid.adapters.ContactsAdapter;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Config;
import com.becandid.candid.data.DataUtil;
import com.becandid.candid.data.EmptyClass;
import com.becandid.candid.fragments.InviteContactMethodFragment;
import com.becandid.candid.fragments.InviteContactPeopleFragment;
import com.becandid.candid.fragments.InviteContactSentFragment;
import com.becandid.candid.models.EmptySubscriber;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import rx.schedulers.Schedulers;

public class InviteContactsActivity
extends BaseActivity {
    public static final int CHOOSE_CONTACTS = 101;
    Activity b;
    int c = -1;
    int d = 0;
    String e;
    @BindView(value=2131624107)
    FrameLayout mPlaceholder;
    public String sendInviteName;

    private void a() {
        InviteContactMethodFragment inviteContactMethodFragment = new InviteContactMethodFragment();
        FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(2131034128, 2131034129, 2131034130, 2131034131);
        fragmentTransaction.replace(2131624107, (Fragment)inviteContactMethodFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void chooseContacts(View view) {
        this.startActivityForResult(new Intent((Context)this, (Class)ChooseContactsActivity.class), 101);
    }

    public void chooseContactsWithCheck(View view) {
        InviteContactsActivityPermissionsDispatcher.b((InviteContactsActivity)this.b, view);
    }

    public aij getContacts() {
        new ArrayList((Collection)io.a.keySet());
        aij aij2 = new aij();
        Cursor cursor = this.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        HashSet hashSet = new HashSet(16);
        while (cursor.moveToNext()) {
            String string2 = cursor.getString(cursor.getColumnIndex("data1"));
            if (string2 == null) continue;
            try {
                if (string2.length() < 7) continue;
                PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.a();
                Phonenumber.PhoneNumber phoneNumber = phoneNumberUtil.a(string2, "US");
                new ContactsAdapter.a();
                String string3 = phoneNumberUtil.a(phoneNumber, PhoneNumberUtil.PhoneNumberFormat.a);
                if (hashSet.contains((Object)string3)) continue;
                hashSet.add((Object)string3);
                aij2.a(DataUtil.newJsonObject("phone", string3));
            }
            catch (NumberParseException var6_8) {
                var6_8.printStackTrace();
            }
        }
        return aij2;
    }

    public void inviteAll(View view) {
        new AlertDialog.Builder((Context)this).setTitle((CharSequence)"Invite Contacts").setMessage((CharSequence)"Do you want to anonymously invite your selected contacts?").setCancelable(true).setNegativeButton((CharSequence)this.getResources().getString(2131230890), new DialogInterface.OnClickListener(){

            public void onClick(DialogInterface dialogInterface, int n2) {
            }
        }).setPositiveButton((CharSequence)this.getResources().getString(2131230953), new DialogInterface.OnClickListener(){

            public void onClick(DialogInterface dialogInterface, int n2) {
                String string2 = InviteContactsActivity.this.getContacts().toString();
                InviteContactsActivity.this.setSendInviteData(string2);
                if (AppState.config.getInt("enable_new_invite_flow", 0) == 1) {
                    InviteContactsActivity.this.a();
                    rk.c().a(new ru("New Text Invite FLow"));
                    return;
                }
                InviteContactsActivity.this.sendContactsToServer();
                rk.c().a(new ru("Old Text Invite Flow"));
            }
        }).create().show();
    }

    public void inviteAllWithCheck(View view) {
        InviteContactsActivityPermissionsDispatcher.a((InviteContactsActivity)this.b, view);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    protected void onActivityResult(int n2, int n3, Intent intent) {
        super.onActivityResult(n2, n3, intent);
        if (n2 != 101 || n3 != -1) return;
        this.setSendInviteData(intent.getStringExtra("contacts"));
        if (AppState.config.getInt("enable_new_invite_flow", 0) == 1) {
            super.a();
            rk.c().a(new ru("New Text Invite FLow"));
            return;
        }
        this.sendContactsToServer();
        rk.c().a(new ru("Old Text Invite Flow"));
    }

    public void onBackPressed() {
        if (this.getSupportFragmentManager().findFragmentById(2131624107) instanceof InviteContactSentFragment) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130968615);
        ButterKnife.bind((Activity)this);
        this.setResult(0);
        this.b = this;
        if (this.mPlaceholder == null || bundle != null) {
            return;
        }
        InviteContactPeopleFragment inviteContactPeopleFragment = new InviteContactPeopleFragment();
        inviteContactPeopleFragment.setArguments(this.getIntent().getExtras());
        this.getSupportFragmentManager().beginTransaction().add(2131624107, (Fragment)inviteContactPeopleFragment).commit();
    }

    public boolean onKeyDown(int n2, KeyEvent keyEvent) {
        if (n2 == 4 && keyEvent.getRepeatCount() == 0) {
            this.onBackPressed();
        }
        return super.onKeyDown(n2, keyEvent);
    }

    @Override
    public void onRequestPermissionsResult(int n2, String[] arrstring, int[] arrn) {
        super.onRequestPermissionsResult(n2, arrstring, arrn);
        InviteContactsActivityPermissionsDispatcher.a((InviteContactsActivity)this, n2, arrn);
    }

    public void sendContactsToServer() {
        String string2 = this.getIntent().getStringExtra("upsell_id");
        ik.a().a(this.e, string2, this.sendInviteName).b(Schedulers.io()).a(apv.a()).b(new apr<EmptyClass>(){

            @Override
            public void onCompleted() {
                if (InviteContactsActivity.this.c != -1 || InviteContactsActivity.this.d != 0) {
                    ik.a().e(InviteContactsActivity.this.c).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
                    Intent intent = new Intent();
                    intent.putExtra("upsellId", InviteContactsActivity.this.d);
                    InviteContactsActivity.this.setResult(-1, intent);
                    if (AppState.config.getInt("enable_new_invite_flow", 0) != 1) {
                        InviteContactsActivity.this.finish();
                        Toast.makeText((Context)InviteContactsActivity.this.getBaseContext(), (CharSequence)"Your friends have been notified. Thanks!", (int)1).show();
                    }
                }
            }

            @Override
            public void onError(Throwable throwable) {
            }

            @Override
            public void onNext(EmptyClass emptyClass) {
            }
        });
    }

    public void setGroupId(int n2) {
        this.c = n2;
    }

    public void setSendInviteData(String string2) {
        this.e = string2;
    }

    public void setSendInviteName(String string2) {
        this.sendInviteName = string2;
    }

    public void setUpsellId(int n2) {
        this.d = n2;
    }

    public void switchFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(2131034128, 2131034129, 2131034130, 2131034131);
        fragmentTransaction.replace(2131624107, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public static final class InviteFlowTypes
    extends Enum<InviteFlowTypes> {
        public static final /* enum */ InviteFlowTypes DOWNLOAD = new InviteFlowTypes("Download");
        public static final /* enum */ InviteFlowTypes GROUP = new InviteFlowTypes("Group");
        public static final /* enum */ InviteFlowTypes POST = new InviteFlowTypes("Post");
        private static final /* synthetic */ InviteFlowTypes[] b;
        private String a;

        static {
            InviteFlowTypes[] arrinviteFlowTypes = new InviteFlowTypes[]{DOWNLOAD, GROUP, POST};
            b = arrinviteFlowTypes;
        }

        private InviteFlowTypes(String string3) {
            super(string2, n2);
            this.a = string3;
        }

        public static InviteFlowTypes valueOf(String string2) {
            return (InviteFlowTypes)Enum.valueOf((Class)InviteFlowTypes.class, (String)string2);
        }

        public static InviteFlowTypes[] values() {
            return (InviteFlowTypes[])b.clone();
        }

        public String toString() {
            return this.a;
        }
    }

}

