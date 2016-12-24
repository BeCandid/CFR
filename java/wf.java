/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ActivityInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.ProviderInfo
 *  android.content.pm.ResolveInfo
 *  android.net.Uri
 *  android.util.Log
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 */
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Log;
import com.facebook.CustomTabActivity;
import com.facebook.FacebookActivity;
import com.facebook.FacebookSdkNotInitializedException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class wf {
    private static final String a = wf.class.getName();

    public static void a() {
        if (!ul.a()) {
            throw new FacebookSdkNotInitializedException("The SDK has not been initialized, make sure to call FacebookSdk.sdkInitialize() first.");
        }
    }

    public static void a(Context context) {
        wf.a(context, true);
    }

    public static void a(Context context, boolean bl2) {
        wf.a((Object)context, "context");
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") == -1) {
            if (bl2) {
                throw new IllegalStateException("No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.");
            }
            Log.w((String)a, (String)"No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.");
        }
    }

    public static void a(Object object, String string2) {
        if (object == null) {
            throw new NullPointerException("Argument '" + string2 + "' cannot be null");
        }
    }

    public static void a(String string2, String string3) {
        if (we.a(string2)) {
            throw new IllegalArgumentException("Argument '" + string3 + "' cannot be null or empty");
        }
    }

    public static <T> void a(Collection<T> collection, String string2) {
        if (collection.isEmpty()) {
            throw new IllegalArgumentException("Container '" + string2 + "' cannot be empty");
        }
    }

    public static String b() {
        String string2 = ul.i();
        if (string2 == null) {
            throw new IllegalStateException("No App ID found, please set the App ID.");
        }
        return string2;
    }

    public static void b(Context context) {
        wf.b(context, true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static void b(Context context, boolean bl2) {
        wf.a((Object)context, "context");
        PackageManager packageManager = context.getPackageManager();
        ActivityInfo activityInfo = null;
        if (packageManager != null) {
            ComponentName componentName = new ComponentName(context, (Class)FacebookActivity.class);
            try {
                ActivityInfo activityInfo2;
                activityInfo = activityInfo2 = packageManager.getActivityInfo(componentName, 1);
            }
            catch (PackageManager.NameNotFoundException var5_6) {
                activityInfo = null;
            }
            if (activityInfo != null) return;
        }
        if (bl2) {
            throw new IllegalStateException("FacebookActivity is not declared in the AndroidManifest.xml, please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.");
        }
        Log.w((String)a, (String)"FacebookActivity is not declared in the AndroidManifest.xml, please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.");
    }

    public static <T> void b(Collection<T> collection, String string2) {
        wf.a(collection, string2);
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() != null) continue;
            throw new NullPointerException("Container '" + string2 + "' cannot contain null values");
        }
    }

    public static String c() {
        String string2 = ul.k();
        if (string2 == null) {
            throw new IllegalStateException("No Client Token found, please set the Client Token.");
        }
        return string2;
    }

    public static <T> void c(Collection<T> collection, String string2) {
        wf.b(collection, string2);
        wf.a(collection, string2);
    }

    public static boolean c(Context context) {
        wf.a((Object)context, "context");
        PackageManager packageManager = context.getPackageManager();
        List list = null;
        if (packageManager != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setData(Uri.parse((String)("fb" + ul.i() + "://authorize")));
            list = packageManager.queryIntentActivities(intent, 64);
        }
        boolean bl2 = false;
        if (list != null) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                if (((ResolveInfo)iterator.next()).activityInfo.name.equals((Object)CustomTabActivity.class.getName())) {
                    bl2 = true;
                    continue;
                }
                return false;
            }
        }
        return bl2;
    }

    public static void d(Context context) {
        String string2;
        wf.a((Object)context, "context");
        String string3 = wf.b();
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null && packageManager.resolveContentProvider(string2 = "com.facebook.app.FacebookContentProvider" + string3, 0) == null) {
            throw new IllegalStateException(String.format((String)"A ContentProvider for this app was not set up in the AndroidManifest.xml, please add %s as a provider to your AndroidManifest.xml file. See https://developers.facebook.com/docs/sharing/android for more info.", (Object[])new Object[]{string2}));
        }
    }
}

