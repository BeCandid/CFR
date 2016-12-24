/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalStateException
 *  java.lang.Iterable
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class aij
extends ail
implements Iterable<ail> {
    private final List<ail> a = new ArrayList();

    public int a() {
        return this.a.size();
    }

    public ail a(int n2) {
        return (ail)this.a.get(n2);
    }

    public void a(ail ail2) {
        if (ail2 == null) {
            ail2 = aim.a;
        }
        this.a.add((Object)ail2);
    }

    @Override
    public Number b() {
        if (this.a.size() == 1) {
            return ((ail)this.a.get(0)).b();
        }
        throw new IllegalStateException();
    }

    @Override
    public String c() {
        if (this.a.size() == 1) {
            return ((ail)this.a.get(0)).c();
        }
        throw new IllegalStateException();
    }

    @Override
    public double d() {
        if (this.a.size() == 1) {
            return ((ail)this.a.get(0)).d();
        }
        throw new IllegalStateException();
    }

    @Override
    public float e() {
        if (this.a.size() == 1) {
            return ((ail)this.a.get(0)).e();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object == this || object instanceof aij && ((aij)object).a.equals(this.a)) {
            return true;
        }
        return false;
    }

    @Override
    public long f() {
        if (this.a.size() == 1) {
            return ((ail)this.a.get(0)).f();
        }
        throw new IllegalStateException();
    }

    @Override
    public int g() {
        if (this.a.size() == 1) {
            return ((ail)this.a.get(0)).g();
        }
        throw new IllegalStateException();
    }

    @Override
    public boolean h() {
        if (this.a.size() == 1) {
            return ((ail)this.a.get(0)).h();
        }
        throw new IllegalStateException();
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public Iterator<ail> iterator() {
        return this.a.iterator();
    }
}

