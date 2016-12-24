/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 */
import java.util.HashMap;
import java.util.Map;

public class pg {
    private static final rh a = new rh();
    private final Map<rh, pf<?, ?>> b = new HashMap();

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public <Z, R> pf<Z, R> a(Class<Z> class_, Class<R> class_2) {
        rh rh2;
        pf pf2;
        if (class_.equals(class_2)) {
            return ph.b();
        }
        rh rh3 = rh2 = a;
        synchronized (rh3) {
            a.a(class_, class_2);
            pf2 = (pf)this.b.get((Object)a);
        }
        if (pf2 != null) return pf2;
        throw new IllegalArgumentException("No transcoder registered for " + class_ + " and " + class_2);
    }

    public <Z, R> void a(Class<Z> class_, Class<R> class_2, pf<Z, R> pf2) {
        this.b.put((Object)new rh(class_, class_2), pf2);
    }
}

