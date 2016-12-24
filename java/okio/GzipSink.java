/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.zip.CRC32
 *  java.util.zip.Deflater
 */
package okio;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import okio.Buffer;
import okio.BufferedSink;
import okio.DeflaterSink;
import okio.Okio;
import okio.Segment;
import okio.Sink;
import okio.Timeout;
import okio.Util;

public final class GzipSink
implements Sink {
    private boolean closed;
    private final CRC32 crc = new CRC32();
    private final Deflater deflater;
    private final DeflaterSink deflaterSink;
    private final BufferedSink sink;

    public GzipSink(Sink sink) {
        if (sink == null) {
            throw new IllegalArgumentException("sink == null");
        }
        this.deflater = new Deflater(-1, true);
        this.sink = Okio.buffer(sink);
        this.deflaterSink = new DeflaterSink(this.sink, this.deflater);
        super.writeHeader();
    }

    private void updateCrc(Buffer buffer, long l2) {
        Segment segment = buffer.head;
        while (l2 > 0) {
            int n2 = (int)Math.min((long)l2, (long)(segment.limit - segment.pos));
            this.crc.update(segment.data, segment.pos, n2);
            l2 -= (long)n2;
            segment = segment.next;
        }
    }

    private void writeFooter() throws IOException {
        this.sink.writeIntLe((int)this.crc.getValue());
        this.sink.writeIntLe(this.deflater.getTotalIn());
    }

    private void writeHeader() {
        Buffer buffer = this.sink.buffer();
        buffer.writeShort(8075);
        buffer.writeByte(8);
        buffer.writeByte(0);
        buffer.writeInt(0);
        buffer.writeByte(0);
        buffer.writeByte(0);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    @Override
    public void close() throws IOException {
        if (this.closed) {
            do {
                return;
                break;
            } while (true);
        }
        var1_1 = null;
        try {
            this.deflaterSink.finishDeflate();
            this.writeFooter();
        }
        catch (Throwable var2_2) {
            var1_1 = var2_2;
            ** continue;
        }
lbl8: // 2 sources:
        do {
            this.deflater.end();
lbl11: // 3 sources:
            do {
                this.sink.close();
lbl14: // 3 sources:
                do {
                    this.closed = true;
                    if (var1_1 == null) ** continue;
                    Util.sneakyRethrow(var1_1);
                    return;
                    break;
                } while (true);
                break;
            } while (true);
            break;
        } while (true);
        catch (Throwable var3_3) {
            if (var1_1 != null) ** GOTO lbl11
            var1_1 = var3_3;
            ** continue;
        }
        catch (Throwable var4_4) {
            if (var1_1 != null) ** GOTO lbl14
            var1_1 = var4_4;
            ** continue;
        }
    }

    @Override
    public void flush() throws IOException {
        this.deflaterSink.flush();
    }

    @Override
    public Timeout timeout() {
        return this.sink.timeout();
    }

    @Override
    public void write(Buffer buffer, long l2) throws IOException {
        if (l2 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + l2);
        }
        if (l2 == 0) {
            return;
        }
        super.updateCrc(buffer, l2);
        this.deflaterSink.write(buffer, l2);
    }
}

