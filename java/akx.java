/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  io.fabric.sdk.android.services.common.IdManager
 *  io.fabric.sdk.android.services.concurrency.UnmetDependencyException
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.concurrent.Callable
 *  java.util.concurrent.CountDownLatch
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Future
 *  java.util.concurrent.atomic.AtomicBoolean
 */
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

public class akx {
    static volatile akx a;
    static final alf b;
    final alf c;
    final boolean d;
    private final Context e;
    private final Map<Class<? extends alc>, alc> f;
    private final ExecutorService g;
    private final Handler h;
    private final ala<akx> i;
    private final ala<?> j;
    private final IdManager k;
    private akv l;
    private WeakReference<Activity> m;
    private AtomicBoolean n;

    static {
        b = new akw();
    }

    akx(Context context, Map<Class<? extends alc>, alc> map, amj amj2, Handler handler, alf alf2, boolean bl2, ala ala2, IdManager idManager) {
        this.e = context;
        this.f = map;
        this.g = amj2;
        this.h = handler;
        this.c = alf2;
        this.d = bl2;
        this.i = ala2;
        this.n = new AtomicBoolean(false);
        this.j = this.a(map.size());
        this.k = idManager;
    }

    static akx a() {
        if (a == null) {
            throw new IllegalStateException("Must Initialize Fabric before using singleton()");
        }
        return a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static /* varargs */ akx a(Context context, alc ... arralc) {
        if (a != null) return a;
        reference var3_2 = akx.class;
        // MONITORENTER : akx.class
        if (a == null) {
            akx.c(new a(context).a(arralc).a());
        }
        // MONITOREXIT : var3_2
        return a;
    }

    public static <T extends alc> T a(Class<T> class_) {
        return (T)((alc)akx.a().f.get(class_));
    }

    private static void a(Map<Class<? extends alc>, alc> map, Collection<? extends alc> collection) {
        for (alc alc2 : collection) {
            map.put((Object)alc2.getClass(), (Object)alc2);
            if (!(alc2 instanceof ald)) continue;
            akx.a(map, ((ald)((Object)alc2)).c());
        }
    }

    private static Map<Class<? extends alc>, alc> b(Collection<? extends alc> collection) {
        HashMap hashMap = new HashMap(collection.size());
        akx.a(hashMap, collection);
        return hashMap;
    }

    private Activity c(Context context) {
        if (context instanceof Activity) {
            return (Activity)context;
        }
        return null;
    }

    private static void c(akx akx2) {
        a = akx2;
        akx2.j();
    }

    public static alf h() {
        if (a == null) {
            return b;
        }
        return akx.a.c;
    }

    public static boolean i() {
        if (a == null) {
            return false;
        }
        return akx.a.d;
    }

    private void j() {
        this.a(this.c(this.e));
        this.l = new akv(this.e);
        this.l.a(new akv.b(){

            @Override
            public void a(Activity activity) {
                akx.this.a(activity);
            }

            @Override
            public void a(Activity activity, Bundle bundle) {
                akx.this.a(activity);
            }

            @Override
            public void b(Activity activity) {
                akx.this.a(activity);
            }
        });
        this.a(this.e);
    }

    public akx a(Activity activity) {
        this.m = new WeakReference((Object)activity);
        return this;
    }

    ala<?> a(final int n2) {
        return new ala(){
            final CountDownLatch a;

            @Override
            public void a(Exception exception) {
                akx.this.i.a(exception);
            }

            public void a(Object object) {
                this.a.countDown();
                if (this.a.getCount() == 0) {
                    akx.this.n.set(true);
                    akx.this.i.a(akx.this);
                }
            }
        };
    }

    /*
     * Enabled aggressive block sorting
     */
    void a(Context context) {
        Future<Map<String, ale>> future = this.b(context);
        Collection<alc> collection = this.g();
        alg alg2 = new alg(future, collection);
        ArrayList arrayList = new ArrayList(collection);
        Collections.sort((List)arrayList);
        alg2.a(context, (akx)this, ala.d, this.k);
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            ((alc)iterator.next()).a(context, (akx)this, this.j, this.k);
        }
        alg2.C();
        StringBuilder stringBuilder = akx.h().a("Fabric", 3) ? new StringBuilder("Initializing ").append(this.d()).append(" [Version: ").append(this.c()).append("], with the following kits:\n") : null;
        for (alc alc2 : arrayList) {
            alc2.f.a(alg2.f);
            this.a(this.f, alc2);
            alc2.C();
            if (stringBuilder == null) continue;
            stringBuilder.append(alc2.b()).append(" [Version: ").append(alc2.a()).append("]\n");
        }
        if (stringBuilder != null) {
            akx.h().a("Fabric", stringBuilder.toString());
        }
    }

    void a(Map<Class<? extends alc>, alc> map, alc alc2) {
        amd amd2 = alc2.j;
        if (amd2 != null) {
            for (Class class_ : amd2.a()) {
                if (class_.isInterface()) {
                    for (alc alc3 : map.values()) {
                        if (!class_.isAssignableFrom(alc3.getClass())) continue;
                        alc2.f.a(alc3.f);
                    }
                    continue;
                }
                if ((alc)map.get(class_) == null) {
                    throw new UnmetDependencyException("Referenced Kit was null, does the kit exist?");
                }
                alc2.f.a(((alc)map.get(class_)).f);
            }
        }
    }

    public Activity b() {
        if (this.m != null) {
            return (Activity)this.m.get();
        }
        return null;
    }

    Future<Map<String, ale>> b(Context context) {
        akz akz2 = new akz(context.getPackageCodePath());
        return this.f().submit((Callable)akz2);
    }

    public String c() {
        return "1.3.12.127";
    }

    public String d() {
        return "io.fabric.sdk.android:fabric";
    }

    public akv e() {
        return this.l;
    }

    public ExecutorService f() {
        return this.g;
    }

    public Collection<alc> g() {
        return this.f.values();
    }

    public static class a {
        private final Context a;
        private alc[] b;
        private amj c;
        private Handler d;
        private alf e;
        private boolean f;
        private String g;
        private String h;
        private ala<akx> i;

        public a(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.a = context.getApplicationContext();
        }

        public /* varargs */ a a(alc ... arralc) {
            if (this.b != null) {
                throw new IllegalStateException("Kits already set.");
            }
            this.b = arralc;
            return this;
        }

        /*
         * Enabled aggressive block sorting
         */
        public akx a() {
            if (this.c == null) {
                this.c = amj.a();
            }
            if (this.d == null) {
                this.d = new Handler(Looper.getMainLooper());
            }
            if (this.e == null) {
                this.e = this.f ? new akw(3) : new akw();
            }
            if (this.h == null) {
                this.h = this.a.getPackageName();
            }
            if (this.i == null) {
                this.i = ala.d;
            }
            HashMap hashMap = this.b == null ? new HashMap() : akx.b((Collection)Arrays.asList((Object[])this.b));
            IdManager idManager = new IdManager(this.a, this.h, this.g, hashMap.values());
            return new akx(this.a, (Map<Class<? extends alc>, alc>)hashMap, this.c, this.d, this.e, this.f, this.i, idManager);
        }
    }

}

