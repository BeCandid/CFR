/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 */
public final class aqf {
    public static <T0, T1, R> aqe<R> a(final aqd<? super T0, ? super T1, ? extends R> aqd2) {
        return new aqe<R>(){

            @Override
            public /* varargs */ R a(Object ... arrobject) {
                if (arrobject.length != 2) {
                    throw new RuntimeException("Func2 expecting 2 arguments.");
                }
                return aqd2.call(arrobject[0], arrobject[1]);
            }
        };
    }

}

