/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.database.Cursor
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.os.Bundle
 *  android.os.Environment
 *  android.os.Parcel
 *  android.os.StatFs
 *  android.telephony.TelephonyManager
 *  android.text.TextUtils
 *  android.util.Log
 *  android.webkit.CookieManager
 *  android.webkit.CookieSyncManager
 *  java.io.BufferedInputStream
 *  java.io.Closeable
 *  java.io.File
 *  java.io.FilenameFilter
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.io.UnsupportedEncodingException
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.Exception
 *  java.lang.IllegalAccessException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.NoSuchMethodException
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 *  java.math.BigInteger
 *  java.net.HttpURLConnection
 *  java.net.URLConnection
 *  java.net.URLDecoder
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Date
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Random
 *  java.util.Set
 *  java.util.TimeZone
 *  java.util.concurrent.ConcurrentHashMap
 *  java.util.concurrent.atomic.AtomicBoolean
 *  java.util.regex.Pattern
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 *  org.json.JSONTokener
 */
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class we {
    private static final String[] a = new String[]{"supports_implicit_sdk_logging", "gdpv4_nux_content", "gdpv4_nux_enabled", "gdpv4_chrome_custom_tabs_enabled", "android_dialog_configs", "android_sdk_error_categories", "app_events_session_timeout"};
    private static Map<String, b> b = new ConcurrentHashMap();
    private static AtomicBoolean c = new AtomicBoolean(false);
    private static int d = 0;
    private static long e = -1;
    private static long f = -1;
    private static long g = -1;
    private static String h = "";
    private static String i = "";
    private static String j = "NoCarrier";

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public static int a(InputStream var0_1, OutputStream var1) throws IOException {
        var2_2 = null;
        var3_3 = 0;
        var4_4 = new BufferedInputStream(var0_1);
        try {
            var6_5 = new byte[8192];
            while ((var7_6 = var4_4.read(var6_5)) != -1) {
                var1.write(var6_5, 0, var7_6);
            }
        }
        catch (Throwable var5_9) {
            var2_2 = var4_4;
            ** continue;
        }
        {
            var3_3 += var7_6;
            continue;
        }
        if (var4_4 != null) {
            var4_4.close();
        }
        if (var0_1 != null) {
            var0_1.close();
        }
        return var3_3;
        catch (Throwable var5_7) lbl-1000: // 2 sources:
        {
            do {
                if (var2_2 != null) {
                    var2_2.close();
                }
                if (var0_1 != null) {
                    var0_1.close();
                }
                throw var5_8;
                break;
            } while (true);
        }
    }

    private static long a(double d2) {
        return Math.round((double)(d2 / 1.073741824E9));
    }

    public static Uri a(String string2, String string3, Bundle bundle) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https");
        builder.authority(string2);
        builder.path(string3);
        if (bundle != null) {
            for (String string4 : bundle.keySet()) {
                Object object = bundle.get(string4);
                if (!(object instanceof String)) continue;
                builder.appendQueryParameter(string4, (String)object);
            }
        }
        return builder.build();
    }

    public static /* varargs */ Object a(Object object, Method method, Object ... arrobject) {
        try {
            Object object2 = method.invoke(object, arrobject);
            return object2;
        }
        catch (IllegalAccessException var4_4) {
            return null;
        }
        catch (InvocationTargetException var3_5) {
            return null;
        }
    }

    public static Object a(JSONObject jSONObject, String string2, String string3) throws JSONException {
        Object object = jSONObject.opt(string2);
        if (object != null && object instanceof String) {
            object = new JSONTokener((String)object).nextValue();
        }
        if (object != null && !(object instanceof JSONObject) && !(object instanceof JSONArray)) {
            if (string3 != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt(string3, object);
                return jSONObject2;
            }
            throw new FacebookException("Got an unexpected non-JSON object.");
        }
        return object;
    }

    public static String a(int n2) {
        Random random = new Random();
        return new BigInteger(n2 * 5, random).toString(32);
    }

    public static String a(Context context) {
        wf.a((Object)context, "context");
        ul.a(context);
        return ul.i();
    }

    public static String a(Uri uri) {
        if (uri == null) {
            return null;
        }
        return uri.toString();
    }

    /*
     * Exception decompiling
     */
    public static String a(InputStream var0) throws IOException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.util.ConcurrentModificationException
        // java.util.LinkedList$ReverseLinkIterator.next(LinkedList.java:217)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.extractLabelledBlocks(Block.java:212)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:485)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredCatch.transformStructuredChildren(StructuredCatch.java:72)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredTry.transformStructuredChildren(StructuredTry.java:81)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.transformStructuredChildren(Block.java:378)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.insertLabelledBlocks(Op04StructuredStatement.java:649)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:816)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:128)
        // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    public static String a(String string2, String string3) {
        if (we.a(string2)) {
            return string3;
        }
        return string2;
    }

    private static String a(String string2, byte[] arrby) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance((String)string2);
        }
        catch (NoSuchAlgorithmException var2_3) {
            return null;
        }
        return we.a(messageDigest, arrby);
    }

    private static String a(MessageDigest messageDigest, byte[] arrby) {
        messageDigest.update(arrby);
        byte[] arrby2 = messageDigest.digest();
        StringBuilder stringBuilder = new StringBuilder();
        for (byte by2 : arrby2) {
            stringBuilder.append(Integer.toHexString((int)(15 & by2 >> 4)));
            stringBuilder.append(Integer.toHexString((int)(15 & by2 >> 0)));
        }
        return stringBuilder.toString();
    }

    public static String a(JSONObject jSONObject, String string2) {
        if (jSONObject != null) {
            return jSONObject.optString(string2, "");
        }
        return "";
    }

    public static String a(byte[] arrby) {
        return we.a("SHA-1", arrby);
    }

    public static /* varargs */ Method a(Class<?> class_, String string2, Class<?> ... arrclass) {
        try {
            Method method = class_.getMethod(string2, arrclass);
            return method;
        }
        catch (NoSuchMethodException var3_4) {
            return null;
        }
    }

    public static /* varargs */ Method a(String string2, String string3, Class<?> ... arrclass) {
        try {
            Method method = we.a(Class.forName((String)string2), string3, arrclass);
            return method;
        }
        catch (ClassNotFoundException var3_4) {
            return null;
        }
    }

    public static /* varargs */ <T> Collection<T> a(T ... arrT) {
        return Collections.unmodifiableCollection((Collection)Arrays.asList((Object[])arrT));
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Date a(Bundle bundle, String string2, Date date) {
        long l2;
        if (bundle == null) {
            return null;
        }
        Object object = bundle.get(string2);
        if (object instanceof Long) {
            l2 = (Long)object;
        } else {
            long l3;
            if (!(object instanceof String)) return null;
            l2 = l3 = Long.parseLong((String)((String)object));
        }
        if (l2 != 0) return new Date(date.getTime() + 1000 * l2);
        return new Date(Long.MAX_VALUE);
        catch (NumberFormatException numberFormatException) {
            return null;
        }
    }

    public static <T, K> List<K> a(List<T> list, d<T, K> d2) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            K k2 = d2.a(iterator.next());
            if (k2 == null) continue;
            arrayList.add(k2);
        }
        if (arrayList.size() == 0) {
            arrayList = null;
        }
        return arrayList;
    }

    public static List<String> a(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
            arrayList.add((Object)jSONArray.getString(i2));
        }
        return arrayList;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Map<String, String> a(Parcel parcel) {
        int n2 = parcel.readInt();
        if (n2 < 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        int n3 = 0;
        while (n3 < n2) {
            hashMap.put((Object)parcel.readString(), (Object)parcel.readString());
            ++n3;
        }
        return hashMap;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static a a(String string2, String string3, String string4) {
        b b2;
        Map map;
        if (we.a(string3) || we.a(string4) || (b2 = (b)b.get((Object)string2)) == null || (map = (Map)b2.e().get((Object)string3)) == null) {
            return null;
        }
        return (a)map.get((Object)string4);
    }

    public static b a(String string2, boolean bl2) {
        if (!bl2 && b.containsKey((Object)string2)) {
            return (b)b.get((Object)string2);
        }
        JSONObject jSONObject = we.g(string2);
        if (jSONObject == null) {
            return null;
        }
        return we.b(string2, jSONObject);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static e a(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = jSONObject.getJSONObject("permissions").getJSONArray("data");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        ArrayList arrayList2 = new ArrayList(jSONArray.length());
        int n2 = 0;
        while (n2 < jSONArray.length()) {
            String string2;
            JSONObject jSONObject2 = jSONArray.optJSONObject(n2);
            String string3 = jSONObject2.optString("permission");
            if (string3 != null && !string3.equals((Object)"installed") && (string2 = jSONObject2.optString("status")) != null) {
                if (string2.equals((Object)"granted")) {
                    arrayList.add((Object)string3);
                } else if (string2.equals((Object)"declined")) {
                    arrayList2.add((Object)string3);
                }
            }
            ++n2;
        }
        return new e((List<String>)arrayList, (List<String>)arrayList2);
    }

    public static void a(final Context context, final String string2) {
        boolean bl2 = c.compareAndSet(false, true);
        if (we.a(string2) || b.containsKey((Object)string2) || !bl2) {
            return;
        }
        final String string3 = String.format((String)"com.facebook.internal.APP_SETTINGS.%s", (Object[])new Object[]{string2});
        ul.d().execute(new Runnable(){

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public void run() {
                JSONObject jSONObject;
                SharedPreferences sharedPreferences = context.getSharedPreferences("com.facebook.internal.preferences.APP_SETTINGS", 0);
                String string22 = sharedPreferences.getString(string3, null);
                if (!we.a(string22)) {
                    JSONObject jSONObject2;
                    try {
                        JSONObject jSONObject3;
                        jSONObject2 = jSONObject3 = new JSONObject(string22);
                    }
                    catch (JSONException var8_6) {
                        we.a("FacebookSDK", (Exception)var8_6);
                        jSONObject2 = null;
                    }
                    if (jSONObject2 != null) {
                        we.b(string2, jSONObject2);
                    }
                }
                if ((jSONObject = we.g(string2)) != null) {
                    we.b(string2, jSONObject);
                    sharedPreferences.edit().putString(string3, jSONObject.toString()).apply();
                }
                c.set(false);
            }
        });
    }

    public static void a(Bundle bundle, String string2, Uri uri) {
        if (uri != null) {
            we.a(bundle, string2, uri.toString());
        }
    }

    public static void a(Bundle bundle, String string2, String string3) {
        if (!we.a(string3)) {
            bundle.putString(string2, string3);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void a(Parcel parcel, Map<String, String> map) {
        if (map == null) {
            parcel.writeInt(-1);
            return;
        } else {
            parcel.writeInt(map.size());
            for (Map.Entry entry : map.entrySet()) {
                parcel.writeString((String)entry.getKey());
                parcel.writeString((String)entry.getValue());
            }
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void a(Closeable closeable) {
        if (closeable == null) return;
        try {
            closeable.close();
            return;
        }
        catch (IOException var1_1) {
            return;
        }
    }

    public static void a(File file) {
        File[] arrfile;
        if (!file.exists()) {
            return;
        }
        if (file.isDirectory() && (arrfile = file.listFiles()) != null) {
            int n2 = arrfile.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                we.a(arrfile[i2]);
            }
        }
        file.delete();
    }

    public static void a(String string2, Exception exception) {
        if (ul.b() && string2 != null && exception != null) {
            Log.d((String)string2, (String)(exception.getClass().getSimpleName() + ": " + exception.getMessage()));
        }
    }

    public static void a(String string2, String string3, Throwable throwable) {
        if (ul.b() && !we.a(string2)) {
            Log.d((String)string2, (String)string3, (Throwable)throwable);
        }
    }

    public static void a(final String string2, final c c2) {
        JSONObject jSONObject = wb.a(string2);
        if (jSONObject != null) {
            c2.a(jSONObject);
            return;
        }
        GraphRequest.b b2 = new GraphRequest.b(){

            @Override
            public void onCompleted(uo uo2) {
                if (uo2.a() != null) {
                    c2.a(uo2.a().g());
                    return;
                }
                wb.a(string2, uo2.b());
                c2.a(uo2.b());
            }
        };
        GraphRequest graphRequest = we.h(string2);
        graphRequest.a(b2);
        graphRequest.j();
    }

    public static void a(URLConnection uRLConnection) {
        if (uRLConnection != null && uRLConnection instanceof HttpURLConnection) {
            ((HttpURLConnection)uRLConnection).disconnect();
        }
    }

    /*
     * Exception decompiling
     */
    public static void a(JSONObject var0_1, Context var1) throws JSONException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[TRYBLOCK]], but top level block is 6[SIMPLE_IF_TAKEN]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2859)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:805)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:128)
        // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void a(JSONObject jSONObject, vg vg2, String string2, boolean bl2) throws JSONException {
        boolean bl3 = true;
        if (vg2 != null && vg2.a() != null) {
            jSONObject.put("attribution", (Object)vg2.a());
        }
        if (vg2 != null && vg2.b() != null) {
            jSONObject.put("advertiser_id", (Object)vg2.b());
            boolean bl4 = !vg2.d() ? bl3 : false;
            jSONObject.put("advertiser_tracking_enabled", bl4);
        }
        if (vg2 != null && vg2.c() != null) {
            jSONObject.put("installer_package", (Object)vg2.c());
        }
        jSONObject.put("anon_id", (Object)string2);
        if (bl2) {
            bl3 = false;
        }
        jSONObject.put("application_tracking_enabled", bl3);
    }

    public static boolean a(AccessToken accessToken) {
        if (accessToken != null) {
            return accessToken.equals(AccessToken.a());
        }
        return false;
    }

    public static <T> boolean a(T t2, T t3) {
        if (t2 == null) {
            if (t3 == null) {
                return true;
            }
            return false;
        }
        return t2.equals(t3);
    }

    public static boolean a(String string2) {
        if (string2 == null || string2.length() == 0) {
            return true;
        }
        return false;
    }

    public static <T> boolean a(Collection<T> collection) {
        if (collection == null || collection.size() == 0) {
            return true;
        }
        return false;
    }

    /*
     * Exception decompiling
     */
    private static int b() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.util.ConcurrentModificationException
        // java.util.LinkedList$ReverseLinkIterator.next(LinkedList.java:217)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.extractLabelledBlocks(Block.java:212)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:485)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.insertLabelledBlocks(Op04StructuredStatement.java:649)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:816)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:128)
        // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    public static String b(String string2) {
        return we.c("MD5", string2);
    }

    public static /* varargs */ <T> List<T> b(T ... arrT) {
        ArrayList arrayList = new ArrayList();
        for (T t2 : arrT) {
            if (t2 == null) continue;
            arrayList.add(t2);
        }
        return arrayList;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static Map<String, Map<String, a>> b(JSONObject jSONObject) {
        JSONArray jSONArray;
        HashMap hashMap = new HashMap();
        if (jSONObject == null || (jSONArray = jSONObject.optJSONArray("data")) == null) {
            return hashMap;
        }
        int n2 = 0;
        while (n2 < jSONArray.length()) {
            a a2 = a.b(jSONArray.optJSONObject(n2));
            if (a2 != null) {
                String string2 = a2.a();
                Map map = (Map)hashMap.get((Object)string2);
                if (map == null) {
                    map = new HashMap();
                    hashMap.put((Object)string2, (Object)map);
                }
                map.put((Object)a2.b(), (Object)a2);
            }
            ++n2;
        }
        return hashMap;
    }

    public static Set<String> b(JSONArray jSONArray) throws JSONException {
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
            hashSet.add((Object)jSONArray.getString(i2));
        }
        return hashSet;
    }

    public static JSONObject b(JSONObject jSONObject, String string2) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(string2);
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static b b(String string2, JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.optJSONArray("android_sdk_error_categories");
        vn vn2 = jSONArray == null ? vn.a() : vn.a(jSONArray);
        b b2 = new b(jSONObject.optBoolean("supports_implicit_sdk_logging", false), jSONObject.optString("gdpv4_nux_content", ""), jSONObject.optBoolean("gdpv4_nux_enabled", false), jSONObject.optBoolean("gdpv4_chrome_custom_tabs_enabled", false), jSONObject.optInt("app_events_session_timeout", vd.a()), we.b(jSONObject.optJSONObject("android_dialog_configs")), vn2, null);
        b.put((Object)string2, (Object)b2);
        return b2;
    }

    public static void b(Context context) {
        we.b(context, "facebook.com");
        we.b(context, ".facebook.com");
        we.b(context, "https://facebook.com");
        we.b(context, "https://.facebook.com");
    }

    private static void b(Context context, String string2) {
        CookieSyncManager.createInstance((Context)context).sync();
        CookieManager cookieManager = CookieManager.getInstance();
        String string3 = cookieManager.getCookie(string2);
        if (string3 == null) {
            return;
        }
        String[] arrstring = string3.split(";");
        int n2 = arrstring.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            String[] arrstring2 = arrstring[i2].split("=");
            if (arrstring2.length <= 0) continue;
            cookieManager.setCookie(string2, arrstring2[0].trim() + "=;expires=Sat, 1 Jan 2000 00:00:01 UTC;");
        }
        cookieManager.removeExpiredCookie();
    }

    public static void b(String string2, String string3) {
        if (ul.b() && string2 != null && string3 != null) {
            Log.d((String)string2, (String)string3);
        }
    }

    public static boolean b(Uri uri) {
        if (uri != null && ("http".equalsIgnoreCase(uri.getScheme()) || "https".equalsIgnoreCase(uri.getScheme()))) {
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Bundle c(String string2) {
        Bundle bundle = new Bundle();
        if (!we.a(string2)) {
            String[] arrstring = string2.split("&");
            int n2 = arrstring.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                String[] arrstring2 = arrstring[i2].split("=");
                try {
                    if (arrstring2.length == 2) {
                        bundle.putString(URLDecoder.decode((String)arrstring2[0], (String)"UTF-8"), URLDecoder.decode((String)arrstring2[1], (String)"UTF-8"));
                        continue;
                    }
                    if (arrstring2.length != 1) continue;
                    bundle.putString(URLDecoder.decode((String)arrstring2[0], (String)"UTF-8"), "");
                    continue;
                }
                catch (UnsupportedEncodingException var6_6) {
                    we.a("FacebookSDK", (Exception)var6_6);
                }
            }
        }
        return bundle;
    }

    public static String c(Context context) {
        if (context == null) {
            return "null";
        }
        if (context == context.getApplicationContext()) {
            return "unknown";
        }
        return context.getClass().getSimpleName();
    }

    private static String c(String string2, String string3) {
        return we.a(string2, string3.getBytes());
    }

    public static JSONArray c(JSONObject jSONObject, String string2) {
        if (jSONObject != null) {
            return jSONObject.optJSONArray(string2);
        }
        return null;
    }

    private static void c() {
        try {
            TimeZone timeZone = TimeZone.getDefault();
            h = timeZone.getDisplayName(timeZone.inDaylightTime(new Date()), 0);
            i = timeZone.getID();
            return;
        }
        catch (Exception var0_1) {
            return;
        }
    }

    public static boolean c(Uri uri) {
        if (uri != null && "content".equalsIgnoreCase(uri.getScheme())) {
            return true;
        }
        return false;
    }

    public static b d(String string2) {
        if (string2 != null) {
            return (b)b.get((Object)string2);
        }
        return null;
    }

    private static void d(Context context) {
        if (e == -1 || System.currentTimeMillis() - e >= 1800000) {
            e = System.currentTimeMillis();
            we.c();
            we.e(context);
            we.f();
            we.e();
        }
    }

    private static boolean d() {
        return "mounted".equals((Object)Environment.getExternalStorageState());
    }

    public static boolean d(Uri uri) {
        if (uri != null && "file".equalsIgnoreCase(uri.getScheme())) {
            return true;
        }
        return false;
    }

    public static long e(Uri uri) {
        Cursor cursor = null;
        try {
            cursor = ul.f().getContentResolver().query(uri, null, null, null, null);
            int n2 = cursor.getColumnIndex("_size");
            cursor.moveToFirst();
            long l2 = cursor.getLong(n2);
            return l2;
        }
        finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public static JSONObject e(String string2) {
        JSONObject jSONObject = wb.a(string2);
        if (jSONObject != null) {
            return jSONObject;
        }
        uo uo2 = we.h(string2).i();
        if (uo2.a() != null) {
            return null;
        }
        return uo2.b();
    }

    private static void e() {
        try {
            if (we.d()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                g = (long)statFs.getAvailableBlocks() * (long)statFs.getBlockSize();
            }
            g = we.a(g);
            return;
        }
        catch (Exception var0_1) {
            return;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static void e(Context context) {
        if (!j.equals((Object)"NoCarrier")) return;
        try {
            j = ((TelephonyManager)context.getSystemService("phone")).getNetworkOperatorName();
            return;
        }
        catch (Exception var1_1) {
            return;
        }
    }

    private static void f() {
        try {
            if (we.d()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                f = (long)statFs.getBlockCount() * (long)statFs.getBlockSize();
            }
            f = we.a(f);
            return;
        }
        catch (Exception var0_1) {
            return;
        }
    }

    private static JSONObject g(String string2) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", TextUtils.join((CharSequence)",", (Object[])a));
        GraphRequest graphRequest = GraphRequest.a(null, string2, null);
        graphRequest.a(true);
        graphRequest.a(bundle);
        return graphRequest.i().b();
    }

    private static GraphRequest h(String string2) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", "id,name,first_name,middle_name,last_name,link");
        bundle.putString("access_token", string2);
        return new GraphRequest(null, "me", bundle, HttpMethod.a, null);
    }

    public static class a {
        private String a;
        private String b;
        private Uri c;
        private int[] d;

        private a(String string2, String string3, Uri uri, int[] arrn) {
            this.a = string2;
            this.b = string3;
            this.c = uri;
            this.d = arrn;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        private static int[] a(JSONArray jSONArray) {
            Object object = null;
            if (jSONArray == null) {
                return object;
            }
            int n2 = jSONArray.length();
            object = new int[n2];
            int n3 = 0;
            while (n3 < n2) {
                String string2;
                int n4 = jSONArray.optInt(n3, -1);
                if (n4 == -1 && !we.a(string2 = jSONArray.optString(n3))) {
                    try {
                        int n5;
                        n4 = n5 = Integer.parseInt((String)string2);
                    }
                    catch (NumberFormatException var6_7) {
                        we.a("FacebookSDK", (Exception)var6_7);
                        n4 = -1;
                    }
                }
                object[n3] = n4;
                ++n3;
            }
            return object;
        }

        /*
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        private static a b(JSONObject jSONObject) {
            String string2 = jSONObject.optString("name");
            if (we.a(string2)) {
                return null;
            }
            String[] arrstring = string2.split("\\|");
            if (arrstring.length != 2) return null;
            String string3 = arrstring[0];
            String string4 = arrstring[1];
            if (we.a(string3)) return null;
            if (we.a(string4)) return null;
            String string5 = jSONObject.optString("url");
            boolean bl2 = we.a(string5);
            Uri uri = null;
            if (bl2) return new a(string3, string4, uri, a.a(jSONObject.optJSONArray("versions")));
            uri = Uri.parse((String)string5);
            return new a(string3, string4, uri, a.a(jSONObject.optJSONArray("versions")));
        }

        public String a() {
            return this.a;
        }

        public String b() {
            return this.b;
        }

        public Uri c() {
            return this.c;
        }

        public int[] d() {
            return this.d;
        }
    }

    public static class b {
        private boolean a;
        private String b;
        private boolean c;
        private boolean d;
        private int e;
        private Map<String, Map<String, a>> f;
        private vn g;

        private b(boolean bl2, String string2, boolean bl3, boolean bl4, int n2, Map<String, Map<String, a>> map, vn vn2) {
            this.a = bl2;
            this.b = string2;
            this.c = bl3;
            this.d = bl4;
            this.f = map;
            this.g = vn2;
            this.e = n2;
        }

        /* synthetic */ b(boolean bl2, String string2, boolean bl3, boolean bl4, int n2, Map map, vn vn2,  var8) {
            super(bl2, string2, bl3, bl4, n2, map, vn2);
        }

        public boolean a() {
            return this.a;
        }

        public String b() {
            return this.b;
        }

        public boolean c() {
            return this.c;
        }

        public boolean d() {
            return this.d;
        }

        public Map<String, Map<String, a>> e() {
            return this.f;
        }

        public vn f() {
            return this.g;
        }
    }

    public static interface c {
        public void a(FacebookException var1);

        public void a(JSONObject var1);
    }

    public static interface d<T, K> {
        public K a(T var1);
    }

    public static class e {
        List<String> a;
        List<String> b;

        public e(List<String> list, List<String> list2) {
            this.a = list;
            this.b = list2;
        }

        public List<String> a() {
            return this.a;
        }

        public List<String> b() {
            return this.b;
        }
    }

}

