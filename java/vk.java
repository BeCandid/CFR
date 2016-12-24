/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Bundle
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.UUID
 */
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import java.util.UUID;

public class vk {
    public static void a(vf vf2) {
        vk.a(vf2, new FacebookException("Unable to show the provided content via the web or the installed version of the Facebook app. Some dialogs are only supported starting API 14."));
    }

    public static void a(vf vf2, Activity activity) {
        activity.startActivityForResult(vf2.b(), vf2.d());
        vf2.e();
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void a(vf vf2, Bundle bundle, vj vj2) {
        wf.b(ul.f());
        wf.a(ul.f());
        String string2 = vj2.name();
        Uri uri = vk.d(vj2);
        if (uri == null) {
            throw new FacebookException("Unable to fetch the Url for the DialogFeature : '" + string2 + "'");
        }
        int n2 = vz.a();
        Bundle bundle2 = wc.a(vf2.c().toString(), n2, bundle);
        if (bundle2 == null) {
            throw new FacebookException("Unable to fetch the app's key-hash");
        }
        Uri uri2 = uri.isRelative() ? we.a(wc.a(), uri.toString(), bundle2) : we.a(uri.getAuthority(), uri.getPath(), bundle2);
        Bundle bundle3 = new Bundle();
        bundle3.putString("url", uri2.toString());
        bundle3.putBoolean("is_fallback", true);
        Intent intent = new Intent();
        vz.a(intent, vf2.c().toString(), vj2.a(), vz.a(), bundle3);
        intent.setClass(ul.f(), (Class)FacebookActivity.class);
        intent.setAction("FacebookDialogFragment");
        vf2.a(intent);
    }

    public static void a(vf vf2, FacebookException facebookException) {
        vk.b(vf2, facebookException);
    }

    public static void a(vf vf2, String string2, Bundle bundle) {
        wf.b(ul.f());
        wf.a(ul.f());
        Bundle bundle2 = new Bundle();
        bundle2.putString("action", string2);
        bundle2.putBundle("params", bundle);
        Intent intent = new Intent();
        vz.a(intent, vf2.c().toString(), string2, vz.a(), bundle2);
        intent.setClass(ul.f(), (Class)FacebookActivity.class);
        intent.setAction("FacebookDialogFragment");
        vf2.a(intent);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void a(vf vf2, a a2, vj vj2) {
        Intent intent;
        Context context = ul.f();
        String string2 = vj2.a();
        int n2 = vk.c(vj2);
        if (n2 == -1) {
            throw new FacebookException("Cannot present this dialog. This likely means that the Facebook app is not installed.");
        }
        Bundle bundle = vz.a(n2) ? a2.a() : a2.b();
        if (bundle == null) {
            bundle = new Bundle();
        }
        if ((intent = vz.a(context, vf2.c().toString(), string2, n2, bundle)) == null) {
            throw new FacebookException("Unable to create Intent; this likely means theFacebook app is not installed.");
        }
        vf2.a(intent);
    }

    public static void a(vf vf2, vq vq2) {
        vq2.a(vf2.b(), vf2.d());
        vf2.e();
    }

    public static boolean a(vj vj2) {
        if (vk.c(vj2) != -1) {
            return true;
        }
        return false;
    }

    private static int[] a(String string2, String string3, vj vj2) {
        we.a a2 = we.a(string2, string3, vj2.name());
        if (a2 != null) {
            return a2.d();
        }
        int[] arrn = new int[]{vj2.b()};
        return arrn;
    }

    public static void b(vf vf2, FacebookException facebookException) {
        if (facebookException == null) {
            return;
        }
        wf.b(ul.f());
        Intent intent = new Intent();
        intent.setClass(ul.f(), (Class)FacebookActivity.class);
        intent.setAction(FacebookActivity.a);
        vz.a(intent, vf2.c().toString(), null, vz.a(), vz.a(facebookException));
        vf2.a(intent);
    }

    public static boolean b(vj vj2) {
        if (vk.d(vj2) != null) {
            return true;
        }
        return false;
    }

    public static int c(vj vj2) {
        String string2 = ul.i();
        String string3 = vj2.a();
        return vz.a(string3, vk.a(string2, string3, vj2));
    }

    private static Uri d(vj vj2) {
        String string2 = vj2.name();
        String string3 = vj2.a();
        we.a a2 = we.a(ul.i(), string3, string2);
        Uri uri = null;
        if (a2 != null) {
            uri = a2.c();
        }
        return uri;
    }

    public static interface a {
        public Bundle a();

        public Bundle b();
    }

}

