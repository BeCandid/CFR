/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Set
 *  java.util.WeakHashMap
 */
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class pi
implements po {
    private final Set<pp> a = Collections.newSetFromMap((Map)new WeakHashMap());
    private boolean b;
    private boolean c;

    public void a() {
        this.b = true;
        Iterator iterator = ri.a(this.a).iterator();
        while (iterator.hasNext()) {
            ((pp)iterator.next()).onStart();
        }
    }

    @Override
    public void a(pp pp2) {
        this.a.add((Object)pp2);
        if (this.c) {
            pp2.onDestroy();
            return;
        }
        if (this.b) {
            pp2.onStart();
            return;
        }
        pp2.onStop();
    }

    public void b() {
        this.b = false;
        Iterator iterator = ri.a(this.a).iterator();
        while (iterator.hasNext()) {
            ((pp)iterator.next()).onStop();
        }
    }

    public void c() {
        this.c = true;
        Iterator iterator = ri.a(this.a).iterator();
        while (iterator.hasNext()) {
            ((pp)iterator.next()).onDestroy();
        }
    }
}

