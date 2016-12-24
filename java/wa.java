/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.Message
 *  android.os.Messenger
 *  android.os.RemoteException
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

public abstract class wa
implements ServiceConnection {
    private final Context a;
    private final Handler b;
    private a c;
    private boolean d;
    private Messenger e;
    private int f;
    private int g;
    private final String h;
    private final int i;

    /*
     * Enabled aggressive block sorting
     */
    public wa(Context context, int n2, int n3, int n4, String string2) {
        Context context2 = context.getApplicationContext();
        if (context2 == null) {
            context2 = context;
        }
        this.a = context2;
        this.f = n2;
        this.g = n3;
        this.h = string2;
        this.i = n4;
        this.b = new Handler(){

            public void handleMessage(Message message) {
                wa.this.a(message);
            }
        };
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void b(Bundle bundle) {
        if (!this.d) {
            return;
        }
        this.d = false;
        a a2 = this.c;
        if (a2 == null) return;
        a2.a(bundle);
    }

    private void c() {
        Bundle bundle = new Bundle();
        bundle.putString("com.facebook.platform.extra.APPLICATION_ID", this.h);
        this.a(bundle);
        Message message = Message.obtain((Handler)null, (int)this.f);
        message.arg1 = this.i;
        message.setData(bundle);
        message.replyTo = new Messenger(this.b);
        try {
            this.e.send(message);
            return;
        }
        catch (RemoteException var3_3) {
            this.b(null);
            return;
        }
    }

    protected abstract void a(Bundle var1);

    /*
     * Enabled aggressive block sorting
     */
    protected void a(Message message) {
        if (message.what == this.g) {
            Bundle bundle = message.getData();
            if (bundle.getString("com.facebook.platform.status.ERROR_TYPE") != null) {
                super.b(null);
            } else {
                super.b(bundle);
            }
            this.a.unbindService((ServiceConnection)this);
        }
    }

    public void a(a a2) {
        this.c = a2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean a() {
        Intent intent;
        if (this.d || vz.b(this.i) == -1 || (intent = vz.a(this.a)) == null) {
            return false;
        }
        this.d = true;
        this.a.bindService(intent, (ServiceConnection)this, 1);
        return true;
    }

    public void b() {
        this.d = false;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.e = new Messenger(iBinder);
        super.c();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public void onServiceDisconnected(ComponentName var1) {
        this.e = null;
        try {
            this.a.unbindService((ServiceConnection)this);
        }
        catch (IllegalArgumentException var2_2) {
            ** continue;
        }
lbl6: // 2 sources:
        do {
            super.b(null);
            return;
            break;
        } while (true);
    }

    public static interface a {
        public void a(Bundle var1);
    }

}

