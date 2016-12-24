/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  org.json.JSONException
 *  org.json.JSONObject
 */
import android.os.Bundle;
import com.facebook.LoggingBehavior;
import java.util.Collection;
import org.json.JSONException;
import org.json.JSONObject;

public final class wc {
    public static final Collection<String> a;
    public static final Collection<String> b;
    private static final String c;

    static {
        c = wc.class.getName();
        a = we.a(new String[]{"service_disabled", "AndroidAuthKillSwitchException"});
        b = we.a(new String[]{"access_denied", "OAuthAccessDeniedException"});
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Bundle a(String string2, int n2, Bundle bundle) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        String string3 = ul.d(ul.f());
        if (we.a(string3)) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("android_key_hash", string3);
        bundle2.putString("app_id", ul.i());
        bundle2.putInt("version", n2);
        bundle2.putString("display", "touch");
        Bundle bundle3 = new Bundle();
        bundle3.putString("action_id", string2);
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            jSONObject2 = vh.a(bundle3);
            jSONObject = vh.a(bundle);
            if (jSONObject2 == null || jSONObject == null) return null;
        }
        catch (JSONException var6_8) {
            vx.a(LoggingBehavior.f, 6, c, "Error creating Url -- " + (Object)var6_8);
            return null;
        }
        bundle2.putString("bridge_args", jSONObject2.toString());
        bundle2.putString("method_args", jSONObject.toString());
        return bundle2;
    }

    public static final String a() {
        Object[] arrobject = new Object[]{ul.e()};
        return String.format((String)"m.%s", (Object[])arrobject);
    }

    public static final String b() {
        Object[] arrobject = new Object[]{ul.e()};
        return String.format((String)"https://graph.%s", (Object[])arrobject);
    }

    public static final String c() {
        Object[] arrobject = new Object[]{ul.e()};
        return String.format((String)"https://graph-video.%s", (Object[])arrobject);
    }

    public static final String d() {
        return "v2.6";
    }
}

