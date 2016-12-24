/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  java.lang.Object
 *  java.lang.String
 *  java.util.concurrent.atomic.AtomicBoolean
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.concurrent.atomic.AtomicBoolean;

class ti {
    private static final IntentFilter a = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private static final IntentFilter b = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");
    private static final IntentFilter c = new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED");
    private final AtomicBoolean d;
    private final Context e;
    private final BroadcastReceiver f;
    private final BroadcastReceiver g;
    private boolean h;

    /*
     * Enabled aggressive block sorting
     */
    public ti(Context context) {
        int n2 = -1;
        this.e = context;
        Intent intent = context.registerReceiver(null, a);
        if (intent != null) {
            n2 = intent.getIntExtra("status", n2);
        }
        boolean bl2 = n2 == 2 || n2 == 5;
        this.h = bl2;
        this.g = new BroadcastReceiver(){

            public void onReceive(Context context, Intent intent) {
                ti.this.h = true;
            }
        };
        this.f = new BroadcastReceiver(){

            public void onReceive(Context context, Intent intent) {
                ti.this.h = false;
            }
        };
        context.registerReceiver(this.g, b);
        context.registerReceiver(this.f, c);
        this.d = new AtomicBoolean(true);
    }

    public boolean a() {
        return this.h;
    }

    public void b() {
        if (!this.d.getAndSet(false)) {
            return;
        }
        this.e.unregisterReceiver(this.g);
        this.e.unregisterReceiver(this.f);
    }

}

