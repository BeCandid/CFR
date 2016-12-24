/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.Void
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 */
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class rj
extends alc<Void>
implements ald {
    public final rk a;
    public final sn b;
    public final sz c;
    public final Collection<? extends alc> d;

    public rj() {
        this(new rk(), new sn(), new sz());
    }

    rj(rk rk2, sn sn2, sz sz2) {
        this.a = rk2;
        this.b = sn2;
        this.c = sz2;
        this.d = Collections.unmodifiableCollection((Collection)Arrays.asList((Object[])new alc[]{rk2, sn2, sz2}));
    }

    public static void a(String string2) {
        rj.g();
        rj.e().c.a(string2);
    }

    public static void a(Throwable throwable) {
        rj.g();
        rj.e().c.a(throwable);
    }

    public static rj e() {
        return (rj)akx.a(rj.class);
    }

    private static void g() {
        if (rj.e() == null) {
            throw new IllegalStateException("Crashlytics must be initialized by calling Fabric.with(Context) prior to calling Crashlytics.getInstance()");
        }
    }

    @Override
    public String a() {
        return "2.6.1.139";
    }

    @Override
    public String b() {
        return "com.crashlytics.sdk.android:crashlytics";
    }

    @Override
    public Collection<? extends alc> c() {
        return this.d;
    }

    protected Void d() {
        return null;
    }

    @Override
    protected /* synthetic */ Object f() {
        return this.d();
    }
}

