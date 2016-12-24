/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 */
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

public class ij
extends ResponseBody {
    private final ResponseBody a;
    private final a b;
    private BufferedSource c;

    public ij(ResponseBody responseBody, a a2) {
        this.a = responseBody;
        this.b = a2;
    }

    private Source a(Source source) {
        return new ForwardingSource(source){
            long a;

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public long read(Buffer buffer, long l2) throws IOException {
                long l3 = super.read(buffer, l2);
                long l4 = this.a;
                long l5 = l3 != -1 ? l3 : 0;
                this.a = l5 + l4;
                a a2 = ij.this.b;
                long l6 = this.a;
                long l7 = ij.this.a.contentLength();
                boolean bl2 = l3 == -1;
                a2.a(l6, l7, bl2);
                return l3;
            }
        };
    }

    @Override
    public long contentLength() {
        return this.a.contentLength();
    }

    @Override
    public MediaType contentType() {
        return this.a.contentType();
    }

    @Override
    public BufferedSource source() {
        if (this.c == null) {
            this.c = Okio.buffer(this.a(this.a.source()));
        }
        return this.c;
    }

    public static interface a {
        public void a(long var1, long var3, boolean var5);
    }

}

