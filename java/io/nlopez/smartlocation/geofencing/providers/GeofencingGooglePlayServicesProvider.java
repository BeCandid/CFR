/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.IntentService
 *  android.app.PendingIntent
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentSender
 *  android.content.IntentSender$SendIntentException
 *  android.location.Location
 *  android.os.Bundle
 *  android.os.Parcelable
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.api.Status
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 */
package io.nlopez.smartlocation.geofencing.providers;

import android.app.Activity;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.location.Location;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class GeofencingGooglePlayServicesProvider
implements xh.b,
xh.c,
xl<Status> {
    public static final String a = GeofencingGooglePlayServicesProvider.class.getCanonicalName() + ".GEOFENCE_TRANSITION";
    private final List<ack> b = Collections.synchronizedList((List)new ArrayList());
    private final List<String> c = Collections.synchronizedList((List)new ArrayList());
    private xh d;
    private aos e;
    private aok f;
    private aoo g;
    private Context h;
    private PendingIntent i;
    private boolean j = false;
    private final aor k;
    private BroadcastReceiver l;

    public GeofencingGooglePlayServicesProvider() {
        this(null);
    }

    public GeofencingGooglePlayServicesProvider(aor aor2) {
        this.l = new BroadcastReceiver(){

            public void onReceive(Context context, Intent intent) {
                if (GeofencingGooglePlayServicesProvider.a.equals((Object)intent.getAction()) && intent.hasExtra("geofences")) {
                    GeofencingGooglePlayServicesProvider.this.e.a("Received geofencing event", new Object[0]);
                    int n2 = intent.getIntExtra("transition", -1);
                    for (String string2 : intent.getStringArrayListExtra("geofences")) {
                        aop aop2 = GeofencingGooglePlayServicesProvider.this.g.a(string2);
                        if (aop2 != null) {
                            GeofencingGooglePlayServicesProvider.this.f.a(new aoq(aop2, n2));
                            continue;
                        }
                        GeofencingGooglePlayServicesProvider.this.e.b("Tried to retrieve geofence " + string2 + " but it was not in the store", new Object[0]);
                    }
                }
            }
        };
        this.k = aor2;
    }

    @Override
    public void a(int n2) {
        this.e.a("onConnectionSuspended " + n2, new Object[0]);
        if (this.k != null) {
            this.k.a(n2);
        }
    }

    @Override
    public void a(Bundle bundle) {
        this.e.a("onConnected", new Object[0]);
        if (this.d.a()) {
            if (this.b.size() > 0) {
                acn.c.a(this.d, this.b, this.i);
                this.b.clear();
            }
            if (this.c.size() > 0) {
                acn.c.a(this.d, this.c);
                this.c.clear();
            }
        }
        if (this.k != null) {
            this.k.a(bundle);
        }
    }

    @Override
    public void a(ConnectionResult connectionResult) {
        this.e.a("onConnectionFailed", new Object[0]);
        if (this.k != null) {
            this.k.a(connectionResult);
        }
    }

    @Override
    public void a(Status status) {
        if (status.f()) {
            this.e.a("Geofencing update request successful", new Object[0]);
            return;
        }
        if (status.e() && this.h instanceof Activity) {
            this.e.b("Unable to register, but we can solve this - will startActivityForResult expecting result code 10003 (if received, please try again)", new Object[0]);
            try {
                status.a((Activity)this.h, 10003);
                return;
            }
            catch (IntentSender.SendIntentException var2_2) {
                this.e.a((Throwable)var2_2, "problem with startResolutionForResult", new Object[0]);
                return;
            }
        }
        this.e.c("Registering failed: " + status.c(), new Object[0]);
    }

    public static class GeofencingService
    extends IntentService {
        public GeofencingService() {
            super(GeofencingService.class.getSimpleName());
        }

        protected void onHandleIntent(Intent intent) {
            acm acm2 = acm.a(intent);
            if (acm2 != null && !acm2.a()) {
                int n2 = acm2.b();
                Intent intent2 = new Intent(GeofencingGooglePlayServicesProvider.a);
                intent2.putExtra("transition", n2);
                intent2.putExtra("location", (Parcelable)acm2.d());
                ArrayList arrayList = new ArrayList();
                Iterator iterator = acm2.c().iterator();
                while (iterator.hasNext()) {
                    arrayList.add((Object)((ack)iterator.next()).a());
                }
                intent2.putStringArrayListExtra("geofences", arrayList);
                this.sendBroadcast(intent2);
            }
        }
    }

}

