/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.os.Build
 *  android.os.Build$VERSION
 *  com.crashlytics.android.answers.SessionEvent
 *  com.crashlytics.android.answers.SessionEvent$Type
 *  java.io.IOException
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Map
 *  org.json.JSONException
 *  org.json.JSONObject
 */
import android.annotation.TargetApi;
import android.os.Build;
import com.crashlytics.android.answers.SessionEvent;
import java.io.IOException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class si
implements amq<SessionEvent> {
    si() {
    }

    @Override
    public byte[] a(SessionEvent sessionEvent) throws IOException {
        return this.b(sessionEvent).toString().getBytes("UTF-8");
    }

    @TargetApi(value=9)
    public JSONObject b(SessionEvent sessionEvent) throws IOException {
        try {
            JSONObject jSONObject = new JSONObject();
            sh sh2 = sessionEvent.a;
            jSONObject.put("appBundleId", (Object)sh2.a);
            jSONObject.put("executionId", (Object)sh2.b);
            jSONObject.put("installationId", (Object)sh2.c);
            jSONObject.put("androidId", (Object)sh2.d);
            jSONObject.put("advertisingId", (Object)sh2.e);
            jSONObject.put("limitAdTrackingEnabled", (Object)sh2.f);
            jSONObject.put("betaDeviceToken", (Object)sh2.g);
            jSONObject.put("buildId", (Object)sh2.h);
            jSONObject.put("osVersion", (Object)sh2.i);
            jSONObject.put("deviceModel", (Object)sh2.j);
            jSONObject.put("appVersionCode", (Object)sh2.k);
            jSONObject.put("appVersionName", (Object)sh2.l);
            jSONObject.put("timestamp", sessionEvent.b);
            jSONObject.put("type", (Object)sessionEvent.c.toString());
            if (sessionEvent.d != null) {
                jSONObject.put("details", (Object)new JSONObject(sessionEvent.d));
            }
            jSONObject.put("customType", (Object)sessionEvent.e);
            if (sessionEvent.f != null) {
                jSONObject.put("customAttributes", (Object)new JSONObject(sessionEvent.f));
            }
            jSONObject.put("predefinedType", (Object)sessionEvent.g);
            if (sessionEvent.h != null) {
                jSONObject.put("predefinedAttributes", (Object)new JSONObject(sessionEvent.h));
            }
            return jSONObject;
        }
        catch (JSONException var3_4) {
            if (Build.VERSION.SDK_INT >= 9) {
                throw new IOException(var3_4.getMessage(), (Throwable)var3_4);
            }
            throw new IOException(var3_4.getMessage());
        }
    }
}

