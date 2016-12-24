/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
import java.util.Map;

public abstract class rm<T extends rm> {
    final rn a = new rn(20, 100, akx.i());
    final rl b = new rl(this.a);

    public Map<String, Object> a() {
        return this.b.b;
    }

    public T a(String string2, String string3) {
        this.b.a(string2, string3);
        return this;
    }
}

