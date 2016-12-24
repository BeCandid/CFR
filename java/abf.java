/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.ConnectionResult
 *  java.lang.Object
 *  java.util.Iterator
 */
import com.google.android.gms.common.ConnectionResult;
import java.util.Iterator;

public class abf
extends abd {
    @Override
    protected void a(ConnectionResult connectionResult, int n2) {
        ((abg)null).b(connectionResult, n2);
    }

    @Override
    public void b() {
        super.b();
        Iterator iterator = ((zl)null).iterator();
        while (iterator.hasNext()) {
            ((xr)iterator.next()).a();
        }
        ((zl)null).clear();
        ((abg)null).a(this);
    }

    @Override
    protected void c() {
        ((abg)null).b();
    }
}

