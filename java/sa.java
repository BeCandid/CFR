/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Random
 */
import java.util.Random;

class sa
implements aml {
    final aml a;
    final Random b;
    final double c;

    public sa(aml aml2, double d2) {
        super(aml2, d2, new Random());
    }

    public sa(aml aml2, double d2, Random random) {
        if (d2 < 0.0 || d2 > 1.0) {
            throw new IllegalArgumentException("jitterPercent must be between 0.0 and 1.0");
        }
        if (aml2 == null) {
            throw new NullPointerException("backoff must not be null");
        }
        if (random == null) {
            throw new NullPointerException("random must not be null");
        }
        this.a = aml2;
        this.c = d2;
        this.b = random;
    }

    double a() {
        double d2 = 1.0 - this.c;
        double d3 = 1.0 + this.c;
        return d2 + this.b.nextDouble() * (d3 - d2);
    }

    @Override
    public long a(int n2) {
        return (long)(this.a() * (double)this.a.a(n2));
    }
}

