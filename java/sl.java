/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  io.fabric.sdk.android.services.common.IdManager
 *  io.fabric.sdk.android.services.common.IdManager$DeviceIdentifierType
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 *  java.util.concurrent.atomic.AtomicBoolean
 */
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import io.fabric.sdk.android.services.common.IdManager;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

abstract class sl
implements su {
    private final AtomicBoolean a = new AtomicBoolean();
    private final AtomicBoolean b;
    private Context c;
    private sn d;
    private IdManager e;
    private anp f;
    private so g;
    private ani h;
    private alu i;
    private anb j;
    private long k = 0;

    public sl() {
        this(false);
    }

    public sl(boolean bl2) {
        this.b = new AtomicBoolean(bl2);
    }

    private void e() {
        akx.h().a("Beta", "Performing update check");
        String string2 = new alr().a(this.c);
        String string3 = (String)this.e.i().get((Object)IdManager.DeviceIdentifierType.c);
        new sp(this.d, this.d.g(), this.f.a, this.j, new sr()).a(string2, string3, this.g);
    }

    void a(long l2) {
        this.k = l2;
    }

    @Override
    public void a(Context context, sn sn2, IdManager idManager, anp anp2, so so2, ani ani2, alu alu2, anb anb2) {
        this.c = context;
        this.d = sn2;
        this.e = idManager;
        this.f = anp2;
        this.g = so2;
        this.h = ani2;
        this.i = alu2;
        this.j = anb2;
        if (this.b()) {
            this.c();
        }
    }

    protected boolean a() {
        this.b.set(true);
        return this.a.get();
    }

    boolean b() {
        this.a.set(true);
        return this.b.get();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @SuppressLint(value={"CommitPrefEdits"})
    protected void c() {
        ani ani2;
        ani ani3 = ani2 = this.h;
        synchronized (ani3) {
            if (this.h.a().contains("last_update_check")) {
                this.h.a(this.h.b().remove("last_update_check"));
            }
        }
        long l2 = this.i.a();
        long l3 = 1000 * (long)this.f.b;
        akx.h().a("Beta", "Check for updates delay: " + l3);
        akx.h().a("Beta", "Check for updates last check time: " + this.d());
        long l4 = l3 + this.d();
        akx.h().a("Beta", "Check for updates current time: " + l2 + ", next check time: " + l4);
        if (l2 < l4) {
            akx.h().a("Beta", "Check for updates next check time was not passed");
            return;
        }
        try {
            this.e();
            return;
        }
        finally {
            this.a(l2);
        }
    }

    long d() {
        return this.k;
    }
}

