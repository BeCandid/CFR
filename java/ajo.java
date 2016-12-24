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
 *  java.lang.Class
 *  java.lang.IllegalAccessException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.Field
 *  java.lang.reflect.Type
 *  java.util.Collection
 *  java.util.LinkedHashMap
 *  java.util.LinkedList
 *  java.util.List
 *  java.util.Map
 */
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class ajo
implements ais {
    private final aiz a;
    private final aig b;
    private final aja c;

    public ajo(aiz aiz2, aig aig2, aja aja2) {
        this.a = aiz2;
        this.b = aig2;
        this.c = aja2;
    }

    private b a(final aih aih2, final Field field, String string2, final aju<?> aju2, boolean bl2, boolean bl3) {
        return new b(string2, bl2, bl3, ajd.a(aju2.getRawType())){
            final air<?> a;
            final /* synthetic */ boolean e;

            @Override
            void a(ajv ajv2, Object object) throws IOException, IllegalAccessException {
                Object obj = this.a.b(ajv2);
                if (obj != null || !this.e) {
                    field.set(object, obj);
                }
            }

            @Override
            void a(ajw ajw2, Object object) throws IOException, IllegalAccessException {
                Object object2 = field.get(object);
                new ajr(aih2, this.a, aju2.getType()).a(ajw2, (Object)object2);
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public boolean a(Object object) throws IOException, IllegalAccessException {
                if (!this.h || field.get(object) == object) {
                    return false;
                }
                return true;
            }
        };
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static List<String> a(aig aig2, Field field) {
        aiv aiv2 = (aiv)field.getAnnotation((Class)aiv.class);
        LinkedList linkedList = new LinkedList();
        if (aiv2 == null) {
            linkedList.add((Object)aig2.a(field));
            return linkedList;
        }
        linkedList.add((Object)aiv2.a());
        String[] arrstring = aiv2.b();
        int n2 = arrstring.length;
        int n3 = 0;
        while (n3 < n2) {
            linkedList.add((Object)arrstring[n3]);
            ++n3;
        }
        return linkedList;
    }

    private List<String> a(Field field) {
        return ajo.a(this.b, field);
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private Map<String, b> a(aih aih2, aju<?> aju2, Class<?> class_) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (class_.isInterface()) {
            return linkedHashMap;
        }
        Type type = aju2.getType();
        while (class_ != Object.class) {
            for (Field field : class_.getDeclaredFields()) {
                boolean bl2 = this.a(field, true);
                boolean bl3 = this.a(field, false);
                if (!bl2 && !bl3) continue;
                field.setAccessible(true);
                Type type2 = aju2.getType();
                Type type3 = field.getGenericType();
                Type type4 = .Gson.Types.a((Type)type2, class_, (Type)type3);
                List<String> list = super.a(field);
                b b2 = null;
                for (int i2 = 0; i2 < list.size(); ++i2) {
                    String string2 = (String)list.get(i2);
                    if (i2 != 0) {
                        bl2 = false;
                    }
                    b b3 = (b)linkedHashMap.put((Object)string2, (Object)super.a(aih2, field, string2, aju.get(type4), bl2, bl3));
                    if (b2 != null) continue;
                    b2 = b3;
                }
            }
            Type type5 = aju2.getType();
            Type type6 = class_.getGenericSuperclass();
            aju2 = aju.get(.Gson.Types.a((Type)type5, class_, (Type)type6));
            class_ = aju2.getRawType();
        }
        return linkedHashMap;
    }

    static boolean a(Field field, boolean bl2, aja aja2) {
        if (!aja2.a(field.getType(), bl2) && !aja2.a(field, bl2)) {
            return true;
        }
        return false;
    }

    @Override
    public <T> air<T> a(aih aih2, aju<T> aju2) {
        Class<T> class_ = aju2.getRawType();
        if (!Object.class.isAssignableFrom(class_)) {
            return null;
        }
        return new a<T>(this.a.a(aju2), super.a(aih2, aju2, class_));
    }

    air<?> a(aih aih2, Field field, aju<?> aju2) {
        air air2;
        aiu aiu2 = (aiu)field.getAnnotation((Class)aiu.class);
        if (aiu2 != null && (air2 = ajj.a(this.a, aih2, aju2, aiu2)) != null) {
            return air2;
        }
        return aih2.a(aju2);
    }

    public boolean a(Field field, boolean bl2) {
        return ajo.a(field, bl2, this.c);
    }

    public static final class a<T>
    extends air<T> {
        private final ajc<T> a;
        private final Map<String, b> b;

        a(ajc<T> ajc2, Map<String, b> map) {
            this.a = ajc2;
            this.b = map;
        }

        @Override
        public void a(ajw ajw2, T t2) throws IOException {
            if (t2 == null) {
                ajw2.f();
                return;
            }
            ajw2.d();
            try {
                for (b b2 : this.b.values()) {
                    if (!b2.a(t2)) continue;
                    ajw2.a(b2.g);
                    b2.a(ajw2, t2);
                }
            }
            catch (IllegalAccessException var4_5) {
                throw new AssertionError((Object)var4_5);
            }
            ajw2.e();
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public T b(ajv ajv2) throws IOException {
            if (ajv2.f() == JsonToken.i) {
                ajv2.j();
                return null;
            }
            T t2 = this.a.a();
            try {
                ajv2.c();
                while (ajv2.e()) {
                    String string2 = ajv2.g();
                    b b2 = (b)this.b.get((Object)string2);
                    if (b2 == null || !b2.i) {
                        ajv2.n();
                        continue;
                    }
                    b2.a(ajv2, t2);
                }
            }
            catch (IllegalStateException var4_5) {
                throw new JsonSyntaxException((Throwable)var4_5);
            }
            catch (IllegalAccessException var3_6) {
                throw new AssertionError((Object)var3_6);
            }
            ajv2.d();
            return t2;
        }
    }

    static abstract class b {
        final String g;
        final boolean h;
        final boolean i;

        protected b(String string2, boolean bl2, boolean bl3) {
            this.g = string2;
            this.h = bl2;
            this.i = bl3;
        }

        abstract void a(ajv var1, Object var2) throws IOException, IllegalAccessException;

        abstract void a(ajw var1, Object var2) throws IOException, IllegalAccessException;

        abstract boolean a(Object var1) throws IOException, IllegalAccessException;
    }

}

