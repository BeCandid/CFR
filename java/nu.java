/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.graphics.Rect
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 *  com.bumptech.glide.load.DecodeFormat
 *  com.bumptech.glide.load.resource.bitmap.ImageHeaderParser
 *  com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$ImageType
 *  com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Enum
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.EnumSet
 *  java.util.Queue
 *  java.util.Set
 */
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.resource.bitmap.ImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.EnumSet;
import java.util.Queue;
import java.util.Set;

public abstract class nu
implements np<InputStream> {
    public static final nu a;
    public static final nu b;
    public static final nu c;
    private static final Set<ImageHeaderParser.ImageType> d;
    private static final Queue<BitmapFactory.Options> e;

    static {
        d = EnumSet.of((Enum)ImageHeaderParser.ImageType.b, (Enum)ImageHeaderParser.ImageType.c, (Enum)ImageHeaderParser.ImageType.d);
        e = ri.a(0);
        a = new nu(){

            @Override
            protected int a(int n2, int n3, int n4, int n5) {
                return Math.min((int)(n3 / n5), (int)(n2 / n4));
            }

            @Override
            public String a() {
                return "AT_LEAST.com.bumptech.glide.load.data.bitmap";
            }
        };
        b = new nu(){

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            @Override
            protected int a(int n2, int n3, int n4, int n5) {
                int n6 = 1;
                int n7 = (int)Math.ceil((double)Math.max((float)((float)n3 / (float)n5), (float)((float)n2 / (float)n4)));
                int n8 = Math.max((int)n6, (int)Integer.highestOneBit((int)n7));
                if (n8 < n7) {
                    do {
                        return n8 << n6;
                        break;
                    } while (true);
                }
                n6 = 0;
                return n8 << n6;
            }

            @Override
            public String a() {
                return "AT_MOST.com.bumptech.glide.load.data.bitmap";
            }
        };
        c = new nu(){

            @Override
            protected int a(int n2, int n3, int n4, int n5) {
                return 0;
            }

            @Override
            public String a() {
                return "NONE.com.bumptech.glide.load.data.bitmap";
            }
        };
    }

    /*
     * Enabled aggressive block sorting
     */
    private int a(int n2, int n3, int n4, int n5, int n6) {
        int n7;
        int n8 = n6 == Integer.MIN_VALUE ? n4 : n6;
        int n9 = n5 == Integer.MIN_VALUE ? n3 : n5;
        int n10 = n2 == 90 || n2 == 270 ? this.a(n4, n3, n9, n8) : this.a(n3, n4, n9, n8);
        if (n10 == 0) {
            n7 = 0;
            return Math.max((int)1, (int)n7);
        }
        n7 = Integer.highestOneBit((int)n10);
        return Math.max((int)1, (int)n7);
    }

    /*
     * Exception decompiling
     */
    private static Bitmap.Config a(InputStream var0_1, DecodeFormat var1) {
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

    private Bitmap a(rg rg2, RecyclableBufferedInputStream recyclableBufferedInputStream, BitmapFactory.Options options, ln ln2, int n2, int n3, int n4, DecodeFormat decodeFormat) {
        Bitmap.Config config = nu.a((InputStream)rg2, decodeFormat);
        options.inSampleSize = n4;
        options.inPreferredConfig = config;
        if ((options.inSampleSize == 1 || 19 <= Build.VERSION.SDK_INT) && nu.a((InputStream)rg2)) {
            nu.a(options, ln2.b((int)Math.ceil((double)((double)n2 / (double)n4)), (int)Math.ceil((double)((double)n3 / (double)n4)), config));
        }
        return nu.b(rg2, recyclableBufferedInputStream, options);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void a(BitmapFactory.Options options) {
        Queue<BitmapFactory.Options> queue;
        nu.b(options);
        Queue<BitmapFactory.Options> queue2 = queue = e;
        synchronized (queue2) {
            e.offer((Object)options);
            return;
        }
    }

    @TargetApi(value=11)
    private static void a(BitmapFactory.Options options, Bitmap bitmap) {
        if (11 <= Build.VERSION.SDK_INT) {
            options.inBitmap = bitmap;
        }
    }

    /*
     * Exception decompiling
     */
    private static boolean a(InputStream var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.util.ConcurrentModificationException
        // java.util.LinkedList$ReverseLinkIterator.next(LinkedList.java:217)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.extractLabelledBlocks(Block.java:212)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:485)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredCatch.transformStructuredChildren(StructuredCatch.java:72)
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Bitmap b(rg rg2, RecyclableBufferedInputStream recyclableBufferedInputStream, BitmapFactory.Options options) {
        if (options.inJustDecodeBounds) {
            rg2.mark(5242880);
        } else {
            recyclableBufferedInputStream.a();
        }
        Bitmap bitmap = BitmapFactory.decodeStream((InputStream)rg2, (Rect)null, (BitmapFactory.Options)options);
        try {
            if (!options.inJustDecodeBounds) return bitmap;
            {
                rg2.reset();
                return bitmap;
            }
        }
        catch (IOException var4_4) {
            if (!Log.isLoggable((String)"Downsampler", (int)6)) return bitmap;
            Log.e((String)"Downsampler", (String)("Exception loading inDecodeBounds=" + options.inJustDecodeBounds + " sample=" + options.inSampleSize), (Throwable)var4_4);
            return bitmap;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    @TargetApi(value=11)
    private static BitmapFactory.Options b() {
        Queue<BitmapFactory.Options> queue;
        reference var4 = nu.class;
        // MONITORENTER : nu.class
        Queue<BitmapFactory.Options> queue2 = queue = e;
        // MONITORENTER : queue2
        BitmapFactory.Options options = (BitmapFactory.Options)e.poll();
        // MONITOREXIT : queue2
        if (options == null) {
            options = new BitmapFactory.Options();
            nu.b(options);
        }
        // MONITOREXIT : var4
        return options;
    }

    @TargetApi(value=11)
    private static void b(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        if (11 <= Build.VERSION.SDK_INT) {
            options.inBitmap = null;
            options.inMutable = true;
        }
    }

    protected abstract int a(int var1, int var2, int var3, int var4);

    /*
     * Exception decompiling
     */
    public Bitmap a(InputStream var1_4, ln var2_5, int var3_2, int var4_3, DecodeFormat var5_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.util.ConcurrentModificationException
        // java.util.LinkedList$ReverseLinkIterator.next(LinkedList.java:217)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.extractLabelledBlocks(Block.java:212)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:485)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredCatch.transformStructuredChildren(StructuredCatch.java:72)
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

    public int[] a(rg rg2, RecyclableBufferedInputStream recyclableBufferedInputStream, BitmapFactory.Options options) {
        options.inJustDecodeBounds = true;
        nu.b(rg2, recyclableBufferedInputStream, options);
        options.inJustDecodeBounds = false;
        int[] arrn = new int[]{options.outWidth, options.outHeight};
        return arrn;
    }

}

