/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
import android.util.Log;
import com.facebook.LoggingBehavior;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class vx {
    private static final HashMap<String, String> a = new HashMap();
    private final LoggingBehavior b;
    private final String c;
    private StringBuilder d;
    private int e = 3;

    public vx(LoggingBehavior loggingBehavior, String string2) {
        wf.a(string2, "tag");
        this.b = loggingBehavior;
        this.c = "FacebookSDK." + string2;
        this.d = new StringBuilder();
    }

    public static void a(LoggingBehavior loggingBehavior, int n2, String string2, String string3) {
        if (ul.a(loggingBehavior)) {
            String string4 = vx.d(string3);
            if (!string2.startsWith("FacebookSDK.")) {
                string2 = "FacebookSDK." + string2;
            }
            Log.println((int)n2, (String)string2, (String)string4);
            if (loggingBehavior == LoggingBehavior.f) {
                new Exception().printStackTrace();
            }
        }
    }

    public static /* varargs */ void a(LoggingBehavior loggingBehavior, int n2, String string2, String string3, Object ... arrobject) {
        if (ul.a(loggingBehavior)) {
            vx.a(loggingBehavior, n2, string2, String.format((String)string3, (Object[])arrobject));
        }
    }

    public static void a(LoggingBehavior loggingBehavior, String string2, String string3) {
        vx.a(loggingBehavior, 3, string2, string3);
    }

    public static /* varargs */ void a(LoggingBehavior loggingBehavior, String string2, String string3, Object ... arrobject) {
        if (ul.a(loggingBehavior)) {
            vx.a(loggingBehavior, 3, string2, String.format((String)string3, (Object[])arrobject));
        }
    }

    public static void a(String string2) {
        reference var2_1 = vx.class;
        synchronized (vx.class) {
            if (!ul.a(LoggingBehavior.b)) {
                vx.a(string2, "ACCESS_TOKEN_REMOVED");
            }
            // ** MonitorExit[var2_1] (shouldn't be in output)
            return;
        }
    }

    public static void a(String string2, String string3) {
        reference var4_2 = vx.class;
        synchronized (vx.class) {
            a.put((Object)string2, (Object)string3);
            // ** MonitorExit[var4_2] (shouldn't be in output)
            return;
        }
    }

    private boolean b() {
        return ul.a(this.b);
    }

    private static String d(String string2) {
        reference var5_1 = vx.class;
        synchronized (vx.class) {
            for (Map.Entry entry : a.entrySet()) {
                String string3;
                string2 = string3 = string2.replace((CharSequence)entry.getKey(), (CharSequence)entry.getValue());
            }
            return string2;
        }
    }

    public void a() {
        this.b(this.d.toString());
        this.d = new StringBuilder();
    }

    public void a(String string2, Object object) {
        this.a("  %s:\t%s\n", string2, object);
    }

    public /* varargs */ void a(String string2, Object ... arrobject) {
        if (super.b()) {
            this.d.append(String.format((String)string2, (Object[])arrobject));
        }
    }

    public void b(String string2) {
        vx.a(this.b, this.e, this.c, string2);
    }

    public void c(String string2) {
        if (super.b()) {
            this.d.append(string2);
        }
    }
}

