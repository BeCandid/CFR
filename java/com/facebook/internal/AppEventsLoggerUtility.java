/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.facebook.internal;

import android.content.Context;
import com.facebook.LoggingBehavior;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class AppEventsLoggerUtility {
    private static final Map<GraphAPIActivityType, String> a = new HashMap<GraphAPIActivityType, String>(){};

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static JSONObject a(GraphAPIActivityType graphAPIActivityType, vg vg2, String string2, boolean bl2, Context context) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("event", a.get((Object)graphAPIActivityType));
        we.a(jSONObject, vg2, string2, bl2);
        try {
            we.a(jSONObject, context);
        }
        catch (Exception var7_6) {
            LoggingBehavior loggingBehavior = LoggingBehavior.e;
            Object[] arrobject = new Object[]{var7_6.toString()};
            vx.a(loggingBehavior, "AppEvents", "Fetching extended device info parameters failed: '%s'", arrobject);
        }
        jSONObject.put("application_package_name", (Object)context.getPackageName());
        return jSONObject;
    }

    public static final class GraphAPIActivityType
    extends Enum<GraphAPIActivityType> {
        public static final /* enum */ GraphAPIActivityType a = new GraphAPIActivityType();
        public static final /* enum */ GraphAPIActivityType b = new GraphAPIActivityType();
        private static final /* synthetic */ GraphAPIActivityType[] c;

        static {
            GraphAPIActivityType[] arrgraphAPIActivityType = new GraphAPIActivityType[]{a, b};
            c = arrgraphAPIActivityType;
        }

        private GraphAPIActivityType() {
            super(string2, n2);
        }

        public static GraphAPIActivityType valueOf(String string2) {
            return (GraphAPIActivityType)Enum.valueOf((Class)GraphAPIActivityType.class, (String)string2);
        }

        public static GraphAPIActivityType[] values() {
            return (GraphAPIActivityType[])c.clone();
        }
    }

}

