/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InterruptedIOException
 *  java.lang.AssertionError
 *  java.lang.IllegalStateException
 *  java.lang.InterruptedException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Throwable
 */
package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import okio.Buffer;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public class AsyncTimeout
extends Timeout {
    private static AsyncTimeout head;
    private boolean inQueue;
    private AsyncTimeout next;
    private long timeoutAt;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static AsyncTimeout awaitTimeout() throws InterruptedException {
        reference var6 = AsyncTimeout.class;
        synchronized (AsyncTimeout.class) {
            AsyncTimeout asyncTimeout = AsyncTimeout.head.next;
            if (asyncTimeout == null) {
                AsyncTimeout.class.wait();
                return null;
            }
            long l2 = asyncTimeout.remainingNanos(System.nanoTime());
            if (l2 > 0) {
                long l3 = l2 / 1000000;
                AsyncTimeout.class.wait(l3, (int)(l2 - l3 * 1000000));
                return null;
            }
            AsyncTimeout.head.next = asyncTimeout.next;
            asyncTimeout.next = null;
            // ** MonitorExit[var6] (shouldn't be in output)
            return asyncTimeout;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static boolean cancelScheduledTimeout(AsyncTimeout asyncTimeout) {
        reference var4_1 = AsyncTimeout.class;
        synchronized (AsyncTimeout.class) {
            AsyncTimeout asyncTimeout2 = head;
            while (asyncTimeout2 != null) {
                if (asyncTimeout2.next == asyncTimeout) {
                    asyncTimeout2.next = asyncTimeout.next;
                    asyncTimeout.next = null;
                    return false;
                }
                asyncTimeout2 = asyncTimeout2.next;
            }
            return true;
        }
    }

    private long remainingNanos(long l2) {
        return this.timeoutAt - l2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void scheduleTimeout(AsyncTimeout asyncTimeout, long l2, boolean bl2) {
        reference var12_3 = AsyncTimeout.class;
        synchronized (AsyncTimeout.class) {
            if (head == null) {
                head = new AsyncTimeout();
                new Watchdog().start();
            }
            long l3 = System.nanoTime();
            if (l2 != 0 && bl2) {
                asyncTimeout.timeoutAt = l3 + Math.min((long)l2, (long)(asyncTimeout.deadlineNanoTime() - l3));
            } else if (l2 != 0) {
                long l4;
                asyncTimeout.timeoutAt = l4 = l3 + l2;
            } else {
                if (!bl2) {
                    throw new AssertionError();
                }
                asyncTimeout.timeoutAt = asyncTimeout.deadlineNanoTime();
            }
            long l5 = asyncTimeout.remainingNanos(l3);
            AsyncTimeout asyncTimeout2 = head;
            do {
                if (asyncTimeout2.next == null || l5 < asyncTimeout2.next.remainingNanos(l3)) {
                    asyncTimeout.next = asyncTimeout2.next;
                    asyncTimeout2.next = asyncTimeout;
                    if (asyncTimeout2 == head) {
                        AsyncTimeout.class.notify();
                    }
                    // ** MonitorExit[var12_3] (shouldn't be in output)
                    return;
                }
                asyncTimeout2 = asyncTimeout2.next;
            } while (true);
        }
    }

    public final void enter() {
        if (this.inQueue) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long l2 = this.timeoutNanos();
        boolean bl2 = this.hasDeadline();
        if (l2 == 0 && !bl2) {
            return;
        }
        this.inQueue = true;
        AsyncTimeout.scheduleTimeout(this, l2, bl2);
    }

    final IOException exit(IOException iOException) throws IOException {
        if (!this.exit()) {
            return iOException;
        }
        return this.newTimeoutException(iOException);
    }

    final void exit(boolean bl2) throws IOException {
        if (this.exit() && bl2) {
            throw this.newTimeoutException(null);
        }
    }

    public final boolean exit() {
        if (!this.inQueue) {
            return false;
        }
        this.inQueue = false;
        return AsyncTimeout.cancelScheduledTimeout(this);
    }

    public IOException newTimeoutException(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause((Throwable)iOException);
        }
        return interruptedIOException;
    }

    public final Sink sink(final Sink sink) {
        return new Sink(){

            @Override
            public void close() throws IOException {
                AsyncTimeout.this.enter();
                try {
                    sink.close();
                }
                catch (IOException var2_1) {
                    try {
                        throw AsyncTimeout.this.exit(var2_1);
                    }
                    catch (Throwable var1_2) {
                        AsyncTimeout.this.exit(false);
                        throw var1_2;
                    }
                }
                AsyncTimeout.this.exit(true);
                return;
            }

            @Override
            public void flush() throws IOException {
                AsyncTimeout.this.enter();
                try {
                    sink.flush();
                }
                catch (IOException var2_1) {
                    try {
                        throw AsyncTimeout.this.exit(var2_1);
                    }
                    catch (Throwable var1_2) {
                        AsyncTimeout.this.exit(false);
                        throw var1_2;
                    }
                }
                AsyncTimeout.this.exit(true);
                return;
            }

            @Override
            public Timeout timeout() {
                return AsyncTimeout.this;
            }

            public String toString() {
                return "AsyncTimeout.sink(" + sink + ")";
            }

            @Override
            public void write(Buffer buffer, long l2) throws IOException {
                AsyncTimeout.this.enter();
                try {
                    sink.write(buffer, l2);
                }
                catch (IOException var5_3) {
                    try {
                        throw AsyncTimeout.this.exit(var5_3);
                    }
                    catch (Throwable var4_4) {
                        AsyncTimeout.this.exit(false);
                        throw var4_4;
                    }
                }
                AsyncTimeout.this.exit(true);
                return;
            }
        };
    }

    public final Source source(final Source source) {
        return new Source(){

            @Override
            public void close() throws IOException {
                try {
                    source.close();
                }
                catch (IOException var2_1) {
                    try {
                        throw AsyncTimeout.this.exit(var2_1);
                    }
                    catch (Throwable var1_2) {
                        AsyncTimeout.this.exit(false);
                        throw var1_2;
                    }
                }
                AsyncTimeout.this.exit(true);
                return;
            }

            @Override
            public long read(Buffer buffer, long l2) throws IOException {
                long l3;
                AsyncTimeout.this.enter();
                try {
                    l3 = source.read(buffer, l2);
                }
                catch (IOException var5_4) {
                    try {
                        throw AsyncTimeout.this.exit(var5_4);
                    }
                    catch (Throwable var4_5) {
                        AsyncTimeout.this.exit(false);
                        throw var4_5;
                    }
                }
                AsyncTimeout.this.exit(true);
                return l3;
            }

            @Override
            public Timeout timeout() {
                return AsyncTimeout.this;
            }

            public String toString() {
                return "AsyncTimeout.source(" + source + ")";
            }
        };
    }

    public void timedOut() {
    }

    static final class Watchdog
    extends Thread {
        public Watchdog() {
            super("Okio Watchdog");
            this.setDaemon(true);
        }

        public void run() {
            do {
                AsyncTimeout asyncTimeout = AsyncTimeout.awaitTimeout();
                if (asyncTimeout == null) continue;
                try {
                    asyncTimeout.timedOut();
                }
                catch (InterruptedException var1_1) {
                }
            } while (true);
        }
    }

}

