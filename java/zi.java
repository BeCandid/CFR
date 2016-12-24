/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.PowerManager
 *  android.os.PowerManager$WakeLock
 *  android.os.Process
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.List
 */
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import java.util.List;

public class zi {
    public static String a(PowerManager.WakeLock wakeLock, String string2) {
        String string3;
        String string4 = String.valueOf((Object)String.valueOf((long)((long)Process.myPid() << 32 | (long)System.identityHashCode((Object)wakeLock))));
        if (TextUtils.isEmpty((CharSequence)string2)) {
            string2 = "";
        }
        if ((string3 = String.valueOf((Object)string2)).length() != 0) {
            return string4.concat(string3);
        }
        return new String(string4);
    }

    static String a(String string2) {
        if ("com.google.android.gms".equals((Object)string2)) {
            string2 = null;
        }
        return string2;
    }

    static List<String> a(List<String> list) {
        if (list != null && list.size() == 1 && "com.google.android.gms".equals(list.get(0))) {
            list = null;
        }
        return list;
    }
}

