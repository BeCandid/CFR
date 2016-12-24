/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  java.lang.Object
 *  java.lang.Runnable
 */
import android.os.Handler;
import com.facebook.GraphRequest;

public class uw {
    private final GraphRequest a;
    private final Handler b;
    private final long c;
    private long d;
    private long e;
    private long f;

    uw(Handler handler, GraphRequest graphRequest) {
        this.a = graphRequest;
        this.b = handler;
        this.c = ul.h();
    }

    /*
     * Enabled aggressive block sorting
     */
    void a() {
        if (this.d > this.e) {
            GraphRequest.b b2 = this.a.g();
            if (this.f > 0 && b2 instanceof GraphRequest.e) {
                final long l2 = this.d;
                final long l3 = this.f;
                final GraphRequest.e e2 = (GraphRequest.e)b2;
                if (this.b == null) {
                    e2.a(l2, l3);
                } else {
                    this.b.post(new Runnable(){

                        public void run() {
                            e2.a(l2, l3);
                        }
                    });
                }
                this.e = this.d;
            }
        }
    }

    void a(long l2) {
        this.d = l2 + this.d;
        if (this.d >= this.e + this.c || this.d >= this.f) {
            this.a();
        }
    }

    void b(long l2) {
        this.f = l2 + this.f;
    }

}

