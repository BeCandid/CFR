/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.security.Principal
 *  java.security.PublicKey
 *  java.security.cert.Certificate
 *  java.security.cert.X509Certificate
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.List
 *  javax.net.ssl.SSLPeerUnverifiedException
 */
package okhttp3;

import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.internal.Util;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;
import okio.ByteString;

public final class CertificatePinner {
    public static final CertificatePinner DEFAULT = new Builder().build();
    private final List<Pin> pins;
    private final TrustRootIndex trustRootIndex;

    private CertificatePinner(Builder builder) {
        this.pins = Util.immutableList(builder.pins);
        this.trustRootIndex = builder.trustRootIndex;
    }

    /* synthetic */ CertificatePinner(Builder builder,  var2_2) {
        super(builder);
    }

    public static String pin(Certificate certificate) {
        if (!(certificate instanceof X509Certificate)) {
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        return "sha256/" + CertificatePinner.sha256((X509Certificate)certificate).base64();
    }

    static ByteString sha1(X509Certificate x509Certificate) {
        return Util.sha1(ByteString.of(x509Certificate.getPublicKey().getEncoded()));
    }

    static ByteString sha256(X509Certificate x509Certificate) {
        return Util.sha256(ByteString.of(x509Certificate.getPublicKey().getEncoded()));
    }

    /*
     * Enabled aggressive block sorting
     */
    public void check(String string2, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<Pin> list2 = this.findMatchingPins(string2);
        if (!list2.isEmpty()) {
            if (this.trustRootIndex != null) {
                list = new CertificateChainCleaner(this.trustRootIndex).clean(list);
            }
            int n2 = 0;
            int n3 = list.size();
            block0 : do {
                X509Certificate x509Certificate;
                int n4;
                ByteString byteString;
                ByteString byteString2;
                if (n2 < n3) {
                    x509Certificate = (X509Certificate)list.get(n2);
                    byteString = null;
                    byteString2 = null;
                    n4 = list2.size();
                } else {
                    StringBuilder stringBuilder = new StringBuilder().append("Certificate pinning failure!").append("\n  Peer certificate chain:");
                    int n5 = list.size();
                    for (int i2 = 0; i2 < n5; ++i2) {
                        X509Certificate x509Certificate2 = (X509Certificate)list.get(i2);
                        stringBuilder.append("\n    ").append(CertificatePinner.pin((Certificate)x509Certificate2)).append(": ").append(x509Certificate2.getSubjectDN().getName());
                    }
                    stringBuilder.append("\n  Pinned certificates for ").append(string2).append(":");
                    int n6 = 0;
                    int n7 = list2.size();
                    do {
                        if (n6 >= n7) {
                            throw new SSLPeerUnverifiedException(stringBuilder.toString());
                        }
                        Pin pin = (Pin)list2.get(n6);
                        stringBuilder.append("\n    ").append((Object)pin);
                        ++n6;
                    } while (true);
                }
                for (int i3 = 0; i3 < n4; ++i3) {
                    Pin pin = (Pin)list2.get(i3);
                    if (pin.hashAlgorithm.equals((Object)"sha256/")) {
                        if (byteString2 == null) {
                            byteString2 = CertificatePinner.sha256(x509Certificate);
                        }
                        if (pin.hash.equals(byteString2)) break block0;
                        continue;
                    }
                    if (!pin.hashAlgorithm.equals((Object)"sha1/")) {
                        throw new AssertionError();
                    }
                    if (byteString == null) {
                        byteString = CertificatePinner.sha1(x509Certificate);
                    }
                    if (!pin.hash.equals(byteString)) continue;
                    return;
                }
                ++n2;
            } while (true);
        }
    }

    public /* varargs */ void check(String string2, Certificate ... arrcertificate) throws SSLPeerUnverifiedException {
        this.check(string2, Arrays.asList((Object[])arrcertificate));
    }

    List<Pin> findMatchingPins(String string2) {
        List list = Collections.emptyList();
        for (Pin pin : this.pins) {
            if (!pin.matches(string2)) continue;
            if (list.isEmpty()) {
                list = new ArrayList();
            }
            list.add((Object)pin);
        }
        return list;
    }

    Builder newBuilder() {
        return new Builder(this);
    }

    public static final class Builder {
        private final List<Pin> pins;
        private TrustRootIndex trustRootIndex;

        public Builder() {
            this.pins = new ArrayList();
        }

        Builder(CertificatePinner certificatePinner) {
            this.pins = new ArrayList();
            this.pins.addAll((Collection)certificatePinner.pins);
            this.trustRootIndex = certificatePinner.trustRootIndex;
        }

        public /* varargs */ Builder add(String string2, String ... arrstring) {
            if (string2 == null) {
                throw new IllegalArgumentException("pattern == null");
            }
            for (String string3 : arrstring) {
                this.pins.add((Object)new Pin(string2, string3));
            }
            return this;
        }

        public CertificatePinner build() {
            return new CertificatePinner(this, null);
        }

        public Builder trustRootIndex(TrustRootIndex trustRootIndex) {
            this.trustRootIndex = trustRootIndex;
            return this;
        }
    }

    static final class Pin {
        final ByteString hash;
        final String hashAlgorithm;
        final String pattern;

        /*
         * Enabled aggressive block sorting
         */
        Pin(String string2, String string3) {
            this.pattern = string2;
            if (string3.startsWith("sha1/")) {
                this.hashAlgorithm = "sha1/";
                this.hash = ByteString.decodeBase64(string3.substring("sha1/".length()));
            } else {
                if (!string3.startsWith("sha256/")) {
                    throw new IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': " + string3);
                }
                this.hashAlgorithm = "sha256/";
                this.hash = ByteString.decodeBase64(string3.substring("sha256/".length()));
            }
            if (this.hash == null) {
                throw new IllegalArgumentException("pins must be base64: " + string3);
            }
        }

        public boolean equals(Object object) {
            if (object instanceof Pin && this.pattern.equals((Object)((Pin)object).pattern) && this.hashAlgorithm.equals((Object)((Pin)object).hashAlgorithm) && this.hash.equals(((Pin)object).hash)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 31 * (31 * (527 + this.pattern.hashCode()) + this.hashAlgorithm.hashCode()) + this.hash.hashCode();
        }

        boolean matches(String string2) {
            if (this.pattern.equals((Object)string2)) {
                return true;
            }
            int n2 = string2.indexOf(46);
            boolean bl2 = this.pattern.startsWith("*.");
            boolean bl3 = false;
            if (bl2) {
                boolean bl4 = string2.regionMatches(false, n2 + 1, this.pattern, 2, -2 + this.pattern.length());
                bl3 = false;
                if (bl4) {
                    bl3 = true;
                }
            }
            return bl3;
        }

        public String toString() {
            return this.hashAlgorithm + this.hash.base64();
        }
    }

}

