/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Queue
 */
import android.util.Log;
import java.util.Queue;

public final class rb {
    private static final rb b = new rb();
    private final Queue<byte[]> a = ri.a(0);

    private rb() {
    }

    public static rb a() {
        return b;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean a(byte[] arrby) {
        Queue<byte[]> queue;
        if (arrby.length != 65536) {
            return false;
        }
        Queue<byte[]> queue2 = queue = this.a;
        synchronized (queue2) {
            int n2 = this.a.size();
            boolean bl2 = false;
            if (n2 < 32) {
                bl2 = true;
                this.a.offer((Object)arrby);
            }
            return bl2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public byte[] b() {
        Queue<byte[]> queue;
        Queue<byte[]> queue2 = queue = this.a;
        // MONITORENTER : queue2
        byte[] arrby = (byte[])this.a.poll();
        // MONITOREXIT : queue2
        if (arrby != null) return arrby;
        arrby = new byte[65536];
        if (!Log.isLoggable((String)"ByteArrayPool", (int)3)) return arrby;
        Log.d((String)"ByteArrayPool", (String)"Created temp bytes");
        return arrby;
    }
}

