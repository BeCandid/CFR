/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.IBinder
 *  android.os.Looper
 *  android.os.Message
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.Set
 */
import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class yr
extends yq
implements Handler.Callback {
    private final HashMap<a, b> a = new HashMap();
    private final Context b;
    private final Handler c;
    private final ze d;
    private final long e;

    yr(Context context) {
        this.b = context.getApplicationContext();
        this.c = new Handler(context.getMainLooper(), (Handler.Callback)this);
        this.d = ze.a();
        this.e = 5000;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean a(a a2, ServiceConnection serviceConnection, String string2) {
        HashMap<a, b> hashMap;
        xz.a(serviceConnection, (Object)"ServiceConnection must not be null");
        HashMap<a, b> hashMap2 = hashMap = this.a;
        synchronized (hashMap2) {
            b b2 = (b)this.a.get((Object)a2);
            if (b2 == null) {
                b2 = (yr)this.new b(a2);
                b2.a(serviceConnection, string2);
                b2.a(string2);
                this.a.put((Object)a2, (Object)b2);
                return b2.a();
            } else {
                this.c.removeMessages(0, (Object)b2);
                if (b2.a(serviceConnection)) {
                    String string3 = String.valueOf((Object)a2);
                    throw new IllegalStateException(new StringBuilder(81 + String.valueOf((Object)string3).length()).append("Trying to bind a GmsServiceConnection that was already connected before.  config=").append(string3).toString());
                }
                b2.a(serviceConnection, string2);
                switch (b2.b()) {
                    case 1: {
                        serviceConnection.onServiceConnected(b2.e(), b2.d());
                        return b2.a();
                    }
                    case 2: {
                        b2.a(string2);
                        return b2.a();
                    }
                }
            }
            return b2.a();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void b(a a2, ServiceConnection serviceConnection, String string2) {
        HashMap<a, b> hashMap;
        xz.a(serviceConnection, (Object)"ServiceConnection must not be null");
        HashMap<a, b> hashMap2 = hashMap = this.a;
        synchronized (hashMap2) {
            b b2 = (b)this.a.get((Object)a2);
            if (b2 == null) {
                String string3 = String.valueOf((Object)a2);
                throw new IllegalStateException(new StringBuilder(50 + String.valueOf((Object)string3).length()).append("Nonexistent connection status for service config: ").append(string3).toString());
            }
            if (!b2.a(serviceConnection)) {
                String string4 = String.valueOf((Object)a2);
                throw new IllegalStateException(new StringBuilder(76 + String.valueOf((Object)string4).length()).append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=").append(string4).toString());
            }
            b2.b(serviceConnection, string2);
            if (b2.c()) {
                Message message = this.c.obtainMessage(0, (Object)b2);
                this.c.sendMessageDelayed(message, this.e);
            }
            return;
        }
    }

    @Override
    public boolean a(String string2, String string3, ServiceConnection serviceConnection, String string4) {
        return super.a(new a(string2, string3), serviceConnection, string4);
    }

    @Override
    public void b(String string2, String string3, ServiceConnection serviceConnection, String string4) {
        super.b(new a(string2, string3), serviceConnection, string4);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean handleMessage(Message message) {
        HashMap<a, b> hashMap;
        switch (message.what) {
            default: {
                return false;
            }
            case 0: 
        }
        b b2 = (b)message.obj;
        HashMap<a, b> hashMap2 = hashMap = this.a;
        synchronized (hashMap2) {
            if (b2.c()) {
                if (b2.a()) {
                    b2.b("GmsClientSupervisor");
                }
                this.a.remove((Object)b2.g);
            }
            return true;
        }
    }

    static final class a {
        private final String a;
        private final String b;
        private final ComponentName c;

        public a(String string2, String string3) {
            this.a = xz.a(string2);
            this.b = xz.a(string3);
            this.c = null;
        }

        public Intent a() {
            if (this.a != null) {
                return new Intent(this.a).setPackage(this.b);
            }
            return new Intent().setComponent(this.c);
        }

        /*
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (!(object instanceof a)) {
                return false;
            }
            a a2 = (a)object;
            if (!zc.a((Object)this.a, (Object)a2.a)) return false;
            if (zc.a((Object)this.c, (Object)a2.c)) return true;
            return false;
        }

        public int hashCode() {
            Object[] arrobject = new Object[]{this.a, this.c};
            return zc.a(arrobject);
        }

        public String toString() {
            if (this.a == null) {
                return this.c.flattenToString();
            }
            return this.a;
        }
    }

    final class b {
        private final a b;
        private final Set<ServiceConnection> c;
        private int d;
        private boolean e;
        private IBinder f;
        private final yr$a g;
        private ComponentName h;

        public b(yr$a a2) {
            this.g = a2;
            this.b = (b)this.new a();
            this.c = new HashSet();
            this.d = 2;
        }

        public void a(ServiceConnection serviceConnection, String string2) {
            yr.this.d.a(yr.this.b, serviceConnection, string2, this.g.a());
            this.c.add((Object)serviceConnection);
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @TargetApi(value=14)
        public void a(String string2) {
            this.d = 3;
            this.e = yr.this.d.a(yr.this.b, string2, this.g.a(), this.b, 129);
            if (this.e) return;
            this.d = 2;
            try {
                yr.this.d.a(yr.this.b, this.b);
                return;
            }
            catch (IllegalArgumentException var2_2) {
                return;
            }
        }

        public boolean a() {
            return this.e;
        }

        public boolean a(ServiceConnection serviceConnection) {
            return this.c.contains((Object)serviceConnection);
        }

        public int b() {
            return this.d;
        }

        public void b(ServiceConnection serviceConnection, String string2) {
            yr.this.d.b(yr.this.b, serviceConnection);
            this.c.remove((Object)serviceConnection);
        }

        public void b(String string2) {
            yr.this.d.a(yr.this.b, this.b);
            this.e = false;
            this.d = 2;
        }

        public boolean c() {
            return this.c.isEmpty();
        }

        public IBinder d() {
            return this.f;
        }

        public ComponentName e() {
            return this.h;
        }

        public class a
        implements ServiceConnection {
            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                HashMap hashMap;
                HashMap hashMap2 = hashMap = yr.this.a;
                synchronized (hashMap2) {
                    b.this.f = iBinder;
                    b.this.h = componentName;
                    Iterator iterator = b.this.c.iterator();
                    do {
                        if (!iterator.hasNext()) {
                            b.this.d = 1;
                            return;
                        }
                        ((ServiceConnection)iterator.next()).onServiceConnected(componentName, iBinder);
                    } while (true);
                }
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public void onServiceDisconnected(ComponentName componentName) {
                HashMap hashMap;
                HashMap hashMap2 = hashMap = yr.this.a;
                synchronized (hashMap2) {
                    b.this.f = null;
                    b.this.h = componentName;
                    Iterator iterator = b.this.c.iterator();
                    do {
                        if (!iterator.hasNext()) {
                            b.this.d = 2;
                            return;
                        }
                        ((ServiceConnection)iterator.next()).onServiceDisconnected(componentName);
                    } while (true);
                }
            }
        }

    }

}

