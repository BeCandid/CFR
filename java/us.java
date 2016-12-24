/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  java.io.OutputStream
 *  java.lang.Object
 *  java.util.HashMap
 *  java.util.Map
 */
import android.os.Handler;
import com.facebook.GraphRequest;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class us
extends OutputStream
implements uv {
    private final Map<GraphRequest, uw> a = new HashMap();
    private final Handler b;
    private GraphRequest c;
    private uw d;
    private int e;

    public us(Handler handler) {
        this.b = handler;
    }

    public int a() {
        return this.e;
    }

    public void a(long l2) {
        if (this.d == null) {
            this.d = new uw(this.b, this.c);
            this.a.put((Object)this.c, (Object)this.d);
        }
        this.d.b(l2);
        this.e = (int)(l2 + (long)this.e);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void a(GraphRequest graphRequest) {
        this.c = graphRequest;
        uw uw2 = graphRequest != null ? (uw)this.a.get((Object)graphRequest) : null;
        this.d = uw2;
    }

    public Map<GraphRequest, uw> b() {
        return this.a;
    }

    public void write(int n2) {
        this.a(1);
    }

    public void write(byte[] arrby) {
        this.a(arrby.length);
    }

    public void write(byte[] arrby, int n2, int n3) {
        this.a(n3);
    }
}

