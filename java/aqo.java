/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Throwable
 */
public final class aqo<T>
implements apl.b<T, T> {
    final aqc<Throwable, ? extends apl<? extends T>> a;

    public aqo(aqc<Throwable, ? extends apl<? extends T>> aqc2) {
        this.a = aqc2;
    }

    public static <T> aqo<T> a(final aqc<Throwable, ? extends T> aqc2) {
        return new aqo<T>(new aqc<Throwable, apl<? extends T>>(){

            public apl<? extends T> a(Throwable throwable) {
                return apl.a(aqc2.call(throwable));
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((Throwable)object);
            }
        });
    }

    public apr<? super T> a(final apr<? super T> apr2) {
        final aqq aqq2 = new aqq();
        final asx asx2 = new asx();
        apr apr3 = new apr<T>(){
            long a;
            private boolean f;

            @Override
            public void onCompleted() {
                if (this.f) {
                    return;
                }
                this.f = true;
                apr2.onCompleted();
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void onError(Throwable throwable) {
                if (this.f) {
                    apx.a(throwable);
                    ask.a().b().a(throwable);
                    return;
                }
                this.f = true;
                try {
                    this.unsubscribe();
                    apr apr22 = new apr<T>(){

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

                        @Override
                        public void setProducer(apn apn2) {
                            aqq2.a(apn2);
                        }
                    };
                    asx2.a(apr22);
                    long l2 = this.a;
                    if (l2 != 0) {
                        aqq2.b(l2);
                    }
                    aqo.this.a.call(throwable).a(apr22);
                    return;
                }
                catch (Throwable var2_4) {
                    apx.a(var2_4, apr2);
                    return;
                }
            }

            @Override
            public void onNext(T t2) {
                if (this.f) {
                    return;
                }
                this.a = 1 + this.a;
                apr2.onNext(t2);
            }

            @Override
            public void setProducer(apn apn2) {
                aqq2.a(apn2);
            }

        };
        asx2.a(apr3);
        apr2.add(asx2);
        apr2.setProducer(aqq2);
        return apr3;
    }

    @Override
    public /* synthetic */ Object call(Object object) {
        return this.a((apr)object);
    }

}

