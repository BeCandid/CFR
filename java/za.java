/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Iterator
 */
import java.util.Iterator;

public class za {
    private final String a;

    private za(String string2) {
        this.a = string2;
    }

    public static za a(String string2) {
        return new za(string2);
    }

    CharSequence a(Object object) {
        if (object instanceof CharSequence) {
            return (CharSequence)object;
        }
        return object.toString();
    }

    public final String a(Iterable<?> iterable) {
        return this.a(new StringBuilder(), iterable).toString();
    }

    public final StringBuilder a(StringBuilder stringBuilder, Iterable<?> iterable) {
        Iterator iterator = iterable.iterator();
        if (iterator.hasNext()) {
            stringBuilder.append(this.a(iterator.next()));
            while (iterator.hasNext()) {
                stringBuilder.append(this.a);
                stringBuilder.append(this.a(iterator.next()));
            }
        }
        return stringBuilder;
    }
}

