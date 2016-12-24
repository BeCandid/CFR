/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

public class ys {
    private static final Uri a = Uri.parse((String)"http://plus.google.com/");
    private static final Uri b = a.buildUpon().appendPath("circles").appendPath("find").build();

    public static Intent a() {
        Intent intent = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
        intent.setPackage("com.google.android.wearable.app");
        return intent;
    }

    public static Intent a(String string2) {
        Uri uri = Uri.fromParts((String)"package", (String)string2, (String)null);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(uri);
        return intent;
    }

    public static Intent a(String string2, String string3) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(ys.b(string2, string3));
        intent.setPackage("com.android.vending");
        intent.addFlags(524288);
        return intent;
    }

    private static Uri b(String string2, String string3) {
        Uri.Builder builder = Uri.parse((String)"market://details").buildUpon().appendQueryParameter("id", string2);
        if (!TextUtils.isEmpty((CharSequence)string3)) {
            builder.appendQueryParameter("pcampaignid", string3);
        }
        return builder.build();
    }
}

