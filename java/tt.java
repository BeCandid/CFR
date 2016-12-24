/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.app.ActivityManager$RunningAppProcessInfo
 *  android.os.Build
 *  android.os.Build$VERSION
 *  com.crashlytics.android.core.CodedOutputStream
 *  io.fabric.sdk.android.services.common.IdManager
 *  io.fabric.sdk.android.services.common.IdManager$DeviceIdentifierType
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.StackTraceElement
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
import android.app.ActivityManager;
import android.os.Build;
import com.crashlytics.android.core.CodedOutputStream;
import io.fabric.sdk.android.services.common.IdManager;
import java.util.List;
import java.util.Map;
import java.util.Set;

class tt {
    private static final sw a = sw.a("0");
    private static final sw b = sw.a("Unity");

    private static int a() {
        return 0 + CodedOutputStream.b((int)1, (sw)a) + CodedOutputStream.b((int)2, (sw)a) + CodedOutputStream.b((int)3, (long)0);
    }

    private static int a(float f2, int n2, boolean bl2, int n3, long l2, long l3) {
        return 0 + CodedOutputStream.b((int)1, (float)f2) + CodedOutputStream.f((int)2, (int)n2) + CodedOutputStream.b((int)3, (boolean)bl2) + CodedOutputStream.d((int)4, (int)n3) + CodedOutputStream.b((int)5, (long)l2) + CodedOutputStream.b((int)6, (long)l3);
    }

    /*
     * Enabled aggressive block sorting
     */
    private static int a(int n2, sw sw2, sw sw3, int n3, long l2, long l3, boolean bl2, Map<IdManager.DeviceIdentifierType, String> map, int n4, sw sw4, sw sw5) {
        int n5;
        int n6 = 0 + CodedOutputStream.b((int)1, (sw)sw2) + CodedOutputStream.e((int)3, (int)n2);
        int n7 = sw3 == null ? 0 : CodedOutputStream.b((int)4, (sw)sw3);
        int n8 = n6 + n7 + CodedOutputStream.d((int)5, (int)n3) + CodedOutputStream.b((int)6, (long)l2) + CodedOutputStream.b((int)7, (long)l3) + CodedOutputStream.b((int)10, (boolean)bl2);
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                int n9 = tt.a((IdManager.DeviceIdentifierType)entry.getKey(), (String)entry.getValue());
                n8 += n9 + (CodedOutputStream.j((int)11) + CodedOutputStream.l((int)n9));
            }
        }
        int n10 = n8 + CodedOutputStream.d((int)12, (int)n4);
        int n11 = sw4 == null ? 0 : CodedOutputStream.b((int)13, (sw)sw4);
        int n12 = n10 + n11;
        if (sw5 == null) {
            n5 = 0;
            return n12 + n5;
        }
        n5 = CodedOutputStream.b((int)14, (sw)sw5);
        return n12 + n5;
    }

    private static int a(long l2, String string2, Throwable throwable, Thread thread, StackTraceElement[] arrstackTraceElement, Thread[] arrthread, List<StackTraceElement[]> list, int n2, Map<String, String> map, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int n3, sw sw2, sw sw3, float f2, int n4, boolean bl2, long l3, long l4, sw sw4) {
        int n5 = 0 + CodedOutputStream.b((int)1, (long)l2) + CodedOutputStream.b((int)2, (sw)sw.a(string2));
        int n6 = tt.a(throwable, thread, arrstackTraceElement, arrthread, list, n2, sw2, sw3, map, runningAppProcessInfo, n3);
        int n7 = n5 + (n6 + (CodedOutputStream.j((int)3) + CodedOutputStream.l((int)n6)));
        int n8 = tt.a(f2, n4, bl2, n3, l3, l4);
        int n9 = n7 + (n8 + (CodedOutputStream.j((int)5) + CodedOutputStream.l((int)n8)));
        if (sw4 != null) {
            int n10 = tt.b(sw4);
            n9 += n10 + (CodedOutputStream.j((int)6) + CodedOutputStream.l((int)n10));
        }
        return n9;
    }

    private static int a(IdManager.DeviceIdentifierType deviceIdentifierType, String string2) {
        return CodedOutputStream.e((int)1, (int)deviceIdentifierType.h) + CodedOutputStream.b((int)2, (sw)sw.a(string2));
    }

    /*
     * Enabled aggressive block sorting
     */
    private static int a(StackTraceElement stackTraceElement, boolean bl2) {
        int n2 = 2;
        int n3 = stackTraceElement.isNativeMethod() ? 0 + CodedOutputStream.b((int)1, (long)Math.max((int)stackTraceElement.getLineNumber(), (int)0)) : 0 + CodedOutputStream.b((int)1, (long)0);
        int n4 = n3 + CodedOutputStream.b((int)n2, (sw)sw.a(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName()));
        if (stackTraceElement.getFileName() != null) {
            n4 += CodedOutputStream.b((int)3, (sw)sw.a(stackTraceElement.getFileName()));
        }
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            n4 += CodedOutputStream.b((int)4, (long)stackTraceElement.getLineNumber());
        }
        if (bl2) {
            return n4 + CodedOutputStream.d((int)5, (int)n2);
        }
        n2 = 0;
        return n4 + CodedOutputStream.d((int)5, (int)n2);
    }

    private static int a(String string2, String string3) {
        int n2 = CodedOutputStream.b((int)1, (sw)sw.a(string2));
        if (string3 == null) {
            string3 = "";
        }
        return n2 + CodedOutputStream.b((int)2, (sw)sw.a(string3));
    }

    private static int a(Thread thread, StackTraceElement[] arrstackTraceElement, int n2, boolean bl2) {
        int n3 = CodedOutputStream.b((int)1, (sw)sw.a(thread.getName())) + CodedOutputStream.d((int)2, (int)n2);
        int n4 = arrstackTraceElement.length;
        for (int i2 = 0; i2 < n4; ++i2) {
            int n5 = tt.a(arrstackTraceElement[i2], bl2);
            n3 += n5 + (CodedOutputStream.j((int)3) + CodedOutputStream.l((int)n5));
        }
        return n3;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static int a(Throwable throwable, int n2, int n3) {
        int n4 = 0 + CodedOutputStream.b((int)1, (sw)sw.a(throwable.getClass().getName()));
        String string2 = throwable.getLocalizedMessage();
        if (string2 != null) {
            n4 += CodedOutputStream.b((int)3, (sw)sw.a(string2));
        }
        StackTraceElement[] arrstackTraceElement = throwable.getStackTrace();
        int n5 = arrstackTraceElement.length;
        for (int i2 = 0; i2 < n5; ++i2) {
            int n6 = tt.a(arrstackTraceElement[i2], true);
            n4 += n6 + (CodedOutputStream.j((int)4) + CodedOutputStream.l((int)n6));
        }
        Throwable throwable2 = throwable.getCause();
        if (throwable2 == null) return n4;
        if (n2 < n3) {
            int n7 = tt.a(throwable2, n2 + 1, n3);
            n4 += n7 + (CodedOutputStream.j((int)6) + CodedOutputStream.l((int)n7));
            return n4;
        }
        int n8 = 0;
        while (throwable2 != null) {
            throwable2 = throwable2.getCause();
            ++n8;
        }
        return n4 + CodedOutputStream.d((int)7, (int)n8);
    }

    private static int a(Throwable throwable, Thread thread, StackTraceElement[] arrstackTraceElement, Thread[] arrthread, List<StackTraceElement[]> list, int n2, sw sw2, sw sw3) {
        int n3 = tt.a(thread, arrstackTraceElement, 4, true);
        int n4 = 0 + (n3 + (CodedOutputStream.j((int)1) + CodedOutputStream.l((int)n3)));
        int n5 = arrthread.length;
        for (int i2 = 0; i2 < n5; ++i2) {
            int n6 = tt.a(arrthread[i2], (StackTraceElement[])list.get(i2), 0, false);
            n4 += n6 + (CodedOutputStream.j((int)1) + CodedOutputStream.l((int)n6));
        }
        int n7 = tt.a(throwable, 1, n2);
        int n8 = n4 + (n7 + (CodedOutputStream.j((int)2) + CodedOutputStream.l((int)n7)));
        int n9 = tt.a();
        int n10 = n8 + (n9 + (CodedOutputStream.j((int)3) + CodedOutputStream.l((int)n9)));
        int n11 = tt.a(sw2, sw3);
        return n10 + (n11 + (CodedOutputStream.j((int)3) + CodedOutputStream.l((int)n11)));
    }

    /*
     * Enabled aggressive block sorting
     */
    private static int a(Throwable throwable, Thread thread, StackTraceElement[] arrstackTraceElement, Thread[] arrthread, List<StackTraceElement[]> list, int n2, sw sw2, sw sw3, Map<String, String> map, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int n3) {
        int n4 = tt.a(throwable, thread, arrstackTraceElement, arrthread, list, n2, sw2, sw3);
        int n5 = 0 + (n4 + (CodedOutputStream.j((int)1) + CodedOutputStream.l((int)n4)));
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                int n6 = tt.a((String)entry.getKey(), (String)entry.getValue());
                n5 += n6 + (CodedOutputStream.j((int)2) + CodedOutputStream.l((int)n6));
            }
        }
        if (runningAppProcessInfo != null) {
            boolean bl2 = runningAppProcessInfo.importance != 100;
            n5 += CodedOutputStream.b((int)3, (boolean)bl2);
        }
        return n5 + CodedOutputStream.d((int)4, (int)n3);
    }

    private static int a(sw sw2) {
        return 0 + CodedOutputStream.b((int)1, (sw)sw2);
    }

    private static int a(sw sw2, sw sw3) {
        int n2 = 0 + CodedOutputStream.b((int)1, (long)0) + CodedOutputStream.b((int)2, (long)0) + CodedOutputStream.b((int)3, (sw)sw2);
        if (sw3 != null) {
            n2 += CodedOutputStream.b((int)4, (sw)sw3);
        }
        return n2;
    }

    private static int a(sw sw2, sw sw3, sw sw4, sw sw5, sw sw6, int n2, sw sw7) {
        int n3 = 0 + CodedOutputStream.b((int)1, (sw)sw2) + CodedOutputStream.b((int)2, (sw)sw4) + CodedOutputStream.b((int)3, (sw)sw5);
        int n4 = tt.a(sw3);
        int n5 = n3 + (n4 + (CodedOutputStream.j((int)5) + CodedOutputStream.l((int)n4))) + CodedOutputStream.b((int)6, (sw)sw6);
        if (sw7 != null) {
            n5 = n5 + CodedOutputStream.b((int)8, (sw)b) + CodedOutputStream.b((int)9, (sw)sw7);
        }
        return n5 + CodedOutputStream.e((int)10, (int)n2);
    }

    private static int a(sw sw2, sw sw3, boolean bl2) {
        return 0 + CodedOutputStream.e((int)1, (int)3) + CodedOutputStream.b((int)2, (sw)sw2) + CodedOutputStream.b((int)3, (sw)sw3) + CodedOutputStream.b((int)4, (boolean)bl2);
    }

    private static sw a(String string2) {
        if (string2 == null) {
            return null;
        }
        return sw.a(string2);
    }

    private static void a(CodedOutputStream codedOutputStream, float f2, int n2, boolean bl2, int n3, long l2, long l3) throws Exception {
        codedOutputStream.g(5, 2);
        codedOutputStream.k(tt.a(f2, n2, bl2, n3, l2, l3));
        codedOutputStream.a(1, f2);
        codedOutputStream.c(2, n2);
        codedOutputStream.a(3, bl2);
        codedOutputStream.a(4, n3);
        codedOutputStream.a(5, l2);
        codedOutputStream.a(6, l3);
    }

    /*
     * Enabled aggressive block sorting
     */
    private static void a(CodedOutputStream codedOutputStream, int n2, StackTraceElement stackTraceElement, boolean bl2) throws Exception {
        int n3 = 4;
        codedOutputStream.g(n2, 2);
        codedOutputStream.k(tt.a(stackTraceElement, bl2));
        if (stackTraceElement.isNativeMethod()) {
            codedOutputStream.a(1, (long)Math.max((int)stackTraceElement.getLineNumber(), (int)0));
        } else {
            codedOutputStream.a(1, 0);
        }
        codedOutputStream.a(2, sw.a(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName()));
        if (stackTraceElement.getFileName() != null) {
            codedOutputStream.a(3, sw.a(stackTraceElement.getFileName()));
        }
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            codedOutputStream.a(n3, (long)stackTraceElement.getLineNumber());
        }
        if (!bl2) {
            n3 = 0;
        }
        codedOutputStream.a(5, n3);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void a(CodedOutputStream codedOutputStream, long l2, String string2, Throwable throwable, Thread thread, StackTraceElement[] arrstackTraceElement, Thread[] arrthread, List<StackTraceElement[]> list, Map<String, String> map, tl tl2, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int n2, String string3, String string4, float f2, int n3, boolean bl2, long l3, long l4) throws Exception {
        sw sw2 = sw.a(string3);
        sw sw3 = string4 == null ? null : sw.a(string4.replace((CharSequence)"-", (CharSequence)""));
        sw sw4 = tl2.a();
        if (sw4 == null) {
            akx.h().a("CrashlyticsCore", "No log data to include with this event.");
        }
        tl2.b();
        codedOutputStream.g(10, 2);
        codedOutputStream.k(tt.a(l2, string2, throwable, thread, arrstackTraceElement, arrthread, list, 8, map, runningAppProcessInfo, n2, sw2, sw3, f2, n3, bl2, l3, l4, sw4));
        codedOutputStream.a(1, l2);
        codedOutputStream.a(2, sw.a(string2));
        tt.a(codedOutputStream, throwable, thread, arrstackTraceElement, arrthread, list, 8, sw2, sw3, map, runningAppProcessInfo, n2);
        tt.a(codedOutputStream, f2, n3, bl2, n2, l3, l4);
        tt.a(codedOutputStream, sw4);
    }

    public static void a(CodedOutputStream codedOutputStream, String string2, int n2, String string3, int n3, long l2, long l3, boolean bl2, Map<IdManager.DeviceIdentifierType, String> map, int n4, String string4, String string5) throws Exception {
        sw sw2 = sw.a(string2);
        sw sw3 = tt.a(string3);
        sw sw4 = tt.a(string5);
        sw sw5 = tt.a(string4);
        codedOutputStream.g(9, 2);
        codedOutputStream.k(tt.a(n2, sw2, sw3, n3, l2, l3, bl2, map, n4, sw5, sw4));
        codedOutputStream.a(1, sw2);
        codedOutputStream.b(3, n2);
        codedOutputStream.a(4, sw3);
        codedOutputStream.a(5, n3);
        codedOutputStream.a(6, l2);
        codedOutputStream.a(7, l3);
        codedOutputStream.a(10, bl2);
        for (Map.Entry entry : map.entrySet()) {
            codedOutputStream.g(11, 2);
            codedOutputStream.k(tt.a((IdManager.DeviceIdentifierType)entry.getKey(), (String)entry.getValue()));
            codedOutputStream.b(1, ((IdManager.DeviceIdentifierType)entry.getKey()).h);
            codedOutputStream.a(2, sw.a((String)entry.getValue()));
        }
        codedOutputStream.a(12, n4);
        if (sw5 != null) {
            codedOutputStream.a(13, sw5);
        }
        if (sw4 != null) {
            codedOutputStream.a(14, sw4);
        }
    }

    public static void a(CodedOutputStream codedOutputStream, String string2, String string3, long l2) throws Exception {
        codedOutputStream.a(1, sw.a(string3));
        codedOutputStream.a(2, sw.a(string2));
        codedOutputStream.a(3, l2);
    }

    public static void a(CodedOutputStream codedOutputStream, String string2, String string3, String string4) throws Exception {
        if (string2 == null) {
            string2 = "";
        }
        sw sw2 = sw.a(string2);
        sw sw3 = tt.a(string3);
        sw sw4 = tt.a(string4);
        int n2 = 0 + CodedOutputStream.b((int)1, (sw)sw2);
        if (string3 != null) {
            n2 += CodedOutputStream.b((int)2, (sw)sw3);
        }
        if (string4 != null) {
            n2 += CodedOutputStream.b((int)3, (sw)sw4);
        }
        codedOutputStream.g(6, 2);
        codedOutputStream.k(n2);
        codedOutputStream.a(1, sw2);
        if (string3 != null) {
            codedOutputStream.a(2, sw3);
        }
        if (string4 != null) {
            codedOutputStream.a(3, sw4);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void a(CodedOutputStream codedOutputStream, String string2, String string3, String string4, String string5, String string6, int n2, String string7) throws Exception {
        sw sw2 = sw.a(string2);
        sw sw3 = sw.a(string3);
        sw sw4 = sw.a(string4);
        sw sw5 = sw.a(string5);
        sw sw6 = sw.a(string6);
        sw sw7 = string7 != null ? sw.a(string7) : null;
        codedOutputStream.g(7, 2);
        codedOutputStream.k(tt.a(sw2, sw3, sw4, sw5, sw6, n2, sw7));
        codedOutputStream.a(1, sw2);
        codedOutputStream.a(2, sw4);
        codedOutputStream.a(3, sw5);
        codedOutputStream.g(5, 2);
        codedOutputStream.k(tt.a(sw3));
        codedOutputStream.a(1, sw3);
        codedOutputStream.a(6, sw6);
        if (sw7 != null) {
            codedOutputStream.a(8, b);
            codedOutputStream.a(9, sw7);
        }
        codedOutputStream.b(10, n2);
    }

    private static void a(CodedOutputStream codedOutputStream, Thread thread, StackTraceElement[] arrstackTraceElement, int n2, boolean bl2) throws Exception {
        codedOutputStream.g(1, 2);
        codedOutputStream.k(tt.a(thread, arrstackTraceElement, n2, bl2));
        codedOutputStream.a(1, sw.a(thread.getName()));
        codedOutputStream.a(2, n2);
        int n3 = arrstackTraceElement.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            tt.a(codedOutputStream, 3, arrstackTraceElement[i2], bl2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static void a(CodedOutputStream codedOutputStream, Throwable throwable, int n2, int n3, int n4) throws Exception {
        codedOutputStream.g(n4, 2);
        codedOutputStream.k(tt.a(throwable, 1, n3));
        codedOutputStream.a(1, sw.a(throwable.getClass().getName()));
        String string2 = throwable.getLocalizedMessage();
        if (string2 != null) {
            codedOutputStream.a(3, sw.a(string2));
        }
        StackTraceElement[] arrstackTraceElement = throwable.getStackTrace();
        int n5 = arrstackTraceElement.length;
        for (int i2 = 0; i2 < n5; ++i2) {
            tt.a(codedOutputStream, 4, arrstackTraceElement[i2], true);
        }
        Throwable throwable2 = throwable.getCause();
        if (throwable2 == null) return;
        if (n2 < n3) {
            tt.a(codedOutputStream, throwable2, n2 + 1, n3, 6);
            return;
        }
        int n6 = 0;
        while (throwable2 != null) {
            throwable2 = throwable2.getCause();
            ++n6;
        }
        codedOutputStream.a(7, n6);
    }

    private static void a(CodedOutputStream codedOutputStream, Throwable throwable, Thread thread, StackTraceElement[] arrstackTraceElement, Thread[] arrthread, List<StackTraceElement[]> list, int n2, sw sw2, sw sw3) throws Exception {
        codedOutputStream.g(1, 2);
        codedOutputStream.k(tt.a(throwable, thread, arrstackTraceElement, arrthread, list, n2, sw2, sw3));
        tt.a(codedOutputStream, thread, arrstackTraceElement, 4, true);
        int n3 = arrthread.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            tt.a(codedOutputStream, arrthread[i2], (StackTraceElement[])list.get(i2), 0, false);
        }
        tt.a(codedOutputStream, throwable, 1, n2, 2);
        codedOutputStream.g(3, 2);
        codedOutputStream.k(tt.a());
        codedOutputStream.a(1, a);
        codedOutputStream.a(2, a);
        codedOutputStream.a(3, 0);
        codedOutputStream.g(4, 2);
        codedOutputStream.k(tt.a(sw2, sw3));
        codedOutputStream.a(1, 0);
        codedOutputStream.a(2, 0);
        codedOutputStream.a(3, sw2);
        if (sw3 != null) {
            codedOutputStream.a(4, sw3);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private static void a(CodedOutputStream codedOutputStream, Throwable throwable, Thread thread, StackTraceElement[] arrstackTraceElement, Thread[] arrthread, List<StackTraceElement[]> list, int n2, sw sw2, sw sw3, Map<String, String> map, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int n3) throws Exception {
        codedOutputStream.g(3, 2);
        codedOutputStream.k(tt.a(throwable, thread, arrstackTraceElement, arrthread, list, n2, sw2, sw3, map, runningAppProcessInfo, n3));
        tt.a(codedOutputStream, throwable, thread, arrstackTraceElement, arrthread, list, n2, sw2, sw3);
        if (map != null && !map.isEmpty()) {
            tt.a(codedOutputStream, map);
        }
        if (runningAppProcessInfo != null) {
            boolean bl2 = runningAppProcessInfo.importance != 100;
            codedOutputStream.a(3, bl2);
        }
        codedOutputStream.a(4, n3);
    }

    private static void a(CodedOutputStream codedOutputStream, Map<String, String> map) throws Exception {
        for (Map.Entry entry : map.entrySet()) {
            codedOutputStream.g(2, 2);
            codedOutputStream.k(tt.a((String)entry.getKey(), (String)entry.getValue()));
            codedOutputStream.a(1, sw.a((String)entry.getKey()));
            String string2 = (String)entry.getValue();
            if (string2 == null) {
                string2 = "";
            }
            codedOutputStream.a(2, sw.a(string2));
        }
    }

    private static void a(CodedOutputStream codedOutputStream, sw sw2) throws Exception {
        if (sw2 != null) {
            codedOutputStream.g(6, 2);
            codedOutputStream.k(tt.b(sw2));
            codedOutputStream.a(1, sw2);
        }
    }

    public static void a(CodedOutputStream codedOutputStream, boolean bl2) throws Exception {
        sw sw2 = sw.a(Build.VERSION.RELEASE);
        sw sw3 = sw.a(Build.VERSION.CODENAME);
        codedOutputStream.g(8, 2);
        codedOutputStream.k(tt.a(sw2, sw3, bl2));
        codedOutputStream.b(1, 3);
        codedOutputStream.a(2, sw2);
        codedOutputStream.a(3, sw3);
        codedOutputStream.a(4, bl2);
    }

    private static int b(sw sw2) {
        return CodedOutputStream.b((int)1, (sw)sw2);
    }
}

