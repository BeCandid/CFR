/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.util.HashMap
 *  java.util.Map
 */
import java.util.HashMap;
import java.util.Map;

public class pz {
    private static final rh a = new rh();
    private final Map<rh, py<?, ?>> b = new HashMap();

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public <T, Z> py<T, Z> a(Class<T> class_, Class<Z> class_2) {
        rh rh2;
        py py2;
        rh rh3 = rh2 = a;
        synchronized (rh3) {
            a.a(class_, class_2);
            py2 = (py)this.b.get((Object)a);
        }
        if (py2 != null) return py2;
        return qa.e();
    }

    public <T, Z> void a(Class<T> class_, Class<Z> class_2, py<T, Z> py2) {
        this.b.put((Object)new rh(class_, class_2), py2);
    }
}

