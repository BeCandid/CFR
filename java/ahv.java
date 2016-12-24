/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.app.Application
 *  android.content.Context
 *  android.util.Log
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.IllegalAccessException
 *  java.lang.IllegalStateException
 *  java.lang.Iterable
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 *  java.util.concurrent.CopyOnWriteArrayList
 *  java.util.concurrent.atomic.AtomicBoolean
 */
import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class ahv {
    static final Map<String, ahv> a;
    private static final List<String> b;
    private static final List<String> c;
    private static final List<String> d;
    private static final Set<String> e;
    private static final Object f;
    private final Context g;
    private final String h;
    private final ahw i;
    private final AtomicBoolean j = new AtomicBoolean(true);
    private final AtomicBoolean k = new AtomicBoolean();
    private final List<Object> l = new CopyOnWriteArrayList();
    private final List<a> m = new CopyOnWriteArrayList();
    private final List<Object> n = new CopyOnWriteArrayList();

    static {
        b = Arrays.asList((Object[])new String[]{"com.google.firebase.auth.FirebaseAuth", "com.google.firebase.iid.FirebaseInstanceId"});
        c = Collections.singletonList((Object)"com.google.firebase.crash.FirebaseCrash");
        d = Arrays.asList((Object[])new String[]{"com.google.android.gms.measurement.AppMeasurement"});
        e = Collections.emptySet();
        f = new Object();
        a = new dh<String, ahv>();
    }

    protected ahv(Context context, String string2, ahw ahw2) {
        this.g = xz.a(context);
        this.h = xz.a(string2);
        this.i = xz.a(ahw2);
    }

    public static ahv a(Context context) {
        ahw ahw2 = ahw.a(context);
        if (ahw2 == null) {
            return null;
        }
        return ahv.a(context, ahw2);
    }

    public static ahv a(Context context, ahw ahw2) {
        return ahv.a(context, ahw2, "[DEFAULT]");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static ahv a(Context context, ahw ahw2, String string2) {
        Object object;
        ahv ahv2;
        aar aar2 = aar.a(context);
        ahv.b(context);
        String string3 = ahv.b(string2);
        Context context2 = context.getApplicationContext();
        Object object2 = object = f;
        synchronized (object2) {
            boolean bl2 = !a.containsKey((Object)string3);
            xz.a(bl2, (Object)new StringBuilder(33 + String.valueOf((Object)string3).length()).append("FirebaseApp name ").append(string3).append(" already exists!").toString());
            xz.a(context2, (Object)"Application context cannot be null.");
            ahv2 = new ahv(context2, string3, ahw2);
            a.put((Object)string3, (Object)ahv2);
        }
        aar2.a(ahv2);
        ahv.a(ahv.class, ahv2, b);
        if (ahv2.e()) {
            ahv.a(ahv.class, ahv2, c);
            ahv.a(Context.class, ahv2.a(), d);
        }
        return ahv2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static ahv a(String string2) {
        Object object;
        Object object2 = object = f;
        synchronized (object2) {
            String string3;
            ahv ahv2 = (ahv)a.get((Object)ahv.b(string2));
            if (ahv2 != null) {
                return ahv2;
            }
            List<String> list = ahv.g();
            String string4 = list.isEmpty() ? "" : ((string3 = String.valueOf((Object)za.a(", ").a(list))).length() != 0 ? "Available app names: ".concat(string3) : new String("Available app names: "));
            throw new IllegalStateException(String.format((String)"FirebaseApp with name %s doesn't exist. %s", (Object[])new Object[]{string2, string4}));
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static <T> void a(Class<T> class_, T t2, Iterable<String> iterable) {
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            String string2 = (String)iterator.next();
            try {
                Class class_2 = Class.forName((String)string2);
                Method method = class_2.getMethod("getInstance", new Class[]{class_});
                if ((9 & method.getModifiers()) == 9) {
                    method.invoke((Object)null, new Object[]{t2});
                }
                String string3 = String.valueOf((Object)class_2);
                Log.d((String)"FirebaseApp", (String)new StringBuilder(13 + String.valueOf((Object)string3).length()).append("Initialized ").append(string3).append(".").toString());
                continue;
            }
            catch (ClassNotFoundException var12_7) {
                if (e.contains((Object)string2)) {
                    throw new IllegalStateException(String.valueOf((Object)string2).concat(" is missing, but is required. Check if it has been removed by Proguard."));
                }
                Log.d((String)"FirebaseApp", (String)String.valueOf((Object)string2).concat(" is not linked. Skipping initialization."));
                continue;
            }
            catch (NoSuchMethodException var11_13) {
                throw new IllegalStateException(String.valueOf((Object)string2).concat("#getInstance has been removed by Proguard. Add keep rule to prevent it."));
            }
            catch (InvocationTargetException var9_4) {
                Log.wtf((String)"FirebaseApp", (String)"Firebase API initialization failure.", (Throwable)var9_4);
                continue;
            }
            catch (IllegalAccessException var5_5) {
                String string4 = String.valueOf((Object)string2);
                String string5 = string4.length() != 0 ? "Failed to initialize ".concat(string4) : new String("Failed to initialize ");
                Log.wtf((String)"FirebaseApp", (String)string5, (Throwable)var5_5);
                continue;
            }
            break;
        }
        return;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(boolean bl2) {
        Object object;
        Object object2 = object = f;
        synchronized (object2) {
            Iterator iterator = new ArrayList(a.values()).iterator();
            while (iterator.hasNext()) {
                ahv ahv2 = (ahv)iterator.next();
                if (!ahv2.j.get()) continue;
                ahv2.b(bl2);
            }
            return;
        }
    }

    private static String b(String string2) {
        return string2.trim();
    }

    @TargetApi(value=14)
    private static void b(Context context) {
        if (zt.c() && context.getApplicationContext() instanceof Application) {
            aaq.a((Application)context.getApplicationContext());
        }
    }

    private void b(boolean bl2) {
        Log.d((String)"FirebaseApp", (String)"Notifying background state change listeners.");
        Iterator iterator = this.m.iterator();
        while (iterator.hasNext()) {
            ((a)iterator.next()).a(bl2);
        }
    }

    public static ahv d() {
        return ahv.a("[DEFAULT]");
    }

    /*
     * Enabled aggressive block sorting
     */
    private void f() {
        boolean bl2 = !this.k.get();
        xz.a(bl2, (Object)"FirebaseApp was deleted");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static List<String> g() {
        Object object;
        zl zl2 = new zl();
        Object object2 = object = f;
        synchronized (object2) {
            Iterator iterator = a.values().iterator();
            while (iterator.hasNext()) {
                zl2.add((Object)((ahv)iterator.next()).b());
            }
            aar aar2 = aar.a();
            if (aar2 != null) {
                zl2.addAll(aar2.b());
            }
        }
        ArrayList arrayList = new ArrayList(zl2);
        Collections.sort((List)arrayList);
        return arrayList;
    }

    public Context a() {
        this.f();
        return this.g;
    }

    public String b() {
        this.f();
        return this.h;
    }

    public ahw c() {
        this.f();
        return this.i;
    }

    public boolean e() {
        return "[DEFAULT]".equals((Object)this.b());
    }

    public boolean equals(Object object) {
        if (!(object instanceof ahv)) {
            return false;
        }
        return this.h.equals((Object)((ahv)object).b());
    }

    public int hashCode() {
        return this.h.hashCode();
    }

    public String toString() {
        return zc.a((Object)this).a("name", this.h).a("options", this.i).toString();
    }

    public static interface a {
        public void a(boolean var1);
    }

}

