/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Thread
 *  java.lang.Throwable
 */
public final class aqp<T>
implements apl.a<T> {
    final apo a;
    final apl<T> b;

    public aqp(apl<T> apl2, apo apo2) {
        this.a = apo2;
        this.b = apl2;
    }

    public void a(final apr<? super T> apr2) {
        final apo.a a2 = this.a.createWorker();
        apr2.add(a2);
        a2.a(new apy(){

            @Override
            public void call() {
                final Thread thread = Thread.currentThread();
                apr apr22 = new apr<T>(apr2){

                    @Override
                    public void onCompleted() {
                        try {
                            apr2.onCompleted();
                            return;
                        }
                        finally {
                            a2.unsubscribe();
                        }
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        try {
                            apr2.onError(throwable);
                            return;
                        }
                        finally {
                            a2.unsubscribe();
                        }
                    }

                    @Override
                    public void onNext(T t2) {
                        apr2.onNext(t2);
                    }

                    @Override
                    public void setProducer(final apn apn2) {
                        apr2.setProducer(new apn(){

                            @Override
                            public void a(final long l2) {
                                if (thread == Thread.currentThread()) {
                                    apn2.a(l2);
                                    return;
                                }
                                a2.a(new apy(){

                                    @Override
                                    public void call() {
                                        apn2.a(l2);
                                    }
                                });
                            }

                        });
                    }

                };
                aqp.this.b.a(apr22);
            }

        });
    }

    @Override
    public /* synthetic */ void call(Object object) {
        this.a((apr)object);
    }

}

