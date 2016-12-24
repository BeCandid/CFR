/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  com.google.android.gms.measurement.internal.zzw
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.measurement.internal.zzw;

class ahf
extends BroadcastReceiver {
    static final String a = ahf.class.getName();
    private final ahk b;
    private boolean c;
    private boolean d;

    ahf(ahk ahk2) {
        xz.a(ahk2);
        this.b = ahk2;
    }

    private Context d() {
        return this.b.q();
    }

    private ahd e() {
        return this.b.f();
    }

    public void a() {
        this.b.a();
        this.b.y();
        if (this.c) {
            return;
        }
        this.d().registerReceiver((BroadcastReceiver)this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.d = this.b.p().f();
        this.e().E().a("Registering connectivity change receiver. Network connected", this.d);
        this.c = true;
    }

    public void b() {
        this.b.a();
        this.b.y();
        if (!this.c()) {
            return;
        }
        this.e().E().a("Unregistering connectivity change receiver");
        this.c = false;
        this.d = false;
        Context context = this.d();
        try {
            context.unregisterReceiver((BroadcastReceiver)this);
            return;
        }
        catch (IllegalArgumentException var2_2) {
            this.e().f().a("Failed to unregister the network broadcast receiver", (Object)var2_2);
            return;
        }
    }

    public boolean c() {
        this.b.y();
        return this.c;
    }

    public void onReceive(Context context, Intent intent) {
        this.b.a();
        String string2 = intent.getAction();
        super.e().E().a("NetworkBroadcastReceiver received action", string2);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals((Object)string2)) {
            final boolean bl2 = this.b.p().f();
            if (this.d != bl2) {
                this.d = bl2;
                this.b.h().a(new Runnable(){

                    public void run() {
                        ahf.this.b.a(bl2);
                    }
                });
            }
            return;
        }
        super.e().z().a("NetworkBroadcastReceiver received unknown action", string2);
    }

}

