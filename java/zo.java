/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 */
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zo {
    public static <T> List<T> a(T t2) {
        return Collections.singletonList(t2);
    }

    public static <K, V> Map<K, V> a() {
        return Collections.emptyMap();
    }

    public static <K, V> Map<K, V> a(K k2, V v2) {
        return Collections.singletonMap(k2, v2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static <K, V> Map<K, V> a(K[] var0_1, V[] var1) {
        var2_2 = 0;
        zo.b(var0_1, var1);
        var3_3 = var0_1.length;
        switch (var3_3) {
            default: {
                if (var3_3 > 32) break;
                var4_4 = new HashMap(var3_3);
                ** GOTO lbl15
            }
            case 0: {
                return zo.a();
            }
            case 1: {
                return zo.a(var0_1[0], var1[0]);
            }
        }
        var4_4 = new HashMap(var3_3, 1.0f);
        var2_2 = 0;
lbl15: // 3 sources:
        while (var2_2 < var3_3) {
            var4_4.put(var0_1[var2_2], var1[var2_2]);
            ++var2_2;
        }
        return Collections.unmodifiableMap((Map)var4_4);
    }

    private static <K, V> void b(K[] arrK, V[] arrV) {
        if (arrK.length != arrV.length) {
            int n2 = arrK.length;
            int n3 = arrV.length;
            throw new IllegalArgumentException(new StringBuilder(66).append("Key and values array lengths not equal: ").append(n2).append(" != ").append(n3).toString());
        }
    }
}

