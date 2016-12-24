/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.Set
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public final class asv
implements aps {
    private Set<aps> a;
    private volatile boolean b;

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
            void var4_2 = this;
            synchronized (var4_2) {
                if (!this.b) {
                    if (this.a == null) {
                        this.a = new HashSet(4);
                    }
                    this.a.add((Object)aps2);
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
        void var4_2 = this;
        // MONITORENTER : var4_2
        if (!this.b && this.a != null) {
            boolean bl2 = this.a.remove((Object)aps2);
            // MONITOREXIT : var4_2
            if (!bl2) return;
            aps2.unsubscribe();
            return;
        }
        // MONITOREXIT : var4_2
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
        Set<aps> set;
        if (this.b) {
            return;
        }
        asv asv2 = this;
        synchronized (asv2) {
            if (this.b) {
                return;
            }
            this.b = true;
            set = this.a;
            this.a = null;
        }
        asv.a(set);
    }
}

