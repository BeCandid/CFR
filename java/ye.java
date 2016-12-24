/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Looper
 *  java.lang.String
 */
import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;

public class ye<T extends IInterface>
extends yp<T> {
    private final xf.h<T> d;

    public ye(Context context, Looper looper, int n2, xh.b b2, xh.c c2, yl yl2, xf.h<T> h2) {
        super(context, looper, n2, yl2, b2, c2);
        this.d = h2;
    }

    @Override
    protected T a(IBinder iBinder) {
        return this.d.a(iBinder);
    }

    @Override
    protected void a(int n2, T t2) {
        this.d.a(n2, t2);
    }

    @Override
    protected String f() {
        return this.d.a();
    }

    @Override
    protected String g() {
        return this.d.b();
    }

    public xf.h<T> h() {
        return this.d;
    }
}

