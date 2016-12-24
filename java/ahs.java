/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Looper
 *  android.os.Parcelable
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 */
import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcelable;

public class ahs
extends yp<ahq>
implements acc {
    private final boolean d;
    private final yl e;
    private final Bundle f;
    private Integer g;

    public ahs(Context context, Looper looper, boolean bl2, yl yl2, acd acd2, xh.b b2, xh.c c2) {
        this(context, looper, bl2, yl2, ahs.a(yl2), b2, c2);
    }

    public ahs(Context context, Looper looper, boolean bl2, yl yl2, Bundle bundle, xh.b b2, xh.c c2) {
        super(context, looper, 44, yl2, b2, c2);
        this.d = bl2;
        this.e = yl2;
        this.f = bundle;
        this.g = yl2.f();
    }

    public static Bundle a(yl yl2) {
        acd acd2 = yl2.e();
        Integer n2 = yl2.f();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", (Parcelable)yl2.a());
        if (n2 != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", n2.intValue());
        }
        if (acd2 != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", acd2.a());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", acd2.b());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", acd2.c());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", acd2.d());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", acd2.e());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", acd2.f());
        }
        return bundle;
    }

    @Override
    protected /* synthetic */ IInterface a(IBinder iBinder) {
        return this.b(iBinder);
    }

    protected ahq b(IBinder iBinder) {
        return ahq.a.a(iBinder);
    }

    @Override
    protected String f() {
        return "com.google.android.gms.signin.service.START";
    }

    @Override
    protected String g() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override
    protected Bundle o() {
        String string2 = this.e.c();
        if (!this.l().getPackageName().equals((Object)string2)) {
            this.f.putString("com.google.android.gms.signin.internal.realClientPackageName", this.e.c());
        }
        return this.f;
    }

    @Override
    public boolean s() {
        return this.d;
    }
}

