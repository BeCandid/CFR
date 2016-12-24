/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
import android.net.Uri;
import java.util.List;

final class mg {
    private static final int a = "file:///android_asset/".length();

    public static boolean a(Uri uri) {
        boolean bl2 = "file".equals((Object)uri.getScheme());
        boolean bl3 = false;
        if (bl2) {
            boolean bl4 = uri.getPathSegments().isEmpty();
            bl3 = false;
            if (!bl4) {
                boolean bl5 = "android_asset".equals(uri.getPathSegments().get(0));
                bl3 = false;
                if (bl5) {
                    bl3 = true;
                }
            }
        }
        return bl3;
    }

    public static String b(Uri uri) {
        return uri.toString().substring(a);
    }
}

