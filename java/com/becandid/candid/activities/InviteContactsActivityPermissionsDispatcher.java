/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.support.v4.app.ActivityCompat
 *  android.view.View
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ref.WeakReference
 */
package com.becandid.candid.activities;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import com.becandid.candid.activities.InviteContactsActivity;
import java.lang.ref.WeakReference;

final class InviteContactsActivityPermissionsDispatcher {
    private static final String[] a = new String[]{"android.permission.READ_CONTACTS"};
    private static api b;
    private static final String[] c;
    private static api d;

    static {
        c = new String[]{"android.permission.READ_CONTACTS"};
    }

    private InviteContactsActivityPermissionsDispatcher() {
    }

    /*
     * Enabled aggressive block sorting
     */
    static void a(InviteContactsActivity inviteContactsActivity, int n2, int[] arrn) {
        switch (n2) {
            case 0: {
                if (apj.a((Context)inviteContactsActivity) < 23 && !apj.a((Context)inviteContactsActivity, a)) return;
                {
                    if (apj.a(arrn) && b != null) {
                        b.grant();
                    }
                    b = null;
                    return;
                }
            }
            default: {
                return;
            }
            case 1: 
        }
        if (apj.a((Context)inviteContactsActivity) < 23 && !apj.a((Context)inviteContactsActivity, c)) return;
        {
            if (apj.a(arrn) && d != null) {
                d.grant();
            }
            d = null;
            return;
        }
    }

    static void a(InviteContactsActivity inviteContactsActivity, View view) {
        if (apj.a((Context)inviteContactsActivity, a)) {
            inviteContactsActivity.inviteAll(view);
            return;
        }
        b = new InviteAllPermissionRequest(inviteContactsActivity, view, null);
        ActivityCompat.requestPermissions((Activity)inviteContactsActivity, (String[])a, (int)0);
    }

    static void b(InviteContactsActivity inviteContactsActivity, View view) {
        if (apj.a((Context)inviteContactsActivity, c)) {
            inviteContactsActivity.chooseContacts(view);
            return;
        }
        d = new ChooseContactsPermissionRequest(inviteContactsActivity, view, null);
        ActivityCompat.requestPermissions((Activity)inviteContactsActivity, (String[])c, (int)1);
    }

    static final class ChooseContactsPermissionRequest
    implements api {
        private final WeakReference<InviteContactsActivity> a;
        private final View b;

        private ChooseContactsPermissionRequest(InviteContactsActivity inviteContactsActivity, View view) {
            this.a = new WeakReference((Object)inviteContactsActivity);
            this.b = view;
        }

        /* synthetic */ ChooseContactsPermissionRequest(InviteContactsActivity inviteContactsActivity, View view,  var3_2) {
            super(inviteContactsActivity, view);
        }

        public void cancel() {
        }

        @Override
        public void grant() {
            InviteContactsActivity inviteContactsActivity = (InviteContactsActivity)this.a.get();
            if (inviteContactsActivity == null) {
                return;
            }
            inviteContactsActivity.chooseContacts(this.b);
        }

        public void proceed() {
            InviteContactsActivity inviteContactsActivity = (InviteContactsActivity)this.a.get();
            if (inviteContactsActivity == null) {
                return;
            }
            ActivityCompat.requestPermissions((Activity)inviteContactsActivity, (String[])c, (int)1);
        }
    }

    static final class InviteAllPermissionRequest
    implements api {
        private final WeakReference<InviteContactsActivity> a;
        private final View b;

        private InviteAllPermissionRequest(InviteContactsActivity inviteContactsActivity, View view) {
            this.a = new WeakReference((Object)inviteContactsActivity);
            this.b = view;
        }

        /* synthetic */ InviteAllPermissionRequest(InviteContactsActivity inviteContactsActivity, View view,  var3_2) {
            super(inviteContactsActivity, view);
        }

        public void cancel() {
        }

        @Override
        public void grant() {
            InviteContactsActivity inviteContactsActivity = (InviteContactsActivity)this.a.get();
            if (inviteContactsActivity == null) {
                return;
            }
            inviteContactsActivity.inviteAll(this.b);
        }

        public void proceed() {
            InviteContactsActivity inviteContactsActivity = (InviteContactsActivity)this.a.get();
            if (inviteContactsActivity == null) {
                return;
            }
            ActivityCompat.requestPermissions((Activity)inviteContactsActivity, (String[])a, (int)0);
        }
    }

}

