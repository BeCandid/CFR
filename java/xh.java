/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Looper
 *  android.view.View
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.api.Scope
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.HashSet
 *  java.util.Map
 *  java.util.Set
 *  java.util.WeakHashMap
 */
import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public abstract class xh {
    private static final Set<xh> a = Collections.newSetFromMap((Map)new WeakHashMap());

    public void a(abp abp2) {
        throw new UnsupportedOperationException();
    }

    public abstract boolean a();

    public void b(abp abp2) {
        throw new UnsupportedOperationException();
    }

    public static final class a {
        private Account a;
        private final Set<Scope> b = new HashSet();
        private final Set<Scope> c = new HashSet();
        private int d;
        private View e;
        private String f;
        private String g;
        private final Map<xf<?>, yl.a> h = new dh();
        private final Context i;
        private final Map<xf<?>, xf.a> j = new dh();
        private int k = -1;
        private Looper l;
        private xd m = xd.a();
        private xf.b<? extends acc, acd> n = acb.c;
        private final ArrayList<b> o = new ArrayList();
        private final ArrayList<c> p = new ArrayList();

        public a(Context context) {
            this.i = context;
            this.l = context.getMainLooper();
            this.f = context.getPackageName();
            this.g = context.getClass().getName();
        }

        public yl a() {
            acd acd2 = acd.a;
            if (this.j.containsKey(acb.g)) {
                acd2 = (acd)this.j.get(acb.g);
            }
            return new yl(this.a, this.b, this.h, this.d, this.e, this.f, this.g, acd2);
        }
    }

    public static interface b {
        public void a(int var1);

        public void a(Bundle var1);
    }

    public static interface c {
        public void a(ConnectionResult var1);
    }

}

