/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.FilterInputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Math
 */
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class rg
extends FilterInputStream {
    private int a = Integer.MIN_VALUE;

    public rg(InputStream inputStream) {
        super(inputStream);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private long a(long l2) {
        if (this.a == 0) {
            return -1;
        }
        if (this.a == Integer.MIN_VALUE) return l2;
        if (l2 <= (long)this.a) return l2;
        return this.a;
    }

    private void b(long l2) {
        if (this.a != Integer.MIN_VALUE && l2 != -1) {
            this.a = (int)((long)this.a - l2);
        }
    }

    public int available() throws IOException {
        if (this.a == Integer.MIN_VALUE) {
            return super.available();
        }
        return Math.min((int)this.a, (int)super.available());
    }

    public void mark(int n2) {
        super.mark(n2);
        this.a = n2;
    }

    public int read() throws IOException {
        if (this.a(1) == -1) {
            return -1;
        }
        int n2 = super.read();
        this.b(1);
        return n2;
    }

    public int read(byte[] arrby, int n2, int n3) throws IOException {
        int n4 = (int)super.a(n3);
        if (n4 == -1) {
            return -1;
        }
        int n5 = super.read(arrby, n2, n4);
        super.b(n5);
        return n5;
    }

    public void reset() throws IOException {
        super.reset();
        this.a = Integer.MIN_VALUE;
    }

    public long skip(long l2) throws IOException {
        long l3 = super.a(l2);
        if (l3 == -1) {
            return -1;
        }
        long l4 = super.skip(l3);
        super.b(l4);
        return l4;
    }
}

