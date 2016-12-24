/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.io.IOException
 *  java.io.PrintStream
 *  java.lang.AssertionError
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.ClassNotFoundException
 *  java.lang.IllegalAccessException
 *  java.lang.Math
 *  java.lang.NoSuchFieldException
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.SecurityException
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.lang.Void
 *  java.lang.reflect.Field
 *  java.lang.reflect.InvocationHandler
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 *  java.lang.reflect.Proxy
 *  java.net.InetSocketAddress
 *  java.net.Socket
 *  java.net.SocketAddress
 *  java.nio.charset.Charset
 *  java.security.cert.X509Certificate
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.logging.Level
 *  java.util.logging.Logger
 *  javax.net.ssl.SSLSocket
 *  javax.net.ssl.SSLSocketFactory
 *  javax.net.ssl.X509TrustManager
 */
package okhttp3.internal;

import android.util.Log;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.charset.Charset;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import okhttp3.internal.Internal;
import okhttp3.internal.OptionalMethod;
import okhttp3.internal.Util;
import okhttp3.internal.tls.AndroidTrustRootIndex;
import okhttp3.internal.tls.RealTrustRootIndex;
import okhttp3.internal.tls.TrustRootIndex;
import okio.Buffer;

public class Platform {
    private static final Platform PLATFORM = Platform.findPlatform();

    /*
     * Enabled aggressive block sorting
     */
    static byte[] concatLengthPrefixed(List<Protocol> list) {
        Buffer buffer = new Buffer();
        int n2 = 0;
        int n3 = list.size();
        while (n2 < n3) {
            Protocol protocol = (Protocol)((Object)list.get(n2));
            if (protocol != Protocol.HTTP_1_0) {
                buffer.writeByte(protocol.toString().length());
                buffer.writeUtf8(protocol.toString());
            }
            ++n2;
        }
        return buffer.readByteArray();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static Platform findPlatform() {
        var10_1 = var21 = Class.forName((String)"com.android.org.conscrypt.SSLParametersImpl");
        {
            catch (ClassNotFoundException var0_9) {
                var10_1 = var9_10 = Class.forName((String)"org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            }
            var11_2 = new Class[]{Boolean.TYPE};
            var12_3 = new OptionalMethod<Socket>(null, "setUseSessionTickets", var11_2);
            var13_4 = new OptionalMethod<Socket>(null, "setHostname", new Class[]{String.class});
        }
lbl10: // 2 sources:
        catch (ClassNotFoundException var1_11) {
            try {
                var4_12 = Class.forName((String)"org.eclipse.jetty.alpn.ALPN");
                var5_13 = Class.forName((String)("org.eclipse.jetty.alpn.ALPN" + "$Provider"));
                var6_14 = Class.forName((String)("org.eclipse.jetty.alpn.ALPN" + "$ClientProvider"));
                var7_15 = Class.forName((String)("org.eclipse.jetty.alpn.ALPN" + "$ServerProvider"));
                return new JdkWithJettyBootPlatform(var4_12.getMethod("put", new Class[]{SSLSocket.class, var5_13}), var4_12.getMethod("get", new Class[]{SSLSocket.class}), var4_12.getMethod("remove", new Class[]{SSLSocket.class}), var6_14, var7_15);
            }
            catch (ClassNotFoundException var3_17) {
                return new Platform();
            }
            catch (NoSuchMethodException var2_18) {
                return new Platform();
            }
        }
        {
            Class.forName((String)"android.net.Network");
            var18_5 = new OptionalMethod<Socket>(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
            var16_7 = var19_6 = new OptionalMethod<T>(null, "setAlpnProtocols", new Class[]{byte[].class});
            var15_8 = var18_5;
            catch (ClassNotFoundException var14_19) {
                var15_8 = null;
                var16_7 = null;
            }
            ** GOTO lbl35
            catch (ClassNotFoundException var20_20) {
                var15_8 = var18_5;
                var16_7 = null;
            }
lbl35: // 3 sources:
            ** try [egrp 4[TRYBLOCK] [4 : 111->137)] { 
lbl36: // 1 sources:
            return new Android(var10_1, var12_3, var13_4, var15_8, var16_7);
        }
    }

    public static Platform get() {
        return PLATFORM;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    static <T> T readFieldOrNull(Object object, Class<T> class_, String string2) {
        Class class_2 = object.getClass();
        do {
            Object var5_7;
            Object object2;
            if (class_2 == Object.class) {
                boolean bl2 = string2.equals((Object)"delegate");
                var5_7 = null;
                if (bl2) return var5_7;
                T t2 = Platform.readFieldOrNull(object, Object.class, "delegate");
                var5_7 = null;
                if (t2 == null) return var5_7;
                var5_7 = Platform.readFieldOrNull(t2, class_, string2);
                return var5_7;
            }
            try {
                Field field = class_2.getDeclaredField(string2);
                field.setAccessible(true);
                Object object3 = field.get(object);
                var5_7 = null;
                if (object3 == null) return var5_7;
                if (!class_.isInstance(object3)) {
                    return null;
                }
                object2 = class_.cast(object3);
            }
            catch (IllegalAccessException var8_9) {
                throw new AssertionError();
            }
            catch (NoSuchFieldException var7_4) {
                class_2 = class_2.getSuperclass();
                continue;
            }
            return (T)object2;
            break;
        } while (true);
    }

    public void afterHandshake(SSLSocket sSLSocket) {
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String string2, List<Protocol> list) {
    }

    public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int n2) throws IOException {
        socket.connect((SocketAddress)inetSocketAddress, n2);
    }

    public String getPrefix() {
        return "OkHttp";
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        return null;
    }

    public void log(String string2) {
        System.out.println(string2);
    }

    public void logW(String string2) {
        System.out.println(string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        try {
            T t2 = Platform.readFieldOrNull((Object)sSLSocketFactory, Class.forName((String)"sun.security.ssl.SSLContextImpl"), "context");
            if (t2 != null) return (X509TrustManager)Platform.readFieldOrNull(t2, X509TrustManager.class, "trustManager");
            return null;
        }
        catch (ClassNotFoundException var2_4) {
            return null;
        }
    }

    public TrustRootIndex trustRootIndex(X509TrustManager x509TrustManager) {
        return new RealTrustRootIndex(x509TrustManager.getAcceptedIssuers());
    }

    static class Android
    extends Platform {
        private static final int MAX_LOG_LENGTH = 4000;
        private final OptionalMethod<Socket> getAlpnSelectedProtocol;
        private final OptionalMethod<Socket> setAlpnProtocols;
        private final OptionalMethod<Socket> setHostname;
        private final OptionalMethod<Socket> setUseSessionTickets;
        private final Class<?> sslParametersClass;

        public Android(Class<?> class_, OptionalMethod<Socket> optionalMethod, OptionalMethod<Socket> optionalMethod2, OptionalMethod<Socket> optionalMethod3, OptionalMethod<Socket> optionalMethod4) {
            this.sslParametersClass = class_;
            this.setUseSessionTickets = optionalMethod;
            this.setHostname = optionalMethod2;
            this.getAlpnSelectedProtocol = optionalMethod3;
            this.setAlpnProtocols = optionalMethod4;
        }

        @Override
        public void configureTlsExtensions(SSLSocket sSLSocket, String string2, List<Protocol> list) {
            if (string2 != null) {
                OptionalMethod<Socket> optionalMethod = this.setUseSessionTickets;
                Object[] arrobject = new Object[]{true};
                optionalMethod.invokeOptionalWithoutCheckedException((Socket)sSLSocket, arrobject);
                this.setHostname.invokeOptionalWithoutCheckedException((Socket)sSLSocket, string2);
            }
            if (this.setAlpnProtocols != null && this.setAlpnProtocols.isSupported((Socket)sSLSocket)) {
                Object[] arrobject = new Object[]{Android.concatLengthPrefixed(list)};
                this.setAlpnProtocols.invokeWithoutCheckedException((Socket)sSLSocket, arrobject);
            }
        }

        @Override
        public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int n2) throws IOException {
            try {
                socket.connect((SocketAddress)inetSocketAddress, n2);
                return;
            }
            catch (AssertionError var7_4) {
                if (Util.isAndroidGetsocknameError(var7_4)) {
                    throw new IOException((Throwable)var7_4);
                }
                throw var7_4;
            }
            catch (SecurityException var4_5) {
                IOException iOException = new IOException("Exception in connect");
                iOException.initCause((Throwable)var4_5);
                throw iOException;
            }
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public String getSelectedProtocol(SSLSocket sSLSocket) {
            if (this.getAlpnSelectedProtocol == null) {
                return null;
            }
            if (!this.getAlpnSelectedProtocol.isSupported((Socket)sSLSocket)) return null;
            byte[] arrby = (byte[])this.getAlpnSelectedProtocol.invokeWithoutCheckedException((Socket)sSLSocket, new Object[0]);
            if (arrby == null) return null;
            return new String(arrby, Util.UTF_8);
        }

        /*
         * Enabled aggressive block sorting
         */
        @Override
        public void log(String string2) {
            int n2 = 0;
            int n3 = string2.length();
            while (n2 < n3) {
                int n4;
                int n5 = string2.indexOf(10, n2);
                if (n5 == -1) {
                    n5 = n3;
                }
                do {
                    n4 = Math.min((int)n5, (int)(n2 + 4000));
                    Log.d((String)"OkHttp", (String)string2.substring(n2, n4));
                } while ((n2 = n4) < n5);
                ++n2;
            }
            return;
        }

        /*
         * Loose catch block
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Lifted jumps to return sites
         */
        @Override
        public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
            X509TrustManager x509TrustManager;
            Object object = Android.readFieldOrNull((Object)sSLSocketFactory, this.sslParametersClass, "sslParameters");
            if (object == null) {
                Object t2;
                object = t2 = Android.readFieldOrNull((Object)sSLSocketFactory, Class.forName((String)"com.google.android.gms.org.conscrypt.SSLParametersImpl", (boolean)false, (ClassLoader)sSLSocketFactory.getClass().getClassLoader()), "sslParameters");
            }
            if ((x509TrustManager = (X509TrustManager)Android.readFieldOrNull(object, X509TrustManager.class, "x509TrustManager")) == null) return (X509TrustManager)Android.readFieldOrNull(object, X509TrustManager.class, "trustManager");
            return x509TrustManager;
            catch (ClassNotFoundException classNotFoundException) {
                return super.trustManager(sSLSocketFactory);
            }
        }

        @Override
        public TrustRootIndex trustRootIndex(X509TrustManager x509TrustManager) {
            TrustRootIndex trustRootIndex = AndroidTrustRootIndex.get(x509TrustManager);
            if (trustRootIndex != null) {
                return trustRootIndex;
            }
            return super.trustRootIndex(x509TrustManager);
        }
    }

    static class JdkWithJettyBootPlatform
    extends Platform {
        private final Class<?> clientProviderClass;
        private final Method getMethod;
        private final Method putMethod;
        private final Method removeMethod;
        private final Class<?> serverProviderClass;

        public JdkWithJettyBootPlatform(Method method, Method method2, Method method3, Class<?> class_, Class<?> class_2) {
            this.putMethod = method;
            this.getMethod = method2;
            this.removeMethod = method3;
            this.clientProviderClass = class_;
            this.serverProviderClass = class_2;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public void afterHandshake(SSLSocket sSLSocket) {
            try {
                this.removeMethod.invoke((Object)null, new Object[]{sSLSocket});
                return;
            }
            catch (IllegalAccessException var3_2) {
                do {
                    throw new AssertionError();
                    break;
                } while (true);
            }
            catch (InvocationTargetException var2_3) {
                throw new AssertionError();
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void configureTlsExtensions(SSLSocket sSLSocket, String string2, List<Protocol> list) {
            void var7_12;
            ArrayList arrayList = new ArrayList(list.size());
            int n2 = list.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                Protocol protocol = (Protocol)((Object)list.get(i2));
                if (protocol == Protocol.HTTP_1_0) continue;
                arrayList.add((Object)protocol.toString());
            }
            try {
                ClassLoader classLoader = Platform.class.getClassLoader();
                Class[] arrclass = new Class[]{this.clientProviderClass, this.serverProviderClass};
                Object object = Proxy.newProxyInstance((ClassLoader)classLoader, (Class[])arrclass, (InvocationHandler)new JettyNegoProvider((List<String>)arrayList));
                this.putMethod.invoke((Object)null, new Object[]{sSLSocket, object});
                return;
            }
            catch (IllegalAccessException var7_11) {
                throw new AssertionError((Object)var7_12);
            }
            catch (InvocationTargetException var7_13) {
                throw new AssertionError((Object)var7_12);
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public String getSelectedProtocol(SSLSocket sSLSocket) {
            try {
                JettyNegoProvider jettyNegoProvider = (JettyNegoProvider)Proxy.getInvocationHandler((Object)this.getMethod.invoke((Object)null, new Object[]{sSLSocket}));
                if (!jettyNegoProvider.unsupported && jettyNegoProvider.selected == null) {
                    Internal.logger.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
                    return null;
                }
                if (jettyNegoProvider.unsupported) return null;
                return jettyNegoProvider.selected;
            }
            catch (IllegalAccessException var3_4) {
                throw new AssertionError();
            }
            catch (InvocationTargetException var2_5) {
                throw new AssertionError();
            }
        }
    }

    static class JettyNegoProvider
    implements InvocationHandler {
        private final List<String> protocols;
        private String selected;
        private boolean unsupported;

        public JettyNegoProvider(List<String> list) {
            this.protocols = list;
        }

        public Object invoke(Object object, Method method, Object[] arrobject) throws Throwable {
            String string2 = method.getName();
            Class class_ = method.getReturnType();
            if (arrobject == null) {
                arrobject = Util.EMPTY_STRING_ARRAY;
            }
            if (string2.equals((Object)"supports") && Boolean.TYPE == class_) {
                return true;
            }
            if (string2.equals((Object)"unsupported") && Void.TYPE == class_) {
                this.unsupported = true;
                return null;
            }
            if (string2.equals((Object)"protocols") && arrobject.length == 0) {
                return this.protocols;
            }
            if ((string2.equals((Object)"selectProtocol") || string2.equals((Object)"select")) && String.class == class_ && arrobject.length == 1 && arrobject[0] instanceof List) {
                String string3;
                List list = (List)arrobject[0];
                int n2 = list.size();
                for (int i2 = 0; i2 < n2; ++i2) {
                    String string4;
                    if (!this.protocols.contains(list.get(i2))) continue;
                    this.selected = string4 = (String)list.get(i2);
                    return string4;
                }
                this.selected = string3 = (String)this.protocols.get(0);
                return string3;
            }
            if ((string2.equals((Object)"protocolSelected") || string2.equals((Object)"selected")) && arrobject.length == 1) {
                this.selected = (String)arrobject[0];
                return null;
            }
            return method.invoke((Object)this, arrobject);
        }
    }

}

