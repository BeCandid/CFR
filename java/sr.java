/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
import java.io.IOException;
import org.json.JSONObject;

class sr {
    sr() {
    }

    public sq a(JSONObject jSONObject) throws IOException {
        if (jSONObject == null) {
            return null;
        }
        String string2 = jSONObject.optString("url", null);
        String string3 = jSONObject.optString("version_string", null);
        String string4 = jSONObject.optString("build_version", null);
        return new sq(string2, string3, jSONObject.optString("display_version", null), string4, jSONObject.optString("identifier", null), jSONObject.optString("instance_identifier", null));
    }
}

