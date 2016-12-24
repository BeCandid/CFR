/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.WorkSource
 *  android.util.Log
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Method
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.List
 */
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.WorkSource;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class zx {
    private static final Method a = zx.a();
    private static final Method b = zx.b();
    private static final Method c = zx.c();
    private static final Method d = zx.d();
    private static final Method e = zx.e();

    public static int a(WorkSource workSource) {
        if (c != null) {
            try {
                int n2 = (Integer)c.invoke((Object)workSource, new Object[0]);
                return n2;
            }
            catch (Exception var1_2) {
                Log.wtf((String)"WorkSourceUtil", (String)"Unable to assign blame through WorkSource", (Throwable)var1_2);
            }
        }
        return 0;
    }

    public static WorkSource a(int n2, String string2) {
        WorkSource workSource = new WorkSource();
        zx.a(workSource, n2, string2);
        return workSource;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static WorkSource a(Context context, String string2) {
        if (context == null || context.getPackageManager() == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(string2, 0);
            if (applicationInfo != null) return zx.a(applicationInfo.uid, string2);
        }
        catch (PackageManager.NameNotFoundException var2_5) {
            String string3 = String.valueOf((Object)string2);
            String string4 = string3.length() != 0 ? "Could not find package: ".concat(string3) : new String("Could not find package: ");
            Log.e((String)"WorkSourceUtil", (String)string4);
            return null;
        }
        {
            String string5 = String.valueOf((Object)string2);
            String string6 = string5.length() != 0 ? "Could not get applicationInfo from package: ".concat(string5) : new String("Could not get applicationInfo from package: ");
            Log.e((String)"WorkSourceUtil", (String)string6);
            return null;
        }
    }

    public static String a(WorkSource workSource, int n2) {
        if (e != null) {
            try {
                Method method = e;
                Object[] arrobject = new Object[]{n2};
                String string2 = (String)method.invoke((Object)workSource, arrobject);
                return string2;
            }
            catch (Exception var2_5) {
                Log.wtf((String)"WorkSourceUtil", (String)"Unable to assign blame through WorkSource", (Throwable)var2_5);
            }
        }
        return null;
    }

    private static Method a() {
        try {
            Class[] arrclass = new Class[]{Integer.TYPE};
            Method method = WorkSource.class.getMethod("add", arrclass);
            return method;
        }
        catch (Exception var0_2) {
            return null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(WorkSource workSource, int n2, String string2) {
        if (b != null) {
            if (string2 == null) {
                string2 = "";
            }
            try {
                Method method = b;
                Object[] arrobject = new Object[]{n2, string2};
                method.invoke((Object)workSource, arrobject);
                return;
            }
            catch (Exception var8_5) {
                Log.wtf((String)"WorkSourceUtil", (String)"Unable to assign blame through WorkSource", (Throwable)var8_5);
                return;
            }
        }
        if (a == null) return;
        try {
            Method method = a;
            Object[] arrobject = new Object[]{n2};
            method.invoke((Object)workSource, arrobject);
            return;
        }
        catch (Exception var3_8) {
            Log.wtf((String)"WorkSourceUtil", (String)"Unable to assign blame through WorkSource", (Throwable)var3_8);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static boolean a(Context context) {
        PackageManager packageManager;
        if (context == null || (packageManager = context.getPackageManager()) == null || packageManager.checkPermission("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) != 0) {
            return false;
        }
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static Method b() {
        boolean bl2 = zt.e();
        Method method = null;
        if (!bl2) return method;
        try {
            Class[] arrclass = new Class[]{Integer.TYPE, String.class};
            Method method2 = WorkSource.class.getMethod("add", arrclass);
            return method2;
        }
        catch (Exception exception) {
            return null;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static List<String> b(WorkSource workSource) {
        int n2 = 0;
        int n3 = workSource == null ? 0 : zx.a(workSource);
        if (n3 == 0) {
            return Collections.EMPTY_LIST;
        }
        List list = new ArrayList();
        while (n2 < n3) {
            String string2 = zx.a(workSource, n2);
            if (!zv.a(string2)) {
                list.add((Object)string2);
            }
            ++n2;
        }
        return list;
    }

    private static Method c() {
        try {
            Method method = WorkSource.class.getMethod("size", new Class[0]);
            return method;
        }
        catch (Exception var0_1) {
            return null;
        }
    }

    private static Method d() {
        try {
            Class[] arrclass = new Class[]{Integer.TYPE};
            Method method = WorkSource.class.getMethod("get", arrclass);
            return method;
        }
        catch (Exception var0_2) {
            return null;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static Method e() {
        boolean bl2 = zt.e();
        Method method = null;
        if (!bl2) return method;
        try {
            Class[] arrclass = new Class[]{Integer.TYPE};
            Method method2 = WorkSource.class.getMethod("getName", arrclass);
            return method2;
        }
        catch (Exception exception) {
            return null;
        }
    }
}

