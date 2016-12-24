/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Set
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.SharePhoto;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ww {
    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Object a(Object object, a a2) throws JSONException {
        if (object == null) {
            return JSONObject.NULL;
        }
        if (object instanceof String) return object;
        if (object instanceof Boolean) return object;
        if (object instanceof Double) return object;
        if (object instanceof Float) return object;
        if (object instanceof Integer) return object;
        if (object instanceof Long) return object;
        if (object instanceof SharePhoto) {
            if (a2 == null) return null;
            return a2.a((SharePhoto)object);
        }
        if (object instanceof ShareOpenGraphObject) {
            return ww.a((ShareOpenGraphObject)object, a2);
        }
        if (!(object instanceof List)) throw new IllegalArgumentException("Invalid object found for JSON serialization: " + object.toString());
        return ww.a((List)object, a2);
    }

    private static JSONArray a(List list, a a2) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            jSONArray.put(ww.a(iterator.next(), a2));
        }
        return jSONArray;
    }

    public static JSONObject a(ShareOpenGraphAction shareOpenGraphAction, a a2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String string2 : shareOpenGraphAction.c()) {
            jSONObject.put(string2, ww.a(shareOpenGraphAction.a(string2), a2));
        }
        return jSONObject;
    }

    private static JSONObject a(ShareOpenGraphObject shareOpenGraphObject, a a2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String string2 : shareOpenGraphObject.c()) {
            jSONObject.put(string2, ww.a(shareOpenGraphObject.a(string2), a2));
        }
        return jSONObject;
    }

    public static interface a {
        public JSONObject a(SharePhoto var1);
    }

}

