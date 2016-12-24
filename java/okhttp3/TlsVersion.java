/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package okhttp3;

public final class TlsVersion
extends Enum<TlsVersion> {
    private static final /* synthetic */ TlsVersion[] $VALUES;
    public static final /* enum */ TlsVersion SSL_3_0;
    public static final /* enum */ TlsVersion TLS_1_0;
    public static final /* enum */ TlsVersion TLS_1_1;
    public static final /* enum */ TlsVersion TLS_1_2;
    final String javaName;

    static {
        TLS_1_2 = new TlsVersion("TLSv1.2");
        TLS_1_1 = new TlsVersion("TLSv1.1");
        TLS_1_0 = new TlsVersion("TLSv1");
        SSL_3_0 = new TlsVersion("SSLv3");
        TlsVersion[] arrtlsVersion = new TlsVersion[]{TLS_1_2, TLS_1_1, TLS_1_0, SSL_3_0};
        $VALUES = arrtlsVersion;
    }

    private TlsVersion(String string3) {
        super(string2, n2);
        this.javaName = string3;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static TlsVersion forJavaName(String var0) {
        var1_1 = -1;
        switch (var0.hashCode()) {
            case -503070502: {
                if (var0.equals((Object)"TLSv1.2")) {
                    var1_1 = 0;
                    ** break;
                }
                ** GOTO lbl16
            }
            case -503070503: {
                if (var0.equals((Object)"TLSv1.1")) {
                    var1_1 = 1;
                    ** break;
                }
                ** GOTO lbl16
            }
            case 79923350: {
                if (var0.equals((Object)"TLSv1")) {
                    var1_1 = 2;
                }
            }
lbl16: // 8 sources:
            default: {
                ** GOTO lbl21
            }
            case 79201641: 
        }
        if (var0.equals((Object)"SSLv3")) {
            var1_1 = 3;
        }
lbl21: // 4 sources:
        switch (var1_1) {
            default: {
                throw new IllegalArgumentException("Unexpected TLS version: " + var0);
            }
            case 0: {
                return TlsVersion.TLS_1_2;
            }
            case 1: {
                return TlsVersion.TLS_1_1;
            }
            case 2: {
                return TlsVersion.TLS_1_0;
            }
            case 3: 
        }
        return TlsVersion.SSL_3_0;
    }

    public static TlsVersion valueOf(String string2) {
        return (TlsVersion)Enum.valueOf((Class)TlsVersion.class, (String)string2);
    }

    public static TlsVersion[] values() {
        return (TlsVersion[])$VALUES.clone();
    }

    public String javaName() {
        return this.javaName;
    }
}

