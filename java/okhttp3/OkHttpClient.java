/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.Cloneable
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.net.MalformedURLException
 *  java.net.Proxy
 *  java.net.ProxySelector
 *  java.net.UnknownHostException
 *  java.security.GeneralSecurityException
 *  java.security.SecureRandom
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  java.util.concurrent.TimeUnit
 *  javax.net.SocketFactory
 *  javax.net.ssl.HostnameVerifier
 *  javax.net.ssl.KeyManager
 *  javax.net.ssl.SSLContext
 *  javax.net.ssl.SSLSocket
 *  javax.net.ssl.SSLSocketFactory
 *  javax.net.ssl.TrustManager
 *  javax.net.ssl.X509TrustManager
 */
package okhttp3;

import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.Address;
import okhttp3.Authenticator;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.CertificatePinner;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.CookieJar;
import okhttp3.Dispatcher;
import okhttp3.Dns;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.RealCall;
import okhttp3.Request;
import okhttp3.internal.Internal;
import okhttp3.internal.InternalCache;
import okhttp3.internal.Platform;
import okhttp3.internal.RouteDatabase;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpEngine;
import okhttp3.internal.http.StreamAllocation;
import okhttp3.internal.io.RealConnection;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.tls.TrustRootIndex;

public class OkHttpClient
implements Cloneable,
Call.Factory {
    private static final List<ConnectionSpec> DEFAULT_CONNECTION_SPECS;
    private static final List<Protocol> DEFAULT_PROTOCOLS;
    final Authenticator authenticator;
    final Cache cache;
    final CertificatePinner certificatePinner;
    final int connectTimeout;
    final ConnectionPool connectionPool;
    final List<ConnectionSpec> connectionSpecs;
    final CookieJar cookieJar;
    final Dispatcher dispatcher;
    final Dns dns;
    final boolean followRedirects;
    final boolean followSslRedirects;
    final HostnameVerifier hostnameVerifier;
    final List<Interceptor> interceptors;
    final InternalCache internalCache;
    final List<Interceptor> networkInterceptors;
    final List<Protocol> protocols;
    final Proxy proxy;
    final Authenticator proxyAuthenticator;
    final ProxySelector proxySelector;
    final int readTimeout;
    final boolean retryOnConnectionFailure;
    final SocketFactory socketFactory;
    final SSLSocketFactory sslSocketFactory;
    final TrustRootIndex trustRootIndex;
    final int writeTimeout;

    static {
        Protocol[] arrprotocol = new Protocol[]{Protocol.HTTP_2, Protocol.SPDY_3, Protocol.HTTP_1_1};
        DEFAULT_PROTOCOLS = Util.immutableList(arrprotocol);
        ConnectionSpec[] arrconnectionSpec = new ConnectionSpec[]{ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT};
        DEFAULT_CONNECTION_SPECS = Util.immutableList(arrconnectionSpec);
        Internal.instance = new Internal(){

            @Override
            public void addLenient(Headers.Builder builder, String string2) {
                builder.addLenient(string2);
            }

            @Override
            public void addLenient(Headers.Builder builder, String string2, String string3) {
                builder.addLenient(string2, string3);
            }

            @Override
            public void apply(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean bl2) {
                connectionSpec.apply(sSLSocket, bl2);
            }

            @Override
            public StreamAllocation callEngineGetStreamAllocation(Call call) {
                return ((RealCall)call).engine.streamAllocation;
            }

            @Override
            public void callEnqueue(Call call, Callback callback, boolean bl2) {
                ((RealCall)call).enqueue(callback, bl2);
            }

            @Override
            public boolean connectionBecameIdle(ConnectionPool connectionPool, RealConnection realConnection) {
                return connectionPool.connectionBecameIdle(realConnection);
            }

            @Override
            public RealConnection get(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation) {
                return connectionPool.get(address, streamAllocation);
            }

            @Override
            public HttpUrl getHttpUrlChecked(String string2) throws MalformedURLException, UnknownHostException {
                return HttpUrl.getChecked(string2);
            }

            @Override
            public InternalCache internalCache(OkHttpClient okHttpClient) {
                return okHttpClient.internalCache();
            }

            @Override
            public void put(ConnectionPool connectionPool, RealConnection realConnection) {
                connectionPool.put(realConnection);
            }

            @Override
            public RouteDatabase routeDatabase(ConnectionPool connectionPool) {
                return connectionPool.routeDatabase;
            }

            @Override
            public void setCache(Builder builder, InternalCache internalCache) {
                builder.setInternalCache(internalCache);
            }
        };
    }

    public OkHttpClient() {
        this(new Builder());
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private OkHttpClient(Builder var1) {
        super();
        this.dispatcher = var1.dispatcher;
        this.proxy = var1.proxy;
        this.protocols = var1.protocols;
        this.connectionSpecs = var1.connectionSpecs;
        this.interceptors = Util.immutableList(var1.interceptors);
        this.networkInterceptors = Util.immutableList(var1.networkInterceptors);
        this.proxySelector = var1.proxySelector;
        this.cookieJar = var1.cookieJar;
        this.cache = var1.cache;
        this.internalCache = var1.internalCache;
        this.socketFactory = var1.socketFactory;
        var2_2 = false;
        for (ConnectionSpec var7_4 : this.connectionSpecs) {
            if (var2_2 || var7_4.isTls()) {
                var2_2 = true;
                continue;
            }
            var2_2 = false;
        }
        if (var1.sslSocketFactory != null || !var2_2) {
            this.sslSocketFactory = var1.sslSocketFactory;
        } else {
            var6_6 = SSLContext.getInstance((String)"TLS");
            var6_6.init(null, null, null);
            this.sslSocketFactory = var6_6.getSocketFactory();
        }
        if (this.sslSocketFactory == null || var1.trustRootIndex != null) ** GOTO lbl37
        var4_5 = Platform.get().trustManager(this.sslSocketFactory);
        if (var4_5 == null) {
            throw new IllegalStateException("Unable to extract the trust manager on " + Platform.get() + ", sslSocketFactory is " + (Object)this.sslSocketFactory.getClass());
        }
        ** GOTO lbl34
        catch (GeneralSecurityException var5_7) {
            throw new AssertionError();
        }
lbl34: // 1 sources:
        this.trustRootIndex = Platform.get().trustRootIndex(var4_5);
        this.certificatePinner = var1.certificatePinner.newBuilder().trustRootIndex(this.trustRootIndex).build();
        ** GOTO lbl39
lbl37: // 1 sources:
        this.trustRootIndex = var1.trustRootIndex;
        this.certificatePinner = var1.certificatePinner;
lbl39: // 2 sources:
        this.hostnameVerifier = var1.hostnameVerifier;
        this.proxyAuthenticator = var1.proxyAuthenticator;
        this.authenticator = var1.authenticator;
        this.connectionPool = var1.connectionPool;
        this.dns = var1.dns;
        this.followSslRedirects = var1.followSslRedirects;
        this.followRedirects = var1.followRedirects;
        this.retryOnConnectionFailure = var1.retryOnConnectionFailure;
        this.connectTimeout = var1.connectTimeout;
        this.readTimeout = var1.readTimeout;
        this.writeTimeout = var1.writeTimeout;
    }

    /* synthetic */ OkHttpClient(Builder builder,  var2_2) {
        super(builder);
    }

    public Authenticator authenticator() {
        return this.authenticator;
    }

    public Cache cache() {
        return this.cache;
    }

    public CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    public int connectTimeoutMillis() {
        return this.connectTimeout;
    }

    public ConnectionPool connectionPool() {
        return this.connectionPool;
    }

    public List<ConnectionSpec> connectionSpecs() {
        return this.connectionSpecs;
    }

    public CookieJar cookieJar() {
        return this.cookieJar;
    }

    public Dispatcher dispatcher() {
        return this.dispatcher;
    }

    public Dns dns() {
        return this.dns;
    }

    public boolean followRedirects() {
        return this.followRedirects;
    }

    public boolean followSslRedirects() {
        return this.followSslRedirects;
    }

    public HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    public List<Interceptor> interceptors() {
        return this.interceptors;
    }

    InternalCache internalCache() {
        if (this.cache != null) {
            return this.cache.internalCache;
        }
        return this.internalCache;
    }

    public List<Interceptor> networkInterceptors() {
        return this.networkInterceptors;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    @Override
    public Call newCall(Request request) {
        return new RealCall((OkHttpClient)this, request);
    }

    public List<Protocol> protocols() {
        return this.protocols;
    }

    public Proxy proxy() {
        return this.proxy;
    }

    public Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    public ProxySelector proxySelector() {
        return this.proxySelector;
    }

    public int readTimeoutMillis() {
        return this.readTimeout;
    }

    public boolean retryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    public SocketFactory socketFactory() {
        return this.socketFactory;
    }

    public SSLSocketFactory sslSocketFactory() {
        return this.sslSocketFactory;
    }

    public int writeTimeoutMillis() {
        return this.writeTimeout;
    }

    public static final class Builder {
        Authenticator authenticator;
        Cache cache;
        CertificatePinner certificatePinner;
        int connectTimeout;
        ConnectionPool connectionPool;
        List<ConnectionSpec> connectionSpecs;
        CookieJar cookieJar;
        Dispatcher dispatcher;
        Dns dns;
        boolean followRedirects;
        boolean followSslRedirects;
        HostnameVerifier hostnameVerifier;
        final List<Interceptor> interceptors;
        InternalCache internalCache;
        final List<Interceptor> networkInterceptors;
        List<Protocol> protocols;
        Proxy proxy;
        Authenticator proxyAuthenticator;
        ProxySelector proxySelector;
        int readTimeout;
        boolean retryOnConnectionFailure;
        SocketFactory socketFactory;
        SSLSocketFactory sslSocketFactory;
        TrustRootIndex trustRootIndex;
        int writeTimeout;

        public Builder() {
            this.interceptors = new ArrayList();
            this.networkInterceptors = new ArrayList();
            this.dispatcher = new Dispatcher();
            this.protocols = DEFAULT_PROTOCOLS;
            this.connectionSpecs = DEFAULT_CONNECTION_SPECS;
            this.proxySelector = ProxySelector.getDefault();
            this.cookieJar = CookieJar.NO_COOKIES;
            this.socketFactory = SocketFactory.getDefault();
            this.hostnameVerifier = OkHostnameVerifier.INSTANCE;
            this.certificatePinner = CertificatePinner.DEFAULT;
            this.proxyAuthenticator = Authenticator.NONE;
            this.authenticator = Authenticator.NONE;
            this.connectionPool = new ConnectionPool();
            this.dns = Dns.SYSTEM;
            this.followSslRedirects = true;
            this.followRedirects = true;
            this.retryOnConnectionFailure = true;
            this.connectTimeout = 10000;
            this.readTimeout = 10000;
            this.writeTimeout = 10000;
        }

        Builder(OkHttpClient okHttpClient) {
            this.interceptors = new ArrayList();
            this.networkInterceptors = new ArrayList();
            this.dispatcher = okHttpClient.dispatcher;
            this.proxy = okHttpClient.proxy;
            this.protocols = okHttpClient.protocols;
            this.connectionSpecs = okHttpClient.connectionSpecs;
            this.interceptors.addAll(okHttpClient.interceptors);
            this.networkInterceptors.addAll(okHttpClient.networkInterceptors);
            this.proxySelector = okHttpClient.proxySelector;
            this.cookieJar = okHttpClient.cookieJar;
            this.internalCache = okHttpClient.internalCache;
            this.cache = okHttpClient.cache;
            this.socketFactory = okHttpClient.socketFactory;
            this.sslSocketFactory = okHttpClient.sslSocketFactory;
            this.trustRootIndex = okHttpClient.trustRootIndex;
            this.hostnameVerifier = okHttpClient.hostnameVerifier;
            this.certificatePinner = okHttpClient.certificatePinner;
            this.proxyAuthenticator = okHttpClient.proxyAuthenticator;
            this.authenticator = okHttpClient.authenticator;
            this.connectionPool = okHttpClient.connectionPool;
            this.dns = okHttpClient.dns;
            this.followSslRedirects = okHttpClient.followSslRedirects;
            this.followRedirects = okHttpClient.followRedirects;
            this.retryOnConnectionFailure = okHttpClient.retryOnConnectionFailure;
            this.connectTimeout = okHttpClient.connectTimeout;
            this.readTimeout = okHttpClient.readTimeout;
            this.writeTimeout = okHttpClient.writeTimeout;
        }

        public Builder addInterceptor(Interceptor interceptor) {
            this.interceptors.add((Object)interceptor);
            return this;
        }

        public Builder addNetworkInterceptor(Interceptor interceptor) {
            this.networkInterceptors.add((Object)interceptor);
            return this;
        }

        public Builder authenticator(Authenticator authenticator) {
            if (authenticator == null) {
                throw new NullPointerException("authenticator == null");
            }
            this.authenticator = authenticator;
            return this;
        }

        public OkHttpClient build() {
            return new OkHttpClient(this, null);
        }

        public Builder cache(Cache cache) {
            this.cache = cache;
            this.internalCache = null;
            return this;
        }

        public Builder certificatePinner(CertificatePinner certificatePinner) {
            if (certificatePinner == null) {
                throw new NullPointerException("certificatePinner == null");
            }
            this.certificatePinner = certificatePinner;
            return this;
        }

        public Builder connectTimeout(long l2, TimeUnit timeUnit) {
            if (l2 < 0) {
                throw new IllegalArgumentException("timeout < 0");
            }
            if (timeUnit == null) {
                throw new IllegalArgumentException("unit == null");
            }
            long l3 = timeUnit.toMillis(l2);
            if (l3 > Integer.MAX_VALUE) {
                throw new IllegalArgumentException("Timeout too large.");
            }
            if (l3 == 0 && l2 > 0) {
                throw new IllegalArgumentException("Timeout too small.");
            }
            this.connectTimeout = (int)l3;
            return this;
        }

        public Builder connectionPool(ConnectionPool connectionPool) {
            if (connectionPool == null) {
                throw new NullPointerException("connectionPool == null");
            }
            this.connectionPool = connectionPool;
            return this;
        }

        public Builder connectionSpecs(List<ConnectionSpec> list) {
            this.connectionSpecs = Util.immutableList(list);
            return this;
        }

        public Builder cookieJar(CookieJar cookieJar) {
            if (cookieJar == null) {
                throw new NullPointerException("cookieJar == null");
            }
            this.cookieJar = cookieJar;
            return this;
        }

        public Builder dispatcher(Dispatcher dispatcher) {
            if (dispatcher == null) {
                throw new IllegalArgumentException("dispatcher == null");
            }
            this.dispatcher = dispatcher;
            return this;
        }

        public Builder dns(Dns dns) {
            if (dns == null) {
                throw new NullPointerException("dns == null");
            }
            this.dns = dns;
            return this;
        }

        public Builder followRedirects(boolean bl2) {
            this.followRedirects = bl2;
            return this;
        }

        public Builder followSslRedirects(boolean bl2) {
            this.followSslRedirects = bl2;
            return this;
        }

        public Builder hostnameVerifier(HostnameVerifier hostnameVerifier) {
            if (hostnameVerifier == null) {
                throw new NullPointerException("hostnameVerifier == null");
            }
            this.hostnameVerifier = hostnameVerifier;
            return this;
        }

        public List<Interceptor> interceptors() {
            return this.interceptors;
        }

        public List<Interceptor> networkInterceptors() {
            return this.networkInterceptors;
        }

        public Builder protocols(List<Protocol> list) {
            List<Protocol> list2 = Util.immutableList(list);
            if (!list2.contains((Object)Protocol.HTTP_1_1)) {
                throw new IllegalArgumentException("protocols doesn't contain http/1.1: " + list2);
            }
            if (list2.contains((Object)Protocol.HTTP_1_0)) {
                throw new IllegalArgumentException("protocols must not contain http/1.0: " + list2);
            }
            if (list2.contains((Object)null)) {
                throw new IllegalArgumentException("protocols must not contain null");
            }
            this.protocols = Util.immutableList(list2);
            return this;
        }

        public Builder proxy(Proxy proxy) {
            this.proxy = proxy;
            return this;
        }

        public Builder proxyAuthenticator(Authenticator authenticator) {
            if (authenticator == null) {
                throw new NullPointerException("proxyAuthenticator == null");
            }
            this.proxyAuthenticator = authenticator;
            return this;
        }

        public Builder proxySelector(ProxySelector proxySelector) {
            this.proxySelector = proxySelector;
            return this;
        }

        public Builder readTimeout(long l2, TimeUnit timeUnit) {
            if (l2 < 0) {
                throw new IllegalArgumentException("timeout < 0");
            }
            if (timeUnit == null) {
                throw new IllegalArgumentException("unit == null");
            }
            long l3 = timeUnit.toMillis(l2);
            if (l3 > Integer.MAX_VALUE) {
                throw new IllegalArgumentException("Timeout too large.");
            }
            if (l3 == 0 && l2 > 0) {
                throw new IllegalArgumentException("Timeout too small.");
            }
            this.readTimeout = (int)l3;
            return this;
        }

        public Builder retryOnConnectionFailure(boolean bl2) {
            this.retryOnConnectionFailure = bl2;
            return this;
        }

        void setInternalCache(InternalCache internalCache) {
            this.internalCache = internalCache;
            this.cache = null;
        }

        public Builder socketFactory(SocketFactory socketFactory) {
            if (socketFactory == null) {
                throw new NullPointerException("socketFactory == null");
            }
            this.socketFactory = socketFactory;
            return this;
        }

        public Builder sslSocketFactory(SSLSocketFactory sSLSocketFactory) {
            if (sSLSocketFactory == null) {
                throw new NullPointerException("sslSocketFactory == null");
            }
            this.sslSocketFactory = sSLSocketFactory;
            this.trustRootIndex = null;
            return this;
        }

        public Builder writeTimeout(long l2, TimeUnit timeUnit) {
            if (l2 < 0) {
                throw new IllegalArgumentException("timeout < 0");
            }
            if (timeUnit == null) {
                throw new IllegalArgumentException("unit == null");
            }
            long l3 = timeUnit.toMillis(l2);
            if (l3 > Integer.MAX_VALUE) {
                throw new IllegalArgumentException("Timeout too large.");
            }
            if (l3 == 0 && l2 > 0) {
                throw new IllegalArgumentException("Timeout too small.");
            }
            this.writeTimeout = (int)l3;
            return this;
        }
    }

}

