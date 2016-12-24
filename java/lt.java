/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  java.lang.Integer
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.NavigableMap
 *  java.util.Set
 *  java.util.TreeMap
 */
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

@TargetApi(value=19)
public class lt
implements lr {
    private static final Bitmap.Config[] a;
    private static final Bitmap.Config[] b;
    private static final Bitmap.Config[] c;
    private static final Bitmap.Config[] d;
    private final b e = new b();
    private final lp<a, Bitmap> f = new lp();
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> g = new HashMap();

    static {
        Bitmap.Config[] arrconfig = new Bitmap.Config[]{Bitmap.Config.ARGB_8888, null};
        a = arrconfig;
        Bitmap.Config[] arrconfig2 = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        b = arrconfig2;
        Bitmap.Config[] arrconfig3 = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        c = arrconfig3;
        Bitmap.Config[] arrconfig4 = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
        d = arrconfig4;
    }

    private NavigableMap<Integer, Integer> a(Bitmap.Config config) {
        NavigableMap navigableMap = (NavigableMap)this.g.get((Object)config);
        if (navigableMap == null) {
            navigableMap = new TreeMap();
            this.g.put((Object)config, (Object)navigableMap);
        }
        return navigableMap;
    }

    /*
     * Enabled aggressive block sorting
     */
    private a a(a a2, int n2, Bitmap.Config config) {
        a a3 = a2;
        Bitmap.Config[] arrconfig = lt.b(config);
        int n3 = arrconfig.length;
        int n4 = 0;
        while (n4 < n3) {
            Bitmap.Config config2 = arrconfig[n4];
            Integer n5 = (Integer)super.a(config2).ceilingKey((Object)n2);
            if (n5 != null && n5 <= n2 * 8) {
                if (n5 == n2) {
                    if (config2 == null) {
                        if (config == null) return a3;
                    } else if (config2.equals((Object)config)) return a3;
                }
                this.e.a(a2);
                return this.e.a(n5, config2);
            }
            ++n4;
        }
        return a3;
    }

    private void a(Integer n2, Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = super.a(config);
        Integer n3 = (Integer)navigableMap.get((Object)n2);
        if (n3 == 1) {
            navigableMap.remove((Object)n2);
            return;
        }
        navigableMap.put((Object)n2, (Object)(-1 + n3));
    }

    private static String b(int n2, Bitmap.Config config) {
        return "[" + n2 + "](" + (Object)config + ")";
    }

    private static Bitmap.Config[] b(Bitmap.Config config) {
        switch (.a[config.ordinal()]) {
            default: {
                return new Bitmap.Config[]{config};
            }
            case 1: {
                return a;
            }
            case 2: {
                return b;
            }
            case 3: {
                return c;
            }
            case 4: 
        }
        return d;
    }

    @Override
    public Bitmap a() {
        Bitmap bitmap = this.f.a();
        if (bitmap != null) {
            this.a(ri.a(bitmap), bitmap.getConfig());
        }
        return bitmap;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public Bitmap a(int n2, int n3, Bitmap.Config config) {
        int n4 = ri.a(n2, n3, config);
        a a2 = super.a(this.e.a(n4, config), n4, config);
        Bitmap bitmap = this.f.a(a2);
        if (bitmap != null) {
            super.a(ri.a(bitmap), bitmap.getConfig());
            Bitmap.Config config2 = bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
            bitmap.reconfigure(n2, n3, config2);
        }
        return bitmap;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void a(Bitmap bitmap) {
        int n2 = ri.a(bitmap);
        a a2 = this.e.a(n2, bitmap.getConfig());
        this.f.a(a2, bitmap);
        NavigableMap<Integer, Integer> navigableMap = super.a(bitmap.getConfig());
        Integer n3 = (Integer)navigableMap.get((Object)a2.b);
        Integer n4 = a2.b;
        int n5 = n3 == null ? 1 : 1 + n3;
        navigableMap.put((Object)n4, (Object)n5);
    }

    @Override
    public String b(int n2, int n3, Bitmap.Config config) {
        return lt.b(ri.a(n2, n3, config), config);
    }

    @Override
    public String b(Bitmap bitmap) {
        return lt.b(ri.a(bitmap), bitmap.getConfig());
    }

    @Override
    public int c(Bitmap bitmap) {
        return ri.a(bitmap);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder().append("SizeConfigStrategy{groupedMap=").append(this.f).append(", sortedSizes=(");
        for (Map.Entry entry : this.g.entrySet()) {
            stringBuilder.append(entry.getKey()).append('[').append(entry.getValue()).append("], ");
        }
        if (!this.g.isEmpty()) {
            stringBuilder.replace(-2 + stringBuilder.length(), stringBuilder.length(), "");
        }
        return stringBuilder.append(")}").toString();
    }

    static final class a
    implements ls {
        private final b a;
        private int b;
        private Bitmap.Config c;

        public a(b b2) {
            this.a = b2;
        }

        @Override
        public void a() {
            this.a.a(this);
        }

        public void a(int n2, Bitmap.Config config) {
            this.b = n2;
            this.c = config;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public boolean equals(Object object) {
            boolean bl2 = object instanceof a;
            boolean bl3 = false;
            if (!bl2) return bl3;
            a a2 = (a)object;
            int n2 = this.b;
            int n3 = a2.b;
            bl3 = false;
            if (n2 != n3) return bl3;
            if (this.c == null) {
                Bitmap.Config config = a2.c;
                bl3 = false;
                if (config != null) return bl3;
                do {
                    return true;
                    break;
                } while (true);
            }
            boolean bl4 = this.c.equals((Object)a2.c);
            bl3 = false;
            if (!bl4) return bl3;
            return true;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public int hashCode() {
            int n2;
            int n3 = 31 * this.b;
            if (this.c != null) {
                n2 = this.c.hashCode();
                do {
                    return n3 + n2;
                    break;
                } while (true);
            }
            n2 = 0;
            return n3 + n2;
        }

        public String toString() {
            return lt.b(this.b, this.c);
        }
    }

    static class b
    extends lm<a> {
        b() {
        }

        protected a a() {
            return new a(this);
        }

        public a a(int n2, Bitmap.Config config) {
            a a2 = (a)this.c();
            a2.a(n2, config);
            return a2;
        }

        @Override
        protected /* synthetic */ ls b() {
            return this.a();
        }
    }

}

