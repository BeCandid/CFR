/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.net.HttpURLConnection
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.Locale
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 *  org.json.JSONTokener
 */
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.LoggingBehavior;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class uo {
    private final HttpURLConnection a;
    private final JSONObject b;
    private final JSONArray c;
    private final FacebookRequestError d;
    private final String e;
    private final GraphRequest f;

    uo(GraphRequest graphRequest, HttpURLConnection httpURLConnection, FacebookRequestError facebookRequestError) {
        super(graphRequest, httpURLConnection, null, null, null, facebookRequestError);
    }

    uo(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String string2, JSONArray jSONArray) {
        super(graphRequest, httpURLConnection, string2, null, jSONArray, null);
    }

    uo(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String string2, JSONObject jSONObject) {
        super(graphRequest, httpURLConnection, string2, jSONObject, null, null);
    }

    uo(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String string2, JSONObject jSONObject, JSONArray jSONArray, FacebookRequestError facebookRequestError) {
        this.f = graphRequest;
        this.a = httpURLConnection;
        this.e = string2;
        this.b = jSONObject;
        this.c = jSONArray;
        this.d = facebookRequestError;
    }

    static List<uo> a(InputStream inputStream, HttpURLConnection httpURLConnection, un un2) throws FacebookException, JSONException, IOException {
        String string2 = we.a(inputStream);
        LoggingBehavior loggingBehavior = LoggingBehavior.c;
        Object[] arrobject = new Object[]{string2.length(), string2};
        vx.a(loggingBehavior, "Response", "Response (raw)\n  Size: %d\n  Response:\n%s\n", arrobject);
        return uo.a(string2, httpURLConnection, un2);
    }

    static List<uo> a(String string2, HttpURLConnection httpURLConnection, un un2) throws FacebookException, JSONException, IOException {
        List<uo> list = uo.a(httpURLConnection, un2, new JSONTokener(string2).nextValue());
        LoggingBehavior loggingBehavior = LoggingBehavior.a;
        Object[] arrobject = new Object[]{un2.b(), string2.length(), list};
        vx.a(loggingBehavior, "Response", "Response\n  Id: %s\n  Size: %d\n  Responses:\n%s\n", arrobject);
        return list;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static List<uo> a(HttpURLConnection httpURLConnection, List<GraphRequest> list, Object object) throws FacebookException, JSONException {
        int n2 = list.size();
        ArrayList arrayList = new ArrayList(n2);
        Object object2 = object;
        if (n2 == 1) {
            GraphRequest graphRequest = (GraphRequest)list.get(0);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("body", object);
                int n3 = httpURLConnection != null ? httpURLConnection.getResponseCode() : 200;
                jSONObject.put("code", n3);
                JSONArray jSONArray = new JSONArray();
                jSONArray.put((Object)jSONObject);
                object = jSONArray;
            }
            catch (JSONException var18_11) {
                arrayList.add((Object)new uo(graphRequest, httpURLConnection, new FacebookRequestError(httpURLConnection, (Exception)var18_11)));
            }
            catch (IOException var16_10) {
                arrayList.add((Object)new uo(graphRequest, httpURLConnection, new FacebookRequestError(httpURLConnection, (Exception)var16_10)));
            }
        }
        if (!(object instanceof JSONArray) || ((JSONArray)object).length() != n2) {
            throw new FacebookException("Unexpected number of results");
        }
        JSONArray jSONArray = (JSONArray)object;
        int n4 = 0;
        while (n4 < jSONArray.length()) {
            GraphRequest graphRequest = (GraphRequest)list.get(n4);
            try {
                arrayList.add((Object)uo.a(graphRequest, httpURLConnection, jSONArray.get(n4), object2));
            }
            catch (JSONException var11_15) {
                arrayList.add((Object)new uo(graphRequest, httpURLConnection, new FacebookRequestError(httpURLConnection, (Exception)var11_15)));
            }
            catch (FacebookException var9_16) {
                arrayList.add((Object)new uo(graphRequest, httpURLConnection, new FacebookRequestError(httpURLConnection, (Exception)var9_16)));
            }
            ++n4;
        }
        return arrayList;
    }

    /*
     * Exception decompiling
     */
    public static List<uo> a(HttpURLConnection var0_1, un var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 2[TRYBLOCK]
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

    public static List<uo> a(List<GraphRequest> list, HttpURLConnection httpURLConnection, FacebookException facebookException) {
        int n2 = list.size();
        ArrayList arrayList = new ArrayList(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            arrayList.add((Object)new uo((GraphRequest)list.get(i2), httpURLConnection, new FacebookRequestError(httpURLConnection, (Exception)facebookException)));
        }
        return arrayList;
    }

    private static uo a(GraphRequest graphRequest, HttpURLConnection httpURLConnection, Object object, Object object2) throws JSONException {
        if (object instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject)object;
            FacebookRequestError facebookRequestError = FacebookRequestError.a(jSONObject, object2, httpURLConnection);
            if (facebookRequestError != null) {
                if (facebookRequestError.b() == 190 && we.a(graphRequest.f())) {
                    AccessToken.a(null);
                }
                return new uo(graphRequest, httpURLConnection, facebookRequestError);
            }
            Object object3 = we.a(jSONObject, "body", "FACEBOOK_NON_JSON_RESULT");
            if (object3 instanceof JSONObject) {
                return new uo(graphRequest, httpURLConnection, object3.toString(), (JSONObject)object3);
            }
            if (object3 instanceof JSONArray) {
                return new uo(graphRequest, httpURLConnection, object3.toString(), (JSONArray)object3);
            }
            object = JSONObject.NULL;
        }
        if (object == JSONObject.NULL) {
            return new uo(graphRequest, httpURLConnection, object.toString(), (JSONObject)null);
        }
        throw new FacebookException("Got unexpected object type in response, class: " + object.getClass().getSimpleName());
    }

    public final FacebookRequestError a() {
        return this.d;
    }

    public final JSONObject b() {
        return this.b;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String toString() {
        String string2;
        try {
            String string3;
            Locale locale = Locale.US;
            Object[] arrobject = new Object[1];
            int n2 = this.a != null ? this.a.getResponseCode() : 200;
            arrobject[0] = n2;
            string2 = string3 = String.format((Locale)locale, (String)"%d", (Object[])arrobject);
        }
        catch (IOException var1_6) {
            string2 = "unknown";
            return "{Response: " + " responseCode: " + string2 + ", graphObject: " + (Object)this.b + ", error: " + this.d + "}";
        }
        return "{Response: " + " responseCode: " + string2 + ", graphObject: " + (Object)this.b + ", error: " + this.d + "}";
    }
}

