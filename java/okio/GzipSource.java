/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.EOFException
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.zip.CRC32
 *  java.util.zip.Inflater
 */
package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import okio.Buffer;
import okio.BufferedSource;
import okio.InflaterSource;
import okio.Okio;
import okio.Segment;
import okio.Source;
import okio.Timeout;

public final class GzipSource
implements Source {
    private static final byte FCOMMENT = 4;
    private static final byte FEXTRA = 2;
    private static final byte FHCRC = 1;
    private static final byte FNAME = 3;
    private static final byte SECTION_BODY = 1;
    private static final byte SECTION_DONE = 3;
    private static final byte SECTION_HEADER = 0;
    private static final byte SECTION_TRAILER = 2;
    private final CRC32 crc = new CRC32();
    private final Inflater inflater;
    private final InflaterSource inflaterSource;
    private int section = 0;
    private final BufferedSource source;

    public GzipSource(Source source) {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.inflater = new Inflater(true);
        this.source = Okio.buffer(source);
        this.inflaterSource = new InflaterSource(this.source, this.inflater);
    }

    private void checkEqual(String string2, int n2, int n3) throws IOException {
        if (n3 != n2) {
            Object[] arrobject = new Object[]{string2, n3, n2};
            throw new IOException(String.format((String)"%s: actual 0x%08x != expected 0x%08x", (Object[])arrobject));
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void consumeHeader() throws IOException {
        this.source.require(10);
        byte by2 = this.source.buffer().getByte(3);
        boolean bl2 = (1 & by2 >> 1) == 1;
        if (bl2) {
            this.updateCrc(this.source.buffer(), 0, 10);
        }
        this.checkEqual("ID1ID2", 8075, this.source.readShort());
        this.source.skip(8);
        if ((1 & by2 >> 2) == 1) {
            this.source.require(2);
            if (bl2) {
                this.updateCrc(this.source.buffer(), 0, 2);
            }
            short s2 = this.source.buffer().readShortLe();
            this.source.require(s2);
            if (bl2) {
                this.updateCrc(this.source.buffer(), 0, s2);
            }
            this.source.skip(s2);
        }
        if ((1 & by2 >> 3) == 1) {
            long l2 = this.source.indexOf(0);
            if (l2 == -1) {
                throw new EOFException();
            }
            if (bl2) {
                this.updateCrc(this.source.buffer(), 0, 1 + l2);
            }
            this.source.skip(1 + l2);
        }
        if ((1 & by2 >> 4) == 1) {
            long l3 = this.source.indexOf(0);
            if (l3 == -1) {
                throw new EOFException();
            }
            if (bl2) {
                this.updateCrc(this.source.buffer(), 0, 1 + l3);
            }
            this.source.skip(1 + l3);
        }
        if (bl2) {
            this.checkEqual("FHCRC", this.source.readShortLe(), (short)this.crc.getValue());
            this.crc.reset();
        }
    }

    private void consumeTrailer() throws IOException {
        this.checkEqual("CRC", this.source.readIntLe(), (int)this.crc.getValue());
        this.checkEqual("ISIZE", this.source.readIntLe(), this.inflater.getTotalOut());
    }

    private void updateCrc(Buffer buffer, long l2, long l3) {
        Segment segment = buffer.head;
        while (l2 >= (long)(segment.limit - segment.pos)) {
            l2 -= (long)(segment.limit - segment.pos);
            segment = segment.next;
        }
        while (l3 > 0) {
            int n2 = (int)(l2 + (long)segment.pos);
            int n3 = (int)Math.min((long)(segment.limit - n2), (long)l3);
            this.crc.update(segment.data, n2, n3);
            l3 -= (long)n3;
            l2 = 0;
            segment = segment.next;
        }
    }

    @Override
    public void close() throws IOException {
        this.inflaterSource.close();
    }

    @Override
    public long read(Buffer buffer, long l2) throws IOException {
        if (l2 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + l2);
        }
        if (l2 == 0) {
            return 0;
        }
        if (this.section == 0) {
            super.consumeHeader();
            this.section = 1;
        }
        if (this.section == 1) {
            long l3 = buffer.size;
            long l4 = this.inflaterSource.read(buffer, l2);
            if (l4 != -1) {
                super.updateCrc(buffer, l3, l4);
                return l4;
            }
            this.section = 2;
        }
        if (this.section == 2) {
            super.consumeTrailer();
            this.section = 3;
            if (!this.source.exhausted()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1;
    }

    @Override
    public Timeout timeout() {
        return this.source.timeout();
    }
}

