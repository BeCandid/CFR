/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Math
 *  java.lang.Object
 */
public class amn
implements aml {
    private final long a;
    private final int b;

    public amn(long l2, int n2) {
        this.a = l2;
        this.b = n2;
    }

    @Override
    public long a(int n2) {
        return (long)((double)this.a * Math.pow((double)this.b, (double)n2));
    }
}

