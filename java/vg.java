/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.content.pm.PackageManager
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Looper
 *  android.os.Parcel
 *  android.os.RemoteException
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.reflect.Method
 *  java.util.concurrent.BlockingQueue
 *  java.util.concurrent.LinkedBlockingDeque
 *  java.util.concurrent.atomic.AtomicBoolean
 */
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import com.facebook.FacebookException;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

public class vg {
    private static final String a = vg.class.getCanonicalName();
    private static vg g;
    private String b;
    private String c;
    private String d;
    private boolean e;
    private long f;

    /*
     * Exception decompiling
     */
    public static vg a(Context var0) {
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

    private static vg a(vg vg2) {
        vg2.f = System.currentTimeMillis();
        g = vg2;
        return vg2;
    }

    private static vg b(Context context) {
        vg vg2 = vg.c(context);
        if (vg2 == null && (vg2 = vg.d(context)) == null) {
            vg2 = new vg();
        }
        return vg2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static vg c(Context context) {
        Method method;
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                throw new FacebookException("getAndroidId cannot be called on the main thread.");
            }
            method = we.a("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", new Class[]{Context.class});
            if (method == null) {
                return null;
            }
        }
        catch (Exception var1_1) {
            we.a("android_id", var1_1);
            return null;
        }
        Object object = we.a((Object)null, method, new Object[]{context});
        if (!(object instanceof Integer)) return null;
        if ((Integer)object != 0) {
            return null;
        }
        Method method2 = we.a("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", new Class[]{Context.class});
        if (method2 == null) {
            return null;
        }
        Object object2 = we.a((Object)null, method2, new Object[]{context});
        if (object2 == null) {
            return null;
        }
        Method method3 = we.a(object2.getClass(), "getId", new Class[0]);
        Method method4 = we.a(object2.getClass(), "isLimitAdTrackingEnabled", new Class[0]);
        if (method3 == null) return null;
        if (method4 == null) {
            return null;
        }
        vg vg2 = new vg();
        vg2.c = (String)we.a(object2, method3, new Object[0]);
        vg2.e = (Boolean)we.a(object2, method4, new Object[0]);
        return vg2;
    }

    private static vg d(Context context) {
        b b2 = new b(null);
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (context.bindService(intent, (ServiceConnection)b2, 1)) {
            try {
                a a2 = new a(b2.a());
                vg vg2 = new vg();
                vg2.c = a2.a();
                vg2.e = a2.b();
                return vg2;
            }
            catch (Exception var7_5) {
                we.a("android_id", var7_5);
            }
        }
        return null;
        finally {
            context.unbindService((ServiceConnection)b2);
        }
    }

    private static String e(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            return packageManager.getInstallerPackageName(context.getPackageName());
        }
        return null;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public boolean d() {
        return this.e;
    }

    static final class a
    implements IInterface {
        private IBinder a;

        a(IBinder iBinder) {
            this.a = iBinder;
        }

        public String a() throws RemoteException {
            Parcel parcel = Parcel.obtain();
            Parcel parcel2 = Parcel.obtain();
            try {
                parcel.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.a.transact(1, parcel, parcel2, 0);
                parcel2.readException();
                String string2 = parcel2.readString();
                return string2;
            }
            finally {
                parcel2.recycle();
                parcel.recycle();
            }
        }

        public IBinder asBinder() {
            return this.a;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public boolean b() throws RemoteException {
            boolean bl2 = true;
            Parcel parcel = Parcel.obtain();
            Parcel parcel2 = Parcel.obtain();
            try {
                parcel.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                parcel.writeInt(1);
                this.a.transact(2, parcel, parcel2, 0);
                parcel2.readException();
                int n2 = parcel2.readInt();
                if (n2 == 0) {
                    bl2 = false;
                }
                return bl2;
            }
            finally {
                parcel2.recycle();
                parcel.recycle();
            }
        }
    }

    static final class b
    implements ServiceConnection {
        private AtomicBoolean a;
        private final BlockingQueue<IBinder> b;

        private b() {
            this.a = new AtomicBoolean(false);
            this.b = new LinkedBlockingDeque();
        }

        /* synthetic */ b( var1) {
        }

        public IBinder a() throws InterruptedException {
            if (this.a.compareAndSet(true, true)) {
                throw new IllegalStateException("Binder already consumed");
            }
            return (IBinder)this.b.take();
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.b.put((Object)iBinder);
                return;
            }
            catch (InterruptedException var3_3) {
                return;
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

}

