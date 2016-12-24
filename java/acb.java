/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Looper
 *  com.google.android.gms.common.api.Scope
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;

public final class acb {
    public static final xf.g<ahs> a = new xf.g();
    public static final xf.g<ahs> b = new xf.g();
    public static final xf.b<ahs, acd> c = new xf.b<ahs, acd>(){

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public ahs a(Context context, Looper looper, yl yl2, acd acd2, xh.b b2, xh.c c2) {
            acd acd3;
            if (acd2 == null) {
                acd3 = acd.a;
                do {
                    return new ahs(context, looper, true, yl2, acd3, b2, c2);
                    break;
                } while (true);
            }
            acd3 = acd2;
            return new ahs(context, looper, true, yl2, acd3, b2, c2);
        }
    };
    static final xf.b<ahs, a> d = new xf.b<ahs, a>(){

        @Override
        public ahs a(Context context, Looper looper, yl yl2, a a2, xh.b b2, xh.c c2) {
            return new ahs(context, looper, false, yl2, a2.a(), b2, c2);
        }
    };
    public static final Scope e = new Scope("profile");
    public static final Scope f = new Scope("email");
    public static final xf<acd> g = new xf<acd>("SignIn.API", c, a);
    public static final xf<a> h = new xf<a>("SignIn.INTERNAL_API", d, b);

    public static class a
    implements xf.a.a {
        public Bundle a() {
            return null;
        }
    }

}

