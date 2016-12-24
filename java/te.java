/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.app.ActivityManager$RunningAppProcessInfo
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.os.Build
 *  android.os.Environment
 *  android.os.StatFs
 *  com.crashlytics.android.core.CodedOutputStream
 *  io.fabric.sdk.android.services.common.CommonUtils
 *  io.fabric.sdk.android.services.common.DeliveryMechanism
 *  io.fabric.sdk.android.services.common.IdManager
 *  java.io.Closeable
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.FilenameFilter
 *  java.io.Flushable
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Runtime
 *  java.lang.StackTraceElement
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.Thread$UncaughtExceptionHandler
 *  java.lang.Throwable
 *  java.lang.Void
 *  java.util.Arrays
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.Date
 *  java.util.HashSet
 *  java.util.LinkedList
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.TreeMap
 *  java.util.concurrent.Callable
 *  java.util.concurrent.Future
 *  java.util.concurrent.atomic.AtomicBoolean
 *  java.util.concurrent.atomic.AtomicInteger
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import com.crashlytics.android.core.CodedOutputStream;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.DeliveryMechanism;
import io.fabric.sdk.android.services.common.IdManager;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class te
implements Thread.UncaughtExceptionHandler {
    static final FilenameFilter a = new FilenameFilter(){

        public boolean accept(File file, String string2) {
            if (string2.length() == 35 + ".cls".length() && string2.endsWith(".cls")) {
                return true;
            }
            return false;
        }
    };
    static final Comparator<File> b = new Comparator<File>(){

        public int a(File file, File file2) {
            return file2.getName().compareTo(file.getName());
        }

        public /* synthetic */ int compare(Object object, Object object2) {
            return this.a((File)object, (File)object2);
        }
    };
    static final Comparator<File> c = new Comparator<File>(){

        public int a(File file, File file2) {
            return file.getName().compareTo(file2.getName());
        }

        public /* synthetic */ int compare(Object object, Object object2) {
            return this.a((File)object, (File)object2);
        }
    };
    static final FilenameFilter d = new FilenameFilter(){

        public boolean accept(File file, String string2) {
            return e.matcher((CharSequence)string2).matches();
        }
    };
    private static final Pattern e = Pattern.compile((String)"([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");
    private static final Map<String, String> f = Collections.singletonMap((Object)"X-CRASHLYTICS-SEND-FLAGS", (Object)"1");
    private static final String[] g = new String[]{"SessionUser", "SessionApp", "SessionOS", "SessionDevice"};
    private final AtomicInteger h = new AtomicInteger(0);
    private final Thread.UncaughtExceptionHandler i;
    private final ang j;
    private final AtomicBoolean k;
    private final ta l;
    private final IdManager m;
    private final sz n;
    private final tl o;
    private final ti p;
    private final String q;

    te(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, ta ta2, IdManager idManager, tv tv2, ang ang2, sz sz2) {
        this.i = uncaughtExceptionHandler;
        this.l = ta2;
        this.m = idManager;
        this.n = sz2;
        this.q = tv2.a();
        this.j = ang2;
        this.k = new AtomicBoolean(false);
        Context context = sz2.E();
        this.o = new tl(context, ang2);
        this.p = new ti(context);
    }

    private String a(File file) {
        return file.getName().substring(0, 35);
    }

    private void a(int n2) {
        HashSet hashSet = new HashSet();
        File[] arrfile = super.n();
        int n3 = Math.min((int)n2, (int)arrfile.length);
        for (int i2 = 0; i2 < n3; ++i2) {
            hashSet.add((Object)super.a(arrfile[i2]));
        }
        this.o.a((Set<String>)hashSet);
        for (File file : super.a(new a(null))) {
            String string2 = file.getName();
            Matcher matcher = e.matcher((CharSequence)string2);
            matcher.matches();
            if (hashSet.contains((Object)matcher.group(1))) continue;
            akx.h().a("CrashlyticsCore", "Trimming open session file: " + string2);
            file.delete();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void a(CodedOutputStream codedOutputStream, File file) throws IOException {
        FileInputStream fileInputStream;
        if (!file.exists()) {
            akx.h().e("CrashlyticsCore", "Tried to include a file that doesn't exist: " + file.getName(), null);
            return;
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
        }
        catch (Throwable var4_4) {}
        try {
            te.a((InputStream)fileInputStream, codedOutputStream, (int)file.length());
        }
        catch (Throwable var4_6) {
            fileInputStream2 = fileInputStream;
        }
        CommonUtils.a((Closeable)fileInputStream, (String)"Failed to close file input stream.");
        return;
        {
            void var4_5;
            CommonUtils.a((Closeable)fileInputStream2, (String)"Failed to close file input stream.");
            throw var4_5;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(CodedOutputStream codedOutputStream, String string2) throws IOException {
        String[] arrstring = g;
        int n2 = arrstring.length;
        int n3 = 0;
        while (n3 < n2) {
            String string3 = arrstring[n3];
            File[] arrfile = super.a(new b(string2 + string3));
            if (arrfile.length == 0) {
                akx.h().e("CrashlyticsCore", "Can't find " + string3 + " data for session ID " + string2, null);
            } else {
                akx.h().a("CrashlyticsCore", "Collecting " + string3 + " data for session ID " + string2);
                te.a(codedOutputStream, arrfile[0]);
            }
            ++n3;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(CodedOutputStream codedOutputStream, Date date, Thread thread, Throwable throwable, String string2, boolean bl2) throws Exception {
        Thread[] arrthread;
        TreeMap treeMap;
        Context context = this.n.E();
        long l2 = date.getTime() / 1000;
        float f2 = CommonUtils.c((Context)context);
        int n2 = CommonUtils.a((Context)context, (boolean)this.p.a());
        boolean bl3 = CommonUtils.d((Context)context);
        int n3 = context.getResources().getConfiguration().orientation;
        long l3 = CommonUtils.b() - CommonUtils.b((Context)context);
        long l4 = CommonUtils.b((String)Environment.getDataDirectory().getPath());
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = CommonUtils.a((String)context.getPackageName(), (Context)context);
        LinkedList linkedList = new LinkedList();
        StackTraceElement[] arrstackTraceElement = throwable.getStackTrace();
        String string3 = this.n.n();
        String string4 = this.m.c();
        if (bl2) {
            Map map = Thread.getAllStackTraces();
            arrthread = new Thread[map.size()];
            int n4 = 0;
            for (Map.Entry entry : map.entrySet()) {
                arrthread[n4] = (Thread)entry.getKey();
                linkedList.add(entry.getValue());
                ++n4;
            }
        } else {
            arrthread = new Thread[]{};
        }
        if (!CommonUtils.a((Context)context, (String)"com.crashlytics.CollectCustomKeys", (boolean)true)) {
            treeMap = new TreeMap();
        } else {
            treeMap = this.n.g();
            if (treeMap != null && treeMap.size() > 1) {
                TreeMap treeMap2;
                treeMap = treeMap2 = new TreeMap(treeMap);
            }
        }
        tt.a(codedOutputStream, l2, string2, throwable, thread, arrstackTraceElement, arrthread, linkedList, treeMap, this.o, runningAppProcessInfo, n3, string4, string3, f2, n2, bl3, l3, l4);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void a(CodedOutputStream codedOutputStream, File[] arrfile, String string2) {
        Arrays.sort((Object[])arrfile, (Comparator)CommonUtils.a);
        int n2 = arrfile.length;
        int n3 = 0;
        while (n3 < n2) {
            File file = arrfile[n3];
            try {
                alf alf2 = akx.h();
                Locale locale = Locale.US;
                Object[] arrobject = new Object[]{string2, file.getName()};
                alf2.a("CrashlyticsCore", String.format((Locale)locale, (String)"Found Non Fatal for session ID %s in %s ", (Object[])arrobject));
                te.a(codedOutputStream, file);
            }
            catch (Exception var6_9) {
                akx.h().e("CrashlyticsCore", "Error writting non-fatal to session.", (Throwable)var6_9);
            }
            ++n3;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(File file, String string2, int n2) {
        akx.h().a("CrashlyticsCore", "Collecting session parts for ID " + string2);
        File[] arrfile = super.a(new b(string2 + "SessionCrash"));
        boolean bl2 = arrfile != null && arrfile.length > 0;
        alf alf2 = akx.h();
        Locale locale = Locale.US;
        Object[] arrobject = new Object[]{string2, bl2};
        alf2.a("CrashlyticsCore", String.format((Locale)locale, (String)"Session %s has fatal exception: %s", (Object[])arrobject));
        File[] arrfile2 = super.a(new b(string2 + "SessionEvent"));
        boolean bl3 = arrfile2 != null && arrfile2.length > 0;
        alf alf3 = akx.h();
        Locale locale2 = Locale.US;
        Object[] arrobject2 = new Object[]{string2, bl3};
        alf3.a("CrashlyticsCore", String.format((Locale)locale2, (String)"Session %s has non-fatal exceptions: %s", (Object[])arrobject2));
        if (bl2 || bl3) {
            File[] arrfile3 = super.a(string2, arrfile2, n2);
            File file2 = bl2 ? arrfile[0] : null;
            super.a(file, string2, arrfile3, file2);
        } else {
            akx.h().a("CrashlyticsCore", "No events present for session ID " + string2);
        }
        akx.h().a("CrashlyticsCore", "Removing session part files for ID " + string2);
        super.a(string2);
    }

    /*
     * Exception decompiling
     */
    private void a(File var1_1, String var2_4, File[] var3_3, File var4) {
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

    private static void a(InputStream inputStream, CodedOutputStream codedOutputStream, int n2) throws IOException {
        int n3;
        byte[] arrby = new byte[n2];
        for (int i2 = 0; i2 < arrby.length && (n3 = inputStream.read(arrby, i2, arrby.length - i2)) >= 0; i2 += n3) {
        }
        codedOutputStream.a(arrby);
    }

    private void a(String string2) {
        File[] arrfile = super.b(string2);
        int n2 = arrfile.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            arrfile[i2].delete();
        }
    }

    private void a(String string2, int n2) {
        tx.a(super.q(), new b(string2 + "SessionEvent"), n2, c);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(String string2, Date date) throws Exception {
        sy sy2;
        sy sy3 = null;
        CodedOutputStream codedOutputStream = null;
        try {
            sy2 = new sy(super.q(), string2 + "BeginSession");
        }
        catch (Throwable var6_8) {}
        try {
            codedOutputStream = CodedOutputStream.a((OutputStream)sy2);
            Locale locale = Locale.US;
            Object[] arrobject = new Object[]{this.n.a()};
            tt.a(codedOutputStream, string2, String.format((Locale)locale, (String)"Crashlytics Android SDK/%s", (Object[])arrobject), date.getTime() / 1000);
        }
        catch (Throwable var6_10) {
            sy3 = sy2;
        }
        CommonUtils.a((Flushable)codedOutputStream, (String)"Failed to flush to session begin file.");
        CommonUtils.a((Closeable)sy2, (String)"Failed to close begin session file.");
        return;
        {
            void var6_9;
            CommonUtils.a((Flushable)codedOutputStream, (String)"Failed to flush to session begin file.");
            CommonUtils.a((Closeable)sy3, (String)"Failed to close begin session file.");
            throw var6_9;
        }
    }

    private void a(Date date, Thread thread, Throwable throwable) throws Exception {
        this.n.A();
        super.b(date, thread, throwable);
        this.d();
        super.l();
        this.f();
        if (!this.n.x()) {
            super.p();
        }
    }

    private void a(sy sy2) {
        if (sy2 == null) {
            return;
        }
        try {
            sy2.a();
            return;
        }
        catch (IOException var2_2) {
            akx.h().e("CrashlyticsCore", "Error closing session file stream in the presence of an exception", (Throwable)var2_2);
            return;
        }
    }

    /*
     * Exception decompiling
     */
    private void a(ud var1) throws IOException {
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
    private void a(boolean bl2) throws Exception {
        int n2 = bl2 ? 1 : 0;
        super.a(n2 + 8);
        File[] arrfile = super.n();
        if (arrfile.length <= n2) {
            akx.h().a("CrashlyticsCore", "No open sessions to be closed.");
            return;
        }
        super.f(super.a(arrfile[n2]));
        anz anz2 = sz.B();
        if (anz2 == null) {
            akx.h().a("CrashlyticsCore", "Unable to close session. Settings are not loaded.");
            return;
        }
        super.a(arrfile, n2, anz2.c);
    }

    private void a(File[] arrfile, int n2, int n3) {
        akx.h().a("CrashlyticsCore", "Closing open sessions.");
        for (int i2 = n2; i2 < arrfile.length; ++i2) {
            File file = arrfile[i2];
            String string2 = super.a(file);
            akx.h().a("CrashlyticsCore", "Closing session: " + string2);
            super.a(file, string2, n3);
        }
    }

    private File[] a(FilenameFilter filenameFilter) {
        return super.b(super.q().listFiles(filenameFilter));
    }

    private File[] a(String string2, File[] arrfile, int n2) {
        if (arrfile.length > n2) {
            alf alf2 = akx.h();
            Locale locale = Locale.US;
            Object[] arrobject = new Object[]{n2};
            alf2.a("CrashlyticsCore", String.format((Locale)locale, (String)"Trimming down to %d logged exceptions.", (Object[])arrobject));
            super.a(string2, n2);
            arrfile = super.a(new b(string2 + "SessionEvent"));
        }
        return arrfile;
    }

    /*
     * Exception decompiling
     */
    private void b(Date var1, Thread var2_3, Throwable var3_2) {
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

    private File[] b(String string2) {
        return super.a(new d(string2));
    }

    private File[] b(File[] arrfile) {
        if (arrfile == null) {
            arrfile = new File[]{};
        }
        return arrfile;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void c(String string2) throws Exception {
        sy sy2;
        sy sy3 = null;
        CodedOutputStream codedOutputStream = null;
        try {
            sy2 = new sy(super.q(), string2 + "SessionApp");
        }
        catch (Throwable var5_5) {}
        try {
            codedOutputStream = CodedOutputStream.a((OutputStream)sy2);
            tt.a(codedOutputStream, this.m.c(), this.n.i(), this.n.l(), this.n.k(), this.m.b(), DeliveryMechanism.a((String)this.n.j()).a(), this.q);
        }
        catch (Throwable var5_7) {
            sy3 = sy2;
        }
        CommonUtils.a((Flushable)codedOutputStream, (String)"Failed to flush to session app file.");
        CommonUtils.a((Closeable)sy2, (String)"Failed to close session app file.");
        return;
        {
            void var5_6;
            CommonUtils.a((Flushable)codedOutputStream, (String)"Failed to flush to session app file.");
            CommonUtils.a((Closeable)sy3, (String)"Failed to close session app file.");
            throw var5_6;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void c(Date var1, Thread var2_3, Throwable var3_2) {
        var4_4 = super.j();
        if (var4_4 == null) {
            akx.h().e("CrashlyticsCore", "Tried to write a non-fatal exception while no session was open.", null);
            return;
        }
        sz.a(var4_4, var3_2.getClass().getName());
        var5_5 = null;
        var6_6 = null;
        akx.h().a("CrashlyticsCore", "Crashlytics is logging non-fatal exception \"" + (Object)var3_2 + "\" from thread " + var2_3.getName());
        var10_7 = CommonUtils.a((int)this.h.getAndIncrement());
        var11_8 = var4_4 + "SessionEvent" + var10_7;
        var12_9 = new sy(super.q(), var11_8);
        try {
            var6_6 = CodedOutputStream.a((OutputStream)var12_9);
            super.a(var6_6, var1, var2_3, var3_2, "error", false);
        }
        catch (Throwable var7_16) {
            var5_5 = var12_9;
            ** GOTO lbl-1000
        }
        catch (Exception var8_13) {
            var5_5 = var12_9;
        }
        CommonUtils.a((Flushable)var6_6, (String)"Failed to flush to non-fatal file.");
        CommonUtils.a((Closeable)var12_9, (String)"Failed to close non-fatal file output stream.");
        ** GOTO lbl34
        catch (Exception var8_11) {}
        {
            try {
                akx.h().e("CrashlyticsCore", "An error occurred in the non-fatal exception logger", (Throwable)var8_12);
            }
            catch (Throwable var7_14) lbl-1000: // 2 sources:
            {
                CommonUtils.a((Flushable)var6_6, (String)"Failed to flush to non-fatal file.");
                CommonUtils.a((Closeable)var5_5, (String)"Failed to close non-fatal file output stream.");
                throw var7_15;
            }
            CommonUtils.a((Flushable)var6_6, (String)"Failed to flush to non-fatal file.");
            CommonUtils.a((Closeable)var5_5, (String)"Failed to close non-fatal file output stream.");
lbl34: // 2 sources:
            try {
                super.a(var4_4, 64);
                return;
            }
            catch (Exception var9_10) {
                akx.h().e("CrashlyticsCore", "An error occurred when trimming non-fatal files.", (Throwable)var9_10);
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void d(String string2) throws Exception {
        sy sy2;
        sy sy3 = null;
        CodedOutputStream codedOutputStream = null;
        try {
            sy2 = new sy(super.q(), string2 + "SessionOS");
        }
        catch (Throwable var5_5) {}
        try {
            codedOutputStream = CodedOutputStream.a((OutputStream)sy2);
            tt.a(codedOutputStream, CommonUtils.g((Context)this.n.E()));
        }
        catch (Throwable var5_7) {
            sy3 = sy2;
        }
        CommonUtils.a((Flushable)codedOutputStream, (String)"Failed to flush to session OS file.");
        CommonUtils.a((Closeable)sy2, (String)"Failed to close session OS file.");
        return;
        {
            void var5_6;
            CommonUtils.a((Flushable)codedOutputStream, (String)"Failed to flush to session OS file.");
            CommonUtils.a((Closeable)sy3, (String)"Failed to close session OS file.");
            throw var5_6;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void e(String string2) throws Exception {
        sy sy2;
        sy sy3 = null;
        CodedOutputStream codedOutputStream = null;
        try {
            sy2 = new sy(super.q(), string2 + "SessionDevice");
        }
        catch (Throwable var5_15) {}
        try {
            codedOutputStream = CodedOutputStream.a((OutputStream)sy2);
            Context context = this.n.E();
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            String string3 = this.m.h();
            int n2 = CommonUtils.a();
            int n3 = Runtime.getRuntime().availableProcessors();
            long l2 = CommonUtils.b();
            long l3 = (long)statFs.getBlockCount() * (long)statFs.getBlockSize();
            boolean bl2 = CommonUtils.f((Context)context);
            Map map = this.m.i();
            int n4 = CommonUtils.h((Context)context);
            tt.a(codedOutputStream, string3, n2, Build.MODEL, n3, l2, l3, bl2, map, n4, Build.MANUFACTURER, Build.PRODUCT);
        }
        catch (Throwable var5_17) {
            sy3 = sy2;
        }
        CommonUtils.a((Flushable)codedOutputStream, (String)"Failed to flush session device info.");
        CommonUtils.a((Closeable)sy2, (String)"Failed to close session device file.");
        return;
        {
            void var5_16;
            CommonUtils.a((Flushable)codedOutputStream, (String)"Failed to flush session device info.");
            CommonUtils.a((Closeable)sy3, (String)"Failed to close session device file.");
            throw var5_16;
        }
    }

    /*
     * Exception decompiling
     */
    private void f(String var1) throws Exception {
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

    private tw g(String string2) {
        if (this.a()) {
            return new tw(this.n.p(), this.n.r(), this.n.q());
        }
        return new tn(super.q()).a(string2);
    }

    private String j() {
        File[] arrfile = this.n();
        if (arrfile.length > 0) {
            return this.a(arrfile[0]);
        }
        return null;
    }

    private String k() {
        File[] arrfile = this.n();
        if (arrfile.length > 1) {
            return this.a(arrfile[1]);
        }
        return null;
    }

    private void l() throws Exception {
        Date date = new Date();
        String string2 = new sx(this.m).toString();
        akx.h().a("CrashlyticsCore", "Opening an new session with ID " + string2);
        this.a(string2, date);
        this.c(string2);
        this.d(string2);
        this.e(string2);
        this.o.a(string2);
    }

    private File[] m() {
        return this.a(a);
    }

    private File[] n() {
        Object[] arrobject = this.e();
        Arrays.sort((Object[])arrobject, b);
        return arrobject;
    }

    private void o() {
        File file = new File(this.n.w(), "invalidClsFiles");
        if (!file.exists()) {
            return;
        }
        if (file.isDirectory()) {
            File[] arrfile = file.listFiles();
            int n2 = arrfile.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                arrfile[i2].delete();
            }
        }
        file.delete();
    }

    private void p() {
        for (File file : this.m()) {
            this.l.a(new c(this.n, file));
        }
    }

    private File q() {
        return this.j.a();
    }

    void a(final long l2, final String string2) {
        this.l.b(new Callable<Void>(){

            public Void a() throws Exception {
                if (!te.this.k.get()) {
                    te.this.o.a(l2, string2);
                }
                return null;
            }

            public /* synthetic */ Object call() throws Exception {
                return this.a();
            }
        });
    }

    void a(final Thread thread, final Throwable throwable) {
        final Date date = new Date();
        this.l.a(new Runnable(){

            public void run() {
                if (!te.this.k.get()) {
                    te.this.c(date, thread, throwable);
                }
            }
        });
    }

    void a(File[] arrfile) {
        super.o();
        for (File file : arrfile) {
            akx.h().a("CrashlyticsCore", "Found invalid session part file: " + (Object)file);
            final String string2 = super.a(file);
            FilenameFilter filenameFilter = new FilenameFilter(){

                public boolean accept(File file, String string22) {
                    return string22.startsWith(string2);
                }
            };
            akx.h().a("CrashlyticsCore", "Deleting all part files for invalid session: " + string2);
            for (File file2 : super.a(filenameFilter)) {
                akx.h().a("CrashlyticsCore", "Deleting session file: " + (Object)file2);
                file2.delete();
            }
        }
    }

    boolean a() {
        return this.k.get();
    }

    void b() {
        this.l.b(new Callable<Void>(){

            public Void a() throws Exception {
                te.this.l();
                return null;
            }

            public /* synthetic */ Object call() throws Exception {
                return this.a();
            }
        });
    }

    boolean c() {
        return (Boolean)this.l.a(new Callable<Boolean>(){

            public Boolean a() throws Exception {
                if (te.this.k.get()) {
                    akx.h().a("CrashlyticsCore", "Skipping session finalization because a crash has already occurred.");
                    return Boolean.FALSE;
                }
                akx.h().a("CrashlyticsCore", "Finalizing previously open sessions.");
                ud ud2 = te.this.n.v();
                if (ud2 != null) {
                    te.this.a(ud2);
                }
                te.this.a(true);
                akx.h().a("CrashlyticsCore", "Closed all previously open sessions");
                return Boolean.TRUE;
            }

            public /* synthetic */ Object call() throws Exception {
                return this.a();
            }
        });
    }

    void d() throws Exception {
        this.a(false);
    }

    File[] e() {
        return this.a(new b("BeginSession"));
    }

    void f() {
        tx.a(this.q(), a, 4, c);
    }

    void g() {
        this.l.a(new Runnable(){

            public void run() {
                te.this.a(te.this.a(sy.a));
            }
        });
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void uncaughtException(final Thread thread, final Throwable throwable) {
        void var8_3 = this;
        // MONITORENTER : var8_3
        this.k.set(true);
        try {
            akx.h().a("CrashlyticsCore", "Crashlytics is handling uncaught exception \"" + (Object)throwable + "\" from thread " + thread.getName());
            this.p.b();
            final Date date = new Date();
            this.l.a(new Callable<Void>(){

                public Void a() throws Exception {
                    te.this.a(date, thread, throwable);
                    return null;
                }

                public /* synthetic */ Object call() throws Exception {
                    return this.a();
                }
            });
        }
        catch (Exception var5_5) {
            akx.h().e("CrashlyticsCore", "An error occurred in the uncaught exception handler", (Throwable)var5_5);
            return;
        }
        finally {
            akx.h().a("CrashlyticsCore", "Crashlytics completed exception processing. Invoking default exception handler.");
            this.i.uncaughtException(thread, throwable);
            this.k.set(false);
            return;
        }
        // MONITOREXIT : var8_3
        return;
    }

    static class a
    implements FilenameFilter {
        private a() {
        }

        /* synthetic */ a( var1) {
        }

        public boolean accept(File file, String string2) {
            if (!te.a.accept(file, string2) && e.matcher((CharSequence)string2).matches()) {
                return true;
            }
            return false;
        }
    }

    static class b
    implements FilenameFilter {
        private final String a;

        public b(String string2) {
            this.a = string2;
        }

        public boolean accept(File file, String string2) {
            if (string2.contains((CharSequence)this.a) && !string2.endsWith(".cls_temp")) {
                return true;
            }
            return false;
        }
    }

    static final class c
    implements Runnable {
        private final sz a;
        private final File b;

        public c(sz sz2, File file) {
            this.a = sz2;
            this.b = file;
        }

        /*
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        public void run() {
            if (!CommonUtils.n((Context)this.a.E())) {
                return;
            }
            akx.h().a("CrashlyticsCore", "Attempting to send crash report at time of crash...");
            aoc aoc2 = aoa.a().b();
            tg tg2 = this.a.a(aoc2);
            if (tg2 == null) return;
            new ts(tg2).a(new tu(this.b, f));
        }
    }

    static class d
    implements FilenameFilter {
        private final String a;

        public d(String string2) {
            this.a = string2;
        }

        /*
         * Enabled aggressive block sorting
         */
        public boolean accept(File file, String string2) {
            if (string2.equals((Object)(this.a + ".cls")) || !string2.contains((CharSequence)this.a) || string2.endsWith(".cls_temp")) {
                return false;
            }
            return true;
        }
    }

}

