/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.security.PublicKey
 *  java.security.cert.X509Certificate
 *  java.util.ArrayList
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Map
 *  javax.security.auth.x500.X500Principal
 */
package okhttp3.internal.tls;

import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.security.auth.x500.X500Principal;
import okhttp3.internal.tls.TrustRootIndex;

public final class RealTrustRootIndex
implements TrustRootIndex {
    private final Map<X500Principal, List<X509Certificate>> subjectToCaCerts = new LinkedHashMap();

    public /* varargs */ RealTrustRootIndex(X509Certificate ... arrx509Certificate) {
        for (X509Certificate x509Certificate : arrx509Certificate) {
            X500Principal x500Principal = x509Certificate.getSubjectX500Principal();
            List list = (List)this.subjectToCaCerts.get((Object)x500Principal);
            if (list == null) {
                list = new ArrayList(1);
                this.subjectToCaCerts.put((Object)x500Principal, (Object)list);
            }
            list.add((Object)x509Certificate);
        }
    }

    @Override
    public X509Certificate findByIssuerAndSignature(X509Certificate x509Certificate) {
        X500Principal x500Principal = x509Certificate.getIssuerX500Principal();
        List list = (List)this.subjectToCaCerts.get((Object)x500Principal);
        if (list == null) {
            return null;
        }
        for (X509Certificate x509Certificate2 : list) {
            PublicKey publicKey = x509Certificate2.getPublicKey();
            try {
                x509Certificate.verify(publicKey);
                return x509Certificate2;
            }
            catch (Exception var7_6) {
                continue;
            }
        }
        return null;
    }
}

