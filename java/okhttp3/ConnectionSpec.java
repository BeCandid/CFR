/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Arrays
 *  java.util.List
 *  javax.net.ssl.SSLSocket
 */
package okhttp3;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import okhttp3.CipherSuite;
import okhttp3.TlsVersion;
import okhttp3.internal.Util;

public final class ConnectionSpec {
    private static final CipherSuite[] APPROVED_CIPHER_SUITES;
    public static final ConnectionSpec CLEARTEXT;
    public static final ConnectionSpec COMPATIBLE_TLS;
    public static final ConnectionSpec MODERN_TLS;
    private final String[] cipherSuites;
    private final boolean supportsTlsExtensions;
    private final boolean tls;
    private final String[] tlsVersions;

    static {
        CipherSuite[] arrcipherSuite = new CipherSuite[]{CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
        APPROVED_CIPHER_SUITES = arrcipherSuite;
        Builder builder = new Builder(true).cipherSuites(APPROVED_CIPHER_SUITES);
        TlsVersion[] arrtlsVersion = new TlsVersion[]{TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0};
        MODERN_TLS = builder.tlsVersions(arrtlsVersion).supportsTlsExtensions(true).build();
        Builder builder2 = new Builder(MODERN_TLS);
        TlsVersion[] arrtlsVersion2 = new TlsVersion[]{TlsVersion.TLS_1_0};
        COMPATIBLE_TLS = builder2.tlsVersions(arrtlsVersion2).supportsTlsExtensions(true).build();
        CLEARTEXT = new Builder(false).build();
    }

    private ConnectionSpec(Builder builder) {
        this.tls = builder.tls;
        this.cipherSuites = builder.cipherSuites;
        this.tlsVersions = builder.tlsVersions;
        this.supportsTlsExtensions = builder.supportsTlsExtensions;
    }

    /* synthetic */ ConnectionSpec(Builder builder,  var2_2) {
        super(builder);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean nonEmptyIntersection(String[] arrstring, String[] arrstring2) {
        if (arrstring == null || arrstring2 == null || arrstring.length == 0 || arrstring2.length == 0) {
            return false;
        }
        int n2 = arrstring.length;
        int n3 = 0;
        while (n3 < n2) {
            if (Util.contains(arrstring2, arrstring[n3])) {
                return true;
            }
            ++n3;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    private ConnectionSpec supportedSpec(SSLSocket sSLSocket, boolean bl2) {
        String[] arrstring = this.cipherSuites != null ? Util.intersect(String.class, this.cipherSuites, sSLSocket.getEnabledCipherSuites()) : sSLSocket.getEnabledCipherSuites();
        String[] arrstring2 = this.tlsVersions != null ? Util.intersect(String.class, this.tlsVersions, sSLSocket.getEnabledProtocols()) : sSLSocket.getEnabledProtocols();
        if (bl2 && Util.contains(sSLSocket.getSupportedCipherSuites(), "TLS_FALLBACK_SCSV")) {
            arrstring = Util.concat(arrstring, "TLS_FALLBACK_SCSV");
        }
        return new Builder((ConnectionSpec)this).cipherSuites(arrstring).tlsVersions(arrstring2).build();
    }

    void apply(SSLSocket sSLSocket, boolean bl2) {
        ConnectionSpec connectionSpec = super.supportedSpec(sSLSocket, bl2);
        if (connectionSpec.tlsVersions != null) {
            sSLSocket.setEnabledProtocols(connectionSpec.tlsVersions);
        }
        if (connectionSpec.cipherSuites != null) {
            sSLSocket.setEnabledCipherSuites(connectionSpec.cipherSuites);
        }
    }

    public List<CipherSuite> cipherSuites() {
        if (this.cipherSuites == null) {
            return null;
        }
        CipherSuite[] arrcipherSuite = new CipherSuite[this.cipherSuites.length];
        for (int i2 = 0; i2 < this.cipherSuites.length; ++i2) {
            arrcipherSuite[i2] = CipherSuite.forJavaName(this.cipherSuites[i2]);
        }
        return Util.immutableList(arrcipherSuite);
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        if (!(object instanceof ConnectionSpec)) {
            return false;
        }
        if (object == this) {
            return true;
        }
        ConnectionSpec connectionSpec = (ConnectionSpec)object;
        if (this.tls != connectionSpec.tls) return false;
        if (!this.tls) return true;
        if (!Arrays.equals((Object[])this.cipherSuites, (Object[])connectionSpec.cipherSuites)) return false;
        if (!Arrays.equals((Object[])this.tlsVersions, (Object[])connectionSpec.tlsVersions)) return false;
        if (this.supportsTlsExtensions != connectionSpec.supportsTlsExtensions) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public int hashCode() {
        int n2;
        int n3 = 17;
        if (!this.tls) return n3;
        int n4 = 31 * (31 * (527 + Arrays.hashCode((Object[])this.cipherSuites)) + Arrays.hashCode((Object[])this.tlsVersions));
        if (this.supportsTlsExtensions) {
            n2 = 0;
            do {
                return n4 + n2;
                break;
            } while (true);
        }
        n2 = 1;
        return n4 + n2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean isCompatible(SSLSocket sSLSocket) {
        if (!this.tls || this.tlsVersions != null && !ConnectionSpec.nonEmptyIntersection(this.tlsVersions, sSLSocket.getEnabledProtocols()) || this.cipherSuites != null && !ConnectionSpec.nonEmptyIntersection(this.cipherSuites, sSLSocket.getEnabledCipherSuites())) {
            return false;
        }
        return true;
    }

    public boolean isTls() {
        return this.tls;
    }

    public boolean supportsTlsExtensions() {
        return this.supportsTlsExtensions;
    }

    public List<TlsVersion> tlsVersions() {
        if (this.tlsVersions == null) {
            return null;
        }
        TlsVersion[] arrtlsVersion = new TlsVersion[this.tlsVersions.length];
        for (int i2 = 0; i2 < this.tlsVersions.length; ++i2) {
            arrtlsVersion[i2] = TlsVersion.forJavaName(this.tlsVersions[i2]);
        }
        return Util.immutableList(arrtlsVersion);
    }

    /*
     * Enabled aggressive block sorting
     */
    public String toString() {
        String string2;
        if (!this.tls) {
            return "ConnectionSpec()";
        }
        String string3 = this.cipherSuites != null ? this.cipherSuites().toString() : "[all enabled]";
        if (this.tlsVersions != null) {
            string2 = this.tlsVersions().toString();
            return "ConnectionSpec(cipherSuites=" + string3 + ", tlsVersions=" + string2 + ", supportsTlsExtensions=" + this.supportsTlsExtensions + ")";
        }
        string2 = "[all enabled]";
        return "ConnectionSpec(cipherSuites=" + string3 + ", tlsVersions=" + string2 + ", supportsTlsExtensions=" + this.supportsTlsExtensions + ")";
    }

    public static final class Builder {
        private String[] cipherSuites;
        private boolean supportsTlsExtensions;
        private boolean tls;
        private String[] tlsVersions;

        public Builder(ConnectionSpec connectionSpec) {
            this.tls = connectionSpec.tls;
            this.cipherSuites = connectionSpec.cipherSuites;
            this.tlsVersions = connectionSpec.tlsVersions;
            this.supportsTlsExtensions = connectionSpec.supportsTlsExtensions;
        }

        Builder(boolean bl2) {
            this.tls = bl2;
        }

        public Builder allEnabledCipherSuites() {
            if (!this.tls) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            this.cipherSuites = null;
            return this;
        }

        public Builder allEnabledTlsVersions() {
            if (!this.tls) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            this.tlsVersions = null;
            return this;
        }

        public ConnectionSpec build() {
            return new ConnectionSpec(this, null);
        }

        public /* varargs */ Builder cipherSuites(String ... arrstring) {
            if (!this.tls) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (arrstring.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            this.cipherSuites = (String[])arrstring.clone();
            return this;
        }

        public /* varargs */ Builder cipherSuites(CipherSuite ... arrcipherSuite) {
            if (!this.tls) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] arrstring = new String[arrcipherSuite.length];
            for (int i2 = 0; i2 < arrcipherSuite.length; ++i2) {
                arrstring[i2] = arrcipherSuite[i2].javaName;
            }
            return this.cipherSuites(arrstring);
        }

        public Builder supportsTlsExtensions(boolean bl2) {
            if (!this.tls) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.supportsTlsExtensions = bl2;
            return this;
        }

        public /* varargs */ Builder tlsVersions(String ... arrstring) {
            if (!this.tls) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (arrstring.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.tlsVersions = (String[])arrstring.clone();
            return this;
        }

        public /* varargs */ Builder tlsVersions(TlsVersion ... arrtlsVersion) {
            if (!this.tls) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            String[] arrstring = new String[arrtlsVersion.length];
            for (int i2 = 0; i2 < arrtlsVersion.length; ++i2) {
                arrstring[i2] = arrtlsVersion[i2].javaName;
            }
            return this.tlsVersions(arrstring);
        }
    }

}

