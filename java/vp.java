/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.BufferedOutputStream
 *  java.io.File
 *  java.io.FileNotFoundException
 *  java.io.FileOutputStream
 *  java.io.FilenameFilter
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Class
 *  java.lang.Comparable
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 *  java.lang.UnsupportedOperationException
 *  java.util.concurrent.atomic.AtomicLong
 *  org.json.JSONException
 *  org.json.JSONObject
 *  org.json.JSONTokener
 */
import com.facebook.LoggingBehavior;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class vp {
    static final String a = vp.class.getSimpleName();
    private static final AtomicLong b = new AtomicLong();
    private final String c;
    private final d d;
    private final File e;
    private boolean f;
    private boolean g;
    private final Object h;
    private AtomicLong i = new AtomicLong(0);

    public vp(String string2, d d2) {
        this.c = string2;
        this.d = d2;
        this.e = new File(ul.m(), string2);
        this.h = new Object();
        if (this.e.mkdirs() || this.e.isDirectory()) {
            a.a(this.e);
        }
    }

    private void a(String string2, File file) {
        if (!file.renameTo(new File(this.e, we.b(string2)))) {
            file.delete();
        }
        super.c();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void c() {
        Object object;
        Object object2 = object = this.h;
        synchronized (object2) {
            if (!this.f) {
                this.f = true;
                ul.d().execute(new Runnable(){

                    public void run() {
                        vp.this.d();
                    }
                });
            }
            return;
        }
    }

    /*
     * Exception decompiling
     */
    private void d() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 13[WHILELOOP]
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

    public InputStream a(String string2) throws IOException {
        return this.a(string2, (String)null);
    }

    public InputStream a(String string2, InputStream inputStream) throws IOException {
        return new c(inputStream, this.b(string2));
    }

    /*
     * Exception decompiling
     */
    public InputStream a(String var1, String var2_2) throws IOException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 9[SIMPLE_IF_TAKEN]
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

    public void a() {
        final File[] arrfile = this.e.listFiles(a.a());
        this.i.set(System.currentTimeMillis());
        if (arrfile != null) {
            ul.d().execute(new Runnable(){

                public void run() {
                    File[] arrfile2 = arrfile;
                    int n2 = arrfile2.length;
                    for (int i2 = 0; i2 < n2; ++i2) {
                        arrfile2[i2].delete();
                    }
                }
            });
        }
    }

    public OutputStream b(String string2) throws IOException {
        return this.b(string2, null);
    }

    public OutputStream b(String string2, String string3) throws IOException {
        FileOutputStream fileOutputStream;
        File file = a.b(this.e);
        file.delete();
        if (!file.createNewFile()) {
            throw new IOException("Could not create file at " + file.getAbsolutePath());
        }
        try {
            fileOutputStream = new FileOutputStream(file);
        }
        catch (FileNotFoundException var12_7) {
            vx.a(LoggingBehavior.d, 5, a, "Error creating buffer output stream: " + (Object)var12_7);
            throw new IOException(var12_7.getMessage());
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream((OutputStream)new b((OutputStream)fileOutputStream, new f(System.currentTimeMillis(), file, string2){
            final /* synthetic */ long a;
            final /* synthetic */ File b;
            final /* synthetic */ String c;

            @Override
            public void a() {
                if (this.a < vp.this.i.get()) {
                    this.b.delete();
                    return;
                }
                vp.this.a(this.c, this.b);
            }
        }), 8192);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", (Object)string2);
            if (!we.a(string3)) {
                jSONObject.put("tag", (Object)string3);
            }
            g.a((OutputStream)bufferedOutputStream, jSONObject);
            return bufferedOutputStream;
        }
        catch (JSONException var9_8) {
            vx.a(LoggingBehavior.d, 5, a, "Error creating JSON header for cache file: " + (Object)var9_8);
            throw new IOException(var9_8.getMessage());
        }
        finally {
            if (!false) {
                bufferedOutputStream.close();
            }
        }
    }

    public String toString() {
        return "{FileLruCache: tag:" + this.c + " file:" + this.e.getName() + "}";
    }

    static class a {
        private static final FilenameFilter a = new FilenameFilter(){

            public boolean accept(File file, String string2) {
                if (!string2.startsWith("buffer")) {
                    return true;
                }
                return false;
            }
        };
        private static final FilenameFilter b = new FilenameFilter(){

            public boolean accept(File file, String string2) {
                return string2.startsWith("buffer");
            }
        };

        static FilenameFilter a() {
            return a;
        }

        static void a(File file) {
            File[] arrfile = file.listFiles(a.b());
            if (arrfile != null) {
                int n2 = arrfile.length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    arrfile[i2].delete();
                }
            }
        }

        static File b(File file) {
            return new File(file, "buffer" + Long.valueOf((long)b.incrementAndGet()).toString());
        }

        static FilenameFilter b() {
            return b;
        }

    }

    static class b
    extends OutputStream {
        final OutputStream a;
        final f b;

        b(OutputStream outputStream, f f2) {
            this.a = outputStream;
            this.b = f2;
        }

        public void close() throws IOException {
            try {
                this.a.close();
                return;
            }
            finally {
                this.b.a();
            }
        }

        public void flush() throws IOException {
            this.a.flush();
        }

        public void write(int n2) throws IOException {
            this.a.write(n2);
        }

        public void write(byte[] arrby) throws IOException {
            this.a.write(arrby);
        }

        public void write(byte[] arrby, int n2, int n3) throws IOException {
            this.a.write(arrby, n2, n3);
        }
    }

    static final class c
    extends InputStream {
        final InputStream a;
        final OutputStream b;

        c(InputStream inputStream, OutputStream outputStream) {
            this.a = inputStream;
            this.b = outputStream;
        }

        public int available() throws IOException {
            return this.a.available();
        }

        public void close() throws IOException {
            try {
                this.a.close();
                return;
            }
            finally {
                this.b.close();
            }
        }

        public void mark(int n2) {
            throw new UnsupportedOperationException();
        }

        public boolean markSupported() {
            return false;
        }

        public int read() throws IOException {
            int n2 = this.a.read();
            if (n2 >= 0) {
                this.b.write(n2);
            }
            return n2;
        }

        public int read(byte[] arrby) throws IOException {
            int n2 = this.a.read(arrby);
            if (n2 > 0) {
                this.b.write(arrby, 0, n2);
            }
            return n2;
        }

        public int read(byte[] arrby, int n2, int n3) throws IOException {
            int n4 = this.a.read(arrby, n2, n3);
            if (n4 > 0) {
                this.b.write(arrby, n2, n4);
            }
            return n4;
        }

        public void reset() {
            c c2 = this;
            synchronized (c2) {
                throw new UnsupportedOperationException();
            }
        }

        public long skip(long l2) throws IOException {
            byte[] arrby = new byte[1024];
            long l3 = 0;
            int n2;
            while (l3 < l2 && (n2 = this.read(arrby, 0, (int)Math.min((long)(l2 - l3), (long)arrby.length))) >= 0) {
                l3 += (long)n2;
            }
            return l3;
        }
    }

    public static final class d {
        private int a = 1048576;
        private int b = 1024;

        int a() {
            return this.a;
        }

        int b() {
            return this.b;
        }
    }

    static final class e
    implements Comparable<e> {
        private final File a;
        private final long b;

        e(File file) {
            this.a = file;
            this.b = file.lastModified();
        }

        public int a(e e2) {
            if (this.b() < e2.b()) {
                return -1;
            }
            if (this.b() > e2.b()) {
                return 1;
            }
            return this.a().compareTo(e2.a());
        }

        File a() {
            return this.a;
        }

        long b() {
            return this.b;
        }

        public /* synthetic */ int compareTo(Object object) {
            return this.a((e)object);
        }

        public boolean equals(Object object) {
            if (object instanceof e && this.a((e)object) == 0) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 37 * (1073 + this.a.hashCode()) + (int)(this.b % Integer.MAX_VALUE);
        }
    }

    static interface f {
        public void a();
    }

    static final class g {
        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        static JSONObject a(InputStream inputStream) throws IOException {
            int n2;
            if (inputStream.read() != 0) {
                return null;
            }
            int n3 = 0;
            for (int i2 = 0; i2 < 3; ++i2) {
                int n4 = inputStream.read();
                if (n4 == -1) {
                    vx.a(LoggingBehavior.d, vp.a, "readHeader: stream.read returned -1 while reading header size");
                    return null;
                }
                n3 = (n3 << 8) + (n4 & 255);
            }
            byte[] arrby = new byte[n3];
            for (int i3 = 0; i3 < arrby.length; i3 += n2) {
                n2 = inputStream.read(arrby, i3, arrby.length - i3);
                if (n2 >= 1) continue;
                vx.a(LoggingBehavior.d, vp.a, "readHeader: stream.read stopped at " + (Object)i3 + " when expected " + arrby.length);
                return null;
            }
            JSONTokener jSONTokener = new JSONTokener(new String(arrby));
            try {
                Object object = jSONTokener.nextValue();
                if (object instanceof JSONObject) return (JSONObject)object;
                vx.a(LoggingBehavior.d, vp.a, "readHeader: expected JSONObject, got " + object.getClass().getCanonicalName());
                return null;
            }
            catch (JSONException var6_10) {
                throw new IOException(var6_10.getMessage());
            }
        }

        static void a(OutputStream outputStream, JSONObject jSONObject) throws IOException {
            byte[] arrby = jSONObject.toString().getBytes();
            outputStream.write(0);
            outputStream.write(255 & arrby.length >> 16);
            outputStream.write(255 & arrby.length >> 8);
            outputStream.write(255 & arrby.length >> 0);
            outputStream.write(arrby);
        }
    }

}

