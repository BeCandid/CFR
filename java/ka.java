/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.PrintStream
 *  java.io.Writer
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Void
 *  java.nio.charset.Charset
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.concurrent.BlockingQueue
 *  java.util.concurrent.Callable
 *  java.util.concurrent.Future
 *  java.util.concurrent.LinkedBlockingQueue
 *  java.util.concurrent.ThreadPoolExecutor
 *  java.util.concurrent.TimeUnit
 */
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ka
implements Closeable {
    final ThreadPoolExecutor a = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, (BlockingQueue)new LinkedBlockingQueue());
    private final File b;
    private final File c;
    private final File d;
    private final File e;
    private final int f;
    private long g;
    private final int h;
    private long i = 0;
    private Writer j;
    private final LinkedHashMap<String, b> k = new LinkedHashMap(0, 0.75f, true);
    private int l;
    private long m = 0;
    private final Callable<Void> n;

    private ka(File file, int n2, int n3, long l2) {
        this.n = new Callable<Void>(){

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public Void a() throws Exception {
                ka ka2;
                ka ka3 = ka2 = ka.this;
                synchronized (ka3) {
                    if (ka.this.j == null) {
                        return null;
                    }
                    ka.this.g();
                    if (ka.this.e()) {
                        ka.this.d();
                        ka.this.l = 0;
                    }
                    return null;
                }
            }

            public /* synthetic */ Object call() throws Exception {
                return this.a();
            }
        };
        this.b = file;
        this.f = n2;
        this.c = new File(file, "journal");
        this.d = new File(file, "journal.tmp");
        this.e = new File(file, "journal.bkp");
        this.h = n3;
        this.g = l2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private a a(String string2, long l2) throws IOException {
        void var17_3 = this;
        synchronized (var17_3) {
            a a2;
            super.f();
            b b2 = (b)this.k.get((Object)string2);
            if (l2 != -1) {
                a2 = null;
                if (b2 == null) return a2;
                long l3 = b2.h;
                long l4 = l3 LCMP l2;
                a2 = null;
                if (l4 != false) return a2;
            }
            if (b2 == null) {
                b2 = new b((ka)this, string2, null);
                this.k.put((Object)string2, (Object)b2);
            } else {
                a a3 = b2.g;
                if (a3 != null) {
                    return null;
                }
            }
            a2 = new a((ka)this, b2, null);
            b2.g = a2;
            this.j.append((CharSequence)"DIRTY");
            this.j.append(' ');
            this.j.append((CharSequence)string2);
            this.j.append('\n');
            this.j.flush();
            return a2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static ka a(File file, int n2, int n3, long l2) throws IOException {
        if (l2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (n3 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                ka.a(file2, file3, false);
            }
        }
        ka ka2 = new ka(file, n2, n3, l2);
        if (ka2.c.exists()) {
            try {
                ka2.b();
                ka2.c();
                return ka2;
            }
            catch (IOException var10_7) {
                System.out.println("DiskLruCache " + (Object)file + " is corrupt: " + var10_7.getMessage() + ", removing");
                ka2.a();
            }
        }
        file.mkdirs();
        ka ka3 = new ka(file, n2, n3, l2);
        ka3.d();
        return ka3;
    }

    private static void a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void a(File file, File file2, boolean bl2) throws IOException {
        if (bl2) {
            ka.a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void a(a var1, boolean var2_2) throws IOException {
        var31_3 = this;
        // MONITORENTER : var31_3
        var4_4 = a.a(var1);
        if (b.a(var4_4) != var1) {
            throw new IllegalStateException();
        }
        if (var2_2 && !b.d(var4_4)) {
            for (var30_5 = 0; var30_5 < this.h; ++var30_5) {
                if (!a.b(var1)[var30_5]) {
                    var1.b();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + var30_5);
                }
                if (var4_4.b(var30_5).exists()) continue;
                var1.b();
                return;
            }
        }
        var5_6 = 0;
        ** GOTO lbl19
        do {
            // MONITOREXIT : var31_3
            return;
            break;
        } while (true);
lbl19: // 1 sources:
        do {
            if (var5_6 < this.h) {
                var23_8 = var4_4.b(var5_6);
                if (var2_2) {
                    if (var23_8.exists()) {
                        var24_10 = var4_4.a(var5_6);
                        var23_8.renameTo(var24_10);
                        var26_7 = b.b(var4_4)[var5_6];
                        b.b((b)var4_4)[var5_6] = var28_9 = var24_10.length();
                        this.i = var28_9 + (this.i - var26_7);
                    }
                } else {
                    ka.a(var23_8);
                }
            } else {
                this.l = 1 + this.l;
                b.a(var4_4, null);
                if (var2_2 | b.d(var4_4)) {
                    b.a(var4_4, true);
                    this.j.append((CharSequence)"CLEAN");
                    this.j.append(' ');
                    this.j.append((CharSequence)b.c(var4_4));
                    this.j.append((CharSequence)var4_4.a());
                    this.j.append('\n');
                    if (var2_2) {
                        var19_11 = this.m;
                        this.m = 1 + var19_11;
                        b.a(var4_4, var19_11);
                    }
                } else {
                    this.k.remove((Object)b.c(var4_4));
                    this.j.append((CharSequence)"REMOVE");
                    this.j.append(' ');
                    this.j.append((CharSequence)b.c(var4_4));
                    this.j.append('\n');
                }
                this.j.flush();
                if (this.i <= this.g && !super.e()) ** continue;
                this.a.submit(this.n);
                return;
            }
            ++var5_6;
        } while (true);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void b() throws IOException {
        var1_1 = new kb((InputStream)new FileInputStream(this.c), kc.a);
        var3_2 = var1_1.a();
        var4_3 = var1_1.a();
        var5_4 = var1_1.a();
        var6_5 = var1_1.a();
        var7_6 = var1_1.a();
        if ("libcore.io.DiskLruCache".equals((Object)var3_2) == false) throw new IOException("unexpected journal header: [" + var3_2 + ", " + var4_3 + ", " + var6_5 + ", " + var7_6 + "]");
        if ("1".equals((Object)var4_3) == false) throw new IOException("unexpected journal header: [" + var3_2 + ", " + var4_3 + ", " + var6_5 + ", " + var7_6 + "]");
        if (Integer.toString((int)this.f).equals((Object)var5_4) == false) throw new IOException("unexpected journal header: [" + var3_2 + ", " + var4_3 + ", " + var6_5 + ", " + var7_6 + "]");
        if (Integer.toString((int)this.h).equals((Object)var6_5) == false) throw new IOException("unexpected journal header: [" + var3_2 + ", " + var4_3 + ", " + var6_5 + ", " + var7_6 + "]");
        if (!"".equals((Object)var7_6)) {
            throw new IOException("unexpected journal header: [" + var3_2 + ", " + var4_3 + ", " + var6_5 + ", " + var7_6 + "]");
        }
        ** GOTO lbl18
        finally {
            kc.a(var1_1);
        }
lbl18: // 1 sources:
        var8_8 = 0;
        do {
            this.d(var1_1.a());
            ++var8_8;
        } while (true);
    }

    private void c() throws IOException {
        ka.a(this.d);
        Iterator iterator = this.k.values().iterator();
        while (iterator.hasNext()) {
            b b2 = (b)iterator.next();
            if (b2.g == null) {
                for (int i2 = 0; i2 < this.h; ++i2) {
                    this.i += b2.e[i2];
                }
                continue;
            }
            b2.g = null;
            for (int i3 = 0; i3 < this.h; ++i3) {
                ka.a(b2.a(i3));
                ka.a(b2.b(i3));
            }
            iterator.remove();
        }
    }

    /*
     * Exception decompiling
     */
    private void d() throws IOException {
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
     */
    private void d(String string2) throws IOException {
        String string3;
        b b2;
        int n2 = string2.indexOf(32);
        if (n2 == -1) {
            throw new IOException("unexpected journal line: " + string2);
        }
        int n3 = n2 + 1;
        int n4 = string2.indexOf(32, n3);
        if (n4 == -1) {
            string3 = string2.substring(n3);
            if (n2 == "REMOVE".length() && string2.startsWith("REMOVE")) {
                this.k.remove((Object)string3);
                return;
            }
        } else {
            string3 = string2.substring(n3, n4);
        }
        if ((b2 = (b)this.k.get((Object)string3)) == null) {
            b2 = new b((ka)this, string3, null);
            this.k.put((Object)string3, (Object)b2);
        }
        if (n4 != -1 && n2 == "CLEAN".length() && string2.startsWith("CLEAN")) {
            String[] arrstring = string2.substring(n4 + 1).split(" ");
            b2.f = true;
            b2.g = null;
            b2.a(arrstring);
            return;
        }
        if (n4 == -1 && n2 == "DIRTY".length() && string2.startsWith("DIRTY")) {
            b2.g = new a((ka)this, b2, null);
            return;
        }
        if (n4 == -1 && n2 == "READ".length() && string2.startsWith("READ")) return;
        {
            throw new IOException("unexpected journal line: " + string2);
        }
    }

    private boolean e() {
        if (this.l >= 2000 && this.l >= this.k.size()) {
            return true;
        }
        return false;
    }

    private void f() {
        if (this.j == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private void g() throws IOException {
        while (this.i > this.g) {
            this.c((String)((Map.Entry)this.k.entrySet().iterator().next()).getKey());
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public c a(String string2) throws IOException {
        void var15_2 = this;
        synchronized (var15_2) {
            super.f();
            b b2 = (b)this.k.get((Object)string2);
            c c2 = null;
            if (b2 == null) return c2;
            boolean bl2 = b2.f;
            c2 = null;
            if (!bl2) return c2;
            File[] arrfile = b2.a;
            int n2 = arrfile.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                boolean bl3 = arrfile[i2].exists();
                c2 = null;
                if (!bl3) return c2;
            }
            this.l = 1 + this.l;
            this.j.append((CharSequence)"READ");
            this.j.append(' ');
            this.j.append((CharSequence)string2);
            this.j.append('\n');
            if (!super.e()) return (ka)this.new c(string2, b2.h, b2.a, b2.e);
            this.a.submit(this.n);
            return (ka)this.new c(string2, b2.h, b2.a, b2.e);
        }
    }

    public void a() throws IOException {
        this.close();
        kc.a(this.b);
    }

    public a b(String string2) throws IOException {
        return super.a(string2, -1);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean c(String string2) throws IOException {
        void var14_2 = this;
        synchronized (var14_2) {
            super.f();
            b b2 = (b)this.k.get((Object)string2);
            if (b2 == null) return false;
            a a2 = b2.g;
            if (a2 != null) {
                return false;
            }
            for (int i2 = 0; i2 < this.h; this.i -= b.b((b)b2)[i2], ++i2) {
                File file = b2.a(i2);
                if (file.exists() && !file.delete()) {
                    throw new IOException("failed to delete " + (Object)file);
                }
                b.b((b)b2)[i2] = 0;
            }
            this.l = 1 + this.l;
            this.j.append((CharSequence)"REMOVE");
            this.j.append(' ');
            this.j.append((CharSequence)string2);
            this.j.append('\n');
            this.k.remove((Object)string2);
            if (!super.e()) return true;
            this.a.submit(this.n);
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void close() throws IOException {
        ka ka2 = this;
        synchronized (ka2) {
            Writer writer = this.j;
            if (writer != null) {
                for (b b2 : new ArrayList(this.k.values())) {
                    if (b2.g == null) continue;
                    b2.g.b();
                }
                this.g();
                this.j.close();
                this.j = null;
            }
            return;
        }
    }

    public final class a {
        final /* synthetic */ ka a;
        private final b b;
        private final boolean[] c;
        private boolean d;

        /*
         * Enabled aggressive block sorting
         */
        private a(ka ka2, b b2) {
            this.a = ka2;
            this.b = b2;
            Object var3_3 = b2.f ? null : new boolean[ka2.h];
            this.c = var3_3;
        }

        /* synthetic */ a(ka ka2, b b2,  var3_2) {
            super(ka2, b2);
        }

        static /* synthetic */ b a(a a2) {
            return a2.b;
        }

        static /* synthetic */ boolean[] b(a a2) {
            return a2.c;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public File a(int n2) throws IOException {
            ka ka2;
            ka ka3 = ka2 = this.a;
            synchronized (ka3) {
                if (this.b.g != this) {
                    throw new IllegalStateException();
                }
                if (!this.b.f) {
                    this.c[n2] = true;
                }
                File file = this.b.b(n2);
                if (!this.a.b.exists()) {
                    this.a.b.mkdirs();
                }
                return file;
            }
        }

        public void a() throws IOException {
            this.a.a(this, true);
            this.d = true;
        }

        public void b() throws IOException {
            this.a.a(this, false);
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public void c() {
            if (this.d) return;
            try {
                this.b();
                return;
            }
            catch (IOException var1_1) {
                return;
            }
        }
    }

    final class b {
        File[] a;
        File[] b;
        final /* synthetic */ ka c;
        private final String d;
        private final long[] e;
        private boolean f;
        private a g;
        private long h;

        private b(ka ka2, String string2) {
            this.c = ka2;
            this.d = string2;
            this.e = new long[ka2.h];
            this.a = new File[ka2.h];
            this.b = new File[ka2.h];
            StringBuilder stringBuilder = new StringBuilder(string2).append('.');
            int n2 = stringBuilder.length();
            for (int i2 = 0; i2 < ka2.h; ++i2) {
                stringBuilder.append(i2);
                this.a[i2] = new File(ka2.b, stringBuilder.toString());
                stringBuilder.append(".tmp");
                this.b[i2] = new File(ka2.b, stringBuilder.toString());
                stringBuilder.setLength(n2);
            }
        }

        /* synthetic */ b(ka ka2, String string2,  var3_2) {
            super(ka2, string2);
        }

        static /* synthetic */ long a(b b2, long l2) {
            b2.h = l2;
            return l2;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        private void a(String[] arrstring) throws IOException {
            if (arrstring.length != this.c.h) {
                throw super.b(arrstring);
            }
            try {
                for (int i2 = 0; i2 < arrstring.length; ++i2) {
                    this.e[i2] = Long.parseLong((String)arrstring[i2]);
                }
                return;
            }
            catch (NumberFormatException var3_3) {
                throw super.b(arrstring);
            }
        }

        private IOException b(String[] arrstring) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString((Object[])arrstring));
        }

        static /* synthetic */ String c(b b2) {
            return b2.d;
        }

        public File a(int n2) {
            return this.a[n2];
        }

        public String a() throws IOException {
            StringBuilder stringBuilder = new StringBuilder();
            for (long l2 : this.e) {
                stringBuilder.append(' ').append(l2);
            }
            return stringBuilder.toString();
        }

        public File b(int n2) {
            return this.b[n2];
        }
    }

    public final class c {
        private final String b;
        private final long c;
        private final long[] d;
        private final File[] e;

        private c(String string2, long l2, File[] arrfile, long[] arrl) {
            this.b = string2;
            this.c = l2;
            this.e = arrfile;
            this.d = arrl;
        }

        public File a(int n2) {
            return this.e[n2];
        }
    }

}

