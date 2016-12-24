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
 *  java.util.zip.Deflater
 *  org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
 */
package okio;

import java.io.IOException;
import java.util.zip.Deflater;
import okio.Buffer;
import okio.BufferedSink;
import okio.Okio;
import okio.Segment;
import okio.SegmentPool;
import okio.Sink;
import okio.Timeout;
import okio.Util;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

public final class DeflaterSink
implements Sink {
    private boolean closed;
    private final Deflater deflater;
    private final BufferedSink sink;

    DeflaterSink(BufferedSink bufferedSink, Deflater deflater) {
        if (bufferedSink == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (deflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.sink = bufferedSink;
        this.deflater = deflater;
    }

    public DeflaterSink(Sink sink, Deflater deflater) {
        super(Okio.buffer(sink), deflater);
    }

    /*
     * Enabled aggressive block sorting
     */
    @IgnoreJRERequirement
    private void deflate(boolean bl2) throws IOException {
        Segment segment;
        Buffer buffer = this.sink.buffer();
        do {
            segment = buffer.writableSegment(1);
            int n2 = bl2 ? this.deflater.deflate(segment.data, segment.limit, 2048 - segment.limit, 2) : this.deflater.deflate(segment.data, segment.limit, 2048 - segment.limit);
            if (n2 > 0) {
                segment.limit = n2 + segment.limit;
                buffer.size += (long)n2;
                this.sink.emitCompleteSegments();
                continue;
            }
            if (this.deflater.needsInput()) break;
        } while (true);
        if (segment.pos == segment.limit) {
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
        }
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
            this.finishDeflate();
        }
        catch (Throwable var2_2) {
            var1_1 = var2_2;
            ** continue;
        }
lbl7: // 2 sources:
        do {
            this.deflater.end();
lbl10: // 3 sources:
            do {
                this.sink.close();
lbl13: // 3 sources:
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
            if (var1_1 != null) ** GOTO lbl10
            var1_1 = var3_3;
            ** continue;
        }
        catch (Throwable var4_4) {
            if (var1_1 != null) ** GOTO lbl13
            var1_1 = var4_4;
            ** continue;
        }
    }

    void finishDeflate() throws IOException {
        this.deflater.finish();
        this.deflate(false);
    }

    @Override
    public void flush() throws IOException {
        this.deflate(true);
        this.sink.flush();
    }

    @Override
    public Timeout timeout() {
        return this.sink.timeout();
    }

    public String toString() {
        return "DeflaterSink(" + this.sink + ")";
    }

    @Override
    public void write(Buffer buffer, long l2) throws IOException {
        Util.checkOffsetAndCount(buffer.size, 0, l2);
        while (l2 > 0) {
            Segment segment = buffer.head;
            int n2 = (int)Math.min((long)l2, (long)(segment.limit - segment.pos));
            this.deflater.setInput(segment.data, segment.pos, n2);
            super.deflate(false);
            buffer.size -= (long)n2;
            segment.pos = n2 + segment.pos;
            if (segment.pos == segment.limit) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            l2 -= (long)n2;
        }
    }
}

