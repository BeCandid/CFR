/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.content.Context
 *  android.view.View
 *  com.google.android.gms.common.api.Scope
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Set
 */
import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class yl {
    private final Account a;
    private final Set<Scope> b;
    private final Set<Scope> c;
    private final Map<xf<?>, a> d;
    private final int e;
    private final View f;
    private final String g;
    private final String h;
    private final acd i;
    private Integer j;

    /*
     * Enabled aggressive block sorting
     */
    public yl(Account account, Set<Scope> set, Map<xf<?>, a> map, int n2, View view, String string2, String string3, acd acd2) {
        this.a = account;
        Set set2 = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        this.b = set2;
        if (map == null) {
            map = Collections.EMPTY_MAP;
        }
        this.d = map;
        this.f = view;
        this.e = n2;
        this.g = string2;
        this.h = string3;
        this.i = acd2;
        HashSet hashSet = new HashSet(this.b);
        Iterator iterator = this.d.values().iterator();
        do {
            if (!iterator.hasNext()) {
                this.c = Collections.unmodifiableSet((Set)hashSet);
                return;
            }
            hashSet.addAll(((a)iterator.next()).a);
        } while (true);
    }

    public static yl a(Context context) {
        return new xh.a(context).a();
    }

    public Account a() {
        return this.a;
    }

    public Set<Scope> b() {
        return this.c;
    }

    public String c() {
        return this.g;
    }

    public String d() {
        return this.h;
    }

    public acd e() {
        return this.i;
    }

    public Integer f() {
        return this.j;
    }

    public static final class a {
        public final Set<Scope> a;
    }

}

