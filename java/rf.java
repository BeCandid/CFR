/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class rf<T, Y> {
    private final LinkedHashMap<T, Y> a = new LinkedHashMap(100, 0.75f, true);
    private int b;
    private final int c;
    private int d = 0;

    public rf(int n2) {
        this.c = n2;
        this.b = n2;
    }

    private void c() {
        this.b(this.b);
    }

    protected int a(Y y2) {
        return 1;
    }

    public void a() {
        this.b(0);
    }

    protected void a(T t2, Y y2) {
    }

    public int b() {
        return this.d;
    }

    public Y b(T t2) {
        return (Y)this.a.get(t2);
    }

    public Y b(T t2, Y y2) {
        if (this.a(y2) >= this.b) {
            this.a(t2, y2);
            return null;
        }
        Object object = this.a.put(t2, y2);
        if (y2 != null) {
            this.d += this.a(y2);
        }
        if (object != null) {
            this.d -= this.a(object);
        }
        super.c();
        return (Y)object;
    }

    protected void b(int n2) {
        while (this.d > n2) {
            Map.Entry entry = (Map.Entry)this.a.entrySet().iterator().next();
            Object object = entry.getValue();
            this.d -= this.a(object);
            Object object2 = entry.getKey();
            this.a.remove(object2);
            this.a(object2, object);
        }
    }

    public Y c(T t2) {
        Object object = this.a.remove(t2);
        if (object != null) {
            this.d -= this.a(object);
        }
        return (Y)object;
    }
}

