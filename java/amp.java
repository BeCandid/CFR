/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
public class amp {
    private final int a;
    private final aml b;
    private final amo c;

    public amp(int n2, aml aml2, amo amo2) {
        this.a = n2;
        this.b = aml2;
        this.c = amo2;
    }

    public amp(aml aml2, amo amo2) {
        super(0, aml2, amo2);
    }

    public long a() {
        return this.b.a(this.a);
    }

    public amp b() {
        return new amp(1 + this.a, this.b, this.c);
    }

    public amp c() {
        return new amp(this.b, this.c);
    }
}

