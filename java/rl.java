/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 *  java.util.concurrent.ConcurrentHashMap
 *  org.json.JSONObject
 */
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

class rl {
    final rn a;
    final Map<String, Object> b = new ConcurrentHashMap();

    public rl(rn rn2) {
        this.a = rn2;
    }

    void a(String string2, Object object) {
        if (!this.a.a(this.b, string2)) {
            this.b.put((Object)string2, object);
        }
    }

    void a(String string2, String string3) {
        if (this.a.a(string2, "key") || this.a.a(string3, "value")) {
            return;
        }
        this.a(this.a.a(string2), (Object)this.a.a(string3));
    }

    public String toString() {
        return new JSONObject(this.b).toString();
    }
}

