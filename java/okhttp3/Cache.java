/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.File
 *  java.io.Flushable
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.IllegalStateException
 *  java.lang.Long
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.security.cert.Certificate
 *  java.security.cert.CertificateEncodingException
 *  java.security.cert.CertificateException
 *  java.security.cert.CertificateFactory
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 *  java.util.NoSuchElementException
 */
package okhttp3;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.CipherSuite;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.TlsVersion;
import okhttp3.internal.DiskLruCache;
import okhttp3.internal.InternalCache;
import okhttp3.internal.Util;
import okhttp3.internal.http.CacheRequest;
import okhttp3.internal.http.CacheStrategy;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.OkHeaders;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.io.FileSystem;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

public final class Cache
implements Closeable,
Flushable {
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201105;
    private final DiskLruCache cache;
    private int hitCount;
    final InternalCache internalCache;
    private int networkCount;
    private int requestCount;
    private int writeAbortCount;
    private int writeSuccessCount;

    public Cache(File file, long l2) {
        super(file, l2, FileSystem.SYSTEM);
    }

    Cache(File file, long l2, FileSystem fileSystem) {
        this.internalCache = new InternalCache(){

            @Override
            public Response get(Request request) throws IOException {
                return Cache.this.get(request);
            }

            @Override
            public CacheRequest put(Response response) throws IOException {
                return Cache.this.put(response);
            }

            @Override
            public void remove(Request request) throws IOException {
                Cache.this.remove(request);
            }

            @Override
            public void trackConditionalCacheHit() {
                Cache.this.trackConditionalCacheHit();
            }

            @Override
            public void trackResponse(CacheStrategy cacheStrategy) {
                Cache.this.trackResponse(cacheStrategy);
            }

            @Override
            public void update(Response response, Response response2) throws IOException {
                Cache.this.update(response, response2);
            }
        };
        this.cache = DiskLruCache.create(fileSystem, file, 201105, 2, l2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void abortQuietly(DiskLruCache.Editor editor) {
        if (editor == null) return;
        try {
            editor.abort();
            return;
        }
        catch (IOException var2_2) {
            return;
        }
    }

    static /* synthetic */ int access$808(Cache cache) {
        int n2 = cache.writeSuccessCount;
        cache.writeSuccessCount = n2 + 1;
        return n2;
    }

    static /* synthetic */ int access$908(Cache cache) {
        int n2 = cache.writeAbortCount;
        cache.writeAbortCount = n2 + 1;
        return n2;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private CacheRequest put(Response response) throws IOException {
        String string2 = response.request().method();
        if (HttpMethod.invalidatesCache(response.request().method())) {
            super.remove(response.request());
            return null;
        }
        if (!string2.equals((Object)"GET")) return null;
        if (OkHeaders.hasVaryAll(response)) return null;
        Entry entry = new Entry(response);
        DiskLruCache.Editor editor = null;
        try {
            editor = this.cache.edit(Cache.urlToKey(response.request()));
            if (editor == null) return null;
            entry.writeTo(editor);
            return (Cache)this.new CacheRequestImpl(editor);
        }
        catch (IOException iOException) {
            super.abortQuietly(editor);
            return null;
        }
        catch (IOException iOException2) {
            return null;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static int readInt(BufferedSource bufferedSource) throws IOException {
        long l2;
        String string2;
        try {
            l2 = bufferedSource.readDecimalLong();
            string2 = bufferedSource.readUtf8LineStrict();
            if (l2 < 0 || l2 > Integer.MAX_VALUE) throw new IOException("expected an int but was \"" + l2 + string2 + "\"");
        }
        catch (NumberFormatException var1_3) {
            throw new IOException(var1_3.getMessage());
        }
        if (string2.isEmpty()) return (int)l2;
        throw new IOException("expected an int but was \"" + l2 + string2 + "\"");
    }

    private void remove(Request request) throws IOException {
        this.cache.remove(Cache.urlToKey(request));
    }

    private void trackConditionalCacheHit() {
        Cache cache = this;
        synchronized (cache) {
            this.hitCount = 1 + this.hitCount;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void trackResponse(CacheStrategy cacheStrategy) {
        void var3_2 = this;
        synchronized (var3_2) {
            this.requestCount = 1 + this.requestCount;
            if (cacheStrategy.networkRequest != null) {
                this.networkCount = 1 + this.networkCount;
            } else if (cacheStrategy.cacheResponse != null) {
                this.hitCount = 1 + this.hitCount;
            }
            return;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void update(Response response, Response response2) {
        Entry entry = new Entry(response2);
        DiskLruCache.Snapshot snapshot = ((CacheResponseBody)response.body()).snapshot;
        DiskLruCache.Editor editor = null;
        try {
            editor = snapshot.edit();
            if (editor == null) return;
        }
        catch (IOException var6_6) {
            super.abortQuietly(editor);
            return;
        }
        entry.writeTo(editor);
        editor.commit();
    }

    private static String urlToKey(Request request) {
        return Util.md5Hex(request.url().toString());
    }

    public void close() throws IOException {
        this.cache.close();
    }

    public void delete() throws IOException {
        this.cache.delete();
    }

    public File directory() {
        return this.cache.getDirectory();
    }

    public void evictAll() throws IOException {
        this.cache.evictAll();
    }

    public void flush() throws IOException {
        this.cache.flush();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    Response get(Request request) {
        DiskLruCache.Snapshot snapshot;
        Response response;
        String string2 = Cache.urlToKey(request);
        try {
            snapshot = this.cache.get(string2);
            if (snapshot == null) {
                return null;
            }
        }
        catch (IOException var3_5) {
            return null;
        }
        try {}
        catch (IOException var7_7) {
            Util.closeQuietly(snapshot);
            return null;
        }
        Entry entry = new Entry(snapshot.getSource(0));
        if (entry.matches(request, response = entry.response(snapshot))) return response;
        Util.closeQuietly(response.body());
        return null;
    }

    public int hitCount() {
        Cache cache = this;
        synchronized (cache) {
            int n2 = this.hitCount;
            return n2;
        }
    }

    public void initialize() throws IOException {
        this.cache.initialize();
    }

    public boolean isClosed() {
        return this.cache.isClosed();
    }

    public long maxSize() {
        return this.cache.getMaxSize();
    }

    public int networkCount() {
        Cache cache = this;
        synchronized (cache) {
            int n2 = this.networkCount;
            return n2;
        }
    }

    public int requestCount() {
        Cache cache = this;
        synchronized (cache) {
            int n2 = this.requestCount;
            return n2;
        }
    }

    public long size() throws IOException {
        return this.cache.size();
    }

    public Iterator<String> urls() throws IOException {
        return new Iterator<String>(){
            boolean canRemove;
            final Iterator<DiskLruCache.Snapshot> delegate;
            String nextUrl;

            public boolean hasNext() {
                if (this.nextUrl != null) {
                    return true;
                }
                this.canRemove = false;
                while (this.delegate.hasNext()) {
                    DiskLruCache.Snapshot snapshot = (DiskLruCache.Snapshot)this.delegate.next();
                    try {
                        this.nextUrl = Okio.buffer(snapshot.getSource(0)).readUtf8LineStrict();
                        return true;
                    }
                    catch (IOException var3_2) {}
                    continue;
                    finally {
                        snapshot.close();
                        continue;
                    }
                }
                return false;
            }

            public String next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                String string2 = this.nextUrl;
                this.nextUrl = null;
                this.canRemove = true;
                return string2;
            }

            public void remove() {
                if (!this.canRemove) {
                    throw new IllegalStateException("remove() before next()");
                }
                this.delegate.remove();
            }
        };
    }

    public int writeAbortCount() {
        Cache cache = this;
        synchronized (cache) {
            int n2 = this.writeAbortCount;
            return n2;
        }
    }

    public int writeSuccessCount() {
        Cache cache = this;
        synchronized (cache) {
            int n2 = this.writeSuccessCount;
            return n2;
        }
    }

    final class CacheRequestImpl
    implements CacheRequest {
        private Sink body;
        private Sink cacheOut;
        private boolean done;
        private final DiskLruCache.Editor editor;

        public CacheRequestImpl(DiskLruCache.Editor editor) throws IOException {
            this.editor = editor;
            this.cacheOut = editor.newSink(1);
            this.body = new ForwardingSink(this.cacheOut, Cache.this, editor){
                final /* synthetic */ DiskLruCache.Editor val$editor;
                final /* synthetic */ Cache val$this$0;

                /*
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 */
                @Override
                public void close() throws IOException {
                    Cache cache;
                    Cache cache2 = cache = Cache.this;
                    synchronized (cache2) {
                        if (CacheRequestImpl.this.done) {
                            return;
                        }
                        CacheRequestImpl.this.done = true;
                        Cache.access$808(Cache.this);
                    }
                    super.close();
                    this.val$editor.commit();
                }
            };
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void abort() {
            Cache cache;
            Cache cache2 = cache = Cache.this;
            synchronized (cache2) {
                if (this.done) {
                    return;
                }
                this.done = true;
                Cache.access$908(Cache.this);
            }
            Util.closeQuietly(this.cacheOut);
            try {
                this.editor.abort();
                return;
            }
            catch (IOException var4_3) {
                return;
            }
        }

        @Override
        public Sink body() {
            return this.body;
        }

    }

    static class CacheResponseBody
    extends ResponseBody {
        private final BufferedSource bodySource;
        private final String contentLength;
        private final String contentType;
        private final DiskLruCache.Snapshot snapshot;

        public CacheResponseBody(final DiskLruCache.Snapshot snapshot, String string2, String string3) {
            this.snapshot = snapshot;
            this.contentType = string2;
            this.contentLength = string3;
            this.bodySource = Okio.buffer(new ForwardingSource(snapshot.getSource(1)){

                @Override
                public void close() throws IOException {
                    snapshot.close();
                    super.close();
                }
            });
        }

        @Override
        public long contentLength() {
            long l2 = -1;
            try {
                if (this.contentLength != null) {
                    long l3;
                    l2 = l3 = Long.parseLong((String)this.contentLength);
                }
                return l2;
            }
            catch (NumberFormatException var3_3) {
                return l2;
            }
        }

        @Override
        public MediaType contentType() {
            if (this.contentType != null) {
                return MediaType.parse(this.contentType);
            }
            return null;
        }

        @Override
        public BufferedSource source() {
            return this.bodySource;
        }

    }

    static final class Entry {
        private final int code;
        private final Handshake handshake;
        private final String message;
        private final Protocol protocol;
        private final String requestMethod;
        private final Headers responseHeaders;
        private final String url;
        private final Headers varyHeaders;

        public Entry(Response response) {
            this.url = response.request().url().toString();
            this.varyHeaders = OkHeaders.varyHeaders(response);
            this.requestMethod = response.request().method();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.responseHeaders = response.headers();
            this.handshake = response.handshake();
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public Entry(Source source) throws IOException {
            try {
                BufferedSource bufferedSource = Okio.buffer(source);
                this.url = bufferedSource.readUtf8LineStrict();
                this.requestMethod = bufferedSource.readUtf8LineStrict();
                Headers.Builder builder = new Headers.Builder();
                int n2 = Cache.readInt(bufferedSource);
                for (int i2 = 0; i2 < n2; ++i2) {
                    builder.addLenient(bufferedSource.readUtf8LineStrict());
                }
                this.varyHeaders = builder.build();
                StatusLine statusLine = StatusLine.parse(bufferedSource.readUtf8LineStrict());
                this.protocol = statusLine.protocol;
                this.code = statusLine.code;
                this.message = statusLine.message;
                Headers.Builder builder2 = new Headers.Builder();
                int n3 = Cache.readInt(bufferedSource);
                for (int i3 = 0; i3 < n3; ++i3) {
                    builder2.addLenient(bufferedSource.readUtf8LineStrict());
                }
                this.responseHeaders = builder2.build();
                if (super.isHttps()) {
                    String string2 = bufferedSource.readUtf8LineStrict();
                    if (string2.length() > 0) {
                        throw new IOException("expected \"\" but was \"" + string2 + "\"");
                    }
                    CipherSuite cipherSuite = CipherSuite.forJavaName(bufferedSource.readUtf8LineStrict());
                    List<Certificate> list = super.readCertificateList(bufferedSource);
                    List<Certificate> list2 = super.readCertificateList(bufferedSource);
                    TlsVersion tlsVersion = !bufferedSource.exhausted() ? TlsVersion.forJavaName(bufferedSource.readUtf8LineStrict()) : null;
                    this.handshake = Handshake.get(tlsVersion, cipherSuite, list, list2);
                    return;
                } else {
                    this.handshake = null;
                }
                return;
            }
            finally {
                source.close();
            }
        }

        private boolean isHttps() {
            return this.url.startsWith("https://");
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        private List<Certificate> readCertificateList(BufferedSource bufferedSource) throws IOException {
            CertificateFactory certificateFactory;
            int n2;
            List list;
            int n3 = Cache.readInt(bufferedSource);
            if (n3 == -1) {
                return Collections.emptyList();
            }
            try {
                certificateFactory = CertificateFactory.getInstance((String)"X.509");
                list = new ArrayList(n3);
                n2 = 0;
            }
            catch (CertificateException var3_8) {
                throw new IOException(var3_8.getMessage());
            }
            while (n2 < n3) {
                String string2 = bufferedSource.readUtf8LineStrict();
                Buffer buffer = new Buffer();
                buffer.write(ByteString.decodeBase64(string2));
                list.add((Object)certificateFactory.generateCertificate(buffer.inputStream()));
                ++n2;
            }
            return list;
        }

        private void writeCertList(BufferedSink bufferedSink, List<Certificate> list) throws IOException {
            bufferedSink.writeDecimalLong(list.size());
            bufferedSink.writeByte(10);
            int n2 = list.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                try {
                    bufferedSink.writeUtf8(ByteString.of(((Certificate)list.get(i2)).getEncoded()).base64());
                    bufferedSink.writeByte(10);
                }
                catch (CertificateEncodingException var3_5) {
                    throw new IOException(var3_5.getMessage());
                }
            }
        }

        public boolean matches(Request request, Response response) {
            if (this.url.equals((Object)request.url().toString()) && this.requestMethod.equals((Object)request.method()) && OkHeaders.varyMatches(response, this.varyHeaders, request)) {
                return true;
            }
            return false;
        }

        public Response response(DiskLruCache.Snapshot snapshot) {
            String string2 = this.responseHeaders.get("Content-Type");
            String string3 = this.responseHeaders.get("Content-Length");
            Request request = new Request.Builder().url(this.url).method(this.requestMethod, null).headers(this.varyHeaders).build();
            return new Response.Builder().request(request).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new CacheResponseBody(snapshot, string2, string3)).handshake(this.handshake).build();
        }

        public void writeTo(DiskLruCache.Editor editor) throws IOException {
            BufferedSink bufferedSink = Okio.buffer(editor.newSink(0));
            bufferedSink.writeUtf8(this.url);
            bufferedSink.writeByte(10);
            bufferedSink.writeUtf8(this.requestMethod);
            bufferedSink.writeByte(10);
            bufferedSink.writeDecimalLong(this.varyHeaders.size());
            bufferedSink.writeByte(10);
            int n2 = this.varyHeaders.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                bufferedSink.writeUtf8(this.varyHeaders.name(i2));
                bufferedSink.writeUtf8(": ");
                bufferedSink.writeUtf8(this.varyHeaders.value(i2));
                bufferedSink.writeByte(10);
            }
            bufferedSink.writeUtf8(new StatusLine(this.protocol, this.code, this.message).toString());
            bufferedSink.writeByte(10);
            bufferedSink.writeDecimalLong(this.responseHeaders.size());
            bufferedSink.writeByte(10);
            int n3 = this.responseHeaders.size();
            for (int i3 = 0; i3 < n3; ++i3) {
                bufferedSink.writeUtf8(this.responseHeaders.name(i3));
                bufferedSink.writeUtf8(": ");
                bufferedSink.writeUtf8(this.responseHeaders.value(i3));
                bufferedSink.writeByte(10);
            }
            if (super.isHttps()) {
                bufferedSink.writeByte(10);
                bufferedSink.writeUtf8(this.handshake.cipherSuite().javaName());
                bufferedSink.writeByte(10);
                super.writeCertList(bufferedSink, this.handshake.peerCertificates());
                super.writeCertList(bufferedSink, this.handshake.localCertificates());
                if (this.handshake.tlsVersion() != null) {
                    bufferedSink.writeUtf8(this.handshake.tlsVersion().javaName());
                    bufferedSink.writeByte(10);
                }
            }
            bufferedSink.close();
        }
    }

}

