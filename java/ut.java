/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  java.io.FilterOutputStream
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 */
import android.os.Handler;
import com.facebook.GraphRequest;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ut
extends FilterOutputStream
implements uv {
    private final Map<GraphRequest, uw> a;
    private final un b;
    private final long c;
    private long d;
    private long e;
    private long f;
    private uw g;

    public ut(OutputStream outputStream, un un2, Map<GraphRequest, uw> map, long l2) {
        super(outputStream);
        this.b = un2;
        this.a = map;
        this.f = l2;
        this.c = ul.h();
    }

    private void a() {
        if (this.d > this.e) {
            for (un.a a2 : this.b.e()) {
                if (!(a2 instanceof un.b)) continue;
                Handler handler = this.b.c();
                final un.b b2 = (un.b)a2;
                if (handler == null) {
                    b2.a(this.b, this.d, this.f);
                    continue;
                }
                handler.post(new Runnable(){

                    public void run() {
                        b2.a(ut.this.b, ut.this.d, ut.this.f);
                    }
                });
            }
            this.e = this.d;
        }
    }

    private void a(long l2) {
        if (this.g != null) {
            this.g.a(l2);
        }
        this.d = l2 + this.d;
        if (this.d >= this.e + this.c || this.d >= this.f) {
            super.a();
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void a(GraphRequest graphRequest) {
        uw uw2 = graphRequest != null ? (uw)this.a.get((Object)graphRequest) : null;
        this.g = uw2;
    }

    public void close() throws IOException {
        super.close();
        Iterator iterator = this.a.values().iterator();
        while (iterator.hasNext()) {
            ((uw)iterator.next()).a();
        }
        this.a();
    }

    public void write(int n2) throws IOException {
        this.out.write(n2);
        super.a(1);
    }

    public void write(byte[] arrby) throws IOException {
        this.out.write(arrby);
        super.a(arrby.length);
    }

    public void write(byte[] arrby, int n2, int n3) throws IOException {
        this.out.write(arrby, n2, n3);
        super.a(n3);
    }

}

