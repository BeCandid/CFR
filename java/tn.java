/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  io.fabric.sdk.android.services.common.CommonUtils
 *  java.io.Closeable
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.InputStream
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.nio.charset.Charset
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.Map
 *  org.json.JSONException
 *  org.json.JSONObject
 */
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class tn {
    private static final Charset a = Charset.forName((String)"UTF-8");
    private final File b;

    public tn(File file) {
        this.b = file;
    }

    private static String a(JSONObject jSONObject, String string2) {
        boolean bl2 = jSONObject.isNull(string2);
        String string3 = null;
        if (!bl2) {
            string3 = jSONObject.optString(string2, null);
        }
        return string3;
    }

    private File c(String string2) {
        return new File(this.b, string2 + "user" + ".meta");
    }

    private File d(String string2) {
        return new File(this.b, string2 + "keys" + ".meta");
    }

    private static tw e(String string2) throws JSONException {
        JSONObject jSONObject = new JSONObject(string2);
        return new tw(tn.a(jSONObject, "userId"), tn.a(jSONObject, "userName"), tn.a(jSONObject, "userEmail"));
    }

    private static Map<String, String> f(String string2) throws JSONException {
        JSONObject jSONObject = new JSONObject(string2);
        HashMap hashMap = new HashMap();
        Iterator iterator = jSONObject.keys();
        while (iterator.hasNext()) {
            String string3 = (String)iterator.next();
            hashMap.put((Object)string3, (Object)tn.a(jSONObject, string3));
        }
        return hashMap;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public tw a(String var1) {
        var2_2 = super.c(var1);
        if (!var2_2.exists()) {
            return tw.a;
        }
        var3_3 = null;
        var4_4 = new FileInputStream(var2_2);
        try {
            var7_5 = tn.e(CommonUtils.a((InputStream)var4_4));
        }
        catch (Throwable var6_11) {
            var3_3 = var4_4;
            ** GOTO lbl-1000
        }
        catch (Exception var5_8) {
            var3_3 = var4_4;
        }
        CommonUtils.a((Closeable)var4_4, (String)"Failed to close user metadata file.");
        return var7_5;
        catch (Exception var5_6) {}
        {
            try {
                akx.h().e("CrashlyticsCore", "Error deserializing user metadata.", (Throwable)var5_7);
            }
            catch (Throwable var6_9) lbl-1000: // 2 sources:
            {
                CommonUtils.a((Closeable)var3_3, (String)"Failed to close user metadata file.");
                throw var6_10;
            }
            CommonUtils.a((Closeable)var3_3, (String)"Failed to close user metadata file.");
            return tw.a;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public Map<String, String> b(String var1) {
        var2_2 = super.d(var1);
        if (!var2_2.exists()) {
            return Collections.emptyMap();
        }
        var3_3 = null;
        var4_4 = new FileInputStream(var2_2);
        try {
            var7_5 = tn.f(CommonUtils.a((InputStream)var4_4));
        }
        catch (Throwable var6_11) {
            var3_3 = var4_4;
            ** GOTO lbl-1000
        }
        catch (Exception var5_8) {
            var3_3 = var4_4;
        }
        CommonUtils.a((Closeable)var4_4, (String)"Failed to close user metadata file.");
        return var7_5;
        catch (Exception var5_6) {}
        {
            try {
                akx.h().e("CrashlyticsCore", "Error deserializing user metadata.", (Throwable)var5_7);
            }
            catch (Throwable var6_9) lbl-1000: // 2 sources:
            {
                CommonUtils.a((Closeable)var3_3, (String)"Failed to close user metadata file.");
                throw var6_10;
            }
            CommonUtils.a((Closeable)var3_3, (String)"Failed to close user metadata file.");
            return Collections.emptyMap();
        }
    }
}

