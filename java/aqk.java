/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.Throwable
 */
public final class aqk<T>
implements apl.b<T, T> {
    final aqc<? super T, Boolean> a;

    public aqk(aqc<? super T, Boolean> aqc2) {
        this.a = aqc2;
    }

    public apr<? super T> a(final apr<? super T> apr2) {
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
                try {
                    if (aqk.this.a.call(t2).booleanValue()) {
                        apr2.onNext(t2);
                        return;
                    }
                    this.request(1);
                    return;
                }
                catch (Throwable var2_2) {
                    apx.a(var2_2, apr2, t2);
                    return;
                }
            }
        };
    }

    @Override
    public /* synthetic */ Object call(Object object) {
        return this.a((apr)object);
    }

}

