/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  java.lang.Object
 *  java.util.UUID
 */
import android.content.Intent;
import java.util.UUID;

public class vf {
    private static vf a;
    private UUID b;
    private Intent c;
    private int d;

    public vf(int n2) {
        super(n2, UUID.randomUUID());
    }

    public vf(int n2, UUID uUID) {
        this.b = uUID;
        this.d = n2;
    }

    public static vf a() {
        return a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static vf a(UUID uUID, int n2) {
        reference var6_2 = vf.class;
        synchronized (vf.class) {
            vf vf2 = vf.a();
            if (vf2 == null) return null;
            if (!vf2.c().equals((Object)uUID)) return null;
            int n3 = vf2.d();
            if (n3 != n2) {
                return null;
            }
            vf.a(null);
            // ** MonitorExit[var6_2] (shouldn't be in output)
            return vf2;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean a(vf vf2) {
        reference var4_1 = vf.class;
        synchronized (vf.class) {
            vf vf3 = vf.a();
            a = vf2;
            if (vf3 == null) return false;
            return true;
        }
    }

    public void a(Intent intent) {
        this.c = intent;
    }

    public Intent b() {
        return this.c;
    }

    public UUID c() {
        return this.b;
    }

    public int d() {
        return this.d;
    }

    public boolean e() {
        return vf.a(this);
    }
}

