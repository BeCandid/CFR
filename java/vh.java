/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class vh {
    private static final Map<Class<?>, a> a = new HashMap();

    static {
        a.put((Object)Boolean.class, (Object)new a(){

            @Override
            public void a(Bundle bundle, String string2, Object object) throws JSONException {
                bundle.putBoolean(string2, ((Boolean)object).booleanValue());
            }

            @Override
            public void a(JSONObject jSONObject, String string2, Object object) throws JSONException {
                jSONObject.put(string2, object);
            }
        });
        a.put((Object)Integer.class, (Object)new a(){

            @Override
            public void a(Bundle bundle, String string2, Object object) throws JSONException {
                bundle.putInt(string2, ((Integer)object).intValue());
            }

            @Override
            public void a(JSONObject jSONObject, String string2, Object object) throws JSONException {
                jSONObject.put(string2, object);
            }
        });
        a.put((Object)Long.class, (Object)new a(){

            @Override
            public void a(Bundle bundle, String string2, Object object) throws JSONException {
                bundle.putLong(string2, ((Long)object).longValue());
            }

            @Override
            public void a(JSONObject jSONObject, String string2, Object object) throws JSONException {
                jSONObject.put(string2, object);
            }
        });
        a.put((Object)Double.class, (Object)new a(){

            @Override
            public void a(Bundle bundle, String string2, Object object) throws JSONException {
                bundle.putDouble(string2, ((Double)object).doubleValue());
            }

            @Override
            public void a(JSONObject jSONObject, String string2, Object object) throws JSONException {
                jSONObject.put(string2, object);
            }
        });
        a.put((Object)String.class, (Object)new a(){

            @Override
            public void a(Bundle bundle, String string2, Object object) throws JSONException {
                bundle.putString(string2, (String)object);
            }

            @Override
            public void a(JSONObject jSONObject, String string2, Object object) throws JSONException {
                jSONObject.put(string2, object);
            }
        });
        a.put((Object)String[].class, (Object)new a(){

            @Override
            public void a(Bundle bundle, String string2, Object object) throws JSONException {
                throw new IllegalArgumentException("Unexpected type from JSON");
            }

            @Override
            public void a(JSONObject jSONObject, String string2, Object object) throws JSONException {
                JSONArray jSONArray = new JSONArray();
                String[] arrstring = (String[])object;
                int n2 = arrstring.length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    jSONArray.put((Object)arrstring[i2]);
                }
                jSONObject.put(string2, (Object)jSONArray);
            }
        });
        a.put((Object)JSONArray.class, (Object)new a(){

            @Override
            public void a(Bundle bundle, String string2, Object object) throws JSONException {
                JSONArray jSONArray = (JSONArray)object;
                ArrayList arrayList = new ArrayList();
                if (jSONArray.length() == 0) {
                    bundle.putStringArrayList(string2, arrayList);
                    return;
                }
                for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
                    Object object2 = jSONArray.get(i2);
                    if (object2 instanceof String) {
                        arrayList.add((Object)((String)object2));
                        continue;
                    }
                    throw new IllegalArgumentException("Unexpected type in an array: " + (Object)object2.getClass());
                }
                bundle.putStringArrayList(string2, arrayList);
            }

            @Override
            public void a(JSONObject jSONObject, String string2, Object object) throws JSONException {
                throw new IllegalArgumentException("JSONArray's are not supported in bundles.");
            }
        });
    }

    public static Bundle a(JSONObject jSONObject) throws JSONException {
        Bundle bundle = new Bundle();
        Iterator iterator = jSONObject.keys();
        while (iterator.hasNext()) {
            String string2 = (String)iterator.next();
            Object object = jSONObject.get(string2);
            if (object == null || object == JSONObject.NULL) continue;
            if (object instanceof JSONObject) {
                bundle.putBundle(string2, vh.a((JSONObject)object));
                continue;
            }
            a a2 = (a)a.get((Object)object.getClass());
            if (a2 == null) {
                throw new IllegalArgumentException("Unsupported type: " + (Object)object.getClass());
            }
            a2.a(bundle, string2, object);
        }
        return bundle;
    }

    public static JSONObject a(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String string2 : bundle.keySet()) {
            Object object = bundle.get(string2);
            if (object == null) continue;
            if (object instanceof List) {
                JSONArray jSONArray = new JSONArray();
                Iterator iterator = ((List)object).iterator();
                while (iterator.hasNext()) {
                    jSONArray.put((Object)((String)iterator.next()));
                }
                jSONObject.put(string2, (Object)jSONArray);
                continue;
            }
            if (object instanceof Bundle) {
                jSONObject.put(string2, (Object)vh.a((Bundle)object));
                continue;
            }
            a a2 = (a)a.get((Object)object.getClass());
            if (a2 == null) {
                throw new IllegalArgumentException("Unsupported type: " + (Object)object.getClass());
            }
            a2.a(jSONObject, string2, object);
        }
        return jSONObject;
    }

    public static interface a {
        public void a(Bundle var1, String var2, Object var3) throws JSONException;

        public void a(JSONObject var1, String var2, Object var3) throws JSONException;
    }

}

