/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 *  java.util.WeakHashMap
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class pt {
    private final Set<qd> a = Collections.newSetFromMap((Map)new WeakHashMap());
    private final List<qd> b = new ArrayList();
    private boolean c;

    public void a() {
        this.c = true;
        for (qd qd2 : ri.a(this.a)) {
            if (!qd2.f()) continue;
            qd2.e();
            this.b.add((Object)qd2);
        }
    }

    public void a(qd qd2) {
        this.a.add((Object)qd2);
        if (!this.c) {
            qd2.b();
            return;
        }
        this.b.add((Object)qd2);
    }

    public void b() {
        this.c = false;
        for (qd qd2 : ri.a(this.a)) {
            if (qd2.g() || qd2.i() || qd2.f()) continue;
            qd2.b();
        }
        this.b.clear();
    }

    public void b(qd qd2) {
        this.a.remove((Object)qd2);
        this.b.remove((Object)qd2);
    }

    public void c() {
        Iterator iterator = ri.a(this.a).iterator();
        while (iterator.hasNext()) {
            ((qd)iterator.next()).d();
        }
        this.b.clear();
    }

    public void d() {
        for (qd qd2 : ri.a(this.a)) {
            if (qd2.g() || qd2.i()) continue;
            qd2.e();
            if (!this.c) {
                qd2.b();
                continue;
            }
            this.b.add((Object)qd2);
        }
    }
}

