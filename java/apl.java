/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.concurrent.TimeUnit
 *  rx.exceptions.OnErrorNotImplementedException
 *  rx.internal.operators.OperatorMerge
 *  rx.internal.operators.OperatorZip
 *  rx.internal.util.ScalarSynchronousObservable
 *  rx.schedulers.Schedulers
 */
import java.util.concurrent.TimeUnit;
import rx.exceptions.OnErrorNotImplementedException;
import rx.internal.operators.OperatorMerge;
import rx.internal.operators.OperatorZip;
import rx.internal.util.ScalarSynchronousObservable;
import rx.schedulers.Schedulers;

public class apl<T> {
    static final asi b = ask.a().c();
    final a<T> a;

    public apl(a<T> a2) {
        this.a = a2;
    }

    public static apl<Long> a(long l2, TimeUnit timeUnit) {
        return apl.a(l2, timeUnit, Schedulers.computation());
    }

    public static apl<Long> a(long l2, TimeUnit timeUnit, apo apo2) {
        return apl.a(new aqi(l2, timeUnit, apo2));
    }

    public static <T> apl<T> a(a<T> a2) {
        return new apl<T>(b.a(a2));
    }

    public static <T> apl<T> a(apl<? extends apl<? extends T>> apl2) {
        if (apl2.getClass() == ScalarSynchronousObservable.class) {
            return ((ScalarSynchronousObservable)apl2).e(arb.a());
        }
        return apl2.a((b<R, apl<T>>)OperatorMerge.a((boolean)false));
    }

    public static <T1, T2, R> apl<R> a(apl<? extends T1> apl2, apl<? extends T2> apl3, aqd<? super T1, ? super T2, ? extends R> aqd2) {
        return apl.a(new apl[]{apl2, apl3}).a((b<R, apl[]>)new OperatorZip(aqd2));
    }

    public static <T> apl<T> a(T t2) {
        return ScalarSynchronousObservable.b(t2);
    }

    public static <T> apl<T> a(Throwable throwable) {
        return new c(throwable);
    }

    private static <T> aps a(apr<? super T> apr2, apl<T> apl2) {
        if (apr2 == null) {
            throw new IllegalArgumentException("observer can not be null");
        }
        if (apl2.a == null) {
            throw new IllegalStateException("onSubscribe function can not be null.");
        }
        apr2.onStart();
        if (!(apr2 instanceof ase)) {
            apr2 = new ase<T>(apr2);
        }
        try {
            b.a(apl2, apl2.a).call(apr2);
            aps aps2 = b.a(apr2);
            return aps2;
        }
        catch (Throwable var2_3) {
            apx.a(var2_3);
            try {
                apr2.onError(b.a(var2_3));
            }
            catch (Throwable var3_4) {
                apx.a(var3_4);
                RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + var2_3.getMessage() + "] and then again while trying to pass to onError.", var3_4);
                b.a((Throwable)runtimeException);
                throw runtimeException;
            }
            return asy.b();
        }
    }

    public final apl<T> a(long l2) {
        return this.a(new aqn(l2));
    }

    public final <R> apl<R> a(final b<? extends R, ? super T> b2) {
        return new apl<T>(new a<R>(){

            /*
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            public void a(apr<? super R> apr2) {
                apr apr3 = (apr)apl.b.a(b2).call(apr2);
                {
                    catch (Throwable throwable) {
                        apx.a(throwable);
                        apr2.onError(throwable);
                        return;
                    }
                }
                try {
                    apr3.onStart();
                    apl.this.a.call((Object)apr3);
                    return;
                }
                catch (Throwable var4_3) {
                    apx.a(var4_3);
                    apr3.onError(var4_3);
                    return;
                }
            }

            @Override
            public /* synthetic */ void call(Object object) {
                this.a((apr)object);
            }
        });
    }

    public final apl<T> a(apo apo2) {
        if (this instanceof ScalarSynchronousObservable) {
            return ((ScalarSynchronousObservable)this).c(apo2);
        }
        return this.a(new aqm(apo2, false));
    }

    public final apl<T> a(final apz<Throwable> apz2) {
        return this.a(new aqj(new apm<T>(){

            @Override
            public final void onCompleted() {
            }

            @Override
            public final void onError(Throwable throwable) {
                apz2.call(throwable);
            }

            @Override
            public final void onNext(T t2) {
            }
        }));
    }

    public final apl<T> a(aqc<? super T, Boolean> aqc2) {
        return this.a((b<? extends R, ? super T>)new aqk<T>(aqc2));
    }

    public app<T> a() {
        return new app(aqh.a(this));
    }

    public final aps a(apr<? super T> apr2) {
        try {
            apr2.onStart();
            b.a(this, this.a).call(apr2);
            aps aps2 = b.a(apr2);
            return aps2;
        }
        catch (Throwable var2_3) {
            apx.a(var2_3);
            try {
                apr2.onError(b.a(var2_3));
            }
            catch (Throwable var3_4) {
                apx.a(var3_4);
                RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + var2_3.getMessage() + "] and then again while trying to pass to onError.", var3_4);
                b.a((Throwable)runtimeException);
                throw runtimeException;
            }
            return asy.b();
        }
    }

    public final apl<T> b(apo apo2) {
        if (this instanceof ScalarSynchronousObservable) {
            return ((ScalarSynchronousObservable)this).c(apo2);
        }
        return apl.a(new aqp(this, apo2));
    }

    public final <R> apl<R> b(aqc<? super T, ? extends apl<? extends R>> aqc2) {
        if (this.getClass() == ScalarSynchronousObservable.class) {
            return ((ScalarSynchronousObservable)this).e(aqc2);
        }
        return apl.a(this.c(aqc2));
    }

    public final aps b(apr<? super T> apr2) {
        return apl.a(apr2, this);
    }

    public final aps b(final apz<? super T> apz2) {
        if (apz2 == null) {
            throw new IllegalArgumentException("onNext can not be null");
        }
        return this.b(new apr<T>(){

            @Override
            public final void onCompleted() {
            }

            @Override
            public final void onError(Throwable throwable) {
                throw new OnErrorNotImplementedException(throwable);
            }

            @Override
            public final void onNext(T t2) {
                apz2.call(t2);
            }
        });
    }

    public final <R> apl<R> c(aqc<? super T, ? extends R> aqc2) {
        return this.a((b<? extends R, ? super T>)new aql<T, R>(aqc2));
    }

    public final apl<T> d(aqc<Throwable, ? extends T> aqc2) {
        return this.a((b<? extends R, ? super T>)aqo.a(aqc2));
    }

    public static interface a<T>
    extends apz<apr<? super T>> {
    }

    public static interface b<R, T>
    extends aqc<apr<? super R>, apr<? super T>> {
    }

    static class c<T>
    extends apl<T> {
        public c(Throwable throwable) {
            super(new a<T>(){

                public void a(apr<? super T> apr2) {
                    apr2.onError(Throwable.this);
                }

                @Override
                public /* synthetic */ void call(Object object) {
                    this.a((apr)object);
                }
            });
        }

    }

}

