/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.os.Bundle
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONException
 *  org.json.JSONObject
 */
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.AccessToken;
import org.json.JSONException;
import org.json.JSONObject;

class ug {
    private final SharedPreferences a;
    private final a b;
    private up c;

    public ug() {
        this(ul.f().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0), new a());
    }

    ug(SharedPreferences sharedPreferences, a a2) {
        this.a = sharedPreferences;
        this.b = a2;
    }

    private boolean c() {
        return this.a.contains("com.facebook.AccessTokenManager.CachedAccessToken");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private AccessToken d() {
        String string2 = this.a.getString("com.facebook.AccessTokenManager.CachedAccessToken", null);
        AccessToken accessToken = null;
        if (string2 == null) return accessToken;
        try {
            AccessToken accessToken2 = AccessToken.a(new JSONObject(string2));
            return accessToken2;
        }
        catch (JSONException jSONException) {
            return null;
        }
    }

    private boolean e() {
        return ul.c();
    }

    private AccessToken f() {
        Bundle bundle = this.g().a();
        AccessToken accessToken = null;
        if (bundle != null) {
            boolean bl2 = up.a(bundle);
            accessToken = null;
            if (bl2) {
                accessToken = AccessToken.a(bundle);
            }
        }
        return accessToken;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private up g() {
        if (this.c == null) {
            ug ug2 = this;
            synchronized (ug2) {
                if (this.c == null) {
                    this.c = this.b.a();
                }
            }
        }
        return this.c;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public AccessToken a() {
        if (this.c()) {
            return this.d();
        }
        boolean bl2 = this.e();
        AccessToken accessToken = null;
        if (!bl2) return accessToken;
        accessToken = this.f();
        if (accessToken == null) return accessToken;
        this.a(accessToken);
        this.g().b();
        return accessToken;
    }

    public void a(AccessToken accessToken) {
        wf.a(accessToken, "accessToken");
        try {
            JSONObject jSONObject = accessToken.j();
            this.a.edit().putString("com.facebook.AccessTokenManager.CachedAccessToken", jSONObject.toString()).apply();
            return;
        }
        catch (JSONException var2_3) {
            return;
        }
    }

    public void b() {
        this.a.edit().remove("com.facebook.AccessTokenManager.CachedAccessToken").apply();
        if (this.e()) {
            this.g().b();
        }
    }

    static class a {
        a() {
        }

        public up a() {
            return new up(ul.f());
        }
    }

}

