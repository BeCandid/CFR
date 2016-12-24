/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.ref.Reference
 *  java.net.Socket
 *  java.util.ArrayDeque
 *  java.util.ArrayList
 *  java.util.Deque
 *  java.util.Iterator
 *  java.util.List
 *  java.util.concurrent.BlockingQueue
 *  java.util.concurrent.Executor
 *  java.util.concurrent.SynchronousQueue
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.ThreadPoolExecutor
 *  java.util.concurrent.TimeUnit
 *  java.util.logging.Logger
 */
package okhttp3;

import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import okhttp3.Address;
import okhttp3.HttpUrl;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.RouteDatabase;
import okhttp3.internal.Util;
import okhttp3.internal.http.StreamAllocation;
import okhttp3.internal.io.RealConnection;

public final class ConnectionPool {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final Executor executor;
    private final Runnable cleanupRunnable;
    boolean cleanupRunning;
    private final Deque<RealConnection> connections;
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;
    final RouteDatabase routeDatabase;

    /*
     * Enabled aggressive block sorting
     */
    static {
        boolean bl2 = !ConnectionPool.class.desiredAssertionStatus();
        $assertionsDisabled = bl2;
        executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, (BlockingQueue)new SynchronousQueue(), Util.threadFactory("OkHttp ConnectionPool", true));
    }

    public ConnectionPool() {
        this(5, 5, TimeUnit.MINUTES);
    }

    public ConnectionPool(int n2, long l2, TimeUnit timeUnit) {
        this.cleanupRunnable = new Runnable(){

            /*
             * Exception decompiling
             */
            public void run() {
                // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                // java.util.ConcurrentModificationException
                // java.util.LinkedList$ReverseLinkIterator.next(LinkedList.java:217)
                // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.extractLabelledBlocks(Block.java:212)
                // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:485)
                // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
                // org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredDo.transformStructuredChildren(StructuredDo.java:53)
                // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:487)
                // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
                // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.transformStructuredChildren(Block.java:378)
                // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:487)
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
        };
        this.connections = new ArrayDeque();
        this.routeDatabase = new RouteDatabase();
        this.maxIdleConnections = n2;
        this.keepAliveDurationNs = timeUnit.toNanos(l2);
        if (l2 <= 0) {
            throw new IllegalArgumentException("keepAliveDuration <= 0: " + l2);
        }
    }

    private int pruneAndGetAllocationCount(RealConnection realConnection, long l2) {
        List<Reference<StreamAllocation>> list = realConnection.allocations;
        int n2 = 0;
        while (n2 < list.size()) {
            if (((Reference)list.get(n2)).get() != null) {
                ++n2;
                continue;
            }
            Internal.logger.warning("A connection to " + realConnection.route().address().url() + " was leaked. Did you forget to close a response body?");
            list.remove(n2);
            realConnection.noNewStreams = true;
            if (!list.isEmpty()) continue;
            realConnection.idleAtNanos = l2 - this.keepAliveDurationNs;
            return 0;
        }
        return list.size();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    long cleanup(long l2) {
        int n2 = 0;
        int n3 = 0;
        RealConnection realConnection = null;
        long l3 = Long.MIN_VALUE;
        void var18_6 = this;
        synchronized (var18_6) {
            for (RealConnection realConnection2 : this.connections) {
                if (super.pruneAndGetAllocationCount(realConnection2, l2) > 0) {
                    ++n2;
                    continue;
                }
                ++n3;
                long l4 = l2 - realConnection2.idleAtNanos;
                if (l4 <= l3) continue;
                l3 = l4;
                realConnection = realConnection2;
            }
            if (l3 >= this.keepAliveDurationNs || n3 > this.maxIdleConnections) {
                this.connections.remove((Object)realConnection);
                // MONITOREXIT [8, 4] lbl21 : MonitorExitStatement: MONITOREXIT : var18_6
                Util.closeQuietly(realConnection.socket());
                return 0;
            }
            if (n3 > 0) {
                return this.keepAliveDurationNs - l3;
            }
            if (n2 > 0) {
                return this.keepAliveDurationNs;
            }
            this.cleanupRunning = false;
            return -1;
        }
    }

    boolean connectionBecameIdle(RealConnection realConnection) {
        if (!$assertionsDisabled && !Thread.holdsLock((Object)this)) {
            throw new AssertionError();
        }
        if (realConnection.noNewStreams || this.maxIdleConnections == 0) {
            this.connections.remove((Object)realConnection);
            return true;
        }
        this.notifyAll();
        return false;
    }

    public int connectionCount() {
        ConnectionPool connectionPool = this;
        synchronized (connectionPool) {
            int n2 = this.connections.size();
            return n2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void evictAll() {
        ArrayList arrayList = new ArrayList();
        ConnectionPool connectionPool = this;
        synchronized (connectionPool) {
            Iterator iterator = this.connections.iterator();
            while (iterator.hasNext()) {
                RealConnection realConnection = (RealConnection)iterator.next();
                if (!realConnection.allocations.isEmpty()) continue;
                realConnection.noNewStreams = true;
                arrayList.add((Object)realConnection);
                iterator.remove();
            }
        }
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Util.closeQuietly(((RealConnection)iterator.next()).socket());
        }
        return;
    }

    RealConnection get(Address address, StreamAllocation streamAllocation) {
        if (!$assertionsDisabled && !Thread.holdsLock((Object)this)) {
            throw new AssertionError();
        }
        for (RealConnection realConnection : this.connections) {
            if (realConnection.allocations.size() >= realConnection.allocationLimit || !address.equals(realConnection.route().address) || realConnection.noNewStreams) continue;
            streamAllocation.acquire(realConnection);
            return realConnection;
        }
        return null;
    }

    public int idleConnectionCount() {
        ConnectionPool connectionPool = this;
        synchronized (connectionPool) {
            int n2 = 0;
            Iterator iterator = this.connections.iterator();
            while (iterator.hasNext()) {
                boolean bl2 = ((RealConnection)iterator.next()).allocations.isEmpty();
                if (!bl2) continue;
            }
            {
                ++n2;
                continue;
            }
            return n2;
        }
    }

    void put(RealConnection realConnection) {
        if (!$assertionsDisabled && !Thread.holdsLock((Object)this)) {
            throw new AssertionError();
        }
        if (!this.cleanupRunning) {
            this.cleanupRunning = true;
            executor.execute(this.cleanupRunnable);
        }
        this.connections.add((Object)realConnection);
    }

}

