/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
public final class arb {
    private static final a a = new a();

    public static <T> aqc<T, T> a() {
        return new aqc<T, T>(){

            @Override
            public T call(T t2) {
                return t2;
            }
        };
    }

    static final class a<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, R>
    implements aqb<R>,
    aqc<T0, R>,
    aqd<T0, T1, R>,
    aqe<R> {
        a() {
        }

        @Override
        public /* varargs */ R a(Object ... arrobject) {
            return null;
        }

        public R call() {
            return null;
        }

        @Override
        public R call(T0 T0) {
            return null;
        }

        @Override
        public R call(T0 T0, T1 T1) {
            return null;
        }
    }

}

