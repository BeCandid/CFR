/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.ref.Reference
 *  java.net.ConnectException
 *  java.net.InetSocketAddress
 *  java.net.Proxy
 *  java.net.Socket
 *  java.net.SocketTimeoutException
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.concurrent.TimeUnit
 *  javax.net.ssl.SSLSocketFactory
 */
package okhttp3.internal.io;

import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Address;
import okhttp3.Authenticator;
import okhttp3.CipherSuite;
import okhttp3.Connection;
import okhttp3.ConnectionSpec;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.ConnectionSpecSelector;
import okhttp3.internal.Platform;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okhttp3.internal.framed.ErrorCode;
import okhttp3.internal.framed.FramedConnection;
import okhttp3.internal.framed.FramedStream;
import okhttp3.internal.http.Http1xStream;
import okhttp3.internal.http.OkHeaders;
import okhttp3.internal.http.RouteException;
import okhttp3.internal.http.StreamAllocation;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import okio.Timeout;

public final class RealConnection
extends FramedConnection.Listener
implements Connection {
    public int allocationLimit;
    public final List<Reference<StreamAllocation>> allocations = new ArrayList();
    public volatile FramedConnection framedConnection;
    private Handshake handshake;
    public long idleAtNanos = Long.MAX_VALUE;
    public boolean noNewStreams;
    private Protocol protocol;
    private Socket rawSocket;
    private final Route route;
    public BufferedSink sink;
    public Socket socket;
    public BufferedSource source;
    public int successCount;

    public RealConnection(Route route) {
        this.route = route;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void connectSocket(int n2, int n3, int n4, ConnectionSpecSelector connectionSpecSelector) throws IOException {
        this.rawSocket.setSoTimeout(n3);
        try {
            Platform.get().connectSocket(this.rawSocket, this.route.socketAddress(), n2);
        }
        catch (ConnectException var5_6) {
            throw new ConnectException("Failed to connect to " + (Object)this.route.socketAddress());
        }
        this.source = Okio.buffer(Okio.source(this.rawSocket));
        this.sink = Okio.buffer(Okio.sink(this.rawSocket));
        if (this.route.address().sslSocketFactory() != null) {
            super.connectTls(n3, n4, connectionSpecSelector);
        } else {
            this.protocol = Protocol.HTTP_1_1;
            this.socket = this.rawSocket;
        }
        if (this.protocol != Protocol.SPDY_3 && this.protocol != Protocol.HTTP_2) {
            this.allocationLimit = 1;
            return;
        }
        this.socket.setSoTimeout(0);
        FramedConnection framedConnection = new FramedConnection.Builder(true).socket(this.socket, this.route.address().url().host(), this.source, this.sink).protocol(this.protocol).listener((FramedConnection.Listener)this).build();
        framedConnection.sendConnectionPreface();
        this.allocationLimit = framedConnection.maxConcurrentStreams();
        this.framedConnection = framedConnection;
    }

    /*
     * Exception decompiling
     */
    private void connectTls(int var1, int var2_3, ConnectionSpecSelector var3_2) throws IOException {
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

    private void createTunnel(int n2, int n3) throws IOException {
        Request request = super.createTunnelRequest();
        HttpUrl httpUrl = request.url();
        String string2 = "CONNECT " + Util.hostHeader(httpUrl, true) + " HTTP/1.1";
        block4 : do {
            Http1xStream http1xStream = new Http1xStream(null, this.source, this.sink);
            this.source.timeout().timeout(n2, TimeUnit.MILLISECONDS);
            this.sink.timeout().timeout(n3, TimeUnit.MILLISECONDS);
            http1xStream.writeRequest(request.headers(), string2);
            http1xStream.finishRequest();
            Response response = http1xStream.readResponse().request(request).build();
            long l2 = OkHeaders.contentLength(response);
            if (l2 == -1) {
                l2 = 0;
            }
            Source source = http1xStream.newFixedLengthSource(l2);
            Util.skipAll(source, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            source.close();
            switch (response.code()) {
                default: {
                    throw new IOException("Unexpected response code for CONNECT: " + response.code());
                }
                case 200: {
                    if (this.source.buffer().exhausted() && this.sink.buffer().exhausted()) break block4;
                    throw new IOException("TLS tunnel buffered too many bytes!");
                }
                case 407: {
                    if ((request = this.route.address().proxyAuthenticator().authenticate(this.route, response)) != null) continue block4;
                    throw new IOException("Failed to authenticate with proxy");
                }
            }
            break;
        } while (true);
    }

    private Request createTunnelRequest() throws IOException {
        return new Request.Builder().url(this.route.address().url()).header("Host", Util.hostHeader(this.route.address().url(), true)).header("Proxy-Connection", "Keep-Alive").header("User-Agent", Version.userAgent()).build();
    }

    public void cancel() {
        Util.closeQuietly(this.rawSocket);
    }

    /*
     * Exception decompiling
     */
    public void connect(int var1_4, int var2_5, int var3_2, List<ConnectionSpec> var4_3, boolean var5_1) throws RouteException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 4[UNCONDITIONALDOLOOP]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2859)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:805)
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
    public Handshake handshake() {
        return this.handshake;
    }

    boolean isConnected() {
        if (this.protocol != null) {
            return true;
        }
        return false;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public boolean isHealthy(boolean var1) {
        var2_2 = true;
        if (this.socket.isClosed() != false) return false;
        if (this.socket.isInputShutdown() != false) return false;
        if (this.socket.isOutputShutdown()) {
            return false;
        }
        if (this.framedConnection != null) return var2_2;
        if (var1 == false) return var2_2;
        var5_3 = this.socket.getSoTimeout();
        this.socket.setSoTimeout(1);
        var7_4 = this.source.exhausted();
        if (!var7_4) ** GOTO lbl20
        {
            catch (Throwable var6_5) {
                this.socket.setSoTimeout(var5_3);
                throw var6_5;
            }
        }
        try {
            this.socket.setSoTimeout(var5_3);
            return false;
lbl20: // 1 sources:
            this.socket.setSoTimeout(var5_3);
            return var2_2;
        }
        catch (IOException var3_6) {
            return false;
        }
        catch (SocketTimeoutException var4_7) {
            return var2_2;
        }
    }

    public boolean isMultiplexed() {
        if (this.framedConnection != null) {
            return true;
        }
        return false;
    }

    @Override
    public void onSettings(FramedConnection framedConnection) {
        this.allocationLimit = framedConnection.maxConcurrentStreams();
    }

    @Override
    public void onStream(FramedStream framedStream) throws IOException {
        framedStream.close(ErrorCode.REFUSED_STREAM);
    }

    @Override
    public Protocol protocol() {
        if (this.framedConnection == null) {
            if (this.protocol != null) {
                return this.protocol;
            }
            return Protocol.HTTP_1_1;
        }
        return this.framedConnection.getProtocol();
    }

    @Override
    public Route route() {
        return this.route;
    }

    @Override
    public Socket socket() {
        return this.socket;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String toString() {
        Object object;
        StringBuilder stringBuilder = new StringBuilder().append("Connection{").append(this.route.address().url().host()).append(":").append(this.route.address().url().port()).append(", proxy=").append((Object)this.route.proxy()).append(" hostAddress=").append((Object)this.route.socketAddress()).append(" cipherSuite=");
        if (this.handshake != null) {
            object = this.handshake.cipherSuite();
            do {
                return stringBuilder.append(object).append(" protocol=").append((Object)this.protocol).append('}').toString();
                break;
            } while (true);
        }
        object = "none";
        return stringBuilder.append(object).append(" protocol=").append((Object)this.protocol).append('}').toString();
    }
}

