/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
public class apk {
    static final apk a = apk.a(new a(){

        public void a(b b2) {
            b2.a(asy.b());
            b2.a();
        }

        @Override
        public /* synthetic */ void call(Object object) {
            this.a((b)object);
        }
    });
    static final apk b = apk.a(new a(){

        public void a(b b2) {
            b2.a(asy.b());
        }

        @Override
        public /* synthetic */ void call(Object object) {
            this.a((b)object);
        }
    });
    static final ash c = ask.a().b();
    private final a d;

    protected apk(a a2) {
        this.d = a2;
    }

    public static apk a(a a2) {
        apk.a(a2);
        try {
            apk apk2 = new apk(a2);
            return apk2;
        }
        catch (NullPointerException var4_2) {
            throw var4_2;
        }
        catch (Throwable var3_3) {
            c.a(var3_3);
            throw apk.a(var3_3);
        }
    }

    static NullPointerException a(Throwable throwable) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(throwable);
        return nullPointerException;
    }

    static <T> T a(T t2) {
        if (t2 == null) {
            throw new NullPointerException();
        }
        return t2;
    }

    public final apk a(final apo apo2) {
        apk.a(apo2);
        return apk.a(new a(){

            public void a(final b b2) {
                final apo.a a2 = apo2.createWorker();
                a2.a(new apy(){

                    @Override
                    public void call() {
                        try {
                            apk.this.a(b2);
                            return;
                        }
                        finally {
                            a2.unsubscribe();
                        }
                    }
                });
            }

            @Override
            public /* synthetic */ void call(Object object) {
                this.a((b)object);
            }

        });
    }

    public final void a(b b2) {
        apk.a(b2);
        try {
            this.d.call((Object)b2);
            return;
        }
        catch (NullPointerException var4_2) {
            throw var4_2;
        }
        catch (Throwable var3_3) {
            c.a(var3_3);
            throw apk.a(var3_3);
        }
    }

    public static interface a
    extends apz<b> {
    }

    public static interface b {
        public void a();

        public void a(aps var1);

        public void a(Throwable var1);
    }

}

