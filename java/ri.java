/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Looper
 *  java.lang.IllegalArgumentException
 *  java.lang.NoSuchFieldError
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayDeque
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Queue
 */
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Looper;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public final class ri {
    private static final char[] a = "0123456789abcdef".toCharArray();
    private static final char[] b = new char[64];
    private static final char[] c = new char[40];

    public static int a(int n2, int n3, Bitmap.Config config) {
        return n2 * n3 * ri.a(config);
    }

    private static int a(Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        switch (.a[config.ordinal()]) {
            default: {
                return 4;
            }
            case 1: {
                return 1;
            }
            case 2: 
            case 3: 
        }
        return 2;
    }

    @TargetApi(value=19)
    public static int a(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                int n2 = bitmap.getAllocationByteCount();
                return n2;
            }
            catch (NullPointerException var1_2) {
                // empty catch block
            }
        }
        return bitmap.getHeight() * bitmap.getRowBytes();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String a(byte[] arrby) {
        char[] arrc;
        char[] arrc2 = arrc = b;
        synchronized (arrc2) {
            return ri.a(arrby, b);
        }
    }

    private static String a(byte[] arrby, char[] arrc) {
        for (int i2 = 0; i2 < arrby.length; ++i2) {
            int n2 = 255 & arrby[i2];
            arrc[i2 * 2] = a[n2 >>> 4];
            arrc[1 + i2 * 2] = a[n2 & 15];
        }
        return new String(arrc);
    }

    public static <T> List<T> a(Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            arrayList.add(iterator.next());
        }
        return arrayList;
    }

    public static <T> Queue<T> a(int n2) {
        return new ArrayDeque(n2);
    }

    public static void a() {
        if (!ri.b()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static boolean a(int n2, int n3) {
        if (ri.b(n2) && ri.b(n3)) {
            return true;
        }
        return false;
    }

    public static boolean b() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return true;
        }
        return false;
    }

    private static boolean b(int n2) {
        if (n2 > 0 || n2 == Integer.MIN_VALUE) {
            return true;
        }
        return false;
    }

    public static boolean c() {
        if (!ri.b()) {
            return true;
        }
        return false;
    }

}

