/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Throwable
 */
public final class aql<T, R>
implements apl.b<R, T> {
    final aqc<? super T, ? extends R> a;

    public aql(aqc<? super T, ? extends R> aqc2) {
        this.a = aqc2;
    }

    public apr<? super T> a(final apr<? super R> apr2) {
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
                    apr2.onNext(aql.this.a.call(t2));
                    return;
                }
                catch (Throwable var2_2) {
                    apx.a(var2_2, this, t2);
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

