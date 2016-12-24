/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayDeque
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Queue
 *  java.util.concurrent.locks.Lock
 *  java.util.concurrent.locks.ReentrantLock
 */
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class lw {
    private final Map<kn, a> a = new HashMap();
    private final b b = new b(null);

    lw() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void a(kn kn2) {
        void var5_2 = this;
        synchronized (var5_2) {
            a a2 = (a)this.a.get((Object)kn2);
            if (a2 == null) {
                a2 = this.b.a();
                this.a.put((Object)kn2, (Object)a2);
            }
            a2.b = 1 + a2.b;
        }
        a2.a.lock();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void b(kn kn2) {
        void var8_2 = this;
        synchronized (var8_2) {
            int n2;
            a a2 = (a)this.a.get((Object)kn2);
            if (a2 == null || a2.b <= 0) {
                int n3;
                StringBuilder stringBuilder = new StringBuilder().append("Cannot release a lock that is not held, key: ").append((Object)kn2).append(", interestedThreads: ");
                if (a2 == null) {
                    n3 = 0;
                    throw new IllegalArgumentException(stringBuilder.append(n3).toString());
                }
                n3 = a2.b;
                throw new IllegalArgumentException(stringBuilder.append(n3).toString());
            }
            a2.b = n2 = -1 + a2.b;
            if (n2 == 0) {
                a a3 = (a)this.a.remove((Object)kn2);
                if (!a3.equals((Object)a2)) {
                    throw new IllegalStateException("Removed the wrong lock, expected to remove: " + a2 + ", but actually removed: " + a3 + ", key: " + kn2);
                }
                this.b.a(a3);
            }
        }
        a2.a.unlock();
    }

    static class a {
        final Lock a;
        int b;

        private a() {
            this.a = new ReentrantLock();
        }

        /* synthetic */ a( var1) {
        }
    }

    static class b {
        private final Queue<a> a;

        private b() {
            this.a = new ArrayDeque();
        }

        /* synthetic */ b( var1) {
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        a a() {
            a a2;
            Queue<a> queue;
            Queue<a> queue2 = queue = this.a;
            synchronized (queue2) {
                a2 = (a)this.a.poll();
            }
            if (a2 != null) return a2;
            return new a(null);
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        void a(a a2) {
            Queue<a> queue;
            Queue<a> queue2 = queue = this.a;
            synchronized (queue2) {
                if (this.a.size() < 10) {
                    this.a.offer((Object)a2);
                }
                return;
            }
        }
    }

}

