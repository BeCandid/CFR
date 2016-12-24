/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.EOFException
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.AssertionError
 *  java.lang.CloneNotSupportedException
 *  java.lang.Cloneable
 *  java.lang.IllegalAccessError
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.nio.charset.Charset
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.List
 */
package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Segment;
import okio.SegmentPool;
import okio.SegmentedByteString;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import okio.Util;

public final class Buffer
implements Cloneable,
BufferedSink,
BufferedSource {
    private static final byte[] DIGITS = new byte[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    static final int REPLACEMENT_CHARACTER = 65533;
    Segment head;
    long size;

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void readFrom(InputStream var1_1, long var2_3, boolean var4) throws IOException {
        if (var1_1 != null) ** GOTO lbl6
        throw new IllegalArgumentException("in == null");
lbl-1000: // 1 sources:
        {
            var5_5.limit = var7_4 + var5_5.limit;
            this.size += (long)var7_4;
            var2_3 -= (long)var7_4;
lbl6: // 2 sources:
            if (var2_3 <= 0) {
                if (var4 == false) return;
            }
            var5_5 = this.writableSegment(1);
            ** while ((var7_4 = var1_1.read((byte[])var5_5.data, (int)var5_5.limit, (int)(var6_6 = (int)Math.min((long)var2_3, (long)((long)(2048 - var5_5.limit)))))) != -1)
        }
lbl10: // 1 sources:
        if (var4 == false) throw new EOFException();
    }

    @Override
    public Buffer buffer() {
        return this;
    }

    public void clear() {
        try {
            this.skip(this.size);
            return;
        }
        catch (EOFException var1_1) {
            throw new AssertionError((Object)var1_1);
        }
    }

    public Buffer clone() {
        Segment segment;
        Buffer buffer = new Buffer();
        if (this.size == 0) {
            return buffer;
        }
        Segment segment2 = buffer.head = new Segment(this.head);
        Segment segment3 = buffer.head;
        segment3.prev = segment = buffer.head;
        segment2.next = segment;
        Segment segment4 = this.head.next;
        while (segment4 != this.head) {
            buffer.head.prev.push(new Segment(segment4));
            segment4 = segment4.next;
        }
        buffer.size = this.size;
        return buffer;
    }

    @Override
    public void close() {
    }

    public long completeSegmentByteCount() {
        long l2 = this.size;
        if (l2 == 0) {
            return 0;
        }
        Segment segment = this.head.prev;
        if (segment.limit < 2048 && segment.owner) {
            l2 -= (long)(segment.limit - segment.pos);
        }
        return l2;
    }

    public Buffer copyTo(OutputStream outputStream) throws IOException {
        return this.copyTo(outputStream, 0, this.size);
    }

    /*
     * Enabled aggressive block sorting
     */
    public Buffer copyTo(OutputStream outputStream, long l2, long l3) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        Util.checkOffsetAndCount(this.size, l2, l3);
        if (l3 != 0) {
            Segment segment = this.head;
            while (l2 >= (long)(segment.limit - segment.pos)) {
                l2 -= (long)(segment.limit - segment.pos);
                segment = segment.next;
            }
            while (l3 > 0) {
                int n2 = (int)(l2 + (long)segment.pos);
                int n3 = (int)Math.min((long)(segment.limit - n2), (long)l3);
                outputStream.write(segment.data, n2, n3);
                l3 -= (long)n3;
                l2 = 0;
                segment = segment.next;
            }
        }
        return this;
    }

    /*
     * Enabled aggressive block sorting
     */
    public Buffer copyTo(Buffer buffer, long l2, long l3) {
        if (buffer == null) {
            throw new IllegalArgumentException("out == null");
        }
        Util.checkOffsetAndCount(this.size, l2, l3);
        if (l3 != 0) {
            buffer.size = l3 + buffer.size;
            Segment segment = this.head;
            while (l2 >= (long)(segment.limit - segment.pos)) {
                l2 -= (long)(segment.limit - segment.pos);
                segment = segment.next;
            }
            while (l3 > 0) {
                Segment segment2 = new Segment(segment);
                segment2.pos = (int)(l2 + (long)segment2.pos);
                segment2.limit = Math.min((int)(segment2.pos + (int)l3), (int)segment2.limit);
                if (buffer.head == null) {
                    segment2.prev = segment2;
                    segment2.next = segment2;
                    buffer.head = segment2;
                } else {
                    buffer.head.prev.push(segment2);
                }
                l3 -= (long)(segment2.limit - segment2.pos);
                l2 = 0;
                segment = segment.next;
            }
        }
        return this;
    }

    @Override
    public BufferedSink emit() {
        return this;
    }

    @Override
    public Buffer emitCompleteSegments() {
        return this;
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Buffer)) {
            return false;
        }
        Buffer buffer = (Buffer)object;
        if (this.size != buffer.size) {
            return false;
        }
        if (this.size == 0) {
            return true;
        }
        Segment segment = this.head;
        Segment segment2 = buffer.head;
        int n2 = segment.pos;
        int n3 = segment2.pos;
        long l2 = 0;
        while (l2 < this.size) {
            long l3 = Math.min((int)(segment.limit - n2), (int)(segment2.limit - n3));
            int n4 = 0;
            int n5 = n3;
            int n6 = n2;
            while ((long)n4 < l3) {
                byte[] arrby = segment.data;
                int n7 = n6 + 1;
                byte by2 = arrby[n6];
                byte[] arrby2 = segment2.data;
                int n8 = n5 + 1;
                if (by2 != arrby2[n5]) {
                    return false;
                }
                ++n4;
                n5 = n8;
                n6 = n7;
            }
            if (n6 == segment.limit) {
                segment = segment.next;
                n2 = segment.pos;
            } else {
                n2 = n6;
            }
            if (n5 == segment2.limit) {
                segment2 = segment2.next;
                n3 = segment2.pos;
            } else {
                n3 = n5;
            }
            l2 += l3;
        }
        return true;
    }

    @Override
    public boolean exhausted() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void flush() {
    }

    public byte getByte(long l2) {
        Util.checkOffsetAndCount(this.size, l2, 1);
        Segment segment = this.head;
        int n2;
        while (l2 >= (long)(n2 = segment.limit - segment.pos)) {
            l2 -= (long)n2;
            segment = segment.next;
        }
        return segment.data[segment.pos + (int)l2];
    }

    public int hashCode() {
        Segment segment = this.head;
        if (segment == null) {
            return 0;
        }
        int n2 = 1;
        do {
            int n3 = segment.limit;
            for (int i2 = segment.pos; i2 < n3; ++i2) {
                n2 = n2 * 31 + segment.data[i2];
            }
        } while ((segment = segment.next) != this.head);
        return n2;
    }

    @Override
    public long indexOf(byte by2) {
        return this.indexOf(by2, 0);
    }

    /*
     * Unable to fully structure code
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public long indexOf(byte var1, long var2_2) {
        if (var2_2 < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        var4_3 = this.head;
        if (var4_3 == null) {
            return -1;
        }
        var5_4 = 0;
        block0 : while (var2_2 >= (long)(var7_8 = var4_3.limit - var4_3.pos)) {
            var2_2 -= (long)var7_8;
lbl9: // 2 sources:
            do {
                var5_4 += (long)var7_8;
                var4_3 = var4_3.next;
                if (var4_3 != this.head) continue block0;
                return -1;
                break;
            } while (true);
        }
        var8_5 = var4_3.data;
        var10_7 = var4_3.limit;
        for (var9_6 = (int)(var2_2 + (long)var4_3.pos); var9_6 < var10_7; ++var9_6) {
            if (var8_5[var9_6] != var1) continue;
            return var5_4 + (long)var9_6 - (long)var4_3.pos;
        }
        var2_2 = 0;
        ** while (true)
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
            ** while (!this.rangeEquals((long)var4_3, (ByteString)var1))
        }
lbl7: // 1 sources:
        return var4_3;
    }

    @Override
    public long indexOfElement(ByteString byteString) {
        return this.indexOfElement(byteString, 0);
    }

    /*
     * Unable to fully structure code
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public long indexOfElement(ByteString var1, long var2_2) {
        if (var2_2 < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        var4_3 = this.head;
        if (var4_3 == null) {
            return -1;
        }
        var5_4 = 0;
        var7_5 = var1.toByteArray();
        block0 : while (var2_2 >= (long)(var8_6 = var4_3.limit - var4_3.pos)) {
            var2_2 -= (long)var8_6;
lbl10: // 2 sources:
            do {
                var5_4 += (long)var8_6;
                var4_3 = var4_3.next;
                if (var4_3 != this.head) continue block0;
                return -1;
                break;
            } while (true);
        }
        var9_7 = var4_3.data;
        var12_8 = var4_3.limit;
        for (var10_10 = var2_2 + (long)var4_3.pos; var10_10 < var12_8; ++var10_10) {
            var14_9 = var9_7[(int)var10_10];
            var15_12 = var7_5.length;
            for (var16_11 = 0; var16_11 < var15_12; ++var16_11) {
                if (var14_9 != var7_5[var16_11]) continue;
                return var5_4 + var10_10 - (long)var4_3.pos;
            }
        }
        var2_2 = 0;
        ** while (true)
    }

    @Override
    public InputStream inputStream() {
        return new InputStream(){

            public int available() {
                return (int)Math.min((long)Buffer.this.size, (long)Integer.MAX_VALUE);
            }

            public void close() {
            }

            public int read() {
                if (Buffer.this.size > 0) {
                    return 255 & Buffer.this.readByte();
                }
                return -1;
            }

            public int read(byte[] arrby, int n2, int n3) {
                return Buffer.this.read(arrby, n2, n3);
            }

            public String toString() {
                return Buffer.this + ".inputStream()";
            }
        };
    }

    @Override
    public OutputStream outputStream() {
        return new OutputStream(){

            public void close() {
            }

            public void flush() {
            }

            public String toString() {
                return (Object)((Object)this) + ".outputStream()";
            }

            public void write(int n2) {
                Buffer.this.writeByte((byte)n2);
            }

            public void write(byte[] arrby, int n2, int n3) {
                Buffer.this.write(arrby, n2, n3);
            }
        };
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    boolean rangeEquals(long l2, ByteString byteString) {
        int n2 = byteString.size();
        if (this.size - l2 < (long)n2) {
            return false;
        }
        int n3 = 0;
        while (n3 < n2) {
            if (this.getByte(l2 + (long)n3) != byteString.getByte(n3)) return false;
            ++n3;
        }
        return true;
    }

    @Override
    public int read(byte[] arrby) {
        return this.read(arrby, 0, arrby.length);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public int read(byte[] arrby, int n2, int n3) {
        Util.checkOffsetAndCount(arrby.length, n2, n3);
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int n4 = Math.min((int)n3, (int)(segment.limit - segment.pos));
        System.arraycopy((Object)segment.data, (int)segment.pos, (Object)arrby, (int)n2, (int)n4);
        segment.pos = n4 + segment.pos;
        this.size -= (long)n4;
        if (segment.pos != segment.limit) return n4;
        this.head = segment.pop();
        SegmentPool.recycle(segment);
        return n4;
    }

    @Override
    public long read(Buffer buffer, long l2) {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (l2 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + l2);
        }
        if (this.size == 0) {
            return -1;
        }
        if (l2 > this.size) {
            l2 = this.size;
        }
        buffer.write((Buffer)this, l2);
        return l2;
    }

    @Override
    public long readAll(Sink sink) throws IOException {
        long l2 = this.size;
        if (l2 > 0) {
            sink.write((Buffer)this, l2);
        }
        return l2;
    }

    @Override
    public byte readByte() {
        if (this.size == 0) {
            throw new IllegalStateException("size == 0");
        }
        Segment segment = this.head;
        int n2 = segment.pos;
        int n3 = segment.limit;
        byte[] arrby = segment.data;
        int n4 = n2 + 1;
        byte by2 = arrby[n2];
        --this.size;
        if (n4 == n3) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
            return by2;
        }
        segment.pos = n4;
        return by2;
    }

    @Override
    public byte[] readByteArray() {
        try {
            byte[] arrby = this.readByteArray(this.size);
            return arrby;
        }
        catch (EOFException var1_2) {
            throw new AssertionError((Object)var1_2);
        }
    }

    @Override
    public byte[] readByteArray(long l2) throws EOFException {
        Util.checkOffsetAndCount(this.size, 0, l2);
        if (l2 > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + l2);
        }
        byte[] arrby = new byte[(int)l2];
        this.readFully(arrby);
        return arrby;
    }

    @Override
    public ByteString readByteString() {
        return new ByteString(this.readByteArray());
    }

    @Override
    public ByteString readByteString(long l2) throws EOFException {
        return new ByteString(this.readByteArray(l2));
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public long readDecimalLong() {
        if (this.size == 0) {
            throw new IllegalStateException("size == 0");
        }
        long l2 = 0;
        int n2 = 0;
        boolean bl2 = false;
        boolean bl3 = false;
        long l3 = -7;
        do {
            int n3;
            Segment segment = this.head;
            byte[] arrby = segment.data;
            int n4 = segment.limit;
            for (n3 = segment.pos; n3 < n4; ++n3, ++n2) {
                byte by2 = arrby[n3];
                if (by2 >= 48 && by2 <= 57) {
                    int n5 = 48 - by2;
                    if (l2 < -922337203685477580L || l2 == -922337203685477580L && (long)n5 < l3) {
                        Buffer buffer = new Buffer().writeDecimalLong(l2).writeByte(by2);
                        if (!bl2) {
                            buffer.readByte();
                        }
                        throw new NumberFormatException("Number too large: " + buffer.readUtf8());
                    }
                    l2 = l2 * 10 + (long)n5;
                    continue;
                }
                if (by2 == 45 && n2 == 0) {
                    bl2 = true;
                    --l3;
                    continue;
                }
                if (n2 == 0) {
                    throw new NumberFormatException("Expected leading [0-9] or '-' character but was 0x" + Integer.toHexString((int)by2));
                }
                bl3 = true;
                break;
            }
            if (n3 == n4) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
                continue;
            }
            segment.pos = n3;
        } while (!bl3 && this.head != null);
        this.size -= (long)n2;
        if (bl2) {
            return l2;
        }
        return - l2;
    }

    public Buffer readFrom(InputStream inputStream) throws IOException {
        super.readFrom(inputStream, Long.MAX_VALUE, true);
        return this;
    }

    public Buffer readFrom(InputStream inputStream, long l2) throws IOException {
        if (l2 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + l2);
        }
        super.readFrom(inputStream, l2, false);
        return this;
    }

    @Override
    public void readFully(Buffer buffer, long l2) throws EOFException {
        if (this.size < l2) {
            buffer.write((Buffer)this, this.size);
            throw new EOFException();
        }
        buffer.write((Buffer)this, l2);
    }

    @Override
    public void readFully(byte[] arrby) throws EOFException {
        int n2;
        for (int i2 = 0; i2 < arrby.length; i2 += n2) {
            n2 = this.read(arrby, i2, arrby.length - i2);
            if (n2 != -1) continue;
            throw new EOFException();
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public long readHexadecimalUnsignedLong() {
        if (this.size == 0) {
            throw new IllegalStateException("size == 0");
        }
        var1_1 = 0;
        var3_2 = 0;
        var4_3 = false;
        do {
            var5_6 = this.head;
            var6_9 = var5_6.data;
            var8_4 = var5_6.limit;
            for (var7_8 = var5_6.pos; var7_8 < var8_4; ++var7_8, ++var3_2) {
                var9_5 = var6_9[var7_8];
                if (var9_5 < 48 || var9_5 > 57) ** GOTO lbl15
                var10_7 = var9_5 - 48;
                ** GOTO lbl20
lbl15: // 1 sources:
                if (var9_5 < 97 || var9_5 > 102) ** GOTO lbl18
                var10_7 = 10 + (var9_5 - 97);
                ** GOTO lbl20
lbl18: // 1 sources:
                if (var9_5 >= 65 && var9_5 <= 70) {
                    var10_7 = 10 + (var9_5 - 65);
lbl20: // 3 sources:
                    if ((-1152921504606846976L & var1_1) != 0) {
                        var11_10 = new Buffer().writeHexadecimalUnsignedLong(var1_1).writeByte(var9_5);
                        throw new NumberFormatException("Number too large: " + var11_10.readUtf8());
                    }
                } else {
                    if (var3_2 == 0) {
                        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString((int)var9_5));
                    }
                    var4_3 = true;
                    break;
                }
                var1_1 = var1_1 << 4 | (long)var10_7;
            }
            if (var7_8 == var8_4) {
                this.head = var5_6.pop();
                SegmentPool.recycle(var5_6);
                continue;
            }
            var5_6.pos = var7_8;
        } while (!var4_3 && this.head != null);
        this.size -= (long)var3_2;
        return var1_1;
    }

    @Override
    public int readInt() {
        if (this.size < 4) {
            throw new IllegalStateException("size < 4: " + this.size);
        }
        Segment segment = this.head;
        int n2 = segment.limit;
        int n3 = segment.pos;
        if (n2 - n3 < 4) {
            return (255 & this.readByte()) << 24 | (255 & this.readByte()) << 16 | (255 & this.readByte()) << 8 | 255 & this.readByte();
        }
        byte[] arrby = segment.data;
        int n4 = n3 + 1;
        int n5 = (255 & arrby[n3]) << 24;
        int n6 = n4 + 1;
        int n7 = n5 | (255 & arrby[n4]) << 16;
        int n8 = n6 + 1;
        int n9 = n7 | (255 & arrby[n6]) << 8;
        int n10 = n8 + 1;
        int n11 = n9 | 255 & arrby[n8];
        this.size -= 4;
        if (n10 == n2) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
            return n11;
        }
        segment.pos = n10;
        return n11;
    }

    @Override
    public int readIntLe() {
        return Util.reverseBytesInt(this.readInt());
    }

    @Override
    public long readLong() {
        if (this.size < 8) {
            throw new IllegalStateException("size < 8: " + this.size);
        }
        Segment segment = this.head;
        int n2 = segment.limit;
        int n3 = segment.pos;
        if (n2 - n3 < 8) {
            return (0xFFFFFFFFL & (long)this.readInt()) << 32 | 0xFFFFFFFFL & (long)this.readInt();
        }
        byte[] arrby = segment.data;
        int n4 = n3 + 1;
        long l2 = (255 & (long)arrby[n3]) << 56;
        int n5 = n4 + 1;
        long l3 = l2 | (255 & (long)arrby[n4]) << 48;
        int n6 = n5 + 1;
        long l4 = l3 | (255 & (long)arrby[n5]) << 40;
        int n7 = n6 + 1;
        long l5 = l4 | (255 & (long)arrby[n6]) << 32;
        int n8 = n7 + 1;
        long l6 = l5 | (255 & (long)arrby[n7]) << 24;
        int n9 = n8 + 1;
        long l7 = l6 | (255 & (long)arrby[n8]) << 16;
        int n10 = n9 + 1;
        long l8 = l7 | (255 & (long)arrby[n9]) << 8;
        int n11 = n10 + 1;
        long l9 = l8 | 255 & (long)arrby[n10];
        this.size -= 8;
        if (n11 == n2) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
            return l9;
        }
        segment.pos = n11;
        return l9;
    }

    @Override
    public long readLongLe() {
        return Util.reverseBytesLong(this.readLong());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public short readShort() {
        if (this.size < 2) {
            throw new IllegalStateException("size < 2: " + this.size);
        }
        Segment segment = this.head;
        int n2 = segment.limit;
        int n3 = segment.pos;
        if (n2 - n3 < 2) {
            return (short)((255 & this.readByte()) << 8 | 255 & this.readByte());
        }
        byte[] arrby = segment.data;
        int n4 = n3 + 1;
        int n5 = (255 & arrby[n3]) << 8;
        int n6 = n4 + 1;
        int n7 = n5 | 255 & arrby[n4];
        this.size -= 2;
        if (n6 == n2) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
            do {
                return (short)n7;
                break;
            } while (true);
        }
        segment.pos = n6;
        return (short)n7;
    }

    @Override
    public short readShortLe() {
        return Util.reverseBytesShort(this.readShort());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public String readString(long l2, Charset charset) throws EOFException {
        Util.checkOffsetAndCount(this.size, 0, l2);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (l2 > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + l2);
        }
        if (l2 == 0) {
            return "";
        }
        Segment segment = this.head;
        if (l2 + (long)segment.pos > (long)segment.limit) {
            return new String(this.readByteArray(l2), charset);
        }
        String string2 = new String(segment.data, segment.pos, (int)l2, charset);
        segment.pos = (int)(l2 + (long)segment.pos);
        this.size -= l2;
        if (segment.pos != segment.limit) return string2;
        this.head = segment.pop();
        SegmentPool.recycle(segment);
        return string2;
    }

    @Override
    public String readString(Charset charset) {
        try {
            String string2 = this.readString(this.size, charset);
            return string2;
        }
        catch (EOFException var2_3) {
            throw new AssertionError((Object)var2_3);
        }
    }

    @Override
    public String readUtf8() {
        try {
            String string2 = this.readString(this.size, Util.UTF_8);
            return string2;
        }
        catch (EOFException var1_2) {
            throw new AssertionError((Object)var1_2);
        }
    }

    @Override
    public String readUtf8(long l2) throws EOFException {
        return this.readString(l2, Util.UTF_8);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public int readUtf8CodePoint() throws EOFException {
        int n2;
        int n3;
        int n4;
        if (this.size == 0) {
            throw new EOFException();
        }
        byte by2 = this.getByte(0);
        if ((by2 & 128) == 0) {
            n4 = by2 & 127;
            n3 = 1;
            n2 = 0;
        } else if ((by2 & 224) == 192) {
            n4 = by2 & 31;
            n3 = 2;
            n2 = 128;
        } else if ((by2 & 240) == 224) {
            n4 = by2 & 15;
            n3 = 3;
            n2 = 2048;
        } else {
            if ((by2 & 248) != 240) {
                this.skip(1);
                return 65533;
            }
            n4 = by2 & 7;
            n3 = 4;
            n2 = 65536;
        }
        if (this.size < (long)n3) {
            throw new EOFException("size < " + n3 + ": " + this.size + " (to read code point prefixed 0x" + Integer.toHexString((int)by2) + ")");
        }
        for (int i2 = 1; i2 < n3; ++i2) {
            byte by3 = this.getByte(i2);
            if ((by3 & 192) != 128) {
                this.skip(i2);
                return 65533;
            }
            n4 = n4 << 6 | by3 & 63;
        }
        this.skip(n3);
        if (n4 > 1114111) {
            return 65533;
        }
        if (n4 >= 55296 && n4 <= 57343) {
            return 65533;
        }
        if (n4 >= n2) return n4;
        return 65533;
    }

    @Override
    public String readUtf8Line() throws EOFException {
        long l2 = this.indexOf(10);
        if (l2 == -1) {
            if (this.size != 0) {
                return this.readUtf8(this.size);
            }
            return null;
        }
        return this.readUtf8Line(l2);
    }

    String readUtf8Line(long l2) throws EOFException {
        if (l2 > 0 && this.getByte(l2 - 1) == 13) {
            String string2 = this.readUtf8(l2 - 1);
            this.skip(2);
            return string2;
        }
        String string3 = this.readUtf8(l2);
        this.skip(1);
        return string3;
    }

    @Override
    public String readUtf8LineStrict() throws EOFException {
        long l2 = this.indexOf(10);
        if (l2 == -1) {
            Buffer buffer = new Buffer();
            this.copyTo(buffer, 0, Math.min((long)32, (long)this.size));
            throw new EOFException("\\n not found: size=" + this.size() + " content=" + buffer.readByteString().hex() + "...");
        }
        return this.readUtf8Line(l2);
    }

    @Override
    public boolean request(long l2) {
        if (this.size >= l2) {
            return true;
        }
        return false;
    }

    @Override
    public void require(long l2) throws EOFException {
        if (this.size < l2) {
            throw new EOFException();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    List<Integer> segmentSizes() {
        if (this.head == null) {
            return Collections.emptyList();
        }
        List list = new ArrayList();
        list.add((Object)(this.head.limit - this.head.pos));
        Segment segment = this.head.next;
        while (segment != this.head) {
            list.add((Object)(segment.limit - segment.pos));
            segment = segment.next;
        }
        return list;
    }

    public long size() {
        return this.size;
    }

    @Override
    public void skip(long l2) throws EOFException {
        while (l2 > 0) {
            if (this.head == null) {
                throw new EOFException();
            }
            int n2 = (int)Math.min((long)l2, (long)(this.head.limit - this.head.pos));
            this.size -= (long)n2;
            l2 -= (long)n2;
            Segment segment = this.head;
            segment.pos = n2 + segment.pos;
            if (this.head.pos != this.head.limit) continue;
            Segment segment2 = this.head;
            this.head = segment2.pop();
            SegmentPool.recycle(segment2);
        }
    }

    public ByteString snapshot() {
        if (this.size > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.size);
        }
        return this.snapshot((int)this.size);
    }

    public ByteString snapshot(int n2) {
        if (n2 == 0) {
            return ByteString.EMPTY;
        }
        return new SegmentedByteString((Buffer)this, n2);
    }

    @Override
    public Timeout timeout() {
        return Timeout.NONE;
    }

    public String toString() {
        if (this.size == 0) {
            return "Buffer[size=0]";
        }
        if (this.size <= 16) {
            ByteString byteString = this.clone().readByteString();
            Object[] arrobject = new Object[]{this.size, byteString.hex()};
            return String.format((String)"Buffer[size=%s data=%s]", (Object[])arrobject);
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance((String)"MD5");
            messageDigest.update(this.head.data, this.head.pos, this.head.limit - this.head.pos);
            Segment segment = this.head.next;
            while (segment != this.head) {
                messageDigest.update(segment.data, segment.pos, segment.limit - segment.pos);
                segment = segment.next;
            }
            Object[] arrobject = new Object[]{this.size, ByteString.of(messageDigest.digest()).hex()};
            String string2 = String.format((String)"Buffer[size=%s md5=%s]", (Object[])arrobject);
            return string2;
        }
        catch (NoSuchAlgorithmException var1_7) {
            throw new AssertionError();
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    Segment writableSegment(int n2) {
        Segment segment;
        if (n2 < 1 || n2 > 2048) {
            throw new IllegalArgumentException();
        }
        if (this.head == null) {
            Segment segment2 = this.head = SegmentPool.take();
            Segment segment3 = this.head;
            segment3.prev = segment = this.head;
            segment2.next = segment;
            return segment;
        } else {
            segment = this.head.prev;
            if (n2 + segment.limit <= 2048 && segment.owner) return segment;
            return segment.push(SegmentPool.take());
        }
    }

    @Override
    public Buffer write(ByteString byteString) {
        if (byteString == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        byteString.write((Buffer)this);
        return this;
    }

    @Override
    public Buffer write(byte[] arrby) {
        if (arrby == null) {
            throw new IllegalArgumentException("source == null");
        }
        return this.write(arrby, 0, arrby.length);
    }

    @Override
    public Buffer write(byte[] arrby, int n2, int n3) {
        if (arrby == null) {
            throw new IllegalArgumentException("source == null");
        }
        Util.checkOffsetAndCount(arrby.length, n2, n3);
        int n4 = n2 + n3;
        while (n2 < n4) {
            Segment segment = this.writableSegment(1);
            int n5 = Math.min((int)(n4 - n2), (int)(2048 - segment.limit));
            System.arraycopy((Object)arrby, (int)n2, (Object)segment.data, (int)segment.limit, (int)n5);
            n2 += n5;
            segment.limit = n5 + segment.limit;
        }
        this.size += (long)n3;
        return this;
    }

    @Override
    public BufferedSink write(Source source, long l2) throws IOException {
        while (l2 > 0) {
            long l3 = source.read((Buffer)this, l2);
            if (l3 == -1) {
                throw new EOFException();
            }
            l2 -= l3;
        }
        return this;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void write(Buffer buffer, long l2) {
        if (buffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (buffer == this) {
            throw new IllegalArgumentException("source == this");
        }
        Util.checkOffsetAndCount(buffer.size, 0, l2);
        while (l2 > 0) {
            if (l2 < (long)(buffer.head.limit - buffer.head.pos)) {
                long l3;
                int n2;
                Segment segment = this.head != null ? this.head.prev : null;
                if (segment != null && segment.owner && (l3 = l2 + (long)segment.limit) - (long)(n2 = segment.shared ? 0 : segment.pos) <= 2048) {
                    buffer.head.writeTo(segment, (int)l2);
                    buffer.size -= l2;
                    this.size = l2 + this.size;
                    return;
                }
                buffer.head = buffer.head.split((int)l2);
            }
            Segment segment = buffer.head;
            long l4 = segment.limit - segment.pos;
            buffer.head = segment.pop();
            if (this.head == null) {
                Segment segment2;
                Segment segment3 = this.head = segment;
                Segment segment4 = this.head;
                segment4.prev = segment2 = this.head;
                segment3.next = segment2;
            } else {
                this.head.prev.push(segment).compact();
            }
            buffer.size -= l4;
            this.size = l4 + this.size;
            l2 -= l4;
        }
    }

    @Override
    public long writeAll(Source source) throws IOException {
        long l2;
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long l3 = 0;
        while ((l2 = source.read((Buffer)this, 2048)) != -1) {
            l3 += l2;
        }
        return l3;
    }

    @Override
    public Buffer writeByte(int n2) {
        Segment segment = this.writableSegment(1);
        byte[] arrby = segment.data;
        int n3 = segment.limit;
        segment.limit = n3 + 1;
        arrby[n3] = (byte)n2;
        this.size = 1 + this.size;
        return this;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public Buffer writeDecimalLong(long l2) {
        if (l2 == 0) {
            return this.writeByte(48);
        }
        long l3 = l2 LCMP 0;
        boolean bl2 = false;
        if (l3 < 0) {
            if ((l2 = - l2) < 0) {
                return this.writeUtf8("-9223372036854775808");
            }
            bl2 = true;
        }
        int n2 = l2 < 100000000 ? (l2 < 10000 ? (l2 < 100 ? (l2 < 10 ? 1 : 2) : (l2 < 1000 ? 3 : 4)) : (l2 < 1000000 ? (l2 < 100000 ? 5 : 6) : (l2 < 10000000 ? 7 : 8))) : (l2 < 1000000000000L ? (l2 < 10000000000L ? (l2 < 1000000000 ? 9 : 10) : (l2 < 100000000000L ? 11 : 12)) : (l2 < 1000000000000000L ? (l2 < 10000000000000L ? 13 : (l2 < 100000000000000L ? 14 : 15)) : (l2 < 100000000000000000L ? (l2 < 10000000000000000L ? 16 : 17) : (l2 < 1000000000000000000L ? 18 : 19))));
        if (bl2) {
            ++n2;
        }
        Segment segment = this.writableSegment(n2);
        byte[] arrby = segment.data;
        int n3 = n2 + segment.limit;
        while (l2 != 0) {
            int n4 = (int)(l2 % 10);
            arrby[--n3] = DIGITS[n4];
            l2 /= 10;
        }
        if (bl2) {
            arrby[n3 - 1] = 45;
        }
        segment.limit = n2 + segment.limit;
        this.size += (long)n2;
        return this;
    }

    @Override
    public Buffer writeHexadecimalUnsignedLong(long l2) {
        if (l2 == 0) {
            return this.writeByte(48);
        }
        int n2 = 1 + Long.numberOfTrailingZeros((long)Long.highestOneBit((long)l2)) / 4;
        Segment segment = this.writableSegment(n2);
        byte[] arrby = segment.data;
        int n3 = segment.limit;
        for (int i2 = -1 + (n2 + segment.limit); i2 >= n3; --i2) {
            arrby[i2] = DIGITS[(int)(15 & l2)];
            l2 >>>= 4;
        }
        segment.limit = n2 + segment.limit;
        this.size += (long)n2;
        return this;
    }

    @Override
    public Buffer writeInt(int n2) {
        Segment segment = this.writableSegment(4);
        byte[] arrby = segment.data;
        int n3 = segment.limit;
        int n4 = n3 + 1;
        arrby[n3] = (byte)(255 & n2 >>> 24);
        int n5 = n4 + 1;
        arrby[n4] = (byte)(255 & n2 >>> 16);
        int n6 = n5 + 1;
        arrby[n5] = (byte)(255 & n2 >>> 8);
        int n7 = n6 + 1;
        arrby[n6] = (byte)(n2 & 255);
        segment.limit = n7;
        this.size = 4 + this.size;
        return this;
    }

    @Override
    public Buffer writeIntLe(int n2) {
        return this.writeInt(Util.reverseBytesInt(n2));
    }

    @Override
    public Buffer writeLong(long l2) {
        Segment segment = this.writableSegment(8);
        byte[] arrby = segment.data;
        int n2 = segment.limit;
        int n3 = n2 + 1;
        arrby[n2] = (byte)(255 & l2 >>> 56);
        int n4 = n3 + 1;
        arrby[n3] = (byte)(255 & l2 >>> 48);
        int n5 = n4 + 1;
        arrby[n4] = (byte)(255 & l2 >>> 40);
        int n6 = n5 + 1;
        arrby[n5] = (byte)(255 & l2 >>> 32);
        int n7 = n6 + 1;
        arrby[n6] = (byte)(255 & l2 >>> 24);
        int n8 = n7 + 1;
        arrby[n7] = (byte)(255 & l2 >>> 16);
        int n9 = n8 + 1;
        arrby[n8] = (byte)(255 & l2 >>> 8);
        int n10 = n9 + 1;
        arrby[n9] = (byte)(l2 & 255);
        segment.limit = n10;
        this.size = 8 + this.size;
        return this;
    }

    @Override
    public Buffer writeLongLe(long l2) {
        return this.writeLong(Util.reverseBytesLong(l2));
    }

    @Override
    public Buffer writeShort(int n2) {
        Segment segment = this.writableSegment(2);
        byte[] arrby = segment.data;
        int n3 = segment.limit;
        int n4 = n3 + 1;
        arrby[n3] = (byte)(255 & n2 >>> 8);
        int n5 = n4 + 1;
        arrby[n4] = (byte)(n2 & 255);
        segment.limit = n5;
        this.size = 2 + this.size;
        return this;
    }

    @Override
    public Buffer writeShortLe(int n2) {
        return this.writeShort(Util.reverseBytesShort((short)n2));
    }

    @Override
    public Buffer writeString(String string2, int n2, int n3, Charset charset) {
        if (string2 == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (n2 < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + n2);
        }
        if (n3 < n2) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + n3 + " < " + n2);
        }
        if (n3 > string2.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + n3 + " > " + string2.length());
        }
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (charset.equals((Object)Util.UTF_8)) {
            return this.writeUtf8(string2);
        }
        byte[] arrby = string2.substring(n2, n3).getBytes(charset);
        return this.write(arrby, 0, arrby.length);
    }

    @Override
    public Buffer writeString(String string2, Charset charset) {
        return this.writeString(string2, 0, string2.length(), charset);
    }

    public Buffer writeTo(OutputStream outputStream) throws IOException {
        return this.writeTo(outputStream, this.size);
    }

    public Buffer writeTo(OutputStream outputStream, long l2) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        Util.checkOffsetAndCount(this.size, 0, l2);
        Segment segment = this.head;
        while (l2 > 0) {
            int n2 = (int)Math.min((long)l2, (long)(segment.limit - segment.pos));
            outputStream.write(segment.data, segment.pos, n2);
            segment.pos = n2 + segment.pos;
            this.size -= (long)n2;
            l2 -= (long)n2;
            if (segment.pos != segment.limit) continue;
            Segment segment2 = segment;
            this.head = segment = segment2.pop();
            SegmentPool.recycle(segment2);
        }
        return this;
    }

    @Override
    public Buffer writeUtf8(String string2) {
        return this.writeUtf8(string2, 0, string2.length());
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public Buffer writeUtf8(String var1, int var2_3, int var3_2) {
        if (var1 == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (var2_3 < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + var2_3);
        }
        if (var3_2 < var2_3) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + var3_2 + " < " + var2_3);
        }
        if (var3_2 > var1.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + var3_2 + " > " + var1.length());
        }
        var4_4 = var2_3;
        block0 : do {
            if (var4_4 >= var3_2) return this;
            var5_7 = var1.charAt(var4_4);
            if (var5_7 < '') ** GOTO lbl37
            if (var5_7 < '\u0800') {
                this.writeByte(192 | var5_7 >> 6);
                this.writeByte(128 | var5_7 & 63);
                var9_11 = var4_4 + 1;
            } else if (var5_7 < '\ud800' || var5_7 > '\udfff') {
                this.writeByte(224 | var5_7 >> 12);
                this.writeByte(128 | 63 & var5_7 >> 6);
                this.writeByte(128 | var5_7 & 63);
                var9_11 = var4_4 + 1;
            } else {
                var10_15 = var4_4 + 1 < var3_2 ? var1.charAt(var4_4 + 1) : '\u0000';
                if (var5_7 > '\udbff' || var10_15 < '\udc00' || var10_15 > '\udfff') {
                    this.writeByte(63);
                    ++var4_4;
                    continue;
                }
                var12_14 = 65536 + ((-55297 & var5_7) << 10 | -56321 & var10_15);
                this.writeByte(240 | var12_14 >> 18);
                this.writeByte(128 | 63 & var12_14 >> 12);
                this.writeByte(128 | 63 & var12_14 >> 6);
                this.writeByte(128 | var12_14 & 63);
                var9_11 = var4_4 + 2;
            }
            ** GOTO lbl50
lbl37: // 1 sources:
            var19_5 = this.writableSegment(1);
            var20_17 = var19_5.data;
            var21_16 = var19_5.limit - var4_4;
            var22_6 = Math.min((int)var3_2, (int)(2048 - var21_16));
            var23_9 = var4_4 + 1;
            var20_17[var21_16 + var4_4] = (byte)var5_7;
            var24_13 = var23_9;
            do {
                if (var24_13 >= var22_6 || (var26_10 = var1.charAt(var24_13)) >= '') {
                    var25_12 = var24_13 + var21_16 - var19_5.limit;
                    var19_5.limit = var25_12 + var19_5.limit;
                    this.size += (long)var25_12;
                    var9_11 = var24_13;
lbl50: // 4 sources:
                    var4_4 = var9_11;
                    continue block0;
                }
                var27_8 = var24_13 + 1;
                var20_17[var21_16 + var24_13] = (byte)var26_10;
                var24_13 = var27_8;
            } while (true);
            break;
        } while (true);
    }

    @Override
    public Buffer writeUtf8CodePoint(int n2) {
        if (n2 < 128) {
            this.writeByte(n2);
            return this;
        }
        if (n2 < 2048) {
            this.writeByte(192 | n2 >> 6);
            this.writeByte(128 | n2 & 63);
            return this;
        }
        if (n2 < 65536) {
            if (n2 >= 55296 && n2 <= 57343) {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString((int)n2));
            }
            this.writeByte(224 | n2 >> 12);
            this.writeByte(128 | 63 & n2 >> 6);
            this.writeByte(128 | n2 & 63);
            return this;
        }
        if (n2 <= 1114111) {
            this.writeByte(240 | n2 >> 18);
            this.writeByte(128 | 63 & n2 >> 12);
            this.writeByte(128 | 63 & n2 >> 6);
            this.writeByte(128 | n2 & 63);
            return this;
        }
        throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString((int)n2));
    }

}

