/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.LinkedList
 *  java.util.Queue
 */
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ara<T>
implements Queue<T> {
    private final LinkedList<T> a;
    private final int b;

    public ara() {
        this.a = new LinkedList();
        this.b = -1;
    }

    public ara(int n2) {
        this.a = new LinkedList();
        this.b = n2;
    }

    public boolean add(T t2) {
        void var4_2 = this;
        synchronized (var4_2) {
            boolean bl2 = this.a.add(t2);
            return bl2;
        }
    }

    public boolean addAll(Collection<? extends T> collection) {
        void var4_2 = this;
        synchronized (var4_2) {
            boolean bl2 = this.a.addAll(collection);
            return bl2;
        }
    }

    public void clear() {
        ara ara2 = this;
        synchronized (ara2) {
            this.a.clear();
            return;
        }
    }

    public Object clone() {
        ara ara2 = this;
        synchronized (ara2) {
            ara<T> ara3 = new ara<T>(this.b);
            ara3.addAll((Collection<T>)this.a);
            return ara3;
        }
    }

    public boolean contains(Object object) {
        void var4_2 = this;
        synchronized (var4_2) {
            boolean bl2 = this.a.contains(object);
            return bl2;
        }
    }

    public boolean containsAll(Collection<?> collection) {
        void var4_2 = this;
        synchronized (var4_2) {
            boolean bl2 = this.a.containsAll(collection);
            return bl2;
        }
    }

    public T element() {
        ara ara2 = this;
        synchronized (ara2) {
            Object object = this.a.element();
            return (T)object;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        ara ara2 = (ara)object;
        if (this.a == null) {
            if (ara2.a == null) return true;
            return false;
        }
        if (!this.a.equals(ara2.a)) return false;
        return true;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public boolean isEmpty() {
        ara ara2 = this;
        synchronized (ara2) {
            boolean bl2 = this.a.isEmpty();
            return bl2;
        }
    }

    public Iterator<T> iterator() {
        ara ara2 = this;
        synchronized (ara2) {
            Iterator iterator = this.a.iterator();
            return iterator;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean offer(T t2) {
        void var7_2 = this;
        synchronized (var7_2) {
            int n2;
            boolean bl2 = this.a.offer(t2);
            if (this.b <= -1) return bl2;
            int n3 = 1 + this.a.size();
            if (n3 <= (n2 = this.b)) return bl2;
            return false;
        }
    }

    public T peek() {
        ara ara2 = this;
        synchronized (ara2) {
            Object object = this.a.peek();
            return (T)object;
        }
    }

    public T poll() {
        ara ara2 = this;
        synchronized (ara2) {
            Object object = this.a.poll();
            return (T)object;
        }
    }

    public T remove() {
        ara ara2 = this;
        synchronized (ara2) {
            Object object = this.a.remove();
            return (T)object;
        }
    }

    public boolean remove(Object object) {
        void var4_2 = this;
        synchronized (var4_2) {
            boolean bl2 = this.a.remove(object);
            return bl2;
        }
    }

    public boolean removeAll(Collection<?> collection) {
        void var4_2 = this;
        synchronized (var4_2) {
            boolean bl2 = this.a.removeAll(collection);
            return bl2;
        }
    }

    public boolean retainAll(Collection<?> collection) {
        void var4_2 = this;
        synchronized (var4_2) {
            boolean bl2 = this.a.retainAll(collection);
            return bl2;
        }
    }

    public int size() {
        ara ara2 = this;
        synchronized (ara2) {
            int n2 = this.a.size();
            return n2;
        }
    }

    public Object[] toArray() {
        ara ara2 = this;
        synchronized (ara2) {
            Object[] arrobject = this.a.toArray();
            return arrobject;
        }
    }

    public <R> R[] toArray(R[] arrR) {
        void var4_2 = this;
        synchronized (var4_2) {
            Object[] arrobject = this.a.toArray((Object[])arrR);
            return arrobject;
        }
    }

    public String toString() {
        ara ara2 = this;
        synchronized (ara2) {
            String string2 = this.a.toString();
            return string2;
        }
    }
}

