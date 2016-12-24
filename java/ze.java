/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.content.pm.PackageManager
 *  android.content.pm.ResolveInfo
 *  android.content.pm.ServiceInfo
 *  android.os.Debug
 *  android.os.Parcelable
 *  android.os.Process
 *  android.os.SystemClock
 *  android.util.Log
 *  com.google.android.gms.common.stats.ConnectionEvent
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.SecurityException
 *  java.lang.StackTraceElement
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.util.Arrays
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 */
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Debug;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.stats.ConnectionEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ze {
    private static final Object a = new Object();
    private static ze b;
    private static Integer h;
    private final List<String> c;
    private final List<String> d;
    private final List<String> e;
    private final List<String> f;
    private zh g;
    private zh i;

    /*
     * Enabled aggressive block sorting
     */
    private ze() {
        if (ze.c() == zg.b) {
            this.c = Collections.EMPTY_LIST;
            this.d = Collections.EMPTY_LIST;
            this.e = Collections.EMPTY_LIST;
            this.f = Collections.EMPTY_LIST;
            return;
        }
        String string2 = zf.a.b.a();
        List list = string2 == null ? Collections.EMPTY_LIST : Arrays.asList((Object[])string2.split(","));
        this.c = list;
        String string3 = zf.a.c.a();
        List list2 = string3 == null ? Collections.EMPTY_LIST : Arrays.asList((Object[])string3.split(","));
        this.d = list2;
        String string4 = zf.a.d.a();
        List list3 = string4 == null ? Collections.EMPTY_LIST : Arrays.asList((Object[])string4.split(","));
        this.e = list3;
        String string5 = zf.a.e.a();
        List list4 = string5 == null ? Collections.EMPTY_LIST : Arrays.asList((Object[])string5.split(","));
        this.f = list4;
        this.g = new zh(1024, zf.a.f.a());
        this.i = new zh(1024, zf.a.f.a());
    }

    private static String a(int n2, int n3) {
        StackTraceElement[] arrstackTraceElement = Thread.currentThread().getStackTrace();
        StringBuffer stringBuffer = new StringBuffer();
        int n4 = n3 + n2;
        while (n2 < n4) {
            stringBuffer.append(ze.a(arrstackTraceElement, n2)).append(" ");
            ++n2;
        }
        return stringBuffer.toString();
    }

    private String a(ServiceConnection serviceConnection) {
        return String.valueOf((long)((long)Process.myPid() << 32 | (long)System.identityHashCode((Object)serviceConnection)));
    }

    private static String a(StackTraceElement[] arrstackTraceElement, int n2) {
        if (n2 + 4 >= arrstackTraceElement.length) {
            return "<bottom of call stack>";
        }
        StackTraceElement stackTraceElement = arrstackTraceElement[n2 + 4];
        String string2 = String.valueOf((Object)stackTraceElement.getClassName());
        String string3 = String.valueOf((Object)stackTraceElement.getMethodName());
        int n3 = stackTraceElement.getLineNumber();
        return new StringBuilder(13 + String.valueOf((Object)string2).length() + String.valueOf((Object)string3).length()).append(string2).append(".").append(string3).append(":").append(n3).toString();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static ze a() {
        Object object;
        Object object2 = object = a;
        synchronized (object2) {
            if (b == null) {
                b = new ze();
            }
            return b;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(Context context, String string2, int n2, String string3, String string4, String string5, String string6) {
        long l2 = System.currentTimeMillis();
        int n3 = ze.c() & zg.f;
        String string7 = null;
        if (n3 != 0) {
            string7 = null;
            if (n2 != 13) {
                string7 = ze.a(3, 5);
            }
        }
        long l3 = 0;
        if ((ze.c() & zg.h) != 0) {
            l3 = Debug.getNativeHeapAllocatedSize();
        }
        ConnectionEvent connectionEvent = n2 == 1 || n2 == 4 || n2 == 14 ? new ConnectionEvent(l2, n2, null, null, null, null, string7, string2, SystemClock.elapsedRealtime(), l3) : new ConnectionEvent(l2, n2, string3, string4, string5, string6, string7, string2, SystemClock.elapsedRealtime(), l3);
        context.startService(new Intent().setComponent(zg.a).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", (Parcelable)connectionEvent));
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void a(Context context, String string2, String string3, Intent intent, int n2) {
        String string4;
        String string5;
        String string6 = null;
        if (!this.b()) return;
        if (this.g == null) {
            return;
        }
        if (n2 == 4 || n2 == 1) {
            if (!this.g.b(string2)) return;
            string5 = null;
            string4 = null;
        } else {
            ServiceInfo serviceInfo = ze.b(context, intent);
            if (serviceInfo == null) {
                Object[] arrobject = new Object[]{string3, intent.toUri(0)};
                Log.w((String)"ConnectionTracker", (String)String.format((String)"Client %s made an invalid request %s", (Object[])arrobject));
                return;
            }
            string4 = serviceInfo.processName;
            string5 = serviceInfo.name;
            string6 = zu.a();
            if (!this.a(string6, string3, string4, string5)) return;
            this.g.a(string2);
        }
        this.a(context, string2, n2, string6, string3, string4, string5);
    }

    private boolean a(Context context, Intent intent) {
        ComponentName componentName = intent.getComponent();
        if (componentName != null) {
            return zm.a(context, componentName.getPackageName());
        }
        return false;
    }

    private boolean a(String string2, String string3, String string4, String string5) {
        int n2 = ze.c();
        if (this.c.contains((Object)string2) || this.d.contains((Object)string3) || this.e.contains((Object)string4) || this.f.contains((Object)string5) || string4.equals((Object)string2) && (n2 & zg.g) != 0) {
            return false;
        }
        return true;
    }

    private static ServiceInfo b(Context context, Intent intent) {
        List list = context.getPackageManager().queryIntentServices(intent, 128);
        if (list == null || list.size() == 0) {
            Object[] arrobject = new Object[]{intent.toUri(0), ze.a(3, 20)};
            Log.w((String)"ConnectionTracker", (String)String.format((String)"There are no handler of this intent: %s\n Stack trace: %s", (Object[])arrobject));
            return null;
        }
        if (list.size() > 1) {
            Object[] arrobject = new Object[]{intent.toUri(0), ze.a(3, 20)};
            Log.w((String)"ConnectionTracker", (String)String.format((String)"Multiple handlers found for this intent: %s\n Stack trace: %s", (Object[])arrobject));
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                Log.w((String)"ConnectionTracker", (String)((ResolveInfo)iterator.next()).serviceInfo.name);
            }
            return null;
        }
        return ((ResolveInfo)list.get((int)0)).serviceInfo;
    }

    private boolean b() {
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static int c() {
        if (h != null) return h;
        try {
            int n2 = zm.a() ? zf.a.a.a() : zg.b;
            h = n2;
        }
        catch (SecurityException var0_1) {
            h = zg.b;
            return h;
        }
        return h;
    }

    @SuppressLint(value={"UntrackedBindService"})
    public void a(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
        super.a(context, super.a(serviceConnection), (String)null, (Intent)null, 1);
    }

    public void a(Context context, ServiceConnection serviceConnection, String string2, Intent intent) {
        super.a(context, super.a(serviceConnection), string2, intent, 3);
    }

    public boolean a(Context context, Intent intent, ServiceConnection serviceConnection, int n2) {
        return this.a(context, context.getClass().getName(), intent, serviceConnection, n2);
    }

    @SuppressLint(value={"UntrackedBindService"})
    public boolean a(Context context, String string2, Intent intent, ServiceConnection serviceConnection, int n2) {
        if (this.a(context, intent)) {
            Log.w((String)"ConnectionTracker", (String)"Attempted to bind to a service in a STOPPED package.");
            return false;
        }
        boolean bl2 = context.bindService(intent, serviceConnection, n2);
        if (bl2) {
            this.a(context, this.a(serviceConnection), string2, intent, 2);
        }
        return bl2;
    }

    public void b(Context context, ServiceConnection serviceConnection) {
        super.a(context, super.a(serviceConnection), (String)null, (Intent)null, 4);
    }
}

