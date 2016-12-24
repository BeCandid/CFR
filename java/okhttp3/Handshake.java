/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.security.Principal
 *  java.security.cert.Certificate
 *  java.security.cert.X509Certificate
 *  java.util.Collections
 *  java.util.List
 *  javax.net.ssl.SSLPeerUnverifiedException
 *  javax.net.ssl.SSLSession
 *  javax.security.auth.x500.X500Principal
 */
package okhttp3;

import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.security.auth.x500.X500Principal;
import okhttp3.CipherSuite;
import okhttp3.TlsVersion;
import okhttp3.internal.Util;

public final class Handshake {
    private final CipherSuite cipherSuite;
    private final List<Certificate> localCertificates;
    private final List<Certificate> peerCertificates;
    private final TlsVersion tlsVersion;

    private Handshake(TlsVersion tlsVersion, CipherSuite cipherSuite, List<Certificate> list, List<Certificate> list2) {
        this.tlsVersion = tlsVersion;
        this.cipherSuite = cipherSuite;
        this.peerCertificates = list;
        this.localCertificates = list2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Handshake get(SSLSession sSLSession) {
        List<Certificate> list;
        Certificate[] arrcertificate;
        String string2 = sSLSession.getCipherSuite();
        if (string2 == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        CipherSuite cipherSuite = CipherSuite.forJavaName(string2);
        String string3 = sSLSession.getProtocol();
        if (string3 == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        TlsVersion tlsVersion = TlsVersion.forJavaName(string3);
        try {
            Certificate[] arrcertificate2;
            arrcertificate = arrcertificate2 = sSLSession.getPeerCertificates();
        }
        catch (SSLPeerUnverifiedException var5_10) {
            arrcertificate = null;
        }
        List<Certificate> list2 = arrcertificate != null ? Util.immutableList(arrcertificate) : Collections.emptyList();
        Certificate[] arrcertificate3 = sSLSession.getLocalCertificates();
        if (arrcertificate3 != null) {
            list = Util.immutableList(arrcertificate3);
            return new Handshake(tlsVersion, cipherSuite, list2, list);
        }
        list = Collections.emptyList();
        return new Handshake(tlsVersion, cipherSuite, list2, list);
    }

    public static Handshake get(TlsVersion tlsVersion, CipherSuite cipherSuite, List<Certificate> list, List<Certificate> list2) {
        if (cipherSuite == null) {
            throw new IllegalArgumentException("cipherSuite == null");
        }
        return new Handshake(tlsVersion, cipherSuite, Util.immutableList(list), Util.immutableList(list2));
    }

    public CipherSuite cipherSuite() {
        return this.cipherSuite;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        if (!(object instanceof Handshake)) {
            return false;
        }
        Handshake handshake = (Handshake)object;
        if (!Util.equal((Object)this.cipherSuite, (Object)handshake.cipherSuite)) return false;
        if (!this.cipherSuite.equals((Object)handshake.cipherSuite)) return false;
        if (!this.peerCertificates.equals(handshake.peerCertificates)) return false;
        if (!this.localCertificates.equals(handshake.localCertificates)) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public int hashCode() {
        int n2;
        if (this.tlsVersion != null) {
            n2 = this.tlsVersion.hashCode();
            do {
                return 31 * (31 * (31 * (n2 + 527) + this.cipherSuite.hashCode()) + this.peerCertificates.hashCode()) + this.localCertificates.hashCode();
                break;
            } while (true);
        }
        n2 = 0;
        return 31 * (31 * (31 * (n2 + 527) + this.cipherSuite.hashCode()) + this.peerCertificates.hashCode()) + this.localCertificates.hashCode();
    }

    public List<Certificate> localCertificates() {
        return this.localCertificates;
    }

    public Principal localPrincipal() {
        if (!this.localCertificates.isEmpty()) {
            return ((X509Certificate)this.localCertificates.get(0)).getSubjectX500Principal();
        }
        return null;
    }

    public List<Certificate> peerCertificates() {
        return this.peerCertificates;
    }

    public Principal peerPrincipal() {
        if (!this.peerCertificates.isEmpty()) {
            return ((X509Certificate)this.peerCertificates.get(0)).getSubjectX500Principal();
        }
        return null;
    }

    public TlsVersion tlsVersion() {
        return this.tlsVersion;
    }
}

