/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 */
import java.io.IOException;

public final class akk {
    public static final int[] a = new int[0];
    public static final long[] b = new long[0];
    public static final float[] c = new float[0];
    public static final double[] d = new double[0];
    public static final boolean[] e = new boolean[0];
    public static final String[] f = new String[0];
    public static final byte[][] g = new byte[0][];
    public static final byte[] h = new byte[0];

    static int a(int n2) {
        return n2 & 7;
    }

    static int a(int n2, int n3) {
        return n3 | n2 << 3;
    }

    public static boolean a(akg akg2, int n2) throws IOException {
        return akg2.b(n2);
    }

    public static int b(int n2) {
        return n2 >>> 3;
    }

    public static final int b(akg akg2, int n2) throws IOException {
        int n3 = 1;
        int n4 = akg2.j();
        akg2.b(n2);
        while (akg2.a() == n2) {
            akg2.b(n2);
            ++n3;
        }
        akg2.e(n4);
        return n3;
    }
}

