/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Throwable
 *  rx.internal.producers.SingleDelayedProducer
 */
import rx.internal.producers.SingleDelayedProducer;

public class app<T> {
    static final asi b = ask.a().c();
    final apl.a<T> a;

    protected app(final a<T> a2) {
        this.a = new apl.a<T>(){

            public void a(final apr<? super T> apr2) {
                final SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(apr2);
                apr2.setProducer((apn)singleDelayedProducer);
                apq apq2 = new apq<T>(){

                    @Override
                    public void a(T t2) {
                        singleDelayedProducer.a(t2);
                    }

                    @Override
                    public void a(Throwable throwable) {
                        apr2.onError(throwable);
                    }
                };
                apr2.add(apq2);
                a2.call((Object)apq2);
            }

            @Override
            public /* synthetic */ void call(Object object) {
                this.a((apr)object);
            }

        };
    }

    public static interface a<T>
    extends apz<apq<? super T>> {
    }

}

