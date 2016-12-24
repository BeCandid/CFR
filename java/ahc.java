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

public class ahc
extends yi<aha> {
    public ahc(Context context, Looper looper, yi.b b2, yi.c c2) {
        super(context, looper, 93, b2, c2, null);
    }

    @Override
    public /* synthetic */ IInterface a(IBinder iBinder) {
        return this.b(iBinder);
    }

    public aha b(IBinder iBinder) {
        return aha.a.a(iBinder);
    }

    @Override
    protected String f() {
        return "com.google.android.gms.measurement.START";
    }

    @Override
    protected String g() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }
}

