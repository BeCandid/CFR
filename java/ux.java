/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Set
 */
import android.content.Context;
import com.facebook.appevents.AccessTokenAppIdPair;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.PersistedEvents;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class ux {
    private final HashMap<AccessTokenAppIdPair, vb> a = new HashMap();

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private vb b(AccessTokenAppIdPair accessTokenAppIdPair) {
        void var6_2 = this;
        synchronized (var6_2) {
            vb vb2 = (vb)this.a.get((Object)accessTokenAppIdPair);
            if (vb2 == null) {
                Context context = AppEventsLogger.d();
                vb2 = new vb(vg.a(context), AppEventsLogger.b(context));
            }
            this.a.put((Object)accessTokenAppIdPair, (Object)vb2);
            return vb2;
        }
    }

    public Set<AccessTokenAppIdPair> a() {
        ux ux2 = this;
        synchronized (ux2) {
            Set set = this.a.keySet();
            return set;
        }
    }

    public vb a(AccessTokenAppIdPair accessTokenAppIdPair) {
        void var4_2 = this;
        synchronized (var4_2) {
            vb vb2 = (vb)this.a.get((Object)accessTokenAppIdPair);
            return vb2;
        }
    }

    public void a(AccessTokenAppIdPair accessTokenAppIdPair, AppEvent appEvent) {
        void var4_3 = this;
        synchronized (var4_3) {
            super.b(accessTokenAppIdPair).a(appEvent);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(PersistedEvents persistedEvents) {
        void var7_2 = this;
        synchronized (var7_2) {
            if (persistedEvents != null) {
                for (AccessTokenAppIdPair accessTokenAppIdPair : persistedEvents.keySet()) {
                    vb vb2 = super.b(accessTokenAppIdPair);
                    Iterator iterator = ((List)persistedEvents.get((Object)accessTokenAppIdPair)).iterator();
                    while (iterator.hasNext()) {
                        vb2.a((AppEvent)iterator.next());
                    }
                }
            }
            return;
        }
    }

    public int b() {
        ux ux2 = this;
        synchronized (ux2) {
            int n2;
            int n3 = 0;
            Iterator iterator = this.a.values().iterator();
            while (iterator.hasNext()) {
                n2 = ((vb)iterator.next()).a();
            }
            {
                n3 += n2;
                continue;
            }
            return n3;
        }
    }
}

