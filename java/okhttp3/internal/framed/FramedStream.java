/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.EOFException
 *  java.io.IOException
 *  java.io.InterruptedIOException
 *  java.lang.AssertionError
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.InterruptedException
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.net.SocketTimeoutException
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 */
package okhttp3.internal.framed;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import okhttp3.internal.framed.ErrorCode;
import okhttp3.internal.framed.FramedConnection;
import okhttp3.internal.framed.Header;
import okhttp3.internal.framed.HeadersMode;
import okhttp3.internal.framed.Settings;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class FramedStream {
    static final /* synthetic */ boolean $assertionsDisabled;
    long bytesLeftInWriteWindow;
    private final FramedConnection connection;
    private ErrorCode errorCode;
    private final int id;
    private final StreamTimeout readTimeout;
    private final List<Header> requestHeaders;
    private List<Header> responseHeaders;
    final FramedDataSink sink;
    private final FramedDataSource source;
    long unacknowledgedBytesRead = 0;
    private final StreamTimeout writeTimeout;

    /*
     * Enabled aggressive block sorting
     */
    static {
        boolean bl2 = !FramedStream.class.desiredAssertionStatus();
        $assertionsDisabled = bl2;
    }

    FramedStream(int n2, FramedConnection framedConnection, boolean bl2, boolean bl3, List<Header> list) {
        this.readTimeout = new StreamTimeout();
        this.writeTimeout = new StreamTimeout();
        this.errorCode = null;
        if (framedConnection == null) {
            throw new NullPointerException("connection == null");
        }
        if (list == null) {
            throw new NullPointerException("requestHeaders == null");
        }
        this.id = n2;
        this.connection = framedConnection;
        this.bytesLeftInWriteWindow = framedConnection.peerSettings.getInitialWindowSize(65536);
        this.source = new FramedDataSource(this, framedConnection.okHttpSettings.getInitialWindowSize(65536), null);
        this.sink = new FramedDataSink();
        this.source.finished = bl3;
        this.sink.finished = bl2;
        this.requestHeaders = list;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void cancelStreamIfNecessary() throws IOException {
        if (!$assertionsDisabled && Thread.holdsLock((Object)this)) {
            throw new AssertionError();
        }
        FramedStream framedStream = this;
        // MONITORENTER : framedStream
        boolean bl2 = !this.source.finished && this.source.closed && (this.sink.finished || this.sink.closed);
        boolean bl3 = this.isOpen();
        // MONITOREXIT : framedStream
        if (bl2) {
            this.close(ErrorCode.CANCEL);
            return;
        }
        if (bl3) return;
        this.connection.removeStream(this.id);
    }

    private void checkOutNotClosed() throws IOException {
        if (this.sink.closed) {
            throw new IOException("stream closed");
        }
        if (this.sink.finished) {
            throw new IOException("stream finished");
        }
        if (this.errorCode != null) {
            throw new IOException("stream was reset: " + (Object)((Object)this.errorCode));
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean closeInternal(ErrorCode errorCode) {
        if (!$assertionsDisabled && Thread.holdsLock((Object)this)) {
            throw new AssertionError();
        }
        void var4_2 = this;
        synchronized (var4_2) {
            if (this.errorCode != null) {
                return false;
            }
            if (this.source.finished && this.sink.finished) {
                return false;
            }
            this.errorCode = errorCode;
            this.notifyAll();
        }
        this.connection.removeStream(this.id);
        return true;
    }

    private void waitForIo() throws InterruptedIOException {
        try {
            this.wait();
            return;
        }
        catch (InterruptedException var1_1) {
            throw new InterruptedIOException();
        }
    }

    void addBytesToWriteWindow(long l2) {
        this.bytesLeftInWriteWindow = l2 + this.bytesLeftInWriteWindow;
        if (l2 > 0) {
            this.notifyAll();
        }
    }

    public void close(ErrorCode errorCode) throws IOException {
        if (!super.closeInternal(errorCode)) {
            return;
        }
        this.connection.writeSynReset(this.id, errorCode);
    }

    public void closeLater(ErrorCode errorCode) {
        if (!super.closeInternal(errorCode)) {
            return;
        }
        this.connection.writeSynResetLater(this.id, errorCode);
    }

    public FramedConnection getConnection() {
        return this.connection;
    }

    public ErrorCode getErrorCode() {
        FramedStream framedStream = this;
        synchronized (framedStream) {
            ErrorCode errorCode = this.errorCode;
            return errorCode;
        }
    }

    public int getId() {
        return this.id;
    }

    public List<Header> getRequestHeaders() {
        return this.requestHeaders;
    }

    /*
     * Exception decompiling
     */
    public List<Header> getResponseHeaders() throws IOException {
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Sink getSink() {
        FramedStream framedStream = this;
        synchronized (framedStream) {
            if (this.responseHeaders == null && !this.isLocallyInitiated()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
            return this.sink;
        }
    }

    public Source getSource() {
        return this.source;
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean isLocallyInitiated() {
        boolean bl2 = (1 & this.id) == 1;
        if (this.connection.client != bl2) return false;
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean isOpen() {
        FramedStream framedStream = this;
        synchronized (framedStream) {
            ErrorCode errorCode = this.errorCode;
            boolean bl2 = false;
            if (errorCode != null) return bl2;
            if (!this.source.finished) {
                if (!this.source.closed) return true;
            }
            if (!this.sink.finished) {
                if (!this.sink.closed) return true;
            }
            List<Header> list = this.responseHeaders;
            bl2 = false;
            if (list != null) return bl2;
            return true;
        }
    }

    public Timeout readTimeout() {
        return this.readTimeout;
    }

    void receiveData(BufferedSource bufferedSource, int n2) throws IOException {
        if (!$assertionsDisabled && Thread.holdsLock((Object)this)) {
            throw new AssertionError();
        }
        this.source.receive(bufferedSource, n2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    void receiveFin() {
        if (!$assertionsDisabled && Thread.holdsLock((Object)this)) {
            throw new AssertionError();
        }
        FramedStream framedStream = this;
        // MONITORENTER : framedStream
        this.source.finished = true;
        boolean bl2 = this.isOpen();
        this.notifyAll();
        // MONITOREXIT : framedStream
        if (bl2) return;
        this.connection.removeStream(this.id);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    void receiveHeaders(List<Header> list, HeadersMode headersMode) {
        ErrorCode errorCode;
        if (!$assertionsDisabled && Thread.holdsLock((Object)this)) {
            throw new AssertionError();
        }
        boolean bl2 = true;
        void var10_4 = this;
        // MONITORENTER : var10_4
        if (this.responseHeaders == null) {
            if (headersMode.failIfHeadersAbsent()) {
                errorCode = ErrorCode.PROTOCOL_ERROR;
            } else {
                this.responseHeaders = list;
                bl2 = this.isOpen();
                this.notifyAll();
                errorCode = null;
            }
        } else if (headersMode.failIfHeadersPresent()) {
            errorCode = ErrorCode.STREAM_IN_USE;
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.responseHeaders);
            arrayList.addAll(list);
            this.responseHeaders = arrayList;
            errorCode = null;
        }
        // MONITOREXIT : var10_4
        if (errorCode != null) {
            this.closeLater(errorCode);
            return;
        }
        if (bl2) return;
        this.connection.removeStream(this.id);
    }

    void receiveRstStream(ErrorCode errorCode) {
        void var3_2 = this;
        synchronized (var3_2) {
            if (this.errorCode == null) {
                this.errorCode = errorCode;
                this.notifyAll();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void reply(List<Header> list, boolean bl2) throws IOException {
        if (!$assertionsDisabled && Thread.holdsLock((Object)this)) {
            throw new AssertionError();
        }
        void var6_3 = this;
        synchronized (var6_3) {
            if (list == null) {
                throw new NullPointerException("responseHeaders == null");
            }
            if (this.responseHeaders != null) {
                throw new IllegalStateException("reply already sent");
            }
            this.responseHeaders = list;
            boolean bl3 = false;
            if (!bl2) {
                this.sink.finished = true;
                bl3 = true;
            }
            this.connection.writeSynReply(this.id, bl3, list);
            if (bl3) {
                this.connection.flush();
            }
            return;
        }
    }

    public Timeout writeTimeout() {
        return this.writeTimeout;
    }

    final class FramedDataSink
    implements Sink {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final long EMIT_BUFFER_SIZE = 16384;
        private boolean closed;
        private boolean finished;
        private final Buffer sendBuffer;

        /*
         * Enabled aggressive block sorting
         */
        static {
            boolean bl2 = !FramedStream.class.desiredAssertionStatus();
            $assertionsDisabled = bl2;
        }

        FramedDataSink() {
            this.sendBuffer = new Buffer();
        }

        /*
         * Exception decompiling
         */
        private void emitDataFrame(boolean var1) throws IOException {
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
            // org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:664)
            // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:747)
            // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
            // org.benf.cfr.reader.Main.doJar(Main.java:128)
            // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
            // java.lang.Thread.run(Thread.java:818)
            throw new IllegalStateException("Decompilation failed");
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Converted monitor instructions to comments
         * Lifted jumps to return sites
         */
        @Override
        public void close() throws IOException {
            FramedStream framedStream;
            FramedStream framedStream2;
            if (!$assertionsDisabled && Thread.holdsLock((Object)FramedStream.this)) {
                throw new AssertionError();
            }
            FramedStream framedStream3 = framedStream2 = FramedStream.this;
            // MONITORENTER : framedStream3
            if (this.closed) {
                // MONITOREXIT : framedStream3
                return;
            }
            // MONITOREXIT : framedStream3
            if (!FramedStream.this.sink.finished) {
                if (this.sendBuffer.size() > 0) {
                    while (this.sendBuffer.size() > 0) {
                        this.emitDataFrame(true);
                    }
                } else {
                    FramedStream.this.connection.writeData(FramedStream.this.id, true, null, 0);
                }
            }
            FramedStream framedStream4 = framedStream = FramedStream.this;
            // MONITORENTER : framedStream4
            this.closed = true;
            // MONITOREXIT : framedStream4
            FramedStream.this.connection.flush();
            FramedStream.this.cancelStreamIfNecessary();
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void flush() throws IOException {
            FramedStream framedStream;
            if (!$assertionsDisabled && Thread.holdsLock((Object)FramedStream.this)) {
                throw new AssertionError();
            }
            FramedStream framedStream2 = framedStream = FramedStream.this;
            synchronized (framedStream2) {
                FramedStream.this.checkOutNotClosed();
            }
            while (this.sendBuffer.size() > 0) {
                this.emitDataFrame(false);
                FramedStream.this.connection.flush();
            }
            return;
        }

        @Override
        public Timeout timeout() {
            return FramedStream.this.writeTimeout;
        }

        @Override
        public void write(Buffer buffer, long l2) throws IOException {
            if (!$assertionsDisabled && Thread.holdsLock((Object)FramedStream.this)) {
                throw new AssertionError();
            }
            this.sendBuffer.write(buffer, l2);
            while (this.sendBuffer.size() >= 16384) {
                super.emitDataFrame(false);
            }
        }
    }

    final class FramedDataSource
    implements Source {
        static final /* synthetic */ boolean $assertionsDisabled;
        private boolean closed;
        private boolean finished;
        private final long maxByteCount;
        private final Buffer readBuffer;
        private final Buffer receiveBuffer;
        final /* synthetic */ FramedStream this$0;

        /*
         * Enabled aggressive block sorting
         */
        static {
            boolean bl2 = !FramedStream.class.desiredAssertionStatus();
            $assertionsDisabled = bl2;
        }

        private FramedDataSource(FramedStream framedStream, long l2) {
            this.this$0 = framedStream;
            this.receiveBuffer = new Buffer();
            this.readBuffer = new Buffer();
            this.maxByteCount = l2;
        }

        /* synthetic */ FramedDataSource(FramedStream framedStream, long l2,  var4) {
            super(framedStream, l2);
        }

        private void checkNotClosed() throws IOException {
            if (this.closed) {
                throw new IOException("stream closed");
            }
            if (this.this$0.errorCode != null) {
                throw new IOException("stream was reset: " + (Object)((Object)this.this$0.errorCode));
            }
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        private void waitUntilReadable() throws IOException {
            this.this$0.readTimeout.enter();
            try {
                while (this.readBuffer.size() == 0 && !this.finished && !this.closed && this.this$0.errorCode == null) {
                    this.this$0.waitForIo();
                }
                return;
            }
            finally {
                this.this$0.readTimeout.exitAndThrowIfTimedOut();
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void close() throws IOException {
            FramedStream framedStream;
            FramedStream framedStream2 = framedStream = this.this$0;
            synchronized (framedStream2) {
                this.closed = true;
                this.readBuffer.clear();
                this.this$0.notifyAll();
            }
            this.this$0.cancelStreamIfNecessary();
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public long read(Buffer buffer, long l2) throws IOException {
            long l3;
            FramedConnection framedConnection;
            FramedStream framedStream;
            if (l2 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + l2);
            }
            FramedStream framedStream2 = framedStream = this.this$0;
            synchronized (framedStream2) {
                super.waitUntilReadable();
                super.checkNotClosed();
                if (this.readBuffer.size() == 0) {
                    return -1;
                }
                l3 = this.readBuffer.read(buffer, Math.min((long)l2, (long)this.readBuffer.size()));
                FramedStream framedStream3 = this.this$0;
                framedStream3.unacknowledgedBytesRead = l3 + framedStream3.unacknowledgedBytesRead;
                if (this.this$0.unacknowledgedBytesRead >= (long)(FramedStream.access$500((FramedStream)this.this$0).okHttpSettings.getInitialWindowSize(65536) / 2)) {
                    this.this$0.connection.writeWindowUpdateLater(this.this$0.id, this.this$0.unacknowledgedBytesRead);
                    this.this$0.unacknowledgedBytesRead = 0;
                }
            }
            FramedConnection framedConnection2 = framedConnection = this.this$0.connection;
            synchronized (framedConnection2) {
                FramedConnection framedConnection3 = this.this$0.connection;
                framedConnection3.unacknowledgedBytesRead = l3 + framedConnection3.unacknowledgedBytesRead;
                if (FramedStream.access$500((FramedStream)this.this$0).unacknowledgedBytesRead >= (long)(FramedStream.access$500((FramedStream)this.this$0).okHttpSettings.getInitialWindowSize(65536) / 2)) {
                    this.this$0.connection.writeWindowUpdateLater(0, FramedStream.access$500((FramedStream)this.this$0).unacknowledgedBytesRead);
                    FramedStream.access$500((FramedStream)this.this$0).unacknowledgedBytesRead = 0;
                }
                return l3;
            }
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Converted monitor instructions to comments
         * Lifted jumps to return sites
         */
        void receive(BufferedSource var1, long var2_2) throws IOException {
            if (FramedDataSource.$assertionsDisabled || !Thread.holdsLock((Object)this.this$0)) ** GOTO lbl11
            throw new AssertionError();
lbl-1000: // 1 sources:
            {
                var2_2 -= var8_3;
                var15_9 = var10_6 = this.this$0;
                // MONITORENTER : var15_9
                var12_5 = this.readBuffer.size() == 0;
                this.readBuffer.writeAll(this.receiveBuffer);
                if (var12_5) {
                    this.this$0.notifyAll();
                }
                // MONITOREXIT : var15_9
lbl11: // 2 sources:
                if (var2_2 <= 0) return;
                var16_8 = var4_4 = this.this$0;
                // MONITORENTER : var16_8
                var6_10 = this.finished;
                var7_7 = var2_2 + this.readBuffer.size() > this.maxByteCount;
                // MONITOREXIT : var16_8
                if (var7_7) {
                    var1.skip(var2_2);
                    this.this$0.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                }
                if (!var6_10) continue;
                var1.skip(var2_2);
                return;
                ** while ((var8_3 = var1.read((Buffer)this.receiveBuffer, (long)var2_2)) != -1)
            }
lbl25: // 1 sources:
            throw new EOFException();
        }

        @Override
        public Timeout timeout() {
            return this.this$0.readTimeout;
        }
    }

    class StreamTimeout
    extends AsyncTimeout {
        StreamTimeout() {
        }

        public void exitAndThrowIfTimedOut() throws IOException {
            if (this.exit()) {
                throw this.newTimeoutException(null);
            }
        }

        @Override
        protected IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause((Throwable)iOException);
            }
            return socketTimeoutException;
        }

        @Override
        protected void timedOut() {
            FramedStream.this.closeLater(ErrorCode.CANCEL);
        }
    }

}

