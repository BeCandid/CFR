/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.Log
 *  java.io.Closeable
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.CharSequence
 *  java.lang.Double
 *  java.lang.Exception
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Locale
 *  java.util.Set
 *  java.util.UUID
 *  java.util.concurrent.ConcurrentHashMap
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.share.internal.LikeContent;
import com.facebook.share.widget.LikeView;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ws {
    private static final String a = ws.class.getSimpleName();
    private static vp b;
    private static final ConcurrentHashMap<String, ws> c;
    private static wh d;
    private static wh e;
    private static Handler f;
    private static String g;
    private static boolean h;
    private static volatile int i;
    private static ui j;
    private String k;
    private LikeView.ObjectType l;
    private boolean m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private boolean t;
    private boolean u;
    private boolean v;
    private Bundle w;
    private AppEventsLogger x;

    static {
        c = new ConcurrentHashMap();
        d = new wh(1);
        e = new wh(1);
    }

    private ws(String string2, LikeView.ObjectType objectType) {
        this.k = string2;
        this.l = objectType;
    }

    private static ws a(String string2) {
        String string3 = ws.d(string2);
        ws ws2 = (ws)c.get((Object)string3);
        if (ws2 != null) {
            d.a(new j(string3, false));
        }
        return ws2;
    }

    private wx a(final Bundle bundle) {
        return new wx(null){

            @Override
            public void a(vf vf2) {
                this.a(vf2, new FacebookOperationCanceledException());
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void a(vf vf2, Bundle bundle3) {
                if (bundle3 == null || !bundle3.containsKey("object_is_liked")) {
                    return;
                }
                boolean bl2 = bundle3.getBoolean("object_is_liked");
                String string2 = ws.this.n;
                String string3 = ws.this.o;
                if (bundle3.containsKey("like_count_string")) {
                    string3 = string2 = bundle3.getString("like_count_string");
                }
                String string4 = ws.this.p;
                String string5 = ws.this.q;
                if (bundle3.containsKey("social_sentence")) {
                    string5 = string4 = bundle3.getString("social_sentence");
                }
                String string6 = bundle3.containsKey("object_is_liked") ? bundle3.getString("unlike_token") : ws.this.r;
                Bundle bundle2 = bundle == null ? new Bundle() : bundle;
                bundle2.putString("call_id", vf2.c().toString());
                ws.this.l().a("fb_like_control_dialog_did_succeed", null, bundle2);
                ws.this.a(bl2, string2, string3, string4, string5, string6);
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void a(vf vf2, FacebookException facebookException) {
                vx.a(LoggingBehavior.a, a, "Like Dialog failed with error : %s", new Object[]{facebookException});
                Bundle bundle2 = bundle == null ? new Bundle() : bundle;
                bundle2.putString("call_id", vf2.c().toString());
                ws.this.a("present_dialog", bundle2);
                ws.c(ws.this, "com.facebook.sdk.LikeActionController.DID_ERROR", vz.a(facebookException));
            }
        };
    }

    private void a(String string2, Bundle bundle) {
        Bundle bundle2 = new Bundle(bundle);
        bundle2.putString("object_id", this.k);
        bundle2.putString("object_type", this.l.toString());
        bundle2.putString("current_action", string2);
        super.l().a("fb_like_control_error", null, bundle2);
    }

    private void a(String string2, FacebookRequestError facebookRequestError) {
        JSONObject jSONObject;
        Bundle bundle = new Bundle();
        if (facebookRequestError != null && (jSONObject = facebookRequestError.f()) != null) {
            bundle.putString("error", jSONObject.toString());
        }
        super.a(string2, bundle);
    }

    public static void a(String string2, LikeView.ObjectType objectType, c c2) {
        ws ws2;
        if (!h) {
            ws.j();
        }
        if ((ws2 = ws.a(string2)) != null) {
            ws.a(ws2, objectType, c2);
            return;
        }
        e.a(new b(string2, objectType, c2));
    }

    private static void a(String string2, ws ws2) {
        String string3 = ws.d(string2);
        d.a(new j(string3, true));
        c.put((Object)string3, (Object)ws2);
    }

    private static void a(final c c2, final ws ws2, final FacebookException facebookException) {
        if (c2 == null) {
            return;
        }
        f.post(new Runnable(){

            public void run() {
                c2.a(ws2, facebookException);
            }
        });
    }

    private void a(final m m2) {
        if (!we.a(this.s)) {
            if (m2 != null) {
                m2.a();
            }
            return;
        }
        final e e2 = (ws)this.new e(this.k, this.l);
        final g g2 = (ws)this.new g(this.k, this.l);
        un un2 = new un();
        e2.a(un2);
        g2.a(un2);
        un2.a(new un.a(){

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void a(un un2) {
                ws.this.s = e2.e;
                if (we.a(ws.this.s)) {
                    ws.this.s = g2.e;
                    ws.this.t = g2.f;
                }
                if (we.a(ws.this.s)) {
                    LoggingBehavior loggingBehavior = LoggingBehavior.f;
                    String string2 = a;
                    Object[] arrobject = new Object[]{ws.this.k};
                    vx.a(loggingBehavior, string2, "Unable to verify the FB id for '%s'. Verify that it is a valid FB object or page", arrobject);
                    ws ws2 = ws.this;
                    FacebookRequestError facebookRequestError = g2.a() != null ? g2.a() : e2.a();
                    ws2.a("get_verified_id", facebookRequestError);
                }
                if (m2 != null) {
                    m2.a();
                }
            }
        });
        un2.h();
    }

    /*
     * Enabled aggressive block sorting
     */
    private static void a(ws ws2, LikeView.ObjectType objectType, c c2) {
        FacebookException facebookException;
        LikeView.ObjectType objectType2 = wz.a(objectType, ws2.l);
        if (objectType2 == null) {
            Object[] arrobject = new Object[]{ws2.k, ws2.l.toString(), objectType.toString()};
            facebookException = new FacebookException("Object with id:\"%s\" is already marked as type:\"%s\". Cannot change the type to:\"%s\"", arrobject);
            ws2 = null;
        } else {
            ws2.l = objectType2;
            facebookException = null;
        }
        ws.a(c2, ws2, facebookException);
    }

    private void a(boolean bl2) {
        super.b(bl2);
        Bundle bundle = new Bundle();
        bundle.putString("com.facebook.platform.status.ERROR_DESCRIPTION", "Unable to publish the like/unlike action");
        ws.c((ws)this, "com.facebook.sdk.LikeActionController.DID_ERROR", bundle);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void a(boolean bl2, String string2, String string3, String string4, String string5, String string6) {
        String string7 = we.a(string2, null);
        String string8 = we.a(string3, null);
        String string9 = we.a(string4, null);
        String string10 = we.a(string5, null);
        String string11 = we.a(string6, null);
        if (bl2 == this.m && we.a(string7, this.n) && we.a(string8, this.o) && we.a(string9, this.p) && we.a(string10, this.q) && we.a(string11, this.r)) return;
        boolean bl3 = true;
        if (!bl3) {
            return;
        }
        this.m = bl2;
        this.n = string7;
        this.o = string8;
        this.p = string9;
        this.q = string10;
        this.r = string11;
        ws.l(this);
        ws.d(this, "com.facebook.sdk.LikeActionController.UPDATED");
    }

    public static boolean a(final int n2, final int n3, final Intent intent) {
        if (we.a(g)) {
            g = ul.f().getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).getString("PENDING_CONTROLLER_KEY", null);
        }
        if (we.a(g)) {
            return false;
        }
        ws.a(g, LikeView.ObjectType.a, new c(){

            @Override
            public void a(ws ws2, FacebookException facebookException) {
                if (facebookException == null) {
                    ws2.b(n2, n3, intent);
                    return;
                }
                we.a(a, (Exception)facebookException);
            }
        });
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    private boolean a(boolean bl2, Bundle bundle) {
        boolean bl3 = super.n();
        boolean bl4 = false;
        if (!bl3) return bl4;
        {
            if (bl2) {
                bl4 = true;
                super.c(bundle);
                return bl4;
            } else {
                boolean bl5 = we.a(this.r);
                bl4 = false;
                if (bl5) return bl4;
                {
                    super.d(bundle);
                    return true;
                }
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static ws b(String string2) {
        ws ws2;
        InputStream inputStream = null;
        try {
            String string3 = ws.d(string2);
            inputStream = b.a(string3);
            ws2 = null;
            if (inputStream != null) {
                String string4 = we.a(inputStream);
                boolean bl2 = we.a(string4);
                ws2 = null;
                if (!bl2) {
                    ws ws3;
                    ws2 = ws3 = ws.c(string4);
                }
            }
            if (inputStream == null) return ws2;
        }
        catch (IOException var3_7) {
            try {
                Log.e((String)a, (String)"Unable to deserialize controller from disk", (Throwable)var3_7);
                ws2 = null;
                if (inputStream == null) return ws2;
            }
            catch (Throwable var2_8) {
                if (inputStream == null) throw var2_8;
                we.a((Closeable)inputStream);
                throw var2_8;
            }
            we.a((Closeable)inputStream);
            return null;
        }
        we.a((Closeable)inputStream);
        return ws2;
    }

    private void b(int n2, int n3, Intent intent) {
        wz.a(n2, n3, intent, super.a(this.w));
        super.m();
    }

    /*
     * Enabled aggressive block sorting
     */
    private void b(Activity activity, vq vq2, Bundle bundle) {
        String string2;
        if (wt.e()) {
            string2 = "fb_like_control_did_present_dialog";
        } else {
            if (!wt.f()) {
                super.a("present_dialog", bundle);
                we.b(a, "Cannot show the Like Dialog on this device.");
                ws.d(null, "com.facebook.sdk.LikeActionController.UPDATED");
                return;
            }
            string2 = "fb_like_control_did_present_fallback_dialog";
        }
        if (string2 != null) {
            String string3 = this.l != null ? this.l.toString() : LikeView.ObjectType.a.toString();
            LikeContent likeContent = new LikeContent.a().a(this.k).b(string3).a();
            if (vq2 != null) {
                new wt(vq2).b(likeContent);
            } else {
                new wt(activity).b(likeContent);
            }
            super.b(bundle);
            super.l().a("fb_like_control_did_present_dialog", null, bundle);
        }
    }

    private void b(Bundle bundle) {
        ws.e(this.k);
        this.w = bundle;
        ws.l((ws)this);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static void b(String string2, String string3) {
        OutputStream outputStream = null;
        try {
            outputStream = b.b(string2);
            outputStream.write(string3.getBytes());
            return;
        }
        catch (IOException var4_3) {
            Log.e((String)a, (String)"Unable to serialize controller to disk", (Throwable)var4_3);
            return;
        }
        finally {
            if (outputStream == null) return;
            we.a((Closeable)outputStream);
        }
    }

    private void b(boolean bl2) {
        super.a(bl2, this.n, this.o, this.p, this.q, this.r);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static ws c(String string2) {
        try {
            JSONObject jSONObject = new JSONObject(string2);
            if (jSONObject.optInt("com.facebook.share.internal.LikeActionController.version", -1) != 3) {
                return null;
            }
            ws ws2 = new ws(jSONObject.getString("object_id"), LikeView.ObjectType.a(jSONObject.optInt("object_type", LikeView.ObjectType.a.a())));
            ws2.n = jSONObject.optString("like_count_string_with_like", null);
            ws2.o = jSONObject.optString("like_count_string_without_like", null);
            ws2.p = jSONObject.optString("social_sentence_with_like", null);
            ws2.q = jSONObject.optString("social_sentence_without_like", null);
            ws2.m = jSONObject.optBoolean("is_object_liked");
            ws2.r = jSONObject.optString("unlike_token", null);
            JSONObject jSONObject2 = jSONObject.optJSONObject("facebook_dialog_analytics_bundle");
            if (jSONObject2 == null) return ws2;
            ws2.w = vh.a(jSONObject2);
            return ws2;
        }
        catch (JSONException var2_4) {
            Log.e((String)a, (String)"Unable to deserialize controller from JSON", (Throwable)var2_4);
            return null;
        }
    }

    private void c(final Bundle bundle) {
        this.v = true;
        super.a(new m(){

            @Override
            public void a() {
                if (we.a(ws.this.s)) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("com.facebook.platform.status.ERROR_DESCRIPTION", "Invalid Object Id");
                    ws.c(ws.this, "com.facebook.sdk.LikeActionController.DID_ERROR", bundle2);
                    return;
                }
                un un2 = new un();
                final k k2 = new k(ws.this.s, ws.this.l);
                k2.a(un2);
                un2.a(new un.a(){

                    @Override
                    public void a(un un2) {
                        ws.this.v = false;
                        if (k2.a() != null) {
                            ws.this.a(false);
                            return;
                        }
                        ws.this.r = we.a(k2.e, null);
                        ws.this.u = true;
                        ws.this.l().a("fb_like_control_did_like", null, bundle);
                        ws.this.e(bundle);
                    }
                });
                un2.h();
            }

        });
    }

    private static void c(String string2, LikeView.ObjectType objectType, c c2) {
        ws ws2 = ws.a(string2);
        if (ws2 != null) {
            ws.a(ws2, objectType, c2);
            return;
        }
        ws ws3 = ws.b(string2);
        if (ws3 == null) {
            ws3 = new ws(string2, objectType);
            ws.l(ws3);
        }
        ws.a(string2, ws3);
        final ws ws4 = ws3;
        f.post(new Runnable(){

            public void run() {
                ws4.o();
            }
        });
        ws.a(c2, ws4, null);
    }

    private static void c(ws ws2, String string2, Bundle bundle) {
        Intent intent = new Intent(string2);
        if (ws2 != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString("com.facebook.sdk.LikeActionController.OBJECT_ID", ws2.a());
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        bn.a(ul.f()).a(intent);
    }

    private static String d(String string2) {
        AccessToken accessToken = AccessToken.a();
        String string3 = null;
        if (accessToken != null) {
            string3 = accessToken.b();
        }
        if (string3 != null) {
            string3 = we.b(string3);
        }
        Locale locale = Locale.ROOT;
        Object[] arrobject = new Object[]{string2, we.a(string3, ""), i};
        return String.format((Locale)locale, (String)"%s|%s|com.fb.sdk.like|%d", (Object[])arrobject);
    }

    private void d(final Bundle bundle) {
        this.v = true;
        un un2 = new un();
        final l l2 = (ws)this.new l(this.r);
        l2.a(un2);
        un2.a(new un.a(){

            @Override
            public void a(un un2) {
                ws.this.v = false;
                if (l2.a() != null) {
                    ws.this.a(true);
                    return;
                }
                ws.this.r = null;
                ws.this.u = false;
                ws.this.l().a("fb_like_control_did_unlike", null, bundle);
                ws.this.e(bundle);
            }
        });
        un2.h();
    }

    private static void d(ws ws2, String string2) {
        ws.c(ws2, string2, null);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void e(Bundle bundle) {
        if (this.m != this.u && !super.a(this.m, bundle)) {
            boolean bl2 = !this.m;
            super.a(bl2);
        }
    }

    private static void e(String string2) {
        g = string2;
        ul.f().getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).edit().putString("PENDING_CONTROLLER_KEY", g).apply();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void j() {
        reference var2 = ws.class;
        synchronized (ws.class) {
            boolean bl2 = h;
            if (!bl2) {
                f = new Handler(Looper.getMainLooper());
                i = ul.f().getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).getInt("OBJECT_SUFFIX", 1);
                b = new vp(a, new vp.d());
                ws.k();
                CallbackManagerImpl.a(CallbackManagerImpl.RequestCodeOffset.d.a(), new CallbackManagerImpl.a(){

                    @Override
                    public boolean a(int n2, Intent intent) {
                        return ws.a(CallbackManagerImpl.RequestCodeOffset.d.a(), n2, intent);
                    }
                });
                h = true;
            }
            // ** MonitorExit[var2] (shouldn't be in output)
            return;
        }
    }

    private static void k() {
        j = new ui(){

            @Override
            protected void a(AccessToken accessToken, AccessToken accessToken2) {
                Context context = ul.f();
                if (accessToken2 == null) {
                    i = (1 + i) % 1000;
                    context.getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).edit().putInt("OBJECT_SUFFIX", i).apply();
                    c.clear();
                    b.a();
                }
                ws.d(null, "com.facebook.sdk.LikeActionController.DID_RESET");
            }
        };
    }

    private AppEventsLogger l() {
        if (this.x == null) {
            this.x = AppEventsLogger.a(ul.f());
        }
        return this.x;
    }

    private static void l(ws ws2) {
        String string2 = ws.m(ws2);
        String string3 = ws.d(ws2.k);
        if (!we.a(string2) && !we.a(string3)) {
            e.a(new o(string3, string2));
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static String m(ws ws2) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("com.facebook.share.internal.LikeActionController.version", 3);
            jSONObject2.put("object_id", (Object)ws2.k);
            jSONObject2.put("object_type", ws2.l.a());
            jSONObject2.put("like_count_string_with_like", (Object)ws2.n);
            jSONObject2.put("like_count_string_without_like", (Object)ws2.o);
            jSONObject2.put("social_sentence_with_like", (Object)ws2.p);
            jSONObject2.put("social_sentence_without_like", (Object)ws2.q);
            jSONObject2.put("is_object_liked", ws2.m);
            jSONObject2.put("unlike_token", (Object)ws2.r);
            if (ws2.w == null || (jSONObject = vh.a(ws2.w)) == null) return jSONObject2.toString();
        }
        catch (JSONException var2_3) {
            Log.e((String)a, (String)"Unable to serialize controller to JSON", (Throwable)var2_3);
            return null;
        }
        jSONObject2.put("facebook_dialog_analytics_bundle", (Object)jSONObject);
        return jSONObject2.toString();
    }

    private void m() {
        this.w = null;
        ws.e(null);
    }

    private boolean n() {
        AccessToken accessToken = AccessToken.a();
        if (!this.t && this.s != null && accessToken != null && accessToken.d() != null && accessToken.d().contains((Object)"publish_actions")) {
            return true;
        }
        return false;
    }

    private void o() {
        if (AccessToken.a() == null) {
            this.p();
            return;
        }
        this.a(new m(){

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void a() {
                void var1_2;
                switch (ws.this.l) {
                    default: {
                        f f2 = new f(ws.this.s, ws.this.l);
                        break;
                    }
                    case c: {
                        h h2 = new h(ws.this.s);
                    }
                }
                d d2 = new d(ws.this.s, ws.this.l);
                un un2 = new un();
                var1_2.a(un2);
                d2.a(un2);
                un2.a(new un.a((i)var1_2, d2){
                    final /* synthetic */ i a;
                    final /* synthetic */ d b;

                    @Override
                    public void a(un un2) {
                        if (this.a.a() != null || this.b.a() != null) {
                            LoggingBehavior loggingBehavior = LoggingBehavior.a;
                            String string2 = a;
                            Object[] arrobject = new Object[]{ws.this.k};
                            vx.a(loggingBehavior, string2, "Unable to refresh like state for id: '%s'", arrobject);
                            return;
                        }
                        ws.this.a(this.a.b(), this.b.e, this.b.f, this.b.g, this.b.h, this.a.c());
                    }
                });
                un2.h();
            }

        });
    }

    private void p() {
        wu wu2 = new wu(ul.f(), ul.i(), this.k);
        if (!wu2.a()) {
            return;
        }
        wu2.a(new wa.a(){

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void a(Bundle bundle) {
                if (bundle == null || !bundle.containsKey("com.facebook.platform.extra.OBJECT_IS_LIKED")) {
                    return;
                }
                boolean bl2 = bundle.getBoolean("com.facebook.platform.extra.OBJECT_IS_LIKED");
                String string2 = bundle.containsKey("com.facebook.platform.extra.LIKE_COUNT_STRING_WITH_LIKE") ? bundle.getString("com.facebook.platform.extra.LIKE_COUNT_STRING_WITH_LIKE") : ws.this.n;
                String string3 = bundle.containsKey("com.facebook.platform.extra.LIKE_COUNT_STRING_WITHOUT_LIKE") ? bundle.getString("com.facebook.platform.extra.LIKE_COUNT_STRING_WITHOUT_LIKE") : ws.this.o;
                String string4 = bundle.containsKey("com.facebook.platform.extra.SOCIAL_SENTENCE_WITH_LIKE") ? bundle.getString("com.facebook.platform.extra.SOCIAL_SENTENCE_WITH_LIKE") : ws.this.p;
                String string5 = bundle.containsKey("com.facebook.platform.extra.SOCIAL_SENTENCE_WITHOUT_LIKE") ? bundle.getString("com.facebook.platform.extra.SOCIAL_SENTENCE_WITHOUT_LIKE") : ws.this.q;
                String string6 = bundle.containsKey("com.facebook.platform.extra.UNLIKE_TOKEN") ? bundle.getString("com.facebook.platform.extra.UNLIKE_TOKEN") : ws.this.r;
                ws.this.a(bl2, string2, string3, string4, string5, string6);
            }
        });
    }

    public String a() {
        return this.k;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(Activity activity, vq vq2, Bundle bundle) {
        boolean bl2 = true;
        boolean bl3 = !this.m ? bl2 : false;
        if (!super.n()) {
            super.b(activity, vq2, bundle);
            return;
        }
        super.b(bl3);
        if (this.v) {
            super.l().a("fb_like_control_did_undo_quickly", null, bundle);
            return;
        } else {
            if (super.a(bl3, bundle)) return;
            {
                if (bl3) {
                    bl2 = false;
                }
                super.b(bl2);
                super.b(activity, vq2, bundle);
                return;
            }
        }
    }

    public String b() {
        if (this.m) {
            return this.n;
        }
        return this.o;
    }

    public String c() {
        if (this.m) {
            return this.p;
        }
        return this.q;
    }

    public boolean d() {
        return this.m;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean e() {
        if (wt.e()) return true;
        if (wt.f()) {
            return true;
        }
        if (this.t) return false;
        if (this.l == LikeView.ObjectType.c) {
            return false;
        }
        AccessToken accessToken = AccessToken.a();
        if (accessToken == null) return false;
        if (accessToken.d() == null) return false;
        if (accessToken.d().contains((Object)"publish_actions")) return true;
        return false;
    }

    abstract class a
    implements n {
        protected String a;
        protected LikeView.ObjectType b;
        protected FacebookRequestError c;
        private GraphRequest e;

        protected a(String string2, LikeView.ObjectType objectType) {
            this.a = string2;
            this.b = objectType;
        }

        @Override
        public FacebookRequestError a() {
            return this.c;
        }

        protected void a(FacebookRequestError facebookRequestError) {
            LoggingBehavior loggingBehavior = LoggingBehavior.a;
            String string2 = a;
            Object[] arrobject = new Object[]{this.a, this.b, facebookRequestError};
            vx.a(loggingBehavior, string2, "Error running request for object '%s' with type '%s' : %s", arrobject);
        }

        protected void a(GraphRequest graphRequest) {
            this.e = graphRequest;
            graphRequest.a("v2.6");
            graphRequest.a(new GraphRequest.b(){

                @Override
                public void onCompleted(uo uo2) {
                    a.this.c = uo2.a();
                    if (a.this.c != null) {
                        a.this.a(a.this.c);
                        return;
                    }
                    a.this.a(uo2);
                }
            });
        }

        @Override
        public void a(un un2) {
            un2.a(this.e);
        }

        protected abstract void a(uo var1);

    }

    static class b
    implements Runnable {
        private String a;
        private LikeView.ObjectType b;
        private c c;

        b(String string2, LikeView.ObjectType objectType, c c2) {
            this.a = string2;
            this.b = objectType;
            this.c = c2;
        }

        public void run() {
            ws.c(this.a, this.b, this.c);
        }
    }

    public static interface c {
        public void a(ws var1, FacebookException var2);
    }

    class d
    extends a {
        String e;
        String f;
        String g;
        String h;

        d(String string2, LikeView.ObjectType objectType) {
            super(string2, objectType);
            this.e = ws.this.n;
            this.f = ws.this.o;
            this.g = ws.this.p;
            this.h = ws.this.q;
            Bundle bundle = new Bundle();
            bundle.putString("fields", "engagement.fields(count_string_with_like,count_string_without_like,social_sentence_with_like,social_sentence_without_like)");
            bundle.putString("locale", Locale.getDefault().toString());
            this.a(new GraphRequest(AccessToken.a(), string2, bundle, HttpMethod.a));
        }

        @Override
        protected void a(FacebookRequestError facebookRequestError) {
            LoggingBehavior loggingBehavior = LoggingBehavior.a;
            String string2 = a;
            Object[] arrobject = new Object[]{this.a, this.b, facebookRequestError};
            vx.a(loggingBehavior, string2, "Error fetching engagement for object '%s' with type '%s' : %s", arrobject);
            ws.this.a("get_engagement", facebookRequestError);
        }

        @Override
        protected void a(uo uo2) {
            JSONObject jSONObject = we.b(uo2.b(), "engagement");
            if (jSONObject != null) {
                this.e = jSONObject.optString("count_string_with_like", this.e);
                this.f = jSONObject.optString("count_string_without_like", this.f);
                this.g = jSONObject.optString("social_sentence_with_like", this.g);
                this.h = jSONObject.optString("social_sentence_without_like", this.h);
            }
        }
    }

    class e
    extends a {
        String e;

        e(String string2, LikeView.ObjectType objectType) {
            super(string2, objectType);
            Bundle bundle = new Bundle();
            bundle.putString("fields", "og_object.fields(id)");
            bundle.putString("ids", string2);
            this.a(new GraphRequest(AccessToken.a(), "", bundle, HttpMethod.a));
        }

        @Override
        protected void a(FacebookRequestError facebookRequestError) {
            if (facebookRequestError.e().contains((CharSequence)"og_object")) {
                this.c = null;
                return;
            }
            LoggingBehavior loggingBehavior = LoggingBehavior.a;
            String string2 = a;
            Object[] arrobject = new Object[]{this.a, this.b, facebookRequestError};
            vx.a(loggingBehavior, string2, "Error getting the FB id for object '%s' with type '%s' : %s", arrobject);
        }

        @Override
        protected void a(uo uo2) {
            JSONObject jSONObject;
            JSONObject jSONObject2 = we.b(uo2.b(), this.a);
            if (jSONObject2 != null && (jSONObject = jSONObject2.optJSONObject("og_object")) != null) {
                this.e = jSONObject.optString("id");
            }
        }
    }

    class f
    extends a
    implements i {
        private boolean f;
        private String g;
        private final String h;
        private final LikeView.ObjectType i;

        f(String string2, LikeView.ObjectType objectType) {
            super(string2, objectType);
            this.f = ws.this.m;
            this.h = string2;
            this.i = objectType;
            Bundle bundle = new Bundle();
            bundle.putString("fields", "id,application");
            bundle.putString("object", this.h);
            this.a(new GraphRequest(AccessToken.a(), "me/og.likes", bundle, HttpMethod.a));
        }

        @Override
        protected void a(FacebookRequestError facebookRequestError) {
            LoggingBehavior loggingBehavior = LoggingBehavior.a;
            String string2 = a;
            Object[] arrobject = new Object[]{this.h, this.i, facebookRequestError};
            vx.a(loggingBehavior, string2, "Error fetching like status for object '%s' with type '%s' : %s", arrobject);
            ws.this.a("get_og_object_like", facebookRequestError);
        }

        @Override
        protected void a(uo uo2) {
            JSONArray jSONArray = we.c(uo2.b(), "data");
            if (jSONArray != null) {
                for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
                    JSONObject jSONObject = jSONArray.optJSONObject(i2);
                    if (jSONObject == null) continue;
                    this.f = true;
                    JSONObject jSONObject2 = jSONObject.optJSONObject("application");
                    AccessToken accessToken = AccessToken.a();
                    if (jSONObject2 == null || accessToken == null || !we.a(accessToken.h(), jSONObject2.optString("id"))) continue;
                    this.g = jSONObject.optString("id");
                }
            }
        }

        @Override
        public boolean b() {
            return this.f;
        }

        @Override
        public String c() {
            return this.g;
        }
    }

    class g
    extends a {
        String e;
        boolean f;

        g(String string2, LikeView.ObjectType objectType) {
            super(string2, objectType);
            Bundle bundle = new Bundle();
            bundle.putString("fields", "id");
            bundle.putString("ids", string2);
            this.a(new GraphRequest(AccessToken.a(), "", bundle, HttpMethod.a));
        }

        @Override
        protected void a(FacebookRequestError facebookRequestError) {
            LoggingBehavior loggingBehavior = LoggingBehavior.a;
            String string2 = a;
            Object[] arrobject = new Object[]{this.a, this.b, facebookRequestError};
            vx.a(loggingBehavior, string2, "Error getting the FB id for object '%s' with type '%s' : %s", arrobject);
        }

        /*
         * Enabled aggressive block sorting
         */
        @Override
        protected void a(uo uo2) {
            JSONObject jSONObject = we.b(uo2.b(), this.a);
            if (jSONObject != null) {
                this.e = jSONObject.optString("id");
                boolean bl2 = !we.a(this.e);
                this.f = bl2;
            }
        }
    }

    class h
    extends a
    implements i {
        private boolean f;
        private String g;

        h(String string2) {
            super(string2, LikeView.ObjectType.c);
            this.f = ws.this.m;
            this.g = string2;
            Bundle bundle = new Bundle();
            bundle.putString("fields", "id");
            this.a(new GraphRequest(AccessToken.a(), "me/likes/" + string2, bundle, HttpMethod.a));
        }

        @Override
        protected void a(FacebookRequestError facebookRequestError) {
            LoggingBehavior loggingBehavior = LoggingBehavior.a;
            String string2 = a;
            Object[] arrobject = new Object[]{this.g, facebookRequestError};
            vx.a(loggingBehavior, string2, "Error fetching like status for page id '%s': %s", arrobject);
            ws.this.a("get_page_like", facebookRequestError);
        }

        @Override
        protected void a(uo uo2) {
            JSONArray jSONArray = we.c(uo2.b(), "data");
            if (jSONArray != null && jSONArray.length() > 0) {
                this.f = true;
            }
        }

        @Override
        public boolean b() {
            return this.f;
        }

        @Override
        public String c() {
            return null;
        }
    }

    static interface i
    extends n {
        public boolean b();

        public String c();
    }

    static class j
    implements Runnable {
        private static ArrayList<String> a = new ArrayList();
        private String b;
        private boolean c;

        j(String string2, boolean bl2) {
            this.b = string2;
            this.c = bl2;
        }

        public void run() {
            if (this.b != null) {
                a.remove((Object)this.b);
                a.add(0, (Object)this.b);
            }
            if (this.c && a.size() >= 128) {
                while (64 < a.size()) {
                    String string2 = (String)a.remove(-1 + a.size());
                    c.remove((Object)string2);
                }
            }
        }
    }

    class k
    extends a {
        String e;

        k(String string2, LikeView.ObjectType objectType) {
            super(string2, objectType);
            Bundle bundle = new Bundle();
            bundle.putString("object", string2);
            this.a(new GraphRequest(AccessToken.a(), "me/og.likes", bundle, HttpMethod.b));
        }

        @Override
        protected void a(FacebookRequestError facebookRequestError) {
            if (facebookRequestError.b() == 3501) {
                this.c = null;
                return;
            }
            LoggingBehavior loggingBehavior = LoggingBehavior.a;
            String string2 = a;
            Object[] arrobject = new Object[]{this.a, this.b, facebookRequestError};
            vx.a(loggingBehavior, string2, "Error liking object '%s' with type '%s' : %s", arrobject);
            ws.this.a("publish_like", facebookRequestError);
        }

        @Override
        protected void a(uo uo2) {
            this.e = we.a(uo2.b(), "id");
        }
    }

    class l
    extends a {
        private String f;

        l(String string2) {
            super(null, null);
            this.f = string2;
            this.a(new GraphRequest(AccessToken.a(), string2, null, HttpMethod.c));
        }

        @Override
        protected void a(FacebookRequestError facebookRequestError) {
            LoggingBehavior loggingBehavior = LoggingBehavior.a;
            String string2 = a;
            Object[] arrobject = new Object[]{this.f, facebookRequestError};
            vx.a(loggingBehavior, string2, "Error unliking object with unlike token '%s' : %s", arrobject);
            ws.this.a("publish_unlike", facebookRequestError);
        }

        @Override
        protected void a(uo uo2) {
        }
    }

    static interface m {
        public void a();
    }

    static interface n {
        public FacebookRequestError a();

        public void a(un var1);
    }

    static class o
    implements Runnable {
        private String a;
        private String b;

        o(String string2, String string3) {
            this.a = string2;
            this.b = string3;
        }

        public void run() {
            ws.b(this.a, this.b);
        }
    }

}

