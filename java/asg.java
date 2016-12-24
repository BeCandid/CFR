/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Throwable
 */
public final class asg {
    public static <T> apr<T> a(final apr<? super T> apr2) {
        return new apr<T>(apr2){

            @Override
            public void onCompleted() {
                apr2.onCompleted();
            }

            @Override
            public void onError(Throwable throwable) {
                apr2.onError(throwable);
            }

            @Override
            public void onNext(T t2) {
                apr2.onNext(t2);
            }
        };
    }

}

