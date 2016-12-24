/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 */
import android.os.Looper;
import android.text.TextUtils;

public final class xz {
    public static <T> T a(T t2) {
        if (t2 == null) {
            throw new NullPointerException("null reference");
        }
        return t2;
    }

    public static <T> T a(T t2, Object object) {
        if (t2 == null) {
            throw new NullPointerException(String.valueOf((Object)object));
        }
        return t2;
    }

    public static String a(String string2) {
        if (TextUtils.isEmpty((CharSequence)string2)) {
            throw new IllegalArgumentException("Given String is empty or null");
        }
        return string2;
    }

    public static String a(String string2, Object object) {
        if (TextUtils.isEmpty((CharSequence)string2)) {
            throw new IllegalArgumentException(String.valueOf((Object)object));
        }
        return string2;
    }

    public static void a(boolean bl2) {
        if (!bl2) {
            throw new IllegalStateException();
        }
    }

    public static void a(boolean bl2, Object object) {
        if (!bl2) {
            throw new IllegalStateException(String.valueOf((Object)object));
        }
    }

    public static void b(String string2) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException(string2);
        }
    }

    public static void b(boolean bl2) {
        if (!bl2) {
            throw new IllegalArgumentException();
        }
    }

    public static void b(boolean bl2, Object object) {
        if (!bl2) {
            throw new IllegalArgumentException(String.valueOf((Object)object));
        }
    }

    public static void c(String string2) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException(string2);
        }
    }
}

