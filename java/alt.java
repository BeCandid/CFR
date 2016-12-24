/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
public abstract class alt {
    private final String a;
    private final String b;

    public alt(String string2, String string3) {
        this.a = string2;
        this.b = string3;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public static class a
    extends alt {
        public a(String string2, String string3) {
            super(string2, string3);
        }
    }

    public static class b
    extends alt {
        public b(String string2, String string3) {
            super(string2, string3);
        }
    }

}

