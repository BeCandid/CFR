/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.Writer
 *  java.lang.AssertionError
 *  java.lang.Boolean
 *  java.lang.Double
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class ajl
extends ajw {
    private static final Writer a = new Writer(){

        public void close() throws IOException {
            throw new AssertionError();
        }

        public void flush() throws IOException {
            throw new AssertionError();
        }

        public void write(char[] arrc, int n2, int n3) {
            throw new AssertionError();
        }
    };
    private static final aip b = new aip("closed");
    private final List<ail> c = new ArrayList();
    private String d;
    private ail e = aim.a;

    public ajl() {
        super(a);
    }

    private void a(ail ail2) {
        if (this.d != null) {
            if (!ail2.l() || this.i()) {
                ((ain)super.j()).a(this.d, ail2);
            }
            this.d = null;
            return;
        }
        if (this.c.isEmpty()) {
            this.e = ail2;
            return;
        }
        ail ail3 = super.j();
        if (ail3 instanceof aij) {
            ((aij)ail3).a(ail2);
            return;
        }
        throw new IllegalStateException();
    }

    private ail j() {
        return (ail)this.c.get(-1 + this.c.size());
    }

    public ail a() {
        if (!this.c.isEmpty()) {
            throw new IllegalStateException("Expected one JSON element but was " + this.c);
        }
        return this.e;
    }

    @Override
    public ajw a(long l2) throws IOException {
        super.a(new aip(l2));
        return this;
    }

    @Override
    public ajw a(Number number) throws IOException {
        double d2;
        if (number == null) {
            return this.f();
        }
        if (!this.g() && (Double.isNaN((double)(d2 = number.doubleValue())) || Double.isInfinite((double)d2))) {
            throw new IllegalArgumentException("JSON forbids NaN and infinities: " + (Object)number);
        }
        super.a(new aip(number));
        return this;
    }

    @Override
    public ajw a(String string2) throws IOException {
        if (this.c.isEmpty() || this.d != null) {
            throw new IllegalStateException();
        }
        if (super.j() instanceof ain) {
            this.d = string2;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override
    public ajw a(boolean bl2) throws IOException {
        super.a(new aip(bl2));
        return this;
    }

    @Override
    public ajw b() throws IOException {
        aij aij2 = new aij();
        this.a(aij2);
        this.c.add((Object)aij2);
        return this;
    }

    @Override
    public ajw b(String string2) throws IOException {
        if (string2 == null) {
            return this.f();
        }
        super.a(new aip(string2));
        return this;
    }

    @Override
    public ajw c() throws IOException {
        if (this.c.isEmpty() || this.d != null) {
            throw new IllegalStateException();
        }
        if (this.j() instanceof aij) {
            this.c.remove(-1 + this.c.size());
            return this;
        }
        throw new IllegalStateException();
    }

    @Override
    public void close() throws IOException {
        if (!this.c.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.c.add((Object)b);
    }

    @Override
    public ajw d() throws IOException {
        ain ain2 = new ain();
        this.a(ain2);
        this.c.add((Object)ain2);
        return this;
    }

    @Override
    public ajw e() throws IOException {
        if (this.c.isEmpty() || this.d != null) {
            throw new IllegalStateException();
        }
        if (this.j() instanceof ain) {
            this.c.remove(-1 + this.c.size());
            return this;
        }
        throw new IllegalStateException();
    }

    @Override
    public ajw f() throws IOException {
        this.a(aim.a);
        return this;
    }

    @Override
    public void flush() throws IOException {
    }

}

