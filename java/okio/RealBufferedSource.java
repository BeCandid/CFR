/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.EOFException
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.AssertionError
 *  java.lang.Byte
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.charset.Charset
 */
package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import okio.Util;

final class RealBufferedSource
implements BufferedSource {
    public final Buffer buffer;
    private boolean closed;
    public final Source source;

    public RealBufferedSource(Source source) {
        super(source, new Buffer());
    }

    public RealBufferedSource(Source source, Buffer buffer) {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.buffer = buffer;
        this.source = source;
    }

    private boolean rangeEquals(long l2, ByteString byteString) throws IOException {
        if (this.request(l2 + (long)byteString.size()) && this.buffer.rangeEquals(l2, byteString)) {
            return true;
        }
        return false;
    }

    @Override
    public Buffer buffer() {
        return this.buffer;
    }

    @Override
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.source.close();
        this.buffer.clear();
    }

    @Override
    public boolean exhausted() throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (this.buffer.exhausted() && this.source.read(this.buffer, 2048) == -1) {
            return true;
        }
        return false;
    }

    @Override
    public long indexOf(byte by2) throws IOException {
        return this.indexOf(by2, 0);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public long indexOf(byte by2, long l2) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (l2 >= this.buffer.size) {
            if (this.source.read(this.buffer, 2048) != -1) continue;
            return -1;
        }
        do {
            long l3;
            if ((l3 = this.buffer.indexOf(by2, l2)) != -1) return l3;
            l2 = this.buffer.size;
        } while (this.source.read(this.buffer, 2048) != -1);
        return -1;
    }

    @Override
    public long indexOf(ByteString byteString) throws IOException {
        return this.indexOf(byteString, 0);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public long indexOf(ByteString var1, long var2_2) throws IOException {
        if (var1.size() != 0) ** GOTO lbl4
        throw new IllegalArgumentException("bytes is empty");
lbl-1000: // 1 sources:
        {
            var2_2 = var4_3 + 1;
lbl4: // 2 sources:
            if ((var4_3 = this.indexOf(var1.getByte(0), var2_2)) != -1) continue;
            return -1;
            ** while (!super.rangeEquals((long)var4_3, (ByteString)var1))
        }
lbl7: // 1 sources:
        return var4_3;
    }

    @Override
    public long indexOfElement(ByteString byteString) throws IOException {
        return this.indexOfElement(byteString, 0);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public long indexOfElement(ByteString byteString, long l2) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (l2 >= this.buffer.size) {
            if (this.source.read(this.buffer, 2048) != -1) continue;
            return -1;
        }
        do {
            long l3;
            if ((l3 = this.buffer.indexOfElement(byteString, l2)) != -1) return l3;
            l2 = this.buffer.size;
        } while (this.source.read(this.buffer, 2048) != -1);
        return -1;
    }

    @Override
    public InputStream inputStream() {
        return new InputStream(){

            public int available() throws IOException {
                if (RealBufferedSource.this.closed) {
                    throw new IOException("closed");
                }
                return (int)Math.min((long)RealBufferedSource.this.buffer.size, (long)Integer.MAX_VALUE);
            }

            public void close() throws IOException {
                RealBufferedSource.this.close();
            }

            public int read() throws IOException {
                if (RealBufferedSource.this.closed) {
                    throw new IOException("closed");
                }
                if (RealBufferedSource.this.buffer.size == 0 && RealBufferedSource.this.source.read(RealBufferedSource.this.buffer, 2048) == -1) {
                    return -1;
                }
                return 255 & RealBufferedSource.this.buffer.readByte();
            }

            public int read(byte[] arrby, int n2, int n3) throws IOException {
                if (RealBufferedSource.this.closed) {
                    throw new IOException("closed");
                }
                Util.checkOffsetAndCount(arrby.length, n2, n3);
                if (RealBufferedSource.this.buffer.size == 0 && RealBufferedSource.this.source.read(RealBufferedSource.this.buffer, 2048) == -1) {
                    return -1;
                }
                return RealBufferedSource.this.buffer.read(arrby, n2, n3);
            }

            public String toString() {
                return RealBufferedSource.this + ".inputStream()";
            }
        };
    }

    @Override
    public int read(byte[] arrby) throws IOException {
        return this.read(arrby, 0, arrby.length);
    }

    @Override
    public int read(byte[] arrby, int n2, int n3) throws IOException {
        Util.checkOffsetAndCount(arrby.length, n2, n3);
        if (this.buffer.size == 0 && this.source.read(this.buffer, 2048) == -1) {
            return -1;
        }
        int n4 = (int)Math.min((long)n3, (long)this.buffer.size);
        return this.buffer.read(arrby, n2, n4);
    }

    @Override
    public long read(Buffer buffer, long l2) throws IOException {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (l2 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + l2);
        }
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (this.buffer.size == 0 && this.source.read(this.buffer, 2048) == -1) {
            return -1;
        }
        long l3 = Math.min((long)l2, (long)this.buffer.size);
        return this.buffer.read(buffer, l3);
    }

    @Override
    public long readAll(Sink sink) throws IOException {
        if (sink == null) {
            throw new IllegalArgumentException("sink == null");
        }
        long l2 = 0;
        while (this.source.read(this.buffer, 2048) != -1) {
            long l3 = this.buffer.completeSegmentByteCount();
            if (l3 <= 0) continue;
            l2 += l3;
            sink.write(this.buffer, l3);
        }
        if (this.buffer.size() > 0) {
            l2 += this.buffer.size();
            sink.write(this.buffer, this.buffer.size());
        }
        return l2;
    }

    @Override
    public byte readByte() throws IOException {
        this.require(1);
        return this.buffer.readByte();
    }

    @Override
    public byte[] readByteArray() throws IOException {
        this.buffer.writeAll(this.source);
        return this.buffer.readByteArray();
    }

    @Override
    public byte[] readByteArray(long l2) throws IOException {
        this.require(l2);
        return this.buffer.readByteArray(l2);
    }

    @Override
    public ByteString readByteString() throws IOException {
        this.buffer.writeAll(this.source);
        return this.buffer.readByteString();
    }

    @Override
    public ByteString readByteString(long l2) throws IOException {
        this.require(l2);
        return this.buffer.readByteString(l2);
    }

    @Override
    public long readDecimalLong() throws IOException {
        this.require(1);
        int n2 = 0;
        while (this.request(n2 + 1)) {
            byte by2 = this.buffer.getByte(n2);
            if (!(by2 >= 48 && by2 <= 57 || n2 == 0 && by2 == 45)) {
                if (n2 != 0) break;
                Object[] arrobject = new Object[]{Byte.valueOf((byte)by2)};
                throw new NumberFormatException(String.format((String)"Expected leading [0-9] or '-' character but was %#x", (Object[])arrobject));
            }
            ++n2;
        }
        return this.buffer.readDecimalLong();
    }

    @Override
    public void readFully(Buffer buffer, long l2) throws IOException {
        try {
            this.require(l2);
        }
        catch (EOFException var4_3) {
            buffer.writeAll(this.buffer);
            throw var4_3;
        }
        this.buffer.readFully(buffer, l2);
    }

    @Override
    public void readFully(byte[] arrby) throws IOException {
        try {
            this.require(arrby.length);
        }
        catch (EOFException var2_2) {
            int n2 = 0;
            while (this.buffer.size > 0) {
                int n3 = this.buffer.read(arrby, n2, (int)this.buffer.size);
                if (n3 == -1) {
                    throw new AssertionError();
                }
                n2 += n3;
            }
            throw var2_2;
        }
        this.buffer.readFully(arrby);
    }

    @Override
    public long readHexadecimalUnsignedLong() throws IOException {
        this.require(1);
        int n2 = 0;
        while (this.request(n2 + 1)) {
            byte by2 = this.buffer.getByte(n2);
            if (!(by2 >= 48 && by2 <= 57 || by2 >= 97 && by2 <= 102 || by2 >= 65 && by2 <= 70)) {
                if (n2 != 0) break;
                Object[] arrobject = new Object[]{Byte.valueOf((byte)by2)};
                throw new NumberFormatException(String.format((String)"Expected leading [0-9a-fA-F] character but was %#x", (Object[])arrobject));
            }
            ++n2;
        }
        return this.buffer.readHexadecimalUnsignedLong();
    }

    @Override
    public int readInt() throws IOException {
        this.require(4);
        return this.buffer.readInt();
    }

    @Override
    public int readIntLe() throws IOException {
        this.require(4);
        return this.buffer.readIntLe();
    }

    @Override
    public long readLong() throws IOException {
        this.require(8);
        return this.buffer.readLong();
    }

    @Override
    public long readLongLe() throws IOException {
        this.require(8);
        return this.buffer.readLongLe();
    }

    @Override
    public short readShort() throws IOException {
        this.require(2);
        return this.buffer.readShort();
    }

    @Override
    public short readShortLe() throws IOException {
        this.require(2);
        return this.buffer.readShortLe();
    }

    @Override
    public String readString(long l2, Charset charset) throws IOException {
        this.require(l2);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        return this.buffer.readString(l2, charset);
    }

    @Override
    public String readString(Charset charset) throws IOException {
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        this.buffer.writeAll(this.source);
        return this.buffer.readString(charset);
    }

    @Override
    public String readUtf8() throws IOException {
        this.buffer.writeAll(this.source);
        return this.buffer.readUtf8();
    }

    @Override
    public String readUtf8(long l2) throws IOException {
        this.require(l2);
        return this.buffer.readUtf8(l2);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public int readUtf8CodePoint() throws IOException {
        this.require(1);
        byte by2 = this.buffer.getByte(0);
        if ((by2 & 224) == 192) {
            this.require(2);
            return this.buffer.readUtf8CodePoint();
        }
        if ((by2 & 240) == 224) {
            this.require(3);
            return this.buffer.readUtf8CodePoint();
        }
        if ((by2 & 248) != 240) return this.buffer.readUtf8CodePoint();
        this.require(4);
        return this.buffer.readUtf8CodePoint();
    }

    @Override
    public String readUtf8Line() throws IOException {
        long l2 = this.indexOf(10);
        if (l2 == -1) {
            if (this.buffer.size != 0) {
                return this.readUtf8(this.buffer.size);
            }
            return null;
        }
        return this.buffer.readUtf8Line(l2);
    }

    @Override
    public String readUtf8LineStrict() throws IOException {
        long l2 = this.indexOf(10);
        if (l2 == -1) {
            Buffer buffer = new Buffer();
            this.buffer.copyTo(buffer, 0, Math.min((long)32, (long)this.buffer.size()));
            throw new EOFException("\\n not found: size=" + this.buffer.size() + " content=" + buffer.readByteString().hex() + "...");
        }
        return this.buffer.readUtf8Line(l2);
    }

    @Override
    public boolean request(long l2) throws IOException {
        if (l2 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + l2);
        }
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (this.buffer.size < l2) {
            if (this.source.read(this.buffer, 2048) != -1) continue;
            return false;
        }
        return true;
    }

    @Override
    public void require(long l2) throws IOException {
        if (!this.request(l2)) {
            throw new EOFException();
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public void skip(long var1) throws IOException {
        if (!this.closed) ** GOTO lbl6
        throw new IllegalStateException("closed");
lbl-1000: // 1 sources:
        {
            var3_2 = Math.min((long)var1, (long)this.buffer.size());
            this.buffer.skip(var3_2);
            var1 -= var3_2;
lbl6: // 2 sources:
            if (var1 <= 0) return;
            ** while (this.buffer.size != 0 || this.source.read((Buffer)this.buffer, (long)2048) != -1)
        }
lbl8: // 1 sources:
        throw new EOFException();
    }

    @Override
    public Timeout timeout() {
        return this.source.timeout();
    }

    public String toString() {
        return "buffer(" + this.source + ")";
    }

}

