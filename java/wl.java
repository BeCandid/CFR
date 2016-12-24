/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Bundle
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Double
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  org.json.JSONException
 *  org.json.JSONObject
 */
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginClient;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class wl {
    private final AppEventsLogger a;
    private String b;
    private String c;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public wl(Context context, String string2) {
        PackageManager packageManager;
        this.b = string2;
        this.a = AppEventsLogger.a(context, string2);
        try {
            packageManager = context.getPackageManager();
            if (packageManager == null) return;
        }
        catch (PackageManager.NameNotFoundException var3_5) {
            return;
        }
        PackageInfo packageInfo = packageManager.getPackageInfo("com.facebook.katana", 0);
        if (packageInfo == null) return;
        this.c = packageInfo.versionName;
    }

    static Bundle a(String string2) {
        Bundle bundle = new Bundle();
        bundle.putLong("1_timestamp_ms", System.currentTimeMillis());
        bundle.putString("0_auth_logger_id", string2);
        bundle.putString("3_method", "");
        bundle.putString("2_result", "");
        bundle.putString("5_error_message", "");
        bundle.putString("4_error_code", "");
        bundle.putString("6_extras", "");
        return bundle;
    }

    public String a() {
        return this.b;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public void a(LoginClient.Request var1) {
        var2_2 = wl.a(var1.e());
        try {
            var3_3 = new JSONObject();
            var3_3.put("login_behavior", (Object)var1.b().toString());
            var3_3.put("request_code", LoginClient.d());
            var3_3.put("permissions", (Object)TextUtils.join((CharSequence)",", var1.a()));
            var3_3.put("default_audience", (Object)var1.c().toString());
            var3_3.put("isReauthorize", var1.f());
            if (this.c != null) {
                var3_3.put("facebookVersion", (Object)this.c);
            }
            var2_2.putString("6_extras", var3_3.toString());
        }
        catch (JSONException var4_4) {
            ** continue;
        }
lbl14: // 2 sources:
        do {
            this.a.a("fb_mobile_login_start", null, var2_2);
            return;
            break;
        } while (true);
    }

    public void a(String string2, String string3) {
        Bundle bundle = wl.a(string2);
        bundle.putString("3_method", string3);
        this.a.a("fb_mobile_login_method_start", null, bundle);
    }

    public void a(String string2, String string3, String string4) {
        Bundle bundle = wl.a("");
        bundle.putString("2_result", LoginClient.Result.Code.c.a());
        bundle.putString("5_error_message", string3);
        bundle.putString("3_method", string4);
        this.a.a(string2, null, bundle);
    }

    public void a(String string2, String string3, String string4, String string5, String string6, Map<String, String> map) {
        Bundle bundle = wl.a(string2);
        if (string4 != null) {
            bundle.putString("2_result", string4);
        }
        if (string5 != null) {
            bundle.putString("5_error_message", string5);
        }
        if (string6 != null) {
            bundle.putString("4_error_code", string6);
        }
        if (map != null && !map.isEmpty()) {
            bundle.putString("6_extras", new JSONObject(map).toString());
        }
        bundle.putString("3_method", string3);
        this.a.a("fb_mobile_login_method_complete", null, bundle);
    }

    public void a(String string2, Map<String, String> map, LoginClient.Result.Code code, Map<String, String> map2, Exception exception) {
        Bundle bundle = wl.a(string2);
        if (code != null) {
            bundle.putString("2_result", code.a());
        }
        if (exception != null && exception.getMessage() != null) {
            bundle.putString("5_error_message", exception.getMessage());
        }
        boolean bl2 = map.isEmpty();
        JSONObject jSONObject = null;
        if (!bl2) {
            jSONObject = new JSONObject(map);
        }
        if (map2 != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                for (Map.Entry entry : map2.entrySet()) {
                    jSONObject.put((String)entry.getKey(), entry.getValue());
                }
            }
            catch (JSONException var9_11) {
                // empty catch block
            }
        }
        if (jSONObject != null) {
            bundle.putString("6_extras", jSONObject.toString());
        }
        this.a.a("fb_mobile_login_complete", null, bundle);
    }

    public void b(String string2, String string3) {
        this.a(string2, string3, "");
    }
}

