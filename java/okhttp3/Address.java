/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.net.Proxy
 *  java.net.ProxySelector
 *  java.util.List
 *  javax.net.SocketFactory
 *  javax.net.ssl.HostnameVerifier
 *  javax.net.ssl.SSLSocketFactory
 */
package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Authenticator;
import okhttp3.CertificatePinner;
import okhttp3.ConnectionSpec;
import okhttp3.Dns;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.internal.Util;

public final class Address {
    final CertificatePinner certificatePinner;
    final List<ConnectionSpec> connectionSpecs;
    final Dns dns;
    final HostnameVerifier hostnameVerifier;
    final List<Protocol> protocols;
    final Proxy proxy;
    final Authenticator proxyAuthenticator;
    final ProxySelector proxySelector;
    final SocketFactory socketFactory;
    final SSLSocketFactory sslSocketFactory;
    final HttpUrl url;

    /*
     * Enabled aggressive block sorting
     */
    public Address(String string2, int n2, Dns dns, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, CertificatePinner certificatePinner, Authenticator authenticator, Proxy proxy, List<Protocol> list, List<ConnectionSpec> list2, ProxySelector proxySelector) {
        HttpUrl.Builder builder = new HttpUrl.Builder();
        String string3 = sSLSocketFactory != null ? "https" : "http";
        this.url = builder.scheme(string3).host(string2).port(n2).build();
        if (dns == null) {
            throw new IllegalArgumentException("dns == null");
        }
        this.dns = dns;
        if (socketFactory == null) {
            throw new IllegalArgumentException("socketFactory == null");
        }
        this.socketFactory = socketFactory;
        if (authenticator == null) {
            throw new IllegalArgumentException("proxyAuthenticator == null");
        }
        this.proxyAuthenticator = authenticator;
        if (list == null) {
            throw new IllegalArgumentException("protocols == null");
        }
        this.protocols = Util.immutableList(list);
        if (list2 == null) {
            throw new IllegalArgumentException("connectionSpecs == null");
        }
        this.connectionSpecs = Util.immutableList(list2);
        if (proxySelector == null) {
            throw new IllegalArgumentException("proxySelector == null");
        }
        this.proxySelector = proxySelector;
        this.proxy = proxy;
        this.sslSocketFactory = sSLSocketFactory;
        this.hostnameVerifier = hostnameVerifier;
        this.certificatePinner = certificatePinner;
    }

    public CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    public List<ConnectionSpec> connectionSpecs() {
        return this.connectionSpecs;
    }

    public Dns dns() {
        return this.dns;
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof Address;
        boolean bl3 = false;
        if (bl2) {
            Address address = (Address)object;
            boolean bl4 = this.url.equals(address.url);
            bl3 = false;
            if (bl4) {
                boolean bl5 = this.dns.equals((Object)address.dns);
                bl3 = false;
                if (bl5) {
                    boolean bl6 = this.proxyAuthenticator.equals((Object)address.proxyAuthenticator);
                    bl3 = false;
                    if (bl6) {
                        boolean bl7 = this.protocols.equals(address.protocols);
                        bl3 = false;
                        if (bl7) {
                            boolean bl8 = this.connectionSpecs.equals(address.connectionSpecs);
                            bl3 = false;
                            if (bl8) {
                                boolean bl9 = this.proxySelector.equals((Object)address.proxySelector);
                                bl3 = false;
                                if (bl9) {
                                    boolean bl10 = Util.equal((Object)this.proxy, (Object)address.proxy);
                                    bl3 = false;
                                    if (bl10) {
                                        boolean bl11 = Util.equal((Object)this.sslSocketFactory, (Object)address.sslSocketFactory);
                                        bl3 = false;
                                        if (bl11) {
                                            boolean bl12 = Util.equal((Object)this.hostnameVerifier, (Object)address.hostnameVerifier);
                                            bl3 = false;
                                            if (bl12) {
                                                boolean bl13 = Util.equal(this.certificatePinner, address.certificatePinner);
                                                bl3 = false;
                                                if (bl13) {
                                                    bl3 = true;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return bl3;
    }

    /*
     * Enabled aggressive block sorting
     */
    public int hashCode() {
        int n2 = 31 * (31 * (31 * (31 * (31 * (31 * (527 + this.url.hashCode()) + this.dns.hashCode()) + this.proxyAuthenticator.hashCode()) + this.protocols.hashCode()) + this.connectionSpecs.hashCode()) + this.proxySelector.hashCode());
        int n3 = this.proxy != null ? this.proxy.hashCode() : 0;
        int n4 = 31 * (n2 + n3);
        int n5 = this.sslSocketFactory != null ? this.sslSocketFactory.hashCode() : 0;
        int n6 = 31 * (n4 + n5);
        int n7 = this.hostnameVerifier != null ? this.hostnameVerifier.hashCode() : 0;
        int n8 = 31 * (n6 + n7);
        CertificatePinner certificatePinner = this.certificatePinner;
        int n9 = 0;
        if (certificatePinner != null) {
            n9 = this.certificatePinner.hashCode();
        }
        return n8 + n9;
    }

    public HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
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

    public SocketFactory socketFactory() {
        return this.socketFactory;
    }

    public SSLSocketFactory sslSocketFactory() {
        return this.sslSocketFactory;
    }

    public HttpUrl url() {
        return this.url;
    }
}

