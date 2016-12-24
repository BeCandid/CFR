/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Class
 *  java.lang.NoSuchMethodError
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Set
 */
import android.content.Context;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class mi {
    private static final mr c = new mr(){

        public ku a(Object object, int n2, int n3) {
            throw new NoSuchMethodError("This should never be called!");
        }

        public String toString() {
            return "NULL_MODEL_LOADER";
        }
    };
    private final Map<Class, Map<Class, ms>> a = new HashMap();
    private final Map<Class, Map<Class, mr>> b = new HashMap();
    private final Context d;

    public mi(Context context) {
        this.d = context.getApplicationContext();
    }

    private <T, Y> void a(Class<T> class_, Class<Y> class_2, mr<T, Y> mr2) {
        Map map = (Map)this.b.get(class_);
        if (map == null) {
            map = new HashMap();
            this.b.put(class_, (Object)map);
        }
        map.put(class_2, mr2);
    }

    private <T, Y> void b(Class<T> class_, Class<Y> class_2) {
        super.a(class_, class_2, c);
    }

    private <T, Y> mr<T, Y> c(Class<T> class_, Class<Y> class_2) {
        Map map = (Map)this.b.get(class_);
        mr mr2 = null;
        if (map != null) {
            mr2 = (mr)map.get(class_2);
        }
        return mr2;
    }

    private <T, Y> ms<T, Y> d(Class<T> class_, Class<Y> class_2) {
        Map map = (Map)this.a.get(class_);
        ms ms2 = null;
        if (map != null) {
            ms2 = (ms)map.get(class_2);
        }
        if (ms2 == null) {
            Map map2;
            Class class_3;
            Iterator iterator = this.a.keySet().iterator();
            while (iterator.hasNext() && (!(class_3 = (Class)iterator.next()).isAssignableFrom(class_) || (map2 = (Map)this.a.get((Object)class_3)) == null || (ms2 = (ms)map2.get(class_2)) == null)) {
            }
        }
        return ms2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public <T, Y> mr<T, Y> a(Class<T> class_, Class<Y> class_2) {
        void var8_3 = this;
        synchronized (var8_3) {
            mr<T, Y> mr2 = super.c(class_, class_2);
            if (mr2 != null) {
                boolean bl2 = c.equals(mr2);
                if (!bl2) return mr2;
                return null;
            }
            ms<T, Y> ms2 = super.d(class_, class_2);
            if (ms2 != null) {
                mr2 = ms2.a(this.d, (mi)this);
                super.a(class_, class_2, mr2);
                return mr2;
            } else {
                super.b(class_, class_2);
            }
            return mr2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public <T, Y> ms<T, Y> a(Class<T> class_, Class<Y> class_2, ms<T, Y> ms2) {
        void var10_4 = this;
        synchronized (var10_4) {
            ms ms3;
            boolean bl2;
            this.b.clear();
            Map map = (Map)this.a.get(class_);
            if (map == null) {
                map = new HashMap();
                this.a.put(class_, (Object)map);
            }
            if ((ms3 = (ms)map.put(class_2, ms2)) == null) return ms3;
            Iterator iterator = this.a.values().iterator();
            do {
                if (!iterator.hasNext()) return ms3;
            } while (!(bl2 = ((Map)iterator.next()).containsValue((Object)ms3)));
            return null;
        }
    }

}

