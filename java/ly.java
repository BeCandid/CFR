/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.io.File
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
import android.util.Log;
import java.io.File;
import java.io.IOException;

public class ly
implements lu {
    private static ly a = null;
    private final lw b = new lw();
    private final md c;
    private final File d;
    private final int e;
    private ka f;

    protected ly(File file, int n2) {
        this.d = file;
        this.e = n2;
        this.c = new md();
    }

    private ka a() throws IOException {
        ly ly2 = this;
        synchronized (ly2) {
            if (this.f == null) {
                this.f = ka.a(this.d, 1, 1, this.e);
            }
            ka ka2 = this.f;
            return ka2;
        }
    }

    public static lu a(File file, int n2) {
        reference var4_2 = ly.class;
        synchronized (ly.class) {
            if (a == null) {
                a = new ly(file, n2);
            }
            ly ly2 = a;
            // ** MonitorExit[var4_2] (shouldn't be in output)
            return ly2;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public File a(kn kn2) {
        ka.c c2;
        File file;
        String string2 = this.c.a(kn2);
        try {
            c2 = super.a().a(string2);
            file = null;
            if (c2 == null) return file;
        }
        catch (IOException var3_6) {
            boolean bl2 = Log.isLoggable((String)"DiskLruCacheWrapper", (int)5);
            file = null;
            if (!bl2) return file;
            Log.w((String)"DiskLruCacheWrapper", (String)"Unable to get from disk cache", (Throwable)var3_6);
            return null;
        }
        File file2 = c2.a(0);
        return file2;
    }

    /*
     * Exception decompiling
     */
    @Override
    public void a(kn var1, lu.b var2_2) {
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
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void b(kn kn2) {
        String string2 = this.c.a(kn2);
        try {
            super.a().c(string2);
            return;
        }
        catch (IOException var3_3) {
            if (!Log.isLoggable((String)"DiskLruCacheWrapper", (int)5)) return;
            Log.w((String)"DiskLruCacheWrapper", (String)"Unable to delete from disk cache", (Throwable)var3_3);
            return;
        }
    }
}

