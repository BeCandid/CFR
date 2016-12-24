/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Looper
 *  com.google.android.gms.common.api.Scope
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Set
 */
import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import java.util.Set;

public final class xf<O extends a> {
    private final b<?, O> a;
    private final i<?, O> b;
    private final g<?> c;
    private final j<?> d;
    private final String e;

    public <C extends f> xf(String string2, b<C, O> b2, g<C> g2) {
        xz.a(b2, (Object)"Cannot construct an Api with a null ClientBuilder");
        xz.a(g2, (Object)"Cannot construct an Api with a null ClientKey");
        this.e = string2;
        this.a = b2;
        this.b = null;
        this.c = g2;
        this.d = null;
    }

    /*
     * Enabled aggressive block sorting
     */
    public b<?, O> a() {
        boolean bl2 = this.a != null;
        xz.a(bl2, (Object)"This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.a;
    }

    public i<?, O> b() {
        xz.a(false, (Object)"This API was constructed with a ClientBuilder. Use getClientBuilder");
        return null;
    }

    public d<?> c() {
        if (this.c != null) {
            return this.c;
        }
        throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
    }

    public boolean d() {
        return false;
    }

    public String e() {
        return this.e;
    }

    public static interface xf$a {

        public static interface a
        extends xf$a {
        }

        public static interface b
        extends xf$a {
        }

        public static interface c
        extends a,
        b {
        }

    }

    public static abstract class b<T extends f, O>
    extends e<T, O> {
        public abstract T a(Context var1, Looper var2, yl var3, O var4, xh.b var5, xh.c var6);
    }

    public static interface c {
    }

    public static class d<C extends c> {
    }

    public static abstract class e<T extends c, O> {
    }

    public static interface f
    extends c {
        public void a();

        public void a(yi.f var1);

        public void a(yt var1, Set<Scope> var2);

        public boolean b();

        public boolean c();

        public boolean d();

        public IBinder e();
    }

    public static final class g<C extends f>
    extends d<C> {
    }

    public static interface h<T extends IInterface>
    extends c {
        public T a(IBinder var1);

        public String a();

        public void a(int var1, T var2);

        public String b();
    }

    public static abstract class i<T extends h, O>
    extends e<T, O> {
        public abstract int a();

        public abstract T a(O var1);
    }

    public static final class j<C extends h>
    extends d<C> {
    }

}

