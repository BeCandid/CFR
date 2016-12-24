/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.FilterInputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Math
 *  java.lang.String
 */
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class rc
extends FilterInputStream {
    private final long a;
    private int b;

    rc(InputStream inputStream, long l2) {
        super(inputStream);
        this.a = l2;
    }

    /*
     * Enabled aggressive block sorting
     */
    private int a(int n2) throws IOException {
        if (n2 >= 0) {
            this.b = n2 + this.b;
            return n2;
        } else {
            if (this.a - (long)this.b <= 0) return n2;
            {
                throw new IOException("Failed to read all expected data, expected: " + this.a + ", but read: " + this.b);
            }
        }
    }

    public static InputStream a(InputStream inputStream, long l2) {
        return new rc(inputStream, l2);
    }

    public int available() throws IOException {
        rc rc2 = this;
        synchronized (rc2) {
            long l2 = Math.max((long)(this.a - (long)this.b), (long)this.in.available());
            int n2 = (int)l2;
            return n2;
        }
    }

    public int read() throws IOException {
        rc rc2 = this;
        synchronized (rc2) {
            int n2 = this.a(super.read());
            return n2;
        }
    }

    public int read(byte[] arrby) throws IOException {
        return this.read(arrby, 0, arrby.length);
    }

    public int read(byte[] arrby, int n2, int n3) throws IOException {
        void var6_4 = this;
        synchronized (var6_4) {
            int n4 = super.a(super.read(arrby, n2, n3));
            return n4;
        }
    }
}

