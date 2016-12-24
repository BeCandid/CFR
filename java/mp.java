/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class mp
implements mk {
    private final Map<String, List<mo>> c;
    private volatile Map<String, String> d;

    mp(Map<String, List<mo>> map) {
        this.c = Collections.unmodifiableMap(map);
    }

    private Map<String, String> b() {
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : this.c.entrySet()) {
            StringBuilder stringBuilder = new StringBuilder();
            List list = (List)entry.getValue();
            for (int i2 = 0; i2 < list.size(); ++i2) {
                stringBuilder.append(((mo)list.get(i2)).a());
                if (i2 == -1 + list.size()) continue;
                stringBuilder.append(',');
            }
            hashMap.put(entry.getKey(), (Object)stringBuilder.toString());
        }
        return hashMap;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public Map<String, String> a() {
        if (this.d == null) {
            mp mp2 = this;
            synchronized (mp2) {
                if (this.d == null) {
                    this.d = Collections.unmodifiableMap(this.b());
                }
            }
        }
        return this.d;
    }

    public boolean equals(Object object) {
        if (object instanceof mp) {
            mp mp2 = (mp)object;
            return this.c.equals(mp2.c);
        }
        return false;
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.c + '}';
    }

    public static final class a {
        private static final String a = System.getProperty((String)"http.agent");
        private static final Map<String, List<mo>> b;
        private boolean c = true;
        private Map<String, List<mo>> d = b;
        private boolean e = true;
        private boolean f = true;

        static {
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty((CharSequence)a)) {
                hashMap.put((Object)"User-Agent", (Object)Collections.singletonList((Object)new b(a)));
            }
            hashMap.put((Object)"Accept-Encoding", (Object)Collections.singletonList((Object)new b("identity")));
            b = Collections.unmodifiableMap((Map)hashMap);
        }

        public mp a() {
            this.c = true;
            return new mp(this.d);
        }
    }

    static final class b
    implements mo {
        private final String a;

        b(String string2) {
            this.a = string2;
        }

        @Override
        public String a() {
            return this.a;
        }

        public boolean equals(Object object) {
            if (object instanceof b) {
                b b2 = (b)object;
                return this.a.equals((Object)b2.a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.a + '\'' + '}';
        }
    }

}

