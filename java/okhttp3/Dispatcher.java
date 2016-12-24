/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.ArrayDeque
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Deque
 *  java.util.Iterator
 *  java.util.List
 *  java.util.concurrent.BlockingQueue
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.SynchronousQueue
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.ThreadPoolExecutor
 *  java.util.concurrent.TimeUnit
 */
package okhttp3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.RealCall;
import okhttp3.internal.Util;

public final class Dispatcher {
    private ExecutorService executorService;
    private int maxRequests;
    private int maxRequestsPerHost;
    private final Deque<RealCall.AsyncCall> readyAsyncCalls;
    private final Deque<RealCall.AsyncCall> runningAsyncCalls;
    private final Deque<RealCall> runningSyncCalls;

    public Dispatcher() {
        this.maxRequests = 64;
        this.maxRequestsPerHost = 5;
        this.readyAsyncCalls = new ArrayDeque();
        this.runningAsyncCalls = new ArrayDeque();
        this.runningSyncCalls = new ArrayDeque();
    }

    public Dispatcher(ExecutorService executorService) {
        this.maxRequests = 64;
        this.maxRequestsPerHost = 5;
        this.readyAsyncCalls = new ArrayDeque();
        this.runningAsyncCalls = new ArrayDeque();
        this.runningSyncCalls = new ArrayDeque();
        this.executorService = executorService;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void promoteCalls() {
        if (this.runningAsyncCalls.size() >= this.maxRequests) {
            return;
        }
        if (this.readyAsyncCalls.isEmpty()) return;
        Iterator iterator = this.readyAsyncCalls.iterator();
        do {
            if (!iterator.hasNext()) return;
            RealCall.AsyncCall asyncCall = (RealCall.AsyncCall)iterator.next();
            if (this.runningCallsForHost(asyncCall) >= this.maxRequestsPerHost) continue;
            iterator.remove();
            this.runningAsyncCalls.add((Object)asyncCall);
            this.executorService().execute((Runnable)asyncCall);
        } while (this.runningAsyncCalls.size() < this.maxRequests);
    }

    private int runningCallsForHost(RealCall.AsyncCall asyncCall) {
        int n2 = 0;
        Iterator iterator = this.runningAsyncCalls.iterator();
        while (iterator.hasNext()) {
            if (!((RealCall.AsyncCall)iterator.next()).host().equals((Object)asyncCall.host())) continue;
            ++n2;
        }
        return n2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void cancelAll() {
        Dispatcher dispatcher = this;
        synchronized (dispatcher) {
            Iterator iterator = this.readyAsyncCalls.iterator();
            while (iterator.hasNext()) {
                ((RealCall.AsyncCall)iterator.next()).cancel();
            }
            Iterator iterator2 = this.runningAsyncCalls.iterator();
            while (iterator2.hasNext()) {
                ((RealCall.AsyncCall)iterator2.next()).cancel();
            }
            Iterator iterator3 = this.runningSyncCalls.iterator();
            while (iterator3.hasNext()) {
                ((RealCall)iterator3.next()).cancel();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void enqueue(RealCall.AsyncCall asyncCall) {
        void var5_2 = this;
        synchronized (var5_2) {
            if (this.runningAsyncCalls.size() < this.maxRequests && super.runningCallsForHost(asyncCall) < this.maxRequestsPerHost) {
                this.runningAsyncCalls.add((Object)asyncCall);
                this.executorService().execute((Runnable)asyncCall);
            } else {
                this.readyAsyncCalls.add((Object)asyncCall);
            }
            return;
        }
    }

    void executed(RealCall realCall) {
        void var4_2 = this;
        synchronized (var4_2) {
            this.runningSyncCalls.add((Object)realCall);
            return;
        }
    }

    public ExecutorService executorService() {
        Dispatcher dispatcher = this;
        synchronized (dispatcher) {
            if (this.executorService == null) {
                this.executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, (BlockingQueue)new SynchronousQueue(), Util.threadFactory("OkHttp Dispatcher", false));
            }
            ExecutorService executorService = this.executorService;
            return executorService;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    void finished(Call call) {
        void var3_2 = this;
        synchronized (var3_2) {
            if (this.runningSyncCalls.remove((Object)call)) return;
            throw new AssertionError((Object)"Call wasn't in-flight!");
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void finished(RealCall.AsyncCall asyncCall) {
        void var3_2 = this;
        synchronized (var3_2) {
            if (!this.runningAsyncCalls.remove((Object)asyncCall)) {
                throw new AssertionError((Object)"AsyncCall wasn't running!");
            }
            super.promoteCalls();
            return;
        }
    }

    public int getMaxRequests() {
        Dispatcher dispatcher = this;
        synchronized (dispatcher) {
            int n2 = this.maxRequests;
            return n2;
        }
    }

    public int getMaxRequestsPerHost() {
        Dispatcher dispatcher = this;
        synchronized (dispatcher) {
            int n2 = this.maxRequestsPerHost;
            return n2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List<Call> queuedCalls() {
        Dispatcher dispatcher = this;
        synchronized (dispatcher) {
            ArrayList arrayList = new ArrayList();
            Iterator iterator = this.readyAsyncCalls.iterator();
            while (iterator.hasNext()) {
                arrayList.add((Object)((RealCall.AsyncCall)iterator.next()).get());
            }
            return Collections.unmodifiableList((List)arrayList);
        }
    }

    public int queuedCallsCount() {
        Dispatcher dispatcher = this;
        synchronized (dispatcher) {
            int n2 = this.readyAsyncCalls.size();
            return n2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List<Call> runningCalls() {
        Dispatcher dispatcher = this;
        synchronized (dispatcher) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.runningSyncCalls);
            Iterator iterator = this.runningAsyncCalls.iterator();
            while (iterator.hasNext()) {
                arrayList.add((Object)((RealCall.AsyncCall)iterator.next()).get());
            }
            return Collections.unmodifiableList((List)arrayList);
        }
    }

    public int runningCallsCount() {
        Dispatcher dispatcher = this;
        synchronized (dispatcher) {
            int n2 = this.runningAsyncCalls.size();
            int n3 = this.runningSyncCalls.size();
            int n4 = n2 + n3;
            return n4;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setMaxRequests(int n2) {
        void var3_2 = this;
        synchronized (var3_2) {
            if (n2 < 1) {
                throw new IllegalArgumentException("max < 1: " + n2);
            }
            this.maxRequests = n2;
            super.promoteCalls();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setMaxRequestsPerHost(int n2) {
        void var3_2 = this;
        synchronized (var3_2) {
            if (n2 < 1) {
                throw new IllegalArgumentException("max < 1: " + n2);
            }
            this.maxRequestsPerHost = n2;
            super.promoteCalls();
            return;
        }
    }
}

