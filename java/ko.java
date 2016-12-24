/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.SafeVarargs
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 */
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ko<T>
implements kr<T> {
    private final Collection<? extends kr<T>> a;
    private String b;

    @SafeVarargs
    public /* varargs */ ko(kr<T> ... arrkr) {
        if (arrkr.length < 1) {
            throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.a = Arrays.asList((Object[])arrkr);
    }

    @Override
    public String a() {
        if (this.b == null) {
            StringBuilder stringBuilder = new StringBuilder();
            Iterator iterator = this.a.iterator();
            while (iterator.hasNext()) {
                stringBuilder.append(((kr)iterator.next()).a());
            }
            this.b = stringBuilder.toString();
        }
        return this.b;
    }

    @Override
    public lj<T> a(lj<T> lj2, int n2, int n3) {
        lj<T> lj3 = lj2;
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            lj<T> lj4 = ((kr)iterator.next()).a(lj3, n2, n3);
            if (lj3 != null && !lj3.equals(lj2) && !lj3.equals(lj4)) {
                lj3.d();
            }
            lj3 = lj4;
        }
        return lj3;
    }
}

