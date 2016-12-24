/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONException
 *  org.json.JSONObject
 */
import org.json.JSONException;
import org.json.JSONObject;

class anu
implements aoe {
    anu() {
    }

    private long a(alu alu2, long l2, JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("expires_at")) {
            return jSONObject.getLong("expires_at");
        }
        return alu2.a() + 1000 * l2;
    }

    private ano a(JSONObject jSONObject) throws JSONException {
        String string2 = jSONObject.getString("identifier");
        String string3 = jSONObject.getString("status");
        String string4 = jSONObject.getString("url");
        String string5 = jSONObject.getString("reports_url");
        boolean bl2 = jSONObject.optBoolean("update_required", false);
        boolean bl3 = jSONObject.has("icon");
        anm anm2 = null;
        if (bl3) {
            boolean bl4 = jSONObject.getJSONObject("icon").has("hash");
            anm2 = null;
            if (bl4) {
                anm2 = super.b(jSONObject.getJSONObject("icon"));
            }
        }
        return new ano(string2, string3, string4, string5, bl2, anm2);
    }

    private anm b(JSONObject jSONObject) throws JSONException {
        return new anm(jSONObject.getString("hash"), jSONObject.getInt("width"), jSONObject.getInt("height"));
    }

    private anw c(JSONObject jSONObject) {
        return new anw(jSONObject.optBoolean("prompt_enabled", false), jSONObject.optBoolean("collect_logged_exceptions", true), jSONObject.optBoolean("collect_reports", true), jSONObject.optBoolean("collect_analytics", false));
    }

    private anl d(JSONObject jSONObject) {
        return new anl(jSONObject.optString("url", "https://e.crashlytics.com/spi/v2/events"), jSONObject.optInt("flush_interval_secs", 600), jSONObject.optInt("max_byte_size_per_file", 8000), jSONObject.optInt("max_file_count_per_send", 1), jSONObject.optInt("max_pending_send_file_count", 100), jSONObject.optBoolean("track_custom_events", true), jSONObject.optBoolean("track_predefined_events", true), jSONObject.optInt("sampling_rate", 1), jSONObject.optBoolean("flush_on_background", true));
    }

    private anz e(JSONObject jSONObject) throws JSONException {
        return new anz(jSONObject.optInt("log_buffer_size", 64000), jSONObject.optInt("max_chained_exception_depth", 8), jSONObject.optInt("max_custom_exception_events", 64), jSONObject.optInt("max_custom_key_value_pairs", 64), jSONObject.optInt("identifier_mask", 255), jSONObject.optBoolean("send_session_without_crash", false));
    }

    private any f(JSONObject jSONObject) throws JSONException {
        return new any(jSONObject.optString("title", "Send Crash Report?"), jSONObject.optString("message", "Looks like we crashed! Please help us fix the problem by sending a crash report."), jSONObject.optString("send_button_title", "Send"), jSONObject.optBoolean("show_cancel_button", true), jSONObject.optString("cancel_button_title", "Don't Send"), jSONObject.optBoolean("show_always_send_button", true), jSONObject.optString("always_send_button_title", "Always Send"));
    }

    private anp g(JSONObject jSONObject) throws JSONException {
        return new anp(jSONObject.optString("update_endpoint", aod.a), jSONObject.optInt("update_suspend_duration", 3600));
    }

    @Override
    public aoc a(alu alu2, JSONObject jSONObject) throws JSONException {
        int n2 = jSONObject.optInt("settings_version", 0);
        int n3 = jSONObject.optInt("cache_duration", 3600);
        ano ano2 = super.a(jSONObject.getJSONObject("app"));
        anz anz2 = super.e(jSONObject.getJSONObject("session"));
        any any2 = super.f(jSONObject.getJSONObject("prompt"));
        anw anw2 = super.c(jSONObject.getJSONObject("features"));
        anl anl2 = super.d(jSONObject.getJSONObject("analytics"));
        anp anp2 = super.g(jSONObject.getJSONObject("beta"));
        return new aoc(super.a(alu2, n3, jSONObject), ano2, anz2, any2, anw2, anl2, anp2, n2, n3);
    }
}

