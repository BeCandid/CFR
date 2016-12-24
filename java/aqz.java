/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.LinkedList
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

public final class aqz
implements aps {
    private LinkedList<aps> a;
    private volatile boolean b;

    public aqz() {
    }

    public aqz(aps aps2) {
        this.a = new LinkedList();
        this.a.add((Object)aps2);
    }

    public /* varargs */ aqz(aps ... arraps) {
        this.a = new LinkedList((Collection)Arrays.asList((Object[])arraps));
    }

    private static void a(Collection<aps> collection) {
        if (collection == null) {
            return;
        }
        ArrayList arrayList = null;
        for (aps aps2 : collection) {
            try {
                aps2.unsubscribe();
            }
            catch (Throwable var4_3) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add((Object)var4_3);
            }
        }
        apx.a(arrayList);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(aps aps2) {
        if (aps2.isUnsubscribed()) {
            return;
        }
        if (!this.b) {
            void var5_2 = this;
            synchronized (var5_2) {
                if (!this.b) {
                    LinkedList linkedList = this.a;
                    if (linkedList == null) {
                        this.a = linkedList = new LinkedList();
                    }
                    linkedList.add((Object)aps2);
                    return;
                }
            }
        }
        aps2.unsubscribe();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void b(aps aps2) {
        if (this.b) return;
        void var5_2 = this;
        // MONITORENTER : var5_2
        LinkedList<aps> linkedList = this.a;
        if (!this.b && linkedList != null) {
            boolean bl2 = linkedList.remove((Object)aps2);
            // MONITOREXIT : var5_2
            if (!bl2) return;
            aps2.unsubscribe();
            return;
        }
        // MONITOREXIT : var5_2
    }

    @Override
    public boolean isUnsubscribed() {
        return this.b;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void unsubscribe() {
        LinkedList<aps> linkedList;
        if (this.b) {
            return;
        }
        aqz aqz2 = this;
        synchronized (aqz2) {
            if (this.b) {
                return;
            }
            this.b = true;
            linkedList = this.a;
            this.a = null;
        }
        aqz.a(linkedList);
    }
}

