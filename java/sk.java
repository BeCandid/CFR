/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.String
 */
public class sk
extends rz<sk> {
    public sk a(String string2) {
        this.c.a("method", string2);
        return this;
    }

    public sk a(boolean bl2) {
        this.c.a("success", Boolean.toString((boolean)bl2));
        return this;
    }

    @Override
    String b() {
        return "signUp";
    }
}

