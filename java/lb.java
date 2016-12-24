/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.bumptech.glide.Priority
 *  com.bumptech.glide.load.engine.DiskCacheStrategy
 *  java.io.BufferedOutputStream
 *  java.io.File
 *  java.io.FileNotFoundException
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class lb<A, T, Z> {
    private static final b a = new b();
    private final lf b;
    private final int c;
    private final int d;
    private final ku<A> e;
    private final py<A, T> f;
    private final kr<T> g;
    private final pf<T, Z> h;
    private final a i;
    private final DiskCacheStrategy j;
    private final Priority k;
    private final b l;
    private volatile boolean m;

    public lb(lf lf2, int n2, int n3, ku<A> ku2, py<A, T> py2, kr<T> kr2, pf<T, Z> pf2, a a2, DiskCacheStrategy diskCacheStrategy, Priority priority) {
        super(lf2, n2, n3, ku2, py2, kr2, pf2, a2, diskCacheStrategy, priority, a);
    }

    lb(lf lf2, int n2, int n3, ku<A> ku2, py<A, T> py2, kr<T> kr2, pf<T, Z> pf2, a a2, DiskCacheStrategy diskCacheStrategy, Priority priority, b b2) {
        this.b = lf2;
        this.c = n2;
        this.d = n3;
        this.e = ku2;
        this.f = py2;
        this.g = kr2;
        this.h = pf2;
        this.i = a2;
        this.j = diskCacheStrategy;
        this.k = priority;
        this.l = b2;
    }

    static /* synthetic */ b a(lb lb2) {
        return lb2.l;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private lj<T> a(A a2) throws IOException {
        if (this.j.a()) {
            return super.b(a2);
        }
        long l2 = re.a();
        lj<T> lj2 = this.f.b().a(a2, this.c, this.d);
        if (!Log.isLoggable((String)"DecodeJob", (int)2)) return lj2;
        super.a("Decoded from source", l2);
        return lj2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private lj<T> a(kn kn2) throws IOException {
        lj<T> lj2;
        File file = this.i.a().a(kn2);
        if (file == null) {
            return null;
        }
        try {
            lj<T> lj3 = this.f.a().a(file, this.c, this.d);
            lj2 = lj3;
            if (lj2 != null) return lj2;
        }
        catch (Throwable var3_5) {
            if (false) throw var3_5;
            this.i.a().b(kn2);
            throw var3_5;
        }
        this.i.a().b(kn2);
        return lj2;
    }

    private lj<Z> a(lj<T> lj2) {
        long l2 = re.a();
        lj<T> lj3 = super.c(lj2);
        if (Log.isLoggable((String)"DecodeJob", (int)2)) {
            super.a("Transformed resource from source", l2);
        }
        super.b(lj3);
        long l3 = re.a();
        lj<Z> lj4 = super.d(lj3);
        if (Log.isLoggable((String)"DecodeJob", (int)2)) {
            super.a("Transcoded transformed from source", l3);
        }
        return lj4;
    }

    private void a(String string2, long l2) {
        Log.v((String)"DecodeJob", (String)(string2 + " in " + re.a(l2) + ", key: " + this.b));
    }

    private lj<T> b(A a2) throws IOException {
        long l2 = re.a();
        c<A> c2 = (lb)this.new c<A>(this.f.c(), a2);
        this.i.a().a(this.b.a(), c2);
        if (Log.isLoggable((String)"DecodeJob", (int)2)) {
            super.a("Wrote source to cache", l2);
        }
        long l3 = re.a();
        lj<T> lj2 = super.a(this.b.a());
        if (Log.isLoggable((String)"DecodeJob", (int)2) && lj2 != null) {
            super.a("Decoded source from cache", l3);
        }
        return lj2;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void b(lj<T> lj2) {
        if (lj2 == null) return;
        if (!this.j.b()) {
            return;
        }
        long l2 = re.a();
        c<lj<T>> c2 = (lb)this.new c<lj<T>>(this.f.d(), lj2);
        this.i.a().a(this.b, c2);
        if (!Log.isLoggable((String)"DecodeJob", (int)2)) return;
        super.a("Wrote transformed from source to cache", l2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private lj<T> c(lj<T> lj2) {
        if (lj2 == null) {
            return null;
        }
        lj<T> lj3 = this.g.a(lj2, this.c, this.d);
        if (lj2.equals(lj3)) return lj3;
        lj2.d();
        return lj3;
    }

    private lj<Z> d(lj<T> lj2) {
        if (lj2 == null) {
            return null;
        }
        return this.h.a(lj2);
    }

    /*
     * Exception decompiling
     */
    private lj<T> e() throws Exception {
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
    public lj<Z> a() throws Exception {
        if (!this.j.b()) {
            return null;
        }
        long l2 = re.a();
        lj<T> lj2 = this.a(this.b);
        if (Log.isLoggable((String)"DecodeJob", (int)2)) {
            this.a("Decoded transformed from cache", l2);
        }
        long l3 = re.a();
        lj<Z> lj3 = this.d(lj2);
        if (!Log.isLoggable((String)"DecodeJob", (int)2)) return lj3;
        this.a("Transcoded transformed from cache", l3);
        return lj3;
    }

    public lj<Z> b() throws Exception {
        if (!this.j.a()) {
            return null;
        }
        long l2 = re.a();
        lj<T> lj2 = this.a(this.b.a());
        if (Log.isLoggable((String)"DecodeJob", (int)2)) {
            this.a("Decoded source from cache", l2);
        }
        return this.a(lj2);
    }

    public lj<Z> c() throws Exception {
        return this.a(this.e());
    }

    public void d() {
        this.m = true;
        this.e.c();
    }

    static interface a {
        public lu a();
    }

    static class b {
        b() {
        }

        public OutputStream a(File file) throws FileNotFoundException {
            return new BufferedOutputStream((OutputStream)new FileOutputStream(file));
        }
    }

    class c<DataType>
    implements lu.b {
        private final km<DataType> b;
        private final DataType c;

        public c(km<DataType> km2, DataType DataType) {
            this.b = km2;
            this.c = DataType;
        }

        /*
         * Exception decompiling
         */
        @Override
        public boolean a(File var1) {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:371)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:449)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2859)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:805)
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
    }

}

