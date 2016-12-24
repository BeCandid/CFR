/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.google.gson.FieldNamingPolicy
 *  com.google.gson.JsonIOException
 *  com.google.gson.JsonSyntaxException
 *  com.google.gson.LongSerializationPolicy
 *  com.google.gson.stream.JsonToken
 *  com.google.gson.stream.MalformedJsonException
 *  java.io.EOFException
 *  java.io.IOException
 *  java.io.Reader
 *  java.io.StringReader
 *  java.io.StringWriter
 *  java.io.Writer
 *  java.lang.Appendable
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Long
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.ThreadLocal
 *  java.lang.Throwable
 *  java.lang.reflect.Type
 *  java.math.BigDecimal
 *  java.math.BigInteger
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.concurrent.atomic.AtomicLong
 *  java.util.concurrent.atomic.AtomicLongArray
 */
import com.google.gson.FieldNamingPolicy;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.LongSerializationPolicy;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

public final class aih {
    final aik a;
    final aiq b;
    private final ThreadLocal<Map<aju<?>, a<?>>> c = new ThreadLocal();
    private final Map<aju<?>, air<?>> d = Collections.synchronizedMap((Map)new HashMap());
    private final List<ais> e;
    private final aiz f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final boolean k;

    public aih() {
        this(aja.a, (aig)FieldNamingPolicy.a, Collections.emptyMap(), false, false, false, true, false, false, false, LongSerializationPolicy.a, Collections.emptyList());
    }

    aih(aja aja2, aig aig2, Map<Type, aii<?>> map, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, LongSerializationPolicy longSerializationPolicy, List<ais> list) {
        this.a = new aik(){};
        this.b = new aiq(){};
        this.f = new aiz(map);
        this.g = bl2;
        this.i = bl4;
        this.h = bl5;
        this.j = bl6;
        this.k = bl7;
        ArrayList arrayList = new ArrayList();
        arrayList.add((Object)ajs.Y);
        arrayList.add((Object)ajn.a);
        arrayList.add((Object)aja2);
        arrayList.addAll(list);
        arrayList.add((Object)ajs.D);
        arrayList.add((Object)ajs.m);
        arrayList.add((Object)ajs.g);
        arrayList.add((Object)ajs.i);
        arrayList.add((Object)ajs.k);
        air<Number> air2 = aih.a(longSerializationPolicy);
        arrayList.add((Object)ajs.a(Long.TYPE, Long.class, air2));
        arrayList.add((Object)ajs.a(Double.TYPE, Double.class, super.a(bl8)));
        arrayList.add((Object)ajs.a(Float.TYPE, Float.class, super.b(bl8)));
        arrayList.add((Object)ajs.x);
        arrayList.add((Object)ajs.o);
        arrayList.add((Object)ajs.q);
        arrayList.add((Object)ajs.a(AtomicLong.class, aih.a(air2)));
        arrayList.add((Object)ajs.a(AtomicLongArray.class, aih.b(air2)));
        arrayList.add((Object)ajs.s);
        arrayList.add((Object)ajs.z);
        arrayList.add((Object)ajs.F);
        arrayList.add((Object)ajs.H);
        arrayList.add((Object)ajs.a(BigDecimal.class, ajs.B));
        arrayList.add((Object)ajs.a(BigInteger.class, ajs.C));
        arrayList.add((Object)ajs.J);
        arrayList.add((Object)ajs.L);
        arrayList.add((Object)ajs.P);
        arrayList.add((Object)ajs.R);
        arrayList.add((Object)ajs.W);
        arrayList.add((Object)ajs.N);
        arrayList.add((Object)ajs.d);
        arrayList.add((Object)aji.a);
        arrayList.add((Object)ajs.U);
        arrayList.add((Object)ajq.a);
        arrayList.add((Object)ajp.a);
        arrayList.add((Object)ajs.S);
        arrayList.add((Object)ajg.a);
        arrayList.add((Object)ajs.b);
        arrayList.add((Object)new ajh(this.f));
        arrayList.add((Object)new ajm(this.f, bl3));
        arrayList.add((Object)new ajj(this.f));
        arrayList.add((Object)ajs.Z);
        arrayList.add((Object)new ajo(this.f, aig2, aja2));
        this.e = Collections.unmodifiableList((List)arrayList);
    }

    private static air<AtomicLong> a(final air<Number> air2) {
        return new air<AtomicLong>(){

            public AtomicLong a(ajv ajv2) throws IOException {
                return new AtomicLong(((Number)air2.b(ajv2)).longValue());
            }

            @Override
            public void a(ajw ajw2, AtomicLong atomicLong) throws IOException {
                air2.a(ajw2, atomicLong.get());
            }

            @Override
            public /* synthetic */ Object b(ajv ajv2) throws IOException {
                return this.a(ajv2);
            }
        }.a();
    }

    private static air<Number> a(LongSerializationPolicy longSerializationPolicy) {
        if (longSerializationPolicy == LongSerializationPolicy.a) {
            return ajs.t;
        }
        return new air<Number>(){

            public Number a(ajv ajv2) throws IOException {
                if (ajv2.f() == JsonToken.i) {
                    ajv2.j();
                    return null;
                }
                return ajv2.l();
            }

            @Override
            public void a(ajw ajw2, Number number) throws IOException {
                if (number == null) {
                    ajw2.f();
                    return;
                }
                ajw2.b(number.toString());
            }

            @Override
            public /* synthetic */ Object b(ajv ajv2) throws IOException {
                return this.a(ajv2);
            }
        };
    }

    private air<Number> a(boolean bl2) {
        if (bl2) {
            return ajs.v;
        }
        return new air<Number>(){

            public Double a(ajv ajv2) throws IOException {
                if (ajv2.f() == JsonToken.i) {
                    ajv2.j();
                    return null;
                }
                return ajv2.k();
            }

            @Override
            public void a(ajw ajw2, Number number) throws IOException {
                if (number == null) {
                    ajw2.f();
                    return;
                }
                aih.a(number.doubleValue());
                ajw2.a(number);
            }

            @Override
            public /* synthetic */ Object b(ajv ajv2) throws IOException {
                return this.a(ajv2);
            }
        };
    }

    static void a(double d2) {
        if (Double.isNaN((double)d2) || Double.isInfinite((double)d2)) {
            throw new IllegalArgumentException("" + d2 + " is not a valid double value as per JSON specification. To override this" + " behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private static void a(Object object, ajv ajv2) {
        if (object != null) {
            try {
                if (ajv2.f() != JsonToken.j) {
                    throw new JsonIOException("JSON document was not fully consumed.");
                }
            }
            catch (MalformedJsonException var3_2) {
                throw new JsonSyntaxException((Throwable)var3_2);
            }
            catch (IOException var2_3) {
                throw new JsonIOException((Throwable)var2_3);
            }
        }
    }

    private static air<AtomicLongArray> b(final air<Number> air2) {
        return new air<AtomicLongArray>(){

            public AtomicLongArray a(ajv ajv2) throws IOException {
                ArrayList arrayList = new ArrayList();
                ajv2.a();
                while (ajv2.e()) {
                    arrayList.add((Object)((Number)air2.b(ajv2)).longValue());
                }
                ajv2.b();
                int n2 = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(n2);
                for (int i2 = 0; i2 < n2; ++i2) {
                    atomicLongArray.set(i2, ((Long)arrayList.get(i2)).longValue());
                }
                return atomicLongArray;
            }

            @Override
            public void a(ajw ajw2, AtomicLongArray atomicLongArray) throws IOException {
                ajw2.b();
                int n2 = atomicLongArray.length();
                for (int i2 = 0; i2 < n2; ++i2) {
                    air2.a(ajw2, atomicLongArray.get(i2));
                }
                ajw2.c();
            }

            @Override
            public /* synthetic */ Object b(ajv ajv2) throws IOException {
                return this.a(ajv2);
            }
        }.a();
    }

    private air<Number> b(boolean bl2) {
        if (bl2) {
            return ajs.u;
        }
        return new air<Number>(){

            public Float a(ajv ajv2) throws IOException {
                if (ajv2.f() == JsonToken.i) {
                    ajv2.j();
                    return null;
                }
                return Float.valueOf((float)((float)ajv2.k()));
            }

            @Override
            public void a(ajw ajw2, Number number) throws IOException {
                if (number == null) {
                    ajw2.f();
                    return;
                }
                aih.a(number.floatValue());
                ajw2.a(number);
            }

            @Override
            public /* synthetic */ Object b(ajv ajv2) throws IOException {
                return this.a(ajv2);
            }
        };
    }

    public <T> air<T> a(ais ais2, aju<T> aju2) {
        boolean bl2 = this.e.contains((Object)ais2);
        boolean bl3 = false;
        if (!bl2) {
            bl3 = true;
        }
        for (ais ais3 : this.e) {
            if (!bl3) {
                if (ais3 != ais2) continue;
                bl3 = true;
                continue;
            }
            air<T> air2 = ais3.a((aih)this, aju2);
            if (air2 == null) continue;
            return air2;
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aju2);
    }

    public <T> air<T> a(aju<T> aju2) {
        a a2;
        air air2 = (air)this.d.get(aju2);
        if (air2 != null) {
            return air2;
        }
        Map map = (Map)this.c.get();
        boolean bl2 = false;
        if (map == null) {
            map = new HashMap();
            this.c.set((Object)map);
            bl2 = true;
        }
        if ((a2 = (a)map.get(aju2)) != null) {
            return a2;
        }
        try {
            a<T> a3 = new a<T>();
            map.put(aju2, a3);
            Iterator iterator = this.e.iterator();
            while (iterator.hasNext()) {
                air<T> air3 = ((ais)iterator.next()).a((aih)this, aju2);
                if (air3 == null) continue;
                a3.a(air3);
                this.d.put(aju2, air3);
                return air3;
            }
            throw new IllegalArgumentException("GSON cannot handle " + aju2);
        }
        finally {
            map.remove(aju2);
            if (bl2) {
                this.c.remove();
            }
        }
    }

    public <T> air<T> a(Class<T> class_) {
        return this.a(aju.get(class_));
    }

    public ajv a(Reader reader) {
        ajv ajv2 = new ajv(reader);
        ajv2.a(this.k);
        return ajv2;
    }

    public ajw a(Writer writer) throws IOException {
        if (this.i) {
            writer.write(")]}'\n");
        }
        ajw ajw2 = new ajw(writer);
        if (this.j) {
            ajw2.c("  ");
        }
        ajw2.d(this.g);
        return ajw2;
    }

    public <T> T a(ail ail2, Class<T> class_) throws JsonSyntaxException {
        T t2 = this.a(ail2, (Type)class_);
        return (T)ajd.a(class_).cast(t2);
    }

    public <T> T a(ail ail2, Type type) throws JsonSyntaxException {
        if (ail2 == null) {
            return null;
        }
        return this.a(new ajk(ail2), type);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public <T> T a(ajv ajv2, Type type) throws JsonIOException, JsonSyntaxException {
        boolean bl2 = true;
        boolean bl3 = ajv2.p();
        ajv2.a(true);
        try {
            ajv2.f();
            bl2 = false;
            Object obj = this.a(aju.get(type)).b(ajv2);
            return (T)obj;
        }
        catch (EOFException var8_6) {
            if (!bl2) throw new JsonSyntaxException((Throwable)var8_6);
            return null;
        }
        catch (IllegalStateException var7_8) {
            throw new JsonSyntaxException((Throwable)var7_8);
        }
        catch (IOException var5_9) {
            throw new JsonSyntaxException((Throwable)var5_9);
        }
        finally {
            ajv2.a(bl3);
        }
    }

    public <T> T a(Reader reader, Type type) throws JsonIOException, JsonSyntaxException {
        ajv ajv2 = this.a(reader);
        T t2 = this.a(ajv2, type);
        aih.a(t2, ajv2);
        return t2;
    }

    public <T> T a(String string2, Class<T> class_) throws JsonSyntaxException {
        T t2 = this.a(string2, (Type)class_);
        return (T)ajd.a(class_).cast(t2);
    }

    public <T> T a(String string2, Type type) throws JsonSyntaxException {
        if (string2 == null) {
            return null;
        }
        return this.a((Reader)new StringReader(string2), type);
    }

    public String a(ail ail2) {
        StringWriter stringWriter = new StringWriter();
        this.a(ail2, (Appendable)stringWriter);
        return stringWriter.toString();
    }

    public String a(Object object) {
        if (object == null) {
            return this.a(aim.a);
        }
        return this.a(object, (Type)object.getClass());
    }

    public String a(Object object, Type type) {
        StringWriter stringWriter = new StringWriter();
        this.a(object, type, (Appendable)stringWriter);
        return stringWriter.toString();
    }

    public void a(ail ail2, ajw ajw2) throws JsonIOException {
        boolean bl2 = ajw2.g();
        ajw2.b(true);
        boolean bl3 = ajw2.h();
        ajw2.c(this.h);
        boolean bl4 = ajw2.i();
        ajw2.d(this.g);
        try {
            aje.a(ail2, ajw2);
            return;
        }
        catch (IOException var7_6) {
            throw new JsonIOException((Throwable)var7_6);
        }
        finally {
            ajw2.b(bl2);
            ajw2.c(bl3);
            ajw2.d(bl4);
        }
    }

    public void a(ail ail2, Appendable appendable) throws JsonIOException {
        try {
            this.a(ail2, this.a(aje.a(appendable)));
            return;
        }
        catch (IOException var3_3) {
            throw new RuntimeException((Throwable)var3_3);
        }
    }

    public void a(Object object, Type type, ajw ajw2) throws JsonIOException {
        air air2 = this.a(aju.get(type));
        boolean bl2 = ajw2.g();
        ajw2.b(true);
        boolean bl3 = ajw2.h();
        ajw2.c(this.h);
        boolean bl4 = ajw2.i();
        ajw2.d(this.g);
        try {
            air2.a(ajw2, (Object)object);
            return;
        }
        catch (IOException var9_8) {
            throw new JsonIOException((Throwable)var9_8);
        }
        finally {
            ajw2.b(bl2);
            ajw2.c(bl3);
            ajw2.d(bl4);
        }
    }

    public void a(Object object, Type type, Appendable appendable) throws JsonIOException {
        try {
            this.a(object, type, this.a(aje.a(appendable)));
            return;
        }
        catch (IOException var4_4) {
            throw new JsonIOException((Throwable)var4_4);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.g + "factories:" + this.e + ",instanceCreators:" + this.f + "}";
    }

    static class a<T>
    extends air<T> {
        private air<T> a;

        a() {
        }

        public void a(air<T> air2) {
            if (this.a != null) {
                throw new AssertionError();
            }
            this.a = air2;
        }

        @Override
        public void a(ajw ajw2, T t2) throws IOException {
            if (this.a == null) {
                throw new IllegalStateException();
            }
            this.a.a(ajw2, t2);
        }

        @Override
        public T b(ajv ajv2) throws IOException {
            if (this.a == null) {
                throw new IllegalStateException();
            }
            return this.a.b(ajv2);
        }
    }

}

