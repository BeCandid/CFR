/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.IBinder
 *  android.view.View
 *  com.google.android.gms.common.api.Scope
 *  com.google.android.gms.common.internal.SignInButtonConfig
 *  com.google.android.gms.dynamic.zzg
 *  com.google.android.gms.dynamic.zzg$zza
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.SignInButtonConfig;
import com.google.android.gms.dynamic.zzg;

public final class yd
extends zzg<yz> {
    private static final yd a = new yd();

    private yd() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View a(Context context, int n2, int n3, Scope[] arrscope) throws zzg.zza {
        return a.b(context, n2, n3, arrscope);
    }

    private View b(Context context, int n2, int n3, Scope[] arrscope) throws zzg.zza {
        try {
            SignInButtonConfig signInButtonConfig = new SignInButtonConfig(n2, n3, arrscope);
            aag aag2 = aah.a(context);
            View view = (View)aah.a(((yz)this.a(context)).a(aag2, signInButtonConfig));
            return view;
        }
        catch (Exception var6_8) {
            throw new zzg.zza(new StringBuilder(64).append("Could not get button with size ").append(n2).append(" and color ").append(n3).toString(), (Throwable)var6_8);
        }
    }

    public yz a(IBinder iBinder) {
        return yz.a.a(iBinder);
    }

    public /* synthetic */ Object b(IBinder iBinder) {
        return this.a(iBinder);
    }
}

