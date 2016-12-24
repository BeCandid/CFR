/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.Thread
 *  java.lang.Throwable
 */
public class asp
implements apy {
    private final apy a;
    private final apo.a b;
    private final long c;

    public asp(apy apy2, apo.a a2, long l2) {
        this.a = apy2;
        this.b = a2;
        this.c = l2;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public void call() {
        long l2;
        if (this.b.isUnsubscribed()) {
            return;
        }
        if (this.c > this.b.a() && (l2 = this.c - this.b.a()) > 0) {
            Thread.sleep((long)l2);
        }
        if (this.b.isUnsubscribed()) return;
        this.a.call();
        return;
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            throw new RuntimeException((Throwable)interruptedException);
        }
    }
}

