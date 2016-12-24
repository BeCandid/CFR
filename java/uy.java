/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.util.Log
 *  java.io.Serializable
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.Set
 *  java.util.concurrent.Executors
 *  java.util.concurrent.ScheduledExecutorService
 *  java.util.concurrent.ScheduledFuture
 *  java.util.concurrent.TimeUnit
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AccessTokenAppIdPair;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.FlushReason;
import com.facebook.appevents.FlushResult;
import com.facebook.appevents.PersistedEvents;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class uy {
    private static final String a = uy.class.getName();
    private static volatile ux b = new ux();
    private static final ScheduledExecutorService c = Executors.newSingleThreadScheduledExecutor();
    private static ScheduledFuture d;
    private static final Runnable e;

    static {
        e = new Runnable(){

            public void run() {
                d = null;
                if (AppEventsLogger.a() != AppEventsLogger.FlushBehavior.b) {
                    uy.b(FlushReason.b);
                }
            }
        };
    }

    uy() {
    }

    private static GraphRequest a(final AccessTokenAppIdPair accessTokenAppIdPair, final vb vb2, boolean bl2, final va va2) {
        String string2 = accessTokenAppIdPair.b();
        we.b b2 = we.a(string2, false);
        final GraphRequest graphRequest = GraphRequest.a(null, String.format((String)"%s/activities", (Object[])new Object[]{string2}), null, null);
        Bundle bundle = graphRequest.e();
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("access_token", accessTokenAppIdPair.a());
        String string3 = AppEventsLogger.c();
        if (string3 != null) {
            bundle.putString("device_token", string3);
        }
        graphRequest.a(bundle);
        if (b2 == null) {
            return null;
        }
        int n2 = vb2.a(graphRequest, AppEventsLogger.d(), b2.a(), bl2);
        if (n2 == 0) {
            return null;
        }
        va2.a = n2 + va2.a;
        graphRequest.a(new GraphRequest.b(){

            @Override
            public void onCompleted(uo uo2) {
                uy.b(accessTokenAppIdPair, graphRequest, uo2, vb2, va2);
            }
        });
        return graphRequest;
    }

    public static Set<AccessTokenAppIdPair> a() {
        return b.a();
    }

    private static va a(FlushReason flushReason, ux ux2) {
        va va2 = new va();
        boolean bl2 = ul.b(AppEventsLogger.d());
        ArrayList arrayList = new ArrayList();
        for (AccessTokenAppIdPair accessTokenAppIdPair : ux2.a()) {
            GraphRequest graphRequest = uy.a(accessTokenAppIdPair, ux2.a(accessTokenAppIdPair), bl2, va2);
            if (graphRequest == null) continue;
            arrayList.add((Object)graphRequest);
        }
        if (arrayList.size() > 0) {
            LoggingBehavior loggingBehavior = LoggingBehavior.e;
            String string2 = a;
            Object[] arrobject = new Object[]{va2.a, flushReason.toString()};
            vx.a(loggingBehavior, string2, "Flushing %d events due to %s.", arrobject);
            Iterator iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                ((GraphRequest)iterator.next()).i();
            }
        } else {
            va2 = null;
        }
        return va2;
    }

    public static void a(final AccessTokenAppIdPair accessTokenAppIdPair, final AppEvent appEvent) {
        c.execute(new Runnable(){

            /*
             * Enabled aggressive block sorting
             */
            public void run() {
                b.a(accessTokenAppIdPair, appEvent);
                if (AppEventsLogger.a() != AppEventsLogger.FlushBehavior.b && b.b() > 100) {
                    uy.b(FlushReason.e);
                    return;
                } else {
                    if (d != null) return;
                    {
                        d = c.schedule(e, 15, TimeUnit.SECONDS);
                        return;
                    }
                }
            }
        });
    }

    public static void a(final FlushReason flushReason) {
        c.execute(new Runnable(){

            public void run() {
                uy.b(flushReason);
            }
        });
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void b(final AccessTokenAppIdPair accessTokenAppIdPair, GraphRequest graphRequest, uo uo2, final vb vb2, va va2) {
        FacebookRequestError facebookRequestError = uo2.a();
        String string2 = "Success";
        FlushResult flushResult = FlushResult.a;
        if (facebookRequestError != null) {
            if (facebookRequestError.b() == -1) {
                string2 = "Failed: No Connectivity";
                flushResult = FlushResult.c;
            } else {
                Object[] arrobject = new Object[]{uo2.toString(), facebookRequestError.toString()};
                string2 = String.format((String)"Failed:\n  Response: %s\n  Error %s", (Object[])arrobject);
                flushResult = FlushResult.b;
            }
        }
        if (ul.a(LoggingBehavior.e)) {
            String string3;
            String string4 = (String)graphRequest.h();
            try {
                String string5;
                string3 = string5 = new JSONArray(string4).toString(2);
            }
            catch (JSONException var10_16) {
                string3 = "<Can't encode events for debug logging>";
            }
            LoggingBehavior loggingBehavior = LoggingBehavior.e;
            String string6 = a;
            Object[] arrobject = new Object[]{graphRequest.a().toString(), string2, string3};
            vx.a(loggingBehavior, string6, "Flush completed\nParams: %s\n  Result: %s\n  Events JSON: %s", arrobject);
        }
        boolean bl2 = facebookRequestError != null;
        vb2.a(bl2);
        if (flushResult == FlushResult.c) {
            ul.d().execute(new Runnable(){

                public void run() {
                    uz.a(accessTokenAppIdPair, vb2);
                }
            });
        }
        if (flushResult != FlushResult.a && va2.b != FlushResult.c) {
            va2.b = flushResult;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static void b(FlushReason flushReason) {
        PersistedEvents persistedEvents = uz.a();
        b.a(persistedEvents);
        try {
            va va2 = uy.a(flushReason, b);
            if (va2 == null) return;
        }
        catch (Exception var2_4) {
            Log.w((String)a, (String)"Caught unexpected exception while flushing app events: ", (Throwable)var2_4);
            return;
        }
        Intent intent = new Intent("com.facebook.sdk.APP_EVENTS_FLUSHED");
        intent.putExtra("com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED", va2.a);
        intent.putExtra("com.facebook.sdk.APP_EVENTS_FLUSH_RESULT", (Serializable)va2.b);
        bn.a(AppEventsLogger.d()).a(intent);
    }

}

