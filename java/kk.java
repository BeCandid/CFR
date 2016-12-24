/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.Priority
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
import com.bumptech.glide.Priority;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;
import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class kk
implements ku<InputStream> {
    private final Call.Factory a;
    private final mj b;
    private InputStream c;
    private ResponseBody d;
    private volatile Call e;

    public kk(Call.Factory factory, mj mj2) {
        this.a = factory;
        this.b = mj2;
    }

    public InputStream a(Priority priority) throws Exception {
        Request.Builder builder = new Request.Builder().url(this.b.b());
        for (Map.Entry entry : this.b.c().entrySet()) {
            builder.addHeader((String)entry.getKey(), (String)entry.getValue());
        }
        Request request = builder.build();
        this.e = this.a.newCall(request);
        Response response = this.e.execute();
        this.d = response.body();
        if (!response.isSuccessful()) {
            throw new IOException("Request failed with code: " + response.code());
        }
        long l2 = this.d.contentLength();
        this.c = rc.a(this.d.byteStream(), l2);
        return this.c;
    }

    /*
     * Unable to fully structure code
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void a() {
        try {
            if (this.c != null) {
                this.c.close();
            }
lbl4: // 4 sources:
            do {
                if (this.d == null) return;
                break;
            } while (true);
        }
        catch (IOException var1_1) {
            ** continue;
        }
        {
            this.d.close();
            return;
        }
    }

    @Override
    public /* synthetic */ Object b(Priority priority) throws Exception {
        return this.a(priority);
    }

    @Override
    public String b() {
        return this.b.d();
    }

    @Override
    public void c() {
        Call call = this.e;
        if (call != null) {
            call.cancel();
        }
    }
}

