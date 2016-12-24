/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
public class tw {
    public static final tw a = new tw();
    public final String b;
    public final String c;
    public final String d;

    public tw() {
        this(null, null, null);
    }

    public tw(String string2, String string3, String string4) {
        this.b = string2;
        this.c = string3;
        this.d = string4;
    }

    public boolean a() {
        if (this.b == null && this.c == null && this.d == null) {
            return true;
        }
        return false;
    }
}

