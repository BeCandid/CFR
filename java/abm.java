/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Iterator
 *  java.util.Set
 */
import java.util.Iterator;
import java.util.Set;

public class abm {
    private final Set<abl<?>> a;

    public void a() {
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            ((abl)iterator.next()).a();
        }
        this.a.clear();
    }
}

