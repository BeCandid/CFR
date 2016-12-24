/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.util.Arrays
 *  java.util.Collection
 *  rx.exceptions.CompositeException
 */
import java.util.Arrays;
import java.util.Collection;
import rx.exceptions.CompositeException;

public class aqj<T>
implements apl.b<T, T> {
    final apm<? super T> a;

    public aqj(apm<? super T> apm2) {
        this.a = apm2;
    }

    public apr<? super T> a(final apr<? super T> apr2) {
        return new apr<T>(apr2){
            private boolean c;

            @Override
            public void onCompleted() {
                if (this.c) {
                    return;
                }
                try {
                    aqj.this.a.onCompleted();
                }
                catch (Throwable var1_1) {
                    apx.a(var1_1, this);
                    return;
                }
                this.c = true;
                apr2.onCompleted();
            }

            @Override
            public void onError(Throwable throwable) {
                apx.a(throwable);
                if (this.c) {
                    return;
                }
                this.c = true;
                try {
                    aqj.this.a.onError(throwable);
                }
                catch (Throwable var2_2) {
                    apx.a(var2_2);
                    apr2.onError((Throwable)new CompositeException((Collection)Arrays.asList((Object[])new Throwable[]{throwable, var2_2})));
                    return;
                }
                apr2.onError(throwable);
            }

            @Override
            public void onNext(T t2) {
                if (this.c) {
                    return;
                }
                try {
                    aqj.this.a.onNext(t2);
                }
                catch (Throwable var2_2) {
                    apx.a(var2_2, this, t2);
                    return;
                }
                apr2.onNext(t2);
            }
        };
    }

    @Override
    public /* synthetic */ Object call(Object object) {
        return this.a((apr)object);
    }

}

