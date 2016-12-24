/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.api.Status
 *  java.lang.Object
 */
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;

public class xq
implements xk {
    private final Status a;
    private final dh<aba<?>, ConnectionResult> b;

    public xq(Status status, dh<aba<?>, ConnectionResult> dh2) {
        this.a = status;
        this.b = dh2;
    }

    @Override
    public Status a() {
        return this.a;
    }
}

