/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.database.Cursor
 *  android.location.Location
 *  android.location.LocationListener
 *  android.location.LocationManager
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.provider.ContactsContract
 *  android.provider.ContactsContract$CommonDataKinds
 *  android.provider.ContactsContract$CommonDataKinds$Phone
 *  android.support.multidex.MultiDexApplication
 *  android.util.Log
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.SecurityException
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.HashSet
 *  java.util.List
 */
package com.becandid.candid;

import android.app.Activity;
import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.database.Cursor;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.ContactsContract;
import android.support.multidex.MultiDexApplication;
import android.util.Log;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.ContactsInfo;
import com.becandid.candid.services.ConnectivityReceiver;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GossipApplication
extends MultiDexApplication {
    public static volatile Context a;
    public static volatile Handler b;
    public static jz c;
    public static String d;
    private static volatile GossipApplication e;
    private a f;

    static {
        d = "https://becandid.com/";
    }

    public static GossipApplication a() {
        return e;
    }

    public void a(ConnectivityReceiver.a a2) {
        ConnectivityReceiver.a = a2;
    }

    public void a(final String string2) {
        LocationManager locationManager = (LocationManager)this.getSystemService("location");
        try {
            locationManager.requestSingleUpdate(string2, new LocationListener(){

                /*
                 * Enabled aggressive block sorting
                 */
                public void onLocationChanged(Location location) {
                    if (string2.equals((Object)"network") && AppState.locationProvider != null && AppState.locationProvider.equals((Object)"passive")) {
                        AppState.location = location;
                        AppState.locationProvider = string2;
                    } else if (string2.equals((Object)"passive") && AppState.locationProvider == null) {
                        AppState.location = location;
                        AppState.locationProvider = string2;
                    }
                    ix.a().a(new in.w());
                }

                public void onProviderDisabled(String string22) {
                }

                public void onProviderEnabled(String string22) {
                }

                public void onStatusChanged(String string22, int n2, Bundle bundle) {
                }
            }, null);
            return;
        }
        catch (SecurityException var3_3) {
            Log.e((String)"Location", (String)var3_3.toString());
            return;
        }
    }

    protected void b() {
        ul.a(this.getApplicationContext());
        alc[] arralc = new alc[]{new rj()};
        akx.a((Context)this, arralc);
        c = jx.b(a);
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void c() {
        if (bb.checkSelfPermission(a, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
            return;
        }
        LocationManager locationManager = (LocationManager)this.getSystemService("location");
        if (locationManager.getAllProviders().contains((Object)"passive") && locationManager.isProviderEnabled("passive")) {
            this.a("passive");
        }
        if (!locationManager.getAllProviders().contains((Object)"network")) return;
        if (!locationManager.isProviderEnabled("network")) return;
        this.a("network");
    }

    public void d() {
        if (AppState.contactsInfo == null) {
            AppState.contactsInfo = new ContactsInfo();
        }
        Cursor cursor = this.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        while (cursor != null && cursor.moveToNext()) {
            String string2 = cursor.getString(cursor.getColumnIndex("data1"));
            try {
                PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.a();
                Phonenumber.PhoneNumber phoneNumber = phoneNumberUtil.a(string2, "US");
                AppState.contactsInfo.contacts.add((Object)phoneNumberUtil.a(phoneNumber, PhoneNumberUtil.PhoneNumberFormat.a));
            }
            catch (NumberParseException var3_5) {
                var3_5.printStackTrace();
            }
        }
    }

    public void onCreate() {
        super.onCreate();
        a = this.getApplicationContext();
        b = new Handler(Looper.getMainLooper());
        e = this;
        this.f = new a();
        AppState.expandedPostIds = new HashSet();
        this.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)this.f);
        this.b();
        AppState.loadState((ContextWrapper)this);
    }

    class a
    implements Application.ActivityLifecycleCallbacks {
        public int a;
        public int b;
        public boolean c;

        a() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
            this.b = 1 + this.b;
            if (this.a == this.b) {
                AppState.saveState((ContextWrapper)GossipApplication.this);
            }
        }

        public void onActivityResumed(Activity activity) {
            this.a = 1 + this.a;
            if (this.c) {
                AppState.loadState((ContextWrapper)GossipApplication.this);
            }
            this.c = false;
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

}

