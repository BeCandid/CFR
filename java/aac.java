/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.app.NotificationManager
 *  android.app.PendingIntent
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageInstaller
 *  android.content.pm.PackageInstaller$SessionInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.res.Resources
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.os.Build
 *  android.os.Bundle
 *  android.os.UserManager
 *  android.text.TextUtils
 *  android.util.Log
 *  com.google.android.gms.R
 *  com.google.android.gms.R$string
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.GooglePlayServicesNotAvailableException
 *  com.google.android.gms.common.GooglePlayServicesRepairableException
 *  java.io.InputStream
 *  java.lang.CharSequence
 *  java.lang.Deprecated
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.SecurityException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Iterator
 *  java.util.List
 *  java.util.NoSuchElementException
 *  java.util.Scanner
 *  java.util.concurrent.atomic.AtomicBoolean
 */
import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class aac {
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 0;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    public static final AtomicBoolean zzakA;
    private static final AtomicBoolean zzakB;
    public static boolean zzaku;
    public static boolean zzakv;
    static boolean zzakw;
    private static String zzakx;
    private static int zzaky;
    private static boolean zzakz;

    static {
        GOOGLE_PLAY_SERVICES_VERSION_CODE = aac.zzqZ();
        zzaku = false;
        zzakv = false;
        zzakw = false;
        zzakx = null;
        zzaky = 0;
        zzakz = false;
        zzakA = new AtomicBoolean();
        zzakB = new AtomicBoolean();
    }

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int n2, Context context, int n3) {
        return aaa.b().a(context, n2, n3);
    }

    @Deprecated
    public static String getErrorString(int n2) {
        return ConnectionResult.a((int)n2);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Deprecated
    public static String getOpenSourceSoftwareLicenseInfo(Context context) {
        InputStream inputStream;
        String string;
        Uri uri = new Uri.Builder().scheme("android.resource").authority("com.google.android.gms").appendPath("raw").appendPath("third_party_licenses").build();
        try {
            inputStream = context.getContentResolver().openInputStream(uri);
        }
        catch (Exception var2_7) {
            return null;
        }
        String string2 = string = new Scanner(inputStream).useDelimiter("\\A").next();
        if (inputStream == null) return string2;
        inputStream.close();
        return string2;
        catch (NoSuchElementException noSuchElementException) {
            if (inputStream == null) return null;
            inputStream.close();
            return null;
        }
        catch (Throwable throwable) {
            if (inputStream == null) throw throwable;
            inputStream.close();
            throw throwable;
        }
    }

    public static Context getRemoteContext(Context context) {
        try {
            Context context2 = context.createPackageContext("com.google.android.gms", 3);
            return context2;
        }
        catch (PackageManager.NameNotFoundException var1_2) {
            return null;
        }
    }

    public static Resources getRemoteResource(Context context) {
        try {
            Resources resources = context.getPackageManager().getResourcesForApplication("com.google.android.gms");
            return resources;
        }
        catch (PackageManager.NameNotFoundException var1_2) {
            return null;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Deprecated
    public static int isGooglePlayServicesAvailable(Context var0) {
        var1_1 = var0.getPackageManager();
        try {
            var0.getResources().getString(R.string.common_google_play_services_unknown_issue);
        }
        catch (Throwable var2_4) {
            Log.e((String)"GooglePlayServicesUtil", (String)"The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals((Object)var0.getPackageName())) {
            aac.zzaj(var0);
        }
        try {
            var6_2 = var1_1.getPackageInfo("com.google.android.gms", 64);
        }
        catch (PackageManager.NameNotFoundException var4_5) {
            Log.w((String)"GooglePlayServicesUtil", (String)"Google Play services is missing.");
            return 1;
        }
        var7_3 = aad.a(var0);
        if (!zq.a(var0)) ** GOTO lbl20
        if (var7_3.a(var6_2, aab.d.a) == null) {
            Log.w((String)"GooglePlayServicesUtil", (String)"Google Play services signature invalid.");
            return 9;
        }
        ** GOTO lbl32
lbl20: // 1 sources:
        try {
            var10_6 = var7_3.a(var1_1.getPackageInfo("com.android.vending", 8256), aab.d.a);
            if (var10_6 == null) {
                Log.w((String)"GooglePlayServicesUtil", (String)"Google Play Store signature invalid.");
                return 9;
            }
            if (var7_3.a(var6_2, new aab.a[]{var10_6}) == null) {
                Log.w((String)"GooglePlayServicesUtil", (String)"Google Play services signature invalid.");
                return 9;
            }
        }
        catch (PackageManager.NameNotFoundException var8_7) {
            Log.w((String)"GooglePlayServicesUtil", (String)"Google Play Store is neither installed nor updating.");
            return 9;
        }
lbl32: // 2 sources:
        var12_8 = zs.a(aac.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        if (zs.a(var6_2.versionCode) < var12_8) {
            var17_9 = aac.GOOGLE_PLAY_SERVICES_VERSION_CODE;
            var18_10 = var6_2.versionCode;
            Log.w((String)"GooglePlayServicesUtil", (String)new StringBuilder(77).append("Google Play services out of date.  Requires ").append(var17_9).append(" but found ").append(var18_10).toString());
            return 2;
        }
        var13_11 = var6_2.applicationInfo;
        if (var13_11 == null) {
            var13_11 = var16_12 = var1_1.getApplicationInfo("com.google.android.gms", 0);
        }
        if (var13_11.enabled != false) return 0;
        return 3;
        catch (PackageManager.NameNotFoundException var14_13) {
            Log.wtf((String)"GooglePlayServicesUtil", (String)"Google Play services missing when getting application info.", (Throwable)var14_13);
            return 1;
        }
    }

    @Deprecated
    public static boolean isUserRecoverableError(int n2) {
        switch (n2) {
            default: {
                return false;
            }
            case 1: 
            case 2: 
            case 3: 
            case 9: 
        }
        return true;
    }

    @Deprecated
    public static void zzaa(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        int n2 = aaa.b().a(context);
        if (n2 != 0) {
            Intent intent = aaa.b().a(context, n2, "e");
            Log.e((String)"GooglePlayServicesUtil", (String)new StringBuilder(57).append("GooglePlayServices not available due to error ").append(n2).toString());
            if (intent == null) {
                throw new GooglePlayServicesNotAvailableException(n2);
            }
            throw new GooglePlayServicesRepairableException(n2, "Google Play Services not available", intent);
        }
    }

    @Deprecated
    public static int zzae(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.google.android.gms", 0);
            return packageInfo.versionCode;
        }
        catch (PackageManager.NameNotFoundException var1_2) {
            Log.w((String)"GooglePlayServicesUtil", (String)"Google Play services is missing.");
            return 0;
        }
    }

    @Deprecated
    public static void zzag(Context context) {
        if (zzakA.getAndSet(true)) {
            return;
        }
        try {
            ((NotificationManager)context.getSystemService("notification")).cancel(10436);
            return;
        }
        catch (SecurityException var1_1) {
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private static void zzaj(Context context) {
        if (zzakB.get()) {
            return;
        }
        aac.zzao(context);
        if (zzaky == 0) {
            throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
        }
        if (zzaky == GOOGLE_PLAY_SERVICES_VERSION_CODE) return;
        int n2 = GOOGLE_PLAY_SERVICES_VERSION_CODE;
        int n3 = zzaky;
        String string2 = String.valueOf((Object)"com.google.android.gms.version");
        throw new IllegalStateException(new StringBuilder(290 + String.valueOf((Object)string2).length()).append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ").append(n2).append(" but found ").append(n3).append(".  You must have the following declaration within the <application> element:     <meta-data android:name=\"").append(string2).append("\" android:value=\"@integer/google_play_services_version\" />").toString());
    }

    public static boolean zzak(Context context) {
        aac.zzao(context);
        return zzakw;
    }

    public static boolean zzal(Context context) {
        if (aac.zzak(context) || !aac.zzra()) {
            return true;
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String zzam(Context context) {
        ApplicationInfo applicationInfo;
        String string2 = context.getApplicationInfo().name;
        if (!TextUtils.isEmpty((CharSequence)string2)) return string2;
        string2 = context.getPackageName();
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        try {
            ApplicationInfo applicationInfo2;
            applicationInfo = applicationInfo2 = abv.b(context).a(context.getPackageName(), 0);
            if (applicationInfo == null) return string2;
        }
        catch (PackageManager.NameNotFoundException var3_5) {
            return string2;
        }
        return packageManager.getApplicationLabel(applicationInfo).toString();
    }

    @TargetApi(value=18)
    public static boolean zzan(Context context) {
        Bundle bundle;
        if (zt.e() && (bundle = ((UserManager)context.getSystemService("user")).getApplicationRestrictions(context.getPackageName())) != null && "true".equals((Object)bundle.getString("restricted_profile"))) {
            return true;
        }
        return false;
    }

    private static void zzao(Context context) {
        if (!zzakz) {
            aac.zzap(context);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static void zzap(Context context) {
        try {
            aab.a[] arra;
            aad aad2;
            zzakx = context.getPackageName();
            abu abu2 = abv.b(context);
            zzaky = zb.b(context);
            PackageInfo packageInfo = abu2.b("com.google.android.gms", 64);
            if (packageInfo != null && (aad2 = aad.a(context)).a(packageInfo, arra = new aab.a[]{aab.d.a[1]}) != null) {
                zzakw = true;
                do {
                    return;
                    break;
                } while (true);
            }
            zzakw = false;
            return;
        }
        catch (PackageManager.NameNotFoundException var2_5) {
            Log.w((String)"GooglePlayServicesUtil", (String)"Cannot find Google Play services package name.", (Throwable)var2_5);
            return;
        }
        finally {
            zzakz = true;
        }
    }

    @Deprecated
    public static Intent zzbC(int n2) {
        return aaa.b().a(null, n2, null);
    }

    public static boolean zzbD(int n2) {
        switch (n2) {
            default: {
                return false;
            }
            case 1: 
            case 2: 
            case 3: 
            case 18: 
            case 42: 
        }
        return true;
    }

    @Deprecated
    public static boolean zzc(Context context, int n2) {
        if (n2 == 18) {
            return true;
        }
        if (n2 == 1) {
            return aac.zzk(context, "com.google.android.gms");
        }
        return false;
    }

    @Deprecated
    public static boolean zzd(Context context, int n2) {
        if (n2 == 9) {
            return aac.zzk(context, "com.android.vending");
        }
        return false;
    }

    @Deprecated
    public static boolean zze(Context context, int n2) {
        return zw.a(context, n2);
    }

    @TargetApi(value=21)
    static boolean zzk(Context context, String string2) {
        if (zt.h()) {
            Iterator iterator = context.getPackageManager().getPackageInstaller().getAllSessions().iterator();
            while (iterator.hasNext()) {
                if (!string2.equals((Object)((PackageInstaller.SessionInfo)iterator.next()).getAppPackageName())) continue;
                return true;
            }
        }
        if (aac.zzan(context)) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            boolean bl2 = packageManager.getApplicationInfo((String)string2, (int)8192).enabled;
            return bl2;
        }
        catch (PackageManager.NameNotFoundException var3_5) {
            return false;
        }
    }

    private static int zzqZ() {
        return yj.a;
    }

    @Deprecated
    public static boolean zzra() {
        return "user".equals((Object)Build.TYPE);
    }
}

