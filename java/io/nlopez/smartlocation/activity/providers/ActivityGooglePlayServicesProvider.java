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
 *  android.os.Bundle
 *  android.os.Parcelable
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.location.ActivityRecognitionResult
 *  com.google.android.gms.location.DetectedActivity
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package io.nlopez.smartlocation.activity.providers;

import android.app.Activity;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.DetectedActivity;

public class ActivityGooglePlayServicesProvider
implements xh.b,
xh.c,
xl<Status> {
    private static final String a = ActivityGooglePlayServicesProvider.class.getCanonicalName() + ".DETECTED_ACTIVITY";
    private xh b;
    private aos c;
    private aoi d;
    private aom e;
    private Context f;
    private boolean g = false;
    private boolean h = false;
    private PendingIntent i;
    private aon j;
    private final aor k;
    private BroadcastReceiver l;

    public ActivityGooglePlayServicesProvider() {
        this(null);
    }

    public ActivityGooglePlayServicesProvider(aor aor2) {
        this.l = new BroadcastReceiver(){

            public void onReceive(Context context, Intent intent) {
                if (a.equals((Object)intent.getAction()) && intent.hasExtra("activity")) {
                    ActivityGooglePlayServicesProvider.this.c.a("sending new activity", new Object[0]);
                    DetectedActivity detectedActivity = (DetectedActivity)intent.getParcelableExtra("activity");
                    ActivityGooglePlayServicesProvider.this.a(detectedActivity);
                }
            }
        };
        this.k = aor2;
    }

    @Override
    private void a(aon aon2) {
        if (this.b.a()) {
            this.i = PendingIntent.getService((Context)this.f, (int)0, (Intent)new Intent(this.f, (Class)ActivityRecognitionService.class), (int)134217728);
            acf.b.a(this.b, aon2.a(), this.i).a((xl<Status>)this);
        }
    }

    @Override
    private void a(DetectedActivity detectedActivity) {
        if (this.d != null) {
            this.d.a(detectedActivity);
        }
        if (this.e != null) {
            this.e.a("GMS", detectedActivity);
        }
    }

    @Override
    public void a(int n2) {
        this.c.a("onConnectionSuspended " + n2, new Object[0]);
        if (this.k != null) {
            this.k.a(n2);
        }
    }

    @Override
    public void a(Bundle bundle) {
        this.c.a("onConnected", new Object[0]);
        if (this.g) {
            super.a(this.j);
        }
        if (this.k != null) {
            this.k.a(bundle);
        }
    }

    @Override
    public void a(ConnectionResult connectionResult) {
        this.c.a("onConnectionFailed", new Object[0]);
        if (this.k != null) {
            this.k.a(connectionResult);
        }
    }

    @Override
    public void a(Status status) {
        if (status.f()) {
            this.c.a("Activity update request successful", new Object[0]);
            return;
        }
        if (status.e() && this.f instanceof Activity) {
            this.c.b("Unable to register, but we can solve this - will startActivityForResult expecting result code 10002 (if received, please try again)", new Object[0]);
            try {
                status.a((Activity)this.f, 10002);
                return;
            }
            catch (IntentSender.SendIntentException var2_2) {
                this.c.a((Throwable)var2_2, "problem with startResolutionForResult", new Object[0]);
                return;
            }
        }
        this.c.c("Registering failed: " + status.c(), new Object[0]);
    }

    public static class ActivityRecognitionService
    extends IntentService {
        public ActivityRecognitionService() {
            super(ActivityRecognitionService.class.getSimpleName());
        }

        protected void onHandleIntent(Intent intent) {
            if (ActivityRecognitionResult.a((Intent)intent)) {
                DetectedActivity detectedActivity = ActivityRecognitionResult.b((Intent)intent).a();
                Intent intent2 = new Intent(a);
                intent2.putExtra("activity", (Parcelable)detectedActivity);
                this.sendBroadcast(intent2);
            }
        }
    }

}

