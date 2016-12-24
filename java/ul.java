/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.Signature
 *  android.os.AsyncTask
 *  android.os.Bundle
 *  android.util.Base64
 *  java.io.File
 *  java.lang.Boolean
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.Void
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.Locale
 *  java.util.concurrent.BlockingQueue
 *  java.util.concurrent.Callable
 *  java.util.concurrent.Executor
 *  java.util.concurrent.FutureTask
 *  java.util.concurrent.LinkedBlockingQueue
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.atomic.AtomicInteger
 *  java.util.concurrent.atomic.AtomicLong
 */
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Base64;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.BoltsMeasurementEventListener;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class ul {
    private static final String a = ul.class.getCanonicalName();
    private static final HashSet<LoggingBehavior> b;
    private static volatile Executor c;
    private static volatile String d;
    private static volatile String e;
    private static volatile String f;
    private static volatile int g;
    private static volatile String h;
    private static AtomicLong i;
    private static volatile boolean j;
    private static boolean k;
    private static vw<File> l;
    private static Context m;
    private static int n;
    private static final Object o;
    private static final BlockingQueue<Runnable> p;
    private static final ThreadFactory q;
    private static Boolean r;

    static {
        LoggingBehavior[] arrloggingBehavior = new LoggingBehavior[]{LoggingBehavior.f};
        b = new HashSet((Collection)Arrays.asList((Object[])arrloggingBehavior));
        h = "facebook.com";
        i = new AtomicLong(65536);
        j = false;
        k = false;
        n = 64206;
        o = new Object();
        p = new LinkedBlockingQueue(10);
        q = new ThreadFactory(){
            private final AtomicInteger a = new AtomicInteger(0);

            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "FacebookSdk #" + this.a.incrementAndGet());
            }
        };
        r = false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void a(int n2) {
        if (n2 == 0) {
            n2 = 16973840;
        }
        g = n2;
    }

    public static void a(Context context) {
        reference var2_1 = ul.class;
        synchronized (ul.class) {
            ul.a(context, null);
            // ** MonitorExit[var2_1] (shouldn't be in output)
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(final Context context, final a a2) {
        reference var5_2 = ul.class;
        synchronized (ul.class) {
            if (r.booleanValue()) {
                if (a2 != null) {
                    a2.a();
                }
            } else {
                wf.a((Object)context, "applicationContext");
                wf.b(context, false);
                wf.a(context, false);
                m = context.getApplicationContext();
                ul.c(m);
                r = true;
                we.a(m, d);
                vz.b();
                BoltsMeasurementEventListener.a(m);
                l = new vw(new Callable<File>(){

                    public File a() throws Exception {
                        return m.getCacheDir();
                    }

                    public /* synthetic */ Object call() throws Exception {
                        return this.a();
                    }
                });
                FutureTask futureTask = new FutureTask((Callable)new Callable<Void>(){

                    public Void a() throws Exception {
                        uh.a().c();
                        ur.a().c();
                        if (AccessToken.a() != null && Profile.a() == null) {
                            Profile.b();
                        }
                        if (a2 != null) {
                            a2.a();
                        }
                        AppEventsLogger.a(context.getApplicationContext()).b();
                        return null;
                    }

                    public /* synthetic */ Object call() throws Exception {
                        return this.a();
                    }
                });
                ul.d().execute((Runnable)futureTask);
            }
            // ** MonitorExit[var5_2] (shouldn't be in output)
            return;
        }
    }

    public static boolean a() {
        reference var2 = ul.class;
        synchronized (ul.class) {
            boolean bl2 = r;
            // ** MonitorExit[var2] (shouldn't be in output)
            return bl2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean a(LoggingBehavior loggingBehavior) {
        HashSet<LoggingBehavior> hashSet;
        HashSet<LoggingBehavior> hashSet2 = hashSet = b;
        synchronized (hashSet2) {
            if (!ul.b()) return false;
            if (!b.contains((Object)loggingBehavior)) return false;
            return true;
        }
    }

    public static boolean b() {
        return j;
    }

    public static boolean b(int n2) {
        if (n2 >= n && n2 < 100 + n) {
            return true;
        }
        return false;
    }

    public static boolean b(Context context) {
        wf.a();
        return context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getBoolean("limitEventUsage", false);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    static void c(Context var0) {
        if (var0 == null) lbl-1000: // 3 sources:
        {
            do {
                return;
                break;
            } while (true);
        }
        try {
            var2_1 = var0.getPackageManager().getApplicationInfo(var0.getPackageName(), 128);
            if (var2_1 == null || var2_1.metaData == null) ** GOTO lbl-1000
            if (ul.d != null) ** GOTO lbl13
        }
        catch (PackageManager.NameNotFoundException var1_4) {
            return;
        }
        var3_2 = var2_1.metaData.get("com.facebook.sdk.ApplicationId");
        if (!(var3_2 instanceof String)) ** GOTO lbl26
        var4_3 = (String)var3_2;
        if (var4_3.toLowerCase(Locale.ROOT).startsWith("fb")) {
            ul.d = var4_3.substring(2);
lbl13: // 4 sources:
            do {
                if (ul.e == null) {
                    ul.e = var2_1.metaData.getString("com.facebook.sdk.ApplicationName");
                }
                if (ul.f == null) {
                    ul.f = var2_1.metaData.getString("com.facebook.sdk.ClientToken");
                }
                if (ul.g != 0) ** continue;
                ul.a(var2_1.metaData.getInt("com.facebook.sdk.WebDialogTheme"));
                return;
                break;
            } while (true);
        }
        ul.d = var4_3;
        ** GOTO lbl13
lbl26: // 1 sources:
        if (var3_2 instanceof Integer) ** break;
        ** while (true)
        throw new FacebookException("App Ids cannot be directly placed in the manifest.They must be prefixed by 'fb' or be placed in the string resource file.");
    }

    public static boolean c() {
        return k;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static String d(Context context) {
        MessageDigest messageDigest;
        Signature[] arrsignature;
        wf.a();
        if (context == null) {
            return null;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) return null;
        String string2 = context.getPackageName();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(string2, 64);
            arrsignature = packageInfo.signatures;
            if (arrsignature == null) return null;
        }
        catch (PackageManager.NameNotFoundException var3_6) {
            return null;
        }
        if (arrsignature.length == 0) return null;
        try {
            messageDigest = MessageDigest.getInstance((String)"SHA-1");
        }
        catch (NoSuchAlgorithmException var6_7) {
            return null;
        }
        messageDigest.update(packageInfo.signatures[0].toByteArray());
        return Base64.encodeToString((byte[])messageDigest.digest(), (int)9);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Executor d() {
        Object object;
        Object object2 = object = o;
        synchronized (object2) {
            if (c == null) {
                c = AsyncTask.THREAD_POOL_EXECUTOR;
            }
            return c;
        }
    }

    public static String e() {
        return h;
    }

    public static Context f() {
        wf.a();
        return m;
    }

    public static String g() {
        return "4.12.1";
    }

    public static long h() {
        wf.a();
        return i.get();
    }

    public static String i() {
        wf.a();
        return d;
    }

    public static String j() {
        wf.a();
        return e;
    }

    public static String k() {
        wf.a();
        return f;
    }

    public static int l() {
        wf.a();
        return g;
    }

    public static File m() {
        wf.a();
        return l.a();
    }

    public static int n() {
        wf.a();
        return n;
    }

    public static interface a {
        public void a();
    }

}

