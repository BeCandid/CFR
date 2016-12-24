/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IBinder$DeathRecipient
 *  android.os.RemoteException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.ref.WeakReference
 *  java.util.Collections
 *  java.util.Map
 *  java.util.Set
 *  java.util.WeakHashMap
 */
import android.os.IBinder;
import android.os.RemoteException;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class abq {
    private static final abc.a<?, ?>[] b = new abc.a[0];
    final Set<abc.a<?, ?>> a = Collections.synchronizedSet((Set)Collections.newSetFromMap((Map)new WeakHashMap()));
    private final b c;
    private final Map<xf.d<?>, xf.f> d;

    public abq(xf.d<?> d2, xf.f f2) {
        this.c = new b(){

            @Override
            public void a(abc.a<?, ?> a2) {
                abq.this.a.remove(a2);
                if (a2.a() != null && abq.a(abq.this) != null) {
                    abq.a(abq.this).a(a2.a());
                }
            }
        };
        this.d = new dh();
        this.d.put(d2, (Object)f2);
    }

    static /* synthetic */ xs a(abq abq2) {
        return null;
    }

    private static void a(abc.a<?, ?> a2, xs xs2, IBinder iBinder) {
        if (a2.e()) {
            a2.a(new a(a2, xs2, iBinder, null));
            return;
        }
        if (iBinder != null && iBinder.isBinderAlive()) {
            a a3 = new a(a2, xs2, iBinder, null);
            a2.a(a3);
            try {
                iBinder.linkToDeath((IBinder.DeathRecipient)a3, 0);
                return;
            }
            catch (RemoteException var4_4) {
                a2.f();
                xs2.a(a2.a());
                return;
            }
        }
        a2.a((b)null);
        a2.f();
        xs2.a(a2.a());
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a() {
        abc.a[] arra = (abc.a[])this.a.toArray(b);
        int n2 = arra.length;
        int n3 = 0;
        while (n3 < n2) {
            abc.a a2 = arra[n3];
            a2.a((b)null);
            if (a2.a() == null) {
                if (a2.g()) {
                    this.a.remove((Object)a2);
                }
            } else {
                a2.c();
                abq.a(a2, null, ((xf.f)this.d.get(a2.b())).e());
                this.a.remove((Object)a2);
            }
            ++n3;
        }
    }

    <A extends xf.c> void a(abc.a<? extends xk, A> a2) {
        this.a.add(a2);
        a2.a(this.c);
    }

    public boolean b() {
        abc.a[] arra = (abc.a[])this.a.toArray(b);
        int n2 = arra.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (arra[i2].e()) continue;
            return true;
        }
        return false;
    }

    static class a
    implements b,
    IBinder.DeathRecipient {
        private final WeakReference<abc.a<?, ?>> a;
        private final WeakReference<xs> b;
        private final WeakReference<IBinder> c;

        private a(abc.a<?, ?> a2, xs xs2, IBinder iBinder) {
            this.b = new WeakReference((Object)xs2);
            this.a = new WeakReference(a2);
            this.c = new WeakReference((Object)iBinder);
        }

        /* synthetic */ a(abc.a a2, xs xs2, IBinder iBinder,  var4) {
            super(a2, xs2, iBinder);
        }

        private void a() {
            abc.a a2 = (abc.a)this.a.get();
            xs xs2 = (xs)this.b.get();
            if (xs2 != null && a2 != null) {
                xs2.a(a2.a());
            }
            IBinder iBinder = (IBinder)this.c.get();
            if (this.c != null) {
                iBinder.unlinkToDeath((IBinder.DeathRecipient)this, 0);
            }
        }

        @Override
        public void a(abc.a<?, ?> a2) {
            super.a();
        }

        public void binderDied() {
            this.a();
        }
    }

    static interface b {
        public void a(abc.a<?, ?> var1);
    }

}

