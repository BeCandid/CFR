/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Throwable
 */
public class ass<T, R>
extends ast<T, R> {
    private final asf<T> c;
    private final ast<T, R> d;

    public ass(ast<T, R> ast2) {
        super(new apl.a<R>(){

            public void a(apr<? super R> apr2) {
                ast.this.a(apr2);
            }

            @Override
            public /* synthetic */ void call(Object object) {
                this.a((apr)object);
            }
        });
        this.d = ast2;
        this.c = new asf(ast2);
    }

    @Override
    public void onCompleted() {
        this.c.onCompleted();
    }

    @Override
    public void onError(Throwable throwable) {
        this.c.onError(throwable);
    }

    @Override
    public void onNext(T t2) {
        this.c.onNext(t2);
    }

}

