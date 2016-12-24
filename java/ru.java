/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.NullPointerException
 *  java.lang.String
 */
public class ru
extends rm<ru> {
    private final String c;

    public ru(String string2) {
        if (string2 == null) {
            throw new NullPointerException("eventName must not be null");
        }
        this.c = this.a.a(string2);
    }

    public String b() {
        return this.c;
    }

    public String toString() {
        return "{eventName:\"" + this.c + '\"' + ", customAttributes:" + this.b + "}";
    }
}

