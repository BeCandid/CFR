/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.IntentService
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.location.Address
 *  android.location.Geocoder
 *  android.location.Location
 *  android.os.Parcelable
 *  java.io.IOException
 *  java.io.Serializable
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Locale
 *  java.util.Set
 */
package io.nlopez.smartlocation.geocoding.providers;

import android.app.IntentService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Parcelable;
import io.nlopez.smartlocation.geocoding.utils.LocationAddress;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class AndroidGeocodingProvider {
    private static final String a = AndroidGeocodingProvider.class.getCanonicalName() + ".DIRECT_GEOCODE_ACTION";
    private static final String b = AndroidGeocodingProvider.class.getCanonicalName() + ".REVERSE_GEOCODE_ACTION";
    private Locale c;
    private aoj d;
    private aol e;
    private HashMap<String, Integer> f;
    private HashMap<Location, Integer> g;
    private aos h;
    private BroadcastReceiver i;
    private BroadcastReceiver j;

    public AndroidGeocodingProvider() {
        this(Locale.getDefault());
    }

    public AndroidGeocodingProvider(Locale locale) {
        this.i = new BroadcastReceiver(){

            public void onReceive(Context context, Intent intent) {
                if (a.equals((Object)intent.getAction())) {
                    AndroidGeocodingProvider.this.h.a("sending new direct geocoding response", new Object[0]);
                    if (AndroidGeocodingProvider.this.d != null) {
                        String string2 = intent.getStringExtra("name");
                        ArrayList arrayList = intent.getParcelableArrayListExtra("result");
                        AndroidGeocodingProvider.this.d.a(string2, (List<LocationAddress>)arrayList);
                    }
                }
            }
        };
        this.j = new BroadcastReceiver(){

            public void onReceive(Context context, Intent intent) {
                if (b.equals((Object)intent.getAction())) {
                    AndroidGeocodingProvider.this.h.a("sending new reverse geocoding response", new Object[0]);
                    if (AndroidGeocodingProvider.this.e != null) {
                        Location location = (Location)intent.getParcelableExtra("location");
                        ArrayList arrayList = (ArrayList)intent.getSerializableExtra("result");
                        AndroidGeocodingProvider.this.e.a(location, (List<Address>)arrayList);
                    }
                }
            }
        };
        if (locale == null) {
            throw new RuntimeException("Locale is null");
        }
        this.c = locale;
        this.f = new HashMap();
        this.g = new HashMap();
        if (!Geocoder.isPresent()) {
            throw new RuntimeException("Android Geocoder not present. Please check if Geocoder.isPresent() before invoking the search");
        }
    }

    public static class AndroidGeocodingService
    extends IntentService {
        private Geocoder a;

        public AndroidGeocodingService() {
            super(AndroidGeocodingService.class.getSimpleName());
        }

        private ArrayList<Address> a(Location location, int n2) {
            try {
                ArrayList arrayList = new ArrayList((Collection)this.a.getFromLocation(location.getLatitude(), location.getLongitude(), n2));
                return arrayList;
            }
            catch (IOException var4_4) {
                return new ArrayList();
            }
        }

        private ArrayList<LocationAddress> a(String string2, int n2) {
            ArrayList arrayList;
            try {
                List list = this.a.getFromLocationName(string2, n2);
                arrayList = new ArrayList();
                Iterator iterator = list.iterator();
                while (iterator.hasNext()) {
                    arrayList.add((Object)new LocationAddress((Address)iterator.next()));
                }
            }
            catch (IOException var3_6) {
                arrayList = new ArrayList();
            }
            return arrayList;
        }

        private void a(Location location, ArrayList<Address> arrayList) {
            Intent intent = new Intent(b);
            intent.putExtra("location", (Parcelable)location);
            intent.putExtra("result", arrayList);
            this.sendBroadcast(intent);
        }

        private void a(String string2, ArrayList<LocationAddress> arrayList) {
            Intent intent = new Intent(a);
            intent.putExtra("name", string2);
            intent.putExtra("result", arrayList);
            this.sendBroadcast(intent);
        }

        /*
         * Enabled aggressive block sorting
         */
        protected void onHandleIntent(Intent intent) {
            Locale locale = (Locale)intent.getSerializableExtra("locale");
            this.a = locale == null ? new Geocoder((Context)this) : new Geocoder((Context)this, locale);
            if (intent.hasExtra("direct")) {
                HashMap hashMap = (HashMap)intent.getSerializableExtra("direct");
                for (String string2 : hashMap.keySet()) {
                    super.a(string2, super.a(string2, (int)((Integer)hashMap.get((Object)string2))));
                }
            }
            if (intent.hasExtra("reverse")) {
                HashMap hashMap = (HashMap)intent.getSerializableExtra("reverse");
                for (Location location : hashMap.keySet()) {
                    super.a(location, super.a(location, (int)((Integer)hashMap.get((Object)location))));
                }
            }
        }
    }

}

