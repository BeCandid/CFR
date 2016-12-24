/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.facebook.internal.FacebookRequestErrorClassification
 *  java.lang.Integer
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Map
 *  java.util.Set
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
import com.facebook.FacebookRequestError;
import com.facebook.internal.FacebookRequestErrorClassification;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class vn {
    private static vn g;
    private final Map<Integer, Set<Integer>> a;
    private final Map<Integer, Set<Integer>> b;
    private final Map<Integer, Set<Integer>> c;
    private final String d;
    private final String e;
    private final String f;

    vn(Map<Integer, Set<Integer>> map, Map<Integer, Set<Integer>> map2, Map<Integer, Set<Integer>> map3, String string2, String string3, String string4) {
        this.a = map;
        this.b = map2;
        this.c = map3;
        this.d = string2;
        this.e = string3;
        this.f = string4;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static Map<Integer, Set<Integer>> a(JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.optJSONArray("items");
        if (jSONArray.length() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        int n2 = 0;
        while (n2 < jSONArray.length()) {
            int n3;
            JSONObject jSONObject2 = jSONArray.optJSONObject(n2);
            if (jSONObject2 != null && (n3 = jSONObject2.optInt("code")) != 0) {
                JSONArray jSONArray2 = jSONObject2.optJSONArray("subcodes");
                HashSet hashSet = null;
                if (jSONArray2 != null) {
                    int n4 = jSONArray2.length();
                    hashSet = null;
                    if (n4 > 0) {
                        hashSet = new HashSet();
                        for (int i2 = 0; i2 < jSONArray2.length(); ++i2) {
                            int n5 = jSONArray2.optInt(i2);
                            if (n5 == 0) continue;
                            hashSet.add((Object)n5);
                        }
                    }
                }
                hashMap.put((Object)n3, (Object)hashSet);
            }
            ++n2;
        }
        return hashMap;
    }

    public static vn a() {
        reference var2 = vn.class;
        synchronized (vn.class) {
            if (g == null) {
                g = vn.b();
            }
            vn vn2 = g;
            // ** MonitorExit[var2] (shouldn't be in output)
            return vn2;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static vn a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        Map<Integer, Set<Integer>> map = null;
        Map<Integer, Set<Integer>> map2 = null;
        Map<Integer, Set<Integer>> map3 = null;
        String string2 = null;
        String string3 = null;
        String string4 = null;
        int n2 = 0;
        while (n2 < jSONArray.length()) {
            String string5;
            JSONObject jSONObject = jSONArray.optJSONObject(n2);
            if (jSONObject != null && (string5 = jSONObject.optString("name")) != null) {
                if (string5.equalsIgnoreCase("other")) {
                    string2 = jSONObject.optString("recovery_message", null);
                    map = vn.a(jSONObject);
                } else if (string5.equalsIgnoreCase("transient")) {
                    string3 = jSONObject.optString("recovery_message", null);
                    map2 = vn.a(jSONObject);
                } else if (string5.equalsIgnoreCase("login_recoverable")) {
                    string4 = jSONObject.optString("recovery_message", null);
                    map3 = vn.a(jSONObject);
                }
            }
            ++n2;
        }
        return new vn(map, map2, map3, string2, string3, string4);
    }

    private static vn b() {
        return new vn(null, (Map<Integer, Set<Integer>>)new HashMap<Integer, Set<Integer>>(){}, (Map<Integer, Set<Integer>>)new HashMap<Integer, Set<Integer>>(){}, null, null, null);
    }

    public FacebookRequestError.Category a(int n2, int n3, boolean bl2) {
        Set set;
        Set set2;
        Set set3;
        if (bl2) {
            return FacebookRequestError.Category.c;
        }
        if (this.a != null && this.a.containsKey((Object)n2) && ((set2 = (Set)this.a.get((Object)n2)) == null || set2.contains((Object)n3))) {
            return FacebookRequestError.Category.b;
        }
        if (this.c != null && this.c.containsKey((Object)n2) && ((set = (Set)this.c.get((Object)n2)) == null || set.contains((Object)n3))) {
            return FacebookRequestError.Category.a;
        }
        if (this.b != null && this.b.containsKey((Object)n2) && ((set3 = (Set)this.b.get((Object)n2)) == null || set3.contains((Object)n3))) {
            return FacebookRequestError.Category.c;
        }
        return FacebookRequestError.Category.b;
    }

    public String a(FacebookRequestError.Category category) {
        switch (.a[category.ordinal()]) {
            default: {
                return null;
            }
            case 1: {
                return this.d;
            }
            case 2: {
                return this.f;
            }
            case 3: 
        }
        return this.e;
    }

}

