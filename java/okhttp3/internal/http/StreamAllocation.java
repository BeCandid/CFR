/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InterruptedIOException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.lang.ref.Reference
 *  java.lang.ref.WeakReference
 *  java.net.ProtocolException
 *  java.net.Socket
 *  java.net.SocketTimeoutException
 *  java.security.cert.CertificateException
 *  java.util.List
 *  java.util.concurrent.TimeUnit
 *  javax.net.ssl.SSLHandshakeException
 *  javax.net.ssl.SSLPeerUnverifiedException
 */
package okhttp3.internal.http;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.Address;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.RouteDatabase;
import okhttp3.internal.Util;
import okhttp3.internal.framed.FramedConnection;
import okhttp3.internal.http.Http1xStream;
import okhttp3.internal.http.Http2xStream;
import okhttp3.internal.http.HttpStream;
import okhttp3.internal.http.RetryableSink;
import okhttp3.internal.http.RouteException;
import okhttp3.internal.http.RouteSelector;
import okhttp3.internal.io.RealConnection;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Sink;
import okio.Timeout;

public final class StreamAllocation {
    public final Address address;
    private boolean canceled;
    private RealConnection connection;
    private final ConnectionPool connectionPool;
    private boolean released;
    private Route route;
    private RouteSelector routeSelector;
    private HttpStream stream;

    public StreamAllocation(ConnectionPool connectionPool, Address address) {
        this.connectionPool = connectionPool;
        this.address = address;
        this.routeSelector = new RouteSelector(address, super.routeDatabase());
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void deallocate(boolean var1, boolean var2_3, boolean var3_2) {
        var12_5 = var4_4 = this.connectionPool;
        // MONITORENTER : var12_5
        if (var3_2) {
            this.stream = null;
        }
        if (var2_3) {
            this.released = true;
        }
        var6_6 = this.connection;
        var7_7 = null;
        if (var6_6 == null) ** GOTO lbl29
        if (var1) {
            this.connection.noNewStreams = true;
        }
        var8_8 = this.stream;
        var7_7 = null;
        if (var8_8 != null) ** GOTO lbl29
        if (this.released) ** GOTO lbl-1000
        var11_9 = this.connection.noNewStreams;
        var7_7 = null;
        if (var11_9) lbl-1000: // 2 sources:
        {
            super.release(this.connection);
            var9_10 = this.connection.allocations.isEmpty();
            var7_7 = null;
            if (var9_10) {
                this.connection.idleAtNanos = System.nanoTime();
                var10_11 = Internal.instance.connectionBecameIdle(this.connectionPool, this.connection);
                var7_7 = null;
                if (var10_11) {
                    var7_7 = this.connection;
                }
            }
            this.connection = null;
        }
lbl29: // 5 sources:
        // MONITOREXIT : var12_5
        if (var7_7 == null) return;
        Util.closeQuietly(var7_7.socket());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private RealConnection findConnection(int n2, int n3, int n4, boolean bl2) throws IOException, RouteException {
        ConnectionPool connectionPool;
        ConnectionPool connectionPool2;
        ConnectionPool connectionPool3 = connectionPool2 = this.connectionPool;
        // MONITORENTER : connectionPool3
        if (this.released) {
            throw new IllegalStateException("released");
        }
        if (this.stream != null) {
            throw new IllegalStateException("stream != null");
        }
        if (this.canceled) {
            throw new IOException("Canceled");
        }
        RealConnection realConnection = this.connection;
        if (realConnection != null && !realConnection.noNewStreams) {
            // MONITOREXIT : connectionPool3
            return realConnection;
        }
        RealConnection realConnection2 = Internal.instance.get(this.connectionPool, this.address, (StreamAllocation)this);
        if (realConnection2 != null) {
            this.connection = realConnection2;
            // MONITOREXIT : connectionPool3
            return realConnection2;
        }
        Route route = this.route;
        // MONITOREXIT : connectionPool3
        if (route == null) {
            ConnectionPool connectionPool4;
            route = this.routeSelector.next();
            ConnectionPool connectionPool5 = connectionPool4 = this.connectionPool;
            // MONITORENTER : connectionPool5
            this.route = route;
            // MONITOREXIT : connectionPool5
        }
        RealConnection realConnection3 = new RealConnection(route);
        this.acquire(realConnection3);
        ConnectionPool connectionPool6 = connectionPool = this.connectionPool;
        // MONITORENTER : connectionPool6
        Internal.instance.put(this.connectionPool, realConnection3);
        this.connection = realConnection3;
        if (this.canceled) {
            throw new IOException("Canceled");
        }
        // MONITOREXIT : connectionPool6
        realConnection3.connect(n2, n3, n4, this.address.connectionSpecs(), bl2);
        super.routeDatabase().connected(realConnection3.route());
        return realConnection3;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private RealConnection findHealthyConnection(int n2, int n3, int n4, boolean bl2, boolean bl3) throws IOException, RouteException {
        do {
            ConnectionPool connectionPool;
            RealConnection realConnection = this.findConnection(n2, n3, n4, bl2);
            ConnectionPool connectionPool2 = connectionPool = this.connectionPool;
            // MONITORENTER : connectionPool2
            if (realConnection.successCount == 0) {
                // MONITOREXIT : connectionPool2
                return realConnection;
            }
            // MONITOREXIT : connectionPool2
            if (realConnection.isHealthy(bl3)) return realConnection;
            this.connectionFailed(new IOException());
        } while (true);
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private boolean isRecoverable(IOException iOException) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            return iOException instanceof SocketTimeoutException;
        }
        if (iOException instanceof SSLHandshakeException) {
            if (iOException.getCause() instanceof CertificateException) return false;
        }
        if (iOException instanceof SSLPeerUnverifiedException) return false;
        return true;
    }

    private void release(RealConnection realConnection) {
        int n2 = realConnection.allocations.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (((Reference)realConnection.allocations.get(i2)).get() != this) continue;
            realConnection.allocations.remove(i2);
            return;
        }
        throw new IllegalStateException();
    }

    private RouteDatabase routeDatabase() {
        return Internal.instance.routeDatabase(this.connectionPool);
    }

    public void acquire(RealConnection realConnection) {
        realConnection.allocations.add((Object)new WeakReference((Object)this));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void cancel() {
        ConnectionPool connectionPool;
        ConnectionPool connectionPool2 = connectionPool = this.connectionPool;
        // MONITORENTER : connectionPool2
        this.canceled = true;
        HttpStream httpStream = this.stream;
        RealConnection realConnection = this.connection;
        // MONITOREXIT : connectionPool2
        if (httpStream != null) {
            httpStream.cancel();
            return;
        }
        if (realConnection == null) return;
        realConnection.cancel();
    }

    public RealConnection connection() {
        StreamAllocation streamAllocation = this;
        synchronized (streamAllocation) {
            RealConnection realConnection = this.connection;
            return realConnection;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void connectionFailed(IOException iOException) {
        ConnectionPool connectionPool;
        ConnectionPool connectionPool2 = connectionPool = this.connectionPool;
        synchronized (connectionPool2) {
            if (this.connection != null && this.connection.successCount == 0) {
                if (this.route != null && iOException != null) {
                    this.routeSelector.connectFailed(this.route, iOException);
                }
                this.route = null;
            }
        }
        super.deallocate(true, false, true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public HttpStream newStream(int n2, int n3, int n4, boolean bl2, boolean bl3) throws RouteException, IOException {
        HttpStream httpStream2;
        try {
            HttpStream httpStream2;
            ConnectionPool connectionPool;
            RealConnection realConnection = this.findHealthyConnection(n2, n3, n4, bl2, bl3);
            if (realConnection.framedConnection != null) {
                httpStream2 = new Http2xStream(this, realConnection.framedConnection);
            } else {
                realConnection.socket().setSoTimeout(n3);
                realConnection.source.timeout().timeout(n3, TimeUnit.MILLISECONDS);
                realConnection.sink.timeout().timeout(n4, TimeUnit.MILLISECONDS);
                httpStream2 = new Http1xStream(this, realConnection.source, realConnection.sink);
            }
            ConnectionPool connectionPool2 = connectionPool = this.connectionPool;
            // MONITORENTER : connectionPool2
        }
        catch (IOException var6_10) {
            throw new RouteException(var6_10);
        }
        this.stream = httpStream2;
        // MONITOREXIT : connectionPool2
        return httpStream2;
    }

    public void noNewStreams() {
        this.deallocate(true, false, false);
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean recover(IOException iOException, Sink sink) {
        boolean bl2 = true;
        if (this.connection != null) {
            this.connectionFailed(iOException);
        }
        boolean bl3 = sink == null || sink instanceof RetryableSink ? bl2 : false;
        if (this.routeSelector != null) {
            if (!this.routeSelector.hasNext()) return false;
        }
        if (!super.isRecoverable(iOException)) return false;
        if (bl3) return bl2;
        return false;
    }

    public void release() {
        this.deallocate(false, true, false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public HttpStream stream() {
        ConnectionPool connectionPool;
        ConnectionPool connectionPool2 = connectionPool = this.connectionPool;
        synchronized (connectionPool2) {
            return this.stream;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void streamFinished(boolean bl2, HttpStream httpStream) {
        ConnectionPool connectionPool;
        ConnectionPool connectionPool2 = connectionPool = this.connectionPool;
        synchronized (connectionPool2) {
            if (httpStream == null || httpStream != this.stream) {
                throw new IllegalStateException("expected " + this.stream + " but was " + httpStream);
            }
            if (!bl2) {
                RealConnection realConnection = this.connection;
                realConnection.successCount = 1 + realConnection.successCount;
            }
        }
        super.deallocate(bl2, false, true);
    }

    public String toString() {
        return this.address.toString();
    }
}

