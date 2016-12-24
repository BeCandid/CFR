/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.NoSuchElementException
 */
import java.util.NoSuchElementException;

public class aqh<T>
implements app.a<T> {
    private final apl<T> a;

    public aqh(apl<T> apl2) {
        this.a = apl2;
    }

    public static <T> aqh<T> a(apl<T> apl2) {
        return new aqh<T>(apl2);
    }

    public void a(final apq<? super T> apq2) {
        apr apr2 = new apr<T>(){
            private boolean c;
            private boolean d;
            private T e;

            @Override
            public void onCompleted() {
                if (this.c) {
                    return;
                }
                if (this.d) {
                    apq2.a(this.e);
                    return;
                }
                apq2.a((Throwable)new NoSuchElementException("Observable emitted no items"));
            }

            @Override
            public void onError(Throwable throwable) {
                apq2.a(throwable);
                this.unsubscribe();
            }

            @Override
            public void onNext(T t2) {
                if (this.d) {
                    this.c = true;
                    apq2.a((Throwable)new IllegalArgumentException("Observable emitted too many elements"));
                    this.unsubscribe();
                    return;
                }
                this.d = true;
                this.e = t2;
            }

            @Override
            public void onStart() {
                this.request(2);
            }
        };
        apq2.a(apr2);
        this.a.a(apr2);
    }

    @Override
    public /* synthetic */ void call(Object object) {
        this.a((apq)object);
    }

}

