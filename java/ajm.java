/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonSyntaxException
 *  com.google.gson.internal.
 *  com.google.gson.internal.$Gson
 *  com.google.gson.internal.$Gson$Types
 *  com.google.gson.stream.JsonToken
 *  java.io.IOException
 *  java.lang.AssertionError
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Type
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class ajm
implements ais {
    final boolean a;
    private final aiz b;

    public ajm(aiz aiz2, boolean bl2) {
        this.b = aiz2;
        this.a = bl2;
    }

    private air<?> a(aih aih2, Type type) {
        if (type == Boolean.TYPE || type == Boolean.class) {
            return ajs.f;
        }
        return aih2.a(aju.get(type));
    }

    @Override
    public <T> air<T> a(aih aih2, aju<T> aju2) {
        Type type = aju2.getType();
        if (!Map.class.isAssignableFrom(aju2.getRawType())) {
            return null;
        }
        Type[] arrtype = .Gson.Types.b((Type)type, (Class).Gson.Types.e((Type)type));
        air air2 = super.a(aih2, arrtype[0]);
        air air3 = aih2.a(aju.get(arrtype[1]));
        ajc<T> ajc2 = this.b.a(aju2);
        return (ajm)this.new a(aih2, arrtype[0], air2, arrtype[1], air3, ajc2);
    }

    final class a<K, V>
    extends air<Map<K, V>> {
        private final air<K> b;
        private final air<V> c;
        private final ajc<? extends Map<K, V>> d;

        public a(aih aih2, Type type, air<K> air2, Type type2, air<V> air3, ajc<? extends Map<K, V>> ajc2) {
            this.b = new ajr<K>(aih2, air2, type);
            this.c = new ajr<V>(aih2, air3, type2);
            this.d = ajc2;
        }

        private String a(ail ail2) {
            if (ail2.k()) {
                aip aip2 = ail2.o();
                if (aip2.q()) {
                    return String.valueOf((Object)aip2.b());
                }
                if (aip2.a()) {
                    return Boolean.toString((boolean)aip2.h());
                }
                if (aip2.r()) {
                    return aip2.c();
                }
                throw new AssertionError();
            }
            if (ail2.l()) {
                return "null";
            }
            throw new AssertionError();
        }

        public Map<K, V> a(ajv ajv2) throws IOException {
            JsonToken jsonToken = ajv2.f();
            if (jsonToken == JsonToken.i) {
                ajv2.j();
                return null;
            }
            Map<K, V> map = this.d.a();
            if (jsonToken == JsonToken.a) {
                ajv2.a();
                while (ajv2.e()) {
                    ajv2.a();
                    K k2 = this.b.b(ajv2);
                    if (map.put(k2, this.c.b(ajv2)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + k2);
                    }
                    ajv2.b();
                }
                ajv2.b();
                return map;
            }
            ajv2.c();
            while (ajv2.e()) {
                ajb.a.a(ajv2);
                K k3 = this.b.b(ajv2);
                if (map.put(k3, this.c.b(ajv2)) == null) continue;
                throw new JsonSyntaxException("duplicate key: " + k3);
            }
            ajv2.d();
            return map;
        }

        /*
         * Enabled aggressive block sorting
         */
        @Override
        public void a(ajw ajw2, Map<K, V> map) throws IOException {
            if (map == null) {
                ajw2.f();
                return;
            }
            if (!ajm.this.a) {
                ajw2.d();
                Iterator iterator = map.entrySet().iterator();
                do {
                    if (!iterator.hasNext()) {
                        ajw2.e();
                        return;
                    }
                    Map.Entry entry = (Map.Entry)iterator.next();
                    ajw2.a(String.valueOf((Object)entry.getKey()));
                    this.c.a(ajw2, (Object)entry.getValue());
                } while (true);
            }
            boolean bl2 = false;
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            for (Map.Entry entry : map.entrySet()) {
                ail ail2 = this.b.a((Object)entry.getKey());
                arrayList.add((Object)ail2);
                arrayList2.add(entry.getValue());
                boolean bl3 = ail2.i() || ail2.j();
                bl2 |= bl3;
            }
            if (bl2) {
                ajw2.b();
                int n2 = 0;
                do {
                    if (n2 >= arrayList.size()) {
                        ajw2.c();
                        return;
                    }
                    ajw2.b();
                    aje.a((ail)arrayList.get(n2), ajw2);
                    this.c.a(ajw2, (Object)arrayList2.get(n2));
                    ajw2.c();
                    ++n2;
                } while (true);
            }
            ajw2.d();
            int n3 = 0;
            do {
                if (n3 >= arrayList.size()) {
                    ajw2.e();
                    return;
                }
                ajw2.a(super.a((ail)arrayList.get(n3)));
                this.c.a(ajw2, (Object)arrayList2.get(n3));
                ++n3;
            } while (true);
        }

        @Override
        public /* synthetic */ Object b(ajv ajv2) throws IOException {
            return this.a(ajv2);
        }
    }

}

