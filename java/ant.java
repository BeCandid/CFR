/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  io.fabric.sdk.android.services.common.CommonUtils
 *  io.fabric.sdk.android.services.settings.SettingsCacheBehavior
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  org.json.JSONException
 *  org.json.JSONObject
 */
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.settings.SettingsCacheBehavior;
import org.json.JSONException;
import org.json.JSONObject;

class ant
implements aob {
    private final aof a;
    private final aoe b;
    private final alu c;
    private final anq d;
    private final aog e;
    private final alc f;
    private final ani g;

    public ant(alc alc2, aof aof2, alu alu2, aoe aoe2, anq anq2, aog aog2) {
        this.f = alc2;
        this.a = aof2;
        this.c = alu2;
        this.b = aoe2;
        this.d = anq2;
        this.e = aog2;
        this.g = new anj(this.f);
    }

    private void a(JSONObject jSONObject, String string2) throws JSONException {
        akx.h().a("Fabric", string2 + jSONObject.toString());
    }

    /*
     * Exception decompiling
     */
    private aoc b(SettingsCacheBehavior var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.lang.IllegalStateException: Backjump on non jumping statement [] lbl24 : TryStatement: try { 1[TRYBLOCK]

        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner$1.call(Cleaner.java:44)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner$1.call(Cleaner.java:22)
        // org.benf.cfr.reader.util.graph.GraphVisitorDFS.process(GraphVisitorDFS.java:68)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner.removeUnreachableCode(Cleaner.java:54)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.RemoveDeterministicJumps.apply(RemoveDeterministicJumps.java:35)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:507)
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

    @Override
    public aoc a() {
        return this.a(SettingsCacheBehavior.a);
    }

    /*
     * Enabled aggressive exception aggregation
     */
    @Override
    public aoc a(SettingsCacheBehavior settingsCacheBehavior) {
        aoc aoc2 = null;
        try {
            JSONObject jSONObject;
            boolean bl2 = akx.i();
            aoc2 = null;
            if (!bl2) {
                boolean bl3 = this.d();
                aoc2 = null;
                if (!bl3) {
                    aoc2 = super.b(settingsCacheBehavior);
                }
            }
            if (aoc2 == null && (jSONObject = this.e.a(this.a)) != null) {
                aoc2 = this.b.a(this.c, jSONObject);
                this.d.a(aoc2.g, jSONObject);
                super.a(jSONObject, "Loaded settings: ");
                this.a(this.b());
            }
            if (aoc2 == null) {
                aoc aoc3;
                aoc2 = aoc3 = super.b(SettingsCacheBehavior.c);
            }
            return aoc2;
        }
        catch (Exception var3_7) {
            akx.h().e("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", (Throwable)var3_7);
            return aoc2;
        }
    }

    @SuppressLint(value={"CommitPrefEdits"})
    boolean a(String string2) {
        SharedPreferences.Editor editor = this.g.b();
        editor.putString("existing_instance_identifier", string2);
        return this.g.a(editor);
    }

    String b() {
        String[] arrstring = new String[]{CommonUtils.m((Context)this.f.E())};
        return CommonUtils.a((String[])arrstring);
    }

    String c() {
        return this.g.a().getString("existing_instance_identifier", "");
    }

    boolean d() {
        if (!this.c().equals((Object)this.b())) {
            return true;
        }
        return false;
    }
}

