/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.ParcelFileDescriptor
 *  java.io.InputStream
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import java.io.InputStream;

public class jz
implements pp {
    private final Context a;
    private final po b;
    private final ps c;
    private final pt d;
    private final jx e;
    private final d f;
    private a g;

    public jz(Context context, po po2, ps ps2) {
        super(context, po2, ps2, new pt(), new pl());
    }

    /*
     * Enabled aggressive block sorting
     */
    jz(Context context, final po po2, ps ps2, pt pt2, pl pl2) {
        this.a = context.getApplicationContext();
        this.b = po2;
        this.c = ps2;
        this.d = pt2;
        this.e = jx.a(context);
        this.f = new d();
        pk pk2 = pl2.a(context, new e(pt2));
        if (ri.c()) {
            new Handler(Looper.getMainLooper()).post(new Runnable(){

                public void run() {
                    po2.a(jz.this);
                }
            });
        } else {
            po2.a(this);
        }
        po2.a(pk2);
    }

    private <T> ju<T> a(Class<T> class_) {
        mr<T, InputStream> mr2 = jx.a(class_, this.a);
        mr<T, ParcelFileDescriptor> mr3 = jx.b(class_, this.a);
        if (class_ != null && mr2 == null && mr3 == null) {
            throw new IllegalArgumentException("Unknown type " + class_ + ". You must provide a Model of a type for" + " which there is a registered ModelLoader, if you are using a custom model, you must first call" + " Glide#register with a ModelLoaderFactory for your custom model class");
        }
        return this.f.a(new ju<T>(class_, mr2, mr3, this.a, this.e, this.d, this.b, this.f));
    }

    private static <T> Class<T> c(T t2) {
        if (t2 != null) {
            return t2.getClass();
        }
        return null;
    }

    public <T> ju<T> a(T t2) {
        return (ju)super.a((T)jz.c(t2)).a((Class<T>)t2);
    }

    public ju<String> a(String string2) {
        return (ju)this.d().a(string2);
    }

    public <A, T> b<A, T> a(mr<A, T> mr2, Class<T> class_) {
        return (jz)this.new b<A, T>(mr2, class_);
    }

    public <T> c<T> a(ng<T> ng2) {
        return (jz)this.new c(ng2);
    }

    public void a() {
        this.e.h();
    }

    public void a(int n2) {
        this.e.a(n2);
    }

    public void b() {
        ri.a();
        this.d.a();
    }

    public void c() {
        ri.a();
        this.d.b();
    }

    public ju<String> d() {
        return this.a(String.class);
    }

    @Override
    public void onDestroy() {
        this.d.c();
    }

    @Override
    public void onStart() {
        this.c();
    }

    @Override
    public void onStop() {
        this.b();
    }

    public static interface a {
        public <T> void a(jv<T, ?, ?, ?> var1);
    }

    public final class b<A, T> {
        private final mr<A, T> b;
        private final Class<T> c;

        b(mr<A, T> mr2, Class<T> class_) {
            this.b = mr2;
            this.c = class_;
        }

        public b<A, T> a(A a2) {
            return (b)this.new a(a2);
        }

        public final class a {
            private final A b;
            private final Class<A> c;
            private final boolean d;

            a(A a2) {
                this.d = true;
                this.b = a2;
                this.c = jz.c(a2);
            }

            public <Z> jw<A, T, Z> a(Class<Z> class_) {
                jw jw2 = jz.this.f.a(new jw(jz.this.a, jz.this.e, this.c, b.this.b, b.this.c, class_, jz.this.d, jz.this.b, jz.this.f));
                if (this.d) {
                    jw2.b(this.b);
                }
                return jw2;
            }
        }

    }

    public final class c<T> {
        private final mr<T, InputStream> b;

        c(mr<T, InputStream> mr2) {
            this.b = mr2;
        }

        public ju<T> a(Class<T> class_) {
            return jz.this.f.a(new ju<T>(class_, this.b, null, jz.this.a, jz.this.e, jz.this.d, jz.this.b, jz.this.f));
        }

        public ju<T> a(T t2) {
            return (ju)this.a((T)jz.c(t2)).a((Class)t2);
        }
    }

    class d {
        d() {
        }

        public <A, X extends jv<A, ?, ?, ?>> X a(X x2) {
            if (jz.this.g != null) {
                jz.this.g.a(x2);
            }
            return x2;
        }
    }

    static class e
    implements pk.a {
        private final pt a;

        public e(pt pt2) {
            this.a = pt2;
        }

        @Override
        public void a(boolean bl2) {
            if (bl2) {
                this.a.d();
            }
        }
    }

}

