/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Throwable
 *  rx.schedulers.Schedulers
 */
import rx.schedulers.Schedulers;

public class ix {
    private static final ix a = new ix();
    private final ast<Object, Object> b = new ass<Object, Object>(asr.b());

    public static ix a() {
        return a;
    }

    public <T> aps a(final Class<T> class_, apr<T> apr2) {
        return this.b.a(10000).a(new aqc<Object, Boolean>(){

            public Boolean a(Object object) {
                return object.getClass().equals((Object)class_);
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a(object);
            }
        }).b(Schedulers.newThread()).a(apv.a()).c(new aqc<Object, T>(){

            @Override
            public T call(Object object) {
                return (T)object;
            }
        }).a(new apz<Throwable>(){

            public void a(Throwable throwable) {
                rj.a(throwable);
            }

            @Override
            public /* synthetic */ void call(Object object) {
                this.a((Throwable)object);
            }
        }).b(apr2);
    }

    public void a(Object object) {
        this.a(object, true);
    }

    public void a(Object object, boolean bl2) {
        this.b.onNext(object);
        this.b.a(new apz<Throwable>(){

            public void a(Throwable throwable) {
                rj.a(throwable);
            }

            @Override
            public /* synthetic */ void call(Object object) {
                this.a((Throwable)object);
            }
        });
    }

}

