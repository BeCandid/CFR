/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.os.Bundle
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.UUID
 *  java.util.concurrent.ScheduledFuture
 *  java.util.concurrent.ScheduledThreadPoolExecutor
 *  java.util.concurrent.TimeUnit
 */
package com.facebook.appevents;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AccessTokenAppIdPair;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.FlushReason;
import java.util.HashSet;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AppEventsLogger {
    private static final String a = AppEventsLogger.class.getCanonicalName();
    private static ScheduledThreadPoolExecutor d;
    private static FlushBehavior e;
    private static Context f;
    private static Object g;
    private static String h;
    private static boolean i;
    private static String j;
    private final String b;
    private final AccessTokenAppIdPair c;

    static {
        e = FlushBehavior.a;
        g = new Object();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private AppEventsLogger(Context context, String string2, AccessToken accessToken) {
        Object object;
        wf.a((Object)context, "context");
        this.b = we.c(context);
        if (accessToken == null) {
            accessToken = AccessToken.a();
        }
        if (accessToken != null && (string2 == null || string2.equals((Object)accessToken.h()))) {
            this.c = new AccessTokenAppIdPair(accessToken);
        } else {
            if (string2 == null) {
                string2 = we.a(context);
            }
            this.c = new AccessTokenAppIdPair(null, string2);
        }
        Object object2 = object = g;
        synchronized (object2) {
            if (f == null) {
                f = context.getApplicationContext();
            }
        }
        AppEventsLogger.f();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static FlushBehavior a() {
        Object object;
        Object object2 = object = g;
        synchronized (object2) {
            return e;
        }
    }

    public static AppEventsLogger a(Context context) {
        return new AppEventsLogger(context, null, null);
    }

    public static AppEventsLogger a(Context context, String string2) {
        return new AppEventsLogger(context, string2, null);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static void a(Context context, AppEvent appEvent, AccessTokenAppIdPair accessTokenAppIdPair) {
        uy.a(accessTokenAppIdPair, appEvent);
        if (appEvent.b() || i) return;
        if (appEvent.a() == "fb_mobile_activate_app") {
            i = true;
            return;
        }
        vx.a(LoggingBehavior.e, "AppEvents", "Warning: Please call AppEventsLogger.activateApp(...)from the long-lived activity's onResume() methodbefore logging other app events.");
    }

    private void a(String string2, Double d2, Bundle bundle, boolean bl2, UUID uUID) {
        AppEvent appEvent = new AppEvent(this.b, string2, d2, bundle, bl2, uUID);
        AppEventsLogger.a(f, appEvent, this.c);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String b(Context context) {
        if (h == null) {
            Object object;
            Object object2 = object = g;
            synchronized (object2) {
                if (h == null && (AppEventsLogger.h = context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getString("anonymousAppDeviceGUID", null)) == null) {
                    h = "XZ" + UUID.randomUUID().toString();
                    context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit().putString("anonymousAppDeviceGUID", h).apply();
                }
            }
        }
        return h;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String c() {
        Object object;
        Object object2 = object = g;
        synchronized (object2) {
            return j;
        }
    }

    public static Context d() {
        return f;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void f() {
        Object object;
        Object object2 = object = g;
        synchronized (object2) {
            if (d != null) {
                return;
            }
            d = new ScheduledThreadPoolExecutor(1);
        }
        Runnable runnable = new Runnable(){

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public void run() {
                Object object;
                HashSet hashSet = new HashSet();
                Object object2 = object = g;
                synchronized (object2) {
                    Iterator iterator = uy.a().iterator();
                    while (iterator.hasNext()) {
                        hashSet.add((Object)((AccessTokenAppIdPair)iterator.next()).b());
                    }
                }
                Iterator iterator = hashSet.iterator();
                while (iterator.hasNext()) {
                    we.a((String)iterator.next(), true);
                }
                return;
            }
        };
        d.scheduleAtFixedRate(runnable, 0, 86400, TimeUnit.SECONDS);
    }

    public void a(String string2, Bundle bundle) {
        super.a(string2, null, bundle, false, vc.a());
    }

    public void a(String string2, Double d2, Bundle bundle) {
        super.a(string2, d2, bundle, true, vc.a());
    }

    public void b() {
        uy.a(FlushReason.a);
    }

    public static final class FlushBehavior
    extends Enum<FlushBehavior> {
        public static final /* enum */ FlushBehavior a = new FlushBehavior();
        public static final /* enum */ FlushBehavior b = new FlushBehavior();
        private static final /* synthetic */ FlushBehavior[] c;

        static {
            FlushBehavior[] arrflushBehavior = new FlushBehavior[]{a, b};
            c = arrflushBehavior;
        }

        private FlushBehavior() {
            super(string2, n2);
        }

        public static FlushBehavior valueOf(String string2) {
            return (FlushBehavior)Enum.valueOf((Class)FlushBehavior.class, (String)string2);
        }

        public static FlushBehavior[] values() {
            return (FlushBehavior[])c.clone();
        }
    }

}

