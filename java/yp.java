/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.IInterface
 *  android.os.Looper
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.api.Scope
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Iterator
 *  java.util.Set
 */
import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import java.util.Iterator;
import java.util.Set;

public abstract class yp<T extends IInterface>
extends yi<T>
implements xf.f {
    private final yl d;
    private final Set<Scope> e;
    private final Account f;

    protected yp(Context context, Looper looper, int n2, yl yl2, xh.b b2, xh.c c2) {
        this(context, looper, yq.a(context), xd.a(), n2, yl2, xz.a(b2), xz.a(c2));
    }

    protected yp(Context context, Looper looper, yq yq2, xd xd2, int n2, yl yl2, xh.b b2, xh.c c2) {
        super(context, looper, yq2, xd2, n2, yp.a(b2), yp.a(c2), yl2.d());
        this.d = yl2;
        this.f = yl2.a();
        this.e = super.b(yl2.b());
    }

    private static yi.b a(xh.b b2) {
        if (b2 == null) {
            return null;
        }
        return new yi.b(){

            @Override
            public void a(int n2) {
                b.this.a(n2);
            }

            @Override
            public void a(Bundle bundle) {
                b.this.a(bundle);
            }
        };
    }

    private static yi.c a(xh.c c2) {
        if (c2 == null) {
            return null;
        }
        return new yi.c(){

            @Override
            public void a(ConnectionResult connectionResult) {
                c.this.a(connectionResult);
            }
        };
    }

    private Set<Scope> b(Set<Scope> set) {
        Set<Scope> set2 = this.a(set);
        Iterator iterator = set2.iterator();
        while (iterator.hasNext()) {
            if (set.contains((Object)((Scope)iterator.next()))) continue;
            throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
        }
        return set2;
    }

    protected Set<Scope> a(Set<Scope> set) {
        return set;
    }

    @Override
    public final Account m() {
        return this.f;
    }

    @Override
    protected final Set<Scope> u() {
        return this.e;
    }

}

