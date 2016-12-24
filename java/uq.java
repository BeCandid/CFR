/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONException
 *  org.json.JSONObject
 */
import android.content.SharedPreferences;
import com.facebook.Profile;
import org.json.JSONException;
import org.json.JSONObject;

final class uq {
    private final SharedPreferences a = ul.f().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0);

    uq() {
    }

    Profile a() {
        String string2 = this.a.getString("com.facebook.ProfileManager.CachedProfile", null);
        if (string2 != null) {
            try {
                Profile profile = new Profile(new JSONObject(string2));
                return profile;
            }
            catch (JSONException var3_3) {
                // empty catch block
            }
        }
        return null;
    }

    void a(Profile profile) {
        wf.a(profile, "profile");
        JSONObject jSONObject = profile.d();
        if (jSONObject != null) {
            this.a.edit().putString("com.facebook.ProfileManager.CachedProfile", jSONObject.toString()).apply();
        }
    }

    void b() {
        this.a.edit().remove("com.facebook.ProfileManager.CachedProfile").apply();
    }
}

