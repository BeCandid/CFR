/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.security.GeneralSecurityException
 *  java.security.Principal
 *  java.security.PublicKey
 *  java.security.cert.Certificate
 *  java.security.cert.X509Certificate
 *  java.util.ArrayDeque
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 *  javax.net.ssl.SSLPeerUnverifiedException
 */
package okhttp3.internal.tls;

import java.security.GeneralSecurityException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.internal.tls.TrustRootIndex;

public final class CertificateChainCleaner {
    private static final int MAX_SIGNERS = 9;
    private final TrustRootIndex trustRootIndex;

    public CertificateChainCleaner(TrustRootIndex trustRootIndex) {
        this.trustRootIndex = trustRootIndex;
    }

    private boolean verifySignature(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (!x509Certificate.getIssuerDN().equals((Object)x509Certificate2.getSubjectDN())) {
            return false;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        }
        catch (GeneralSecurityException var3_3) {
            return false;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public List<Certificate> clean(List<Certificate> list) throws SSLPeerUnverifiedException {
        ArrayDeque arrayDeque = new ArrayDeque(list);
        ArrayList arrayList = new ArrayList();
        arrayList.add(arrayDeque.removeFirst());
        boolean bl2 = false;
        int n2 = 0;
        while (n2 < 9) {
            X509Certificate x509Certificate = (X509Certificate)arrayList.get(-1 + arrayList.size());
            X509Certificate x509Certificate2 = this.trustRootIndex.findByIssuerAndSignature(x509Certificate);
            if (x509Certificate2 != null) {
                if (arrayList.size() > 1 || !x509Certificate.equals((Object)x509Certificate2)) {
                    arrayList.add((Object)x509Certificate2);
                }
                if (super.verifySignature(x509Certificate2, x509Certificate2)) {
                    return arrayList;
                }
                bl2 = true;
            } else {
                X509Certificate x509Certificate3;
                Iterator iterator = arrayDeque.iterator();
                do {
                    if (iterator.hasNext()) continue;
                    if (bl2) return arrayList;
                    throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + (Object)x509Certificate);
                } while (!super.verifySignature(x509Certificate, x509Certificate3 = (X509Certificate)iterator.next()));
                iterator.remove();
                arrayList.add((Object)x509Certificate3);
            }
            ++n2;
        }
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + (Object)arrayList);
    }
}

