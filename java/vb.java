/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  java.io.UnsupportedEncodingException
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
import android.content.Context;
import android.os.Bundle;
import com.facebook.GraphRequest;
import com.facebook.appevents.AppEvent;
import com.facebook.internal.AppEventsLoggerUtility;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class vb {
    private List<AppEvent> a = new ArrayList();
    private List<AppEvent> b = new ArrayList();
    private int c;
    private vg d;
    private String e;
    private final int f = 1000;

    public vb(vg vg2, String string2) {
        this.d = vg2;
        this.e = string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(GraphRequest graphRequest, Context context, int n2, JSONArray jSONArray, boolean bl2) {
        JSONObject jSONObject;
        String string2;
        try {
            jSONObject = AppEventsLoggerUtility.a(AppEventsLoggerUtility.GraphAPIActivityType.b, this.d, this.e, bl2, context);
            if (this.c > 0) {
                jSONObject.put("num_skipped_events", n2);
            }
        }
        catch (JSONException var6_9) {
            jSONObject = new JSONObject();
        }
        graphRequest.a(jSONObject);
        Bundle bundle = graphRequest.e();
        if (bundle == null) {
            bundle = new Bundle();
        }
        if ((string2 = jSONArray.toString()) != null) {
            bundle.putByteArray("custom_events_file", this.a(string2));
            graphRequest.a((Object)string2);
        }
        graphRequest.a(bundle);
    }

    private byte[] a(String string2) {
        try {
            byte[] arrby = string2.getBytes("UTF-8");
            return arrby;
        }
        catch (UnsupportedEncodingException var2_3) {
            we.a("Encoding exception: ", (Exception)var2_3);
            return null;
        }
    }

    public int a() {
        vb vb2 = this;
        synchronized (vb2) {
            int n2 = this.a.size();
            return n2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int a(GraphRequest graphRequest, Context context, boolean bl2, boolean bl3) {
        JSONArray jSONArray;
        int n2;
        void var12_5 = this;
        synchronized (var12_5) {
            n2 = this.c;
            this.b.addAll(this.a);
            this.a.clear();
            jSONArray = new JSONArray();
            for (AppEvent appEvent : this.b) {
                if (!bl2 && appEvent.b()) continue;
                jSONArray.put((Object)appEvent.c());
            }
            if (jSONArray.length() == 0) {
                return 0;
            }
        }
        super.a(graphRequest, context, n2, jSONArray, bl3);
        return jSONArray.length();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(AppEvent appEvent) {
        void var4_2 = this;
        synchronized (var4_2) {
            if (this.a.size() + this.b.size() >= 1000) {
                this.c = 1 + this.c;
            } else {
                this.a.add((Object)appEvent);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(boolean bl2) {
        void var4_2 = this;
        synchronized (var4_2) {
            if (bl2) {
                this.a.addAll(this.b);
            }
            this.b.clear();
            this.c = 0;
            return;
        }
    }

    public List<AppEvent> b() {
        vb vb2 = this;
        synchronized (vb2) {
            List<AppEvent> list = this.a;
            this.a = new ArrayList();
            return list;
        }
    }
}

