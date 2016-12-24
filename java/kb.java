/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.Closeable
 *  java.io.EOFException
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.UnsupportedEncodingException
 *  java.lang.AssertionError
 *  java.lang.IllegalArgumentException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.charset.Charset
 */
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

class kb
implements Closeable {
    private final InputStream a;
    private final Charset b;
    private byte[] c;
    private int d;
    private int e;

    public kb(InputStream inputStream, int n2, Charset charset) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        }
        if (n2 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals((Object)kc.a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.a = inputStream;
        this.b = charset;
        this.c = new byte[n2];
    }

    public kb(InputStream inputStream, Charset charset) {
        super(inputStream, 8192, charset);
    }

    private void c() throws IOException {
        int n2 = this.a.read(this.c, 0, this.c.length);
        if (n2 == -1) {
            throw new EOFException();
        }
        this.d = 0;
        this.e = n2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String a() throws IOException {
        InputStream inputStream;
        InputStream inputStream2 = inputStream = this.a;
        synchronized (inputStream2) {
            if (this.c == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.d >= this.e) {
                this.c();
            }
            int n2 = this.d;
            do {
                if (n2 == this.e) break;
                if (this.c[n2] == 10) {
                    int n3 = n2 != this.d && this.c[n2 - 1] == 13 ? n2 - 1 : n2;
                    String string2 = new String(this.c, this.d, n3 - this.d, this.b.name());
                    this.d = n2 + 1;
                    return string2;
                }
                ++n2;
            } while (true);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(80 + (this.e - this.d)){

                /*
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 */
                public String toString() {
                    int n2 = this.count > 0 && this.buf[-1 + this.count] == 13 ? -1 + this.count : this.count;
                    try {
                        return new String(this.buf, 0, n2, kb.this.b.name());
                    }
                    catch (UnsupportedEncodingException var3_3) {
                        throw new AssertionError((Object)var3_3);
                    }
                }
            };
            block5 : do {
                byteArrayOutputStream.write(this.c, this.d, this.e - this.d);
                this.e = -1;
                this.c();
                int n4 = this.d;
                do {
                    if (n4 == this.e) continue block5;
                    if (this.c[n4] == 10) {
                        if (n4 != this.d) {
                            byteArrayOutputStream.write(this.c, this.d, n4 - this.d);
                        }
                        this.d = n4 + 1;
                        return byteArrayOutputStream.toString();
                    }
                    ++n4;
                } while (true);
                break;
            } while (true);
        }
    }

    public boolean b() {
        if (this.e == -1) {
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void close() throws IOException {
        InputStream inputStream;
        InputStream inputStream2 = inputStream = this.a;
        synchronized (inputStream2) {
            if (this.c != null) {
                this.c = null;
                this.a.close();
            }
            return;
        }
    }

}

