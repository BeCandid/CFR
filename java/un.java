/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.AbstractList
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.List
 *  java.util.concurrent.atomic.AtomicInteger
 */
import android.os.Handler;
import com.facebook.GraphRequest;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class un
extends AbstractList<GraphRequest> {
    private static AtomicInteger a = new AtomicInteger();
    private Handler b;
    private List<GraphRequest> c;
    private int d;
    private final String e;
    private List<a> f;
    private String g;

    public un() {
        this.c = new ArrayList();
        this.d = 0;
        this.e = Integer.valueOf((int)a.incrementAndGet()).toString();
        this.f = new ArrayList();
        this.c = new ArrayList();
    }

    public un(Collection<GraphRequest> collection) {
        this.c = new ArrayList();
        this.d = 0;
        this.e = Integer.valueOf((int)a.incrementAndGet()).toString();
        this.f = new ArrayList();
        this.c = new ArrayList(collection);
    }

    public /* varargs */ un(GraphRequest ... arrgraphRequest) {
        this.c = new ArrayList();
        this.d = 0;
        this.e = Integer.valueOf((int)a.incrementAndGet()).toString();
        this.f = new ArrayList();
        this.c = Arrays.asList((Object[])arrgraphRequest);
    }

    public int a() {
        return this.d;
    }

    public final GraphRequest a(int n2) {
        return (GraphRequest)this.c.get(n2);
    }

    public final void a(int n2, GraphRequest graphRequest) {
        this.c.add(n2, (Object)graphRequest);
    }

    final void a(Handler handler) {
        this.b = handler;
    }

    public void a(a a2) {
        if (!this.f.contains((Object)a2)) {
            this.f.add((Object)a2);
        }
    }

    public final boolean a(GraphRequest graphRequest) {
        return this.c.add((Object)graphRequest);
    }

    public /* synthetic */ void add(int n2, Object object) {
        this.a(n2, (GraphRequest)object);
    }

    public /* synthetic */ boolean add(Object object) {
        return this.a((GraphRequest)object);
    }

    public final GraphRequest b(int n2) {
        return (GraphRequest)this.c.remove(n2);
    }

    public final GraphRequest b(int n2, GraphRequest graphRequest) {
        return (GraphRequest)this.c.set(n2, (Object)graphRequest);
    }

    public final String b() {
        return this.e;
    }

    public final Handler c() {
        return this.b;
    }

    public final void clear() {
        this.c.clear();
    }

    public final List<GraphRequest> d() {
        return this.c;
    }

    public final List<a> e() {
        return this.f;
    }

    public final String f() {
        return this.g;
    }

    public final List<uo> g() {
        return this.i();
    }

    public /* synthetic */ Object get(int n2) {
        return this.a(n2);
    }

    public final um h() {
        return this.j();
    }

    List<uo> i() {
        return GraphRequest.b(this);
    }

    um j() {
        return GraphRequest.c(this);
    }

    public /* synthetic */ Object remove(int n2) {
        return this.b(n2);
    }

    public /* synthetic */ Object set(int n2, Object object) {
        return this.b(n2, (GraphRequest)object);
    }

    public final int size() {
        return this.c.size();
    }

    public static interface a {
        public void a(un var1);
    }

    public static interface b
    extends a {
        public void a(un var1, long var2, long var4);
    }

}

