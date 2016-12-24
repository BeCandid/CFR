/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 */
class sb {
    long a;
    private amp b;

    public sb(amp amp2) {
        if (amp2 == null) {
            throw new NullPointerException("retryState must not be null");
        }
        this.b = amp2;
    }

    public void a() {
        this.a = 0;
        this.b = this.b.c();
    }

    public boolean a(long l2) {
        long l3 = 1000000 * this.b.a();
        if (l2 - this.a >= l3) {
            return true;
        }
        return false;
    }

    public void b(long l2) {
        this.a = l2;
        this.b = this.b.b();
    }
}

