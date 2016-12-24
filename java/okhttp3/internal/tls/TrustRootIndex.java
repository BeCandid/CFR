/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.security.cert.X509Certificate
 */
package okhttp3.internal.tls;

import java.security.cert.X509Certificate;

public interface TrustRootIndex {
    public X509Certificate findByIssuerAndSignature(X509Certificate var1);
}

