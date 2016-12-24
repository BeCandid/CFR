/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.net.InetAddress
 *  java.net.InetSocketAddress
 *  java.net.Proxy
 *  java.net.Proxy$Type
 *  java.net.ProxySelector
 *  java.net.SocketAddress
 *  java.net.SocketException
 *  java.net.URI
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.List
 *  java.util.NoSuchElementException
 */
package okhttp3.internal.http;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.Address;
import okhttp3.Dns;
import okhttp3.HttpUrl;
import okhttp3.Route;
import okhttp3.internal.RouteDatabase;

public final class RouteSelector {
    private final Address address;
    private List<InetSocketAddress> inetSocketAddresses = Collections.emptyList();
    private InetSocketAddress lastInetSocketAddress;
    private Proxy lastProxy;
    private int nextInetSocketAddressIndex;
    private int nextProxyIndex;
    private final List<Route> postponedRoutes = new ArrayList();
    private List<Proxy> proxies = Collections.emptyList();
    private final RouteDatabase routeDatabase;

    public RouteSelector(Address address, RouteDatabase routeDatabase) {
        this.address = address;
        this.routeDatabase = routeDatabase;
        super.resetNextProxy(address.url(), address.proxy());
    }

    static String getHostString(InetSocketAddress inetSocketAddress) {
        InetAddress inetAddress = inetSocketAddress.getAddress();
        if (inetAddress == null) {
            return inetSocketAddress.getHostName();
        }
        return inetAddress.getHostAddress();
    }

    private boolean hasNextInetSocketAddress() {
        if (this.nextInetSocketAddressIndex < this.inetSocketAddresses.size()) {
            return true;
        }
        return false;
    }

    private boolean hasNextPostponed() {
        if (!this.postponedRoutes.isEmpty()) {
            return true;
        }
        return false;
    }

    private boolean hasNextProxy() {
        if (this.nextProxyIndex < this.proxies.size()) {
            return true;
        }
        return false;
    }

    private InetSocketAddress nextInetSocketAddress() throws IOException {
        if (!this.hasNextInetSocketAddress()) {
            throw new SocketException("No route to " + this.address.url().host() + "; exhausted inet socket addresses: " + this.inetSocketAddresses);
        }
        List<InetSocketAddress> list = this.inetSocketAddresses;
        int n2 = this.nextInetSocketAddressIndex;
        this.nextInetSocketAddressIndex = n2 + 1;
        return (InetSocketAddress)list.get(n2);
    }

    private Route nextPostponed() {
        return (Route)this.postponedRoutes.remove(0);
    }

    private Proxy nextProxy() throws IOException {
        if (!this.hasNextProxy()) {
            throw new SocketException("No route to " + this.address.url().host() + "; exhausted proxy configurations: " + this.proxies);
        }
        List<Proxy> list = this.proxies;
        int n2 = this.nextProxyIndex;
        this.nextProxyIndex = n2 + 1;
        Proxy proxy = (Proxy)list.get(n2);
        this.resetNextInetSocketAddress(proxy);
        return proxy;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void resetNextInetSocketAddress(Proxy proxy) throws IOException {
        String string2;
        int n2;
        this.inetSocketAddresses = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            string2 = this.address.url().host();
            n2 = this.address.url().port();
        } else {
            SocketAddress socketAddress = proxy.address();
            if (!(socketAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + (Object)socketAddress.getClass());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress)socketAddress;
            string2 = RouteSelector.getHostString(inetSocketAddress);
            n2 = inetSocketAddress.getPort();
        }
        if (n2 < 1 || n2 > 65535) {
            throw new SocketException("No route to " + string2 + ":" + n2 + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            this.inetSocketAddresses.add((Object)InetSocketAddress.createUnresolved((String)string2, (int)n2));
        } else {
            List<InetAddress> list = this.address.dns().lookup(string2);
            int n3 = list.size();
            for (int i2 = 0; i2 < n3; ++i2) {
                InetAddress inetAddress = (InetAddress)list.get(i2);
                this.inetSocketAddresses.add((Object)new InetSocketAddress(inetAddress, n2));
            }
        }
        this.nextInetSocketAddressIndex = 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void resetNextProxy(HttpUrl httpUrl, Proxy proxy) {
        if (proxy != null) {
            this.proxies = Collections.singletonList((Object)proxy);
        } else {
            this.proxies = new ArrayList();
            List list = this.address.proxySelector().select(httpUrl.uri());
            if (list != null) {
                this.proxies.addAll((Collection)list);
            }
            this.proxies.removeAll((Collection)Collections.singleton((Object)Proxy.NO_PROXY));
            this.proxies.add((Object)Proxy.NO_PROXY);
        }
        this.nextProxyIndex = 0;
    }

    public void connectFailed(Route route, IOException iOException) {
        if (route.proxy().type() != Proxy.Type.DIRECT && this.address.proxySelector() != null) {
            this.address.proxySelector().connectFailed(this.address.url().uri(), route.proxy().address(), iOException);
        }
        this.routeDatabase.failed(route);
    }

    public boolean hasNext() {
        if (this.hasNextInetSocketAddress() || this.hasNextProxy() || this.hasNextPostponed()) {
            return true;
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public Route next() throws IOException {
        if (!this.hasNextInetSocketAddress()) {
            if (!this.hasNextProxy()) {
                if (this.hasNextPostponed()) return this.nextPostponed();
                throw new NoSuchElementException();
            }
            this.lastProxy = this.nextProxy();
        }
        this.lastInetSocketAddress = this.nextInetSocketAddress();
        Route route = new Route(this.address, this.lastProxy, this.lastInetSocketAddress);
        if (!this.routeDatabase.shouldPostpone(route)) return route;
        this.postponedRoutes.add((Object)route);
        return this.next();
    }
}

