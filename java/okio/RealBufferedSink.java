/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.EOFException
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.charset.Charset
 */
package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Sink;
import okio.Source;
import okio.Timeout;

final class RealBufferedSink
implements BufferedSink {
    public final Buffer buffer;
    private boolean closed;
    public final Sink sink;

    public RealBufferedSink(Sink sink) {
        super(sink, new Buffer());
    }

    public RealBufferedSink(Sink sink, Buffer buffer) {
        if (sink == null) {
            throw new IllegalArgumentException("sink == null");
        }
        this.buffer = buffer;
        this.sink = sink;
    }

    @Override
    public Buffer buffer() {
        return this.buffer;
    }

    /*
     * Exception decompiling
     */
    @Override
    public void close() throws IOException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.util.ConcurrentModificationException
        // java.util.LinkedList$ReverseLinkIterator.next(LinkedList.java:217)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.extractLabelledBlocks(Block.java:212)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:485)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.insertLabelledBlocks(Op04StructuredStatement.java:649)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:816)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:128)
        // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    @Override
    public BufferedSink emit() throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        long l2 = this.buffer.size();
        if (l2 > 0) {
            this.sink.write(this.buffer, l2);
        }
        return this;
    }

    @Override
    public BufferedSink emitCompleteSegments() throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        long l2 = this.buffer.completeSegmentByteCount();
        if (l2 > 0) {
            this.sink.write(this.buffer, l2);
        }
        return this;
    }

    @Override
    public void flush() throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (this.buffer.size > 0) {
            this.sink.write(this.buffer, this.buffer.size);
        }
        this.sink.flush();
    }

    @Override
    public OutputStream outputStream() {
        return new OutputStream(){

            public void close() throws IOException {
                RealBufferedSink.this.close();
            }

            public void flush() throws IOException {
                if (!RealBufferedSink.this.closed) {
                    RealBufferedSink.this.flush();
                }
            }

            public String toString() {
                return RealBufferedSink.this + ".outputStream()";
            }

            public void write(int n2) throws IOException {
                if (RealBufferedSink.this.closed) {
                    throw new IOException("closed");
                }
                RealBufferedSink.this.buffer.writeByte((byte)n2);
                RealBufferedSink.this.emitCompleteSegments();
            }

            public void write(byte[] arrby, int n2, int n3) throws IOException {
                if (RealBufferedSink.this.closed) {
                    throw new IOException("closed");
                }
                RealBufferedSink.this.buffer.write(arrby, n2, n3);
                RealBufferedSink.this.emitCompleteSegments();
            }
        };
    }

    @Override
    public Timeout timeout() {
        return this.sink.timeout();
    }

    public String toString() {
        return "buffer(" + this.sink + ")";
    }

    @Override
    public BufferedSink write(ByteString byteString) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.write(byteString);
        return this.emitCompleteSegments();
    }

    @Override
    public BufferedSink write(Source source, long l2) throws IOException {
        while (l2 > 0) {
            long l3 = source.read(this.buffer, l2);
            if (l3 == -1) {
                throw new EOFException();
            }
            l2 -= l3;
            this.emitCompleteSegments();
        }
        return this;
    }

    @Override
    public BufferedSink write(byte[] arrby) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.write(arrby);
        return this.emitCompleteSegments();
    }

    @Override
    public BufferedSink write(byte[] arrby, int n2, int n3) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.write(arrby, n2, n3);
        return this.emitCompleteSegments();
    }

    @Override
    public void write(Buffer buffer, long l2) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.write(buffer, l2);
        this.emitCompleteSegments();
    }

    @Override
    public long writeAll(Source source) throws IOException {
        long l2;
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long l3 = 0;
        while ((l2 = source.read(this.buffer, 2048)) != -1) {
            l3 += l2;
            this.emitCompleteSegments();
        }
        return l3;
    }

    @Override
    public BufferedSink writeByte(int n2) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeByte(n2);
        return this.emitCompleteSegments();
    }

    @Override
    public BufferedSink writeDecimalLong(long l2) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeDecimalLong(l2);
        return this.emitCompleteSegments();
    }

    @Override
    public BufferedSink writeHexadecimalUnsignedLong(long l2) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeHexadecimalUnsignedLong(l2);
        return this.emitCompleteSegments();
    }

    @Override
    public BufferedSink writeInt(int n2) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeInt(n2);
        return this.emitCompleteSegments();
    }

    @Override
    public BufferedSink writeIntLe(int n2) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeIntLe(n2);
        return this.emitCompleteSegments();
    }

    @Override
    public BufferedSink writeLong(long l2) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeLong(l2);
        return this.emitCompleteSegments();
    }

    @Override
    public BufferedSink writeLongLe(long l2) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeLongLe(l2);
        return this.emitCompleteSegments();
    }

    @Override
    public BufferedSink writeShort(int n2) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeShort(n2);
        return this.emitCompleteSegments();
    }

    @Override
    public BufferedSink writeShortLe(int n2) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeShortLe(n2);
        return this.emitCompleteSegments();
    }

    @Override
    public BufferedSink writeString(String string2, int n2, int n3, Charset charset) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeString(string2, n2, n3, charset);
        return this.emitCompleteSegments();
    }

    @Override
    public BufferedSink writeString(String string2, Charset charset) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeString(string2, charset);
        return this.emitCompleteSegments();
    }

    @Override
    public BufferedSink writeUtf8(String string2) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeUtf8(string2);
        return this.emitCompleteSegments();
    }

    @Override
    public BufferedSink writeUtf8(String string2, int n2, int n3) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeUtf8(string2, n2, n3);
        return this.emitCompleteSegments();
    }

    @Override
    public BufferedSink writeUtf8CodePoint(int n2) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeUtf8CodePoint(n2);
        return this.emitCompleteSegments();
    }

}

