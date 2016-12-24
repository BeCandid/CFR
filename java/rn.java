/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Locale
 *  java.util.Map
 */
import java.util.Locale;
import java.util.Map;

class rn {
    final int a;
    final int b;
    boolean c;

    public rn(int n2, int n3, boolean bl2) {
        this.a = n2;
        this.b = n3;
        this.c = bl2;
    }

    private void a(RuntimeException runtimeException) {
        if (this.c) {
            throw runtimeException;
        }
        akx.h().e("Answers", "Invalid user input detected", (Throwable)runtimeException);
    }

    public String a(String string2) {
        if (string2.length() > this.b) {
            Locale locale = Locale.US;
            Object[] arrobject = new Object[]{this.b};
            super.a((RuntimeException)new IllegalArgumentException(String.format((Locale)locale, (String)"String is too long, truncating to %d characters", (Object[])arrobject)));
            string2 = string2.substring(0, this.b);
        }
        return string2;
    }

    public boolean a(Object object, String string2) {
        if (object == null) {
            super.a((RuntimeException)new NullPointerException(string2 + " must not be null"));
            return true;
        }
        return false;
    }

    public boolean a(Map<String, Object> map, String string2) {
        if (map.size() >= this.a && !map.containsKey((Object)string2)) {
            Locale locale = Locale.US;
            Object[] arrobject = new Object[]{this.a};
            super.a((RuntimeException)new IllegalArgumentException(String.format((Locale)locale, (String)"Limit of %d attributes reached, skipping attribute", (Object[])arrobject)));
            return true;
        }
        return false;
    }
}

