/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.concurrent.ConcurrentHashMap
 *  org.json.JSONObject
 */
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

class wb {
    private static final ConcurrentHashMap<String, JSONObject> a = new ConcurrentHashMap();

    public static JSONObject a(String string2) {
        return (JSONObject)a.get((Object)string2);
    }

    public static void a(String string2, JSONObject jSONObject) {
        a.put((Object)string2, (Object)jSONObject);
    }
}

