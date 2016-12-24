/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Log
 *  com.bumptech.glide.Priority
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.net.HttpURLConnection
 *  java.net.URI
 *  java.net.URISyntaxException
 *  java.net.URL
 *  java.net.URLConnection
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.Priority;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.Set;

public class kx
implements ku<InputStream> {
    private static final b a = new a(null);
    private final mj b;
    private final b c;
    private HttpURLConnection d;
    private InputStream e;
    private volatile boolean f;

    public kx(mj mj2) {
        super(mj2, a);
    }

    kx(mj mj2, b b2) {
        this.b = mj2;
        this.c = b2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private InputStream a(HttpURLConnection httpURLConnection) throws IOException {
        if (TextUtils.isEmpty((CharSequence)httpURLConnection.getContentEncoding())) {
            int n2 = httpURLConnection.getContentLength();
            this.e = rc.a(httpURLConnection.getInputStream(), n2);
            do {
                return this.e;
                break;
            } while (true);
        }
        if (Log.isLoggable((String)"HttpUrlFetcher", (int)3)) {
            Log.d((String)"HttpUrlFetcher", (String)("Got non empty content encoding: " + httpURLConnection.getContentEncoding()));
        }
        this.e = httpURLConnection.getInputStream();
        return this.e;
    }

    private InputStream a(URL uRL, int n2, URL uRL2, Map<String, String> map) throws IOException {
        if (n2 >= 5) {
            throw new IOException("Too many (> 5) redirects!");
        }
        if (uRL2 != null) {
            try {
                if (uRL.toURI().equals((Object)uRL2.toURI())) {
                    throw new IOException("In re-direct loop");
                }
            }
            catch (URISyntaxException var9_5) {
                // empty catch block
            }
        }
        this.d = this.c.a(uRL);
        for (Map.Entry entry : map.entrySet()) {
            this.d.addRequestProperty((String)entry.getKey(), (String)entry.getValue());
        }
        this.d.setConnectTimeout(2500);
        this.d.setReadTimeout(2500);
        this.d.setUseCaches(false);
        this.d.setDoInput(true);
        this.d.connect();
        if (this.f) {
            return null;
        }
        int n3 = this.d.getResponseCode();
        if (n3 / 100 == 2) {
            return super.a(this.d);
        }
        if (n3 / 100 == 3) {
            String string2 = this.d.getHeaderField("Location");
            if (TextUtils.isEmpty((CharSequence)string2)) {
                throw new IOException("Received empty or null redirect url");
            }
            return super.a(new URL(uRL, string2), n2 + 1, uRL, map);
        }
        if (n3 == -1) {
            throw new IOException("Unable to retrieve response code from HttpUrlConnection.");
        }
        throw new IOException("Request failed " + n3 + ": " + this.d.getResponseMessage());
    }

    public InputStream a(Priority priority) throws Exception {
        return super.a(this.b.a(), 0, null, this.b.c());
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a() {
        if (this.e != null) {
            this.e.close();
        }
lbl4: // 4 sources:
        do {
            if (this.d != null) {
                this.d.disconnect();
            }
            return;
            break;
        } while (true);
        catch (IOException var1_1) {
            ** continue;
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
        this.f = true;
    }

    static class a
    implements b {
        private a() {
        }

        /* synthetic */ a( var1) {
        }

        @Override
        public HttpURLConnection a(URL uRL) throws IOException {
            return (HttpURLConnection)uRL.openConnection();
        }
    }

    static interface b {
        public HttpURLConnection a(URL var1) throws IOException;
    }

}

