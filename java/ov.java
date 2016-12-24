/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.util.Log
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
import android.graphics.Bitmap;
import android.util.Log;
import java.io.IOException;
import java.io.OutputStream;

public class ov
implements kq<on> {
    private static final a a = new a();
    private final kd.a b;
    private final ln c;
    private final a d;

    public ov(ln ln2) {
        super(ln2, a);
    }

    ov(ln ln2, a a2) {
        this.c = ln2;
        this.b = new om(ln2);
        this.d = a2;
    }

    private kd a(byte[] arrby) {
        kg kg2 = this.d.a();
        kg2.a(arrby);
        kf kf2 = kg2.b();
        kd kd2 = this.d.a(this.b);
        kd2.a(kf2, arrby);
        kd2.a();
        return kd2;
    }

    private lj<Bitmap> a(Bitmap bitmap, kr<Bitmap> kr2, on on2) {
        lj<Bitmap> lj2;
        lj<Bitmap> lj3 = this.d.a(bitmap, this.c);
        if (!lj3.equals(lj2 = kr2.a(lj3, on2.getIntrinsicWidth(), on2.getIntrinsicHeight()))) {
            lj3.d();
        }
        return lj2;
    }

    @Override
    private boolean a(byte[] arrby, OutputStream outputStream) {
        try {
            outputStream.write(arrby);
            return true;
        }
        catch (IOException var3_3) {
            if (Log.isLoggable((String)"GifEncoder", (int)3)) {
                Log.d((String)"GifEncoder", (String)"Failed to write data to output stream in GifResourceEncoder", (Throwable)var3_3);
            }
            return false;
        }
    }

    @Override
    public String a() {
        return "";
    }

    /*
     * Exception decompiling
     */
    @Override
    public boolean a(lj<on> var1, OutputStream var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.util.ConcurrentModificationException
        // java.util.LinkedList$ReverseLinkIterator.next(LinkedList.java:217)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.extractLabelledBlocks(Block.java:212)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:485)
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

    static class a {
        a() {
        }

        public kd a(kd.a a2) {
            return new kd(a2);
        }

        public kg a() {
            return new kg();
        }

        public lj<Bitmap> a(Bitmap bitmap, ln ln2) {
            return new nr(bitmap, ln2);
        }

        public kh b() {
            return new kh();
        }
    }

}

