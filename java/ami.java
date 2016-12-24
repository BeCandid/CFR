/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  io.fabric.sdk.android.services.concurrency.Priority
 *  java.lang.ClassCastException
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 *  java.util.concurrent.atomic.AtomicBoolean
 *  java.util.concurrent.atomic.AtomicReference
 */
import io.fabric.sdk.android.services.concurrency.Priority;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class ami
implements amc<amk>,
amh,
amk {
    private final List<amk> a = new ArrayList();
    private final AtomicBoolean b = new AtomicBoolean(false);
    private final AtomicReference<Throwable> c = new AtomicReference((Object)null);

    public static boolean a(Object object) {
        try {
            amc amc2 = (amc)object;
            amk amk2 = (amk)object;
            amh amh2 = (amh)object;
            boolean bl2 = false;
            if (amc2 != null) {
                bl2 = false;
                if (amk2 != null) {
                    bl2 = false;
                    if (amh2 != null) {
                        bl2 = true;
                    }
                }
            }
            return bl2;
        }
        catch (ClassCastException var1_5) {
            return false;
        }
    }

    public void a(amk amk2) {
        void var4_2 = this;
        synchronized (var4_2) {
            this.a.add((Object)amk2);
            return;
        }
    }

    @Override
    public void a(Throwable throwable) {
        this.c.set((Object)throwable);
    }

    @Override
    public Priority b() {
        return Priority.b;
    }

    @Override
    public void b(boolean bl2) {
        void var3_2 = this;
        synchronized (var3_2) {
            this.b.set(bl2);
            return;
        }
    }

    @Override
    public Collection<amk> c() {
        ami ami2 = this;
        synchronized (ami2) {
            Collection collection = Collections.unmodifiableCollection(this.a);
            return collection;
        }
    }

    @Override
    public /* synthetic */ void c(Object object) {
        this.a((amk)object);
    }

    public int compareTo(Object object) {
        return Priority.a((amh)this, (Object)object);
    }

    @Override
    public boolean d() {
        Iterator iterator = this.c().iterator();
        while (iterator.hasNext()) {
            if (((amk)iterator.next()).f()) continue;
            return false;
        }
        return true;
    }

    @Override
    public boolean f() {
        return this.b.get();
    }
}

