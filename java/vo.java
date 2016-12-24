/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.webkit.WebView
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  org.json.JSONException
 *  org.json.JSONObject
 */
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import org.json.JSONException;
import org.json.JSONObject;

public class vo
extends wg {
    private static final String a = vo.class.getName();
    private boolean b;

    public vo(Context context, String string2, String string3) {
        super(context, string2);
        this.b(string3);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    protected Bundle a(String string2) {
        Bundle bundle = we.c(Uri.parse((String)string2).getQuery());
        String string3 = bundle.getString("bridge_args");
        bundle.remove("bridge_args");
        if (!we.a(string3)) {
            try {
                bundle.putBundle("com.facebook.platform.protocol.BRIDGE_ARGS", vh.a(new JSONObject(string3)));
            }
            catch (JSONException var6_5) {
                we.a(a, "Unable to parse bridge_args JSON", (Throwable)var6_5);
            }
        }
        String string4 = bundle.getString("method_results");
        bundle.remove("method_results");
        if (!we.a(string4)) {
            if (we.a(string4)) {
                string4 = "{}";
            }
            try {
                bundle.putBundle("com.facebook.platform.protocol.RESULT_ARGS", vh.a(new JSONObject(string4)));
            }
            catch (JSONException var5_6) {
                we.a(a, "Unable to parse bridge_args JSON", (Throwable)var5_6);
            }
        }
        bundle.remove("version");
        bundle.putInt("com.facebook.platform.protocol.PROTOCOL_VERSION", vz.a());
        return bundle;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void cancel() {
        WebView webView = this.c();
        if (!this.b() || this.a() || webView == null || !webView.isShown()) {
            super.cancel();
            return;
        } else {
            if (this.b) return;
            {
                this.b = true;
                webView.loadUrl("javascript:" + "(function() {  var event = document.createEvent('Event');  event.initEvent('fbPlatformDialogMustClose',true,true);  document.dispatchEvent(event);})();");
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable(){

                    public void run() {
                        vo.this.cancel();
                    }
                }, 1500);
                return;
            }
        }
    }

}

