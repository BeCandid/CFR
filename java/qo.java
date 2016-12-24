/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
public class qo<R>
implements ql<R> {
    private final qn.a a;
    private qk<R> b;

    qo(qn.a a2) {
        this.a = a2;
    }

    @Override
    public qk<R> a(boolean bl2, boolean bl3) {
        if (bl2 || !bl3) {
            return qm.b();
        }
        if (this.b == null) {
            this.b = new qn(this.a);
        }
        return this.b;
    }
}

