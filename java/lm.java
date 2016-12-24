/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Queue
 */
import java.util.Queue;

abstract class lm<T extends ls> {
    private final Queue<T> a = ri.a(20);

    lm() {
    }

    public void a(T t2) {
        if (this.a.size() < 20) {
            this.a.offer(t2);
        }
    }

    protected abstract T b();

    protected T c() {
        ls ls2 = (ls)this.a.poll();
        if (ls2 == null) {
            ls2 = this.b();
        }
        return (T)ls2;
    }
}

