/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.os.Build
 *  android.os.Build$VERSION
 *  io.fabric.sdk.android.services.common.CommonUtils
 *  io.fabric.sdk.android.services.common.IdManager
 *  java.io.File
 *  java.lang.Boolean
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.IdManager;
import java.io.File;

public class rk
extends alc<Boolean> {
    sf a;

    public static rk c() {
        return (rk)akx.a(rk.class);
    }

    @Override
    public String a() {
        return "1.3.8.127";
    }

    @Override
    public void a(alt.a a2) {
        if (this.a != null) {
            this.a.a(a2.a(), a2.b());
        }
    }

    @Override
    public void a(alt.b b2) {
        if (this.a != null) {
            this.a.a(b2.a());
        }
    }

    @Override
    public void a(ru ru2) {
        if (ru2 == null) {
            throw new NullPointerException("event must not be null");
        }
        if (this.a != null) {
            this.a.a(ru2);
        }
    }

    @Override
    public void a(sk sk2) {
        if (sk2 == null) {
            throw new NullPointerException("event must not be null");
        }
        if (this.a != null) {
            this.a.a(sk2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @SuppressLint(value={"NewApi"})
    @Override
    protected boolean a_() {
        try {
            long l2;
            Context context = this.E();
            PackageManager packageManager = context.getPackageManager();
            String string2 = context.getPackageName();
            PackageInfo packageInfo = packageManager.getPackageInfo(string2, 0);
            String string3 = Integer.toString((int)packageInfo.versionCode);
            String string4 = packageInfo.versionName == null ? "0.0" : packageInfo.versionName;
            long l3 = Build.VERSION.SDK_INT >= 9 ? packageInfo.firstInstallTime : (l2 = new File(packageManager.getApplicationInfo((String)string2, (int)0).sourceDir).lastModified());
            this.a = sf.a(this, context, this.D(), string3, string4, l3);
            this.a.b();
            return true;
        }
        catch (Exception var1_9) {
            akx.h().e("Answers", "Error retrieving app properties", (Throwable)var1_9);
            return false;
        }
    }

    @Override
    public String b() {
        return "com.crashlytics.sdk.android:answers";
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected Boolean e() {
        try {
            aoc aoc2 = aoa.a().b();
            if (aoc2 == null) {
                akx.h().e("Answers", "Failed to retrieve settings");
                return false;
            }
            if (aoc2.d.d) {
                akx.h().a("Answers", "Analytics collection enabled");
                this.a.a(aoc2.e, this.g());
                return true;
            }
            akx.h().a("Answers", "Analytics collection disabled");
            this.a.c();
            return false;
        }
        catch (Exception var1_3) {
            akx.h().e("Answers", "Error dealing with settings", (Throwable)var1_3);
            return false;
        }
    }

    @Override
    protected /* synthetic */ Object f() {
        return this.e();
    }

    String g() {
        return CommonUtils.b((Context)this.E(), (String)"com.crashlytics.ApiEndpoint");
    }
}

