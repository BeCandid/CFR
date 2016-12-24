/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
import java.util.Map;

public abstract class rz<T extends rz>
extends rm<T> {
    final rl c;

    public rz() {
        this.c = new rl(this.a);
    }

    public abstract String b();

    public Map<String, Object> c() {
        return this.c.b;
    }

    public String toString() {
        return "{type:\"" + this.b() + '\"' + ", predefinedAttributes:" + this.c + ", customAttributes:" + this.b + "}";
    }
}

