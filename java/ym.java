/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.util.Log
 *  com.google.android.gms.R
 *  com.google.android.gms.R$string
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import com.google.android.gms.R;

public final class ym {
    public static String a(Context context, int n2) {
        Resources resources = context.getResources();
        switch (n2) {
            default: {
                Log.e((String)"GoogleApiAvailability", (String)new StringBuilder(33).append("Unexpected error code ").append(n2).toString());
            }
            case 4: 
            case 6: {
                return null;
            }
            case 1: {
                return resources.getString(R.string.common_google_play_services_install_title);
            }
            case 3: {
                return resources.getString(R.string.common_google_play_services_enable_title);
            }
            case 18: {
                return resources.getString(R.string.common_google_play_services_updating_title);
            }
            case 2: 
            case 42: {
                return resources.getString(R.string.common_google_play_services_update_title);
            }
            case 9: {
                Log.e((String)"GoogleApiAvailability", (String)"Google Play services is invalid. Cannot recover.");
                return resources.getString(R.string.common_google_play_services_unsupported_title);
            }
            case 7: {
                Log.e((String)"GoogleApiAvailability", (String)"Network error occurred. Please retry request later.");
                return resources.getString(R.string.common_google_play_services_network_error_title);
            }
            case 8: {
                Log.e((String)"GoogleApiAvailability", (String)"Internal error occurred. Please see logs for detailed information");
                return null;
            }
            case 10: {
                Log.e((String)"GoogleApiAvailability", (String)"Developer error occurred. Please see logs for detailed information");
                return null;
            }
            case 5: {
                Log.e((String)"GoogleApiAvailability", (String)"An invalid account was specified when connecting. Please provide a valid account.");
                return resources.getString(R.string.common_google_play_services_invalid_account_title);
            }
            case 11: {
                Log.e((String)"GoogleApiAvailability", (String)"The application is not licensed to the user.");
                return null;
            }
            case 16: {
                Log.e((String)"GoogleApiAvailability", (String)"One of the API components you attempted to connect to is not available.");
                return null;
            }
            case 17: {
                Log.e((String)"GoogleApiAvailability", (String)"The specified account could not be signed in.");
                return resources.getString(R.string.common_google_play_services_sign_in_failed_title);
            }
            case 20: 
        }
        Log.e((String)"GoogleApiAvailability", (String)"The current user profile is restricted and could not use authenticated features.");
        return resources.getString(R.string.common_google_play_services_restricted_profile_title);
    }

    public static String a(Context context, int n2, String string2) {
        Resources resources = context.getResources();
        switch (n2) {
            default: {
                return resources.getString(R.string.common_google_play_services_unknown_issue, new Object[]{string2});
            }
            case 1: {
                if (zq.a(resources)) {
                    return resources.getString(R.string.common_google_play_services_install_text_tablet, new Object[]{string2});
                }
                return resources.getString(R.string.common_google_play_services_install_text_phone, new Object[]{string2});
            }
            case 3: {
                return resources.getString(R.string.common_google_play_services_enable_text, new Object[]{string2});
            }
            case 18: {
                return resources.getString(R.string.common_google_play_services_updating_text, new Object[]{string2});
            }
            case 2: {
                return resources.getString(R.string.common_google_play_services_update_text, new Object[]{string2});
            }
            case 42: {
                return resources.getString(R.string.common_google_play_services_wear_update_text);
            }
            case 9: {
                return resources.getString(R.string.common_google_play_services_unsupported_text, new Object[]{string2});
            }
            case 7: {
                return resources.getString(R.string.common_google_play_services_network_error_text);
            }
            case 5: {
                return resources.getString(R.string.common_google_play_services_invalid_account_text);
            }
            case 16: {
                return resources.getString(R.string.common_google_play_services_api_unavailable_text, new Object[]{string2});
            }
            case 17: {
                return resources.getString(R.string.common_google_play_services_sign_in_failed_text);
            }
            case 20: 
        }
        return resources.getString(R.string.common_google_play_services_restricted_profile_text);
    }

    public static String b(Context context, int n2) {
        Resources resources = context.getResources();
        if (n2 == 6) {
            return resources.getString(R.string.common_google_play_services_resolution_required_title);
        }
        return ym.a(context, n2);
    }

    public static String b(Context context, int n2, String string2) {
        Resources resources = context.getResources();
        if (n2 == 6) {
            return resources.getString(R.string.common_google_play_services_resolution_required_text);
        }
        return ym.a(context, n2, string2);
    }

    public static String c(Context context, int n2) {
        Resources resources = context.getResources();
        switch (n2) {
            default: {
                return resources.getString(17039370);
            }
            case 1: {
                return resources.getString(R.string.common_google_play_services_install_button);
            }
            case 3: {
                return resources.getString(R.string.common_google_play_services_enable_button);
            }
            case 2: 
        }
        return resources.getString(R.string.common_google_play_services_update_button);
    }
}

