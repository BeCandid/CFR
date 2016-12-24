/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

class pm
implements pk {
    private final Context a;
    private final pk.a b;
    private boolean c;
    private boolean d;
    private final BroadcastReceiver e;

    public pm(Context context, pk.a a2) {
        this.e = new BroadcastReceiver(){

            public void onReceive(Context context, Intent intent) {
                boolean bl2 = pm.this.c;
                pm.this.c = pm.this.a(context);
                if (bl2 != pm.this.c) {
                    pm.this.b.a(pm.this.c);
                }
            }
        };
        this.a = context.getApplicationContext();
        this.b = a2;
    }

    private void a() {
        if (this.d) {
            return;
        }
        this.c = this.a(this.a);
        this.a.registerReceiver(this.e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.d = true;
    }

    private boolean a(Context context) {
        NetworkInfo networkInfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    private void b() {
        if (!this.d) {
            return;
        }
        this.a.unregisterReceiver(this.e);
        this.d = false;
    }

    @Override
    public void onDestroy() {
    }

    @Override
    public void onStart() {
        this.a();
    }

    @Override
    public void onStop() {
        this.b();
    }

}

