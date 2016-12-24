/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.IOException
 *  java.io.InterruptedIOException
 *  java.lang.AssertionError
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.InterruptedException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.net.InetSocketAddress
 *  java.net.Socket
 *  java.net.SocketAddress
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.LinkedHashSet
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 *  java.util.concurrent.BlockingQueue
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Future
 *  java.util.concurrent.LinkedBlockingQueue
 *  java.util.concurrent.SynchronousQueue
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.ThreadPoolExecutor
 *  java.util.concurrent.TimeUnit
 *  java.util.logging.Level
 *  java.util.logging.Logger
 */
package okhttp3.internal.framed;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.Protocol;
import okhttp3.internal.Internal;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.Util;
import okhttp3.internal.framed.ErrorCode;
import okhttp3.internal.framed.FrameReader;
import okhttp3.internal.framed.FrameWriter;
import okhttp3.internal.framed.FramedStream;
import okhttp3.internal.framed.Header;
import okhttp3.internal.framed.HeadersMode;
import okhttp3.internal.framed.Http2;
import okhttp3.internal.framed.Ping;
import okhttp3.internal.framed.PushObserver;
import okhttp3.internal.framed.Settings;
import okhttp3.internal.framed.Spdy3;
import okhttp3.internal.framed.Variant;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

public final class FramedConnection
implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    private static final ExecutorService executor;
    long bytesLeftInWriteWindow;
    final boolean client;
    private final Set<Integer> currentPushRequests;
    final FrameWriter frameWriter;
    private final String hostname;
    private long idleStartTimeNs;
    private int lastGoodStreamId;
    private final Listener listener;
    private int nextPingId;
    private int nextStreamId;
    Settings okHttpSettings;
    final Settings peerSettings;
    private Map<Integer, Ping> pings;
    final Protocol protocol;
    private final ExecutorService pushExecutor;
    private final PushObserver pushObserver;
    final Reader readerRunnable;
    private boolean receivedInitialPeerSettings;
    private boolean shutdown;
    final Socket socket;
    private final Map<Integer, FramedStream> streams;
    long unacknowledgedBytesRead;
    final Variant variant;

    /*
     * Enabled aggressive block sorting
     */
    static {
        boolean bl2 = !FramedConnection.class.desiredAssertionStatus();
        $assertionsDisabled = bl2;
        executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, (BlockingQueue)new SynchronousQueue(), Util.threadFactory("OkHttp FramedConnection", true));
    }

    /*
     * Enabled aggressive block sorting
     */
    private FramedConnection(Builder builder) throws IOException {
        int n2 = 2;
        this.streams = new HashMap();
        this.idleStartTimeNs = System.nanoTime();
        this.unacknowledgedBytesRead = 0;
        this.okHttpSettings = new Settings();
        this.peerSettings = new Settings();
        this.receivedInitialPeerSettings = false;
        this.currentPushRequests = new LinkedHashSet();
        this.protocol = builder.protocol;
        this.pushObserver = builder.pushObserver;
        this.client = builder.client;
        this.listener = builder.listener;
        int n3 = builder.client ? 1 : n2;
        this.nextStreamId = n3;
        if (builder.client && this.protocol == Protocol.HTTP_2) {
            this.nextStreamId = 2 + this.nextStreamId;
        }
        if (builder.client) {
            n2 = 1;
        }
        this.nextPingId = n2;
        if (builder.client) {
            this.okHttpSettings.set(7, 0, 16777216);
        }
        this.hostname = builder.hostname;
        if (this.protocol == Protocol.HTTP_2) {
            this.variant = new Http2();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
            Object[] arrobject = new Object[]{this.hostname};
            this.pushExecutor = new ThreadPoolExecutor(0, 1, 60, timeUnit, (BlockingQueue)linkedBlockingQueue, Util.threadFactory(String.format((String)"OkHttp %s Push Observer", (Object[])arrobject), true));
            this.peerSettings.set(7, 0, 65535);
            this.peerSettings.set(5, 0, 16384);
        } else {
            if (this.protocol != Protocol.SPDY_3) {
                throw new AssertionError((Object)this.protocol);
            }
            this.variant = new Spdy3();
            this.pushExecutor = null;
        }
        this.bytesLeftInWriteWindow = this.peerSettings.getInitialWindowSize(65536);
        this.socket = builder.socket;
        this.frameWriter = this.variant.newWriter(builder.sink, this.client);
        this.readerRunnable = new Reader((FramedConnection)this, this.variant.newReader(builder.source, this.client), null);
        new Thread((Runnable)this.readerRunnable).start();
    }

    /* synthetic */ FramedConnection(Builder builder,  var2_2) throws IOException {
        super(builder);
    }

    static /* synthetic */ void access$1200(FramedConnection framedConnection, ErrorCode errorCode, ErrorCode errorCode2) throws IOException {
        framedConnection.close(errorCode, errorCode2);
    }

    /*
     * Exception decompiling
     */
    private void close(ErrorCode var1, ErrorCode var2_2) throws IOException {
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
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private FramedStream newStream(int n2, List<Header> list, boolean bl2, boolean bl3) throws IOException {
        FrameWriter frameWriter;
        boolean bl4 = true;
        boolean bl5 = !bl2 ? bl4 : false;
        if (bl3) {
            bl4 = false;
        }
        FrameWriter frameWriter2 = frameWriter = this.frameWriter;
        // MONITORENTER : frameWriter2
        void var14_9 = this;
        // MONITORENTER : var14_9
        if (this.shutdown) {
            throw new IOException("shutdown");
        }
        int n3 = this.nextStreamId;
        this.nextStreamId = 2 + this.nextStreamId;
        FramedStream framedStream = new FramedStream(n3, (FramedConnection)this, bl5, bl4, list);
        if (framedStream.isOpen()) {
            this.streams.put((Object)n3, (Object)framedStream);
            super.setIdle(false);
        }
        // MONITOREXIT : var14_9
        if (n2 == 0) {
            this.frameWriter.synStream(bl5, bl4, n3, n2, list);
        } else {
            if (this.client) {
                throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
            }
            this.frameWriter.pushPromise(n2, n3, list);
        }
        // MONITOREXIT : frameWriter2
        if (bl2) return framedStream;
        this.frameWriter.flush();
        return framedStream;
    }

    private void pushDataLater(final int n2, BufferedSource bufferedSource, final int n3, final boolean bl2) throws IOException {
        final Buffer buffer = new Buffer();
        bufferedSource.require(n3);
        bufferedSource.read(buffer, (long)n3);
        if (buffer.size() != (long)n3) {
            throw new IOException("" + buffer.size() + " != " + n3);
        }
        ExecutorService executorService = this.pushExecutor;
        Object[] arrobject = new Object[]{this.hostname, n2};
        executorService.execute((Runnable)new NamedRunnable("OkHttp %s Push Data[%s]", arrobject){

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Converted monitor instructions to comments
             * Lifted jumps to return sites
             */
            @Override
            public void execute() {
                try {
                    FramedConnection framedConnection;
                    boolean bl22 = FramedConnection.this.pushObserver.onData(n2, buffer, n3, bl2);
                    if (bl22) {
                        FramedConnection.this.frameWriter.rstStream(n2, ErrorCode.CANCEL);
                    }
                    if (!bl22) {
                        if (!bl2) return;
                    }
                    FramedConnection framedConnection2 = framedConnection = FramedConnection.this;
                    // MONITORENTER : framedConnection2
                }
                catch (IOException var1_4) {
                    // empty catch block
                }
                FramedConnection.this.currentPushRequests.remove((Object)n2);
                // MONITOREXIT : framedConnection2
                return;
            }
        });
    }

    private void pushHeadersLater(final int n2, final List<Header> list, final boolean bl2) {
        ExecutorService executorService = this.pushExecutor;
        Object[] arrobject = new Object[]{this.hostname, n2};
        executorService.execute((Runnable)new NamedRunnable("OkHttp %s Push Headers[%s]", arrobject){

            /*
             * Unable to fully structure code
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Converted monitor instructions to comments
             * Lifted jumps to return sites
             */
            @Override
            public void execute() {
                var1_1 = FramedConnection.access$2700(FramedConnection.this).onHeaders(n2, list, bl2);
                if (!var1_1) ** GOTO lbl5
                try {
                    FramedConnection.this.frameWriter.rstStream(n2, ErrorCode.CANCEL);
lbl5: // 2 sources:
                    if (!var1_1) {
                        if (bl2 == false) return;
                    }
                    var6_3 = var3_2 = FramedConnection.this;
                    // MONITORENTER : var6_3
                }
                catch (IOException var2_4) {
                    // empty catch block
                }
                FramedConnection.access$2800(FramedConnection.this).remove((Object)n2);
                // MONITOREXIT : var6_3
                return;
            }
        });
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void pushRequestLater(final int n2, final List<Header> list) {
        void var7_3 = this;
        synchronized (var7_3) {
            if (this.currentPushRequests.contains((Object)n2)) {
                this.writeSynResetLater(n2, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.currentPushRequests.add((Object)n2);
        }
        ExecutorService executorService = this.pushExecutor;
        Object[] arrobject = new Object[]{this.hostname, n2};
        executorService.execute((Runnable)new NamedRunnable("OkHttp %s Push Request[%s]", arrobject){

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Converted monitor instructions to comments
             * Lifted jumps to return sites
             */
            @Override
            public void execute() {
                if (!FramedConnection.this.pushObserver.onRequest(n2, list)) return;
                try {
                    FramedConnection framedConnection;
                    FramedConnection.this.frameWriter.rstStream(n2, ErrorCode.CANCEL);
                    FramedConnection framedConnection2 = framedConnection = FramedConnection.this;
                    // MONITORENTER : framedConnection2
                }
                catch (IOException var1_3) {
                    // empty catch block
                }
                FramedConnection.this.currentPushRequests.remove((Object)n2);
                // MONITOREXIT : framedConnection2
                return;
            }
        });
    }

    private void pushResetLater(final int n2, final ErrorCode errorCode) {
        ExecutorService executorService = this.pushExecutor;
        Object[] arrobject = new Object[]{this.hostname, n2};
        executorService.execute((Runnable)new NamedRunnable("OkHttp %s Push Reset[%s]", arrobject){

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void execute() {
                FramedConnection framedConnection;
                FramedConnection.this.pushObserver.onReset(n2, errorCode);
                FramedConnection framedConnection2 = framedConnection = FramedConnection.this;
                synchronized (framedConnection2) {
                    FramedConnection.this.currentPushRequests.remove((Object)n2);
                    return;
                }
            }
        });
    }

    private boolean pushedStream(int n2) {
        if (this.protocol == Protocol.HTTP_2 && n2 != 0 && (n2 & 1) == 0) {
            return true;
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private Ping removePing(int n2) {
        void var4_2 = this;
        synchronized (var4_2) {
            if (this.pings == null) return null;
            return (Ping)this.pings.remove((Object)n2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void setIdle(boolean bl2) {
        void var5_2 = this;
        synchronized (var5_2) {
            long l2 = bl2 ? System.nanoTime() : Long.MAX_VALUE;
            this.idleStartTimeNs = l2;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void writePing(boolean bl2, int n2, int n3, Ping ping) throws IOException {
        FrameWriter frameWriter;
        FrameWriter frameWriter2 = frameWriter = this.frameWriter;
        synchronized (frameWriter2) {
            if (ping != null) {
                ping.send();
            }
            this.frameWriter.ping(bl2, n2, n3);
            return;
        }
    }

    private void writePingLater(final boolean bl2, final int n2, final int n3, final Ping ping) {
        ExecutorService executorService = executor;
        Object[] arrobject = new Object[]{this.hostname, n2, n3};
        executorService.execute((Runnable)new NamedRunnable("OkHttp %s ping %08x%08x", arrobject){

            @Override
            public void execute() {
                try {
                    FramedConnection.this.writePing(bl2, n2, n3, ping);
                    return;
                }
                catch (IOException var1_1) {
                    return;
                }
            }
        });
    }

    void addBytesToWriteWindow(long l2) {
        this.bytesLeftInWriteWindow = l2 + this.bytesLeftInWriteWindow;
        if (l2 > 0) {
            this.notifyAll();
        }
    }

    public void close() throws IOException {
        this.close(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    public void flush() throws IOException {
        this.frameWriter.flush();
    }

    public long getIdleStartTimeNs() {
        FramedConnection framedConnection = this;
        synchronized (framedConnection) {
            long l2 = this.idleStartTimeNs;
            return l2;
        }
    }

    public Protocol getProtocol() {
        return this.protocol;
    }

    FramedStream getStream(int n2) {
        void var4_2 = this;
        synchronized (var4_2) {
            FramedStream framedStream = (FramedStream)this.streams.get((Object)n2);
            return framedStream;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean isIdle() {
        FramedConnection framedConnection = this;
        synchronized (framedConnection) {
            long l2 = this.idleStartTimeNs;
            if (l2 == Long.MAX_VALUE) return false;
            return true;
        }
    }

    public int maxConcurrentStreams() {
        FramedConnection framedConnection = this;
        synchronized (framedConnection) {
            int n2 = this.peerSettings.getMaxConcurrentStreams(Integer.MAX_VALUE);
            return n2;
        }
    }

    public FramedStream newStream(List<Header> list, boolean bl2, boolean bl3) throws IOException {
        return super.newStream(0, list, bl2, bl3);
    }

    public int openStreamCount() {
        FramedConnection framedConnection = this;
        synchronized (framedConnection) {
            int n2 = this.streams.size();
            return n2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Ping ping() throws IOException {
        int n2;
        Ping ping = new Ping();
        FramedConnection framedConnection = this;
        synchronized (framedConnection) {
            if (this.shutdown) {
                throw new IOException("shutdown");
            }
            n2 = this.nextPingId;
            this.nextPingId = 2 + this.nextPingId;
            if (this.pings == null) {
                this.pings = new HashMap();
            }
            this.pings.put((Object)n2, (Object)ping);
        }
        this.writePing(false, n2, 1330343787, ping);
        return ping;
    }

    public FramedStream pushStream(int n2, List<Header> list, boolean bl2) throws IOException {
        if (this.client) {
            throw new IllegalStateException("Client cannot push requests.");
        }
        if (this.protocol != Protocol.HTTP_2) {
            throw new IllegalStateException("protocol != HTTP_2");
        }
        return super.newStream(n2, list, bl2, false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    FramedStream removeStream(int n2) {
        void var4_2 = this;
        synchronized (var4_2) {
            FramedStream framedStream = (FramedStream)this.streams.remove((Object)n2);
            if (framedStream != null && this.streams.isEmpty()) {
                super.setIdle(true);
            }
            this.notifyAll();
            return framedStream;
        }
    }

    public void sendConnectionPreface() throws IOException {
        this.frameWriter.connectionPreface();
        this.frameWriter.settings(this.okHttpSettings);
        int n2 = this.okHttpSettings.getInitialWindowSize(65536);
        if (n2 != 65536) {
            this.frameWriter.windowUpdate(0, n2 - 65536);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setSettings(Settings settings) throws IOException {
        FrameWriter frameWriter;
        FrameWriter frameWriter2 = frameWriter = this.frameWriter;
        synchronized (frameWriter2) {
            void var6_4 = this;
            synchronized (var6_4) {
                if (this.shutdown) {
                    throw new IOException("shutdown");
                }
                this.okHttpSettings.merge(settings);
                this.frameWriter.settings(settings);
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void shutdown(ErrorCode errorCode) throws IOException {
        FrameWriter frameWriter;
        FrameWriter frameWriter2 = frameWriter = this.frameWriter;
        synchronized (frameWriter2) {
            int n2;
            void var7_4 = this;
            synchronized (var7_4) {
                if (this.shutdown) {
                    return;
                }
                this.shutdown = true;
                n2 = this.lastGoodStreamId;
            }
            this.frameWriter.goAway(n2, errorCode, Util.EMPTY_BYTE_ARRAY);
            return;
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
    public void writeData(int var1_1, boolean var2_4, Buffer var3_3, long var4) throws IOException {
        if (var4 != 0) ** GOTO lbl10
        this.frameWriter.data(var2_4, var1_1, var3_3, 0);
        return;
        {
            var8_5 = Math.min((int)((int)Math.min((long)var4, (long)this.bytesLeftInWriteWindow)), (int)this.frameWriter.maxDataLength());
            this.bytesLeftInWriteWindow -= (long)var8_5;
            // MONITOREXIT : this
            var9_7 = this.frameWriter;
            var10_8 = var2_4 != false && (var4 -= (long)var8_5) == 0;
            var9_7.data(var10_8, var1_1, var3_3, var8_5);
lbl10: // 2 sources:
            if (var4 <= 0) return;
            var11_6 = this;
            // MONITORENTER : var11_6
            do {
                if (this.bytesLeftInWriteWindow > 0) continue block6;
                if (!this.streams.containsKey((Object)var1_1)) {
                    throw new IOException("stream closed");
                }
                this.wait();
            } while (true);
        }
        catch (InterruptedException var7_9) {
            throw new InterruptedIOException();
        }
    }

    void writeSynReply(int n2, boolean bl2, List<Header> list) throws IOException {
        this.frameWriter.synReply(bl2, n2, list);
    }

    void writeSynReset(int n2, ErrorCode errorCode) throws IOException {
        this.frameWriter.rstStream(n2, errorCode);
    }

    void writeSynResetLater(final int n2, final ErrorCode errorCode) {
        ExecutorService executorService = executor;
        Object[] arrobject = new Object[]{this.hostname, n2};
        executorService.submit((Runnable)new NamedRunnable("OkHttp %s stream %d", arrobject){

            @Override
            public void execute() {
                try {
                    FramedConnection.this.writeSynReset(n2, errorCode);
                    return;
                }
                catch (IOException var1_1) {
                    return;
                }
            }
        });
    }

    void writeWindowUpdateLater(final int n2, final long l2) {
        ExecutorService executorService = executor;
        Object[] arrobject = new Object[]{this.hostname, n2};
        executorService.execute((Runnable)new NamedRunnable("OkHttp Window Update %s stream %d", arrobject){

            @Override
            public void execute() {
                try {
                    FramedConnection.this.frameWriter.windowUpdate(n2, l2);
                    return;
                }
                catch (IOException var1_1) {
                    return;
                }
            }
        });
    }

    public static class Builder {
        private boolean client;
        private String hostname;
        private Listener listener = Listener.REFUSE_INCOMING_STREAMS;
        private Protocol protocol = Protocol.SPDY_3;
        private PushObserver pushObserver = PushObserver.CANCEL;
        private BufferedSink sink;
        private Socket socket;
        private BufferedSource source;

        public Builder(boolean bl2) throws IOException {
            this.client = bl2;
        }

        public FramedConnection build() throws IOException {
            return new FramedConnection(this, null);
        }

        public Builder listener(Listener listener) {
            this.listener = listener;
            return this;
        }

        public Builder protocol(Protocol protocol) {
            this.protocol = protocol;
            return this;
        }

        public Builder pushObserver(PushObserver pushObserver) {
            this.pushObserver = pushObserver;
            return this;
        }

        public Builder socket(Socket socket) throws IOException {
            return this.socket(socket, ((InetSocketAddress)socket.getRemoteSocketAddress()).getHostName(), Okio.buffer(Okio.source(socket)), Okio.buffer(Okio.sink(socket)));
        }

        public Builder socket(Socket socket, String string2, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.socket = socket;
            this.hostname = string2;
            this.source = bufferedSource;
            this.sink = bufferedSink;
            return this;
        }
    }

    public static abstract class Listener {
        public static final Listener REFUSE_INCOMING_STREAMS = new Listener(){

            @Override
            public void onStream(FramedStream framedStream) throws IOException {
                framedStream.close(ErrorCode.REFUSED_STREAM);
            }
        };

        public void onSettings(FramedConnection framedConnection) {
        }

        public abstract void onStream(FramedStream var1) throws IOException;

    }

    class Reader
    extends NamedRunnable
    implements FrameReader.Handler {
        final FrameReader frameReader;
        final /* synthetic */ FramedConnection this$0;

        private Reader(FramedConnection framedConnection, FrameReader frameReader) {
            this.this$0 = framedConnection;
            Object[] arrobject = new Object[]{framedConnection.hostname};
            super("OkHttp %s", arrobject);
            this.frameReader = frameReader;
        }

        /* synthetic */ Reader(FramedConnection framedConnection, FrameReader frameReader, okhttp3.internal.framed.FramedConnection$1 var3_2) {
            super(framedConnection, frameReader);
        }

        private void ackSettingsLater(final Settings settings) {
            ExecutorService executorService = executor;
            Object[] arrobject = new Object[]{this.this$0.hostname};
            executorService.execute((Runnable)new NamedRunnable("OkHttp %s ACK Settings", arrobject){

                @Override
                public void execute() {
                    try {
                        Reader.this.this$0.frameWriter.ackSettings(settings);
                        return;
                    }
                    catch (IOException var1_1) {
                        return;
                    }
                }
            });
        }

        @Override
        public void ackSettings() {
        }

        @Override
        public void alternateService(int n2, String string2, ByteString byteString, String string3, int n3, long l2) {
        }

        /*
         * Enabled aggressive block sorting
         */
        @Override
        public void data(boolean bl2, int n2, BufferedSource bufferedSource, int n3) throws IOException {
            if (this.this$0.pushedStream(n2)) {
                this.this$0.pushDataLater(n2, bufferedSource, n3, bl2);
                return;
            } else {
                FramedStream framedStream = this.this$0.getStream(n2);
                if (framedStream == null) {
                    this.this$0.writeSynResetLater(n2, ErrorCode.INVALID_STREAM);
                    bufferedSource.skip(n3);
                    return;
                }
                framedStream.receiveData(bufferedSource, n3);
                if (!bl2) return;
                {
                    framedStream.receiveFin();
                    return;
                }
            }
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive exception aggregation
         */
        @Override
        protected void execute() {
            var1_1 = ErrorCode.INTERNAL_ERROR;
            var2_2 = ErrorCode.INTERNAL_ERROR;
            if (!this.this$0.client) {
                this.frameReader.readConnectionPreface();
            }
            while (this.frameReader.nextFrame(this)) {
            }
            var1_1 = ErrorCode.NO_ERROR;
            var8_3 = ErrorCode.CANCEL;
            try {
                FramedConnection.access$1200(this.this$0, var1_1, var8_3);
            }
            catch (IOException var9_9) {
                ** continue;
            }
lbl14: // 2 sources:
            do {
                Util.closeQuietly(this.frameReader);
                return;
                break;
            } while (true);
            catch (IOException var5_4) {
                try {
                    var1_1 = ErrorCode.PROTOCOL_ERROR;
                    var6_5 = ErrorCode.PROTOCOL_ERROR;
                }
                catch (Throwable var3_6) {
                    try {
                        FramedConnection.access$1200(this.this$0, var1_1, var2_2);
                    }
                    catch (IOException var4_7) {
                        ** continue;
                    }
lbl26: // 2 sources:
                    do {
                        Util.closeQuietly(this.frameReader);
                        throw var3_6;
                        break;
                    } while (true);
                }
                try {
                    FramedConnection.access$1200(this.this$0, var1_1, var6_5);
                }
                catch (IOException var7_8) {
                    ** continue;
                }
lbl33: // 2 sources:
                do {
                    Util.closeQuietly(this.frameReader);
                    return;
                    break;
                } while (true);
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void goAway(int n2, ErrorCode errorCode, ByteString byteString) {
            FramedStream[] arrframedStream;
            FramedConnection framedConnection;
            if (byteString.size() > 0) {
                // empty if block
            }
            FramedConnection framedConnection2 = framedConnection = this.this$0;
            synchronized (framedConnection2) {
                arrframedStream = (FramedStream[])this.this$0.streams.values().toArray((Object[])new FramedStream[this.this$0.streams.size()]);
                this.this$0.shutdown = true;
            }
            int n3 = arrframedStream.length;
            int n4 = 0;
            while (n4 < n3) {
                FramedStream framedStream = arrframedStream[n4];
                if (framedStream.getId() > n2 && framedStream.isLocallyInitiated()) {
                    framedStream.receiveRstStream(ErrorCode.REFUSED_STREAM);
                    this.this$0.removeStream(framedStream.getId());
                }
                ++n4;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Converted monitor instructions to comments
         * Lifted jumps to return sites
         */
        @Override
        public void headers(boolean bl2, boolean bl3, int n2, int n3, List<Header> list, HeadersMode headersMode) {
            FramedConnection framedConnection;
            if (this.this$0.pushedStream(n2)) {
                this.this$0.pushHeadersLater(n2, list, bl3);
                return;
            }
            FramedConnection framedConnection2 = framedConnection = this.this$0;
            // MONITORENTER : framedConnection2
            if (this.this$0.shutdown) {
                // MONITOREXIT : framedConnection2
                return;
            }
            FramedStream framedStream = this.this$0.getStream(n2);
            if (framedStream == null) {
                if (headersMode.failIfStreamAbsent()) {
                    this.this$0.writeSynResetLater(n2, ErrorCode.INVALID_STREAM);
                    // MONITOREXIT : framedConnection2
                    return;
                }
                if (n2 <= this.this$0.lastGoodStreamId) {
                    // MONITOREXIT : framedConnection2
                    return;
                }
                if (n2 % 2 == this.this$0.nextStreamId % 2) {
                    // MONITOREXIT : framedConnection2
                    return;
                }
                final FramedStream framedStream2 = new FramedStream(n2, this.this$0, bl2, bl3, list);
                this.this$0.lastGoodStreamId = n2;
                this.this$0.streams.put((Object)n2, (Object)framedStream2);
                ExecutorService executorService = executor;
                Object[] arrobject = new Object[]{this.this$0.hostname, n2};
                executorService.execute((Runnable)new NamedRunnable("OkHttp %s stream %d", arrobject){

                    @Override
                    public void execute() {
                        try {
                            Reader.this.this$0.listener.onStream(framedStream2);
                            return;
                        }
                        catch (IOException var1_1) {
                            Internal.logger.log(Level.INFO, "FramedConnection.Listener failure for " + Reader.this.this$0.hostname, (Throwable)var1_1);
                            try {
                                framedStream2.close(ErrorCode.PROTOCOL_ERROR);
                                return;
                            }
                            catch (IOException var2_2) {
                                return;
                            }
                        }
                    }
                });
                // MONITOREXIT : framedConnection2
                return;
            }
            // MONITOREXIT : framedConnection2
            if (headersMode.failIfStreamPresent()) {
                framedStream.closeLater(ErrorCode.PROTOCOL_ERROR);
                this.this$0.removeStream(n2);
                return;
            }
            framedStream.receiveHeaders(list, headersMode);
            if (!bl3) return;
            framedStream.receiveFin();
        }

        @Override
        public void ping(boolean bl2, int n2, int n3) {
            if (bl2) {
                Ping ping = this.this$0.removePing(n2);
                if (ping != null) {
                    ping.receive();
                }
                return;
            }
            this.this$0.writePingLater(true, n2, n3, null);
        }

        @Override
        public void priority(int n2, int n3, int n4, boolean bl2) {
        }

        @Override
        public void pushPromise(int n2, int n3, List<Header> list) {
            this.this$0.pushRequestLater(n3, list);
        }

        /*
         * Enabled aggressive block sorting
         */
        @Override
        public void rstStream(int n2, ErrorCode errorCode) {
            if (this.this$0.pushedStream(n2)) {
                this.this$0.pushResetLater(n2, errorCode);
                return;
            } else {
                FramedStream framedStream = this.this$0.removeStream(n2);
                if (framedStream == null) return;
                {
                    framedStream.receiveRstStream(errorCode);
                    return;
                }
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Converted monitor instructions to comments
         * Lifted jumps to return sites
         */
        @Override
        public void settings(boolean bl2, Settings settings) {
            FramedConnection framedConnection;
            long l2 = 0;
            FramedConnection framedConnection2 = framedConnection = this.this$0;
            // MONITORENTER : framedConnection2
            int n2 = this.this$0.peerSettings.getInitialWindowSize(65536);
            if (bl2) {
                this.this$0.peerSettings.clear();
            }
            this.this$0.peerSettings.merge(settings);
            if (this.this$0.getProtocol() == Protocol.HTTP_2) {
                super.ackSettingsLater(settings);
            }
            int n3 = this.this$0.peerSettings.getInitialWindowSize(65536);
            FramedStream[] arrframedStream = null;
            if (n3 != -1) {
                arrframedStream = null;
                if (n3 != n2) {
                    l2 = n3 - n2;
                    if (!this.this$0.receivedInitialPeerSettings) {
                        this.this$0.addBytesToWriteWindow(l2);
                        this.this$0.receivedInitialPeerSettings = true;
                    }
                    boolean bl3 = this.this$0.streams.isEmpty();
                    arrframedStream = null;
                    if (!bl3) {
                        arrframedStream = (FramedStream[])this.this$0.streams.values().toArray((Object[])new FramedStream[this.this$0.streams.size()]);
                    }
                }
            }
            ExecutorService executorService = executor;
            Object[] arrobject = new Object[]{this.this$0.hostname};
            executorService.execute((Runnable)new NamedRunnable("OkHttp %s settings", arrobject){

                @Override
                public void execute() {
                    Reader.this.this$0.listener.onSettings(Reader.this.this$0);
                }
            });
            // MONITOREXIT : framedConnection2
            if (arrframedStream == null) return;
            if (l2 == 0) return;
            int n4 = arrframedStream.length;
            int n5 = 0;
            while (n5 < n4) {
                FramedStream framedStream;
                FramedStream framedStream2 = framedStream = arrframedStream[n5];
                // MONITORENTER : framedStream2
                framedStream.addBytesToWriteWindow(l2);
                // MONITOREXIT : framedStream2
                ++n5;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void windowUpdate(int n2, long l2) {
            if (n2 == 0) {
                FramedConnection framedConnection;
                FramedConnection framedConnection2 = framedConnection = this.this$0;
                synchronized (framedConnection2) {
                    FramedConnection framedConnection3 = this.this$0;
                    framedConnection3.bytesLeftInWriteWindow = l2 + framedConnection3.bytesLeftInWriteWindow;
                    this.this$0.notifyAll();
                    return;
                }
            }
            FramedStream framedStream = this.this$0.getStream(n2);
            if (framedStream != null) {
                FramedStream framedStream2 = framedStream;
                synchronized (framedStream2) {
                    framedStream.addBytesToWriteWindow(l2);
                    return;
                }
            }
        }

    }

}

