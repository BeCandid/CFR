/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.crashlytics.android.answers.SessionEvent
 *  com.crashlytics.android.answers.SessionEvent$Type
 *  com.crashlytics.android.answers.SessionEvent$a
 *  io.fabric.sdk.android.services.common.CommonUtils
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.concurrent.RejectedExecutionException
 *  java.util.concurrent.ScheduledExecutorService
 *  java.util.concurrent.ScheduledFuture
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicReference
 *  rx
 */
import android.content.Context;
import com.crashlytics.android.answers.SessionEvent;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.IOException;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

class rw
implements sg {
    final sh a;
    amv b;
    alr c = new alr();
    rx d = new ry();
    boolean e = true;
    boolean f = true;
    volatile int g = -1;
    private final alc h;
    private final anb i;
    private final Context j;
    private final sd k;
    private final ScheduledExecutorService l;
    private final AtomicReference<ScheduledFuture<?>> m = new AtomicReference();

    public rw(alc alc2, Context context, ScheduledExecutorService scheduledExecutorService, sd sd2, anb anb2, sh sh2) {
        this.h = alc2;
        this.j = context;
        this.l = scheduledExecutorService;
        this.k = sd2;
        this.i = anb2;
        this.a = sh2;
    }

    /*
     * Exception decompiling
     */
    @Override
    public void a() {
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
    void a(long l2, long l3) {
        if (this.m.get() != null) return;
        boolean bl2 = true;
        if (!bl2) return;
        amy amy2 = new amy(this.j, (amu)this);
        CommonUtils.a((Context)this.j, (String)("Scheduling time based file roll over every " + l3 + " seconds"));
        try {
            this.m.set((Object)this.l.scheduleAtFixedRate((Runnable)amy2, l2, l3, TimeUnit.SECONDS));
            return;
        }
        catch (RejectedExecutionException var7_5) {
            CommonUtils.a((Context)this.j, (String)"Failed to schedule time based file roll over", (Throwable)var7_5);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void a(anl anl2, String string2) {
        this.b = rs.a(new se(this.h, string2, anl2.a, this.i, this.c.a(this.j)));
        this.k.a(anl2);
        this.e = anl2.f;
        alf alf2 = akx.h();
        StringBuilder stringBuilder = new StringBuilder().append("Custom event tracking ");
        String string3 = this.e ? "enabled" : "disabled";
        alf2.a("Answers", stringBuilder.append(string3).toString());
        this.f = anl2.g;
        alf alf3 = akx.h();
        StringBuilder stringBuilder2 = new StringBuilder().append("Predefined event tracking ");
        String string4 = this.f ? "enabled" : "disabled";
        alf3.a("Answers", stringBuilder2.append(string4).toString());
        if (anl2.i > 1) {
            akx.h().a("Answers", "Event sampling enabled");
            this.d = new sc(anl2.i);
        }
        this.g = anl2.b;
        this.a(0, this.g);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(SessionEvent.a a2) {
        SessionEvent sessionEvent = a2.a(this.a);
        if (!this.e && SessionEvent.Type.g.equals((Object)sessionEvent.c)) {
            akx.h().a("Answers", "Custom events tracking disabled - skipping event: " + (Object)sessionEvent);
            return;
        }
        if (!this.f && SessionEvent.Type.h.equals((Object)sessionEvent.c)) {
            akx.h().a("Answers", "Predefined events tracking disabled - skipping event: " + (Object)sessionEvent);
            return;
        }
        if (this.d.a(sessionEvent)) {
            akx.h().a("Answers", "Skipping filtered event: " + (Object)sessionEvent);
            return;
        }
        try {
            this.k.a(sessionEvent);
        }
        catch (IOException var3_3) {
            akx.h().e("Answers", "Failed to write event: " + (Object)sessionEvent, (Throwable)var3_3);
        }
        this.e();
    }

    @Override
    public void b() {
        this.k.f();
    }

    @Override
    public boolean c() {
        try {
            boolean bl2 = this.k.d();
            return bl2;
        }
        catch (IOException var1_2) {
            CommonUtils.a((Context)this.j, (String)"Failed to roll file over.", (Throwable)var1_2);
            return false;
        }
    }

    @Override
    public void d() {
        if (this.m.get() != null) {
            CommonUtils.a((Context)this.j, (String)"Cancelling time-based rollover because no events are currently being generated.");
            ((ScheduledFuture)this.m.get()).cancel(false);
            this.m.set((Object)null);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void e() {
        if (this.g == -1) return;
        boolean bl2 = true;
        if (!bl2) return;
        this.a(this.g, this.g);
    }
}

