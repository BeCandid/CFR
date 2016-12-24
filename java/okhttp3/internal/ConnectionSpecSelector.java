/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InterruptedIOException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.net.ProtocolException
 *  java.net.UnknownServiceException
 *  java.security.cert.CertificateException
 *  java.util.Arrays
 *  java.util.List
 *  javax.net.ssl.SSLHandshakeException
 *  javax.net.ssl.SSLPeerUnverifiedException
 *  javax.net.ssl.SSLProtocolException
 *  javax.net.ssl.SSLSocket
 */
package okhttp3.internal;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;
import okhttp3.ConnectionSpec;
import okhttp3.internal.Internal;

public final class ConnectionSpecSelector {
    private final List<ConnectionSpec> connectionSpecs;
    private boolean isFallback;
    private boolean isFallbackPossible;
    private int nextModeIndex = 0;

    public ConnectionSpecSelector(List<ConnectionSpec> list) {
        this.connectionSpecs = list;
    }

    private boolean isFallbackPossible(SSLSocket sSLSocket) {
        for (int i2 = this.nextModeIndex; i2 < this.connectionSpecs.size(); ++i2) {
            if (!((ConnectionSpec)this.connectionSpecs.get(i2)).isCompatible(sSLSocket)) continue;
            return true;
        }
        return false;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public ConnectionSpec configureSecureSocket(SSLSocket var1) throws IOException {
        var2_2 = this.nextModeIndex;
        var3_3 = this.connectionSpecs.size();
        do {
            var4_4 = null;
            if (var2_2 >= var3_3) ** GOTO lbl10
            var5_5 = (ConnectionSpec)this.connectionSpecs.get(var2_2);
            if (var5_5.isCompatible(var1)) {
                var4_4 = var5_5;
                this.nextModeIndex = var2_2 + 1;
lbl10: // 2 sources:
                if (var4_4 != null) break;
                throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.isFallback + ", modes=" + this.connectionSpecs + ", supported protocols=" + Arrays.toString((Object[])var1.getEnabledProtocols()));
            }
            ++var2_2;
        } while (true);
        this.isFallbackPossible = super.isFallbackPossible(var1);
        Internal.instance.apply(var4_4, var1, this.isFallback);
        return var4_4;
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean connectionFailed(IOException iOException) {
        this.isFallback = true;
        if (!this.isFallbackPossible || iOException instanceof ProtocolException || iOException instanceof InterruptedIOException || iOException instanceof SSLHandshakeException && iOException.getCause() instanceof CertificateException || iOException instanceof SSLPeerUnverifiedException || !(iOException instanceof SSLHandshakeException) && !(iOException instanceof SSLProtocolException)) {
            return false;
        }
        return true;
    }
}

