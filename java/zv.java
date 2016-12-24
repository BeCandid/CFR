/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.regex.Pattern
 */
import java.util.regex.Pattern;

public class zv {
    private static final Pattern a = Pattern.compile((String)"\\$\\{(.*?)\\}");

    public static boolean a(String string2) {
        if (string2 == null || yk.a.b(string2)) {
            return true;
        }
        return false;
    }
}

