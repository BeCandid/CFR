/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
public class qm<R>
implements qk<R> {
    private static final qm<?> a = new qm<R>();
    private static final ql<?> b = new a();

    public static <R> ql<R> a() {
        return b;
    }

    public static <R> qk<R> b() {
        return a;
    }

    @Override
    public boolean a(Object object, qk.a a2) {
        return false;
    }

    public static class a<R>
    implements ql<R> {
        @Override
        public qk<R> a(boolean bl2, boolean bl3) {
            return a;
        }
    }

}

