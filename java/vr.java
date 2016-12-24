/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.net.Uri
 *  android.os.Handler
 *  android.os.Looper
 *  java.io.Closeable
 *  java.io.InputStream
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.util.HashMap
 *  java.util.Map
 */
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import java.io.Closeable;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class vr {
    private static Handler a;
    private static wh b;
    private static wh c;
    private static final Map<d, c> d;

    static {
        b = new wh(8);
        c = new wh(2);
        d = new HashMap();
    }

    private static Handler a() {
        reference var2 = vr.class;
        synchronized (vr.class) {
            if (a == null) {
                a = new Handler(Looper.getMainLooper());
            }
            Handler handler = a;
            // ** MonitorExit[var2] (shouldn't be in output)
            return handler;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static c a(d d2) {
        Map<d, c> map;
        Map<d, c> map2 = map = d;
        synchronized (map2) {
            return (c)d.remove((Object)d2);
        }
    }

    private static void a(d d2, final Exception exception, final Bitmap bitmap, final boolean bl2) {
        vs.b b2;
        vs vs2;
        c c2 = vr.a(d2);
        if (c2 != null && !c2.c && (b2 = (vs2 = c2.b).c()) != null) {
            vr.a().post(new Runnable(){

                public void run() {
                    vt vt2 = new vt(vs2, exception, bl2, bitmap);
                    b2.a(vt2);
                }
            });
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(vs vs2) {
        Map<d, c> map;
        if (vs2 == null) {
            return;
        }
        d d2 = new d(vs2.b(), vs2.e());
        Map<d, c> map2 = map = d;
        synchronized (map2) {
            c c2 = (c)d.get((Object)d2);
            if (c2 != null) {
                c2.b = vs2;
                c2.c = false;
                c2.a.b();
            } else {
                vr.a(vs2, d2, vs2.d());
            }
            return;
        }
    }

    private static void a(vs vs2, d d2) {
        vr.a(vs2, d2, b, new b(vs2.a(), d2));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void a(vs vs2, d d2, wh wh2, Runnable runnable) {
        Map<d, c> map;
        Map<d, c> map2 = map = d;
        synchronized (map2) {
            c c2 = new c(null);
            c2.b = vs2;
            d.put((Object)d2, (Object)c2);
            c2.a = wh2.a(runnable);
            return;
        }
    }

    private static void a(vs vs2, d d2, boolean bl2) {
        vr.a(vs2, d2, c, new a(vs2.a(), d2, bl2));
    }

    /*
     * Exception decompiling
     */
    private static void b(d var0_1, Context var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 3[SWITCH]
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
     * Unable to fully structure code
     */
    private static void b(d var0_1, Context var1, boolean var2_2) {
        var3_3 = null;
        var4_4 = false;
        if (!var2_2) ** GOTO lbl11
        var7_5 = wd.a(var0_1.a);
        var3_3 = null;
        var4_4 = false;
        if (var7_5 == null) ** GOTO lbl11
        var3_3 = vu.a(var7_5, var1);
        if (var3_3 != null) {
            var4_4 = true;
lbl11: // 4 sources:
            do {
                if (!var4_4) {
                    var3_3 = vu.a(var0_1.a, var1);
                }
                if (var3_3 != null) {
                    var6_6 = BitmapFactory.decodeStream((InputStream)var3_3);
                    we.a((Closeable)var3_3);
                    vr.a(var0_1, null, var6_6, var4_4);
lbl18: // 2 sources:
                    do {
                        return;
                        break;
                    } while (true);
                }
                break;
                break;
            } while (true);
        } else {
            var4_4 = false;
            ** continue;
        }
        ** while ((var5_7 = vr.a((d)var0_1)) == null || var5_7.c)
lbl24: // 1 sources:
        vr.a(var5_7.b, var0_1);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean b(vs vs2) {
        Map<d, c> map;
        d d2 = new d(vs2.b(), vs2.e());
        Map<d, c> map2 = map = d;
        synchronized (map2) {
            c c2 = (c)d.get((Object)d2);
            boolean bl2 = false;
            if (c2 != null) {
                bl2 = true;
                if (c2.a.a()) {
                    d.remove((Object)d2);
                } else {
                    c2.c = true;
                }
            }
            return bl2;
        }
    }

    static class a
    implements Runnable {
        private Context a;
        private d b;
        private boolean c;

        a(Context context, d d2, boolean bl2) {
            this.a = context;
            this.b = d2;
            this.c = bl2;
        }

        public void run() {
            vr.b(this.b, this.a, this.c);
        }
    }

    static class b
    implements Runnable {
        private Context a;
        private d b;

        b(Context context, d d2) {
            this.a = context;
            this.b = d2;
        }

        public void run() {
            vr.b(this.b, this.a);
        }
    }

    static class c {
        wh.a a;
        vs b;
        boolean c;

        private c() {
        }

        /* synthetic */ c( var1) {
        }
    }

    static class d {
        Uri a;
        Object b;

        d(Uri uri, Object object) {
            this.a = uri;
            this.b = object;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public boolean equals(Object object) {
            boolean bl2 = false;
            if (object == null) return bl2;
            boolean bl3 = object instanceof d;
            bl2 = false;
            if (!bl3) return bl2;
            d d2 = (d)object;
            if (d2.a != this.a) return false;
            if (d2.b != this.b) return false;
            return true;
        }

        public int hashCode() {
            return 37 * (1073 + this.a.hashCode()) + this.b.hashCode();
        }
    }

}

