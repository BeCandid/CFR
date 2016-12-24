/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  java.io.Serializable
 *  java.lang.Double
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.HashSet
 *  java.util.Locale
 *  java.util.Set
 *  java.util.UUID
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.facebook.appevents;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class AppEvent
implements Serializable {
    private static final HashSet<String> c = new HashSet();
    private JSONObject a;
    private boolean b;
    private String d;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public AppEvent(String string2, String string3, Double d2, Bundle bundle, boolean bl2, UUID uUID) {
        try {
            this.a(string3);
            this.d = string3;
            this.b = bl2;
            this.a = new JSONObject();
            this.a.put("_eventName", (Object)string3);
            this.a.put("_logTime", System.currentTimeMillis() / 1000);
            this.a.put("_ui", (Object)string2);
            if (uUID != null) {
                this.a.put("_session_id", (Object)uUID);
            }
            if (d2 != null) {
                this.a.put("_valueToSum", d2.doubleValue());
            }
            if (this.b) {
                this.a.put("_implicitlyLogged", (Object)"1");
            }
            if (bundle != null) {
                for (String string4 : bundle.keySet()) {
                    this.a(string4);
                    Object object = bundle.get(string4);
                    if (!(object instanceof String) && !(object instanceof Number)) {
                        throw new FacebookException(String.format((String)"Parameter value '%s' for key '%s' should be a string or a numeric type.", (Object[])new Object[]{object, string4}));
                    }
                    this.a.put(string4, (Object)object.toString());
                }
            }
            if (this.b) return;
            {
                LoggingBehavior loggingBehavior = LoggingBehavior.e;
                Object[] arrobject = new Object[]{this.a.toString()};
                vx.a(loggingBehavior, "AppEvents", "Created app event '%s'", arrobject);
                return;
            }
        }
        catch (JSONException var10_10) {
            LoggingBehavior loggingBehavior = LoggingBehavior.e;
            Object[] arrobject = new Object[]{var10_10.toString()};
            vx.a(loggingBehavior, "AppEvents", "JSON encoding for app event failed: '%s'", arrobject);
            this.a = null;
            return;
        }
        catch (FacebookException var7_13) {
            LoggingBehavior loggingBehavior = LoggingBehavior.e;
            Object[] arrobject = new Object[]{var7_13.toString()};
            vx.a(loggingBehavior, "AppEvents", "Invalid app event name or parameter:", arrobject);
            this.a = null;
            return;
        }
    }

    private AppEvent(String string2, boolean bl2) throws JSONException {
        this.a = new JSONObject(string2);
        this.b = bl2;
    }

    /* synthetic */ AppEvent(String string2, boolean bl2,  var3_2) throws JSONException {
        super(string2, bl2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void a(String string2) throws FacebookException {
        HashSet<String> hashSet;
        HashSet<String> hashSet2;
        if (string2 == null || string2.length() == 0 || string2.length() > 40) {
            if (string2 == null) {
                string2 = "<None Provided>";
            }
            Locale locale = Locale.ROOT;
            Object[] arrobject = new Object[]{string2, 40};
            throw new FacebookException(String.format((Locale)locale, (String)"Identifier '%s' must be less than %d characters", (Object[])arrobject));
        }
        HashSet<String> hashSet3 = hashSet2 = c;
        // MONITORENTER : hashSet3
        boolean bl2 = c.contains((Object)string2);
        // MONITOREXIT : hashSet3
        if (bl2) return;
        if (!string2.matches("^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$")) throw new FacebookException(String.format((String)"Skipping event named '%s' due to illegal name - must be under 40 chars and alphanumeric, _, - or space, and not start with a space or hyphen.", (Object[])new Object[]{string2}));
        HashSet<String> hashSet4 = hashSet = c;
        // MONITORENTER : hashSet4
        c.add((Object)string2);
        // MONITOREXIT : hashSet4
    }

    private Object writeReplace() {
        return new SerializationProxyV1(this.a.toString(), this.b, null);
    }

    public String a() {
        return this.d;
    }

    public boolean b() {
        return this.b;
    }

    public JSONObject c() {
        return this.a;
    }

    public String toString() {
        Object[] arrobject = new Object[]{this.a.optString("_eventName"), this.b, this.a.toString()};
        return String.format((String)"\"%s\", implicit: %b, json: %s", (Object[])arrobject);
    }

    public static class SerializationProxyV1
    implements Serializable {
        private final String a;
        private final boolean b;

        private SerializationProxyV1(String string2, boolean bl2) {
            this.a = string2;
            this.b = bl2;
        }

        /* synthetic */ SerializationProxyV1(String string2, boolean bl2,  var3_2) {
            super(string2, bl2);
        }

        private Object readResolve() throws JSONException {
            return new AppEvent(this.a, this.b, null);
        }
    }

}

