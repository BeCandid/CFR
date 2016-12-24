/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonIOException
 *  com.google.gson.JsonSyntaxException
 *  com.google.gson.internal.LazilyParsedNumber
 *  com.google.gson.stream.JsonToken
 *  java.io.IOException
 *  java.lang.AssertionError
 *  java.lang.Boolean
 *  java.lang.Byte
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.NoSuchFieldError
 *  java.lang.NoSuchFieldException
 *  java.lang.Number
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.Field
 *  java.math.BigDecimal
 *  java.math.BigInteger
 *  java.net.InetAddress
 *  java.net.URI
 *  java.net.URISyntaxException
 *  java.net.URL
 *  java.sql.Timestamp
 *  java.util.ArrayList
 *  java.util.BitSet
 *  java.util.Calendar
 *  java.util.Currency
 *  java.util.Date
 *  java.util.GregorianCalendar
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.StringTokenizer
 *  java.util.UUID
 *  java.util.concurrent.atomic.AtomicBoolean
 *  java.util.concurrent.atomic.AtomicInteger
 *  java.util.concurrent.atomic.AtomicIntegerArray
 */
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public final class ajs {
    public static final air<String> A;
    public static final air<BigDecimal> B;
    public static final air<BigInteger> C;
    public static final ais D;
    public static final air<StringBuilder> E;
    public static final ais F;
    public static final air<StringBuffer> G;
    public static final ais H;
    public static final air<URL> I;
    public static final ais J;
    public static final air<URI> K;
    public static final ais L;
    public static final air<InetAddress> M;
    public static final ais N;
    public static final air<UUID> O;
    public static final ais P;
    public static final air<Currency> Q;
    public static final ais R;
    public static final ais S;
    public static final air<Calendar> T;
    public static final ais U;
    public static final air<Locale> V;
    public static final ais W;
    public static final air<ail> X;
    public static final ais Y;
    public static final ais Z;
    public static final air<Class> a;
    public static final ais b;
    public static final air<BitSet> c;
    public static final ais d;
    public static final air<Boolean> e;
    public static final air<Boolean> f;
    public static final ais g;
    public static final air<Number> h;
    public static final ais i;
    public static final air<Number> j;
    public static final ais k;
    public static final air<Number> l;
    public static final ais m;
    public static final air<AtomicInteger> n;
    public static final ais o;
    public static final air<AtomicBoolean> p;
    public static final ais q;
    public static final air<AtomicIntegerArray> r;
    public static final ais s;
    public static final air<Number> t;
    public static final air<Number> u;
    public static final air<Number> v;
    public static final air<Number> w;
    public static final ais x;
    public static final air<Character> y;
    public static final ais z;

    static {
        a = new air<Class>(){

            public Class a(ajv ajv2) throws IOException {
                if (ajv2.f() == JsonToken.i) {
                    ajv2.j();
                    return null;
                }
                throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
            }

            @Override
            public void a(ajw ajw2, Class class_) throws IOException {
                if (class_ == null) {
                    ajw2.f();
                    return;
                }
                throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + class_.getName() + ". Forgot to register a type adapter?");
            }

            @Override
            public /* synthetic */ Object b(ajv ajv2) throws IOException {
                return this.a(ajv2);
            }
        };
        b = ajs.a(Class.class, a);
        c = new air<BitSet>(){

            /*
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            public BitSet a(ajv ajv2) throws IOException {
                String string2;
                if (ajv2.f() == JsonToken.i) {
                    ajv2.j();
                    return null;
                }
                BitSet bitSet = new BitSet();
                ajv2.a();
                int n2 = 0;
                JsonToken jsonToken = ajv2.f();
                do {
                    boolean bl2;
                    if (jsonToken == JsonToken.b) {
                        ajv2.b();
                        return bitSet;
                    }
                    switch (.a[jsonToken.ordinal()]) {
                        default: {
                            throw new JsonSyntaxException("Invalid bitset value type: " + (Object)jsonToken);
                        }
                        case 1: {
                            if (ajv2.m() != 0) {
                                bl2 = true;
                                break;
                            }
                            bl2 = false;
                            break;
                        }
                        case 2: {
                            bl2 = ajv2.i();
                            break;
                        }
                        case 3: {
                            string2 = ajv2.h();
                            int n3 = Integer.parseInt((String)string2);
                            bl2 = n3 != 0;
                        }
                    }
                    if (bl2) {
                        bitSet.set(n2);
                    }
                    ++n2;
                    jsonToken = ajv2.f();
                } while (true);
                catch (NumberFormatException numberFormatException) {
                    throw new JsonSyntaxException("Error: Expecting: bitset number value (1, 0), Found: " + string2);
                }
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void a(ajw ajw2, BitSet bitSet) throws IOException {
                if (bitSet == null) {
                    ajw2.f();
                    return;
                }
                ajw2.b();
                int n2 = 0;
                do {
                    if (n2 >= bitSet.length()) {
                        ajw2.c();
                        return;
                    }
                    boolean bl2 = bitSet.get(n2);
                    ajw2.a((long)bl2 ? 1 : 0);
                    ++n2;
                } while (true);
            }

            @Override
            public /* synthetic */ Object b(ajv ajv2) throws IOException {
                return this.a(ajv2);
            }
        };
        d = ajs.a(BitSet.class, c);
        e = new air<Boolean>(){

            public Boolean a(ajv ajv2) throws IOException {
                if (ajv2.f() == JsonToken.i) {
                    ajv2.j();
                    return null;
                }
                if (ajv2.f() == JsonToken.f) {
                    return Boolean.parseBoolean((String)ajv2.h());
                }
                return ajv2.i();
            }

            @Override
            public void a(ajw ajw2, Boolean bl2) throws IOException {
                if (bl2 == null) {
                    ajw2.f();
                    return;
                }
                ajw2.a(bl2);
            }

            @Override
            public /* synthetic */ Object b(ajv ajv2) throws IOException {
                return this.a(ajv2);
            }
        };
        f = new air<Boolean>(){

            public Boolean a(ajv ajv2) throws IOException {
                if (ajv2.f() == JsonToken.i) {
                    ajv2.j();
                    return null;
                }
                return Boolean.valueOf((String)ajv2.h());
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void a(ajw ajw2, Boolean bl2) throws IOException {
                String string2 = bl2 == null ? "null" : bl2.toString();
                ajw2.b(string2);
            }

            @Override
            public /* synthetic */ Object b(ajv ajv2) throws IOException {
                return this.a(ajv2);
            }
        };
        g = ajs.a(Boolean.TYPE, Boolean.class, e);
        h = new air<Number>(){

            public Number a(ajv ajv2) throws IOException {
                if (ajv2.f() == JsonToken.i) {
                    ajv2.j();
                    return null;
                }
                try {
                    Byte by2 = Byte.valueOf((byte)((byte)ajv2.m()));
                    return by2;
                }
                catch (NumberFormatException var2_3) {
                    throw new JsonSyntaxException((Throwable)var2_3);
                }
            }

            @Override
            public void a(ajw ajw2, Number number) throws IOException {
                ajw2.a(number);
            }

            @Override
            public /* synthetic */ Object b(ajv ajv2) throws IOException {
                return this.a(ajv2);
            }
        };
        i = ajs.a(Byte.TYPE, Byte.class, h);
        j = new air<Number>(){

            public Number a(ajv ajv2) throws IOException {
                if (ajv2.f() == JsonToken.i) {
                    ajv2.j();
                    return null;
                }
                try {
                    Short s2 = (short)ajv2.m();
                    return s2;
                }
                catch (NumberFormatException var2_3) {
                    throw new JsonSyntaxException((Throwable)var2_3);
                }
            }

            @Override
            public void a(ajw ajw2, Number number) throws IOException {
                ajw2.a(number);
            }

            @Override
            public /* synthetic */ Object b(ajv ajv2) throws IOException {
                return this.a(ajv2);
            }
        };
        k = ajs.a(Short.TYPE, Short.class, j);
        l = new air<Number>(){

            public Number a(ajv ajv2) throws IOException {
                if (ajv2.f() == JsonToken.i) {
                    ajv2.j();
                    return null;
                }
                try {
                    Integer n2 = ajv2.m();
                    return n2;
                }
                catch (NumberFormatException var2_3) {
                    throw new JsonSyntaxException((Throwable)var2_3);
                }
            }

            @Override
            public void a(ajw ajw2, Number number) throws IOException {
                ajw2.a(number);
            }

            @Override
            public /* synthetic */ Object b(ajv ajv2) throws IOException {
                return this.a(ajv2);
            }
        };
        m = ajs.a(Integer.TYPE, Integer.class, l);
        n = new air<AtomicInteger>(){

            public AtomicInteger a(ajv ajv2) throws IOException {
                try {
                    AtomicInteger atomicInteger = new AtomicInteger(ajv2.m());
                    return atomicInteger;
                }
                catch (NumberFormatException var3_3) {
                    throw new JsonSyntaxException((Throwable)var3_3);
                }
            }

            @Override
            public void a(ajw ajw2, AtomicInteger atomicInteger) throws IOException {
                ajw2.a((long)atomicInteger.get());
            }

            @Override
            public /* synthetic */ Object b(ajv ajv2) throws IOException {
                return this.a(ajv2);
            }
        }.a();
        o = ajs.a(AtomicInteger.class, n);
        p = new air<AtomicBoolean>(){

            public AtomicBoolean a(ajv ajv2) throws IOException {
                return new AtomicBoolean(ajv2.i());
            }

            @Override
            public void a(ajw ajw2, AtomicBoolean atomicBoolean) throws IOException {
                ajw2.a(atomicBoolean.get());
            }

            @Override
            public /* synthetic */ Object b(ajv ajv2) throws IOException {
                return this.a(ajv2);
            }
        }.a();
        q = ajs.a(AtomicBoolean.class, p);
        r = new air<AtomicIntegerArray>(){

            public AtomicIntegerArray a(ajv ajv2) throws IOException {
                ArrayList arrayList = new ArrayList();
                ajv2.a();
                while (ajv2.e()) {
                    try {
                        arrayList.add((Object)ajv2.m());
                        continue;
                    }
                    catch (NumberFormatException var6_3) {
                        throw new JsonSyntaxException((Throwable)var6_3);
                    }
                }
                ajv2.b();
                int n2 = arrayList.size();
                AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(n2);
                for (int i2 = 0; i2 < n2; ++i2) {
                    atomicIntegerArray.set(i2, ((Integer)arrayList.get(i2)).intValue());
                }
                return atomicIntegerArray;
            }

            @Override
            public void a(ajw ajw2, AtomicIntegerArray atomicIntegerArray) throws IOException {
                ajw2.b();
                int n2 = atomicIntegerArray.length();
                for (int i2 = 0; i2 < n2; ++i2) {
                    ajw2.a((long)atomicIntegerArray.get(i2));
                }
                ajw2.c();
            }

            @Override
            public /* synthetic */ Object b(ajv ajv2) throws IOException {
                return this.a(ajv2);
            }
        }.a();
        s = ajs.a(AtomicIntegerArray.class, r);
        t = new air<Number>(){

            public Number a(ajv ajv2) throws IOException {
                if (ajv2.f() == JsonToken.i) {
                    ajv2.j();
                    return null;
                }
                try {
                    Long l2 = ajv2.l();
                    return l2;
                }
                catch (NumberFormatException var2_3) {
                    throw new JsonSyntaxException((Throwable)var2_3);
                }
            }

            @Override
            public void a(ajw ajw2, Number number) throws IOException {
                ajw2.a(number);
            }

            @Override
            public /* synthetic */ Object b(ajv ajv2) throws IOException {
                return this.a(ajv2);
            }
        };
        u = new air<Number>(){

            public Number a(ajv ajv2) throws IOException {
                if (ajv2.f() == JsonToken.i) {
                    ajv2.j();
                    return null;
                }
                return Float.valueOf((float)((float)ajv2.k()));
            }

            @Override
            public void a(ajw ajw2, Number number) throws IOException {
                ajw2.a(number);
            }

            @Override
            public /* synthetic */ Object b(ajv ajv2) throws IOException {
                return this.a(ajv2);
            }
        };
        v = new air<Number>(){

            public Number a(ajv ajv2) throws IOException {
                if (ajv2.f() == JsonToken.i) {
                    ajv2.j();
                    return null;
                }
                return ajv2.k();
            }

            @Override
            public void a(ajw ajw2, Number number) throws IOException {
                ajw2.a(number);
            }

            @Override
            public /* synthetic */ Object b(ajv ajv2) throws IOException {
                return this.a(ajv2);
            }
        };
        w = new air<Number>(){

            public Number a(ajv ajv2) throws IOException {
                JsonToken jsonToken = ajv2.f();
                switch (.a[jsonToken.ordinal()]) {
                    default: {
                        throw new JsonSyntaxException("Expecting number, got: " + (Object)jsonToken);
                    }
                    case 4: {
                        ajv2.j();
                        return null;
                    }
                    case 1: 
                }
                return new LazilyParsedNumber(ajv2.h());
            }

            @Override
            public void a(ajw ajw2, Number number) throws IOException {
                ajw2.a(number);
            }

            @Override
            public /* synthetic */ Object b(ajv ajv2) throws IOException {
                return this.a(ajv2);
            }
        };
        x = ajs.a(Number.class, w);
        y = new air<Character>(){

            public Character a(ajv ajv2) throws IOException {
                if (ajv2.f() == JsonToken.i) {
                    ajv2.j();
                    return null;
                }
                String string2 = ajv2.h();
                if (string2.length() != 1) {
                    throw new JsonSyntaxException("Expecting character, got: " + string2);
                }
                return Character.valueOf((char)string2.charAt(0));
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void a(ajw ajw2, Character c2) throws IOException {
                String string2 = c2 == null ? null : String.valueOf((Object)c2);
                ajw2.b(string2);
            }

            @Override
            public /* synthetic */ Object b(ajv ajv2) throws IOException {
                return this.a(ajv2);
            }
        };
        z = ajs.a(Character.TYPE, Character.class, y);
        A = new air<String>(){

            public String a(ajv ajv2) throws IOException {
                JsonToken jsonToken = ajv2.f();
                if (jsonToken == JsonToken.i) {
                    ajv2.j();
                    return null;
                }
                if (jsonToken == JsonToken.h) {
                    return Boolean.toString((boolean)ajv2.i());
                }
                return ajv2.h();
            }

            @Override
            public void a(ajw ajw2, String string2) throws IOException {
                ajw2.b(string2);
            }

            @Override
            public /* synthetic */ Object b(ajv ajv2) throws IOException {
                return this.a(ajv2);
            }
        };
        B = new air<BigDecimal>(){

            public BigDecimal a(ajv ajv2) throws IOException {
                if (ajv2.f() == JsonToken.i) {
                    ajv2.j();
                    return null;
                }
                try {
                    BigDecimal bigDecimal = new BigDecimal(ajv2.h());
                    return bigDecimal;
                }
                catch (NumberFormatException var3_3) {
                    throw new JsonSyntaxException((Throwable)var3_3);
                }
            }

            @Override
            public void a(ajw ajw2, BigDecimal bigDecimal) throws IOException {
                ajw2.a((Number)bigDecimal);
            }

            @Override
            public /* synthetic */ Object b(ajv ajv2) throws IOException {
                return this.a(ajv2);
            }
        };
        C = new air<BigInteger>(){

            public BigInteger a(ajv ajv2) throws IOException {
                if (ajv2.f() == JsonToken.i) {
                    ajv2.j();
                    return null;
                }
                try {
                    BigInteger bigInteger = new BigInteger(ajv2.h());
                    return bigInteger;
                }
                catch (NumberFormatException var3_3) {
                    throw new JsonSyntaxException((Throwable)var3_3);
                }
            }

            @Override
            public void a(ajw ajw2, BigInteger bigInteger) throws IOException {
                ajw2.a((Number)bigInteger);
            }

            @Override
            public /* synthetic */ Object b(ajv ajv2) throws IOException {
                return this.a(ajv2);
            }
        };
        D = ajs.a(String.class, A);
        E = new air<StringBuilder>(){

            public StringBuilder a(ajv ajv2) throws IOException {
                if (ajv2.f() == JsonToken.i) {
                    ajv2.j();
                    return null;
                }
                return new StringBuilder(ajv2.h());
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void a(ajw ajw2, StringBuilder stringBuilder) throws IOException {
                String string2 = stringBuilder == null ? null : stringBuilder.toString();
                ajw2.b(string2);
            }

            @Override
            public /* synthetic */ Object b(ajv ajv2) throws IOException {
                return this.a(ajv2);
            }
        };
        F = ajs.a(StringBuilder.class, E);
        G = new air<StringBuffer>(){

            public StringBuffer a(ajv ajv2) throws IOException {
                if (ajv2.f() == JsonToken.i) {
                    ajv2.j();
                    return null;
                }
                return new StringBuffer(ajv2.h());
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void a(ajw ajw2, StringBuffer stringBuffer) throws IOException {
                String string2 = stringBuffer == null ? null : stringBuffer.toString();
                ajw2.b(string2);
            }

            @Override
            public /* synthetic */ Object b(ajv ajv2) throws IOException {
                return this.a(ajv2);
            }
        };
        H = ajs.a(StringBuffer.class, G);
        I = new air<URL>(){

            /*
             * Enabled aggressive block sorting
             */
            public URL a(ajv ajv2) throws IOException {
                if (ajv2.f() == JsonToken.i) {
                    ajv2.j();
                    return null;
                } else {
                    String string2 = ajv2.h();
                    if ("null".equals((Object)string2)) return null;
                    return new URL(string2);
                }
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void a(ajw ajw2, URL uRL) throws IOException {
                String string2 = uRL == null ? null : uRL.toExternalForm();
                ajw2.b(string2);
            }

            @Override
            public /* synthetic */ Object b(ajv ajv2) throws IOException {
                return this.a(ajv2);
            }
        };
        J = ajs.a(URL.class, I);
        K = new air<URI>(){

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public URI a(ajv ajv2) throws IOException {
                if (ajv2.f() == JsonToken.i) {
                    ajv2.j();
                    return null;
                }
                try {
                    String string2 = ajv2.h();
                    if ("null".equals((Object)string2)) return null;
                    return new URI(string2);
                }
                catch (URISyntaxException var2_4) {
                    throw new JsonIOException((Throwable)var2_4);
                }
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void a(ajw ajw2, URI uRI) throws IOException {
                String string2 = uRI == null ? null : uRI.toASCIIString();
                ajw2.b(string2);
            }

            @Override
            public /* synthetic */ Object b(ajv ajv2) throws IOException {
                return this.a(ajv2);
            }
        };
        L = ajs.a(URI.class, K);
        M = new air<InetAddress>(){

            public InetAddress a(ajv ajv2) throws IOException {
                if (ajv2.f() == JsonToken.i) {
                    ajv2.j();
                    return null;
                }
                return InetAddress.getByName((String)ajv2.h());
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void a(ajw ajw2, InetAddress inetAddress) throws IOException {
                String string2 = inetAddress == null ? null : inetAddress.getHostAddress();
                ajw2.b(string2);
            }

            @Override
            public /* synthetic */ Object b(ajv ajv2) throws IOException {
                return this.a(ajv2);
            }
        };
        N = ajs.b(InetAddress.class, M);
        O = new air<UUID>(){

            public UUID a(ajv ajv2) throws IOException {
                if (ajv2.f() == JsonToken.i) {
                    ajv2.j();
                    return null;
                }
                return UUID.fromString((String)ajv2.h());
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void a(ajw ajw2, UUID uUID) throws IOException {
                String string2 = uUID == null ? null : uUID.toString();
                ajw2.b(string2);
            }

            @Override
            public /* synthetic */ Object b(ajv ajv2) throws IOException {
                return this.a(ajv2);
            }
        };
        P = ajs.a(UUID.class, O);
        Q = new air<Currency>(){

            public Currency a(ajv ajv2) throws IOException {
                return Currency.getInstance((String)ajv2.h());
            }

            @Override
            public void a(ajw ajw2, Currency currency) throws IOException {
                ajw2.b(currency.getCurrencyCode());
            }

            @Override
            public /* synthetic */ Object b(ajv ajv2) throws IOException {
                return this.a(ajv2);
            }
        }.a();
        R = ajs.a(Currency.class, Q);
        S = new ais(){

            @Override
            public <T> air<T> a(aih aih2, aju<T> aju2) {
                if (aju2.getRawType() != Timestamp.class) {
                    return null;
                }
                return new air<Timestamp>(aih2.a(Date.class)){
                    final /* synthetic */ air a;

                    public Timestamp a(ajv ajv2) throws IOException {
                        Date date = (Date)this.a.b(ajv2);
                        if (date != null) {
                            return new Timestamp(date.getTime());
                        }
                        return null;
                    }

                    @Override
                    public void a(ajw ajw2, Timestamp timestamp) throws IOException {
                        this.a.a(ajw2, timestamp);
                    }

                    @Override
                    public /* synthetic */ Object b(ajv ajv2) throws IOException {
                        return this.a(ajv2);
                    }
                };
            }

        };
        T = new air<Calendar>(){

            public Calendar a(ajv ajv2) throws IOException {
                if (ajv2.f() == JsonToken.i) {
                    ajv2.j();
                    return null;
                }
                ajv2.c();
                int n2 = 0;
                int n3 = 0;
                int n4 = 0;
                int n5 = 0;
                int n6 = 0;
                int n7 = 0;
                while (ajv2.f() != JsonToken.d) {
                    String string2 = ajv2.g();
                    int n8 = ajv2.m();
                    if ("year".equals((Object)string2)) {
                        n2 = n8;
                        continue;
                    }
                    if ("month".equals((Object)string2)) {
                        n3 = n8;
                        continue;
                    }
                    if ("dayOfMonth".equals((Object)string2)) {
                        n4 = n8;
                        continue;
                    }
                    if ("hourOfDay".equals((Object)string2)) {
                        n5 = n8;
                        continue;
                    }
                    if ("minute".equals((Object)string2)) {
                        n6 = n8;
                        continue;
                    }
                    if (!"second".equals((Object)string2)) continue;
                    n7 = n8;
                }
                ajv2.d();
                return new GregorianCalendar(n2, n3, n4, n5, n6, n7);
            }

            @Override
            public void a(ajw ajw2, Calendar calendar) throws IOException {
                if (calendar == null) {
                    ajw2.f();
                    return;
                }
                ajw2.d();
                ajw2.a("year");
                ajw2.a((long)calendar.get(1));
                ajw2.a("month");
                ajw2.a((long)calendar.get(2));
                ajw2.a("dayOfMonth");
                ajw2.a((long)calendar.get(5));
                ajw2.a("hourOfDay");
                ajw2.a((long)calendar.get(11));
                ajw2.a("minute");
                ajw2.a((long)calendar.get(12));
                ajw2.a("second");
                ajw2.a((long)calendar.get(13));
                ajw2.e();
            }

            @Override
            public /* synthetic */ Object b(ajv ajv2) throws IOException {
                return this.a(ajv2);
            }
        };
        U = ajs.b(Calendar.class, GregorianCalendar.class, T);
        V = new air<Locale>(){

            public Locale a(ajv ajv2) throws IOException {
                if (ajv2.f() == JsonToken.i) {
                    ajv2.j();
                    return null;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(ajv2.h(), "_");
                boolean bl2 = stringTokenizer.hasMoreElements();
                String string2 = null;
                if (bl2) {
                    string2 = stringTokenizer.nextToken();
                }
                boolean bl3 = stringTokenizer.hasMoreElements();
                String string3 = null;
                if (bl3) {
                    string3 = stringTokenizer.nextToken();
                }
                boolean bl4 = stringTokenizer.hasMoreElements();
                String string4 = null;
                if (bl4) {
                    string4 = stringTokenizer.nextToken();
                }
                if (string3 == null && string4 == null) {
                    return new Locale(string2);
                }
                if (string4 == null) {
                    return new Locale(string2, string3);
                }
                return new Locale(string2, string3, string4);
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void a(ajw ajw2, Locale locale) throws IOException {
                String string2 = locale == null ? null : locale.toString();
                ajw2.b(string2);
            }

            @Override
            public /* synthetic */ Object b(ajv ajv2) throws IOException {
                return this.a(ajv2);
            }
        };
        W = ajs.a(Locale.class, V);
        X = new air<ail>(){

            @Override
            public ail a(ajv ajv2) throws IOException {
                switch (.a[ajv2.f().ordinal()]) {
                    default: {
                        throw new IllegalArgumentException();
                    }
                    case 3: {
                        return new aip(ajv2.h());
                    }
                    case 1: {
                        return new aip((Number)new LazilyParsedNumber(ajv2.h()));
                    }
                    case 2: {
                        return new aip(ajv2.i());
                    }
                    case 4: {
                        ajv2.j();
                        return aim.a;
                    }
                    case 5: {
                        aij aij2 = new aij();
                        ajv2.a();
                        while (ajv2.e()) {
                            aij2.a(this.a(ajv2));
                        }
                        ajv2.b();
                        return aij2;
                    }
                    case 6: 
                }
                ain ain2 = new ain();
                ajv2.c();
                while (ajv2.e()) {
                    ain2.a(ajv2.g(), this.a(ajv2));
                }
                ajv2.d();
                return ain2;
            }

            @Override
            public void a(ajw ajw2, ail ail2) throws IOException {
                if (ail2 == null || ail2.l()) {
                    ajw2.f();
                    return;
                }
                if (ail2.k()) {
                    aip aip2 = ail2.o();
                    if (aip2.q()) {
                        ajw2.a(aip2.b());
                        return;
                    }
                    if (aip2.a()) {
                        ajw2.a(aip2.h());
                        return;
                    }
                    ajw2.b(aip2.c());
                    return;
                }
                if (ail2.i()) {
                    ajw2.b();
                    Iterator<ail> iterator = ail2.n().iterator();
                    while (iterator.hasNext()) {
                        this.a(ajw2, (ail)iterator.next());
                    }
                    ajw2.c();
                    return;
                }
                if (ail2.j()) {
                    ajw2.d();
                    for (Map.Entry entry : ail2.m().a()) {
                        ajw2.a((String)entry.getKey());
                        this.a(ajw2, (ail)entry.getValue());
                    }
                    ajw2.e();
                    return;
                }
                throw new IllegalArgumentException("Couldn't write " + (Object)ail2.getClass());
            }

            @Override
            public /* synthetic */ Object b(ajv ajv2) throws IOException {
                return this.a(ajv2);
            }
        };
        Y = ajs.b(ail.class, X);
        Z = new ais(){

            @Override
            public <T> air<T> a(aih aih2, aju<T> aju2) {
                Class class_ = aju2.getRawType();
                if (!Enum.class.isAssignableFrom(class_) || class_ == Enum.class) {
                    return null;
                }
                if (!class_.isEnum()) {
                    class_ = class_.getSuperclass();
                }
                return new a(class_);
            }
        };
    }

    public static <TT> ais a(final Class<TT> class_, final air<TT> air2) {
        return new ais(){

            @Override
            public <T> air<T> a(aih aih2, aju<T> aju2) {
                if (aju2.getRawType() == class_) {
                    return air2;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + class_.getName() + ",adapter=" + air2 + "]";
            }
        };
    }

    public static <TT> ais a(final Class<TT> class_, final Class<TT> class_2, final air<? super TT> air2) {
        return new ais(){

            @Override
            public <T> air<T> a(aih aih2, aju<T> aju2) {
                Class<T> class_3 = aju2.getRawType();
                if (class_3 == class_ || class_3 == class_2) {
                    return air2;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + class_2.getName() + "+" + class_.getName() + ",adapter=" + air2 + "]";
            }
        };
    }

    public static <T1> ais b(final Class<T1> class_, final air<T1> air2) {
        return new ais(){

            public <T2> air<T2> a(aih aih2, aju<T2> aju2) {
                final Class<T2> class_2 = aju2.getRawType();
                if (!class_.isAssignableFrom(class_2)) {
                    return null;
                }
                return new air<T1>(){

                    @Override
                    public void a(ajw ajw2, T1 T1) throws IOException {
                        air2.a(ajw2, T1);
                    }

                    @Override
                    public T1 b(ajv ajv2) throws IOException {
                        Object t2 = air2.b(ajv2);
                        if (t2 != null && !class_2.isInstance(t2)) {
                            throw new JsonSyntaxException("Expected a " + class_2.getName() + " but was " + t2.getClass().getName());
                        }
                        return (T1)t2;
                    }
                };
            }

            public String toString() {
                return "Factory[typeHierarchy=" + class_.getName() + ",adapter=" + air2 + "]";
            }

        };
    }

    public static <TT> ais b(final Class<TT> class_, final Class<? extends TT> class_2, final air<? super TT> air2) {
        return new ais(){

            @Override
            public <T> air<T> a(aih aih2, aju<T> aju2) {
                Class<T> class_3 = aju2.getRawType();
                if (class_3 == class_ || class_3 == class_2) {
                    return air2;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + class_.getName() + "+" + class_2.getName() + ",adapter=" + air2 + "]";
            }
        };
    }

    static final class a<T extends Enum<T>>
    extends air<T> {
        private final Map<String, T> a = new HashMap();
        private final Map<T, String> b = new HashMap();

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public a(Class<T> class_) {
            try {
                Enum[] arrenum = (Enum[])class_.getEnumConstants();
                int n2 = arrenum.length;
                int n3 = 0;
                while (n3 < n2) {
                    Enum enum_ = arrenum[n3];
                    String string2 = enum_.name();
                    aiv aiv2 = (aiv)class_.getField(string2).getAnnotation((Class)aiv.class);
                    if (aiv2 != null) {
                        string2 = aiv2.a();
                        for (String string3 : aiv2.b()) {
                            this.a.put((Object)string3, (Object)enum_);
                        }
                    }
                    this.a.put((Object)string2, (Object)enum_);
                    this.b.put((Object)enum_, (Object)string2);
                    ++n3;
                }
                return;
            }
            catch (NoSuchFieldException var2_12) {
                throw new AssertionError("Missing field in " + class_.getName(), (Throwable)var2_12);
            }
        }

        public T a(ajv ajv2) throws IOException {
            if (ajv2.f() == JsonToken.i) {
                ajv2.j();
                return null;
            }
            return (T)((Enum)this.a.get((Object)ajv2.h()));
        }

        /*
         * Enabled aggressive block sorting
         */
        @Override
        public void a(ajw ajw2, T t2) throws IOException {
            String string2 = t2 == null ? null : (String)this.b.get(t2);
            ajw2.b(string2);
        }

        @Override
        public /* synthetic */ Object b(ajv ajv2) throws IOException {
            return this.a(ajv2);
        }
    }

}

