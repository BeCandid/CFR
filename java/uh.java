/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Parcelable
 *  android.util.Log
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.Date
 *  java.util.HashSet
 *  java.util.Locale
 *  java.util.Set
 *  java.util.concurrent.atomic.AtomicBoolean
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public final class uh {
    private static volatile uh a;
    private final bn b;
    private final ug c;
    private AccessToken d;
    private AtomicBoolean e = new AtomicBoolean(false);
    private Date f = new Date(0);

    uh(bn bn2, ug ug2) {
        wf.a(bn2, "localBroadcastManager");
        wf.a(ug2, "accessTokenCache");
        this.b = bn2;
        this.c = ug2;
    }

    private static GraphRequest a(AccessToken accessToken, GraphRequest.b b2) {
        return new GraphRequest(accessToken, "me/permissions", new Bundle(), HttpMethod.a, b2);
    }

    static /* synthetic */ AtomicBoolean a(uh uh2) {
        return uh2.e;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static uh a() {
        if (a != null) return a;
        reference var1 = uh.class;
        // MONITORENTER : uh.class
        if (a == null) {
            a = new uh(bn.a(ul.f()), new ug());
        }
        // MONITOREXIT : var1
        return a;
    }

    private void a(AccessToken accessToken, AccessToken accessToken2) {
        Intent intent = new Intent("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
        intent.putExtra("com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN", (Parcelable)accessToken);
        intent.putExtra("com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN", (Parcelable)accessToken2);
        this.b.a(intent);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(AccessToken accessToken, boolean bl2) {
        AccessToken accessToken2 = this.d;
        this.d = accessToken;
        this.e.set(false);
        this.f = new Date(0);
        if (bl2) {
            if (accessToken != null) {
                this.c.a(accessToken);
            } else {
                this.c.b();
                we.b(ul.f());
            }
        }
        if (!we.a(accessToken2, accessToken)) {
            super.a(accessToken2, accessToken);
        }
    }

    private static GraphRequest b(AccessToken accessToken, GraphRequest.b b2) {
        Bundle bundle = new Bundle();
        bundle.putString("grant_type", "fb_extend_sso_token");
        return new GraphRequest(accessToken, "oauth/access_token", bundle, HttpMethod.a, b2);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void b(final AccessToken.a a2) {
        final AccessToken accessToken = this.d;
        if (accessToken == null) {
            if (a2 == null) return;
            {
                a2.a(new FacebookException("No current access token to refresh"));
                return;
            }
        } else {
            if (this.e.compareAndSet(false, true)) {
                this.f = new Date();
                HashSet hashSet = new HashSet();
                HashSet hashSet2 = new HashSet();
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                final a a3 = new a(null);
                GraphRequest[] arrgraphRequest = new GraphRequest[]{uh.a(accessToken, new GraphRequest.b((Set)hashSet, (Set)hashSet2){
                    final /* synthetic */ Set b;
                    final /* synthetic */ Set c;

                    /*
                     * Enabled aggressive block sorting
                     */
                    @Override
                    public void onCompleted(uo uo2) {
                        JSONArray jSONArray;
                        JSONObject jSONObject = uo2.b();
                        if (jSONObject == null || (jSONArray = jSONObject.optJSONArray("data")) == null) {
                            return;
                        }
                        atomicBoolean.set(true);
                        int n2 = 0;
                        while (n2 < jSONArray.length()) {
                            JSONObject jSONObject2 = jSONArray.optJSONObject(n2);
                            if (jSONObject2 != null) {
                                String string2 = jSONObject2.optString("permission");
                                String string3 = jSONObject2.optString("status");
                                if (!we.a(string2) && !we.a(string3)) {
                                    String string4 = string3.toLowerCase(Locale.US);
                                    if (string4.equals((Object)"granted")) {
                                        this.b.add((Object)string2);
                                    } else if (string4.equals((Object)"declined")) {
                                        this.c.add((Object)string2);
                                    } else {
                                        Log.w((String)"AccessTokenManager", (String)("Unexpected status: " + string4));
                                    }
                                }
                            }
                            ++n2;
                        }
                    }
                }), uh.b(accessToken, new GraphRequest.b(){

                    @Override
                    public void onCompleted(uo uo2) {
                        JSONObject jSONObject = uo2.b();
                        if (jSONObject == null) {
                            return;
                        }
                        a3.a = jSONObject.optString("access_token");
                        a3.b = jSONObject.optInt("expires_at");
                    }
                })};
                un un2 = new un(arrgraphRequest);
                un2.a(new un.a((Set)hashSet, (Set)hashSet2){
                    final /* synthetic */ Set e;
                    final /* synthetic */ Set f;

                    /*
                     * Exception decompiling
                     */
                    @Override
                    public void a(un var1) {
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
                        // org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:664)
                        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:747)
                        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
                        // org.benf.cfr.reader.Main.doJar(Main.java:128)
                        // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
                        // java.lang.Thread.run(Thread.java:818)
                        throw new IllegalStateException("Decompilation failed");
                    }
                });
                un2.h();
                return;
            }
            if (a2 == null) return;
            {
                a2.a(new FacebookException("Refresh already in progress"));
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private boolean e() {
        if (this.d == null) {
            return false;
        }
        Long l2 = new Date().getTime();
        if (!this.d.f().a()) return false;
        if (l2 - this.f.getTime() <= 3600000) return false;
        if (l2 - this.d.g().getTime() <= 86400000) return false;
        return true;
    }

    void a(final AccessToken.a a2) {
        if (Looper.getMainLooper().equals((Object)Looper.myLooper())) {
            super.b(a2);
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable(){

            public void run() {
                uh.this.b(a2);
            }
        });
    }

    public void a(AccessToken accessToken) {
        super.a(accessToken, true);
    }

    public AccessToken b() {
        return this.d;
    }

    boolean c() {
        AccessToken accessToken = this.c.a();
        boolean bl2 = false;
        if (accessToken != null) {
            this.a(accessToken, false);
            bl2 = true;
        }
        return bl2;
    }

    public void d() {
        if (!this.e()) {
            return;
        }
        this.a((AccessToken.a)null);
    }

    static class a {
        public String a;
        public int b;

        private a() {
        }

        /* synthetic */ a( var1) {
        }
    }

}

