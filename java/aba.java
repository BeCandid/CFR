/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
public final class aba<O extends xf.a> {
    private final xf<O> a;
    private final O b;

    public xf.d<?> a() {
        return this.a.c();
    }

    public String b() {
        return this.a.e();
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof aba)) {
            return false;
        }
        aba aba2 = (aba)object;
        if (!zc.a(this.a, aba2.a)) return false;
        if (zc.a(this.b, aba2.b)) return true;
        return false;
    }

    public int hashCode() {
        Object[] arrobject = new Object[]{this.a, this.b};
        return zc.a(arrobject);
    }
}

