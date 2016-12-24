/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.google.gson.stream.JsonToken
 *  java.io.IOException
 *  java.io.Reader
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.IllegalStateException
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class ajk
extends ajv {
    private static final Reader b = new Reader(){

        public void close() throws IOException {
            throw new AssertionError();
        }

        public int read(char[] arrc, int n2, int n3) throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object c = new Object();
    private final List<Object> d = new ArrayList();

    public ajk(ail ail2) {
        super(b);
        this.d.add((Object)ail2);
    }

    private void a(JsonToken jsonToken) throws IOException {
        if (this.f() != jsonToken) {
            throw new IllegalStateException("Expected " + (Object)jsonToken + " but was " + (Object)this.f());
        }
    }

    private Object u() {
        return this.d.get(-1 + this.d.size());
    }

    private Object v() {
        return this.d.remove(-1 + this.d.size());
    }

    @Override
    public void a() throws IOException {
        this.a(JsonToken.a);
        aij aij2 = (aij)this.u();
        this.d.add(aij2.iterator());
    }

    @Override
    public void b() throws IOException {
        this.a(JsonToken.b);
        this.v();
        this.v();
    }

    @Override
    public void c() throws IOException {
        this.a(JsonToken.c);
        ain ain2 = (ain)this.u();
        this.d.add((Object)ain2.a().iterator());
    }

    @Override
    public void close() throws IOException {
        this.d.clear();
        this.d.add(c);
    }

    @Override
    public void d() throws IOException {
        this.a(JsonToken.d);
        this.v();
        this.v();
    }

    @Override
    public boolean e() throws IOException {
        JsonToken jsonToken = this.f();
        if (jsonToken != JsonToken.d && jsonToken != JsonToken.b) {
            return true;
        }
        return false;
    }

    @Override
    public JsonToken f() throws IOException {
        if (this.d.isEmpty()) {
            return JsonToken.j;
        }
        Object object = this.u();
        if (object instanceof Iterator) {
            boolean bl2 = this.d.get(-2 + this.d.size()) instanceof ain;
            Iterator iterator = (Iterator)object;
            if (iterator.hasNext()) {
                if (bl2) {
                    return JsonToken.e;
                }
                this.d.add(iterator.next());
                return this.f();
            }
            if (bl2) {
                return JsonToken.d;
            }
            return JsonToken.b;
        }
        if (object instanceof ain) {
            return JsonToken.c;
        }
        if (object instanceof aij) {
            return JsonToken.a;
        }
        if (object instanceof aip) {
            aip aip2 = (aip)object;
            if (aip2.r()) {
                return JsonToken.f;
            }
            if (aip2.a()) {
                return JsonToken.h;
            }
            if (aip2.q()) {
                return JsonToken.g;
            }
            throw new AssertionError();
        }
        if (object instanceof aim) {
            return JsonToken.i;
        }
        if (object == c) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw new AssertionError();
    }

    @Override
    public String g() throws IOException {
        this.a(JsonToken.e);
        Map.Entry entry = (Map.Entry)((Iterator)this.u()).next();
        this.d.add(entry.getValue());
        return (String)entry.getKey();
    }

    @Override
    public String h() throws IOException {
        JsonToken jsonToken = this.f();
        if (jsonToken != JsonToken.f && jsonToken != JsonToken.g) {
            throw new IllegalStateException("Expected " + (Object)JsonToken.f + " but was " + (Object)jsonToken);
        }
        return ((aip)this.v()).c();
    }

    @Override
    public boolean i() throws IOException {
        this.a(JsonToken.h);
        return ((aip)this.v()).h();
    }

    @Override
    public void j() throws IOException {
        this.a(JsonToken.i);
        this.v();
    }

    @Override
    public double k() throws IOException {
        JsonToken jsonToken = this.f();
        if (jsonToken != JsonToken.g && jsonToken != JsonToken.f) {
            throw new IllegalStateException("Expected " + (Object)JsonToken.g + " but was " + (Object)jsonToken);
        }
        double d2 = ((aip)this.u()).d();
        if (!this.p() && (Double.isNaN((double)d2) || Double.isInfinite((double)d2))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + d2);
        }
        this.v();
        return d2;
    }

    @Override
    public long l() throws IOException {
        JsonToken jsonToken = this.f();
        if (jsonToken != JsonToken.g && jsonToken != JsonToken.f) {
            throw new IllegalStateException("Expected " + (Object)JsonToken.g + " but was " + (Object)jsonToken);
        }
        long l2 = ((aip)this.u()).f();
        this.v();
        return l2;
    }

    @Override
    public int m() throws IOException {
        JsonToken jsonToken = this.f();
        if (jsonToken != JsonToken.g && jsonToken != JsonToken.f) {
            throw new IllegalStateException("Expected " + (Object)JsonToken.g + " but was " + (Object)jsonToken);
        }
        int n2 = ((aip)this.u()).g();
        this.v();
        return n2;
    }

    @Override
    public void n() throws IOException {
        if (this.f() == JsonToken.e) {
            this.g();
            return;
        }
        this.v();
    }

    public void o() throws IOException {
        this.a(JsonToken.e);
        Map.Entry entry = (Map.Entry)((Iterator)this.u()).next();
        this.d.add(entry.getValue());
        this.d.add((Object)new aip((String)entry.getKey()));
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

}

