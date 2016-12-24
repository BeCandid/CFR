/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.security.cert.Certificate
 *  java.security.cert.CertificateParsingException
 *  java.security.cert.X509Certificate
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Locale
 *  javax.net.ssl.HostnameVerifier
 *  javax.net.ssl.SSLException
 *  javax.net.ssl.SSLSession
 *  javax.security.auth.x500.X500Principal
 */
package okhttp3.internal.tls;

import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.security.auth.x500.X500Principal;
import okhttp3.internal.Util;
import okhttp3.internal.tls.DistinguishedNameParser;

public final class OkHostnameVerifier
implements HostnameVerifier {
    private static final int ALT_DNS_NAME = 2;
    private static final int ALT_IPA_NAME = 7;
    public static final OkHostnameVerifier INSTANCE = new OkHostnameVerifier();

    private OkHostnameVerifier() {
    }

    public static List<String> allSubjectAltNames(X509Certificate x509Certificate) {
        List<String> list = OkHostnameVerifier.getSubjectAltNames(x509Certificate, 7);
        List<String> list2 = OkHostnameVerifier.getSubjectAltNames(x509Certificate, 2);
        ArrayList arrayList = new ArrayList(list.size() + list2.size());
        arrayList.addAll(list);
        arrayList.addAll(list2);
        return arrayList;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static List<String> getSubjectAltNames(X509Certificate x509Certificate, int n2) {
        ArrayList arrayList = new ArrayList();
        try {
            Collection collection = x509Certificate.getSubjectAlternativeNames();
            if (collection == null) {
                return Collections.emptyList();
            }
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                String string2;
                Integer n3;
                List list = (List)iterator.next();
                if (list == null || list.size() < 2 || (n3 = (Integer)list.get(0)) == null || n3 != n2 || (string2 = (String)list.get(1)) == null) continue;
                arrayList.add((Object)string2);
            }
            return arrayList;
        }
        catch (CertificateParsingException var3_8) {
            return Collections.emptyList();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private boolean verifyHostname(String string2, String string3) {
        String string4;
        if (string2 == null) return false;
        if (string2.length() == 0) return false;
        if (string2.startsWith(".")) return false;
        if (string2.endsWith("..")) {
            return false;
        }
        if (string3 == null) return false;
        if (string3.length() == 0) return false;
        if (string3.startsWith(".")) return false;
        if (string3.endsWith("..")) return false;
        if (!string2.endsWith(".")) {
            string2 = string2 + '.';
        }
        if (!string3.endsWith(".")) {
            string3 = string3 + '.';
        }
        if (!(string4 = string3.toLowerCase(Locale.US)).contains((CharSequence)"*")) {
            return string2.equals((Object)string4);
        }
        if (!string4.startsWith("*.")) return false;
        if (string4.indexOf(42, 1) != -1) return false;
        if (string2.length() < string4.length()) return false;
        if ("*.".equals((Object)string4)) return false;
        String string5 = string4.substring(1);
        if (!string2.endsWith(string5)) return false;
        int n2 = string2.length() - string5.length();
        if (n2 <= 0) return true;
        if (string2.lastIndexOf(46, n2 - 1) != -1) return false;
        return true;
    }

    private boolean verifyHostname(String string2, X509Certificate x509Certificate) {
        String string3;
        String string4 = string2.toLowerCase(Locale.US);
        boolean bl2 = false;
        List<String> list = OkHostnameVerifier.getSubjectAltNames(x509Certificate, 2);
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            bl2 = true;
            if (!super.verifyHostname(string4, (String)list.get(i2))) continue;
            return true;
        }
        if (!bl2 && (string3 = new DistinguishedNameParser(x509Certificate.getSubjectX500Principal()).findMostSpecific("cn")) != null) {
            return super.verifyHostname(string4, string3);
        }
        return false;
    }

    private boolean verifyIpAddress(String string2, X509Certificate x509Certificate) {
        List<String> list = OkHostnameVerifier.getSubjectAltNames(x509Certificate, 7);
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!string2.equalsIgnoreCase((String)list.get(i2))) continue;
            return true;
        }
        return false;
    }

    public boolean verify(String string2, X509Certificate x509Certificate) {
        if (Util.verifyAsIpAddress(string2)) {
            return super.verifyIpAddress(string2, x509Certificate);
        }
        return super.verifyHostname(string2, x509Certificate);
    }

    public boolean verify(String string2, SSLSession sSLSession) {
        try {
            boolean bl2 = this.verify(string2, (X509Certificate)sSLSession.getPeerCertificates()[0]);
            return bl2;
        }
        catch (SSLException var3_4) {
            return false;
        }
    }
}

