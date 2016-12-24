/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.IllegalAccessException
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 *  java.security.cert.TrustAnchor
 *  java.security.cert.X509Certificate
 *  javax.net.ssl.X509TrustManager
 */
package okhttp3.internal.tls;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.tls.TrustRootIndex;

public final class AndroidTrustRootIndex
implements TrustRootIndex {
    private final Method findByIssuerAndSignatureMethod;
    private final X509TrustManager trustManager;

    public AndroidTrustRootIndex(X509TrustManager x509TrustManager, Method method) {
        this.findByIssuerAndSignatureMethod = method;
        this.trustManager = x509TrustManager;
    }

    public static TrustRootIndex get(X509TrustManager x509TrustManager) {
        try {
            Method method = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[]{X509Certificate.class});
            method.setAccessible(true);
            AndroidTrustRootIndex androidTrustRootIndex = new AndroidTrustRootIndex(x509TrustManager, method);
            return androidTrustRootIndex;
        }
        catch (NoSuchMethodException var1_3) {
            return null;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public X509Certificate findByIssuerAndSignature(X509Certificate x509Certificate) {
        TrustAnchor trustAnchor = (TrustAnchor)this.findByIssuerAndSignatureMethod.invoke((Object)this.trustManager, new Object[]{x509Certificate});
        X509Certificate x509Certificate2 = null;
        if (trustAnchor == null) return x509Certificate2;
        try {
            X509Certificate x509Certificate3 = trustAnchor.getTrustedCert();
            return x509Certificate3;
        }
        catch (IllegalAccessException var3_5) {
            throw new AssertionError();
        }
        catch (InvocationTargetException var2_6) {
            return null;
        }
    }
}

