/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.app.Activity
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.res.Resources
 *  android.util.DisplayMetrics
 *  android.view.View
 *  android.widget.ScrollView
 *  android.widget.TextView
 *  com.crashlytics.android.core.CrashlyticsMissingDependencyException
 *  io.fabric.sdk.android.services.common.CommonUtils
 *  io.fabric.sdk.android.services.common.IdManager
 *  io.fabric.sdk.android.services.concurrency.Priority
 *  io.fabric.sdk.android.services.concurrency.UnmetDependencyException
 *  java.io.File
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Thread$UncaughtExceptionHandler
 *  java.lang.Throwable
 *  java.lang.Void
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.concurrent.Callable
 *  java.util.concurrent.ConcurrentHashMap
 *  java.util.concurrent.CountDownLatch
 *  java.util.concurrent.ExecutionException
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Future
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.TimeoutException
 */
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import com.crashlytics.android.core.CrashlyticsMissingDependencyException;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.concurrency.Priority;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@amd(a={"Ltz;"})
public class sz
extends alc<Void> {
    private anb A;
    private ta B;
    private tz C;
    private final long a;
    private final ConcurrentHashMap<String, String> b;
    private File c;
    private ang d;
    private tb k;
    private tb l;
    private tc m;
    private te n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private String u;
    private String v;
    private String w;
    private float x;
    private boolean y;
    private final tp z;

    public sz() {
        this(1.0f, null, null, false);
    }

    sz(float f2, tc tc2, tp tp2, boolean bl2) {
        super(f2, tc2, tp2, bl2, alw.a("Crashlytics Exception Handler"));
    }

    /*
     * Enabled aggressive block sorting
     */
    sz(float f2, tc tc2, tp tp2, boolean bl2, ExecutorService executorService) {
        this.o = null;
        this.p = null;
        this.q = null;
        this.x = f2;
        if (tc2 == null) {
            tc2 = new b(null);
        }
        this.m = tc2;
        this.z = tp2;
        this.y = bl2;
        this.B = new ta(executorService);
        this.b = new ConcurrentHashMap();
        this.a = System.currentTimeMillis();
    }

    static anz B() {
        aoc aoc2 = aoa.a().b();
        if (aoc2 == null) {
            return null;
        }
        return aoc2.b;
    }

    private void J() {
        amf<Void> amf2 = new amf<Void>(){

            public Void a() throws Exception {
                return sz.this.c();
            }

            @Override
            public Priority b() {
                return Priority.d;
            }

            public /* synthetic */ Object call() throws Exception {
                return this.a();
            }
        };
        Iterator iterator = this.I().iterator();
        while (iterator.hasNext()) {
            amf2.a((amk)iterator.next());
        }
        Future future = this.F().f().submit((Callable)amf2);
        akx.h().a("CrashlyticsCore", "Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            future.get(4, TimeUnit.SECONDS);
            return;
        }
        catch (InterruptedException var6_4) {
            akx.h().e("CrashlyticsCore", "Crashlytics was interrupted during initialization.", (Throwable)var6_4);
            return;
        }
        catch (ExecutionException var5_5) {
            akx.h().e("CrashlyticsCore", "Problem encountered during Crashlytics initialization.", (Throwable)var5_5);
            return;
        }
        catch (TimeoutException var4_6) {
            akx.h().e("CrashlyticsCore", "Crashlytics timed out during initialization.", (Throwable)var4_6);
            return;
        }
    }

    private void K() {
        Boolean bl2 = (Boolean)this.B.a(new a(this.l));
        if (!Boolean.TRUE.equals((Object)bl2)) {
            return;
        }
        try {
            this.m.a();
            return;
        }
        catch (Exception var2_2) {
            akx.h().e("CrashlyticsCore", "Exception thrown by CrashlyticsListener while notifying of previous crash.", (Throwable)var2_2);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(int n2, String string2, String string3) {
        if (this.y || !sz.b("prior to logging messages.")) {
            return;
        }
        long l2 = System.currentTimeMillis() - this.a;
        this.n.a(l2, sz.b(n2, string2, string3));
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(Context context, String string2) throws PackageManager.NameNotFoundException {
        td td2 = this.z != null ? new td(this.z) : null;
        this.A = new ana(akx.h());
        this.A.a(td2);
        this.s = context.getPackageName();
        this.u = this.D().j();
        akx.h().a("CrashlyticsCore", "Installer package name is: " + this.u);
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(this.s, 0);
        this.v = Integer.toString((int)packageInfo.versionCode);
        String string3 = packageInfo.versionName == null ? "0.0" : packageInfo.versionName;
        this.w = string3;
        this.r = CommonUtils.m((Context)context);
        this.a(this.r, sz.b(context)).a(string2, this.s);
    }

    static void a(String string2, String string3) {
        rk rk2 = (rk)akx.a(rk.class);
        if (rk2 != null) {
            rk2.a(new alt.b(string2, string3));
        }
    }

    @Override
    private void a(tv tv2) {
        try {
            akx.h().a("CrashlyticsCore", "Installing exception handler...");
            this.n = new te(Thread.getDefaultUncaughtExceptionHandler(), this.B, this.D(), tv2, this.d, (sz)this);
            this.n.b();
            Thread.setDefaultUncaughtExceptionHandler((Thread.UncaughtExceptionHandler)this.n);
            akx.h().a("CrashlyticsCore", "Successfully installed exception handler.");
            return;
        }
        catch (Exception var2_2) {
            akx.h().e("CrashlyticsCore", "There was a problem installing the exception handler.", (Throwable)var2_2);
            return;
        }
    }

    private boolean a(final Activity activity, final any any2) {
        final tj tj2 = new tj((Context)activity, any2);
        final c c2 = new c(null);
        activity.runOnUiThread(new Runnable(){

            public void run() {
                AlertDialog.Builder builder = new AlertDialog.Builder((Context)activity);
                DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener(){

                    public void onClick(DialogInterface dialogInterface, int n2) {
                        c2.a(true);
                        dialogInterface.dismiss();
                    }
                };
                float f2 = activity.getResources().getDisplayMetrics().density;
                int n2 = sz.b(f2, 5);
                TextView textView = new TextView((Context)activity);
                textView.setAutoLinkMask(15);
                textView.setText((CharSequence)tj2.b());
                textView.setTextAppearance((Context)activity, 16973892);
                textView.setPadding(n2, n2, n2, n2);
                textView.setFocusable(false);
                ScrollView scrollView = new ScrollView((Context)activity);
                scrollView.setPadding(sz.b(f2, 14), sz.b(f2, 2), sz.b(f2, 10), sz.b(f2, 12));
                scrollView.addView((View)textView);
                builder.setView((View)scrollView).setTitle((CharSequence)tj2.a()).setCancelable(false).setNeutralButton((CharSequence)tj2.c(), onClickListener);
                if (any2.d) {
                    DialogInterface.OnClickListener onClickListener2 = new DialogInterface.OnClickListener(){

                        public void onClick(DialogInterface dialogInterface, int n2) {
                            c2.a(false);
                            dialogInterface.dismiss();
                        }
                    };
                    builder.setNegativeButton((CharSequence)tj2.e(), onClickListener2);
                }
                if (any2.f) {
                    DialogInterface.OnClickListener onClickListener3 = new DialogInterface.OnClickListener(){

                        public void onClick(DialogInterface dialogInterface, int n2) {
                            sz.this.a(true);
                            c2.a(true);
                            dialogInterface.dismiss();
                        }
                    };
                    builder.setPositiveButton((CharSequence)tj2.d(), onClickListener3);
                }
                builder.show();
            }

        });
        akx.h().a("CrashlyticsCore", "Waiting for user opt-in.");
        c2.b();
        return c2.a();
    }

    private static int b(float f2, int n2) {
        return (int)(f2 * (float)n2);
    }

    private static String b(int n2, String string2, String string3) {
        return CommonUtils.b((int)n2) + "/" + string2 + " " + string3;
    }

    static void b(String string2, String string3) {
        rk rk2 = (rk)akx.a(rk.class);
        if (rk2 != null) {
            rk2.a(new alt.a(string2, string3));
        }
    }

    private static boolean b(Context context) {
        return CommonUtils.a((Context)context, (String)"com.crashlytics.RequireBuildId", (boolean)true);
    }

    private static boolean b(String string2) {
        sz sz2 = sz.e();
        if (sz2 == null || sz2.n == null) {
            akx.h().e("CrashlyticsCore", "Crashlytics must be initialized by calling Fabric.with(Context) " + string2, null);
            return false;
        }
        return true;
    }

    public static sz e() {
        return (sz)akx.a(sz.class);
    }

    void A() {
        this.l.a();
    }

    @Override
    public String a() {
        return "2.3.10.127";
    }

    sv a(String string2, boolean bl2) {
        return new sv(string2, bl2);
    }

    tg a(aoc aoc2) {
        if (aoc2 != null) {
            return new th((alc)this, this.m(), aoc2.a.d, this.A);
        }
        return null;
    }

    @Override
    public void a(String string2) {
        super.a(3, "CrashlyticsCore", string2);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void a(Throwable throwable) {
        if (this.y || !sz.b("prior to logging exceptions.")) {
            return;
        }
        if (throwable == null) {
            akx.h().a(5, "CrashlyticsCore", "Crashlytics is ignoring a request to log a null exception.");
            return;
        }
        this.n.a(Thread.currentThread(), throwable);
    }

    @SuppressLint(value={"CommitPrefEdits"})
    @Override
    void a(boolean bl2) {
        anj anj2 = new anj((alc)this);
        anj2.a(anj2.b().putBoolean("always_send_reports_opt_in", bl2));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    boolean a(Context context) {
        if (this.y) return false;
        this.t = new alr().a(context);
        if (this.t == null) {
            return false;
        }
        akx.h().c("CrashlyticsCore", "Initializing Crashlytics " + this.a());
        this.d = new anh((alc)this);
        this.l = new tb("crash_marker", this.d);
        this.k = new tb("initialization_marker", this.d);
        try {
            super.a(context, this.t);
            tm tm2 = new tm(context, this.h());
            boolean bl2 = this.u();
            super.K();
            super.a(tm2);
            if (!bl2 || !CommonUtils.n((Context)context)) return true;
            {
                super.J();
                return false;
            }
        }
        catch (CrashlyticsMissingDependencyException var3_4) {
            throw new UnmetDependencyException((Throwable)var3_4);
        }
        catch (Exception var2_5) {
            akx.h().e("CrashlyticsCore", "Crashlytics was not started due to an exception during initialization", (Throwable)var2_5);
            return false;
        }
    }

    @Override
    protected boolean a_() {
        return this.a(super.E());
    }

    @Override
    public String b() {
        return "com.crashlytics.sdk.android.crashlytics-core";
    }

    protected Void c() {
        this.s();
        this.n.g();
        try {
            aoc aoc2 = aoa.a().b();
            if (aoc2 == null) {
                akx.h().d("CrashlyticsCore", "Received null settings, skipping initialization!");
                return null;
            }
            if (!aoc2.d.c) {
                akx.h().a("CrashlyticsCore", "Collection of crash reports disabled in Crashlytics settings.");
                return null;
            }
            this.n.c();
            tg tg2 = this.a(aoc2);
            if (tg2 == null) {
                akx.h().d("CrashlyticsCore", "Unable to create a call to upload reports.");
                return null;
            }
            new ts(tg2).a(this.x);
            return null;
        }
        catch (Exception var2_3) {
            akx.h().e("CrashlyticsCore", "Crashlytics encountered a problem during asynchronous initialization.", (Throwable)var2_3);
            return null;
        }
        finally {
            this.t();
        }
    }

    @Override
    protected /* synthetic */ Object f() {
        return this.c();
    }

    Map<String, String> g() {
        return Collections.unmodifiableMap(this.b);
    }

    String h() {
        return this.s;
    }

    String i() {
        return this.t;
    }

    String j() {
        return this.u;
    }

    String k() {
        return this.w;
    }

    String l() {
        return this.v;
    }

    String m() {
        return CommonUtils.b((Context)this.E(), (String)"com.crashlytics.ApiEndpoint");
    }

    String n() {
        return this.r;
    }

    te o() {
        return this.n;
    }

    String p() {
        if (this.D().a()) {
            return this.o;
        }
        return null;
    }

    String q() {
        if (this.D().a()) {
            return this.p;
        }
        return null;
    }

    String r() {
        if (this.D().a()) {
            return this.q;
        }
        return null;
    }

    void s() {
        this.B.a(new Callable<Void>(){

            public Void a() throws Exception {
                sz.this.k.a();
                akx.h().a("CrashlyticsCore", "Initialization marker file created.");
                return null;
            }

            public /* synthetic */ Object call() throws Exception {
                return this.a();
            }
        });
    }

    void t() {
        this.B.b(new Callable<Boolean>(){

            public Boolean a() throws Exception {
                try {
                    boolean bl2 = sz.this.k.c();
                    akx.h().a("CrashlyticsCore", "Initialization marker file removed: " + bl2);
                    Boolean bl3 = bl2;
                    return bl3;
                }
                catch (Exception var1_3) {
                    akx.h().e("CrashlyticsCore", "Problem encountered deleting Crashlytics initialization marker.", (Throwable)var1_3);
                    return false;
                }
            }

            public /* synthetic */ Object call() throws Exception {
                return this.a();
            }
        });
    }

    boolean u() {
        return (Boolean)this.B.a(new Callable<Boolean>(){

            public Boolean a() throws Exception {
                return sz.this.k.b();
            }

            public /* synthetic */ Object call() throws Exception {
                return this.a();
            }
        });
    }

    ud v() {
        tz tz2 = this.C;
        ud ud2 = null;
        if (tz2 != null) {
            ud2 = this.C.a();
        }
        return ud2;
    }

    File w() {
        if (this.c == null) {
            this.c = new anh(this).a();
        }
        return this.c;
    }

    boolean x() {
        return aoa.a().a(new aoa.b<Boolean>(){

            public Boolean a(aoc aoc2) {
                if (aoc2.d.a) {
                    boolean bl2 = sz.this.y();
                    boolean bl3 = false;
                    if (!bl2) {
                        bl3 = true;
                    }
                    return bl3;
                }
                return false;
            }

            @Override
            public /* synthetic */ Object b(aoc aoc2) {
                return this.a(aoc2);
            }
        }, false);
    }

    boolean y() {
        return new anj(this).a().getBoolean("always_send_reports_opt_in", false);
    }

    boolean z() {
        return aoa.a().a(new aoa.b<Boolean>(){

            public Boolean a(aoc aoc2) {
                boolean bl2 = true;
                Activity activity = sz.this.F().b();
                if (activity != null && !activity.isFinishing() && sz.this.x()) {
                    bl2 = sz.this.a(activity, aoc2.c);
                }
                return bl2;
            }

            @Override
            public /* synthetic */ Object b(aoc aoc2) {
                return this.a(aoc2);
            }
        }, true);
    }

    static final class a
    implements Callable<Boolean> {
        private final tb a;

        public a(tb tb2) {
            this.a = tb2;
        }

        public Boolean a() throws Exception {
            if (!this.a.b()) {
                return Boolean.FALSE;
            }
            akx.h().a("CrashlyticsCore", "Found previous crash marker.");
            this.a.c();
            return Boolean.TRUE;
        }

        public /* synthetic */ Object call() throws Exception {
            return this.a();
        }
    }

    static final class b
    implements tc {
        private b() {
        }

        /* synthetic */ b( var1) {
        }

        @Override
        public void a() {
        }
    }

    static class c {
        private boolean a;
        private final CountDownLatch b;

        private c() {
            this.a = false;
            this.b = new CountDownLatch(1);
        }

        /* synthetic */ c( var1) {
        }

        void a(boolean bl2) {
            this.a = bl2;
            this.b.countDown();
        }

        boolean a() {
            return this.a;
        }

        void b() {
            try {
                this.b.await();
                return;
            }
            catch (InterruptedException var1_1) {
                return;
            }
        }
    }

}

