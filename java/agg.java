/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.content.pm.PackageManager
 *  android.os.Bundle
 *  android.os.DeadObjectException
 *  android.os.IBinder
 *  android.os.Looper
 *  android.os.RemoteException
 *  android.text.TextUtils
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.measurement.internal.AppMetadata
 *  com.google.android.gms.measurement.internal.EventParcel
 *  com.google.android.gms.measurement.internal.UserAttributeParcel
 *  com.google.android.gms.measurement.internal.zzw
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.List
 */
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.measurement.internal.AppMetadata;
import com.google.android.gms.measurement.internal.EventParcel;
import com.google.android.gms.measurement.internal.UserAttributeParcel;
import com.google.android.gms.measurement.internal.zzw;
import java.util.ArrayList;
import java.util.List;

public class agg
extends agd {
    private final a a;
    private aha b;
    private Boolean c;
    private final agt d;
    private final agk e;
    private final List<Runnable> f = new ArrayList();
    private final agt g;

    protected agg(ahk ahk2) {
        super(ahk2);
        this.e = new agk(ahk2.r());
        this.a = (agg)this.new a();
        this.d = new agt(ahk2){

            @Override
            public void a() {
                agg.this.F();
            }
        };
        this.g = new agt(ahk2){

            @Override
            public void a() {
                agg.this.w().z().a("Tasks have been queued for a long time");
            }
        };
    }

    private void D() {
        this.j();
        this.e.a();
        if (!this.n.C()) {
            this.d.a(this.y().K());
        }
    }

    private boolean E() {
        List list = this.q().getPackageManager().queryIntentServices(new Intent().setClassName(this.q(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        if (list != null && list.size() > 0) {
            return true;
        }
        return false;
    }

    private void F() {
        this.j();
        if (!this.f()) {
            return;
        }
        this.w().E().a("Inactivity, disconnecting from AppMeasurementService");
        this.C();
    }

    private void G() {
        this.j();
        this.A();
    }

    private void H() {
        this.j();
        this.w().E().a("Processing queued up service tasks", this.f.size());
        for (Runnable runnable : this.f) {
            this.v().a(runnable);
        }
        this.f.clear();
        this.g.c();
    }

    private void a(aha aha2) {
        this.j();
        xz.a(aha2);
        this.b = aha2;
        super.D();
        super.H();
    }

    private void a(ComponentName componentName) {
        this.j();
        if (this.b != null) {
            this.b = null;
            this.w().E().a("Disconnected from device MeasurementService", (Object)componentName);
            super.G();
        }
    }

    private void a(Runnable runnable) throws IllegalStateException {
        this.j();
        if (this.f()) {
            runnable.run();
            return;
        }
        if ((long)this.f.size() >= this.y().V()) {
            this.w().f().a("Discarding data. Max runnable queue size reached");
            return;
        }
        this.f.add((Object)runnable);
        if (!this.n.C()) {
            this.g.a(60000);
        }
        this.A();
    }

    void A() {
        this.j();
        this.c();
        if (this.f()) {
            return;
        }
        if (this.c == null) {
            this.c = this.x().B();
            if (this.c == null) {
                this.w().E().a("State of service unknown");
                this.c = this.B();
                this.x().a(this.c);
            }
        }
        if (this.c.booleanValue()) {
            this.w().E().a("Using measurement service");
            this.a.a();
            return;
        }
        if (!this.n.C() && this.E()) {
            this.w().E().a("Using local app measurement service");
            Intent intent = new Intent("com.google.android.gms.measurement.START");
            intent.setComponent(new ComponentName(this.q(), "com.google.android.gms.measurement.AppMeasurementService"));
            this.a.a(intent);
            return;
        }
        if (this.y().P()) {
            this.w().E().a("Using direct local measurement implementation");
            this.a(new ahl(this.n, true));
            return;
        }
        this.w().f().a("Not in main process. Unable to use local measurement implementation. Please register the AppMeasurementService service in the app manifest");
    }

    protected boolean B() {
        this.j();
        this.c();
        if (this.y().O()) {
            return true;
        }
        this.w().E().a("Checking service availability");
        switch (aaa.b().a(this.q())) {
            default: {
                return false;
            }
            case 0: {
                this.w().E().a("Service available");
                return true;
            }
            case 1: {
                this.w().E().a("Service missing");
                return false;
            }
            case 18: {
                this.w().z().a("Service updating");
                return true;
            }
            case 2: {
                this.w().D().a("Service container out of date");
                return true;
            }
            case 3: {
                this.w().z().a("Service disabled");
                return false;
            }
            case 9: 
        }
        this.w().z().a("Service invalid");
        return false;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public void C() {
        this.j();
        this.c();
        try {
            ze.a().a(this.q(), this.a);
        }
        catch (IllegalStateException var2_1) {
        }
        catch (IllegalArgumentException var1_2) {
            ** continue;
        }
lbl5: // 3 sources:
        do {
            this.b = null;
            return;
            break;
        } while (true);
    }

    protected void a(final EventParcel eventParcel, final String string2) {
        xz.a(eventParcel);
        this.j();
        this.c();
        super.a(new Runnable(){

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public void run() {
                aha aha2 = agg.this.b;
                if (aha2 == null) {
                    agg.this.w().f().a("Discarding data. Failed to send event to service");
                    return;
                }
                try {
                    if (TextUtils.isEmpty((CharSequence)string2)) {
                        aha2.a(eventParcel, agg.this.m().a(agg.this.w().F()));
                    } else {
                        aha2.a(eventParcel, string2, agg.this.w().F());
                    }
                    agg.this.D();
                    return;
                }
                catch (RemoteException var2_2) {
                    agg.this.w().f().a("Failed to send event to AppMeasurementService", (Object)var2_2);
                    return;
                }
            }
        });
    }

    protected void a(final UserAttributeParcel userAttributeParcel) {
        this.j();
        this.c();
        super.a(new Runnable(){

            public void run() {
                aha aha2 = agg.this.b;
                if (aha2 == null) {
                    agg.this.w().f().a("Discarding data. Failed to set user attribute");
                    return;
                }
                try {
                    aha2.a(userAttributeParcel, agg.this.m().a(agg.this.w().F()));
                    agg.this.D();
                    return;
                }
                catch (RemoteException var2_2) {
                    agg.this.w().f().a("Failed to send attribute to AppMeasurementService", (Object)var2_2);
                    return;
                }
            }
        });
    }

    @Override
    protected void e() {
    }

    public boolean f() {
        this.j();
        this.c();
        if (this.b != null) {
            return true;
        }
        return false;
    }

    protected void g() {
        this.j();
        this.c();
        this.a(new Runnable(){

            public void run() {
                aha aha2 = agg.this.b;
                if (aha2 == null) {
                    agg.this.w().f().a("Failed to send measurementEnabled to service");
                    return;
                }
                try {
                    aha2.b(agg.this.m().a(agg.this.w().F()));
                    agg.this.D();
                    return;
                }
                catch (RemoteException var2_2) {
                    agg.this.w().f().a("Failed to send measurementEnabled to AppMeasurementService", (Object)var2_2);
                    return;
                }
            }
        });
    }

    protected void z() {
        this.j();
        this.c();
        this.a(new Runnable(){

            public void run() {
                aha aha2 = agg.this.b;
                if (aha2 == null) {
                    agg.this.w().f().a("Discarding data. Failed to send app launch");
                    return;
                }
                try {
                    aha2.a(agg.this.m().a(agg.this.w().F()));
                    agg.this.D();
                    return;
                }
                catch (RemoteException var2_2) {
                    agg.this.w().f().a("Failed to send app launch to AppMeasurementService", (Object)var2_2);
                    return;
                }
            }
        });
    }

    public class a
    implements ServiceConnection,
    yi.b,
    yi.c {
        private volatile boolean b;
        private volatile ahc c;

        protected a() {
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public void a() {
            agg.this.j();
            Context context = agg.this.q();
            a a2 = this;
            synchronized (a2) {
                if (this.b) {
                    agg.this.w().E().a("Connection attempt already in progress");
                    return;
                }
                if (this.c != null) {
                    agg.this.w().E().a("Already awaiting connection attempt");
                    return;
                }
                this.c = new ahc(context, Looper.getMainLooper(), this, this);
                agg.this.w().E().a("Connecting to remote service");
                this.b = true;
                this.c.k();
                return;
            }
        }

        @Override
        public void a(int n2) {
            xz.b("MeasurementServiceConnection.onConnectionSuspended");
            agg.this.w().D().a("Service connection suspended");
            agg.this.v().a(new Runnable(){

                public void run() {
                    agg.this.a(new ComponentName(agg.this.q(), "com.google.android.gms.measurement.AppMeasurementService"));
                }
            });
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public void a(Intent intent) {
            agg.this.j();
            Context context = agg.this.q();
            ze ze2 = ze.a();
            void var6_4 = this;
            synchronized (var6_4) {
                if (this.b) {
                    agg.this.w().E().a("Connection attempt already in progress");
                    return;
                }
                this.b = true;
                ze2.a(context, intent, agg.this.a, 129);
                return;
            }
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive exception aggregation
         */
        @Override
        public void a(Bundle var1) {
            xz.b("MeasurementServiceConnection.onConnected");
            var6_2 = this;
            synchronized (var6_2) {
                var5_3 = (aha)this.c.r();
                this.c = null;
                agg.this.v().a(new Runnable(){

                    /*
                     * Enabled aggressive block sorting
                     * Enabled unnecessary exception pruning
                     * Enabled aggressive exception aggregation
                     */
                    public void run() {
                        a a2;
                        a a3 = a2 = a.this;
                        synchronized (a3) {
                            a.this.b = false;
                            if (!agg.this.f()) {
                                agg.this.w().D().a("Connected to remote service");
                                agg.this.a(var5_3);
                            }
                            return;
                        }
                    }
                });
lbl9: // 2 sources:
                do {
                    return;
                    break;
                } while (true);
lbl11: // 2 sources:
                do {
                    this.c = null;
                    this.b = false;
                    ** continue;
                    break;
                } while (true);
                catch (Throwable var3_4) {}
                {
                    throw var3_4;
                }
                {
                    catch (DeadObjectException var2_5) {
                        ** GOTO lbl11
                    }
                    catch (IllegalStateException var4_6) {
                        ** continue;
                    }
                }
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void a(ConnectionResult connectionResult) {
            xz.b("MeasurementServiceConnection.onConnectionFailed");
            ahd ahd2 = agg.this.n.g();
            if (ahd2 != null) {
                ahd2.z().a("Service connection failed", (Object)connectionResult);
            }
            void var4_3 = this;
            synchronized (var4_3) {
                this.b = false;
                this.c = null;
                return;
            }
        }

        /*
         * Exception decompiling
         */
        public void onServiceConnected(ComponentName var1, IBinder var2_2) {
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
            // org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:664)
            // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:747)
            // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
            // org.benf.cfr.reader.Main.doJar(Main.java:128)
            // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
            // java.lang.Thread.run(Thread.java:818)
            throw new IllegalStateException("Decompilation failed");
        }

        public void onServiceDisconnected(final ComponentName componentName) {
            xz.b("MeasurementServiceConnection.onServiceDisconnected");
            agg.this.w().D().a("Service disconnected");
            agg.this.v().a(new Runnable(){

                public void run() {
                    agg.this.a(componentName);
                }
            });
        }

    }

}

