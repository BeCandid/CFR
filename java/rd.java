/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 *  java.util.Queue
 */
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

public class rd
extends InputStream {
    private static final Queue<rd> a = ri.a(0);
    private InputStream b;
    private IOException c;

    rd() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static rd a(InputStream inputStream) {
        Queue<rd> queue;
        Queue<rd> queue2 = queue = a;
        // MONITORENTER : queue2
        rd rd2 = (rd)((Object)a.poll());
        // MONITOREXIT : queue2
        if (rd2 == null) {
            rd2 = new rd();
        }
        rd2.b(inputStream);
        return rd2;
    }

    public IOException a() {
        return this.c;
    }

    public int available() throws IOException {
        return this.b.available();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b() {
        Queue<rd> queue;
        this.c = null;
        this.b = null;
        Queue<rd> queue2 = queue = a;
        synchronized (queue2) {
            a.offer((Object)this);
            return;
        }
    }

    void b(InputStream inputStream) {
        this.b = inputStream;
    }

    public void close() throws IOException {
        this.b.close();
    }

    public void mark(int n2) {
        this.b.mark(n2);
    }

    public boolean markSupported() {
        return this.b.markSupported();
    }

    public int read() throws IOException {
        try {
            int n2 = this.b.read();
            return n2;
        }
        catch (IOException var1_2) {
            this.c = var1_2;
            return -1;
        }
    }

    public int read(byte[] arrby) throws IOException {
        try {
            int n2 = this.b.read(arrby);
            return n2;
        }
        catch (IOException var2_3) {
            this.c = var2_3;
            return -1;
        }
    }

    public int read(byte[] arrby, int n2, int n3) throws IOException {
        try {
            int n4 = this.b.read(arrby, n2, n3);
            return n4;
        }
        catch (IOException var4_5) {
            this.c = var4_5;
            return -1;
        }
    }

    public void reset() throws IOException {
        rd rd2 = this;
        synchronized (rd2) {
            this.b.reset();
            return;
        }
    }

    public long skip(long l2) throws IOException {
        try {
            long l3 = this.b.skip(l2);
            return l3;
        }
        catch (IOException var3_3) {
            this.c = var3_3;
            return 0;
        }
    }
}

