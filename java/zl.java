/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.AbstractSet
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.Set
 */
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class zl<E>
extends AbstractSet<E> {
    private final dh<E, E> a = new dh();

    public boolean a(zl<? extends E> zl2) {
        int n2 = this.size();
        this.a.a(zl2.a);
        if (this.size() > n2) {
            return true;
        }
        return false;
    }

    public boolean add(E e2) {
        if (this.a.containsKey(e2)) {
            return false;
        }
        this.a.put(e2, e2);
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        if (collection instanceof zl) {
            return this.a((zl)collection);
        }
        return super.addAll(collection);
    }

    public void clear() {
        this.a.clear();
    }

    public boolean contains(Object object) {
        return this.a.containsKey(object);
    }

    public Iterator<E> iterator() {
        return this.a.keySet().iterator();
    }

    public boolean remove(Object object) {
        if (!this.a.containsKey(object)) {
            return false;
        }
        this.a.remove(object);
        return true;
    }

    public int size() {
        return this.a.size();
    }
}

