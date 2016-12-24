/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.os.AsyncTask
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Parcel
 *  android.os.ParcelFileDescriptor
 *  android.os.ParcelFileDescriptor$AutoCloseInputStream
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 *  android.util.Log
 *  android.util.Pair
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Iterable
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.Void
 *  java.net.HttpURLConnection
 *  java.net.MalformedURLException
 *  java.net.URL
 *  java.net.URLConnection
 *  java.net.URLEncoder
 *  java.text.SimpleDateFormat
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Date
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Set
 *  java.util.concurrent.Executor
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.facebook;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GraphRequest {
    public static final String a = GraphRequest.class.getSimpleName();
    private static String b;
    private static Pattern c;
    private static volatile String q;
    private AccessToken d;
    private HttpMethod e;
    private String f;
    private JSONObject g;
    private String h;
    private String i;
    private boolean j;
    private Bundle k;
    private b l;
    private String m;
    private Object n;
    private String o;
    private boolean p;

    static {
        c = Pattern.compile((String)"^/?v\\d+\\.\\d+/(.*)");
    }

    public GraphRequest() {
        this(null, null, null, null, null);
    }

    public GraphRequest(AccessToken accessToken, String string2, Bundle bundle, HttpMethod httpMethod) {
        super(accessToken, string2, bundle, httpMethod, null);
    }

    public GraphRequest(AccessToken accessToken, String string2, Bundle bundle, HttpMethod httpMethod, b b2) {
        this(accessToken, string2, bundle, httpMethod, b2, null);
    }

    /*
     * Enabled aggressive block sorting
     */
    public GraphRequest(AccessToken accessToken, String string2, Bundle bundle, HttpMethod httpMethod, b b2, String string3) {
        this.j = true;
        this.p = false;
        this.d = accessToken;
        this.f = string2;
        this.o = string3;
        this.a(b2);
        this.a(httpMethod);
        this.k = bundle != null ? new Bundle(bundle) : new Bundle();
        if (this.o == null) {
            this.o = wc.d();
        }
    }

    public static GraphRequest a(AccessToken accessToken, final c c2) {
        return new GraphRequest(accessToken, "me", null, null, new b(){

            @Override
            public void onCompleted(uo uo2) {
                if (c2 != null) {
                    c2.onCompleted(uo2.b(), uo2);
                }
            }
        });
    }

    public static GraphRequest a(AccessToken accessToken, String string2, b b2) {
        return new GraphRequest(accessToken, string2, null, null, b2);
    }

    public static GraphRequest a(AccessToken accessToken, String string2, JSONObject jSONObject, b b2) {
        GraphRequest graphRequest = new GraphRequest(accessToken, string2, null, HttpMethod.b, b2);
        graphRequest.a(jSONObject);
        return graphRequest;
    }

    private static HttpURLConnection a(URL uRL) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
        httpURLConnection.setRequestProperty("User-Agent", GraphRequest.p());
        httpURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().toString());
        httpURLConnection.setChunkedStreamingMode(0);
        return httpURLConnection;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static HttpURLConnection a(un var0) {
        GraphRequest.d(var0);
        try {
            var2_1 = var0.size() == 1 ? new URL(var0.a(0).l()) : new URL(wc.b());
            var3_2 = null;
        }
        catch (MalformedURLException var1_3) {
            throw new FacebookException("could not construct URL for request", (Throwable)var1_3);
        }
        try {
            var3_2 = GraphRequest.a(var2_1);
            GraphRequest.a(var0, var3_2);
            return var3_2;
        }
        catch (JSONException var4_4) {}
        ** GOTO lbl-1000
        catch (IOException var4_6) {}
lbl-1000: // 2 sources:
        {
            we.a((URLConnection)var3_2);
            throw new FacebookException("could not construct request body", (Throwable)var4_5);
        }
    }

    public static List<uo> a(HttpURLConnection httpURLConnection, un un2) {
        List<uo> list = uo.a(httpURLConnection, un2);
        we.a((URLConnection)httpURLConnection);
        int n2 = un2.size();
        if (n2 != list.size()) {
            Locale locale = Locale.US;
            Object[] arrobject = new Object[]{list.size(), n2};
            throw new FacebookException(String.format((Locale)locale, (String)"Received %d responses while expecting %d", (Object[])arrobject));
        }
        GraphRequest.a(un2, list);
        uh.a().d();
        return list;
    }

    public static List<uo> a(Collection<GraphRequest> collection) {
        return GraphRequest.b(new un(collection));
    }

    public static /* varargs */ List<uo> a(GraphRequest ... arrgraphRequest) {
        wf.a(arrgraphRequest, "requests");
        return GraphRequest.a(Arrays.asList((Object[])arrgraphRequest));
    }

    public static uo a(GraphRequest graphRequest) {
        List<uo> list = GraphRequest.a(new GraphRequest[]{graphRequest});
        if (list == null || list.size() != 1) {
            throw new FacebookException("invalid state: expected a single response");
        }
        return (uo)list.get(0);
    }

    private static void a(Bundle bundle, f f2, GraphRequest graphRequest) throws IOException {
        for (String string2 : bundle.keySet()) {
            Object object = bundle.get(string2);
            if (!GraphRequest.e(object)) continue;
            f2.a(string2, object, graphRequest);
        }
    }

    private static void a(f f2, Collection<GraphRequest> collection, Map<String, a> map) throws JSONException, IOException {
        JSONArray jSONArray = new JSONArray();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            ((GraphRequest)iterator.next()).a(jSONArray, map);
        }
        f2.a("batch", jSONArray, collection);
    }

    /*
     * Enabled aggressive block sorting
     */
    private static void a(String string2, Object object, d d2, boolean bl2) throws IOException {
        Class class_ = object.getClass();
        if (JSONObject.class.isAssignableFrom(class_)) {
            JSONObject jSONObject = (JSONObject)object;
            if (bl2) {
                Iterator iterator = jSONObject.keys();
                while (iterator.hasNext()) {
                    String string3 = (String)iterator.next();
                    GraphRequest.a(String.format((String)"%s[%s]", (Object[])new Object[]{string2, string3}), jSONObject.opt(string3), d2, bl2);
                }
                return;
            } else if (jSONObject.has("id")) {
                GraphRequest.a(string2, (Object)jSONObject.optString("id"), d2, bl2);
                return;
            } else {
                if (jSONObject.has("url")) {
                    GraphRequest.a(string2, (Object)jSONObject.optString("url"), d2, bl2);
                    return;
                }
                if (!jSONObject.has("fbsdk:create_object")) return;
                {
                    GraphRequest.a(string2, (Object)jSONObject.toString(), d2, bl2);
                    return;
                }
            }
        } else {
            if (JSONArray.class.isAssignableFrom(class_)) {
                JSONArray jSONArray = (JSONArray)object;
                int n2 = jSONArray.length();
                int n3 = 0;
                while (n3 < n2) {
                    Locale locale = Locale.ROOT;
                    Object[] arrobject = new Object[]{string2, n3};
                    GraphRequest.a(String.format((Locale)locale, (String)"%s[%d]", (Object[])arrobject), jSONArray.opt(n3), d2, bl2);
                    ++n3;
                }
                return;
            }
            if (String.class.isAssignableFrom(class_) || Number.class.isAssignableFrom(class_) || Boolean.class.isAssignableFrom(class_)) {
                d2.a(string2, object.toString());
                return;
            }
            if (!Date.class.isAssignableFrom(class_)) return;
            {
                Date date = (Date)object;
                d2.a(string2, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format(date));
                return;
            }
        }
    }

    private static void a(HttpURLConnection httpURLConnection, boolean bl2) {
        if (bl2) {
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
            return;
        }
        httpURLConnection.setRequestProperty("Content-Type", GraphRequest.o());
    }

    private static void a(Map<String, a> map, f f2) throws IOException {
        for (String string2 : map.keySet()) {
            a a2 = (a)map.get((Object)string2);
            if (!GraphRequest.d(a2.b())) continue;
            f2.a(string2, a2.b(), a2.a());
        }
    }

    private void a(JSONArray jSONArray, Map<String, a> map) throws JSONException, IOException {
        JSONObject jSONObject = new JSONObject();
        if (this.h != null) {
            jSONObject.put("name", (Object)this.h);
            jSONObject.put("omit_response_on_success", this.j);
        }
        if (this.i != null) {
            jSONObject.put("depends_on", (Object)this.i);
        }
        String string2 = this.k();
        jSONObject.put("relative_url", (Object)string2);
        jSONObject.put("method", (Object)this.e);
        if (this.d != null) {
            vx.a(this.d.b());
        }
        ArrayList arrayList = new ArrayList();
        for (String string3 : this.k.keySet()) {
            Object object = this.k.get(string3);
            if (!GraphRequest.d(object)) continue;
            Locale locale = Locale.ROOT;
            Object[] arrobject = new Object[]{"file", map.size()};
            String string4 = String.format((Locale)locale, (String)"%s%d", (Object[])arrobject);
            arrayList.add((Object)string4);
            map.put((Object)string4, (Object)new a((GraphRequest)this, object));
        }
        if (!arrayList.isEmpty()) {
            jSONObject.put("attached_files", (Object)TextUtils.join((CharSequence)",", (Iterable)arrayList));
        }
        if (this.g != null) {
            final ArrayList arrayList2 = new ArrayList();
            GraphRequest.a(this.g, string2, new d(){

                @Override
                public void a(String string2, String string3) throws IOException {
                    ArrayList arrayList = arrayList2;
                    Locale locale = Locale.US;
                    Object[] arrobject = new Object[]{string2, URLEncoder.encode((String)string3, (String)"UTF-8")};
                    arrayList.add((Object)String.format((Locale)locale, (String)"%s=%s", (Object[])arrobject));
                }
            });
            jSONObject.put("body", (Object)TextUtils.join((CharSequence)"&", (Iterable)arrayList2));
        }
        jSONArray.put((Object)jSONObject);
    }

    /*
     * Enabled aggressive block sorting
     */
    private static void a(JSONObject jSONObject, String string2, d d2) throws IOException {
        boolean bl2 = GraphRequest.c(string2);
        boolean bl3 = false;
        if (bl2) {
            int n2 = string2.indexOf(":");
            int n3 = string2.indexOf("?");
            bl3 = n2 > 3 && (n3 == -1 || n2 < n3);
        }
        Iterator iterator = jSONObject.keys();
        while (iterator.hasNext()) {
            String string3 = (String)iterator.next();
            Object object = jSONObject.opt(string3);
            boolean bl4 = bl3 && string3.equalsIgnoreCase("image");
            GraphRequest.a(string3, object, d2, bl4);
        }
        return;
    }

    /*
     * Exception decompiling
     */
    static final void a(un var0_1, HttpURLConnection var1) throws IOException, JSONException {
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

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static void a(final un un2, List<uo> list) {
        int n2 = un2.size();
        final ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < n2; ++i2) {
            GraphRequest graphRequest = un2.a(i2);
            if (graphRequest.l == null) continue;
            arrayList.add((Object)new Pair((Object)graphRequest.l, list.get(i2)));
        }
        if (arrayList.size() <= 0) return;
        Runnable runnable = new Runnable(){

            public void run() {
                for (Pair pair : arrayList) {
                    ((b)pair.first).onCompleted((uo)pair.second);
                }
                Iterator iterator = un2.e().iterator();
                while (iterator.hasNext()) {
                    ((un.a)iterator.next()).a(un2);
                }
            }
        };
        Handler handler = un2.c();
        if (handler == null) {
            runnable.run();
            return;
        }
        handler.post(runnable);
    }

    private static void a(un un2, vx vx2, int n2, URL uRL, OutputStream outputStream, boolean bl2) throws IOException, JSONException {
        f f2 = new f(outputStream, vx2, bl2);
        if (n2 == 1) {
            GraphRequest graphRequest = un2.a(0);
            HashMap hashMap = new HashMap();
            for (String string2 : graphRequest.k.keySet()) {
                Object object = graphRequest.k.get(string2);
                if (!GraphRequest.d(object)) continue;
                hashMap.put((Object)string2, (Object)new a(graphRequest, object));
            }
            if (vx2 != null) {
                vx2.c("  Parameters:\n");
            }
            GraphRequest.a(graphRequest.k, f2, graphRequest);
            if (vx2 != null) {
                vx2.c("  Attachments:\n");
            }
            GraphRequest.a(hashMap, f2);
            if (graphRequest.g != null) {
                GraphRequest.a(graphRequest.g, uRL.getPath(), f2);
            }
            return;
        }
        String string3 = GraphRequest.g(un2);
        if (we.a(string3)) {
            throw new FacebookException("App ID was not specified at the request or Settings.");
        }
        f2.a("batch_app_id", string3);
        HashMap hashMap = new HashMap();
        GraphRequest.a(f2, un2, hashMap);
        if (vx2 != null) {
            vx2.c("  Attachments:\n");
        }
        GraphRequest.a(hashMap, f2);
    }

    private String b(String string2) {
        Uri.Builder builder = new Uri.Builder().encodedPath(string2);
        for (String string3 : this.k.keySet()) {
            Object object = this.k.get(string3);
            if (object == null) {
                object = "";
            }
            if (GraphRequest.e(object)) {
                builder.appendQueryParameter(string3, GraphRequest.f(object).toString());
                continue;
            }
            if (this.e != HttpMethod.a) continue;
            Locale locale = Locale.US;
            Object[] arrobject = new Object[]{object.getClass().getSimpleName()};
            throw new IllegalArgumentException(String.format((Locale)locale, (String)"Unsupported parameter type for GET request: %s", (Object[])arrobject));
        }
        return builder.toString();
    }

    /*
     * Enabled aggressive exception aggregation
     */
    public static List<uo> b(un un2) {
        wf.c(un2, "requests");
        HttpURLConnection httpURLConnection2 = null;
        try {
            try {
                HttpURLConnection httpURLConnection;
                httpURLConnection2 = httpURLConnection = GraphRequest.a(un2);
            }
            catch (Exception exception) {
                List<uo> list2 = uo.a(un2.d(), null, new FacebookException((Throwable)exception));
                GraphRequest.a(un2, list2);
                we.a(null);
                return list2;
            }
            List<uo> list = GraphRequest.a(httpURLConnection2, un2);
            return list;
        }
        finally {
            we.a((URLConnection)httpURLConnection2);
        }
    }

    public static um b(Collection<GraphRequest> collection) {
        return GraphRequest.c(new un(collection));
    }

    public static /* varargs */ um b(GraphRequest ... arrgraphRequest) {
        wf.a(arrgraphRequest, "requests");
        return GraphRequest.b(Arrays.asList((Object[])arrgraphRequest));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static final boolean b(GraphRequest graphRequest) {
        String[] arrstring;
        String string2 = graphRequest.d();
        if (we.a(string2)) {
            return true;
        }
        if (string2.startsWith("v")) {
            string2 = string2.substring(1);
        }
        if ((arrstring = string2.split("\\.")).length >= 2) {
            if (Integer.parseInt((String)arrstring[0]) > 2) return true;
        }
        int n2 = Integer.parseInt((String)arrstring[0]);
        boolean bl2 = false;
        if (n2 < 2) return bl2;
        int n3 = Integer.parseInt((String)arrstring[1]);
        bl2 = false;
        if (n3 < 4) return bl2;
        return true;
    }

    public static um c(un un2) {
        wf.c(un2, "requests");
        um um2 = new um(un2);
        um2.executeOnExecutor(ul.d(), (Object[])new Void[0]);
        return um2;
    }

    private static boolean c(String string2) {
        Matcher matcher = c.matcher((CharSequence)string2);
        if (matcher.matches()) {
            string2 = matcher.group(1);
        }
        if (string2.startsWith("me/") || string2.startsWith("/me/")) {
            return true;
        }
        return false;
    }

    static final void d(un un2) {
        Iterator iterator = un2.iterator();
        while (iterator.hasNext()) {
            Bundle bundle;
            GraphRequest graphRequest = (GraphRequest)iterator.next();
            if (!HttpMethod.a.equals((Object)graphRequest.c()) || !GraphRequest.b(graphRequest) || (bundle = graphRequest.e()).containsKey("fields") && !we.a(bundle.getString("fields"))) continue;
            LoggingBehavior loggingBehavior = LoggingBehavior.f;
            Object[] arrobject = new Object[]{graphRequest.b()};
            vx.a(loggingBehavior, 5, "Request", "starting with Graph API v2.4, GET requests for /%s should contain an explicit \"fields\" parameter.", arrobject);
        }
    }

    private static boolean d(Object object) {
        if (object instanceof Bitmap || object instanceof byte[] || object instanceof Uri || object instanceof ParcelFileDescriptor || object instanceof ParcelableResourceWithMimeType) {
            return true;
        }
        return false;
    }

    private static boolean e(Object object) {
        if (object instanceof String || object instanceof Boolean || object instanceof Number || object instanceof Date) {
            return true;
        }
        return false;
    }

    private static boolean e(un un2) {
        Iterator iterator = un2.e().iterator();
        while (iterator.hasNext()) {
            if (!((un.a)iterator.next() instanceof un.b)) continue;
            return true;
        }
        Iterator iterator2 = un2.iterator();
        while (iterator2.hasNext()) {
            if (!(((GraphRequest)iterator2.next()).g() instanceof e)) continue;
            return true;
        }
        return false;
    }

    private static String f(Object object) {
        if (object instanceof String) {
            return (String)object;
        }
        if (object instanceof Boolean || object instanceof Number) {
            return object.toString();
        }
        if (object instanceof Date) {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format(object);
        }
        throw new IllegalArgumentException("Unsupported parameter type.");
    }

    private static boolean f(un un2) {
        Iterator iterator = un2.iterator();
        while (iterator.hasNext()) {
            GraphRequest graphRequest = (GraphRequest)iterator.next();
            for (String string2 : graphRequest.k.keySet()) {
                if (!GraphRequest.d(graphRequest.k.get(string2))) continue;
                return false;
            }
        }
        return true;
    }

    private static String g(un un2) {
        if (!we.a(un2.f())) {
            return un2.f();
        }
        Iterator iterator = un2.iterator();
        while (iterator.hasNext()) {
            String string2;
            AccessToken accessToken = ((GraphRequest)iterator.next()).d;
            if (accessToken == null || (string2 = accessToken.h()) == null) continue;
            return string2;
        }
        if (!we.a(b)) {
            return b;
        }
        return ul.i();
    }

    /*
     * Enabled aggressive block sorting
     */
    private void m() {
        if (this.d != null) {
            if (!this.k.containsKey("access_token")) {
                String string2 = this.d.b();
                vx.a(string2);
                this.k.putString("access_token", string2);
            }
        } else if (!this.p && !this.k.containsKey("access_token")) {
            String string3 = ul.i();
            String string4 = ul.k();
            if (!we.a(string3) && !we.a(string4)) {
                String string5 = string3 + "|" + string4;
                this.k.putString("access_token", string5);
            } else {
                Log.d((String)a, (String)"Warning: Request without access token missing application ID or client token.");
            }
        }
        this.k.putString("sdk", "android");
        this.k.putString("format", "json");
        if (ul.a(LoggingBehavior.h)) {
            this.k.putString("debug", "info");
            return;
        } else {
            if (!ul.a(LoggingBehavior.g)) return;
            {
                this.k.putString("debug", "warning");
                return;
            }
        }
    }

    private String n() {
        if (c.matcher((CharSequence)this.f).matches()) {
            return this.f;
        }
        Object[] arrobject = new Object[]{this.o, this.f};
        return String.format((String)"%s/%s", (Object[])arrobject);
    }

    private static String o() {
        return String.format((String)"multipart/form-data; boundary=%s", (Object[])new Object[]{"3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f"});
    }

    private static String p() {
        if (q == null) {
            q = String.format((String)"%s.%s", (Object[])new Object[]{"FBAndroidSDK", "4.12.1"});
            String string2 = vv.a();
            if (!we.a(string2)) {
                Locale locale = Locale.ROOT;
                Object[] arrobject = new Object[]{q, string2};
                q = String.format((Locale)locale, (String)"%s/%s", (Object[])arrobject);
            }
        }
        return q;
    }

    public final JSONObject a() {
        return this.g;
    }

    public final void a(Bundle bundle) {
        this.k = bundle;
    }

    public final void a(final b b2) {
        if (ul.a(LoggingBehavior.h) || ul.a(LoggingBehavior.g)) {
            this.l = new b(){

                /*
                 * Enabled aggressive block sorting
                 */
                @Override
                public void onCompleted(uo uo2) {
                    JSONObject jSONObject = uo2.b();
                    JSONObject jSONObject2 = jSONObject != null ? jSONObject.optJSONObject("__debug__") : null;
                    JSONArray jSONArray = jSONObject2 != null ? jSONObject2.optJSONArray("messages") : null;
                    if (jSONArray != null) {
                        for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
                            JSONObject jSONObject3 = jSONArray.optJSONObject(i2);
                            String string2 = jSONObject3 != null ? jSONObject3.optString("message") : null;
                            String string3 = jSONObject3 != null ? jSONObject3.optString("type") : null;
                            String string4 = jSONObject3 != null ? jSONObject3.optString("link") : null;
                            if (string2 == null || string3 == null) continue;
                            LoggingBehavior loggingBehavior = LoggingBehavior.h;
                            if (string3.equals((Object)"warning")) {
                                loggingBehavior = LoggingBehavior.g;
                            }
                            if (!we.a(string4)) {
                                string2 = string2 + " Link: " + string4;
                            }
                            vx.a(loggingBehavior, GraphRequest.a, string2);
                        }
                    }
                    if (b2 == null) return;
                    b2.onCompleted(uo2);
                }
            };
            return;
        }
        this.l = b2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final void a(HttpMethod httpMethod) {
        if (this.m != null && httpMethod != HttpMethod.a) {
            throw new FacebookException("Can't change HTTP method on request with overridden URL.");
        }
        if (httpMethod == null) {
            httpMethod = HttpMethod.a;
        }
        this.e = httpMethod;
    }

    public final void a(Object object) {
        this.n = object;
    }

    public final void a(String string2) {
        this.o = string2;
    }

    public final void a(JSONObject jSONObject) {
        this.g = jSONObject;
    }

    public final void a(boolean bl2) {
        this.p = bl2;
    }

    public final String b() {
        return this.f;
    }

    public final HttpMethod c() {
        return this.e;
    }

    public final String d() {
        return this.o;
    }

    public final Bundle e() {
        return this.k;
    }

    public final AccessToken f() {
        return this.d;
    }

    public final b g() {
        return this.l;
    }

    public final Object h() {
        return this.n;
    }

    public final uo i() {
        return GraphRequest.a(this);
    }

    public final um j() {
        return GraphRequest.b(new GraphRequest[]{this});
    }

    final String k() {
        if (this.m != null) {
            throw new FacebookException("Can't override URL for a batch request");
        }
        String string2 = this.n();
        this.m();
        return this.b(string2);
    }

    /*
     * Enabled aggressive block sorting
     */
    final String l() {
        if (this.m != null) {
            return this.m.toString();
        }
        String string2 = this.c() == HttpMethod.b && this.f != null && this.f.endsWith("/videos") ? wc.c() : wc.b();
        Object[] arrobject = new Object[]{string2, this.n()};
        String string3 = String.format((String)"%s/%s", (Object[])arrobject);
        this.m();
        return this.b(string3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String toString() {
        Object object;
        StringBuilder stringBuilder = new StringBuilder().append("{Request: ").append(" accessToken: ");
        if (this.d == null) {
            object = "null";
            do {
                return stringBuilder.append(object).append(", graphPath: ").append(this.f).append(", graphObject: ").append((Object)this.g).append(", httpMethod: ").append((Object)this.e).append(", parameters: ").append((Object)this.k).append("}").toString();
                break;
            } while (true);
        }
        object = this.d;
        return stringBuilder.append(object).append(", graphPath: ").append(this.f).append(", graphObject: ").append((Object)this.g).append(", httpMethod: ").append((Object)this.e).append(", parameters: ").append((Object)this.k).append("}").toString();
    }

    public static class ParcelableResourceWithMimeType<RESOURCE extends Parcelable>
    implements Parcelable {
        public static final Parcelable.Creator<ParcelableResourceWithMimeType> CREATOR = new Parcelable.Creator<ParcelableResourceWithMimeType>(){

            public ParcelableResourceWithMimeType a(Parcel parcel) {
                return new ParcelableResourceWithMimeType(parcel, null);
            }

            public ParcelableResourceWithMimeType[] a(int n2) {
                return new ParcelableResourceWithMimeType[n2];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return this.a(parcel);
            }

            public /* synthetic */ Object[] newArray(int n2) {
                return this.a(n2);
            }
        };
        private final String a;
        private final RESOURCE b;

        private ParcelableResourceWithMimeType(Parcel parcel) {
            this.a = parcel.readString();
            this.b = parcel.readParcelable(ul.f().getClassLoader());
        }

        /* synthetic */ ParcelableResourceWithMimeType(Parcel parcel, com.facebook.GraphRequest$1 var2_2) {
            super(parcel);
        }

        public String a() {
            return this.a;
        }

        public RESOURCE b() {
            return this.b;
        }

        public int describeContents() {
            return 1;
        }

        public void writeToParcel(Parcel parcel, int n2) {
            parcel.writeString(this.a);
            parcel.writeParcelable(this.b, n2);
        }

    }

    static class a {
        private final GraphRequest a;
        private final Object b;

        public a(GraphRequest graphRequest, Object object) {
            this.a = graphRequest;
            this.b = object;
        }

        public GraphRequest a() {
            return this.a;
        }

        public Object b() {
            return this.b;
        }
    }

    public static interface b {
        public void onCompleted(uo var1);
    }

    public static interface c {
        public void onCompleted(JSONObject var1, uo var2);
    }

    static interface d {
        public void a(String var1, String var2) throws IOException;
    }

    public static interface e
    extends b {
        public void a(long var1, long var3);
    }

    static class f
    implements d {
        private final OutputStream a;
        private final vx b;
        private boolean c = true;
        private boolean d = false;

        public f(OutputStream outputStream, vx vx2, boolean bl2) {
            this.a = outputStream;
            this.b = vx2;
            this.d = bl2;
        }

        private RuntimeException b() {
            return new IllegalArgumentException("value is not a supported type.");
        }

        public void a() throws IOException {
            if (!this.d) {
                this.b("--%s", "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
                return;
            }
            this.a.write("&".getBytes());
        }

        public void a(String string2, Bitmap bitmap) throws IOException {
            this.a(string2, string2, "image/png");
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, this.a);
            this.b("", new Object[0]);
            this.a();
            if (this.b != null) {
                this.b.a("    " + string2, (Object)"<Image>");
            }
        }

        /*
         * Enabled aggressive block sorting
         */
        public void a(String string2, Uri uri, String string3) throws IOException {
            if (string3 == null) {
                string3 = "content/unknown";
            }
            this.a(string2, string2, string3);
            int n2 = 0;
            if (this.a instanceof us) {
                long l2 = we.e(uri);
                ((us)this.a).a(l2);
            } else {
                n2 = 0 + we.a(ul.f().getContentResolver().openInputStream(uri), this.a);
            }
            this.b("", new Object[0]);
            this.a();
            if (this.b != null) {
                vx vx2 = this.b;
                String string4 = "    " + string2;
                Locale locale = Locale.ROOT;
                Object[] arrobject = new Object[]{n2};
                vx2.a(string4, (Object)String.format((Locale)locale, (String)"<Data: %d>", (Object[])arrobject));
            }
        }

        /*
         * Enabled aggressive block sorting
         */
        public void a(String string2, ParcelFileDescriptor parcelFileDescriptor, String string3) throws IOException {
            if (string3 == null) {
                string3 = "content/unknown";
            }
            this.a(string2, string2, string3);
            int n2 = 0;
            if (this.a instanceof us) {
                ((us)this.a).a(parcelFileDescriptor.getStatSize());
            } else {
                n2 = 0 + we.a((InputStream)new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor), this.a);
            }
            this.b("", new Object[0]);
            this.a();
            if (this.b != null) {
                vx vx2 = this.b;
                String string4 = "    " + string2;
                Locale locale = Locale.ROOT;
                Object[] arrobject = new Object[]{n2};
                vx2.a(string4, (Object)String.format((Locale)locale, (String)"<Data: %d>", (Object[])arrobject));
            }
        }

        public void a(String string2, Object object, GraphRequest graphRequest) throws IOException {
            if (this.a instanceof uv) {
                ((uv)this.a).a(graphRequest);
            }
            if (GraphRequest.e(object)) {
                this.a(string2, GraphRequest.f(object));
                return;
            }
            if (object instanceof Bitmap) {
                this.a(string2, (Bitmap)object);
                return;
            }
            if (object instanceof byte[]) {
                this.a(string2, (byte[])object);
                return;
            }
            if (object instanceof Uri) {
                this.a(string2, (Uri)object, null);
                return;
            }
            if (object instanceof ParcelFileDescriptor) {
                this.a(string2, (ParcelFileDescriptor)object, null);
                return;
            }
            if (object instanceof ParcelableResourceWithMimeType) {
                ParcelableResourceWithMimeType parcelableResourceWithMimeType = (ParcelableResourceWithMimeType)object;
                Object RESOURCE = parcelableResourceWithMimeType.b();
                String string3 = parcelableResourceWithMimeType.a();
                if (RESOURCE instanceof ParcelFileDescriptor) {
                    this.a(string2, (ParcelFileDescriptor)RESOURCE, string3);
                    return;
                }
                if (RESOURCE instanceof Uri) {
                    this.a(string2, (Uri)RESOURCE, string3);
                    return;
                }
                throw super.b();
            }
            throw super.b();
        }

        @Override
        public void a(String string2, String string3) throws IOException {
            this.a(string2, (String)null, (String)null);
            this.b("%s", string3);
            this.a();
            if (this.b != null) {
                this.b.a("    " + string2, (Object)string3);
            }
        }

        public void a(String string2, String string3, String string4) throws IOException {
            if (!this.d) {
                this.a("Content-Disposition: form-data; name=\"%s\"", new Object[]{string2});
                if (string3 != null) {
                    this.a("; filename=\"%s\"", new Object[]{string3});
                }
                this.b("", new Object[0]);
                if (string4 != null) {
                    this.b("%s: %s", "Content-Type", string4);
                }
                this.b("", new Object[0]);
                return;
            }
            this.a.write(String.format((String)"%s=", (Object[])new Object[]{string2}).getBytes());
        }

        /*
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        public void a(String string2, JSONArray jSONArray, Collection<GraphRequest> collection) throws IOException, JSONException {
            if (!(this.a instanceof uv)) {
                this.a(string2, jSONArray.toString());
                return;
            }
            uv uv2 = (uv)this.a;
            this.a(string2, (String)null, (String)null);
            this.a("[", new Object[0]);
            int n2 = 0;
            Iterator iterator = collection.iterator();
            do {
                if (!iterator.hasNext()) {
                    this.a("]", new Object[0]);
                    if (this.b == null) return;
                    this.b.a("    " + string2, (Object)jSONArray.toString());
                    return;
                }
                GraphRequest graphRequest = (GraphRequest)iterator.next();
                JSONObject jSONObject = jSONArray.getJSONObject(n2);
                uv2.a(graphRequest);
                if (n2 > 0) {
                    Object[] arrobject = new Object[]{jSONObject.toString()};
                    this.a(",%s", arrobject);
                } else {
                    Object[] arrobject = new Object[]{jSONObject.toString()};
                    this.a("%s", arrobject);
                }
                ++n2;
            } while (true);
        }

        public void a(String string2, byte[] arrby) throws IOException {
            this.a(string2, string2, "content/unknown");
            this.a.write(arrby);
            this.b("", new Object[0]);
            this.a();
            if (this.b != null) {
                vx vx2 = this.b;
                String string3 = "    " + string2;
                Locale locale = Locale.ROOT;
                Object[] arrobject = new Object[]{arrby.length};
                vx2.a(string3, (Object)String.format((Locale)locale, (String)"<Data: %d>", (Object[])arrobject));
            }
        }

        public /* varargs */ void a(String string2, Object ... arrobject) throws IOException {
            if (!this.d) {
                if (this.c) {
                    this.a.write("--".getBytes());
                    this.a.write("3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f".getBytes());
                    this.a.write("\r\n".getBytes());
                    this.c = false;
                }
                this.a.write(String.format((String)string2, (Object[])arrobject).getBytes());
                return;
            }
            this.a.write(URLEncoder.encode((String)String.format((Locale)Locale.US, (String)string2, (Object[])arrobject), (String)"UTF-8").getBytes());
        }

        public /* varargs */ void b(String string2, Object ... arrobject) throws IOException {
            this.a(string2, arrobject);
            if (!this.d) {
                this.a("\r\n", new Object[0]);
            }
        }
    }

}

