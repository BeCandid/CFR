/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  io.fabric.sdk.android.services.network.HttpMethod
 *  io.fabric.sdk.android.services.network.HttpRequest
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.HashMap
 *  java.util.Map
 *  org.json.JSONObject
 */
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class sp
extends all {
    private final sr b;

    public sp(alc alc2, String string2, String string3, anb anb2, sr sr2) {
        super(alc2, string2, string3, anb2, HttpMethod.a);
        this.b = sr2;
    }

    private HttpRequest a(HttpRequest httpRequest, String string2, String string3) {
        return httpRequest.a("Accept", "application/json").a("User-Agent", "Crashlytics Android SDK/" + this.a.a()).a("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa").a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.a()).a("X-CRASHLYTICS-API-KEY", string2).a("X-CRASHLYTICS-BETA-TOKEN", sp.a(string3));
    }

    static String a(String string2) {
        return "3:" + string2;
    }

    private Map<String, String> a(so so2) {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"build_version", (Object)so2.a);
        hashMap.put((Object)"display_version", (Object)so2.b);
        hashMap.put((Object)"instance", (Object)so2.c);
        hashMap.put((Object)"source", (Object)"3");
        return hashMap;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public sq a(String string2, String string3, so so2) {
        HttpRequest httpRequest = null;
        try {
            Map<String, String> map = super.a(so2);
            httpRequest = this.a(map);
            httpRequest = super.a(httpRequest, string2, string3);
            akx.h().a("Beta", "Checking for updates from " + this.a());
            akx.h().a("Beta", "Checking for updates query params are: " + map);
            if (httpRequest.c()) {
                akx.h().a("Beta", "Checking for updates was successful");
                JSONObject jSONObject = new JSONObject(httpRequest.e());
                sq sq2 = this.b.a(jSONObject);
                return sq2;
            }
            akx.h().e("Beta", "Checking for updates failed. Response code: " + httpRequest.b());
            do {
                return null;
                break;
            } while (true);
        }
        catch (Exception var7_10) {
            akx.h().e("Beta", "Error while checking for updates from " + this.a(), (Throwable)var7_10);
            return null;
        }
        finally {
            if (httpRequest == null) return null;
            {
                String string4 = httpRequest.b("X-REQUEST-ID");
                akx.h().a("Fabric", "Checking for updates request ID: " + string4);
            }
            return null;
        }
    }
}

