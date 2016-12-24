/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.net.InetSocketAddress
 *  java.net.Proxy
 *  java.net.Proxy$Type
 *  javax.net.ssl.SSLSocketFactory
 */
package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Address;

public final class Route {
    final Address address;
    final InetSocketAddress inetSocketAddress;
    final Proxy proxy;

    public Route(Address address, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (address == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.address = address;
        this.proxy = proxy;
        this.inetSocketAddress = inetSocketAddress;
    }

    public Address address() {
        return this.address;
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof Route;
        boolean bl3 = false;
        if (bl2) {
            Route route = (Route)object;
            boolean bl4 = this.address.equals(route.address);
            bl3 = false;
            if (bl4) {
                boolean bl5 = this.proxy.equals((Object)route.proxy);
                bl3 = false;
                if (bl5) {
                    boolean bl6 = this.inetSocketAddress.equals((Object)route.inetSocketAddress);
                    bl3 = false;
                    if (bl6) {
                        bl3 = true;
                    }
                }
            }
        }
        return bl3;
    }

    public int hashCode() {
        return 31 * (31 * (527 + this.address.hashCode()) + this.proxy.hashCode()) + this.inetSocketAddress.hashCode();
    }

    public Proxy proxy() {
        return this.proxy;
    }

    public boolean requiresTunnel() {
        if (this.address.sslSocketFactory != null && this.proxy.type() == Proxy.Type.HTTP) {
            return true;
        }
        return false;
    }

    public InetSocketAddress socketAddress() {
        return this.inetSocketAddress;
    }
}

