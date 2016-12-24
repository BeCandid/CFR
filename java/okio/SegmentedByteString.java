/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.AssertionError
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.Arrays
 */
package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import okio.Buffer;
import okio.ByteString;
import okio.Segment;
import okio.Util;

final class SegmentedByteString
extends ByteString {
    final transient int[] directory;
    final transient byte[][] segments;

    SegmentedByteString(Buffer buffer, int n2) {
        super(null);
        Util.checkOffsetAndCount(buffer.size, 0, n2);
        int n3 = 0;
        int n4 = 0;
        Segment segment = buffer.head;
        while (n3 < n2) {
            if (segment.limit == segment.pos) {
                throw new AssertionError((Object)"s.limit == s.pos");
            }
            n3 += segment.limit - segment.pos;
            ++n4;
            segment = segment.next;
        }
        this.segments = new byte[n4][];
        this.directory = new int[n4 * 2];
        int n5 = 0;
        int n6 = 0;
        Segment segment2 = buffer.head;
        while (n5 < n2) {
            this.segments[n6] = segment2.data;
            this.directory[n6] = n5 += segment2.limit - segment2.pos;
            this.directory[n6 + this.segments.length] = segment2.pos;
            segment2.shared = true;
            ++n6;
            segment2 = segment2.next;
        }
    }

    private int segment(int n2) {
        int n3 = Arrays.binarySearch((int[])this.directory, (int)0, (int)this.segments.length, (int)(n2 + 1));
        if (n3 >= 0) {
            return n3;
        }
        return ~ n3;
    }

    private ByteString toByteString() {
        return new ByteString(this.toByteArray());
    }

    private Object writeReplace() {
        return this.toByteString();
    }

    @Override
    public String base64() {
        return this.toByteString().base64();
    }

    @Override
    public String base64Url() {
        return this.toByteString().base64Url();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ByteString)) return false;
        if (((ByteString)object).size() != this.size()) return false;
        if (!this.rangeEquals(0, (ByteString)object, 0, this.size())) return false;
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public byte getByte(int n2) {
        Util.checkOffsetAndCount(this.directory[-1 + this.segments.length], n2, 1);
        int n3 = super.segment(n2);
        int n4 = n3 == 0 ? 0 : this.directory[n3 - 1];
        int n5 = this.directory[n3 + this.segments.length];
        return this.segments[n3][n5 + (n2 - n4)];
    }

    @Override
    public int hashCode() {
        int n2 = this.hashCode;
        if (n2 != 0) {
            return n2;
        }
        int n3 = 1;
        int n4 = 0;
        int n5 = this.segments.length;
        for (int i2 = 0; i2 < n5; ++i2) {
            byte[] arrby = this.segments[i2];
            int n6 = this.directory[n5 + i2];
            int n7 = this.directory[i2];
            int n8 = n7 - n4;
            int n9 = n6 + n8;
            for (int i3 = n6; i3 < n9; ++i3) {
                n3 = n3 * 31 + arrby[i3];
            }
            n4 = n7;
        }
        this.hashCode = n3;
        return n3;
    }

    @Override
    public String hex() {
        return this.toByteString().hex();
    }

    @Override
    public ByteString md5() {
        return this.toByteString().md5();
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public boolean rangeEquals(int n2, ByteString byteString, int n3, int n4) {
        if (n2 > this.size() - n4) {
            return false;
        }
        int n5 = super.segment(n2);
        while (n4 > 0) {
            int n6 = n5 == 0 ? 0 : this.directory[n5 - 1];
            int n7 = this.directory[n5 + this.segments.length] + (n2 - n6);
            int n8 = Math.min((int)n4, (int)(n6 + (this.directory[n5] - n6) - n2));
            if (!byteString.rangeEquals(n3, this.segments[n5], n7, n8)) return false;
            n2 += n8;
            n3 += n8;
            n4 -= n8;
            ++n5;
        }
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public boolean rangeEquals(int n2, byte[] arrby, int n3, int n4) {
        if (n2 > this.size() - n4 || n3 > arrby.length - n4) {
            return false;
        }
        int n5 = super.segment(n2);
        while (n4 > 0) {
            int n6 = n5 == 0 ? 0 : this.directory[n5 - 1];
            int n7 = this.directory[n5 + this.segments.length] + (n2 - n6);
            int n8 = Math.min((int)n4, (int)(n6 + (this.directory[n5] - n6) - n2));
            if (!Util.arrayRangeEquals(this.segments[n5], n7, arrby, n3, n8)) return false;
            n2 += n8;
            n3 += n8;
            n4 -= n8;
            ++n5;
        }
        return true;
    }

    @Override
    public ByteString sha256() {
        return this.toByteString().sha256();
    }

    @Override
    public int size() {
        return this.directory[-1 + this.segments.length];
    }

    @Override
    public ByteString substring(int n2) {
        return super.toByteString().substring(n2);
    }

    @Override
    public ByteString substring(int n2, int n3) {
        return super.toByteString().substring(n2, n3);
    }

    @Override
    public ByteString toAsciiLowercase() {
        return this.toByteString().toAsciiLowercase();
    }

    @Override
    public ByteString toAsciiUppercase() {
        return this.toByteString().toAsciiUppercase();
    }

    @Override
    public byte[] toByteArray() {
        byte[] arrby = new byte[this.directory[-1 + this.segments.length]];
        int n2 = 0;
        int n3 = this.segments.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            int n4 = this.directory[n3 + i2];
            int n5 = this.directory[i2];
            System.arraycopy((Object)this.segments[i2], (int)n4, (Object)arrby, (int)n2, (int)(n5 - n2));
            n2 = n5;
        }
        return arrby;
    }

    @Override
    public String toString() {
        return this.toByteString().toString();
    }

    @Override
    public String utf8() {
        return this.toByteString().utf8();
    }

    @Override
    public void write(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        int n2 = 0;
        int n3 = this.segments.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            int n4 = this.directory[n3 + i2];
            int n5 = this.directory[i2];
            outputStream.write(this.segments[i2], n4, n5 - n2);
            n2 = n5;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    void write(Buffer buffer) {
        int n2 = 0;
        int n3 = 0;
        int n4 = this.segments.length;
        do {
            if (n3 >= n4) {
                buffer.size += (long)n2;
                return;
            }
            int n5 = this.directory[n4 + n3];
            int n6 = this.directory[n3];
            Segment segment = new Segment(this.segments[n3], n5, n5 + n6 - n2);
            if (buffer.head == null) {
                segment.prev = segment;
                segment.next = segment;
                buffer.head = segment;
            } else {
                buffer.head.prev.push(segment);
            }
            n2 = n6;
            ++n3;
        } while (true);
    }
}

