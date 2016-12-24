/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  io.fabric.sdk.android.services.common.CommonUtils
 *  io.fabric.sdk.android.services.network.HttpMethod
 *  io.fabric.sdk.android.services.network.HttpRequest
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.HashMap
 *  java.util.Map
 *  org.json.JSONObject
 */
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class anv
extends all
implements aog {
    public anv(alc alc2, String string2, String string3, anb anb2) {
        super(alc2, string2, string3, anb2, HttpMethod.a);
    }

    anv(alc alc2, String string2, String string3, anb anb2, HttpMethod httpMethod) {
        super(alc2, string2, string3, anb2, httpMethod);
    }

    private HttpRequest a(HttpRequest httpRequest, aof aof2) {
        super.a(httpRequest, "X-CRASHLYTICS-API-KEY", aof2.a);
        super.a(httpRequest, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        super.a(httpRequest, "X-CRASHLYTICS-API-CLIENT-VERSION", this.a.a());
        super.a(httpRequest, "Accept", "application/json");
        super.a(httpRequest, "X-CRASHLYTICS-DEVICE-MODEL", aof2.b);
        super.a(httpRequest, "X-CRASHLYTICS-OS-BUILD-VERSION", aof2.c);
        super.a(httpRequest, "X-CRASHLYTICS-OS-DISPLAY-VERSION", aof2.d);
        super.a(httpRequest, "X-CRASHLYTICS-ADVERTISING-TOKEN", aof2.e);
        super.a(httpRequest, "X-CRASHLYTICS-INSTALLATION-ID", aof2.f);
        super.a(httpRequest, "X-CRASHLYTICS-ANDROID-ID", aof2.g);
        return httpRequest;
    }

    private JSONObject a(String string2) {
        try {
            JSONObject jSONObject = new JSONObject(string2);
            return jSONObject;
        }
        catch (Exception var3_3) {
            akx.h().a("Fabric", "Failed to parse settings JSON from " + this.a(), (Throwable)var3_3);
            akx.h().a("Fabric", "Settings response " + string2);
            return null;
        }
    }

    private void a(HttpRequest httpRequest, String string2, String string3) {
        if (string3 != null) {
            httpRequest.a(string2, string3);
        }
    }

    private Map<String, String> b(aof aof2) {
        String string2;
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"build_version", (Object)aof2.j);
        hashMap.put((Object)"display_version", (Object)aof2.i);
        hashMap.put((Object)"source", (Object)Integer.toString((int)aof2.k));
        if (aof2.l != null) {
            hashMap.put((Object)"icon_hash", (Object)aof2.l);
        }
        if (!CommonUtils.c((String)(string2 = aof2.h))) {
            hashMap.put((Object)"instance", (Object)string2);
        }
        return hashMap;
    }

    @Override
    public JSONObject a(aof aof2) {
        HttpRequest httpRequest = null;
        try {
            Map<String, String> map = super.b(aof2);
            httpRequest = this.a(map);
            httpRequest = super.a(httpRequest, aof2);
            akx.h().a("Fabric", "Requesting settings from " + this.a());
            akx.h().a("Fabric", "Settings query params were: " + map);
            JSONObject jSONObject = this.a(httpRequest);
            return jSONObject;
        }
        finally {
            if (httpRequest != null) {
                akx.h().a("Fabric", "Settings request ID: " + httpRequest.b("X-REQUEST-ID"));
            }
        }
    }

    JSONObject a(HttpRequest httpRequest) {
        int n2 = httpRequest.b();
        akx.h().a("Fabric", "Settings result was: " + n2);
        if (this.a(n2)) {
            return super.a(httpRequest.e());
        }
        akx.h().e("Fabric", "Failed to retrieve settings from " + this.a());
        return null;
    }

    boolean a(int n2) {
        if (n2 == 200 || n2 == 201 || n2 == 202 || n2 == 203) {
            return true;
        }
        return false;
    }
}

