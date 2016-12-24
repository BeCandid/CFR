/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.google.gson.internal.LinkedTreeMap
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import java.util.Set;

public final class ain
extends ail {
    private final LinkedTreeMap<String, ail> a = new LinkedTreeMap();

    private ail a(Object object) {
        if (object == null) {
            return aim.a;
        }
        return new aip(object);
    }

    public Set<Map.Entry<String, ail>> a() {
        return this.a.entrySet();
    }

    public void a(String string2, ail ail2) {
        if (ail2 == null) {
            ail2 = aim.a;
        }
        this.a.put((Object)string2, (Object)ail2);
    }

    public void a(String string2, Boolean bl2) {
        this.a(string2, super.a((Object)bl2));
    }

    public void a(String string2, String string3) {
        this.a(string2, super.a((Object)string3));
    }

    public boolean a(String string2) {
        return this.a.containsKey((Object)string2);
    }

    public ail b(String string2) {
        return (ail)this.a.get((Object)string2);
    }

    public aij c(String string2) {
        return (aij)this.a.get((Object)string2);
    }

    public ain d(String string2) {
        return (ain)this.a.get((Object)string2);
    }

    public boolean equals(Object object) {
        if (object == this || object instanceof ain && ((ain)object).a.equals(this.a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}

