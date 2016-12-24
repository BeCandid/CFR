/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.LinkedHashSet
 *  java.util.Set
 */
package okhttp3.internal;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.Route;

public final class RouteDatabase {
    private final Set<Route> failedRoutes = new LinkedHashSet();

    public void connected(Route route) {
        void var4_2 = this;
        synchronized (var4_2) {
            this.failedRoutes.remove((Object)route);
            return;
        }
    }

    public void failed(Route route) {
        void var4_2 = this;
        synchronized (var4_2) {
            this.failedRoutes.add((Object)route);
            return;
        }
    }

    public int failedRoutesCount() {
        RouteDatabase routeDatabase = this;
        synchronized (routeDatabase) {
            int n2 = this.failedRoutes.size();
            return n2;
        }
    }

    public boolean shouldPostpone(Route route) {
        void var4_2 = this;
        synchronized (var4_2) {
            boolean bl2 = this.failedRoutes.contains((Object)route);
            return bl2;
        }
    }
}

